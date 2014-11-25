var DBE;
(function (DBE) {
    (function (KanryoDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KanryoDialog.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KanryoDialog.ModeController = ModeController;
    })(DBE.KanryoDialog || (DBE.KanryoDialog = {}));
    var KanryoDialog = DBE.KanryoDialog;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (KanryoDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KanryoDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("KanryoDialog_width", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getKanryoDialog_width = function () {
                return this.controls.KanryoDialog().width;
            };

            PublicProperties.prototype.setKanryoDialog_width = function (value) {
                this.controls.KanryoDialog().width = value;
            };
            return PublicProperties;
        })();
        KanryoDialog.PublicProperties = PublicProperties;
    })(DBE.KanryoDialog || (DBE.KanryoDialog = {}));
    var KanryoDialog = DBE.KanryoDialog;
})(DBE || (DBE = {}));
