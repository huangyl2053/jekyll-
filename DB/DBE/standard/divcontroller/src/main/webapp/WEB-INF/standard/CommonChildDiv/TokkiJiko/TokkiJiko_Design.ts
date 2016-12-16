/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module TokkiJiko {

        export class Events {

            public static onClick_ToriKesi(): string {
                return "onClick_ToriKesi";
            }

            public static onClick_KakuTeyi(): string {
                return "onClick_KakuTeyi";
            }

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
                return this._myName + "_" + DBE.TokkiJiko.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.TokkiJiko.Controls.myType() + "_" + fieldName;
            }

            public TokkiJiko(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public lblTokki(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokki"));
            }

            public txtTokki(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokki"));
            }

            public imgTokkiJiko(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgTokkiJiko"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

        }

     }

}

