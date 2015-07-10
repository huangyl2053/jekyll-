/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module TokubetsuIryoIken {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TokubetsuIryoIken";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.TokubetsuIryoIken.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.TokubetsuIryoIken.Controls.myType() + "_" + fieldName;
            }

            public TokubetsuIryoIken(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public chkTokubetsuIryo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTokubetsuIryo"));
            }

            public chkTokubetsuTaiou(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTokubetsuTaiou"));
            }

            public chkShikkinTaio(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShikkinTaio"));
            }

            public btnBack(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBack"));
            }

            public btnKoshin(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKoshin"));
            }

        }

     }

}

