/// <reference path='TaishoshaIchiran_Design.ts' />
module DBC
{
    export module TaishoshaIchiran
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
            
            public priorities(): Array {
                return [
                    "State"
                ];
            }
            
            public State() {
                return new Modes.State(this.controls);
            }
        }

        export module Modes {
        
          export class State {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                public ModifyMode(): void {
                    var gridSetting = this.controls.dgJukyushaIdoRenrakuhyoHenkoSearchResultList().gridSetting;
                    
                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    
                    this.controls.dgJukyushaIdoRenrakuhyoHenkoSearchResultList().gridSetting = gridSetting;
                    this.controls.dgJukyushaIdoRenrakuhyoHenkoSearchResultList()._control.afterPropertiesSet();
                }
                
                public SelectMode(): void {
                    var gridSetting = this.controls.dgJukyushaIdoRenrakuhyoHenkoSearchResultList().gridSetting;
                    
                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    
                    this.controls.dgJukyushaIdoRenrakuhyoHenkoSearchResultList().gridSetting = gridSetting;
                    this.controls.dgJukyushaIdoRenrakuhyoHenkoSearchResultList()._control.afterPropertiesSet();
                }
            }
        }
    }
}

module DBC
{
    export module TaishoshaIchiran
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

