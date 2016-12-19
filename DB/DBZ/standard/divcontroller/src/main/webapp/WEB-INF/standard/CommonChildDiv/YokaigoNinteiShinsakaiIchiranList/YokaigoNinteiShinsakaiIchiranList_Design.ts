/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module YokaigoNinteiShinsakaiIchiranList {

        export class Events {

            public static onClick_BtnKensaku(): string {
                return "onClick_BtnKensaku";
            }

            public static onClick_btnClear(): string {
                return "onClick_btnClear";
            }

            public static onClick_btnSelect(): string {
                return "onClick_btnSelect";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "YokaigoNinteiShinsakaiIchiranList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.YokaigoNinteiShinsakaiIchiranList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.YokaigoNinteiShinsakaiIchiranList.Controls.myType() + "_" + fieldName;
            }

            public YokaigoNinteiShinsakaiIchiranList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public HyojiJoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HyojiJoken"));
            }

            public txtHyojiKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtHyojiKikan"));
            }

            public txtSaidaiHyojiKensu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSaidaiHyojiKensu"));
            }

            public radHyojiJokenWaritsukeMikanryo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHyojiJokenWaritsukeMikanryo"));
            }

            public radHyojiJokenWaritsukeKanryo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHyojiJokenWaritsukeKanryo"));
            }

            public radHyojiJokenShinsakaiMikanryo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHyojiJokenShinsakaiMikanryo"));
            }

            public radHyojiJokenShinsakaiKanryo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHyojiJokenShinsakaiKanryo"));
            }

            public radDammyShinsakai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radDammyShinsakai"));
            }

            public btnKensaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            }

            public btnClear(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClear"));
            }

            public dgShinsakaiIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShinsakaiIchiran"));
            }

        }

     }

}

