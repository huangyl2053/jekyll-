/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module YokaigoNinteiTaskList {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "YokaigoNinteiTaskList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.YokaigoNinteiTaskList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.YokaigoNinteiTaskList.Controls.myType() + "_" + fieldName;
            }

            public YokaigoNinteiTaskList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtCompleteCount(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtCompleteCount"));
            }

            public txtTotalCount(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTotalCount"));
            }

            public dgNinteiTaskList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgNinteiTaskList"));
            }

        }

     }

}

