var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoMeisaiList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceTeikyoShomeishoMeisaiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceTeikyoShomeishoMeisaiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoMeisaiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoMeisaiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceTeikyoShomeishoMeisaiList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgServiceTeikyoShomeishoMeisaiList = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceTeikyoShomeishoMeisaiList"));
            };
            return Controls;
        })();
        ServiceTeikyoShomeishoMeisaiList.Controls = Controls;
    })(DBC.ServiceTeikyoShomeishoMeisaiList || (DBC.ServiceTeikyoShomeishoMeisaiList = {}));
    var ServiceTeikyoShomeishoMeisaiList = DBC.ServiceTeikyoShomeishoMeisaiList;
})(DBC || (DBC = {}));
