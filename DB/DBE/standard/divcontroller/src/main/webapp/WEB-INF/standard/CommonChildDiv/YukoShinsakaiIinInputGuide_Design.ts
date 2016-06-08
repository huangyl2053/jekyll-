/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module YukoShinsakaiIinInputGuide {

        export class Events {

            public static onSelectBySelectButton_dgYukoShinsakaiIin(): string {
                return "onSelectBySelectButton_dgYukoShinsakaiIin";
            }

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "YukoShinsakaiIinInputGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.YukoShinsakaiIinInputGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.YukoShinsakaiIinInputGuide.Controls.myType() + "_" + fieldName;
            }

            public YukoShinsakaiIinInputGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgYukoShinsakaiIin(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgYukoShinsakaiIin"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

