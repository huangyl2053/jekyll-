var DBA;
(function (DBA) {
    (function (ShotokuShokaiDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        ShotokuShokaiDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShotokuShokaiDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.ShotokuShokaiDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.ShotokuShokaiDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShotokuShokaiDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        ShotokuShokaiDialog.Controls = Controls;
    })(DBA.ShotokuShokaiDialog || (DBA.ShotokuShokaiDialog = {}));
    var ShotokuShokaiDialog = DBA.ShotokuShokaiDialog;
})(DBA || (DBA = {}));
