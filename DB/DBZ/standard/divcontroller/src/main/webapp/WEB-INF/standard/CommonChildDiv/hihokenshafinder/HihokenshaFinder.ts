/// <reference path='HihokenshaFinder_Design.ts' />
module DBZ {
    export module HihokenshaFinder {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);

                Uz.GyomuJSHelper.registOriginalEvent("onClick_btnKaigoSaikinShorishaHyoji", () => {
                    (<any>this.controls.btnHihokenshaFinderHyoji()._control).fireEvent("onClick_btnHihokenshaFinderHyoji");
                });
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public priorities(): Array { 
                return [
                    "HyojiMode",
                    "Hokensha" 
                ]; 
            } 

            public HyojiMode() {
                return new Modes.HyojiMode(this.controls);
            }

            public Hokensha() {
                return new Modes.Hokensha(this.controls);
            }
        }

        export module Modes {

            export class HyojiMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Shikakukei(): void {
                    this.controls.txtTuchishoNo().visible = false;
                    this.controls.txtTuchishoNo().displayNone = true;
                    this.controls.ddlFukaNendo().visible = false;
                    this.controls.ddlFukaNendo().displayNone = true;
                    this.controls.chkJukyushaDaicho().visible = true;
                    this.controls.chkJukyushaDaicho().displayNone = false;
                    this.controls.chkJushochiTokureisha().visible = true;
                    this.controls.chkJushochiTokureisha().displayNone = false;
                }

                public Fukakei(): void {
                    this.controls.txtTuchishoNo().visible = true;
                    this.controls.txtTuchishoNo().displayNone = false;
                    this.controls.ddlFukaNendo().visible = true;
                    this.controls.ddlFukaNendo().displayNone = false;
                    this.controls.chkJukyushaDaicho().visible = false;
                    this.controls.chkJukyushaDaicho().displayNone = true;
                    this.controls.chkJushochiTokureisha().visible = false;
                    this.controls.chkJushochiTokureisha().displayNone = true;
                }
            }

            export class Hokensha {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public HyojiSuru(): void {
                    this.controls.ddlHokensha().visible = true;
                    this.controls.ddlHokensha().displayNone = false;
                }

                public HyojiShinai(): void {
                    this.controls.ddlHokensha().visible = false;
                    this.controls.ddlHokensha().displayNone = true;
                }
            }
        }
    }
}
