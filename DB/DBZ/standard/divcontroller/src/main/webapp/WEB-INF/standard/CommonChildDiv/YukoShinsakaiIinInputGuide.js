var DBE;
(function (DBE) {
    (function (YukoShinsakaiIinInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new YukoShinsakaiIinInputGuide.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        YukoShinsakaiIinInputGuide.ModeController = ModeController;
    })(DBE.YukoShinsakaiIinInputGuide || (DBE.YukoShinsakaiIinInputGuide = {}));
    var YukoShinsakaiIinInputGuide = DBE.YukoShinsakaiIinInputGuide;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (YukoShinsakaiIinInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new YukoShinsakaiIinInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        YukoShinsakaiIinInputGuide.PublicProperties = PublicProperties;
    })(DBE.YukoShinsakaiIinInputGuide || (DBE.YukoShinsakaiIinInputGuide = {}));
    var YukoShinsakaiIinInputGuide = DBE.YukoShinsakaiIinInputGuide;
})(DBE || (DBE = {}));
