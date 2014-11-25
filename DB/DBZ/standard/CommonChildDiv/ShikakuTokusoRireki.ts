/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="ShikakuTokusoRireki_Design.ts" />

module DBZ
{
    export module ShikakuTokusoRireki {

            export class ModeController {
                private controls: Controls;
                
                constructor(fieldName: string) {
                    this.controls = new Controls(fieldName);
                }

                public priorities(): Array {
                return [
                    "DisplayType",
                    "BtnDisplayMode",
                    "HokenshaJohoDisplayMode",
                    "DataGridWidth",
                    "DataGridHeight"
                    ];
                }

                public DisplayType() {
                    return new Modes.DisplayType(this.controls);
                }

                public BtnDisplayMode() {
                    return new Modes.BtnDisplayMode(this.controls);
                }

                public HokenshaJohoDisplayMode() {
                    return new Modes.HokenshaJohoDisplayMode(this.controls);
                }

                public DataGridWidth() {
                    return new Modes.DataGridWidth(this.controls);
                }

                public DataGridHeight() {
                    return new Modes.DataGridHeight(this.controls);
                }
            
            }
            
            export module Modes {

                export class DisplayType {
                    private controls: Controls;

                    constructor(controls: Controls) {
                        this.controls = controls;
                    }

                    public shokai(): void {
                        this.controls.dgShikakuShutokuRireki().readOnly = false;
                        
                        var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;
                        
                        gridSetting.columns[0].visible = false;
                        gridSetting.isShowModifyButtonColumn = false;
                        gridSetting.isShowDeleteButtonColumn = false;

                        this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                    }

                    public toroku(): void {
                        this.controls.dgShikakuShutokuRireki().readOnly = false;

                        var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;
                        
                        gridSetting.columns[0].visible = true;
                        gridSetting.isShowModifyButtonColumn = false;
                        gridSetting.isShowDeleteButtonColumn = false;

                        this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                    }

                    public teiseitoroku(): void {
                        this.controls.dgShikakuShutokuRireki().readOnly = false;

                        var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                        gridSetting.columns[0].visible = true;
                        gridSetting.isShowModifyButtonColumn = true;
                        gridSetting.isShowDeleteButtonColumn = true;

                        this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                    }

                }

                export class BtnDisplayMode {
                    private controls: Controls;

                    constructor(controls: Controls) {
                        this.controls = controls;
                    }

                    public SetDisplay(): void {
                        this.controls.btnAdd().displayNone = false;

                    }

                    public SetDisplayNone(): void {
                        this.controls.btnAdd().displayNone = true;
                    }
                }

                export class HokenshaJohoDisplayMode {
                    private controls: Controls;

                    constructor(controls: Controls) {
                        this.controls = controls;
                    }

                    public TanitsuGappeiNashi(): void {
                        var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;
                        
                        gridSetting.columns[14].visible = false;
                        gridSetting.columns[15].visible = false;
                        gridSetting.columns[16].visible = false;

                        this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }

                    public TanitsuGappeiAri(): void {
                        var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                        gridSetting.columns[14].visible = false;
                        gridSetting.columns[15].visible = false;
                        gridSetting.columns[16].visible = true;

                        this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }

                    public KoikiGappeiNashi(): void {
                        var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                        gridSetting.columns[14].visible = true;
                        gridSetting.columns[15].visible = true;
                        gridSetting.columns[16].visible = false;

                        this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }

                    public KoikiGappeiAri(): void {
                        var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                        gridSetting.columns[14].visible = true;
                        gridSetting.columns[15].visible = true;
                        gridSetting.columns[16].visible = true;

                        this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }
                
                }

                export class DataGridWidth {
                    private controls: Controls;

                    constructor(controls: Controls) {
                        this.controls = controls;
                    }

                    public Size1(): void {
                        this.controls.dgShikakuShutokuRireki().width = 1090;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }

                    public Size2(): void {
                        this.controls.dgShikakuShutokuRireki().width = 1050;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }

                    public Size3(): void {
                        this.controls.dgShikakuShutokuRireki().width = 1020;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }

                    public Size4(): void {
                        this.controls.dgShikakuShutokuRireki().width = 970;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }

                    public Size5(): void {
                        this.controls.dgShikakuShutokuRireki().width = 920;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }

                    public Size6(): void {
                        this.controls.dgShikakuShutokuRireki().width = 870;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }
                }

                export class DataGridHeight {
                    private controls: Controls;

                    constructor(controls: Controls) {
                        this.controls = controls;
                    }

                    public Size1(): void {
                        this.controls.dgShikakuShutokuRireki().height = 450;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }

                    public Size2(): void {
                        this.controls.dgShikakuShutokuRireki().height = 400;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }

                    public Size3(): void {
                        this.controls.dgShikakuShutokuRireki().height = 350;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }

                    public Size4(): void {
                        this.controls.dgShikakuShutokuRireki().height = 300;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }

                    public Size5(): void {
                        this.controls.dgShikakuShutokuRireki().height = 250;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }

                    public Size6(): void {
                        this.controls.dgShikakuShutokuRireki().height = 200;

                        this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();

                    }
                }
            }
        }
}


module DBZ {

    export module ShikakuTokusoRireki {

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




