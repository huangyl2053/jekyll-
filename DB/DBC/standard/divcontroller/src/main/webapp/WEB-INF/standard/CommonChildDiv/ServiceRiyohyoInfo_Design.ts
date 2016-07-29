/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="../d.ts/DBZCommonChildDiv.d.ts" />
// <reference path="./ServiceCodeInputCommonChildDiv/ServiceCodeInputCommonChildDiv.ts" />

module DBC {

     export module ServiceRiyohyoInfo {

        export class Events {

            public static onOkClosebtnShowShuruiGendogaku(): string {
                return "onOkClosebtnShowShuruiGendogaku";
            }

            public static onBeforeOpenDialogbtnShowShuruiGendogaku(): string {
                return "onBeforeOpenDialogbtnShowShuruiGendogaku";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ServiceRiyohyoInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBC.ServiceRiyohyoInfo.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBC.ServiceRiyohyoInfo.Controls.myType() + "_" + fieldName;
            }

            public ServiceRiyohyoInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtTodokedeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTodokedeYMD"));
            }

            public txtTekiyoKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtTekiyoKikan"));
            }

            public txtKubunShikyuGendogaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunShikyuGendogaku"));
            }

            public txtGendoKanriKikan(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtGendoKanriKikan"));
            }

            public txtRiyoYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtRiyoYM"));
            }

            public chkZanteiKubun(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkZanteiKubun"));
            }

            public ddlKoshinKbn(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKoshinKbn"));
            }

            public txtKoshinYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtKoshinYMD"));
            }

            public txtSofuYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSofuYM"));
            }

            public btnShowShuruiGendogaku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShowShuruiGendogaku"));
            }

            public btnZengetsuCopy(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnZengetsuCopy"));
            }

            public ServiceRiyohyoBeppyoRiyoNissu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoRiyoNissu"));
            }

            public txtZengetsuRiyoNissu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtZengetsuRiyoNissu"));
            }

            public txtTogetsuRiyoNissu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTogetsuRiyoNissu"));
            }

            public txtRuikeiRiyoNissu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRuikeiRiyoNissu"));
            }

            public ServiceRiyohyoBeppyoList(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoList"));
            }

            public btnBeppyoMeisaiNew(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBeppyoMeisaiNew"));
            }

            public btnBeppyoGokeiNew(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBeppyoGokeiNew"));
            }

            public dgServiceRiyohyoBeppyoList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgServiceRiyohyoBeppyoList"));
            }

            public ServiceRiyohyoBeppyoJigyoshaServiceInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoJigyoshaServiceInput"));
            }

            //public ccdJigyoshaInput(): DBZ.ShisetsuJohoCommonChildDiv.ModeController {
            //    return new DBZ.ShisetsuJohoCommonChildDiv.ModeController(this.convFiledName("ccdJigyoshaInput"));
            //}

            //public ccdServiceCodeInput(): DBC.ServiceCodeInputCommonChildDiv.ModeController {
            //    return new DBC.ServiceCodeInputCommonChildDiv.ModeController(this.convFiledName("ccdServiceCodeInput"));
            //}

            //public ccdServiceTypeInput(): DBZ.ServiceTypeInputCommonChildDiv.ModeController {
            //    return new DBZ.ServiceTypeInputCommonChildDiv.ModeController(this.convFiledName("ccdServiceTypeInput"));
            //}

            public ServiceRiyohyoBeppyoMeisai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoMeisai"));
            }

            public txtTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTani"));
            }

            public txtWaribikigoRitsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtWaribikigoRitsu"));
            }

            public txtWaribikigoTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtWaribikigoTani"));
            }

            public txtKaisu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKaisu"));
            }

            public lblKaisu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaisu"));
            }

            public txtServiceTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtServiceTani"));
            }

            public lblServiceTani(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblServiceTani"));
            }

            public txtRiyoushaFutangaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoushaFutangaku"));
            }

            public txtTeigakuRiyoushaFutangaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTeigakuRiyoushaFutangaku"));
            }

            public ServiceRiyohyoBeppyoMeisaiFooter(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoMeisaiFooter"));
            }

            public btnBeppyoMeisaiKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBeppyoMeisaiKakutei"));
            }

            public btnCalcMeisaiGokei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCalcMeisaiGokei"));
            }

            public btnCancelMeisaiInput(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancelMeisaiInput"));
            }

            public btnCalcMeisai(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCalcMeisai"));
            }

            public ServiceRiyohyoBeppyoGokei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoGokei"));
            }

            public txtShuruiGendoChokaTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShuruiGendoChokaTani"));
            }

            public txtShuruiGendonaiTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShuruiGendonaiTani"));
            }

            public txtTanisuTanka(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTanisuTanka"));
            }

            public txtKubunGendoChokaTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunGendoChokaTani"));
            }

            public txtKubunGendonaiTani(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunGendonaiTani"));
            }

            public txtKyufuritsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuritsu"));
            }

            public txtHiyoSogaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHiyoSogaku"));
            }

            public lblHiyoSogaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHiyoSogaku"));
            }

            public txtHokenKyufugaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenKyufugaku"));
            }

            public lblHokenKyufugaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHokenKyufugaku"));
            }

            public txtRiyoshaFutangakuHoken(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutangakuHoken"));
            }

            public lblRiyoshaFutangakuHoken(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblRiyoshaFutangakuHoken"));
            }

            public txtRiyoshaFutangakuZengaku(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutangakuZengaku"));
            }

            public lblRiyoshaFutangakuZengaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblRiyoshaFutangakuZengaku"));
            }

            public ServiceRiyohyoBeppyoGokeiFooter(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoGokeiFooter"));
            }

            public btnBeppyoGokeiKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBeppyoGokeiKakutei"));
            }

            public btnCalcGokei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCalcGokei"));
            }

            public btnCancelGokeiInput(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancelGokeiInput"));
            }

            public ServiceRiyohyoBeppyoFooter(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoFooter"));
            }

            public btnUpdate(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnUpdate"));
            }

            public btnBackRiyoNengetsuIchiran(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBackRiyoNengetsuIchiran"));
            }

        }

     }

}

