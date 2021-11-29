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

class lens{
  public:
  string id;
  vector<int> data;
  lens(vector<string>& arr) {
    int n = arr.size();
    id = arr[0];
    for(int i=1; i<n; i++) data.push_back(stoi(arr[i]));
  }
};

vector<int> types = {3,2,2,2,3};
float min_sup;
unordered_set<string> frequent();

vector<lens> read_data() {
  string temp, word;
  vector<string> arr;
  vector<lens> data;
  fstream fin;

  fin.open("lensesdata.csv", ios::in);
  if(!fin.is_open()) {
    cout << "File not found.\n";
    return data;
  }
  while(fin >> temp) {
    stringstream s(temp);
    while(getline(s, word, ',')) {
      arr.push_back(word);
    }
    data.push_back(lens(arr));
    arr.clear();
  }
  return data;
}

int find_frequency(vector<int> arr, vector<lens>& data){
  int count = 0;
  for(const lens& t: data) {
    bool present = true;
    for(int i=0; i<arr.size(); i++) {
      if(arr[i]!=t.data[i]) present = false;
    }
    if(present) count++;
  }
  return count;
}

void apriori(vector<int> prev, vector<lens>& data) {
  if(prev.size()==5) return;
  for(int i=1; i<=types[prev.size()]; i++) {
    prev.push_back(i);
    int c = find_frequency(prev, data);
    float f = (float) c/(float) data.size();
    if(f>=min_sup) {
      for(const int& j: prev) cout << j << "\t";
      cout << endl;
      apriori(prev, data);
    }
    prev.pop_back();
  }
}



int main() {
  vector<lens> data = read_data();
  

  min_sup = 0.10;
  cout << "\nMin. Support: " << min_sup << endl;
  apriori({}, data);

  min_sup = 0.15;
  cout << "\nMin. Support: " << min_sup << endl;
  apriori({}, data);

  min_sup = 0.20;
  cout << "\nMin. Support: " << min_sup << endl;
  apriori({}, data);


  return 0;
}
```
