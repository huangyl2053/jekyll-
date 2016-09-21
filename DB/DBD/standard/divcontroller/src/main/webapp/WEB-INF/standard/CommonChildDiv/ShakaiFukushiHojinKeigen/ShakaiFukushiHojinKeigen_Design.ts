/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module ShakaiFukushiHojinKeigen {

        export class Events {

            public static onSelect_dgShakaiFukushiHojinKeigenList(): string {
                return "onSelect_dgShakaiFukushiHojinKeigenList";
            }

            public static CloseOK(): string {
                return "CloseOK";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShakaiFukushiHojinKeigen";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.ShakaiFukushiHojinKeigen.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.ShakaiFukushiHojinKeigen.Controls.myType() + "_" + fieldName;
            }

            public ShakaiFukushiHojinKeigen(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgShakaiFukushiHojinKeigenList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShakaiFukushiHojinKeigenList"));
            }

            public ShakaiFukushiHojinKeigenDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShakaiFukushiHojinKeigenDetail"));
            }

            public txtShinseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            }

            public ShakaiFukushiHojinKeigenRiyoshaFutan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShakaiFukushiHojinKeigenRiyoshaFutan"));
            }

            public txtKetteiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKetteiDate"));
            }

            public txtKetteiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKetteiKubun"));
            }

            public txtTekiyoDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoDate"));
            }

            public txtYukokigenDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukokigenDate"));
            }

            public txtKeigenJiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKeigenJiyu"));
            }

            public txtKeigenRitsuBunshi(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKeigenRitsuBunshi"));
            }

            public lblIKeigenRitsuVinculum(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblIKeigenRitsuVinculum"));
            }

            public txtKeigenRitsuBunbo(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKeigenRitsuBunbo"));
            }

            public txtFushoninRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushoninRiyu"));
            }

            public txtKakuninNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtKakuninNo"));
            }

            public txtKyotakuServiceOnly(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyotakuServiceOnly"));
            }

            public txtKyojuhiShokujiOnly(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyojuhiShokujiOnly"));
            }

            public txtUnitPrivateRoomOnly(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtUnitPrivateRoomOnly"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

