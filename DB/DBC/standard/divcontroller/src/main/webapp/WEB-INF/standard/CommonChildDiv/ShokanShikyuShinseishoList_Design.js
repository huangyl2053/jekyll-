var DBC;
(function (DBC) {
    (function (ShokanShikyuShinseishoList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShokanShikyuShinseishoList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShokanShikyuShinseishoList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ShokanShikyuShinseishoList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ShokanShikyuShinseishoList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShokanShikyuShinseishoList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgShokanShikyuShinseishoList = function () {
                return new UZA.DataGrid(this.convFiledName("dgShokanShikyuShinseishoList"));
            };
            return Controls;
        })();
        ShokanShikyuShinseishoList.Controls = Controls;
    })(DBC.ShokanShikyuShinseishoList || (DBC.ShokanShikyuShinseishoList = {}));
    var ShokanShikyuShinseishoList = DBC.ShokanShikyuShinseishoList;
})(DBC || (DBC = {}));
