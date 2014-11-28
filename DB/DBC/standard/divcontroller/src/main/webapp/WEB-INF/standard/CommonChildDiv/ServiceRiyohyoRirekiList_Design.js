var DBC;
(function (DBC) {
    (function (ServiceRiyohyoRirekiList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceRiyohyoRirekiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceRiyohyoRirekiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ServiceRiyohyoRirekiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ServiceRiyohyoRirekiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceRiyohyoRirekiList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgServiceRiyohyoRirekiList = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceRiyohyoRirekiList"));
            };
            return Controls;
        })();
        ServiceRiyohyoRirekiList.Controls = Controls;
    })(DBC.ServiceRiyohyoRirekiList || (DBC.ServiceRiyohyoRirekiList = {}));
    var ServiceRiyohyoRirekiList = DBC.ServiceRiyohyoRirekiList;
})(DBC || (DBC = {}));
