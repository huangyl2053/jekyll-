/// <reference path='KihonChosaInput_Design.ts' />
module DBZ
{
    export module KihonChosaInput
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

                public Dai1gun(): void {

                    this.controls.DaiichigunShintaiKino().visible = true;
                      this.controls.SeikatsuKinou().visible = false;
                        this.controls.NinchiKinou().visible = false;
                          this.controls.KoudoShogai().visible = false;
                            this.controls.ShakaiSekatsu().visible = false;
                              this.controls.TokubetsuIryo().visible = false;
                                this.controls.Jiritsudo().visible = false;
                    

                }

                public Dai2gun(): void {

                    this.controls.DaiichigunShintaiKino().visible = false;
                      this.controls.SeikatsuKinou().visible = true;
                        this.controls.NinchiKinou().visible = false;
                          this.controls.KoudoShogai().visible = false;
                            this.controls.ShakaiSekatsu().visible = false;
                              this.controls.TokubetsuIryo().visible = false;
                                this.controls.Jiritsudo().visible = false;
                }
                  public Dai3gun(): void {

                    this.controls.DaiichigunShintaiKino().visible = false;
                      this.controls.SeikatsuKinou().visible = false;
                        this.controls.NinchiKinou().visible = true;
                          this.controls.KoudoShogai().visible = false;
                            this.controls.ShakaiSekatsu().visible = false;
                              this.controls.TokubetsuIryo().visible = false;
                                this.controls.Jiritsudo().visible = false;
                }
                  public Dai4gun(): void {

                    this.controls.DaiichigunShintaiKino().visible = false;
                      this.controls.SeikatsuKinou().visible = false;
                        this.controls.NinchiKinou().visible = false;
                          this.controls.KoudoShogai().visible = true;
                            this.controls.ShakaiSekatsu().visible = false;
                              this.controls.TokubetsuIryo().visible = false;
                                this.controls.Jiritsudo().visible = false;
                }
                  public Dai5gun(): void {

                    this.controls.DaiichigunShintaiKino().visible = false;
                      this.controls.SeikatsuKinou().visible = false;
                        this.controls.NinchiKinou().visible = false;
                          this.controls.KoudoShogai().visible = false;
                            this.controls.ShakaiSekatsu().visible = true;
                              this.controls.TokubetsuIryo().visible = false;
                                this.controls.Jiritsudo().visible = false;
                }
                  public Dai6gun(): void {

                    this.controls.DaiichigunShintaiKino().visible = false;
                      this.controls.SeikatsuKinou().visible = false;
                        this.controls.NinchiKinou().visible = false;
                          this.controls.KoudoShogai().visible = false;
                            this.controls.ShakaiSekatsu().visible = false;
                              this.controls.TokubetsuIryo().visible = true;
                                this.controls.Jiritsudo().visible = false;
                }
                  public Dai7gun(): void {

                    this.controls.DaiichigunShintaiKino().visible = false;
                      this.controls.SeikatsuKinou().visible = false;
                        this.controls.NinchiKinou().visible = false;
                          this.controls.KoudoShogai().visible = false;
                            this.controls.ShakaiSekatsu().visible = false;
                              this.controls.TokubetsuIryo().visible = false;
                                this.controls.Jiritsudo().visible = true;
                }
            }
        
        }
    }
}

module DBZ
{
    export module KihonChosaInput
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

