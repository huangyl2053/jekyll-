var DBZ;
(function (DBZ) {
    (function (KogakuServicehiJudgementResult) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KogakuServicehiJudgementResult.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KogakuServicehiJudgementResult";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KogakuServicehiJudgementResult.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KogakuServicehiJudgementResult.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KogakuServicehiJudgementResult = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgJudgementResult = function () {
                return new UZA.DataGrid(this.convFiledName("dgJudgementResult"));
            };

            Controls.prototype.KogakuServicehiJudgementResultDetail1 = function () {
                return new UZA.Panel(this.convFiledName("KogakuServicehiJudgementResultDetail1"));
            };

            Controls.prototype.txtUketsukeDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeDate"));
            };

            Controls.prototype.txtHonninPaymentAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHonninPaymentAmount"));
            };

            Controls.prototype.txtKetteiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKetteiDate"));
            };

            Controls.prototype.radShikyuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radShikyuKubun"));
            };

            Controls.prototype.txtsetaiShuyakuNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtsetaiShuyakuNo"));
            };

            Controls.prototype.txtShikyuAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShikyuAmount"));
            };

            Controls.prototype.radIsKogakuAutoShokan = function () {
                return new UZA.RadioButton(this.convFiledName("radIsKogakuAutoShokan"));
            };

            Controls.prototype.KogakuServicehiJudgementResultDetail2 = function () {
                return new UZA.Panel(this.convFiledName("KogakuServicehiJudgementResultDetail2"));
            };

            Controls.prototype.txtBiko = function () {
                return new UZA.TextBox(this.convFiledName("txtBiko"));
            };

            Controls.prototype.radJudgementMethod = function () {
                return new UZA.RadioButton(this.convFiledName("radJudgementMethod"));
            };

            Controls.prototype.txtFushikyuRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushikyuRiyu"));
            };
            return Controls;
        })();
        KogakuServicehiJudgementResult.Controls = Controls;
    })(DBZ.KogakuServicehiJudgementResult || (DBZ.KogakuServicehiJudgementResult = {}));
    var KogakuServicehiJudgementResult = DBZ.KogakuServicehiJudgementResult;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KogakuServicehiJudgementResult) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuServicehiJudgementResult.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KogakuServicehiJudgementResult.ModeController = ModeController;
    })(DBZ.KogakuServicehiJudgementResult || (DBZ.KogakuServicehiJudgementResult = {}));
    var KogakuServicehiJudgementResult = DBZ.KogakuServicehiJudgementResult;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KogakuServicehiJudgementResult) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KogakuServicehiJudgementResult.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KogakuServicehiJudgementResult().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KogakuServicehiJudgementResult().title = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KogakuServicehiJudgementResult().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KogakuServicehiJudgementResult().eraseBorder = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.KogakuServicehiJudgementResult().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.KogakuServicehiJudgementResult().panelDisplay = value;
            };
            return PublicProperties;
        })();
        KogakuServicehiJudgementResult.PublicProperties = PublicProperties;
    })(DBZ.KogakuServicehiJudgementResult || (DBZ.KogakuServicehiJudgementResult = {}));
    var KogakuServicehiJudgementResult = DBZ.KogakuServicehiJudgementResult;
})(DBZ || (DBZ = {}));
