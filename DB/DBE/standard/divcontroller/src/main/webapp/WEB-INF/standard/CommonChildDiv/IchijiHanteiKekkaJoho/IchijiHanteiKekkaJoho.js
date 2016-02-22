var DBE;
(function (DBE) {
    (function (IchijiHanteiKekkaJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IchijiHanteiKekkaJoho.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.State = function () {
                return new Modes.State(this.controls);
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        IchijiHanteiKekkaJoho.ModeController = ModeController;
        (function (Modes) {
            var State = (function () {
                function State(controls) {
                    this.controls = controls;
                }
                State.prototype.shokai = function () {
                };

                State.prototype.touroku = function () {
                };
                return State;
            })();
            Modes.State = State;
        })(IchijiHanteiKekkaJoho.Modes || (IchijiHanteiKekkaJoho.Modes = {}));
        var Modes = IchijiHanteiKekkaJoho.Modes;
    })(DBE.IchijiHanteiKekkaJoho || (DBE.IchijiHanteiKekkaJoho = {}));
    var IchijiHanteiKekkaJoho = DBE.IchijiHanteiKekkaJoho;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (IchijiHanteiKekkaJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new IchijiHanteiKekkaJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IchijiHanteiKekkaJoho.PublicProperties = PublicProperties;
    })(DBE.IchijiHanteiKekkaJoho || (DBE.IchijiHanteiKekkaJoho = {}));
    var IchijiHanteiKekkaJoho = DBE.IchijiHanteiKekkaJoho;
})(DBE || (DBE = {}));
