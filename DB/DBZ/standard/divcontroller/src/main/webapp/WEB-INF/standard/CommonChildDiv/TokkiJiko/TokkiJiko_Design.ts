/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module TokkiJiko {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TokkiJiko";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.TokkiJiko.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.TokkiJiko.Controls.myType() + "_" + fieldName;
            }

            public TokkiJiko(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public lblTokki(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokki"));
            }

            public imgTokkiJiko(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgTokkiJiko"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnKoshin(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKoshin"));
            }

            public btnMasking(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnMasking"));
            }

        }

     }

}

