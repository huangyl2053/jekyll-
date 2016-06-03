var DBZ;
(function (DBZ) {
    (function (KaigoUploadPanel) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoUploadPanel.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoUploadPanel.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "isSimpleMode"
                ];
            };

            ModeController.prototype.isSimpleMode = function () {
                return new Modes.isSimpleMode(this.controls);
            };
            return ModeController;
        })();
        KaigoUploadPanel.ModeController = ModeController;

        (function (Modes) {
            var isSimpleMode = (function () {
                function isSimpleMode(controls) {
                    this.controls = controls;
                }
                isSimpleMode.prototype.TRUE = function () {
                    this.controls.lblFileName().visible = true;
                    this.controls.lblUploadFileName().visible = true;
                };

                isSimpleMode.prototype.FALSE = function () {
                    this.controls.lblFileName().visible = false;
                    this.controls.lblUploadFileName().visible = false;
                };
                return isSimpleMode;
            })();
            Modes.isSimpleMode = isSimpleMode;
        })(KaigoUploadPanel.Modes || (KaigoUploadPanel.Modes = {}));
        var Modes = KaigoUploadPanel.Modes;
    })(DBZ.KaigoUploadPanel || (DBZ.KaigoUploadPanel = {}));
    var KaigoUploadPanel = DBZ.KaigoUploadPanel;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoUploadPanel) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoUploadPanel.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoUploadPanel.PublicProperties = PublicProperties;
    })(DBZ.KaigoUploadPanel || (DBZ.KaigoUploadPanel = {}));
    var KaigoUploadPanel = DBZ.KaigoUploadPanel;
})(DBZ || (DBZ = {}));
