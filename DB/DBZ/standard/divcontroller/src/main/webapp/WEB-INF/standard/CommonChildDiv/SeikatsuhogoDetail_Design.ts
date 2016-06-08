/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SeikatsuhogoDetail {

        export class Events {

            public static onbtn_AddRow(): string {
                return "onbtn_AddRow";
            }

            public static onbtn_Select(): string {
                return "onbtn_Select";
            }

            public static onbtn_Modify(): string {
                return "onbtn_Modify";
            }

            public static onbtn_Delete(): string {
                return "onbtn_Delete";
            }

            public static onbtn_OK(): string {
                return "onbtn_OK";
            }

            public static onbtn_Cancel(): string {
                return "onbtn_Cancel";
            }

            public static onbtn_DetailAirOK(): string {
                return "onbtn_DetailAirOK";
            }

            public static onbtn_DetailAirCancel(): string {
                return "onbtn_DetailAirCancel";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SeikatsuhogoDetail";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.SeikatsuhogoDetail.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SeikatsuhogoDetail.Controls.myType() + "_" + fieldName;
            }

            public SeikatsuhogoDetail(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public SeikatsuhogoDetailSub(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SeikatsuhogoDetailSub"));
            }

            public JukyuKikan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JukyuKikan"));
            }

            public txtJukyushaNo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtJukyushaNo"));
            }

            public txtJukyuKaishiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtJukyuKaishiYMD"));
            }

            public txtJukyuHaishiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtJukyuHaishiYMD"));
            }

            public HokenryoDairinofu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HokenryoDairinofu"));
            }

            public radDairinofuKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radDairinofuKubun"));
            }

            public txtDainoNofuYM(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtDainoNofuYM"));
            }

            public KyugoShisetsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KyugoShisetsu"));
            }

            public radNyutaishoKubun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNyutaishoKubun"));
            }

            public txtNyutaishoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNyutaishoYMD"));
            }

            public FujoShurui(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("FujoShurui"));
            }

            public chkFujoShurui(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkFujoShurui"));
            }

            public TeishiKikan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TeishiKikan"));
            }

            public btnTeishiRirekiAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTeishiRirekiAdd"));
            }

            public dgTeishiRireki(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgTeishiRireki"));
            }

            public TeishiKikanInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TeishiKikanInput"));
            }

            public txtTeishiKaishiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTeishiKaishiYMD"));
            }

            public txtTeishiShuryoYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtTeishiShuryoYMD"));
            }

            public TeishiInputSeigyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TeishiInputSeigyo"));
            }

            public btnTeishiInputKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTeishiInputKakutei"));
            }

            public btnTeishiInputTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTeishiInputTorikeshi"));
            }

            public SeikatsuHojoInputSeigyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SeikatsuHojoInputSeigyo"));
            }

            public btnMeisaiKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnMeisaiKakutei"));
            }

            public btnMeisaiTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnMeisaiTorikeshi"));
            }

        }

     }

}

