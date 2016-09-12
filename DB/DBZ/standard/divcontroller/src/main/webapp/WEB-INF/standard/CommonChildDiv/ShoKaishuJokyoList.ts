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
                    "GridHyojiMode",
                    "IchiranPanelTakasa" ,
					"MeisaiHyojiMode"
					
                ];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }
            
            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }

            public GridHyojiMode() {
                return new Modes.GridHyojiMode(this.controls);
            }

            public IchiranPanelTakasa() {
                return new Modes.IchiranPanelTakasa(this.controls);
            }
			  public MeisaiHyojiMode() {
                return new Modes.MeisaiHyojiMode(this.controls);
            }
        }

        export module Modes {

            export class GridHyojiMode {
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
					this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
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

            export class IchiranPanelTakasa {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Size200(): void {
                    this.controls.dgShoKaishuJokyo().height = "200";
                }

                public Size250(): void {
                    this.controls.dgShoKaishuJokyo().height = "250";
                }

                public Size300(): void {
                    this.controls.dgShoKaishuJokyo().height = "300";
                }

                public Size350(): void {
                    this.controls.dgShoKaishuJokyo().height = "350";
                }

                public Size400(): void {
                    this.controls.dgShoKaishuJokyo().height = "400";
                }

                public Size450(): void {
                    this.controls.dgShoKaishuJokyo().height = "450";
                }

                public Size500(): void {
                    this.controls.dgShoKaishuJokyo().height = "500";
                }

            }
			       export class MeisaiHyojiMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Shokai(): void {
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
                }

                public Nyuryoku(): void {
                    this.controls.ShoKaishuJokyoShosai().readOnly = false;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
                }

                public Hihyoji(): void {
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = true;
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



