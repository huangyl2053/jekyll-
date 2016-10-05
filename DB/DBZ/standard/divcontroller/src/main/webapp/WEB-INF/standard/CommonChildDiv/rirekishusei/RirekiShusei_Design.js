var DBZ;
(function (DBZ) {
    (function (RirekiShusei) {
        var Events = (function () {
            function Events() {
            }
            Events.onOkClose_btnChosaJokyo = function () {
                return "onOkClose_btnChosaJokyo";
            };

            Events.onBefore_btnChosaJokyo = function () {
                return "onBefore_btnChosaJokyo";
            };

            Events.onClick_btnKakutei = function () {
                return "onClick_btnKakutei";
            };

            Events.onClick_btnCancel = function () {
                return "onClick_btnCancel";
            };
            return Events;
        })();
        RirekiShusei.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "RirekiShusei";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.RirekiShusei.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.RirekiShusei.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.RirekiShusei = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdKaigoNinteiShinseiKihonJohoInput = function () {
                return new DBZ.KaigoNinteiShinseiKihonJohoInput.ModeController(this.convFiledName("ccdKaigoNinteiShinseiKihonJohoInput"));
            };

            Controls.prototype.ccdNinteiShinseiTodokedesha = function () {
                return new DBZ.NinteiShinseiTodokedesha.ModeController(this.convFiledName("ccdNinteiShinseiTodokedesha"));
            };

            Controls.prototype.ShijiiIryokikanAndShijiiInput = function () {
                return new UZA.Panel(this.convFiledName("ShijiiIryokikanAndShijiiInput"));
            };

            Controls.prototype.ccdShujiiIryokikanAndShujiiInput = function () {
                return new DBZ.ShujiiIryokikanAndShujiiInput.ModeController(this.convFiledName("ccdShujiiIryokikanAndShujiiInput"));
            };

            Controls.prototype.ChsaItakusakiAndChosainInput = function () {
                return new UZA.Panel(this.convFiledName("ChsaItakusakiAndChosainInput"));
            };

            Controls.prototype.ccdChosaItakusakiAndChosainInput = function () {
                return new DBZ.ChosaItakusakiAndChosainInput.ModeController(this.convFiledName("ccdChosaItakusakiAndChosainInput"));
            };

            Controls.prototype.ccdNinteiJohoInput = function () {
                return new DBZ.NinteiInput.ModeController(this.convFiledName("ccdNinteiJohoInput"));
            };

            Controls.prototype.ccdZenkaiNinteiKekka = function () {
                return new DBZ.ZenkaiNinteiKekkaJoho.ModeController(this.convFiledName("ccdZenkaiNinteiKekka"));
            };

            Controls.prototype.ccdShinseiSonotaJohoInput = function () {
                return new DBZ.ShinseiSonotaJohoInput.ModeController(this.convFiledName("ccdShinseiSonotaJohoInput"));
            };

            Controls.prototype.btnChosaJokyo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChosaJokyo"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        RirekiShusei.Controls = Controls;
    })(DBZ.RirekiShusei || (DBZ.RirekiShusei = {}));
    var RirekiShusei = DBZ.RirekiShusei;
})(DBZ || (DBZ = {}));
