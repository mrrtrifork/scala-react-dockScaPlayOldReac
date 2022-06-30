import React from "react";
import { MyService } from "./MyService";

export class MyComponent extends React.Component{
    constructor(){
        super();
        this.state = {
            myService: new MyService(),
            received: ''
        };
    }
    updateShowData(data){
        this.setState({
            myService: this.state.myService,
            received: JSON.stringify(data)
        });
    }
    callBackend() {
        var self = this;
        this.state.myService.callBackend()
        .then(function(response){
            response.json()
            .then(function(data){
                console.log(data);
                self.updateShowData(data);
            })
            .catch(function(error1){
                console.error(error1);
            });      
        })
        .catch(function(error2){
            console.error(error2);
        });
    }
    render(){
        return (
            <div>
                <button onClick={()=>this.callBackend()}>Click me</button>
                <p>{this.state.received}</p>
            </div>            
        );
    }
}