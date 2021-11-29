```
#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <algorithm>
#include <vector>
#include <unordered_map>
using namespace std;

class iris{
  public:
  // data
  vector<float> attr;
  string iris_class;

  // initialisation
  iris(vector<string>& _input) {
    for(int i=0; i<4; i++) {
      attr.push_back(stof(_input[i]));
    }
    iris_class = _input[4];
  }
};

class Node{
  public:
  float break_value;
  string type;
  vector<iris> members;
  Node *less, *more;
  Node(vector<iris> _members) {
    type = "";
    break_value = 0;
    members = _members;
    less = more = NULL;
  }
};

vector<iris> read_data() {
  vector<iris> data;
  string temp, word;
  vector<string> t;
  fstream fin;

  // Open the data file
  fin.open("irisdata.csv", ios::in);
  if(!fin.is_open()) {
    cout << "Data is not available" << endl;
    return {};
  }

  while(fin >> temp) {
    stringstream s(temp);
    while(getline(s, word, ','))
      t.push_back(word);
    data.push_back(iris(t));
    t.clear();
  }

  return data;
}

Node* create_tree(vector<iris>& data, int i=0) {
  Node* root = new Node(data);
  if(i==4) {
    int x, y, z;
    x = y = z = 0;
    for(const iris& t: data) {
      if(t.iris_class=="Iris-setosa") x++;
      else if(t.iris_class=="Iris-versicolor") y++;
      else z++;
    }
    if(x>y and x>z) root->type = "Iris-setosa";
    else if(y>x and y>z) root->type = "Iris-versicolor";
    else root->type = "Iris-virginica";
  }

  else {
    float mean = 0;
    for(const iris& t: data){
      mean+=t.attr[i];
    }
    mean = mean/(float)data.size();

    root->break_value = mean;

    vector<iris> left, right;
    for(const iris& t: data){
      if(t.attr[i]<mean) left.push_back(t);
      else right.push_back(t);
    } 

    root->less = create_tree(left, i+1);
    root->more = create_tree(right, i+1);
  }
  
  return root;
}

string predict(vector<float>& sample, Node* root) {
  for(const float& t: sample) {
    if(!root)
      return "Iris-virginica";
    else if(t<root->break_value)
      root = root->less;
    else
      root = root->more;
  }
  return root->type;
}

int main() {
  vector<iris> data = read_data();
  // Create a decision tree
  Node* root = create_tree(data);
  
  vector<float> sample(4, 0);
  cout << "Sepal Length: ";
  cin >> sample[0];
  cout << "Sepal Width: ";
  cin >> sample[1];
  cout << "Petal Length: ";
  cin >> sample[2];
  cout << "Petal Width: ";
  cin >> sample[3];

  ofstream output;
  output.open("output.txt", ios::app);

  output << sample[0] << "\t" << sample[1] << "\t" << sample[2] << "\t" << sample[3] << "\t" << predict(sample, root) << "\n";

  return 0;
}
```
