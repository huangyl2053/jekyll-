/// <reference path='TekiyoJogaiRireki_Design.ts' />
module DBZ
{
    export module TekiyoJogaiRireki
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }
            
            /////////////////////////////
            public ModeA() {
                return new Modes.ModeA(this.controls);
            }
            
            public ModeB() {
                return new Modes.ModeB(this.controls);
            }
            
            public ModeC() {
                return new Modes.ModeC(this.controls);
            }
            
            public ModeD() {
                return new Modes.ModeD(this.controls);
            }
			
			public ModeShokai() {
                return new Modes.ModeShokai(this.controls);
            }
            
            public 除外施設入所適用() {
                return new Modes.除外施設入所適用(this.controls);
            }
            
            public 除外施設退所解除() {
                return new Modes.除外施設退所解除(this.controls);
            }
            
            public 除外施設変更変更() {
                return new Modes.除外施設変更変更(this.controls);
            }
            
            public 除外異動訂正() {
                return new Modes.除外異動訂正(this.controls);
            }
			 public 履歴訂正() {
                return new Modes.履歴訂正(this.controls);
            }
			
            ////////////////////////////

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
            
            ////////////////////////////////////////////////////
            
            public priorities(): Array<string> {
                return [
                    "ModeA","ModeB","ModeC","ModeD","ModeShokai",
                    "除外施設入所適用","除外施設退所解除","除外施設変更変更","除外異動訂正","履歴訂正"
                ];
            }
            ////////////////////////////////////////////////////
        }

        export module Modes {
        //////////////////////////////////
              //新規（適用）モード
              export class ModeA {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                 public Shinki(): void {
                  
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = false;
                   
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnKakutei().displayNone = false;
					this.controls.btnInputClear().displayNone = false;
                    this.controls.TekiyoJogaiTorokuHenkoIchiran().displayNone = true;
                }
              
              
              }
              
              //削除（解除）モード
              export class ModeB {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }


                 public Kaijo(): void {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                   
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = false;
                    
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = false;
					 this.controls.btnInputClear().displayNone = false;
                    this.controls.btnInputClear().disabled = false;
                    this.controls.TekiyoJogaiTorokuHenkoIchiran().displayNone = true;
                }
              }
                
              //変更モード
              export class ModeC {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }


                 public HenKo(): void {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                   
                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                                     
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = true;
					this.controls.btnInputClear().displayNone = false;
                    this.controls.btnInputClear().disabled = true;
                    this.controls.TekiyoJogaiTorokuHenkoIchiran().displayNone = true;
                }
                
              }
              //表示モード
              export class ModeD {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }


                 public Hyoji(): void {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    
                    this.controls.btnKakutei().displayNone = true;
					this.controls.btnInputClear().displayNone = true;
                    this.controls.TekiyoJogaiTorokuHenkoIchiran().displayNone = true;
                }

              
              
              }
              //除外施設入所により適用モード
              export class 除外施設入所適用 {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                 public 適用(): void {
                  
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = false;
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = false;
					this.controls.btnInputClear().displayNone = false;
                    this.controls.btnInputClear().disabled = false;
                    this.controls.btnAdd().displayNone = false;			
					
                    this.controls.datagridTekiyoJogai().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.TekiyoJogaiTorokuHenkoIchiran().displayNone = true;
					this.controls.ccdShisetsuJoho().入力補助().除外施設を表示する();
                }
              }
              //除外施設退所により解除モード
              export class 除外施設退所解除 {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                 public 解除(): void {
				 
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = false;
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = false;
					this.controls.btnInputClear().displayNone = false;
                    this.controls.btnInputClear().disabled = false;
                    this.controls.btnAdd().displayNone = true;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.TekiyoJogaiTorokuHenkoIchiran().displayNone = true;
					this.controls.ccdShisetsuJoho().入力補助().除外施設を表示する();
                }
              }
              //除外施設変更により変更モード
              export class 除外施設変更変更 {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                 public 変更(): void {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = false;
					this.controls.panelTekiyoInput().disabled = true;
					this.controls.panelTekiyoInput().title = '';
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = false;
					this.controls.btnInputClear().displayNone = false;
                    this.controls.btnInputClear().disabled = false;
                    this.controls.panelTekiyoRireki().displayNone = true;                
                    this.controls.TekiyoJogaiTorokuHenkoIchiran().displayNone = false;	
					this.controls.ccdShisetsuNyushRirekiKanri().表示モード().登録()　　					
					this.controls.ccdShisetsuNyushRirekiKanri().明細表示モード().適用除外者();
					this.controls.ccdShisetsuNyushRirekiKanri().表示Heightサイズ().サイズ300();
					this.controls.ccdShisetsuNyushRirekiKanri().表示widthサイズ().モード5();
					this.controls.ccdShisetsuNyushRirekiKanri().台帳種別の列を().表示しない();					
					this.controls.ccdShisetsuNyushRirekiKanri().施設種類の列を().表示しない();	
					this.controls.ccdShisetsuNyushRirekiKanri().施設入退所を追加する().表示しない();	
					this.controls.txtNyusyoDate().displayNone = true;
                    this.controls.txtTaisyoDate().displayNone = true;
					
                }
                
              }
              //除外異動訂正により訂正モード
              export class 除外異動訂正 {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                 public 訂正(): void {
                   
				    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.txtNyusyoDate().displayNone = true;
                    this.controls.txtTaisyoDate().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = false;
                    this.controls.btnAdd().displayNone = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.TekiyoJogaiTorokuHenkoIchiran().displayNone = false;
                }
                
              }
			   export class 履歴訂正{
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                 public teisei(): void {               
				    this.controls.btnAdd().text = '過去の履歴を追加する';
					this.controls.btnAdd().width = "200";
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;                    
                    this.controls.btnKakutei().displayNone = true;
					this.controls.btnInputClear().displayNone = true;
                    this.controls.TekiyoJogaiTorokuHenkoIchiran().displayNone = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowSelectButtonColumn = false;
					this.controls.datagridTekiyoJogai().gridSetting.isShowModifyButtonColumn = true;
					this.controls.datagridTekiyoJogai().gridSetting.isShowDeleteButtonColumn = true;
					
				
					this.controls.ccdShisetsuNyushRirekiKanri().表示モード().登録();
					this.controls.ccdShisetsuNyushRirekiKanri().表示Heightサイズ().サイズ300();
					this.controls.ccdShisetsuNyushRirekiKanri().表示widthサイズ().モード5();
					this.controls.ccdShisetsuNyushRirekiKanri().台帳種別の列を().表示しない();
					this.controls.ccdShisetsuNyushRirekiKanri().明細表示モード().適用除外者();
					this.controls.ccdShisetsuNyushRirekiKanri().施設種類の列を().表示しない();
					this.controls.panelTekiyoInput().title = '明細';
					this.controls.TekiyoJogaiTorokuHenkoIchiran().title = '施設情報';
					this.controls.txtNyusyoDate().displayNone = true;
                    this.controls.txtTaisyoDate().displayNone = true;
                }
                
              }

			 export class ModeShokai {
                private controls: Controls;
                constructor(controls: Controls) {
                    this.controls = controls;
                }

                 public shokai(): void {
				    this.controls.btnAdd().displayNone = true;
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;                    
                    this.controls.btnKakutei().displayNone = true;
					this.controls.btnInputClear().displayNone = true;
                    this.controls.TekiyoJogaiTorokuHenkoIchiran().displayNone = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowSelectButtonColumn = true;
					this.controls.datagridTekiyoJogai().gridSetting.isShowModifyButtonColumn = false;
					this.controls.datagridTekiyoJogai().gridSetting.isShowDeleteButtonColumn = false;
					this.controls.ccdShisetsuNyushRirekiKanri().表示モード().照会();
					this.controls.ccdShisetsuNyushRirekiKanri().表示Heightサイズ().サイズ300();
					this.controls.ccdShisetsuNyushRirekiKanri().表示widthサイズ().モード5();
					this.controls.ccdShisetsuNyushRirekiKanri().台帳種別の列を().表示しない();
					this.controls.ccdShisetsuNyushRirekiKanri().明細表示モード().非表示();
					this.controls.ccdShisetsuNyushRirekiKanri().施設種類の列を().表示しない();
					this.controls.panelTekiyoInput().title = '明細';
					this.controls.TekiyoJogaiTorokuHenkoIchiran().title = '施設情報';
					this.controls.txtNyusyoDate().displayNone = true;
                    this.controls.txtTaisyoDate().displayNone = true;
					                 
                }
                
              }

        
        //////////////////////////////////
        }
    }
}

module DBZ
{
    export module TekiyoJogaiRireki
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

