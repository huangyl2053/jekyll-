var DBZ;
(function (DBZ) {
    (function (KaigoNinteiShinseiKihonJohoInput) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoNinteiShinseiKihonJohoInput.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoNinteiShinseiKihonJohoInput";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoNinteiShinseiKihonJohoInput.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoNinteiShinseiKihonJohoInput.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoNinteiShinseiKihonJohoInput = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radShinseishoKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radShinseishoKubun"));
            };

            Controls.prototype.txtShinseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));
            };

            Controls.prototype.ddlShinseiShubetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinseiShubetsu"));
            };

            Controls.prototype.ddlShinseiKubunShinseiji = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinseiKubunShinseiji"));
            };

            Controls.prototype.ddlShinseiKubunHorei = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinseiKubunHorei"));
            };

            Controls.prototype.chkKyuSochisha = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKyuSochisha"));
            };

            Controls.prototype.ddlHihokenshaKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHihokenshaKubun"));
            };

            Controls.prototype.chkShikakuShutokuMae = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShikakuShutokuMae"));
            };

            Controls.prototype.ddlTokuteiShippei = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTokuteiShippei"));
            };

            Controls.prototype.txtShinseiJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseiJokyo"));
            };

            Controls.prototype.ServiceSakujo = function () {
                return new UZA.Panel(this.convFiledName("ServiceSakujo"));
            };

            Controls.prototype.btnServiceSakujoTeikeibun = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnServiceSakujoTeikeibun"));
            };

            Controls.prototype.txtServiceSakujo = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtServiceSakujo"));
            };

            Controls.prototype.NinteiShinseiRiyu = function () {
                return new UZA.Panel(this.convFiledName("NinteiShinseiRiyu"));
            };

            Controls.prototype.btnNinteiShinseiRiyuTeikeibun = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNinteiShinseiRiyuTeikeibun"));
            };

            Controls.prototype.txtNinteiShinseRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtNinteiShinseRiyu"));
            };
            return Controls;
        })();
        KaigoNinteiShinseiKihonJohoInput.Controls = Controls;
    })(DBZ.KaigoNinteiShinseiKihonJohoInput || (DBZ.KaigoNinteiShinseiKihonJohoInput = {}));
    var KaigoNinteiShinseiKihonJohoInput = DBZ.KaigoNinteiShinseiKihonJohoInput;
})(DBZ || (DBZ = {}));
