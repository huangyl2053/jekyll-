var DBZ;
(function (DBZ) {
    (function (KaigoSonotaConfigInfo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoSonotaConfigInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoSonotaConfigInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoSonotaConfigInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoSonotaConfigInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoSonotaConfigInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.HyojiCodeBusu = function () {
                return new UZA.Panel(this.convFiledName("HyojiCodeBusu"));
            };

            Controls.prototype.HyojiCodeName = function () {
                return new UZA.Panel(this.convFiledName("HyojiCodeName"));
            };

            Controls.prototype.ddlHyojiCodeName1 = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHyojiCodeName1"));
            };

            Controls.prototype.ddlHyojiCodeName2 = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHyojiCodeName2"));
            };

            Controls.prototype.ddlHyojiCodeName3 = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHyojiCodeName3"));
            };

            Controls.prototype.InnojiBusuInput = function () {
                return new UZA.Panel(this.convFiledName("InnojiBusuInput"));
            };

            Controls.prototype.txtInnojiCrtl = function () {
                return new UZA.TextBox(this.convFiledName("txtInnojiCrtl"));
            };

            Controls.prototype.txtHakkoBusu = function () {
                return new UZA.TextBox(this.convFiledName("txtHakkoBusu"));
            };

            Controls.prototype.SonotaConfigInfo = function () {
                return new UZA.Panel(this.convFiledName("SonotaConfigInfo"));
            };

            Controls.prototype.radDenshiKouin = function () {
                return new UZA.RadioButton(this.convFiledName("radDenshiKouin"));
            };

            Controls.prototype.radDainoninKbn = function () {
                return new UZA.RadioButton(this.convFiledName("radDainoninKbn"));
            };

            Controls.prototype.radSetaiNushiHyoji = function () {
                return new UZA.RadioButton(this.convFiledName("radSetaiNushiHyoji"));
            };

            Controls.prototype.radKozaMask = function () {
                return new UZA.RadioButton(this.convFiledName("radKozaMask"));
            };

            Controls.prototype.SonotaConfigInfo2 = function () {
                return new UZA.Panel(this.convFiledName("SonotaConfigInfo2"));
            };

            Controls.prototype.radBatchHakkoUmu = function () {
                return new UZA.RadioButton(this.convFiledName("radBatchHakkoUmu"));
            };

            Controls.prototype.radMonjiKireCrtl = function () {
                return new UZA.RadioButton(this.convFiledName("radMonjiKireCrtl"));
            };

            Controls.prototype.radMojiKireBunriKbn = function () {
                return new UZA.RadioButton(this.convFiledName("radMojiKireBunriKbn"));
            };

            Controls.prototype.radInjiIchi = function () {
                return new UZA.RadioButton(this.convFiledName("radInjiIchi"));
            };

            Controls.prototype.lin1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            };

            Controls.prototype.BarCode = function () {
                return new UZA.Panel(this.convFiledName("BarCode"));
            };

            Controls.prototype.ddlBarCodeUmu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlBarCodeUmu"));
            };

            Controls.prototype.ddlBarCodeHenshuHoho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlBarCodeHenshuHoho"));
            };
            return Controls;
        })();
        KaigoSonotaConfigInfo.Controls = Controls;
    })(DBZ.KaigoSonotaConfigInfo || (DBZ.KaigoSonotaConfigInfo = {}));
    var KaigoSonotaConfigInfo = DBZ.KaigoSonotaConfigInfo;
})(DBZ || (DBZ = {}));
