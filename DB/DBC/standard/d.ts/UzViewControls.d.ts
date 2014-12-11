declare module Uz {
    enum _ViewControlType {
        TextBox,
        TextBoxMultiLine,
        TextBoxCode,
        TextBoxNum,
        TextBoxNumRange,
        TextBoxNumSpinner,
        TextBoxDate,
        TextBoxDateRange,
        TextBoxFlexibleDate,
        TextBoxDateRangeSlider,
        TextBoxYubinNo,
        TextBoxTime,
        TextBoxTimeRange,
        TextBoxDateTimeRange,
        TextBoxKana,
        Button,
        ButtonPublish,
        ButtonReportCommon,
        ButtonPreview,
        ButtonPrint,
        ButtonPrinter,
        ButtonPrinterList,
        ButtonReportPublish,
        ButtonDownLoad,
        ButtonDialog,
        ButtonBatchParameterRestore,
        ButtonBatchParameterSave,
        ButtonBatchRegister,
        ButtonBatchReserve,
        CharacterFontLabel,
        CharacterHelperButtonDialog,
        DropDownList,
        CheckBoxList,
        RadioButton,
        SegmentedControl,
        SortableList,
        ControlRepeater,
        TabContainer,
        TabPanel,
        DataGrid,
        Label,
        UploadPanel,
        StaticImage,
        ImageDialog,
        DynamicImage,
        TreeView,
        Panel,
        PanelPublish,
        PanelBatchParameter,
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
        TextBoxShogakkokuCode,
        TextBoxChugakkokuCode,
        TextBoxYear,
        TextBoxYearMonth,
        TextBoxYearMonthDay,
        Icon,
        HorizontalLine,
        VerticalLine,
        TextBoxFlexibleYear,
        TextBoxFlexibleYearMonth,
        Space,
        Calendar,
    }
    enum _CommonButtonType {
        CommonButtonNext,
        CommonButtonBack,
        CommonButtonComplete,
        CommonButtonSelectableComplete,
        CommonButtonConfirm,
        CommonButtonSearch,
        CommonButtonUpdate,
        CommonButtonFree,
        CommonButtonReportPublish,
        CommonButtonCreate,
        CommonButtonExecute,
        CommonButtonSearchResult,
        CommonButtonReSearch,
        CommonButtonApprovalRequest,
        CommonButtonReject,
        CommonButtonApprove,
        CommonButtonAccept,
        CommonButtonSend,
        CommonButtonReceive,
        CommonButtonImport,
        CommonButtonBatchRegister,
        CommonButtonBatchReserve,
        CommonButtonDownload,
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
        static getJSONInfoAll(control): {};
        private static DefaultControlList;
        private static createDefaultControl(control);
        static initHelpButton(state: boolean): void;
        static moveHelpIcon(): void;
        static removeHelpIcon(): void;
        static changeHelpMode(): void;
        private static drawHelpIcon(targetObject);
        private static onSelectHelpIcon(control);
        private static openHelpDialog(targetObject);
        static closeHelpMode(): void;
        private static createHelpMessageListForHelpDialog(targetObject);
        private static getDistinctMessage(targetObject);
        static getHelpRelationControl(): any[];
        static getHelpRelationControlMain(selector): any[];
        static getHelpRelationControlOnDisplay(): any[];
        static beforeCapture(): void;
        private static drawMaskEntryPoint();
        private static drawMask(selector);
        static afterCapture(): void;
        static getTextBoxTypeEditableProperty(value: string, enabled?: boolean): {};
        static getSelectTypeEditableProperty(selectedValue: string, eNum: any, enabled?: boolean): {};
        static getSelectTypeEditablePropertyForSelectNum(selectedValue: string, eNum: any, enabled?: boolean): {};
        static getSelectTypeEditablePropertyForDynamicData(selectedValue: string, data: string[], enabled?: boolean): {};
        static getComboboxTypeEditableProperty(selectedValue: string, eNum: any, enabled?: boolean): {};
        static getCheckBoxTypeEditableProperty(value: boolean, enabled?: boolean): {};
        static getButtonTypeEditableProperty(buttonText: string, callBackFunction: Function): {};
        static getGridTypeEditableProperty(columnInfos: any[], rowData: any[], enabled?: boolean, validation?: Function, customFunc?: Function, canAddDelete?: boolean): {};
        static getPropertyColumnInfo(name: string, editType: PropertyEditType, editOptions?: any, width?: number, editable?: boolean, frozen?: boolean, defaultVal?: any): {};
        private static getDefaultValString(editType, editOptions, defaultVal);
        static getUniqueId(): string;
        static removeControl(parentControl: Uz._JSControl, targetFieldName: string): void;
        static removeControlAll(jsControl: Uz._JSControl): void;
        static getJSControlParent(ancestorControl: Uz._JSControl, fieldName: string): Uz._JSControl;
        static getJSControl(fieldName: string): Uz._JSControl;
        private static searchLazyLoadingJSControl(targetFieldName, lazyLoadingControls);
        private static getJSControlElementFromDistal(splitedFieldName, searchFieldName, distalCounter);
        static setJSControl(element: Element, jsControl: Uz._JSControl): void;
        static removeLinkedData(element: Element): void;
        static getJSControlForType(ancestorControl: Uz._JSControl, controlType: string, searchInCommon?: boolean): Uz._JSControl[];
        static getTargetControlItemsIndex(parentControl: Uz._JSControl, targetControlFieldName: string);
        static getCompositeRoot(control: Uz._JSControl): Uz._JSControl;
        static getCompositeRootExcludeArgumentControl(control: Uz._JSControl): Uz._JSControl;
        static isPropertyPublishing(compositeControl: any, controlName: string, propertyName: string): boolean;
        static getDomIdFromCompositeFieldName(rootControl: any, fieldName: string): string;
        static getCompositeFieldNameFromDomId(domId: string): string;
        static setFocus(setFocusId: string): void;
        static forEachItemsRecursively(control: Uz._JSControl, iterator: Function, applyBefore?: boolean): void;
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
        Custom,
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
        private createCustomErrorMessage(rule, propertyName, propertyValue);
        private pushErrorMessage(errorMessage, errorMessageArray);
    }
}
declare module Uz {
    interface _IJSControlsInDesign {
        getEditablePropertyInfo(): any;
        registProperty(): void;
    }
    class _JSControl implements _IJSControlsInDesign {
        private _isInit;
        private _fieldName;
        private _items;
        private _controlType;
        private _rules;
        private _saveDesignItem;
        private _designObj;
        public designObj : any;
        public isInit : boolean;
        public fieldName : string;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        public items : _JSControl[];
        public controlType : any;
        public rules : Object;
        constructor();
        public getJQueryElement(isCoreElement?: boolean): JQuery;
        public getJQueryRangeElement(val: string): JQuery;
        public getJQueryFieldNameAddElement(val: string): JQuery;
        public getFromAreaID(): string;
        public getToAreaID(): string;
        public getFieldNameAddID(val: string): string;
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        public validateControl(): any;
        public afterPropertiesSet(): void;
        public resizeControl(): void;
        public setProperty(properties, parentCommonChildDivFieldName?: string): void;
        public setPropertyItem(property: string, data): void;
        public initRuntime($element: JQuery): void;
        public initRules(): void;
        public getProperty(): any;
        public beforeSaveDesign(): any;
        public afterSaveDesign(): void;
        public saveDesignItem : any;
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
    enum SizeOfSML {
        S,
        M,
        L,
    }
    enum SizeForGridHeight {
        XS,
        S,
        M,
        L,
        XL,
        Auto,
    }
    enum SizeForPanelHeight {
        XS,
        S,
        M,
        L,
        XL,
        Auto,
    }
    enum SizeForMargin {
        XS,
        S,
        M,
        L,
        XL,
        Default,
    }
    enum LumpSizeForContorol {
        S,
        M,
        L,
    }
    enum LumpSizeForPanel {
        S,
        M,
        L,
    }
    enum SizeForLine {
        XS,
        S,
        M,
        L,
        XL,
        Default,
    }
    enum GridSizeForPanel {
        G1,
        G2,
        G3,
        G4,
        G5,
        G6,
        G7,
        G8,
        G9,
        G10,
        G11,
        G12,
    }
    enum SizeForSpaceHeight {
        XS,
        S,
        M,
        L,
        XL,
    }
    enum SizeForSpaceWidth {
        XS,
        S,
        M,
        L,
        XL,
        Default,
    }
    enum SizeForTabContainer {
        S,
        M,
        L,
        G1,
        G2,
        G3,
        G4,
        G5,
        G6,
        G7,
        G8,
        G9,
        G10,
        G11,
        G12,
    }
    enum SizeForTabContainerHeight {
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
    enum DataIO {
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
        Number,
    }
    enum TextKind {
        "All",
        "半角文字すべて",
        "英数字のみ",
        "カナすべて(全半角)",
        "半角カナ",
        "数字のみ",
    }
    enum TimeKubun {
        "時",
        "時分",
        "時分秒",
    }
    enum DisplayFormat {
        "24hh:mm",
        "24hh時mm分",
        "午前hh時mm分",
        "AMhh:mm",
    }
    enum befoerDisplayFormat {
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
        "YYYY.MM.DD",
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
        Success,
    }
    enum KanaType {
        "全角カナ",
        "半角カナ",
        "全角かな",
    }
    enum Icon {
        Info,
        Question,
        Warning,
        Error,
        Check,
        File_Ari,
        Complete,
        Person_Jumin,
        Person_NoJumin,
        Mansion,
        Sharer,
        Corporation,
        Person,
        Incomplete,
        BarcodeReader,
        Person_Jutonai,
        Person_Jutogai,
        Person_Japanese,
        Person_Foreigner,
        SuccessCompletion,
    }
    enum IconJapaneaseName {
        "インフォメーション",
        "クエスチョン",
        "警告",
        "エラー",
        "レ点",
        "資料",
        "済み",
        "住民",
        "住民以外",
        "マンション",
        "共有者",
        "法人",
        "個人",
        "未",
        "バーコードリーダー",
        "住登内",
        "住登外",
        "日本人",
        "外国人",
        "緑レ点",
    }
    enum IconButton {
        NONE,
        Info,
        Question,
        Warning,
        Error,
        Check,
        File_Ari,
        Complete,
        Person_Jumin,
        Person_NoJumin,
        Mansion,
        Sharer,
        Corporation,
        Person,
        Incomplete,
        BarcodeReader,
        Person_Jutonai,
        Person_Jutogai,
        Person_Japanese,
        Person_Foreigner,
        SuccessCompletion,
    }
    enum IconButtonJapaneaseName {
        "NONE",
        "インフォメーション",
        "クエスチョン",
        "警告",
        "エラー",
        "レ点",
        "資料",
        "済み",
        "住民",
        "住民以外",
        "マンション",
        "共有者",
        "法人",
        "個人",
        "未",
        "バーコードリーダー",
        "住登内",
        "住登外",
        "日本人",
        "外国人",
        "緑レ点",
    }
    enum Appearance {
        Default,
        ATag,
        Image,
    }
    enum PanelDisplay {
        Normal,
        GroupBox,
        Detail,
    }
    enum ParentState {
        Disable,
        Enable,
        ReadOnly,
    }
    enum FileListDisplayNumber {
        Auto,
        "1件",
        "5件",
        "10件",
    }
}
declare module Uz {
    class GyomuJSHelper {
        static gyomuOriginalEventList: any[];
        static registOriginalEvent(eventName: string, callBackFunction: Function): void;
        static transitionEventFire(eventName: string): void;
        static isDesignMode(): boolean;
        static getJSControl(fieldName: string): Uz._JSControl;
        static getCompositeChildControl(compositeControlFieldName: string, compositeControlName: string, childControlFieldName: string): Uz._JSControl;
        static setPankuzuReadOnly(stateName: string, layoutName: string, subGyomuCode: string, isReadOnly: boolean): void;
    }
}
declare module Uz {
    class _ViewControl extends Uz._JSControl {
        private _width;
        private _visible;
        private _displayNone;
        private _disabled;
        private _parentState;
        private _accessKey;
        private _nextFocusFiledName;
        private _wrap;
        private _float;
        private _toolTip;
        private _authorityMode;
        private _marginLeft;
        private _marginRight;
        private _selectControlID;
        private _helpMessageID;
        private _jpControlName;
        private static DEFAULT_SELECTEDSOURCELISTSORTBUTTON_ID;
        private static DEFAULT_TABPANEL_ID;
        public _isDesignMode: boolean;
        public nextFocusFiledName : string;
        public helpMessageID : string;
        public width : any;
        public convertWidth(value): any;
        public changeWidth(): void;
        public changeWidthParameter(oldWidth, newWidth): void;
        public bindWidth(value): void;
        public visible : boolean;
        public displayNone : boolean;
        public changedDisplayNone(oldValue): void;
        public addDisplayRelatedClass(): void;
        public disabled : boolean;
        public parentState : Uz.ParentState;
        public accessKey : string;
        public nextFocusFieldName : string;
        public wrap : boolean;
        public wrapChanged(beforeValue, afterValue): void;
        public float : Uz.Float;
        public toolTip : string;
        public authorityMode : Uz.AuthorityMode;
        public _onAuthoritySet(): void;
        public marginLeft : any;
        public marginRight : any;
        private checkValidMarginLeftRight();
        private setMarginLeftRight();
        private setDisabledMargin(isDisabled);
        public setDisabledWidthAuto(isDisabled: boolean): void;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        private changeFieldName(beforeFieldName, newFieldName);
        public selectControlID : string;
        public jpControlName : string;
        constructor($parentElement?: JQuery, isDesignMode?: boolean, createDomElementFunc?: Function);
        public initToolTip(element: HTMLElement): void;
        public getJQueryElement(isCoreElement?: boolean): JQuery;
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        public createComboboxTypeDisabledProperty(editablePropertyInfo: any, keyName: string, selectedValue: string, eNum: any, enabled?: boolean);
        static createViewControl(controlType: Uz._ViewControlType, $parentElement: JQuery, isDesignMode: boolean): Uz._JSControl;
        private static isUzControl(controlTypeName);
        public moveNextField(element: HTMLElement): void;
        public setNextFocus(shiftKey: boolean): boolean;
        public canAcceptFocus(): boolean;
        public setFocus(shiftKey: boolean): boolean;
        private getNextFocusFieldName();
        private getPrevFocusFieldName();
        private findNextFocusFieldName(target);
        public handlesDefaultNextFocus(shiftKey: boolean): boolean;
        public fireEvent(eventName: string, triggerControlInfo?: any): void;
        private fireUploadEvent(eventName);
        private static mergeLoadSequence(fireEventPanels, fireEventPanelsParent, loadSequencePanelNames, eventName, aliasEventName);
        private static searchInLoadSequenceByFireEventPanelName(fireEventPanelNames, loadSequencePanelNames);
        private static moveLoadSequencePanel(loadSequencePanelNames, fireEventPanelParentFieldName, foundIndex);
        private static selectTargetLoadSequencePanelNamesIndex(loadSequencePanelNames, fireEventPanelParent, foundIndexes);
        private getParentCommonChildDiv(target);
        private executeGyomuFunction(eventName);
        private executeGridActionFunction(actionName);
        private static raiseCallBackIfNoEventFired(triggerControlInfo, fireEventPanels);
        public getRequestUrl(eventName: string): string;
        public bindData(data: any): void;
        public receivedResponse(triggerControlInfo: any): void;
        public getData(): any;
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        public changedVisible(): void;
        public changedDisabled(): void;
        public changedParentState(): void;
        public changeStateOfControl(): void;
        public hasDisabled(): boolean;
        public changeTabIndex(): void;
        public initRuntime($element: JQuery): void;
        public createDomElement($parentElement: JQuery, isDesignMode: boolean): HTMLElement;
        public createDOMElement($parentElement: JQuery, isDesignMode: boolean): HTMLElement;
        public initDesign($parentElement: JQuery): void;
        public getProperty(): any;
        public getElementForFocus(): JQuery;
    }
    class PanelWithEventName {
        private _panel;
        private _eventName;
        constructor(_panel: Uz._IStateChangable, _eventName);
        public panel : Uz._IStateChangable;
        public eventName : any;
    }
    class Dependency {
        public dependTo: string;
        public dependValue: string;
        public expression: Uz.Expression;
        public myCondition: Uz.Constraint;
    }
    class TriggerControlInfo {
        public fieldName: string;
        public fireEventPropertyName: string;
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
        duplicationParentClassFieldName,
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
        private valiateDuplicationParentClassFieldName(rule, rowDatas);
        private createDuplicationParentClassFieldNameError(parentClassId, rowDatas);
    }
}
declare module Uz {
    class _Panel extends Uz._ViewControl implements Uz._IStateChangable {
        static DEFAULT_BODYAREA_ID: string;
        static DEFAULT_HEADERAREA_ID: string;
        public _panelBodyDom: HTMLElement;
        public _panelHeaderDom: HTMLElement;
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
        private _eraseBorder;
        private _widthAuto;
        private _readOnly;
        private _isFirstLoadFinished;
        private _panelDisplay;
        private _isGroupBox;
        private _height;
        private _focusPositionID;
        private _canPost;
        private _decorationClass;
        private _closingNow;
        public isFirstLoadFinished : boolean;
        public title : string;
        public isOpen : boolean;
        public canOpenAndClose : boolean;
        private keepHeaderWidth(beforeWidth);
        private changePanelHeaderIcon();
        public changePanelBodyVisible(): void;
        private changePanelHeaderBorderRadius();
        private changePanelHeaderIconVisible();
        public postParameterPanelNames : Object[];
        public requestSettings : RequestSettings[];
        public hiddenInput : Object[];
        public onLoad : string;
        public onOpen : string;
        public onClose : string;
        public session : any;
        public marginTop : any;
        public backgroundColor : Uz.Color;
        public changeMarginTop(): void;
        public marginBottom : any;
        public changeMarginBottom(): void;
        public eraseBorder : boolean;
        public widthAuto : boolean;
        public panelDisplay : any;
        public height : any;
        private clearCssClass(value);
        private addCssClass(value);
        public readOnly : boolean;
        public isGroupBox : boolean;
        public focusPositionID : any;
        public canPost : boolean;
        public decorationClass : string;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public changeWidth(): void;
        public createCheckBoxTypeDisabledProperty(editablePropertyInfo: any, keyName: string, value: boolean, enabled?: boolean);
        public afterPropertiesSet(): void;
        public showLoading(): void;
        public hideLoading(): void;
        public childInChildDivOnLoad(): void;
        public setFocusForPanel(focusId: string): void;
        public bindData(data: any): void;
        public setPropertyItemForHiddenInput(data): void;
        private getPanelBodyAreaID();
        private getPanelHeaderAreaID();
        public resetChildControl(): void;
        public layoutedChildControl(): void;
        private panelSetMinWidth(bodyAreaID);
        public changeStateOfControl(): void;
        public changeStateOfControlPanel(): void;
        public setDisabledWidthAuto(isDisabled: boolean): void;
        private isSizeEnum(width);
        public getSizeEnumToGridSizeEnum(width: any): any;
        public _onAuthoritySet(): void;
        private initPanelOpener($element);
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public createDOMElement($parentElement: JQuery): HTMLDivElement;
        public isSelectedInDesignPanel(): void;
    }
    class RequestSettings {
        public eventName: string;
        public requestUrl: string;
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
        public recreateDomElement(isImage: boolean): void;
        public bindData(data: any): void;
        public initRuntime($element: JQuery): void;
        public clickButtonHandler(): void;
        public startDownload(postParameter: any): void;
        public getProperty(): any;
        public createDOMElement($parentElement): HTMLButtonElement;
    }
}
declare module Uz {
    class _ButtonReportCommon extends Uz._ViewControl {
        private static BASE_URL;
        private _reportButtonText;
        private _postParameterPanelNames;
        private _validateUrl;
        private _isModal;
        private _isInstruation;
        private _isPreview;
        private _printable;
        private _copiesChangeable;
        private _progressVisible;
        private _printButtonVisible;
        public baseUrl(): string;
        public reportButtonText : string;
        public postParameterPanelNames : Object[];
        public validateUrl : string;
        public isModal : boolean;
        public isInstruction : boolean;
        public isPreview : boolean;
        public printable : boolean;
        public copiesChangeable : boolean;
        public progressVisible : boolean;
        public printButtonVisible : boolean;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc?: Function);
        public bindData(data: any): void;
        public createQueryStrings(type: number, subGyomuCode: string, reportId: string, reportIndex: number): string;
        public createPrintButtonVisibleQueryStrings(): string;
        private static toPritButtonVisibleNumber(printButtonVisible);
        public createTokenIdQueryStrings(): string;
        public createOptions(width: number, height: number, resizable: string, scroll: string): string;
        public concatArrays(options: string[]): string;
        public getPrintType(): any;
        static getPostParamter(postParameterPanelNames: any[]): any[];
        public initRuntime($element: JQuery): void;
        public createDOMElement($parentElement, isDesignMode: boolean): HTMLButtonElement;
    }
    enum _PrintType {
        DIRECT,
        PRINT_PREVIEW_ONLY,
        PRINT_SETTING,
        PRINT,
        HIDE_VIEW_XBAP_CALLING,
    }
    class _ReportPublishResponseUserData {
        public data: _ReportSourceData[];
    }
    class _ReportSourceData {
        public subGyomuCode: string;
        public reportId: string;
        public reportIndex: {
            reportIndex: string;
        };
    }
}
declare module Uz {
    class _ButtonReportPublish extends Uz._ButtonReportCommon {
        private static DEFAULT_LABEL;
        private _sourceCreateUrl;
        private _afterPrintUrl;
        public sourceCreateUrl : string;
        public afterPrintUrl : string;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc?: Function);
        private onClick_btnReportPublish();
        private validateCallBack(response);
        private validateFailedCallBack(response);
        public publishCallBack(response: any): void;
        private showDialogMultiple(sourceDataList);
        private validSourceDataInfo(sourceData);
        private publishFailedCallBack(response);
        private doAfterPrintCallBack(response);
        private doAfterPrintFailedCallBack(response);
        private showDialog(sourceDataInfoList);
        public getPrintType(): number;
        public initRuntime($element: JQuery): void;
        public createDOMElement($parentElement): HTMLButtonElement;
    }
}
declare module Uz {
    class _ButtonPrinter extends Uz._ButtonReportCommon {
        private static DEFAULT_LABEL;
        private _subGyomuCode;
        private _reportId;
        private _printerNameCallBack;
        public subGyomuCode : string;
        public reportId : string;
        public printerNameCallBack : (value: string) => void;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc?: Function);
        private onClick_btnPrinter();
        private validateCallBack(response);
        private validateFailedCallBack(response);
        private showDialog(subGyomuCode, reportId);
        public getPrintType(): number;
        public initRuntime($element: JQuery): void;
        public createDOMElement($parentElement, isDesignMode: boolean): HTMLButtonElement;
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
        private static DEFAULT_ICON_HEADER;
        private static DEFAULT_ICON_TRALER_PNG;
        private static DEFAULT_ICON_TRALER_GIF;
        private static HEIGTH_MATCHES_TEXTBOX;
        private static WIDTH_MATCHES_TEXTBOX;
        private static DEFAULT_ICONSPAN_PADDING;
        private _text;
        private _appearance;
        private _imageFileUrl;
        private _onClick;
        private _imageWidth;
        private _imageHeight;
        private _icon;
        private _iconFileUrl;
        private _iconDirs;
        private _heightTextBoxMatches;
        private _onBeforeClick;
        private _onAfterClick;
        public onClick : string;
        public onBeforeClick : string;
        public onAfterClick : string;
        public text : string;
        public changeText(): void;
        public appearance : Uz.Appearance;
        public imageFileUrl : string;
        public imageHeight : any;
        public imageWidth : any;
        public icon : any;
        private iconSpanWidth(status);
        public heightTextBoxMatches : boolean;
        private setHeightTextBoxMatchesForButton();
        private setHeightTextBoxMatchesForImage(isChange);
        public setMargin(): void;
        public setWidth(): void;
        public changeWidth(): void;
        constructor($parentElement?: JQuery, isDesignMode?: boolean, createDomElementFunc?: Function);
        public recreateDomElement(isImage: boolean): void;
        public bindData(data: any): void;
        public receivedResponse(triggerControlInfo: Uz.TriggerControlInfo): void;
        private checkValidateInputError();
        private checkValidateServerError();
        private isDialogCancelButton();
        public clickRequest(): void;
        public changeStateOfControl(): void;
        public reSizeHeightImage(isHeightValue: boolean): void;
        public reSizeWidthImage(isWidthValue: boolean): void;
        private setDisabledImageProperty(isDisabled);
        private setDisabledImageHeightAndWidth(isDisabled);
        private setDisabledTextProperty(isDisabled);
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public applyCommonButtonData(properties: any): void;
        public createDOMElement($parentElement): HTMLButtonElement;
    }
}
declare module Uz {
    class _ButtonDialog extends Uz._Button {
        private _displayChildDivName;
        private _dataPassing;
        private _visibleCloseButton;
        private _onOkClose;
        private _onCancelClose;
        private _onBeforeOpenDialog;
        public displayChildDivName : string;
        public dataPassing : Object[];
        public visibleCloseButton : boolean;
        public onOkClose : string;
        public onBeforeOpenDialog : string;
        public onCancelClose : string;
        constructor($parentElement?: JQuery, isDesignMode?: boolean, createDomElementFunc?: Function);
        public createDomElement($parentElement, isDesignMode: boolean): HTMLButtonElement;
        public bindData(data: any): void;
        public waitLoadingForButtonDialog(thisInstance): void;
        public recreateDomElement(isImage: boolean): void;
        public bindRuntimeForButtonDialog(): void;
        public initRuntime($element: JQuery): void;
        public createDOMElement($parentElement): HTMLButtonElement;
    }
}
declare module Uz {
    class _ButtonPrinterList extends Uz._ButtonDialog {
        private static PRINTER_LIST_DIV_NAME;
        private static PRINTERLISTDIV_EVENT_DATAPASSINGCOMPLETE;
        private _getReportListUrl;
        private _postParameterPanelNames;
        public getReportListUrl : string;
        public postParameterPanelNames : Object[];
        constructor($parentElement?: JQuery, isDesignMode?: boolean, createDomElementFunc?: Function);
        public recreateDomElement(isImage: boolean): void;
        public bindData(data: any): void;
        private bindClickEvent();
        private onClick_buttonPrinterList(data);
        private onClick_PrinterListButton();
        private openPrinterListCommonChildDiv(closeFunction);
        private waitDialogOpen(data, closeFunction);
        private executeAfterPrinterListDivClose(closeFunction);
        private validateResponceData(response);
        private setPrinterListDivParameter(response);
        private fireEventLoadPrinterList();
        private getPrinterSettingList();
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public createDOMElement($parentElement): HTMLButtonElement;
    }
}
declare module Uz {
    class _ButtonPrint extends Uz._ButtonReportCommon {
        private static DEFAULT_LABEL;
        private static DIRECT_URL;
        private _sourceCreateUrl;
        private _afterPrintUrl;
        private directUrl();
        public sourceCreateUrl : string;
        public afterPrintUrl : string;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc?: Function);
        private onClick_btnPrint();
        private validateCallBack(response);
        private validateFailedCallBack(response);
        private publishCallBack(response);
        private showDialogMultiple(sourceDataList);
        private validSourceDataInfo(sourceData);
        private publishFailedCallBack(response);
        private doAfterPrintCallBack(response);
        private doAfterPrintFailedCallBack(response);
        private showDialog(sourceDataInfoList);
        public getPrintType(): number;
        public initRuntime($element: JQuery): void;
        public createDOMElement($parentElement, isDesignMode: boolean): HTMLButtonElement;
    }
}
declare module Uz {
    class _ButtonPreview extends Uz._ButtonReportCommon {
        private static DEFAULT_LABEL;
        private _dialogTop;
        private _dialogLeft;
        private _dialogWidth;
        private _dialogHeight;
        private _sourceCreateUrl;
        private _afterPrintUrl;
        public sourceCreateUrl : string;
        public afterPrintUrl : string;
        public dialogTop : string;
        public dialogLeft : string;
        public dialogWidth : string;
        public dialogHeight : string;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc?: Function);
        private isNumber(value);
        private toInt(value);
        private createPreviewOptions(top, left, width, height, resizable, scroll);
        private onClick_btnPreview();
        private validateCallBack(response);
        private validateFailedCallBack(response);
        private publishCallBack(response);
        private showDialogMultiple(sourceDataInfoList);
        private validSourceDataInfo(sourceData);
        private publishFailedCallBack(response);
        private doAfterPrintCallBack(response);
        private doAfterPrintFailedCallBack(response);
        private showDialog(sourceDataInfoList, top, left, width, height);
        public getPrintType(): number;
        public initRuntime($element: JQuery): void;
        public createDOMElement($parentElement, isDesignMode: boolean): HTMLButtonElement;
    }
}
declare module Uz {
    class _ButtonBatchRegister extends Uz._ButtonDialog {
        private static REGISTER_DIV_NAME;
        private static GET_BATCH_INFO_URL;
        private static OK_CLOSE_EVENT_NAME;
        private _batchId;
        private _subGyomuCode;
        private _batchName;
        private _repeatable;
        private _confirmMessage;
        private _onSetBatchParameterURL;
        private _postParameterPanelNames;
        private _isProcessing;
        private _registerConfirmObject;
        private _batchParameter;
        public batchId : string;
        public subGyomuCode : string;
        public repeatable : boolean;
        public isProcessing : boolean;
        public onSetBatchParameterURL : string;
        public postParameterPanelNames : Object[];
        constructor($parentElement?: JQuery, isDesignMode?: boolean);
        public waitLoadingForButtonDialog(thisInstance): void;
        public recreateDomElement(isImage: boolean): void;
        public bindData(data: any): void;
        private getBatchParameter();
        private getBatchInformation(batchParameter);
        private waitOpenDialog(thisInstance);
        private createPostData(batchId, subGyomuCode);
        private setPassingData(data, batchParameter);
        private getChildDivElement(childDiv, type, id);
        private createSpanElement(text);
        public initRuntime($element: JQuery): void;
        public bindRuntimeForButtonDialog(): void;
        public getProperty(): any;
        public createDOMElement($parentElement): HTMLButtonElement;
    }
}
declare module Uz {
    class CommonChildDiv extends Uz._ViewControl {
        private _layout;
        private _businessId;
        private _controlName;
        private _isCommonChildDivEditMode;
        private _originalProperty;
        private _marginTop;
        private _marginBottom;
        private _canTransferEvent;
        private _isAfterOriginalPropertiesSet;
        private _dataPassingForDialog;
        private _dialogOkEventNameForDialog;
        private _dialogCancelEventNameForDialog;
        private _heightForDialog;
        private _firstFocusFieldName;
        private _lastFocusFieldName;
        private _packageName;
        private _publicEvents;
        private _publicEventsAlias;
        private _initPublicPropertyFunctions;
        private _parentButtonDialog;
        private _modes;
        public layout : any;
        public businessId : string;
        public controlName : string;
        public changeControlName(value): void;
        public isCommonChildDivEditMode : boolean;
        public originalProperty : Object[];
        public marginTop : any;
        public marginBottom : any;
        public dataPassingForDialog : Object[];
        public dialogOkEventNameForDialog : string;
        public dialogCancelEventNameForDialog : string;
        public canTransferEvent : boolean;
        public heightForDialog : string;
        public firstFocusFieldName : string;
        public lastFocusFieldName : string;
        public modes : Object[];
        private static existsModeController(businessId, controlName);
        private applyMode(modes, modesBeforeChange);
        private applyModeByPriority(modes, priorities, modesBeforeChange);
        private static hasModeChanged(modesBeforeChange, modeKey, modeValue);
        public packageName : string;
        public publicEvents : Object[];
        public publicEventsAlias : Object[];
        public initPublicPropertyFunctions : Object[];
        private static defaultLayout;
        constructor($parentElement: JQuery, isDesignMode: boolean, staticLayout: any, fieldName: string);
        public afterPropertiesSet(): void;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        public renderCompleted(): void;
        private static getCommonChildDivFieldName($parentElement, fieldName);
        private initLayout(staticLayout);
        public setProperty(properties, parentCommonChildDivFieldName?: string): void;
        public raisePropertyChanged(layout): void;
        private copyPropertyFromLayout();
        private initChildControls($childDivParentElement, childDivFieldName);
        private changeChildControlsFieldNames(parentLayout, beforeFieldName, newFieldName);
        private static addFieldNameForCommonChildDivChildren(parentFieldName, childControl);
        static createCommonChildDiv(childdivFieldName: string, businessId: string, controlName: string, $parentElement: JQuery, isDesignMode: boolean, isCommonChildDivEditMode: boolean): Uz._JSControl;
        private setElementId();
        public bindData(data: any): void;
        public initDefaultOriginalProperty(basePanelName: string): void;
        public fireCloseEventForDialog(eventName: string): void;
        public setParentButtonDialog(control: any): void;
        public getParentButtonDialog();
        private waitLoadingForDialog(thisInstance);
        public changedDisabled(): void;
        public changedParentState(): void;
        public changedDisplayNone(oldValue): void;
        public handlesDefaultNextFocus(shiftKey: boolean): boolean;
        public setFocus(shiftKey: boolean): boolean;
        private getChildElementDOMIDFromFieldName(fieldName);
        public initRuntime($element: JQuery): void;
        public initPublicProperty(): void;
        public getProperty(): any;
        public getPostParameter(): any;
        public createDOMElement($parentElement): HTMLDivElement;
    }
}
declare module Uz {
    class _BatchUtil {
        static getCommonChildDiv(divName: string): Uz.CommonChildDiv;
        static getCommonChildDivPanel(divName: string): Uz._Panel;
        private static getDialogDomId(businessId, controlName);
        private static getDialogPanelDomId(businessId, controlName);
        private static getDialogBusinessId(displayChildDivName);
        private static getDialogControlName(displayChildDivName);
        static setHiddenValue(targetPanel: Uz._Panel, propertyName: string, value: string): void;
        static getHiddenValue(targetPanel: Uz._Panel, propertyName: string): string;
    }
}
declare module Uz {
    class _ButtonBatchReserve extends Uz._ButtonDialog {
        private static RESERVE_DIV_NAME;
        private static GET_BATCH_INFO_URL;
        private static OK_CLOSE_EVENT_NAME;
        private _batchId;
        private _subGyomuCode;
        private _onSetBatchParameterURL;
        private _postParameterPanelNames;
        private _isProcessing;
        private _registerConfirmObject;
        private _batchParameter;
        public batchId : string;
        public subGyomuCode : string;
        public isProcessing : boolean;
        public onSetBatchParameterURL : string;
        public postParameterPanelNames : Object[];
        constructor($parentElement?: JQuery, isDesignMode?: boolean);
        public waitLoadingForButtonDialog(thisInstance): void;
        private getBatchParameter();
        private getBatchInformation(batchParameter);
        private waitOpenDialog(thisInstance);
        private createPostData(batchId, subGyomuCode);
        public recreateDomElement(isImage: boolean): void;
        public bindData(data: any): void;
        private setPassingData(data, batchParameter);
        private createItemString(data);
        private getDateTimeString(dateTime);
        private getChildDivElement(type, id);
        private getDialogDomId(businessId, controlName);
        private getDialogBusinessId(displayChildDivName);
        private getDialogControlName(displayChildDivName);
        public initRuntime($element: JQuery): void;
        public bindRuntimeForButtonDialog(): void;
        public getProperty(): any;
        public createDOMElement($parentElement): HTMLButtonElement;
    }
}
declare module Uz {
    class _UploadPanel extends Uz._ViewControl {
        private static DEFAULT_HIDEFILE_ID;
        private static DEFAULT_SELECTBUTTON_ID;
        private static DEFAULT_DROPAREA_ID;
        private static DEFAULT_UPLOADEFILETABLE_ID;
        private static DEFAULT_UPLOADBUTTON_ID;
        private static DEFAULT_COUNTDISPLAYAREA_ID;
        private static DEFAULT_SCROLLAREA_ID;
        private static DEFAULT_SIMPLESELECTFILEAREA_ID;
        private static UPLOADEFILETABLE_ROW_HEIGHT;
        private static UPLOADEFILETABLE_BORDER_HEIGHT;
        private static ANIMATION_SPEED;
        private _multiSelect;
        private _extension;
        private _url;
        private _fileListDisplayNumber;
        private _isSimpleMode;
        private _uploadFiles;
        private _uploadEventName;
        private _onAfterUploaded;
        private _postParameterPanelNames;
        public multiSelect : boolean;
        public extension : string;
        private createAddDotExtension();
        public url : string;
        public uploadFiles : File[];
        public fileListDisplayNumber : string;
        public isSimpleMode : boolean;
        public postParameterPanelNames : Object[];
        public uploadEventName : string;
        public onAfterUploaded : string;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        public getHideFileElement(): JQuery;
        public getSelectButtonElement(): JQuery;
        public getDropAreaElement(): JQuery;
        public getUploadFileTableElement(): JQuery;
        public getScrollAreaElement(): JQuery;
        public getCountDisplayAreaElement(): JQuery;
        public getSimpleSelectFileListAreaElement(): JQuery;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        private createOuterDiv();
        private createButton(elementName, id, text);
        private createHideFile();
        private createDropArea();
        private createTable();
        private createCountDisplayArea();
        private createSimpleSelectFileArea();
        private bindEvent();
        private openExplorer();
        private addUploadFiles(selectFiles);
        private addUploadFilesForSimpleMode(selectFile);
        private canUploadFile(selectFile, errorFileName);
        private createErrorMessage(errorFileName);
        private addRowtoUploadFileTable(addTargetFileNames);
        public appendRow(table: JQuery, fileName: string, fieldName: string): void;
        private bindDeleteEvent();
        public fileUpload(): void;
        public bindData(data: any): void;
        public changeStateOfControl(): void;
        private refreshCountDisplayArea();
        private showDialogMessage(message, width);
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public getElementForFocus(): JQuery;
        public createDOMElement($parentElement): HTMLDivElement;
        private recreateDOMElement();
        private recreateSimpleDOMElement();
        public setDefaultData(thisControl: any): void;
    }
}
declare module Uz {
    class _ListControl extends Uz._ViewControl {
        static DEFAULT_CORE_ID: string;
        static DEFAULT_LABELL_ID: string;
        private _dataSource;
        private _disabledItem;
        private _selectedItem;
        private _onChange;
        private _readOnly;
        private _required;
        private _labelLText;
        private _labelLWidth;
        private _labelLAlign;
        public dataSource : ListControlDataPair[];
        public updateUIforDataSource(): void;
        public changeSelectedItem(dataSource: ListControlDataPair[]): void;
        public onChange : string;
        public disabledItem : ListControlDataPair[];
        public selectedItem : string;
        public _getSelectedItemCore(): ListControlDataPair;
        private __selectedItemForBeforeBindingDataSource;
        private existDataSource(value);
        public listDisabledItem(): void;
        public updateUIForSelectedItem(value: string): void;
        public readOnly : boolean;
        public changedReadOnly(): void;
        public required : boolean;
        public labelLText : string;
        public updateLabelLText(value: string): void;
        public createLabelElement(className: string): HTMLElement;
        public labelLWidth : any;
        public decideWidth(element: JQuery, beforeWidth, afterWidth): void;
        public labelLAlign : Uz.Align;
        public getCoreID(): string;
        public getLabelLID(): string;
        public getJQueryLabelLElement(): JQuery;
        constructor($parentElement?: JQuery, isDesignMode?: boolean, createDomElementFunc?: Function);
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        public getJQueryElement(isCoreElement?: boolean): JQuery;
        public changeWidth(): void;
        public createIDWithKey(key: string): string;
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
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
        static createTextIcon($list: JQuery, textIcon: TextIcon[]): void;
        static createIconColumnInfo(dataSource: Uz.ListControlDataPair[]): any[];
        static textIconJapaneaseNameToEnglishName(textIcon: TextIcon[]): any;
        private static iconJapaneaseNameToEnglishName(iconName);
        private static getIconJapaneaseNameObject();
    }
    class TextIcon {
        public key: string;
        public icon: Uz.Icon;
        constructor(key: string, icon: Uz.Icon);
    }
}
declare module Uz {
    class _RadioButton extends Uz._ListControl {
        private _groupName;
        private _onClick;
        private _newLineItemNumber;
        private _spaceSize;
        private _icon;
        public changedReadOnly(): void;
        public groupName : string;
        private updateUIForGroupName();
        public onClick : string;
        public newLineItemNumber : number;
        public spaceSize : any;
        private changeSpaceSize(before, after);
        public icon : Uz.TextIcon[];
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        private getGroupName();
        constructor($parentElement?: JQuery, isDesignMode?: boolean);
        public changeWidth(): void;
        public updateUIForSelectedItem(selectedItem: string): void;
        public updateUIforDataSource(): void;
        public createRadioButtonEvent(): void;
        public createRadioButton(): void;
        public createRdaioButtonDom(key: string, value: string): HTMLInputElement;
        private createButtonSpan(className);
        public bindData(properties: any): void;
        public validateControl(): any;
        public validateRequired(): any;
        public getJQueryElement(isCoreElement?: boolean): JQuery;
        public changeStateOfControl(): void;
        public changedDisabled(): void;
        public resizeControl(): void;
        public canAcceptFocus(): boolean;
        public setFocus(shiftKey: boolean): boolean;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public getElementForFocus(): JQuery;
        public createDOMElement($parentElement, isDesignMode: boolean): HTMLDivElement;
    }
}
declare module Uz {
    class _SegmentedControl extends Uz._RadioButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public changeWidth(): void;
        public createRadioButtonEvent(): void;
        public createRadioButton(): void;
        private initializeSegmentedControl($element);
        private segmentedControlWidth($element);
        public changeSelectedItem(dataSource: Uz.ListControlDataPair[]): void;
        public updateUIForSelectedItem(selectedItem: string): void;
        public changeStateOfControl(): void;
        public bindData(properties: any): void;
        public initRuntime($element: JQuery): void;
        public createDOMElement($parentElement, isDesignMode: boolean): HTMLDivElement;
    }
}
declare module Uz {
    class _DateControlUtil {
        static CALENDAR_OPENER_ICON_URL: string;
        static CALENDAR_OPENER_ICON_CLASS: string;
        private static FORMAT_BASE;
        private static DEFAULT_DISPLAY_FORMAT;
        private static DEFAULT_FORMAT_ERROR;
        private static DATETIME_RANGE_FROM;
        private static DATETIME_RANGE_TO;
        static initializeRegion(): void;
        static initializeCalendarForGrid($inputElement: JQuery, cellDetails: {
            ymdKubun: any;
            displayFormat: any;
            isShowCalendarOpenerIcon: any;
        }): {
            show(): void;
        };
        static datepickerForGrid(inputElement: JQuery, displayFormat: any, ymdKubun: any, isShowCalendarOpenerIcon: any): void;
        static monthpickerForGrid(inputElement: any, displayFormat: any, ymdKubun: any, isShowCalendarOpenerIcon: any): void;
        static yearpickerForGrid(inputElement: any, displayFormat: any, ymdKubun: any): void;
        private static formatOnBlurForGrid(element, displayFormat, ymdKubun, flexibleStatus?);
        static onSelectForDate($element: JQuery, inst: any, displayFormat: any, ymdKubun: any);
        static beforeShowForDate(element: JQuery, value: any, displayFormat: any, ymdKubun: any, maxMin: any): void;
        static formatOnBlurForDate($element: JQuery, displayFormat: any, ymdKubun: any): void;
        static formatOnFocusForDate(element: JQuery, displayFormat: any, ymdKubun: any): string;
        static getOrgTextForDate(targetObj: JQuery, displayFormat: any, ymdKubun: any): string;
        static getFormatText(targetText: string, displayFormat: any, ymdKubun: any, $element?: any, gridFormatter?: string): string;
        private static monthDateEndCheck(strYear, strMonth);
        static displayFormatPropertyCheck(displayFormat: any, ymdKubun: Uz.YmdKubun): number;
        static suggestYearList($element: JQuery, displayFormat, ymdKubun): any;
        private static format2digit(value);
        private static warekiGanNenConvert(strDate);
        static getDateInfoStruct(strDateValueTmp, flexibleStatus?: boolean, $element?: any): DateStruct;
        private static ymdCheckNot(ymd, flexibleStatus, $element);
        private static ymdCheckNotAll(a_strReturn, flexibleStatus, $element);
        private static getEraCode(fieldSelector, value);
        private static warekiInputDataCheck(genYear);
        private static seirekiInputDataCheck(year);
        private static convDateSeireki(targetDate, formatType, flexibleStatus?, $element?, gridFormatter?);
        private static displayFormatInputCheck(resultString);
        private static isYearRange(targetValue);
        private static formatDateSeireki(date, fmt, ymd);
        private static formatDateWareki(date, fmt, ymd, flexibleStatus?, $element?, gridFormatter?);
        private static getEraTable();
        private static getDefaultEraTable();
        private static getEraFromDate(targetValue, flexibleStatus?, $element?, gridFormatter?);
        private static analyzeDateString(strDateValue, flexibleStatus?, $element?);
        private static getDateInfoFromWareki(eraType, strYM, flexibleStatus?);
        private static getEraFromName(targetValue);
        private static getEraFromCode(targetValue);
        static flexibleYearConvert(wareki: string, format): string;
        static flexibleDateGridRule($element: any, type): void;
        private static flexibleDateRule($element, gridFormatter);
        static yearKeepWarekiClear($element?: any): void;
        private static yearKeepWarekiSet(targetValue, $element?);
        private static yearKeepWarekiGet($element, val?);
        private static getDaysInMonthWareki(strGYYMM, flexibleStatus?);
        private static convDateWareki(TargetDate, flexibleStatus?, returnValue?);
        static ymdKubunChage($element: JQuery, ymdKubunAfter: any, ymdKubunBefore: any): void;
        static resetDateFormat(inst: any, displayFormat, ymdKubun, $element: JQuery): any;
        static validateRequired(element: JQuery, isFrom: boolean, validateParameter: any): any;
        static validateTextKind(element: JQuery, validateParameter: DateValidateParameter): any;
        private static getDefaultAllowEraCharactors(fieldSelector);
        static validateInputDate(element: JQuery, validateParameter: any): any;
        static validateDateRange(element: JQuery, isFrom: boolean, validateParameter: any): any;
        static removeInitialCalenderIcon($icon: JQuery, ymdKubun: any): void;
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
    class DateValidateParameter {
        public jpControlName: string;
        public displayFormat: Uz.DisplayDateFormat;
        public permitCharactor: string;
    }
}
declare module Uz {
    class _TextBoxDateRange extends Uz._ViewControl {
        private static DEFAULT_YMDKUBUN;
        private static DEFAULT_DISPLAY_DATE_FORMAT;
        private static DEFAULT_FROMDATE_ID;
        private static DEFAULT_ARROW_ID;
        private static DEFAULT_TODATE_ID;
        private static DEFAULT_CORE_ID;
        private static DEFAULT_LABELL_ID;
        private static DEFAULT_LABELR_ID;
        private static DEFAULT_FROM;
        private static DEFAULT_TO;
        private _coreDom;
        private _labelLDom;
        private _labelRDom;
        private _fromDate;
        private _arrow;
        private _toDate;
        private _rangeWidth;
        private _fromSelectControlID;
        private _toSelectControlID;
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
        private _labelLText;
        private _labelRText;
        private _labelLWidth;
        private _labelRWidth;
        private _labelLAlign;
        private _labelRAlign;
        private _decorationClass;
        private _defaultPermitCharactor;
        private _suggestSourceYear;
        private _autoRangeTo;
        private _isShowCalendarOpenerIcon;
        public autoRangeTo : any;
        public suggestSourceYear : any;
        public isDesignModeLocal : boolean;
        public rangeWidth : string;
        public coreDom : HTMLElement;
        public fromDate : HTMLElement;
        public arrow : HTMLElement;
        public toDate : HTMLElement;
        public ymdKubun : Uz.YmdKubun;
        public displayFormat : Uz.DisplayDateFormat;
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
        private changedReadOnly();
        public isPrivateInfo : boolean;
        public isPassword : boolean;
        public onFocus : string;
        public onBlur : string;
        public onChange : string;
        public onKeyPress : string;
        public fromText : string;
        public toText : string;
        public labelLText : string;
        public labelRText : string;
        private createLabelElement(className);
        public labelLWidth : any;
        public labelRWidth : any;
        private decideWidth(element, beforeWidth, afterWidth);
        public labelLAlign : Uz.Align;
        public labelRAlign : Uz.Align;
        public permitCharactor : string;
        public defaultPermitCharactor : string;
        public fromSelectControlID : string;
        public toSelectControlID : string;
        public isShowCalendarOpenerIcon : boolean;
        public changeIsShowCalendarOpenerIcon(): void;
        private static createCalendarOpenerDOMElement();
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        private getCoreID();
        private getLabelLID();
        private getLabelRID();
        public decorationClass : string;
        constructor($parentElement?: JQuery, isDesignMode?: boolean, createDomElementFunc?: Function);
        public formatValidation(): boolean;
        public changeFormat(): void;
        public changeWidthParameter(oldWidth, newWidth): void;
        public rangeChangeWidth(oldWidth, newWidth): void;
        public changedDisplayNone(oldValue): void;
        private createDomElementRange($parentElement);
        private createFromToDateChange();
        private bindEvent();
        private bindRangeEvent(selector, staus);
        private copyAutoRangeTo($elementTo);
        public createFromToDate(element): HTMLInputElement;
        public createArrow(): HTMLSpanElement;
        public getJQueryElement(isCoreElement?: boolean): JQuery;
        private getJQueryLabelLElement();
        private getJQueryLabelRElement();
        public minMaxDateProperty(minMaxDate): Date;
        private initializeCalendar($element);
        private showCalendar($element);
        public initializeDatepickerProperty(): void;
        public initializeDatepicker($element: JQuery): boolean;
        public initializeYearList($element, format, ymd, beforeValue): void;
        public initializeMonthPicker($element: JQuery): boolean;
        public initializeMonthPickerSet($element): void;
        public initializeDatepickerSet(element, elementChg): void;
        public datepickerOnSelect(element): void;
        public datepickerOnClose(element: JQuery, beforeValue): void;
        public beforeShowMinMaxSet(element, elementChg, filedName, maxMin): void;
        public inputTextDateConvert(element): void;
        private getDateRangeIdCheck(element, val);
        public bindData(data: any): void;
        public validateControlDateRange(element: JQuery, isFrom: boolean): any;
        public validateRequired(element: JQuery, isFrom: boolean): any;
        public validateInputDate(element: JQuery): any;
        public validateDateRange(element: JQuery, isFrom: boolean): any;
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        public changedDisabled(): void;
        public changedParentState(): void;
        public changeStateOfControl(): void;
        public changeTabIndex(): void;
        public resizeControl(): void;
        public canAcceptFocus(): boolean;
        public handlesDefaultNextFocus(shiftKey: boolean): boolean;
        public setFocus(shiftKey: boolean): boolean;
        private addCssClass(cssClasName);
        private removeCssClass(cssClasName);
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public getElementForFocus(): JQuery;
        public createDOMElement($parentElement): HTMLDivElement;
        private getFormatText(value);
        public changedReadOnlyForRunTime(): void;
        public getMaskControl(): any[];
    }
}
declare module Uz {
    class _TextBoxNumRange extends Uz._ViewControl {
        private static DEFAULT_FROM_NUM_ID;
        private static DEFAULT_ARROW_ID;
        private static DEFAULT_TO_NUM_ID;
        private static DEFAULT_CORE_ID;
        private static DEFAULT_LABELL_ID;
        private static DEFAULT_LABELR_ID;
        private _coreDom;
        private _fromNum;
        private _arrow;
        private _toNum;
        private _rangeWidth;
        private _fromSelectControlID;
        private _toSelectControlID;
        private _fromText;
        private _toText;
        private _fromValue;
        private _toValue;
        private _fromRequired;
        private _toRequired;
        private _isHolizontal;
        private _fromPlaceHolder;
        private _toPlaceHolder;
        private _maxLength;
        private _minLength;
        private _textAlign;
        private _readOnly;
        private _textKind;
        private _isPassword;
        private _isPrivateInfo;
        private _onFocus;
        private _onBlur;
        private _onChange;
        private _onKeyPress;
        private _labelLText;
        private _labelRText;
        private _labelLWidth;
        private _labelRWidth;
        private _labelLAlign;
        private _labelRAlign;
        private _permitCharactor;
        private _decorationClass;
        private _maxValue;
        private _minValue;
        private _isCurrency;
        private _isComma;
        private _decimalPointLength;
        private _defaultPermitCharactor;
        private _autoRangeTo;
        public autoRangeTo : any;
        public isDesignModeLocal : boolean;
        public rangeWidth : string;
        public coreDom : HTMLElement;
        public fromNum : HTMLElement;
        public arrow : HTMLElement;
        public toNum : HTMLElement;
        public fromValue : string;
        public toValue : string;
        public isHolizontal : boolean;
        public fromRequired : boolean;
        public fromPlaceHolder : string;
        public toRequired : boolean;
        public toPlaceHolder : string;
        public textKind : Uz.TextKind;
        public textAlign : Uz.Align;
        public readOnly : boolean;
        private changedReadOnly();
        public isPrivateInfo : boolean;
        public isPassword : boolean;
        public onFocus : string;
        public onBlur : string;
        public onChange : string;
        public onKeyPress : string;
        public fromText : string;
        public toText : string;
        public labelLText : string;
        public labelRText : string;
        private createLabelElement(className);
        public labelLWidth : any;
        public labelRWidth : any;
        private decideWidth(element, beforeWidth, afterWidth);
        public labelLAlign : Uz.Align;
        public labelRAlign : Uz.Align;
        public permitCharactor : string;
        public defaultPermitCharactor : string;
        public fromSelectControlID : string;
        public toSelectControlID : string;
        public maxLength : number;
        public minLength : number;
        public maxValue : number;
        public minValue : number;
        public isCurrency : boolean;
        public isComma : boolean;
        public decimalPointLength : number;
        public decorationClass : string;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        private getCoreID();
        private getLabelLID();
        private getLabelRID();
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc: Function);
        private isValidKeyCode(code);
        private isValidMaxLength(code, element);
        public formatValidation(): boolean;
        public changeFormat(): void;
        public registProperty(): void;
        public changeWidthParameter(oldWidth, newWidth): void;
        public rangeChangeWidth(oldWidth, newWidth): void;
        public changedDisplayNone(oldValue): void;
        public createDomElement($parentElement, isDesignMode): HTMLDivElement;
        public createDomElementRange($parentElement): HTMLSpanElement;
        public createFromToNumChange(): void;
        private bindEvent();
        private changeEventHander(myIns, validation, $eventElement);
        private bindEventSideElement($sideElement);
        public createFromToNum(element): HTMLInputElement;
        public createArrow(): HTMLSpanElement;
        public getEditablePropertyInfo(): any;
        public getJQueryElement(isCoreElement?: boolean): JQuery;
        private getJQueryLabelLElement();
        private getJQueryLabelRElement();
        static getNoFormatText(text, decimalPointLength): string;
        private static removeFormat(text);
        static getFormatText(value: string, isCurrency: any, isComma: any): string;
        private static getPointNumber(num, point);
        private static getFloorValue(num, point);
        private static repeatText(s, num);
        public getNumRangeElement(val: string): JQuery;
        public bindData(data: any): void;
        private addCssClass(cssClasName);
        private removeCssClass(cssClasName);
        private getFromNumAreaID();
        private getToNumAreaID();
        public validateControlFrom(): any;
        public validateControlTo(): any;
        public validateControlSide(id: string, text: string, required: boolean): any;
        public validateRequired(id: string, text: string, required: boolean): any;
        public validateMaxLength(id: string, text: string): any;
        public validateMinLength(id: string, text: string): any;
        public validateMaxValue(id: string, text: string): any;
        public validateMinValue(id: string, text: string): any;
        public validateTextKind(id: string, text: string): any;
        public validateNumRange(): any;
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        public changedDisabled(): void;
        public changedParentState(): void;
        public changeStateOfControl(): void;
        public changeTabIndex(): void;
        public resizeControl(): void;
        public canAcceptFocus(): boolean;
        public handlesDefaultNextFocus(shiftKey: boolean): boolean;
        public setFocus(shiftKey: boolean): boolean;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public getElementForFocus(): JQuery;
        public createDOMElement($parentElement): HTMLDivElement;
        private getFormatText(value, orgText);
        public changedReadOnlyForRunTime(): void;
        public getMaskControl(): any[];
    }
}
declare module Uz {
    class _TextBoxTimeRange extends Uz._ViewControl {
        static PERMITCHARACTER_GRID: string;
        private static DEFAULT_FROM_TIME_ID;
        private static DEFAULT_ARROW_ID;
        private static DEFAULT_TO_TIME_ID;
        private static DEFAULT_CORE_ID;
        private static DEFAULT_LABELL_ID;
        private static DEFAULT_LABELR_ID;
        private static DEFAULT_FROM;
        private static DEFAULT_TO;
        private _coreDom;
        private _labelLDom;
        private _labelRDom;
        private _fromTime;
        private _arrow;
        private _toTime;
        private _rangeWidth;
        private _fromSelectControlID;
        private _toSelectControlID;
        private _fromText;
        private _toText;
        private _fromValue;
        private _toValue;
        private _fromRequired;
        private _toRequired;
        private _isHolizontal;
        private _fromPlaceHolder;
        private _toPlaceHolder;
        private _readOnly;
        private _isPassword;
        private _isComboBox;
        private _isPrivateInfo;
        private _onFocus;
        private _onBlur;
        private _onChange;
        private _onKeyPress;
        private _labelLText;
        private _labelRText;
        private _labelLWidth;
        private _labelRWidth;
        private _labelLAlign;
        private _labelRAlign;
        private _fromSuggest;
        private _toSuggest;
        private _permitCharactor;
        private _defaultPermitCharactor;
        private _displayFormat;
        private _timeKubun;
        private _autoRangeTo;
        public autoRangeTo : any;
        public isDesignModeLocal : boolean;
        public rangeWidth : string;
        public coreDom : HTMLElement;
        public fromTime : HTMLElement;
        public arrow : HTMLElement;
        public toTime : HTMLElement;
        public fromValue : string;
        public toValue : string;
        public isHolizontal : boolean;
        public fromRequired : boolean;
        public fromPlaceHolder : string;
        public toRequired : boolean;
        public toPlaceHolder : string;
        public readOnly : boolean;
        public changedReadOnly(): void;
        public isPrivateInfo : boolean;
        public isPassword : boolean;
        public onFocus : string;
        public onBlur : string;
        public onChange : string;
        public onKeyPress : string;
        public fromText : string;
        public toText : string;
        public labelLText : string;
        public labelRText : string;
        private createLabelElement(className);
        public labelLWidth : any;
        public labelRWidth : any;
        private decideWidth(element, beforeWidth, afterWidth);
        public labelLAlign : Uz.Align;
        public labelRAlign : Uz.Align;
        public fromSuggest : string[];
        public toSuggest : string[];
        public permitCharactor : string;
        public defaultPermitCharactor : string;
        public fromSelectControlID : string;
        public toSelectControlID : string;
        public displayFormat : Uz.DisplayFormat;
        public timeKubun : Uz.TimeKubun;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        private getCoreID();
        public getLabelLID(): string;
        public getLabelRID(): string;
        public isComboBox : boolean;
        private isComboBoxChanged(value);
        public createComboBoxChanged(): void;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc: Function);
        public formatValidation(): boolean;
        public changeFormat(): void;
        public changeWidthParameter(oldWidth, newWidth): void;
        private rangeChangeWidthTime(oldWidth, newWidth);
        public changedDisplayNone(oldValue): void;
        public createDomElementRange($parentElement): HTMLSpanElement;
        public createFromToTimeChange(): void;
        private bindEvent();
        private bindRangeEvent(selector, staus);
        private changeEventValidate(element);
        private copyAutoRangeTo();
        public createFromToTime(element): HTMLInputElement;
        public createArrow(): HTMLSpanElement;
        private createSelectDomElement();
        private createComboBoxDomElement($text, fieldName);
        private createNormalDomElement();
        private createOption($parent, suggest);
        public getJQueryElement(isCoreElement?: boolean): JQuery;
        public getJQueryLabelLElement(): JQuery;
        public getJQueryLabelRElement(): JQuery;
        public bindData(data: any): void;
        public validateControlFrom(): any;
        public validateControlTo(): any;
        public validateControlSide(id: string, text: string, required: boolean): any;
        public validateTimeRangeCheck(validateMessage): any;
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        public changedDisabled(): void;
        public changedParentState(): void;
        public changeStateOfControl(): void;
        public changeTabIndex(): void;
        public resizeControl(): void;
        public canAcceptFocus(): boolean;
        public handlesDefaultNextFocus(shiftKey: boolean): boolean;
        public setFocus(shiftKey: boolean): boolean;
        public initRuntime($element: JQuery): void;
        public getProperty();
        public getElementForFocus(): JQuery;
        public createDOMElement($parentElement): HTMLDivElement;
        public changedReadOnlyForRunTime(): void;
        private getFormatText(value);
        public getMaskControl(): any[];
    }
}
declare module Uz {
    class _TextBoxDateTimeRange extends Uz._TextBoxTimeRange {
        private static DEFAULT_YMDKUBUN;
        private static DEFAULT_DISPLAY_DATE_FORMAT;
        private static DEFAULT_FROMDATE_ID;
        private static DEFAULT_ARROW_ID;
        private static DEFAULT_TODATE_ID;
        private static DATETIME_RANGE_FROM;
        private static DATETIME_RANGE_TO;
        private _fromDate;
        private _toDate;
        private _fromDateSelectControlID;
        private _toDateSelectControlID;
        private _ymdKubun;
        private _displayDateFormat;
        private _fromDateText;
        private _toDateText;
        private _fromDateValue;
        private _toDateValue;
        private _fromDatePlaceHolder;
        private _toDatePlaceHolder;
        private _minDate;
        private _maxDate;
        private _suggestSourceYear;
        private _isShowCalendarOpenerIcon;
        public suggestSourceYear : any;
        public fromDate : HTMLElement;
        public toDate : HTMLElement;
        public ymdKubun : Uz.YmdKubun;
        public displayDateFormat : Uz.DisplayDateFormat;
        private propertyFormatChange();
        public minDate : string;
        public maxDate : string;
        public fromDateValue : string;
        public toDateValue : string;
        public fromDateText : string;
        public toDateText : string;
        public fromDateSelectControlID : string;
        public toDateSelectControlID : string;
        public fromDatePlaceHolder : string;
        public toDatePlaceHolder : string;
        public isShowCalendarOpenerIcon : boolean;
        public changeIsShowCalendarOpenerIcon(): void;
        private static createCalendarOpenerDOMElement();
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc: Function);
        public formatValidation(): boolean;
        public changeFormat(): void;
        public changeWidthParameter(oldWidth, newWidth): void;
        private rangeChangeWidthDate(oldWidth, newWidth);
        public changedDisplayNone(oldValue): void;
        public createComboBoxChanged(): void;
        private createDomElementDateRange();
        public createFromToDateChange(): void;
        private bindDateEvent();
        private bindDateRangeEvent(selector, staus);
        public copyAutoDateRangeTo(): void;
        private createFromToDate(element);
        public minMaxDateProperty(minMaxDate): Date;
        private initializeCalendar($element);
        private showCalendar($element);
        public initializeDatepicker($element: JQuery): boolean;
        public initializeYearList($element, format, ymd, beforeValue): void;
        public initializeMonthPicker($element: JQuery): boolean;
        public initializeMonthPickerSet($element): void;
        public initializeDatepickerSet(element, elementChg): void;
        public datepickerOnSelect(element): void;
        public datepickerOnClose(element: JQuery, beforeValue): void;
        public beforeShowMinMaxSet(element, elementChg, filedName, maxMin): void;
        public inputTextDateConvert(element): void;
        private getDateRangeIdCheck(element, val);
        private getUtilParameter();
        public bindData(data: any): void;
        public getDateTimeFromAreaID(): string;
        public getDateTimeToAreaID(): string;
        public validateControlDateRange(element: JQuery, isFrom: boolean): any;
        public validateTimeRangeCheck(validateMessage: string): any;
        private getUtilValidateParameter();
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        public changedDisabled(): void;
        public changedParentState(): void;
        public changedReadOnly(): void;
        public changeStateOfControlDate(): void;
        public changeTabIndex(): void;
        public resizeControl(): void;
        public canAcceptFocus(): boolean;
        public handlesDefaultNextFocus(shiftKey: boolean): boolean;
        public setFocus(shiftKey: boolean): boolean;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public getElementForFocus(): JQuery;
        public createDOMElement($parentElement): HTMLDivElement;
        private getFormatDateText(value);
        public changedReadOnlyForRunTime(): void;
    }
}
declare module Uz {
    class _TextBox extends Uz._ViewControl {
        private static DEFAULT_CORE_ID;
        private static DEFAULT_LABELL_ID;
        private static DEFAULT_LABELR_ID;
        private static LOWERCASE_SIZE;
        private static ELLIPSIS_SIZE;
        private static ELLIPSIS;
        private _labelLDom;
        private _labelRDom;
        private _required;
        private _maxLength;
        private _minLength;
        private _textAlign;
        private _readOnly;
        private _placeHolder;
        private _imeMode;
        private _textKind;
        private _isPassword;
        private _isComboBox;
        private _isPrivateInfo;
        private _text;
        private _onFocus;
        private _onBlur;
        private _onChange;
        private _onKeyPress;
        private _labelLText;
        private _labelRText;
        private _labelLWidth;
        private _labelRWidth;
        private _labelLAlign;
        private _labelRAlign;
        private _suggest;
        private _defaultPermitCharactor;
        private _permitCharactor;
        private _value;
        private _decorationClass;
        private _ellipsis;
        public required : boolean;
        public maxLength : number;
        public minLength : number;
        public textAlign : Uz.Align;
        public readOnly : boolean;
        public labelRDom : HTMLElement;
        public changedReadOnly(): void;
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
        public labelLText : string;
        public labelRText : string;
        public addLabelRDom(): void;
        private createLabelElement(className);
        public labelLWidth : any;
        public labelRWidth : any;
        private decideWidth(element, beforeWidth, afterWidth);
        public labelLAlign : Uz.Align;
        public labelRAlign : Uz.Align;
        public suggest : string[];
        public permitCharactor : string;
        public defaultPermitCharactor : string;
        public value : string;
        public decorationClass : string;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        public getCoreID(): string;
        private getLabelLID();
        private getLabelRID();
        public isComboBox : boolean;
        public isComboBoxChanged(value): void;
        public ellipsis : boolean;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc: Function);
        public bindEvent(): void;
        private setEllipsisValue(value);
        private setToolTip(str);
        private static getByte(str);
        private static getByteArray(str);
        private static createEllipsisText(text, width);
        private static getLimitIndex(text, width);
        public changeWidth(): void;
        private addCssClass(cssClasName);
        private removeCssClass(cssClasName);
        public resizeWidthOfCharacters(): void;
        public formatValidation(): boolean;
        public getFormatText(value): string;
        public changeFormat(): void;
        private createInputDomElement(fieldName, $parent);
        private createSelectDomElement(fieldName, $parent);
        private setupCombobox($select);
        private createOption($parent);
        public getJQueryElement(isCoreElement?: boolean): JQuery;
        private getJQueryLabelLElement();
        private getJQueryLabelRElement();
        public bindData(data: any): void;
        public validateControl(): any;
        static validateRequired(text: string, required: boolean, id: string, jpControlName: string): any;
        static validateMaxLength(text: string, maxLength: number, id: string, jpControlName: string): any;
        static validateMinLength(text: string, minLength: number, id: string, jpControlName: string): any;
        static validateTextKind(text: string, imeMode: Uz.ImeMode, id: string, jpControlName: string): any;
        static validateUniqueCharactor(text: string, id: string, jpControlName: string): any;
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        public changedDisabled(): void;
        public changedParentState(): void;
        public changeStateOfControl(): void;
        public changeTabIndex(): void;
        public resizeControl(): void;
        public canAcceptFocus(): boolean;
        public changedDisplayNone(oldValue): void;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public getMaskControl(): any[];
        public createDOMElement($parentElement: JQuery): HTMLDivElement;
    }
}
declare module Uz {
    class _TextBoxCode extends Uz._TextBox {
        constructor($parentElement?: JQuery, isDesignMode?: boolean);
        public bindEvent(): void;
        private isValidMaxLength(code);
        public bindData(data: any): void;
        public formatValidation(): boolean;
        public getFormatText(value): string;
        public changeFormat(): void;
        static getFormatText(text: string, maxLength: any): string;
        static particularValidation(formatText: string): boolean;
        public validateControl(): any;
        static validateTextKindForCode(text: string, permitCharactor: string, id: string, jpControlName: string): any;
        public createDOMElement($parentElement: JQuery): HTMLDivElement;
    }
}
declare module Uz {
    class _TextBoxNum extends Uz._TextBox {
        static PERMITCHARACTER_GRID: string;
        private _maxValue;
        private _minValue;
        private _isCurrency;
        private _isComma;
        private _decimalPointLength;
        public maxValue : number;
        public changedMaxValue(): void;
        public minValue : number;
        public changedMinValue(): void;
        public isCurrency : boolean;
        public isComma : boolean;
        public decimalPointLength : number;
        public isComboBox : boolean;
        public isComboBoxChanged(value): void;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc: Function);
        public bindEvent(): void;
        private isValidKeyCode(code);
        private isValidMaxLength(code);
        public bindData(data: any): void;
        public formatValidation(): boolean;
        public changeFormat(): void;
        private static getPointNumber(num, point);
        private static getFloorValue(num, point);
        private static repeatText(s, num);
        static getNoFormatText(text, decimalPointLength): string;
        private static removeFormat(text);
        public getFormatText(value): string;
        static getFormatText(value: string, isCurrency: any, isComma: any): string;
        static particularValidation(text: string): boolean;
        public validateControl(): any;
        static validateMaxLengthForNum(text: string, maxLength: number, decimalPointLength: number, id: string, jpControlName: string): any;
        static validateMinLengthForNum(text: string, minLength: number, decimalPointLength: number, id: string, jpControlName: string): any;
        static validateMaxValue(text: string, maxValue: number, decimalPointLength: number, id: string, jpControlName: string): any;
        static validateMinValue(text: string, minValue: number, decimalPointLength: number, id: string, jpControlName: string): any;
        static validateTextKindForNum(text: string, permitCharactor: string, decimalPointLength: number, id: string, jpControlName: string): any;
        static validateDecimalPartValue(text: string, decimalPointLength: number, id: string, jpControlName: string): any;
        public createDOMElement($parentElement: JQuery): HTMLDivElement;
    }
}
declare module Uz {
    class _TextBoxDate extends Uz._ViewControl {
        private static DEFAULT_YMDKUBUN;
        private static DEFAULT_DISPLAY_DATE_FORMAT;
        private static DEFAULT_CORE_ID;
        private static DEFAULT_LABELL_ID;
        private static DEFAULT_LABELR_ID;
        private static KEY_TAB;
        private static KEY_ENTER;
        private static KEY_SPACE;
        private _coreDom;
        private _labelLDom;
        private _labelRDom;
        private _required;
        private _readOnly;
        private _placeHolder;
        private _imeMode;
        private _isPassword;
        private _isPrivateInfo;
        private _text;
        private _onFocus;
        private _onBlur;
        private _onChange;
        private _onKeyPress;
        private _labelLText;
        private _labelRText;
        private _labelLWidth;
        private _labelRWidth;
        private _labelLAlign;
        private _labelRAlign;
        private _defaultPermitCharactor;
        private _permitCharactor;
        private _ymdKubun;
        private _displayFormat;
        private _value;
        private _suggestSourceYear;
        private _decorationClass;
        private _isShowCalendarOpenerIcon;
        public suggestSourceYear : any;
        public ymdKubun : Uz.YmdKubun;
        public displayFormat : Uz.DisplayDateFormat;
        public required : boolean;
        public readOnly : boolean;
        public changedReadOnly(): void;
        public placeHolder : string;
        public imeMode : Uz.ImeMode;
        public isPrivateInfo : boolean;
        public isPassword : boolean;
        public onFocus : string;
        public onBlur : string;
        public onChange : string;
        public onKeyPress : string;
        public text : string;
        public labelLText : string;
        public labelRText : string;
        private createLabelElement(className);
        public labelLWidth : any;
        public labelRWidth : any;
        private decideWidth(element, beforeWidth, afterWidth);
        public labelLAlign : Uz.Align;
        public labelRAlign : Uz.Align;
        public permitCharactor : string;
        public defaultPermitCharactor : string;
        public value : string;
        public decorationClass : string;
        public isShowCalendarOpenerIcon : boolean;
        public changeIsShowCalendarOpenerIcon(): void;
        private static createCalendarOpenerDOMElement();
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        public getCoreID(): string;
        private getLabelLID();
        private getLabelRID();
        constructor($parentElement?: JQuery, isDesignMode?: boolean, createDomElementFunc?: Function);
        private bindEvent();
        private initializeCalendar();
        private showCalendar();
        public changeWidth(): void;
        public formatValidation(): boolean;
        public changeFormat(): void;
        public registProperty(): void;
        public changedDisplayNone(oldValue): void;
        public createDomElement($parentElement, isDesignMode): HTMLDivElement;
        public getJQueryElement(isCoreElement?: boolean): JQuery;
        private getJQueryLabelLElement();
        private getJQueryLabelRElement();
        public initializeDatepicker(): boolean;
        public initializeYearList(beforeValue): void;
        public initializeMonthPicker(): boolean;
        public initializeMonthPickerSet(): void;
        public initializeDatepickerSet(): void;
        public inputTextDateConvert(element): void;
        public bindData(data: any): void;
        public changeFormatBindData(): void;
        public validateControl(): any;
        static validateTextKindForDate(text, displayFormat, permitCharactor, id, jpControlName): any;
        static validateInputDate(ymdKubun, displayFormat, $element, id, jpControlName): any;
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        public changedDisabled(): void;
        public changedParentState(): void;
        public changeStateOfControl(): void;
        private addCssClass(cssClasName);
        private removeCssClass(cssClasName);
        public changeTabIndex(): void;
        public resizeControl(): void;
        public canAcceptFocus(): boolean;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public createDOMElement($parentElement): HTMLDivElement;
        private getFormatText(value);
        public changedReadOnlyForRuntime(): void;
        public getMaskControl(): any[];
    }
}
declare module Uz {
    class _TextBoxFlexibleDate extends Uz._TextBoxDate {
        constructor($parentElement?: JQuery, isDesignMode?: boolean, createDomElementFunc?: Function);
        public validateControl(): any;
        static validateInputDateForFlexibleDate($element: JQuery, id: string, jpControlName: string): any;
        public initRuntime($element: JQuery): void;
        public createDOMElement($parentElement): HTMLDivElement;
    }
}
declare module Uz {
    class _TextBoxTime extends Uz._TextBox {
        static PERMITCHARACTER_GRID: string;
        private _displayFormat;
        private _timeKubun;
        public displayFormat : Uz.DisplayFormat;
        public timeKubun : Uz.TimeKubun;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public bindData(data: any): void;
        public formatValidation(): boolean;
        public changeFormat(): void;
        public validateControl(): any;
        static validateTextKindForTime(text: string, permitCharactor: string, id: string, jpControlName: string): any[];
        static validateUniqueCharactorForTime(text: string, id: string, jpControlName: string): any[];
        static validateTime(text: string, id: string, timeKubun: Uz.TimeKubun, displayFormat: Uz.DisplayFormat, jpControlName: string): any;
        private static getValidateValue(value, displayFormat);
        private static checkTimeValue(timeArray, timeKubun);
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public getFormatText(value): string;
        public createDOMElement($parentElement: JQuery): HTMLDivElement;
    }
}
declare module Uz {
    class _TabPanel extends Uz._ViewControl {
        private $_parentTabContainer;
        public parentTabContainer : JQuery;
        private _title;
        private _titleHref;
        private _onActive;
        private _onFirstActive;
        private _isFirstActivated;
        private _lazyEvalProperties;
        private _lazyBoundData;
        private _lazyLoadingControls;
        public title : string;
        private getTabATag();
        private getTabList();
        public titleHref : string;
        public onActive : string;
        public onFirstActive : string;
        public lazyLoadingControls : any;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        public appendLiTitle(): void;
        private createLiTitle();
        private createATag();
        public changedVisible(): void;
        public bindData(data: any): void;
        public changeStateOfControl(): void;
        public lazyEvalProperties : any;
        public _onAuthoritySet(): void;
        static cancelCommentOut(tabPanelElement: HTMLElement): void;
        public bindLazyLoadingControls(): void;
        static getOriginalFieldName($tabPanelElement: JQuery, fieldName: string): string;
        public initRuntime($element: JQuery): void;
        public createLazyLoadingControls(lazyLoadingControls: any): void;
        public getProperty(): any;
        public createDOMElement($parentElement): HTMLDivElement;
    }
}
declare module Uz {
    class _TabContainer extends Uz._ViewControl {
        private _selectedItemFeildName;
        private _tabpanelPosition;
        private _isDraggable;
        private _onChange;
        private _containerWidth;
        private _initialTab;
        private _height;
        private _isLazyLoading;
        public containerWidth : any;
        public onChange : string;
        public selectedItem : Uz._TabPanel;
        public selectedItemCore(): Uz._TabPanel;
        private isInvalidPanel(value);
        private activeTab(selectedItem);
        private static getTabListItems($tabContainer);
        public tabpanelPosition : string[];
        public isDraggable : boolean;
        public initialTab : number;
        public initialTabActiveTab(): void;
        public height : any;
        private changeTabHeight();
        public selectedItemFieldName : string;
        public isLazyLoading : boolean;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        private createTabContainer();
        private appendTabList(tabs);
        private alignTabTitlesHeight();
        private static findMaxTitleLineNum(tabContainer);
        private static appendBlankLinesToTitles(tabContainer, maxLineNum);
        public addNewTab(selectedControl): void;
        public removeTab(selectedControl): void;
        static saveTabState(): void;
        static refreshTabState(element?: JQuery): void;
        static refreshTabStateByPanel($panel: JQuery): void;
        static clearTabState(): void;
        static initDefaultActiveTab(): void;
        private static resizeTabPanel(anyTabs);
        private static reloadActiveTab();
        private initSortableTabs();
        public sortableTabs(): void;
        private getOrderOfTabpanel();
        public refreshTabOrder(): void;
        private createTabpanelPosition(tabpanelPosition);
        private isAllStringInArray(tabpanelPosition);
        private sortTabpanelByTabpanelPosition();
        private createEditablePropertyTabpanelPosition();
        public getFirstTabInDisplayed(): Uz._TabPanel;
        private getTabPanelByFieldName(tabFieldName);
        public resetSelectItem(): void;
        public bindData(data: any): void;
        public changeStateOfControl(): void;
        private activeInitialTab();
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public setProperty(properties, parentCommonChildDivFieldName?: string): void;
        public getElementForFocus(): JQuery;
        public createDOMElement($parentElement): HTMLElement;
    }
}
declare module Uz {
    class _TimeControlUtil {
        static formatValidation(value: string): boolean;
        static formatValidationDateTime(dateValue: string, timeValue: string): any;
        static changeFormat(value: string, displayFormat: Uz.DisplayFormat, timeKubun: Uz.TimeKubun): string;
        static displayFormatEnumConvert(format: any): Uz.DisplayFormat;
        private static createEasyFormat(value);
        private static changeDateTypeStringCommaSeparateMillis(value, easyFormat);
        private static changeDateTypeString1or2DigitNumber(value, easyFormat);
        private static changeDateTypeStringCommaSeparate(value, easyFormat);
        private changeDateTypeString1or2DigitNumber(value, easyFormat);
        private static changeDateTypeString4DigitNumber(value, easyFormat);
        private static changeDateTypeString6DigitNumber(value, easyFormat);
        private static changeDateTypeStringJapanFormat(value, easyFormat);
        private static change24Format(text, hourSeparatPosition);
        private static changeSeparators(text);
        private static searchMinuteAndSecond(text, mySeparatPosition, frontSeparatPosition);
        static getValueText(value: any): string;
        static getFormatText(value: any, displayFormat: any, timeKubun: any): string;
        private static setSeparators(displayFormat);
        private static createHour(date, separators, displayFormat);
        private static change2Digit(value);
        private static getTimeRemoveSeparater(value);
        static validateRequired(text: string, required: boolean, id: string, jpControlName: string): any;
        static validateTextKindForTime(text: string, permitCharactor: string, id: string, jpControlName: string): {};
        static validateUniqueCharactorForTime(text: string, id: string, jpControlName: string): {};
        static validateTime(text: string, id: string, timeKubun: Uz.TimeKubun, displayFormat: Uz.DisplayFormat, jpControlName: string): any;
        static validateTimeRange(fromValue: string, toValue: string, id: string, jpControlName: string): any;
        private static getValidateValue(value, displayFormat);
        private static checkTimeValue(timeArray, timeKubun);
    }
}
declare module Uz {
    class _Icon extends Uz._ViewControl {
        private static DEFAULT_ICON_HEADER;
        private static DEFAULT_ICON_TRALER_PNG;
        private static DEFAULT_ICON_TRALER_GIF;
        private _icon;
        private _iconSize;
        public icon : any;
        public iconSize : any;
        constructor($parentElement?: JQuery, isDesignMode?: boolean);
        public createDomElement($parentElement, isDesignMode: boolean): HTMLImageElement;
        public bindData(properties: any): void;
        public hasDisabled(): boolean;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public createDOMElement($parentElement: JQuery): HTMLImageElement;
    }
}
declare module Uz {
    class _DataGridFormatter {
        static _isDesignMode: boolean;
        static HeaderFormatter(row, cell, value, columnDef, dataContext): string;
        static LabelFormatter(row, cell, value, columnDef, dataContext): string;
        static TextBoxFormatter(row, cell, value, columnDef, dataContext, gridId): string;
        static CheckBoxFormatter(row, cell, value, columnDef, dataContext): string;
        static CheckBoxListFormatter(row, cell, value, columnDef, dataContext, gridId): string;
        private static getCheckBoxState(selectedItems, key, state);
        static DropDownListFormatter(row, cell, value, columnDef, dataContext): string;
        static RowStateFormatter(row, cell, value, columnDef, dataContext): string;
        static SelectActionButtonFormatter(row, cell, value, columnDef, dataContext): string;
        static ModifyActionButtonFormatter(row, cell, value, columnDef, dataContext): string;
        static DeleteActionButtonFormatter(row, cell, value, columnDef, dataContext): string;
        private static ActionButtonFormatter(row, cell, value, columnDef, dataContext, action);
        static ButtonFormatter(row, cell, value, columnDef, dataContext): string;
        static ImageFormatter(row, cell, value, columnDef, dataContext): string;
        static IconFormatter(row, cell, value, columnDef, dataContext): string;
        static DynamicImageFormatter(row, cell, value, columnDef, dataContext): string;
        private static getAlignClass(columnDef);
        private static getCustomAttrStringForDateControl(value, columnDef, data, wareki);
        private static getCustomAttrString(columnDef, dataContext);
        private static getSizeStyleAttrString(width?, height?, useStyleAttributeName?);
        private static getTitleAttrString(title);
        private static getCellControlId(columnDef, dataContext, gridId);
        static ButtonDialogFormatter(row, cell, value, columnDef, dataContext): string;
        private static checkValue(value, columnDef);
        private static getOptionHtml(suggest);
        static TextBoxMultiLineFormatter(row, cell, value, columnDef, dataContext, gridId): string;
        static ComboBoxAfterFormatter(cellNode, row, dataContext, columnDef): void;
        private static IsHide(value);
        private static getControlState(value, columnDef);
    }
    class _FormatDataForGrid {
        public value: any;
        public formatValue: any;
        public result: boolean;
        constructor(value: any, column: any);
        private format(value, column);
    }
    enum CellState {
        Disable,
        Enable,
        ReadOnly,
    }
    class DataGridColumnCellDetailsString {
        public isSetValueToToolTip: Boolean;
    }
    class DataGridColumnCellDetailsTextBox {
        public maxLength: string;
        public minLength: string;
        public textAlign: Uz.Align;
        public onChange: string;
        public textKind: Uz.TextKind;
        public isSetValueToToolTip: Boolean;
        public readOnly: Boolean;
    }
    class DataGridColumnCellDetailsCheckBox {
        public disabled: Boolean;
        public onChange: string;
    }
    class DataGridColumnCellDetailsDropDownList {
        public onChange: string;
        public selectedItem: string;
        public isBlankLine: Boolean;
        public dataSource: Uz.ListControlDataPair[];
        public readOnly: Boolean;
        public disabled: Boolean;
    }
    class DataGridColumnCellDetailsTextBoxCode {
        public maxLength: string;
        public minLength: string;
        public onChange: string;
        public isSetValueToToolTip: Boolean;
        public readOnly: Boolean;
    }
    class DataGridColumnCellDetailsTextBoxNum {
        public maxLength: string;
        public minLength: string;
        public maxValue: string;
        public minValue: string;
        public isCurrency: Boolean;
        public isComma: Boolean;
        public decimalPointLength: string;
        public onChange: string;
        public isSetValueToToolTip: Boolean;
        public readOnly: Boolean;
    }
    class DataGridColumnCellDetailsTextBoxDate {
        public ymdKubun: Uz.YmdKubun;
        public displayFormat: Uz.DisplayDateFormat;
        public onChange: string;
        public isSetValueToToolTip: Boolean;
        public readOnly: Boolean;
    }
    class DataGridColumnCellDetailsTextBoxFlexibleDate {
        public ymdKubun: Uz.YmdKubun;
        public displayFormat: Uz.DisplayDateFormat;
        public onChange: string;
        public isSetValueToToolTip: Boolean;
        public readOnly: Boolean;
    }
    class DataGridColumnCellDetailsButton {
        public text: string;
        public onClick: string;
        public imageFileUrl: string;
        public imageWidth: string;
        public imageHeigh: string;
    }
    class DataGridColumnCellDetailsStaticImage {
        public labelRWidth: string;
        public labelRAlign: Uz.Align;
        public imageWidth: string;
        public imageHeight: string;
    }
    class DataGridColumnCellDetailsDynamicImage {
        public imageWidth: string;
        public imageHeight: string;
    }
    class DataGridColumnCellDetailsButtonDialog {
        public text: string;
        public imageFileUrl: string;
        public imageWidth: string;
        public imageHeight: string;
        public displayChildDivName: string;
        public visibleCloseButton: Boolean;
        public onBeforeOpenDialog: string;
        public onOkClose: string;
        public onCancelClose: string;
        public dataPassing: Object[];
    }
    class DataGridColumnCellDetailsTextBoxMultiLine {
        public maxLength: string;
        public minLength: string;
        public onChange: string;
        public textKind: Uz.TextKind;
        public isSetValueToToolTip: Boolean;
        public readOnly: Boolean;
    }
    class DataGridColumnCellDetailsTextBoxTime {
        public timeKubun: Uz.TimeKubun;
        public displayFormat: Uz.DisplayFormat;
        public onChange: string;
        public isSetValueToToolTip: Boolean;
        public readOnly: Boolean;
    }
    class DataGridColumnCellDetailsIcon {
        public icon: Uz.Icon;
        public iconSize: Uz.SizeOfSML;
    }
    class DataGridColumnCellDetailsDataGridColumnCheckBox {
        public disabled: Boolean;
        public onChange: string;
    }
}
declare module Uz {
    class _DialogContainer {
        private _displayChildDivName;
        private _dataPassing;
        private _visibleCloseButton;
        private _onOkClose;
        private _onCancelClose;
        private _parentControl;
        private _$overlay;
        public displayChildDivName : string;
        public dataPassing : Object[];
        public visibleCloseButton : boolean;
        public onOkClose : string;
        public onCancelClose : string;
        public parentControl : Uz._ViewControl;
        constructor(parentControl: Uz._ViewControl, displayChildDivName: string, dataPassing: any, visibleCloseButton: boolean, onOkClose: string, onCancelClose: string);
        public openDialog(isLoading?: boolean): void;
        public closeDialog(isCancel: boolean): void;
        private loadDialog();
        private buildItems(control);
        private showDialog(isLoading);
        private showOverlay(overlayCount);
        private hideDialog();
        private resetIsFirstLoadFinished();
        private setInitializeDataForControls();
        private getDialogDomId();
        private getDialogBaseDomId();
        private bindParentToDialog();
        private bindDialogToParent();
        private getBindControlFromPage(controlName);
        private getBindControlFromDialog(controlName);
        private isHiddenInput(controlName);
        private isDataGridColumn(controlName);
        private getPassingDataForHidden(panel, hiddenInputName);
        private setPassingDataForHidden(panel, hiddenInputName, value);
        private getDialogDivControl();
        private getDialogDivPanelDomId();
        private fireOnLoadEvent();
        static canShowDialog(displayChildDivName: string): boolean;
        private decideHeight(element, height);
        private setPosition();
    }
}
declare module Uz {
    class _DataGrid extends Uz._ViewControl {
        private static GRID_ID_SUFFIX;
        private static PAGER_ID_SUFFIX;
        private static DEFAULT_GRID_FOOTER_HEIGHT;
        private _columnFilters;
        private _dataSource;
        private _sortOrder;
        private _isAscending;
        private _filterList;
        private _activeRowId;
        private _passingDataRowId;
        private _nextFocusRow;
        private _nextFocusCol;
        private _viewportPosition;
        private _fireBeforeOpenDialog;
        private _height;
        private _onSort;
        private _onSelect;
        private _onSelectByDblClick;
        private _onSelectBySelectButton;
        private _onSelectByModifyButton;
        private _onSelectByDeleteButton;
        private _onAfterRequest;
        private _onAfterRequestByDblClick;
        private _onAfterRequestBySelectButton;
        private _onAfterRequestByModifyButton;
        private _onAfterRequestByDeleteButton;
        private _onOnlyRow;
        private _onNoRow;
        private _onMultiRows;
        private _marginTop;
        private _marginBottom;
        private _readOnly;
        private _gridAction;
        private _cellControlValidateError;
        private _isTriggerEventOnNoRow;
        private _isTriggerEventOnOnlyRow;
        private _isTriggerEventOnMultiRow;
        private _gridSetting;
        private _confirmDialog;
        private _grid;
        private _dataView;
        private _options;
        private _footer;
        private _gridDiv;
        private _footerDiv;
        private _checkboxSelector;
        public getGridElement(): JQuery;
        public getPagerElement(): JQuery;
        public getGridDivSelector(): string;
        public gridSetting : _GridSetting;
        public changeGridSettingForRuntime(value: _GridSetting): void;
        public changeGridSetting(value: _GridSetting): void;
        public confirmDialog : _ConfirmDialog[];
        private getCellDetailsObject(cellDetails);
        public height : any;
        private static convertOldValue(value);
        public marginTop : any;
        public marginBottom : any;
        public dataSource : any[];
        public getDataSourceForRuntime(): any[];
        public sortOrder : string;
        public isAscending : boolean;
        public filterList : any[];
        public activeRowId : number;
        public passingDataRowId : number;
        public onSort : string;
        public onSelect : string;
        public onSelectByDblClick : string;
        public onSelectBySelectButton : string;
        public onSelectByModifyButton : string;
        public onSelectByDeleteButton : string;
        public onAfterRequest : string;
        public onAfterRequestByDblClick : string;
        public onAfterRequestBySelectButton : string;
        public onAfterRequestByModifyButton : string;
        public onAfterRequestByDeleteButton : string;
        public onOnlyRow : string;
        public onNoRow : string;
        public onMultiRows : string;
        public readOnly : boolean;
        public gridAction : _gridAction[];
        public isTriggerEventOnNoRow : boolean;
        public isTriggerEventOnOnlyRow : boolean;
        public isTriggerEventOnMultiRow : boolean;
        public changeHeight(): void;
        public changedDisabled(): void;
        public changedReadOnly(): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        private createGrid();
        private getDispRowStateColumnDefinition(headerHeightClass);
        private getSelectButtonColumnDefinition(headerHeightClass);
        private getModifyButtonColumnDefinition(headerHeightClass);
        private getDeleteButtonColumnDefinition(headerHeightClass);
        private getHeaderHeightClass();
        private getColModel(columns, header);
        private getGroupedColModel(colModel, combines, groupHeaderHeight);
        private getGroupSetting(colModel, combines);
        public initSlickGridDataForRuntime(): void;
        public initSlickGridEventForRuntime(): void;
        private initGridRowHoverEvent();
        private initSlickGrid(colModel);
        private initGridAction();
        private initFilterEvent();
        private hideValidateError();
        private initGridEvent();
        private getNextFocusElement(self, shiftKey);
        private initGridCellClickEvent();
        private setSelectedRowById(id);
        private clickActionButtonEventTrigger(id, dataName);
        private initGridCellFocusEvent();
        private initGridCellChangeEvent();
        private validateGridCell($element, cellDetails, text, value, result);
        private resetValidateError();
        private validateTextBox(id, cellDetails, text);
        private validateTextBoxCode(id, cellDetails, text);
        private validateTextBoxNum(id, cellDetails, text);
        private validateTextBoxTime(id, cellDetails, text);
        private validateTextBoxDate(id, cellDetails, text, $element);
        private validateTextBoxFlexibleDate(id, cellDetails, text, $element);
        private afterChangeAction(inputElement, column);
        private getColumnDefinition(columnId);
        private initFilterToolbar();
        private initFrozenColumn(colModel);
        private initDataView();
        private initGridFooter();
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        public changedFieldNameForRuntime(): void;
        public changeGrid(): void;
        public createDOMElement($parentElement, isDesignMode: boolean): HTMLDivElement;
        private compareDataSource(targetSource);
        public bindData(data: any): void;
        public receivedResponse(triggerControlInfo: Uz.TriggerControlInfo): void;
        private clearTriggerEvent();
        private saveScrollPosition();
        private setScrollPosition();
        private setFocusPosition(isAutoScroll?, isClearNextFocusRowCol?);
        private reflectCellBgColor();
        private setSelectedRows();
        private setSortColumn();
        private getComparerFunc(sortOrder);
        private convertDataSource(data, colModel, activeRowId);
        private convertDataForClient(rowId, data, colModel);
        private convertDataForServer(data, colModel);
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        private getOutputParameterGridSetting(value);
        public getShowFilterState(): boolean;
        public getOutputParameterForDialog(rowId: number, dataName: string): any;
        private isSelectedItems(selectedItems, key);
        public setOutputParameterForDialog(rowId: number, dataName: string, value: any): void;
        private getConvertValueForCheckBox(value);
        private waitLoadingForDialog(thisInstance, column);
        private showDialog(thisInstance, column);
        public resizeControl(): void;
        public changedParentState(): void;
        public changeStateOfControl(): void;
        public addNewRow(): number;
        public deleteActiveRow(): void;
        public deleteSelectedRows(): void;
        public deleteAllRows(): void;
        public moveUpActiveRow(): void;
        public moveDownActiveRow(): void;
        public getIdxById(id: any): number;
        public getTotalRecords(): number;
        public setRowBgColor(id: any, color: string): void;
        public setCellBgColor(id: any, dataName: string, color: string): void;
        public clearRowBgColor(id: any): void;
        public setFilter(filterList: any[]): void;
        public clearFilter(): void;
        public runFilter(): void;
        private exchangeRow(currentRowIdx, targetRowIdx);
        public setData(data: any): void;
        public canAcceptFocus(): boolean;
        public setSortableMode(enable: boolean): void;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        private afterBindData();
    }
    enum _GridRowNum {
        rows_5,
        rows_10,
        rows_15,
        rows_20,
        rows_25,
    }
    enum _GridColumnWidth {
        XS,
        S,
        M,
        L,
        XL,
    }
    enum _GridSelectLimitRowCount {
        "none",
        "1",
        "2",
        "3",
        "4",
        "5",
    }
    enum _GridCellType {
        String,
        TextBox,
        CheckBox,
        DropDownList,
        TextBoxCode,
        TextBoxNum,
        TextBoxDate,
        TextBoxFlexibleDate,
        Button,
        StaticImage,
        DynamicImage,
        ButtonDialog,
        TextBoxMultiLine,
        TextBoxTime,
        Icon,
        DataGridColumnCheckBox,
        CheckBoxList,
    }
    enum _GridAlign {
        left,
        center,
        right,
    }
    enum _GridCellBgColor {
        Normal,
        Red,
        Blue,
        Yellow,
        Green,
        Gray,
        LightRed,
        LightBlue,
        LightYellow,
        LightGreen,
        LightGray,
    }
    class _GridSetting {
        static DEFAULT_GRID_ROWHEIGHT: number;
        static DEFAULT_GRID_IS_MULTISELECTABLE: boolean;
        static DEFAULT_GRID_IS_SHOW_HEADER: boolean;
        static DEFAULT_GRID_IS_SHOW_FOOTER: boolean;
        static DEFAULT_GRID_IS_SHOW_FILTER: boolean;
        static DEFAULT_GRID_IS_SHOW_FILTER_BUTTON: boolean;
        static DEFAULT_GRID_IS_SHOW_CLEAR_SORT_BUTTON: boolean;
        static DEFAULT_GRID_IS_SHOW_ROWSTATE: boolean;
        static DEFAULT_GRID_IS_SHOW_SELECTED_ROW_COUNT: boolean;
        static DEFAULT_GRID_IS_SHOW_SELECT_BUTTON_COLUMN: boolean;
        static DEFAULT_GRID_IS_SHOW_MODIFY_BUTTON_COLUMN: boolean;
        static DEFAULT_GRID_IS_SHOW_DELETE_BUTTON_COLUMN: boolean;
        static DEFAULT_GRID_SELECT_LIMIT_ROW_COUNT: _GridSelectLimitRowCount;
        public rowHeight: number;
        public isMultiSelectable: boolean;
        public isShowHeader: boolean;
        public isShowFilter: boolean;
        public isShowFilterButton: boolean;
        public isShowClearSortButton: boolean;
        public isShowSelectedRowCount: boolean;
        public isShowFooter: boolean;
        public isShowRowState: boolean;
        public columns: _GridColumn[];
        public header: _GridHeader;
        public isShowSelectButtonColumn: boolean;
        public isShowModifyButtonColumn: boolean;
        public isShowDeleteButtonColumn: boolean;
        public limitRowCount: number;
        public selectedRowCount: number;
        public selectLimitRowCount: _GridSelectLimitRowCount;
        constructor();
    }
    class _GridColumn {
        static DEFAULT_GRID_COLUMN_WIDTH: _GridColumnWidth;
        static DEFAULT_GRID_COLUMN_CELL_TYPE: _GridCellType;
        static DEFAULT_GRID_COLUMN_VISIBLE: boolean;
        static DEFAULT_GRID_COLUMN_ALIGN: _GridAlign;
        static DEFAULT_GRID_COLUMN_RISIZE: boolean;
        static DEFAULT_GRID_COLUMN_IS_PRIVATE_INFO: boolean;
        static DEFAULT_GRID_COLUMN_BGCOLOR: _GridCellBgColor;
        public columnName: string;
        public headerHtml: string;
        public dataName;
        public string: string;
        public toolTip: string;
        public sortKey: string;
        public bgColor: any;
        public width: _GridColumnWidth;
        public visible: boolean;
        public cellType: any;
        public cellDetails: any;
        public align: any;
        public resize: boolean;
        public isPrivateInfo: boolean;
        constructor();
    }
    class _GridHeader {
        static DEFAULT_GRID_HEADER_HEADERHEIGHT: Uz.Size;
        public combineColumns: _GridCombineColumn[];
        public frozenColumn: string;
        public headerHeight: Uz.Size;
        public groupHeaderHeight: Uz.Size;
        constructor();
    }
    class _GridCombineColumn {
        public combineColumnName: string;
        public combineHeaderHtml: string;
        public combineItem: string[];
        constructor();
    }
    class _ConfirmDialog {
        public button: string;
        public showDialog: boolean;
        public title: string;
        public messageBody: string;
        public okButtonValue: string;
        public cancelButtonValue: string;
        constructor(buttonType: string);
        static place(self: _ConfirmDialog, title, message, okButtonValue, cancelButtonValue): _ConfirmDialog;
        static openConfirmDialog(self: _ConfirmDialog, callbackOkButtonHandler?: Function, callbackCancelButtonHandler?: Function): void;
    }
    class _gridAction {
        public actionName: string;
        public actionType: _GridActionType;
        constructor();
    }
    enum _GridActionType {
        addNewRow,
        deleteActiveRow,
        deleteSelectedRows,
        deleteAllRows,
        moveUpActiveRow,
        moveDownActiveRow,
    }
    class GridActionHelper {
        static gridActionList: any[];
        static registGridAction(fieldName: string, actionName: string, actionType: _GridActionType): void;
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
        private _isAfterOriginalPropertiesSet;
        private _firstFocusFieldName;
        private _lastFocusFieldName;
        private _packageName;
        public url : string;
        public targetPostParamFieldNames : string[];
        public layout : any;
        public businessId : string;
        public controlName : string;
        public isCompositeEditMode : boolean;
        public relation : string[];
        public originalProperty : Object[];
        public firstFocusFieldName : string;
        public lastFocusFieldName : string;
        public packageName : string;
        private static defaultLayout;
        constructor($parentElement: JQuery, isDesignMode: boolean, staticLayout: any, fieldName: string);
        public afterPropertiesSet(): void;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        public renderCompleted(): void;
        private static getCompositeControlFieldName($parentElement, fieldName);
        private initLayout(staticLayout);
        public raisePropertyChanged(layout): void;
        private copyPropertyFromLayout();
        private initChildControls($compositeParentElement, compositeControlFieldName);
        private changeChildControlsFieldNames(parentLayout, beforeFieldName, newFieldName);
        private static addFieldNameForCompositeControlChildren(parentFieldName, childControl);
        public createDOMElement($parentElement): HTMLDivElement;
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        private createOriginalPropertyColumnInfos();
        static createCompositeControl(compositeFieldName: string, businessId: string, controlName: string, $parentElement: JQuery, isDesignMode: boolean, isCompositeEditMode: boolean): Uz._JSControl;
        private static getChildFieldNames(control, fieldNames);
        private setElementId();
        public bindData(data: any): void;
        public changeStateOfControl(): void;
        public changedDisplayNone(oldValue): void;
        public handlesDefaultNextFocus(shiftKey: boolean): boolean;
        public setFocus(shiftKey: boolean): boolean;
        public initRuntime($element: JQuery): void;
        public initDesign($parentElement: JQuery): void;
    }
}
declare module Uz {
    class _CheckBoxList extends Uz._ListControl {
        private _onClick;
        private _newLineItemNumber;
        private _minCheckedItem;
        private _maxCheckedItem;
        private _selectedItems;
        private _spaceSize;
        private _isAllSelectable;
        private _isAllSelectableBreakLine;
        private _isAllSelectStatus;
        private _isIndeterminateStatus;
        private _icon;
        public changedReadOnly(): void;
        public removeClientError(): void;
        public selectedItems : Uz.ListControlDataPair[];
        private addIsAllSelect(items);
        public onClick : string;
        public newLineItemNumber : number;
        public minCheckedItem : number;
        public maxCheckedItem : number;
        public spaceSize : any;
        public isAllSelectable : boolean;
        public isAllSelectableBreakLine : boolean;
        public isAllSelectStatus : boolean;
        public isIndeterminateStatus : boolean;
        public icon : Uz.TextIcon[];
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement?: JQuery, isDesignMode?: boolean);
        public changeWidth(): void;
        public updateUIForSelectedItem(value: string): void;
        private updateSelectedItems();
        private unCheckOfDisable();
        private updateSelectedItemsAll();
        private updateOfIsAllSelectStatusNoChange();
        private isIndeterminateTrueToFalse();
        private setIndeterminate(isIndeterminate);
        private setAllSelect(isAllSelect, $Element);
        public updateUIforDataSource(): void;
        public createCheckBoxListEvent(): void;
        private createCheckBoxList();
        private crieateAllSelectCheckBox(element);
        private createCheckBox(key, value);
        private createCheckBoxSpan(className);
        public bindData(properties: any): void;
        public validateControl(): any;
        public validateRequired(): any;
        public validateMaxSelect(): any;
        public validateMinSelect(): any;
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        public getJQueryElement(isCoreElement?: boolean): JQuery;
        public changeStateOfControl(): void;
        public changedDisabled(): void;
        public resizeControl(): void;
        private resizeOuterDiv();
        public canAcceptFocus(): boolean;
        public handlesDefaultNextFocus(shiftKey: boolean): boolean;
        public setFocus(shiftKey: boolean): boolean;
        private getFocusElement(shiftKey);
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public getElementForFocus(): JQuery;
        public createDOMElement($parentElement, isDesignMode: boolean): HTMLDivElement;
    }
}
declare module Uz {
    class _DropDownList extends Uz._ListControl {
        private static DEFAULT_LABELR_ID;
        private _labelRText;
        private _labelRWidth;
        private _labelRAlign;
        private _onFocus;
        private _onBlur;
        private _isBlankLine;
        public changedReadOnly(): void;
        public removeClientError(): void;
        public onFocus : string;
        public onBlur : string;
        public labelRText : string;
        public createLabelElement(className: string): HTMLElement;
        public labelRAlign : Uz.Align;
        public labelRWidth : any;
        public changeSelectedItem(dataSource: Uz.ListControlDataPair[]): void;
        public isBlankLine : boolean;
        public clearSelectedItem(): void;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement?: JQuery, isDesignMode?: boolean);
        public changeWidth(): void;
        public getJQueryElement(isCoreElement?: boolean): JQuery;
        private getJQueryLabelRElement();
        private getLabelRID();
        public updateUIForSelectedItem(selectedItem: string): void;
        public updateUIforDataSource(): void;
        public _getSelectedItemCore(): Uz.ListControlDataPair;
        public createDropDownList(): void;
        private createOption(key, value);
        public bindData(properties: any): void;
        public validateControl(): any;
        public validateRequired(): any;
        public changedDisabled(): void;
        public changedParentState(): void;
        public changeStateOfControl(): void;
        public resizeControl(): void;
        public changeTabIndex(): void;
        public canAcceptFocus(): boolean;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public createDOMElement($parentElement, isDesignMode: boolean): HTMLDivElement;
    }
}
declare module Uz {
    class _ControlRepeater extends Uz._ViewControl {
        private _repeateData;
        private _height;
        public height : any;
        public repeateData : any;
        public createRepeateData(): any[];
        private getCommonChildDivRepeateData($children, parentProperty);
        private bindCommonChildDiv(control, childrenElements, targetRepeateData);
        private repeateControl();
        private createNewJSControl(templateControl, createCount, idCount);
        private createCloneFieldName(templateControl, originElement, firstFieldName, idCount);
        private createNewCommonChildDiv($templateElement, createCount, idCount);
        private replaceTemplateFieldName(cloneHtml, cloneFieldName, templateFieldName, replaceKeyword);
        private reduceControl(templateControl, reduceCount, idCount);
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public bindData(data: any): void;
        public changeStateOfControl(): void;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public createDOMElement($parentElement: JQuery): HTMLDivElement;
        public removeClonedControl(): void;
    }
}
declare module Uz {
    class _DynamicImage extends Uz._ViewControl {
        private _src;
        private _imageWidth;
        private _imageHeight;
        public src : string;
        public imageHeight : any;
        public imageWidth : any;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public bindData(data: any): void;
        public hasDisabled(): boolean;
        public initRuntime($element: JQuery): void;
        public setProperty(properties, parentCommonChildDivFieldName?: string): void;
        public getProperty(): any;
        public createDOMElement($parentElement: JQuery): HTMLImageElement;
    }
}
declare module Uz {
    class _HorizontalLine extends Uz._ViewControl {
        private _size;
        public width : any;
        public float : Uz.Float;
        public size : any;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public bindData(properties: any): void;
        public hasDisabled(): boolean;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public createDOMElement($parentElement): HTMLDivElement;
    }
}
declare module Uz {
    class _Label extends Uz._ViewControl {
        private _align;
        private _text;
        private _isPrivateInfo;
        private _required;
        private _decorationClass;
        public required : boolean;
        public text : string;
        public align : Uz.Align;
        public isPrivateInfo : boolean;
        public decorationClass : string;
        constructor($parentElement?: JQuery, isDesignMode?: boolean);
        public bindData(data: any): void;
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        public hasDisabled(): boolean;
        public getProperty(): any;
        public getMaskControl(): any[];
        public createDOMElement($parentElement): HTMLSpanElement;
    }
}
declare module Uz {
    class _PanelPublish extends Uz._Panel {
        private static DEFAULT_CHECKBOX_ID;
        private _checkboxDom;
        private _isPublish;
        private _isEmptyControl;
        public isPublish : boolean;
        public isEmptyControl : boolean;
        public isEmptyControlAtRuntime(): void;
        public setIsEmptyControlFalse(): void;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement?: JQuery, isDesignMode?: boolean);
        private getCheckBoxID();
        private bindEvent();
        public bindData(data: any): void;
        public setDisabledCanOpenAndClose(isDisabled: boolean): void;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public getElementForFocus(): JQuery;
        public createDOMElement($parentElement): HTMLDivElement;
        public setProperty(properties, parentCommonChildDivFieldName?: string): void;
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
        private _contentValueAlign;
        private _selectedSourceTitle;
        private _dataSourceTitle;
        private _minSelectedItem;
        private _maxSelectedItem;
        private _dataSource;
        private _selectedItems;
        public selectedSourceTitle : string;
        public dataSourceTitle : string;
        public minSelectedItem : number;
        public maxSelectedItem : number;
        public dataSource : SortableListDataItem[];
        public selectedItems : SortableListDataItem[];
        private getSortableListDataItemInList(targetElement);
        public setListHeight(): void;
        public onChange : string;
        public required : boolean;
        public contentValueAlign : Uz.Align;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        public bindEvent(): void;
        private getDataSourceTitleElement();
        private getSelectedSourceTitleElement();
        private getDataSourceListElement();
        private getSelectedSourceListElement();
        private getSelectButtonElement();
        private getRemoveButtonElement();
        private getDataSourceListAllSelectButtonElement();
        private getDataSourceListAllReleaseButtonElement();
        private getSelectedSourceListAllSelectButtonElement();
        private getSelectedSourceListAllReleaseButtonElement();
        private getSelectedSourceListSortButtonElement();
        private getSelectButtonId();
        private getRemoveButtonId();
        private getDataSourceListAllSelectButtonId();
        private getDataSourceListAllReleaseButtonId();
        private getSelectedSourceListAllSelectButtonId();
        private getSelectedSourceListAllReleaseButtonId();
        private getSelectedSourceListSortButtonId();
        constructor($parentElement: JQuery, isDesignMode: boolean);
        private bindSortableAndSelectable(sourceList, connectListId);
        private bindMoveNode();
        private moveNode(sourceList, connectList);
        private bindAllSelectAndAllRelease();
        private allSelect(tagetList);
        private allRelease(tagetList);
        private bindSort();
        private sortList(tagetList);
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
        public bindData(data: any): void;
        public validateControl(): any;
        public validateMaxSelect(): any;
        public validateMinSelect(): any;
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        public changeStateOfControl(): void;
        public addDisabled(): void;
        public removeDisabled(): void;
        public addAsIfDisabledClass(): void;
        public removeAsIfDisabledClass(): void;
        public handlesDefaultNextFocus(shiftKey: boolean): boolean;
        public setFocus(shiftKey: boolean): boolean;
        private getFocusElement(shiftKey);
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public setProperty(properties, parentCommonChildDivFieldName?: string): void;
        public getElementForFocus(): JQuery;
        public createDOMElement($parentElement: JQuery): HTMLElement;
    }
    class SortableListDataItem {
        public key: string;
        public value: string;
        public sortKey: string;
        constructor(key: string, value: string, sortKey: string);
    }
}
declare module Uz {
    class _Space extends Uz._ViewControl {
        private _height;
        private _SpaceCount;
        public float : Uz.Float;
        public spaceCount : any;
        public height : any;
        private changeHeight(beforeHeight, afterHeight);
        public changeWidth(): void;
        public wrapChanged(beforeValue, afterValue): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public createDomElement($parentElement, isDesignMode): HTMLDivElement;
        public bindData(data: any): void;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public createDOMElement($parentElement: JQuery): HTMLDivElement;
        public beforeSaveDesign(): void;
        public afterSaveDesign(): void;
    }
}
declare module Uz {
    class _StaticImage extends Uz._ViewControl {
        private static DEFAULT_CORE_ID;
        private static DEFAULT_LABELR_ID;
        private _src;
        private _imageWidth;
        private _imageHeight;
        private _labelRText;
        private _labelRWidth;
        private _labelRAlign;
        public src : string;
        public imageHeight : any;
        public imageWidth : any;
        public labelRText : string;
        private labelRHeight();
        private createLabelRElement();
        public labelRWidth : any;
        private decideWidth(beforeWidth, afterWidth);
        public labelRAlign : Uz.Align;
        private addLabelRAlignClass(newAlign, beforeAlign);
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        public getCoreID(): string;
        private getLabelRID();
        constructor($parentElement: JQuery, isDesignMode: boolean);
        private createImgDomElement(fieldName, $parent);
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        public bindData(data: any): void;
        public hasDisabled(): boolean;
        public initRuntime($element: JQuery): void;
        public setProperty(properties, parentCommonChildDivFieldName?: string): void;
        public getProperty(): any;
        public createDOMElement($parentElement: JQuery): HTMLDivElement;
        private createImgDOMElement(fieldName, $parent);
    }
}
declare module Uz {
    class _TableCell extends Uz._ViewControl {
        private _connectTd;
        public connectTd : string;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public createDOMElement($parentElement, isDesignMode: boolean): HTMLDivElement;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
    }
}
declare module Uz {
    class _TablePanel extends Uz._ViewControl {
        static DEFAULT_HTML: string;
        private _html;
        public html : string;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public getTempDivJQueryElement(): JQuery;
        public getTableAreaJQueryElement(): JQuery;
        public createDOMElement($parentElement, isDesignMode): HTMLDivElement;
        public bindData(data: any): void;
        public changeStateOfControl(): void;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
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
        public getKanjiInFeildInfo(): any;
        public bindData(data: any): void;
        public initConvertKana(): void;
        private static getKanaTypeString(value);
        public formatValidation(): boolean;
        static particularValidation(formatText: string): boolean;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public createDOMElement($parentElement: JQuery): HTMLDivElement;
    }
}
declare module Uz {
    class _TextBoxNumSpinner extends Uz._TextBoxNum {
        private static AUTO_COUNT_START_TIME;
        private static UP_BUTTON_NAME_SUFFIX;
        private static DOWN_BUTTON_NAME_SUFFIX;
        private _onCountUp;
        private _onCountDown;
        public onCountUp : string;
        public onCountDown : string;
        public changedMaxValue(): void;
        public changedMinValue(): void;
        private getMaxLength();
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        public addLabelRDom(): void;
        private bindSpinnerEvent(targetButtonName, countFunction);
        public changeWidth(): void;
        private fireUpDownEvent(upOrDown);
        private countUp(beforeResult);
        private countDown(beforeResult);
        private createSpinnerButtonArea();
        private createSpinnerButton(str);
        public bindData(data: any): void;
        public changeStateOfControl(): void;
        public changedReadOnly(): void;
        public validateControl(): any;
        public isComboBoxChanged(value): void;
        public initRuntime($element: JQuery): void;
        public createDOMElement($parentElement): HTMLDivElement;
        public changedReadOnlyForRuntime(): void;
    }
}
declare module Uz {
    class _TextBoxYubinNo extends Uz._TextBox {
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public bindData(data: any): void;
        public formatValidation(): boolean;
        public getFormatText(value): string;
        static getFormatText(value: string): string;
        public changeFormat(): void;
        public validateControl(): any;
        public validateTextKind(): any;
        public createDOMElement($parentElement: JQuery): HTMLDivElement;
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
        public changeIconType(): void;
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
        private createTreeViewJson(dataSource, parentId, parentJson);
        private createNodeJson(treeItem, id);
        public beforeData : TreeItem[];
        public onClick : string;
        public onDropped : string;
        public treeViewJson : Object[];
        public selectedItemsId : string[];
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public bindJstree(): void;
        public bindSelectNodeEvent(): void;
        private createJstreeOption();
        public bindDropEvent(option: any): any;
        public bindData(data: any): void;
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        public hasDisabled(): boolean;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public setProperty(properties, parentCommonChildDivFieldName?: string): void;
        private bindTreeView();
        public getElementForFocus(): JQuery;
        public createDOMElement($parentElement: JQuery): HTMLDivElement;
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
    class _VerticalLine extends Uz._ViewControl {
        private _size;
        public width : any;
        public size : any;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public bindData(data: any): void;
        public hasDisabled(): boolean;
        public initRuntime($element: JQuery): void;
        public initDesign($parentElement?: JQuery, isDesignMode?: boolean, createDomElementFunc?: Function): void;
        public getProperty(): any;
        public createDOMElement($parentElement): HTMLDivElement;
    }
}
declare module Uz {
    class _TextBoxDateRangeSlider extends Uz._TextBoxDateRange {
        private static DEFAULT_SLIDER_ID;
        private static DEFAULT_SLIDER_RANGE_DATE_MIN;
        private static DEFAULT_SLIDER_RANGE_DATE_MAX;
        private static SLIDER_SIZE;
        private _sliderDate;
        private _sliderRangeDateMin;
        private _sliderRangeDateMax;
        public sliderDate : HTMLElement;
        public sliderRangeDateMin : string;
        public sliderRangeDateMax : string;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement?: JQuery, isDesignMode?: boolean, createDomElementFunc?: Function);
        public changeWidthParameter(oldWidth, newWidth): void;
        public rangeChangeWidthArrow(oldWidth, newWidth): void;
        public rangeChangeWidthArrowFree(oldWidth, newWidth): void;
        public createFromToDateSliderChange(): void;
        public createFromToDate(element): HTMLInputElement;
        public createArrow(): HTMLSpanElement;
        public createSliderDate(element, elementTop);
        public initializeSlider(fieldName: string): void;
        public dateRangemSliderBase(): void;
        public rangeSliderDataSize(range1: number, range2: number, range3: number, range4: number): number[];
        public rangeSliderDataVal(fieldName, minDate, maxDate): number;
        public datepickerOnClose(element, beforeValue): void;
        public createSliderDisplaySize(element);
        public sliderDisplaySize();
        public initRuntime($element: JQuery): void;
        public createDOMElement($parentElement): HTMLDivElement;
    }
}
declare module Uz {
    class _ButtonBatchParameterRestore extends Uz._ButtonDialog {
        private static RESTORE_DIV_NAME;
        private _batchId;
        private _subGyomuCode;
        private _onRestoreBatchParameter;
        private _selectedRestoreParameter;
        public batchId : string;
        public subGyomuCode : string;
        public onRestoreBatchParameter : string;
        public selectedRestoreParameter : string;
        constructor($parentElement?: JQuery, isDesignMode?: boolean);
        public recreateDomElement(isImage: boolean): void;
        public bindData(data: any): void;
        private waitOpenDialog(thisInstance);
        private setPassingData();
        private setHiddenValue(targetPanel, propertyName, value);
        public initRuntime($element: JQuery): void;
        public bindRuntimeForButtonDialog(): void;
        public getProperty(): any;
        public createDOMElement($parentElement): HTMLButtonElement;
    }
}
declare module Uz {
    class _ButtonBatchParameterSave extends Uz._ButtonDialog {
        private static SAVE_DIV_NAME;
        private _batchId;
        private _subGyomuCode;
        private _getSaveBatchParameterURL;
        private _postParameterPanelNames;
        private _selectedParameterKey;
        private _beforeSaveName;
        private _beforePublicationRange;
        private _existsBeforeParameter;
        private _isProcessing;
        public batchId : string;
        public subGyomuCode : string;
        public getSaveBatchParameterURL : string;
        public postParameterPanelNames : Object[];
        public isProcessing : boolean;
        public beforeSaveName : string;
        public beforePublicationRange : string;
        public existsBeforeParameter : boolean;
        constructor($parentElement?: JQuery, isDesignMode?: boolean);
        public recreateDomElement(isImage: boolean): void;
        public waitLoadingForButtonDialog(thisInstance): void;
        public bindData(data: any): void;
        private getSaveBatchParameter();
        private openSaveDialog(saveBatchParameter);
        private waitOpenDialog(thisInstance, saveBatchParameter);
        private setPassingData(saveBatchParameter);
        private setHiddenValue(targetPanel, propertyName, value);
        public initRuntime($element: JQuery): void;
        public bindRuntimeForButtonDialog(): void;
        public getProperty(): any;
        public createDOMElement($parentElement): HTMLButtonElement;
    }
}
declare module Uz {
    class _PanelBatchParameter extends Uz._Panel {
        constructor($parentElement?: JQuery, isDesignMode?: boolean);
        public initRuntime($element: JQuery): void;
        public createDOMElement($parentElement): HTMLDivElement;
    }
}
declare module Uz {
    class _CommonButton extends Uz._Button {
        private _additionalText;
        public additionalText : string;
        public recreateDomElement(isImage: boolean): void;
        public convertWidth(value): any;
        public changeWidthParameter(oldWidth, newWidth): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public applyCommonButtonData(properties: any): void;
    }
}
declare module Uz {
    class _CommonButtonAccept extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
    }
}
declare module Uz {
    class _CommonButtonApprovalRequest extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
    }
}
declare module Uz {
    class _CommonButtonApprove extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
    }
}
declare module Uz {
    class _CommonButtonBack extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
    }
}
declare module Uz {
    class _CommonButtonBatchRegister extends Uz._ButtonBatchRegister {
        private static REGISTER_DIV_NAME;
        static CLASS: string;
        private _additionalText;
        public additionalText : string;
        public convertWidth(value): any;
        public changeWidthParameter(oldWidth, newWidth): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public applyCommonButtonData(properties: any): void;
    }
}
declare module Uz {
    class _CommonButtonBatchReserve extends Uz._ButtonBatchReserve {
        private static REGISTER_DIV_NAME;
        static CLASS: string;
        private _additionalText;
        public additionalText : string;
        public convertWidth(value): any;
        public changeWidthParameter(oldWidth, newWidth): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public applyCommonButtonData(properties: any): void;
    }
}
declare module Uz {
    class _CommonButtonComplete extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
    }
}
declare module Uz {
    class _CommonButtonConfirm extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
    }
}
declare module Uz {
    class _CommonButtonCreate extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
    }
}
declare module Uz {
    class _CommonButtonDownload extends Uz._CommonButton {
        private static BUTTONDOWNLOAD_TEMP_ID;
        private _buttonDownload;
        private _url;
        private _postParameterPanelNames;
        public url : string;
        public postParameterPanelNames : Object[];
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public applyCommonButtonData(properties: any): void;
        public initRuntime($element: JQuery): void;
    }
}
declare module Uz {
    class _CommonButtonExecute extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
    }
}
declare module Uz {
    class _CommonButtonFree extends Uz._CommonButton {
        private DEFAULT_ICON_HEADER_COMMON;
        private DEFAULT_ICON_TRALER_COMMON;
        private _prefixText;
        private _suffixText;
        private _commonButtonIcon;
        public additionalText : string;
        public prefixText : string;
        public suffixText : string;
        public recreateDomElement(isImage: boolean): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public changeText(): void;
        public applyCommonButtonData(properties: any): void;
    }
}
declare module Uz {
    class _CommonButtonImport extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
    }
}
declare module Uz {
    class _CommonButtonNext extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
    }
}
declare module Uz {
    class _CommonButtonReceive extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
    }
}
declare module Uz {
    class _CommonButtonReject extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
    }
}
declare module Uz {
    class _CommonButtonReportPublish extends Uz._ButtonReportPublish {
        private _additionalText;
        public additionalText : string;
        public convertWidth(value): any;
        public changeWidthParameter(oldWidth, newWidth): void;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public applyCommonButtonData(properties: any): void;
        public initRuntime($element: JQuery): void;
        private onClick();
    }
}
declare module Uz {
    class _CommonButtonReSearch extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public getEditablePropertyInfo(): any;
    }
}
declare module Uz {
    class _CommonButtonSearch extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
    }
}
declare module Uz {
    class _CommonButtonSearchResult extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public getEditablePropertyInfo(): any;
    }
}
declare module Uz {
    class _CommonButtonSelectableComplete extends Uz._CommonButton {
        private _message;
        private _textOfYes;
        private _textOfNo;
        public message : string;
        public textOfYes : string;
        public textOfNo : string;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        private dialogDiv();
        private createDialog();
        public registProperty(): void;
        public getEditablePropertyInfo(): any;
        private static call(extension);
        private static requestFinishFlow(extension, subGyomuCD, flowInstanceId, currentTaskId, wfParameter, callBack);
        private static displayGyomuScreen(url);
        public initRuntime($element: JQuery): void;
        public applyCommonButtonData(property: any): void;
    }
}
declare module Uz {
    class _CommonButtonSend extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
    }
}
declare module Uz {
    class _CommonButtonUpdate extends Uz._CommonButton {
        constructor($parentElement: JQuery, isDesignMode: boolean);
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
        private printDialog();
        public bindData(data: any): void;
        public initRuntime($element: JQuery): void;
        public createDOMElement($parentElement, isDesignMode: boolean): HTMLButtonElement;
    }
}
declare module Uz {
    class _ButtonControlUtil {
        private static DEFAULT_IMG_TEMP_ID;
        private static DEFAULT_BTN_TEMP_ID;
        private static DEFAULT_ICON_HEADER;
        private static DEFAULT_ICON_TRALER_PNG;
        private static DEFAULT_ICON_TRALER_GIF;
        private static HEIGTH_MATCHES_TEXTBOX;
        private static WIDTH_MATCHES_TEXTBOX;
        private static DEFAULT_ICONSPAN_PADDING;
        static buttonImageReSizeHeight($imageElement: JQuery, imageWidth: string, imageHeight: string, isHeightValue: boolean): void;
        static buttonImageReSizeWidth($imageElement: JQuery, imageWidth: string, imageHeight: string, isWidthValue: boolean): void;
    }
}
declare module Uz {
    class _ImageDialog extends Uz._ButtonDialog {
        private static DEFAULT_CORE_ID;
        private static DEFAULT_LABELR_ID;
        private static DEFAULT_IMG_TEMP_ID;
        private _src;
        private _labelRText;
        private _labelRWidth;
        private _labelRAlign;
        public src : string;
        public labelRText : string;
        private labelRHeight();
        private createLabelRElement();
        public labelRWidth : any;
        private decideWidth(beforeWidth, afterWidth);
        private addLabelRAlignClass(newAlign, beforeAlign);
        public changeText(): void;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        constructor($parentElement?: JQuery, isDesignMode?: boolean);
        public reSizeHeightImage(isHeightValue: boolean): void;
        public reSizeWidthImage(isWidthValue: boolean): void;
        public changeStateOfControl(): void;
        public recreateDomElement(isImage: boolean): void;
        public bindRuntimeForButtonDialog(): void;
        public getJQueryElement(isCoreElement?: boolean): JQuery;
        public bindData(data: any): void;
        public hasDisabled(): boolean;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public createDOMElement($parentElement: JQuery): HTMLButtonElement;
        private createInputDOMElement(fieldName);
    }
}
declare module Uz {
    class _Calendar extends Uz._ViewControl {
        private _onDayClick;
        private _onEventClick;
        private _dayClickParam_date;
        private _dayClickParam_allDay;
        private _eventClickParam_eventId;
        private fullCalendarObj;
        public onDayClick : string;
        public onEventClick : string;
        constructor($parentElement: JQuery, isDesignMode: boolean, createDomElementFunc: Function);
        public bindData(data: any): void;
        public getProperty(): any;
        public createDOMElement($parentElement, isDesignMode: boolean): HTMLDivElement;
        private makeFullCalendar($targetElement, fullCalendarObj);
        private setCalendarEvents(events);
    }
}
declare module Uz {
    class _CharacterFontLabel extends Uz._ViewControl {
        private _reamsUnicode;
        private _reamsCharacter;
        private _availableType;
        private _title;
        private _base64BmpString;
        private _onClick;
        private _characterAttributes;
        public availableType : _AvailableType;
        public reamsUnicode : string;
        public reamsCharacter : string;
        public title : string;
        public base64BmpString : string;
        public onClick : string;
        constructor();
        public createALinkDomElement(): HTMLElement;
        private createAnchorClass(type);
        private createDivDomElement();
        public bindData(data: any): void;
        private bindEvent();
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public createDOMElement($parentElement: JQuery): HTMLElement;
    }
    enum _AvailableType {
        AVAILABLE,
        JUKI_NET_TOUITSU_NAIJI,
        OTHER_CHARACTER,
    }
    class _CharacterAttributes {
        private _reamsUnicode;
        private _totalStrokes;
        private _yomi1;
        private _yomi2;
        private _yomi3;
        private _yomi4;
        private _busyu1;
        private _busyu2;
        private _busyu3;
        private _busyu4;
        private _kanjiKind;
    }
    enum _CharacterKindType {
        JIS_X_0201,
        JIS_X_0208,
        JIS_X_0212,
        JIS_X_0213,
        IBM_EXTEND,
        NEC_SPECIAL,
        MJ_VARIATION,
        JIS_X_0213_COMBINE,
        SJIS,
        SJIS_RUIJI,
        JUKI_NET_TOUITSU_MOJI,
        NYUKAN_SEIJI,
        NYUKAN_GAIJI,
    }
    enum _KanjiKindType {
        KANJI,
        NOT_KANJI_RUSSIA,
        NOT_KANJI_GREEK,
        NOT_KANJI_KATAKANA,
        NOT_KANJI_KANA,
        NOT_KANJI_NUMERIC,
        NOT_KANJI_ALPHABET,
        NOT_KANJI_SPECIAL,
        NOT_KANJI_HENTAIKANA,
        NOT_KANJI_OTHER,
    }
}
declare module Uz {
    class _CharacterHelperButtonDialog extends Uz._ButtonDialog {
        static CHARACTER_HELPER_IMAGE: string;
        static DIV_CHARACTER_SEARCH: string;
        private static DIV_ID_CHARACTER_HELPER;
        private static DIV_FIRE_EVENT_METHOD;
        private _searchKind;
        private _sortKey;
        public searchKind : string;
        private setDisabledSortKey(isDisabled);
        public sortKey : string;
        constructor($parentElement?: JQuery, isDesignMode?: boolean, createDomElementFunc?: Function);
        private execOnLoadCharacterHelper(searchKind, sortKey);
        public bindData(data: any): void;
        public waitLoadingForButtonDialog(thisInstance): void;
        public waitForDialogOpen(): void;
        public recreateDomElement(isImage: boolean): void;
        public bindRuntimeForButtonDialog(): void;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public createDOMElement($parentElement: JQuery): HTMLButtonElement;
    }
    enum SearchKindJapaneseName {
        "単漢字検索",
        "氏名検索",
    }
    enum SortKeyJapaneseName {
        "使用頻度が直近のものでソートする",
        "出生のトレンドでソートする",
    }
}
declare module Uz {
    class _ViewControlUtil {
        static applyLayoutInfo(control?: Uz._JSControl, layoutInfo?: any, $ancestorElement?: JQuery, isDesignMode?: boolean, forceBind?: Boolean, selecter?: string): Uz._JSControl;
        static applyLayoutInfoForDesign(selector?: string, parentCommonChildDivFieldName?: string): void;
        private static buildItems(control);
        private static getTargetPanelNames(state);
        private static getTargetLayoutInfo(layoutInfo, targetPanelName);
        static createInitialControl(control: Uz._JSControl, layoutInfo: any, $ancestorElement: JQuery, isDesignMode: boolean): Uz._JSControl;
        private static isCompositeControlType(controlType);
        private static isCompositeEditMode(control, layoutInfo);
        static adjustmentViewPageHeight(isDesignMode: boolean): void;
        private static resizeViewPageHeight();
        static getPanelFieldNames(parentControl: Uz._ViewControl, panelFieldNames: string[]): string[];
        static getPanelBatchParameterFieldNames(parentControl: Uz._ViewControl, panelFieldNames: string[]): string[];
        static getPanelFieldNamesAll(parentControl: Uz._ViewControl): string[];
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
        private static getCommonButtonEventList(page);
        private static isPrefixOn(propertyName);
        private static appendFeildNameConnectorString(field);
        private static isCommonChildDivType(controlType);
        static splitStringByBreak(str: string): string[];
        static appendNewLinetText(element: JQuery, strArray: string[]): void;
        static getUniqueIdForViewControl(controlType: any);
        static getGyomuCD(): string;
        static createPostParameter(instance: Uz._JSControl): any;
        static createPostParameterByPostParameterPanelNames(postParameterPanelNames: any[]): any;
        static createPostParameterCore(postParameterPanelNames, keyName): any[];
        static getLayoutByFieldName(rootControl: Uz._JSControl, fieldName: string): any;
        private static searchLayoutByFieldName(currnetControl, fieldName);
        static getLayoutParentByFieldName(rootControl: Uz._JSControl, fieldName: string): any;
        private static searchLayoutParentByFieldName(currnetControl, fieldName);
        static getSendJsonInfo(control: Uz._JSControl, currentLayout?: any): any;
        private static pushJsonInfoFromItems(jsonInfo, controlItems, currentLayout);
        private static getJsonInfoItem(ControlItem, itemName);
        private static createItemsToJsonObject(parentDiv, parentLayout?);
        private static isViewControl(control);
        static isCommonChildDivPanel(control: Uz._JSControl): boolean;
        static isCompositeChild(control: Uz._JSControl): boolean;
        static fireStateTransitionOnDatagridColumn(fieldName: string, columnName: string, eventName: string): void;
        static viewPageRootTitle(rootTitle: string): void;
        static panelWidthAuto(id: string, status: string): boolean;
        static getSerializedOutputParameter(ioInfo: any): string;
        static getOutputParameter(ioInfo: any): any;
        private static getOutputParameterForHidden(ioInfo);
        static setSerializedOutputParameter(ioInfo: any, serializedParameter: any): void;
        static setOutputParameter(ioInfo: any, parameter: any): void;
        private static setOutputParameterForHidden(dataPassing, parameter);
        static loadSequencePanel(loadPanelInstance: Uz.PanelWithEventName[], loadSequence: string[][], triggerControlInfo?: any, completeFunc?: Function): void;
        private static executeLoad(sequenceLoad, triggerControlInfo);
        static getLoadOrderTree(instances: Uz.PanelWithEventName[]): Uz.PanelWithEventName[][][];
        private static loadDivs(instances, loadSequence, triggerControlInfo?, completeFunc?, failFunc?);
        static getFieldNamesForDialog(searchControl: Uz._JSControl): string[];
        private static searchFieldNamesForDialog(control, fieldNames);
        static setInitializeDataForControls(control: Uz._JSControl, initlayout: any): void;
        static deletePropertyFromItems(selected, childPropertyName, childFieldName);
        static execClientValidation(postParameterPanelNames: any): boolean;
        private static execValidation(items);
        static setViewPageParameter(element): void;
        private static addControlMargin(element, page);
        static deletePanelMarginPadding(target): void;
        static addPanelMarginPadding(target): void;
        static changeStateOfContainerChildren(childrenControl: Uz._JSControl[], parentState: Uz.ParentState): void;
        static escapePermitCharacter(permitCharacter: string): string;
        static showValidationToolTip(fieldName: string, isShow: boolean): void;
        static showValidateErrorMessage(validateMessages: any): void;
        static changeControlColor(controlId: string): void;
        static removeClientError(controlId: string): void;
        static isValidateError(validateFrom?: string): boolean;
        static isValidateWarningMessage(): boolean;
        static resizeOuterDiv(targetControl: any): void;
        private static getOuterDivWidthOfCenter(targetControl);
        private static isImageButton(control);
        static isControlOnDialog(control: Uz._JSControl): boolean;
        static changeCommonButtonPropertyFromServerSide(page: Uz._ViewPage, pDisabled: any, pVisible: any, pDisplayNone: any, pAdditionalText: any, pPrefixText: any, pSuffixText: any): void;
        static resizeOuterDivForComposite(targetControl: any): void;
        private static setSizeComposite(rootControl, layout);
        static openModelessWindow(param: any);
        static isInReamsBrowser(): Boolean;
        static appendSizeUnit(value: any, unit: string): any;
        static getEventValues(searchControl: Uz._JSControl): string[];
        private static searchEventValue(control, events);
        static getPublicEventName(targetControl: Uz.CommonChildDiv, eventName: string): string;
        static requiredStateControl(required: boolean, targetControl: any, ControlElement?: any): void;
        static requireMarkControl(required: boolean, targetControl: any, ControlElement?: any): void;
        static rangeRequireMarkControl(targetRequired: boolean, targetControl: any, targetName: string, required: boolean, ControlElement?: any): void;
        static activesParentTabPanel(target: Uz._ViewControl): boolean;
        private static findParentTabPanelsForLazyLoadingControl(tabPanel, targetFieldName);
        static getControlInfo(fullControlName): any;
        private static getBusinessId(fullName);
        private static getControlName(fullName);
        static setPrivateInfo(value: boolean, control: Uz._JSControl): void;
    }
    class Console {
        private static timeCounters;
        private static info(data);
        static time(name, reset?): void;
        static timeEnd(name): number;
    }
}
declare module Uz {
    class StateTransitionRow {
        public order: string;
        public showWizard: Boolean;
        public showPankuzu: Boolean;
        public stateName: string;
        public wizardName: string;
        public id: string;
        public subGyomuCode: string;
        public visibleDivs: {
            visibleDiv: string;
            panelState: string;
            fixedDiv: string;
        }[];
        public validation: {
            url?: string;
            parameters?: string[];
        };
        public events: {
            fieldName: string;
            event: string;
            transition: string;
        }[];
    }
    class _ViewPage extends Uz._ViewControl {
        private _onLoad;
        private _title;
        private _jsPathCollection;
        private _relation;
        private _stateTransition;
        private _currentState;
        private _id;
        private _WFParameter;
        private _UIContainerEventMapping;
        private _loadSequencePanelNames;
        private _panelMargin;
        private _controlMargin;
        private _supplementInfoAllSet;
        private _supplementInfoAllPostParam;
        private _currentSupplementInfoByState;
        private _currentSupplementInfoPostParam;
        private _commonButtonAreaData;
        private _isOpenSupplementWindow;
        private _supplementWindow;
        private _isOpenStaticManualWindow;
        private _staticManualWindow;
        private _gyomuCode;
        private _subGyomuCode;
        private _currentCommonButtonDisabled;
        private _currentCommonButtonVisible;
        private _currentCommonButtonDisplayNone;
        private _currentCommonButtonAdditionalText;
        private _currentCommonButtonPrefixText;
        private _currentCommonButtonSuffixText;
        private _packageName;
        private _isSupplementLocationChange;
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
        public getScriptFile(path): void;
        public relation : string[];
        public stateTransition : StateTransitionRow[];
        public currentState : string;
        public currentSupplementInfoPostParam : string;
        public overrideStateTransition(stateTransition): void;
        private static updateStateTransition(targetStateTransition, sourceStateTransition, layoutName, subGyomuCode);
        public cleanStateTransition(): void;
        public getStateTransitionTargetPanelNames(): string[];
        public changeFieldNameInStateTransition(beforeFieldName: string, newFieldName: string): void;
        public id : string;
        public gyomuCode : string;
        public subGyomuCode : string;
        public WFParameter : string[];
        public UIContainerEventMapping : UIContainerMappingRow[];
        public loadSequencePanelNames : string[][];
        public panelMargin : Uz.LumpSizeForPanel;
        public controlMargin : Uz.LumpSizeForContorol;
        public supplementInfoAllSet : string;
        public supplementInfoAllPostParam : string[];
        public currentSupplementInfoByState : string;
        public commonButtonAreaData : string[];
        public isOpenSupplementWindow : boolean;
        private supplementWindow;
        public isOpenStaticManualWindow : boolean;
        private staticManualWindow;
        public getCurrentCommonButtonProperty();
        public currentCommonButtonDisabled : any;
        public currentCommonButtonVisible : any;
        public currentCommonButtonDisplayNone : any;
        public currentCommonButtonAdditionalText : any;
        public currentCommonButtonSuffixText : any;
        public currentCommonButtonPrefixText : any;
        public packageName : string;
        private _uiContainerEventAlias;
        public uiContainerEventAlias : string;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        private initUnLoadEvent();
        public initSupplementButtonClickEvent(): void;
        private redirectSupplementInfoPage();
        public getSupplementInfoUrl(supplementInfo: String): string;
        public addStateChangableCss(): void;
        public initTitle(): void;
        public initCommonButtonData(isAll?: boolean): void;
        private initTitleAreaButtonToolTip();
        public initManualButtonClickEvent(): void;
        private getAuthData();
        private createManualWindowBizEntryPoint();
        private createManualWindow(sendAuthData, sendStaticManualData);
        public changeCommonButtonArea(isAll?: boolean): void;
        public applyCommonButtonData(button, buttonProperty): void;
        public searchButtonSetting(isAll?: boolean);
        private searchIsFinishButtonOnTheRight();
        private searchFinishButtonVisible();
        private searchSuspendButtonVisible();
        private changeCurrentSupplementInfo();
        private initTempHelpData();
        static createCommonButtonArea(): void;
        static createCommonButtonAreaForDesign(): void;
        private initErrorAndWarningAccordion();
        private initPageResizeEvent();
        private static resizeHelpTabAndDiv(pageWidth, top, additionalTop, left, $helpTab, $helpDiv);
        private initHelpTabClickEvent($helpTab, $helpDiv);
        public registProperty(): void;
        public createDomElement($parentElement, isDesignMode): HTMLDivElement;
        private createFloatErrorAndWarningDiv($parentElement);
        private createErrorAndWarningDiv(errorWarningDiv);
        public bindStateTransitionEvent(): void;
        public changeState(fieldName: string, eventName: string): void;
        private changePage(eventName);
        private changeFinishState(extention);
        public whenBatchRegisteredChangeFinishState(): void;
        public getEventName(eventAliasName: string): string;
        public fireUIContainerToEvent(eventNameAlias: string): void;
        private changeVisibleDiv(isAll);
        public changeDisplayCss(element): void;
        public addChangeInstance(element, changeInstance: Uz.PanelWithEventName[]): Uz.PanelWithEventName[];
        public rePositioningFixedDiv(): void;
        public resizeChildControls($parentsPanel: JQuery): void;
        private setParentsPanleMinWidth($parentsPanel);
        private returnOriginalLocation(element);
        private changeControlMargin(value);
        private changePanelMargin(value);
        public initRuntime($element: JQuery): void;
        public createDOMElement($parentElement: JQuery): HTMLDivElement;
    }
    class CommonButtonAreaData {
        public commonButtonAreaId: string;
        public buttonSetting: ButtonSetting[];
        public isFinishButtonOnTheRight: boolean;
        public states: string[];
    }
    class ButtonSetting {
        public buttonKind: string;
        public buttonProperty: Object;
    }
    class UIContainerMappingRow {
        private _alias;
        private _eventName;
        constructor(_alias: string, _eventName: string);
        public alias : string;
        public eventName : string;
    }
}
declare module Uz {
    class _TextBoxMultiLine extends Uz._ViewControl {
        private static DEFAULT_LIMITLENGTH;
        private static DEFAULT_TEXTAREA_ID;
        private static DEFAULT_TEXTCOUNT_ID;
        private static DEFAULT_CORE_ID;
        private static DEFAULT_LABELL_ID;
        private static DEFAULT_LABELR_ID;
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
        private _labelLText;
        private _labelRText;
        private _labelLWidth;
        private _labelRWidth;
        private _labelLAlign;
        private _labelRAlign;
        private _decorationClass;
        public fieldNameChanged(beforeFieldName, newFieldName): void;
        private getCoreID();
        private getLabelLID();
        private getLabelRID();
        public required : boolean;
        public maxLength : number;
        public minLength : number;
        public readOnly : boolean;
        private changedReadOnly();
        public setReadOnlyStyle($element: JQuery, readOnly: boolean): void;
        public placeHolder : string;
        public isPrivateInfo : boolean;
        public imeMode : Uz.ImeMode;
        public textKind : Uz.TextKind;
        public onFocus : string;
        public onBlur : string;
        public onChange : string;
        public onKeyPress : string;
        public text : string;
        public labelLText : string;
        public labelRText : string;
        private createLabelElement(className);
        private createLabelCountElement(className);
        public labelLWidth : any;
        public labelRWidth : any;
        private decideWidth(element, beforeWidth, afterWidth);
        public labelLAlign : Uz.Align;
        public labelRAlign : Uz.Align;
        public height : any;
        public limitLength : number;
        public countDisp : boolean;
        public value : string;
        public decorationClass : string;
        constructor($parentElement: JQuery, isDesignMode: boolean);
        public changeWidthParameter(oldWidth, newWidth): void;
        public multiLineChangeWidth(oldWidth, newWidth): void;
        public createDomElementMultiLine(): HTMLSpanElement;
        public createDomElementCount(): HTMLDivElement;
        public getEditablePropertyInfo(): any;
        public getJQueryElement(isCoreElement?: boolean): JQuery;
        public getTextAreaElement(): JQuery;
        private getJQueryLabelLElement();
        private getJQueryLabelRElement();
        private getJQueryLabelCountElement();
        private addCssClass(cssClasName);
        private removeCssClass(cssClasName);
        public bindData(data: any): void;
        private initEvent();
        private initJcountJS();
        private getTextAreaID();
        private getTextContID();
        private getTextContDivID();
        public validateControl(): any;
        public changedDisabled(): void;
        public changedParentState(): void;
        public changeStateOfControl(): void;
        public getOutputParameter(): any;
        public setOutputParameter(value: any): void;
        private heightConvert(value);
        public changeTabIndex(): void;
        public resizeControl(): void;
        public canAcceptFocus(): boolean;
        public initRuntime($element: JQuery): void;
        public getProperty(): any;
        public getElementForFocus(): JQuery;
        public createDOMElement($parentElement: JQuery): HTMLDivElement;
        public getMaskControl(): any[];
    }
}
