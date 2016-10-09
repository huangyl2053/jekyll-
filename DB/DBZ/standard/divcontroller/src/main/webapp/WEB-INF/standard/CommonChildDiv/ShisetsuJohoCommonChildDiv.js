var DBZ;
(function (DBZ) {
    (function (ShisetsuJohoCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuJohoCommonChildDiv.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "State"
                ];
            };

            ModeController.prototype.State = function () {
                return new Modes.State(this.controls);
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShisetsuJohoCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShisetsuJohoCommonChildDiv.ModeController = ModeController;

        (function (Modes) {
            var State = (function () {
                function State(controls) {
                    this.controls = controls;
                }
                State.prototype.DaichoShubetsuAriMode = function () {
                    this.controls.ddlDaichoShubetsu().displayNone = false;
                    this.controls.radKaigoHokenShisetsu().displayNone = false;
                    this.controls.radOtherTokureiShisetsu().displayNone = false;
                    this.controls.radTekiyoJyogaiShisetsu().displayNone = false;
                };
                State.prototype.DaichoShubetsuNashiMode = function () {
                    this.controls.ddlDaichoShubetsu().displayNone = true;
                    this.controls.radKaigoHokenShisetsu().labelLText = " ";
                    this.controls.radKaigoHokenShisetsu().displayNone = false;
                    this.controls.radOtherTokureiShisetsu().displayNone = false;
                    this.controls.radTekiyoJyogaiShisetsu().displayNone = false;
                };
                State.prototype.KaigoHokenMode = function () {
                    this.controls.ddlDaichoShubetsu().displayNone = true;
                    this.controls.radKaigoHokenShisetsu().labelLText = " ";
                    this.controls.radKaigoHokenShisetsu().displayNone = false;
                    this.controls.radOtherTokureiShisetsu().displayNone = false;
                    this.controls.radTekiyoJyogaiShisetsu().displayNone = true;
                };
                State.prototype.OtherTokureiMode = function () {
                    this.controls.ddlDaichoShubetsu().displayNone = true;
                    this.controls.radKaigoHokenShisetsu().labelLText = " ";
                    this.controls.radKaigoHokenShisetsu().displayNone = false;
                    this.controls.radOtherTokureiShisetsu().displayNone = false;
                    this.controls.radTekiyoJyogaiShisetsu().displayNone = true;
                };
                State.prototype.TekiyoJogaiMode = function () {
                    this.controls.ddlDaichoShubetsu().displayNone = true;
                    this.controls.radKaigoHokenShisetsu().displayNone = true;
                    this.controls.radOtherTokureiShisetsu().displayNone = true;
                    this.controls.radTekiyoJyogaiShisetsu().displayNone = true;
                };
                State.prototype.JigyoshaInputGuideMode = function () {
                    this.controls.ddlDaichoShubetsu().displayNone = true;
                    this.controls.radKaigoHokenShisetsu().displayNone = true;
                    this.controls.radOtherTokureiShisetsu().displayNone = true;
                    this.controls.radTekiyoJyogaiShisetsu().displayNone = true;
                };
                return State;
            })();
            Modes.State = State;
        })(ShisetsuJohoCommonChildDiv.Modes || (ShisetsuJohoCommonChildDiv.Modes = {}));
        var Modes = ShisetsuJohoCommonChildDiv.Modes;
    })(DBZ.ShisetsuJohoCommonChildDiv || (DBZ.ShisetsuJohoCommonChildDiv = {}));
    var ShisetsuJohoCommonChildDiv = DBZ.ShisetsuJohoCommonChildDiv;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShisetsuJohoCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.getNyuryokuShisetsuKodo_labelLText = function () {
                    return this.controls.txtNyuryokuShisetsuKodo().labelLText;
                };
                this.setNyuryokuShisetsuKodo_labelLText = function (value) {
                    this.controls.txtNyuryokuShisetsuKodo().labelLText = value;
                };
                this.getNyuryokuShisetsuKodo_required = function () {
                    return this.controls.txtNyuryokuShisetsuKodo().required;
                };
                this.setNyuryokuShisetsuKodo_required = function (value) {
                    this.controls.txtNyuryokuShisetsuKodo().required = value;
                };
                this.getNyuryokuShisetsuKodo_labelLWidth = function () {
                    return this.controls.txtNyuryokuShisetsuKodo().labelLWidth;
                };
                this.setNyuryokuShisetsuKodo_labelLWidth = function (value) {
                    this.controls.txtNyuryokuShisetsuKodo().labelLWidth = value;
                };
                this.getNyuryokuShisetsuMeisho_width = function () {
                    return this.controls.txtNyuryokuShisetsuMeisho().width;
                };
                this.setNyuryokuShisetsuMeisho_width = function (value) {
                    this.controls.txtNyuryokuShisetsuMeisho().width = value;
                };
                this.getNyuryokuShisetsuMeisho_marginLeft = function () {
                    return this.controls.txtNyuryokuShisetsuMeisho().marginLeft;
                };
                this.setNyuryokuShisetsuMeisho_marginLeft = function (value) {
                    this.controls.txtNyuryokuShisetsuMeisho().marginLeft = value;
                };
                this.getNyuryokuShisetsuMeisho_wrap = function () {
                    return this.controls.txtNyuryokuShisetsuMeisho().wrap;
                };
                this.setNyuryokuShisetsuMeisho_wrap = function (value) {
                    this.controls.txtNyuryokuShisetsuMeisho().wrap = value;
                };
                this.getShisetsuJohoCommonChildDiv_width = function () {
                    return this.controls.ShisetsuJohoCommonChildDiv().width;
                };
                this.setShisetsuJohoCommonChildDiv_width = function (value) {
                    this.controls.ShisetsuJohoCommonChildDiv().width = value;
                };
                this.fieldName = fieldName;
                this.controls = new ShisetsuJohoCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();
                editTypes.addEditType("ShisetsuJohoCommonChildDiv_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("NyuryokuShisetsuKodo_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("NyuryokuShisetsuKodo_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("NyuryokuShisetsuKodo_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("NyuryokuShisetsuMeisho_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("NyuryokuShisetsuMeisho_wrap", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("NyuryokuShisetsuMeisho_marginLeft", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };
            return PublicProperties;
        })();
        ShisetsuJohoCommonChildDiv.PublicProperties = PublicProperties;
    })(DBZ.ShisetsuJohoCommonChildDiv || (DBZ.ShisetsuJohoCommonChildDiv = {}));
    var ShisetsuJohoCommonChildDiv = DBZ.ShisetsuJohoCommonChildDiv;
})(DBZ || (DBZ = {}));
