/// <reference path="HihokenshaFinder_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module HihokenshaFinder {

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

    export module HihokenshaFinder {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("onClick_BtnToSearch", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("displayNone_txtTsuchishoNo", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("displayNone_ddlFukaNendo", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("displayNone_SearchCriteriaDetail", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("canOpenAndClose_HihokenshaFinder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("displayNone_saikinShorisha", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("displayNone_ddlHokensha", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("displayNone_chkMinashiNigo", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getonClick_BtnToSearch() {
                return this.controls.btnToSearch().onClick;
            }

            public setonClick_BtnToSearch(value) {
                this.controls.btnToSearch().onClick = value;
            }

            public getdisplayNone_txtTsuchishoNo() {
                return this.controls.txtTuchishoNo().displayNone;
            }

            public setdisplayNone_txtTsuchishoNo(value) {
                this.controls.txtTuchishoNo().displayNone = value;
            }

            public getdisplayNone_ddlFukaNendo() {
                return this.controls.ddlFukaNendo().displayNone;
            }

            public setdisplayNone_ddlFukaNendo(value) {
                this.controls.ddlFukaNendo().displayNone = value;
            }

            public getdisplayNone_SearchCriteriaDetail() {
                return this.controls.SearchCriteriaDetail().displayNone;
            }

            public setdisplayNone_SearchCriteriaDetail(value) {
                this.controls.SearchCriteriaDetail().displayNone = value;
            }

            public getcanOpenAndClose_HihokenshaFinder() {
                return this.controls.HihokenshaFinder().canOpenAndClose;
            }

            public setcanOpenAndClose_HihokenshaFinder(value) {
                this.controls.HihokenshaFinder().canOpenAndClose = value;
            }

            //public getdisplayNone_saikinShorisha() {
            //    return this.controls.saikinShorisha().Properties().displayNone;
            //}

            //public setdisplayNone_saikinShorisha(value) {
            //    this.controls.saikinShorisha().Properties().displayNone = value;
            //}

            public getdisplayNone_ddlHokensha() {
                return this.controls.ddlHokensha().displayNone;
            }

            public setdisplayNone_ddlHokensha(value) {
                this.controls.ddlHokensha().displayNone = value;
            }

            public getdisplayNone_chkMinashiNigo() {
                return this.controls.chkMinashiNigo().displayNone;
            }

            public setdisplayNone_chkMinashiNigo(value) {
                this.controls.chkMinashiNigo().displayNone = value;
            }

        }
    }
}




