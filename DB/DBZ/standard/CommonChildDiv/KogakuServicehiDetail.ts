/// <reference path="KogakuServicehiDetail_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module KogakuServicehiDetail {

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
        }

    }
}



module DBZ {

    export module KogakuServicehiDetail {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("tplJudgementResult_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("tplKetteiJoho_visible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public gettitle() {
                return this.controls.KogakuServicehiDetail().title;
            }

            public settitle(value) {
                this.controls.KogakuServicehiDetail().title = value;
            }

            public geteraseBorder() {
                return this.controls.KogakuServicehiDetail().eraseBorder;
            }

            public seteraseBorder(value) {
                this.controls.KogakuServicehiDetail().eraseBorder = value;
            }

            public getpanelDisplay() {
                return this.controls.KogakuServicehiDetail().panelDisplay;
            }

            public setpanelDisplay(value) {
                this.controls.KogakuServicehiDetail().panelDisplay = value;
            }

            public gettplJudgementResult_title() {
                return this.controls.tplJudgementResult().title;
            }

            public settplJudgementResult_title(value) {
                this.controls.tplJudgementResult().title = value;
            }

            public gettplKetteiJoho_visible() {
                return this.controls.tplKetteiJoho().visible;
            }

            public settplKetteiJoho_visible(value) {
                this.controls.tplKetteiJoho().visible = value;
            }

        }
    }
}




