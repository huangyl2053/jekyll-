/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBC {

     export module YokaigoninteiJigyotaishoRirekiList {

        export class Events {

            public static onClick_BtnClose(): string {
                return "onClick_BtnClose";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "YokaigoninteiJigyotaishoRirekiList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.YokaigoninteiJigyotaishoRirekiList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.YokaigoninteiJigyotaishoRirekiList.Controls.myType() + "_" + fieldName;
            }

            public YokaigoninteiJigyotaishoRirekiList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public pnlYokaigoNintei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("pnlYokaigoNintei"));
            }

            public dgNinteiRirekiList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgNinteiRirekiList"));
            }

            public pnlJigyoTaishosha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("pnlJigyoTaishosha"));
            }

            public dgJigyoTaishoshaList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJigyoTaishoshaList"));
            }

            public pnlBottonArea(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("pnlBottonArea"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

