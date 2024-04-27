<html>
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
    flex-direction: column;
    width: 100vw;
    background: url('https://www.pixel4k.com/wp-content/uploads/2020/10/peaceful-lake-minimal-4k_1603396138.jpg.webp') no-repeat;
    background-size: cover;
    background-position: center;
}
h1{
    color: white;
    font-size: 5em;
    margin-block: 50px;
    text-shadow: 0 0 30px rgba(0,0,0,0.4);
}
form{
    display: flex;
}
input{
    width: 300px;
    padding: 12px;
    margin: 20px;
    border-radius: 5px;
    border: none;
    font-size: 1em;
    background-color: #FEECE2;
    box-shadow: 0 0 50px rgba(0,0,0,0.4);
}
input:hover{
    background-color: #FC819E;
    cursor: pointer;
}
</style>
<body>
<h1>Welcome To the Page</h1>
<form action="CRUD" method="post">
    <input type="submit" name="register" value="Register" />
    <br/>
    <input type="submit" name="show" value="Show all" />
    
</form>
</body>
</html>
