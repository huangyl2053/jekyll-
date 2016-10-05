/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBD {

     export module FutanGendogakuNintei {

        export class Events {

            public static onSelect_dgFutanGendogakuNinteiList(): string {
                return "onSelect_dgFutanGendogakuNinteiList";
            }

            public static CloseOK(): string {
                return "CloseOK";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "FutanGendogakuNintei";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBD.FutanGendogakuNintei.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBD.FutanGendogakuNintei.Controls.myType() + "_" + fieldName;
            }

            public FutanGendogakuNintei(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public dgFutanGendogakuNinteiList(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgFutanGendogakuNinteiList"));
            }

            public FutanGendogakuNinteiDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("FutanGendogakuNinteiDetail"));
            }

            public txtShinseiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            }

            public txtShinseiRiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinseiRiyu"));
            }

            public izokuNenkinJukyuShinkoku(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("izokuNenkinJukyuShinkoku"));
            }

            public shogaiNenkinJukyuShinkoku(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("shogaiNenkinJukyuShinkoku"));
            }

            public HiKazeiNenkinjoho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("HiKazeiNenkinjoho"));
            }

            public FutanGendogakuNinteiRiyoshaFutan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("FutanGendogakuNinteiRiyoshaFutan"));
            }

            public txtKetteiDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKetteiDate"));
            }

            public txtKetteiKubun(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKetteiKubun"));
            }

            public txtTekiyoDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoDate"));
            }

            public txtYukokigenDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukokigenDate"));
            }

            public txtKyushochisha(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyushochisha"));
            }

            public txtFutanDankai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtFutanDankai"));
            }

            public txtKyoshitsuType(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyoshitsuType"));
            }

            public txtKyokaiso(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyokaiso"));
            }

            public txtGekihenKanwa(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtGekihenKanwa"));
            }

            public FutanGendogaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("FutanGendogaku"));
            }

            public txtShokuhi(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtShokuhi"));
            }

            public txtUnitKoshitsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtUnitKoshitsu"));
            }

            public txtUnitJunKoshitsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtUnitJunKoshitsu"));
            }

            public txtTashoshitsu(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtTashoshitsu"));
            }

            public txtJuraigataKoshitsuTokuyo(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtJuraigataKoshitsuTokuyo"));
            }

            public txtJuraigataKoshitsuRoken(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtJuraigataKoshitsuRoken"));
            }

            public txtFushoninRiyu(): UZA.TextBoxMultiLine {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushoninRiyu"));
            }

            public haigushaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("haigushaJoho"));
            }

            public radHaigushaUmu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHaigushaUmu"));
            }

            public txtShikibetsuCode(): UZA.TextBoxShikibetsuCode {
                return new UZA.TextBoxShikibetsuCode(this.convFiledName("txtShikibetsuCode"));
            }

            public txtShimeiKana(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShimeiKana"));
            }

            public txtShimei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            }

            public txtBirthday(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtBirthday"));
            }

            public txtRenrakusaki(): UZA.TextBoxTelNo {
                return new UZA.TextBoxTelNo(this.convFiledName("txtRenrakusaki"));
            }

            public txtJusho1(): UZA.TextBoxJusho {
                return new UZA.TextBoxJusho(this.convFiledName("txtJusho1"));
            }

            public lblGenjusho1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblGenjusho1"));
            }

            public txtGenjusho(): UZA.TextBoxJusho {
                return new UZA.TextBoxJusho(this.convFiledName("txtGenjusho"));
            }

            public radKazeiKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKazeiKubun"));
            }

            public yochokinjoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("yochokinjoho"));
            }

            public chkYochokin(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkYochokin"));
            }

            public txtYochokin(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtYochokin"));
            }

            public txtYukaShoken(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtYukaShoken"));
            }

            public txtSonota(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtSonota"));
            }

            public btnClose(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnClose"));
            }

        }

     }

}

