/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module TokubetsuIryoIken {

        export class Events {

            public static btnCancel(): string {
                return "btnCancel";
            }

            public static btnKakutei(): string {
                return "btnKakutei";
            }

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
                return this._myName + "_" + DBE.TokubetsuIryoIken.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.TokubetsuIryoIken.Controls.myType() + "_" + fieldName;
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

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

        }

     }

}

