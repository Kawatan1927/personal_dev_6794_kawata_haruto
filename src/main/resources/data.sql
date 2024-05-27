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
INSERT INTO customers(name, address, tel, email, password) VALUES('佐藤太郎', '東京都', '090-3333-4444', 'sato@bbb.com', 'himitsu1');
INSERT INTO customers(name, address, tel, email, password) VALUES('田中花子', '神奈川県', '080-5555-6666', 'tanaka@ccc.com', 'himitsu2');
INSERT INTO customers(name, address, tel, email, password) VALUES('山本二郎', '北海道', '070-7777-8888', 'yamamoto@ddd.com', 'himitsu3');
INSERT INTO customers(name, address, tel, email, password) VALUES('中村三郎', '愛知県', '090-9999-0000', 'nakamura@eee.com', 'himitsu4');
INSERT INTO customers(name, address, tel, email, password) VALUES('小林四郎', '福岡県', '080-1111-3333', 'kobayashi@fff.com', 'himitsu5');
INSERT INTO customers(name, address, tel, email, password) VALUES('加藤五郎', '広島県', '070-4444-5555', 'kato@ggg.com', 'himitsu6');
INSERT INTO customers(name, address, tel, email, password) VALUES('伊藤六郎', '埼玉県', '090-6666-7777', 'ito@hhh.com', 'himitsu7');

