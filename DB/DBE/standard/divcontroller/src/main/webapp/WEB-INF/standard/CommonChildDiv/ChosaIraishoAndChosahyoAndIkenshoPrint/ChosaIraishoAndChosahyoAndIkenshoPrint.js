var DBE;
(function (DBE) {
    (function (ChosaIraishoAndChosahyoAndIkenshoPrint) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaIraishoAndChosahyoAndIkenshoPrint.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ChosaIraishoAndChosahyoAndIkenshoPrint.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ChosaIraishoAndChosahyoAndIkenshoPrint.ModeController = ModeController;
    })(DBE.ChosaIraishoAndChosahyoAndIkenshoPrint || (DBE.ChosaIraishoAndChosahyoAndIkenshoPrint = {}));
    var ChosaIraishoAndChosahyoAndIkenshoPrint = DBE.ChosaIraishoAndChosahyoAndIkenshoPrint;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ChosaIraishoAndChosahyoAndIkenshoPrint) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaIraishoAndChosahyoAndIkenshoPrint.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChosaIraishoAndChosahyoAndIkenshoPrint.PublicProperties = PublicProperties;
    })(DBE.ChosaIraishoAndChosahyoAndIkenshoPrint || (DBE.ChosaIraishoAndChosahyoAndIkenshoPrint = {}));
    var ChosaIraishoAndChosahyoAndIkenshoPrint = DBE.ChosaIraishoAndChosahyoAndIkenshoPrint;
})(DBE || (DBE = {}));
