/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module OnseiFileOperator {

        export class Events {

            public static onClick_btnDelete(): string {
                return "onClick_btnDelete";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "OnseiFileOperator";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.OnseiFileOperator.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.OnseiFileOperator.Controls.myType() + "_" + fieldName;
            }

            public OnseiFileOperator(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtNo(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtNo"));
            }

            public txtInsDate(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtInsDate"));
            }

            public btnDownload(): UZA.ButtonDownLoad {
                return new UZA.ButtonDownLoad(this.convFiledName("btnDownload"));
            }

            public btnDelete(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnDelete"));
            }

            public OnseiFileDeleted(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("OnseiFileDeleted"));
            }

            public icoOnseiFileDeleted(): UZA.Icon {
                return new UZA.Icon(this.convFiledName("icoOnseiFileDeleted"));
            }

            public lblOnseiFileDeleted(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblOnseiFileDeleted"));
            }

        }

     }

}

