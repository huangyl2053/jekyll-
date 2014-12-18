var DBC;
(function (DBC) {
    (function (ServiceRiyohyoInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceRiyohyoInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ServiceRiyohyoInfo.ModeController = ModeController;
    })(DBC.ServiceRiyohyoInfo || (DBC.ServiceRiyohyoInfo = {}));
    var ServiceRiyohyoInfo = DBC.ServiceRiyohyoInfo;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ServiceRiyohyoInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ServiceRiyohyoInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("BeppyoMeisaiVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("BeppyoMeisaiDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("BeppyoGokeiVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("BeppyoGokeiDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("BeppyoRiyoNissuVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("BeppyoRiyoNissuDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KeikakuJigyoshaCodeVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KeikakuJigyoshaCodeDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KeikakuJigyoshaNameVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KeikakuJigyoshaNameDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("onClickZengetsuCopy", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickRiyohyoMeisaiAdd", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickBeppyoMeisaiNew", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickBeppyoGokeiNew", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickBeppyoMeisaiKakutei", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickBeppyoGokeiKakutei", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgServiceRiyohyoListSelectByDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgServiceRiyohyoListSelectBySelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgServiceRiyohyoListSelectByDelete", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgServiceRiyohyoBeppyoListSelectByDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgServiceRiyohyoBeppyoListSelectBySelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgServiceRiyohyoBeppyoListSelectByDelete", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ServiceRiyohyoEraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("onClickBtnCalcMeisai", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickBtnCalcGokei", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onBlurTxtSreviceCode", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getBeppyoMeisaiVisible = function () {
                return this.controls.ServiceRiyohyoBeppyoMeisai().visible;
            };

            PublicProperties.prototype.setBeppyoMeisaiVisible = function (value) {
                this.controls.ServiceRiyohyoBeppyoMeisai().visible = value;
            };

            PublicProperties.prototype.getBeppyoMeisaiDisplayNone = function () {
                return this.controls.ServiceRiyohyoBeppyoMeisai().displayNone;
            };

            PublicProperties.prototype.setBeppyoMeisaiDisplayNone = function (value) {
                this.controls.ServiceRiyohyoBeppyoMeisai().displayNone = value;
            };

            PublicProperties.prototype.getBeppyoGokeiVisible = function () {
                return this.controls.ServiceRiyohyoBeppyoGokei().visible;
            };

            PublicProperties.prototype.setBeppyoGokeiVisible = function (value) {
                this.controls.ServiceRiyohyoBeppyoGokei().visible = value;
            };

            PublicProperties.prototype.getBeppyoGokeiDisplayNone = function () {
                return this.controls.ServiceRiyohyoBeppyoGokei().displayNone;
            };

            PublicProperties.prototype.setBeppyoGokeiDisplayNone = function (value) {
                this.controls.ServiceRiyohyoBeppyoGokei().displayNone = value;
            };

            PublicProperties.prototype.getBeppyoRiyoNissuVisible = function () {
                return this.controls.ServiceRiyohyoBeppyoRiyoNissu().visible;
            };

            PublicProperties.prototype.setBeppyoRiyoNissuVisible = function (value) {
                this.controls.ServiceRiyohyoBeppyoRiyoNissu().visible = value;
            };

            PublicProperties.prototype.getBeppyoRiyoNissuDisplayNone = function () {
                return this.controls.ServiceRiyohyoBeppyoRiyoNissu().displayNone;
            };

            PublicProperties.prototype.setBeppyoRiyoNissuDisplayNone = function (value) {
                this.controls.ServiceRiyohyoBeppyoRiyoNissu().displayNone = value;
            };

            PublicProperties.prototype.getKeikakuJigyoshaCodeVisible = function () {
                return this.controls.txtKeikakuJigyoshaCode().visible;
            };

            PublicProperties.prototype.setKeikakuJigyoshaCodeVisible = function (value) {
                this.controls.txtKeikakuJigyoshaCode().visible = value;
            };

            PublicProperties.prototype.getKeikakuJigyoshaCodeDisplayNone = function () {
                return this.controls.txtKeikakuJigyoshaCode().displayNone;
            };

            PublicProperties.prototype.setKeikakuJigyoshaCodeDisplayNone = function (value) {
                this.controls.txtKeikakuJigyoshaCode().displayNone = value;
            };

            PublicProperties.prototype.getKeikakuJigyoshaNameVisible = function () {
                return this.controls.txtKeikakuJigyoshaName().visible;
            };

            PublicProperties.prototype.setKeikakuJigyoshaNameVisible = function (value) {
                this.controls.txtKeikakuJigyoshaName().visible = value;
            };

            PublicProperties.prototype.getKeikakuJigyoshaNameDisplayNone = function () {
                return this.controls.txtKeikakuJigyoshaName().displayNone;
            };

            PublicProperties.prototype.setKeikakuJigyoshaNameDisplayNone = function (value) {
                this.controls.txtKeikakuJigyoshaName().displayNone = value;
            };

            PublicProperties.prototype.getonClickZengetsuCopy = function () {
                return this.controls.btnZengetsuCopy().onClick;
            };

            PublicProperties.prototype.setonClickZengetsuCopy = function (value) {
                this.controls.btnZengetsuCopy().onClick = value;
            };

            PublicProperties.prototype.getonClickRiyohyoMeisaiAdd = function () {
                return this.controls.btnRiyohyoMeisaiAdd().onClick;
            };

            PublicProperties.prototype.setonClickRiyohyoMeisaiAdd = function (value) {
                this.controls.btnRiyohyoMeisaiAdd().onClick = value;
            };

            PublicProperties.prototype.getonClickBeppyoMeisaiNew = function () {
                return this.controls.btnBeppyoMeisaiNew().onClick;
            };

            PublicProperties.prototype.setonClickBeppyoMeisaiNew = function (value) {
                this.controls.btnBeppyoMeisaiNew().onClick = value;
            };

            PublicProperties.prototype.getonClickBeppyoGokeiNew = function () {
                return this.controls.btnBeppyoGokeiNew().onClick;
            };

            PublicProperties.prototype.setonClickBeppyoGokeiNew = function (value) {
                this.controls.btnBeppyoGokeiNew().onClick = value;
            };

            PublicProperties.prototype.getonClickBeppyoMeisaiKakutei = function () {
                return this.controls.btnBeppyoMeisaiKakutei().onClick;
            };

            PublicProperties.prototype.setonClickBeppyoMeisaiKakutei = function (value) {
                this.controls.btnBeppyoMeisaiKakutei().onClick = value;
            };

            PublicProperties.prototype.getonClickBeppyoGokeiKakutei = function () {
                return this.controls.btnBeppyoGokeiKakutei().onClick;
            };

            PublicProperties.prototype.setonClickBeppyoGokeiKakutei = function (value) {
                this.controls.btnBeppyoGokeiKakutei().onClick = value;
            };

            PublicProperties.prototype.getdgServiceRiyohyoListSelectByDblClick = function () {
                return this.controls.dgServiceRiyohyoList().onSelectByDblClick;
            };

            PublicProperties.prototype.setdgServiceRiyohyoListSelectByDblClick = function (value) {
                this.controls.dgServiceRiyohyoList().onSelectByDblClick = value;
            };

            PublicProperties.prototype.getdgServiceRiyohyoListSelectBySelect = function () {
                return this.controls.dgServiceRiyohyoList().onSelectBySelectButton;
            };

            PublicProperties.prototype.setdgServiceRiyohyoListSelectBySelect = function (value) {
                this.controls.dgServiceRiyohyoList().onSelectBySelectButton = value;
            };

            PublicProperties.prototype.getdgServiceRiyohyoListSelectByDelete = function () {
                return this.controls.dgServiceRiyohyoList().onSelectByDeleteButton;
            };

            PublicProperties.prototype.setdgServiceRiyohyoListSelectByDelete = function (value) {
                this.controls.dgServiceRiyohyoList().onSelectByDeleteButton = value;
            };

            PublicProperties.prototype.getdgServiceRiyohyoBeppyoListSelectByDblClick = function () {
                return this.controls.dgServiceRiyohyoBeppyoList().onSelectByDblClick;
            };

            PublicProperties.prototype.setdgServiceRiyohyoBeppyoListSelectByDblClick = function (value) {
                this.controls.dgServiceRiyohyoBeppyoList().onSelectByDblClick = value;
            };

            PublicProperties.prototype.getdgServiceRiyohyoBeppyoListSelectBySelect = function () {
                return this.controls.dgServiceRiyohyoBeppyoList().onSelectBySelectButton;
            };

            PublicProperties.prototype.setdgServiceRiyohyoBeppyoListSelectBySelect = function (value) {
                this.controls.dgServiceRiyohyoBeppyoList().onSelectBySelectButton = value;
            };

            PublicProperties.prototype.getdgServiceRiyohyoBeppyoListSelectByDelete = function () {
                return this.controls.dgServiceRiyohyoBeppyoList().onSelectByDeleteButton;
            };

            PublicProperties.prototype.setdgServiceRiyohyoBeppyoListSelectByDelete = function (value) {
                this.controls.dgServiceRiyohyoBeppyoList().onSelectByDeleteButton = value;
            };

            PublicProperties.prototype.getServiceRiyohyoEraseBorder = function () {
                return this.controls.ServiceRiyohyoInfo().eraseBorder;
            };

            PublicProperties.prototype.setServiceRiyohyoEraseBorder = function (value) {
                this.controls.ServiceRiyohyoInfo().eraseBorder = value;
            };

            PublicProperties.prototype.getonClickBtnCalcMeisai = function () {
                return this.controls.btnCalcMeisai().onClick;
            };

            PublicProperties.prototype.setonClickBtnCalcMeisai = function (value) {
                this.controls.btnCalcMeisai().onClick = value;
            };

            PublicProperties.prototype.getonClickBtnCalcGokei = function () {
                return this.controls.btnCalcGokei().onClick;
            };

            PublicProperties.prototype.setonClickBtnCalcGokei = function (value) {
                this.controls.btnCalcGokei().onClick = value;
            };

            PublicProperties.prototype.getonBlurTxtSreviceCode = function () {
                return this.controls.txtServiceCode().onBlur;
            };

            PublicProperties.prototype.setonBlurTxtSreviceCode = function (value) {
                this.controls.txtServiceCode().onBlur = value;
            };
            return PublicProperties;
        })();
        ServiceRiyohyoInfo.PublicProperties = PublicProperties;
    })(DBC.ServiceRiyohyoInfo || (DBC.ServiceRiyohyoInfo = {}));
    var ServiceRiyohyoInfo = DBC.ServiceRiyohyoInfo;
})(DBC || (DBC = {}));
