var DBX;
(function (DBX) {
    (function (JigyoshaList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JigyoshaList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JigyoshaList.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JigyoshaList.ModeController = ModeController;
    })(DBX.JigyoshaList || (DBX.JigyoshaList = {}));
    var JigyoshaList = DBX.JigyoshaList;
})(DBX || (DBX = {}));

var DBX;
(function (DBX) {
    (function (JigyoshaList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JigyoshaList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JigyoshaList.PublicProperties = PublicProperties;
    })(DBX.JigyoshaList || (DBX.JigyoshaList = {}));
    var JigyoshaList = DBX.JigyoshaList;
})(DBX || (DBX = {}));
