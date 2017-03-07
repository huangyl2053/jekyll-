/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="../../d.ts/DBZCommonChildDiv.d.ts" />

module DBE {

     export module TokkiJikoInput {

        export class Events {

            public static onChange_radTokkiJikoGroup(): string {
                return "onChange_radTokkiJikoGroup";
            }

            public static onChange_ddlTokkiJikoNo(): string {
                return "onChange_ddlTokkiJikoNo";
            }

            public static onClick_btnInput(): string {
                return "onClick_btnInput";
            }

            public static onChange_txtTokkiJiko(): string {
                return "onChange_txtTokkiJiko";
            }

            public static onClick_btnSave(): string {
                return "onClick_btnSave";
            }

            public static onClick_btnCancel(): string {
                return "onClick_btnCancel";
            }

            public static onClick_btnDelete(): string {
                return "onClick_btnDelete";
            }

            public static onClick_btnDeleteCancel(): string {
                return "onClick_btnDeleteCancel";
            }

            public static onClick_btnReturn(): string {
                return "onClick_btnReturn";
            }

            public static onClick_btnUpdateCancel(): string {
                return "onClick_btnUpdateCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TokkiJikoInput";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.TokkiJikoInput.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.TokkiJikoInput.Controls.myType() + "_" + fieldName;
            }

            public TokkiJikoInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ChosaTaishosha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ChosaTaishosha"));
            }

            //public ccdNinteiShinseishaKihon(): DBZ.NinteiShinseishaKihonInfo.ModeController {
            //    return new DBZ.NinteiShinseishaKihonInfo.ModeController(this.convFiledName("ccdNinteiShinseishaKihon"));
            //}

            //public ccdNinteiShinseiRenrakusakiKihon(): DBZ.NinteiShinseiRenrakusakiKihon.ModeController {
            //    return new DBZ.NinteiShinseiRenrakusakiKihon.ModeController(this.convFiledName("ccdNinteiShinseiRenrakusakiKihon"));
            //}

            public ChosaJisshisha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ChosaJisshisha"));
            }

            //public ccdChosaJisshishaJoho(): DBZ.ChosaJisshishaJoho.ModeController {
            //    return new DBZ.ChosaJisshishaJoho.ModeController(this.convFiledName("ccdChosaJisshishaJoho"));
            //}

            public TokkiJikoNyuryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TokkiJikoNyuryoku"));
            }

            public radTokkiJikoGroup(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTokkiJikoGroup"));
            }

            public ddlTokkiJikoNo(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTokkiJikoNo"));
            }

            public btnInput(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnInput"));
            }

            public txtTokkiJiko(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkiJiko"));
            }

            public btnSave(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSave"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

            public btnDelete(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnDelete"));
            }

            public btnDeleteCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnDeleteCancel"));
            }

            public dgTokkiJikoJoho(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTokkiJikoJoho"));
            }

            public btnReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnReturn"));
            }

            public btnUpdateCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnUpdateCancel"));
            }

        }

     }

}

