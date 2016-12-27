var DBZ;
(function (DBZ) {
    (function (NinteiShinseishaFinder) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseishaFinder.Controls(fieldName);
                this.controls.ShosaiJoken().isOpen = false;
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiShinseishaFinder.PublicProperties(this.fieldName);
            };
            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };
            ModeController.prototype.GyomuType = function () {
                return new Modes.GyomuType(this.controls);
            };
            ModeController.prototype.MinashiType = function () {
                return new Modes.MinashiType(this.controls);
            };
            return ModeController;
        })();
        NinteiShinseishaFinder.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.StandardMode = function () {
                    this.controls.ShosaiJoken().isOpen = false;
                    this.controls.KihonJoho().isOpen = true;
                    this.controls.NinteiChosa().isOpen = false;
                    this.controls.ShujiiJoho().isOpen = false;
                    this.controls.IchijiHantei().isOpen = false;
                    this.controls.KaigoNinteiShinsakaiJoho().isOpen = false;
                    this.controls.ZenkaiJoho().isOpen = false;
                    this.controls.SonotaJoho().isOpen = false;
                    this.controls.KanryoJoho().isOpen = false;
                };
                DisplayType.prototype.PhaseMode = function () {
                    this.controls.ShosaiJoken().isOpen = false;
                    this.controls.KihonJoho().isOpen = true;
                    this.controls.NinteiChosa().isOpen = false;
                    this.controls.ShujiiJoho().isOpen = false;
                    this.controls.IchijiHantei().isOpen = false;
                    this.controls.KaigoNinteiShinsakaiJoho().isOpen = false;
                    this.controls.ZenkaiJoho().isOpen = false;
                    this.controls.SonotaJoho().isOpen = false;
                    this.controls.KanryoJoho().isOpen = true;
                };

                DisplayType.prototype.NinteiChosaMode = function () {
                    this.controls.ShosaiJoken().isOpen = false;
                    this.controls.KihonJoho().isOpen = true;
                    this.controls.NinteiChosa().isOpen = true;
                    this.controls.ShujiiJoho().isOpen = false;
                    this.controls.IchijiHantei().isOpen = false;
                    this.controls.KaigoNinteiShinsakaiJoho().isOpen = false;
                    this.controls.ZenkaiJoho().isOpen = false;
                    this.controls.SonotaJoho().isOpen = false;
                    this.controls.KanryoJoho().isOpen = false;
                };

                DisplayType.prototype.IkenshoMode = function () {
                    this.controls.ShosaiJoken().isOpen = false;
                    this.controls.KihonJoho().isOpen = true;
                    this.controls.NinteiChosa().isOpen = false;
                    this.controls.ShujiiJoho().isOpen = true;
                    this.controls.IchijiHantei().isOpen = false;
                    this.controls.KaigoNinteiShinsakaiJoho().isOpen = false;
                    this.controls.ZenkaiJoho().isOpen = false;
                    this.controls.SonotaJoho().isOpen = false;
                    this.controls.KanryoJoho().isOpen = false;
                };
                DisplayType.prototype.ShinsakaiMode = function () {
                    this.controls.ShosaiJoken().isOpen = false;
                    this.controls.KihonJoho().isOpen = true;
                    this.controls.NinteiChosa().isOpen = false;
                    this.controls.ShujiiJoho().isOpen = false;
                    this.controls.IchijiHantei().isOpen = true;
                    this.controls.KaigoNinteiShinsakaiJoho().isOpen = true;
                    this.controls.ZenkaiJoho().isOpen = false;
                    this.controls.SonotaJoho().isOpen = false;
                    this.controls.KanryoJoho().isOpen = false;
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;

            var GyomuType = (function () {
                function GyomuType(controls) {
                    this.controls = controls;
                }
                GyomuType.prototype.Nintei = function () {
                    this.controls.chkShinseiUketsuke().readOnly = false;
                    this.controls.chkChosaIrai().readOnly = false;
                    this.controls.chkIkenshoIrai().readOnly = false;
                    this.controls.chkChosaNyushu().readOnly = false;
                    this.controls.chkIkenshoNyushu().readOnly = false;
                    this.controls.chkIchijiHantei().readOnly = false;
                    this.controls.chkMasking().readOnly = false;
                    this.controls.chkShinsakaiToroku().readOnly = false;
                    this.controls.chkNijiHantei().readOnly = false;
                    this.controls.chkTsuchiShori().readOnly = true;
                    this.controls.chkGetsureiShori().readOnly = false;
                };
                GyomuType.prototype.Jukyu = function () {
                    this.controls.chkShinseiUketsuke().readOnly = true;
                    this.controls.chkChosaIrai().readOnly = true;
                    this.controls.chkIkenshoIrai().readOnly = true;
                    this.controls.chkChosaNyushu().readOnly = true;
                    this.controls.chkIkenshoNyushu().readOnly = true;
                    this.controls.chkIchijiHantei().readOnly = true;
                    this.controls.chkMasking().readOnly = true;
                    this.controls.chkShinsakaiToroku().readOnly = true;
                    this.controls.chkNijiHantei().readOnly = true;
                    this.controls.chkTsuchiShori().readOnly = false;
                    this.controls.chkGetsureiShori().readOnly = true;
                };
                return GyomuType;
            })();
            Modes.GyomuType = GyomuType;

            var MinashiType = (function () {
                function MinashiType(controls) {
                    this.controls = controls;
                }
                MinashiType.prototype.Minashi = function () {
                    this.controls.chkMinashiFlag().readOnly = true;
                };
                MinashiType.prototype.NotMinashi = function () {
                    this.controls.chkMinashiFlag().readOnly = false;
                };
                return MinashiType;
            })();
            Modes.MinashiType = MinashiType;
        })(NinteiShinseishaFinder.Modes || (NinteiShinseishaFinder.Modes = {}));
        var Modes = NinteiShinseishaFinder.Modes;
    })(DBZ.NinteiShinseishaFinder || (DBZ.NinteiShinseishaFinder = {}));
    var NinteiShinseishaFinder = DBZ.NinteiShinseishaFinder;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiShinseishaFinder) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseishaFinder.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiShinseishaFinder.PublicProperties = PublicProperties;
    })(DBZ.NinteiShinseishaFinder || (DBZ.NinteiShinseishaFinder = {}));
    var NinteiShinseishaFinder = DBZ.NinteiShinseishaFinder;
})(DBZ || (DBZ = {}));
