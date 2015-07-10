/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoAtesakiJushoHenshu {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoAtesakiJushoHenshu";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoAtesakiJushoHenshu.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoAtesakiJushoHenshu.Controls.myType() + "_" + fieldName;
            }

            public KaigoAtesakiJushoHenshu(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public JushoHenshu1(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JushoHenshu1"));
            }

            public radKenmeiHyojiUmu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKenmeiHyojiUmu"));
            }

            public radGunmeiHyojiUmu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radGunmeiHyojiUmu"));
            }

            public radCitymeiHyojiUmu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radCitymeiHyojiUmu"));
            }

            public JushoHenshu2(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JushoHenshu2"));
            }

            public ddlJushoHenshu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlJushoHenshu"));
            }

            public radKatagakiHyojiUmu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKatagakiHyojiUmu"));
            }

            public SpaceJusho(): UZA.Space {
                return new UZA.Space(this.convFiledName("SpaceJusho"));
            }

            public lin1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

        }

     }

}

