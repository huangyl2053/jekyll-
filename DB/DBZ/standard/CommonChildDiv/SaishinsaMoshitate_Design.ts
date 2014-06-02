/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />

module DBZ {
    /**
     * 自動生成コードです。修正しないでください。
     * SaishinsaMoshitateクラスのみで継承して使えます。
     */
    export class SaishinsaMoshitate_Design extends Uz.CommonChildDiv {
    
        public get title() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["title"];
        }
        
        public set title(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["title"] = value;
            } else {
                this.layout.items[0]["title"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get eraseBorderTop() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderTop"];
        }
        
        public set eraseBorderTop(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderTop"] = value;
            } else {
                this.layout.items[0]["eraseBorderTop"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get eraseBorderBottom() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderBottom"];
        }
        
        public set eraseBorderBottom(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderBottom"] = value;
            } else {
                this.layout.items[0]["eraseBorderBottom"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get eraseBorderRight() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderRight"];
        }
        
        public set eraseBorderRight(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderRight"] = value;
            } else {
                this.layout.items[0]["eraseBorderRight"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get eraseBorderLeft() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderLeft"];
        }
        
        public set eraseBorderLeft(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["eraseBorderLeft"] = value;
            } else {
                this.layout.items[0]["eraseBorderLeft"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        public get isGroupBox() {
            return Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["isGroupBox"];
        }
        
        public set isGroupBox(value) {
            if ( $("#" + this.fieldName + "_" + this.layout.items[0]["fieldName"]).length > 0 && 
                 Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]) != undefined ) {
                Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"])["isGroupBox"] = value;
            } else {
                this.layout.items[0]["isGroupBox"] = value;
                this.raisePropertyChanged(this.layout);
            }
        }
        
        constructor($parentElement: JQuery, isDesignMode: bool, fieldName: string) {
            super($parentElement, isDesignMode, SaishinsaMoshitate_Design.myLayout, fieldName);
        }
        
        /**
         * レイアウト情報のプロパティを登録します
         * @method registProperty
         */
        public registProperty() {
            super.registProperty();
            Uz.JSControlUtil.registProperty("title");
            Uz.JSControlUtil.registProperty("eraseBorderTop");
            Uz.JSControlUtil.registProperty("eraseBorderBottom");
            Uz.JSControlUtil.registProperty("eraseBorderRight");
            Uz.JSControlUtil.registProperty("eraseBorderLeft");
            Uz.JSControlUtil.registProperty("isGroupBox");
        }
        
        /**
         * コントロール内で編集させたいプロパティをまとめたEditablePropertyInfoオブジェクトを返却します。
         * @method getEditableProperty
         * @return EditablePropertyInfoオブジェクト
         */
        public getEditablePropertyInfo(): any {
            var editablePropertyInfo = super.getEditablePropertyInfo();
            editablePropertyInfo["title"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["title"];
            editablePropertyInfo["eraseBorderTop"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderTop"];
            editablePropertyInfo["eraseBorderBottom"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderBottom"];
            editablePropertyInfo["eraseBorderRight"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderRight"];
            editablePropertyInfo["eraseBorderLeft"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["eraseBorderLeft"];
            editablePropertyInfo["isGroupBox"] = Uz.JSControlUtil.getJSControl(this.fieldName + "_" + this.layout.items[0]["fieldName"]).getEditablePropertyInfo()["isGroupBox"];
            
            return editablePropertyInfo;
        }
        public static myLayout = {
 "fieldName": "defaultLayout",
 "items": [
  {
   "fieldName": "SaishinsaMoshitate",
   "items": [
    {
     "fieldName": "txtJigyoshaNo",
     "items": [],
     "controlType": "TextBoxCode",
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
     "selectControlID": "txtJigyoshaNo_core",
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "readOnly": true,
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
     "labelLText": "事業者",
     "labelRText": "",
     "labelLWidth": "130",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": "",
     "formatLength": "10"
    },
    {
     "fieldName": "txtJigyoshaName",
     "items": [],
     "controlType": "TextBox",
     "width": "417",
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
     "marginLeft": "-0.2",
     "marginRight": "XS",
     "selectControlID": "txtJigyoshaName_core",
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "readOnly": true,
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
     "permitCharactor": ""
    },
    {
     "fieldName": "txtTeikyoYM",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "55",
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
     "selectControlID": "txtTeikyoYM_core",
     "required": false,
     "readOnly": true,
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
     "labelLText": "提供年月",
     "labelRText": "",
     "labelLWidth": "130",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": "./_-",
     "ymdKubun": 1,
     "displayFormat": 0
    },
    {
     "fieldName": "txtSendYM",
     "items": [],
     "controlType": "TextBoxDate",
     "width": "55",
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
     "marginLeft": "4.5",
     "marginRight": "XS",
     "selectControlID": "txtSendYM_core",
     "required": false,
     "readOnly": true,
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
     "labelLText": "送付年月",
     "labelRText": "",
     "labelLWidth": "64",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": "./_-",
     "ymdKubun": 1,
     "displayFormat": 0
    },
    {
     "fieldName": "txtShokisaiHokenshaNo",
     "items": [],
     "controlType": "TextBoxCode",
     "width": "45",
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
     "selectControlID": "txtShokisaiHokenshaNo_core",
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "readOnly": true,
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
     "labelLText": "証記載保険者番号",
     "labelRText": "",
     "labelLWidth": "130",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": "",
     "formatLength": "6"
    },
    {
     "fieldName": "txtShokisaiHokenshaName",
     "items": [],
     "controlType": "TextBox",
     "width": "200",
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
     "marginLeft": "-0.2",
     "marginRight": "XS",
     "selectControlID": "txtShokisaiHokenshaName_core",
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 0,
     "readOnly": true,
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
     "permitCharactor": ""
    },
    {
     "fieldName": "radSaishinsaTaisho",
     "items": [],
     "controlType": "RadioButton",
     "width": "140",
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
     "selectControlID": "radSaishinsaTaisho_core",
     "required": false,
     "onChange": "",
     "labelLText": "再審査対象",
     "labelLWidth": "130",
     "labelLAlign": 2,
     "selectedItem": "",
     "dataSource": [
      {
       "key": "serviceShurui",
       "value": "サービス種類"
      },
      {
       "key": "serviceCode",
       "value": "サービスコード"
      },
      {
       "key": "tokuteiShinryoShikibetsu",
       "value": "特定診療識別"
      }
     ],
     "onClick": "",
     "newLineItemNumber": 1,
     "spaceSize": "M"
    },
    {
     "fieldName": "SaishinsaTaisho",
     "items": [
      {
       "fieldName": "ddlServiceShuruiCode",
       "items": [],
       "controlType": "DropDownList",
       "width": "440",
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
       "selectControlID": "ddlServiceShuruiCode_core",
       "required": false,
       "onFocus": "",
       "onBlur": "",
       "onChange": "",
       "labelLText": "",
       "labelRText": "",
       "labelLWidth": "140",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "selectedItem": "key2",
       "dataSource": [
        {
         "key": "key0",
         "value": "26：介護予防短期入所療養介護（介護療養型医療施設等）"
        },
        {
         "key": "key1",
         "value": "114904：身体１生活１・２級・同・２人・深"
        }
       ]
      },
      {
       "fieldName": "btnTokuteiShinryoShikibetsuCodeInputGuide",
       "items": [],
       "controlType": "ButtonDialog",
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
       "marginLeft": "-0.2",
       "marginRight": "XS",
       "selectControlID": "btnTokuteiShinryoShikibetsuCodeInputGuide",
       "text": "icon",
       "onClick": "",
       "appearance": 0,
       "imageFileUrl": "",
       "imageWidth": "",
       "imageHeight": "",
       "icon": 0,
       "displayChildDivName": "DBZ.TokuteiShinryoShikibetsuCodeInputGuide",
       "dataPassing": [],
       "visibleCloseButton": true,
       "onOkClose": "",
       "onBeforeOpenDialog": ""
      },
      {
       "fieldName": "txtShinsaTaishoCode",
       "items": [],
       "controlType": "TextBoxCode",
       "width": "34",
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
       "selectControlID": "txtShinsaTaishoCode_core",
       "required": false,
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "readOnly": false,
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
       "labelLText": "",
       "labelRText": "",
       "labelLWidth": "S",
       "labelRWidth": "S",
       "labelLAlign": 2,
       "labelRAlign": 0,
       "permitCharactor": "",
       "formatLength": "4"
      },
      {
       "fieldName": "txtShinsaTaishoName",
       "items": [],
       "controlType": "TextBox",
       "width": "440",
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
       "marginLeft": "-0.2",
       "marginRight": "XS",
       "selectControlID": "txtShinsaTaishoName_core",
       "required": false,
       "maxLength": 100000000,
       "minLength": 0,
       "textAlign": 0,
       "readOnly": true,
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
       "permitCharactor": ""
      }
     ],
     "controlType": "Panel",
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
     "marginLeft": "-0.5",
     "marginRight": "XS",
     "selectControlID": "SaishinsaTaisho",
     "onLoad": "",
     "title": "",
     "marginTop": "S",
     "marginBottom": "Default",
     "isOpen": true,
     "canOpenAndClose": true,
     "postParameterPanelNames": [
      {
       "postParameterPanelNames": "SaishinsaTaisho"
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
     "isGroupBox": false
    },
    {
     "fieldName": "txtMoshitateDate",
     "items": [],
     "controlType": "TextBoxDate",
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
     "selectControlID": "txtMoshitateDate_core",
     "required": false,
     "readOnly": false,
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
     "labelLText": "申立日",
     "labelRText": "",
     "labelLWidth": "130",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": "./_-",
     "ymdKubun": 2,
     "displayFormat": 0
    },
    {
     "fieldName": "ddlMoshitateshaKubun",
     "items": [],
     "controlType": "DropDownList",
     "width": "165",
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
     "selectControlID": "ddlMoshitateshaKubun_core",
     "required": false,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "申立者区分",
     "labelRText": "",
     "labelLWidth": "130",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "kohiFutansha",
     "dataSource": [
      {
       "key": "hokensha",
       "value": "2：保険者申立"
      },
      {
       "key": "kohiFutansha",
       "value": "3：公費負担者申立"
      }
     ]
    },
    {
     "fieldName": "txtMoshitateTanisu",
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
     "selectControlID": "txtMoshitateTanisu_core",
     "required": false,
     "maxLength": 100000000,
     "minLength": 0,
     "textAlign": 2,
     "readOnly": false,
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
     "labelLText": "申立単位数",
     "labelRText": "",
     "labelLWidth": "130",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "permitCharactor": "+-,.\\",
     "maxValue": 1.7976931348623157e+308,
     "minValue": 0,
     "isCurrency": false,
     "isComma": false,
     "decimalPointLength": 0
    },
    {
     "fieldName": "ddlMoshitateTaishoItem",
     "items": [],
     "controlType": "DropDownList",
     "width": "510",
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
     "selectControlID": "ddlMoshitateTaishoItem_core",
     "required": true,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "申立対象項目",
     "labelRText": "",
     "labelLWidth": "130",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "code59",
     "dataSource": [
      {
       "key": "code10",
       "value": "10：サービス種類コードおよびサービス項目コードで示すサービス"
      },
      {
       "key": "code11",
       "value": "11：緊急時施設療養費　緊急時療養管理"
      },
      {
       "key": "code12",
       "value": "12：緊急時施設療養費　リハビリテーション"
      },
      {
       "key": "code13",
       "value": "13：緊急時施設療養費　処置"
      },
      {
       "key": "code14",
       "value": "14：緊急時施設療養費　手術"
      },
      {
       "key": "code15",
       "value": "15：緊急時施設療養費　麻酔"
      },
      {
       "key": "code16",
       "value": "16：緊急時施設療養費　放射線治療"
      },
      {
       "key": "code17",
       "value": "17：所定疾患施設療養"
      },
      {
       "key": "code20",
       "value": "20：特定診療費・特別療養費"
      },
      {
       "key": "code21",
       "value": "21：特定診療費　指導管理等"
      },
      {
       "key": "code22",
       "value": "22：特定診療費　単純エックス線"
      },
      {
       "key": "code23",
       "value": "23：特定診療費　リハビリテーション"
      },
      {
       "key": "code24",
       "value": "24：特定診療費　精神科専門療法"
      }
     ]
    },
    {
     "fieldName": "ddlMoshitateRiyu",
     "items": [],
     "controlType": "DropDownList",
     "width": "270",
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
     "selectControlID": "ddlMoshitateRiyu_core",
     "required": true,
     "onFocus": "",
     "onBlur": "",
     "onChange": "",
     "labelLText": "申立理由",
     "labelRText": "",
     "labelLWidth": "130",
     "labelRWidth": "S",
     "labelLAlign": 2,
     "labelRAlign": 0,
     "selectedItem": "code59",
     "dataSource": [
      {
       "key": "code01",
       "value": "01：固定単位数に誤りがある場合"
      },
      {
       "key": "code02",
       "value": "02：計算に誤りがある場合"
      },
      {
       "key": "code03",
       "value": "03：給付内容に疑義がある場合"
      },
      {
       "key": "code04",
       "value": "04：審査内容に疑義がある場合"
      },
      {
       "key": "code05",
       "value": "05：重複して請求されている場合"
      },
      {
       "key": "code06",
       "value": "06：適正化による場合"
      },
      {
       "key": "code99",
       "value": "99：その他の再審査請求"
      }
     ]
    }
   ],
   "controlType": "Panel",
   "width": "810",
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
   "selectControlID": "SaishinsaMoshitate",
   "onLoad": "",
   "title": "再審査申立書情報",
   "marginTop": "Default",
   "marginBottom": "Default",
   "isOpen": true,
   "canOpenAndClose": true,
   "postParameterPanelNames": [
    {
     "postParameterPanelNames": "SaishinsaMoshitate"
    }
   ],
   "requestSettings": [],
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
   "panelDisplay": 0,
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
 "selectControlID": "defaultLayout",
 "relation": [],
 "businessId": "DBZ",
 "controlName": "SaishinsaMoshitate",
 "marginTop": 0,
 "marginBottom": 0,
 "originalProperty": [
  {
   "publicChildFieldName": "SaishinsaMoshitate",
   "publicChildProperty": "title",
   "newPropertyName": "title"
  },
  {
   "publicChildFieldName": "SaishinsaMoshitate",
   "publicChildProperty": "eraseBorderTop",
   "newPropertyName": "eraseBorderTop"
  },
  {
   "publicChildFieldName": "SaishinsaMoshitate",
   "publicChildProperty": "eraseBorderBottom",
   "newPropertyName": "eraseBorderBottom"
  },
  {
   "publicChildFieldName": "SaishinsaMoshitate",
   "publicChildProperty": "eraseBorderRight",
   "newPropertyName": "eraseBorderRight"
  },
  {
   "publicChildFieldName": "SaishinsaMoshitate",
   "publicChildProperty": "eraseBorderLeft",
   "newPropertyName": "eraseBorderLeft"
  },
  {
   "publicChildFieldName": "SaishinsaMoshitate",
   "publicChildProperty": "isGroupBox",
   "newPropertyName": "isGroupBox"
  }
 ],
 "dataPassingForDialog": [],
 "dialogOkEventNameForDialog": "",
 "dialogCancelEventNameForDialog": ""
}        
    }
}

