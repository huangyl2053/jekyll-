/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoUploadPanel {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KaigoUploadPanel";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KaigoUploadPanel.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KaigoUploadPanel.Controls.myType() + "_" + fieldName;
            }

            public KaigoUploadPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public uplUploadFile(): UZA.UploadPanel {
                return new UZA.UploadPanel(this.convFiledName("uplUploadFile"));
            }

            public btnUpload(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnUpload"));
            }

        }

     }

}

