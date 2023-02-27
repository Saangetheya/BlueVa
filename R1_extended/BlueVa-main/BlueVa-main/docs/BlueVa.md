### WorkFlow
(Below are in chronological order)

Pacakge Editor + Class Editor => Xml Document + Class Node files => On Compile , we use xml document as main package layout , parse it then use roaster library with json files for each class to generate files  ( as each internal implementation of classes , interfaces doesn't diff  ,we can use same api's)

class names must be read only ( else parsing is tough )
no use of uuid required 

Components available to GUI programmer :
- [ ] Global xml document handle object 
- [ ] List of all classes / interfaces / enums in the package 
- [ ] Each class has object and it is stored in HashMap 
- [ ] For package there exists a single  package  that contains the api to all these global / hashMap

Components :
- [ ] Xml file scheme
- [ ] Json file scheme
- [ ] Xml file creation api 
- [ ] Json file creation api
- [ ] generating file from xml ( without json ) using roaster
- [ ] Wireframes
- [ ] Helpful documentation for each in code + workflow diagrams