var DBE;
(function (DBE) {
    (function (KihonchosaResultInputCom) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonchosaResultInputCom.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KihonchosaResultInputCom.ModeController = ModeController;
    })(DBE.KihonchosaResultInputCom || (DBE.KihonchosaResultInputCom = {}));
    var KihonchosaResultInputCom = DBE.KihonchosaResultInputCom;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (KihonchosaResultInputCom) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KihonchosaResultInputCom.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("text_ItemNo", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("text_ItemName", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("visible_ItemNo", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("onFocus_Answer", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettext_ItemNo = function () {
                return this.controls.lblItemNo().text;
            };

            PublicProperties.prototype.settext_ItemNo = function (value) {
                this.controls.lblItemNo().text = value;
            };

            PublicProperties.prototype.gettext_ItemName = function () {
                return this.controls.lblItemName().text;
            };

            PublicProperties.prototype.settext_ItemName = function (value) {
                this.controls.lblItemName().text = value;
            };

            PublicProperties.prototype.getvisible_ItemNo = function () {
                return this.controls.lblItemNo().visible;
            };

            PublicProperties.prototype.setvisible_ItemNo = function (value) {
                this.controls.lblItemNo().visible = value;
            };

            PublicProperties.prototype.getonFocus_Answer = function () {
                return this.controls.txtAnswer().onFocus;
            };

            PublicProperties.prototype.setonFocus_Answer = function (value) {
                this.controls.txtAnswer().onFocus = value;
            };
            return PublicProperties;
        })();
        KihonchosaResultInputCom.PublicProperties = PublicProperties;
    })(DBE.KihonchosaResultInputCom || (DBE.KihonchosaResultInputCom = {}));
    var KihonchosaResultInputCom = DBE.KihonchosaResultInputCom;
})(DBE || (DBE = {}));
