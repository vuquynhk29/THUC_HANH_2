# THUC_HANH_2
 # Các thành viên: Phạm Tường Thụy, Vũ Thị Quỳnh, Trần Đình Hoan
# Mô tả:
   - Kết nối project với CSDL trên MySQL
   - Tạo lớp thực thể tương ứng với table CSDL
   - Sử dụng Spring Data JDBC tạo repository (productDB)
   - Viết các lớp Controller và trang view(html)

# Phân chia công việc:
  - Phạm Tường Thụy: Làm 2 chức năng xem và thêm product gồm các Controller: ViewProducts, AddProductController, HomeController, các trang html: home, addProduct displayProducts;
  - Vũ Thị Quỳnh : Làm chức năng edit product gồm Controller: EditController và trang html: edit
  - Trần Đình Hoan: Làm chức năng remove product gồm Controller: RemoveController và trang html: remove
  - Mỗi người tự viết Repository trong file ProductDB để cập nhật kết quả trên csdl
  - Tất cả thành viên đều chạy thử và chỉnh sửa
# Kết nối với CSDL trong MySql:
   - Tạo một database mới với tên là products
   - Mở file application.properties và viết các dòng sau:
spring.datasource.url = jdbc:mysql://localhost:3306/products
spring.datasource.username = tài khoản
spring.datasource.password = mật khẩu

