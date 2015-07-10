/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module KanryoDialog {

        export class Events {

            public static CloseOK(): string {
                return "CloseOK";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KanryoDialog";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.KanryoDialog.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.KanryoDialog.Controls.myType() + "_" + fieldName;
            }

            public KanryoDialog(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public SuccessInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SuccessInfo"));
            }

            public imgSuccess(): UZA.StaticImage {
                return new UZA.StaticImage(this.convFiledName("imgSuccess"));
            }

            public WrapMessageMain(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SuccessInfo_WrapMessageMain"));
            }

            public lblMessageMain(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblMessageMain"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

