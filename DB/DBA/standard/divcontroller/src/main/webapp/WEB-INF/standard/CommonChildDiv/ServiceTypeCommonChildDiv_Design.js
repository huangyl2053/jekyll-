var DBA;
(function (DBA) {
    (function (ServiceTypeCommonChildDiv) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnYameru = function () {
                return "onClick_btnYameru";
            };

            Events.onClick_btnKakutei = function () {
                return "onClick_btnKakutei";
            };
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
                return this._myName + "_" + DBA.ServiceTypeCommonChildDiv.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.ServiceTypeCommonChildDiv.Controls.myType() + "_" + fieldName;
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
    })(DBA.ServiceTypeCommonChildDiv || (DBA.ServiceTypeCommonChildDiv = {}));
    var ServiceTypeCommonChildDiv = DBA.ServiceTypeCommonChildDiv;
})(DBA || (DBA = {}));
