var DBE;
(function (DBE) {
    (function (ShinsakaiIinList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShinsakaiIinList.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ShinsakaiIinList.ModeController = ModeController;
    })(DBE.ShinsakaiIinList || (DBE.ShinsakaiIinList = {}));
    var ShinsakaiIinList = DBE.ShinsakaiIinList;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ShinsakaiIinList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShinsakaiIinList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShinsakaiIinList.PublicProperties = PublicProperties;
    })(DBE.ShinsakaiIinList || (DBE.ShinsakaiIinList = {}));
    var ShinsakaiIinList = DBE.ShinsakaiIinList;
})(DBE || (DBE = {}));
