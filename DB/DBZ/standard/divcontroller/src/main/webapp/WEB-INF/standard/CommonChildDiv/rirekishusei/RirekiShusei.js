var DBZ;
(function (DBZ) {
    (function (RirekiShusei) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RirekiShusei.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new RirekiShusei.PublicProperties(this.fieldName);
            };
            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };
            return ModeController;
        })();
        RirekiShusei.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.tsuika = function () {
                };
                DisplayType.prototype.sakujo = function () {
                };
                DisplayType.prototype.sakujoShusei = function () {
                };
                DisplayType.prototype.torikeshiTsuika = function () {
                };
                DisplayType.prototype.torikeshiShusei = function () {
                };
                DisplayType.prototype.ninteiShusei = function () {
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;
        })(RirekiShusei.Modes || (RirekiShusei.Modes = {}));
        var Modes = RirekiShusei.Modes;
    })(DBZ.RirekiShusei || (DBZ.RirekiShusei = {}));
    var RirekiShusei = DBZ.RirekiShusei;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (RirekiShusei) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RirekiShusei.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        RirekiShusei.PublicProperties = PublicProperties;
    })(DBZ.RirekiShusei || (DBZ.RirekiShusei = {}));
    var RirekiShusei = DBZ.RirekiShusei;
})(DBZ || (DBZ = {}));
