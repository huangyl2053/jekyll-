var DBD;
(function (DBD) {
    (function (IchijiSashitome2Go) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IchijiSashitome2Go.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new IchijiSashitome2Go.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        IchijiSashitome2Go.ModeController = ModeController;
    })(DBD.IchijiSashitome2Go || (DBD.IchijiSashitome2Go = {}));
    var IchijiSashitome2Go = DBD.IchijiSashitome2Go;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (IchijiSashitome2Go) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IchijiSashitome2Go.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IchijiSashitome2Go.PublicProperties = PublicProperties;
    })(DBD.IchijiSashitome2Go || (DBD.IchijiSashitome2Go = {}));
    var IchijiSashitome2Go = DBD.IchijiSashitome2Go;
})(DBD || (DBD = {}));
