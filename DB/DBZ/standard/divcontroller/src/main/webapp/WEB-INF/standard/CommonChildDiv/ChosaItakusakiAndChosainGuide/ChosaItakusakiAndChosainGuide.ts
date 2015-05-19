/// <reference path='ChosaItakusakiAndChosainGuide_Design.ts' />
module DBZ
{
    export module ChosaItakusakiAndChosainGuide
    {
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

                public Itakusaki(): void {
                    this.controls.txtChosainCodeFrom().displayNone = true;
                    this.controls.txtChosainCodeTo().displayNone = true;
                    this.controls.txtChosainName().displayNone = true;
                    this.controls.txtChosainKanaShimei().displayNone = false;
                    this.controls.radChosainJokyo().displayNone = true;
                    
                    this.controls.txtChosaItakusakiCodeFrom().displayNone = false;
                    this.controls.txtChosaItakuaskiCodeTo().displayNone = false;
                    this.controls.txtChosaItakusakiName().displayNone = false;
                    this.controls.txtChosaItakusakiKanaMeisho().displayNone =false;
                    this.controls.txtChosainKanaShimei().displayNone = false;
                    this.controls.radItakusakiJokyo().displayNone = false;
                    
                    var gridSetting = this.controls.dgKensakuKekkaIchiran().gridSetting;
                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = false;
                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    this.controls.dgKensakuKekkaIchiran().gridSetting = gridSetting;
                    this.controls.dgKensakuKekkaIchiran()._control.afterPropertiesSet();
                }

                public Chosain(): void {
                    this.controls.txtChosainCodeFrom().displayNone = false;
                    this.controls.txtChosainCodeTo().displayNone = false;
                    this.controls.txtChosainName().displayNone = false;
                    this.controls.txtChosainKanaShimei().displayNone = false;
                    this.controls.radChosainJokyo().displayNone = false
                    
                    this.controls.txtChosaItakusakiCodeFrom().displayNone = true;
                    this.controls.txtChosaItakuaskiCodeTo().displayNone = true;
                    this.controls.txtChosaItakusakiName().displayNone = true;
                    this.controls.txtChosaItakusakiKanaMeisho().displayNone = true;
                    this.controls.radItakusakiJokyo().displayNone = true;
                    
                    var gridSetting = this.controls.dgKensakuKekkaIchiran().gridSetting;
                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    this.controls.dgKensakuKekkaIchiran().gridSetting = gridSetting;
                    this.controls.dgKensakuKekkaIchiran()._control.afterPropertiesSet();
                }
            }
        }
    }
}

module DBZ {
    export module ChosaItakusakiAndChosainGuide {
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