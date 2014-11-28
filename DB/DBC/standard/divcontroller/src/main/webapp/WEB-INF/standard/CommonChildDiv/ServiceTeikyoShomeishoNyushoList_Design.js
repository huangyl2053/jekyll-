var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoNyushoList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceTeikyoShomeishoNyushoList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceTeikyoShomeishoNyushoList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoNyushoList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoNyushoList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceTeikyoShomeishoNyushoList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgServiceTeikyoShomeishoNyushoList = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceTeikyoShomeishoNyushoList"));
            };
            return Controls;
        })();
        ServiceTeikyoShomeishoNyushoList.Controls = Controls;
    })(DBC.ServiceTeikyoShomeishoNyushoList || (DBC.ServiceTeikyoShomeishoNyushoList = {}));
    var ServiceTeikyoShomeishoNyushoList = DBC.ServiceTeikyoShomeishoNyushoList;
})(DBC || (DBC = {}));
