/// <reference path="CompleteProcess_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module CompleteProcess {

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

    export module CompleteProcess {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("lblCompleteMessage_text", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("CompleteProcess_width", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getlblCompleteMessage_text() {
                return this.controls.lblCompleteMessage().text;
            }

            public setlblCompleteMessage_text(value) {
                this.controls.lblCompleteMessage().text = value;
            }

            public getCompleteProcess_width() {
                return this.controls.CompleteProcess().width;
            }

            public setCompleteProcess_width(value) {
                this.controls.CompleteProcess().width = value;
            }

        }
    }
}




