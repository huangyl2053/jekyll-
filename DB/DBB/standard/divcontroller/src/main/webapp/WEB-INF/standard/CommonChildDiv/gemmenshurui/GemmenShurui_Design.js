var DBB;
(function (DBB) {
    (function (GemmenShurui) {
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
        GemmenShurui.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "GemmenShurui";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBB.GemmenShurui.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBB.GemmenShurui.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.GemmenShurui = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgGemmenShurui = function () {
                return new UZA.DataGrid(this.convFiledName("dgGemmenShurui"));
            };

            Controls.prototype.btnTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            };
            return Controls;
        })();
        GemmenShurui.Controls = Controls;
    })(DBB.GemmenShurui || (DBB.GemmenShurui = {}));
    var GemmenShurui = DBB.GemmenShurui;
})(DBB || (DBB = {}));
