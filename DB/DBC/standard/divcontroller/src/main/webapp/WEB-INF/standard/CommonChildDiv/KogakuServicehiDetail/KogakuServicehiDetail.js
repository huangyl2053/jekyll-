var DBC;
(function (DBC) {
    (function (KogakuServicehiDetail) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuServicehiDetail.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return ["DisplayMode"];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };
            return ModeController;
        })();
        KogakuServicehiDetail.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.tsuika = function () {
                    this.controls.tplShinseisha().disabled = false;
                    this.controls.txtShinseiYMD().disabled = false;
                    this.controls.rdbShinseisyaKubun().disabled = false;
                    this.controls.txtHokenJyaBango().disabled = false;
                    this.controls.chkKokuhorenSaiso().disabled = false;
                    this.controls.txtShimeiKanji().disabled = false;
                    this.controls.txtShimeiKana().disabled = false;
                    this.controls.txtTelNo().disabled = false;
                    this.controls.txtShinseiRiyu().disabled = false;
                    this.controls.txtShiharaiTotalAmount().disabled = false;

                    this.controls.tplJudgementResult().disabled = false;
                    this.controls.txtUketsukeYMD().disabled = false;
                    this.controls.txtKetteiYMD().disabled = false;
                    this.controls.txtShikyuKingaku().disabled = false;
                    this.controls.txtHonninShiharaiGaku().disabled = false;
                    this.controls.txtSetaiSyuyakuBango().disabled = false;
                    this.controls.txtShikyusinaiRiyu().disabled = false;
                    this.controls.rdbShinsaHohoKubun().disabled = false;

                    this.controls.tplKetteiJoho().disabled = true;
                    this.controls.tplKetteiJoho().visible = false;
                };

                DisplayMode.prototype.shusei = function () {
                    this.controls.tplShinseisha().disabled = false;
                    this.controls.txtShinseiYMD().disabled = false;
                    this.controls.rdbShinseisyaKubun().disabled = false;
                    this.controls.txtHokenJyaBango().disabled = false;
                    this.controls.chkKokuhorenSaiso().disabled = false;
                    this.controls.txtShimeiKanji().disabled = false;
                    this.controls.txtShimeiKana().disabled = false;
                    this.controls.txtTelNo().disabled = false;
                    this.controls.txtShinseiRiyu().disabled = false;
                    this.controls.txtShiharaiTotalAmount().disabled = false;

                    this.controls.tplJudgementResult().disabled = false;
                    this.controls.txtUketsukeYMD().disabled = false;
                    this.controls.txtKetteiYMD().disabled = false;
                    this.controls.txtShikyuKingaku().disabled = false;
                    this.controls.txtHonninShiharaiGaku().disabled = false;
                    this.controls.txtSetaiSyuyakuBango().disabled = false;
                    this.controls.txtShikyusinaiRiyu().disabled = false;
                    this.controls.rdbShinsaHohoKubun().disabled = false;

                    this.controls.tplKetteiJoho().disabled = true;
                    this.controls.tplKetteiJoho().visible = false;
                };

                DisplayMode.prototype.sofuzumi = function () {
                    this.controls.tplShinseisha().disabled = false;
                    this.controls.txtShinseiYMD().disabled = true;
                    this.controls.rdbShinseisyaKubun().disabled = true;
                    this.controls.txtHokenJyaBango().disabled = true;
                    this.controls.chkKokuhorenSaiso().disabled = false;
                    this.controls.txtShimeiKanji().disabled = true;
                    this.controls.txtShimeiKana().disabled = true;
                    this.controls.txtTelNo().disabled = true;
                    this.controls.txtShinseiRiyu().disabled = true;
                    this.controls.txtShiharaiTotalAmount().disabled = true;

                    this.controls.tplJudgementResult().disabled = true;

                    this.controls.tplKetteiJoho().disabled = true;
                    this.controls.tplKetteiJoho().visible = false;
                };

                DisplayMode.prototype.sakujyo = function () {
                    this.controls.tplShinseisha().disabled = true;

                    this.controls.tplKoza().disabled = true;

                    this.controls.tplJudgementResult().disabled = true;

                    this.controls.tplKetteiJoho().disabled = true;
                    this.controls.tplKetteiJoho().visible = false;
                };

                DisplayMode.prototype.shokai = function () {
                    this.controls.tplShinseisha().disabled = true;

                    this.controls.tplKoza().disabled = true;

                    this.controls.tplJudgementResult().disabled = true;

                    this.controls.tplKetteiJoho().disabled = true;
                    this.controls.tplKetteiJoho().visible = true;
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;
        })(KogakuServicehiDetail.Modes || (KogakuServicehiDetail.Modes = {}));
        var Modes = KogakuServicehiDetail.Modes;
    })(DBC.KogakuServicehiDetail || (DBC.KogakuServicehiDetail = {}));
    var KogakuServicehiDetail = DBC.KogakuServicehiDetail;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
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
    })(DBC.KogakuServicehiDetail || (DBC.KogakuServicehiDetail = {}));
    var KogakuServicehiDetail = DBC.KogakuServicehiDetail;
})(DBC || (DBC = {}));
