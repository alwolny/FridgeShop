insert into shop.user_role(id, role, description) VALUES (1, 'ROLE_USER', 'user');
insert into shop.user_role(id, role, description) VALUES (2, 'ROLE_ADMIN', 'admin');
insert into shop.shopping_carts(cart_id) VALUES (-2);
insert into shop.users(user_id, email, last_name, passwort) VALUES (-1, 'admin@o2.pl', 'admin', 'admin');
insert into shop.users(user_id, email, last_name, passwort, cart_cart_id) VALUES (-2, 'jankowalski@o2.pl', 'kowalski', 'jan', -2);
insert into shop.users_roles(user_user_id, roles_id) VALUES (-1, 2);
insert into shop.users_roles(user_user_id, roles_id) VALUES (-2, 1);


 insert into shop.products (units_in_order, units_in_stock, brand, category, description, discontinued, image, manufacturer, name, prod_condition, unit_price) values (0, 200, 'Bosch', 'fridge', 'description', false, null, 'Bosch', 'ip340', null, 3400);
 insert into shop.products (units_in_order, units_in_stock, brand, category, description, discontinued, image, manufacturer, name, prod_condition, unit_price) values (0, 200, 'Samsung', 'cabinet', 'description', false, null, 'Samsung', 'i25', null, 4500);
 insert into shop.products (units_in_order, units_in_stock, brand, category, description, discontinued, image, manufacturer, name, prod_condition, unit_price) values (0, 200, 'Bosch', 'coolerbox', 'description', false, null, 'Bosch', 'i40', null, 1200);
 insert into shop.products (units_in_order, units_in_stock, brand, category, description, discontinued, image, manufacturer, name, prod_condition, unit_price) values (0, 200, 'Samsung', 'refrigerator', 'desc', false, null, 'Samsung', 'i30', null, 6500);
 insert into shop.products (units_in_order, units_in_stock, brand, category, description, discontinued, image, manufacturer, name, prod_condition, unit_price) values (0, 200, 'Bosch', 'accessory', 'desc', false, null, 'Bosch', 'i50', null, 2800);