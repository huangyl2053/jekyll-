/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module ChosaKekkaTokkiImages {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ChosaKekkaTokkiImages";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ChosaKekkaTokkiImages.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ChosaKekkaTokkiImages.Controls.myType() + "_" + fieldName;
            }

            public ChosaKekkaTokkiImages(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlTokkiJikoNos(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTokkiJikoNos"));
            }

            public btnToDisplay(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnToDisplay"));
            }

        }

     }

}

