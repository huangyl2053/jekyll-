var DBB;
(function (DBB) {
    (function (Kiwarigaku) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new Kiwarigaku.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        Kiwarigaku.ModeController = ModeController;
    })(DBB.Kiwarigaku || (DBB.Kiwarigaku = {}));
    var Kiwarigaku = DBB.Kiwarigaku;
})(DBB || (DBB = {}));

var DBB;
(function (DBB) {
    (function (Kiwarigaku) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new Kiwarigaku.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("TokuchoKiText1", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuchoKiText2", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuchoKiText3", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuchoKiText4", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuchoKiText5", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuchoKiText6", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuchoKiVisible1", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuchoKiVisible2", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuchoKiVisible3", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuchoKiVisible4", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuchoKiVisible5", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuchoKiVisible6", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuKibetsuGakuText1", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuKibetsuGakuText2", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuKibetsuGakuText3", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuKibetsuGakuText4", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuKibetsuGakuText5", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuKibetsuGakuText6", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuKibetsuGakuVisible1", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuKibetsuGakuVisible2", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuKibetsuGakuVisible3", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuKibetsuGakuVisible4", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuKibetsuGakuVisible5", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuKibetsuGakuVisible6", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText1", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuNofuGakuText2", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuNofuGakuText3", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuNofuGakuText4", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuNofuGakuText5", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuNofuGakuText6", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuNofuGakuText7", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText8", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText9", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText10", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText11", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText12", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText13", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText14", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible1", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible2", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible3", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible4", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible5", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible6", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible7", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible8", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible9", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible10", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible11", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible12", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible13", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible14", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiText1", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText2", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText3", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText4", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText5", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText6", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText7", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText8", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText9", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText10", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText11", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText12", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText13", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText14", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiVisible1", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible2", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible3", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible4", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible5", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible6", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible7", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible8", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible9", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible10", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible11", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible12", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible13", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible14", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuText1", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText2", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText3", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText4", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText5", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText6", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText7", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText8", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText9", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText10", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText11", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText12", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText13", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText14", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuVisible1", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible2", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible3", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible4", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible5", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible6", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible7", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible8", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible9", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible10", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible11", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible12", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible13", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible14", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuText1", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText2", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText3", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText4", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText5", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText6", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText7", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText8", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText9", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText10", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText11", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText12", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText13", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText14", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuVisible1", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible2", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible3", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible4", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible5", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible6", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible7", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible8", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible9", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible10", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible11", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible12", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible13", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible14", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuKibetsugakuKeiText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuKibetsugakuKeiVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofugakuKeiText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuNofugakuKeiVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsugakuKeiText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsugakuKeiVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNoufugakuKeiText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofugakuKeiVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getTokuchoKiText1 = function () {
                return this.controls.lblTokuchoKi1().text;
            };

            PublicProperties.prototype.setTokuchoKiText1 = function (value) {
                this.controls.lblTokuchoKi1().text = value;
            };

            PublicProperties.prototype.getTokuchoKiText2 = function () {
                return this.controls.lblTokuchoKi2().text;
            };

            PublicProperties.prototype.setTokuchoKiText2 = function (value) {
                this.controls.lblTokuchoKi2().text = value;
            };

            PublicProperties.prototype.getTokuchoKiText3 = function () {
                return this.controls.lblTokuchoKi3().text;
            };

            PublicProperties.prototype.setTokuchoKiText3 = function (value) {
                this.controls.lblTokuchoKi3().text = value;
            };

            PublicProperties.prototype.getTokuchoKiText4 = function () {
                return this.controls.lblTokuchoKi4().text;
            };

            PublicProperties.prototype.setTokuchoKiText4 = function (value) {
                this.controls.lblTokuchoKi4().text = value;
            };

            PublicProperties.prototype.getTokuchoKiText5 = function () {
                return this.controls.lblTokuchoKi5().text;
            };

            PublicProperties.prototype.setTokuchoKiText5 = function (value) {
                this.controls.lblTokuchoKi5().text = value;
            };

            PublicProperties.prototype.getTokuchoKiText6 = function () {
                return this.controls.lblTokuchoKi6().text;
            };

            PublicProperties.prototype.setTokuchoKiText6 = function (value) {
                this.controls.lblTokuchoKi6().text = value;
            };

            PublicProperties.prototype.getTokuchoKiVisible1 = function () {
                return this.controls.lblTokuchoKi1().visible;
            };

            PublicProperties.prototype.setTokuchoKiVisible1 = function (value) {
                this.controls.lblTokuchoKi1().visible = value;
            };

            PublicProperties.prototype.getTokuchoKiVisible2 = function () {
                return this.controls.lblTokuchoKi2().visible;
            };

            PublicProperties.prototype.setTokuchoKiVisible2 = function (value) {
                this.controls.lblTokuchoKi2().visible = value;
            };

            PublicProperties.prototype.getTokuchoKiVisible3 = function () {
                return this.controls.lblTokuchoKi3().visible;
            };

            PublicProperties.prototype.setTokuchoKiVisible3 = function (value) {
                this.controls.lblTokuchoKi3().visible = value;
            };

            PublicProperties.prototype.getTokuchoKiVisible4 = function () {
                return this.controls.lblTokuchoKi4().visible;
            };

            PublicProperties.prototype.setTokuchoKiVisible4 = function (value) {
                this.controls.lblTokuchoKi4().visible = value;
            };

            PublicProperties.prototype.getTokuchoKiVisible5 = function () {
                return this.controls.lblTokuchoKi5().visible;
            };

            PublicProperties.prototype.setTokuchoKiVisible5 = function (value) {
                this.controls.lblTokuchoKi5().visible = value;
            };

            PublicProperties.prototype.getTokuchoKiVisible6 = function () {
                return this.controls.lblTokuchoKi6().visible;
            };

            PublicProperties.prototype.setTokuchoKiVisible6 = function (value) {
                this.controls.lblTokuchoKi6().visible = value;
            };

            PublicProperties.prototype.getTokuKibetsuGakuText1 = function () {
                return this.controls.lblTokuKibetsuGaku1().text;
            };

            PublicProperties.prototype.setTokuKibetsuGakuText1 = function (value) {
                this.controls.lblTokuKibetsuGaku1().text = value;
            };

            PublicProperties.prototype.getTokuKibetsuGakuText2 = function () {
                return this.controls.lblTokuKibetsuGaku2().text;
            };

            PublicProperties.prototype.setTokuKibetsuGakuText2 = function (value) {
                this.controls.lblTokuKibetsuGaku2().text = value;
            };

            PublicProperties.prototype.getTokuKibetsuGakuText3 = function () {
                return this.controls.lblTokuKibetsuGaku3().text;
            };

            PublicProperties.prototype.setTokuKibetsuGakuText3 = function (value) {
                this.controls.lblTokuKibetsuGaku3().text = value;
            };

            PublicProperties.prototype.getTokuKibetsuGakuText4 = function () {
                return this.controls.lblTokuKibetsuGaku4().text;
            };

            PublicProperties.prototype.setTokuKibetsuGakuText4 = function (value) {
                this.controls.lblTokuKibetsuGaku4().text = value;
            };

            PublicProperties.prototype.getTokuKibetsuGakuText5 = function () {
                return this.controls.lblTokuKibetsuGaku5().text;
            };

            PublicProperties.prototype.setTokuKibetsuGakuText5 = function (value) {
                this.controls.lblTokuKibetsuGaku5().text = value;
            };

            PublicProperties.prototype.getTokuKibetsuGakuText6 = function () {
                return this.controls.lblTokuKibetsuGaku6().text;
            };

            PublicProperties.prototype.setTokuKibetsuGakuText6 = function (value) {
                this.controls.lblTokuKibetsuGaku6().text = value;
            };

            PublicProperties.prototype.getTokuKibetsuGakuVisible1 = function () {
                return this.controls.lblTokuKibetsuGaku1().visible;
            };

            PublicProperties.prototype.setTokuKibetsuGakuVisible1 = function (value) {
                this.controls.lblTokuKibetsuGaku1().visible = value;
            };

            PublicProperties.prototype.getTokuKibetsuGakuVisible2 = function () {
                return this.controls.lblTokuKibetsuGaku2().visible;
            };

            PublicProperties.prototype.setTokuKibetsuGakuVisible2 = function (value) {
                this.controls.lblTokuKibetsuGaku2().visible = value;
            };

            PublicProperties.prototype.getTokuKibetsuGakuVisible3 = function () {
                return this.controls.lblTokuKibetsuGaku3().visible;
            };

            PublicProperties.prototype.setTokuKibetsuGakuVisible3 = function (value) {
                this.controls.lblTokuKibetsuGaku3().visible = value;
            };

            PublicProperties.prototype.getTokuKibetsuGakuVisible4 = function () {
                return this.controls.lblTokuKibetsuGaku4().visible;
            };

            PublicProperties.prototype.setTokuKibetsuGakuVisible4 = function (value) {
                this.controls.lblTokuKibetsuGaku4().visible = value;
            };

            PublicProperties.prototype.getTokuKibetsuGakuVisible5 = function () {
                return this.controls.lblTokuKibetsuGaku5().visible;
            };

            PublicProperties.prototype.setTokuKibetsuGakuVisible5 = function (value) {
                this.controls.lblTokuKibetsuGaku5().visible = value;
            };

            PublicProperties.prototype.getTokuKibetsuGakuVisible6 = function () {
                return this.controls.lblTokuKibetsuGaku6().visible;
            };

            PublicProperties.prototype.setTokuKibetsuGakuVisible6 = function (value) {
                this.controls.lblTokuKibetsuGaku6().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuText1 = function () {
                return this.controls.lblTokuNofuGaku1().text;
            };

            PublicProperties.prototype.setTokuNofuGakuText1 = function (value) {
                this.controls.lblTokuNofuGaku1().text = value;
            };

            PublicProperties.prototype.getTokuNofuGakuText2 = function () {
                return this.controls.lblTokuNofuGaku2().text;
            };

            PublicProperties.prototype.setTokuNofuGakuText2 = function (value) {
                this.controls.lblTokuNofuGaku2().text = value;
            };

            PublicProperties.prototype.getTokuNofuGakuText3 = function () {
                return this.controls.lblTokuNofuGaku3().text;
            };

            PublicProperties.prototype.setTokuNofuGakuText3 = function (value) {
                this.controls.lblTokuNofuGaku3().text = value;
            };

            PublicProperties.prototype.getTokuNofuGakuText4 = function () {
                return this.controls.lblTokuNofuGaku4().text;
            };

            PublicProperties.prototype.setTokuNofuGakuText4 = function (value) {
                this.controls.lblTokuNofuGaku4().text = value;
            };

            PublicProperties.prototype.getTokuNofuGakuText5 = function () {
                return this.controls.lblTokuNofuGaku5().text;
            };

            PublicProperties.prototype.setTokuNofuGakuText5 = function (value) {
                this.controls.lblTokuNofuGaku5().text = value;
            };

            PublicProperties.prototype.getTokuNofuGakuText6 = function () {
                return this.controls.lblTokuNofuGaku6().text;
            };

            PublicProperties.prototype.setTokuNofuGakuText6 = function (value) {
                this.controls.lblTokuNofuGaku6().text = value;
            };

            PublicProperties.prototype.getTokuNofuGakuText7 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuText7 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuText8 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuText8 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuText9 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuText9 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuText10 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuText10 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuText11 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuText11 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuText12 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuText12 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuText13 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuText13 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuText14 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuText14 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuVisible1 = function () {
                return this.controls.lblTokuNofuGaku1().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuVisible1 = function (value) {
                this.controls.lblTokuNofuGaku1().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuVisible2 = function () {
                return this.controls.lblTokuNofuGaku2().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuVisible2 = function (value) {
                this.controls.lblTokuNofuGaku2().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuVisible3 = function () {
                return this.controls.lblTokuNofuGaku3().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuVisible3 = function (value) {
                this.controls.lblTokuNofuGaku3().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuVisible4 = function () {
                return this.controls.lblTokuNofuGaku4().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuVisible4 = function (value) {
                this.controls.lblTokuNofuGaku4().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuVisible5 = function () {
                return this.controls.lblTokuNofuGaku5().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuVisible5 = function (value) {
                this.controls.lblTokuNofuGaku5().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuVisible6 = function () {
                return this.controls.lblTokuNofuGaku6().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuVisible6 = function (value) {
                this.controls.lblTokuNofuGaku6().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuVisible7 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuVisible7 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuVisible8 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuVisible8 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuVisible9 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuVisible9 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuVisible10 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuVisible10 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuVisible11 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuVisible11 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuVisible12 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuVisible12 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuVisible13 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuVisible13 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getTokuNofuGakuVisible14 = function () {
                return this.controls.Kiwarigaku().visible;
            };

            PublicProperties.prototype.setTokuNofuGakuVisible14 = function (value) {
                this.controls.Kiwarigaku().visible = value;
            };

            PublicProperties.prototype.getFuchoKiText1 = function () {
                return this.controls.lblFuchoKi1().text;
            };

            PublicProperties.prototype.setFuchoKiText1 = function (value) {
                this.controls.lblFuchoKi1().text = value;
            };

            PublicProperties.prototype.getFuchoKiText2 = function () {
                return this.controls.lblFuchoKi2().text;
            };

            PublicProperties.prototype.setFuchoKiText2 = function (value) {
                this.controls.lblFuchoKi2().text = value;
            };

            PublicProperties.prototype.getFuchoKiText3 = function () {
                return this.controls.lblFuchoKi3().text;
            };

            PublicProperties.prototype.setFuchoKiText3 = function (value) {
                this.controls.lblFuchoKi3().text = value;
            };

            PublicProperties.prototype.getFuchoKiText4 = function () {
                return this.controls.lblFuchoKi4().text;
            };

            PublicProperties.prototype.setFuchoKiText4 = function (value) {
                this.controls.lblFuchoKi4().text = value;
            };

            PublicProperties.prototype.getFuchoKiText5 = function () {
                return this.controls.lblFuchoKi5().text;
            };

            PublicProperties.prototype.setFuchoKiText5 = function (value) {
                this.controls.lblFuchoKi5().text = value;
            };

            PublicProperties.prototype.getFuchoKiText6 = function () {
                return this.controls.lblFuchoKi6().text;
            };

            PublicProperties.prototype.setFuchoKiText6 = function (value) {
                this.controls.lblFuchoKi6().text = value;
            };

            PublicProperties.prototype.getFuchoKiText7 = function () {
                return this.controls.lblFuchoKi7().text;
            };

            PublicProperties.prototype.setFuchoKiText7 = function (value) {
                this.controls.lblFuchoKi7().text = value;
            };

            PublicProperties.prototype.getFuchoKiText8 = function () {
                return this.controls.lblFuchoKi8().text;
            };

            PublicProperties.prototype.setFuchoKiText8 = function (value) {
                this.controls.lblFuchoKi8().text = value;
            };

            PublicProperties.prototype.getFuchoKiText9 = function () {
                return this.controls.lblFuchoKi9().text;
            };

            PublicProperties.prototype.setFuchoKiText9 = function (value) {
                this.controls.lblFuchoKi9().text = value;
            };

            PublicProperties.prototype.getFuchoKiText10 = function () {
                return this.controls.lblFuchoKi10().text;
            };

            PublicProperties.prototype.setFuchoKiText10 = function (value) {
                this.controls.lblFuchoKi10().text = value;
            };

            PublicProperties.prototype.getFuchoKiText11 = function () {
                return this.controls.lblFuchoKi11().text;
            };

            PublicProperties.prototype.setFuchoKiText11 = function (value) {
                this.controls.lblFuchoKi11().text = value;
            };

            PublicProperties.prototype.getFuchoKiText12 = function () {
                return this.controls.lblFuchoKi12().text;
            };

            PublicProperties.prototype.setFuchoKiText12 = function (value) {
                this.controls.lblFuchoKi12().text = value;
            };

            PublicProperties.prototype.getFuchoKiText13 = function () {
                return this.controls.lblFuchoKi13().text;
            };

            PublicProperties.prototype.setFuchoKiText13 = function (value) {
                this.controls.lblFuchoKi13().text = value;
            };

            PublicProperties.prototype.getFuchoKiText14 = function () {
                return this.controls.lblFuchoKi14().text;
            };

            PublicProperties.prototype.setFuchoKiText14 = function (value) {
                this.controls.lblFuchoKi14().text = value;
            };

            PublicProperties.prototype.getFuchoKiVisible1 = function () {
                return this.controls.lblFuchoKi1().visible;
            };

            PublicProperties.prototype.setFuchoKiVisible1 = function (value) {
                this.controls.lblFuchoKi1().visible = value;
            };

            PublicProperties.prototype.getFuchoKiVisible2 = function () {
                return this.controls.lblFuchoKi2().visible;
            };

            PublicProperties.prototype.setFuchoKiVisible2 = function (value) {
                this.controls.lblFuchoKi2().visible = value;
            };

            PublicProperties.prototype.getFuchoKiVisible3 = function () {
                return this.controls.lblFuchoKi3().visible;
            };

            PublicProperties.prototype.setFuchoKiVisible3 = function (value) {
                this.controls.lblFuchoKi3().visible = value;
            };

            PublicProperties.prototype.getFuchoKiVisible4 = function () {
                return this.controls.lblFuchoKi4().visible;
            };

            PublicProperties.prototype.setFuchoKiVisible4 = function (value) {
                this.controls.lblFuchoKi4().visible = value;
            };

            PublicProperties.prototype.getFuchoKiVisible5 = function () {
                return this.controls.lblFuchoKi5().visible;
            };

            PublicProperties.prototype.setFuchoKiVisible5 = function (value) {
                this.controls.lblFuchoKi5().visible = value;
            };

            PublicProperties.prototype.getFuchoKiVisible6 = function () {
                return this.controls.lblFuchoKi6().visible;
            };

            PublicProperties.prototype.setFuchoKiVisible6 = function (value) {
                this.controls.lblFuchoKi6().visible = value;
            };

            PublicProperties.prototype.getFuchoKiVisible7 = function () {
                return this.controls.lblFuchoKi7().visible;
            };

            PublicProperties.prototype.setFuchoKiVisible7 = function (value) {
                this.controls.lblFuchoKi7().visible = value;
            };

            PublicProperties.prototype.getFuchoKiVisible8 = function () {
                return this.controls.lblFuchoKi8().visible;
            };

            PublicProperties.prototype.setFuchoKiVisible8 = function (value) {
                this.controls.lblFuchoKi8().visible = value;
            };

            PublicProperties.prototype.getFuchoKiVisible9 = function () {
                return this.controls.lblFuchoKi9().visible;
            };

            PublicProperties.prototype.setFuchoKiVisible9 = function (value) {
                this.controls.lblFuchoKi9().visible = value;
            };

            PublicProperties.prototype.getFuchoKiVisible10 = function () {
                return this.controls.lblFuchoKi10().visible;
            };

            PublicProperties.prototype.setFuchoKiVisible10 = function (value) {
                this.controls.lblFuchoKi10().visible = value;
            };

            PublicProperties.prototype.getFuchoKiVisible11 = function () {
                return this.controls.lblFuchoKi11().visible;
            };

            PublicProperties.prototype.setFuchoKiVisible11 = function (value) {
                this.controls.lblFuchoKi11().visible = value;
            };

            PublicProperties.prototype.getFuchoKiVisible12 = function () {
                return this.controls.lblFuchoKi12().visible;
            };

            PublicProperties.prototype.setFuchoKiVisible12 = function (value) {
                this.controls.lblFuchoKi12().visible = value;
            };

            PublicProperties.prototype.getFuchoKiVisible13 = function () {
                return this.controls.lblFuchoKi13().visible;
            };

            PublicProperties.prototype.setFuchoKiVisible13 = function (value) {
                this.controls.lblFuchoKi13().visible = value;
            };

            PublicProperties.prototype.getFuchoKiVisible14 = function () {
                return this.controls.lblFuchoKi14().visible;
            };

            PublicProperties.prototype.setFuchoKiVisible14 = function (value) {
                this.controls.lblFuchoKi14().visible = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuText1 = function () {
                return this.controls.lblFuchoKibetsuGaku1().text;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuText1 = function (value) {
                this.controls.lblFuchoKibetsuGaku1().text = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuText2 = function () {
                return this.controls.lblFuchoKibetsuGaku2().text;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuText2 = function (value) {
                this.controls.lblFuchoKibetsuGaku2().text = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuText3 = function () {
                return this.controls.lblFuchoKibetsuGaku3().text;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuText3 = function (value) {
                this.controls.lblFuchoKibetsuGaku3().text = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuText4 = function () {
                return this.controls.lblFuchoKibetsuGaku4().text;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuText4 = function (value) {
                this.controls.lblFuchoKibetsuGaku4().text = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuText5 = function () {
                return this.controls.lblFuchoKibetsuGaku5().text;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuText5 = function (value) {
                this.controls.lblFuchoKibetsuGaku5().text = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuText6 = function () {
                return this.controls.lblFuchoKibetsuGaku6().text;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuText6 = function (value) {
                this.controls.lblFuchoKibetsuGaku6().text = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuText7 = function () {
                return this.controls.lblFuchoKibetsuGaku7().text;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuText7 = function (value) {
                this.controls.lblFuchoKibetsuGaku7().text = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuText8 = function () {
                return this.controls.lblFuchoKibetsuGaku8().text;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuText8 = function (value) {
                this.controls.lblFuchoKibetsuGaku8().text = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuText9 = function () {
                return this.controls.lblFuchoKibetsuGaku9().text;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuText9 = function (value) {
                this.controls.lblFuchoKibetsuGaku9().text = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuText10 = function () {
                return this.controls.lblFuchoKibetsuGaku10().text;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuText10 = function (value) {
                this.controls.lblFuchoKibetsuGaku10().text = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuText11 = function () {
                return this.controls.lblFuchoKibetsuGaku11().text;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuText11 = function (value) {
                this.controls.lblFuchoKibetsuGaku11().text = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuText12 = function () {
                return this.controls.lblFuchoKibetsuGaku12().text;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuText12 = function (value) {
                this.controls.lblFuchoKibetsuGaku12().text = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuText13 = function () {
                return this.controls.lblFuchoKibetsuGaku13().text;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuText13 = function (value) {
                this.controls.lblFuchoKibetsuGaku13().text = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuText14 = function () {
                return this.controls.lblFuchoKibetsuGaku14().text;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuText14 = function (value) {
                this.controls.lblFuchoKibetsuGaku14().text = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuVisible1 = function () {
                return this.controls.lblFuchoKibetsuGaku1().visible;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuVisible1 = function (value) {
                this.controls.lblFuchoKibetsuGaku1().visible = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuVisible2 = function () {
                return this.controls.lblFuchoKibetsuGaku2().visible;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuVisible2 = function (value) {
                this.controls.lblFuchoKibetsuGaku2().visible = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuVisible3 = function () {
                return this.controls.lblFuchoKibetsuGaku3().visible;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuVisible3 = function (value) {
                this.controls.lblFuchoKibetsuGaku3().visible = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuVisible4 = function () {
                return this.controls.lblFuchoKibetsuGaku4().visible;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuVisible4 = function (value) {
                this.controls.lblFuchoKibetsuGaku4().visible = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuVisible5 = function () {
                return this.controls.lblFuchoKibetsuGaku5().visible;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuVisible5 = function (value) {
                this.controls.lblFuchoKibetsuGaku5().visible = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuVisible6 = function () {
                return this.controls.lblFuchoKibetsuGaku6().visible;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuVisible6 = function (value) {
                this.controls.lblFuchoKibetsuGaku6().visible = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuVisible7 = function () {
                return this.controls.lblFuchoKibetsuGaku7().visible;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuVisible7 = function (value) {
                this.controls.lblFuchoKibetsuGaku7().visible = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuVisible8 = function () {
                return this.controls.lblFuchoKibetsuGaku8().visible;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuVisible8 = function (value) {
                this.controls.lblFuchoKibetsuGaku8().visible = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuVisible9 = function () {
                return this.controls.lblFuchoKibetsuGaku9().visible;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuVisible9 = function (value) {
                this.controls.lblFuchoKibetsuGaku9().visible = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuVisible10 = function () {
                return this.controls.lblFuchoKibetsuGaku10().visible;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuVisible10 = function (value) {
                this.controls.lblFuchoKibetsuGaku10().visible = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuVisible11 = function () {
                return this.controls.lblFuchoKibetsuGaku11().visible;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuVisible11 = function (value) {
                this.controls.lblFuchoKibetsuGaku11().visible = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuVisible12 = function () {
                return this.controls.lblFuchoKibetsuGaku12().visible;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuVisible12 = function (value) {
                this.controls.lblFuchoKibetsuGaku12().visible = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuVisible13 = function () {
                return this.controls.lblFuchoKibetsuGaku13().visible;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuVisible13 = function (value) {
                this.controls.lblFuchoKibetsuGaku13().visible = value;
            };

            PublicProperties.prototype.getFuchoKibetsuGakuVisible14 = function () {
                return this.controls.lblFuchoKibetsuGaku14().visible;
            };

            PublicProperties.prototype.setFuchoKibetsuGakuVisible14 = function (value) {
                this.controls.lblFuchoKibetsuGaku14().visible = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuText1 = function () {
                return this.controls.lblFuchoNofuGaku1().text;
            };

            PublicProperties.prototype.setFuchoNofuGakuText1 = function (value) {
                this.controls.lblFuchoNofuGaku1().text = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuText2 = function () {
                return this.controls.lblFuchoNofuGaku2().text;
            };

            PublicProperties.prototype.setFuchoNofuGakuText2 = function (value) {
                this.controls.lblFuchoNofuGaku2().text = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuText3 = function () {
                return this.controls.lblFuchoNofuGaku3().text;
            };

            PublicProperties.prototype.setFuchoNofuGakuText3 = function (value) {
                this.controls.lblFuchoNofuGaku3().text = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuText4 = function () {
                return this.controls.lblFuchoNofuGaku4().text;
            };

            PublicProperties.prototype.setFuchoNofuGakuText4 = function (value) {
                this.controls.lblFuchoNofuGaku4().text = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuText5 = function () {
                return this.controls.lblFuchoNofuGaku5().text;
            };

            PublicProperties.prototype.setFuchoNofuGakuText5 = function (value) {
                this.controls.lblFuchoNofuGaku5().text = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuText6 = function () {
                return this.controls.lblFuchoNofuGaku6().text;
            };

            PublicProperties.prototype.setFuchoNofuGakuText6 = function (value) {
                this.controls.lblFuchoNofuGaku6().text = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuText7 = function () {
                return this.controls.lblFuchoNofuGaku7().text;
            };

            PublicProperties.prototype.setFuchoNofuGakuText7 = function (value) {
                this.controls.lblFuchoNofuGaku7().text = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuText8 = function () {
                return this.controls.lblFuchoNofuGaku8().text;
            };

            PublicProperties.prototype.setFuchoNofuGakuText8 = function (value) {
                this.controls.lblFuchoNofuGaku8().text = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuText9 = function () {
                return this.controls.lblFuchoNofuGaku9().text;
            };

            PublicProperties.prototype.setFuchoNofuGakuText9 = function (value) {
                this.controls.lblFuchoNofuGaku9().text = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuText10 = function () {
                return this.controls.lblFuchoNofuGaku10().text;
            };

            PublicProperties.prototype.setFuchoNofuGakuText10 = function (value) {
                this.controls.lblFuchoNofuGaku10().text = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuText11 = function () {
                return this.controls.lblFuchoNofuGaku11().text;
            };

            PublicProperties.prototype.setFuchoNofuGakuText11 = function (value) {
                this.controls.lblFuchoNofuGaku11().text = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuText12 = function () {
                return this.controls.lblFuchoNofuGaku12().text;
            };

            PublicProperties.prototype.setFuchoNofuGakuText12 = function (value) {
                this.controls.lblFuchoNofuGaku12().text = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuText13 = function () {
                return this.controls.lblFuchoNofuGaku13().text;
            };

            PublicProperties.prototype.setFuchoNofuGakuText13 = function (value) {
                this.controls.lblFuchoNofuGaku13().text = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuText14 = function () {
                return this.controls.lblFuchoNofuGaku14().text;
            };

            PublicProperties.prototype.setFuchoNofuGakuText14 = function (value) {
                this.controls.lblFuchoNofuGaku14().text = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuVisible1 = function () {
                return this.controls.lblFuchoNofuGaku1().visible;
            };

            PublicProperties.prototype.setFuchoNofuGakuVisible1 = function (value) {
                this.controls.lblFuchoNofuGaku1().visible = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuVisible2 = function () {
                return this.controls.lblFuchoNofuGaku2().visible;
            };

            PublicProperties.prototype.setFuchoNofuGakuVisible2 = function (value) {
                this.controls.lblFuchoNofuGaku2().visible = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuVisible3 = function () {
                return this.controls.lblFuchoNofuGaku3().visible;
            };

            PublicProperties.prototype.setFuchoNofuGakuVisible3 = function (value) {
                this.controls.lblFuchoNofuGaku3().visible = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuVisible4 = function () {
                return this.controls.lblFuchoNofuGaku4().visible;
            };

            PublicProperties.prototype.setFuchoNofuGakuVisible4 = function (value) {
                this.controls.lblFuchoNofuGaku4().visible = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuVisible5 = function () {
                return this.controls.lblFuchoNofuGaku5().visible;
            };

            PublicProperties.prototype.setFuchoNofuGakuVisible5 = function (value) {
                this.controls.lblFuchoNofuGaku5().visible = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuVisible6 = function () {
                return this.controls.lblFuchoNofuGaku6().visible;
            };

            PublicProperties.prototype.setFuchoNofuGakuVisible6 = function (value) {
                this.controls.lblFuchoNofuGaku6().visible = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuVisible7 = function () {
                return this.controls.lblFuchoNofuGaku7().visible;
            };

            PublicProperties.prototype.setFuchoNofuGakuVisible7 = function (value) {
                this.controls.lblFuchoNofuGaku7().visible = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuVisible8 = function () {
                return this.controls.lblFuchoNofuGaku8().visible;
            };

            PublicProperties.prototype.setFuchoNofuGakuVisible8 = function (value) {
                this.controls.lblFuchoNofuGaku8().visible = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuVisible9 = function () {
                return this.controls.lblFuchoNofuGaku9().visible;
            };

            PublicProperties.prototype.setFuchoNofuGakuVisible9 = function (value) {
                this.controls.lblFuchoNofuGaku9().visible = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuVisible10 = function () {
                return this.controls.lblFuchoNofuGaku10().visible;
            };

            PublicProperties.prototype.setFuchoNofuGakuVisible10 = function (value) {
                this.controls.lblFuchoNofuGaku10().visible = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuVisible11 = function () {
                return this.controls.lblFuchoNofuGaku11().visible;
            };

            PublicProperties.prototype.setFuchoNofuGakuVisible11 = function (value) {
                this.controls.lblFuchoNofuGaku11().visible = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuVisible12 = function () {
                return this.controls.lblFuchoNofuGaku12().visible;
            };

            PublicProperties.prototype.setFuchoNofuGakuVisible12 = function (value) {
                this.controls.lblFuchoNofuGaku12().visible = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuVisible13 = function () {
                return this.controls.lblFuchoNofuGaku13().visible;
            };

            PublicProperties.prototype.setFuchoNofuGakuVisible13 = function (value) {
                this.controls.lblFuchoNofuGaku13().visible = value;
            };

            PublicProperties.prototype.getFuchoNofuGakuVisible14 = function () {
                return this.controls.lblFuchoNofuGaku14().visible;
            };

            PublicProperties.prototype.setFuchoNofuGakuVisible14 = function (value) {
                this.controls.lblFuchoNofuGaku14().visible = value;
            };

            PublicProperties.prototype.getTokuKibetsugakuKeiText = function () {
                return this.controls.lblTokuKibetsuGakuKei().text;
            };

            PublicProperties.prototype.setTokuKibetsugakuKeiText = function (value) {
                this.controls.lblTokuKibetsuGakuKei().text = value;
            };

            PublicProperties.prototype.getTokuKibetsugakuKeiVisible = function () {
                return this.controls.lblTokuKibetsuGakuKei().visible;
            };

            PublicProperties.prototype.setTokuKibetsugakuKeiVisible = function (value) {
                this.controls.lblTokuKibetsuGakuKei().visible = value;
            };

            PublicProperties.prototype.getTokuNofugakuKeiText = function () {
                return this.controls.lblTokuNofuGakuKei().text;
            };

            PublicProperties.prototype.setTokuNofugakuKeiText = function (value) {
                this.controls.lblTokuNofuGakuKei().text = value;
            };

            PublicProperties.prototype.getTokuNofugakuKeiVisible = function () {
                return this.controls.lblTokuNofuGakuKei().visible;
            };

            PublicProperties.prototype.setTokuNofugakuKeiVisible = function (value) {
                this.controls.lblTokuNofuGakuKei().visible = value;
            };

            PublicProperties.prototype.getFuchoKibetsugakuKeiText = function () {
                return this.controls.lblFuchoKibetsuGakuKei().text;
            };

            PublicProperties.prototype.setFuchoKibetsugakuKeiText = function (value) {
                this.controls.lblFuchoKibetsuGakuKei().text = value;
            };

            PublicProperties.prototype.getFuchoKibetsugakuKeiVisible = function () {
                return this.controls.lblFuchoKibetsuGakuKei().visible;
            };

            PublicProperties.prototype.setFuchoKibetsugakuKeiVisible = function (value) {
                this.controls.lblFuchoKibetsuGakuKei().visible = value;
            };

            PublicProperties.prototype.getFuchoNoufugakuKeiText = function () {
                return this.controls.lblFuchoNofuGakuKei().text;
            };

            PublicProperties.prototype.setFuchoNoufugakuKeiText = function (value) {
                this.controls.lblFuchoNofuGakuKei().text = value;
            };

            PublicProperties.prototype.getFuchoNofugakuKeiVisible = function () {
                return this.controls.lblFuchoNofuGakuKei().visible;
            };

            PublicProperties.prototype.setFuchoNofugakuKeiVisible = function (value) {
                this.controls.lblFuchoNofuGakuKei().visible = value;
            };
            return PublicProperties;
        })();
        Kiwarigaku.PublicProperties = PublicProperties;
    })(DBB.Kiwarigaku || (DBB.Kiwarigaku = {}));
    var Kiwarigaku = DBB.Kiwarigaku;
})(DBB || (DBB = {}));
