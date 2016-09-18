var DBB;
(function (DBB) {
    (function (KaigoFukaKihon) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoFukaKihon.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoFukaKihon";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBB.KaigoFukaKihon.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBB.KaigoFukaKihon.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoFukaKihon = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTsuchishoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTsuchishoNo"));
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            };

            Controls.prototype.txtHokenryoDankai = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenryoDankai"));
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

            Controls.prototype.btnHihoRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHihoRireki"));
            };
            return Controls;
        })();
        KaigoFukaKihon.Controls = Controls;
    })(DBB.KaigoFukaKihon || (DBB.KaigoFukaKihon = {}));
    var KaigoFukaKihon = DBB.KaigoFukaKihon;
})(DBB || (DBB = {}));
