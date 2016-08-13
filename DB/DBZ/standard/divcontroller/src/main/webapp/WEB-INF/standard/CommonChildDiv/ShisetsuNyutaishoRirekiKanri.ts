/// <reference path='ShisetsuNyutaishoRirekiKanri_Design.ts' />

// 共有子Divモード記述TypeScriptソースです。


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
                    "DisplayMode",
                    "DataGridHeight",
                    "DataGridWidth",
                    "MeisaiMode",
                    "Riyou"
                ];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }

            public DisplayMode() {
                return new Modes.DisplayMode(this.controls);
            }

            public DataGridHeight() {
                return new Modes.DataGridHeight(this.controls);
            }

            public DataGridWidth() {
                return new Modes.DataGridWidth(this.controls);
            }


            public MeisaiMode() {
                return new Modes.MeisaiMode(this.controls);
            }

            public Riyou() {
                return new Modes.Riyou(this.controls);
            }

        }

        export module Modes {


            export class DisplayMode {
                private controls: Controls;
                private gridWidthCalc;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 登録(): void {

                    this.controls.btnAddShisetsuNyutaisho().displayNone = false;

                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;
                    gridSetting.isShowSelectButtonColumn = false;
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
                    gridSetting.isShowSelectButtonColumn = false;
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
				     public 照会選択有(): void {

                    this.controls.btnAddShisetsuNyutaisho().displayNone = true;

                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;
                    gridSetting.isShowSelectButtonColumn = true;
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
                    gridSetting.isShowSelectButtonColumn = false;
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

            export class DataGridHeight {
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

            export class DataGridWidth {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public モード1(): void {
                    this.controls.dgShisetsuNyutaishoRireki().width = "1120";
                }

                public モード2(): void {
                    this.controls.dgShisetsuNyutaishoRireki().width = "1070";
                }

                public モード3(): void {
                    this.controls.dgShisetsuNyutaishoRireki().width = "990";
                }

                public モード4(): void {
                    this.controls.dgShisetsuNyutaishoRireki().width = "890";
                }

                public モード5(): void {
                    this.controls.dgShisetsuNyutaishoRireki().width = "810";
                }
            }


            export class MeisaiMode {
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
                    this.controls.btnShisetsuNyutaishoKakutei().displayNone = false;
                    // this.controls.btnShisetsuNyutaishoKakutei().disabled = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().displayNone = false;
                    // this.controls.btnShisetsuNyutaishoTorikeshi().disabled = false;


                }

                public 削除(): void {

                    this.controls.ShisetsuNyutaishoInput().displayNone = false;
                    this.controls.ShisetsuNyutaishoInput().readOnly = false;

                    this.controls.txtNyushoDate().displayNone = false;
                    this.controls.txtNyushoDate().readOnly = true;
                    this.controls.txtTaishoDate().displayNone = false;
                    this.controls.txtTaishoDate().readOnly = true;
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



            export class Riyou{
			private gridWidthCalc;
			private controls: Controls;
                    constructor(controls: Controls) {
                    this.controls = controls;
                }

				  public 台帳種別表示機能(): void {
                    // 台帳種別表示
                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'daichoShubetsu') {
                            columns[i].visible = true;
                        }
                    }
                    gridSetting.columns = columns;


                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();

                    this.controls.ccdShisetsuJoho().State().DaichoShubetsuAriMode();

					//施設種類表示、転出先保険者番号表示
					var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'shisetsuShurui') {
                            columns[i].visible = true;
                        }
                        if (columns[i].dataName === 'txtTenshutsusakiHokenshaBango') {
                            columns[i].visible = true;
                        }
                    }
                    gridSetting.columns = columns;

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                    this.controls.TenshutsusakiJohoPanel().displayNone = false;

                }



				public 全施設対象機能(): void {
					// 台帳種別非表示
				   var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'daichoShubetsu') {
                            columns[i].visible = false;
                        }
                    }
                    gridSetting.columns = columns;

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();

                    this.controls.ccdShisetsuJoho().State().DaichoShubetsuNashiMode();

					//施設種類表示、転出先保険者番号表示
					var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'shisetsuShurui') {
                            columns[i].visible = true;
                        }
                        if (columns[i].dataName === 'txtTenshutsusakiHokenshaBango') {
                            columns[i].visible = true;
                        }
                    }
                    gridSetting.columns = columns;

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                    this.controls.TenshutsusakiJohoPanel().displayNone = false;

					}


					public 被保険者対象機能(): void {
					// 台帳種別非表示
				   var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'daichoShubetsu') {
                            columns[i].visible = false;
                        }
                    }
                    gridSetting.columns = columns;

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();

                    this.controls.ccdShisetsuJoho().State().OtherTokureiMode();

					//施設種類表示、転出先保険者番号表示
					var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'shisetsuShurui') {
                            columns[i].visible = true;
                        }
                        if (columns[i].dataName === 'txtTenshutsusakiHokenshaBango') {
                            columns[i].visible = true;
                        }
                    }
                    gridSetting.columns = columns;
                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                    this.controls.TenshutsusakiJohoPanel().displayNone = false;
                }

					public 他市町村住所地特例者対象機能(): void {
					// 台帳種別非表示
				   var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'daichoShubetsu') {
                            columns[i].visible = false;
                        }
                    }
                    gridSetting.columns = columns;

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();

                    this.controls.ccdShisetsuJoho().State().OtherTokureiMode();

					//施設種類表示、転出先保険者番号非表示
					var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'shisetsuShurui') {
                            columns[i].visible = true;
                        }
                        if (columns[i].dataName === 'txtTenshutsusakiHokenshaBango') {
                            columns[i].visible = false;
                        }
                    }
                    gridSetting.columns = columns;

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                    this.controls.TenshutsusakiJohoPanel().displayNone = true;

                	}

               	 public 適用除外者対象機能(): void {
                    // 台帳種別非表示
                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'daichoShubetsu') {
                            columns[i].visible = false;
                        }
                    }
                    gridSetting.columns = columns;

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();

                    this.controls.ccdShisetsuJoho().State().TekiyoJogaiMode();

                    //施設種類、転出先保険者番号非表示
                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'shisetsuShurui') {
                            columns[i].visible = false;
                        }
                        if (columns[i].dataName === 'txtTenshutsusakiHokenshaBango') {
                            columns[i].visible = false;
                        }
                    }
                    gridSetting.columns = columns;

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                    this.controls.TenshutsusakiJohoPanel().displayNone = true;


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

