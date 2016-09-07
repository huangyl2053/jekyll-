/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
/// <reference path="./ShisetsuJohoCommonChildDiv.ts" />

module DBZ {

     export module ShisetsuNyutaishoRirekiKanri {

        export class Events {

            public static onClick_btnAddShisetsuNyutaisho(): string {
                return "onClick_btnAddShisetsuNyutaisho";
            }

            public static onSelectBySelectButton_dgShisetsuNyutaishoRireki(): string {
                return "onSelectBySelectButton_dgShisetsuNyutaishoRireki";
            }

            public static onSelectByModifyButton_dgShisetsuNyutaishoRireki(): string {
                return "onSelectByModifyButton_dgShisetsuNyutaishoRireki";
            }

            public static onSelectByDeleteButton_dgShisetsuNyutaishoRireki(): string {
                return "onSelectByDeleteButton_dgShisetsuNyutaishoRireki";
            }

            public static onBlur_nyuryokuHokensyaCode(): string {
                return "onBlur_nyuryokuHokensyaCode";
            }

            public static onClick_BtnHokenshaInputGuide(): string {
                return "onClick_BtnHokenshaInputGuide";
            }

            public static onClick_btnShisetsuNyutaishoKakutei(): string {
                return "onClick_btnShisetsuNyutaishoKakutei";
            }

            public static onClick_btnShisetsuNyutaishoTorikeshi(): string {
                return "onClick_btnShisetsuNyutaishoTorikeshi";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShisetsuNyutaishoRirekiKanri";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShisetsuNyutaishoRirekiKanri.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShisetsuNyutaishoRirekiKanri.Controls.myType() + "_" + fieldName;
            }

            public ShisetsuNyutaishoRirekiKanri(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAddShisetsuNyutaisho(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAddShisetsuNyutaisho"));
            }

            public dgShisetsuNyutaishoRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShisetsuNyutaishoRireki"));
            }

            public ShisetsuNyutaishoInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShisetsuNyutaishoInput"));
            }

            public txtNyushoDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNyushoDate"));
            }

            public txtTaishoDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTaishoDate"));
            }

            public ccdShisetsuJoho(): DBZ.ShisetsuJohoCommonChildDiv.ModeController {
                return new DBZ.ShisetsuJohoCommonChildDiv.ModeController(this.convFiledName("ccdShisetsuJoho"));
            }

            public TenshutsusakiJohoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TenshutsusakiJohoPanel"));
            }

            public txtHokensha(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokensha"));
            }

            public btnHokenshaKensaku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHokenshaKensaku"));
            }

            public txtHokensyaMeisho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHokensyaMeisho"));
            }

            public btnShisetsuNyutaishoKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShisetsuNyutaishoKakutei"));
            }

            public btnShisetsuNyutaishoTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShisetsuNyutaishoTorikeshi"));
            }

        }

     }

}

