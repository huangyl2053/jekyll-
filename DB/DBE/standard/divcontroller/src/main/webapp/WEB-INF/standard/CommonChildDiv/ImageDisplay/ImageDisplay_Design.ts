/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="../../d.ts/DBZCommonChildDiv.d.ts" />

module DBE {

     export module ImageDisplay {

        export class Events {

            public static onClick_btnBefore(): string {
                return "onClick_btnBefore";
            }

            public static onClick_btnBack(): string {
                return "onClick_btnBack";
            }

            public static onClick_btnAfterImg(): string {
                return "onClick_btnAfterImg";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ImageDisplay";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ImageDisplay.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ImageDisplay.Controls.myType() + "_" + fieldName;
            }

            public ImageDisplay(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            //public ccdChosaTokkiShiryoShokai(): DBZ.ChosaTokkiShiryoShokai.ModeController {
            //    return new DBZ.ChosaTokkiShiryoShokai.ModeController(this.convFiledName("ccdChosaTokkiShiryoShokai"));
            //}

            public lblGenbon(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGenbon"));
            }

            public imgGenbon(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgGenbon"));
            }

            public lblMask(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblMask"));
            }

            public imgMask(): UZA.DynamicImage {
                return new UZA.DynamicImage(this.convFiledName("imgMask"));
            }

            public btnBefore(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBefore"));
            }

            public btnBack(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBack"));
            }

            public btnAfterImg(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAfterImg"));
            }

            public lblNoImage(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblNoImage"));
            }

        }

     }

}

