/// <reference path="KaigoFukaKihon_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ {
    export module KaigoFukaKihon {

        export class ModeController {
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

    export module KaigoFukaKihon {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("canOpenAndClose", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("backGroundColor", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnHihoRireki_visible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public gettitle() {
                return this.controls.KaigoFukaKihon().title;
            }

            public settitle(value) {
                this.controls.KaigoFukaKihon().title = value;
            }

            public getcanOpenAndClose() {
                return this.controls.KaigoFukaKihon().canOpenAndClose;
            }

            public setcanOpenAndClose(value) {
                this.controls.KaigoFukaKihon().canOpenAndClose = value;
            }
            
            public geteraseBorderTop() {
                return this.controls.KaigoFukaKihon().eraseBorder;
            }

            public seteraseBorderTop(value) {
                this.controls.KaigoFukaKihon().eraseBorder = value;
            }

            public getbackGroundColor() {
                return this.controls.KaigoFukaKihon().backgroundColor;
            }

            public setbackGroundColor(value) {
                this.controls.KaigoFukaKihon().backgroundColor = value;
            }

            public getbtnHihoRireki_visible() {
                return this.controls.btnHihoRireki().visible;
            }

            public setbtnHihoRireki_visible(value) {
                this.controls.btnHihoRireki().visible = value;
            }

        }
    }
}




