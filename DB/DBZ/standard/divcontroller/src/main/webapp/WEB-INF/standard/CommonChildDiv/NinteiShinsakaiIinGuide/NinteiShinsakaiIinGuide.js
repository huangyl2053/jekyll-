var DBZ;
(function (DBZ) {
    (function (NinteiShinsakaiIinGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinsakaiIinGuide.Controls(fieldName);

                this.controls.ShosaiJoken().isOpen = false;
                this.controls.ShinsakaiIinIchiran().isOpen = false;
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiShinsakaiIinGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        NinteiShinsakaiIinGuide.ModeController = ModeController;
    })(DBZ.NinteiShinsakaiIinGuide || (DBZ.NinteiShinsakaiIinGuide = {}));
    var NinteiShinsakaiIinGuide = DBZ.NinteiShinsakaiIinGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiShinsakaiIinGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinsakaiIinGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiShinsakaiIinGuide.PublicProperties = PublicProperties;
    })(DBZ.NinteiShinsakaiIinGuide || (DBZ.NinteiShinsakaiIinGuide = {}));
    var NinteiShinsakaiIinGuide = DBZ.NinteiShinsakaiIinGuide;
})(DBZ || (DBZ = {}));
