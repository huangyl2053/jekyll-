/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShinsakaiJohoKojin {

        export class Events {

            public static btn_Modoru(): string {
                return "btn_Modoru";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShinsakaiJohoKojin";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShinsakaiJohoKojin.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShinsakaiJohoKojin.Controls.myType() + "_" + fieldName;
            }

            public ShinsakaiJohoKojin(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtShinsakaiNo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinsakaiNo"));
            }

            public txtGogitaiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGogitaiName"));
            }

            public txtShinsakaijoMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinsakaijoMeisho"));
            }

            public txtShinsakaijoChikuCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShinsakaijoChikuCode"));
            }

            public txtShinsakaijoChikuMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinsakaijoChikuMeisho"));
            }

            public txtShinsaKaishiDay(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtShinsaKaishiDay"));
            }

            public txtShinsaKaishiTime(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtShinsaKaishiTime"));
            }

            public txtShinsaShuryoTime(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtShinsaShuryoTime"));
            }

            public txtShinsaTime(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinsaTime"));
            }

            public ShussekiIinJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShussekiIinJoho"));
            }

            public lblShinsakaiIin(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShinsakaiIin"));
            }

            public lblHoketsuShinsakaiIin(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHoketsuShinsakaiIin"));
            }

            public dgShinsakaiIin(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShinsakaiIin"));
            }

            public dgHoketsuShinsakai(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgHoketsuShinsakai"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

        }

     }

}

