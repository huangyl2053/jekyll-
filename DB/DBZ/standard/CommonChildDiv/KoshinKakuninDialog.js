var DBZ;
(function (DBZ) {
    (function (KoshinKakuninDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KoshinKakuninDialog.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KoshinKakuninDialog.ModeController = ModeController;
    })(DBZ.KoshinKakuninDialog || (DBZ.KoshinKakuninDialog = {}));
    var KoshinKakuninDialog = DBZ.KoshinKakuninDialog;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KoshinKakuninDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KoshinKakuninDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KoshinKakuninDialog.PublicProperties = PublicProperties;
    })(DBZ.KoshinKakuninDialog || (DBZ.KoshinKakuninDialog = {}));
    var KoshinKakuninDialog = DBZ.KoshinKakuninDialog;
})(DBZ || (DBZ = {}));
