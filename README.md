# BlessingChess
棋开得胜-学生在线2024寒假实训项目-后端仓库

## 开发者

**后端**

> lxy<br>
> lrq<br>
> ljy
>
> 

## 接口文档：

[BlessingChess接口文档](https://apifox.com/apidoc/shared-3e150537-fd3c-4f70-ae07-e75b401dac38)

## 数据库结构

```sql
CREATE DATABASE `BlessingChess`
-- 创建用户表
CREATE TABLE BlessingChess.`user` (
	id INTEGER auto_increment NOT NULL,
	session_key TEXT NULL,
	open_id TEXT NOT NULL,
	last_time DATE NULL,
	username TEXT NOT NULL,
	invitation_code TEXT NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
-- 创建祝福表
CREATE TABLE BlessingChess.blessing (
	id INTEGER auto_increment NOT NULL,
	`sender-id` INTEGER NOT NULL,
	`receiver-id` INTEGER NOT NULL,
	`delivery-time` DATE NULL,
	content TEXT NULL,
	icon TEXT NULL,
	background TEXT NULL,
	is_viewed BOOL NOT NULL,
	public BOOL NOT NULL,
	CONSTRAINT blessing_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
-- 创建贺卡表
CREATE TABLE BlessingChess.card (
	id INTEGER auto_increment NOT NULL,
	sender_id INTEGER NOT NULL,
	delivery_time DATE NULL,
	content TEXT NULL,
	icon TEXT NULL,
	background TEXT NULL,
	CONSTRAINT card_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
-- 创建贺卡接收关系表
CREATE TABLE BlessingChess.card_receiver_relations (
	id INTEGER auto_increment NOT NULL,
	card_id INTEGER NOT NULL,
	receiver_id INTEGER NOT NULL,
	CONSTRAINT card_receiver_relations_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

```

