var DBB;
(function (DBB) {
    (function (SelectTorikeshiShurui) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnSelect = function () {
                return "onClick_btnSelect";
            };

            Events.onClick_btnCancel = function () {
                return "onClick_btnCancel";
            };
            return Events;
        })();
        SelectTorikeshiShurui.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SelectTorikeshiShurui";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBB.SelectTorikeshiShurui.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBB.SelectTorikeshiShurui.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SelectTorikeshiShurui = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgTorikeshiShurui = function () {
                return new UZA.DataGrid(this.convFiledName("dgTorikeshiShurui"));
            };

            Controls.prototype.btnTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            };
            return Controls;
        })();
        SelectTorikeshiShurui.Controls = Controls;
    })(DBB.SelectTorikeshiShurui || (DBB.SelectTorikeshiShurui = {}));
    var SelectTorikeshiShurui = DBB.SelectTorikeshiShurui;
})(DBB || (DBB = {}));
