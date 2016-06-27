/// <reference path="KyodoJukyushaIdoRenrakuhyo_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module KyodoJukyushaIdoRenrakuhyo {

        export class ModeController{
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }
 
            public priorities(): Array<string> {
                return ["DisplayMode"];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
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

                //新規モード
                public shinki(): void {
                	this.controls.KyodoJukyushaIdoRenrakuhyo().disabled = false;
                    this.controls.txtHiHokenshaNo().readOnly = true;		//被保番号
                    this.controls.txtTaisyoYM().readOnly = true;			//対象年月
                    this.controls.txtIdoYMD().readOnly = true;				//異動日
                    this.controls.txtShoKisaiHokenshaNo().readOnly = false;	//証記載保険者番号
                    this.controls.radIdoKubunCode().readOnly = false;		//異動区分
                    this.controls.ddlJukyushaIdoJiyu().readOnly = false;	//異動事由
                    this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().visible = false;
                    //this.controls.txtTeiseiYMD().readOnly = true;			//訂正日
                    //this.controls.radTeiseiKubunCode().readOnly = true;		//訂正区分
                    //基本送付情報
                    this.controls.chkKihonSofuAdd().visible = true;
                    this.controls.chkKihonSofuAdd().readOnly = false;
                    this.controls.chkKihonSofuDelete().visible = false;
                    this.controls.chkKihonSofuDelete().readOnly = false;
                    //KyodoJukyushaIdoRenrakuhyoKihonPanel
                    this.controls.KyodoJukyushaIdoRenrakuhyoShokanPanel().readOnly = false;
                    this.controls.txtKihonIdoYMD().readOnly = false;
                    this.controls.txtRirekiNo().readOnly = true;
                    //this.controls.txtHiHokenshaName().readOnly = true;
                    //this.controls.txtTelNo().readOnly = true;
                    //this.controls.txtChohyoOutputJunjyoCode().readOnly = true;
                    //this.controls.txtYubinNo().readOnly = true;
                    //this.controls.txtAddress().readOnly = true;
                    //this.controls.txtAddressKana().readOnly = true;
                    
                    //償還送付情報
                    this.controls.chkShokanSofuAdd().visible = true;
                    this.controls.chkShokanSofuAdd().readOnly = false;
                    this.controls.chkShokanSofuDelete().visible = false;
                    this.controls.chkShokanSofuDelete().readOnly = false;
                    //KyodoJukyushaIdoRenrakuhyoShokanPanel
                    this.controls.KyodoJukyushaIdoRenrakuhyoShokanPanel().readOnly = false;
                    this.controls.txtShokanIdoYMD().readOnly = false;
                    this.controls.txtShokanRirekiNo().readOnly = true;
                    //this.controls.txtHokenKyufuIchijiSashitomeYMD().readOnly = true;
                    //this.controls.ddlHokenkyufuIchijiSashitomeKubun().readOnly = true;
                    //this.controls.txtHokenkyufuIchijiSashitomeKingaku().readOnly = true;
                    
                    //高額送付情報
                    this.controls.chkKogakuSofuAdd().visible = true;
                    this.controls.chkKogakuSofuAdd().readOnly = false;
                    this.controls.chkKogakuSofuDelete().visible = false;
                    this.controls.chkKogakuSofuDelete().readOnly = false;
                    //KyodoJukyushaIdoRenrakuhyoKogakuPanel
                    this.controls.KyodoJukyushaIdoRenrakuhyoKogakuPanel().readOnly = false;
                    this.controls.txtKogakuIdoYMD().readOnly = false;
                    this.controls.txtKogakuRirekiNo().readOnly = true;
                    //this.controls.txtSetaiShuyakuNo().readOnly = true;
                    //this.controls.ddlSetaiShotokuKubun().readOnly = true;
                    //this.controls.ddlShotokuKubun().readOnly = true;
                    //this.controls.radRoureiFukushiNenkinJukyuAriFlag().readOnly = true;
                    //this.controls.radRiyoshaFutan2DankaiAriFlag().readOnly = true;
                    //this.controls.radShikyuShinseishoOutputAriFlag().readOnly = true;
                }
                
                //訂正モード
                public teisei(): void {
                	this.controls.KyodoJukyushaIdoRenrakuhyo().disabled = false;
                    this.controls.txtHiHokenshaNo().readOnly = true;		//被保番号
                    this.controls.txtTaisyoYM().readOnly = true;			//対象年月
                    this.controls.txtIdoYMD().readOnly = true;				//異動日
                    this.controls.txtShoKisaiHokenshaNo().readOnly = false;	//証記載保険者番号
                    this.controls.radIdoKubunCode().readOnly = false;		//異動区分
                    this.controls.ddlJukyushaIdoJiyu().readOnly = false;	//異動事由
                    this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().visible = true;
                    //this.controls.txtTeiseiYMD().readOnly = true;			//訂正日
                    //this.controls.radTeiseiKubunCode().readOnly = true;		//訂正区分
                    //基本送付情報
                    this.controls.chkKihonSofuAdd().visible = true;
                    this.controls.chkKihonSofuAdd().readOnly = false;
                    this.controls.chkKihonSofuDelete().visible = true;
                    this.controls.chkKihonSofuDelete().readOnly = false;
                    //KyodoJukyushaIdoRenrakuhyoKihonPanel
                    this.controls.KyodoJukyushaIdoRenrakuhyoShokanPanel().readOnly = false;
                    this.controls.txtKihonIdoYMD().readOnly = true;
                    this.controls.txtRirekiNo().readOnly = true;
                    //this.controls.txtHiHokenshaName().readOnly = true;
                    //this.controls.txtTelNo().readOnly = true;
                    //this.controls.txtChohyoOutputJunjyoCode().readOnly = true;
                    //this.controls.txtYubinNo().readOnly = true;
                    //this.controls.txtAddress().readOnly = true;
                    //this.controls.txtAddressKana().readOnly = true;
                    
                    //償還送付情報
                    this.controls.chkShokanSofuAdd().visible = true;
                    this.controls.chkShokanSofuAdd().readOnly = false;
                    this.controls.chkShokanSofuDelete().visible = true;
                    this.controls.chkShokanSofuDelete().readOnly = false;
                    //KyodoJukyushaIdoRenrakuhyoShokanPanel
                    this.controls.KyodoJukyushaIdoRenrakuhyoShokanPanel().readOnly = false;
                    this.controls.txtShokanIdoYMD().readOnly = true;
                    this.controls.txtShokanRirekiNo().readOnly = true;
                    //this.controls.txtHokenKyufuIchijiSashitomeYMD().readOnly = true;
                    //this.controls.ddlHokenkyufuIchijiSashitomeKubun().readOnly = true;
                    //this.controls.txtHokenkyufuIchijiSashitomeKingaku().readOnly = true;
                    
                    //高額送付情報
                    this.controls.chkKogakuSofuAdd().visible = true;
                    this.controls.chkKogakuSofuAdd().readOnly = false;
                    this.controls.chkKogakuSofuDelete().visible = true;
                    this.controls.chkKogakuSofuDelete().readOnly = false;
                    //KyodoJukyushaIdoRenrakuhyoKogakuPanel
                    this.controls.KyodoJukyushaIdoRenrakuhyoKogakuPanel().readOnly = false;
                    this.controls.txtKogakuIdoYMD().readOnly = true;
                    this.controls.txtKogakuRirekiNo().readOnly = true;
                    //this.controls.txtSetaiShuyakuNo().readOnly = true;
                    //this.controls.ddlSetaiShotokuKubun().readOnly = true;
                    //this.controls.ddlShotokuKubun().readOnly = true;
                    //this.controls.radRoureiFukushiNenkinJukyuAriFlag().readOnly = true;
                    //this.controls.radRiyoshaFutan2DankaiAriFlag().readOnly = true;
                    //this.controls.radShikyuShinseishoOutputAriFlag().readOnly = true;
                }
                
                //削除モード
                public sakujyo(): void {
                    //this.controls.KyodoJukyushaIdoRenrakuhyo().readOnly = true;
                    this.controls.KyodoJukyushaIdoRenrakuhyo().disabled = true;
                    //基本送付情報
                    this.controls.chkKihonSofuAdd().visible = false;
                    this.controls.chkKihonSofuDelete().visible = false;
                    //償還送付情報
                    this.controls.chkShokanSofuAdd().visible = false;
                    this.controls.chkShokanSofuDelete().visible = false;
                    //高額送付情報
                    this.controls.chkKogakuSofuAdd().visible = false;
                    this.controls.chkKogakuSofuDelete().visible = false;
                }
                
                //照会モード
                public shokai(): void {
                    //this.controls.KyodoJukyushaIdoRenrakuhyo().readOnly = true;
                    this.controls.KyodoJukyushaIdoRenrakuhyo().disabled = true;
                    //基本送付情報
                    this.controls.chkKihonSofuAdd().visible = false;
                    this.controls.chkKihonSofuDelete().visible = false;
                    //償還送付情報
                    this.controls.chkShokanSofuAdd().visible = false;
                    this.controls.chkShokanSofuDelete().visible = false;
                    //高額送付情報
                    this.controls.chkKogakuSofuAdd().visible = false;
                    this.controls.chkKogakuSofuDelete().visible = false;
                }
            }
        }
        

    }
}



module DBC {

    export module KyodoJukyushaIdoRenrakuhyo {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("TeiseiInfoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TeiseiInfoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getTeiseiInfoVisible() {
                return this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().visible;
            }

            public setTeiseiInfoVisible(value) {
                this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().visible = value;
            }

            public getTeiseiInfoDisplayNone() {
                return this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().displayNone;
            }

            public setTeiseiInfoDisplayNone(value) {
                this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().displayNone = value;
            }

        }
    }
}




