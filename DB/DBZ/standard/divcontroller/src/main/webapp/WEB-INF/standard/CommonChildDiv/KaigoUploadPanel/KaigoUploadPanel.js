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

            ModeController.prototype.IsSimpleMode = function () {
                return new Modes.IsSimpleMode(this.controls);
            };
            return ModeController;
        })();
        KaigoUploadPanel.ModeController = ModeController;

        (function (Modes) {
            var IsSimpleMode = (function () {
                function IsSimpleMode(controls) {
                    this.controls = controls;
                }
                IsSimpleMode.prototype.TRUE = function () {
                    this.controls.uplUploadFile().displayNone = false;
                    this.controls.uplUploadFile1().displayNone = true;
                    this.controls.btnUpload().displayNone = false;
                    this.controls.btnUpload1().displayNone = true;
                    this.controls.lblFileName().visible = true;
                    this.controls.lblUploadFileName().visible = true;
                };

                IsSimpleMode.prototype.FALSE = function () {
                    this.controls.uplUploadFile().displayNone = true;
                    this.controls.uplUploadFile1().displayNone = false;
                    this.controls.btnUpload().displayNone = true;
                    this.controls.btnUpload1().displayNone = false;
                    this.controls.lblFileName().visible = false;
                    this.controls.lblUploadFileName().visible = false;
                };
                return IsSimpleMode;
            })();
            Modes.IsSimpleMode = IsSimpleMode;
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
