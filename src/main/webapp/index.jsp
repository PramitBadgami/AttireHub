<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>AttireHub-Home</title>
	<link rel="stylesheet" type="text/css" href="styles/style.css">
	<style>
	
	.errorMessageOverlay{
		background-color: rgba(0,0,0,0.5);
		width: 100%;
		height: 100vh;
		position: fixed;
		top: 0; 
		opacity: 1;
		z-index: 1;
		transition: 0.5s
	}
	
	.errorMessageOverlayRemove{
		opacity: 0;
		z-index: -1;
	}
	
	.errorMessage{
		background-color:  rgb(142, 108, 53);
		position: absolute;
		top:50%;
		left: 50%;
		transform: translate(-50%,-50%);
		padding: 20px;
		border-radius: 9px;
		z-index: 2; 
		display: flex;
		align-items: center;
		justify-content: center;
		flex-direction: column;
		box-shadow: 0 0 10px rgba(0,0,0,0.3);
	}
		
	.errorMessage button{
		margin-top:10px;
		padding: 10px;
		border-radius: 5px;
		border: none;
		background-color: #9b4f96;
		color: #fff;
		cursor: pointer;
		width: 80%;
		font-size: 16px;
		margin-bottom: 10px;
			
	}
	.errorMessageRemove{
		display:  none;
	}
		
	</style>
</head>
<body>
    <header>
        <nav>
            <div class="nav-logo">
                <!-- logo -->
                <img src="images/logo.png" alt="Logo" class="nav-logo">

            </div>

            <ul>
                <!-- navbar -->
                <li><a href="#">Home</a></li>
                <li><a href="#">Products</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>

            <div class="buttons">
                <!-- login/register buttons -->
                <button onclick="showLoginForm()">Sign In</button>
                <button onclick="showRegisterForm()">Sign Up</button>

            </div>
            

            <div class="user-id">
                <!-- if already logged in  than user details -->
            </div>
        </nav>
    </header>


	<div class="container">
        <li>Home</li>

    </div>
    <footer></footer>


    <div class="overlay" onclick="removeModal()"></div>
    
    <!-- <%String errorMessage = (String) request.getAttribute("errorMessage"); %> -->
    <%if(errorMessage != null){ %>
    	<div  class = "errorMessageOverlay"></div>
		<div class = "errorMessage">
		<img alt="error icon" src="./images/error_icon.png"><br>
		<%= errorMessage %>
		<br>
		<button onclick="removeInvalidModal()">Okay</button>
		
		</div>
	<%} %>
    <div class="login-box" id = "login-box">
        <img src="./images/logo.png" class="logo">
        <h2>Login to Your Account</h2>
        <form action = "LoginServlet" method = "post">
            <label for="email">Email</label>
            <input type="text" name="email" id="email" required>

            <label for="password">Password</label>
            <div class="password-field">
                <input type="password" name="password" id="password" required>

                <div class="hidden-view" onclick="viewPassword()">
                    <img  class="hide-pw-gogs" src="images/hidden.png" alt="password hide">
                    <img class="hide-pw-face" src="images/view.png" alt="password logo">
                </div>
            </div>


            <input type="submit" value="Login">
            <a href="#">Forgot Password?</a>
            <p>Don't have an account? <a href="#" onclick="showRegisterForm()()">Register here</a></p>
        </form>
        
    </div>

	
    <div class="register-box" id="register-box"> 
        <div class="flexbox">
            <img src="images/logo.png" class="logo">
            <form action="RegisterServlet" method = "post" enctype = "multipart/form-data">
                <h2>Register Your Account</h2>
                <label for="image">Upload Photo</label>
                <input type="file" name="image" id="image" required>

                <div class="register-col">
                    <div class="register-row">
                        <label for="fname">First Name</label>
                        <input type="text" name="fname" id="fname" required>
                    </div>

                    <div class="register-row">
                        <label for="lname">Last Name</label>
                        <input type="text" name="lname" id="lname" required>
                    </div>

                </div>

                <div class="register-col">
                    <div class="register-row">
                        <label for="dob">Date of Birth</label>
                        <input type="date" name="dob" id="dob" required>
                    </div>

                    <div class="register-row">
                        <label for="gender">Gender</label>
                        <div class="radio-btn">
                            <input type="radio" name="gender" id="gender" value="male" checked ><label for="male">Male</label>
                            <input type="radio" name="gender" id="gender" value="female" required ><label for="female">Female</label>
                            <input type="radio" name="gender" id="gender" value="other" required ><label for="other">Other</label>
                        </div>
                    </div>

                </div>

                <div class="register-col">
                    <div class="register-row">
                        <label for="register-email">Email</label>
                        <input type="text" name="register-email" id="register-email" required>
                    </div>
                    <div class="register-row">
                        <label for="register-phone">Phone Number</label>
                        <input type="text" name="register-phone" id="register-phone" required>
                    </div>
                </div>

                <div class="register-col">
                    <div class="register-row">
                        <label for="register-password">Password</label>
                        <input type="password" name="register-password" id="register-password" required>
                    </div>
                    <div class="register-row">
                        <label for="confirm-password">Confirm Password</label>
                        <input type="password" name="confirm-password" id="confirm-password" required>
                    </div>
                </div>

                

                <input type="submit" value="Register">
                <p>Already have an account? <a href="#" onclick="showLoginForm()">Login</a></p>
            </form>
        </div>
    </div>
    <script>
        function showLoginForm(){
            document.querySelector(".register-box").classList.remove("showRegister");
            document.querySelector(".overlay").classList.remove("showOverlay");

            document.querySelector(".login-box").classList.add("showLogin");
            document.querySelector(".overlay").classList.add("showOverlay");

        }

        function showRegisterForm(){
            document.querySelector(".login-box").classList.remove("showLogin");
            document.querySelector(".overlay").classList.remove("showOverlay");

            document.querySelector(".register-box").classList.add("showRegister");
            document.querySelector(".overlay").classList.add("showOverlay");
        }

        function removeModal(){
            document.querySelector(".login-box").classList.remove("showLogin");
            document.querySelector(".overlay").classList.remove("showOverlay");
            document.querySelector(".register-box").classList.remove("showRegister");
        }

        var hidden = true
        function viewPassword(){
            if(hidden){
                document.querySelector(".hide-pw-gogs").classList.add("slide-gogs");
                document.getElementById("password").setAttribute('type','text');
                hidden = false
            }else{
                document.querySelector(".hide-pw-gogs").classList.remove("slide-gogs");
                document.getElementById("password").setAttribute('type','password');
                hidden = true
            }
            
        }
        
        function removeInvalidModal(){
        	 document.querySelector(".errorMessage").classList.add("errorMessageRemove");
        	 document.querySelector(".errorMessageOverlay").classList.add("errorMessageOverlayRemove");
        }
    </script>
</body>
</html>