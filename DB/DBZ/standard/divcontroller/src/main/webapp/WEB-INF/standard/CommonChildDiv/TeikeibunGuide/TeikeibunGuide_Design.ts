/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module TeikeibunGuide {

        export class Events {

            public static onSelectTeikeibun(): string {
                return "onSelectTeikeibun";
            }

            public static onClickModoru(): string {
                return "onClickModoru";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TeikeibunGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.TeikeibunGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.TeikeibunGuide.Controls.myType() + "_" + fieldName;
            }

            public TeikeibunGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlTeikeibunZokusei(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTeikeibunZokusei"));
            }

            public dgTeikeibunIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTeikeibunIchiran"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

        }

     }

}

