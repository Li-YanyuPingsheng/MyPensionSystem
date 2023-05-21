# Api文档

## jQuery引入 

使用GoogleCDN 可选择本地或者其他CDN 示例代码 
```javascript
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js">
```
对于状态响应码的处理请看Test.html中的请求

1 封装json格式
``` javascript
    <script>
        function confirm(){
            let myData={"goodName":$("#Good_Name").val(),
                "quantity": $("#quantity").val(),
                "price":$("#price").val(),
                "location":$("#location").val(),
                "status":"未发货"}
            $.ajax(
                {
                    url:"/order/add",
                    contentType:'application/json;charset=utf-8',
                    data: JSON.stringify(myData),
                    type: "POST",
                    success:function (data){
                        alert("提交成功")
                        location.reload()
                    }
                }
            )
        }
    </script>
```
2 直接发送形式
``` javascript
    <script>
        function confirm(){
            let myData={"goodName":$("#Good_Name").val(),
                "quantity": $("#quantity").val(),
                "price":$("#price").val(),
                "location":$("#location").val(),
                "status":"未发货"}
            $.ajax(
                {
                    url:"/order/add",
                    data: {
                            "goodName":$("#Good_Name").val(),
                            "quantity": $("#quantity").val(),
                            "price":$("#price").val(),
                            "location":$("#location").val(),
                            "status":"未发货"
                            }       //数据体
                    type: "POST",   //发送方式 有Post Put Patch Get Delete等
                    success:function (data){
                        alert("提交成功")
                        location.reload()
                    }               //请求成功处理
                }
            )
        }
    </script>
```
## 详细说明(WIP)
```
api中所有date类型格式为yyyy-MM-dd
所有UUID尽可能使用JSON.stringify转换为字符串 否则可能出现精度丢失
```
### 1.UserRestController
#### 登录
URL:/user Method:get data:{```username:*,password:*,role:*```} 

Description:     登录接口需要通过状态响应码来输出响应的信息 其中 404 账号不存在 405 密码错误* 200表示登录成功
#### 注册老人
URL:/user/elders  Method:Post data: {
```json
[
{
"id": "511521200207084670",
"location": "test",
"name":"test"
},
{
"id": "511521200207084671",
"location": "test1",
"name":"test"
}
]
```
}
#### 注册商家/医生
url:/user/merchant /user/doctor Method:Post data:{```username:*,password:*,role:*```}
#### 更新用户信息 用户名/密码
url:/user/username /user/password Method:Put data:{```username:*,username/passowrd:*```}
#### 添加收货地址 
url:/user/elder/deliverAddress Method:Post data:{```"elderUUID":*（使用JSON.stringify转换为字符串 否则可能出现精度丢失）,"location":*```}
#### 更新收货地址
url:/user/elder/deliverAddress Method:Put data:{```"UUID:*,"updateContent":*```}
#### 删除收货地址
url:/user/elder/deliverAddress Method:Delete data:{```"UUID":*```}
#### 创建老人列表
url:/users/elders Method:Post data:["elder":{ID,location},"elder":{ID,location}]
#### 创建老人单个
url:/user/elder Method:Post data:{ID,location}
### ElderCommentRestController
#### 添加投诉
url:/comment Method:Post data:{```"Elder_UUID":*,"Content":*```}
#### 投诉回复
url:/comment Method:Put data:{```"UUID":*,"content":*```}
### ActivityRestController
#### 添加活动
url:/activity method:Post data:{```"content":*,"fee":*,"location":*,"data":*,"picture_ID":*(nullable)```}
#### 更新活动信息
url:/activity method:Put data:{```"content":*,"fee":*,"location":*,"data":*,"picture_ID":*(nullable)```}
#### 删除活动
url:/activity Method:Delete data:{```"UUID":*```}
#### 修改活动状态
url:/activity Method:Patch data:{```"UUID":*,status":*```}
#### 批量删除活动
url:/activities Method:Delete data:{```["UUID":*,"UUID":*]```}
#### 添加活动评论
url:/activity/comment Method:Post data:{```"activityUUID":*,"elderUUID":*,"Content":*```}
#### 活动评论回复
url:/activity/comment Method:Put data:{```"UUID":*,"content":*```}
#### 删除活动
url:/comment Method:Delete data:{```"UUID":*```}
#### 活动收藏
url:/activity/favourite Method:Put data:{```"activity_UUID":*,"Elder_UUID":*```}
#### 参加活动
url:/activity/attention Method:Post data:{```"activity_UUID":*,"Elder_UUID":*```}
#### 退出活动
url:/activity/attention Method:Delete data:{```"activity_UUID":*,"Elder_UUID":*```}
### AgentRestController 
#### 发布请求
url:/agent Method:Post data:{"elder_UUID":,"content":}
#### 更新请求
url:/agent Method:Put data:{"elder_UUID":,"content":}
#### 更新请求状态
url:/agent Method:Put data:{"UUID":,"status":}
#### 删除请求
url:/agent Method:Delete data:{"UUID":}
### MedicalRestController
#### 添加身体数据
url:/bodyData Method:Post data:{"elderUUID":,"content":,"picture_ID":}
#### 更新身体数据
url:/bodyData Method:Put data:{"elderUUID":,"content":,"picture_ID":}
#### 删除身体数据
url:/bodyData Method:Delete data:{"UUID":}
#### 添加诊断
url:/bodyData/analysis method:Post data:{"elderDataUUID":,"doctorUUID":,"content":,"picture_ID":}
#### 修改诊断
url:/bodyData/analysis method:Put data:{"elderDataUUID":,"doctorUUID":,"content":,"picture_ID":}
### TradeRestController
#### 添加分类
url:/good/category method:Post data:{"fatherUUID":(nullable),"name":,leafDepth:}
#### 修改分类
url:/good/category method:Put data:{"fatherUUID":(nullable),"name":,leafDepth:}
#### 删除分类
url:/good/category Method:Delete data:{"UUID":}
#### 添加活动评论
url:/activity/comment Method:Post data:{```"goodUUID":*,"elderUUID":*,"Content":*```}
#### 活动评论回复
url:/activity/comment Method:Put data:{```"UUID":*,"content":*```}
#### 删除身体数据
url:/activity/comment Method:Delete data:{"UUID":}
#### 添加商品
url:/good method:Post data:{"name":,"price","stock","status":,"information":,"picture_ID":,"category_UUID":,"merchant_UUID":}
#### 修改商品
url:/good method:Put data:{"name":,"price","stock","status":,"information":,"picture_ID":,"category_UUID":,"merchant_UUID":}
#### 删除商品
url:/good Method:Delete data:{"UUID":}
#### 点赞
url:/good/like method:Post data:{Good_UUID,Elder_UUID}
#### 收藏
url:/good/favourite method:Post data:{Elder_UUID,Good_UUID}
#### 购物车添加
url:/cart method:Post data:{Elder_UUID,Good_UUID}
#### 购物车减少
url:/cart method:Put data:{Elder_UUID,Good_UUID}
#### 订单创建
url:/order method:Post data:{Elder_UUID,locationUUID,[orderDetail:{goodUUID,quantity},orderDetail:{goodUUID,quantity}]} //可能书写有错误
#### 订单状态修改
url:/order method:Put data:{UUID,status}