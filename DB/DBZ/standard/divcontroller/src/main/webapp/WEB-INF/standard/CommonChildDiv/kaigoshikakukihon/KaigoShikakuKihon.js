var DBZ;
(function (DBZ) {
    (function (KaigoShikakuKihon) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoShikakuKihon.Controls(fieldName);
            }
            ModeController.prototype.HihoRirekiButtonWo = function () {
                return new Modes.HihoRirekiButtonWo(this.controls);
            };

            ModeController.prototype.NinteiRirekiButtonWo = function () {
                return new Modes.NinteiRirekiButtonWo(this.controls);
            };
            return ModeController;
        })();
        KaigoShikakuKihon.ModeController = ModeController;

        (function (Modes) {
            var HihoRirekiButtonWo = (function () {
                function HihoRirekiButtonWo(controls) {
                    this.controls = controls;
                }
                HihoRirekiButtonWo.prototype.HyojiSuru = function () {
                    this.controls.btnHihoRireki().displayNone = false;
                };

                HihoRirekiButtonWo.prototype.HyojiShinai = function () {
                    this.controls.btnHihoRireki().displayNone = true;
                };
                return HihoRirekiButtonWo;
            })();
            Modes.HihoRirekiButtonWo = HihoRirekiButtonWo;

            var NinteiRirekiButtonWo = (function () {
                function NinteiRirekiButtonWo(controls) {
                    this.controls = controls;
                }
                NinteiRirekiButtonWo.prototype.HyojiSuru = function () {
                    this.controls.btnNinteiRireki().displayNone = false;
                };

                NinteiRirekiButtonWo.prototype.HyojiShinai = function () {
                    this.controls.btnNinteiRireki().displayNone = true;
                };
                return NinteiRirekiButtonWo;
            })();
            Modes.NinteiRirekiButtonWo = NinteiRirekiButtonWo;
        })(KaigoShikakuKihon.Modes || (KaigoShikakuKihon.Modes = {}));
        var Modes = KaigoShikakuKihon.Modes;
    })(DBZ.KaigoShikakuKihon || (DBZ.KaigoShikakuKihon = {}));
    var KaigoShikakuKihon = DBZ.KaigoShikakuKihon;
})(DBZ || (DBZ = {}));
