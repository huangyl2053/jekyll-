/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoSonotaConfigInfo {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoSonotaConfigInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoSonotaConfigInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoSonotaConfigInfo.Controls.myType() + "_" + fieldName;
            }

            public KaigoSonotaConfigInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public HyojiCodeBusu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HyojiCodeBusu"));
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

            public InnojiBusuInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("InnojiBusuInput"));
            }

            public txtInnojiCrtl(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtInnojiCrtl"));
            }

            public txtHakkoBusu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHakkoBusu"));
            }

            public SonotaConfigInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SonotaConfigInfo"));
            }

            public radDenshiKouin(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radDenshiKouin"));
            }

            public radDainoninKbn(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radDainoninKbn"));
            }

            public radSetaiNushiHyoji(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSetaiNushiHyoji"));
            }

            public radKozaMask(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKozaMask"));
            }

            public SonotaConfigInfo2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SonotaConfigInfo2"));
            }

            public radBatchHakkoUmu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radBatchHakkoUmu"));
            }

            public radMonjiKireCrtl(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMonjiKireCrtl"));
            }

            public radMojiKireBunriKbn(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMojiKireBunriKbn"));
            }

            public radInjiIchi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radInjiIchi"));
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

        }

     }

}

