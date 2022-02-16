// import {connect} from "react-dedux"
// import { createProject } from "../../actions/projectActions";
// import AddProject from "./AddProject";
// import PropTypes from "prop-types"


// //将state.counter绑定到props的counter
// const mapStateToProps = (state) => {
//   return {
//       counter: state.history
//   }
// };
// //将action的所有方法绑定到props上
// const mapDispatchToProps = (dispatch, ownProps) => {
//   return {
//       createProject: (...args) => dispatch(createProject(...args))
//   }
// };

// //通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
// const AddProjectContainer = connect(mapStateToProps, mapDispatchToProps)(AddProject)
// export default AddProjectContainer;