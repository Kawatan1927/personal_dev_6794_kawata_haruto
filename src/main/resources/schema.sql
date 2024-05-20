-- 各種テーブル削除
DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS items CASCADE;
DROP TABLE IF EXISTS item_images CASCADE;
DROP TABLE IF EXISTS customers CASCADE;;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS order_details CASCADE;
DROP TABLE IF EXISTS reviews CASCADE;
DROP TABLE IF EXISTS wishlists CASCADE;

-- カテゴリーテーブル
CREATE TABLE categories
(
   id SERIAL PRIMARY KEY,
   name TEXT
);
-- 商品テーブル
CREATE TABLE items
(
   id SERIAL PRIMARY KEY,
   category_id INTEGER,
   name TEXT,
   detail TEXT,
   price INTEGER
);
--商品画像テーブル
CREATE TABLE item_images
(
   id SERIAL PRIMARY KEY,
   item_id INTEGER,
   image TEXT
 
);
-- 顧客テーブル
CREATE TABLE customers
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   address TEXT,
   tel TEXT,
   email TEXT,
   password TEXT,
   point INTEGER DEFAULT 0
);
-- 注文テーブル
CREATE TABLE orders
(
   id SERIAL PRIMARY KEY,
   customer_id INTEGER,
   ordered_on DATE,
   total_price INTEGER
   
);
-- 注文明細テーブル
CREATE TABLE order_details
(
   id SERIAL PRIMARY KEY,
   order_id INTEGER,
   item_id INTEGER,
   quantity INTEGER
);

--注文履歴テーブルView
CREATE VIEW v_order_details AS
(
	SELECT
		od.id,
		o.id AS order_id,
		o.customer_id,
		o.ordered_on,
		od.item_id,
		i.name,
		i.price,
		od.quantity,
		o.total_price
	FROM order_details od
	JOIN  orders o
	ON od.order_id = o.id
	JOIN items i
	ON od.item_id = i.id
);

--カスタマーレビューテーブル
CREATE TABLE reviews
(
	id SERIAL PRIMARY KEY,
	item_id INTEGER,
	customer_id INTEGER,
	reviewed_on DATE,
	review_title TEXT,	
	review_score INTEGER,
	review_image TEXT,	
	review_detail TEXT,	
	good INTEGER,	
	bad INTEGER
);	

--欲しいものリストテーブル
CREATE TABLE wishlists
(
	id SERIAL PRIMARY KEY,
	item_id INTEGER,
	customer_id INTEGER
);

--欲しいものリストビューテーブル
CREATE VIEW v_wishlists AS
(
	SELECT
		w.id,
		w.item_id,
		w.customer_id,
		i.name,
		i.price
	FROM wishlists w
	JOIN items i
	ON w.item_id = i.id
);
	