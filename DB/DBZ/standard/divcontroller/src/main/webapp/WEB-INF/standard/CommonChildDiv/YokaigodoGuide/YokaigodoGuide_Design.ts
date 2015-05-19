/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module YokaigodoGuide {

        export class Events {

            public static onSelect_Yokaigodo(): string {
                return "onSelect_Yokaigodo";
            }

            public static onClick_btnModoru(): string {
                return "onClick_btnModoru";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "YokaigodoGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.YokaigodoGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.YokaigodoGuide.Controls.myType() + "_" + fieldName;
            }

            public YokaigodoGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgYokaigodoGuide(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgYokaigodoGuide"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

        }

     }

}

