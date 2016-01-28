var DBA;
(function (DBA) {
    (function (RoreiFukushiNenkinShokai) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RoreiFukushiNenkinShokai.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new RoreiFukushiNenkinShokai.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        RoreiFukushiNenkinShokai.ModeController = ModeController;
    })(DBA.RoreiFukushiNenkinShokai || (DBA.RoreiFukushiNenkinShokai = {}));
    var RoreiFukushiNenkinShokai = DBA.RoreiFukushiNenkinShokai;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (RoreiFukushiNenkinShokai) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RoreiFukushiNenkinShokai.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        RoreiFukushiNenkinShokai.PublicProperties = PublicProperties;
    })(DBA.RoreiFukushiNenkinShokai || (DBA.RoreiFukushiNenkinShokai = {}));
    var RoreiFukushiNenkinShokai = DBA.RoreiFukushiNenkinShokai;
})(DBA || (DBA = {}));
