declare module Uz {
    enum _ViewControlType {
        TextBox,
        TextBoxMultiLine,
        TextBoxCode,
        TextBoxNum,
        TextBoxDate,
        TextBoxDateRange,
        TextBoxFlexibleDate,
        TextBoxDateRangeSlider,
        TextBoxYubinNo,
        TextBoxTime,
        Button,
        ButtonPublish,
        ButtonSubmit,
        ButtonDownLoad,
        DropDownList,
        CheckBoxList,
        RadioButton,
        SortableList,
        ControlRepeater,
        TabContainer,
        TabPanel,
        DataGrid,
        Label,
        UploadPanel,
        StaticImage,
        DynamicImage,
        TreeView,
        Panel,
        TablePanel,
        TableCell,
        CompositeControl,
        CommonChildDiv,
        TextBoxKatagaki,
        TextBoxKatagakiCode,
        TextBoxTelNo,
        TextBoxMailAddress,
        TextBoxAtenaMeisho,
        TextBoxAtenaKanaMeisho,
        TextBoxJusho,
        TextBoxBanchi,
        TextBoxShikibetsuCode,
        TextBoxZenkokuJushoCode,
        TextBoxBanchiCode,
        TextBoxChoikiCode,
        TextBoxGyoseikuCode,
        TextBoxChikuCode,
        TextBoxTohyokuCode,
        TextBoxKamokuCode,
        TextBoxEdabanCode,
        TextBoxKinyuKikanCode,
        TextBoxKinyuKikanShitenCode,
        TextBoxTsuzukigaraCode,
        TextBoxSetaiCode,
        TextBoxDomainCode,
        DropDownListCode,
        TextBoxShogakkokuCode,
        TextBoxChugakkokuCode,
        TextBoxFlexibleYSeireki,
        TextBoxFlexibleYM,
        TextBoxFlexibleDateYMD,
        TextBoxYear,
        TextBoxYearMonth,
        TextBoxYearMonthDay,
    }
}
declare module Uz {
    enum PropertyEditType {
        text,
        select,
        checkbox,
        button,
    }
    class JSControlUtil {
        private static _properties;
        static getProperties(): any[];
        static registProperty(value: any): void;
        static getJSONInfo(control): {};
        static getTextBoxTypeEditableProperty(value: string, enabled?: boolean): {};
        static getSelectTypeEditableProperty(selectedValue: string, eNum: any): {};
        static getSelectTypeEditablePropertyForDynamicData(selectedValue: string, data: string[]): {};
        static getComboboxTypeEditableProperty(selectedValue: string, eNum: any): {};
        static getCheckBoxTypeEditableProperty(value: boolean): {};
        static getButtonTypeEditableProperty(buttonText: string, callBackFunction: Function): {};
        static getGridTypeEditableProperty(columnInfos: any[], rowData: any[]): {};
        static getPropertyColumnInfo(name: string, editType: PropertyEditType, editOptions?: any, width?: number, editable?: boolean, frozen?: boolean): {};
        static getUniqueId(): string;
        static removeControl(parentControl: Uz._JSControl, targetFieldName: string): void;
        static removeControlAll(jsControl: Uz._JSControl): void;
        static getJSControlParent(ancestorControl: Uz._JSControl, fieldName: string): Uz._JSControl;
        static getJSControl(fieldName: string): Uz._JSControl;
        static setJSControl(element: Element, jsControl: Uz._JSControl): void;
        static removeLinkedData(element: Element): void;
        static getJSControlForType(ancestorControl: Uz._JSControl, controlType: string): Uz._JSControl[];
        static getTargetControlItemsIndex(parentControl: Uz._JSControl, targetControlFieldName: string);
        static getCompositeRoot(control: Uz._JSControl): Uz._JSControl;
        static isPropertyPublishing(compositeControl: any, controlName: string, propertyName: string): boolean;
        static getDomIdFromCompositeFieldName(rootControl: any, fieldName: string): string;
        private static appendCompositeDomID(currentControl, fieldName, domId);
        static getCompositeFieldNameFromDomId(domId: string): string;
        private static searchFieldNameFromDomId(currentLayout, parentId, searchFileName);
    }
}
declare module Uz {
    enum TextBoxValidationTypeInDesign {
        Required,
        MaxLength,
        MinLength,
        MaxNumber,
        MinNumber,
        Regex,
        Overlap,
    }
    class ValidationTextBoxInDesign {
        public validateTextBox(propertyName: string, propertyValue: string, rule: any, JSONTextArea: string, changedJSON: boolean, propertyValueOnJson: string): string[];
        private createRequiredErrorMessage(rule, propertyName, propertyValue);
        private createMaxLengthErrorMessage(rule, propertyName, propertyValue);
        private createMinLengthErrorMessage(rule, propertyName, propertyValue);
        private createMaxNumberErrorMessage(rule, propertyName, propertyValue);
        private createMinNumberErrorMessage(rule, propertyName, propertyValue);
        private createRegexErrorMessage(rule, propertyName, propertyValue);
        private createOverlapErrorMessage(rule, propertyName, propertyValue, JSONTextArea, changedJSON, propertyValueOnJson);
        private pushErrorMessage(errorMessage, errorMessageArray);
    }
}
declare module Uz {
    interface _IJSControlsInDesign {
        getEditablePropertyInfo(): any;
        registProperty(): void;
    }
    class _JSControl implements _IJSControlsInDesign {
        private _fieldName;
        private _items;
        private _controlType;
        private _rules;
        public fieldName : string;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        public items : _JSControl[];
        public controlType : any;
        public rules : Object;
        constructor();
        public getJQueryElement(): JQuery;
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
    }
}
declare module Uz {
    enum Size {
        XS,
        S,
        M,
        L,
        XL,
    }
    enum SizeForGridHeight {
        XS,
        S,
        M,
        L,
        XL,
        Auto,
    }
    enum Align {
        left,
        center,
        right,
    }
    enum Expression {
        isEmpty,
        isNotEmpty,
        isSelected,
        isNotSelected,
    }
    enum Constraint {
        required,
        disabled,
        inVisible,
        moreThan,
        lessThan,
    }
    enum Float {
        left,
        center,
        right,
    }
    enum DataPassingIO {
        input,
        output,
        input_output,
    }
    enum ImeMode {
        Hiragana,
        Alpha,
        Off,
        Katakana,
        KatakanaHalf,
    }
    enum TextKind {
        "All",
        "半角文字すべて",
        "英数字のみ",
        "カナすべて(全半角)",
        "半角カナ",
    }
    enum TimeKubun {
        "時",
        "時分",
        "時分秒",
    }
    enum DisplayFormat {
        "12hh:mm",
        "24hh:mm",
        "12hh時mm分",
        "24hh時mm分",
        "午前hh時mm分",
        "AMhh:mm",
    }
    enum IconType {
        File,
        Data,
    }
    enum YmdKubun {
        "年",
        "年月",
        "年月日",
        "月日",
    }
    enum DisplayDateFormat {
        "平YYMMDD",
        "HYYMMDD",
        "NYYMMDD",
        "平成YY年MM月DD日",
        "YYYY年M月D日",
        "YYYYMMDD",
    }
    enum AuthorityMode {
        ALL_PERMISSION,
        READ_ONLY,
        MASK,
        HIDDEN,
        NONE,
    }
    enum Color {
        Default,
        Alert,
        Error,
        Information,
        Succeed,
    }
    enum KanaType {
        "全角カナ",
        "半角カナ",
        "全角かな",
    }
}
declare module Uz {
    class _ViewControl extends Uz._JSControl {
        private _width;
        private _visible;
        private _disabled;
        private _accessKey;
        private _nextFocusFiledName;
        private _wrap;
        private _dependencies;
        private _float;
        private _toolTip;
        private _authorityMode;
        private _marginLeft;
        private _marginRight;
        private static DEFAULT_SELECTEDSOURCELISTSORTBUTTON_ID;
        private static DEFAULT_TABPANEL_ID;
        public _isDesignMode: boolean;
        public width : any;
        public changeWidth(): void;
        public bindWidth(value): void;
        public visible : boolean;
        public disabled : boolean;
        public accessKey : string;
        public nextFocusFieldName : string;
        public wrap : boolean;
        public wrapChanged(beforeValue, afterValue): void;
        public dependencies : Dependency[];
        public float : Uz.Float;
        public toolTip : string;
        public authorityMode : Uz.AuthorityMode;
        public marginLeft : any;
        public marginRight : any;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        private changeFieldName(beforeFieldName, newFieldName);
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc: Function);
        public initToolTip(element: HTMLElement): void;
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        static createViewControl(controlType: Uz._ViewControlType, $parentElement: JQuery, isDesignMode: boolean): Uz._JSControl;
        private static isUzControl(controlTypeName);
        public moveNextField(element: HTMLElement): void;
        private isNextField(element);
        public fireEvent(eventName: string): void;
        public bindData(data: any): void;
        public getData(): any;
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        public changedVisible(): void;
        public changedDisabled(): void;
    }
    class Dependency {
        public dependTo: string;
        public dependValue: string;
        public expression: Uz.Expression;
        public myCondition: Uz.Constraint;
    }
}
declare module Uz {
    interface _IStateChangable {
        postParameterPanelNames: Object[];
    }
}
declare module Uz {
    enum GridValidationTypeInDesign {
        CircularReference,
        duplicationNewPropertyName,
    }
    class ValidationGridInDesign {
        public validateGrid(propertyName: string, rule: any, fieldName: string, rowDatas: any): any;
        private valiateCircularReference(rule, fieldName, rowDatas);
        private createAllpostParameterPanelNames(fieldName, rowDatas);
        private isSelectSamePanelName(postParameterPanelNames);
        private sortAllParameterPanelNames(allPostParameterPanelNames);
        private createReferenceSequence(allPostParameterPanelNames);
        public createValidateResult(allPostParameterPanelNames: any): any;
        private searchTargetPanelSequenceIndex(circularReferenceInfoArray, postParameterPanelNames, panelName);
        private pushCircularReferenceInfo(circularReferenceInfoArray, postParameterPanelNames, panelName);
        private editCircularReferenceInfo(circularReferenceInfoArray, postParameterPanelNames, panelName, targetIndex);
        private isCircularReferenceError(postParameterPanelNames, targetCheckedPanels, panelName);
        private editPanelSequence(postParameterPanelNames, targetPanelSequence, panelName);
        private sortPanelSequence(targetPanelSequence, myIndex, referenceIndex);
        private changePanelSequenceArray(circularReferenceInfo);
        private valiateDuplicationNewPropertyName(rule, fieldName, rowDatas);
        private createDuplicationNewPropertyName(fieldName, rowDatas);
    }
}
declare module Uz {
    class _Panel extends Uz._ViewControl implements Uz._IStateChangable {
        private static DEFAULT_BODYAREA_ID;
        private _panelBodyDom;
        private _title;
        private _isOpen;
        private _canOpenAndClose;
        private _postParameterPanelNames;
        private _requestSettings;
        private _hiddenInput;
        private _onLoad;
        private _onOpen;
        private _onClose;
        private _session;
        private _backgroundColor;
        private _marginTop;
        private _marginBottom;
        private _eraseBorderBottom;
        private _eraseBorderRight;
        private _eraseBorderLeft;
        private _eraseBorderTop;
        private _isFirstLoadFinished;
        public isFirstLoadFinished : boolean;
        public title : string;
        public isOpen : boolean;
        public canOpenAndClose : boolean;
        private keepHeaderWidth(beforeWidth);
        private changePanelHeaderIcon();
        private changePanelBodyVisible();
        public postParameterPanelNames : Object[];
        public requestSettings : RequestSettings[];
        public hiddenInput : Object[];
        public onLoad : string;
        public onOpen : string;
        public onClose : string;
        public session : any;
        public marginTop : any;
        public backgroundColor : Uz.Color;
        public marginBottom : any;
        public eraseBorderTop : boolean;
        public eraseBorderBottom : boolean;
        public eraseBorderRight : boolean;
        public eraseBorderLeft : boolean;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode): HTMLDivElement;
        public getEditablePropertyInfo(): any;
        private childDivAutoMakeSelect();
        private childDivAutoMakeSelectElement(fieldName);
        public showLoading(): void;
        public hideLoading(): void;
        private requestSettingsBind();
        public bindData(data: any): void;
        private getPanelBodyAreaID();
        public layoutedChildControl(): void;
    }
    class RequestSettings {
        public eventName: string;
        public requestUrl: string;
    }
}
declare module Uz {
    interface _IPostable {
        url: string;
        targetPostParamFieldNames: string[];
        relation: string[];
    }
}
declare module Uz {
    class _Button extends Uz._ViewControl {
        private static DEFAULT_IMG_TEMP_ID;
        private static DEFAULT_BTN_TEMP_ID;
        private _text;
        private _imageFileUrl;
        private _onClick;
        public onClick : string;
        public text : string;
        public imageFileUrl : string;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc?: Function);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode: boolean): HTMLButtonElement;
        public recreateDomElement(isImage: boolean): void;
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
    }
}
declare module Uz {
    class _ButtonSubmit extends Uz._Button {
        private _postParameterPanelNames;
        private _validateUrl;
        private _submitUrl;
        private _onAfterRequest;
        public postParameterPanelNames : Object[];
        public validateUrl : string;
        public submitUrl : string;
        public onAfterRequest : string;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode: boolean): HTMLButtonElement;
        public recreateDomElement(isImage: boolean): void;
        public getEditablePropertyInfo(): any;
        private submitRequest();
        private execClientValidation();
        public bindData(data: any): void;
    }
}
declare module Uz {
    class _ButtonDownLoad extends Uz._ViewControl {
        private static DEFAULT_IMG_TEMP_ID;
        private static DEFAULT_BTN_TEMP_ID;
        private _text;
        private _imageFileUrl;
        private _onClick;
        private _fileType;
        private _url;
        private _onBeforeClick;
        private _postParameterPanelNames;
        public onClick : string;
        public text : string;
        public imageFileUrl : string;
        public fileType : string;
        public url : string;
        public onBeforeClick : string;
        public postParameterPanelNames : Object[];
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc?: Function);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode: boolean): HTMLButtonElement;
        public recreateDomElement(isImage: boolean): void;
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
    }
}
declare module Uz {
    class _ButtonPublish extends Uz._ViewControl {
        private static DEFAULT_TEXT;
        private static DEFAULT_PRINTDIALOGURL;
        private _text;
        private _postParameterPanelNames;
        private _validateUrl;
        private _sourceCreateUrl;
        private _afterPrintUrl;
        private _isPreview;
        private _onAfterPrint;
        public text : string;
        public postParameterPanelNames : Object[];
        public validateUrl : string;
        public sourceCreateUrl : string;
        public afterPrintUrl : string;
        public isPreview : boolean;
        public onAfterPrint : string;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc?: Function);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode: boolean): HTMLButtonElement;
        public getEditablePropertyInfo(): any;
        private printDialog();
        public bindData(data: any): void;
    }
}
declare module Uz {
    class _UploadPanel extends Uz._ViewControl {
        private static DEFAULT_HIDEFILE_ID;
        private static DEFAULT_SELECTBUTTON_ID;
        private static DEFAULT_DROPAREA_ID;
        private static DEFAULT_UPLOADEFILETABLE_ID;
        private static DEFAULT_UPLOADBUTTON_ID;
        private static ANIMATION_SPEED;
        private _multiSelect;
        private _extension;
        private _url;
        private _uploadFiles;
        private _selectButton;
        private _hideFile;
        private _dropArea;
        private _uploadFileTable;
        private _uploadButton;
        private _postParameterPanelNames;
        public multiSelect : boolean;
        public extension : string;
        public url : string;
        public uploadFiles : File[];
        private selectButton;
        private hideFile;
        private dropArea;
        private uploadFileTable;
        private uploadButton;
        public postParameterPanelNames : Object[];
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode: boolean): HTMLDivElement;
        private createOuterDiv();
        private createButton(elementName, id, text);
        private createHideFile();
        private createDropArea();
        private createTable(isDesignMode);
        private bindEvent();
        private openExplorer();
        private addUpdateFilesTo(selectFiles);
        private canUploadFile(selectFile);
        private serchSameFileIndex(selectFileName);
        private addRowtoUploadFileTable(addTargetFileNames);
        private appendRow(table, fileName, fieldName);
        private bindDeleteEvent();
        private fileUpload();
        public getEditablePropertyInfo(): any;
    }
}
declare module Uz {
    class _TextBox extends Uz._ViewControl {
        private _required;
        private _maxLength;
        private _minLength;
        private _textAlign;
        private _readOnly;
        private _placeHolder;
        private _imeMode;
        private _textKind;
        private _isPassword;
        private _isPrivateInfo;
        private _text;
        private _onFocus;
        private _onBlur;
        private _onChange;
        private _onKeyPress;
        private _suggest;
        private _defaultPermitCharactor;
        private _permitCharactor;
        private _value;
        public required : boolean;
        public maxLength : number;
        public minLength : number;
        public textAlign : Uz.Align;
        public readOnly : boolean;
        public placeHolder : string;
        public imeMode : Uz.ImeMode;
        public textKind : Uz.TextKind;
        public isPrivateInfo : boolean;
        public isPassword : boolean;
        public onFocus : string;
        public onBlur : string;
        public onChange : string;
        public onKeyPress : string;
        public text : string;
        public suggest : string[];
        public permitCharactor : string;
        public defaultPermitCharactor : string;
        public value : string;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc: Function);
        public formatValidation(): boolean;
        public changeFormat(): void;
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode): HTMLInputElement;
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
        public validateControl(): any;
        public validateRequired(): any;
        public validateMaxLength(): any;
        public validateMinLength(): any;
        public validateTextKind(): any;
        public validateUniqueCharactor(): any;
    }
}
declare module Uz {
    class _TextBoxCode extends Uz._TextBox {
        private _formatLength;
        public formatLength : number;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode): HTMLInputElement;
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
        public formatValidation(): boolean;
        public changeFormat(): void;
        static getFormatText(text: string, formatLength: any): string;
        static particularValidation(formatText: string): boolean;
        public validateControl(): any;
        public validateTextKind(): any;
    }
}
declare module Uz {
    class _TextBoxNum extends Uz._TextBox {
        private _maxValue;
        private _minValue;
        private _isCurrency;
        private _isComma;
        private _decimalPointLength;
        public maxValue : number;
        public minValue : number;
        public isCurrency : boolean;
        public isComma : boolean;
        public decimalPointLength : number;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode): HTMLInputElement;
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
        public formatValidation(): boolean;
        public changeFormat(): void;
        private static getPointNumber(num, point);
        private static repeatText(s, num);
        static getNoFormatText(text, decimalPointLength): string;
        static getFormatText(value: string, isCurrency: any, isComma: any): string;
        static particularValidation(text: string): boolean;
        public validateControl(): any;
        public validateMaxLength(): any;
        public validateMinLength(): any;
        public validateMaxValue(): any;
        public validateMinValue(): any;
        public validateTextKind(): any;
    }
}
declare module Uz {
    class _DateControlUtil {
        private static FORMAT_BASE;
        private static DEFAULT_DISPLAY_FORMAT;
        static initializeRegion(): void;
        static datepickerForGrid(inputElement: JQuery, displayFormat: any, ymdKubun: any): void;
        private static formatOnBlurForGrid(element, displayFormat, ymdKubun);
        static onSelectForDate(element: JQuery, inst: any, displayFormat: any, ymdKubun: any);
        static beforeShowForDate(element: JQuery, value: any, displayFormat: any, ymdKubun: any, maxMin: any): void;
        static formatOnBlurForDate(element: JQuery, displayFormat: any, ymdKubun: any): void;
        static formatOnFocusForDate(element: JQuery, displayFormat: any, ymdKubun: any): string;
        static getOrgTextForDate(targetObj: JQuery, displayFormat: any, ymdKubun: any): string;
        static getFormatText(targetText: string, displayFormat: any, ymdKubun: any): string;
        private static displayFormatPropertyCheck(displayFormat, ymdKubun);
        private static format2digit(value);
        static getDateInfoStruct(strDateValue): DateStruct;
        private static convDateSeireki(targetDate, formatType);
        private static displayFormatInputCheck(resultString);
        private static isYearRange(targetValue);
        private static formatDateSeireki(date, fmt, ymd);
        private static formatDateWareki(date, fmt, ymd);
        private static getEraTable();
        private static getEraFromDate(targetValue);
        private static analyzeDateString(strDateValue);
        private static getDateInfoFromWareki(eraType, strYM);
        private static getEraFromName(targetValue);
        private static getEraFromCode(targetValue);
        private static getDaysInMonthWareki(strGYYMM);
        private static convDateWareki(TargetDate);
    }
    class DateStruct {
        private _eraNumber;
        private _eraAlphabet;
        private _eraKanji;
        private _eraKanjiRyaku;
        private _yearSeireki;
        private _yearWareki;
        private _month;
        private _day;
        private _isSeireki;
        public eraNumber : string;
        public eraAlphabet : string;
        public eraKanji : string;
        public eraKanjiRyaku : string;
        public yearSeireki : string;
        public yearWareki : string;
        public month : string;
        public day : string;
        public isSeireki : boolean;
        constructor();
    }
    class CTable {
        private _fcode;
        private _fename;
        private _fjname;
        private _foffset;
        private _fdstart;
        private _fdend;
        private _fjryaku;
        public fcode : string;
        public fename : string;
        public fjname : string;
        public foffset : string;
        public fdstart : Date;
        public fdend : Date;
        public fjryaku : string;
        constructor(fcode, fename, fjname, foffset, fdstart, fdend, fjryaku);
    }
}
declare module Uz {
    class _TextBoxDate extends Uz._ViewControl {
        private static DEFAULT_YMDKUBUN;
        private static DEFAULT_DISPLAY_DATE_FORMAT;
        private _required;
        private _readOnly;
        private _placeHolder;
        private _imeMode;
        private _textKind;
        private _isPassword;
        private _isPrivateInfo;
        private _text;
        private _onFocus;
        private _onBlur;
        private _onChange;
        private _onKeyPress;
        private _defaultPermitCharactor;
        private _permitCharactor;
        private _ymdKubun;
        private _displayFormat;
        private _valueString;
        public ymdKubun : Uz.YmdKubun;
        public displayFormat : Uz.DisplayFormat;
        public required : boolean;
        public readOnly : boolean;
        public placeHolder : string;
        public imeMode : Uz.ImeMode;
        public textKind : Uz.TextKind;
        public isPrivateInfo : boolean;
        public isPassword : boolean;
        public onFocus : string;
        public onBlur : string;
        public onChange : string;
        public onKeyPress : string;
        public text : string;
        public permitCharactor : string;
        public defaultPermitCharactor : string;
        public valueString : string;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc: Function);
        public formatValidation(): boolean;
        public changeFormat(): void;
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode): HTMLInputElement;
        public getEditablePropertyInfo(): any;
        public initializeDatepicker(): void;
        public initializeDatepickerSet(): void;
        public inputTextDateConvert(element): void;
        public bindData(data: any): void;
        public changeFormatBindData(): void;
        public validateControl(): any;
        public validateRequired(): any;
        public validateTextKind(): any;
        public validateInputDate(): any;
    }
}
declare module Uz {
    class _TextBoxFlexibleDate extends Uz._TextBox {
        private static DEFAULT_YMDKUBUN;
        private static DEFAULT_DISPLAY_DATE_FORMAT;
        private _ymdKubun;
        private _displayFormat;
        public ymdKubun : number;
        public displayFormat : Uz.DisplayDateFormat;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc: Function);
        public formatValidation(): boolean;
        public changeFormat(): void;
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode): HTMLInputElement;
        public getEditablePropertyInfo(): any;
        public initializeDatepicker(): void;
        public initializeDatepickerSet(): void;
        public inputTextDateConvert(element): void;
        public bindData(data: any): void;
        public changeFormatBindData(): void;
        public validateControl(): any;
        public validateRequired(): any;
        public validateTextKind(): any;
    }
}
declare module Uz {
    class _GridControlUtil {
        static setFrozenColumns(grid: JQuery, columns: any, frozenColumnName: string): void;
        private static fixPositionsOfFrozenDivs(element);
        static resetRowIds(grid: JQuery): void;
        static restoreSelectedRows(grid: JQuery, dataSource: any): void;
        static changeRowState(grid: JQuery, rowId, state: string): void;
        static getRowId(inputElement: JQuery): any;
        static getAreaDivElement(grid: JQuery, area?: string): JQuery;
        static keepSearchCriteria(grid: JQuery): void;
        static getSelectedRows(grid: JQuery): any[];
        static getDropDownList(dataSource: any): any;
        static enableNaviButton(button: JQuery): void;
        static disableNaviButton(button: JQuery): void;
    }
}
declare module Uz {
    class _TabPanel extends Uz._ViewControl {
        private $_parentTabContainer;
        private _title;
        private _titleHref;
        private _onActive;
        public title : string;
        private getTabATag();
        private getTabList();
        private titleHref;
        public onActive : string;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public createDomElement($parentElement, isDesignMode: boolean): HTMLDivElement;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        private appendLiTitle();
        private createLiTitle();
        private createATag();
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        public changedVisible(): void;
        public bindData(data: any): void;
    }
}
declare module Uz {
    class _TabContainer extends Uz._ViewControl {
        private _selectedItemFeildName;
        private _tabpanelPosition;
        private _isDraggable;
        private _onChange;
        public onChange : string;
        public selectedItem : Uz._TabPanel;
        private isInvalidPanel(value);
        private activeTab(selectedItem);
        private static getTabListItems($tabContainer);
        public tabpanelPosition : string[];
        public isDraggable : boolean;
        public selectedItemFieldName : string;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public createDomElement($parentElement, isDesignMode: boolean): HTMLElement;
        private createTabContainer();
        private appendTabList(tabs);
        private alignTabTitlesHeight();
        private static findMaxTitleLineNum(tabContainer);
        private static appendBlankLinesToTitles(tabContainer, maxLineNum);
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        private addNewTab(selectedControl);
        private removeTab(selectedControl);
        static saveTabState(): void;
        static refreshTabState(element?: JQuery): void;
        static clearTabState(): void;
        static initDefaultActiveTab(): void;
        private static resizeTabPanel(anyTabs);
        private static reloadActiveTab();
        private initSortableTabs();
        private sortableTabs();
        private getOrderOfTabpanel();
        public refreshTabOrder(): void;
        private createTabpanelPosition(tabpanelPosition);
        private isAllStringInArray(tabpanelPosition);
        private sortTabpanelByTabpanelPosition();
        private createEditablePropertyTabpanelPosition();
        private getFirstTabInDisplayed();
        private getTabPanelByFieldName(tabFieldName);
        public resetSelectItem(): void;
        public bindData(data: any): void;
    }
}
declare module Uz {
    class _DataGrid extends Uz._ViewControl {
        private static DEFAULT_GRID_ID;
        private static DEFAULT_PAGER_ID;
        private static DEFAULT_GRID_COLUMNS;
        private static DEFAULT_GRID_ROWS;
        private static DEFAULT_IMAGE_TAG_NAME;
        private _grid;
        private _pager;
        private _outerDiv;
        private _editable;
        private _prevSelectedRowid;
        private _beforePaging;
        private _clickRowId;
        private _gridSetting;
        private _height;
        private _currentPageNum;
        private _dataSource;
        private _selectedItems;
        private _clickedItem;
        private _sortOrder;
        private _isAscending;
        private _filterList;
        private _totalRecords;
        private _onSort;
        private _onPageChanged;
        private _onSelect;
        private _onAddRow;
        private _onDeleteRow;
        private _onOnlyRow;
        private _onNoRow;
        private _onMultiRows;
        private _onExecuteFilter;
        private grid;
        private pager;
        public gridSetting : _JQGridSetting;
        public height : Uz.SizeForGridHeight;
        public currentPageNum : any;
        public dataSource : any[];
        public selectedItems : any[];
        public clickedItem : any;
        public sortOrder : string;
        public isAscending : boolean;
        public filterList : any[];
        public totalRecords : any;
        public onSort : string;
        public onPageChanged : string;
        public onSelect : string;
        public onAddRow : string;
        public onDeleteRow : string;
        public onOnlyRow : string;
        public onNoRow : string;
        public onMultiRows : string;
        public onExecuteFilter : string;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public changeWidth(): void;
        private createDefaultGridSetting();
        private createGrid();
        private isEditable(columns);
        private getColModel(columns, header, isRowState);
        private getColNames(columns, isRowState);
        private initJqGrid(colNames, colModel);
        private onGridCompleteEvent(grid);
        private formatter(inputElement, column, dataSource?);
        private onBeforeSelectRowEvent(grid, rowid);
        private onSelectAllEvent(grid, rowids, status);
        private initGridCellFocusEvent(grid);
        private initGridCellChangeEvent(grid);
        private initGridCellClickEvent(grid);
        private initGridPager(grid, colModels);
        private changeNaviButtonState();
        private onClickInsertButtonEvent(grid, colModel);
        private onClickAddButtonEvent(grid, colModel);
        private createDefaultRow(grid, colModel, rowid?, select?);
        private onClickDeleteButtonEvent(grid, colModels);
        private onClickCancelButtonEvent(grid, colModels);
        private deleteRowData(grid, selectedRow);
        private restoreRowData(grid, selectedRow);
        private showGridCustomButton(addVisible, insertVisible, deleteVisible);
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        private changeJqGrid(grid);
        public createDomElement($parentElement, isDesignMode: boolean): HTMLDivElement;
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        private static getDialogTypeEditableProperty(gridSetting);
        private displayOnParentsTabPanel(cotrol);
        private displayRestoreParentsTabPanel(tabPanelStates);
        public bindData(data: any): void;
        private convertDataSource(data, colModel);
        private convertDataForClient(rowId, data, colModel);
        private convertDataForServer(data, colModel);
        private denyControlClickEvent();
        private updateHeight();
        private fillWithEmptyRows();
    }
    enum _JQGridRowNum {
        rows_5,
        rows_10,
        rows_15,
        rows_20,
        rows_25,
    }
    enum _JQGridColumnWidth {
        XS,
        S,
        M,
        L,
        XL,
    }
    enum _JQGridCellType {
        String,
        TextBox,
        CheckBox,
        DropDownList,
        TextBoxCode,
        TextBoxNum,
        TextBoxDate,
        TextBoxFlexibleDate,
        Button,
    }
    enum _JQGridAlign {
        left,
        center,
        right,
    }
    class _JQGridSetting {
        static DEFAULT_GRID_ROWNUM: _JQGridRowNum;
        static DEFAULT_GRID_IS_MULTISELECTABLE: boolean;
        static DEFAULT_GRID_IS_SHOW_ADDBUTTON: boolean;
        static DEFAULT_GRID_IS_SHOW_INSERTBUTTON: boolean;
        static DEFAULT_GRID_IS_SHOW_DELETEBUTTON: boolean;
        static DEFAULT_GRID_IS_SHOW_FOOTER: boolean;
        static DEFAULT_GRID_IS_SHOW_FILTER: boolean;
        public rowNum: _JQGridRowNum;
        public isMultiSelectable: boolean;
        public isShowAddButton: boolean;
        public isShowInsertButton: boolean;
        public isShowDeleteButton: boolean;
        public isShowFilter: boolean;
        public isShowFooter: boolean;
        public columns: _JQGridColumn[];
        public header: _JQGridHeader;
        constructor();
    }
    class _JQGridColumn {
        static DEFAULT_GRID_COLUMN_WIDTH: _JQGridColumnWidth;
        static DEFAULT_GRID_COLUMN_CELL_TYPE: _JQGridCellType;
        static DEFAULT_GRID_COLUMN_VISIBLE: boolean;
        static DEFAULT_GRID_COLUMN_ALIGN: _JQGridAlign;
        static DEFAULT_GRID_COLUMN_RISIZE: boolean;
        static DEFAULT_GRID_COLUMN_IS_PRIVATE_INFO: boolean;
        public columnName: string;
        public dataName;
        public string;
        public sortKey: string;
        public width;
        public visible: boolean;
        public cellType;
        public cellDetails: any;
        public align;
        public resize: boolean;
        public isPrivateInfo: boolean;
        constructor();
    }
    class _JQGridHeader {
        public combineColumns: _JQGridCombineColumn[];
        public frozenColumn: string;
        constructor();
    }
    class _JQGridCombineColumn {
        public combineColumnName: string;
        public combineItem: string[];
        constructor();
    }
}
declare module Uz {
    class CompositeControl extends Uz._ViewControl implements Uz._IPostable {
        private _url;
        private _targetPostParamFieldNames;
        private _layout;
        private _businessId;
        private _controlName;
        private _isCompositeEditMode;
        private _relation;
        private _originalProperty;
        public url : string;
        public targetPostParamFieldNames : string[];
        public targetPostParamFieldName : any;
        public layout : any;
        public businessId : string;
        public controlName : string;
        public relation : string[];
        public originalProperty : Object[];
        private static defaultLayout;
        constructor($parentElement: JQuery, isDesignMode: boolean, staticLayout: any, fieldName: string);
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        private static getCompositeControlFieldName($parentElement, fieldName);
        private initLayout(staticLayout);
        public raisePropertyChanged(layout): void;
        private copyPropertyFromLayout();
        private initChildControls($compositeParentElement, compositeControlFieldName);
        private static addFieldNameForCompositeControlChildren(parentFieldName, childControl);
        public createDomElement($parentElement, isDesignMode: boolean): HTMLDivElement;
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        private createOriginalPropertyColumnInfos();
        static createCompositeControl(compositeFieldName: string, businessId: string, controlName: string, $parentElement: JQuery, isDesignMode: boolean, isCompositeEditMode: boolean): Uz._JSControl;
        private static getChildFieldNames(control, fieldNames);
        private setElementId();
        public bindData(data: any): void;
    }
}
declare module Uz {
    class CommonChildDiv extends Uz._ViewControl {
        private _layout;
        private _businessId;
        private _controlName;
        private _isCommonChildDivEditMode;
        private _relation;
        private _originalProperty;
        private _marginTop;
        private _marginBottom;
        public layout : any;
        public businessId : string;
        public controlName : string;
        public relation : string[];
        public originalProperty : Object[];
        public marginTop : any;
        public marginBottom : any;
        private static defaultLayout;
        constructor($parentElement: JQuery, isDesignMode: boolean, staticLayout: any, fieldName: string);
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        private static getCommonChildDivFieldName($parentElement, fieldName);
        private initLayout(staticLayout);
        public raisePropertyChanged(layout): void;
        private copyPropertyFromLayout();
        private initChildControls($childDivParentElement, childDivFieldName);
        private static addFieldNameForCommonChildDivChildren(parentFieldName, childControl);
        public createDomElement($parentElement, isDesignMode: boolean): HTMLDivElement;
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        private createOriginalPropertyColumnInfos();
        static createCommonChildDiv(childdivFieldName: string, businessId: string, controlName: string, $parentElement: JQuery, isDesignMode: boolean, isCommonChildDivEditMode: boolean): Uz._JSControl;
        private static getChildFieldNames(control, fieldNames);
        private setElementId();
        public bindData(data: any): void;
        public initDefaultOriginalProperty(basePanelName: string): void;
    }
}
declare module Uz {
    class _ViewControlUtil {
        static applyLayoutInfo(control: Uz._JSControl, layoutInfo: any, $ancestorElement: JQuery, isDesignMode: boolean): Uz._JSControl;
        static applyLayoutInfoForDesign(control: Uz._JSControl, layoutInfo: any, $ancestorElement: JQuery, isDesignMode: boolean): Uz._JSControl;
        private static getTargetPanelNames(state);
        private static getTargetLayoutInfo(layoutInfo, targetPanelName);
        private static applyLayoutInfoForDesignCore(control, layoutInfo, $ancestorElement, isDesignMode);
        static createInitialControl(control: Uz._JSControl, layoutInfo: any, $ancestorElement: JQuery, isDesignMode: boolean): Uz._JSControl;
        private static isCompositeControlType(controlType);
        private static isCompositeEditMode(control, layoutInfo);
        static adjustmentViewPageHeight(isDesignMode: boolean): void;
        private static resizeViewPageHeight();
        static applyDependencies(myControl: Uz._ViewControl): void;
        private static applyDependency(dependentControl, myCondition, myControl, expression, targetProperty, targetValue);
        private static applyDependencyForSelectableControl(myControl, dependencyIndex, myCondition, isSelected);
        private static changeMyConditionFromDependency(myCondition, controlProperties, isDepend);
        static getPanelFieldNames(parentControl: Uz._ViewControl, panelFieldNames: string[]): string[];
        static serializeArrayForGrid(array: string[]): string;
        static getFirstState(page: Uz._ViewPage): string;
        static getNextState(page: Uz._ViewPage, fieldName: string, eventName: string): string;
        static getTransitionEvents(page: Uz._ViewPage): Object[];
        private static isExistEventInArray(eventArray, data);
        static getStateTransitionByState(page: Uz._ViewPage, targetState: string): any;
        static getVisibleDivByState(page: Uz._ViewPage): string[];
        static bindTransitionEvent(page: Uz._ViewPage, fieldName: string, eventName: string): void;
        static fireEvent(eventName: string): void;
        static getControlEventList(ancestorControl: Uz._JSControl, parentFieldName?: string): string[];
        private static isPrefixOn(propertyName);
        private static appendFeildNameConnectorString(field);
        private static isCommonChildDivType(controlType);
        static splitStringByBreak(str: string): string[];
        static appendNewLinetText(element: JQuery, strArray: string[]): void;
        static getUniqueIdForViewControl(controlType: any);
        static createPostParameter(instance: Uz._JSControl): any;
        static getLayoutByFieldName(rootControl: Uz._JSControl, fieldName: string): any;
        private static searchLayoutByFieldName(currnetControl, fieldName);
        static getLayoutParentByFieldName(rootControl: Uz._JSControl, fieldName: string): any;
        private static searchLayoutParentByFieldName(currnetControl, fieldName);
        private static getSendJsonInfo(control, currntLayout?);
        private static createItemsToJsonObject(parentDiv, parentLayout?);
        private static isViewControl(control);
        static isCommonChildDivPanel(control: Uz._JSControl): boolean;
        static isCompositeChild(control: Uz._JSControl): boolean;
        static fireStateTransitionOnDatagridColumn(fieldName: string, columnName: string, eventName: string): void;
        static viewPageRootTitle(rootTitle: string): void;
    }
}
declare module Uz {
    class _ViewPage extends Uz._ViewControl {
        private _onLoad;
        private _title;
        private _jsPathCollection;
        private _relation;
        private _stateTransition;
        private _currentState;
        private _id;
        private _dataPassing;
        private _loadSequencePanelNames;
        private static _helpTabWidth;
        private static _helpTabHeight;
        private static _helpDivWidth;
        private static EXCEPTIONMESSAGE_JSNOTFOUNDERROR;
        private static EXCEPTIONMESSAGE_JSEXECECTIONERROR;
        private static EXCEPTIONMESSAGE_JSCOLLECTIONERROR;
        private static _http200OK;
        private static _http404ERROR;
        public onLoad : string;
        public title : string;
        public jsPathCollection : string[];
        private getScriptFile(path);
        public relation : string[];
        public stateTransition : string[];
        public currentState : string;
        public id : string;
        public dataPassing : string[];
        public loadSequencePanelNames : string[];
        constructor($parentElement: JQuery, isDesignMode: boolean, isDialogPage: boolean);
        private initTempHelpData();
        static createCommonButtonArea(): void;
        private initErrorAndWarningAccordion();
        private initPageResizeEvent();
        private static resizeHelpTabAndDiv(pageWidth, top, additionalTop, left, $helpTab, $helpDiv);
        private initHelpTabClickEvent($helpTab, $helpDiv);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode): HTMLDivElement;
        private createErrorAndWarningDiv(errorWarningDiv);
        public getEditablePropertyInfo(): any;
        private static getFieldNames(control, fieldNames);
        private getStateNames();
        private createHelpTab(text, className, startGradient, endGradient, fontSize);
        private createHelpDiv(className);
        private fillColorOfHelpTab(context, startGradient, endGradient);
        private writeVerticalLine(context, text, x, y, fontSize);
        public bindStateTransitionEvent(): void;
        public changeState(fieldName: string, eventName: string): void;
        private changeFinishState();
        private getWorkFlowParameter();
        private setWorkFlowParameter(parameters);
        private changeVisibleDiv(isAll);
        private changeStateDiv(changeInstance);
        private loadDivs(instances, loadSequence);
    }
}
declare module Uz {
    class _TextBoxMultiLine extends Uz._ViewControl {
        private static DEFAULT_LIMITLENGTH;
        private static DEFAULT_TEXTAREA_ID;
        private static DEFAULT_TEXTCOUNT_ID;
        private _textareaDom;
        private _textcountDom;
        private _outerDiv;
        private _required;
        private _maxLength;
        private _minLength;
        private _readOnly;
        private _placeHolder;
        private _isPrivateInfo;
        private _imeMode;
        private _textKind;
        private _height;
        private _limitLength;
        private _countDisp;
        private _onFocus;
        private _onBlur;
        private _onChange;
        private _onKeyPress;
        private _text;
        private _value;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        public required : boolean;
        public maxLength : number;
        public minLength : number;
        public readOnly : boolean;
        public placeHolder : string;
        public isPrivateInfo : boolean;
        public imeMode : Uz.ImeMode;
        public textKind : Uz.TextKind;
        public onFocus : string;
        public onBlur : string;
        public onChange : string;
        public onKeyPress : string;
        public text : string;
        private height;
        public limitLength : number;
        public countDisp : boolean;
        public value : string;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode): HTMLDivElement;
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
        private initEvent();
        private initJcountJS();
        private getTextAreaID();
        private getTextContID();
        public validateControl(): any;
        public validateRequired(): any;
        public validateMaxLength(): any;
        public validateMinLength(): any;
        public validateTextKind(): any;
        public validateUniqueCharactor(): any;
        public changedDisabled(): void;
    }
}
declare module Uz {
    class _TextBoxYubinNo extends Uz._TextBox {
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode): HTMLInputElement;
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
        public formatValidation(): boolean;
        public changeFormat(): void;
        public validateControl(): any;
        public validateTextKind(): any;
    }
}
declare module Uz {
    class _TextBoxDateRange extends Uz._ViewControl {
        private static DEFAULT_YMDKUBUN;
        private static DEFAULT_DISPLAY_DATE_FORMAT;
        private static DEFAULT_FROMDATE_ID;
        private static DEFAULT_ARROW_ID;
        private static DEFAULT_TODATE_ID;
        private _fromDate;
        private _arrow;
        private _toDate;
        private _rangeWidth;
        private _isDesignModeLocal;
        private _permitCharactor;
        private _ymdKubun;
        private _displayFormat;
        private _fromText;
        private _toText;
        private _fromValue;
        private _toValue;
        private _fromRequired;
        private _toRequired;
        private _isHolizontal;
        private _fromPlaceHolder;
        private _toPlaceHolder;
        private _minDate;
        private _maxDate;
        private _readOnly;
        private _isPassword;
        private _isPrivateInfo;
        private _onFocus;
        private _onBlur;
        private _onChange;
        private _onKeyPress;
        private _defaultPermitCharactor;
        public isDesignModeLocal : boolean;
        public rangeWidth : string;
        public fromDate : HTMLElement;
        public arrow : HTMLElement;
        public toDate : HTMLElement;
        public ymdKubun : Uz.YmdKubun;
        public displayFormat : Uz.DisplayFormat;
        public minDate : string;
        public maxDate : string;
        public fromValue : string;
        public toValue : string;
        public isHolizontal : boolean;
        public fromRequired : boolean;
        public fromPlaceHolder : string;
        public toRequired : boolean;
        public toPlaceHolder : string;
        public readOnly : boolean;
        public isPrivateInfo : boolean;
        public isPassword : boolean;
        public onFocus : string;
        public onBlur : string;
        public onChange : string;
        public onKeyPress : string;
        public fromText : string;
        public toText : string;
        public permitCharactor : string;
        public defaultPermitCharactor : string;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc: Function);
        public formatValidation(): boolean;
        public changeFormat(): void;
        public registProperty(): void;
        public changeWidth(): void;
        public rangeChangeWidth(oldWidth, newWidth): void;
        public createDomElement($parentElement, isDesignMode): HTMLDivElement;
        public createFromToDateChange(): void;
        private dateRangeTrigger(from, to);
        public createFromToDate(element): HTMLInputElement;
        public createArrow(): HTMLDivElement;
        public getEditablePropertyInfo(): any;
        public minMaxDateProperty(minMaxDate): Date;
        public initializeDatepickerProperty(): void;
        public initializeDatepicker(fromToStats): void;
        public initializeDatepickerSet(element, elementChg): void;
        public datepickerOnSelect(element): void;
        public datepickerOnClose(element): void;
        public beforeShowMinMaxSet(element, elementChg, filedName, maxMin): void;
        public displayFormatPropertyCheck();
        public inputTextDateConvert(element): void;
        public getDateRangeElement(val: string): JQuery;
        public bindData(data: any): void;
        private getFromDateAreaID();
        private getToDateAreaID();
        public validateControl(element: JQuery, isFrom: boolean): any;
        public validateRequired(element: JQuery, isFrom: boolean): any;
        public validateTextKind(element: JQuery): any;
        public validateInputDate(element: JQuery): any;
    }
}
declare module Uz {
    class _TextBoxDateRangeSlider extends Uz._TextBoxDateRange {
        private static DEFAULT_SLIDER_ID;
        private static DEFAULT_SLIDER_RANGE_DATE_MIN;
        private static DEFAULT_SLIDER_RANGE_DATE_MAX;
        private _sliderDate;
        private _sliderRangeDateMin;
        private _sliderRangeDateMax;
        public sliderDate : HTMLElement;
        public sliderRangeDateMin : string;
        public sliderRangeDateMax : string;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc: Function);
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        public changeWidth(): void;
        public rangeChangeWidthArrow(oldWidth, newWidth): void;
        public rangeChangeWidthArrowFree(oldWidth, newWidth): void;
        public createDomElement($parentElement, isDesignMode): HTMLDivElement;
        public createFromToDateChange(): void;
        public createFromToDate(element): HTMLInputElement;
        public createArrow(): HTMLDivElement;
        public createSliderDate(element, $parentElement);
        public initializeSlider(fieldName): void;
        public dateRangemSliderBase(): void;
        public rangeSliderDataSize(range1, range2, range3, range4): any[];
        public rangeSliderDataVal(fieldName, minDate, maxDate);
        public datepickerOnClose(element): void;
        public createSliderDisplaySize(element);
        public sliderDisplaySize();
        public bindData(data: any): void;
    }
}
declare module Uz {
    class _TextBoxTime extends Uz._TextBox {
        private _displayFormat;
        private _timeKubun;
        public displayFormat : Uz.DisplayFormat;
        public timeKubun : Uz.TimeKubun;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode): HTMLInputElement;
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
        public formatValidation(): boolean;
        private createEasyFormat();
        private changeDateTypeStringCommaSeparate(easyFormat);
        private changeDateTypeString1or2DigitNumber(easyFormat);
        private changeDateTypeString4DigitNumber(easyFormat);
        private changeDateTypeString6DigitNumber(easyFormat);
        private changeDateTypeStringJapanFormat(easyFormat);
        private change24Format(text, hourSeparatPosition);
        private changeSeparators(text);
        private searchMinuteAndSecond(text, mySeparatPosition, frontSeparatPosition);
        public changeFormat(): void;
        private setSeparators();
        private createHour(date, separators);
        private change2Digit(value);
        public validateControl(): any;
        public validateTextKind(): any;
        public validateUniqueCharactor(): any;
    }
}
declare module Uz {
    class _TreeView extends Uz._ViewControl {
        private _iconType;
        private _isDraggable;
        private _beforeData;
        private _selectedItems;
        private _dataSource;
        private _onClick;
        private _onDropped;
        private _treeViewJson;
        private _selectedItemsId;
        public iconType : Uz.IconType;
        public isDraggable : boolean;
        public selectedItems : TreeItem[];
        private getSelectedItemsId(data);
        private getSelectItemsFromData(selectItemsId, dataSource, selectedItems);
        private getSelectedItems(selectItemsId, nodeData, selectedItems);
        private serchSelectNodeItems(selectNodeItem, dataSource);
        private addSelectedItemsId(selectNodeItem, nodeItem);
        public dataSource : TreeItem[];
        private createDataSource(nodeJsonArray, parentTreeItem, dataSource);
        private createTreeItem(nodeJson, parentNodeText);
        private createDefaultDataSource();
        private createTreeViewJson(dataSource, parentId, parentJson);
        private createNodeJson(treeItem, id);
        public beforeData : TreeItem[];
        public onClick : string;
        public onDropped : string;
        public treeViewJson : Object[];
        public selectedItemsId : string[];
        constructor($parentElement: JQuery, isDesignMode: boolean);
        private bindJstree();
        private createJstreeOption();
        public createDomElement($parentElement, isDesignMode: boolean): HTMLDivElement;
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
    }
    class TreeItem {
        public childNodes: TreeItem[];
        public text: string;
        public isOpen: boolean;
        public hasChildNode: boolean;
        public parent: string;
        public id: string;
        constructor();
        public setTreeeItem(treeItem): void;
        public treeItemEquals(targetTreeItem: TreeItem): boolean;
    }
}
declare module Uz {
    class _SortableList extends Uz._ViewControl {
        private static DEFAULT_DATASOURCETITLE_ID;
        private static DEFAULT_SELECTEDSOURCETITLE_ID;
        private static DEFAULT_DATASOURCELIST_ID;
        private static DEFAULT_SELECTEDSOURCELIST_ID;
        private static DEFAULT_SELECTBUTTON_ID;
        private static DEFAULT_REMOVEBUTTON_ID;
        private static DEFAULT_DATASOURCELISTALLRELEASEBUTTON_ID;
        private static DEFAULT_DATASOURCELISTALLSELECTBUTTON_ID;
        private static DEFAULT_SELECTEDSOURCELISTALLSELECTBUTTON_ID;
        private static DEFAULT_SELECTEDSOURCELISTALLRELEASEBUTTON_ID;
        private static DEFAULT_SELECTEDSOURCELISTSORTBUTTON_ID;
        private _onChange;
        private _required;
        private _selectedSourceTitle;
        private _dataSourceTitle;
        private _minSelectedItem;
        private _maxSelectedItem;
        private _dataSource;
        private _selectedItems;
        private _dataSourceTitleElement;
        private _selectedSourceTitleElement;
        private _dataSourceListElement;
        private _selectedSourceListElement;
        private _selectButtonElement;
        private _removeButtonElement;
        private _dataSourceListAllSelectButtonElement;
        private _dataSourceListAllReleaseButtonElement;
        private _selectedSourceListAllSelectButtonElement;
        private _selectedSourceListAllReleaseButtonElement;
        private _selectedSourceListSortButtonElement;
        public selectedSourceTitle : string;
        public dataSourceTitle : string;
        public minSelectedItem : number;
        public maxSelectedItem : number;
        private addDefaultDataSource(dataSource);
        public dataSource : SortableListDataItem[];
        public selectedItems : SortableListDataItem[];
        private getSortableListDataItemInList(targetElement);
        private setListHeight();
        public onChange : string;
        public required : boolean;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        private bindSortableAndSelectable(sourceList, connectListId);
        private bindMoveNode();
        private moveNode(sourceList, connectList);
        private bindAllSelectAndAllRelease();
        private allSelect(tagetList);
        private allRelease(tagetList);
        private bindSort();
        private sortList(tagetList);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode: boolean): HTMLElement;
        private createTitleArea();
        private createListArea();
        private createDataSourceListArea();
        private createButtonArea();
        private createSelectedSourceListArea();
        private createOuterDiv();
        private createInnerDiv(className);
        private createTitle(id);
        private createList(id);
        private createButton(id, text);
        private createListContent(targetList, source);
        private createLi(key, value, sortKey);
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
        public validateControl(): any;
        public validateMaxSelect(): any;
        public validateMinSelect(): any;
    }
    class SortableListDataItem {
        public key: string;
        public value: string;
        public sortKey: string;
        constructor(key: string, value: string, sortKey: string);
    }
}
declare module Uz {
    class _ControlRepeater extends Uz._ViewControl {
        private _repeateData;
        public repeateData : any;
        private setCompositeControlJson(templateControlJson, templateControlFieldName);
        private bindCompositeControl(control, childrenElements, targetRepeateData);
        private repeateJScontrol(repeateData);
        private createNewCompositeControl(templateControl, createCount, idCount);
        private createNewJSControl(templateControl, createCount, idCount);
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode): HTMLDivElement;
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
    }
}
declare module Uz {
    class _DynamicImage extends Uz._ViewControl {
        private _src;
        public src : string;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public createDomElement($parentElement, isDesignMode: boolean): HTMLImageElement;
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
    }
}
declare module Uz {
    class _StaticImage extends Uz._ViewControl {
        private _src;
        public src : string;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public createDomElement($parentElement, isDesignMode: boolean): HTMLImageElement;
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
    }
}
declare module Uz {
    class _ButtonDivPopup extends Uz._Button {
        private static DEFAULT_IMG_TEMP_ID;
        private static DEFAULT_BTN_TEMP_ID;
        private _targetPanelName;
        private _modeless;
        private _modalPanel;
        private _foldIconSpan;
        private _closeIconSpan;
        private _childHiddenPanels;
        public targetPanelName : string;
        public modeless : boolean;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode: boolean): HTMLButtonElement;
        public recreateDomElement(isImage: boolean): void;
        public getEditablePropertyInfo(): any;
        private openModalPanel();
        private loadModalPanel();
        private displayModalPanel(sign);
        private adjustCenter();
        public bindData(data: any): void;
    }
}
declare module Uz {
    class _TableCell extends Uz._ViewControl {
        private _connectTd;
        public connectTd : string;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public createDomElement($parentElement, isDesignMode: boolean): HTMLDivElement;
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        private selectParentTablePanel(selectedControl);
        public bindData(data: any): void;
    }
}
declare module Uz {
    class _TablePanel extends Uz._ViewControl {
        static DEFAULT_HTML: string;
        private _html;
        public html : string;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        private getTempDivJQueryElement();
        private getTableAreaJQueryElement();
        private createTableHtml();
        private backupTableCell();
        private restoreTableCell();
        private rebuildTableCell();
        private revmoveDisusedTableCell();
        private addNewTableCell();
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode): HTMLDivElement;
        public getEditablePropertyInfo(): any;
        static checkHtml(inputText: string): string;
        public bindData(data: any): void;
    }
}
declare module Uz {
    class _TextBoxKana extends Uz._TextBox {
        private static DEFAULT_KANATYPE;
        private static DEFAULT_KANJI_IN_TEXTBOX_ID;
        private _kanaType;
        private _kanjiInField;
        public kanaType : Uz.KanaType;
        public kanjiInField : string;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode): HTMLInputElement;
        public getEditablePropertyInfo(): any;
        public getKanjiInFeildInfo(): any;
        public bindData(data: any): void;
        static initConvertKanaAll(): void;
        public formatValidation(): boolean;
        static particularValidation(formatText: string): boolean;
    }
}
declare module Uz {
    class _Label extends Uz._ViewControl {
        private _align;
        private _text;
        private _isPrivateInfo;
        public text : string;
        public align : Uz.Align;
        public isPrivateInfo : boolean;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode): HTMLSpanElement;
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
    }
}
declare module Uz {
    class _ListControl extends Uz._ViewControl {
        private _dataSource;
        private _selectedItem;
        private _onChange;
        private _required;
        public dataSource : ListControlDataPair[];
        public updateUIforDataSource(): void;
        private addDefaultDataSource();
        public onChange : string;
        public selectedItem : string;
        public _getSelectedItemCore(): ListControlDataPair;
        private __selectedItemForBeforeBindingDataSource;
        public updateUIForSelectedItem(value: string): void;
        public required : boolean;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc: Function);
        public registProperty(): void;
        public createIDWithKey(key: string): string;
        public getEditablePropertyInfo(): any;
        private createDataSourceColumnInfo();
    }
    class ListControlDataPair {
        public key: string;
        public value: string;
        constructor(key: string, value: string);
    }
}
declare module Uz {
    class _ListControlUtil {
        static createLabelFor(htmlElement, key): HTMLLabelElement;
        static createIDForItemInDiv(divID: string, itemKey: string): string;
    }
}
declare module Uz {
    class _DropDownList extends Uz._ListControl {
        private _onFocus;
        private _onBlur;
        public onFocus : string;
        public onBlur : string;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public updateUIForSelectedItem(selectedItem: string): void;
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode: boolean): HTMLSelectElement;
        public updateUIforDataSource(): void;
        public _getSelectedItemCore(): Uz.ListControlDataPair;
        private createDropDownList();
        private createOption(key, value);
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
        public validateControl(): any;
        public validateRequired(): any;
    }
}
declare module Uz {
    class _CheckBoxList extends Uz._ListControl {
        private _onClick;
        private _newLineItemNumber;
        private _minCheckedItem;
        private _maxCheckedItem;
        private _selectedItems;
        public selectedItems : Uz.ListControlDataPair[];
        public onClick : string;
        public newLineItemNumber : number;
        public minCheckedItem : number;
        public maxCheckedItem : number;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        private updateSelectedItems();
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode: boolean): HTMLDivElement;
        public updateUIforDataSource(): void;
        private createCheckBoxList();
        private createCheckBox(key, value);
        public getEditablePropertyInfo(): any;
        private createSelectedItemsColumnInfo();
        public bindData(data: any): void;
        public validateControl(): any;
        public validateRequired(): any;
        public validateMaxSelect(): any;
        public validateMinSelect(): any;
    }
}
declare module Uz {
    class _RadioButton extends Uz._ListControl {
        private _groupName;
        private _onClick;
        private _newLineItemNumber;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        public groupName : string;
        private updateUIForGroupName();
        public onClick : string;
        public newLineItemNumber : number;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        private getGroupName();
        public registProperty(): void;
        public updateUIForSelectedItem(selectedItem: string): void;
        public _getSelectedItemCore(): Uz.ListControlDataPair;
        public createDomElement($parentElement, isDesignMode: boolean): HTMLDivElement;
        public updateUIforDataSource(): void;
        private createRadioButton();
        private createRdaioButton(key, value);
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
        public validateControl(): any;
        public validateRequired(): any;
    }
}
