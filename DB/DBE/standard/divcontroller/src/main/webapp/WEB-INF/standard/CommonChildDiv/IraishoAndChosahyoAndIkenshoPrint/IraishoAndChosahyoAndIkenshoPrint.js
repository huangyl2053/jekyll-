var DBE;
(function (DBE) {
    (function (IraishoAndChosahyoAndIkenshoPrint) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IraishoAndChosahyoAndIkenshoPrint.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new IraishoAndChosahyoAndIkenshoPrint.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        IraishoAndChosahyoAndIkenshoPrint.ModeController = ModeController;
    })(DBE.IraishoAndChosahyoAndIkenshoPrint || (DBE.IraishoAndChosahyoAndIkenshoPrint = {}));
    var IraishoAndChosahyoAndIkenshoPrint = DBE.IraishoAndChosahyoAndIkenshoPrint;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (IraishoAndChosahyoAndIkenshoPrint) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IraishoAndChosahyoAndIkenshoPrint.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IraishoAndChosahyoAndIkenshoPrint.PublicProperties = PublicProperties;
    })(DBE.IraishoAndChosahyoAndIkenshoPrint || (DBE.IraishoAndChosahyoAndIkenshoPrint = {}));
    var IraishoAndChosahyoAndIkenshoPrint = DBE.IraishoAndChosahyoAndIkenshoPrint;
})(DBE || (DBE = {}));
