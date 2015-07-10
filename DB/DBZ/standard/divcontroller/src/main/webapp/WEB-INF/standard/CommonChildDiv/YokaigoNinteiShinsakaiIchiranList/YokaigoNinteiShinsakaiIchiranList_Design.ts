/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module YokaigoNinteiShinsakaiIchiranList {

        export class Events {

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

            public txtHyojiKikanFrom(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHyojiKikanFrom"));
            }

            public txtHyojiKikanTo(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtHyojiKikanTo"));
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

            public dgShinsakaiIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShinsakaiIchiran"));
            }

        }

     }

}

