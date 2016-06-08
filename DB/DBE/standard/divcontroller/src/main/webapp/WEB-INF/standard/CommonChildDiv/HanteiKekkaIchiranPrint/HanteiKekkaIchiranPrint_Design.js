var DBE;
(function (DBE) {
    (function (HanteiKekkaIchiranPrint) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        HanteiKekkaIchiranPrint.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HanteiKekkaIchiranPrint";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.HanteiKekkaIchiranPrint.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.HanteiKekkaIchiranPrint.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HanteiKekkaIchiranPrint = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHokenshaCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHokenshaCode"));
            };

            Controls.prototype.txtHokenshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenshaName"));
            };

            Controls.prototype.chkPrintChohyo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkPrintChohyo"));
            };

            Controls.prototype.spSpace1 = function () {
                return new UZA.Space(this.convFiledName("spSpace1"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnPritBatch = function () {
                return new UZA.ButtonBatchRegister(this.convFiledName("btnPritBatch"));
            };
            return Controls;
        })();
        HanteiKekkaIchiranPrint.Controls = Controls;
    })(DBE.HanteiKekkaIchiranPrint || (DBE.HanteiKekkaIchiranPrint = {}));
    var HanteiKekkaIchiranPrint = DBE.HanteiKekkaIchiranPrint;
})(DBE || (DBE = {}));
