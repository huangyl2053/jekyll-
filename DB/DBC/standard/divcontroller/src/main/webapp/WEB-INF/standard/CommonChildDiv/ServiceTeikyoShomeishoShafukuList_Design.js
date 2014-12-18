var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoShafukuList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceTeikyoShomeishoShafukuList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceTeikyoShomeishoShafukuList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoShafukuList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoShafukuList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceTeikyoShomeishoShafukuList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgServiceTeikyoShomeishoShafukuList = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceTeikyoShomeishoShafukuList"));
            };
            return Controls;
        })();
        ServiceTeikyoShomeishoShafukuList.Controls = Controls;
    })(DBC.ServiceTeikyoShomeishoShafukuList || (DBC.ServiceTeikyoShomeishoShafukuList = {}));
    var ServiceTeikyoShomeishoShafukuList = DBC.ServiceTeikyoShomeishoShafukuList;
})(DBC || (DBC = {}));
