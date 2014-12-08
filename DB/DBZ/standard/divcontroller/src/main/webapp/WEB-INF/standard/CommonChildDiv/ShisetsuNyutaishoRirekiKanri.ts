/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path='ShisetsuNyutaishoRirekiKanri_Design.ts' />
module DBZ {
    export module ShisetsuNyutaishoRirekiKanri {

        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public priorities(): Array {
                return [
                    "表示モード",
                    "表示Heightサイズ",
                    "表示widthサイズ",
                    "台帳種別の列を",
                    "明細表示モード"
                ];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }

            public 表示モード() {
                return new Modes.表示モード(this.controls);
            }

            public 表示Heightサイズ() {
                return new Modes.表示heightサイズ(this.controls);
            }

            public 表示widthサイズ() {
                return new Modes.表示widthサイズ(this.controls);
            }

            public 台帳種別の列を() {
                return new Modes.台帳種別の列を(this.controls);
            }

            public 明細表示モード() {
                return new Modes.明細表示モード(this.controls);
            }
        }

        export module Modes {
            

            export class 表示モード {
                private controls: Controls;
                private gridWidthCalc;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 登録(): void {

                    this.controls.btnAddShisetsuNyutaisho().displayNone = false;

                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'state') {
                            columns[i].visible = false;
                        }
                    }
                    gridSetting.columns = columns;

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();



                }


                public 照会(): void {

                    this.controls.btnAddShisetsuNyutaisho().displayNone = true;

                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'state') {
                            columns[i].visible = false;
                        }
                    }
                    gridSetting.columns = columns;

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();

                }

                public 資格異動(): void {

                    this.controls.btnAddShisetsuNyutaisho().displayNone = false;

                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'state') {
                            columns[i].visible = true;
                        }
                    }

                    gridSetting.columns = columns;
                    
                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();

                }
            }

            export class 表示heightサイズ {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public サイズ200(): void {
                    this.controls.dgShisetsuNyutaishoRireki().height = "200";
                }

                public サイズ250(): void {
                    this.controls.dgShisetsuNyutaishoRireki().height = "250";
                }

                public サイズ300(): void {
                    this.controls.dgShisetsuNyutaishoRireki().height = "300";
                }

                public サイズ350(): void {
                    this.controls.dgShisetsuNyutaishoRireki().height = "350";
                }

                public サイズ400(): void {
                    this.controls.dgShisetsuNyutaishoRireki().height = "400";
                }

                public サイズ450(): void {
                    this.controls.dgShisetsuNyutaishoRireki().height = "450";
                }

                public サイズ500(): void {
                    this.controls.dgShisetsuNyutaishoRireki().height = "500";
                }
            }

            export class 表示widthサイズ {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public モード1(): void {
                    this.controls.dgShisetsuNyutaishoRireki().width = "1030";
                }

                public モード2(): void {
                    this.controls.dgShisetsuNyutaishoRireki().width = "980";
                }

                public モード3(): void {
                    this.controls.dgShisetsuNyutaishoRireki().width = "900";
                }

                public モード4(): void {
                    this.controls.dgShisetsuNyutaishoRireki().width = "800";
                }

                public モード5(): void {
                    this.controls.dgShisetsuNyutaishoRireki().width = "720";
                }
            }

            export class 台帳種別の列を {
                private controls: Controls;
                private gridWidthCalc;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 表示しない(): void {
                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'daichoShubetsu') {
                            columns[i].visible = false;
                        }
                    }
                    gridSetting.columns = columns;

                    this.controls.ccdShisetsuJoho().台帳種別().台帳種別非表示する();
                    
                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                }

                public 表示する(): void {
                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'daichoShubetsu') {
                            columns[i].visible = true;
                        }
                    }
                    gridSetting.columns = columns;
                    
                    this.controls.ccdShisetsuJoho().台帳種別().台帳種別表示する();
                    
                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                }
            }
            
            export class 明細表示モード {
                private controls: Controls;
                
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 追加_修正(): void {
                    
                    this.controls.ShisetsuNyutaishoInput().displayNone = false;
                    this.controls.ShisetsuNyutaishoInput().readOnly = false;

                    this.controls.txtNyushoDate().displayNone = false;
                    this.controls.txtNyushoDate().readOnly = false;
                    this.controls.txtTaishoDate().displayNone = false;
                    this.controls.txtTaishoDate().readOnly = false;
                    this.controls.ccdShisetsuJoho().表示モード().defaultView();
                    this.controls.btnShisetsuNyutaishoKakutei().displayNone = false;
                    this.controls.btnShisetsuNyutaishoKakutei().disabled = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().displayNone = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().disabled = false;


                }
                
                public 削除(): void {

                    this.controls.ShisetsuNyutaishoInput().displayNone = false;
                    this.controls.ShisetsuNyutaishoInput().readOnly = false;
                    
                    this.controls.txtNyushoDate().displayNone = false;
                    this.controls.txtNyushoDate().readOnly = true;
                    this.controls.txtTaishoDate().displayNone = false;
                    this.controls.txtTaishoDate().readOnly = true;
                    this.controls.ccdShisetsuJoho().表示モード().readOnly();
                    this.controls.btnShisetsuNyutaishoKakutei().displayNone = false;
                    this.controls.btnShisetsuNyutaishoKakutei().disabled = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().displayNone = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().disabled = false;

                }

                public 選択不可(): void {

                    this.controls.ShisetsuNyutaishoInput().displayNone = false;
                    this.controls.ShisetsuNyutaishoInput().readOnly = true;

                    this.controls.txtNyushoDate().displayNone = false;
                    this.controls.txtNyushoDate().readOnly = true;
                    this.controls.txtTaishoDate().displayNone = false;
                    this.controls.txtTaishoDate().readOnly = true;
                    this.controls.ccdShisetsuJoho().表示モード().readOnly();
                    this.controls.btnShisetsuNyutaishoKakutei().displayNone = false;
                    this.controls.btnShisetsuNyutaishoKakutei().disabled = true;
                    this.controls.btnShisetsuNyutaishoTorikeshi().displayNone = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().disabled = true;
                }
                
                
                public 非表示(): void {
                    this.controls.ShisetsuNyutaishoInput().displayNone = true;
                    this.controls.ShisetsuNyutaishoInput().readOnly = true;
                }
            }

        }
    }
}




module DBZ {

    export module ShisetsuNyutaishoRirekiKanri {

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

