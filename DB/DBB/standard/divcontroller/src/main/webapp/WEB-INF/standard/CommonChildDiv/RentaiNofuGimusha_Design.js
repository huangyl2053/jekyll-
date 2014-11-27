var DBB;
(function (DBB) {
    (function (RentaiNofuGimusha) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        RentaiNofuGimusha.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "RentaiNofuGimusha";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBB.RentaiNofuGimusha.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBB.RentaiNofuGimusha.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.RentaiNofuGimusha = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShikibetsuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShikibetsuCode"));
            };

            Controls.prototype.txtShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            };

            Controls.prototype.txtKaishiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaishiYMD"));
            };

            Controls.prototype.txtSyuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSyuryoYMD"));
            };
            return Controls;
        })();
        RentaiNofuGimusha.Controls = Controls;
    })(DBB.RentaiNofuGimusha || (DBB.RentaiNofuGimusha = {}));
    var RentaiNofuGimusha = DBB.RentaiNofuGimusha;
})(DBB || (DBB = {}));
