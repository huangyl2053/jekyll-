var DBZ;
(function (DBZ) {
    (function (ChosaJisshishaJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_ddlChosaJisshiBasho = function () {
                return "onChange_ddlChosaJisshiBasho";
            };

            Events.onChange_ddlShozokuKikan = function () {
                return "onChange_ddlShozokuKikan";
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

            Controls.prototype.txtChosaJisshiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtChosaJisshiDate"));
            };

            Controls.prototype.ddlChosaJisshiBasho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChosaJisshiBasho"));
            };

            Controls.prototype.txtJisshiBashoMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtJisshiBashoMeisho"));
            };

            Controls.prototype.ddlShozokuKikan = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShozokuKikan"));
            };

            Controls.prototype.ddlKinyusha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKinyusha"));
            };

            Controls.prototype.txtChosaKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtChosaKubun"));
            };
            return Controls;
        })();
        ChosaJisshishaJoho.Controls = Controls;
    })(DBZ.ChosaJisshishaJoho || (DBZ.ChosaJisshishaJoho = {}));
    var ChosaJisshishaJoho = DBZ.ChosaJisshishaJoho;
})(DBZ || (DBZ = {}));
