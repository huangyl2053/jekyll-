/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="./../tokkiimages/TokkiImagesPerKomoku.ts" />
// <reference path="./../tokkiimages/TokkiImagesPerKomoku.ts" />

module DBE {

     export module TokkiImagesPerChosa {

        export class Events {

            public static onClick_btnDisplay(): string {
                return "onClick_btnDisplay";
            }

            public static onClick_btnReturn(): string {
                return "onClick_btnReturn";
            }

            public static onClick_btnSave(): string {
                return "onClick_btnSave";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TokkiImagesPerChosa";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.TokkiImagesPerChosa.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.TokkiImagesPerChosa.Controls.myType() + "_" + fieldName;
            }

            public TokkiImagesPerChosa(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public TokkiJikoSelecting(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TokkiJikoSelecting"));
            }

            public ddlTokkiJikoNos(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTokkiJikoNos"));
            }

            public btnToDisplay(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnToDisplay"));
            }

            //public ccdRembanEditor(): DBE.TokkiImagesPerKomoku.ModeController {
            //    return new DBE.TokkiImagesPerKomoku.ModeController(this.convFiledName("ccdRembanEditor"));
            //}

            public repTokkiJikos(): UZA.ControlRepeater {
                return new UZA.ControlRepeater(this.convFiledName("repTokkiJikos"));
            }

            //public ccdImagesPerKomoku(): DBE.TokkiImagesPerKomoku.ModeController {
            //    return new DBE.TokkiImagesPerKomoku.ModeController(this.convFiledName("ccdImagesPerKomoku"));
            //}

            public btnReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReturn"));
            }

            public btnSave(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSave"));
            }

        }

     }

}

