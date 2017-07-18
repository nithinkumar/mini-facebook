

<#macro page>
<html>
  <head>
  </head>
  <body>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/page.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <script  type="text/javascript" src="/js/index.js"></script>
    <div class="container">
      <div class="row">
        <div class="col-md-6 col-lg-6">
          Some Image
        </div>
        <div class="col-md-6 col-lg-6">
          <div class="header row">
            <div class="col-md-6 col-lg-6 no-padding">
              <button class="btn btn-default full-width">Sign Up</button>
            </div>
            <div class="col-md-6 col-lg-6 no-padding">
              <button class="btn btn-default full-width">Login</button>
            </div>
          </div>
          <div class="signUpFormDiv">
            <div class="col-md-12 col-lg-12 no-padding">
                <@formCreator gridWidth=1 id="signUpForm"
                  columns=[
                  	{"name":"name", "label":"Name", "attrMap":{"required":"required"}},
                  	{"name":"phone", "label":"Phone", "type":"tel", "attrMap":{"pattern":"[0-9]{10}","required":"required"}},
                  	{"name":"email", "label":"Email", "type":"email", "attrMap":{"required":"required"}}
                    {"name":"password", "label":"Password", "type":"password", "attrMap":{"required":"required"}}
                  ]
                  buttons = [{"class":"btn,btn-sm,btn-default", "id":"signUpBtn", "name":"Sign Up"}] />
            </div>
          </div>
          <div class="loginFormDiv hide">
            <div class="col-md-12 col-lg-12 no-padding">
                <@formCreator gridWidth=1 id="signUpForm"
                  columns=[
                    {"name":"email", "label":"Email", "type":"email", "attrMap":{"required":"required"}}
                    {"name":"password", "label":"Password", "type":"password", "attrMap":{"required":"required"}}
                  ]
                  buttons = [{"class":"btn,btn-sm,btn-default,loginBtn", "id":"loginBtn", "name":"Login"}] />
            </div>
          </div>
        </div>
      </div>
    </div>
    <#nested/>
  </body>
</html>
</#macro>
