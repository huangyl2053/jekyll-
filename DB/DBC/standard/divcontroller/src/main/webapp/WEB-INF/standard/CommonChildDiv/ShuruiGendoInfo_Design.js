var DBC;
(function (DBC) {
    (function (ShuruiGendoInfoCommonChildDiv) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShuruiGendoInfoCommonChildDiv.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShuruiGendoInfoCommonChildDiv";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ShuruiGendoInfoCommonChildDiv.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ShuruiGendoInfoCommonChildDiv.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShuruiGendoInfoCommonChildDiv = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgGendoInfo = function () {
                return new UZA.DataGrid(this.convFiledName("dgGendoInfo"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };

            Controls.prototype.Button1 = function () {
                return new UZA.Button(this.convFiledName("Button1"));
            };
            return Controls;
        })();
        ShuruiGendoInfoCommonChildDiv.Controls = Controls;
    })(DBC.ShuruiGendoInfoCommonChildDiv || (DBC.ShuruiGendoInfoCommonChildDiv = {}));
    var ShuruiGendoInfoCommonChildDiv = DBC.ShuruiGendoInfoCommonChildDiv;
})(DBC || (DBC = {}));
