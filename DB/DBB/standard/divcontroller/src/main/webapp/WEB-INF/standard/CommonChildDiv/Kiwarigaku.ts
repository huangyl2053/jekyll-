/// <reference path="Kiwarigaku_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBB
{
    export module Kiwarigaku {

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



module DBB {

    export module Kiwarigaku {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("TokuchoKiText1", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuchoKiText2", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuchoKiText3", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuchoKiText4", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuchoKiText5", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuchoKiText6", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuchoKiVisible1", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuchoKiVisible2", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuchoKiVisible3", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuchoKiVisible4", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuchoKiVisible5", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuchoKiVisible6", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuKibetsuGakuText1", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuKibetsuGakuText2", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuKibetsuGakuText3", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuKibetsuGakuText4", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuKibetsuGakuText5", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuKibetsuGakuText6", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuKibetsuGakuVisible1", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuKibetsuGakuVisible2", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuKibetsuGakuVisible3", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuKibetsuGakuVisible4", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuKibetsuGakuVisible5", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuKibetsuGakuVisible6", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText1", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuNofuGakuText2", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuNofuGakuText3", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuNofuGakuText4", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuNofuGakuText5", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuNofuGakuText6", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuNofuGakuText7", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText8", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText9", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText10", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText11", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText12", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText13", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuText14", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible1", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible2", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible3", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible4", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible5", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible6", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible7", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible8", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible9", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible10", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible11", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible12", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible13", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofuGakuVisible14", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiText1", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText2", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText3", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText4", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText5", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText6", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText7", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText8", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText9", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText10", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText11", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText12", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText13", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiText14", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKiVisible1", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible2", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible3", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible4", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible5", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible6", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible7", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible8", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible9", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible10", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible11", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible12", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible13", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKiVisible14", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuText1", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText2", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText3", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText4", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText5", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText6", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText7", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText8", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText9", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText10", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText11", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText12", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText13", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuText14", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsuGakuVisible1", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible2", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible3", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible4", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible5", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible6", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible7", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible8", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible9", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible10", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible11", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible12", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible13", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsuGakuVisible14", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuText1", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText2", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText3", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText4", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText5", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText6", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText7", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText8", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText9", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText10", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText11", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText12", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText13", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuText14", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofuGakuVisible1", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible2", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible3", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible4", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible5", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible6", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible7", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible8", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible9", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible10", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible11", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible12", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible13", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNofuGakuVisible14", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuKibetsugakuKeiText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuKibetsugakuKeiVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TokuNofugakuKeiText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TokuNofugakuKeiVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoKibetsugakuKeiText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoKibetsugakuKeiVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuchoNoufugakuKeiText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("FuchoNofugakuKeiVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            }

            public getTokuchoKiText1() {
                return this.controls.lblTokuchoKi1().text;
            }

            public setTokuchoKiText1(value) {
                this.controls.lblTokuchoKi1().text = value;
            }

            public getTokuchoKiText2() {
                return this.controls.lblTokuchoKi2().text;
            }

            public setTokuchoKiText2(value) {
                this.controls.lblTokuchoKi2().text = value;
            }

            public getTokuchoKiText3() {
                return this.controls.lblTokuchoKi3().text;
            }

            public setTokuchoKiText3(value) {
                this.controls.lblTokuchoKi3().text = value;
            }

            public getTokuchoKiText4() {
                return this.controls.lblTokuchoKi4().text;
            }

            public setTokuchoKiText4(value) {
                this.controls.lblTokuchoKi4().text = value;
            }

            public getTokuchoKiText5() {
                return this.controls.lblTokuchoKi5().text;
            }

            public setTokuchoKiText5(value) {
                this.controls.lblTokuchoKi5().text = value;
            }

            public getTokuchoKiText6() {
                return this.controls.lblTokuchoKi6().text;
            }

            public setTokuchoKiText6(value) {
                this.controls.lblTokuchoKi6().text = value;
            }

            public getTokuchoKiVisible1() {
                return this.controls.lblTokuchoKi1().visible;
            }

            public setTokuchoKiVisible1(value) {
                this.controls.lblTokuchoKi1().visible = value;
            }

            public getTokuchoKiVisible2() {
                return this.controls.lblTokuchoKi2().visible;
            }

            public setTokuchoKiVisible2(value) {
                this.controls.lblTokuchoKi2().visible = value;
            }

            public getTokuchoKiVisible3() {
                return this.controls.lblTokuchoKi3().visible;
            }

            public setTokuchoKiVisible3(value) {
                this.controls.lblTokuchoKi3().visible = value;
            }

            public getTokuchoKiVisible4() {
                return this.controls.lblTokuchoKi4().visible;
            }

            public setTokuchoKiVisible4(value) {
                this.controls.lblTokuchoKi4().visible = value;
            }

            public getTokuchoKiVisible5() {
                return this.controls.lblTokuchoKi5().visible;
            }

            public setTokuchoKiVisible5(value) {
                this.controls.lblTokuchoKi5().visible = value;
            }

            public getTokuchoKiVisible6() {
                return this.controls.lblTokuchoKi6().visible;
            }

            public setTokuchoKiVisible6(value) {
                this.controls.lblTokuchoKi6().visible = value;
            }

            public getTokuKibetsuGakuText1() {
                return this.controls.lblTokuKibetsuGaku1().text;
            }

            public setTokuKibetsuGakuText1(value) {
                this.controls.lblTokuKibetsuGaku1().text = value;
            }

            public getTokuKibetsuGakuText2() {
                return this.controls.lblTokuKibetsuGaku2().text;
            }

            public setTokuKibetsuGakuText2(value) {
                this.controls.lblTokuKibetsuGaku2().text = value;
            }

            public getTokuKibetsuGakuText3() {
                return this.controls.lblTokuKibetsuGaku3().text;
            }

            public setTokuKibetsuGakuText3(value) {
                this.controls.lblTokuKibetsuGaku3().text = value;
            }

            public getTokuKibetsuGakuText4() {
                return this.controls.lblTokuKibetsuGaku4().text;
            }

            public setTokuKibetsuGakuText4(value) {
                this.controls.lblTokuKibetsuGaku4().text = value;
            }

            public getTokuKibetsuGakuText5() {
                return this.controls.lblTokuKibetsuGaku5().text;
            }

            public setTokuKibetsuGakuText5(value) {
                this.controls.lblTokuKibetsuGaku5().text = value;
            }

            public getTokuKibetsuGakuText6() {
                return this.controls.lblTokuKibetsuGaku6().text;
            }

            public setTokuKibetsuGakuText6(value) {
                this.controls.lblTokuKibetsuGaku6().text = value;
            }

            public getTokuKibetsuGakuVisible1() {
                return this.controls.lblTokuKibetsuGaku1().visible;
            }

            public setTokuKibetsuGakuVisible1(value) {
                this.controls.lblTokuKibetsuGaku1().visible = value;
            }

            public getTokuKibetsuGakuVisible2() {
                return this.controls.lblTokuKibetsuGaku2().visible;
            }

            public setTokuKibetsuGakuVisible2(value) {
                this.controls.lblTokuKibetsuGaku2().visible = value;
            }

            public getTokuKibetsuGakuVisible3() {
                return this.controls.lblTokuKibetsuGaku3().visible;
            }

            public setTokuKibetsuGakuVisible3(value) {
                this.controls.lblTokuKibetsuGaku3().visible = value;
            }

            public getTokuKibetsuGakuVisible4() {
                return this.controls.lblTokuKibetsuGaku4().visible;
            }

            public setTokuKibetsuGakuVisible4(value) {
                this.controls.lblTokuKibetsuGaku4().visible = value;
            }

            public getTokuKibetsuGakuVisible5() {
                return this.controls.lblTokuKibetsuGaku5().visible;
            }

            public setTokuKibetsuGakuVisible5(value) {
                this.controls.lblTokuKibetsuGaku5().visible = value;
            }

            public getTokuKibetsuGakuVisible6() {
                return this.controls.lblTokuKibetsuGaku6().visible;
            }

            public setTokuKibetsuGakuVisible6(value) {
                this.controls.lblTokuKibetsuGaku6().visible = value;
            }

            public getTokuNofuGakuText1() {
                return this.controls.lblTokuNofuGaku1().text;
            }

            public setTokuNofuGakuText1(value) {
                this.controls.lblTokuNofuGaku1().text = value;
            }

            public getTokuNofuGakuText2() {
                return this.controls.lblTokuNofuGaku2().text;
            }

            public setTokuNofuGakuText2(value) {
                this.controls.lblTokuNofuGaku2().text = value;
            }

            public getTokuNofuGakuText3() {
                return this.controls.lblTokuNofuGaku3().text;
            }

            public setTokuNofuGakuText3(value) {
                this.controls.lblTokuNofuGaku3().text = value;
            }

            public getTokuNofuGakuText4() {
                return this.controls.lblTokuNofuGaku4().text;
            }

            public setTokuNofuGakuText4(value) {
                this.controls.lblTokuNofuGaku4().text = value;
            }

            public getTokuNofuGakuText5() {
                return this.controls.lblTokuNofuGaku5().text;
            }

            public setTokuNofuGakuText5(value) {
                this.controls.lblTokuNofuGaku5().text = value;
            }

            public getTokuNofuGakuText6() {
                return this.controls.lblTokuNofuGaku6().text;
            }

            public setTokuNofuGakuText6(value) {
                this.controls.lblTokuNofuGaku6().text = value;
            }

            public getTokuNofuGakuText7() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuText7(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getTokuNofuGakuText8() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuText8(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getTokuNofuGakuText9() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuText9(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getTokuNofuGakuText10() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuText10(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getTokuNofuGakuText11() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuText11(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getTokuNofuGakuText12() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuText12(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getTokuNofuGakuText13() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuText13(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getTokuNofuGakuText14() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuText14(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getTokuNofuGakuVisible1() {
                return this.controls.lblTokuNofuGaku1().visible;
            }

            public setTokuNofuGakuVisible1(value) {
                this.controls.lblTokuNofuGaku1().visible = value;
            }

            public getTokuNofuGakuVisible2() {
                return this.controls.lblTokuNofuGaku2().visible;
            }

            public setTokuNofuGakuVisible2(value) {
                this.controls.lblTokuNofuGaku2().visible = value;
            }

            public getTokuNofuGakuVisible3() {
                return this.controls.lblTokuNofuGaku3().visible;
            }

            public setTokuNofuGakuVisible3(value) {
                this.controls.lblTokuNofuGaku3().visible = value;
            }

            public getTokuNofuGakuVisible4() {
                return this.controls.lblTokuNofuGaku4().visible;
            }

            public setTokuNofuGakuVisible4(value) {
                this.controls.lblTokuNofuGaku4().visible = value;
            }

            public getTokuNofuGakuVisible5() {
                return this.controls.lblTokuNofuGaku5().visible;
            }

            public setTokuNofuGakuVisible5(value) {
                this.controls.lblTokuNofuGaku5().visible = value;
            }

            public getTokuNofuGakuVisible6() {
                return this.controls.lblTokuNofuGaku6().visible;
            }

            public setTokuNofuGakuVisible6(value) {
                this.controls.lblTokuNofuGaku6().visible = value;
            }

            public getTokuNofuGakuVisible7() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuVisible7(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getTokuNofuGakuVisible8() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuVisible8(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getTokuNofuGakuVisible9() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuVisible9(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getTokuNofuGakuVisible10() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuVisible10(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getTokuNofuGakuVisible11() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuVisible11(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getTokuNofuGakuVisible12() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuVisible12(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getTokuNofuGakuVisible13() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuVisible13(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getTokuNofuGakuVisible14() {
                return this.controls.Kiwarigaku().visible;
            }

            public setTokuNofuGakuVisible14(value) {
                this.controls.Kiwarigaku().visible = value;
            }

            public getFuchoKiText1() {
                return this.controls.lblFuchoKi1().text;
            }

            public setFuchoKiText1(value) {
                this.controls.lblFuchoKi1().text = value;
            }

            public getFuchoKiText2() {
                return this.controls.lblFuchoKi2().text;
            }

            public setFuchoKiText2(value) {
                this.controls.lblFuchoKi2().text = value;
            }

            public getFuchoKiText3() {
                return this.controls.lblFuchoKi3().text;
            }

            public setFuchoKiText3(value) {
                this.controls.lblFuchoKi3().text = value;
            }

            public getFuchoKiText4() {
                return this.controls.lblFuchoKi4().text;
            }

            public setFuchoKiText4(value) {
                this.controls.lblFuchoKi4().text = value;
            }

            public getFuchoKiText5() {
                return this.controls.lblFuchoKi5().text;
            }

            public setFuchoKiText5(value) {
                this.controls.lblFuchoKi5().text = value;
            }

            public getFuchoKiText6() {
                return this.controls.lblFuchoKi6().text;
            }

            public setFuchoKiText6(value) {
                this.controls.lblFuchoKi6().text = value;
            }

            public getFuchoKiText7() {
                return this.controls.lblFuchoKi7().text;
            }

            public setFuchoKiText7(value) {
                this.controls.lblFuchoKi7().text = value;
            }

            public getFuchoKiText8() {
                return this.controls.lblFuchoKi8().text;
            }

            public setFuchoKiText8(value) {
                this.controls.lblFuchoKi8().text = value;
            }

            public getFuchoKiText9() {
                return this.controls.lblFuchoKi9().text;
            }

            public setFuchoKiText9(value) {
                this.controls.lblFuchoKi9().text = value;
            }

            public getFuchoKiText10() {
                return this.controls.lblFuchoKi10().text;
            }

            public setFuchoKiText10(value) {
                this.controls.lblFuchoKi10().text = value;
            }

            public getFuchoKiText11() {
                return this.controls.lblFuchoKi11().text;
            }

            public setFuchoKiText11(value) {
                this.controls.lblFuchoKi11().text = value;
            }

            public getFuchoKiText12() {
                return this.controls.lblFuchoKi12().text;
            }

            public setFuchoKiText12(value) {
                this.controls.lblFuchoKi12().text = value;
            }

            public getFuchoKiText13() {
                return this.controls.lblFuchoKi13().text;
            }

            public setFuchoKiText13(value) {
                this.controls.lblFuchoKi13().text = value;
            }

            public getFuchoKiText14() {
                return this.controls.lblFuchoKi14().text;
            }

            public setFuchoKiText14(value) {
                this.controls.lblFuchoKi14().text = value;
            }

            public getFuchoKiVisible1() {
                return this.controls.lblFuchoKi1().visible;
            }

            public setFuchoKiVisible1(value) {
                this.controls.lblFuchoKi1().visible = value;
            }

            public getFuchoKiVisible2() {
                return this.controls.lblFuchoKi2().visible;
            }

            public setFuchoKiVisible2(value) {
                this.controls.lblFuchoKi2().visible = value;
            }

            public getFuchoKiVisible3() {
                return this.controls.lblFuchoKi3().visible;
            }

            public setFuchoKiVisible3(value) {
                this.controls.lblFuchoKi3().visible = value;
            }

            public getFuchoKiVisible4() {
                return this.controls.lblFuchoKi4().visible;
            }

            public setFuchoKiVisible4(value) {
                this.controls.lblFuchoKi4().visible = value;
            }

            public getFuchoKiVisible5() {
                return this.controls.lblFuchoKi5().visible;
            }

            public setFuchoKiVisible5(value) {
                this.controls.lblFuchoKi5().visible = value;
            }

            public getFuchoKiVisible6() {
                return this.controls.lblFuchoKi6().visible;
            }

            public setFuchoKiVisible6(value) {
                this.controls.lblFuchoKi6().visible = value;
            }

            public getFuchoKiVisible7() {
                return this.controls.lblFuchoKi7().visible;
            }

            public setFuchoKiVisible7(value) {
                this.controls.lblFuchoKi7().visible = value;
            }

            public getFuchoKiVisible8() {
                return this.controls.lblFuchoKi8().visible;
            }

            public setFuchoKiVisible8(value) {
                this.controls.lblFuchoKi8().visible = value;
            }

            public getFuchoKiVisible9() {
                return this.controls.lblFuchoKi9().visible;
            }

            public setFuchoKiVisible9(value) {
                this.controls.lblFuchoKi9().visible = value;
            }

            public getFuchoKiVisible10() {
                return this.controls.lblFuchoKi10().visible;
            }

            public setFuchoKiVisible10(value) {
                this.controls.lblFuchoKi10().visible = value;
            }

            public getFuchoKiVisible11() {
                return this.controls.lblFuchoKi11().visible;
            }

            public setFuchoKiVisible11(value) {
                this.controls.lblFuchoKi11().visible = value;
            }

            public getFuchoKiVisible12() {
                return this.controls.lblFuchoKi12().visible;
            }

            public setFuchoKiVisible12(value) {
                this.controls.lblFuchoKi12().visible = value;
            }

            public getFuchoKiVisible13() {
                return this.controls.lblFuchoKi13().visible;
            }

            public setFuchoKiVisible13(value) {
                this.controls.lblFuchoKi13().visible = value;
            }

            public getFuchoKiVisible14() {
                return this.controls.lblFuchoKi14().visible;
            }

            public setFuchoKiVisible14(value) {
                this.controls.lblFuchoKi14().visible = value;
            }

            public getFuchoKibetsuGakuText1() {
                return this.controls.lblFuchoKibetsuGaku1().text;
            }

            public setFuchoKibetsuGakuText1(value) {
                this.controls.lblFuchoKibetsuGaku1().text = value;
            }

            public getFuchoKibetsuGakuText2() {
                return this.controls.lblFuchoKibetsuGaku2().text;
            }

            public setFuchoKibetsuGakuText2(value) {
                this.controls.lblFuchoKibetsuGaku2().text = value;
            }

            public getFuchoKibetsuGakuText3() {
                return this.controls.lblFuchoKibetsuGaku3().text;
            }

            public setFuchoKibetsuGakuText3(value) {
                this.controls.lblFuchoKibetsuGaku3().text = value;
            }

            public getFuchoKibetsuGakuText4() {
                return this.controls.lblFuchoKibetsuGaku4().text;
            }

            public setFuchoKibetsuGakuText4(value) {
                this.controls.lblFuchoKibetsuGaku4().text = value;
            }

            public getFuchoKibetsuGakuText5() {
                return this.controls.lblFuchoKibetsuGaku5().text;
            }

            public setFuchoKibetsuGakuText5(value) {
                this.controls.lblFuchoKibetsuGaku5().text = value;
            }

            public getFuchoKibetsuGakuText6() {
                return this.controls.lblFuchoKibetsuGaku6().text;
            }

            public setFuchoKibetsuGakuText6(value) {
                this.controls.lblFuchoKibetsuGaku6().text = value;
            }

            public getFuchoKibetsuGakuText7() {
                return this.controls.lblFuchoKibetsuGaku7().text;
            }

            public setFuchoKibetsuGakuText7(value) {
                this.controls.lblFuchoKibetsuGaku7().text = value;
            }

            public getFuchoKibetsuGakuText8() {
                return this.controls.lblFuchoKibetsuGaku8().text;
            }

            public setFuchoKibetsuGakuText8(value) {
                this.controls.lblFuchoKibetsuGaku8().text = value;
            }

            public getFuchoKibetsuGakuText9() {
                return this.controls.lblFuchoKibetsuGaku9().text;
            }

            public setFuchoKibetsuGakuText9(value) {
                this.controls.lblFuchoKibetsuGaku9().text = value;
            }

            public getFuchoKibetsuGakuText10() {
                return this.controls.lblFuchoKibetsuGaku10().text;
            }

            public setFuchoKibetsuGakuText10(value) {
                this.controls.lblFuchoKibetsuGaku10().text = value;
            }

            public getFuchoKibetsuGakuText11() {
                return this.controls.lblFuchoKibetsuGaku11().text;
            }

            public setFuchoKibetsuGakuText11(value) {
                this.controls.lblFuchoKibetsuGaku11().text = value;
            }

            public getFuchoKibetsuGakuText12() {
                return this.controls.lblFuchoKibetsuGaku12().text;
            }

            public setFuchoKibetsuGakuText12(value) {
                this.controls.lblFuchoKibetsuGaku12().text = value;
            }

            public getFuchoKibetsuGakuText13() {
                return this.controls.lblFuchoKibetsuGaku13().text;
            }

            public setFuchoKibetsuGakuText13(value) {
                this.controls.lblFuchoKibetsuGaku13().text = value;
            }

            public getFuchoKibetsuGakuText14() {
                return this.controls.lblFuchoKibetsuGaku14().text;
            }

            public setFuchoKibetsuGakuText14(value) {
                this.controls.lblFuchoKibetsuGaku14().text = value;
            }

            public getFuchoKibetsuGakuVisible1() {
                return this.controls.lblFuchoKibetsuGaku1().visible;
            }

            public setFuchoKibetsuGakuVisible1(value) {
                this.controls.lblFuchoKibetsuGaku1().visible = value;
            }

            public getFuchoKibetsuGakuVisible2() {
                return this.controls.lblFuchoKibetsuGaku2().visible;
            }

            public setFuchoKibetsuGakuVisible2(value) {
                this.controls.lblFuchoKibetsuGaku2().visible = value;
            }

            public getFuchoKibetsuGakuVisible3() {
                return this.controls.lblFuchoKibetsuGaku3().visible;
            }

            public setFuchoKibetsuGakuVisible3(value) {
                this.controls.lblFuchoKibetsuGaku3().visible = value;
            }

            public getFuchoKibetsuGakuVisible4() {
                return this.controls.lblFuchoKibetsuGaku4().visible;
            }

            public setFuchoKibetsuGakuVisible4(value) {
                this.controls.lblFuchoKibetsuGaku4().visible = value;
            }

            public getFuchoKibetsuGakuVisible5() {
                return this.controls.lblFuchoKibetsuGaku5().visible;
            }

            public setFuchoKibetsuGakuVisible5(value) {
                this.controls.lblFuchoKibetsuGaku5().visible = value;
            }

            public getFuchoKibetsuGakuVisible6() {
                return this.controls.lblFuchoKibetsuGaku6().visible;
            }

            public setFuchoKibetsuGakuVisible6(value) {
                this.controls.lblFuchoKibetsuGaku6().visible = value;
            }

            public getFuchoKibetsuGakuVisible7() {
                return this.controls.lblFuchoKibetsuGaku7().visible;
            }

            public setFuchoKibetsuGakuVisible7(value) {
                this.controls.lblFuchoKibetsuGaku7().visible = value;
            }

            public getFuchoKibetsuGakuVisible8() {
                return this.controls.lblFuchoKibetsuGaku8().visible;
            }

            public setFuchoKibetsuGakuVisible8(value) {
                this.controls.lblFuchoKibetsuGaku8().visible = value;
            }

            public getFuchoKibetsuGakuVisible9() {
                return this.controls.lblFuchoKibetsuGaku9().visible;
            }

            public setFuchoKibetsuGakuVisible9(value) {
                this.controls.lblFuchoKibetsuGaku9().visible = value;
            }

            public getFuchoKibetsuGakuVisible10() {
                return this.controls.lblFuchoKibetsuGaku10().visible;
            }

            public setFuchoKibetsuGakuVisible10(value) {
                this.controls.lblFuchoKibetsuGaku10().visible = value;
            }

            public getFuchoKibetsuGakuVisible11() {
                return this.controls.lblFuchoKibetsuGaku11().visible;
            }

            public setFuchoKibetsuGakuVisible11(value) {
                this.controls.lblFuchoKibetsuGaku11().visible = value;
            }

            public getFuchoKibetsuGakuVisible12() {
                return this.controls.lblFuchoKibetsuGaku12().visible;
            }

            public setFuchoKibetsuGakuVisible12(value) {
                this.controls.lblFuchoKibetsuGaku12().visible = value;
            }

            public getFuchoKibetsuGakuVisible13() {
                return this.controls.lblFuchoKibetsuGaku13().visible;
            }

            public setFuchoKibetsuGakuVisible13(value) {
                this.controls.lblFuchoKibetsuGaku13().visible = value;
            }

            public getFuchoKibetsuGakuVisible14() {
                return this.controls.lblFuchoKibetsuGaku14().visible;
            }

            public setFuchoKibetsuGakuVisible14(value) {
                this.controls.lblFuchoKibetsuGaku14().visible = value;
            }

            public getFuchoNofuGakuText1() {
                return this.controls.lblFuchoNofuGaku1().text;
            }

            public setFuchoNofuGakuText1(value) {
                this.controls.lblFuchoNofuGaku1().text = value;
            }

            public getFuchoNofuGakuText2() {
                return this.controls.lblFuchoNofuGaku2().text;
            }

            public setFuchoNofuGakuText2(value) {
                this.controls.lblFuchoNofuGaku2().text = value;
            }

            public getFuchoNofuGakuText3() {
                return this.controls.lblFuchoNofuGaku3().text;
            }

            public setFuchoNofuGakuText3(value) {
                this.controls.lblFuchoNofuGaku3().text = value;
            }

            public getFuchoNofuGakuText4() {
                return this.controls.lblFuchoNofuGaku4().text;
            }

            public setFuchoNofuGakuText4(value) {
                this.controls.lblFuchoNofuGaku4().text = value;
            }

            public getFuchoNofuGakuText5() {
                return this.controls.lblFuchoNofuGaku5().text;
            }

            public setFuchoNofuGakuText5(value) {
                this.controls.lblFuchoNofuGaku5().text = value;
            }

            public getFuchoNofuGakuText6() {
                return this.controls.lblFuchoNofuGaku6().text;
            }

            public setFuchoNofuGakuText6(value) {
                this.controls.lblFuchoNofuGaku6().text = value;
            }

            public getFuchoNofuGakuText7() {
                return this.controls.lblFuchoNofuGaku7().text;
            }

            public setFuchoNofuGakuText7(value) {
                this.controls.lblFuchoNofuGaku7().text = value;
            }

            public getFuchoNofuGakuText8() {
                return this.controls.lblFuchoNofuGaku8().text;
            }

            public setFuchoNofuGakuText8(value) {
                this.controls.lblFuchoNofuGaku8().text = value;
            }

            public getFuchoNofuGakuText9() {
                return this.controls.lblFuchoNofuGaku9().text;
            }

            public setFuchoNofuGakuText9(value) {
                this.controls.lblFuchoNofuGaku9().text = value;
            }

            public getFuchoNofuGakuText10() {
                return this.controls.lblFuchoNofuGaku10().text;
            }

            public setFuchoNofuGakuText10(value) {
                this.controls.lblFuchoNofuGaku10().text = value;
            }

            public getFuchoNofuGakuText11() {
                return this.controls.lblFuchoNofuGaku11().text;
            }

            public setFuchoNofuGakuText11(value) {
                this.controls.lblFuchoNofuGaku11().text = value;
            }

            public getFuchoNofuGakuText12() {
                return this.controls.lblFuchoNofuGaku12().text;
            }

            public setFuchoNofuGakuText12(value) {
                this.controls.lblFuchoNofuGaku12().text = value;
            }

            public getFuchoNofuGakuText13() {
                return this.controls.lblFuchoNofuGaku13().text;
            }

            public setFuchoNofuGakuText13(value) {
                this.controls.lblFuchoNofuGaku13().text = value;
            }

            public getFuchoNofuGakuText14() {
                return this.controls.lblFuchoNofuGaku14().text;
            }

            public setFuchoNofuGakuText14(value) {
                this.controls.lblFuchoNofuGaku14().text = value;
            }

            public getFuchoNofuGakuVisible1() {
                return this.controls.lblFuchoNofuGaku1().visible;
            }

            public setFuchoNofuGakuVisible1(value) {
                this.controls.lblFuchoNofuGaku1().visible = value;
            }

            public getFuchoNofuGakuVisible2() {
                return this.controls.lblFuchoNofuGaku2().visible;
            }

            public setFuchoNofuGakuVisible2(value) {
                this.controls.lblFuchoNofuGaku2().visible = value;
            }

            public getFuchoNofuGakuVisible3() {
                return this.controls.lblFuchoNofuGaku3().visible;
            }

            public setFuchoNofuGakuVisible3(value) {
                this.controls.lblFuchoNofuGaku3().visible = value;
            }

            public getFuchoNofuGakuVisible4() {
                return this.controls.lblFuchoNofuGaku4().visible;
            }

            public setFuchoNofuGakuVisible4(value) {
                this.controls.lblFuchoNofuGaku4().visible = value;
            }

            public getFuchoNofuGakuVisible5() {
                return this.controls.lblFuchoNofuGaku5().visible;
            }

            public setFuchoNofuGakuVisible5(value) {
                this.controls.lblFuchoNofuGaku5().visible = value;
            }

            public getFuchoNofuGakuVisible6() {
                return this.controls.lblFuchoNofuGaku6().visible;
            }

            public setFuchoNofuGakuVisible6(value) {
                this.controls.lblFuchoNofuGaku6().visible = value;
            }

            public getFuchoNofuGakuVisible7() {
                return this.controls.lblFuchoNofuGaku7().visible;
            }

            public setFuchoNofuGakuVisible7(value) {
                this.controls.lblFuchoNofuGaku7().visible = value;
            }

            public getFuchoNofuGakuVisible8() {
                return this.controls.lblFuchoNofuGaku8().visible;
            }

            public setFuchoNofuGakuVisible8(value) {
                this.controls.lblFuchoNofuGaku8().visible = value;
            }

            public getFuchoNofuGakuVisible9() {
                return this.controls.lblFuchoNofuGaku9().visible;
            }

            public setFuchoNofuGakuVisible9(value) {
                this.controls.lblFuchoNofuGaku9().visible = value;
            }

            public getFuchoNofuGakuVisible10() {
                return this.controls.lblFuchoNofuGaku10().visible;
            }

            public setFuchoNofuGakuVisible10(value) {
                this.controls.lblFuchoNofuGaku10().visible = value;
            }

            public getFuchoNofuGakuVisible11() {
                return this.controls.lblFuchoNofuGaku11().visible;
            }

            public setFuchoNofuGakuVisible11(value) {
                this.controls.lblFuchoNofuGaku11().visible = value;
            }

            public getFuchoNofuGakuVisible12() {
                return this.controls.lblFuchoNofuGaku12().visible;
            }

            public setFuchoNofuGakuVisible12(value) {
                this.controls.lblFuchoNofuGaku12().visible = value;
            }

            public getFuchoNofuGakuVisible13() {
                return this.controls.lblFuchoNofuGaku13().visible;
            }

            public setFuchoNofuGakuVisible13(value) {
                this.controls.lblFuchoNofuGaku13().visible = value;
            }

            public getFuchoNofuGakuVisible14() {
                return this.controls.lblFuchoNofuGaku14().visible;
            }

            public setFuchoNofuGakuVisible14(value) {
                this.controls.lblFuchoNofuGaku14().visible = value;
            }

            public getTokuKibetsugakuKeiText() {
                return this.controls.lblTokuKibetsuGakuKei().text;
            }

            public setTokuKibetsugakuKeiText(value) {
                this.controls.lblTokuKibetsuGakuKei().text = value;
            }

            public getTokuKibetsugakuKeiVisible() {
                return this.controls.lblTokuKibetsuGakuKei().visible;
            }

            public setTokuKibetsugakuKeiVisible(value) {
                this.controls.lblTokuKibetsuGakuKei().visible = value;
            }

            public getTokuNofugakuKeiText() {
                return this.controls.lblTokuNofuGakuKei().text;
            }

            public setTokuNofugakuKeiText(value) {
                this.controls.lblTokuNofuGakuKei().text = value;
            }

            public getTokuNofugakuKeiVisible() {
                return this.controls.lblTokuNofuGakuKei().visible;
            }

            public setTokuNofugakuKeiVisible(value) {
                this.controls.lblTokuNofuGakuKei().visible = value;
            }

            public getFuchoKibetsugakuKeiText() {
                return this.controls.lblFuchoKibetsuGakuKei().text;
            }

            public setFuchoKibetsugakuKeiText(value) {
                this.controls.lblFuchoKibetsuGakuKei().text = value;
            }

            public getFuchoKibetsugakuKeiVisible() {
                return this.controls.lblFuchoKibetsuGakuKei().visible;
            }

            public setFuchoKibetsugakuKeiVisible(value) {
                this.controls.lblFuchoKibetsuGakuKei().visible = value;
            }

            public getFuchoNoufugakuKeiText() {
                return this.controls.lblFuchoNofuGakuKei().text;
            }

            public setFuchoNoufugakuKeiText(value) {
                this.controls.lblFuchoNofuGakuKei().text = value;
            }

            public getFuchoNofugakuKeiVisible() {
                return this.controls.lblFuchoNofuGakuKei().visible;
            }

            public setFuchoNofugakuKeiVisible(value) {
                this.controls.lblFuchoNofuGakuKei().visible = value;
            }

        }
    }
}




