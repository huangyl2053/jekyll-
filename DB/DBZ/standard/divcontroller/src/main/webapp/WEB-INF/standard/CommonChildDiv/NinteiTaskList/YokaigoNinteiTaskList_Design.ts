/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module YokaigoNinteiTaskList {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "YokaigoNinteiTaskList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.YokaigoNinteiTaskList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.YokaigoNinteiTaskList.Controls.myType() + "_" + fieldName;
            }

            public YokaigoNinteiTaskList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public NarabekaeJoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NarabekaeJoken"));
            }

            public ddlFirstPriority(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlFirstPriority"));
            }

            public ddlSecondPriority(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSecondPriority"));
            }

            public ddlThirdPriority(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlThirdPriority"));
            }

            public btnNarabekae(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnNarabekae"));
            }

            public NinteiTaskIchiran(): UZA.PanelBatchParameter {
                return new UZA.PanelBatchParameter(this.convFiledName("NinteiTaskIchiran"));
            }

            public txtCompleteCount(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtCompleteCount"));
            }

            public txtTotalCount(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTotalCount"));
            }

            public txtNarabekae(): UZA.Button {
                return new UZA.Button(this.convFiledName("txtNarabekae"));
            }

            public dgNinteiTaskList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgNinteiTaskList"));
            }

            public btnCSVShutsuryoku(): UZA.ButtonBatchRegister {
                return new UZA.ButtonBatchRegister(this.convFiledName("btnCSVShutsuryoku"));
            }

            public btnIchiranhyoShutsuryoku(): UZA.ButtonBatchRegister {
                return new UZA.ButtonBatchRegister(this.convFiledName("btnIchiranhyoShutsuryoku"));
            }

        }

     }

}

