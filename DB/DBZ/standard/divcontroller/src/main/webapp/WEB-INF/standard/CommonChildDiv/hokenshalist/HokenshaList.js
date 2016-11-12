var DBZ;
(function (DBZ) {
    (function (HokenshaList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HokenshaList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HokenshaList.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HokenshaList.ModeController = ModeController;
    })(DBZ.HokenshaList || (DBZ.HokenshaList = {}));
    var HokenshaList = DBZ.HokenshaList;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HokenshaList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HokenshaList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HokenshaList.PublicProperties = PublicProperties;
    })(DBZ.HokenshaList || (DBZ.HokenshaList = {}));
    var HokenshaList = DBZ.HokenshaList;
})(DBZ || (DBZ = {}));
