package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsaKaiKekkaToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsaKaiKekkaTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-13_17-59-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("shinsakaikanryo")
    private shinsakaikanryoDiv shinsakaikanryo;
    @JsonProperty("btnShinsakaikanryooutput")
    private ButtonDownLoad btnShinsakaikanryooutput;
    @JsonProperty("KanryoMsg")
    private KanryoMsgDiv KanryoMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getshinsakaikanryo
     * @return shinsakaikanryo
     */
    @JsonProperty("shinsakaikanryo")
    public shinsakaikanryoDiv getShinsakaikanryo() {
        return shinsakaikanryo;
    }

    /*
     * setshinsakaikanryo
     * @param shinsakaikanryo shinsakaikanryo
     */
    @JsonProperty("shinsakaikanryo")
    public void setShinsakaikanryo(shinsakaikanryoDiv shinsakaikanryo) {
        this.shinsakaikanryo = shinsakaikanryo;
    }

    /*
     * getbtnShinsakaikanryooutput
     * @return btnShinsakaikanryooutput
     */
    @JsonProperty("btnShinsakaikanryooutput")
    public ButtonDownLoad getBtnShinsakaikanryooutput() {
        return btnShinsakaikanryooutput;
    }

    /*
     * setbtnShinsakaikanryooutput
     * @param btnShinsakaikanryooutput btnShinsakaikanryooutput
     */
    @JsonProperty("btnShinsakaikanryooutput")
    public void setBtnShinsakaikanryooutput(ButtonDownLoad btnShinsakaikanryooutput) {
        this.btnShinsakaikanryooutput = btnShinsakaikanryooutput;
    }

    /*
     * getKanryoMsg
     * @return KanryoMsg
     */
    @JsonProperty("KanryoMsg")
    public KanryoMsgDiv getKanryoMsg() {
        return KanryoMsg;
    }

    /*
     * setKanryoMsg
     * @param KanryoMsg KanryoMsg
     */
    @JsonProperty("KanryoMsg")
    public void setKanryoMsg(KanryoMsgDiv KanryoMsg) {
        this.KanryoMsg = KanryoMsg;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadTaishosyaJotai() {
        return this.getShinsakaikanryo().getRadTaishosyaJotai();
    }

    @JsonIgnore
    public void  setRadTaishosyaJotai(RadioButton radTaishosyaJotai) {
        this.getShinsakaikanryo().setRadTaishosyaJotai(radTaishosyaJotai);
    }

    @JsonIgnore
    public TextBox getTxtTotalCount() {
        return this.getShinsakaikanryo().getTxtTotalCount();
    }

    @JsonIgnore
    public void  setTxtTotalCount(TextBox txtTotalCount) {
        this.getShinsakaikanryo().setTxtTotalCount(txtTotalCount);
    }

    @JsonIgnore
    public TextBox getTxtCompleteCount() {
        return this.getShinsakaikanryo().getTxtCompleteCount();
    }

    @JsonIgnore
    public void  setTxtCompleteCount(TextBox txtCompleteCount) {
        this.getShinsakaikanryo().setTxtCompleteCount(txtCompleteCount);
    }

    @JsonIgnore
    public TextBox getTxtMishoriCount() {
        return this.getShinsakaikanryo().getTxtMishoriCount();
    }

    @JsonIgnore
    public void  setTxtMishoriCount(TextBox txtMishoriCount) {
        this.getShinsakaikanryo().setTxtMishoriCount(txtMishoriCount);
    }

    @JsonIgnore
    public DataGrid<dgNinteiTaskList_Row> getDgNinteiTaskList() {
        return this.getShinsakaikanryo().getDgNinteiTaskList();
    }

    @JsonIgnore
    public void  setDgNinteiTaskList(DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList) {
        this.getShinsakaikanryo().setDgNinteiTaskList(dgNinteiTaskList);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryoMsg().getCcdKanryoMsg();
    }

    // </editor-fold>
}
