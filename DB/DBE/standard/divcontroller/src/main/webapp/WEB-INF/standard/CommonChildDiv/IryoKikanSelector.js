var DBE;
(function (DBE) {
    (function (IryoKikanSelector) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IryoKikanSelector.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        IryoKikanSelector.ModeController = ModeController;
    })(DBE.IryoKikanSelector || (DBE.IryoKikanSelector = {}));
    var IryoKikanSelector = DBE.IryoKikanSelector;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (IryoKikanSelector) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new IryoKikanSelector.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IryoKikanSelector.PublicProperties = PublicProperties;
    })(DBE.IryoKikanSelector || (DBE.IryoKikanSelector = {}));
    var IryoKikanSelector = DBE.IryoKikanSelector;
})(DBE || (DBE = {}));
