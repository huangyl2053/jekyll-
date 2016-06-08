var DBZ;
(function (DBZ) {
    (function (KaigoToiawasesaki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoToiawasesaki.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoToiawasesaki.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoToiawasesaki.ModeController = ModeController;
    })(DBZ.KaigoToiawasesaki || (DBZ.KaigoToiawasesaki = {}));
    var KaigoToiawasesaki = DBZ.KaigoToiawasesaki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoToiawasesaki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoToiawasesaki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoToiawasesaki.PublicProperties = PublicProperties;
    })(DBZ.KaigoToiawasesaki || (DBZ.KaigoToiawasesaki = {}));
    var KaigoToiawasesaki = DBZ.KaigoToiawasesaki;
})(DBZ || (DBZ = {}));
