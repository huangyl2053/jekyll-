var DBZ;
(function (DBZ) {
    (function (SogoShokaiKogakuKaigoServicehiInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiKogakuKaigoServicehiInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiKogakuKaigoServicehiInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiKogakuKaigoServicehiInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiKogakuKaigoServicehiInfo || (DBZ.SogoShokaiKogakuKaigoServicehiInfo = {}));
    var SogoShokaiKogakuKaigoServicehiInfo = DBZ.SogoShokaiKogakuKaigoServicehiInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiKogakuKaigoServicehiInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiKogakuKaigoServicehiInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiKogakuKaigoServicehiInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiKogakuKaigoServicehiInfo || (DBZ.SogoShokaiKogakuKaigoServicehiInfo = {}));
    var SogoShokaiKogakuKaigoServicehiInfo = DBZ.SogoShokaiKogakuKaigoServicehiInfo;
})(DBZ || (DBZ = {}));
