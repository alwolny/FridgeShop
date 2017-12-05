insert into shop.user_role(id, role, description) VALUES (1, 'ROLE_USER', 'user');
insert into shop.user_role(id, role, description) VALUES (2, 'ROLE_ADMIN', 'admin');
insert into shop.shopping_carts(cart_id) VALUES (-2);
insert into shop.users(user_id, email, last_name, passwort, active) VALUES (-1, 'admin@o2.pl', 'admin', '$2a$10$VpxT7HGNvFeslPj23CK0w.s3ncAYVrZM1UCA4ueR8RWBH52sPGMRm', 1);
insert into shop.users(user_id, email, last_name, passwort, cart_cart_id, active) VALUES (-2, 'jankowalski@o2.pl', 'kowalski', '$2a$10$2CZyFoEiIlvgTjM4EiBm4Omj5zwdb/9qAbhYL.dlmcH0Eaf4LAGj2', -2, 1);
insert into shop.users_roles(user_user_id, roles_id) VALUES (-1, 2);
insert into shop.users_roles(user_user_id, roles_id) VALUES (-2, 1);


 insert into shop.products (units_in_order, units_in_stock, brand, category, discontinued, image, manufacturer, name, prod_condition, unit_price) values (0, 200, 'Samsung', 'fridge', false, null, 'Samsung', 'Samsung RB33', null, 1900);
 insert into shop.products (units_in_order, units_in_stock, brand, category, discontinued, image, manufacturer, name, prod_condition, unit_price) values (0, 200, 'Liebherr', 'cabinet', false, null, 'LIEBHERR', 'Liebherr W2', null, 890);
 insert into shop.products (units_in_order, units_in_stock, brand, category, discontinued, image, manufacturer, name, prod_condition, unit_price) values (0, 200, 'Campignaz', 'coolerbox', false, null, 'CAMPINGAZ', 'Campignaz Icetime', null, 1200);
 insert into shop.products (units_in_order, units_in_stock, brand, category, discontinued, image, manufacturer, name, prod_condition, unit_price) values (0, 200, 'Beko', 'refrigerator', false, null, 'Beko', 'Beko HSA295', null, 1099);
 insert into shop.products (units_in_order, units_in_stock, brand, category, discontinued, image, manufacturer, name, prod_condition, unit_price) values (0, 200, 'Samsung', 'accessory', false, null, 'Samsung', 'Filtr do wody', null, 35);