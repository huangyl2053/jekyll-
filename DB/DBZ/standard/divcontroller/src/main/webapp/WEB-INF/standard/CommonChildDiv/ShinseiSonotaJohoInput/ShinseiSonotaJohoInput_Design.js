var DBZ;
(function (DBZ) {
    (function (ShinseiSonotaJohoInput) {
        var Events = (function () {
            function Events() {
            }
            Events.idojyu_onChange = function () {
                return "idojyu_onChange";
            };
            return Events;
        })();
        ShinseiSonotaJohoInput.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShinseiSonotaJohoInput";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShinseiSonotaJohoInput.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShinseiSonotaJohoInput.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShinseiSonotaJohoInput = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlIdoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIdoJiyu"));
            };

            Controls.prototype.ddlSakujoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSakujoJiyu"));
            };

            Controls.prototype.txtRiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtRiyu"));
            };

            Controls.prototype.txtSoshitsuDay = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSoshitsuDay"));
            };

            Controls.prototype.txtTorisageDay = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTorisageDay"));
            };

            Controls.prototype.txtToshoNinteiKikanFrom = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtToshoNinteiKikanFrom"));
            };

            Controls.prototype.txtToshoNinteiKikanTo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtToshoNinteiKikanTo"));
            };

            Controls.prototype.lblJukyuShikakuShomeisho = function () {
                return new UZA.Label(this.convFiledName("lblJukyuShikakuShomeisho"));
            };

            Controls.prototype.txtJukyuShikakuHakkoDay1 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtJukyuShikakuHakkoDay1"));
            };

            Controls.prototype.txtJukyuShikakuHakkoDay2 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtJukyuShikakuHakkoDay2"));
            };
            return Controls;
        })();
        ShinseiSonotaJohoInput.Controls = Controls;
    })(DBZ.ShinseiSonotaJohoInput || (DBZ.ShinseiSonotaJohoInput = {}));
    var ShinseiSonotaJohoInput = DBZ.ShinseiSonotaJohoInput;
})(DBZ || (DBZ = {}));
