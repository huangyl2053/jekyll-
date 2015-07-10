/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module ChosaItakusakiSelector {

        export class Events {

            public static onSelect_dgChosaItakusakiList(): string {
                return "onSelect_dgChosaItakusakiList";
            }

            public static onSelectByDC_ChosaItakusaki(): string {
                return "onSelectByDC_ChosaItakusaki";
            }

            public static onSelectBySB_ChosaItakusaki(): string {
                return "onSelectBySB_ChosaItakusaki";
            }

            public static onSelectByDC_Chosain(): string {
                return "onSelectByDC_Chosain";
            }

            public static onSelectBySB_Chosain(): string {
                return "onSelectBySB_Chosain";
            }

            public static onClick_btnSelectAndClose(): string {
                return "onClick_btnSelectAndClose";
            }

            public static onClick_btnNonSelectReturn(): string {
                return "onClick_btnNonSelectReturn";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ChosaItakusakiSelector";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.ChosaItakusakiSelector.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ChosaItakusakiSelector.Controls.myType() + "_" + fieldName;
            }

            public ChosaItakusakiSelector(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ChosaItakusaki(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ChosaItakusaki"));
            }

            public ChosaItakusakiList(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ChosaItakusaki_ChosaItakusakiList"));
            }

            public btnToMentenanceChosaKikan(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnToMentenanceChosaKikan"));
            }

            public dgChosaItakusakiList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgChosaItakusakiList"));
            }

            public Chosain(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ChosaItakusaki_Chosain"));
            }

            public spaChosain(): UZA.Space {
                return new UZA.Space(this.convFiledName("spaChosain"));
            }

            public ChosainList(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ChosaItakusaki_Chosain_ChosainList"));
            }

            public dgChosainList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgChosainList"));
            }

            public SelectedContents(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SelectedContents"));
            }

            public txtChosaItakusakiCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtChosaItakusakiCode"));
            }

            public txtChosaItakusakiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosaItakusakiName"));
            }

            public txtChosainCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtChosainCode"));
            }

            public txtChosainName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtChosainName"));
            }

            public btnSelectAndClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSelectAndClose"));
            }

            public btnNonSelectReturn(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnNonSelectReturn"));
            }

        }

     }

}

