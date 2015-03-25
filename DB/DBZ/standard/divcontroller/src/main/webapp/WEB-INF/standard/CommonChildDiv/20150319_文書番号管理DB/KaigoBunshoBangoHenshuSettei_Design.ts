/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoBunshoBangoHenshuSettei {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoBunshoBangoHenshuSettei";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoBunshoBangoHenshuSettei.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoBunshoBangoHenshuSettei.Controls.myType() + "_" + fieldName;
            }

            public KaigoBunshoBangoHenshuSettei(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtKaishiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKaishiYMD"));
            }

            public txtShuryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShuryoYMD"));
            }

            public lin1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            }

            public radBunshuBangoShuchuryokuUmu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radBunshuBangoShuchuryokuUmu"));
            }

            public txtYukoKetasu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtYukoKetasu"));
            }

            public lin2(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin2"));
            }

            public BunshoBangoKigo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("BunshoBangoKigo"));
            }

            public radBunshoBangoKigoFuyoUmu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radBunshoBangoKigoFuyoUmu"));
            }

            public txtBunshoBangoKigo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtBunshoBangoKigo"));
            }

            public BunshoHeader(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("BunshoHeader"));
            }

            public radBunshoHeaderFuyoUmu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radBunshoHeaderFuyoUmu"));
            }

            public txtBunshoNoHeader(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtBunshoNoHeader"));
            }

            public BunshoNoHenshu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("BunshoNoHenshu"));
            }

            public ddlBunshoNoHenshu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlBunshoNoHenshu"));
            }

            public ddlBunshoNoHatsuban(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlBunshoNoHatsuban"));
            }

            public txtBunshoKoseiNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtBunshoKoseiNo"));
            }

            public BunshoFooter(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("BunshoFooter"));
            }

            public radBunshoNoFooterFuyoUmu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radBunshoNoFooterFuyoUmu"));
            }

            public txtBunshoNoFooter(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtBunshoNoFooter"));
            }

        }

     }

}

