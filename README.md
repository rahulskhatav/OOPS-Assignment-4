```
#include <iostream>
#include <algorithm>
#include <queue>
#include <list>
#include <vector>
#include <unordered_map>
#include <unordered_set>
using namespace std;

typedef 
struct page{
  int id;
  page(int _id) { id = _id; }
} page;
typedef unordered_set<int> usint;

vector<page> create_page_demand_stream() {
  vector<page> stream;
  // Page streams from Operating System Concepts
  vector<int> ids = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
  for(int i=0; i<ids.size(); i++) {
    page t(ids[i]);
    stream.push_back(t);
  }
  return stream;
}

void fifo(vector<page>& stream) {
  cout << "\nFIFO Replacement Algorithm\n\n";
  int max_pages = 3, faults = 0;
  usint available;
  queue<page> q;

  for(const page& demand: stream) {
    cout << "Demand page " << demand.id << " : ";
    if(available.find(demand.id) != available.end()) {
      cout << "Page exists in memory\n";
    }
    else {
      cout << "PAGE FAULT\n";
      faults++;
      if(q.size()==max_pages) {
        page t = q.front(); 
        q.pop();
        available.erase(t.id);
      }
      q.push(demand);
      available.insert(demand.id);
    }
  }
  cout << "Total page Faults: " << faults << "\n";
}

void lru(vector<page>& stream) {
  cout << "\nLRU Replacement Algorithm\n\n";
  int max_pages = 3, faults = 0;
  list<page> l;
  unordered_map<int, list<page>::iterator> available;

  for(const page& demand: stream) {
    cout << "Demand page " << demand.id << " : ";
    if(available.find(demand.id) != available.end()) {
      cout << "Page exists in memory\n";
      l.erase(available[demand.id]);
      l.push_front(demand);
      available[demand.id] = l.begin();
    }
    else {
      cout << "PAGE FAULT\n";
      faults++;
      if(l.size()==max_pages) {
        page t = l.back();
        l.pop_back();
        available.erase(t.id);
      }
      l.push_front(demand);
      available.insert({demand.id, l.begin()});
    }
  }
  cout << "Total page Faults: " << faults << "\n";
}

int main() {
  vector<page> stream = create_page_demand_stream();
  fifo(stream);
  lru(stream);
  return 0;
} 
```
