var DBD;
(function (DBD) {
    (function (ZenkaiNinteiKekkaJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.btn_ZenkaiShosai = function () {
                return "btn_ZenkaiShosai";
            };
            return Events;
        })();
        ZenkaiNinteiKekkaJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ZenkaiNinteiKekkaJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.ZenkaiNinteiKekkaJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.ZenkaiNinteiKekkaJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ZenkaiNinteiKekkaJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtYokaigodo = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigodo"));
            };

            Controls.prototype.txtNinteiDay = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiDay"));
            };

            Controls.prototype.txtYukoKikanFrom = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukoKikanFrom"));
            };

            Controls.prototype.btnZenkaiShosai = function () {
                return new UZA.Button(this.convFiledName("btnZenkaiShosai"));
            };

            Controls.prototype.txtYukoKikanTo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukoKikanTo"));
            };
            return Controls;
        })();
        ZenkaiNinteiKekkaJoho.Controls = Controls;
    })(DBD.ZenkaiNinteiKekkaJoho || (DBD.ZenkaiNinteiKekkaJoho = {}));
    var ZenkaiNinteiKekkaJoho = DBD.ZenkaiNinteiKekkaJoho;
})(DBD || (DBD = {}));
