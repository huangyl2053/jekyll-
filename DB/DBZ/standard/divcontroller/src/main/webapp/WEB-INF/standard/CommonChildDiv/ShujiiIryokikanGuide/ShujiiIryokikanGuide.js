var DBZ;
(function (DBZ) {
    (function (ShujiiIryokikanGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShujiiIryokikanGuide.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShujiiIryokikanGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShujiiIryokikanGuide.ModeController = ModeController;
    })(DBZ.ShujiiIryokikanGuide || (DBZ.ShujiiIryokikanGuide = {}));
    var ShujiiIryokikanGuide = DBZ.ShujiiIryokikanGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShujiiIryokikanGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShujiiIryokikanGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShujiiIryokikanGuide.PublicProperties = PublicProperties;
    })(DBZ.ShujiiIryokikanGuide || (DBZ.ShujiiIryokikanGuide = {}));
    var ShujiiIryokikanGuide = DBZ.ShujiiIryokikanGuide;
})(DBZ || (DBZ = {}));
