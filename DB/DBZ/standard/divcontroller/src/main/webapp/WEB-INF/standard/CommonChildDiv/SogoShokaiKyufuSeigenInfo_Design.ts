/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SogoShokaiKyufuSeigenInfo {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SogoShokaiKyufuSeigenInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SogoShokaiKyufuSeigenInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SogoShokaiKyufuSeigenInfo.Controls.myType() + "_" + fieldName;
            }

            public SogoShokaiKyufuSeigenInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtSeigenTorokuJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSeigenTorokuJokyo"));
            }

            public txtSeigenShuryoJokyo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSeigenShuryoJokyo"));
            }

            public SogoShokaiKyufuSeigenHenko(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiKyufuSeigenHenko"));
            }

            public txtSeigenHenkoYokokuTorokuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoYokokuTorokuYMD"));
            }

            public txtSeigenHenkoKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoKetteiYMD"));
            }

            public txtSeigenHenkoSashitomeSyuryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoSashitomeSyuryoYMD"));
            }

            public txtSeigenHenkoTekiyoShuryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoTekiyoShuryoYMD"));
            }

            public txtSeigenTainoKojoKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenTainoKojoKetteiYMD"));
            }

            public txtSeigenChoshuShometsuKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenChoshuShometsuKikan"));
            }

            public txtSeigenNofuzumiKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenNofuzumiKikan"));
            }

            public SogoShokaiKyufuSeigenGengaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SogoShokaiKyufuSeigenGengaku"));
            }

            public txtSeigenGengakuKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenGengakuKikan"));
            }

            public txtSeigenGengakuKetteiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenGengakuKetteiYMD"));
            }

            public txtSeigenGengakuTekiyoKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenGengakuTekiyoKikan"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

