var DBZ;
(function (DBZ) {
    (function (KaigoAtenaInfo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoAtenaInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoAtenaInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoAtenaInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoAtenaInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoAtenaInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.atenaInfo = function () {
                return new URA.AtenaShokaiSimple.ModeController(this.convFiledName("atenaInfo"));
            };
            return Controls;
        })();
        KaigoAtenaInfo.Controls = Controls;
    })(DBZ.KaigoAtenaInfo || (DBZ.KaigoAtenaInfo = {}));
    var KaigoAtenaInfo = DBZ.KaigoAtenaInfo;
})(DBZ || (DBZ = {}));
