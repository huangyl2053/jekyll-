var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoRyoyoList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceTeikyoShomeishoRyoyoList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceTeikyoShomeishoRyoyoList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoRyoyoList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoRyoyoList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceTeikyoShomeishoRyoyoList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgServiceTeikyoShomeishoRyoyoList = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceTeikyoShomeishoRyoyoList"));
            };
            return Controls;
        })();
        ServiceTeikyoShomeishoRyoyoList.Controls = Controls;
    })(DBC.ServiceTeikyoShomeishoRyoyoList || (DBC.ServiceTeikyoShomeishoRyoyoList = {}));
    var ServiceTeikyoShomeishoRyoyoList = DBC.ServiceTeikyoShomeishoRyoyoList;
})(DBC || (DBC = {}));
