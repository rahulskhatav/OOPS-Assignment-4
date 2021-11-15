```
#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <algorithm>
#include <vector>
#include <unordered_map>
#include <unordered_set>
using namespace std;

class diffset {
  public: 
    vector<bool> sets;
    void read(string str) {
      sets.resize(7, true);
      for(const char& c: str) {
        sets[c-'0'] = false;
      }
    }
};

string items = "ACDTW";
int min_sup = 3;
unordered_map<string, diffset> all_sets;
unordered_map<string, int> freq_count;
unordered_set<string> frequent;

void read_tidsets() {
  string temp, word, id, items = "";
  
  fstream fin;
  fin.open("transactions.csv", ios::in);
  // transactions file not found.
  if(!fin.is_open()) {
    cout << "Transactions file not found.\n";
    return;
  }

  while(fin >> temp) {
    stringstream s(temp);
    int j = 0;
    while (getline(s, word, ',')) {
      if(j==0) id = word;
      else
        items += word;
      j++;
    }
    diffset t; t.read(items);
    freq_count.insert({id, items.length()});
    // cout << id << " " << freq_count[id] << endl;
    if(freq_count[id]>=min_sup) {
      frequent.insert(id);
    }
    all_sets.insert({id, t});
    j = 0;
    items = "";
  }
}

pair<diffset, int> subtract(diffset a, diffset b) {
  diffset res; res.read("");
  int count = 0;
  for(int i=1; i<=7; i++) {
    if(b.sets[i] && !a.sets[i])
      count++;
    else 
      res.sets[i] = false;
  }
  return {res, count};
}

void findFrequent(string str1, string str2) {
  if(str2=="") return;
  string temp1 = "", temp2 = "";
  for(int i=0; i<str2.length(); i++) {
    char c = str2[i];
    temp1 = str1 + c;
    temp2 += c;

    // cout << str1 << " " << temp2 << endl;

    pair<diffset, int> res = subtract(all_sets[str1], all_sets[temp2]);

    all_sets.insert({temp1, res.first});

    // cout << temp1 << " " << res.second << endl;

    freq_count.insert({temp1, freq_count[str1]-res.second});

    // cout << temp1 << " " << freq_count[temp1] << endl;

    if(freq_count[temp1]>=min_sup) {
      frequent.insert(temp1);
      findFrequent(temp1, str2.substr(i+1));
    }

    temp1 = temp2 = "";
  }
}

int main() {
  read_tidsets();

  for(int i=0; i<5; i++) {
      string str1 = "", str2 = items.substr(i+1);
      str1+=items[i];
      findFrequent(str1, str2);
  }

  cout << "Frequent Itemsets: ";

  for(const string& str: frequent) { 
    cout << str << " " ;
  }
  
  cout << endl;
  return 0;
} 
```
