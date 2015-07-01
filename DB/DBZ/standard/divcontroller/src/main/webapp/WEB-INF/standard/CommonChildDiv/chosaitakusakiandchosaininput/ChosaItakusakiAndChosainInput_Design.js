var DBZ;
(function (DBZ) {
    (function (ChosaItakusakiAndChosainInput) {
        var Events = (function () {
            function Events() {
            }
            Events.onBlurTxtchosaItakusaki = function () {
                return "onBlurTxtchosaItakusaki";
            };

            Events.onClickBtnZenkaiFukusha = function () {
                return "onClickBtnZenkaiFukusha";
            };

            Events.onBlurTxtChosaincode = function () {
                return "onBlurTxtChosaincode";
            };

            Events.onClickBtnClear = function () {
                return "onClickBtnClear";
            };
            return Events;
        })();
        ChosaItakusakiAndChosainInput.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChosaItakusakiAndChosainInput";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ChosaItakusakiAndChosainInput.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ChosaItakusakiAndChosainInput.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChosaItakusakiAndChosainInput = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtChosaItakusakiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtChosaItakusakiCode"));
            };

            Controls.prototype.btnChosaItakusakiGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChosaItakusakiGuide"));
            };

            Controls.prototype.txtChosaItakusakiName = function () {
                return new UZA.TextBox(this.convFiledName("txtChosaItakusakiName"));
            };

            Controls.prototype.btnChosainRenrakuJiko = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChosainRenrakuJiko"));
            };

            Controls.prototype.btnZenkaiFukusha = function () {
                return new UZA.Button(this.convFiledName("btnZenkaiFukusha"));
            };

            Controls.prototype.txtChosainCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtChosainCode"));
            };

            Controls.prototype.btnChosainGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChosainGuide"));
            };

            Controls.prototype.txtChosainName = function () {
                return new UZA.TextBox(this.convFiledName("txtChosainName"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };
            return Controls;
        })();
        ChosaItakusakiAndChosainInput.Controls = Controls;
    })(DBZ.ChosaItakusakiAndChosainInput || (DBZ.ChosaItakusakiAndChosainInput = {}));
    var ChosaItakusakiAndChosainInput = DBZ.ChosaItakusakiAndChosainInput;
})(DBZ || (DBZ = {}));
