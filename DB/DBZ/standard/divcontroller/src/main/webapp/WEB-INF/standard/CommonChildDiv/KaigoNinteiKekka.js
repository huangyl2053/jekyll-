var DBE;
(function (DBE) {
    (function (KaigoNinteiKekka) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoNinteiKekka.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KaigoNinteiKekka.ModeController = ModeController;
    })(DBE.KaigoNinteiKekka || (DBE.KaigoNinteiKekka = {}));
    var KaigoNinteiKekka = DBE.KaigoNinteiKekka;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (KaigoNinteiKekka) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KaigoNinteiKekka.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("selectDdlNijiHantei", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("selectDdlNinteiYukoTsukisu", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("selectDdlNinteiKubun", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getselectDdlNijiHantei = function () {
                return this.controls.ddlNijiHanteiKekka().onChange;
            };

            PublicProperties.prototype.setselectDdlNijiHantei = function (value) {
                this.controls.ddlNijiHanteiKekka().onChange = value;
            };

            PublicProperties.prototype.getselectDdlNinteiYukoTsukisu = function () {
                return this.controls.ddlNinteiYukoTsukisu().onChange;
            };

            PublicProperties.prototype.setselectDdlNinteiYukoTsukisu = function (value) {
                this.controls.ddlNinteiYukoTsukisu().onChange = value;
            };

            PublicProperties.prototype.getselectDdlNinteiKubun = function () {
                return this.controls.ddlNinteiKubun().onChange;
            };

            PublicProperties.prototype.setselectDdlNinteiKubun = function (value) {
                this.controls.ddlNinteiKubun().onChange = value;
            };
            return PublicProperties;
        })();
        KaigoNinteiKekka.PublicProperties = PublicProperties;
    })(DBE.KaigoNinteiKekka || (DBE.KaigoNinteiKekka = {}));
    var KaigoNinteiKekka = DBE.KaigoNinteiKekka;
})(DBE || (DBE = {}));
