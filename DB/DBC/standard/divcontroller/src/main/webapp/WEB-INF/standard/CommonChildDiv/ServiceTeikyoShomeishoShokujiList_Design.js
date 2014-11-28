var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoShokujiList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceTeikyoShomeishoShokujiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceTeikyoShomeishoShokujiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoShokujiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoShokujiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceTeikyoShomeishoShokujiList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgServiceTeikyoShomeishoShokujiList = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceTeikyoShomeishoShokujiList"));
            };
            return Controls;
        })();
        ServiceTeikyoShomeishoShokujiList.Controls = Controls;
    })(DBC.ServiceTeikyoShomeishoShokujiList || (DBC.ServiceTeikyoShomeishoShokujiList = {}));
    var ServiceTeikyoShomeishoShokujiList = DBC.ServiceTeikyoShomeishoShokujiList;
})(DBC || (DBC = {}));
