/// <reference path="SetaiShotokuIchiran_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module SetaiShotokuIchiran {

        export class ModeController{
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }
 
            public priorities(): Array<string> {
                return [];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
        }

    }
}



module DBZ {

    export module SetaiShotokuIchiran {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtKijunYmdVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKijunYmdReadOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKazeiNendoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKazeiNendoReadOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlKazeiNendoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlKazeiNendoDataSource", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnSaihyojiVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSaihyojiOnClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("chkIchiranAllOnClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnNarabeteHyojuVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnNarabeteHyojuOnClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgSetaishotokuGridSetting", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgSetaishotokuWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgSetaishotokuOnSelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgSetaishotokuDbClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgSetaishotokuBySelectButton", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlKazeiNendoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnNarabeteHyoJiDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSetaiCodeDisyplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSaihyojiDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("lblKijunYMDMsgVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("lblKijunYMDMsgDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSetaiIchiranKazeiNendoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public gettxtKijunYmdVisible() {
                return this.controls.txtSetaiIchiranKijunYMD().visible;
            }

            public settxtKijunYmdVisible(value) {
                this.controls.txtSetaiIchiranKijunYMD().visible = value;
            }

            public gettxtKijunYmdReadOnly() {
                return this.controls.txtSetaiIchiranKijunYMD().readOnly;
            }

            public settxtKijunYmdReadOnly(value) {
                this.controls.txtSetaiIchiranKijunYMD().readOnly = value;
            }

            public gettxtKazeiNendoVisible() {
                return this.controls.txtSetaiIchiranKazeiNendo().visible;
            }

            public settxtKazeiNendoVisible(value) {
                this.controls.txtSetaiIchiranKazeiNendo().visible = value;
            }

            public gettxtKazeiNendoReadOnly() {
                return this.controls.txtSetaiIchiranKazeiNendo().readOnly;
            }

            public settxtKazeiNendoReadOnly(value) {
                this.controls.txtSetaiIchiranKazeiNendo().readOnly = value;
            }

            public getddlKazeiNendoVisible() {
                return this.controls.ddlSetaiIchiranKazeiNendo().visible;
            }

            public setddlKazeiNendoVisible(value) {
                this.controls.ddlSetaiIchiranKazeiNendo().visible = value;
            }
            /*
            //TODO n8178 城間篤人 モード化の必要があるか不明。共有子Div作成者の判断で修正。不要なら削除。
            public getddlKazeiNendoDataSource() {
                return this.controls.ddlSetaiIchiranKazeiNendo().dataSource;
            }

            public setddlKazeiNendoDataSource(value) {
                this.controls.ddlSetaiIchiranKazeiNendo().dataSource = value;
            }
            */
            public getbtnSaihyojiVisible() {
                return this.controls.btnSaiHyoji().visible;
            }

            public setbtnSaihyojiVisible(value) {
                this.controls.btnSaiHyoji().visible = value;
            }

            public getbtnSaihyojiOnClick() {
                return this.controls.btnSaiHyoji().onClick;
            }

            public setbtnSaihyojiOnClick(value) {
                this.controls.btnSaiHyoji().onClick = value;
            }

            public getchkIchiranAllOnClick() {
                return this.controls.chkSetaiIchiranAll().onClick;
            }

            public setchkIchiranAllOnClick(value) {
                this.controls.chkSetaiIchiranAll().onClick = value;
            }

            public getbtnNarabeteHyojuVisible() {
                return this.controls.btnNarabeteHyoji().visible;
            }

            public setbtnNarabeteHyojuVisible(value) {
                this.controls.btnNarabeteHyoji().visible = value;
            }

            public getbtnNarabeteHyojuOnClick() {
                return this.controls.btnNarabeteHyoji().onClick;
            }

            public setbtnNarabeteHyojuOnClick(value) {
                this.controls.btnNarabeteHyoji().onClick = value;
            }
            /*
            //TODO n8178 城間篤人 モード化の必要があるか不明。共有子Div作成者の判断で修正。不要なら削除。
            public getdgSetaishotokuGridSetting() {
                return this.controls.dgSetaiShotoku().gridSetting;
            }

            public setdgSetaishotokuGridSetting(value) {
                this.controls.dgSetaiShotoku().gridSetting = value;
            }
            */
            public getdgSetaishotokuWidth() {
                return this.controls.dgSetaiShotoku().width;
            }

            public setdgSetaishotokuWidth(value) {
                this.controls.dgSetaiShotoku().width = value;
            }

            public getdgSetaishotokuOnSelect() {
                return this.controls.dgSetaiShotoku().onSelect;
            }

            public setdgSetaishotokuOnSelect(value) {
                this.controls.dgSetaiShotoku().onSelect = value;
            }

            public getdgSetaishotokuDbClick() {
                return this.controls.dgSetaiShotoku().onSelectByDblClick;
            }

            public setdgSetaishotokuDbClick(value) {
                this.controls.dgSetaiShotoku().onSelectByDblClick = value;
            }

            public getdgSetaishotokuBySelectButton() {
                return this.controls.dgSetaiShotoku().onSelectBySelectButton;
            }

            public setdgSetaishotokuBySelectButton(value) {
                this.controls.dgSetaiShotoku().onSelectBySelectButton = value;
            }

            public getddlKazeiNendoDisplayNone() {
                return this.controls.ddlSetaiIchiranKazeiNendo().displayNone;
            }

            public setddlKazeiNendoDisplayNone(value) {
                this.controls.ddlSetaiIchiranKazeiNendo().displayNone = value;
            }

            public getbtnNarabeteHyoJiDisplayNone() {
                return this.controls.btnNarabeteHyoji().displayNone;
            }

            public setbtnNarabeteHyoJiDisplayNone(value) {
                this.controls.btnNarabeteHyoji().displayNone = value;
            }

            public gettxtSetaiCodeDisyplayNone() {
                return this.controls.txtSetaiIchiranSetaiCode().displayNone;
            }

            public settxtSetaiCodeDisyplayNone(value) {
                this.controls.txtSetaiIchiranSetaiCode().displayNone = value;
            }

            public getbtnSaihyojiDisplayNone() {
                return this.controls.btnSaiHyoji().displayNone;
            }

            public setbtnSaihyojiDisplayNone(value) {
                this.controls.btnSaiHyoji().displayNone = value;
            }

            public getlblKijunYMDMsgVisible() {
                return this.controls.lblSetaiIchiranMsg().visible;
            }

            public setlblKijunYMDMsgVisible(value) {
                this.controls.lblSetaiIchiranMsg().visible = value;
            }

            public getlblKijunYMDMsgDisplayNone() {
                return this.controls.lblSetaiIchiranMsg().displayNone;
            }

            public setlblKijunYMDMsgDisplayNone(value) {
                this.controls.lblSetaiIchiranMsg().displayNone = value;
            }

            public gettxtSetaiIchiranKazeiNendoDisplayNone() {
                return this.controls.txtSetaiIchiranKazeiNendo().displayNone;
            }

            public settxtSetaiIchiranKazeiNendoDisplayNone(value) {
                this.controls.txtSetaiIchiranKazeiNendo().displayNone = value;
            }

        }
    }
}




