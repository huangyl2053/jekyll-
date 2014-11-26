var DBC;
(function (DBC) {
    (function (KyufuKanrihyoInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyufuKanrihyoInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KyufuKanrihyoInfo.ModeController = ModeController;
    })(DBC.KyufuKanrihyoInfo || (DBC.KyufuKanrihyoInfo = {}));
    var KyufuKanrihyoInfo = DBC.KyufuKanrihyoInfo;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KyufuKanrihyoInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KyufuKanrihyoInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ZengetsuNissuVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ShikyuGendogakuIsComma", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("GokeiTanisuLabelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("GokeiTanisuIsComma", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TantoSenmonNoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TantoSenmonNoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ItakuJigyoshaNoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ItakuJigyoshaNoDisplayNode", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ItakuJigyoshaNameVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ItakuJigyoshaNameDisplayNode", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ItakuSenmonNoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ItakuSenmonNoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("MeisaiListHeight", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("MeisaiListOnSort", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("MeisaiListOnSelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("MeisaiListOnSelectByDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("MeisaiListOnSelectBySelectButton", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("MeisaiListOnSelectbyModifyButton", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("MeisaiListOnSelectByDeleteButton", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getZengetsuNissuVisible = function () {
                return this.controls.txtZengetsuNissu().visible;
            };

            PublicProperties.prototype.setZengetsuNissuVisible = function (value) {
                this.controls.txtZengetsuNissu().visible = value;
            };

            PublicProperties.prototype.getShikyuGendogakuIsComma = function () {
                return this.controls.txtShikyuGendogaku().isComma;
            };

            PublicProperties.prototype.setShikyuGendogakuIsComma = function (value) {
                this.controls.txtShikyuGendogaku().isComma = value;
            };

            PublicProperties.prototype.getGokeiTanisuLabelLText = function () {
                return this.controls.txtGokeiTanisu().labelLText;
            };

            PublicProperties.prototype.setGokeiTanisuLabelLText = function (value) {
                this.controls.txtGokeiTanisu().labelLText = value;
            };

            PublicProperties.prototype.getGokeiTanisuIsComma = function () {
                return this.controls.txtGokeiTanisu().isComma;
            };

            PublicProperties.prototype.setGokeiTanisuIsComma = function (value) {
                this.controls.txtGokeiTanisu().isComma = value;
            };

            PublicProperties.prototype.getTantoSenmonNoVisible = function () {
                return this.controls.txtTantoSenmonNo().visible;
            };

            PublicProperties.prototype.setTantoSenmonNoVisible = function (value) {
                this.controls.txtTantoSenmonNo().visible = value;
            };

            PublicProperties.prototype.getTantoSenmonNoDisplayNone = function () {
                return this.controls.txtTantoSenmonNo().displayNone;
            };

            PublicProperties.prototype.setTantoSenmonNoDisplayNone = function (value) {
                this.controls.txtTantoSenmonNo().displayNone = value;
            };

            PublicProperties.prototype.getItakuJigyoshaNoVisible = function () {
                return this.controls.txtItakuJigyoshaNo().visible;
            };

            PublicProperties.prototype.setItakuJigyoshaNoVisible = function (value) {
                this.controls.txtItakuJigyoshaNo().visible = value;
            };

            PublicProperties.prototype.getItakuJigyoshaNoDisplayNode = function () {
                return this.controls.txtItakuJigyoshaNo().displayNone;
            };

            PublicProperties.prototype.setItakuJigyoshaNoDisplayNode = function (value) {
                this.controls.txtItakuJigyoshaNo().displayNone = value;
            };

            PublicProperties.prototype.getItakuJigyoshaNameVisible = function () {
                return this.controls.txtItakuJigyoshaName().visible;
            };

            PublicProperties.prototype.setItakuJigyoshaNameVisible = function (value) {
                this.controls.txtItakuJigyoshaName().visible = value;
            };

            PublicProperties.prototype.getItakuJigyoshaNameDisplayNode = function () {
                return this.controls.txtItakuJigyoshaName().displayNone;
            };

            PublicProperties.prototype.setItakuJigyoshaNameDisplayNode = function (value) {
                this.controls.txtItakuJigyoshaName().displayNone = value;
            };

            PublicProperties.prototype.getItakuSenmonNoVisible = function () {
                return this.controls.txtItakuSenmonNo().visible;
            };

            PublicProperties.prototype.setItakuSenmonNoVisible = function (value) {
                this.controls.txtItakuSenmonNo().visible = value;
            };

            PublicProperties.prototype.getItakuSenmonNoDisplayNone = function () {
                return this.controls.txtItakuSenmonNo().displayNone;
            };

            PublicProperties.prototype.setItakuSenmonNoDisplayNone = function (value) {
                this.controls.txtItakuSenmonNo().displayNone = value;
            };

            PublicProperties.prototype.getMeisaiListHeight = function () {
                return this.controls.dgMeisaiList().height;
            };

            PublicProperties.prototype.setMeisaiListHeight = function (value) {
                this.controls.dgMeisaiList().height = value;
            };

            PublicProperties.prototype.getMeisaiListOnSort = function () {
                return this.controls.dgMeisaiList().onSort;
            };

            PublicProperties.prototype.setMeisaiListOnSort = function (value) {
                this.controls.dgMeisaiList().onSort = value;
            };

            PublicProperties.prototype.getMeisaiListOnSelect = function () {
                return this.controls.dgMeisaiList().onSelect;
            };

            PublicProperties.prototype.setMeisaiListOnSelect = function (value) {
                this.controls.dgMeisaiList().onSelect = value;
            };

            PublicProperties.prototype.getMeisaiListOnSelectByDblClick = function () {
                return this.controls.dgMeisaiList().onSelectByDblClick;
            };

            PublicProperties.prototype.setMeisaiListOnSelectByDblClick = function (value) {
                this.controls.dgMeisaiList().onSelectByDblClick = value;
            };

            PublicProperties.prototype.getMeisaiListOnSelectBySelectButton = function () {
                return this.controls.dgMeisaiList().onSelectBySelectButton;
            };

            PublicProperties.prototype.setMeisaiListOnSelectBySelectButton = function (value) {
                this.controls.dgMeisaiList().onSelectBySelectButton = value;
            };

            PublicProperties.prototype.getMeisaiListOnSelectbyModifyButton = function () {
                return this.controls.dgMeisaiList().onSelectByModifyButton;
            };

            PublicProperties.prototype.setMeisaiListOnSelectbyModifyButton = function (value) {
                this.controls.dgMeisaiList().onSelectByModifyButton = value;
            };

            PublicProperties.prototype.getMeisaiListOnSelectByDeleteButton = function () {
                return this.controls.dgMeisaiList().onSelectByDeleteButton;
            };

            PublicProperties.prototype.setMeisaiListOnSelectByDeleteButton = function (value) {
                this.controls.dgMeisaiList().onSelectByDeleteButton = value;
            };
            return PublicProperties;
        })();
        KyufuKanrihyoInfo.PublicProperties = PublicProperties;
    })(DBC.KyufuKanrihyoInfo || (DBC.KyufuKanrihyoInfo = {}));
    var KyufuKanrihyoInfo = DBC.KyufuKanrihyoInfo;
})(DBC || (DBC = {}));
