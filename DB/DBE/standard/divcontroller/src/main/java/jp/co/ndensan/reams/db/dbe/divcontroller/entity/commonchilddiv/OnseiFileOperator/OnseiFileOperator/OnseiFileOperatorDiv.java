package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.OnseiFileOperator.OnseiFileOperator;
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
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho2;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * OnseiFileOperator のクラスファイル
 *
 * @author 自動生成
 */
public class OnseiFileOperatorDiv extends Panel implements IOnseiFileOperatorDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNo")
    private TextBoxNum txtNo;
    @JsonProperty("txtInsDate")
    private TextBox txtInsDate;
    @JsonProperty("btnDownload")
    private ButtonDownLoad btnDownload;
    @JsonProperty("btnDelete")
    private Button btnDelete;
    @JsonProperty("OnseiFileDeleted")
    private OnseiFileDeletedDiv OnseiFileDeleted;
    @JsonProperty("bizData")
    private RString bizData;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNo
     * @return txtNo
     */
    @JsonProperty("txtNo")
    public TextBoxNum getTxtNo() {
        return txtNo;
    }

    /*
     * settxtNo
     * @param txtNo txtNo
     */
    @JsonProperty("txtNo")
    public void setTxtNo(TextBoxNum txtNo) {
        this.txtNo = txtNo;
    }

    /*
     * gettxtInsDate
     * @return txtInsDate
     */
    @JsonProperty("txtInsDate")
    public TextBox getTxtInsDate() {
        return txtInsDate;
    }

    /*
     * settxtInsDate
     * @param txtInsDate txtInsDate
     */
    @JsonProperty("txtInsDate")
    public void setTxtInsDate(TextBox txtInsDate) {
        this.txtInsDate = txtInsDate;
    }

    /*
     * getbtnDownload
     * @return btnDownload
     */
    @JsonProperty("btnDownload")
    public ButtonDownLoad getBtnDownload() {
        return btnDownload;
    }

    /*
     * setbtnDownload
     * @param btnDownload btnDownload
     */
    @JsonProperty("btnDownload")
    public void setBtnDownload(ButtonDownLoad btnDownload) {
        this.btnDownload = btnDownload;
    }

    /*
     * getbtnDelete
     * @return btnDelete
     */
    @JsonProperty("btnDelete")
    public Button getBtnDelete() {
        return btnDelete;
    }

    /*
     * setbtnDelete
     * @param btnDelete btnDelete
     */
    @JsonProperty("btnDelete")
    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    /*
     * getOnseiFileDeleted
     * @return OnseiFileDeleted
     */
    @JsonProperty("OnseiFileDeleted")
    public OnseiFileDeletedDiv getOnseiFileDeleted() {
        return OnseiFileDeleted;
    }

    /*
     * setOnseiFileDeleted
     * @param OnseiFileDeleted OnseiFileDeleted
     */
    @JsonProperty("OnseiFileDeleted")
    public void setOnseiFileDeleted(OnseiFileDeletedDiv OnseiFileDeleted) {
        this.OnseiFileDeleted = OnseiFileDeleted;
    }

    /*
     * getbizData
     * @return bizData
     */
    @JsonProperty("bizData")
    public RString getBizData() {
        return bizData;
    }

    /*
     * setbizData
     * @param bizData bizData
     */
    @JsonProperty("bizData")
    public void setBizData(RString bizData) {
        this.bizData = bizData;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Icon getIcoOnseiFileDeleted() {
        return this.getOnseiFileDeleted().getIcoOnseiFileDeleted();
    }

    @JsonIgnore
    public void  setIcoOnseiFileDeleted(Icon icoOnseiFileDeleted) {
        this.getOnseiFileDeleted().setIcoOnseiFileDeleted(icoOnseiFileDeleted);
    }

    @JsonIgnore
    public Label getLblOnseiFileDeleted() {
        return this.getOnseiFileDeleted().getLblOnseiFileDeleted();
    }

    @JsonIgnore
    public void  setLblOnseiFileDeleted(Label lblOnseiFileDeleted) {
        this.getOnseiFileDeleted().setLblOnseiFileDeleted(lblOnseiFileDeleted);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(ShinsakaiOnseiJoho2 審査会音声情報) {
        OnseiFileOperatorHandler handler = new OnseiFileOperatorHandler(this);
        handler.initialize(審査会音声情報);
    }

    @Override
    public void initialize(ShinsakaiOnseiJoho2 審査会音声情報, RDateTime 追加日時) {
        OnseiFileOperatorHandler handler = new OnseiFileOperatorHandler(this);
        handler.initialize(審査会音声情報, 追加日時);
    }

}
