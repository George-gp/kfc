import React from 'react'
import $ from 'jquery'
import {Table,Modal} from 'antd'
class Usermanager extends React.Component{

    constructor(){
        super();
        this.state={
            visible:false,
            form:{
                name:'',
                age:'',
                address:''
            }
        }
    }
    toUpdate(id){
        // 1. 通过id查找课程信息
        // 2. 将返回结果设置到this.state.form中
        // state->form
        $.get("http://127.0.0.1:8888/user/findById?id="+id,({status,message,data})=>{
          if(status === 200){
            // 将查询数据设置到state中
            this.setState({ flag:true,"form":data })
          } else {alert (message)}
        })
      }
    delTeacher = (id)=>{
        let url='http://127.0.0.1:8888/user/delete?id='+id;
        $.get(url,({status,message})=>{
        if(status===200){
            this.loadTeacher();
            }
            alert(message);
        })
    }
    handleCancel=()=>{
        this.setState({
            visible:false
        })
    }
    toAdd1=(key)=>{//显示模态框
       
            this.setState({//设置数据
                visible:true,
                
            })
        
    }
    changeHandler = (event)=>{
        let name = event.target.name;
        let value = event.target.value;
        this.setState({
          form:{...this.state.form,...{[name]:value}}
        })
      }
    render(){
        let{form}=this.state;
        let columns =[{
            title: '用户名',
            dataIndex: 'name',
            key: 'name'
            
        },{
            title: '姓名',
            dataIndex: 'age',
            key: 'age'
        },{
            title: '地址',
            dataIndex: 'address',
            key: 'address'
        },{
            title: '操作',
            key: 'action',
            render: (record) => (
            
                <span>
                    <span onClick={this.delTeacher.bind(record.key)}>删除 </span>
                    <span onClick={this.toAdd1.bind(record.key)}>更新</span>
                </span>
                //this.toUpdate.bind(record.key)
                // <span>
                // <a href="#">更新</a>
                
                // <a href="#">删除</a>
                // </span>
            ),
        }]
        const data = [
            {
              key: '1',
              name: 'John Brown',
              age: 32,
              address: 'New York No. 1 Lake Park',
            },
            {
              key: '2',
              name: 'Jim Green',
              age: 42,
              address: 'London No. 1 Lake Park',
            },
            {
              key: '3',
              name: 'Joe Black',
              age: 32,
              address: 'Sidney No. 1 Lake Park',
            },
            {
              key: '4',
              name: 'Disabled User',
              age: 99,
              address: 'Sidney No. 1 Lake Park',
            },
          ]
          
          const rowSelection = {
            onChange: (selectedRowKeys, selectedRows) => {
              console.log(`selectedRowKeys: ${selectedRowKeys}`, 'selectedRows: ', selectedRows);
            },
            getCheckboxProps: record => ({
              disabled: record.name === 'Disabled User', // boss用户不可操作
              name: record.name,
            }),
          };
        return (
          
            <div className='user'>
              <h1>用户管理</h1>
               <Table rowSelection={rowSelection} columns={columns} dataSource={data} /> 
               <Modal
                    title="Basic Modal"
                    visible={this.state.visible}
                    onOk={this.handleOk}
                    onCancel={this.handleCancel}
                    >
                    {JSON.stringify(form)}
                    <form onSubmit={this.submitHandler}>
                        名字
                        <input type="text" name="name" value={this.state.form.name} onChange={this.changeHandler}/> <br/>
                        年龄
                        <input type="text" name="age" value={this.state.form.age} onChange={this.changeHandler}/> <br/>
                        地址
                        <textarea name="address" value={this.state.form.address} onChange={this.changeHandler}></textarea> <br/>
                     </form>
                </Modal>
            </div>
        )
    }
}
export default Usermanager;