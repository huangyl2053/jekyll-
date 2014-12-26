var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceTeikyoShomeishoList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceTeikyoShomeishoList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceTeikyoShomeishoList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgServiceTeikyoShomeishoList = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceTeikyoShomeishoList"));
            };
            return Controls;
        })();
        ServiceTeikyoShomeishoList.Controls = Controls;
    })(DBC.ServiceTeikyoShomeishoList || (DBC.ServiceTeikyoShomeishoList = {}));
    var ServiceTeikyoShomeishoList = DBC.ServiceTeikyoShomeishoList;
})(DBC || (DBC = {}));
