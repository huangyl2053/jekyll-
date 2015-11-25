var DBZ;
(function (DBZ) {
    (function (ServiceTypeCommonChildDiv) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ServiceTypeCommonChildDiv.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceTypeCommonChildDiv";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ServiceTypeCommonChildDiv.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ServiceTypeCommonChildDiv.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceTypeCommonChildDiv = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgServiceType = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceType"));
            };

            Controls.prototype.btnYameru = function () {
                return new UZA.Button(this.convFiledName("btnYameru"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };
            return Controls;
        })();
        ServiceTypeCommonChildDiv.Controls = Controls;
    })(DBZ.ServiceTypeCommonChildDiv || (DBZ.ServiceTypeCommonChildDiv = {}));
    var ServiceTypeCommonChildDiv = DBZ.ServiceTypeCommonChildDiv;
})(DBZ || (DBZ = {}));
