var DBZ;
(function (DBZ) {
    (function (KaigoShikakuKihon) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.controls = new KaigoShikakuKihon.Controls(fieldName);
            }
            ModeController.prototype.RenrakusakiNashiMode = function () {
                return new Modes.RenrakusakiNashiMode(this.controls);
            };

            ModeController.prototype.HihokenrirekiNashiMode = function () {
                return new Modes.HihokenrirekiNashiMode(this.controls);
            };

            ModeController.prototype.NinteirirekiNashiMode = function () {
                return new Modes.NinteirirekiNashiMode(this.controls);
            };
            return ModeController;
        })();
        KaigoShikakuKihon.ModeController = ModeController;

        (function (Modes) {
            var RenrakusakiNashiMode = (function () {
                function RenrakusakiNashiMode(controls) {
                    this.controls = controls;
                }
                RenrakusakiNashiMode.prototype.RenrakusakiNashi = function () {
                    this.controls.btnRenrakusaki().displayNone = true;
                };
                return RenrakusakiNashiMode;
            })();
            Modes.RenrakusakiNashiMode = RenrakusakiNashiMode;

            var HihokenrirekiNashiMode = (function () {
                function HihokenrirekiNashiMode(controls) {
                    this.controls = controls;
                }
                HihokenrirekiNashiMode.prototype.HihokenrirekiNashi = function () {
                    this.controls.btnHihoRireki().displayNone = true;
                };
                return HihokenrirekiNashiMode;
            })();
            Modes.HihokenrirekiNashiMode = HihokenrirekiNashiMode;

            var NinteirirekiNashiMode = (function () {
                function NinteirirekiNashiMode(controls) {
                    this.controls = controls;
                }
                NinteirirekiNashiMode.prototype.NinteirirekiNashi = function () {
                    this.controls.btnNinteiRireki().displayNone = true;
                };
                return NinteirirekiNashiMode;
            })();
            Modes.NinteirirekiNashiMode = NinteirirekiNashiMode;
        })(KaigoShikakuKihon.Modes || (KaigoShikakuKihon.Modes = {}));
        var Modes = KaigoShikakuKihon.Modes;
    })(DBZ.KaigoShikakuKihon || (DBZ.KaigoShikakuKihon = {}));
    var KaigoShikakuKihon = DBZ.KaigoShikakuKihon;
})(DBZ || (DBZ = {}));
