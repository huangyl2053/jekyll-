var DBE;
(function (DBE) {
    (function (HanteiKekkaIchiranShinsakaiPrint) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HanteiKekkaIchiranShinsakaiPrint.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HanteiKekkaIchiranShinsakaiPrint.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HanteiKekkaIchiranShinsakaiPrint.ModeController = ModeController;
    })(DBE.HanteiKekkaIchiranShinsakaiPrint || (DBE.HanteiKekkaIchiranShinsakaiPrint = {}));
    var HanteiKekkaIchiranShinsakaiPrint = DBE.HanteiKekkaIchiranShinsakaiPrint;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (HanteiKekkaIchiranShinsakaiPrint) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HanteiKekkaIchiranShinsakaiPrint.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HanteiKekkaIchiranShinsakaiPrint.PublicProperties = PublicProperties;
    })(DBE.HanteiKekkaIchiranShinsakaiPrint || (DBE.HanteiKekkaIchiranShinsakaiPrint = {}));
    var HanteiKekkaIchiranShinsakaiPrint = DBE.HanteiKekkaIchiranShinsakaiPrint;
})(DBE || (DBE = {}));
