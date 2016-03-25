/// <reference path='NinteiShinseiRenrakusakiJoho_Design.ts' />
module DBZ
{
    export module NinteiShinseiRenrakusakiJoho {
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

            public ShoriType() {
                return new Modes.ShoriType(this.controls);
            }           
        }

        export module Modes {

            export class ShoriType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public InputMode(): void {
                    this.controls.btnShinkiTsuika().disabled = false;
                    this.controls.btnFukushaTsuika().disabled = false;
                    this.controls.btnZenkaiFukusha().disabled = false;
                    this.controls.dgRenrakusakiIchiran().readOnly = false;
                    this.controls.btnKakutei().disabled = false;
                    this.controls.txtRenban().readOnly = false;
                    this.controls.ddlRenrakusakiKubun().readOnly = false;
                    this.controls.txtShimei().readOnly = false;
                    this.controls.txtKanaShimei().readOnly = false;
                    this.controls.txtYubinNo().readOnly = false;
                    this.controls.ddlTsuzukigara().readOnly = false;
                    this.controls.txtTelNo().readOnly = false;
                    this.controls.txtMobileNo().readOnly = false;
                    this.controls.txtJusho().readOnly = false;
                    this.controls.txtYusenJuni().readOnly = false;
                    this.controls.btnToroku().disabled = false;
                    this.controls.ddlShisho().readOnly = false;
                }

                public ShokaiMode(): void {
                    this.controls.btnShinkiTsuika().disabled = false;
                    this.controls.btnFukushaTsuika().disabled = false;
                    this.controls.btnZenkaiFukusha().disabled = false;
                    this.controls.dgRenrakusakiIchiran().readOnly = false;
                    this.controls.btnKakutei().disabled = false;
                    this.controls.txtRenban().readOnly = true;
                    this.controls.ddlRenrakusakiKubun().readOnly = true;
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtKanaShimei().readOnly = true;
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.ddlTsuzukigara().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;
                    this.controls.txtMobileNo().readOnly = true;
                    this.controls.txtJusho().readOnly = true;
                    this.controls.txtYusenJuni().readOnly = true;
                    this.controls.btnToroku().disabled = true;
                    this.controls.ddlShisho().readOnly = true;
                }

                public KoshinMode(): void {
                    this.controls.btnShinkiTsuika().disabled = false;
                    this.controls.btnFukushaTsuika().disabled = false;
                    this.controls.btnZenkaiFukusha().disabled = false;
                    this.controls.dgRenrakusakiIchiran().readOnly = false;
                    this.controls.btnKakutei().disabled = false;
                    this.controls.txtRenban().readOnly = true;
                    this.controls.ddlRenrakusakiKubun().readOnly = false;
                    this.controls.txtShimei().readOnly = false;
                    this.controls.txtKanaShimei().readOnly = false;
                    this.controls.txtYubinNo().readOnly = false;
                    this.controls.ddlTsuzukigara().readOnly = false;
                    this.controls.txtTelNo().readOnly = false;
                    this.controls.txtMobileNo().readOnly = false;
                    this.controls.txtJusho().readOnly = false;
                    this.controls.txtYusenJuni().readOnly = false;
                    this.controls.btnToroku().disabled = false;
                    this.controls.ddlShisho().readOnly = false;
                }

                public ReadOnlyMode(): void {
                    this.controls.btnShinkiTsuika().disabled = true;
                    this.controls.btnFukushaTsuika().disabled = true;
                    this.controls.btnZenkaiFukusha().disabled = true;
                    this.controls.dgRenrakusakiIchiran().readOnly = true;
                    this.controls.btnKakutei().disabled = true;
                    this.controls.txtRenban().readOnly = true;
                    this.controls.ddlRenrakusakiKubun().readOnly = true;
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtKanaShimei().readOnly = true;
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.ddlTsuzukigara().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;
                    this.controls.txtMobileNo().readOnly = true;
                    this.controls.txtJusho().readOnly = true;
                    this.controls.txtYusenJuni().readOnly = true;
                    this.controls.btnToroku().disabled = true;
                    this.controls.ddlShisho().readOnly = true;
                }
            }
        }
    }
}

module DBZ
{
    export module NinteiShinseiRenrakusakiJoho {
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