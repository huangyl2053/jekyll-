var DBA;
(function (DBA) {
    (function (ServiceTypeInputCommonChildDiv) {
        var Events = (function () {
            function Events() {
            }
            Events.onBlur = function () {
                return "onBlur";
            };

            Events.onOkClose_btnSearch = function () {
                return "onOkClose_btnSearch";
            };

            Events.onBeforeOpenDialog_btnSearch = function () {
                return "onBeforeOpenDialog_btnSearch";
            };
            return Events;
        })();
        ServiceTypeInputCommonChildDiv.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceTypeInputCommonChildDiv";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.ServiceTypeInputCommonChildDiv.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.ServiceTypeInputCommonChildDiv.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceTypeInputCommonChildDiv = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtServiceType = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceType"));
            };

            Controls.prototype.btnKensaku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKensaku"));
            };

            Controls.prototype.txtServiceTypeName = function () {
                return new UZA.TextBox(this.convFiledName("txtServiceTypeName"));
            };
            return Controls;
        })();
        ServiceTypeInputCommonChildDiv.Controls = Controls;
    })(DBA.ServiceTypeInputCommonChildDiv || (DBA.ServiceTypeInputCommonChildDiv = {}));
    var ServiceTypeInputCommonChildDiv = DBA.ServiceTypeInputCommonChildDiv;
})(DBA || (DBA = {}));
