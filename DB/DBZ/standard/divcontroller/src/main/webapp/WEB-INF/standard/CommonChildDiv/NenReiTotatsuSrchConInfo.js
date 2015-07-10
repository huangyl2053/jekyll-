var DBZ;
(function (DBZ) {
    (function (NenReiTotatsuSrchConInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NenReiTotatsuSrchConInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "DisplayMode"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NenReiTotatsuSrchConInfo.PublicProperties(this.fieldName);
            };

            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };
            return ModeController;
        })();
        NenReiTotatsuSrchConInfo.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.KensakuInput = function () {
                    this.controls.btnKensaku().displayNone = false;
                };

                DisplayMode.prototype.ChushutsuInput = function () {
                    this.controls.btnKensaku().displayNone = true;
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;
        })(NenReiTotatsuSrchConInfo.Modes || (NenReiTotatsuSrchConInfo.Modes = {}));
        var Modes = NenReiTotatsuSrchConInfo.Modes;
    })(DBZ.NenReiTotatsuSrchConInfo || (DBZ.NenReiTotatsuSrchConInfo = {}));
    var NenReiTotatsuSrchConInfo = DBZ.NenReiTotatsuSrchConInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NenReiTotatsuSrchConInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new NenReiTotatsuSrchConInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NenReiTotatsuSrchConInfo.PublicProperties = PublicProperties;
    })(DBZ.NenReiTotatsuSrchConInfo || (DBZ.NenReiTotatsuSrchConInfo = {}));
    var NenReiTotatsuSrchConInfo = DBZ.NenReiTotatsuSrchConInfo;
})(DBZ || (DBZ = {}));
