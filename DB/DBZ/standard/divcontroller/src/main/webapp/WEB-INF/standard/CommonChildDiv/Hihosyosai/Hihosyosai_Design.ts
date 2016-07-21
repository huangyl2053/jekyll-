/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="./../jushochitokureirirekilist/JushochiTokureiRirekiList.ts" />
// <reference path="./../shikakuhenkorireki/ShikakuHenkoRireki.ts" />
// <reference path="./../ShisetsuNyutaishoRirekiKanri.ts" />

module DBZ {

     export module Hihosyosai {

        export class Events {

            public static onClick_Change(): string {
                return "onClick_Change";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "Hihosyosai";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.Hihosyosai.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.Hihosyosai.Controls.myType() + "_" + fieldName;
            }

            public Hihosyosai(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public lblSyutokubi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSyutokubi"));
            }

            public lblSyutokutodokedebi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSyutokutodokedebi"));
            }

            public lblSyutokujiyu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSyutokujiyu"));
            }

            public lblHihokubun(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblHihokubun"));
            }

            public lblSyozaiHokensya(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSyozaiHokensya"));
            }

            public lblSotimotoHokensya(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSotimotoHokensya"));
            }

            public lblKyuHokensya(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKyuHokensya"));
            }

            public lblSyoniNichiji(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSyoniNichiji"));
            }

            public txtSyutokuYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSyutokuYMD"));
            }

            public txtSyutokutodokedeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSyutokutodokedeYMD"));
            }

            public ddlSyutokuJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSyutokuJiyu"));
            }

            public ddlHihokubun(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlHihokubun"));
            }

            public ddlSyozaiHokensya(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSyozaiHokensya"));
            }

            public ddlSotimotoHokensya(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSotimotoHokensya"));
            }

            public ddlKyuHokensya(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKyuHokensya"));
            }

            public txtSyoninichiji1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSyoninichiji1"));
            }

            public lblSosichibi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSosichibi"));
            }

            public lblSosichiTodokedebi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSosichiTodokedebi"));
            }

            public lblSosichiJiyu(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSosichiJiyu"));
            }

            public lblSyoninichibi2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblSyoninichibi2"));
            }

            public txtSosichiYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSosichiYMD"));
            }

            public txtSosichiTodokedeYMD(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtSosichiTodokedeYMD"));
            }

            public ddlSosichiJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSosichiJiyu"));
            }

            public txtSyoninichiji2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSyoninichiji2"));
            }

            public tabContainerDetail(): UZA.TabContainer {
                return new UZA.TabContainer(this.convFiledName("tabContainerDetail"));
            }

            public tabPnlJyusyoti(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tabPnlJyusyoti"));
            }

            //public ccdJyusyotiTokure(): DBZ.JushochiTokureiRirekiList.ModeController {
            //    return new DBZ.JushochiTokureiRirekiList.ModeController(this.convFiledName("ccdJyusyotiTokure"));
            //}

            public tabPnlShikaku(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tabPnlShikaku"));
            }

            //public ccdShikakuKanrenIdo(): DBZ.ShikakuHenkoRireki.ModeController {
            //    return new DBZ.ShikakuHenkoRireki.ModeController(this.convFiledName("ccdShikakuKanrenIdo"));
            //}

            public tabPnlShisetu(): UZA.TabPanel {
                return new UZA.TabPanel(this.convFiledName("tabPnlShisetu"));
            }

            //public ccdShisetuNyutaisyo(): DBZ.ShisetsuNyutaishoRirekiKanri.ModeController {
            //    return new DBZ.ShisetsuNyutaishoRirekiKanri.ModeController(this.convFiledName("ccdShisetuNyutaisyo"));
            //}

        }

     }

}

