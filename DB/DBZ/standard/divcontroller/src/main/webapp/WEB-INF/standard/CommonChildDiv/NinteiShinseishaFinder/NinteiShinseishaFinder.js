var DBZ;
(function (DBZ) {
    (function (NinteiShinseishaFinder) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseishaFinder.Controls(fieldName);
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
