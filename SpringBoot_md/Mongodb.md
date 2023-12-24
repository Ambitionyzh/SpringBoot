 https://pan.baidu.com/s/1z8I4IXEuYBepDYbg4ijzUw?pwd=1234





#### Mongodb

●淘宝用户数据
	◆存储位置：数据库
	◆特征：永久性存储，修改频度极低

●游戏装备数据、游戏道具数据
	◆存储位置：数据库、Mongodb
	◆特征：永久性存储与临时存储相结合、修改频度较高

●直播数据、打赏数据、粉丝数据

​	◆存储位置：数据库、Mongodb

​	◆特征：永久性存储与临时存储相结合，修改频度极高。

●物联网数据

​	◆存储位置：Mongodb

​	◆特征：临时存储，修改频度飞速



服务端启动：

```shell
mongod --dbpath=..\data\db
```

