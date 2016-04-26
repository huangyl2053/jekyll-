var DBD;
(function (DBD) {
    (function (tokureishisetsuNyutaishoJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new tokureishisetsuNyutaishoJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new tokureishisetsuNyutaishoJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        tokureishisetsuNyutaishoJoho.ModeController = ModeController;
    })(DBD.tokureishisetsuNyutaishoJoho || (DBD.tokureishisetsuNyutaishoJoho = {}));
    var tokureishisetsuNyutaishoJoho = DBD.tokureishisetsuNyutaishoJoho;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (tokureishisetsuNyutaishoJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new tokureishisetsuNyutaishoJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        tokureishisetsuNyutaishoJoho.PublicProperties = PublicProperties;
    })(DBD.tokureishisetsuNyutaishoJoho || (DBD.tokureishisetsuNyutaishoJoho = {}));
    var tokureishisetsuNyutaishoJoho = DBD.tokureishisetsuNyutaishoJoho;
})(DBD || (DBD = {}));
