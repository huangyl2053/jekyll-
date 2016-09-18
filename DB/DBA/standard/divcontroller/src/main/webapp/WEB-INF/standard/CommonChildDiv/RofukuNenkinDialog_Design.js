var DBA;
(function (DBA) {
    (function (RofukuNenkinDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        RofukuNenkinDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "RofukuNenkinDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.RofukuNenkinDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.RofukuNenkinDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.RofukuNenkinDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        RofukuNenkinDialog.Controls = Controls;
    })(DBA.RofukuNenkinDialog || (DBA.RofukuNenkinDialog = {}));
    var RofukuNenkinDialog = DBA.RofukuNenkinDialog;
})(DBA || (DBA = {}));
