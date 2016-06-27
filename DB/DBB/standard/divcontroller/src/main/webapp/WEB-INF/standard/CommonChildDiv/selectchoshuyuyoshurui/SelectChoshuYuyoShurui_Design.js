var DBB;
(function (DBB) {
    (function (SelectChoshuYuyoShurui) {
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
        SelectChoshuYuyoShurui.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SelectChoshuYuyoShurui";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBB.SelectChoshuYuyoShurui.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBB.SelectChoshuYuyoShurui.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SelectChoshuYuyoShurui = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgYuyoShurui = function () {
                return new UZA.DataGrid(this.convFiledName("dgYuyoShurui"));
            };

            Controls.prototype.btnTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            };
            return Controls;
        })();
        SelectChoshuYuyoShurui.Controls = Controls;
    })(DBB.SelectChoshuYuyoShurui || (DBB.SelectChoshuYuyoShurui = {}));
    var SelectChoshuYuyoShurui = DBB.SelectChoshuYuyoShurui;
})(DBB || (DBB = {}));
