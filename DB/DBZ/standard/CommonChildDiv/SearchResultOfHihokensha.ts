/// <reference path="SearchResultOfHihokensha_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module SearchResultOfHihokensha {

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

    export module SearchResultOfHihokensha {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("onClick_btnToResearch", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("height_dgSearchResult", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getonClick_btnToResearch() {
                return this.controls.btnToResearch().onClick;
            }

            public setonClick_btnToResearch(value) {
                this.controls.btnToResearch().onClick = value;
            }

            public getheight_dgSearchResult() {
                return this.controls.dgSearchResult().height;
            }

            public setheight_dgSearchResult(value) {
                this.controls.dgSearchResult().height = value;
            }

        }
    }
}




