var DBZ;
(function (DBZ) {
    (function (KogakuServicehiDetail) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuServicehiDetail.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KogakuServicehiDetail.ModeController = ModeController;
    })(DBZ.KogakuServicehiDetail || (DBZ.KogakuServicehiDetail = {}));
    var KogakuServicehiDetail = DBZ.KogakuServicehiDetail;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KogakuServicehiDetail) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KogakuServicehiDetail.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("tplJudgementResult_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("tplKetteiJoho_visible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KogakuServicehiDetail().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KogakuServicehiDetail().title = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KogakuServicehiDetail().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KogakuServicehiDetail().eraseBorder = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.KogakuServicehiDetail().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.KogakuServicehiDetail().panelDisplay = value;
            };

            PublicProperties.prototype.gettplJudgementResult_title = function () {
                return this.controls.tplJudgementResult().title;
            };

            PublicProperties.prototype.settplJudgementResult_title = function (value) {
                this.controls.tplJudgementResult().title = value;
            };

            PublicProperties.prototype.gettplKetteiJoho_visible = function () {
                return this.controls.tplKetteiJoho().visible;
            };

            PublicProperties.prototype.settplKetteiJoho_visible = function (value) {
                this.controls.tplKetteiJoho().visible = value;
            };
            return PublicProperties;
        })();
        KogakuServicehiDetail.PublicProperties = PublicProperties;
    })(DBZ.KogakuServicehiDetail || (DBZ.KogakuServicehiDetail = {}));
    var KogakuServicehiDetail = DBZ.KogakuServicehiDetail;
})(DBZ || (DBZ = {}));
