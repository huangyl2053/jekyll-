var DBZ;
(function (DBZ) {
    (function (ShinsakaiJohoKojin) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShinsakaiJohoKojin.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShinsakaiJohoKojin.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShinsakaiJohoKojin.ModeController = ModeController;
    })(DBZ.ShinsakaiJohoKojin || (DBZ.ShinsakaiJohoKojin = {}));
    var ShinsakaiJohoKojin = DBZ.ShinsakaiJohoKojin;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShinsakaiJohoKojin) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShinsakaiJohoKojin.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShinsakaiJohoKojin.PublicProperties = PublicProperties;
    })(DBZ.ShinsakaiJohoKojin || (DBZ.ShinsakaiJohoKojin = {}));
    var ShinsakaiJohoKojin = DBZ.ShinsakaiJohoKojin;
})(DBZ || (DBZ = {}));
