-- カテゴリーテーブルデータ
INSERT INTO categories(name) VALUES('ちいかわ');
INSERT INTO categories(name) VALUES('クレヨンしんちゃん');
INSERT INTO categories(name) VALUES('ポケモン');
-- 商品テーブルデータ
INSERT INTO items(category_id, name, detail, price) VALUES(1, 'ちいかわ', 'ちょっぴり泣き虫だけど優しい性格。草むしりや討伐などをして生活している。', 2500);
INSERT INTO items(category_id, name, detail, price) VALUES(1, 'ハチワレ', 'ちいかわのともだち。明るくてポジティブ。 どうくつで生活している。', 980);
INSERT INTO items(category_id, name, detail, price) VALUES(1, 'うさぎ', 'ちいかわのともだち。「ウラ」「ヤハ」など大声でよく叫ぶ。', 1200);
INSERT INTO items(category_id, name, detail, price) VALUES(1, 'モモンガ', '常にかわいこぶっている。色んなことをおねだりする。', 2000);
INSERT INTO items(category_id, name, detail, price) VALUES(1, 'ポシェットの鎧さん', 'かわいいものが好き。自作のポシェットやパジャマを売っている。', 4200);
INSERT INTO items(category_id, name, detail, price) VALUES(1, '労働の鎧さん', '労働の受付をしている。ポシェットの鎧さんと仲が良い。', 2900);
INSERT INTO items(category_id, name, detail, price) VALUES(1, 'ラーメンの鎧さん', 'メニューや注文方法に特徴のあるラーメン屋「郎」の店主。', 1300);
INSERT INTO items(category_id, name, detail, price) VALUES(1, 'ラッコ', '討伐が得意で強い。ちいかわ達のあこがれの存在。', 1780);
INSERT INTO items(category_id, name, detail, price) VALUES(1, 'くりまんじゅう', '見た目はかわいいけど…!? グルメで面倒見がいい。', 1580);
INSERT INTO items(category_id, name, detail, price) VALUES(1, 'シーサー', 'ラーメン屋「郎」の助手。ラーメンの鎧さんを「お師匠」と呼ぶ。', 1730);
INSERT INTO items(category_id, name, detail, price) VALUES(1, 'パジャマパーティーズ', 'ポシェットの鎧さんが作ったパジャマを着て歌とダンスを披露するグループ。', 1470);
INSERT INTO items(category_id, name, detail, price) VALUES(2, 'しんのすけ', '美人のお姉さんと、お菓子の「チョコビ」が大好き。ひたすらお気楽マイペースな幼稚園児。', 1700);
INSERT INTO items(category_id, name, detail, price) VALUES(2, '野原ひろし', 'しんのすけの父。安月給のサラリーマン。のんびり屋でビールが大好き。しんのすけのお姉さん好きは、この人ゆずり。足がくさいのが特ちょう！？', 4200);
INSERT INTO items(category_id, name, detail, price) VALUES(2, '野原みさえ', 'しんのすけの母。「サトーココノカドー」のポイントをためることと、スーパーのタイムセールに命をかけている。成功しないダイエットと昼寝が趣味！？', 5900);
INSERT INTO items(category_id, name, detail, price) VALUES(2, 'ひまわり', 'しんのすけの妹。イケメンと宝石などのキラキラした物が大好き。', 1030);
INSERT INTO items(category_id, name, detail, price) VALUES(2, 'シロ', '野原家の犬。実は野原家の誰よりもしっかり者！？', 190);
INSERT INTO items(category_id, name, detail, price) VALUES(2, '風間くん', 'しんちゃんの友達。幼児とは思えないほどの知識を持つ、エリート志向の自信家。', 5300);
INSERT INTO items(category_id, name, detail, price) VALUES(2, 'ネネちゃん', 'しんちゃんの友達。ちょっとおませな、明るくかわいい女の子。ただしキレると、ウサギのぬいぐるみを殴ってうさを晴らす。', 450);
INSERT INTO items(category_id, name, detail, price) VALUES(2, 'マサオくん', 'しんちゃんの友達。気が弱く、泣き虫な男の子。', 200);
INSERT INTO items(category_id, name, detail, price) VALUES(2, 'ボーちゃん', 'しんちゃんの友達。いつもぼーっとしている無口な子だが、いざとなると一番頼りになる。', 1980);
INSERT INTO items(category_id, name, detail, price) VALUES(3, 'フシギダネ', 'たねポケモン', 780);
INSERT INTO items(category_id, name, detail, price) VALUES(3, 'ヒトカゲ', 'とかげポケモン', 530);
INSERT INTO items(category_id, name, detail, price) VALUES(3, 'ゼニガメ', 'かめのこポケモン', 2490);
INSERT INTO items(category_id, name, detail, price) VALUES(3, 'ピカチュウ', 'ねずみポケモン', 1020);
INSERT INTO items(category_id, name, detail, price) VALUES(3, 'ヤドン', 'まぬけポケモン', 780);
INSERT INTO items(category_id, name, detail, price) VALUES(3, 'イーブイ', 'しんかポケモン', 1980);
INSERT INTO items(category_id, name, detail, price) VALUES(3, 'ヒノアラシ', 'ひねずみポケモン', 2000);
INSERT INTO items(category_id, name, detail, price) VALUES(3, 'ヨーギラス', 'いわはだポケモン', 1780);
INSERT INTO items(category_id, name, detail, price) VALUES(3, 'タマザラシ', 'てたたきポケモン', 1650);
INSERT INTO items(category_id, name, detail, price) VALUES(3, 'ニンフィア', 'むすびつきポケモン', 2000);
INSERT INTO items(category_id, name, detail, price) VALUES(3, 'デデンネ', 'アンテナポケモン', 1780);
--商品画像テーブルデータ
INSERT INTO item_images(item_id, image) VALUES(1,'/images/item1-1.png');
INSERT INTO item_images(item_id, image) VALUES(2,'/images/item2-1.png');
INSERT INTO item_images(item_id, image) VALUES(3,'/images/item3-1.png');
INSERT INTO item_images(item_id, image) VALUES(4,'/images/item4-1.png');
INSERT INTO item_images(item_id, image) VALUES(5,'/images/item5-1.png');
INSERT INTO item_images(item_id, image) VALUES(6,'/images/item6-1.png');
INSERT INTO item_images(item_id, image) VALUES(7,'/images/item7-1.png');
INSERT INTO item_images(item_id, image) VALUES(8,'/images/item8-1.png');
INSERT INTO item_images(item_id, image) VALUES(9,'/images/item9-1.png');
INSERT INTO item_images(item_id, image) VALUES(10,'/images/item10-1.png');
INSERT INTO item_images(item_id, image) VALUES(11,'/images/item11-1.png');
INSERT INTO item_images(item_id, image) VALUES(12,'/images/item12-1.png');
INSERT INTO item_images(item_id, image) VALUES(13,'/images/item13-1.png');
INSERT INTO item_images(item_id, image) VALUES(14,'/images/item14-1.png');
INSERT INTO item_images(item_id, image) VALUES(15,'/images/item15-1.png');
INSERT INTO item_images(item_id, image) VALUES(16,'/images/item16-1.png');
INSERT INTO item_images(item_id, image) VALUES(17,'/images/item17-1.png');
INSERT INTO item_images(item_id, image) VALUES(18,'/images/item18-1.png');
INSERT INTO item_images(item_id, image) VALUES(19,'/images/item19-1.png');
INSERT INTO item_images(item_id, image) VALUES(20,'/images/item20-1.png');
INSERT INTO item_images(item_id, image) VALUES(21,'/images/item21-1.png');
INSERT INTO item_images(item_id, image) VALUES(22,'/images/item22-1.png');
INSERT INTO item_images(item_id, image) VALUES(23,'/images/item23-1.png');
INSERT INTO item_images(item_id, image) VALUES(24,'/images/item24-1.png');
INSERT INTO item_images(item_id, image) VALUES(25,'/images/item25-1.png');
INSERT INTO item_images(item_id, image) VALUES(26,'/images/item26-1.png');
INSERT INTO item_images(item_id, image) VALUES(27,'/images/item27-1.png');
INSERT INTO item_images(item_id, image) VALUES(28,'/images/item28-1.png');
INSERT INTO item_images(item_id, image) VALUES(29,'/images/item29-1.png');
INSERT INTO item_images(item_id, image) VALUES(30,'/images/item30-1.png');
INSERT INTO item_images(item_id, image) VALUES(31,'/images/item31-1.png');



