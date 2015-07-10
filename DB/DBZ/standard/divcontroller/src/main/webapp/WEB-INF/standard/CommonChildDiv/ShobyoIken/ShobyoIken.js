var DBZ;
(function (DBZ) {
    (function (ShobyoIken) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShobyoIken.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShobyoIken.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShobyoIken.ModeController = ModeController;
    })(DBZ.ShobyoIken || (DBZ.ShobyoIken = {}));
    var ShobyoIken = DBZ.ShobyoIken;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShobyoIken) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShobyoIken.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShobyoIken.PublicProperties = PublicProperties;
    })(DBZ.ShobyoIken || (DBZ.ShobyoIken = {}));
    var ShobyoIken = DBZ.ShobyoIken;
})(DBZ || (DBZ = {}));
