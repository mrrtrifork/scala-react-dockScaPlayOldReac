export class MyService{
    callBackend() {
        const myHeaders = new Headers();
        myHeaders.set('Accept', 'application/json');
        return fetch('/users', {method: 'GET', headers: myHeaders});    
    }
}