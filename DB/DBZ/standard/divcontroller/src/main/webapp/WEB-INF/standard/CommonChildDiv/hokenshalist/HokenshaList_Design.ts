/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module HokenshaList {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HokenshaList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.HokenshaList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.HokenshaList.Controls.myType() + "_" + fieldName;
            }

            public HokenshaList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlHokenshaList(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHokenshaList"));
            }

        }

     }

}

