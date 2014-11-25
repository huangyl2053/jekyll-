var DBE;
(function (DBE) {
    (function (IchijiHanteiKekkaInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IchijiHanteiKekkaInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        IchijiHanteiKekkaInfo.ModeController = ModeController;
    })(DBE.IchijiHanteiKekkaInfo || (DBE.IchijiHanteiKekkaInfo = {}));
    var IchijiHanteiKekkaInfo = DBE.IchijiHanteiKekkaInfo;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (IchijiHanteiKekkaInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new IchijiHanteiKekkaInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IchijiHanteiKekkaInfo.PublicProperties = PublicProperties;
    })(DBE.IchijiHanteiKekkaInfo || (DBE.IchijiHanteiKekkaInfo = {}));
    var IchijiHanteiKekkaInfo = DBE.IchijiHanteiKekkaInfo;
})(DBE || (DBE = {}));
