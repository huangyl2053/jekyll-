/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path='ShoKaishuJokyoShosai_Design.ts' />
module DBZ
{
    export module ShoKaishuJokyoShosai
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public priorities(): Array {
                return [
                    "表示方法"
                ];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }


            public 表示方法() {
                return new Modes.表示方法(this.controls);
            }
        }

        export module Modes {

            export class 表示方法 {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 照会(): void {
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
                }

                public 入力(): void {
                    this.controls.ShoKaishuJokyoShosai().readOnly = false;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
                }

                public 非表示(): void {
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = true;
                }
            }

        }
    }
}

module DBZ {

    export module ShoKaishuJokyoShosai {

        export class PublicProperties {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ShoKaishuJokyoShosai_panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShoKaishuJokyoShosai_canOpenAndClose", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getShoKaishuJokyoShosai_panelDisplay() {
                return this.controls.ShoKaishuJokyoShosai().panelDisplay;
            }

            public setShoKaishuJokyoShosai_panelDisplay(value) {
                this.controls.ShoKaishuJokyoShosai().panelDisplay = value;
            }

            public getShoKaishuJokyoShosai_canOpenAndClose() {
                return this.controls.ShoKaishuJokyoShosai().canOpenAndClose;
            }

            public setShoKaishuJokyoShosai_canOpenAndClose(value) {
                this.controls.ShoKaishuJokyoShosai().canOpenAndClose = value;
            }

        }
    }
}
