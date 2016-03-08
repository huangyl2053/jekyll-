package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020004;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * NinteiChosaScheduleMemoInformation のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaScheduleMemoInformationDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSetteiDate")
    private TextBoxFlexibleDate txtSetteiDate;
    @JsonProperty("txtTaishoChiku")
    private TextBox txtTaishoChiku;
    @JsonProperty("txtNumberOfJuyoMemo")
    private TextBox txtNumberOfJuyoMemo;
    @JsonProperty("txtNumberOfTsujoMemo")
    private TextBox txtNumberOfTsujoMemo;
    @JsonProperty("ListOfCommonMemo")
    private ListOfCommonMemoDiv ListOfCommonMemo;
    @JsonProperty("ListOfJichikuMemo")
    private ListOfJichikuMemoDiv ListOfJichikuMemo;
    @JsonProperty("MaintenanceForMemo")
    private MaintenanceForMemoDiv MaintenanceForMemo;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("メモ一覧共通")
    private RString メモ一覧共通;
    @JsonProperty("共通一覧インデックス")
    private RString 共通一覧インデックス;
    @JsonProperty("メモ一覧自地区")
    private RString メモ一覧自地区;
    @JsonProperty("共通番号")
    private RString 共通番号;
    @JsonProperty("自地区番号")
    private RString 自地区番号;
    @JsonProperty("自地区一覧インデックス")
    private RString 自地区一覧インデックス;
    @JsonProperty("Max連番")
    private RString Max連番;
    @JsonProperty("状態区分")
    private RString 状態区分;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSetteiDate
     * @return txtSetteiDate
     */
    @JsonProperty("txtSetteiDate")
    public TextBoxFlexibleDate getTxtSetteiDate() {
        return txtSetteiDate;
    }

    /*
     * settxtSetteiDate
     * @param txtSetteiDate txtSetteiDate
     */
    @JsonProperty("txtSetteiDate")
    public void setTxtSetteiDate(TextBoxFlexibleDate txtSetteiDate) {
        this.txtSetteiDate = txtSetteiDate;
    }

    /*
     * gettxtTaishoChiku
     * @return txtTaishoChiku
     */
    @JsonProperty("txtTaishoChiku")
    public TextBox getTxtTaishoChiku() {
        return txtTaishoChiku;
    }

    /*
     * settxtTaishoChiku
     * @param txtTaishoChiku txtTaishoChiku
     */
    @JsonProperty("txtTaishoChiku")
    public void setTxtTaishoChiku(TextBox txtTaishoChiku) {
        this.txtTaishoChiku = txtTaishoChiku;
    }

    /*
     * gettxtNumberOfJuyoMemo
     * @return txtNumberOfJuyoMemo
     */
    @JsonProperty("txtNumberOfJuyoMemo")
    public TextBox getTxtNumberOfJuyoMemo() {
        return txtNumberOfJuyoMemo;
    }

    /*
     * settxtNumberOfJuyoMemo
     * @param txtNumberOfJuyoMemo txtNumberOfJuyoMemo
     */
    @JsonProperty("txtNumberOfJuyoMemo")
    public void setTxtNumberOfJuyoMemo(TextBox txtNumberOfJuyoMemo) {
        this.txtNumberOfJuyoMemo = txtNumberOfJuyoMemo;
    }

    /*
     * gettxtNumberOfTsujoMemo
     * @return txtNumberOfTsujoMemo
     */
    @JsonProperty("txtNumberOfTsujoMemo")
    public TextBox getTxtNumberOfTsujoMemo() {
        return txtNumberOfTsujoMemo;
    }

    /*
     * settxtNumberOfTsujoMemo
     * @param txtNumberOfTsujoMemo txtNumberOfTsujoMemo
     */
    @JsonProperty("txtNumberOfTsujoMemo")
    public void setTxtNumberOfTsujoMemo(TextBox txtNumberOfTsujoMemo) {
        this.txtNumberOfTsujoMemo = txtNumberOfTsujoMemo;
    }

    /*
     * getListOfCommonMemo
     * @return ListOfCommonMemo
     */
    @JsonProperty("ListOfCommonMemo")
    public ListOfCommonMemoDiv getListOfCommonMemo() {
        return ListOfCommonMemo;
    }

    /*
     * setListOfCommonMemo
     * @param ListOfCommonMemo ListOfCommonMemo
     */
    @JsonProperty("ListOfCommonMemo")
    public void setListOfCommonMemo(ListOfCommonMemoDiv ListOfCommonMemo) {
        this.ListOfCommonMemo = ListOfCommonMemo;
    }

    /*
     * getListOfJichikuMemo
     * @return ListOfJichikuMemo
     */
    @JsonProperty("ListOfJichikuMemo")
    public ListOfJichikuMemoDiv getListOfJichikuMemo() {
        return ListOfJichikuMemo;
    }

    /*
     * setListOfJichikuMemo
     * @param ListOfJichikuMemo ListOfJichikuMemo
     */
    @JsonProperty("ListOfJichikuMemo")
    public void setListOfJichikuMemo(ListOfJichikuMemoDiv ListOfJichikuMemo) {
        this.ListOfJichikuMemo = ListOfJichikuMemo;
    }

    /*
     * getMaintenanceForMemo
     * @return MaintenanceForMemo
     */
    @JsonProperty("MaintenanceForMemo")
    public MaintenanceForMemoDiv getMaintenanceForMemo() {
        return MaintenanceForMemo;
    }

    /*
     * setMaintenanceForMemo
     * @param MaintenanceForMemo MaintenanceForMemo
     */
    @JsonProperty("MaintenanceForMemo")
    public void setMaintenanceForMemo(MaintenanceForMemoDiv MaintenanceForMemo) {
        this.MaintenanceForMemo = MaintenanceForMemo;
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
     * getメモ一覧共通
     * @return メモ一覧共通
     */
    @JsonProperty("メモ一覧共通")
    public RString getメモ一覧共通() {
        return メモ一覧共通;
    }

    /*
     * setメモ一覧共通
     * @param メモ一覧共通 メモ一覧共通
     */
    @JsonProperty("メモ一覧共通")
    public void setメモ一覧共通(RString メモ一覧共通) {
        this.メモ一覧共通 = メモ一覧共通;
    }

    /*
     * get共通一覧インデックス
     * @return 共通一覧インデックス
     */
    @JsonProperty("共通一覧インデックス")
    public RString get共通一覧インデックス() {
        return 共通一覧インデックス;
    }

    /*
     * set共通一覧インデックス
     * @param 共通一覧インデックス 共通一覧インデックス
     */
    @JsonProperty("共通一覧インデックス")
    public void set共通一覧インデックス(RString 共通一覧インデックス) {
        this.共通一覧インデックス = 共通一覧インデックス;
    }

    /*
     * getメモ一覧自地区
     * @return メモ一覧自地区
     */
    @JsonProperty("メモ一覧自地区")
    public RString getメモ一覧自地区() {
        return メモ一覧自地区;
    }

    /*
     * setメモ一覧自地区
     * @param メモ一覧自地区 メモ一覧自地区
     */
    @JsonProperty("メモ一覧自地区")
    public void setメモ一覧自地区(RString メモ一覧自地区) {
        this.メモ一覧自地区 = メモ一覧自地区;
    }

    /*
     * get共通番号
     * @return 共通番号
     */
    @JsonProperty("共通番号")
    public RString get共通番号() {
        return 共通番号;
    }

    /*
     * set共通番号
     * @param 共通番号 共通番号
     */
    @JsonProperty("共通番号")
    public void set共通番号(RString 共通番号) {
        this.共通番号 = 共通番号;
    }

    /*
     * get自地区番号
     * @return 自地区番号
     */
    @JsonProperty("自地区番号")
    public RString get自地区番号() {
        return 自地区番号;
    }

    /*
     * set自地区番号
     * @param 自地区番号 自地区番号
     */
    @JsonProperty("自地区番号")
    public void set自地区番号(RString 自地区番号) {
        this.自地区番号 = 自地区番号;
    }

    /*
     * get自地区一覧インデックス
     * @return 自地区一覧インデックス
     */
    @JsonProperty("自地区一覧インデックス")
    public RString get自地区一覧インデックス() {
        return 自地区一覧インデックス;
    }

    /*
     * set自地区一覧インデックス
     * @param 自地区一覧インデックス 自地区一覧インデックス
     */
    @JsonProperty("自地区一覧インデックス")
    public void set自地区一覧インデックス(RString 自地区一覧インデックス) {
        this.自地区一覧インデックス = 自地区一覧インデックス;
    }

    /*
     * getMax連番
     * @return Max連番
     */
    @JsonProperty("Max連番")
    public RString getMax連番() {
        return Max連番;
    }

    /*
     * setMax連番
     * @param Max連番 Max連番
     */
    @JsonProperty("Max連番")
    public void setMax連番(RString Max連番) {
        this.Max連番 = Max連番;
    }

    /*
     * get状態区分
     * @return 状態区分
     */
    @JsonProperty("状態区分")
    public RString get状態区分() {
        return 状態区分;
    }

    /*
     * set状態区分
     * @param 状態区分 状態区分
     */
    @JsonProperty("状態区分")
    public void set状態区分(RString 状態区分) {
        this.状態区分 = 状態区分;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAddForListOfCommonMemo() {
        return this.getListOfCommonMemo().getBtnAddForListOfCommonMemo();
    }

    @JsonIgnore
    public void  setBtnAddForListOfCommonMemo(Button btnAddForListOfCommonMemo) {
        this.getListOfCommonMemo().setBtnAddForListOfCommonMemo(btnAddForListOfCommonMemo);
    }

    @JsonIgnore
    public DataGrid<dgListOfCommonMemo_Row> getDgListOfCommonMemo() {
        return this.getListOfCommonMemo().getDgListOfCommonMemo();
    }

    @JsonIgnore
    public void  setDgListOfCommonMemo(DataGrid<dgListOfCommonMemo_Row> dgListOfCommonMemo) {
        this.getListOfCommonMemo().setDgListOfCommonMemo(dgListOfCommonMemo);
    }

    @JsonIgnore
    public Button getBtnAddForListOfJichikuMemo() {
        return this.getListOfJichikuMemo().getBtnAddForListOfJichikuMemo();
    }

    @JsonIgnore
    public void  setBtnAddForListOfJichikuMemo(Button btnAddForListOfJichikuMemo) {
        this.getListOfJichikuMemo().setBtnAddForListOfJichikuMemo(btnAddForListOfJichikuMemo);
    }

    @JsonIgnore
    public DataGrid<dgListOfJichikuMemo_Row> getDgListOfJichikuMemo() {
        return this.getListOfJichikuMemo().getDgListOfJichikuMemo();
    }

    @JsonIgnore
    public void  setDgListOfJichikuMemo(DataGrid<dgListOfJichikuMemo_Row> dgListOfJichikuMemo) {
        this.getListOfJichikuMemo().setDgListOfJichikuMemo(dgListOfJichikuMemo);
    }

    @JsonIgnore
    public DropDownList getDdlMemoType() {
        return this.getMaintenanceForMemo().getDdlMemoType();
    }

    @JsonIgnore
    public void  setDdlMemoType(DropDownList ddlMemoType) {
        this.getMaintenanceForMemo().setDdlMemoType(ddlMemoType);
    }

    @JsonIgnore
    public TextBox getTxtMemoNumber() {
        return this.getMaintenanceForMemo().getTxtMemoNumber();
    }

    @JsonIgnore
    public void  setTxtMemoNumber(TextBox txtMemoNumber) {
        this.getMaintenanceForMemo().setTxtMemoNumber(txtMemoNumber);
    }

    @JsonIgnore
    public DropDownList getDdlShiteiChosaChiku() {
        return this.getMaintenanceForMemo().getDdlShiteiChosaChiku();
    }

    @JsonIgnore
    public void  setDdlShiteiChosaChiku(DropDownList ddlShiteiChosaChiku) {
        this.getMaintenanceForMemo().setDdlShiteiChosaChiku(ddlShiteiChosaChiku);
    }

    @JsonIgnore
    public TextBox getTxtCreator() {
        return this.getMaintenanceForMemo().getTxtCreator();
    }

    @JsonIgnore
    public void  setTxtCreator(TextBox txtCreator) {
        this.getMaintenanceForMemo().setTxtCreator(txtCreator);
    }

    @JsonIgnore
    public DropDownList getDdlMemoImportance() {
        return this.getMaintenanceForMemo().getDdlMemoImportance();
    }

    @JsonIgnore
    public void  setDdlMemoImportance(DropDownList ddlMemoImportance) {
        this.getMaintenanceForMemo().setDdlMemoImportance(ddlMemoImportance);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtMemo() {
        return this.getMaintenanceForMemo().getTxtMemo();
    }

    @JsonIgnore
    public void  setTxtMemo(TextBoxMultiLine txtMemo) {
        this.getMaintenanceForMemo().setTxtMemo(txtMemo);
    }

    @JsonIgnore
    public Button getBtnSave() {
        return this.getMaintenanceForMemo().getBtnSave();
    }

    @JsonIgnore
    public void  setBtnSave(Button btnSave) {
        this.getMaintenanceForMemo().setBtnSave(btnSave);
    }

    @JsonIgnore
    public Button getBtnDelete() {
        return this.getMaintenanceForMemo().getBtnDelete();
    }

    @JsonIgnore
    public void  setBtnDelete(Button btnDelete) {
        this.getMaintenanceForMemo().setBtnDelete(btnDelete);
    }

    @JsonIgnore
    public Button getBtnAbort() {
        return this.getMaintenanceForMemo().getBtnAbort();
    }

    @JsonIgnore
    public void  setBtnAbort(Button btnAbort) {
        this.getMaintenanceForMemo().setBtnAbort(btnAbort);
    }

    // </editor-fold>
}
