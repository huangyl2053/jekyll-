var DBZ;
(function (DBZ) {
    (function (JukyuShikakuShomeishoHakko) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        JukyuShikakuShomeishoHakko.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JukyuShikakuShomeishoHakko";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JukyuShikakuShomeishoHakko.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JukyuShikakuShomeishoHakko.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JukyuShikakuShomeishoHakko = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKofuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKofuDate"));
            };

            Controls.prototype.txtIdoYoteiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIdoYoteiDate"));
            };

            Controls.prototype.txtYokaigoJotai = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigoJotai"));
            };

            Controls.prototype.txtNinteiYukoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoKikan"));
            };

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.lblNinteiShinsakaiIken = function () {
                return new UZA.Label(this.convFiledName("lblNinteiShinsakaiIken"));
            };

            Controls.prototype.txtNinteiShinsakaiIken = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtNinteiShinsakaiIken"));
            };

            Controls.prototype.lblBiko = function () {
                return new UZA.Label(this.convFiledName("lblBiko"));
            };

            Controls.prototype.txtBiko = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtBiko"));
            };

            Controls.prototype.chkJushoHihyoji = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJushoHihyoji"));
            };
            return Controls;
        })();
        JukyuShikakuShomeishoHakko.Controls = Controls;
    })(DBZ.JukyuShikakuShomeishoHakko || (DBZ.JukyuShikakuShomeishoHakko = {}));
    var JukyuShikakuShomeishoHakko = DBZ.JukyuShikakuShomeishoHakko;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (JukyuShikakuShomeishoHakko) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JukyuShikakuShomeishoHakko.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JukyuShikakuShomeishoHakko.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JukyuShikakuShomeishoHakko.ModeController = ModeController;
    })(DBZ.JukyuShikakuShomeishoHakko || (DBZ.JukyuShikakuShomeishoHakko = {}));
    var JukyuShikakuShomeishoHakko = DBZ.JukyuShikakuShomeishoHakko;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (JukyuShikakuShomeishoHakko) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JukyuShikakuShomeishoHakko.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JukyuShikakuShomeishoHakko.PublicProperties = PublicProperties;
    })(DBZ.JukyuShikakuShomeishoHakko || (DBZ.JukyuShikakuShomeishoHakko = {}));
    var JukyuShikakuShomeishoHakko = DBZ.JukyuShikakuShomeishoHakko;
})(DBZ || (DBZ = {}));
