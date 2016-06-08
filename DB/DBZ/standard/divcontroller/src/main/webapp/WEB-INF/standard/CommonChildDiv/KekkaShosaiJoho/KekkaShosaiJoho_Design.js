var DBZ;
(function (DBZ) {
    (function (KekkaShosaiJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnModoru = function () {
                return "onClick_btnModoru";
            };

            Events.onClick_btnToroku = function () {
                return "onClick_btnToroku";
            };
            return Events;
        })();
        KekkaShosaiJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KekkaShosaiJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KekkaShosaiJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KekkaShosaiJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KekkaShosaiJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdNinteiInput = function () {
                return new DBZ.NinteiInput.ModeController(this.convFiledName("ccdNinteiInput"));
            };

            Controls.prototype.ccdShinseiSonotaJohoInput = function () {
                return new DBZ.ShinseiSonotaJohoInput.ModeController(this.convFiledName("ccdShinseiSonotaJohoInput"));
            };

            Controls.prototype.txtShinseiKubunShinsei = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubunShinsei"));
            };

            Controls.prototype.txtShinseiKubunLaw = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubunLaw"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnToroku = function () {
                return new UZA.Button(this.convFiledName("btnToroku"));
            };
            return Controls;
        })();
        KekkaShosaiJoho.Controls = Controls;
    })(DBZ.KekkaShosaiJoho || (DBZ.KekkaShosaiJoho = {}));
    var KekkaShosaiJoho = DBZ.KekkaShosaiJoho;
})(DBZ || (DBZ = {}));
