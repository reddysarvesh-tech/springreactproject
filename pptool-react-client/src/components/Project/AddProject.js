import React, { Component } from 'react';
import DatePicker from 'react-date-picker';

class AddProject extends Component {

  constructor(){
    super();
    this.state = {
      "name":"",
      "projectIdentifier":"",
      "description":"",
      "start_date": new Date(),
      "end_date":new Date()
    }

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
    this.onStartDateChanged = this.onStartDateChanged.bind(this);
    this.onEndDateChanged = this.onEndDateChanged.bind(this);
  }

  onChange(e){
    this.setState({[e.target.name]:e.target.value});
  }

  onSubmit(e) {
    e.preventDefault();
    const newProject = {
      projectName: this.state.name,
      projectIdentifier: this.state.projectIdentifier,
      description: this.state.description,
      start_date: this.state.start_date,
      end_date: this.state.end_date
    };
    console.log(newProject);
  }
 
 
 // onStartDateChanged = startdate => this.setState({ startdate })

 // onEndDateChanged = enddate => this.setState({ enddate })
 onStartDateChanged(date){

  if(date > this.state.end_date){
    return false;
  }
  this.setState({
    start_date : date
  })
   
 }

 onEndDateChanged(date){

  if(date < this.state.start_date){
    return false;
  }
   this.setState({
     end_date:date
   })
 }


  

  render() {
    return (
      <div className="row example-wrapper">
        <div className="col-xs-12 col-sm-6 offset-sm-3 example-col">
          <div className="card">
            <div className="card-block">
              <form className="k-form" onSubmit={this.onSubmit}>
                <fieldset>
                  <legend> Project Details </legend>
                  <label className="k-form-field">
                    <span> Project Name </span>
                    <input
                      className="k-textbox"
                      name="name"
                      placeholder="Project Name"
                      value={this.state.name}
                      onChange = {this.onChange}
                    />
                    </label>
                    <label className="k-form-field">
                    <span> Project Identifier </span>
                    <input
                      className="k-textbox"
                      name="projectIdentifier"
                      placeholder="Project Identifier"
                      value={this.state.projectIdentifier}
                      onChange = {this.onChange}
                    />
                    </label>
                    <label className="k-form-field">
                    <span> Description </span>
                    <textarea
                      className="k-textbox"
                      name="description"
                      placeholder="Project Description"
                      value={this.state.description}
                      onChange = {this.onChange}
                    />
                  </label>
                  <label className="k-form-field">
                  <span> Start Date </span>
                  <DatePicker  
                  name = "start_date"
                  value={this.state.start_date}   
                  onChange = {this.onStartDateChanged}     
                  />
                  </label>
                  <label className="k-form-field">
                  <span> End Date </span>
                  <DatePicker  
                  name = "end_date"
                  value={this.state.end_date}    
                  onChange = {this.onEndDateChanged}    
                  />
                </label>
                </fieldset>
                <input type="submit" className="k-button" name="Submit" />
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default AddProject;
