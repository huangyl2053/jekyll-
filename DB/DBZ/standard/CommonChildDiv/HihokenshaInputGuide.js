var DBZ;
(function (DBZ) {
    (function (HihokenshaInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HihokenshaInputGuide.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        HihokenshaInputGuide.ModeController = ModeController;
    })(DBZ.HihokenshaInputGuide || (DBZ.HihokenshaInputGuide = {}));
    var HihokenshaInputGuide = DBZ.HihokenshaInputGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HihokenshaInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HihokenshaInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HihokenshaInputGuide.PublicProperties = PublicProperties;
    })(DBZ.HihokenshaInputGuide || (DBZ.HihokenshaInputGuide = {}));
    var HihokenshaInputGuide = DBZ.HihokenshaInputGuide;
})(DBZ || (DBZ = {}));
