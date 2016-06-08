/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module TokkijikoCom {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TokkijikoCom";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.TokkijikoCom.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.TokkijikoCom.Controls.myType() + "_" + fieldName;
            }

            public TokkijikoCom(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlChosaItem(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlChosaItem"));
            }

            public txtTokkijikoContent(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkijikoContent"));
            }

            public lblSpace(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSpace"));
            }

        }

     }

}

