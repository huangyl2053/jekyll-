/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SearchResultOfHihokensha {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SearchResultOfHihokensha";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SearchResultOfHihokensha.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SearchResultOfHihokensha.Controls.myType() + "_" + fieldName;
            }

            public SearchResultOfHihokensha(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgSearchResult(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgSearchResult"));
            }

            public ButtonsForSearchResultOfHihokensha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ButtonsForSearchResultOfHihokensha"));
            }

            public btnToResearch(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnToResearch"));
            }

        }

     }

}

