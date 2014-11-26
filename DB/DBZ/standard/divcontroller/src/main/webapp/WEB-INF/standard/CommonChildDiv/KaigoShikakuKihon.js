var DBZ;
(function (DBZ) {
    (function (KaigoShikakuKihon) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.controls = new KaigoShikakuKihon.Controls(fieldName);
            }
            ModeController.prototype.RenrakusakiAriMode = function () {
                return new Modes.RenrakusakiAriMode(this.controls);
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
            var RenrakusakiAriMode = (function () {
                function RenrakusakiAriMode(controls) {
                    this.controls = controls;
                }
                RenrakusakiAriMode.prototype.RenrakusakiAri = function () {
                    this.controls.btnRenrakusaki().displayNone = false;
                };
                return RenrakusakiAriMode;
            })();
            Modes.RenrakusakiAriMode = RenrakusakiAriMode;

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
                NinteirirekiNashiMode.prototype.NinteirirekiAri = function () {
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

var DBZ;
(function (DBZ) {
    (function (KaigoShikakuKihon) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KaigoShikakuKihon.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoShikakuKihon.PublicProperties = PublicProperties;
    })(DBZ.KaigoShikakuKihon || (DBZ.KaigoShikakuKihon = {}));
    var KaigoShikakuKihon = DBZ.KaigoShikakuKihon;
})(DBZ || (DBZ = {}));
