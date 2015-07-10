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
