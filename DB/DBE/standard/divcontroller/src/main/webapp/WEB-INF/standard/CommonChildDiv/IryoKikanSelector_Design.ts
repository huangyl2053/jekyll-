/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBE {

     export module IryoKikanSelector {

        export class Events {

            public static onSelect_dgIryoKikanList(): string {
                return "onSelect_dgIryoKikanList";
            }

            public static onSelectByDC_IryoKikan(): string {
                return "onSelectByDC_IryoKikan";
            }

            public static onSelectBySB_IryoKikan(): string {
                return "onSelectBySB_IryoKikan";
            }

            public static onSelectByDC_Ishi(): string {
                return "onSelectByDC_Ishi";
            }

            public static onSelectBySB_Ishi(): string {
                return "onSelectBySB_Ishi";
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
                return "IryoKikanSelector";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.IryoKikanSelector.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.IryoKikanSelector.Controls.myType() + "_" + fieldName;
            }

            public IryoKikanSelector(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public IryoKikan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IryoKikan"));
            }

            public IryoKikanList(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IryoKikan_IryoKikanList"));
            }

            public btnToMentenanceIryoKikan(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnToMentenanceIryoKikan"));
            }

            public dgIryoKikanList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgIryoKikanList"));
            }

            public Ishi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IryoKikan_Ishi"));
            }

            public spaIshi(): UZA.Space {
                return new UZA.Space(this.convFiledName("spaIshi"));
            }

            public IshiList(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IryoKikan_Ishi_IshiList"));
            }

            public dgIshiList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgIshiList"));
            }

            public SelectedContents(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SelectedContents"));
            }

            public txtiryoKikanCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtiryoKikanCode"));
            }

            public txtiryoKikanName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtiryoKikanName"));
            }

            public txtishiCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtishiCode"));
            }

            public txtishiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtishiName"));
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

