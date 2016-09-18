var DBA;
(function (DBA) {
    (function (ShoKaishuKirokuDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        ShoKaishuKirokuDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShoKaishuKirokuDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.ShoKaishuKirokuDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.ShoKaishuKirokuDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShoKaishuKirokuDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        ShoKaishuKirokuDialog.Controls = Controls;
    })(DBA.ShoKaishuKirokuDialog || (DBA.ShoKaishuKirokuDialog = {}));
    var ShoKaishuKirokuDialog = DBA.ShoKaishuKirokuDialog;
})(DBA || (DBA = {}));
