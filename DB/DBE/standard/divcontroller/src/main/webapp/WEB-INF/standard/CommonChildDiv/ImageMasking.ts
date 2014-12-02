/// <reference path='./ImageMasking_Design.ts' />
/// <reference path='../d.ts/UzViewControls.d.ts' />
/// <reference path='../d.ts/jquery.d.ts' />

/*
//TODO n8178 城間篤人 元々あったスクリプトだが、not exist on value of type 'ImageMasking'.とのエラーが保存時に発生するため一時的にコメントアウト。
module DBE {
    export module ImageMasking {
        export class ImageMasking extends ImageMasking_Design {
            public renderCompleted() {
                if (!Uz.GyomuJSHelper.isDesignMode()) {
                    var viewerPanel = this.getJQueryElement();
                    window["initMasking"](viewerPanel.attr("id") + "_ImageMasking_panel_body_area", "/db/dbe/Scripts/E0001.png");
                }
            }
        }
    }
}
*/

module DBE {
    export module ImageMasking {

        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }
            
            public priorities(): Array<string> {
                return [];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }
        }

    }
}


module DBE {

    export module ImageMasking {

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




