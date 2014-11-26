var DBZ;
(function (DBZ) {
    (function (ShisetsuNyutaishoRirekiKanri) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuNyutaishoRirekiKanri.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ShisetsuNyutaishoRirekiKanri.ModeController = ModeController;
    })(DBZ.ShisetsuNyutaishoRirekiKanri || (DBZ.ShisetsuNyutaishoRirekiKanri = {}));
    var ShisetsuNyutaishoRirekiKanri = DBZ.ShisetsuNyutaishoRirekiKanri;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShisetsuNyutaishoRirekiKanri) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShisetsuNyutaishoRirekiKanri.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShisetsuNyutaishoRirekiKanri.PublicProperties = PublicProperties;
    })(DBZ.ShisetsuNyutaishoRirekiKanri || (DBZ.ShisetsuNyutaishoRirekiKanri = {}));
    var ShisetsuNyutaishoRirekiKanri = DBZ.ShisetsuNyutaishoRirekiKanri;
})(DBZ || (DBZ = {}));
