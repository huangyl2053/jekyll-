var DBZ;
(function (DBZ) {
    (function (KagoMoshitate) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KagoMoshitate.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KagoMoshitate";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KagoMoshitate.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KagoMoshitate.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KagoMoshitate = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.txtJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));
            };

            Controls.prototype.txtSendYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSendYM"));
            };

            Controls.prototype.txtMoshitateshaKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtMoshitateshaKubun"));
            };

            Controls.prototype.txtShokisaiHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShokisaiHokenshaNo"));
            };

            Controls.prototype.txtShokisaiHokenshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtShokisaiHokenshaName"));
            };

            Controls.prototype.txtTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            };

            Controls.prototype.txtKagoForm = function () {
                return new UZA.TextBox(this.convFiledName("txtKagoForm"));
            };

            Controls.prototype.txtMoshitateDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtMoshitateDate"));
            };

            Controls.prototype.ddlKagoMoshitateRiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKagoMoshitateRiyu"));
            };

            Controls.prototype.chkForDogetsuShinsa = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkForDogetsuShinsa"));
            };
            return Controls;
        })();
        KagoMoshitate.Controls = Controls;
    })(DBZ.KagoMoshitate || (DBZ.KagoMoshitate = {}));
    var KagoMoshitate = DBZ.KagoMoshitate;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KagoMoshitate) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KagoMoshitate.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KagoMoshitate.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KagoMoshitate.ModeController = ModeController;
    })(DBZ.KagoMoshitate || (DBZ.KagoMoshitate = {}));
    var KagoMoshitate = DBZ.KagoMoshitate;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KagoMoshitate) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KagoMoshitate.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KagoMoshitate().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KagoMoshitate().title = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KagoMoshitate().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KagoMoshitate().eraseBorder = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.KagoMoshitate().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.KagoMoshitate().panelDisplay = value;
            };
            return PublicProperties;
        })();
        KagoMoshitate.PublicProperties = PublicProperties;
    })(DBZ.KagoMoshitate || (DBZ.KagoMoshitate = {}));
    var KagoMoshitate = DBZ.KagoMoshitate;
})(DBZ || (DBZ = {}));
