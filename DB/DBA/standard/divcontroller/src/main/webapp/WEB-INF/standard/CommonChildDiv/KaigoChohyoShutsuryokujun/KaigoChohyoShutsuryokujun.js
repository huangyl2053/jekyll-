var DBZ;
(function (DBZ) {
    (function (KaigoChohyoShutsuryokujun) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoChohyoShutsuryokujun.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoChohyoShutsuryokujun.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DisplayType"
                ];
            };

            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };
            return ModeController;
        })();
        KaigoChohyoShutsuryokujun.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.SORT_ONLY = function () {
                    this.controls.ccdChohyoShutsuryokujun().Grid().G12();
                    this.controls.ccdChohyoShutsuryokujun().DisplayNone().SORT_ONLY();
                };

                DisplayType.prototype.SHUKEI_NONE = function () {
                    this.controls.ccdChohyoShutsuryokujun().Grid().G12();
                    this.controls.ccdChohyoShutsuryokujun().DisplayNone().SHUKEI_NONE();
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;
        })(KaigoChohyoShutsuryokujun.Modes || (KaigoChohyoShutsuryokujun.Modes = {}));
        var Modes = KaigoChohyoShutsuryokujun.Modes;
    })(DBZ.KaigoChohyoShutsuryokujun || (DBZ.KaigoChohyoShutsuryokujun = {}));
    var KaigoChohyoShutsuryokujun = DBZ.KaigoChohyoShutsuryokujun;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoChohyoShutsuryokujun) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoChohyoShutsuryokujun.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoChohyoShutsuryokujun.PublicProperties = PublicProperties;
    })(DBZ.KaigoChohyoShutsuryokujun || (DBZ.KaigoChohyoShutsuryokujun = {}));
    var KaigoChohyoShutsuryokujun = DBZ.KaigoChohyoShutsuryokujun;
})(DBZ || (DBZ = {}));
