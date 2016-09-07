var DBC;
(function (DBC) {
    (function (ShuruiGendoInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        ShuruiGendoInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShuruiGendoInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ShuruiGendoInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ShuruiGendoInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShuruiGendoInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgGendoInfo = function () {
                return new UZA.DataGrid(this.convFiledName("dgGendoInfo"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        ShuruiGendoInfo.Controls = Controls;
    })(DBC.ShuruiGendoInfo || (DBC.ShuruiGendoInfo = {}));
    var ShuruiGendoInfo = DBC.ShuruiGendoInfo;
})(DBC || (DBC = {}));
