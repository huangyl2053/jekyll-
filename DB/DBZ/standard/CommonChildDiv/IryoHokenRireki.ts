  
       
/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="IryoHokenRireki_Design.ts" />

module DBZ
{
    export module IryoHokenRireki {

            export class ModeController {
                private controls: Controls;

                constructor(fieldName: string) {
                    this.controls = new Controls(fieldName);
                }

                public DisplayMode() {
                    return new Modes.DisplayMode(this.controls);
                }
                
                public WidthMode() {
                    return new Modes.WidthMode(this.controls);
                }

            }
            
            export module Modes {

                export class DisplayMode {
                    private controls: Controls;

                    constructor(controls: Controls) {
                        this.controls = controls;
                    }

                    public Shokai(): void {

                        this.controls.dgIryoHokenRireki().readOnly = true;

                        var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                        gridSetting.isShowDeleteButtonColumn = false;
                        gridSetting.isShowModifyButtonColumn = false;
                        
                        this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                        this.controls.dgIryoHokenRireki().width = 940;
                    }

                    public Toroku(): void {

                        this.controls.dgIryoHokenRireki().readOnly = false;

                        var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                        gridSetting.isShowDeleteButtonColumn = true;
                        gridSetting.isShowModifyButtonColumn = true;

                        this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                       this.controls.dgIryoHokenRireki().width = 980;

                    }
                }

                export class WidthMode {
                    private controls: Controls;

                    constructor(controls: Controls) {
                        this.controls = controls;
                    }

                    public Width1(): void {
                        this.controls.dgIryoHokenRireki().width = 800;
                    }

                    public Width2(): void {
                        this.controls.dgIryoHokenRireki().width = 700;

                    }
                }
            }
        }
}


  
