-- 创建数据库
CREATE DATABASE IF NOT EXISTS erp;

-- 选择数据库
USE erp;

-- 创建用户表
CREATE TABLE IF NOT EXISTS user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(20),
    password VARCHAR(60),
    phone VARCHAR(11),
    create_time DATE,
    update_time DATE,
    access INT NOT null
);

-- 创建订单表
CREATE TABLE IF NOT EXISTS `order` (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    company VARCHAR(30),
    contact_person VARCHAR(15),
    customer_contract_number VARCHAR(50),
    order_date DATE,
    latest_delivery_date DATE,
    product_name VARCHAR(50),    
    delivery_info VARCHAR(120),
    file_path VARCHAR(120),
    notes VARCHAR(120)
);

-- 创建子订单表
CREATE TABLE IF NOT EXISTS suborder(
    suborder_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    paper_type INT,
    specification VARCHAR(50),
    craft INT,
    quantity INT,
    unit_price DECIMAL(10, 2),
    amount DECIMAL(10, 2) AS (ROUND(quantity * unit_price, 2)) STORED,
    order_status INT,
    FOREIGN KEY (order_id) REFERENCES `order`(order_id)
);

-- 创建库存表
CREATE TABLE IF NOT EXISTS inventory (
    material_id INT AUTO_INCREMENT PRIMARY KEY,
    material_name VARCHAR(50),
    specification VARCHAR(50),
    quantity INT
);

-- 设置订单金额求和触发器
CREATE TRIGGER update_order_sum
AFTER INSERT ON suborder
FOR EACH ROW
BEGIN
    UPDATE `order` o
    SET o.sum = (
        SELECT SUM(s.amount)
        FROM suborder s
        WHERE s.order_id = NEW.order_id
    )
    WHERE o.order_id = NEW.order_id;
END;