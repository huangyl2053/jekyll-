/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />




module DBC {
    /**
     * 自動生成コードです。修正しないでください。
     */

    export module KyufuKanrihyoInfo {

        export class Events {


        }

        export class Controls {
            private _myName: string;

            public static get MyType(): string {
                return "KyufuKanrihyoInfo";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }


            public KyufuKanrihyoInfo() : UZA.Panel {

                return new UZA.Panel(this.convFiledNameSelf());

            }

            public txtSakuseiKubun() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtSakuseiKubun"));

            }

            public txtSakuseiYMD() : UZA.TextBoxDate {

                return new UZA.TextBoxDate(this.convFiledName("txtSakuseiYMD"));

            }

            public txtZengetsuNissu() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtZengetsuNissu"));

            }

            public txtKeikakuSakuseiKubun() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtKeikakuSakuseiKubun"));

            }

            public txtShienJigyoshaNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtShienJigyoshaNo"));

            }

            public txtShienJigyoshaName() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtShienJigyoshaName"));

            }

            public txtShikyuGendogaku() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtShikyuGendogaku"));

            }

            public txtGendogakuTekiyoKikan() : UZA.TextBoxDateRange {

                return new UZA.TextBoxDateRange(this.convFiledName("txtGendogakuTekiyoKikan"));

            }

            public txtShiteiServiceShokei() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtShiteiServiceShokei"));

            }

            public txtKijunServiceShokei() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtKijunServiceShokei"));

            }

            public txtGokeiTanisu() : UZA.TextBoxNum {

                return new UZA.TextBoxNum(this.convFiledName("txtGokeiTanisu"));

            }

            public dgMeisaiList() : UZA.DataGrid {

                return new UZA.DataGrid(this.convFiledName("dgMeisaiList"));

            }

            public txtTantoSenmonNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtTantoSenmonNo"));

            }

            public txtItakuJigyoshaNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtItakuJigyoshaNo"));

            }

            public txtItakuJigyoshaName() : UZA.TextBox {

                return new UZA.TextBox(this.convFiledName("txtItakuJigyoshaName"));

            }

            public txtItakuSenmonNo() : UZA.TextBoxCode {

                return new UZA.TextBoxCode(this.convFiledName("txtItakuSenmonNo"));

            }


            public convFiledNameSelf(): string {
                return this._myName + "_" + Controls.MyType;
            }

            private convFiledName(fieldName: string): string {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            }
        }
    }

    export class KyufuKanrihyoInfo_Design extends Uz.CommonChildDiv {
    
        public get ZengetsuNissuVisible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["visible"];
        }
        
        public set ZengetsuNissuVisible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[2]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get ShikyuGendogakuIsComma() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["isComma"];
        }
        
        public set ShikyuGendogakuIsComma(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"])["isComma"] = value;
            } else {
                this.layout.items[0].items[6]["isComma"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get GokeiTanisuLabelLText() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"])["labelLText"];
        }
        
        public set GokeiTanisuLabelLText(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"])["labelLText"] = value;
            } else {
                this.layout.items[0].items[10]["labelLText"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get GokeiTanisuIsComma() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"])["isComma"];
        }
        
        public set GokeiTanisuIsComma(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"])["isComma"] = value;
            } else {
                this.layout.items[0].items[10]["isComma"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get TantoSenmonNoVisible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"])["visible"];
        }
        
        public set TantoSenmonNoVisible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[12]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get TantoSenmonNoDisplayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"])["displayNone"];
        }
        
        public set TantoSenmonNoDisplayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[12]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get ItakuJigyoshaNoVisible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"])["visible"];
        }
        
        public set ItakuJigyoshaNoVisible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[13]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get ItakuJigyoshaNoDisplayNode() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"])["displayNone"];
        }
        
        public set ItakuJigyoshaNoDisplayNode(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[13]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get ItakuJigyoshaNameVisible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[14]["fieldName"])["visible"];
        }
        
        public set ItakuJigyoshaNameVisible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[14]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[14]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[14]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[14]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get ItakuJigyoshaNameDisplayNode() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[14]["fieldName"])["displayNone"];
        }
        
        public set ItakuJigyoshaNameDisplayNode(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[14]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[14]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[14]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[14]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get ItakuSenmonNoVisible() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"])["visible"];
        }
        
        public set ItakuSenmonNoVisible(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"])["visible"] = value;
            } else {
                this.layout.items[0].items[15]["visible"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get ItakuSenmonNoDisplayNone() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"])["displayNone"];
        }
        
        public set ItakuSenmonNoDisplayNone(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"])["displayNone"] = value;
            } else {
                this.layout.items[0].items[15]["displayNone"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get MeisaiListGridSetting() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["gridSetting"];
        }
        
        public set MeisaiListGridSetting(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["gridSetting"] = value;
            } else {
                this.layout.items[0].items[11]["gridSetting"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get MeisaiListHeight() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["height"];
        }
        
        public set MeisaiListHeight(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["height"] = value;
            } else {
                this.layout.items[0].items[11]["height"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get MeisaiListOnSort() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["onSort"];
        }
        
        public set MeisaiListOnSort(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["onSort"] = value;
            } else {
                this.layout.items[0].items[11]["onSort"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get MeisaiListOnSelect() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["onSelect"];
        }
        
        public set MeisaiListOnSelect(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["onSelect"] = value;
            } else {
                this.layout.items[0].items[11]["onSelect"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get MeisaiListOnSelectByDblClick() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["onSelectByDblClick"];
        }
        
        public set MeisaiListOnSelectByDblClick(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["onSelectByDblClick"] = value;
            } else {
                this.layout.items[0].items[11]["onSelectByDblClick"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get MeisaiListOnSelectBySelectButton() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["onSelectBySelectButton"];
        }
        
        public set MeisaiListOnSelectBySelectButton(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["onSelectBySelectButton"] = value;
            } else {
                this.layout.items[0].items[11]["onSelectBySelectButton"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get MeisaiListOnSelectbyModifyButton() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["onSelectByModifyButton"];
        }
        
        public set MeisaiListOnSelectbyModifyButton(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["onSelectByModifyButton"] = value;
            } else {
                this.layout.items[0].items[11]["onSelectByModifyButton"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get MeisaiListOnSelectByDeleteButton() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["onSelectByDeleteButton"];
        }
        
        public set MeisaiListOnSelectByDeleteButton(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"])["onSelectByDeleteButton"] = value;
            } else {
                this.layout.items[0].items[11]["onSelectByDeleteButton"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, KyufuKanrihyoInfo_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("ZengetsuNissuVisible");
            Uz.JSControlUtil.registProperty("ShikyuGendogakuIsComma");
            Uz.JSControlUtil.registProperty("GokeiTanisuLabelLText");
            Uz.JSControlUtil.registProperty("GokeiTanisuIsComma");
            Uz.JSControlUtil.registProperty("TantoSenmonNoVisible");
            Uz.JSControlUtil.registProperty("TantoSenmonNoDisplayNone");
            Uz.JSControlUtil.registProperty("ItakuJigyoshaNoVisible");
            Uz.JSControlUtil.registProperty("ItakuJigyoshaNoDisplayNode");
            Uz.JSControlUtil.registProperty("ItakuJigyoshaNameVisible");
            Uz.JSControlUtil.registProperty("ItakuJigyoshaNameDisplayNode");
            Uz.JSControlUtil.registProperty("ItakuSenmonNoVisible");
            Uz.JSControlUtil.registProperty("ItakuSenmonNoDisplayNone");
            Uz.JSControlUtil.registProperty("MeisaiListGridSetting");
            Uz.JSControlUtil.registProperty("MeisaiListHeight");
            Uz.JSControlUtil.registProperty("MeisaiListOnSort");
            Uz.JSControlUtil.registProperty("MeisaiListOnSelect");
            Uz.JSControlUtil.registProperty("MeisaiListOnSelectByDblClick");
            Uz.JSControlUtil.registProperty("MeisaiListOnSelectBySelectButton");
            Uz.JSControlUtil.registProperty("MeisaiListOnSelectbyModifyButton");
            Uz.JSControlUtil.registProperty("MeisaiListOnSelectByDeleteButton");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["ZengetsuNissuVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[2]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["ShikyuGendogakuIsComma"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[6]["fieldName"]).getEditablePropertyInfo()["isComma"];
            editablePropertyInfo["GokeiTanisuLabelLText"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"]).getEditablePropertyInfo()["labelLText"];
            editablePropertyInfo["GokeiTanisuIsComma"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[10]["fieldName"]).getEditablePropertyInfo()["isComma"];
            editablePropertyInfo["TantoSenmonNoVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["TantoSenmonNoDisplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[12]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["ItakuJigyoshaNoVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["ItakuJigyoshaNoDisplayNode"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[13]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["ItakuJigyoshaNameVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[14]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["ItakuJigyoshaNameDisplayNode"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[14]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["ItakuSenmonNoVisible"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"]).getEditablePropertyInfo()["visible"];
            editablePropertyInfo["ItakuSenmonNoDisplayNone"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"]).getEditablePropertyInfo()["displayNone"];
            editablePropertyInfo["MeisaiListGridSetting"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).getEditablePropertyInfo()["gridSetting"];
            editablePropertyInfo["MeisaiListHeight"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).getEditablePropertyInfo()["height"];
            editablePropertyInfo["MeisaiListOnSort"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).getEditablePropertyInfo()["onSort"];
            editablePropertyInfo["MeisaiListOnSelect"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).getEditablePropertyInfo()["onSelect"];
            editablePropertyInfo["MeisaiListOnSelectByDblClick"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).getEditablePropertyInfo()["onSelectByDblClick"];
            editablePropertyInfo["MeisaiListOnSelectBySelectButton"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).getEditablePropertyInfo()["onSelectBySelectButton"];
            editablePropertyInfo["MeisaiListOnSelectbyModifyButton"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).getEditablePropertyInfo()["onSelectByModifyButton"];
            editablePropertyInfo["MeisaiListOnSelectByDeleteButton"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[11]["fieldName"]).getEditablePropertyInfo()["onSelectByDeleteButton"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "KyufuKanrihyoInfo",
   "items": [
    {
     "fieldName": "txtSakuseiKubun",
     "items": [],
     "controlType": "TextBox",
     "width": "80",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtSakuseiKubun_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "作成区分",
     "labelRText": "",
     "labelLWidth": "158",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtSakuseiYMD",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "80",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtSakuseiYMD_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "value": "",
     "labelLText": "作成日",
     "labelRText": "",
     "labelLWidth": "120",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "permitCharactor": "./_-"
    },
    {
     "fieldName": "txtZengetsuNissu",
     "items": [],
     "controlType": "TextBoxNum",
     "width": "50",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtZengetsuNissu_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 2,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "前月までの給付計画日数",
     "labelRText": "",
     "labelLWidth": "180",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "maxValue": 1.7976931348623157e+308,
     "minValue": 0,
     "isCurrency": false,
     "isComma": false,
     "decimalPointLength": 0,
     "permitCharactor": "+-,.\\"
    },
    {
     "fieldName": "txtKeikakuSakuseiKubun",
     "items": [],
     "controlType": "TextBox",
     "width": "80",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": true,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtKeikakuSakuseiKubun_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "計画作成区分",
     "labelRText": "",
     "labelLWidth": "158",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtShienJigyoshaNo",
     "items": [],
     "controlType": "TextBoxCode",
     "width": "80",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtShienJigyoshaNo_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "支援事業者",
     "labelRText": "",
     "labelLWidth": "120",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": "",
     "formatLength": "10"
    },
    {
     "fieldName": "txtShienJigyoshaName",
     "items": [],
     "controlType": "TextBox",
     "width": "500",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtShienJigyoshaName_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtShikyuGendogaku",
     "items": [],
     "controlType": "TextBoxNum",
     "width": "80",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": true,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtShikyuGendogaku_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 2,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "支給限度額",
     "labelRText": "",
     "labelLWidth": "158",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "maxValue": 1.7976931348623157e+308,
     "minValue": 0,
     "isCurrency": false,
     "isComma": true,
     "decimalPointLength": 0,
     "permitCharactor": "+-,.\\"
    },
    {
     "fieldName": "txtGendogakuTekiyoKikan",
     "items": [],
     "controlType": "TextBoxDateRange",
     "width": "60",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtGendogakuTekiyoKikan_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "isPrivateInfo": false,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "labelLText": "限度額適用期間",
     "labelRText": "",
     "labelLWidth": "120",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 1,
     "displayFormat": 0,
     "permitCharactor": "",
     "fromPlaceHolder": "",
     "toPlaceHolder": "",
     "minDate": "",
     "maxDate": "",
     "fromText": "",
     "toText": "",
     "fromValue": "",
     "toValue": "",
     "fromSelectControlID": "txtGendogakuTekiyoKikanFrom",
     "toSelectControlID": "txtGendogakuTekiyoKikanTo"
    },
    {
     "fieldName": "txtShiteiServiceShokei",
     "items": [],
     "controlType": "TextBoxNum",
     "width": "80",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": true,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtShiteiServiceShokei_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 2,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "指定サービス分小計",
     "labelRText": "",
     "labelLWidth": "158",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "maxValue": 1.7976931348623157e+308,
     "minValue": 0,
     "isCurrency": false,
     "isComma": true,
     "decimalPointLength": 0,
     "permitCharactor": "+-,.\\"
    },
    {
     "fieldName": "txtKijunServiceShokei",
     "items": [],
     "controlType": "TextBoxNum",
     "width": "80",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtKijunServiceShokei_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 2,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "基準該当等サービス分小計",
     "labelRText": "",
     "labelLWidth": "200",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "maxValue": 1.7976931348623157e+308,
     "minValue": 0,
     "isCurrency": false,
     "isComma": true,
     "decimalPointLength": 0,
     "permitCharactor": "+-,.\\"
    },
    {
     "fieldName": "txtGokeiTanisu",
     "items": [],
     "controlType": "TextBoxNum",
     "width": "80",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtGokeiTanisu_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 2,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "給付計画合計単位数",
     "labelRText": "",
     "labelLWidth": "150",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "maxValue": 1.7976931348623157e+308,
     "minValue": 0,
     "isCurrency": false,
     "isComma": true,
     "decimalPointLength": 0,
     "permitCharactor": "+-,.\\"
    },
    {
     "fieldName": "dgMeisaiList",
     "items": [],
     "controlType": "DataGrid",
     "width": "1080",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": true,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "dgMeisaiList",
     "helpMessageID": "",
     "jpControlName": "",
     "height": "175",
     "gridSetting": {
      "rowHeight": 25,
      "isMultiSelectable": false,
      "isShowHeader": true,
      "isShowFooter": true,
      "isShowFilter": false,
      "isShowFilterButton": false,
      "isShowRowState": false,
      "isShowSelectButtonColumn": false,
      "isShowModifyButtonColumn": false,
      "isShowDeleteButtonColumn": false,
      "limitRowCount": 0,
      "selectedRowCount": 0,
      "header": {
       "combineColumns": [],
       "frozenColumn": "",
       "headerHeight": 0
      },
      "columns": [
       {
        "columnName": "明細",
        "dataName": "txtNo",
        "toolTip": "",
        "bgColor": 0,
        "width": 60,
        "visible": true,
        "cellType": 0,
        "cellDetails": null,
        "align": 1,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtNo"
       },
       {
        "columnName": "サービス種類",
        "dataName": "txtServiceShurui",
        "toolTip": "",
        "bgColor": 0,
        "width": 170,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtServiceShurui"
       },
       {
        "columnName": "計画単位数",
        "dataName": "txtTanisu",
        "toolTip": "",
        "bgColor": 0,
        "width": 110,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 2,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtTanisu"
       },
       {
        "columnName": "サービス事業者",
        "dataName": "txtJigyosha",
        "toolTip": "",
        "bgColor": 0,
        "width": 450,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtJigyosha"
       },
       {
        "columnName": "事業者区分",
        "dataName": "txtJigyoshaKubun",
        "toolTip": "",
        "bgColor": 0,
        "width": 270,
        "visible": true,
        "cellType": 0,
        "cellDetails": {
         "cellType": 0
        },
        "align": 0,
        "resize": true,
        "isPrivateInfo": false,
        "sortKey": "txtJigyoshaKubun"
       }
      ]
     },
     "onSort": "",
     "onSelect": "",
     "onSelectByDblClick": "",
     "onSelectBySelectButton": "",
     "onSelectByModifyButton": "",
     "onSelectByDeleteButton": "",
     "onOnlyRow": "",
     "onNoRow": "",
     "onMultiRows": "",
     "dataSource": [],
     "sortOrder": "txtJigyoshaKubun",
     "isAscending": true,
     "filterList": [],
     "activeRowId": -1
    },
    {
     "fieldName": "txtTantoSenmonNo",
     "items": [],
     "controlType": "TextBoxCode",
     "width": "65",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": true,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtTantoSenmonNo_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "担当介護支援専門員番号",
     "labelRText": "",
     "labelLWidth": "267",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": "",
     "formatLength": "8"
    },
    {
     "fieldName": "txtItakuJigyoshaNo",
     "items": [],
     "controlType": "TextBoxCode",
     "width": "80",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": true,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtItakuJigyoshaNo_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "委託先の居宅介護支援事業者",
     "labelRText": "",
     "labelLWidth": "267",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": "",
     "formatLength": "10"
    },
    {
     "fieldName": "txtItakuJigyoshaName",
     "items": [],
     "controlType": "TextBox",
     "width": "500",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtItakuJigyoshaName_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 0,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": ""
    },
    {
     "fieldName": "txtItakuSenmonNo",
     "items": [],
     "controlType": "TextBoxCode",
     "width": "65",
     "visible": true,
     "displayNone": false,
     "disabled": false,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": true,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "selectControlID": "txtItakuSenmonNo_core",
     "helpMessageID": "",
     "jpControlName": "",
     "readOnly": true,
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "placeHolder": "",
     "textKind": 2,
     "isPrivateInfo": false,
     "isPassword": false,
     "isComboBox": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "text": "",
     "suggest": [],
     "value": "",
     "labelLText": "委託先の居宅介護支援専門員番号",
     "labelRText": "",
     "labelLWidth": "267",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "decorationClass": "",
     "permitCharactor": "",
     "formatLength": "8"
    }
   ],
   "controlType": "Panel",
   "width": "G2",
   "visible": true,
   "displayNone": false,
   "disabled": false,
   "accessKey": "",
   "nextFocusFieldName": "",
   "wrap": false,
   "dependencies": [],
   "float": 0,
   "toolTip": "",
   "authorityMode": 0,
   "marginLeft": "XS",
   "marginRight": "XS",
   "selectControlID": "KyufuKanrihyoInfo",
   "helpMessageID": "",
   "jpControlName": "",
   "onLoad": "",
   "title": "",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "KyufuKanrihyoInfo"
    }
   ],
   "requestSettings": [],
   "hiddenInput": [],
   "onOpen": "",
   "onClose": "",
   "session": {},
   "eraseBorderTop": true,
   "eraseBorderBottom": true,
   "eraseBorderRight": true,
   "eraseBorderLeft": true,
   "backgroundColor": 0,
   "widthAuto": true,
   "panelDisplay": 0,
   "isGroupBox": false,
   "readOnly": false,
   "height": "Auto"
  }
 ],
 "controlType": "CommonChildDiv",
 "width": "XS",
 "visible": true,
 "displayNone": false,
 "disabled": false,
 "accessKey": "",
 "nextFocusFieldName": "",
 "wrap": false,
 "dependencies": [],
 "float": 0,
 "toolTip": "",
 "authorityMode": 0,
 "marginLeft": "0",
 "marginRight": "0",
 "selectControlID": "defaultLayout",
 "helpMessageID": "",
 "jpControlName": "",
 "relation": [],
 "businessId": "DBC",
 "controlName": "KyufuKanrihyoInfo",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "txtZengetsuNissu",
   "publicChildProperty": "visible",
   "newPropertyName": "ZengetsuNissuVisible"
  },
  {
   "publicChildFieldName": "txtShikyuGendogaku",
   "publicChildProperty": "isComma",
   "newPropertyName": "ShikyuGendogakuIsComma"
  },
  {
   "publicChildFieldName": "txtGokeiTanisu",
   "publicChildProperty": "labelLText",
   "newPropertyName": "GokeiTanisuLabelLText"
  },
  {
   "publicChildFieldName": "txtGokeiTanisu",
   "publicChildProperty": "isComma",
   "newPropertyName": "GokeiTanisuIsComma"
  },
  {
   "publicChildFieldName": "txtTantoSenmonNo",
   "publicChildProperty": "visible",
   "newPropertyName": "TantoSenmonNoVisible"
  },
  {
   "publicChildFieldName": "txtTantoSenmonNo",
   "publicChildProperty": "displayNone",
   "newPropertyName": "TantoSenmonNoDisplayNone"
  },
  {
   "publicChildFieldName": "txtItakuJigyoshaNo",
   "publicChildProperty": "visible",
   "newPropertyName": "ItakuJigyoshaNoVisible"
  },
  {
   "publicChildFieldName": "txtItakuJigyoshaNo",
   "publicChildProperty": "displayNone",
   "newPropertyName": "ItakuJigyoshaNoDisplayNode"
  },
  {
   "publicChildFieldName": "txtItakuJigyoshaName",
   "publicChildProperty": "visible",
   "newPropertyName": "ItakuJigyoshaNameVisible"
  },
  {
   "publicChildFieldName": "txtItakuJigyoshaName",
   "publicChildProperty": "displayNone",
   "newPropertyName": "ItakuJigyoshaNameDisplayNode"
  },
  {
   "publicChildFieldName": "txtItakuSenmonNo",
   "publicChildProperty": "visible",
   "newPropertyName": "ItakuSenmonNoVisible"
  },
  {
   "publicChildFieldName": "txtItakuSenmonNo",
   "publicChildProperty": "displayNone",
   "newPropertyName": "ItakuSenmonNoDisplayNone"
  },
  {
   "publicChildFieldName": "dgMeisaiList",
   "publicChildProperty": "gridSetting",
   "newPropertyName": "MeisaiListGridSetting"
  },
  {
   "publicChildFieldName": "dgMeisaiList",
   "publicChildProperty": "height",
   "newPropertyName": "MeisaiListHeight"
  },
  {
   "publicChildFieldName": "dgMeisaiList",
   "publicChildProperty": "onSort",
   "newPropertyName": "MeisaiListOnSort"
  },
  {
   "publicChildFieldName": "dgMeisaiList",
   "publicChildProperty": "onSelect",
   "newPropertyName": "MeisaiListOnSelect"
  },
  {
   "publicChildFieldName": "dgMeisaiList",
   "publicChildProperty": "onSelectByDblClick",
   "newPropertyName": "MeisaiListOnSelectByDblClick"
  },
  {
   "publicChildFieldName": "dgMeisaiList",
   "publicChildProperty": "onSelectBySelectButton",
   "newPropertyName": "MeisaiListOnSelectBySelectButton"
  },
  {
   "publicChildFieldName": "dgMeisaiList",
   "publicChildProperty": "onSelectByModifyButton",
   "newPropertyName": "MeisaiListOnSelectbyModifyButton"
  },
  {
   "publicChildFieldName": "dgMeisaiList",
   "publicChildProperty": "onSelectByDeleteButton",
   "newPropertyName": "MeisaiListOnSelectByDeleteButton"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

