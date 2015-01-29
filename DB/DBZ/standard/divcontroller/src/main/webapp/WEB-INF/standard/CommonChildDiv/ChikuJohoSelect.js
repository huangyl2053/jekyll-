var DBZ;
(function (DBZ) {
    (function (ChikuJohoSelect) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChikuJohoSelect.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ChikuJohoSelect.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ChikuJohoSelect.ModeController = ModeController;
    })(DBZ.ChikuJohoSelect || (DBZ.ChikuJohoSelect = {}));
    var ChikuJohoSelect = DBZ.ChikuJohoSelect;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ChikuJohoSelect) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChikuJohoSelect.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChikuJohoSelect.PublicProperties = PublicProperties;
    })(DBZ.ChikuJohoSelect || (DBZ.ChikuJohoSelect = {}));
    var ChikuJohoSelect = DBZ.ChikuJohoSelect;
})(DBZ || (DBZ = {}));
