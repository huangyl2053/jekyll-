var DBD;
(function (DBD) {
    (function (AtokureishisetsuNyutaishoJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new AtokureishisetsuNyutaishoJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new AtokureishisetsuNyutaishoJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        AtokureishisetsuNyutaishoJoho.ModeController = ModeController;
    })(DBD.AtokureishisetsuNyutaishoJoho || (DBD.AtokureishisetsuNyutaishoJoho = {}));
    var AtokureishisetsuNyutaishoJoho = DBD.AtokureishisetsuNyutaishoJoho;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (AtokureishisetsuNyutaishoJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new AtokureishisetsuNyutaishoJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        AtokureishisetsuNyutaishoJoho.PublicProperties = PublicProperties;
    })(DBD.AtokureishisetsuNyutaishoJoho || (DBD.AtokureishisetsuNyutaishoJoho = {}));
    var AtokureishisetsuNyutaishoJoho = DBD.AtokureishisetsuNyutaishoJoho;
})(DBD || (DBD = {}));
