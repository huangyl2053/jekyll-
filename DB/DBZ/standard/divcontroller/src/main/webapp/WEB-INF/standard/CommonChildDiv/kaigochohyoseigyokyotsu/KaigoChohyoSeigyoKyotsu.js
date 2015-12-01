var DBZ;
(function (DBZ) {
    (function (KaigoChohyoSeigyoKyotsu) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoChohyoSeigyoKyotsu.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoChohyoSeigyoKyotsu.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoChohyoSeigyoKyotsu.ModeController = ModeController;
    })(DBZ.KaigoChohyoSeigyoKyotsu || (DBZ.KaigoChohyoSeigyoKyotsu = {}));
    var KaigoChohyoSeigyoKyotsu = DBZ.KaigoChohyoSeigyoKyotsu;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoChohyoSeigyoKyotsu) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoChohyoSeigyoKyotsu.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoChohyoSeigyoKyotsu.PublicProperties = PublicProperties;
    })(DBZ.KaigoChohyoSeigyoKyotsu || (DBZ.KaigoChohyoSeigyoKyotsu = {}));
    var KaigoChohyoSeigyoKyotsu = DBZ.KaigoChohyoSeigyoKyotsu;
})(DBZ || (DBZ = {}));
