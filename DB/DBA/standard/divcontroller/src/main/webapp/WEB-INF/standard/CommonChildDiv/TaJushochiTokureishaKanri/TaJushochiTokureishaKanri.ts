/// <reference path='TaJushochiTokureishaKanri_Design.ts' />
module DBA
{
    export module TaJushochiTokureishaKanri
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
            public priorities(): Array < string > {
                return [
                    "DisplayMode"
                ];
            }
            
            public DisplayMode() {
                return new Modes.DisplayMode(this.controls);
            }
        }

        export module Modes {
            export class DisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                
                public Shokai(): void {
                  this.controls.btnAdd().displayNone = true;
                  this.controls.btnKakunin().displayNone = true;
                  this.controls.btnTorikeshi().displayNone = true;
                  
                  var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                  var columns = gridSetting.columns;
                  
                  gridSetting.isShowRowState = false;
                  gridSetting.isShowSelectButtonColumn = true;
                  gridSetting.isShowModifyButtonColumn = false;
                  gridSetting.isShowDeleteButtonColumn = false;
                  
                  this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;
                  //this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();

                  this.controls.TajushochiTokureiInput().title="他市町村住所地特例情報";
                  this.controls.TajushochiTokureiInput().displayNone=false;
                  this.controls.TajushochiTokureiInput().disabled=true;
                  
                  this.controls.txtNyusyobi().displayNone=true;
                  this.controls.txtTekiyobi().displayNone=false;
                  this.controls.txtTekiyoTodokedebi().displayNone=false;
                  this.controls.ddlTekiyoJiyo().displayNone=false;
                  
                  this.controls.txtTasyobi().displayNone=true;
                  this.controls.txtKaijyobi().displayNone=false;
                  this.controls.txtKaijyoTodokedebi().displayNone=false;
                  this.controls.ddlKaijyoJiyo().displayNone=false;
                  this.controls.txtKaijyobi().wrap=true;
                  
                  this.controls.panSotimotoJyoho().displayNone=false;
                  this.controls.panShisetsuJoho().displayNone=true;
                  
                }

                public Teisei(): void {
                  this.controls.btnAdd().displayNone = false;
                  this.controls.btnKakunin().displayNone = false;
                  this.controls.btnTorikeshi().displayNone = false;
                  
                  var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                  var columns = gridSetting.columns;
                    
                  gridSetting.isShowRowState = true;
                  gridSetting.isShowSelectButtonColumn = false;
                  gridSetting.isShowModifyButtonColumn = true;
                  gridSetting.isShowDeleteButtonColumn = true;
                  
                  this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;
                  //this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                  
                  this.controls.TajushochiTokureiInput().title="他市町村住所地特例情報入力";
                  this.controls.TajushochiTokureiInput().displayNone=false;
                  this.controls.TajushochiTokureiInput().disabled=false;
                  
                  this.controls.txtNyusyobi().displayNone=true;
                  this.controls.txtTekiyobi().displayNone=false;
                  this.controls.txtTekiyoTodokedebi().displayNone=false;
                  this.controls.ddlTekiyoJiyo().displayNone=false;
                  
                  this.controls.txtTasyobi().displayNone=true;
                  this.controls.txtKaijyobi().displayNone=false;
                  this.controls.txtKaijyoTodokedebi().displayNone=false;
                  this.controls.ddlKaijyoJiyo().displayNone=false;
                  this.controls.txtKaijyobi().wrap=true;
                  
                  this.controls.panSotimotoJyoho().displayNone=false;
                  this.controls.panShisetsuJoho().displayNone=true;
                }

                public Tekiyo(): void {
                  this.controls.btnAdd().displayNone = true;
                  this.controls.btnKakunin().displayNone = false;
                  this.controls.btnTorikeshi().displayNone = true;
                  
                  var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                  var columns = gridSetting.columns;
                    
                  gridSetting.isShowRowState = false;
                  gridSetting.isShowSelectButtonColumn = false;
                  gridSetting.isShowModifyButtonColumn = false;
                  gridSetting.isShowDeleteButtonColumn = false;
                  
                  this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;
                  //this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                    
                  this.controls.TajushochiTokureiInput().title="他市町村住所地特例情報入力";
                  this.controls.TajushochiTokureiInput().displayNone=false;
                  this.controls.TajushochiTokureiInput().disabled=false;
                  
                  this.controls.txtNyusyobi().displayNone=false;
                  this.controls.txtTekiyobi().displayNone=false;
                  this.controls.txtTekiyoTodokedebi().displayNone=false;
                  this.controls.ddlTekiyoJiyo().displayNone=false;
                  
                  this.controls.txtTasyobi().displayNone=true;
                  this.controls.txtKaijyobi().displayNone=true;
                  this.controls.txtKaijyoTodokedebi().displayNone=true;
                  this.controls.ddlKaijyoJiyo().displayNone=true;
                  
                  this.controls.panSotimotoJyoho().displayNone=false;
                  this.controls.panShisetsuJoho().displayNone=false;
                }

                public Kaijyo(): void {
                  this.controls.btnAdd().displayNone = true;
                  this.controls.btnKakunin().displayNone = false;
                  this.controls.btnTorikeshi().displayNone = true;
                  
                  var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                  var columns = gridSetting.columns;
                  
                  gridSetting.isShowRowState = false;
                  gridSetting.isShowSelectButtonColumn = false;
                  gridSetting.isShowModifyButtonColumn = false;
                  gridSetting.isShowDeleteButtonColumn = false;
                  
                  this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;
                  //this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                    
                  this.controls.TajushochiTokureiInput().title="他市町村住所地特例情報入力";
                  this.controls.TajushochiTokureiInput().displayNone=false;
                  this.controls.TajushochiTokureiInput().disabled=false;
                  
                  this.controls.txtNyusyobi().displayNone=true;
                  this.controls.txtTekiyobi().displayNone=true;
                  this.controls.txtTekiyoTodokedebi().displayNone=true;
                  this.controls.ddlTekiyoJiyo().displayNone=true;
                  
                  this.controls.txtTasyobi().displayNone=false;
                  this.controls.txtKaijyobi().displayNone=false;
                  this.controls.txtKaijyoTodokedebi().displayNone=false;
                  this.controls.ddlKaijyoJiyo().displayNone=false;
                  this.controls.txtKaijyobi().wrap=false;
                  
                  this.controls.panSotimotoJyoho().displayNone=true;
                  this.controls.panShisetsuJoho().displayNone=true;
                }
                
                public ShisetuHenko(): void {
                  this.controls.btnAdd().displayNone = true;
                  this.controls.btnKakunin().displayNone = true;
                  this.controls.btnTorikeshi().displayNone = true;
                  
                  var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                  var columns = gridSetting.columns;
                  
                  gridSetting.isShowRowState = false;
                  gridSetting.isShowSelectButtonColumn = false;
                  gridSetting.isShowModifyButtonColumn = false;
                  gridSetting.isShowDeleteButtonColumn = false;
                  
                  this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;
                  //this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                  
                  this.controls.TajushochiTokureiInput().displayNone=true;
                }
            }
        }
    }
}

module DBA
{
    export module TaJushochiTokureishaKanri
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

