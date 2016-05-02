var DBD;
(function (DBD) {
    (function (HikazeiNenkinShokai) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HikazeiNenkinShokai.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HikazeiNenkinShokai.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HikazeiNenkinShokai.ModeController = ModeController;
    })(DBD.HikazeiNenkinShokai || (DBD.HikazeiNenkinShokai = {}));
    var HikazeiNenkinShokai = DBD.HikazeiNenkinShokai;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (HikazeiNenkinShokai) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HikazeiNenkinShokai.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HikazeiNenkinShokai.PublicProperties = PublicProperties;
    })(DBD.HikazeiNenkinShokai || (DBD.HikazeiNenkinShokai = {}));
    var HikazeiNenkinShokai = DBD.HikazeiNenkinShokai;
})(DBD || (DBD = {}));
