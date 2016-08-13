/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBC {

     export module KogakuKyufuTaishoList {

        export class Events {

            public static onClick_btnTsuika(): string {
                return "onClick_btnTsuika";
            }

            public static onClick_modify(): string {
                return "onClick_modify";
            }

            public static onClick_delete(): string {
                return "onClick_delete";
            }

            public static onMulti_dgKyufuJissekiMeisaiList(): string {
                return "onMulti_dgKyufuJissekiMeisaiList";
            }

            public static onOkClose_btnJgyosha(): string {
                return "onOkClose_btnJgyosha";
            }

            public static onBeforeOpenDialog_btnJgyosha(): string {
                return "onBeforeOpenDialog_btnJgyosha";
            }

            public static onOkClose_btnServiceSyurui(): string {
                return "onOkClose_btnServiceSyurui";
            }

            public static onBeforeOpenDialog_btnServiceSyurui(): string {
                return "onBeforeOpenDialog_btnServiceSyurui";
            }

            public static onClick_btnTorikeshi(): string {
                return "onClick_btnTorikeshi";
            }

            public static onClick_btnkakutei(): string {
                return "onClick_btnkakutei";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KogakuKyufuTaishoList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.KogakuKyufuTaishoList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.KogakuKyufuTaishoList.Controls.myType() + "_" + fieldName;
            }

            public KogakuKyufuTaishoList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnTsuika(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTsuika"));
            }

            public dgTaishoshaIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTaishoshaIchiran"));
            }

            public MeisaiGokeiHenshuPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("MeisaiGokeiHenshuPanel"));
            }

            public rdbMisaiGkeiKbun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rdbMisaiGkeiKbun"));
            }

            public txtJgyoshaCode(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJgyoshaCode"));
            }

            public btnJgyosha(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnJgyosha"));
            }

            public txtJgyoshaName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJgyoshaName"));
            }

            public txtServiceSyurui(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceSyurui"));
            }

            public btnServiceSyurui(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnServiceSyurui"));
            }

            public txtServiceSyuruiName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtServiceSyuruiName"));
            }

            public txtHyoGkei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHyoGkei"));
            }

            public txtRiyoshafutanGokei(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshafutanGokei"));
            }

            public GokeiPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("GokeiPanel"));
            }

            public txtSanteiKijunGaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSanteiKijunGaku"));
            }

            public txtSiharaiZumiGaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSiharaiZumiGaku"));
            }

            public txtKogakuShikyuGaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuShikyuGaku"));
            }

            public txtSetaiSyuyakuBango(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSetaiSyuyakuBango"));
            }

            public rdbKogakuJidoSyokanTaisyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rdbKogakuJidoSyokanTaisyo"));
            }

            public lin1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            }

            public KogakuKyufuKonkyoPanel(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KogakuKyufuKonkyoPanel"));
            }

            public rdbTsukiOkure(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rdbTsukiOkure"));
            }

            public rabSetaiShotokuKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rabSetaiShotokuKubun"));
            }

            public rdbShotokuKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rdbShotokuKubun"));
            }

            public rdbGassan(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rdbGassan"));
            }

            public rdbRoreiFukushiNenkin(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rdbRoreiFukushiNenkin"));
            }

            public rdbRiyoshafutanDai2dankai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rdbRiyoshafutanDai2dankai"));
            }

            public rdbGekihenkanwaKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("rdbGekihenkanwaKubun"));
            }

            public btnTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            }

            public btnkakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnkakutei"));
            }

            public rowId(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("rowId"));
            }

        }

     }

}

