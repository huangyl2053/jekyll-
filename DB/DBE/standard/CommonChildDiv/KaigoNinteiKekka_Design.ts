/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBE {
    /**
     * 自動生成コードです。修正しないでください。
     * KaigoNinteiKekkaクラスのみで継承して使えます。
     */
    export class KaigoNinteiKekka_Design extends Uz.CommonChildDiv {
    
        public get selectDdlNijiHantei() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"])["onChange"];
        }
        
        public set selectDdlNijiHantei(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"])["onChange"] = value;
            } else {
                this.layout.items[0].items[15]["onChange"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get selectDdlNinteiYukoTsukisu() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[22]["fieldName"])["onChange"];
        }
        
        public set selectDdlNinteiYukoTsukisu(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[22]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[22]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[22]["fieldName"])["onChange"] = value;
            } else {
                this.layout.items[0].items[22]["onChange"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get selectDdlNinteiKubun() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["onChange"];
        }
        
        public set selectDdlNinteiKubun(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"])["onChange"] = value;
            } else {
                this.layout.items[0].items[7]["onChange"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, KaigoNinteiKekka_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("selectDdlNijiHantei");
            Uz.JSControlUtil.registProperty("selectDdlNinteiYukoTsukisu");
            Uz.JSControlUtil.registProperty("selectDdlNinteiKubun");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["selectDdlNijiHantei"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[15]["fieldName"]).getEditablePropertyInfo()["onChange"];
            editablePropertyInfo["selectDdlNinteiYukoTsukisu"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[22]["fieldName"]).getEditablePropertyInfo()["onChange"];
            editablePropertyInfo["selectDdlNinteiKubun"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"] + "_" + this.layout.items[0].items[7]["fieldName"]).getEditablePropertyInfo()["onChange"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "KaigoNinteiKekka",
   "items": [
    {
     "fieldName": "lblShinseibi",
     "items": [],
     "controlType": "Label",
     "width": "100",
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
     "required": false,
     "align": 2,
     "text": "申請日",
     "isPrivateInfo": false
    },
    {
     "fieldName": "txtShinseibi",
     "items": [],
     "controlType": "TextBoxFlexibleDate",
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
     "required": false,
     "text": "",
     "isPrivateInfo": false,
     "readOnly": true,
     "placeHolder": "",
     "textKind": 0,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "value": ""
    },
    {
     "fieldName": "lblShinseiKubunShinsei",
     "items": [],
     "controlType": "Label",
     "width": "175",
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
     "required": false,
     "align": 2,
     "text": "申請区分（申請時）",
     "isPrivateInfo": false
    },
    {
     "fieldName": "txtShinseiKubunShinsei",
     "items": [],
     "controlType": "TextBox",
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
     "required": false,
     "text": "",
     "isPrivateInfo": false,
     "readOnly": true,
     "placeHolder": "区分変更",
     "textKind": 0,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "180",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "value": "",
     "maxLength": 1000000000000,
     "minLength": 0,
     "textAlign": 0,
     "isComboBox": false,
     "suggest": []
    },
    {
     "fieldName": "lblShinseiKubun",
     "items": [],
     "controlType": "Label",
     "width": "138",
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
     "required": false,
     "align": 2,
     "text": "申請区分（法令）",
     "isPrivateInfo": false
    },
    {
     "fieldName": "txtShinseiKubunHorei",
     "items": [],
     "controlType": "TextBox",
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
     "required": false,
     "text": "",
     "isPrivateInfo": false,
     "readOnly": true,
     "placeHolder": "",
     "textKind": 0,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "138",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "value": "",
     "maxLength": 1000000000000,
     "minLength": 0,
     "textAlign": 0,
     "isComboBox": false,
     "suggest": []
    },
    {
     "fieldName": "lblNinteiKubun",
     "items": [],
     "controlType": "Label",
     "width": "100",
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
     "required": false,
     "align": 2,
     "text": "認定区分",
     "isPrivateInfo": false
    },
    {
     "fieldName": "ddlNinteiKubun",
     "items": [],
     "controlType": "DropDownList",
     "width": "75",
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
     "required": false,
     "text": "",
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "01",
     "dataSource": [
      {
       "key": "01",
       "value": "認定"
      },
      {
       "key": "02",
       "value": "再調査"
      },
      {
       "key": "03",
       "value": "再審査"
      },
      {
       "key": "09",
       "value": "却下"
      },
      {
       "key": "11",
       "value": "区却"
      }
     ]
    },
    {
     "fieldName": "lblIchijiHantei",
     "items": [],
     "controlType": "Label",
     "width": "182",
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
     "required": false,
     "align": 2,
     "text": "一次判定結果",
     "isPrivateInfo": false
    },
    {
     "fieldName": "txtIchijiHanteiKekka",
     "items": [],
     "controlType": "TextBox",
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
     "required": false,
     "text": "",
     "isPrivateInfo": false,
     "readOnly": true,
     "placeHolder": "要介護５",
     "textKind": 0,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "185",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "value": "",
     "maxLength": 1000000000000,
     "minLength": 0,
     "textAlign": 0,
     "isComboBox": false,
     "suggest": []
    },
    {
     "fieldName": "lblTokuteiShippei",
     "items": [],
     "controlType": "Label",
     "width": "138",
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
     "required": false,
     "align": 2,
     "text": "特定疾病",
     "isPrivateInfo": false
    },
    {
     "fieldName": "ddlTokuteiShippei",
     "items": [],
     "controlType": "DropDownList",
     "width": "M",
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
     "required": false,
     "text": "",
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "140",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "",
     "dataSource": [
      {
       "key": "",
       "value": ""
      },
      {
       "key": "01",
       "value": "筋萎縮性側索硬化症"
      },
      {
       "key": "02",
       "value": "後縦靭帯骨化症"
      }
     ]
    },
    {
     "fieldName": "lblNinteibi",
     "items": [],
     "controlType": "Label",
     "width": "100",
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
     "required": false,
     "align": 2,
     "text": "認定日",
     "isPrivateInfo": false
    },
    {
     "fieldName": "txtNinteibi",
     "items": [],
     "controlType": "TextBoxFlexibleDate",
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
     "required": false,
     "text": "",
     "isPrivateInfo": false,
     "readOnly": false,
     "placeHolder": "",
     "textKind": 0,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "value": "",
     "maxLength": 1000000000000,
     "minLength": 0,
     "textAlign": 0,
     "suggest": []
    },
    {
     "fieldName": "lblNijiHantei",
     "items": [],
     "controlType": "Label",
     "width": "175",
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
     "required": false,
     "align": 2,
     "text": "二次判定結果",
     "isPrivateInfo": false
    },
    {
     "fieldName": "ddlNijiHanteiKekka",
     "items": [],
     "controlType": "DropDownList",
     "width": "85",
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
     "required": true,
     "text": "",
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "178",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "01",
     "dataSource": [
      {
       "key": "01",
       "value": ""
      },
      {
       "key": "12",
       "value": "要支援１"
      },
      {
       "key": "13",
       "value": "要支援２"
      },
      {
       "key": "21",
       "value": "要介護１"
      },
      {
       "key": "22",
       "value": "要介護２"
      },
      {
       "key": "23",
       "value": "要介護３"
      },
      {
       "key": "24",
       "value": "要介護４"
      },
      {
       "key": "25",
       "value": "要介護５"
      },
      {
       "key": "31",
       "value": "非該当"
      }
     ]
    },
    {
     "fieldName": "lblJotaizoRei",
     "items": [],
     "controlType": "Label",
     "width": "115",
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
     "required": false,
     "align": 2,
     "text": "状態像例",
     "isPrivateInfo": false
    },
    {
     "fieldName": "ddlJotaiZo",
     "items": [],
     "controlType": "DropDownList",
     "width": "M",
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
     "required": false,
     "text": "",
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "117",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "",
     "dataSource": [
      {
       "key": "",
       "value": ""
      },
      {
       "key": "01",
       "value": "01:認知機能の低下等"
      },
      {
       "key": "02",
       "value": "02:不安定な状態"
      }
     ]
    },
    {
     "fieldName": "lblNinteiKikan",
     "items": [],
     "controlType": "Label",
     "width": "100",
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
     "required": false,
     "align": 2,
     "text": "認定期間",
     "isPrivateInfo": false
    },
    {
     "fieldName": "txtNinteiYukoKikanStart",
     "items": [],
     "controlType": "TextBoxFlexibleDate",
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
     "required": false,
     "text": "",
     "isPrivateInfo": false,
     "readOnly": false,
     "placeHolder": "",
     "textKind": 0,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "value": "",
     "maxLength": 1000000000000,
     "minLength": 0,
     "textAlign": 0,
     "suggest": []
    },
    {
     "fieldName": "lblKara3",
     "items": [],
     "controlType": "Label",
     "width": "20",
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
     "required": false,
     "align": 1,
     "text": "～",
     "isPrivateInfo": false
    },
    {
     "fieldName": "txtNinteiYukoKikanEnd",
     "items": [],
     "controlType": "TextBoxFlexibleDate",
     "width": "80",
     "visible": true,
     "displayNone": false,
     "disabled": true,
     "accessKey": "",
     "nextFocusFieldName": "",
     "wrap": false,
     "dependencies": [],
     "float": 0,
     "toolTip": "",
     "authorityMode": 0,
     "marginLeft": "XS",
     "marginRight": "XS",
     "required": false,
     "text": "",
     "isPrivateInfo": false,
     "readOnly": true,
     "placeHolder": "",
     "textKind": 0,
     "isPassword": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "ymdKubun": 2,
     "displayFormat": 0,
     "value": "",
     "maxLength": 1000000000000,
     "minLength": 0,
     "textAlign": 0,
     "suggest": []
    },
    {
     "fieldName": "ddlNinteiYukoTsukisu",
     "items": [],
     "controlType": "DropDownList",
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
     "marginLeft": "0",
     "marginRight": "0",
     "required": true,
     "text": "",
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "",
     "labelRText": "ヶ月",
     "labelLWidth": "2",
     "labelRWidth": "40",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "24",
     "dataSource": [
      {
       "key": "24",
       "value": "２４"
      },
      {
       "key": "12",
       "value": "１２"
      },
      {
       "key": "06",
       "value": "６"
      },
      {
       "key": "01",
       "value": "１"
      }
     ]
    },
    {
     "fieldName": "lblShinsakaiIken",
     "items": [],
     "controlType": "Label",
     "width": "100",
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
     "marginRight": "14",
     "required": false,
     "align": 2,
     "text": "■審査会意見",
     "isPrivateInfo": false
    },
    {
     "fieldName": "btnShinsaIkenTeikei",
     "items": [],
     "controlType": "ButtonDialog",
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
     "text": "定型文",
     "onClick": "",
     "appearance": 0,
     "imageFileUrl": "",
     "imageWidth": "",
     "imageHeight": "",
     "displayChildDivName": "",
     "dataPassing": [],
     "visibleCloseButton": true,
     "onOkClose": "",
     "onBeforeOpenDialog": ""
    },
    {
     "fieldName": "lblShinsakaiMemo",
     "items": [],
     "controlType": "Label",
     "width": "100",
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
     "marginLeft": "1.5",
     "marginRight": "15",
     "required": false,
     "align": 2,
     "text": "■審査会メモ",
     "isPrivateInfo": false
    },
    {
     "fieldName": "txtShinsakaiIken",
     "items": [],
     "controlType": "TextBoxMultiLine",
     "width": "410",
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
     "marginLeft": "0.5",
     "marginRight": "XS",
     "required": false,
     "text": "",
     "isPrivateInfo": false,
     "readOnly": false,
     "placeHolder": "",
     "textKind": 0,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "value": "",
     "maxLength": "200",
     "minLength": 0,
     "height": "40",
     "limitLength": "200",
     "countDisp": false
    },
    {
     "fieldName": "txtShinsakaiMemo",
     "items": [],
     "controlType": "TextBoxMultiLine",
     "width": "415",
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
     "required": false,
     "text": "",
     "isPrivateInfo": false,
     "readOnly": false,
     "placeHolder": "",
     "textKind": 0,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "onKeyPress": "",
     "labelLText": "",
     "labelRText": "",
     "labelLWidth": "S",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "value": "",
     "maxLength": 100000000,
     "minLength": 0,
     "height": "40",
     "limitLength": "200",
     "countDisp": false
    }
   ],
   "controlType": "Panel",
   "width": "880",
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
   "onLoad": "",
   "title": "認定結果",
   "marginTop": "XS",
   "marginBottom": "XS",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "NinteiKekkaNyuryoku"
    }
   ],
   "requestSettings": [
    {
     "eventName": "onLoad",
     "requestUrl": ""
    }
   ],
   "hiddenInput": [],
   "onOpen": "",
   "onClose": "",
   "session": {},
   "eraseBorderTop": false,
   "eraseBorderBottom": false,
   "eraseBorderRight": false,
   "eraseBorderLeft": false,
   "backgroundColor": 0,
   "widthAuto": false,
   "isGroupBox": false
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
 "marginLeft": 0,
 "marginRight": 0,
 "relation": [],
 "businessId": "DBE",
 "controlName": "KaigoNinteiKekka",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "ddlNijiHanteiKekka",
   "publicChildProperty": "onChange",
   "newPropertyName": "selectDdlNijiHantei"
  },
  {
   "publicChildFieldName": "ddlNinteiYukoTsukisu",
   "publicChildProperty": "onChange",
   "newPropertyName": "selectDdlNinteiYukoTsukisu"
  },
  {
   "publicChildFieldName": "ddlNinteiKubun",
   "publicChildProperty": "onChange",
   "newPropertyName": "selectDdlNinteiKubun"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

