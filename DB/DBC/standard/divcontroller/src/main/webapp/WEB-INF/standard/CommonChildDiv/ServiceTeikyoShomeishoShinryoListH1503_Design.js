var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoShinryoListH1503) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceTeikyoShomeishoShinryoListH1503.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceTeikyoShomeishoShinryoListH1503";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoShinryoListH1503.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoShinryoListH1503.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceTeikyoShomeishoShinryoListH1503 = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgServiceTeikyoShomeishoShinryoListH1503 = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceTeikyoShomeishoShinryoListH1503"));
            };
            return Controls;
        })();
        ServiceTeikyoShomeishoShinryoListH1503.Controls = Controls;
    })(DBC.ServiceTeikyoShomeishoShinryoListH1503 || (DBC.ServiceTeikyoShomeishoShinryoListH1503 = {}));
    var ServiceTeikyoShomeishoShinryoListH1503 = DBC.ServiceTeikyoShomeishoShinryoListH1503;
})(DBC || (DBC = {}));
