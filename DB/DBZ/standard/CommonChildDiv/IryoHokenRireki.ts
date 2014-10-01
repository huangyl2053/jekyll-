  
       
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
                        this.controls.btnAddIryoHoken().displayNone = true;


                        var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                        gridSetting.isShowDeleteButtonColumn = false;
                        gridSetting.isShowModifyButtonColumn = false;
                        gridSetting.columns[0].visible = false;
                        

                        this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                        this.controls.dgIryoHokenRireki().width = 940;

                        this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                    }

                    public Toroku(): void {

                        this.controls.dgIryoHokenRireki().readOnly = false;
                        this.controls.btnAddIryoHoken().displayNone = false;

                        var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                        gridSetting.isShowDeleteButtonColumn = true;
                        gridSetting.isShowModifyButtonColumn = true;
                        gridSetting.columns[0].visible = false;
 

                        this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                        this.controls.dgIryoHokenRireki().width = 980;

                        this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();

                    }

                    
                    public ShikakuIdo(): void {

                        this.controls.dgIryoHokenRireki().readOnly = false;
                        this.controls.btnAddIryoHoken().displayNone = false;

                        var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                        gridSetting.isShowDeleteButtonColumn = true;
                        gridSetting.isShowModifyButtonColumn = true;
                        gridSetting.columns[0].visible = true;
                        
                        
                        this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                        this.controls.dgIryoHokenRireki().width = 980;

                        this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();

                    }

                }

                export class WidthMode {
                    private controls: Controls;

                    constructor(controls: Controls) {
                        this.controls = controls;
                    }

                    public Width1(): void {
                        this.controls.dgIryoHokenRireki().width = 800;
                        this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                    }

                    public Width2(): void {
                        this.controls.dgIryoHokenRireki().width = 700;
                        this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();

                    }
                }
            }
        }
}


  
