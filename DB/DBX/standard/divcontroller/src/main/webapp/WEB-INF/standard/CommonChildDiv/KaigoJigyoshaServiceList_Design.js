var DBX;
(function (DBX) {
    (function (KaigoJigyoshaServiceList) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnSettle = function () {
                return "onClick_btnSettle";
            };

            Events.onClick_btnCancel = function () {
                return "onClick_btnCancel";
            };
            return Events;
        })();
        KaigoJigyoshaServiceList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoJigyoshaServiceList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBX.KaigoJigyoshaServiceList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBX.KaigoJigyoshaServiceList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoJigyoshaServiceList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgKaigoJigyoshaService = function () {
                return new UZA.DataGrid(this.convFiledName("dgKaigoJigyoshaService"));
            };

            Controls.prototype.btnSet = function () {
                return new UZA.Button(this.convFiledName("btnSet"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        KaigoJigyoshaServiceList.Controls = Controls;
    })(DBX.KaigoJigyoshaServiceList || (DBX.KaigoJigyoshaServiceList = {}));
    var KaigoJigyoshaServiceList = DBX.KaigoJigyoshaServiceList;
})(DBX || (DBX = {}));
