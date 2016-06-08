/// <reference path='ShujiiIryokikanAndShujiiGuide_Design.ts' />
module DBZ {
    export module ShujiiIryokikanAndShujiiGuide {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
                this.controls.KensakuKekkaIchiran().isOpen = true;

            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }

            public TaishoMode() {
                return new Modes.TaishoMode(this.controls);
            }
        }

        export module Modes {
            export class TaishoMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public IryoKikanMode(): void {
                    this.controls.txtShuijiiCodeFrom().displayNone = true;
                    this.controls.txtShujiiCodeTo().displayNone = true;
                    this.controls.txtShujiiShimei().displayNone = true;
                    this.controls.txtShujiiKanaShimei().displayNone = true;
                    this.controls.radShujiiJokyo().displayNone = true;
                                        
                    var gridSetting = this.controls.dgKensakuKekkaIchiran().gridSetting;
                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = false;
                    this.controls.dgKensakuKekkaIchiran().gridSetting = gridSetting;
                    this.controls.dgKensakuKekkaIchiran()._control.afterPropertiesSet();
                }

                public ShujiiMode(): void {
                    this.controls.txtShuijiiCodeFrom().displayNone = false;
                    this.controls.txtShujiiCodeTo().displayNone = false;
                    this.controls.txtShujiiShimei().displayNone = false;
                    this.controls.txtShujiiKanaShimei().displayNone = false;
                    this.controls.radShujiiJokyo().displayNone = false;
                    
                    var gridSetting = this.controls.dgKensakuKekkaIchiran().gridSetting;
                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = true;
                    this.controls.dgKensakuKekkaIchiran().gridSetting = gridSetting;
                    this.controls.dgKensakuKekkaIchiran()._control.afterPropertiesSet();
                }
            }
        }
    }
}

module DBZ
{
    export module ShujiiIryokikanAndShujiiGuide
    {
        export class PublicProperties {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            }
        }
    }
}

