/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBC {

     export module TaishoshaIchiran {

        export class Events {

            public static onClick_btnSelect(): string {
                return "onClick_btnSelect";
            }

            public static onClick_btnModify(): string {
                return "onClick_btnModify";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TaishoshaIchiran";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.TaishoshaIchiran.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.TaishoshaIchiran.Controls.myType() + "_" + fieldName;
            }

            public TaishoshaIchiran(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgJukyushaIdoRenrakuhyoHenkoSearchResultList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJukyushaIdoRenrakuhyoHenkoSearchResultList"));
            }

        }

     }

}

