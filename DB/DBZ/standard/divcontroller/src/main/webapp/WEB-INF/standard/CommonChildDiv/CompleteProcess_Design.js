var DBZ;
(function (DBZ) {
    (function (CompleteProcess) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        CompleteProcess.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "CompleteProcess";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.CompleteProcess.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.CompleteProcess.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.CompleteProcess = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.CompleteProssessPadding = function () {
                return new UZA.Panel(this.convFiledName("CompleteProssessPadding"));
            };

            Controls.prototype.lblCompleteMessage = function () {
                return new UZA.Label(this.convFiledName("lblCompleteMessage"));
            };
            return Controls;
        })();
        CompleteProcess.Controls = Controls;
    })(DBZ.CompleteProcess || (DBZ.CompleteProcess = {}));
    var CompleteProcess = DBZ.CompleteProcess;
})(DBZ || (DBZ = {}));
