<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.hadrian.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<style>
/* https://i.pinimg.com/originals/db/7c/fd/db7cfdbdc0664e77262aa0856b5d8883.jpg */
/* https://img.freepik.com/free-photo/painting-mountain-lake-with-mountain-background_188544-9126.jpg?size=626&ext=jpg&ga=GA1.1.34264412.1713052800&semt=ais */
/* https://cdn.wallpapersafari.com/87/43/FMqPpX.jpg */
/* https://www.pixel4k.com/wp-content/uploads/2020/10/peaceful-lake-minimal-4k_1603396138.jpg.webp */
/* https://wallpaper.dog/large/5516281.jpg */
@import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');
*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: "Poppins", sans-serif;
}
body{
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100vw;
    height: 100vh;
    background: url('https://www.pixel4k.com/wp-content/uploads/2020/10/peaceful-lake-minimal-4k_1603396138.jpg.webp') no-repeat;
    background-size: cover;
    background-position: center;
}
.wrapper{
    width: 420px;
    background: transparent;
    border: 2px solid rgba(255, 255, 255, .2);
    backdrop-filter: blur(30px);
    box-shadow: 0 0 10px rgba(0, 0, 0, .4);
    color: white;
    border-radius: 10px;
    padding: 30px 40px;
}
.wrapper h1{
    font-size: 36px;
    text-align: center;
}
input{
    width: 100%;
    height: 50px;
    background: rgba(0,0,0,0.1);
    border: none;
    outline: none;
    border-radius: 40px;
    font-size: 14px;
    color: white;
    padding: 15px;
    margin: 15px 0;
    box-shadow: inset -1px 2px 5px rgba(0,0,0,0.4),
                2px 2px rgba(255,255,255,0.3);
}
input::placeholder{
    color: white;
}

button{
    width: 100%;
    height: 45px;
    background: white;
    border: none;
    outline: none;
    border-radius: 40px;
    cursor: pointer;
    font-size: 14px;
    color: black;
}
button:hover{
    background-color: #FC819E;
    color: black;
}
</style>
</head>
<body>

     <div class="wrapper">
       <form action="reg" method="post">
        <h1>Register</h1>
            <input type="number" placeholder="id" name="inpId" hidden>

            <input type="text" placeholder="Username" name="inpName" autocomplete="none">

            <input type=email placeholder="Email id" name="inpEmail" autocomplete="none">

            <input type="tel" placeholder="Mobile number" name="inpMobile" autocomplete="none" >
 
            <input type="password" placeholder="Password" name="inpPass" autocomplete="none">
            
        <button type="submit">submit</button>
       </form>
   </div>
	
</body>
</html>