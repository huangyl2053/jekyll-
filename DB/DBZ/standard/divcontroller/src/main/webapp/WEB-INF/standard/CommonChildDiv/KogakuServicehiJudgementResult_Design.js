var DBZ;
(function (DBZ) {
    (function (KogakuServicehiJudgementResult) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KogakuServicehiJudgementResult.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KogakuServicehiJudgementResult";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KogakuServicehiJudgementResult.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KogakuServicehiJudgementResult.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KogakuServicehiJudgementResult = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgJudgementResult = function () {
                return new UZA.DataGrid(this.convFiledName("dgJudgementResult"));
            };

            Controls.prototype.KogakuServicehiJudgementResultDetail1 = function () {
                return new UZA.Panel(this.convFiledName("KogakuServicehiJudgementResultDetail1"));
            };

            Controls.prototype.txtUketsukeDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeDate"));
            };

            Controls.prototype.txtHonninPaymentAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHonninPaymentAmount"));
            };

            Controls.prototype.txtKetteiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKetteiDate"));
            };

            Controls.prototype.radShikyuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radShikyuKubun"));
            };

            Controls.prototype.txtsetaiShuyakuNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtsetaiShuyakuNo"));
            };

            Controls.prototype.txtShikyuAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShikyuAmount"));
            };

            Controls.prototype.radIsKogakuAutoShokan = function () {
                return new UZA.RadioButton(this.convFiledName("radIsKogakuAutoShokan"));
            };

            Controls.prototype.KogakuServicehiJudgementResultDetail2 = function () {
                return new UZA.Panel(this.convFiledName("KogakuServicehiJudgementResultDetail2"));
            };

            Controls.prototype.txtBiko = function () {
                return new UZA.TextBox(this.convFiledName("txtBiko"));
            };

            Controls.prototype.radJudgementMethod = function () {
                return new UZA.RadioButton(this.convFiledName("radJudgementMethod"));
            };

            Controls.prototype.txtFushikyuRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushikyuRiyu"));
            };
            return Controls;
        })();
        KogakuServicehiJudgementResult.Controls = Controls;
    })(DBZ.KogakuServicehiJudgementResult || (DBZ.KogakuServicehiJudgementResult = {}));
    var KogakuServicehiJudgementResult = DBZ.KogakuServicehiJudgementResult;
})(DBZ || (DBZ = {}));
