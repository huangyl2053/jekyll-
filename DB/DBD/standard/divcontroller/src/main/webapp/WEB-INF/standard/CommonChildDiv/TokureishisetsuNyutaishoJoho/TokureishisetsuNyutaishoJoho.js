var DBD;
(function (DBD) {
    (function (TokureishisetsuNyutaishoJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokureishisetsuNyutaishoJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TokureishisetsuNyutaishoJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TokureishisetsuNyutaishoJoho.ModeController = ModeController;
    })(DBD.TokureishisetsuNyutaishoJoho || (DBD.TokureishisetsuNyutaishoJoho = {}));
    var TokureishisetsuNyutaishoJoho = DBD.TokureishisetsuNyutaishoJoho;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (TokureishisetsuNyutaishoJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokureishisetsuNyutaishoJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TokureishisetsuNyutaishoJoho.PublicProperties = PublicProperties;
    })(DBD.TokureishisetsuNyutaishoJoho || (DBD.TokureishisetsuNyutaishoJoho = {}));
    var TokureishisetsuNyutaishoJoho = DBD.TokureishisetsuNyutaishoJoho;
})(DBD || (DBD = {}));
