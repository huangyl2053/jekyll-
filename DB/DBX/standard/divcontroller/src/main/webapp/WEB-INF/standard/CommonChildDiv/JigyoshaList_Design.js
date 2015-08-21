var DBX;
(function (DBX) {
    (function (JigyoshaList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        JigyoshaList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JigyoshaList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBX.JigyoshaList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBX.JigyoshaList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JigyoshaList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.dgJigyoshaList = function () {
                return new UZA.DataGrid(this.convFiledName("dgJigyoshaList"));
            };
            return Controls;
        })();
        JigyoshaList.Controls = Controls;
    })(DBX.JigyoshaList || (DBX.JigyoshaList = {}));
    var JigyoshaList = DBX.JigyoshaList;
})(DBX || (DBX = {}));
