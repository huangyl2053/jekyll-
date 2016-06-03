var DBZ;
(function (DBZ) {
    (function (KaigoAtesakiJushoSettei) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoAtesakiJushoSettei.Controls(fieldName);
            }
            ModeController.prototype.DisplayJushoSetteiRad = function () {
                return new Modes.DisplayJushoSetteiRad(this.controls);
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoAtesakiJushoSettei.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoAtesakiJushoSettei.ModeController = ModeController;

        (function (Modes) {
            var DisplayJushoSetteiRad = (function () {
                function DisplayJushoSetteiRad(controls) {
                    this.controls = controls;
                }
                DisplayJushoSetteiRad.prototype.NotDisplay = function () {
                    this.controls.radJushoSettei().displayNone = true;
                };

                DisplayJushoSetteiRad.prototype.Display = function () {
                    this.controls.radJushoSettei().displayNone = false;
                };
                return DisplayJushoSetteiRad;
            })();
            Modes.DisplayJushoSetteiRad = DisplayJushoSetteiRad;
        })(KaigoAtesakiJushoSettei.Modes || (KaigoAtesakiJushoSettei.Modes = {}));
        var Modes = KaigoAtesakiJushoSettei.Modes;
    })(DBZ.KaigoAtesakiJushoSettei || (DBZ.KaigoAtesakiJushoSettei = {}));
    var KaigoAtesakiJushoSettei = DBZ.KaigoAtesakiJushoSettei;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoAtesakiJushoSettei) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoAtesakiJushoSettei.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoAtesakiJushoSettei.PublicProperties = PublicProperties;
    })(DBZ.KaigoAtesakiJushoSettei || (DBZ.KaigoAtesakiJushoSettei = {}));
    var KaigoAtesakiJushoSettei = DBZ.KaigoAtesakiJushoSettei;
})(DBZ || (DBZ = {}));
