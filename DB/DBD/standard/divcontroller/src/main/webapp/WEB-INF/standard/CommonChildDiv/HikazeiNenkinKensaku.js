var DBD;
(function (DBD) {
    (function (HikazeiNenkinKensaku) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HikazeiNenkinKensaku.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HikazeiNenkinKensaku.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HikazeiNenkinKensaku.ModeController = ModeController;
    })(DBD.HikazeiNenkinKensaku || (DBD.HikazeiNenkinKensaku = {}));
    var HikazeiNenkinKensaku = DBD.HikazeiNenkinKensaku;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (HikazeiNenkinKensaku) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HikazeiNenkinKensaku.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HikazeiNenkinKensaku.PublicProperties = PublicProperties;
    })(DBD.HikazeiNenkinKensaku || (DBD.HikazeiNenkinKensaku = {}));
    var HikazeiNenkinKensaku = DBD.HikazeiNenkinKensaku;
})(DBD || (DBD = {}));
