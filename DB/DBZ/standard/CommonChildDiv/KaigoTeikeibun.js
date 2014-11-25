var DBZ;
(function (DBZ) {
    (function (KaigoTeikeibun) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoTeikeibun.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KaigoTeikeibun.ModeController = ModeController;
    })(DBZ.KaigoTeikeibun || (DBZ.KaigoTeikeibun = {}));
    var KaigoTeikeibun = DBZ.KaigoTeikeibun;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoTeikeibun) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KaigoTeikeibun.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoTeikeibun.PublicProperties = PublicProperties;
    })(DBZ.KaigoTeikeibun || (DBZ.KaigoTeikeibun = {}));
    var KaigoTeikeibun = DBZ.KaigoTeikeibun;
})(DBZ || (DBZ = {}));
