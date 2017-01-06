var DBE;
(function (DBE) {
    (function (OnseiFileOperator) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new OnseiFileOperator.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new OnseiFileOperator.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        OnseiFileOperator.ModeController = ModeController;
    })(DBE.OnseiFileOperator || (DBE.OnseiFileOperator = {}));
    var OnseiFileOperator = DBE.OnseiFileOperator;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (OnseiFileOperator) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new OnseiFileOperator.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        OnseiFileOperator.PublicProperties = PublicProperties;
    })(DBE.OnseiFileOperator || (DBE.OnseiFileOperator = {}));
    var OnseiFileOperator = DBE.OnseiFileOperator;
})(DBE || (DBE = {}));
