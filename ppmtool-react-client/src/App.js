import logo from './logo.svg';
import './App.css';
import Dashboard from './components/Dashboard';
import Header from './components/Layout/Header';
import "bootstrap/dist/css/bootstrap.min.css"
import {BrowserRouter , Route, Routes} from "react-router-dom"
import AddProject from './components/Project/AddProject';
import {Provider} from "react-redux"
import store from "./store"
//import AddProjectContainer from './components/Project/AddProjectContainer';
import { createBrowserHistory } from 'history';
import UpdateProject from './components/Project/UpdateProject';


function App() {
  const customHistory = createBrowserHistory();
  return (
    <Provider store={store}>
      <BrowserRouter>
      <div className="App">
        <Header />
        <Routes>
          <Route exact path="/dashboard" element={<Dashboard />} />
          <Route exact path="/addProject" element={<AddProject history={customHistory}/>} />
          <Route exact path="/updateProject/:id" element={<UpdateProject history={customHistory} />} />
          
          {/* <Route exact path="/updateProject/:id" render={(props) => <UpdateProject {...props} history={customHistory}/>} /> */}
        </Routes>
      </div>
      </BrowserRouter>
    </Provider>
  );
}

export default App;
