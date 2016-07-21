/// <reference path='SetaiShotokuIchiran_Design.ts' />
module DBZ
{
    export module SetaiShotokuIchiran {
        export class ModeController{
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public DisplayMode() {
                return new Modes.DisplayMode(this.controls);
            }

        }

        export module Modes {

            export class DisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public FukaShokai(): void {
                    this.controls.ddlSetaiIchiranKazeiNendo().displayNone = true;
                    this.controls.btnSaiHyoji().displayNone = true;
                    this.controls.dgShotokuRireki().displayNone = true;
                    this.controls.btnRirekiClose().displayNone = true;
                    this.controls.dgSetaiShotoku().displayNone = false;
                    this.controls.dgSetaiShotoku().gridSetting.isMultiSelectable = true;
                    this.controls.btnNarabeteHyoji().displayNone = false;
                    this.controls.btnNarabeteHyojiKogaku().displayNone = true;
                }

                public ShotokuShokai(): void {
                    this.controls.txtSetaiIchiranKazeiNendo().displayNone = true;
                    this.controls.ddlSetaiIchiranKazeiNendo().displayNone = false;
                    this.controls.btnSaiHyoji().displayNone = false;
                    this.controls.ddlSetaiIchiranKazeiNendo().disabled = false;
                    this.controls.btnSaiHyoji().disabled = false;
                    this.controls.txtSetaiIchiranSetaiCode().disabled = true;
                    this.controls.chkSetaiIchiranAll().displayNone = true;
                    this.controls.btnNarabeteHyoji().displayNone = true;
                    this.controls.dgSetaiShotoku().gridSetting.isMultiSelectable = false;
                    this.controls.dgShotokuRireki().displayNone = true;
                    this.controls.dgSetaiShotoku().displayNone = false;
                    this.controls.btnRirekiClose().displayNone = true;
                    this.controls.btnNarabeteHyojiKogaku().displayNone = true;
                }

                public ShotokuRirekiShokai(): void {
                    this.controls.txtSetaiIchiranKazeiNendo().displayNone = true;
                    this.controls.ddlSetaiIchiranKazeiNendo().displayNone = true;
                    this.controls.btnSaiHyoji().displayNone = true;
                    this.controls.txtSetaiIchiranSetaiCode().displayNone = true;
                    this.controls.chkSetaiIchiranAll().displayNone = true;
                    this.controls.btnNarabeteHyoji().displayNone = true;
                    this.controls.dgSetaiShotoku().displayNone = true;
                    this.controls.dgSetaiShotoku().gridSetting.isMultiSelectable = true;
                    this.controls.dgShotokuRireki().displayNone = false;
                    this.controls.dgShotokuRireki().disabled = false;
                    this.controls.btnRirekiClose().disabled = false;
                    this.controls.btnRirekiClose().displayNone = false;
                    this.controls.btnNarabeteHyojiKogaku().displayNone = true;
                }

                public KogakuKaigoServicehi(): void {
                    this.controls.txtSetaiIchiranKijunYMD().disabled = false;
                    this.controls.txtSetaiIchiranKazeiNendo().displayNone = true;
                    this.controls.dgShotokuRireki().displayNone = true;
                    this.controls.dgSetaiShotoku().displayNone = false;
                    this.controls.dgSetaiShotoku().gridSetting.isMultiSelectable = true;
                    this.controls.btnRirekiClose().displayNone = true;
                    this.controls.btnNarabeteHyoji().displayNone = true;
                    this.controls.btnNarabeteHyojiKogaku().displayNone = false;
                }
            }
        }
    }
}

module DBZ
{
    export module SetaiShotokuIchiran
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

