var DBZ;
(function (DBZ) {
    (function (DataOutputInfomation) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new DataOutputInfomation.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        DataOutputInfomation.ModeController = ModeController;
    })(DBZ.DataOutputInfomation || (DBZ.DataOutputInfomation = {}));
    var DataOutputInfomation = DBZ.DataOutputInfomation;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (DataOutputInfomation) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new DataOutputInfomation.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        DataOutputInfomation.PublicProperties = PublicProperties;
    })(DBZ.DataOutputInfomation || (DBZ.DataOutputInfomation = {}));
    var DataOutputInfomation = DBZ.DataOutputInfomation;
})(DBZ || (DBZ = {}));
