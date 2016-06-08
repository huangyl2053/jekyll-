var DBZ;
(function (DBZ) {
    (function (ChikuShichosonSelect) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChikuShichosonSelect.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ChikuShichosonSelect.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ChikuShichosonSelect.ModeController = ModeController;
    })(DBZ.ChikuShichosonSelect || (DBZ.ChikuShichosonSelect = {}));
    var ChikuShichosonSelect = DBZ.ChikuShichosonSelect;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ChikuShichosonSelect) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChikuShichosonSelect.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChikuShichosonSelect.PublicProperties = PublicProperties;
    })(DBZ.ChikuShichosonSelect || (DBZ.ChikuShichosonSelect = {}));
    var ChikuShichosonSelect = DBZ.ChikuShichosonSelect;
})(DBZ || (DBZ = {}));
