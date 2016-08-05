var DBC;
(function (DBC) {
    (function (KyufuseigenRirekiList) {
        var Events = (function () {
            function Events() {
            }
            Events.onClose = function () {
                return "onClose";
            };
            return Events;
        })();
        KyufuseigenRirekiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KyufuseigenRirekiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.KyufuseigenRirekiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.KyufuseigenRirekiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KyufuseigenRirekiList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.pnlKyufuseigen = function () {
                return new UZA.Panel(this.convFiledName("pnlKyufuseigen"));
            };

            Controls.prototype.dgKyufuseigenRirekiList = function () {
                return new UZA.DataGrid(this.convFiledName("dgKyufuseigenRirekiList"));
            };

            Controls.prototype.pnlButton = function () {
                return new UZA.Panel(this.convFiledName("pnlButton"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        KyufuseigenRirekiList.Controls = Controls;
    })(DBC.KyufuseigenRirekiList || (DBC.KyufuseigenRirekiList = {}));
    var KyufuseigenRirekiList = DBC.KyufuseigenRirekiList;
})(DBC || (DBC = {}));
