var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoKeikakuList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceTeikyoShomeishoKeikakuList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceTeikyoShomeishoKeikakuList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoKeikakuList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoKeikakuList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceTeikyoShomeishoKeikakuList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgShokanShikyuTorokuShomeishoKeikakuList = function () {
                return new UZA.DataGrid(this.convFiledName("dgShokanShikyuTorokuShomeishoKeikakuList"));
            };
            return Controls;
        })();
        ServiceTeikyoShomeishoKeikakuList.Controls = Controls;
    })(DBC.ServiceTeikyoShomeishoKeikakuList || (DBC.ServiceTeikyoShomeishoKeikakuList = {}));
    var ServiceTeikyoShomeishoKeikakuList = DBC.ServiceTeikyoShomeishoKeikakuList;
})(DBC || (DBC = {}));
