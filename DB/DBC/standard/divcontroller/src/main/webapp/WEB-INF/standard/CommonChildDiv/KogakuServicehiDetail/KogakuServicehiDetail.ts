/// <reference path="KogakuServicehiDetail_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module KogakuServicehiDetail {

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

                //追加モード
                public tsuika(): void {
                   
                    //申請者情報
                    this.controls.tplShinseisha().disabled = false;
                    this.controls.txtShinseiYMD().disabled = false;
                    this.controls.rdbShinseisyaKubun().disabled = false;
                    this.controls.txtHokenJyaBango().disabled = false;
                    this.controls.chkKokuhorenSaiso().disabled = false;
                    this.controls.txtShimeiKanji().disabled = false;
                    this.controls.txtShimeiKana().disabled = false;
                    this.controls.txtTelNo().disabled = false;
                    this.controls.txtShinseiRiyu().disabled = false;
                    this.controls.txtShiharaiTotalAmount().disabled = false;
                    //口座情報
                    //this.controls.tplKoza().disabled = true;
                    //this.controls.ccdShiharaiHohoJyoho().disabled = true;
                    //判定結果
                    this.controls.tplJudgementResult().disabled = false;
                    this.controls.txtUketsukeYMD().disabled = false;
                    this.controls.txtKetteiYMD().disabled = false;
                    this.controls.txtShikyuKingaku().disabled = false;
                    this.controls.txtHonninShiharaiGaku().disabled = false;
                    this.controls.txtSetaiSyuyakuBango().disabled = false;
                    this.controls.txtShikyusinaiRiyu().disabled = false;
                    this.controls.rdbShinsaHohoKubun().disabled = false;
                    //高額決定情報
                    this.controls.tplKetteiJoho().disabled = true;
                    this.controls.tplKetteiJoho().visible = false;
                }
                
                //修正モード
                public shusei(): void {
                    
                    //申請者情報
                    this.controls.tplShinseisha().disabled = false;
                    this.controls.txtShinseiYMD().disabled = false;
                    this.controls.rdbShinseisyaKubun().disabled = false;
                    this.controls.txtHokenJyaBango().disabled = false;
                    this.controls.chkKokuhorenSaiso().disabled = false;
                    this.controls.txtShimeiKanji().disabled = false;
                    this.controls.txtShimeiKana().disabled = false;
                    this.controls.txtTelNo().disabled = false;
                    this.controls.txtShinseiRiyu().disabled = false;
                    this.controls.txtShiharaiTotalAmount().disabled = false;
                    //口座情報
                    //this.controls.tplKoza().disabled = true;
                    //this.controls.ccdShiharaiHohoJyoho().disabled = true;
                    //判定結果
                    this.controls.tplJudgementResult().disabled = false;
                    this.controls.txtUketsukeYMD().disabled = false;
                    this.controls.txtKetteiYMD().disabled = false;
                    this.controls.txtShikyuKingaku().disabled = false;
                    this.controls.txtHonninShiharaiGaku().disabled = false;
                    this.controls.txtSetaiSyuyakuBango().disabled = false;
                    this.controls.txtShikyusinaiRiyu().disabled = false;
                    this.controls.rdbShinsaHohoKubun().disabled = false;
                    //高額決定情報
                    this.controls.tplKetteiJoho().disabled = true;
                    this.controls.tplKetteiJoho().visible = false;
                }
                
                //送付済モード
                public sofuzumi(): void {
                    //申請者情報
                    this.controls.tplShinseisha().disabled = false;
                    this.controls.txtShinseiYMD().disabled = true;
                    this.controls.rdbShinseisyaKubun().disabled = true;
                    this.controls.txtHokenJyaBango().disabled = true;
                    this.controls.chkKokuhorenSaiso().disabled = false;
                    this.controls.txtShimeiKanji().disabled = true;
                    this.controls.txtShimeiKana().disabled = true;
                    this.controls.txtTelNo().disabled = true;
                    this.controls.txtShinseiRiyu().disabled = true;
                    this.controls.txtShiharaiTotalAmount().disabled = true;
                    //口座情報
                    //this.controls.tplKoza().disabled = true;
                    //this.controls.ccdShiharaiHohoJyoho().disabled = true;
                    //判定結果
                    this.controls.tplJudgementResult().disabled = true;
                    //高額決定情報
                    this.controls.tplKetteiJoho().disabled = true;
                    this.controls.tplKetteiJoho().visible = false;
                }
                
                //削除モード
                public sakujyo(): void {
                    //申請者情報
                    this.controls.tplShinseisha().disabled = true;
                    //口座情報
                    this.controls.tplKoza().disabled = true;
                    //判定結果
                    this.controls.tplJudgementResult().disabled = true;
                    //高額決定情報
                    this.controls.tplKetteiJoho().disabled = true;
                    this.controls.tplKetteiJoho().visible = false;
                }
                
                //照会モード
                public shokai(): void {
                    
                    //申請者情報
                    this.controls.tplShinseisha().disabled = true;
                    //口座情報
                    this.controls.tplKoza().disabled = true;
                    //判定結果
                    this.controls.tplJudgementResult().disabled = true;
                    //高額決定情報
                    this.controls.tplKetteiJoho().disabled = true;
                    this.controls.tplKetteiJoho().visible = true;
                }
            }
        }
        
        
        
        

    }
}



module DBC {

    export module KogakuServicehiDetail {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
               editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("tplJudgementResult_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("tplKetteiJoho_visible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public gettitle() {
                return this.controls.KogakuServicehiDetail().title;
            }

            public settitle(value) {
                this.controls.KogakuServicehiDetail().title = value;
            }

            public geteraseBorder() {
                return this.controls.KogakuServicehiDetail().eraseBorder;
            }

            public seteraseBorder(value) {
                this.controls.KogakuServicehiDetail().eraseBorder = value;
            }

            public getpanelDisplay() {
                return this.controls.KogakuServicehiDetail().panelDisplay;
            }

            public setpanelDisplay(value) {
                this.controls.KogakuServicehiDetail().panelDisplay = value;
            }

            public gettplJudgementResult_title() {
                return this.controls.tplJudgementResult().title;
            }

            public settplJudgementResult_title(value) {
                this.controls.tplJudgementResult().title = value;
            }

            public gettplKetteiJoho_visible() {
                return this.controls.tplKetteiJoho().visible;
            }

            public settplKetteiJoho_visible(value) {
                this.controls.tplKetteiJoho().visible = value;
            }

        }
    }
}




