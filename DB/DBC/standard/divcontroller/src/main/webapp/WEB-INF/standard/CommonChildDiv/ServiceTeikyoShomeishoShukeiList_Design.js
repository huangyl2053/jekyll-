var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoShukeiList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceTeikyoShomeishoShukeiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceTeikyoShomeishoShukeiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoShukeiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoShukeiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceTeikyoShomeishoShukeiList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgServiceTeikyoShomeishoShukeiList = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceTeikyoShomeishoShukeiList"));
            };
            return Controls;
        })();
        ServiceTeikyoShomeishoShukeiList.Controls = Controls;
    })(DBC.ServiceTeikyoShomeishoShukeiList || (DBC.ServiceTeikyoShomeishoShukeiList = {}));
    var ServiceTeikyoShomeishoShukeiList = DBC.ServiceTeikyoShomeishoShukeiList;
})(DBC || (DBC = {}));
