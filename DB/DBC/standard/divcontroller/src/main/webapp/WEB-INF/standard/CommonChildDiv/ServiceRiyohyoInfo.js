var DBC;
(function (DBC) {
    (function (ServiceRiyohyoInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceRiyohyoInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ServiceRiyohyoInfo.PublicProperties(this.fieldName);
            };

            ModeController.prototype.GamenMode = function () {
                return new Modes.GamenMode(this.controls);
            };
            return ModeController;
        })();
        ServiceRiyohyoInfo.ModeController = ModeController;

        (function (Modes) {
            var GamenMode = (function () {
                function GamenMode(controls) {
                    this.controls = controls;
                }
                GamenMode.prototype.ModifyMode = function () {
                };

                GamenMode.prototype.InquiryMode = function () {
                    this.controls.btnZengetsuCopy().displayNone = true;

                    this.controls.btnBeppyoMeisaiNew().displayNone = true;
                    this.controls.btnBeppyoGokeiNew().displayNone = true;
                    this.controls.btnBeppyoMeisaiGokeiNew().displayNone = true;

                    this.controls.ServiceRiyohyoBeppyoMeisai().disabled = true;
                    this.controls.btnCalcMeisai().displayNone = true;
                    this.controls.btnBeppyoMeisaiKakutei().displayNone = true;

                    this.controls.ServiceRiyohyoBeppyoGokei().disabled = true;
                    this.controls.btnCalcGokei().displayNone = true;
                    this.controls.btnBeppyoGokeiKakutei().displayNone = true;

                    this.controls.btnDelete().displayNone = true;
                    this.controls.btnSave().displayNone = true;
                };
                return GamenMode;
            })();
            Modes.GamenMode = GamenMode;
        })(ServiceRiyohyoInfo.Modes || (ServiceRiyohyoInfo.Modes = {}));
        var Modes = ServiceRiyohyoInfo.Modes;
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
                editTypes.addEditType("onClickZengetsuCopy", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickBeppyoMeisaiNew", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickBeppyoGokeiNew", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickBeppyoMeisaiKakutei", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickBeppyoGokeiKakutei", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgServiceRiyohyoBeppyoListSelectByDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgServiceRiyohyoBeppyoListSelectBySelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgServiceRiyohyoBeppyoListSelectByDelete", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ServiceRiyohyoEraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("onClickBtnCalcMeisai", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickBtnCalcGokei", UZA.EditTypeEnumForPublicProperty.StringType);
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

            PublicProperties.prototype.getonClickZengetsuCopy = function () {
                return this.controls.btnZengetsuCopy().onClick;
            };

            PublicProperties.prototype.setonClickZengetsuCopy = function (value) {
                this.controls.btnZengetsuCopy().onClick = value;
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
            return PublicProperties;
        })();
        ServiceRiyohyoInfo.PublicProperties = PublicProperties;
    })(DBC.ServiceRiyohyoInfo || (DBC.ServiceRiyohyoInfo = {}));
    var ServiceRiyohyoInfo = DBC.ServiceRiyohyoInfo;
})(DBC || (DBC = {}));
