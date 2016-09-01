var DBA;
(function (DBA) {
    (function (ShotokuShokaiDialogButton) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShotokuShokaiDialogButton.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShotokuShokaiDialogButton";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.ShotokuShokaiDialogButton.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.ShotokuShokaiDialogButton.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShotokuShokaiDialogButton = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnSetaiShotoku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSetaiShotoku"));
            };
            return Controls;
        })();
        ShotokuShokaiDialogButton.Controls = Controls;
    })(DBA.ShotokuShokaiDialogButton || (DBA.ShotokuShokaiDialogButton = {}));
    var ShotokuShokaiDialogButton = DBA.ShotokuShokaiDialogButton;
})(DBA || (DBA = {}));
