USE heroku_cc1579a21c316f1;

CREATE TABLE IF NOT EXISTS heroku_cc1579a21c316f1.users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  active tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS heroku_cc1579a21c316f1.shopping_lists(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  color VARCHAR(45) NOT NULL,
  created_utc TIMESTAMP NOT NULL,
  modified_utc TIMESTAMP NOT NULL,
  PRIMARY KEY (id));
  
CREATE TABLE IF NOT EXISTS heroku_cc1579a21c316f1.shopping_list_items (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  shopping_list_id INT NOT NULL,
  contents VARCHAR(100) NOT NULL,
  priority INT UNSIGNED NOT NULL,
  is_checked tinyint(1) NOT NULL DEFAULT 1,
  created_utc TIMESTAMP NOT NULL,
  modified_utc TIMESTAMP NOT NULL,
  PRIMARY KEY (id));
  
CREATE TABLE IF NOT EXISTS heroku_cc1579a21c316f1.notes (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  shopping_list_item_id INT NOT NULL,
  body VARCHAR(250) NOT NULL,
  created_utc TIMESTAMP NOT NULL,
  modified_utc TIMESTAMP NOT NULL,
  PRIMARY KEY (id));
  