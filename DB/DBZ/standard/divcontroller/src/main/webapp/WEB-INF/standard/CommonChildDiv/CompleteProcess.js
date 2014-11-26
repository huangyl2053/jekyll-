var DBZ;
(function (DBZ) {
    (function (CompleteProcess) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new CompleteProcess.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        CompleteProcess.ModeController = ModeController;
    })(DBZ.CompleteProcess || (DBZ.CompleteProcess = {}));
    var CompleteProcess = DBZ.CompleteProcess;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (CompleteProcess) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new CompleteProcess.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("lblCompleteMessage_text", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("CompleteProcess_width", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getlblCompleteMessage_text = function () {
                return this.controls.lblCompleteMessage().text;
            };

            PublicProperties.prototype.setlblCompleteMessage_text = function (value) {
                this.controls.lblCompleteMessage().text = value;
            };

            PublicProperties.prototype.getCompleteProcess_width = function () {
                return this.controls.CompleteProcess().width;
            };

            PublicProperties.prototype.setCompleteProcess_width = function (value) {
                this.controls.CompleteProcess().width = value;
            };
            return PublicProperties;
        })();
        CompleteProcess.PublicProperties = PublicProperties;
    })(DBZ.CompleteProcess || (DBZ.CompleteProcess = {}));
    var CompleteProcess = DBZ.CompleteProcess;
})(DBZ || (DBZ = {}));
