var DBE;
(function (DBE) {
    (function (HanteiKekkaIchiranPrint) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HanteiKekkaIchiranPrint.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HanteiKekkaIchiranPrint.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HanteiKekkaIchiranPrint.ModeController = ModeController;
    })(DBE.HanteiKekkaIchiranPrint || (DBE.HanteiKekkaIchiranPrint = {}));
    var HanteiKekkaIchiranPrint = DBE.HanteiKekkaIchiranPrint;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (HanteiKekkaIchiranPrint) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HanteiKekkaIchiranPrint.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HanteiKekkaIchiranPrint.PublicProperties = PublicProperties;
    })(DBE.HanteiKekkaIchiranPrint || (DBE.HanteiKekkaIchiranPrint = {}));
    var HanteiKekkaIchiranPrint = DBE.HanteiKekkaIchiranPrint;
})(DBE || (DBE = {}));
