/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KaigoUploadPanel {

        export class Events {

            public static onClick_BtnUpload(): string {
                return "onClick_BtnUpload";
            }

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

            public lblFileName(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFileName"));
            }

            public lblUploadFileName(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblUploadFileName"));
            }

            public btnUpload(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnUpload"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

