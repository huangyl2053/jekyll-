var DBZ;
(function (DBZ) {
    (function (KaigoninteiShikakuInfo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoninteiShikakuInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoninteiShikakuInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoninteiShikakuInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoninteiShikakuInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoninteiShikakuInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            };

            Controls.prototype.txtShutokuYmd = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShutokuYmd"));
            };

            Controls.prototype.txtShutokuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtShutokuJiyu"));
            };

            Controls.prototype.txtSoshitsuYmd = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSoshitsuYmd"));
            };

            Controls.prototype.txtSoshitsuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtSoshitsuJiyu"));
            };

            Controls.prototype.txtJutokuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtJutokuKubun"));
            };

            Controls.prototype.txtYokaigoJotaiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigoJotaiKubun"));
            };

            Controls.prototype.txtNinteiKaishiYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiKaishiYmd"));
            };

            Controls.prototype.txtNinteiShuryoYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiShuryoYmd"));
            };

            Controls.prototype.txtHokensha = function () {
                return new UZA.TextBox(this.convFiledName("txtHokensha"));
            };
            return Controls;
        })();
        KaigoninteiShikakuInfo.Controls = Controls;
    })(DBZ.KaigoninteiShikakuInfo || (DBZ.KaigoninteiShikakuInfo = {}));
    var KaigoninteiShikakuInfo = DBZ.KaigoninteiShikakuInfo;
})(DBZ || (DBZ = {}));
