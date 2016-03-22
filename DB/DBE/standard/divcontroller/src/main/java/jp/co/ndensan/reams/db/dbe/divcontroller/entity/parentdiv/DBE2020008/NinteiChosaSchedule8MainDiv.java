package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020008;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaSchedule8Main のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaSchedule8MainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaChikuGroupList")
    private ChosaChikuGroupListDiv ChosaChikuGroupList;
    @JsonProperty("ChosaChikuGroupChosaChikuList")
    private ChosaChikuGroupChosaChikuListDiv ChosaChikuGroupChosaChikuList;
    @JsonProperty("ChosaChikuGroupChosaChikuInput")
    private ChosaChikuGroupChosaChikuInputDiv ChosaChikuGroupChosaChikuInput;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("hdnTxtSchemaName")
    private RString hdnTxtSchemaName;
    @JsonProperty("hdnTxtSubGyomuCode")
    private RString hdnTxtSubGyomuCode;
    @JsonProperty("hdnTxtCodeShubetsu")
    private RString hdnTxtCodeShubetsu;
    @JsonProperty("hdnTxtCode")
    private RString hdnTxtCode;
    @JsonProperty("hdnTxtKijunYmd")
    private RString hdnTxtKijunYmd;
    @JsonProperty("hdnTxtCodeMasterKind")
    private RString hdnTxtCodeMasterKind;
    @JsonProperty("hdnTxtCodeMeisho")
    private RString hdnTxtCodeMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChosaChikuGroupList
     * @return ChosaChikuGroupList
     */
    @JsonProperty("ChosaChikuGroupList")
    public ChosaChikuGroupListDiv getChosaChikuGroupList() {
        return ChosaChikuGroupList;
    }

    /*
     * setChosaChikuGroupList
     * @param ChosaChikuGroupList ChosaChikuGroupList
     */
    @JsonProperty("ChosaChikuGroupList")
    public void setChosaChikuGroupList(ChosaChikuGroupListDiv ChosaChikuGroupList) {
        this.ChosaChikuGroupList = ChosaChikuGroupList;
    }

    /*
     * getChosaChikuGroupChosaChikuList
     * @return ChosaChikuGroupChosaChikuList
     */
    @JsonProperty("ChosaChikuGroupChosaChikuList")
    public ChosaChikuGroupChosaChikuListDiv getChosaChikuGroupChosaChikuList() {
        return ChosaChikuGroupChosaChikuList;
    }

    /*
     * setChosaChikuGroupChosaChikuList
     * @param ChosaChikuGroupChosaChikuList ChosaChikuGroupChosaChikuList
     */
    @JsonProperty("ChosaChikuGroupChosaChikuList")
    public void setChosaChikuGroupChosaChikuList(ChosaChikuGroupChosaChikuListDiv ChosaChikuGroupChosaChikuList) {
        this.ChosaChikuGroupChosaChikuList = ChosaChikuGroupChosaChikuList;
    }

    /*
     * getChosaChikuGroupChosaChikuInput
     * @return ChosaChikuGroupChosaChikuInput
     */
    @JsonProperty("ChosaChikuGroupChosaChikuInput")
    public ChosaChikuGroupChosaChikuInputDiv getChosaChikuGroupChosaChikuInput() {
        return ChosaChikuGroupChosaChikuInput;
    }

    /*
     * setChosaChikuGroupChosaChikuInput
     * @param ChosaChikuGroupChosaChikuInput ChosaChikuGroupChosaChikuInput
     */
    @JsonProperty("ChosaChikuGroupChosaChikuInput")
    public void setChosaChikuGroupChosaChikuInput(ChosaChikuGroupChosaChikuInputDiv ChosaChikuGroupChosaChikuInput) {
        this.ChosaChikuGroupChosaChikuInput = ChosaChikuGroupChosaChikuInput;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * gethdnTxtSchemaName
     * @return hdnTxtSchemaName
     */
    @JsonProperty("hdnTxtSchemaName")
    public RString getHdnTxtSchemaName() {
        return hdnTxtSchemaName;
    }

    /*
     * sethdnTxtSchemaName
     * @param hdnTxtSchemaName hdnTxtSchemaName
     */
    @JsonProperty("hdnTxtSchemaName")
    public void setHdnTxtSchemaName(RString hdnTxtSchemaName) {
        this.hdnTxtSchemaName = hdnTxtSchemaName;
    }

    /*
     * gethdnTxtSubGyomuCode
     * @return hdnTxtSubGyomuCode
     */
    @JsonProperty("hdnTxtSubGyomuCode")
    public RString getHdnTxtSubGyomuCode() {
        return hdnTxtSubGyomuCode;
    }

    /*
     * sethdnTxtSubGyomuCode
     * @param hdnTxtSubGyomuCode hdnTxtSubGyomuCode
     */
    @JsonProperty("hdnTxtSubGyomuCode")
    public void setHdnTxtSubGyomuCode(RString hdnTxtSubGyomuCode) {
        this.hdnTxtSubGyomuCode = hdnTxtSubGyomuCode;
    }

    /*
     * gethdnTxtCodeShubetsu
     * @return hdnTxtCodeShubetsu
     */
    @JsonProperty("hdnTxtCodeShubetsu")
    public RString getHdnTxtCodeShubetsu() {
        return hdnTxtCodeShubetsu;
    }

    /*
     * sethdnTxtCodeShubetsu
     * @param hdnTxtCodeShubetsu hdnTxtCodeShubetsu
     */
    @JsonProperty("hdnTxtCodeShubetsu")
    public void setHdnTxtCodeShubetsu(RString hdnTxtCodeShubetsu) {
        this.hdnTxtCodeShubetsu = hdnTxtCodeShubetsu;
    }

    /*
     * gethdnTxtCode
     * @return hdnTxtCode
     */
    @JsonProperty("hdnTxtCode")
    public RString getHdnTxtCode() {
        return hdnTxtCode;
    }

    /*
     * sethdnTxtCode
     * @param hdnTxtCode hdnTxtCode
     */
    @JsonProperty("hdnTxtCode")
    public void setHdnTxtCode(RString hdnTxtCode) {
        this.hdnTxtCode = hdnTxtCode;
    }

    /*
     * gethdnTxtKijunYmd
     * @return hdnTxtKijunYmd
     */
    @JsonProperty("hdnTxtKijunYmd")
    public RString getHdnTxtKijunYmd() {
        return hdnTxtKijunYmd;
    }

    /*
     * sethdnTxtKijunYmd
     * @param hdnTxtKijunYmd hdnTxtKijunYmd
     */
    @JsonProperty("hdnTxtKijunYmd")
    public void setHdnTxtKijunYmd(RString hdnTxtKijunYmd) {
        this.hdnTxtKijunYmd = hdnTxtKijunYmd;
    }

    /*
     * gethdnTxtCodeMasterKind
     * @return hdnTxtCodeMasterKind
     */
    @JsonProperty("hdnTxtCodeMasterKind")
    public RString getHdnTxtCodeMasterKind() {
        return hdnTxtCodeMasterKind;
    }

    /*
     * sethdnTxtCodeMasterKind
     * @param hdnTxtCodeMasterKind hdnTxtCodeMasterKind
     */
    @JsonProperty("hdnTxtCodeMasterKind")
    public void setHdnTxtCodeMasterKind(RString hdnTxtCodeMasterKind) {
        this.hdnTxtCodeMasterKind = hdnTxtCodeMasterKind;
    }

    /*
     * gethdnTxtCodeMeisho
     * @return hdnTxtCodeMeisho
     */
    @JsonProperty("hdnTxtCodeMeisho")
    public RString getHdnTxtCodeMeisho() {
        return hdnTxtCodeMeisho;
    }

    /*
     * sethdnTxtCodeMeisho
     * @param hdnTxtCodeMeisho hdnTxtCodeMeisho
     */
    @JsonProperty("hdnTxtCodeMeisho")
    public void setHdnTxtCodeMeisho(RString hdnTxtCodeMeisho) {
        this.hdnTxtCodeMeisho = hdnTxtCodeMeisho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgChosaChikuGroupList_Row> getDgChosaChikuGroupList() {
        return this.getChosaChikuGroupList().getDgChosaChikuGroupList();
    }

    @JsonIgnore
    public void  setDgChosaChikuGroupList(DataGrid<dgChosaChikuGroupList_Row> dgChosaChikuGroupList) {
        this.getChosaChikuGroupList().setDgChosaChikuGroupList(dgChosaChikuGroupList);
    }

    @JsonIgnore
    public TextBoxNum getTxtChosaChikuCode() {
        return this.getChosaChikuGroupChosaChikuList().getTxtChosaChikuCode();
    }

    @JsonIgnore
    public void  setTxtChosaChikuCode(TextBoxNum txtChosaChikuCode) {
        this.getChosaChikuGroupChosaChikuList().setTxtChosaChikuCode(txtChosaChikuCode);
    }

    @JsonIgnore
    public TextBox getTxtChosaChikuName() {
        return this.getChosaChikuGroupChosaChikuList().getTxtChosaChikuName();
    }

    @JsonIgnore
    public void  setTxtChosaChikuName(TextBox txtChosaChikuName) {
        this.getChosaChikuGroupChosaChikuList().setTxtChosaChikuName(txtChosaChikuName);
    }

    @JsonIgnore
    public Button getBtnInsert() {
        return this.getChosaChikuGroupChosaChikuList().getBtnInsert();
    }

    @JsonIgnore
    public void  setBtnInsert(Button btnInsert) {
        this.getChosaChikuGroupChosaChikuList().setBtnInsert(btnInsert);
    }

    @JsonIgnore
    public DataGrid<dgChosaChikuGroupChosaChikuList_Row> getDgChosaChikuGroupChosaChikuList() {
        return this.getChosaChikuGroupChosaChikuList().getDgChosaChikuGroupChosaChikuList();
    }

    @JsonIgnore
    public void  setDgChosaChikuGroupChosaChikuList(DataGrid<dgChosaChikuGroupChosaChikuList_Row> dgChosaChikuGroupChosaChikuList) {
        this.getChosaChikuGroupChosaChikuList().setDgChosaChikuGroupChosaChikuList(dgChosaChikuGroupChosaChikuList);
    }

    @JsonIgnore
    public TextBoxNum getTxtYusenNo() {
        return this.getChosaChikuGroupChosaChikuInput().getTxtYusenNo();
    }

    @JsonIgnore
    public void  setTxtYusenNo(TextBoxNum txtYusenNo) {
        this.getChosaChikuGroupChosaChikuInput().setTxtYusenNo(txtYusenNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaChikuCode1() {
        return this.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuCode1();
    }

    @JsonIgnore
    public void  setTxtChosaChikuCode1(TextBoxCode txtChosaChikuCode1) {
        this.getChosaChikuGroupChosaChikuInput().setTxtChosaChikuCode1(txtChosaChikuCode1);
    }

    @JsonIgnore
    public ButtonDialog getBtnToSearchChosaChiku() {
        return this.getChosaChikuGroupChosaChikuInput().getBtnToSearchChosaChiku();
    }

    @JsonIgnore
    public void  setBtnToSearchChosaChiku(ButtonDialog btnToSearchChosaChiku) {
        this.getChosaChikuGroupChosaChikuInput().setBtnToSearchChosaChiku(btnToSearchChosaChiku);
    }

    @JsonIgnore
    public TextBox getTxtChosaChikuMeisho1() {
        return this.getChosaChikuGroupChosaChikuInput().getTxtChosaChikuMeisho1();
    }

    @JsonIgnore
    public void  setTxtChosaChikuMeisho1(TextBox txtChosaChikuMeisho1) {
        this.getChosaChikuGroupChosaChikuInput().setTxtChosaChikuMeisho1(txtChosaChikuMeisho1);
    }

    @JsonIgnore
    public TextBoxCode getTxtShichosonCode() {
        return this.getChosaChikuGroupChosaChikuInput().getTxtShichosonCode();
    }

    @JsonIgnore
    public void  setTxtShichosonCode(TextBoxCode txtShichosonCode) {
        this.getChosaChikuGroupChosaChikuInput().setTxtShichosonCode(txtShichosonCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnToSearchShichoson() {
        return this.getChosaChikuGroupChosaChikuInput().getBtnToSearchShichoson();
    }

    @JsonIgnore
    public void  setBtnToSearchShichoson(ButtonDialog btnToSearchShichoson) {
        this.getChosaChikuGroupChosaChikuInput().setBtnToSearchShichoson(btnToSearchShichoson);
    }

    @JsonIgnore
    public TextBox getTxtShichosonMeisho() {
        return this.getChosaChikuGroupChosaChikuInput().getTxtShichosonMeisho();
    }

    @JsonIgnore
    public void  setTxtShichosonMeisho(TextBox txtShichosonMeisho) {
        this.getChosaChikuGroupChosaChikuInput().setTxtShichosonMeisho(txtShichosonMeisho);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getChosaChikuGroupChosaChikuInput().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getChosaChikuGroupChosaChikuInput().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public Button getBtnTorikeshi() {
        return this.getChosaChikuGroupChosaChikuInput().getBtnTorikeshi();
    }

    @JsonIgnore
    public void  setBtnTorikeshi(Button btnTorikeshi) {
        this.getChosaChikuGroupChosaChikuInput().setBtnTorikeshi(btnTorikeshi);
    }

    // </editor-fold>
}
