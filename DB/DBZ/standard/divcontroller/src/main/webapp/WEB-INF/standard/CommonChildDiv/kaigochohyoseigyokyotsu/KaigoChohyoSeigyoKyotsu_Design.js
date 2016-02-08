var DBZ;
(function (DBZ) {
    (function (KaigoChohyoSeigyoKyotsu) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoChohyoSeigyoKyotsu.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoChohyoSeigyoKyotsu";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoChohyoSeigyoKyotsu.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoChohyoSeigyoKyotsu.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoChohyoSeigyoKyotsu = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.AtesakiJusho = function () {
                return new UZA.Panel(this.convFiledName("AtesakiJusho"));
            };

            Controls.prototype.ccdKaigoAtesakiJushoSettei = function () {
                return new DBZ.KaigoAtesakiJushoSettei.ModeController(this.convFiledName("ccdKaigoAtesakiJushoSettei"));
            };

            Controls.prototype.ConfigInfo1 = function () {
                return new UZA.Panel(this.convFiledName("ConfigInfo1"));
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

            Controls.prototype.ConfigInfo2 = function () {
                return new UZA.Panel(this.convFiledName("ConfigInfo2"));
            };

            Controls.prototype.radSetaiNushiHyoji = function () {
                return new UZA.RadioButton(this.convFiledName("radSetaiNushiHyoji"));
            };

            Controls.prototype.radDainoninHyoji = function () {
                return new UZA.RadioButton(this.convFiledName("radDainoninHyoji"));
            };

            Controls.prototype.radKozaMask = function () {
                return new UZA.RadioButton(this.convFiledName("radKozaMask"));
            };

            Controls.prototype.radKozaMeigininKana = function () {
                return new UZA.RadioButton(this.convFiledName("radKozaMeigininKana"));
            };

            Controls.prototype.ConfigInfo3 = function () {
                return new UZA.Panel(this.convFiledName("ConfigInfo3"));
            };

            Controls.prototype.radMonjiKireCrtlGaibu = function () {
                return new UZA.RadioButton(this.convFiledName("radMonjiKireCrtlGaibu"));
            };

            Controls.prototype.radMonjiKireCrtlNaibu = function () {
                return new UZA.RadioButton(this.convFiledName("radMonjiKireCrtlNaibu"));
            };

            Controls.prototype.radMojiKireBunriCtrl = function () {
                return new UZA.RadioButton(this.convFiledName("radMojiKireBunriCtrl"));
            };

            Controls.prototype.radDaikoPrintUmu = function () {
                return new UZA.RadioButton(this.convFiledName("radDaikoPrintUmu"));
            };

            Controls.prototype.ddlChohyoMongonYoshiki = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChohyoMongonYoshiki"));
            };

            Controls.prototype.ConfigInfo4 = function () {
                return new UZA.Panel(this.convFiledName("ConfigInfo4"));
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

            Controls.prototype.CommonButtonPanel = function () {
                return new UZA.Panel(this.convFiledName("CommonButtonPanel"));
            };

            Controls.prototype.btnBunshoNo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnBunshoNo"));
            };

            Controls.prototype.btnTsuchishoTeikeibun = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTsuchishoTeikeibun"));
            };

            Controls.prototype.btnGyomuNinshohsa = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnGyomuNinshohsa"));
            };

            Controls.prototype.btnKaigoToiawasesaki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKaigoToiawasesaki"));
            };

            Controls.prototype.ccdChohyoShutsuryokujun = function () {
                return new URZ.ChohyoShutsuryokujun.ModeController(this.convFiledName("ccdChohyoShutsuryokujun"));
            };
            return Controls;
        })();
        KaigoChohyoSeigyoKyotsu.Controls = Controls;
    })(DBZ.KaigoChohyoSeigyoKyotsu || (DBZ.KaigoChohyoSeigyoKyotsu = {}));
    var KaigoChohyoSeigyoKyotsu = DBZ.KaigoChohyoSeigyoKyotsu;
})(DBZ || (DBZ = {}));
