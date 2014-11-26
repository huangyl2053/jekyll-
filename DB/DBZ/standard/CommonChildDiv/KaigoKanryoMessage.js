var DBZ;
(function (DBZ) {
    (function (KaigoKanryoMessage) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoKanryoMessage.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KaigoKanryoMessage.ModeController = ModeController;
    })(DBZ.KaigoKanryoMessage || (DBZ.KaigoKanryoMessage = {}));
    var KaigoKanryoMessage = DBZ.KaigoKanryoMessage;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoKanryoMessage) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoKanryoMessage.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("KanryoMessage_width", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getKanryoMessage_width = function () {
                return this.controls.KanryoMessage().PublicProperties().KanryoMessage_width;
            };

            PublicProperties.prototype.setKanryoMessage_width = function (value) {
                this.controls.KanryoMessage().PublicProperties().KanryoMessage_width = value;
            };
            return PublicProperties;
        })();
        KaigoKanryoMessage.PublicProperties = PublicProperties;
    })(DBZ.KaigoKanryoMessage || (DBZ.KaigoKanryoMessage = {}));
    var KaigoKanryoMessage = DBZ.KaigoKanryoMessage;
})(DBZ || (DBZ = {}));
