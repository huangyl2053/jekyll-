/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path='ShoKaishuKirokuKanri_Design.ts' />
module DBZ
{
    export module ShoKaishuKirokuKanri
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
                    "表示方法",
                    "グリッド表示モード",
                    "一覧パネル高さ"
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

            public グリッド表示モード() {
                return new Modes.グリッド表示モード(this.controls);
            }

            public 一覧パネル高さ() {
                return new Modes.一覧パネル高さ(this.controls);
            }

        }

        export module Modes {

            export class 表示方法 {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 照会(): void {
                    this.controls.ccdShoKaishuJokyoShosai().表示方法().照会();
                    this.controls.btnShoKaishuKakutei().disabled = true;
                    this.controls.btnShoKaishuTorikeshi().disabled = true;
                    this.controls.btnShoKaishuKakutei().displayNone = false;
                    this.controls.btnShoKaishuTorikeshi().displayNone = false;
                }

                public 入力(): void {
                    this.controls.ccdShoKaishuJokyoShosai().表示方法().入力();
                    this.controls.btnShoKaishuKakutei().disabled = false;
                    this.controls.btnShoKaishuTorikeshi().disabled = false;
                    this.controls.btnShoKaishuKakutei().displayNone = false;
                    this.controls.btnShoKaishuTorikeshi().displayNone = false;
                }

                public 非表示(): void {
                    this.controls.ccdShoKaishuJokyoShosai().表示方法().非表示();
                    this.controls.btnShoKaishuKakutei().displayNone = true;
                    this.controls.btnShoKaishuTorikeshi().displayNone = true;
                }
            }

            export class グリッド表示モード {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public shokai(): void {
                    this.controls.ccdShoKaishuJokyoList().グリッド表示モード().shokai();
                }

                public toroku(): void {
                    this.controls.ccdShoKaishuJokyoList().グリッド表示モード().toroku();
                }

                public select(): void {
                    this.controls.ccdShoKaishuJokyoList().グリッド表示モード().select();
                }
            }

            export class 一覧パネル高さ {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public サイズ200(): void {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ200();
                }

                public サイズ250(): void {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ250();
                }

                public サイズ300(): void {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ300();
                }

                public サイズ350(): void {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ350();
                }

                public サイズ400(): void {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ400();
                }

                public サイズ450(): void {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ450();
                }

                public サイズ500(): void {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ500();
                }

            }

        }
    }
}



module DBZ {

    export module ShoKaishuKirokuKanri {

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
                return this.controls.ccdShoKaishuJokyoShosai().PublicProperties().getShoKaishuJokyoShosai_panelDisplay;
            }

            public setShoKaishuJokyoShosai_panelDisplay(value) {
                this.controls.ccdShoKaishuJokyoShosai().PublicProperties().setShoKaishuJokyoShosai_panelDisplay = value;
            }

            public getShoKaishuJokyoShosai_canOpenAndClose() {
                return this.controls.ccdShoKaishuJokyoShosai().PublicProperties().getShoKaishuJokyoShosai_canOpenAndClose;
            }

            public setShoKaishuJokyoShosai_canOpenAndClose(value) {
                this.controls.ccdShoKaishuJokyoShosai().PublicProperties().setShoKaishuJokyoShosai_canOpenAndClose = value;
            }

        }
    }
}

