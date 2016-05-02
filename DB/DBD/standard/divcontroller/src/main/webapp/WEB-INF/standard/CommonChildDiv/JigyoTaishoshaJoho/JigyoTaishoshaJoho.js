var DBD;
(function (DBD) {
    (function (JigyoTaishoshaJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JigyoTaishoshaJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JigyoTaishoshaJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JigyoTaishoshaJoho.ModeController = ModeController;
    })(DBD.JigyoTaishoshaJoho || (DBD.JigyoTaishoshaJoho = {}));
    var JigyoTaishoshaJoho = DBD.JigyoTaishoshaJoho;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (JigyoTaishoshaJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JigyoTaishoshaJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JigyoTaishoshaJoho.PublicProperties = PublicProperties;
    })(DBD.JigyoTaishoshaJoho || (DBD.JigyoTaishoshaJoho = {}));
    var JigyoTaishoshaJoho = DBD.JigyoTaishoshaJoho;
})(DBD || (DBD = {}));