--顧客テーブルデータ
INSERT INTO customers(name, address, tel, email, password) VALUES('田中太郎', '東京都', '090-1111-1111', 'tanaka@aaa.com', 'himitu'); 
INSERT INTO customers(name, address, tel, email, password) VALUES('鈴木一郎', '大阪府', '090-1111-2222', 'suzuki@aaa.com', 'himitu'); 
INSERT INTO customers(name, address, tel, email, password) VALUES('河田陽大', '大阪府', '090-1111-2222', 'haruto.kawata0602@gmail.com', 'himitu'); 

--タイムセールテーブルデータ
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(1, '2024-05-22 10:00:00', '2024-05-28 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(2, '2024-05-21 10:00:00', '2024-05-28 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(3, '2024-05-21 10:00:00', '2024-05-28 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(4, '2024-05-21 10:00:00', '2024-05-28 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(5, '2024-05-21 10:00:00', '2024-05-28 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(6, '2024-05-21 10:00:00', '2024-05-28 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(7, '2024-05-21 10:00:00', '2024-05-28 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(8, '2024-05-21 10:00:00', '2024-05-28 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(9, '2024-05-21 10:00:00', '2024-05-28 12:00:00', 0.90);

--クーポンデータ
INSERT INTO coupon (customer_id, code, discount, is_used) VALUES(1, 0, 0.1, false);
 