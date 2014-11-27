/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SogoShokaiKogakuKaigoServicehiInfo {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SogoShokaiKogakuKaigoServicehiInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SogoShokaiKogakuKaigoServicehiInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SogoShokaiKogakuKaigoServicehiInfo.Controls.myType() + "_" + fieldName;
            }

            public SogoShokaiKogakuKaigoServicehiInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtKogakuTeikyoYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuTeikyoYM"));
            }

            public txtKogakuShinseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuShinseiYMD"));
            }

            public txtKogakuShiharaigaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuShiharaigaku"));
            }

            public txtKogakuShiharaiHoho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKogakuShiharaiHoho"));
            }

            public txtKogakuKinyuKikanCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKogakuKinyuKikanCode"));
            }

            public txtKogakuKinyuKikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKogakuKinyuKikanName"));
            }

            public txtKogakuKozaShubetsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKogakuKozaShubetsu"));
            }

            public txtKogakuKozaMeiginin(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKogakuKozaMeiginin"));
            }

            public txtKogakuShitenCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKogakuShitenCode"));
            }

            public txtKogakuShitenName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKogakuShitenName"));
            }

            public txtKogakuKozaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKogakuKozaNo"));
            }

            public txtKogakuKozaMeigininKana(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtKogakuKozaMeigininKana"));
            }

            public txtKogakuKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuKetteiYMD"));
            }

            public txtKogakuShikyuKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKogakuShikyuKubun"));
            }

            public txtKogakuShikyugaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuShikyugaku"));
            }

            public txtKogakuFushikyuRiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKogakuFushikyuRiyu"));
            }

            public txtKogakuSetaiShuyakuNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKogakuSetaiShuyakuNo"));
            }

            public SogoShokaiKogakuKokuhorenKettei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiKogakuKokuhorenKettei"));
            }

            public txtKogakuKokuhorenTsuchishoNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKogakuKokuhorenTsuchishoNo"));
            }

            public txtKogakuKokuhorenShikyuKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKogakuKokuhorenShikyuKubun"));
            }

            public txtKogakuKokuhorenKetteiYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuKokuhorenKetteiYM"));
            }

            public txtKogakuKokuhorenFutangaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuKokuhorenFutangaku"));
            }

            public txtKogakuKokuhorenShikyugaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuKokuhorenShikyugaku"));
            }

            public txtKogakuTsuchishoSakuseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuTsuchishoSakuseiYMD"));
            }

            public SogoShokaiKogakuFurikomi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiKogakuFurikomi"));
            }

            public txtKogakuFurikomiMeisaiSakuseiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuFurikomiMeisaiSakuseiYMD"));
            }

            public txtKogakuFurikomiShiharaiYoteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuFurikomiShiharaiYoteiYMD"));
            }

            public SogoShokaiKogakuKokuhorenSofu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiKogakuKokuhorenSofu"));
            }

            public txtKogakuKokuhorenSofuYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuKokuhorenSofuYM"));
            }

            public txtKogakuKokuhorenUketoriYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuKokuhorenUketoriYM"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

