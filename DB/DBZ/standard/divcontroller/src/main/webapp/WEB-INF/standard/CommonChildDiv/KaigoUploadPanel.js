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
            return ModeController;
        })();
        KaigoUploadPanel.ModeController = ModeController;
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
