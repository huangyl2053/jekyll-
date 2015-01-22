/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module ImageMasking {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ImageMasking";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ImageMasking.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ImageMasking.Controls.myType() + "_" + fieldName;
            }

            public ImageMasking(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

        }

     }

}

