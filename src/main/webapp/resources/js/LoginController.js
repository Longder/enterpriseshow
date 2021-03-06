/**
 * 登陆页面Angular控制器
 * Created by Longder on 2016/7/18.
 */
//页面App
var app = angular.module("loginApp", []);
//配置json
app.config(function ($httpProvider) {
    $httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
    $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

    // Override $http service's default transformRequest
    $httpProvider.defaults.transformRequest = [function (data) {
        /**
         * The workhorse; converts an object to x-www-form-urlencoded serialization.
         * @param {Object} obj
         * @return {String}
         */
        var param = function (obj) {
            var query = '';
            var name, value, fullSubName, subName, subValue, innerObj, i;

            for (name in obj) {
                value = obj[name];

                if (value instanceof Array) {
                    for (i = 0; i < value.length; ++i) {
                        subValue = value[i];
                        fullSubName = name + '[' + i + ']';
                        innerObj = {};
                        innerObj[fullSubName] = subValue;
                        query += param(innerObj) + '&';
                    }
                } else if (value instanceof Object) {
                    for (subName in value) {
                        subValue = value[subName];
                        fullSubName = name + '[' + subName + ']';
                        innerObj = {};
                        innerObj[fullSubName] = subValue;
                        query += param(innerObj) + '&';
                    }
                } else if (value !== undefined && value !== null) {
                    query += encodeURIComponent(name) + '='
                        + encodeURIComponent(value) + '&';
                }
            }

            return query.length ? query.substr(0, query.length - 1) : query;
        };

        return angular.isObject(data) && String(data) !== '[object File]'
            ? param(data)
            : data;
    }];
});
//页面控制器
app.controller('LoginController', function ($scope, $http){
    //登录用户实体
    $scope.user = null;
    //错误信息
    $scope.message = null;
    $scope.login = function(valid,error){
        //验证成功则发送Ajax请求进行登录
        if(valid){
            $http({
                method: 'POST',
                url: 'user/login',
                data: {
                    "userInfo":angular.toJson($scope.user)
                }
            }).success(function(data){
                if(data.status==0){
                    //登录成功进入主页面
                    window.location.href = "admin/main";
                }else{
                    $scope.message = data.message;
                }
            });
        }else{
            if(error.required[0].$name=="loginName"){
                alert("请填写用户名");
                return;
            }
            if(error.required[0].$name=="password"){
                alert("请填写密码");
                return;
            }
        }
    };
});