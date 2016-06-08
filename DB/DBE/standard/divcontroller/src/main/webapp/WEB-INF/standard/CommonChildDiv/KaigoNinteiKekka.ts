/// <reference path="KaigoNinteiKekka_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBE
{
    export module KaigoNinteiKekka {

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



module DBE {

    export module KaigoNinteiKekka {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("selectDdlNijiHantei", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("selectDdlNinteiYukoTsukisu", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("selectDdlNinteiKubun", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getselectDdlNijiHantei() {
                return this.controls.ddlNijiHanteiKekka().onChange;
            }

            public setselectDdlNijiHantei(value) {
                this.controls.ddlNijiHanteiKekka().onChange = value;
            }

            public getselectDdlNinteiYukoTsukisu() {
                return this.controls.ddlNinteiYukoTsukisu().onChange;
            }

            public setselectDdlNinteiYukoTsukisu(value) {
                this.controls.ddlNinteiYukoTsukisu().onChange = value;
            }

            public getselectDdlNinteiKubun() {
                return this.controls.ddlNinteiKubun().onChange;
            }

            public setselectDdlNinteiKubun(value) {
                this.controls.ddlNinteiKubun().onChange = value;
            }

        }
    }
}




