var xxx;
(function (xxx) {
    (function (CommonChildDivDummy) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        CommonChildDivDummy.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "CommonChildDivDummy";
                },
                enumerable: true,
                configurable: true
            });

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        CommonChildDivDummy.Controls = Controls;
    })(xxx.CommonChildDivDummy || (xxx.CommonChildDivDummy = {}));
    var CommonChildDivDummy = xxx.CommonChildDivDummy;

    var CommonChildDivDummy_Design = (function () {
        function CommonChildDivDummy_Design() {
        }
        CommonChildDivDummy_Design.myLayout = {};
        return CommonChildDivDummy_Design;
    })();
    xxx.CommonChildDivDummy_Design = CommonChildDivDummy_Design;
})(xxx || (xxx = {}));
var xxx;
(function (xxx) {
    (function (CommonChildDivDummy) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.controls = new CommonChildDivDummy.Controls(fieldName);
            }
            return ModeController;
        })();
        CommonChildDivDummy.ModeController = ModeController;
    })(xxx.CommonChildDivDummy || (xxx.CommonChildDivDummy = {}));
    var CommonChildDivDummy = xxx.CommonChildDivDummy;
})(xxx || (xxx = {}));
