package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0220001;
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
 * GetsureiShori のクラスファイル 
 * 
 * @author 自動生成
 */
public class GetsureiShoriDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("CenterSoshinTaishoshaIchiran")
    private CenterSoshinTaishoshaIchiranDiv CenterSoshinTaishoshaIchiran;
    @JsonProperty("CenterSoshinTaishoshaShutsuryoku")
    private CenterSoshinTaishoshaShutsuryokuDiv CenterSoshinTaishoshaShutsuryoku;
    @JsonProperty("KanryoMsg")
    private KanryoMsgDiv KanryoMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getCenterSoshinTaishoshaIchiran
     * @return CenterSoshinTaishoshaIchiran
     */
    @JsonProperty("CenterSoshinTaishoshaIchiran")
    public CenterSoshinTaishoshaIchiranDiv getCenterSoshinTaishoshaIchiran() {
        return CenterSoshinTaishoshaIchiran;
    }

    /*
     * setCenterSoshinTaishoshaIchiran
     * @param CenterSoshinTaishoshaIchiran CenterSoshinTaishoshaIchiran
     */
    @JsonProperty("CenterSoshinTaishoshaIchiran")
    public void setCenterSoshinTaishoshaIchiran(CenterSoshinTaishoshaIchiranDiv CenterSoshinTaishoshaIchiran) {
        this.CenterSoshinTaishoshaIchiran = CenterSoshinTaishoshaIchiran;
    }

    /*
     * getCenterSoshinTaishoshaShutsuryoku
     * @return CenterSoshinTaishoshaShutsuryoku
     */
    @JsonProperty("CenterSoshinTaishoshaShutsuryoku")
    public CenterSoshinTaishoshaShutsuryokuDiv getCenterSoshinTaishoshaShutsuryoku() {
        return CenterSoshinTaishoshaShutsuryoku;
    }

    /*
     * setCenterSoshinTaishoshaShutsuryoku
     * @param CenterSoshinTaishoshaShutsuryoku CenterSoshinTaishoshaShutsuryoku
     */
    @JsonProperty("CenterSoshinTaishoshaShutsuryoku")
    public void setCenterSoshinTaishoshaShutsuryoku(CenterSoshinTaishoshaShutsuryokuDiv CenterSoshinTaishoshaShutsuryoku) {
        this.CenterSoshinTaishoshaShutsuryoku = CenterSoshinTaishoshaShutsuryoku;
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
    public TextBoxNum getTxtDispMax() {
        return this.getCenterSoshinTaishoshaIchiran().getTxtDispMax();
    }

    @JsonIgnore
    public void  setTxtDispMax(TextBoxNum txtDispMax) {
        this.getCenterSoshinTaishoshaIchiran().setTxtDispMax(txtDispMax);
    }

    @JsonIgnore
    public RadioButton getRadJyotaiKubun() {
        return this.getCenterSoshinTaishoshaIchiran().getRadJyotaiKubun();
    }

    @JsonIgnore
    public void  setRadJyotaiKubun(RadioButton radJyotaiKubun) {
        this.getCenterSoshinTaishoshaIchiran().setRadJyotaiKubun(radJyotaiKubun);
    }

    @JsonIgnore
    public Space getSpc1() {
        return this.getCenterSoshinTaishoshaIchiran().getSpc1();
    }

    @JsonIgnore
    public void  setSpc1(Space spc1) {
        this.getCenterSoshinTaishoshaIchiran().setSpc1(spc1);
    }

    @JsonIgnore
    public TextBox getTxtGokei() {
        return this.getCenterSoshinTaishoshaIchiran().getTxtGokei();
    }

    @JsonIgnore
    public void  setTxtGokei(TextBox txtGokei) {
        this.getCenterSoshinTaishoshaIchiran().setTxtGokei(txtGokei);
    }

    @JsonIgnore
    public TextBox getTxtKanryouKano() {
        return this.getCenterSoshinTaishoshaIchiran().getTxtKanryouKano();
    }

    @JsonIgnore
    public void  setTxtKanryouKano(TextBox txtKanryouKano) {
        this.getCenterSoshinTaishoshaIchiran().setTxtKanryouKano(txtKanryouKano);
    }

    @JsonIgnore
    public TextBox getTxtMisyori() {
        return this.getCenterSoshinTaishoshaIchiran().getTxtMisyori();
    }

    @JsonIgnore
    public void  setTxtMisyori(TextBox txtMisyori) {
        this.getCenterSoshinTaishoshaIchiran().setTxtMisyori(txtMisyori);
    }

    @JsonIgnore
    public DataGrid<dgNinteiTaskList_Row> getDgNinteiTaskList() {
        return this.getCenterSoshinTaishoshaIchiran().getDgNinteiTaskList();
    }

    @JsonIgnore
    public void  setDgNinteiTaskList(DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList) {
        this.getCenterSoshinTaishoshaIchiran().setDgNinteiTaskList(dgNinteiTaskList);
    }

    @JsonIgnore
    public ButtonDownLoad getBtndataoutput() {
        return this.getCenterSoshinTaishoshaShutsuryoku().getBtndataoutput();
    }

    @JsonIgnore
    public void  setBtndataoutput(ButtonDownLoad btndataoutput) {
        this.getCenterSoshinTaishoshaShutsuryoku().setBtndataoutput(btndataoutput);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryoMsg().getCcdKanryoMsg();
    }

    // </editor-fold>
}
