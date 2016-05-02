var DBZ;
(function (DBZ) {
    (function (RoreiFukushiNenkinJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RoreiFukushiNenkinJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new RoreiFukushiNenkinJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        RoreiFukushiNenkinJoho.ModeController = ModeController;
    })(DBZ.RoreiFukushiNenkinJoho || (DBZ.RoreiFukushiNenkinJoho = {}));
    var RoreiFukushiNenkinJoho = DBZ.RoreiFukushiNenkinJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (RoreiFukushiNenkinJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RoreiFukushiNenkinJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        RoreiFukushiNenkinJoho.PublicProperties = PublicProperties;
    })(DBZ.RoreiFukushiNenkinJoho || (DBZ.RoreiFukushiNenkinJoho = {}));
    var RoreiFukushiNenkinJoho = DBZ.RoreiFukushiNenkinJoho;
})(DBZ || (DBZ = {}));
