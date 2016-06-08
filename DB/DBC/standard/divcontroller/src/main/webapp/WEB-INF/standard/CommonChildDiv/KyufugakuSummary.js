var DBC;
(function (DBC) {
    (function (KyufugakuSummary) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyufugakuSummary.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KyufugakuSummary.ModeController = ModeController;
    })(DBC.KyufugakuSummary || (DBC.KyufugakuSummary = {}));
    var KyufugakuSummary = DBC.KyufugakuSummary;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KyufugakuSummary) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KyufugakuSummary.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("btnLimitOverCheck_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnRireki_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnRireki_text", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getbtnLimitOverCheck_displayNone = function () {
                return this.controls.btnLimitOverCheck().displayNone;
            };

            PublicProperties.prototype.setbtnLimitOverCheck_displayNone = function (value) {
                this.controls.btnLimitOverCheck().displayNone = value;
            };

            PublicProperties.prototype.getbtnRireki_displayNone = function () {
                return this.controls.btnRireki().displayNone;
            };

            PublicProperties.prototype.setbtnRireki_displayNone = function (value) {
                this.controls.btnRireki().displayNone = value;
            };

            PublicProperties.prototype.getbtnRireki_text = function () {
                return this.controls.btnRireki().text;
            };

            PublicProperties.prototype.setbtnRireki_text = function (value) {
                this.controls.btnRireki().text = value;
            };
            return PublicProperties;
        })();
        KyufugakuSummary.PublicProperties = PublicProperties;
    })(DBC.KyufugakuSummary || (DBC.KyufugakuSummary = {}));
    var KyufugakuSummary = DBC.KyufugakuSummary;
})(DBC || (DBC = {}));
