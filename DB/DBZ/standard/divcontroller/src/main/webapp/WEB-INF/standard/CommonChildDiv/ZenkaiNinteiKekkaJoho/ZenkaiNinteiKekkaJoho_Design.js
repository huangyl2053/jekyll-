var DBZ;
(function (DBZ) {
    (function (ZenkaiNinteiKekkaJoho) {
        var Events = (function () {
            function Events() {
            }
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
                return this._myName + "_" + DBZ.ZenkaiNinteiKekkaJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ZenkaiNinteiKekkaJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ZenkaiNinteiKekkaJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtYokaigodo = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigodo"));
            };

            Controls.prototype.txtNinteiDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiDay"));
            };

            Controls.prototype.txtYukoKikanFrom = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtYukoKikanFrom"));
            };

            Controls.prototype.txtYukoKikanTo = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtYukoKikanTo"));
            };

            Controls.prototype.btnZenkaiShosaiGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnZenkaiShosaiGuide"));
            };
            return Controls;
        })();
        ZenkaiNinteiKekkaJoho.Controls = Controls;
    })(DBZ.ZenkaiNinteiKekkaJoho || (DBZ.ZenkaiNinteiKekkaJoho = {}));
    var ZenkaiNinteiKekkaJoho = DBZ.ZenkaiNinteiKekkaJoho;
})(DBZ || (DBZ = {}));
