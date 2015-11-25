/// <reference path='ShiharaiHohoJyoho_Design.ts' />
module DBC
{
    export module ShiharaiHohoJyoho
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
            
            public priorities(): Array < string > {
                return [
                    "DisplayMode",
                    "PageMode"
                ];
            }
            
            public DisplayMode() {
                return new Modes.DisplayMode(this.controls);
            }
            
            public PageMode() {
                return new Modes.PageMode(this.controls);
            }
        }

        export module Modes {
            export class DisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public shokai(): void {
                    this.controls.radMadoguti().disabled = true;
                    this.controls.txtShiharaiBasho().disabled = true;
                    this.controls.txtStartYMD().disabled = true;
                    this.controls.txtStartHHMM().disabled = true;
                    this.controls.txtEndYMD().disabled = true;
                    this.controls.txtEndHHMM().disabled = true;
                    this.controls.radKoza().disabled = true;
                    this.controls.radJyryoinin().disabled = true;
                }

                public toroku(): void {
                    this.controls.radMadoguti().disabled = false;
                    this.controls.txtShiharaiBasho().disabled = false;
                    this.controls.txtStartYMD().disabled = false;
                    this.controls.txtStartHHMM().disabled = false;
                    this.controls.txtEndYMD().disabled = false;
                    this.controls.txtEndHHMM().disabled = false;
                    this.controls.radKoza().disabled = false;
                    this.controls.radJyryoinin().disabled = false;
                }
            }
            export class PageMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Shokan(): void {
                    this.controls.linKoza().displayNone = false;
                    this.controls.radJyryoinin().displayNone = false;
                    this.controls.txtKeiyakuNo().displayNone = false;
                    this.controls.btnSelect().displayNone = false;
                    this.controls.txtKeiyakuCode().displayNone = false;
                    this.controls.txtKeiyakuName().displayNone = false;
                    this.controls.txtKinyuKikanCode1().displayNone = false;
                    this.controls.txtKinyuKikanShitenCode1().displayNone = false;
                    this.controls.txtYokinShubetsu1().displayNone = false;
                    this.controls.txtKozaNo1().displayNone = false;
                    this.controls.txtKinyuKikanName1().displayNone = false;
                    this.controls.txtMeigininKana1().displayNone = false;
                    this.controls.txtMeigininKanji1().displayNone = false;
                }
                
                public JutakuKaishu(): void {
                    this.controls.linKoza().displayNone = false;
                    this.controls.radJyryoinin().displayNone = false;
                    this.controls.txtKeiyakuNo().displayNone = false;
                    this.controls.btnSelect().displayNone = false;
                    this.controls.txtKeiyakuCode().displayNone = false;
                    this.controls.txtKeiyakuName().displayNone = false;
                    this.controls.txtKinyuKikanCode1().displayNone = false;
                    this.controls.txtKinyuKikanShitenCode1().displayNone = false;
                    this.controls.txtYokinShubetsu1().displayNone = false;
                    this.controls.txtKozaNo1().displayNone = false;
                    this.controls.txtKinyuKikanName1().displayNone = false;
                    this.controls.txtMeigininKana1().displayNone = false;
                    this.controls.txtMeigininKanji1().displayNone = false;
                }
                
                public Fukushiyogu(): void {
                    this.controls.linKoza().displayNone = false;
                    this.controls.radJyryoinin().displayNone = false;
                    this.controls.txtKeiyakuNo().displayNone = false;
                    this.controls.btnSelect().displayNone = false;
                    this.controls.txtKeiyakuCode().displayNone = false;
                    this.controls.txtKeiyakuName().displayNone = false;
                    this.controls.txtKinyuKikanCode1().displayNone = false;
                    this.controls.txtKinyuKikanShitenCode1().displayNone = false;
                    this.controls.txtYokinShubetsu1().displayNone = false;
                    this.controls.txtKozaNo1().displayNone = false;
                    this.controls.txtKinyuKikanName1().displayNone = false;
                    this.controls.txtMeigininKana1().displayNone = false;
                    this.controls.txtMeigininKanji1().displayNone = false;
                }
                
                public KogakuService(): void {
                    this.controls.linKoza().displayNone = false;
                    this.controls.radJyryoinin().displayNone = false;
                    this.controls.txtKeiyakuNo().displayNone = false;
                    this.controls.btnSelect().displayNone = false;
                    this.controls.txtKeiyakuCode().displayNone = false;
                    this.controls.txtKeiyakuName().displayNone = false;
                    this.controls.txtKinyuKikanCode1().displayNone = false;
                    this.controls.txtKinyuKikanShitenCode1().displayNone = false;
                    this.controls.txtYokinShubetsu1().displayNone = false;
                    this.controls.txtKozaNo1().displayNone = false;
                    this.controls.txtKinyuKikanName1().displayNone = false;
                    this.controls.txtMeigininKana1().displayNone = false;
                    this.controls.txtMeigininKanji1().displayNone = false;
                }

                public KogakuGassan(): void {
                    this.controls.linKoza().displayNone = true;
                    this.controls.radJyryoinin().displayNone = true;
                    this.controls.txtKeiyakuNo().displayNone = true;
                    this.controls.btnSelect().displayNone = true;
                    this.controls.txtKeiyakuCode().displayNone = true;
                    this.controls.txtKeiyakuName().displayNone = true;
                    this.controls.txtKinyuKikanCode1().displayNone = true;
                    this.controls.txtKinyuKikanShitenCode1().displayNone = true;
                    this.controls.txtYokinShubetsu1().displayNone = true;
                    this.controls.txtKozaNo1().displayNone = true;
                    this.controls.txtKinyuKikanName1().displayNone = true;
                    this.controls.txtMeigininKana1().displayNone = true;
                    this.controls.txtMeigininKanji1().displayNone = true;
                }
            }
        }
    }
}

module DBC
{
    export module ShiharaiHohoJyoho
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

