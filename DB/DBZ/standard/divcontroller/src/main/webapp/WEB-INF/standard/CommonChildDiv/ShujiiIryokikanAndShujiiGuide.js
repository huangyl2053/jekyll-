var DBZ;
(function (DBZ) {
    (function (ShujiiIryokikanAndShujiiGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShujiiIryokikanAndShujiiGuide.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShujiiIryokikanAndShujiiGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShujiiIryokikanAndShujiiGuide.ModeController = ModeController;
    })(DBZ.ShujiiIryokikanAndShujiiGuide || (DBZ.ShujiiIryokikanAndShujiiGuide = {}));
    var ShujiiIryokikanAndShujiiGuide = DBZ.ShujiiIryokikanAndShujiiGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShujiiIryokikanAndShujiiGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShujiiIryokikanAndShujiiGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShujiiIryokikanAndShujiiGuide.PublicProperties = PublicProperties;
    })(DBZ.ShujiiIryokikanAndShujiiGuide || (DBZ.ShujiiIryokikanAndShujiiGuide = {}));
    var ShujiiIryokikanAndShujiiGuide = DBZ.ShujiiIryokikanAndShujiiGuide;
})(DBZ || (DBZ = {}));
