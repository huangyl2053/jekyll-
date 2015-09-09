var DBE;
(function (DBE) {
    (function (IraishoChosahyoIkenshoPrint) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IraishoChosahyoIkenshoPrint.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new IraishoChosahyoIkenshoPrint.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        IraishoChosahyoIkenshoPrint.ModeController = ModeController;
    })(DBE.IraishoChosahyoIkenshoPrint || (DBE.IraishoChosahyoIkenshoPrint = {}));
    var IraishoChosahyoIkenshoPrint = DBE.IraishoChosahyoIkenshoPrint;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (IraishoChosahyoIkenshoPrint) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IraishoChosahyoIkenshoPrint.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IraishoChosahyoIkenshoPrint.PublicProperties = PublicProperties;
    })(DBE.IraishoChosahyoIkenshoPrint || (DBE.IraishoChosahyoIkenshoPrint = {}));
    var IraishoChosahyoIkenshoPrint = DBE.IraishoChosahyoIkenshoPrint;
})(DBE || (DBE = {}));
