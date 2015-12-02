/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
/// <reference path="./../kaigoatesakijushosettei/KaigoAtesakiJushoSettei.ts" />
/// <reference path="../../d.ts/URZCommonChildDiv.d.ts" />

module DBZ {

     export module KaigoChohyoSeigyoKyotsu {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoChohyoSeigyoKyotsu";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoChohyoSeigyoKyotsu.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoChohyoSeigyoKyotsu.Controls.myType() + "_" + fieldName;
            }

            public KaigoChohyoSeigyoKyotsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public AtesakiJusho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("AtesakiJusho"));
            }

            public ccdKaigoAtesakiJushoSettei(): DBZ.KaigoAtesakiJushoSettei.ModeController {
                return new DBZ.KaigoAtesakiJushoSettei.ModeController(this.convFiledName("ccdKaigoAtesakiJushoSettei"));
            }

            public ConfigInfo1(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ConfigInfo1"));
            }

            public HyojiCodeName(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HyojiCodeName"));
            }

            public ddlHyojiCodeName1(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHyojiCodeName1"));
            }

            public ddlHyojiCodeName2(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHyojiCodeName2"));
            }

            public ddlHyojiCodeName3(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHyojiCodeName3"));
            }

            public ConfigInfo2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ConfigInfo2"));
            }

            public radSetaiNushiHyoji(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSetaiNushiHyoji"));
            }

            public radDainoninHyoji(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radDainoninHyoji"));
            }

            public radKozaMask(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKozaMask"));
            }

            public radKozaMeigininKana(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKozaMeigininKana"));
            }

            public ConfigInfo3(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ConfigInfo3"));
            }

            public radMonjiKireCrtlGaibu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMonjiKireCrtlGaibu"));
            }

            public radMonjiKireCrtlNaibu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMonjiKireCrtlNaibu"));
            }

            public radMojiKireBunriCtrl(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMojiKireBunriCtrl"));
            }

            public radDaikoPrintUmu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radDaikoPrintUmu"));
            }

            public ddlChohyoMongonYoshiki(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlChohyoMongonYoshiki"));
            }

            public ConfigInfo4(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ConfigInfo4"));
            }

            public lin1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            }

            public BarCode(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("BarCode"));
            }

            public ddlBarCodeUmu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlBarCodeUmu"));
            }

            public ddlBarCodeHenshuHoho(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlBarCodeHenshuHoho"));
            }

            public CommonButtonPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("CommonButtonPanel"));
            }

            public btnBunshoNo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnBunshoNo"));
            }

            public btnTsuchishoTeikeibun(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTsuchishoTeikeibun"));
            }

            public btnGyomuNinshohsa(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnGyomuNinshohsa"));
            }

            public btnKaigoToiawasesaki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKaigoToiawasesaki"));
            }

            public ccdChohyoShutsuryokujun(): URZ.ChohyoShutsuryokujun.ModeController {
                return new URZ.ChohyoShutsuryokujun.ModeController(this.convFiledName("ccdChohyoShutsuryokujun"));
            }

        }

     }

}

