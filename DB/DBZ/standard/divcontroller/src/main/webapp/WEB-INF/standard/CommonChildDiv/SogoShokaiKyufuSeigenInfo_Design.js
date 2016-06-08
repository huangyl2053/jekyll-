var DBZ;
(function (DBZ) {
    (function (SogoShokaiKyufuSeigenInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiKyufuSeigenInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiKyufuSeigenInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiKyufuSeigenInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiKyufuSeigenInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiKyufuSeigenInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtSeigenTorokuJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtSeigenTorokuJokyo"));
            };

            Controls.prototype.txtSeigenShuryoJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtSeigenShuryoJokyo"));
            };

            Controls.prototype.SogoShokaiKyufuSeigenHenko = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKyufuSeigenHenko"));
            };

            Controls.prototype.txtSeigenHenkoYokokuTorokuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoYokokuTorokuYMD"));
            };

            Controls.prototype.txtSeigenHenkoKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoKetteiYMD"));
            };

            Controls.prototype.txtSeigenHenkoSashitomeSyuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoSashitomeSyuryoYMD"));
            };

            Controls.prototype.txtSeigenHenkoTekiyoShuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoTekiyoShuryoYMD"));
            };

            Controls.prototype.txtSeigenTainoKojoKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenTainoKojoKetteiYMD"));
            };

            Controls.prototype.txtSeigenChoshuShometsuKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenChoshuShometsuKikan"));
            };

            Controls.prototype.txtSeigenNofuzumiKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenNofuzumiKikan"));
            };

            Controls.prototype.SogoShokaiKyufuSeigenGengaku = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKyufuSeigenGengaku"));
            };

            Controls.prototype.txtSeigenGengakuKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenGengakuKikan"));
            };

            Controls.prototype.txtSeigenGengakuKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenGengakuKetteiYMD"));
            };

            Controls.prototype.txtSeigenGengakuTekiyoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenGengakuTekiyoKikan"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiKyufuSeigenInfo.Controls = Controls;
    })(DBZ.SogoShokaiKyufuSeigenInfo || (DBZ.SogoShokaiKyufuSeigenInfo = {}));
    var SogoShokaiKyufuSeigenInfo = DBZ.SogoShokaiKyufuSeigenInfo;
})(DBZ || (DBZ = {}));
