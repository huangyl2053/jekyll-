/// <reference path="ServiceRiyohyoInfo_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBC
{
    export module ServiceRiyohyoInfo {

        export class ModeController{
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }
 
            public priorities(): Array<string> {
                return [];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }
        }

    }
}



module DBC {

    export module ServiceRiyohyoInfo {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("BeppyoMeisaiVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("BeppyoMeisaiDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("BeppyoGokeiVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("BeppyoGokeiDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("BeppyoRiyoNissuVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("BeppyoRiyoNissuDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KeikakuJigyoshaCodeVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KeikakuJigyoshaCodeDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KeikakuJigyoshaNameVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("KeikakuJigyoshaNameDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("onClickZengetsuCopy", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickRiyohyoMeisaiAdd", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickBeppyoMeisaiNew", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickBeppyoGokeiNew", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickBeppyoMeisaiKakutei", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickBeppyoGokeiKakutei", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgServiceRiyohyoListSelectByDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgServiceRiyohyoListSelectBySelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgServiceRiyohyoListSelectByDelete", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgServiceRiyohyoBeppyoListSelectByDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgServiceRiyohyoBeppyoListSelectBySelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgServiceRiyohyoBeppyoListSelectByDelete", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ServiceRiyohyoEraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("onClickBtnCalcMeisai", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClickBtnCalcGokei", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onBlurTxtSreviceCode", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public getBeppyoMeisaiVisible() {
                return this.controls.ServiceRiyohyoBeppyoMeisai().visible;
            }

            public setBeppyoMeisaiVisible(value) {
                this.controls.ServiceRiyohyoBeppyoMeisai().visible = value;
            }

            public getBeppyoMeisaiDisplayNone() {
                return this.controls.ServiceRiyohyoBeppyoMeisai().displayNone;
            }

            public setBeppyoMeisaiDisplayNone(value) {
                this.controls.ServiceRiyohyoBeppyoMeisai().displayNone = value;
            }

            public getBeppyoGokeiVisible() {
                return this.controls.ServiceRiyohyoBeppyoGokei().visible;
            }

            public setBeppyoGokeiVisible(value) {
                this.controls.ServiceRiyohyoBeppyoGokei().visible = value;
            }

            public getBeppyoGokeiDisplayNone() {
                return this.controls.ServiceRiyohyoBeppyoGokei().displayNone;
            }

            public setBeppyoGokeiDisplayNone(value) {
                this.controls.ServiceRiyohyoBeppyoGokei().displayNone = value;
            }

            public getBeppyoRiyoNissuVisible() {
                return this.controls.ServiceRiyohyoBeppyoRiyoNissu().visible;
            }

            public setBeppyoRiyoNissuVisible(value) {
                this.controls.ServiceRiyohyoBeppyoRiyoNissu().visible = value;
            }

            public getBeppyoRiyoNissuDisplayNone() {
                return this.controls.ServiceRiyohyoBeppyoRiyoNissu().displayNone;
            }

            public setBeppyoRiyoNissuDisplayNone(value) {
                this.controls.ServiceRiyohyoBeppyoRiyoNissu().displayNone = value;
            }

            public getKeikakuJigyoshaCodeVisible() {
                return this.controls.txtKeikakuJigyoshaCode().visible;
            }

            public setKeikakuJigyoshaCodeVisible(value) {
                this.controls.txtKeikakuJigyoshaCode().visible = value;
            }

            public getKeikakuJigyoshaCodeDisplayNone() {
                return this.controls.txtKeikakuJigyoshaCode().displayNone;
            }

            public setKeikakuJigyoshaCodeDisplayNone(value) {
                this.controls.txtKeikakuJigyoshaCode().displayNone = value;
            }

            public getKeikakuJigyoshaNameVisible() {
                return this.controls.txtKeikakuJigyoshaName().visible;
            }

            public setKeikakuJigyoshaNameVisible(value) {
                this.controls.txtKeikakuJigyoshaName().visible = value;
            }

            public getKeikakuJigyoshaNameDisplayNone() {
                return this.controls.txtKeikakuJigyoshaName().displayNone;
            }

            public setKeikakuJigyoshaNameDisplayNone(value) {
                this.controls.txtKeikakuJigyoshaName().displayNone = value;
            }
            
            /*
            //TODO n8178 城間篤人 モード化するか削除するか作成者の判断が必要。
            public getdgServiceRiyohyoListGridSetting() {
                return this.controls.dgServiceRiyohyoList().gridSetting;
            }

            public setdgServiceRiyohyoListGridSetting(value) {
                this.controls.dgServiceRiyohyoList().gridSetting = value;
            }
            */

            public getonClickZengetsuCopy() {
                return this.controls.btnZengetsuCopy().onClick;
            }

            public setonClickZengetsuCopy(value) {
                this.controls.btnZengetsuCopy().onClick = value;
            }

            public getonClickRiyohyoMeisaiAdd() {
                return this.controls.btnRiyohyoMeisaiAdd().onClick;
            }

            public setonClickRiyohyoMeisaiAdd(value) {
                this.controls.btnRiyohyoMeisaiAdd().onClick = value;
            }

            public getonClickBeppyoMeisaiNew() {
                return this.controls.btnBeppyoMeisaiNew().onClick;
            }

            public setonClickBeppyoMeisaiNew(value) {
                this.controls.btnBeppyoMeisaiNew().onClick = value;
            }

            public getonClickBeppyoGokeiNew() {
                return this.controls.btnBeppyoGokeiNew().onClick;
            }

            public setonClickBeppyoGokeiNew(value) {
                this.controls.btnBeppyoGokeiNew().onClick = value;
            }

            public getonClickBeppyoMeisaiKakutei() {
                return this.controls.btnBeppyoMeisaiKakutei().onClick;
            }

            public setonClickBeppyoMeisaiKakutei(value) {
                this.controls.btnBeppyoMeisaiKakutei().onClick = value;
            }

            public getonClickBeppyoGokeiKakutei() {
                return this.controls.btnBeppyoGokeiKakutei().onClick;
            }

            public setonClickBeppyoGokeiKakutei(value) {
                this.controls.btnBeppyoGokeiKakutei().onClick = value;
            }
            
            /*
            //TODO n8178 城間篤人 モード化するか削除するか作成者の判断が必要。
            public getdgServiceRiyohyoBeppyoListGridSetting() {
                return this.controls.dgServiceRiyohyoBeppyoList().gridSetting;
            }

            public setdgServiceRiyohyoBeppyoListGridSetting(value) {
                this.controls.dgServiceRiyohyoBeppyoList().gridSetting = value;
            }
            */

            public getdgServiceRiyohyoListSelectByDblClick() {
                return this.controls.dgServiceRiyohyoList().onSelectByDblClick;
            }

            public setdgServiceRiyohyoListSelectByDblClick(value) {
                this.controls.dgServiceRiyohyoList().onSelectByDblClick = value;
            }

            public getdgServiceRiyohyoListSelectBySelect() {
                return this.controls.dgServiceRiyohyoList().onSelectBySelectButton;
            }

            public setdgServiceRiyohyoListSelectBySelect(value) {
                this.controls.dgServiceRiyohyoList().onSelectBySelectButton = value;
            }

            public getdgServiceRiyohyoListSelectByDelete() {
                return this.controls.dgServiceRiyohyoList().onSelectByDeleteButton;
            }

            public setdgServiceRiyohyoListSelectByDelete(value) {
                this.controls.dgServiceRiyohyoList().onSelectByDeleteButton = value;
            }

            public getdgServiceRiyohyoBeppyoListSelectByDblClick() {
                return this.controls.dgServiceRiyohyoBeppyoList().onSelectByDblClick;
            }

            public setdgServiceRiyohyoBeppyoListSelectByDblClick(value) {
                this.controls.dgServiceRiyohyoBeppyoList().onSelectByDblClick = value;
            }

            public getdgServiceRiyohyoBeppyoListSelectBySelect() {
                return this.controls.dgServiceRiyohyoBeppyoList().onSelectBySelectButton;
            }

            public setdgServiceRiyohyoBeppyoListSelectBySelect(value) {
                this.controls.dgServiceRiyohyoBeppyoList().onSelectBySelectButton = value;
            }

            public getdgServiceRiyohyoBeppyoListSelectByDelete() {
                return this.controls.dgServiceRiyohyoBeppyoList().onSelectByDeleteButton;
            }

            public setdgServiceRiyohyoBeppyoListSelectByDelete(value) {
                this.controls.dgServiceRiyohyoBeppyoList().onSelectByDeleteButton = value;
            }

            public getServiceRiyohyoEraseBorder() {
                return this.controls.ServiceRiyohyoInfo().eraseBorder;
            }

            public setServiceRiyohyoEraseBorder(value) {
                this.controls.ServiceRiyohyoInfo().eraseBorder = value;
            }

            public getonClickBtnCalcMeisai() {
                return this.controls.btnCalcMeisai().onClick;
            }

            public setonClickBtnCalcMeisai(value) {
                this.controls.btnCalcMeisai().onClick = value;
            }

            public getonClickBtnCalcGokei() {
                return this.controls.btnCalcGokei().onClick;
            }

            public setonClickBtnCalcGokei(value) {
                this.controls.btnCalcGokei().onClick = value;
            }

            public getonBlurTxtSreviceCode() {
                return this.controls.txtServiceCode().onBlur;
            }

            public setonBlurTxtSreviceCode(value) {
                this.controls.txtServiceCode().onBlur = value;
            }

        }
    }
}




