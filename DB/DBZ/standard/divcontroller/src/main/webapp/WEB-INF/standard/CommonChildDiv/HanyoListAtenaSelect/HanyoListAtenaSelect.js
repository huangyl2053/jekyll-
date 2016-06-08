var DBZ;
(function (DBZ) {
    (function (HanyoListAtenaSelect) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HanyoListAtenaSelect.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HanyoListAtenaSelect.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HanyoListAtenaSelect.ModeController = ModeController;
    })(DBZ.HanyoListAtenaSelect || (DBZ.HanyoListAtenaSelect = {}));
    var HanyoListAtenaSelect = DBZ.HanyoListAtenaSelect;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HanyoListAtenaSelect) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HanyoListAtenaSelect.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HanyoListAtenaSelect.PublicProperties = PublicProperties;
    })(DBZ.HanyoListAtenaSelect || (DBZ.HanyoListAtenaSelect = {}));
    var HanyoListAtenaSelect = DBZ.HanyoListAtenaSelect;
})(DBZ || (DBZ = {}));
