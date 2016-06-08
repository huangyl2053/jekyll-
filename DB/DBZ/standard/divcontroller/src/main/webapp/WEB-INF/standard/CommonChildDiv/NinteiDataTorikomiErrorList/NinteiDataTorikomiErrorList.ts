/// <reference path='NinteiDataTorikomiErrorList_Design.ts' />
module DBZ
{
    export module NinteiDataTorikomiErrorList
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
            public TorikomiType() {
                return new Modes.TorikomiType(this.controls);
            }
        }

        export module Modes {
            export class TorikomiType {

                private controls: Controls;


                constructor(controls: Controls) {
                    this.controls = controls;
                }



                public ShinseiJohoMode(): void {
                    var gridSetting = this.controls.dgDataTorikomiErrorIchiran().gridSetting;
                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = true;
                    this.controls.dgDataTorikomiErrorIchiran().gridSetting = gridSetting;
                    this.controls.dgDataTorikomiErrorIchiran()._control.afterPropertiesSet();
                }

                public ChosaKekkaMode(): void {
                    var gridSetting = this.controls.dgDataTorikomiErrorIchiran().gridSetting;

                    gridSetting.columns[6].visible = false;

                    this.controls.dgDataTorikomiErrorIchiran().gridSetting = gridSetting;
                    this.controls.dgDataTorikomiErrorIchiran()._control.afterPropertiesSet();
                }
                
                public OrcaMode(): void {
                    var gridSetting = this.controls.dgDataTorikomiErrorIchiran().gridSetting;

                    gridSetting.columns[6].visible = false;

                    this.controls.dgDataTorikomiErrorIchiran().gridSetting = gridSetting;
                    this.controls.dgDataTorikomiErrorIchiran()._control.afterPropertiesSet();

                }

                public ShinsaKekkaMode(): void {
                    var gridSetting = this.controls.dgDataTorikomiErrorIchiran().gridSetting;

                    gridSetting.columns[6].visible = true;

                    this.controls.dgDataTorikomiErrorIchiran().gridSetting = gridSetting;
                    this.controls.dgDataTorikomiErrorIchiran()._control.afterPropertiesSet();
                }

                public NinteiKekkaMode(): void {
                    var gridSetting = this.controls.dgDataTorikomiErrorIchiran().gridSetting;

                    gridSetting.columns[6].visible = true;

                    this.controls.dgDataTorikomiErrorIchiran().gridSetting = gridSetting;
                    this.controls.dgDataTorikomiErrorIchiran()._control.afterPropertiesSet();

                }
            }
        }
    }
}

module DBZ
{
    export module NinteiDataTorikomiErrorList
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

