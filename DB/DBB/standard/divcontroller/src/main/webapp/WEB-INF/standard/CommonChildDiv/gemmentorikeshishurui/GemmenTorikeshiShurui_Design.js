var DBB;
(function (DBB) {
    (function (GemmenTorikeshiShurui) {
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
        GemmenTorikeshiShurui.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "GemmenTorikeshiShurui";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBB.GemmenTorikeshiShurui.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBB.GemmenTorikeshiShurui.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.GemmenTorikeshiShurui = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgGemmenTorikeshiShurui = function () {
                return new UZA.DataGrid(this.convFiledName("dgGemmenTorikeshiShurui"));
            };

            Controls.prototype.btnTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            };
            return Controls;
        })();
        GemmenTorikeshiShurui.Controls = Controls;
    })(DBB.GemmenTorikeshiShurui || (DBB.GemmenTorikeshiShurui = {}));
    var GemmenTorikeshiShurui = DBB.GemmenTorikeshiShurui;
})(DBB || (DBB = {}));
