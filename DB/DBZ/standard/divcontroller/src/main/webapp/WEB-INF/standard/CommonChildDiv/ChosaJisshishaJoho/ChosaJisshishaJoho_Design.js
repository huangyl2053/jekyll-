var DBZ;
(function (DBZ) {
    (function (ChosaJisshishaJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onBlur_txtShozokuKikanCode = function () {
                return "onBlur_txtShozokuKikanCode";
            };

            Events.onOkClose_btnChosaItakusakiGuide = function () {
                return "onOkClose_btnChosaItakusakiGuide";
            };

            Events.onClick_btnChosaItakusakiGuide = function () {
                return "onClick_btnChosaItakusakiGuide";
            };

            Events.onChange_ddlChosaJisshiBasho = function () {
                return "onChange_ddlChosaJisshiBasho";
            };

            Events.onBlur_txtKinyushaCode = function () {
                return "onBlur_txtKinyushaCode";
            };

            Events.onOkClose_btnChosainGuide = function () {
                return "onOkClose_btnChosainGuide";
            };

            Events.onClick_btnChosainGuide = function () {
                return "onClick_btnChosainGuide";
            };
            return Events;
        })();
        ChosaJisshishaJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChosaJisshishaJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ChosaJisshishaJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ChosaJisshishaJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChosaJisshishaJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtNinteiShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiShinseiDate"));
            };

            Controls.prototype.txtChosaKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtChosaKubun"));
            };

            Controls.prototype.txtShozokuKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShozokuKikanCode"));
            };

            Controls.prototype.btnChosaItakusakiGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChosaItakusakiGuide"));
            };

            Controls.prototype.txtShozokuKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtShozokuKikanName"));
            };

            Controls.prototype.txtChosaJisshiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtChosaJisshiDate"));
            };

            Controls.prototype.ddlChosaJisshiBasho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChosaJisshiBasho"));
            };

            Controls.prototype.txtJisshiBashoMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtJisshiBashoMeisho"));
            };

            Controls.prototype.txtKinyushaCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyushaCode"));
            };

            Controls.prototype.btnChosainGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChosainGuide"));
            };

            Controls.prototype.txtKinyushaName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyushaName"));
            };
            return Controls;
        })();
        ChosaJisshishaJoho.Controls = Controls;
    })(DBZ.ChosaJisshishaJoho || (DBZ.ChosaJisshishaJoho = {}));
    var ChosaJisshishaJoho = DBZ.ChosaJisshishaJoho;
})(DBZ || (DBZ = {}));
