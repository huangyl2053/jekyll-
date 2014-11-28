var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoShinryoList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceTeikyoShomeishoShinryoList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceTeikyoShomeishoShinryoList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoShinryoList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoShinryoList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceTeikyoShomeishoShinryoList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgServiceTeikyoShomeishoShinryoList = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceTeikyoShomeishoShinryoList"));
            };
            return Controls;
        })();
        ServiceTeikyoShomeishoShinryoList.Controls = Controls;
    })(DBC.ServiceTeikyoShomeishoShinryoList || (DBC.ServiceTeikyoShomeishoShinryoList = {}));
    var ServiceTeikyoShomeishoShinryoList = DBC.ServiceTeikyoShomeishoShinryoList;
})(DBC || (DBC = {}));
