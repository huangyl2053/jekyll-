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
