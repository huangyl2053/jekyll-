/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SaikinShorisha {

        export class Events {

            public static onSaikishorishaClick(): string {
                return "onSaikishorishaClick";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SaikinShorisha";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SaikinShorisha.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SaikinShorisha.Controls.myType() + "_" + fieldName;
            }

            public SaikinShorisha(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlSaikinShorisha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSaikinShorisha"));
            }

            public btnConfirm(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnConfirm"));
            }

        }

     }

}

