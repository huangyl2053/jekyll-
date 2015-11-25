/// <reference path='KaigoKanryoMessage_Design.ts' />
module DBZ
{
    export module KaigoKanryoMessage
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }
            
            public priorities(): Array<string> {
                return [
                    "SizeType",
                    "MessageType",
                    "ResultType"
                ];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
            
            public ResultType() {
                return new Modes.ResultType(this.controls);
            }

            public MessageType() {
                return new Modes.MessageType(this.controls);
            }

            public SizeType() {
                return new Modes.SizeType(this.controls);
            }
        }

        export module Modes {
            export class ResultType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Success(): void {
                     this.controls.ccdKanryoMessage().ResultType().Success();
                }

                public Error(): void {
                    this.controls.ccdKanryoMessage().ResultType().Error();
                }

            }
            
            export class MessageType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Nomal(): void {
                    this.controls.ccdKanryoMessage().MessageType().Nomal();
                }

                public Empty(): void {
                    this.controls.ccdKanryoMessage().MessageType().Empty();
                }

            }
            
            export class SizeType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Normal(): void {
                    this.controls.ccdKanryoMessage().SizeType().Normal();
                }

                public Small(): void {
                    this.controls.ccdKanryoMessage().SizeType().Small();
                }
            }
        }
    }
}

module DBZ
{
    export module KaigoKanryoMessage
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

