var DBZ;
(function (DBZ) {
    (function (SetaiShotokuIchiran) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SetaiShotokuIchiran.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SetaiShotokuIchiran.ModeController = ModeController;
    })(DBZ.SetaiShotokuIchiran || (DBZ.SetaiShotokuIchiran = {}));
    var SetaiShotokuIchiran = DBZ.SetaiShotokuIchiran;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SetaiShotokuIchiran) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SetaiShotokuIchiran.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtKijunYmdVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKijunYmdReadOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKazeiNendoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKazeiNendoReadOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlKazeiNendoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlKazeiNendoDataSource", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnSaihyojiVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSaihyojiOnClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("chkIchiranAllOnClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnNarabeteHyojuVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnNarabeteHyojuOnClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgSetaishotokuGridSetting", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgSetaishotokuWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgSetaishotokuOnSelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgSetaishotokuDbClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgSetaishotokuBySelectButton", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlKazeiNendoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnNarabeteHyoJiDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSetaiCodeDisyplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSaihyojiDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("lblKijunYMDMsgVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("lblKijunYMDMsgDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSetaiIchiranKazeiNendoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtKijunYmdVisible = function () {
                return this.controls.txtSetaiIchiranKijunYMD().visible;
            };

            PublicProperties.prototype.settxtKijunYmdVisible = function (value) {
                this.controls.txtSetaiIchiranKijunYMD().visible = value;
            };

            PublicProperties.prototype.gettxtKijunYmdReadOnly = function () {
                return this.controls.txtSetaiIchiranKijunYMD().readOnly;
            };

            PublicProperties.prototype.settxtKijunYmdReadOnly = function (value) {
                this.controls.txtSetaiIchiranKijunYMD().readOnly = value;
            };

            PublicProperties.prototype.gettxtKazeiNendoVisible = function () {
                return this.controls.txtSetaiIchiranKazeiNendo().visible;
            };

            PublicProperties.prototype.settxtKazeiNendoVisible = function (value) {
                this.controls.txtSetaiIchiranKazeiNendo().visible = value;
            };

            PublicProperties.prototype.gettxtKazeiNendoReadOnly = function () {
                return this.controls.txtSetaiIchiranKazeiNendo().readOnly;
            };

            PublicProperties.prototype.settxtKazeiNendoReadOnly = function (value) {
                this.controls.txtSetaiIchiranKazeiNendo().readOnly = value;
            };

            PublicProperties.prototype.getddlKazeiNendoVisible = function () {
                return this.controls.ddlSetaiIchiranKazeiNendo().visible;
            };

            PublicProperties.prototype.setddlKazeiNendoVisible = function (value) {
                this.controls.ddlSetaiIchiranKazeiNendo().visible = value;
            };

            PublicProperties.prototype.getbtnSaihyojiVisible = function () {
                return this.controls.btnSaiHyoji().visible;
            };

            PublicProperties.prototype.setbtnSaihyojiVisible = function (value) {
                this.controls.btnSaiHyoji().visible = value;
            };

            PublicProperties.prototype.getbtnSaihyojiOnClick = function () {
                return this.controls.btnSaiHyoji().onClick;
            };

            PublicProperties.prototype.setbtnSaihyojiOnClick = function (value) {
                this.controls.btnSaiHyoji().onClick = value;
            };

            PublicProperties.prototype.getchkIchiranAllOnClick = function () {
                return this.controls.chkSetaiIchiranAll().onClick;
            };

            PublicProperties.prototype.setchkIchiranAllOnClick = function (value) {
                this.controls.chkSetaiIchiranAll().onClick = value;
            };

            PublicProperties.prototype.getbtnNarabeteHyojuVisible = function () {
                return this.controls.btnNarabeteHyoji().visible;
            };

            PublicProperties.prototype.setbtnNarabeteHyojuVisible = function (value) {
                this.controls.btnNarabeteHyoji().visible = value;
            };

            PublicProperties.prototype.getbtnNarabeteHyojuOnClick = function () {
                return this.controls.btnNarabeteHyoji().onClick;
            };

            PublicProperties.prototype.setbtnNarabeteHyojuOnClick = function (value) {
                this.controls.btnNarabeteHyoji().onClick = value;
            };

            PublicProperties.prototype.getdgSetaishotokuWidth = function () {
                return this.controls.dgSetaiShotoku().width;
            };

            PublicProperties.prototype.setdgSetaishotokuWidth = function (value) {
                this.controls.dgSetaiShotoku().width = value;
            };

            PublicProperties.prototype.getdgSetaishotokuOnSelect = function () {
                return this.controls.dgSetaiShotoku().onSelect;
            };

            PublicProperties.prototype.setdgSetaishotokuOnSelect = function (value) {
                this.controls.dgSetaiShotoku().onSelect = value;
            };

            PublicProperties.prototype.getdgSetaishotokuDbClick = function () {
                return this.controls.dgSetaiShotoku().onSelectByDblClick;
            };

            PublicProperties.prototype.setdgSetaishotokuDbClick = function (value) {
                this.controls.dgSetaiShotoku().onSelectByDblClick = value;
            };

            PublicProperties.prototype.getdgSetaishotokuBySelectButton = function () {
                return this.controls.dgSetaiShotoku().onSelectBySelectButton;
            };

            PublicProperties.prototype.setdgSetaishotokuBySelectButton = function (value) {
                this.controls.dgSetaiShotoku().onSelectBySelectButton = value;
            };

            PublicProperties.prototype.getddlKazeiNendoDisplayNone = function () {
                return this.controls.ddlSetaiIchiranKazeiNendo().displayNone;
            };

            PublicProperties.prototype.setddlKazeiNendoDisplayNone = function (value) {
                this.controls.ddlSetaiIchiranKazeiNendo().displayNone = value;
            };

            PublicProperties.prototype.getbtnNarabeteHyoJiDisplayNone = function () {
                return this.controls.btnNarabeteHyoji().displayNone;
            };

            PublicProperties.prototype.setbtnNarabeteHyoJiDisplayNone = function (value) {
                this.controls.btnNarabeteHyoji().displayNone = value;
            };

            PublicProperties.prototype.gettxtSetaiCodeDisyplayNone = function () {
                return this.controls.txtSetaiIchiranSetaiCode().displayNone;
            };

            PublicProperties.prototype.settxtSetaiCodeDisyplayNone = function (value) {
                this.controls.txtSetaiIchiranSetaiCode().displayNone = value;
            };

            PublicProperties.prototype.getbtnSaihyojiDisplayNone = function () {
                return this.controls.btnSaiHyoji().displayNone;
            };

            PublicProperties.prototype.setbtnSaihyojiDisplayNone = function (value) {
                this.controls.btnSaiHyoji().displayNone = value;
            };

            PublicProperties.prototype.getlblKijunYMDMsgVisible = function () {
                return this.controls.lblSetaiIchiranMsg().visible;
            };

            PublicProperties.prototype.setlblKijunYMDMsgVisible = function (value) {
                this.controls.lblSetaiIchiranMsg().visible = value;
            };

            PublicProperties.prototype.getlblKijunYMDMsgDisplayNone = function () {
                return this.controls.lblSetaiIchiranMsg().displayNone;
            };

            PublicProperties.prototype.setlblKijunYMDMsgDisplayNone = function (value) {
                this.controls.lblSetaiIchiranMsg().displayNone = value;
            };

            PublicProperties.prototype.gettxtSetaiIchiranKazeiNendoDisplayNone = function () {
                return this.controls.txtSetaiIchiranKazeiNendo().displayNone;
            };

            PublicProperties.prototype.settxtSetaiIchiranKazeiNendoDisplayNone = function (value) {
                this.controls.txtSetaiIchiranKazeiNendo().displayNone = value;
            };
            return PublicProperties;
        })();
        SetaiShotokuIchiran.PublicProperties = PublicProperties;
    })(DBZ.SetaiShotokuIchiran || (DBZ.SetaiShotokuIchiran = {}));
    var SetaiShotokuIchiran = DBZ.SetaiShotokuIchiran;
})(DBZ || (DBZ = {}));
