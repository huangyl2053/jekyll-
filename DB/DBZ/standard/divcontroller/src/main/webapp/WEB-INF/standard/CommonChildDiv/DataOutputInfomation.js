var DBE;
(function (DBE) {
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
    })(DBE.DataOutputInfomation || (DBE.DataOutputInfomation = {}));
    var DataOutputInfomation = DBE.DataOutputInfomation;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
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
    })(DBE.DataOutputInfomation || (DBE.DataOutputInfomation = {}));
    var DataOutputInfomation = DBE.DataOutputInfomation;
})(DBE || (DBE = {}));
