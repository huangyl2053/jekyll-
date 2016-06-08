var DBZ;
(function (DBZ) {
    (function (NenReiTotatsuSrchConInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnKensaku = function () {
                return "onClick_btnKensaku";
            };
            return Events;
        })();
        NenReiTotatsuSrchConInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NenReiTotatsuSrchConInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NenReiTotatsuSrchConInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NenReiTotatsuSrchConInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NenReiTotatsuSrchConInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtZenkaiFrom = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiFrom"));
            };

            Controls.prototype.txtZenkaiTo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiTo"));
            };

            Controls.prototype.btnKensaku = function () {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            };

            Controls.prototype.txtNenreiTotatsuKikanFrom = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNenreiTotatsuKikanFrom"));
            };

            Controls.prototype.txtNenreiTotatsuKikanTo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNenreiTotatsuKikanTo"));
            };
            return Controls;
        })();
        NenReiTotatsuSrchConInfo.Controls = Controls;
    })(DBZ.NenReiTotatsuSrchConInfo || (DBZ.NenReiTotatsuSrchConInfo = {}));
    var NenReiTotatsuSrchConInfo = DBZ.NenReiTotatsuSrchConInfo;
})(DBZ || (DBZ = {}));
