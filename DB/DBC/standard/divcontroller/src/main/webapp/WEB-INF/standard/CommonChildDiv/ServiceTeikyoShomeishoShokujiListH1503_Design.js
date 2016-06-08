var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoShokujiListH1503) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceTeikyoShomeishoShokujiListH1503.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceTeikyoShomeishoShokujiListH1503";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoShokujiListH1503.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoShokujiListH1503.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceTeikyoShomeishoShokujiListH1503 = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgServiceTeikyoShomeishoShokujiListH1503 = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceTeikyoShomeishoShokujiListH1503"));
            };
            return Controls;
        })();
        ServiceTeikyoShomeishoShokujiListH1503.Controls = Controls;
    })(DBC.ServiceTeikyoShomeishoShokujiListH1503 || (DBC.ServiceTeikyoShomeishoShokujiListH1503 = {}));
    var ServiceTeikyoShomeishoShokujiListH1503 = DBC.ServiceTeikyoShomeishoShokujiListH1503;
})(DBC || (DBC = {}));
