var DBZ;
(function (DBZ) {
    (function (KihonChosaInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KihonChosaInput.PublicProperties(this.fieldName);
            };
            ModeController.prototype.priorities = function () {
                return [
                    "State"
                ];
            };
            ModeController.prototype.State = function () {
                return new Modes.State(this.controls);
            };
            return ModeController;
        })();
        KihonChosaInput.ModeController = ModeController;

        (function (Modes) {
            var State = (function () {
                function State(controls) {
                    this.controls = controls;
                }
                State.prototype.Dai1gun = function () {
                    this.controls.DaiichigunShintaiKino().visible = true;
                    this.controls.SeikatsuKinou().visible = false;
                    this.controls.NinchiKinou().visible = false;
                    this.controls.KoudoShogai().visible = false;
                    this.controls.ShakaiSekatsu().visible = false;
                    this.controls.TokubetsuIryo().visible = false;
                    this.controls.Jiritsudo().visible = false;
                    this.controls.ZenkaiHyojiTeiji().visible = true;
                };

                State.prototype.Dai2gun = function () {
                    this.controls.DaiichigunShintaiKino().visible = false;
                    this.controls.SeikatsuKinou().visible = true;
                    this.controls.NinchiKinou().visible = false;
                    this.controls.KoudoShogai().visible = false;
                    this.controls.ShakaiSekatsu().visible = false;
                    this.controls.TokubetsuIryo().visible = false;
                    this.controls.Jiritsudo().visible = false;
                    this.controls.ZenkaiHyojiTeiji().visible = true;
                };
                State.prototype.Dai3gun = function () {
                    this.controls.DaiichigunShintaiKino().visible = false;
                    this.controls.SeikatsuKinou().visible = false;
                    this.controls.NinchiKinou().visible = true;
                    this.controls.KoudoShogai().visible = false;
                    this.controls.ShakaiSekatsu().visible = false;
                    this.controls.TokubetsuIryo().visible = false;
                    this.controls.Jiritsudo().visible = false;
                    this.controls.ZenkaiHyojiTeiji().visible = true;
                };
                State.prototype.Dai4gun = function () {
                    this.controls.DaiichigunShintaiKino().visible = false;
                    this.controls.SeikatsuKinou().visible = false;
                    this.controls.NinchiKinou().visible = false;
                    this.controls.KoudoShogai().visible = true;
                    this.controls.ShakaiSekatsu().visible = false;
                    this.controls.TokubetsuIryo().visible = false;
                    this.controls.Jiritsudo().visible = false;
                    this.controls.ZenkaiHyojiTeiji().visible = true;
                };
                State.prototype.Dai5gun = function () {
                    this.controls.DaiichigunShintaiKino().visible = false;
                    this.controls.SeikatsuKinou().visible = false;
                    this.controls.NinchiKinou().visible = false;
                    this.controls.KoudoShogai().visible = false;
                    this.controls.ShakaiSekatsu().visible = true;
                    this.controls.TokubetsuIryo().visible = false;
                    this.controls.Jiritsudo().visible = false;
                    this.controls.ZenkaiHyojiTeiji().visible = true;
                };
                State.prototype.Dai6gun = function () {
                    this.controls.DaiichigunShintaiKino().visible = false;
                    this.controls.SeikatsuKinou().visible = false;
                    this.controls.NinchiKinou().visible = false;
                    this.controls.KoudoShogai().visible = false;
                    this.controls.ShakaiSekatsu().visible = false;
                    this.controls.TokubetsuIryo().visible = true;
                    this.controls.Jiritsudo().visible = false;
                    this.controls.ZenkaiHyojiTeiji().visible = true;
                };
                State.prototype.Dai7gun = function () {
                    this.controls.DaiichigunShintaiKino().visible = false;
                    this.controls.SeikatsuKinou().visible = false;
                    this.controls.NinchiKinou().visible = false;
                    this.controls.KoudoShogai().visible = false;
                    this.controls.ShakaiSekatsu().visible = false;
                    this.controls.TokubetsuIryo().visible = false;
                    this.controls.Jiritsudo().visible = true;
                    this.controls.ZenkaiHyojiTeiji().visible = true;
                };
                return State;
            })();
            Modes.State = State;
        })(KihonChosaInput.Modes || (KihonChosaInput.Modes = {}));
        var Modes = KihonChosaInput.Modes;
    })(DBZ.KihonChosaInput || (DBZ.KihonChosaInput = {}));
    var KihonChosaInput = DBZ.KihonChosaInput;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KihonChosaInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonChosaInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KihonChosaInput.PublicProperties = PublicProperties;
    })(DBZ.KihonChosaInput || (DBZ.KihonChosaInput = {}));
    var KihonChosaInput = DBZ.KihonChosaInput;
})(DBZ || (DBZ = {}));
