var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBE;
(function (DBE) {
    var TokkijikoCom_Design = (function (_super) {
        __extends(TokkijikoCom_Design, _super);
        function TokkijikoCom_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, TokkijikoCom_Design.myLayout, fieldName);
        }
        TokkijikoCom_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        TokkijikoCom_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        TokkijikoCom_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "ddlChosaItem",
                    "items": [],
                    "controlType": "DropDownList",
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
                    "selectControlID": "ddlChosaItem_core",
                    "required": false,
                    "onFocus": "",
                    "onBlur": "",
                    "onChange": "",
                    "labelLText": "対象項目",
                    "labelRText": "",
                    "labelLWidth": "70",
                    "labelRWidth": "S",
                    "labelLAlign": 2,
                    "labelRAlign": 0,
                    "selectedItem": "0",
                    "dataSource": [
                        {
                            "key": "0",
                            "value": ""
                        },
                        {
                            "key": "1-1",
                            "value": "1-1：麻痺"
                        },
                        {
                            "key": "1-2",
                            "value": "1-2：拘縮"
                        }
                    ]
                },
                {
                    "fieldName": "txtTokkijikoContent",
                    "items": [],
                    "controlType": "TextBoxMultiLine",
                    "width": "481",
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
                    "selectControlID": "txtTokkijikoContent_text_area",
                    "required": false,
                    "text": "",
                    "isPrivateInfo": false,
                    "maxLength": "200",
                    "minLength": 0,
                    "readOnly": false,
                    "placeHolder": "",
                    "textKind": 0,
                    "onFocus": "",
                    "onBlur": "",
                    "onChange": "",
                    "onKeyPress": "",
                    "value": "",
                    "labelLText": "",
                    "labelRText": "",
                    "labelLWidth": "S",
                    "labelRWidth": "S",
                    "labelLAlign": 2,
                    "labelRAlign": 0,
                    "height": "120",
                    "limitLength": "200",
                    "countDisp": true
                },
                {
                    "fieldName": "lblSpace",
                    "items": [],
                    "controlType": "Label",
                    "width": "S",
                    "visible": false,
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
                    "selectControlID": "lblSpace",
                    "required": false,
                    "align": 2,
                    "text": "",
                    "isPrivateInfo": false
                }
            ],
            "controlType": "CompositeControl",
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
            "marginLeft": "XS",
            "marginRight": "XS",
            "selectControlID": "defaultLayout",
            "relation": [],
            "businessId": "DBE",
            "controlName": "TokkijikoCom",
            "originalProperty": []
        };
        return TokkijikoCom_Design;
    })(Uz.CompositeControl);
    DBE.TokkijikoCom_Design = TokkijikoCom_Design;
})(DBE || (DBE = {}));