--タイムセールテーブルデータ
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(1, '2024-05-22 10:00:00', '2024-05-30 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(2, '2024-05-21 10:00:00', '2024-05-28 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(3, '2024-05-21 10:00:00', '2024-05-30 12:00:00', 0.80);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(4, '2024-05-21 10:00:00', '2024-05-28 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(5, '2024-05-21 10:00:00', '2024-05-28 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(6, '2024-05-21 10:00:00', '2024-05-28 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(7, '2024-05-21 10:00:00', '2024-05-28 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(8, '2024-05-21 10:00:00', '2024-05-28 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(9, '2024-05-21 10:00:00', '2024-05-28 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(15, '2024-05-21 10:00:00', '2024-05-30 12:00:00', 0.75);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(21, '2024-05-21 10:00:00', '2024-05-30 12:00:00', 0.90);
INSERT INTO timesale (item_id, start_time, end_time, discount_price_ratio) VALUES(27, '2024-05-21 10:00:00', '2024-05-30 12:00:00', 0.85);

--クーポンデータ
INSERT INTO coupon (customer_id, code, discount, is_used) VALUES(1, 0000, 0.1, false);
 
 --カスタマーレビューデータ
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(1, 1, '2024-05-27', ' 色がかわいい', 5, '0', 'とてもかわいい！', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(1, 1, '2024-05-20', '色が鮮やか', 4, '0', '鮮やかな色合いで気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(1, 3, '2024-05-18', 'サイズがちょうどいい', 5, '0', 'ちょうどいいサイズで使いやすいです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(1, 4, '2024-05-25', '耐久性がある', 5, '0', '耐久性が高くて長持ちしそうです。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(2, 2, '2024-05-21', 'デザインが素敵', 4, '0', 'デザインがとても素敵です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(2, 5, '2024-05-19', '使いやすい', 4, '0', 'とても使いやすくて便利です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(2, 1, '2024-05-17', '価格が手頃', 3, '0', '価格が手頃でコスパがいいです。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(3, 3, '2024-05-16', '品質が良い', 5, '0', '品質が良くて満足です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(3, 2, '2024-05-22', '発送が早い', 4, '0', '発送がとても早かったです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(3, 4, '2024-05-24', '梱包が丁寧', 5, '0', '梱包が丁寧で安心しました。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(4, 1, '2024-05-23', '色が鮮やか', 4, '0', '鮮やかな色合いで気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(4, 3, '2024-05-20', 'サイズがちょうどいい', 5, '0', 'ちょうどいいサイズで使いやすいです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(4, 5, '2024-05-21', '耐久性がある', 5, '0', '耐久性が高くて長持ちしそうです。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(5, 2, '2024-05-18', 'デザインが素敵', 4, '0', 'デザインがとても素敵です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(5, 4, '2024-05-19', '使いやすい', 4, '0', 'とても使いやすくて便利です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(5, 1, '2024-05-23', '価格が手頃', 3, '0', '価格が手頃でコスパがいいです。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(6, 1, '2024-05-22', 'デザインが良い', 5, '0', 'デザインが非常に良くて気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(6, 3, '2024-05-21', '使い勝手が良い', 4, '0', '使い勝手が非常に良いです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(6, 4, '2024-05-19', '満足しています', 5, '0', '非常に満足しています。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(7, 2, '2024-05-20', 'サイズがぴったり', 4, '0', 'サイズがぴったりで使いやすいです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(7, 5, '2024-05-18', '価格に満足', 3, '0', '価格に非常に満足しています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(7, 1, '2024-05-17', '品質が良い', 5, '0', '品質が非常に良くて安心しました。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(8, 3, '2024-05-16', '発送が迅速', 4, '0', '発送が迅速で助かりました。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(8, 2, '2024-05-22', '見た目がいい', 5, '0', '見た目が非常に良いです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(8, 4, '2024-05-24', '機能が多い', 4, '0', '機能が多くて便利です。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(9, 1, '2024-05-23', '高級感がある', 5, '0', '高級感があってとても気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(9, 3, '2024-05-20', '軽量で便利', 4, '0', '軽量で非常に便利です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(9, 5, '2024-05-21', 'コスパが良い', 4, '0', 'コスパが良くて満足しています。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(10, 2, '2024-05-18', 'シンプルで良い', 4, '0', 'シンプルなデザインが良いです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(10, 4, '2024-05-19', '丈夫で安心', 5, '0', '非常に丈夫で安心できます。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(10, 1, '2024-05-23', '使いやすい', 4, '0', '非常に使いやすくて助かります。', 0, 0);


INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(11, 1, '2024-05-21', '見た目が良い', 5, '0', '見た目が非常に良くて満足です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(11, 3, '2024-05-18', '軽くて持ちやすい', 4, '0', '軽くて持ちやすいので便利です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(11, 4, '2024-05-17', '価格が手頃', 4, '0', '価格が手頃でコスパが良いです。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(12, 2, '2024-05-16', '使いやすい', 5, '0', '非常に使いやすくて気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(12, 5, '2024-05-22', 'デザインが素敵', 4, '0', 'デザインが素敵で満足です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(12, 1, '2024-05-24', '品質が良い', 5, '0', '品質が非常に良くて安心しました。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(13, 3, '2024-05-23', '見た目が高級', 5, '0', '見た目が高級感があって気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(13, 2, '2024-05-20', '軽くて便利', 4, '0', '軽くて便利で使いやすいです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(13, 4, '2024-05-21', '価格がリーズナブル', 4, '0', '価格がリーズナブルでコスパが良いです。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(14, 1, '2024-05-18', '耐久性がある', 5, '0', '耐久性が非常に高くて満足しています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(14, 3, '2024-05-19', 'デザインが良い', 4, '0', 'デザインが非常に良くて気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(14, 5, '2024-05-23', '価格に満足', 4, '0', '価格に非常に満足しています。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(15, 2, '2024-05-16', 'サイズがちょうどいい', 4, '0', 'サイズがちょうど良くて便利です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(15, 4, '2024-05-22', '軽くて持ちやすい', 5, '0', '軽くて持ちやすいので便利です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(15, 1, '2024-05-24', '見た目が良い', 4, '0', '見た目が非常に良くて気に入っています。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(16, 3, '2024-05-23', '品質が良い', 5, '0', '品質が非常に良くて満足です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(16, 2, '2024-05-20', '使い勝手が良い', 4, '0', '使い勝手が非常に良いです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(16, 4, '2024-05-21', 'デザインが素敵', 5, '0', 'デザインが素敵で満足です。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(17, 1, '2024-05-18', '価格が手頃', 4, '0', '価格が手頃でコスパが良いです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(17, 3, '2024-05-19', '梱包が丁寧', 5, '0', '梱包が丁寧で安心しました。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(17, 5, '2024-05-23', '発送が迅速', 4, '0', '発送が迅速で助かりました。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(18, 2, '2024-05-16', 'デザインが良い', 5, '0', 'デザインが非常に良くて気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(18, 4, '2024-05-22', '耐久性がある', 4, '0', '耐久性が非常に高くて満足しています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(18, 1, '2024-05-24', '使いやすい', 5, '0', '非常に使いやすくて助かります。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(19, 3, '2024-05-23', '価格が手頃', 4, '0', '価格が手頃でコスパが良いです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(19, 2, '2024-05-20', '梱包が丁寧', 5, '0', '梱包が丁寧で安心しました。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(19, 4, '2024-05-21', '発送が迅速', 4, '0', '発送が迅速で助かりました。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(20, 1, '2024-05-18', 'デザインが良い', 5, '0', 'デザインが非常に良くて気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(20, 3, '2024-05-19', '使い勝手が良い', 4, '0', '使い勝手が非常に良いです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(20, 5, '2024-05-23', '品質が良い', 5, '0', '品質が非常に良くて満足です。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(21, 2, '2024-05-16', '使いやすい', 5, '0', '非常に使いやすくて気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(21, 4, '2024-05-22', 'デザインが素敵', 4, '0', 'デザインが素敵で満足です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(21, 1, '2024-05-24', '品質が良い', 5, '0', '品質が非常に良くて安心しました。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(22, 3, '2024-05-23', '見た目が高級', 5, '0', '見た目が高級感があって気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(22, 2, '2024-05-20', '軽くて便利', 4, '0', '軽くて便利で使いやすいです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(22, 4, '2024-05-21', '価格がリーズナブル', 4, '0', '価格がリーズナブルでコスパが良いです。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(23, 1, '2024-05-18', '耐久性がある', 5, '0', '耐久性が非常に高くて満足しています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(23, 3, '2024-05-19', 'デザインが良い', 4, '0', 'デザインが非常に良くて気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(23, 5, '2024-05-23', '価格に満足', 4, '0', '価格に非常に満足しています。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(24, 2, '2024-05-16', 'サイズがちょうどいい', 4, '0', 'サイズがちょうど良くて便利です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(24, 4, '2024-05-22', '軽くて持ちやすい', 5, '0', '軽くて持ちやすいので便利です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(24, 1, '2024-05-24', '見た目が良い', 4, '0', '見た目が非常に良くて気に入っています。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(25, 3, '2024-05-23', '品質が良い', 5, '0', '品質が非常に良くて満足です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(25, 2, '2024-05-20', '使い勝手が良い', 4, '0', '使い勝手が非常に良いです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(25, 4, '2024-05-21', 'デザインが素敵', 5, '0', 'デザインが素敵で満足です。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(26, 1, '2024-05-18', '価格が手頃', 4, '0', '価格が手頃でコスパが良いです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(26, 3, '2024-05-19', '梱包が丁寧', 5, '0', '梱包が丁寧で安心しました。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(26, 5, '2024-05-23', '発送が迅速', 4, '0', '発送が迅速で助かりました。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(27, 2, '2024-05-16', 'デザインが良い', 5, '0', 'デザインが非常に良くて気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(27, 4, '2024-05-22', '耐久性がある', 4, '0', '耐久性が非常に高くて満足しています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(27, 1, '2024-05-24', '使いやすい', 5, '0', '非常に使いやすくて助かります。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(28, 3, '2024-05-23', '価格が手頃', 4, '0', '価格が手頃でコスパが良いです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(28, 2, '2024-05-20', '梱包が丁寧', 5, '0', '梱包が丁寧で安心しました。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(28, 4, '2024-05-21', '発送が迅速', 4, '0', '発送が迅速で助かりました。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(29, 1, '2024-05-18', 'デザインが良い', 5, '0', 'デザインが非常に良くて気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(29, 3, '2024-05-19', '使い勝手が良い', 4, '0', '使い勝手が非常に良いです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(29, 5, '2024-05-23', '品質が良い', 5, '0', '品質が非常に良くて満足です。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(30, 2, '2024-05-16', '使いやすい', 5, '0', '非常に使いやすくて気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(30, 4, '2024-05-22', 'デザインが素敵', 4, '0', 'デザインが素敵で満足です。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(30, 1, '2024-05-24', '品質が良い', 5, '0', '品質が非常に良くて安心しました。', 0, 0);

INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(31, 3, '2024-05-23', '見た目が高級', 5, '0', '見た目が高級感があって気に入っています。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(31, 2, '2024-05-20', '軽くて便利', 4, '0', '軽くて便利で使いやすいです。', 0, 0);
INSERT INTO reviews(item_id, customer_id, reviewed_on, review_title, review_score, review_image, review_detail, good, bad) VALUES(31, 4, '2024-05-21', '価格がリーズナブル', 4, '0', '価格がリーズナブルでコスパが良いです。', 0, 0);

