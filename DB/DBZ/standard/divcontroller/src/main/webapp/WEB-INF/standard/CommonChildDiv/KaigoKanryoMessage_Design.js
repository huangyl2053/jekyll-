var DBZ;
(function (DBZ) {
    (function (KaigoKanryoMessage) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoKanryoMessage.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoKanryoMessage";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoKanryoMessage.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoKanryoMessage.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoKanryoMessage = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdKanryoMessage = function () {
                return new URZ.KanryoMessage.ModeController(this.convFiledName("ccdKanryoMessage"));
            };
            return Controls;
        })();
        KaigoKanryoMessage.Controls = Controls;
    })(DBZ.KaigoKanryoMessage || (DBZ.KaigoKanryoMessage = {}));
    var KaigoKanryoMessage = DBZ.KaigoKanryoMessage;
})(DBZ || (DBZ = {}));
