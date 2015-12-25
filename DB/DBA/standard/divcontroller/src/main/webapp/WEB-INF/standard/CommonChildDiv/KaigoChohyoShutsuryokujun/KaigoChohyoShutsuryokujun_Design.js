var DBZ;
(function (DBZ) {
    (function (KaigoChohyoShutsuryokujun) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoChohyoShutsuryokujun.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoChohyoShutsuryokujun";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoChohyoShutsuryokujun.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoChohyoShutsuryokujun.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoChohyoShutsuryokujun = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdChohyoShutsuryokujun = function () {
                return new URZ.ChohyoShutsuryokujun.ModeController(this.convFiledName("ccdChohyoShutsuryokujun"));
            };
            return Controls;
        })();
        KaigoChohyoShutsuryokujun.Controls = Controls;
    })(DBZ.KaigoChohyoShutsuryokujun || (DBZ.KaigoChohyoShutsuryokujun = {}));
    var KaigoChohyoShutsuryokujun = DBZ.KaigoChohyoShutsuryokujun;
})(DBZ || (DBZ = {}));
