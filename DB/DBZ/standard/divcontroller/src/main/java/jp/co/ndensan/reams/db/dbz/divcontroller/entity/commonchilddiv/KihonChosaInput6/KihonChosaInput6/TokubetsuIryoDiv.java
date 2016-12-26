package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput6.KihonChosaInput6;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokubetsuIryo のクラスファイル
 *
 * @author 自動生成
 */
public class TokubetsuIryoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShochiNaiyo")
    private ShochiNaiyoDiv ShochiNaiyo;
    @JsonProperty("TokiTaiou")
    private TokiTaiouDiv TokiTaiou;
    @JsonProperty("shinseishoKanriNo")
    private RString shinseishoKanriNo;
    @JsonProperty("recordNumber")
    private RString recordNumber;
    @JsonProperty("ninteichosaTokkijikoNoList")
    private RString ninteichosaTokkijikoNoList;
    @JsonProperty("tokkijikoNo")
    private RString tokkijikoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShochiNaiyo
     * @return ShochiNaiyo
     */
    @JsonProperty("ShochiNaiyo")
    public ShochiNaiyoDiv getShochiNaiyo() {
        return ShochiNaiyo;
    }

    /*
     * setShochiNaiyo
     * @param ShochiNaiyo ShochiNaiyo
     */
    @JsonProperty("ShochiNaiyo")
    public void setShochiNaiyo(ShochiNaiyoDiv ShochiNaiyo) {
        this.ShochiNaiyo = ShochiNaiyo;
    }

    /*
     * getTokiTaiou
     * @return TokiTaiou
     */
    @JsonProperty("TokiTaiou")
    public TokiTaiouDiv getTokiTaiou() {
        return TokiTaiou;
    }

    /*
     * setTokiTaiou
     * @param TokiTaiou TokiTaiou
     */
    @JsonProperty("TokiTaiou")
    public void setTokiTaiou(TokiTaiouDiv TokiTaiou) {
        this.TokiTaiou = TokiTaiou;
    }

    /*
     * getshinseishoKanriNo
     * @return shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /*
     * setshinseishoKanriNo
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /*
     * getrecordNumber
     * @return recordNumber
     */
    @JsonProperty("recordNumber")
    public RString getRecordNumber() {
        return recordNumber;
    }

    /*
     * setrecordNumber
     * @param recordNumber recordNumber
     */
    @JsonProperty("recordNumber")
    public void setRecordNumber(RString recordNumber) {
        this.recordNumber = recordNumber;
    }

    /*
     * getninteichosaTokkijikoNoList
     * @return ninteichosaTokkijikoNoList
     */
    @JsonProperty("ninteichosaTokkijikoNoList")
    public RString getNinteichosaTokkijikoNoList() {
        return ninteichosaTokkijikoNoList;
    }

    /*
     * setninteichosaTokkijikoNoList
     * @param ninteichosaTokkijikoNoList ninteichosaTokkijikoNoList
     */
    @JsonProperty("ninteichosaTokkijikoNoList")
    public void setNinteichosaTokkijikoNoList(RString ninteichosaTokkijikoNoList) {
        this.ninteichosaTokkijikoNoList = ninteichosaTokkijikoNoList;
    }

    /*
     * gettokkijikoNo
     * @return tokkijikoNo
     */
    @JsonProperty("tokkijikoNo")
    public RString getTokkijikoNo() {
        return tokkijikoNo;
    }

    /*
     * settokkijikoNo
     * @param tokkijikoNo tokkijikoNo
     */
    @JsonProperty("tokkijikoNo")
    public void setTokkijikoNo(RString tokkijikoNo) {
        this.tokkijikoNo = tokkijikoNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonDialog getBtnTenteki() {
        return this.getShochiNaiyo().getBtnTenteki();
    }

    @JsonIgnore
    public void  setBtnTenteki(ButtonDialog btnTenteki) {
        this.getShochiNaiyo().setBtnTenteki(btnTenteki);
    }

    @JsonIgnore
    public CheckBoxList getChkTenteki() {
        return this.getShochiNaiyo().getChkTenteki();
    }

    @JsonIgnore
    public void  setChkTenteki(CheckBoxList chkTenteki) {
        this.getShochiNaiyo().setChkTenteki(chkTenteki);
    }

    @JsonIgnore
    public ButtonDialog getBtnSeimyaku() {
        return this.getShochiNaiyo().getBtnSeimyaku();
    }

    @JsonIgnore
    public void  setBtnSeimyaku(ButtonDialog btnSeimyaku) {
        this.getShochiNaiyo().setBtnSeimyaku(btnSeimyaku);
    }

    @JsonIgnore
    public CheckBoxList getChkSeimyaku() {
        return this.getShochiNaiyo().getChkSeimyaku();
    }

    @JsonIgnore
    public void  setChkSeimyaku(CheckBoxList chkSeimyaku) {
        this.getShochiNaiyo().setChkSeimyaku(chkSeimyaku);
    }

    @JsonIgnore
    public ButtonDialog getBtnTouseki() {
        return this.getShochiNaiyo().getBtnTouseki();
    }

    @JsonIgnore
    public void  setBtnTouseki(ButtonDialog btnTouseki) {
        this.getShochiNaiyo().setBtnTouseki(btnTouseki);
    }

    @JsonIgnore
    public CheckBoxList getChkTouseki() {
        return this.getShochiNaiyo().getChkTouseki();
    }

    @JsonIgnore
    public void  setChkTouseki(CheckBoxList chkTouseki) {
        this.getShochiNaiyo().setChkTouseki(chkTouseki);
    }

    @JsonIgnore
    public ButtonDialog getBtnSutoma() {
        return this.getShochiNaiyo().getBtnSutoma();
    }

    @JsonIgnore
    public void  setBtnSutoma(ButtonDialog btnSutoma) {
        this.getShochiNaiyo().setBtnSutoma(btnSutoma);
    }

    @JsonIgnore
    public CheckBoxList getChkSutoma() {
        return this.getShochiNaiyo().getChkSutoma();
    }

    @JsonIgnore
    public void  setChkSutoma(CheckBoxList chkSutoma) {
        this.getShochiNaiyo().setChkSutoma(chkSutoma);
    }

    @JsonIgnore
    public ButtonDialog getBtnSansou() {
        return this.getShochiNaiyo().getBtnSansou();
    }

    @JsonIgnore
    public void  setBtnSansou(ButtonDialog btnSansou) {
        this.getShochiNaiyo().setBtnSansou(btnSansou);
    }

    @JsonIgnore
    public CheckBoxList getChkSansou() {
        return this.getShochiNaiyo().getChkSansou();
    }

    @JsonIgnore
    public void  setChkSansou(CheckBoxList chkSansou) {
        this.getShochiNaiyo().setChkSansou(chkSansou);
    }

    @JsonIgnore
    public ButtonDialog getBtnResupireta() {
        return this.getShochiNaiyo().getBtnResupireta();
    }

    @JsonIgnore
    public void  setBtnResupireta(ButtonDialog btnResupireta) {
        this.getShochiNaiyo().setBtnResupireta(btnResupireta);
    }

    @JsonIgnore
    public CheckBoxList getChkResupireta() {
        return this.getShochiNaiyo().getChkResupireta();
    }

    @JsonIgnore
    public void  setChkResupireta(CheckBoxList chkResupireta) {
        this.getShochiNaiyo().setChkResupireta(chkResupireta);
    }

    @JsonIgnore
    public ButtonDialog getBtnKikan() {
        return this.getShochiNaiyo().getBtnKikan();
    }

    @JsonIgnore
    public void  setBtnKikan(ButtonDialog btnKikan) {
        this.getShochiNaiyo().setBtnKikan(btnKikan);
    }

    @JsonIgnore
    public CheckBoxList getChkKikan() {
        return this.getShochiNaiyo().getChkKikan();
    }

    @JsonIgnore
    public void  setChkKikan(CheckBoxList chkKikan) {
        this.getShochiNaiyo().setChkKikan(chkKikan);
    }

    @JsonIgnore
    public ButtonDialog getBtnToutsu() {
        return this.getShochiNaiyo().getBtnToutsu();
    }

    @JsonIgnore
    public void  setBtnToutsu(ButtonDialog btnToutsu) {
        this.getShochiNaiyo().setBtnToutsu(btnToutsu);
    }

    @JsonIgnore
    public CheckBoxList getChkToutsu() {
        return this.getShochiNaiyo().getChkToutsu();
    }

    @JsonIgnore
    public void  setChkToutsu(CheckBoxList chkToutsu) {
        this.getShochiNaiyo().setChkToutsu(chkToutsu);
    }

    @JsonIgnore
    public ButtonDialog getBtnKeikan() {
        return this.getShochiNaiyo().getBtnKeikan();
    }

    @JsonIgnore
    public void  setBtnKeikan(ButtonDialog btnKeikan) {
        this.getShochiNaiyo().setBtnKeikan(btnKeikan);
    }

    @JsonIgnore
    public CheckBoxList getChkKeikan() {
        return this.getShochiNaiyo().getChkKeikan();
    }

    @JsonIgnore
    public void  setChkKeikan(CheckBoxList chkKeikan) {
        this.getShochiNaiyo().setChkKeikan(chkKeikan);
    }

    @JsonIgnore
    public ButtonDialog getBtnMonita() {
        return this.getTokiTaiou().getBtnMonita();
    }

    @JsonIgnore
    public void  setBtnMonita(ButtonDialog btnMonita) {
        this.getTokiTaiou().setBtnMonita(btnMonita);
    }

    @JsonIgnore
    public CheckBoxList getChkMonita() {
        return this.getTokiTaiou().getChkMonita();
    }

    @JsonIgnore
    public void  setChkMonita(CheckBoxList chkMonita) {
        this.getTokiTaiou().setChkMonita(chkMonita);
    }

    @JsonIgnore
    public ButtonDialog getBtnJyokuso() {
        return this.getTokiTaiou().getBtnJyokuso();
    }

    @JsonIgnore
    public void  setBtnJyokuso(ButtonDialog btnJyokuso) {
        this.getTokiTaiou().setBtnJyokuso(btnJyokuso);
    }

    @JsonIgnore
    public CheckBoxList getChkJyokuso() {
        return this.getTokiTaiou().getChkJyokuso();
    }

    @JsonIgnore
    public void  setChkJyokuso(CheckBoxList chkJyokuso) {
        this.getTokiTaiou().setChkJyokuso(chkJyokuso);
    }

    @JsonIgnore
    public ButtonDialog getBtnbtnKateru() {
        return this.getTokiTaiou().getBtnbtnKateru();
    }

    @JsonIgnore
    public void  setBtnbtnKateru(ButtonDialog btnbtnKateru) {
        this.getTokiTaiou().setBtnbtnKateru(btnbtnKateru);
    }

    @JsonIgnore
    public CheckBoxList getChkKateru() {
        return this.getTokiTaiou().getChkKateru();
    }

    @JsonIgnore
    public void  setChkKateru(CheckBoxList chkKateru) {
        this.getTokiTaiou().setChkKateru(chkKateru);
    }

    // </editor-fold>
}
