var DBE;
(function (DBE) {
    (function (ShujiiIryokikanAndShujiiInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShujiiIryokikanAndShujiiInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShujiiIryokikanAndShujiiInput.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShujiiIryokikanAndShujiiInput.ModeController = ModeController;
    })(DBE.ShujiiIryokikanAndShujiiInput || (DBE.ShujiiIryokikanAndShujiiInput = {}));
    var ShujiiIryokikanAndShujiiInput = DBE.ShujiiIryokikanAndShujiiInput;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ShujiiIryokikanAndShujiiInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShujiiIryokikanAndShujiiInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShujiiIryokikanAndShujiiInput.PublicProperties = PublicProperties;
    })(DBE.ShujiiIryokikanAndShujiiInput || (DBE.ShujiiIryokikanAndShujiiInput = {}));
    var ShujiiIryokikanAndShujiiInput = DBE.ShujiiIryokikanAndShujiiInput;
})(DBE || (DBE = {}));
