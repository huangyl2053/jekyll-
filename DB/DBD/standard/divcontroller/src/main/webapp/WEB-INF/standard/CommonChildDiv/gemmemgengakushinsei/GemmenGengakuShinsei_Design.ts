/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="../../d.ts/DBZCommonChildDiv.d.ts" />

module DBD {

     export module GemmenGengakuShinsei {

        export class Events {

            public static onclick_txtCopyHonnin(): string {
                return "onclick_txtCopyHonnin";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "GemmenGengakuShinsei";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.GemmenGengakuShinsei.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.GemmenGengakuShinsei.Controls.myType() + "_" + fieldName;
            }

            public GemmenGengakuShinsei(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlShinseiDaikoKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShinseiDaikoKubun"));
            }

            public Shinseisha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Shinseisha"));
            }

            public txtShinseishaShimeiKana(): UZA.TextBoxKana {
                return new UZA.TextBoxKana(this.convFiledName("txtShinseishaShimeiKana"));
            }

            public txtCopyHonnin(): UZA.Button {
                return new UZA.Button(this.convFiledName("txtCopyHonnin"));
            }

            public txtShinseishaShimei(): UZA.TextBoxAtenaMeisho {
                return new UZA.TextBoxAtenaMeisho(this.convFiledName("txtShinseishaShimei"));
            }

            public txtShinseishaTsuzukigara(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseishaTsuzukigara"));
            }

            public imgYubinNoLabel(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgYubinNoLabel"));
            }

            public txtShinseishaYubinNo(): UZA.TextBoxYubinNo {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtShinseishaYubinNo"));
            }

            public txtShinseishaTelNo(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtShinseishaTelNo"));
            }

            public txtShinseishaJusho(): UZA.TextBoxJusho {
                return new UZA.TextBoxJusho(this.convFiledName("txtShinseishaJusho"));
            }

            public ShinseiDaikoJigyosha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShinseiDaikoJigyosha"));
            }

            //public ccdShisetsuJoho(): DBZ.ShisetsuJohoCommonChildDiv.ModeController {
            //    return new DBZ.ShisetsuJohoCommonChildDiv.ModeController(this.convFiledName("ccdShisetsuJoho"));
            //}

            public ddlJigyoshaKubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlJigyoshaKubun"));
            }

        }

     }

}

