  
       
/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="IryoHokenRireki_Design.ts" />

module DBZ
{
    export module IryoHokenRireki {
        
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public priorities(): Array {
                return [
                    "DisplayMode",
                    "WidthMode",
                    "MeisaiMode"
                ];
            }

            public DisplayMode() {
                return new Modes.DisplayMode(this.controls);
            }
            
             public WidthMode() {
                    return new Modes.WidthMode(this.controls);
                }
            
            public MeisaiMode() {
                return new Modes.MeisaiMode(this.controls);
            }
        }
            
            export module Modes {

                export class DisplayMode {
                    private controls: Controls;

                    constructor(controls: Controls) {
                        this.controls = controls;
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

                export class MeisaiMode {
                    private controls: Controls;

                    constructor(controls: Controls) {
                        this.controls = controls;
                    }

                    public toroku(): void {
                        this.controls.IryoHokenInput().readOnly = false;
                        this.controls.IryoHokenInput().displayNone = false;

                        this.controls.txtIryoHokenKanyuDate().readOnly = false;
                        this.controls.txtIryoHokenKanyuDate().displayNone = false;
                        this.controls.txtIryoHokenDattaiDate().readOnly = false;
                        this.controls.txtIryoHokenDattaiDate().displayNone = false;
                        this.controls.ddlIryoHokenShubetsu().readOnly = false;
                        this.controls.ddlIryoHokenShubetsu().displayNone = false;
                        this.controls.txtIryoHokenHokenshaNo().readOnly = false;
                        this.controls.txtIryoHokenHokenshaNo().displayNone = false;
                        this.controls.txtIryoHokenHokenshaMeisho().readOnly = false;
                        this.controls.txtIryoHokenHokenshaMeisho().displayNone = false;
                        this.controls.txtIryoHokenKigoNo().readOnly = false;
                        this.controls.txtIryoHokenKigoNo().displayNone = false;

                        this.controls.btnIryoHokenKakutei().disabled = false;
                        this.controls.btnIryoHokenKakutei().displayNone = false;
                        this.controls.btnIryoHokenTorikeshi().disabled = false;
                        this.controls.btnIryoHokenTorikeshi().displayNone = false;
                    }

                    public sakujo(): void {
                        this.controls.IryoHokenInput().readOnly = false;
                        this.controls.IryoHokenInput().displayNone = false;
                        
                        this.controls.txtIryoHokenKanyuDate().readOnly = true;
                        this.controls.txtIryoHokenKanyuDate().displayNone = false;
                        this.controls.txtIryoHokenDattaiDate().readOnly = true;
                        this.controls.txtIryoHokenDattaiDate().displayNone = false;
                        this.controls.ddlIryoHokenShubetsu().readOnly = true;
                        this.controls.ddlIryoHokenShubetsu().displayNone = false;
                        this.controls.txtIryoHokenHokenshaNo().readOnly = true;
                        this.controls.txtIryoHokenHokenshaNo().displayNone = false;
                        this.controls.txtIryoHokenHokenshaMeisho().readOnly = true;
                        this.controls.txtIryoHokenHokenshaMeisho().displayNone = false;
                        this.controls.txtIryoHokenKigoNo().readOnly = true;
                        this.controls.txtIryoHokenKigoNo().displayNone = false;
                        
                        this.controls.btnIryoHokenKakutei().disabled = false;
                        this.controls.btnIryoHokenKakutei().displayNone = false;
                        this.controls.btnIryoHokenTorikeshi().disabled = false;
                        this.controls.btnIryoHokenTorikeshi().displayNone = false;
                    }

                    public setReadOnly(): void {
                        this.controls.IryoHokenInput().readOnly = true;
                        this.controls.IryoHokenInput().displayNone = false;
                        
                        this.controls.txtIryoHokenKanyuDate().displayNone = false;
                        this.controls.txtIryoHokenDattaiDate().displayNone = false;
                        this.controls.ddlIryoHokenShubetsu().displayNone = false;
                        this.controls.txtIryoHokenHokenshaNo().displayNone = false;
                        this.controls.txtIryoHokenHokenshaMeisho().displayNone = false;
                        this.controls.txtIryoHokenKigoNo().displayNone = false;
                        
                        this.controls.btnIryoHokenKakutei().displayNone = true;
                        this.controls.btnIryoHokenTorikeshi().displayNone = true;
                    }

                    public setDisplayNone(): void {
                        this.controls.IryoHokenInput().readOnly = true;
                        this.controls.IryoHokenInput().displayNone = true;
                    }
                }
            }
        }
}


  
