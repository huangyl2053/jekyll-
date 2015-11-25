var DBZ;
(function (DBZ) {
    (function (TekiyoJogaiRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TekiyoJogaiRireki.Controls(fieldName);
            }
            ModeController.prototype.ModeA = function () {
                return new Modes.ModeA(this.controls);
            };

            ModeController.prototype.ModeB = function () {
                return new Modes.ModeB(this.controls);
            };

            ModeController.prototype.ModeC = function () {
                return new Modes.ModeC(this.controls);
            };

            ModeController.prototype.ModeD = function () {
                return new Modes.ModeD(this.controls);
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TekiyoJogaiRireki.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "ModeA",
                    "ModeB",
                    "ModeC",
                    "ModeD"
                ];
            };
            return ModeController;
        })();
        TekiyoJogaiRireki.ModeController = ModeController;

        (function (Modes) {
            var ModeA = (function () {
                function ModeA(controls) {
                    this.controls = controls;
                }
                ModeA.prototype.Shinki = function () {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = false;

                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnKakutei().displayNone = false;
                };
                return ModeA;
            })();
            Modes.ModeA = ModeA;

            var ModeB = (function () {
                function ModeB(controls) {
                    this.controls = controls;
                }
                ModeB.prototype.Kaijo = function () {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;

                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = false;

                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = false;
                };
                return ModeB;
            })();
            Modes.ModeB = ModeB;

            var ModeC = (function () {
                function ModeC(controls) {
                    this.controls = controls;
                }
                ModeC.prototype.HenKo = function () {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;

                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnKakutei().disabled = true;

                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = true;
                };
                return ModeC;
            })();
            Modes.ModeC = ModeC;

            var ModeD = (function () {
                function ModeD(controls) {
                    this.controls = controls;
                }
                ModeD.prototype.Hyoji = function () {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;

                    this.controls.btnKakutei().displayNone = true;
                };
                return ModeD;
            })();
            Modes.ModeD = ModeD;
        })(TekiyoJogaiRireki.Modes || (TekiyoJogaiRireki.Modes = {}));
        var Modes = TekiyoJogaiRireki.Modes;
    })(DBZ.TekiyoJogaiRireki || (DBZ.TekiyoJogaiRireki = {}));
    var TekiyoJogaiRireki = DBZ.TekiyoJogaiRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (TekiyoJogaiRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TekiyoJogaiRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TekiyoJogaiRireki.PublicProperties = PublicProperties;
    })(DBZ.TekiyoJogaiRireki || (DBZ.TekiyoJogaiRireki = {}));
    var TekiyoJogaiRireki = DBZ.TekiyoJogaiRireki;
})(DBZ || (DBZ = {}));
