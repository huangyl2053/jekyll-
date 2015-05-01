/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module NinteiShinsakaiIinGuide {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NinteiShinsakaiIinGuide";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.NinteiShinsakaiIinGuide.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.NinteiShinsakaiIinGuide.Controls.myType() + "_" + fieldName;
            }

            public NinteiShinsakaiIinGuide(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public KensakuJoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KensakuJoken"));
            }

            public KensakuJokenInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KensakuJokenInput"));
            }

            public txtShinsakaiIinCodeFrom(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShinsakaiIinCodeFrom"));
            }

            public txtShinsakaiIinCodeTo(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtShinsakaiIinCodeTo"));
            }

            public txtShinsakaiIinName(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShinsakaiIinName"));
            }

            public ddlSeibetsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSeibetsu"));
            }

            public ddlShinsainShikakuCode(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShinsainShikakuCode"));
            }

            public btnKensakku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKensakku"));
            }

            public ShosaiJoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShosaiJoken"));
            }

            public lblShozoku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblShozoku"));
            }

            public ddlIryoKikan(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlIryoKikan"));
            }

            public ddlKaigoJigyosha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKaigoJigyosha"));
            }

            public ddlSonotaJigyosha(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSonotaJigyosha"));
            }

            public chkKiken(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKiken"));
            }

            public chkHaishi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkHaishi"));
            }

            public ShinsakaiIinIchiran(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShinsakaiIinIchiran"));
            }

            public dgShinsakaiIinIchiran(): UZA.DataGrid {
                return new UZA.DataGrid(this.convFiledName("dgShinsakaiIinIchiran"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnSaikensaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSaikensaku"));
            }

        }

     }

}

