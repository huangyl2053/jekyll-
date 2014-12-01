var DBZ;
(function (DBZ) {
    (function (ShinseishaInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_ddlShinseishaKubun = function () {
                return "onChange_ddlShinseishaKubun";
            };
            return Events;
        })();
        ShinseishaInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShinseishaInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShinseishaInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShinseishaInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShinseishaInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.ddlShinseishaKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinseishaKubun"));
            };

            Controls.prototype.txtUketsukeDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeDate"));
            };

            Controls.prototype.txtShinseiRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.btnJigyoshaInputGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyoshaInputGuide"));
            };

            Controls.prototype.btnHonninJohoCopy = function () {
                return new UZA.Button(this.convFiledName("btnHonninJohoCopy"));
            };

            Controls.prototype.ddlHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHokensha"));
            };

            Controls.prototype.txtShinseishaNameKana = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaNameKana"));
            };

            Controls.prototype.txtShinseishaName = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaName"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtAddress = function () {
                return new UZA.TextBox(this.convFiledName("txtAddress"));
            };
            return Controls;
        })();
        ShinseishaInfo.Controls = Controls;
    })(DBZ.ShinseishaInfo || (DBZ.ShinseishaInfo = {}));
    var ShinseishaInfo = DBZ.ShinseishaInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShinseishaInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShinseishaInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShinseishaInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShinseishaInfo.ModeController = ModeController;
    })(DBZ.ShinseishaInfo || (DBZ.ShinseishaInfo = {}));
    var ShinseishaInfo = DBZ.ShinseishaInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShinseishaInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShinseishaInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("btnJigyoshaInputGuide_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtUkestukeDate_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtJigyoshaNo_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtShinseishaName_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtYubinNo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtAddress_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnJigyoshaInputGuide_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("shinseishaInfo_eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getbtnJigyoshaInputGuide_displayNone = function () {
                return this.controls.btnJigyoshaInputGuide().displayNone;
            };

            PublicProperties.prototype.setbtnJigyoshaInputGuide_displayNone = function (value) {
                this.controls.btnJigyoshaInputGuide().displayNone = value;
            };

            PublicProperties.prototype.gettxtUkestukeDate_displayNone = function () {
                return this.controls.txtUketsukeDate().displayNone;
            };

            PublicProperties.prototype.settxtUkestukeDate_displayNone = function (value) {
                this.controls.txtUketsukeDate().displayNone = value;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.ShinseishaInfo().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.ShinseishaInfo().title = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.ShinseishaInfo().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.ShinseishaInfo().panelDisplay = value;
            };

            PublicProperties.prototype.gettxtJigyoshaNo_disabled = function () {
                return this.controls.txtJigyoshaNo().disabled;
            };

            PublicProperties.prototype.settxtJigyoshaNo_disabled = function (value) {
                this.controls.txtJigyoshaNo().disabled = value;
            };

            PublicProperties.prototype.gettxtShinseishaName_labelLText = function () {
                return this.controls.txtShinseishaNameKana().labelLText;
            };

            PublicProperties.prototype.settxtShinseishaName_labelLText = function (value) {
                this.controls.txtShinseishaNameKana().labelLText = value;
            };

            PublicProperties.prototype.gettxtYubinNo_displayNone = function () {
                return this.controls.txtYubinNo().displayNone;
            };

            PublicProperties.prototype.settxtYubinNo_displayNone = function (value) {
                this.controls.txtYubinNo().displayNone = value;
            };

            PublicProperties.prototype.gettxtAddress_displayNone = function () {
                return this.controls.txtAddress().displayNone;
            };

            PublicProperties.prototype.settxtAddress_displayNone = function (value) {
                this.controls.txtAddress().displayNone = value;
            };

            PublicProperties.prototype.getbtnJigyoshaInputGuide_disabled = function () {
                return this.controls.btnJigyoshaInputGuide().disabled;
            };

            PublicProperties.prototype.setbtnJigyoshaInputGuide_disabled = function (value) {
                this.controls.btnJigyoshaInputGuide().disabled = value;
            };

            PublicProperties.prototype.getshinseishaInfo_eraseBorder = function () {
                return this.controls.ShinseishaInfo().eraseBorder;
            };

            PublicProperties.prototype.setshinseishaInfo_eraseBorder = function (value) {
                this.controls.ShinseishaInfo().eraseBorder = value;
            };
            return PublicProperties;
        })();
        ShinseishaInfo.PublicProperties = PublicProperties;
    })(DBZ.ShinseishaInfo || (DBZ.ShinseishaInfo = {}));
    var ShinseishaInfo = DBZ.ShinseishaInfo;
})(DBZ || (DBZ = {}));
