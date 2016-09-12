var DBC;
(function (DBC) {
    (function (JukyuIdoKeikakuRirekiList) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        JukyuIdoKeikakuRirekiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JukyuIdoKeikakuRirekiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.JukyuIdoKeikakuRirekiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.JukyuIdoKeikakuRirekiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JukyuIdoKeikakuRirekiList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.pnlKyotakuKeikaku = function () {
                return new UZA.Panel(this.convFiledName("pnlKyotakuKeikaku"));
            };

            Controls.prototype.dgKyotakuKeikaku = function () {
                return new UZA.DataGrid(this.convFiledName("dgKyotakuKeikaku"));
            };

            Controls.prototype.pnlButton = function () {
                return new UZA.Panel(this.convFiledName("pnlButton"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        JukyuIdoKeikakuRirekiList.Controls = Controls;
    })(DBC.JukyuIdoKeikakuRirekiList || (DBC.JukyuIdoKeikakuRirekiList = {}));
    var JukyuIdoKeikakuRirekiList = DBC.JukyuIdoKeikakuRirekiList;
})(DBC || (DBC = {}));
