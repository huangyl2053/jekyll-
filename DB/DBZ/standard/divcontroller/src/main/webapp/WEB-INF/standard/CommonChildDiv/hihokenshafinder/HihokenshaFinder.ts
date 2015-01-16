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
                    "表示モード",
                    "保険者" 
                ]; 
            } 

            public 表示モード() {
                return new Modes.表示モード(this.controls);
            }

            public 保険者() {
                return new Modes.保険者(this.controls);
            }
        }

        export module Modes {

            export class 表示モード {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 資格系(): void {
                    this.controls.txtTuchishoNo().visible = false;
                    this.controls.txtTuchishoNo().displayNone = true;
                    this.controls.ddlFukaNendo().visible = false;
                    this.controls.ddlFukaNendo().displayNone = true;
                    this.controls.chkJukyushaDaicho().visible = true;
                    this.controls.chkJukyushaDaicho().displayNone = false;
                    this.controls.chkJushochiTokureisha().visible = true;
                    this.controls.chkJushochiTokureisha().displayNone = false;
                    this.controls.radMinashiNigo().visible = true;
                    this.controls.radMinashiNigo().displayNone = false;
                }

                public 賦課系(): void {
                    this.controls.txtTuchishoNo().visible = true;
                    this.controls.txtTuchishoNo().displayNone = false;
                    this.controls.ddlFukaNendo().visible = true;
                    this.controls.ddlFukaNendo().displayNone = false;
                    this.controls.chkJukyushaDaicho().visible = false;
                    this.controls.chkJukyushaDaicho().displayNone = true;
                    this.controls.chkJushochiTokureisha().visible = false;
                    this.controls.chkJushochiTokureisha().displayNone = true;
                    this.controls.radMinashiNigo().visible = false;
                    this.controls.radMinashiNigo().displayNone = true;
                }
            }

            export class 保険者 {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 表示する(): void {
                    this.controls.ddlHokensha().visible = true;
                    this.controls.ddlHokensha().displayNone = false;
                }

                public 表示しない(): void {
                    this.controls.ddlHokensha().visible = false;
                    this.controls.ddlHokensha().displayNone = true;
                }
            }
        }
    }
}
