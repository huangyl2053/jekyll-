/// <reference path='ShoKaishuJokyoList_Design.ts' />
module DBZ
{
    export module ShoKaishuJokyoList {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public priorities(): Array {
                return [
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

            public グリッド表示モード() {
                return new Modes.グリッド表示モード(this.controls);
            }

            public 一覧パネル高さ() {
                return new Modes.一覧パネル高さ(this.controls);
            }
        }

        export module Modes {

            export class グリッド表示モード {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public shokai(): void {
                    var gridSetting = this.controls.dgShoKaishuJokyo().gridSetting;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgShoKaishuJokyo().gridSetting = gridSetting;

                    this.controls.dgShoKaishuJokyo()._control.afterPropertiesSet();
                }

                public toroku(): void {
                    var gridSetting = this.controls.dgShoKaishuJokyo().gridSetting;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.columns[0].visible = true;

                    this.controls.dgShoKaishuJokyo().gridSetting = gridSetting;

                    this.controls.dgShoKaishuJokyo()._control.afterPropertiesSet();
                }

                public select(): void {
                    var gridSetting = this.controls.dgShoKaishuJokyo().gridSetting;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgShoKaishuJokyo().gridSetting = gridSetting;

                    this.controls.dgShoKaishuJokyo()._control.afterPropertiesSet();
                }
            }

            export class 一覧パネル高さ {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public サイズ200(): void {
                    this.controls.dgShoKaishuJokyo().height = "200";
                }

                public サイズ250(): void {
                    this.controls.dgShoKaishuJokyo().height = "250";
                }

                public サイズ300(): void {
                    this.controls.dgShoKaishuJokyo().height = "300";
                }

                public サイズ350(): void {
                    this.controls.dgShoKaishuJokyo().height = "350";
                }

                public サイズ400(): void {
                    this.controls.dgShoKaishuJokyo().height = "400";
                }

                public サイズ450(): void {
                    this.controls.dgShoKaishuJokyo().height = "450";
                }

                public サイズ500(): void {
                    this.controls.dgShoKaishuJokyo().height = "500";
                }

            }
        }
    }
}


module DBZ {

    export module ShoKaishuJokyoList {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            }

        }
    }
}



