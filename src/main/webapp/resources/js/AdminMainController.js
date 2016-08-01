/**
 * 后台管理页控制器
 * Created by Longder on 2016/7/19.
 */
//页面App
var app = angular.module("mainApp", ["ngRoute"]);

//主控制器（页面包括菜单和导航）
app.controller('MainController', function ($scope) {
    //当前视图标识
    $scope.currentPageFlag = 0;
    /**
     * 页面跳转
     * @param flag 视图标识
     */
    $scope.changePage = function (flag) {
        $scope.currentPageFlag = flag;
    }
});
/**
 * Dashboard页控制器
 */
app.controller('DashboardController', function ($scope) {
    $scope.message = "DashBoard！";
});
/**
 * 留言板管理页控制器
 */
app.controller('MessageManageController', function ($scope,$http) {
    //总页数
    $scope.totalPages = null;
    //当前页
    $scope.currentPage = 1;
    //查询条件
    $scope.condition = {
        name: null,
        startTime: null,
        endTime: null,
        hasRead: 3
    };
    /**
     * 监听当前选中节点的变化，触发事件
     */
    $scope.$watch("condition", function () {
        loadMessageList($scope.currentPage);
    },true);

    /**
     * 根据条件和页数加载列表
     */
    var loadMessageList = function(page){
        $http.post("message/loadMessages", {
            "page": page,
            "condition": angular.toJson($scope.condition)
        }).success(function(data){

        });
    };
    /**
     * 清空查询条件点击事件
     */
    $scope.clearCondition = function(){
        $scope.condition = {
            name: null,
            startTime: null,
            endTime: null,
            hasRead: 3
        };
    };


    /**
     * Bootstrap TimePicker
     */
    $(".timePicker").datetimepicker({
        language: 'zh-CN',
        format: 'yyyy-mm-dd hh:ii'
    });
    /**
     * 页面加载完后要执行的方法
     */
    loadMessageList(1);
});
/**
 * 路由配置
 */
app.config(function ($routeProvider) {
    $routeProvider.when("/", {//默认一开始是Dashboard
        templateUrl: "dashboard",
        controller: "DashboardController"
    }).when("/messageManage", {
        templateUrl: "messageManage",
        controller: "MessageManageController"
    });
});
/**
 * json配置
 */
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