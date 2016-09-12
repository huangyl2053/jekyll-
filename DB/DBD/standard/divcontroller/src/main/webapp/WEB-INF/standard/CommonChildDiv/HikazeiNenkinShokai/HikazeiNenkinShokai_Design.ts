/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module HikazeiNenkinShokai {

        export class Events {

            public static onClick_btnClose(): string {
                return "onClick_btnClose";
            }

            public static onClick_btnSaiHyoji(): string {
                return "onClick_btnSaiHyoji";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HikazeiNenkinShokai";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.HikazeiNenkinShokai.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.HikazeiNenkinShokai.Controls.myType() + "_" + fieldName;
            }

            public HikazeiNenkinShokai(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtHihoNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtHihoNo"));
            }

            public ddlNendo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlNendo"));
            }

            public radRireki(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radRireki"));
            }

            public btnSaiHyoji(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSaiHyoji"));
            }

            public linLine1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linLine1"));
            }

            public lblHojinHikazeiNenkinJoho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHojinHikazeiNenkinJoho"));
            }

            public txtShotokuKananGakugo(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShotokuKananGakugo"));
            }

            public dgHikazeiNenkinShokai(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgHikazeiNenkinShokai"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

