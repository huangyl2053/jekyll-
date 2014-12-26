/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module JushochiTokureiRirekiList {

        export class Events {

            public static onClick_btnAdd(): string {
                return "onClick_btnAdd";
            }

            public static onSelect_dgJutoku(): string {
                return "onSelect_dgJutoku";
            }

            public static onSelectByDblClick_dgJutoku(): string {
                return "onSelectByDblClick_dgJutoku";
            }

            public static onSelectByModifyButton_dgJutoku(): string {
                return "onSelectByModifyButton_dgJutoku";
            }

            public static onSelectByDeleteButton_dgJutoku(): string {
                return "onSelectByDeleteButton_dgJutoku";
            }

            public static onClick_btnJutokuKakutei(): string {
                return "onClick_btnJutokuKakutei";
            }

            public static onClick_btnJutokuTorikeshi(): string {
                return "onClick_btnJutokuTorikeshi";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JushochiTokureiRirekiList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType() + "_" + fieldName;
            }

            public JushochiTokureiRirekiList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public btnAdd(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnAdd"));
            }

            public dgJutoku(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgJutoku"));
            }

            public JutokuInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutokuInput"));
            }

            public JutokuTekiyoInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuTekiyoInput"));
            }

            public txtTekiyoDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoDate"));
            }

            public txtTekiyoTodokedeDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoTodokedeDate"));
            }

            public ddlTekiyoJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyoJiyu"));
            }

            public tekiyojiHokenshaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuTekiyoInput_tekiyojiHokenshaJoho"));
            }

            public ddlTekiyojiShozaiHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiShozaiHokensha"));
            }

            public ddlTekiyojiSochimotoHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiSochimotoHokensha"));
            }

            public ddlTekiyojiKyuHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiKyuHokensha"));
            }

            public ddlTekiyojiJuminJoho(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiJuminJoho"));
            }

            public JutokuKaijoInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuKaijoInput"));
            }

            public txtKaijoDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaijoDate"));
            }

            public txtKaijoTodokedeDate(): UZA.TextBoxFlexibleDate {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaijoTodokedeDate"));
            }

            public ddlKaijoJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaijoJiyu"));
            }

            public kaijojiHokenshaJoho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuKaijoInput_kaijojiHokenshaJoho"));
            }

            public ddlKaijojiShozaiHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiShozaiHokensha"));
            }

            public ddlKaijojiSochimotoHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiSochimotoHokensha"));
            }

            public ddlKaijojiKyuHokensha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiKyuHokensha"));
            }

            public ddlKaijojiJuminJono(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiJuminJono"));
            }

            public btnJutokuKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnJutokuKakutei"));
            }

            public btnJutokuTorikeshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnJutokuTorikeshi"));
            }

        }

     }

}

