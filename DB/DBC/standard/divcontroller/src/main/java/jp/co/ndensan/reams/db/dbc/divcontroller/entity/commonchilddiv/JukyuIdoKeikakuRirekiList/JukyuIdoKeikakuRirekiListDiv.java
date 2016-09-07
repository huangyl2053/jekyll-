package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyuIdoKeikakuRirekiList;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * JukyuIdoKeikakuRirekiList のクラスファイル
 *
 * @author 自動生成
 */
public class JukyuIdoKeikakuRirekiListDiv extends Panel implements IJukyuIdoKeikakuRirekiListDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlKyotakuKeikaku")
    private pnlKyotakuKeikakuDiv pnlKyotakuKeikaku;
    @JsonProperty("pnlButton")
    private pnlButtonDiv pnlButton;
    @JsonProperty("HihokenshaNo")
    private RString HihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpnlKyotakuKeikaku
     * @return pnlKyotakuKeikaku
     */
    @JsonProperty("pnlKyotakuKeikaku")
    public pnlKyotakuKeikakuDiv getPnlKyotakuKeikaku() {
        return pnlKyotakuKeikaku;
    }

    /*
     * setpnlKyotakuKeikaku
     * @param pnlKyotakuKeikaku pnlKyotakuKeikaku
     */
    @JsonProperty("pnlKyotakuKeikaku")
    public void setPnlKyotakuKeikaku(pnlKyotakuKeikakuDiv pnlKyotakuKeikaku) {
        this.pnlKyotakuKeikaku = pnlKyotakuKeikaku;
    }

    /*
     * getpnlButton
     * @return pnlButton
     */
    @JsonProperty("pnlButton")
    public pnlButtonDiv getPnlButton() {
        return pnlButton;
    }

    /*
     * setpnlButton
     * @param pnlButton pnlButton
     */
    @JsonProperty("pnlButton")
    public void setPnlButton(pnlButtonDiv pnlButton) {
        this.pnlButton = pnlButton;
    }

    /*
     * getHihokenshaNo
     * @return HihokenshaNo
     */
    @JsonProperty("HihokenshaNo")
    public RString getHihokenshaNo() {
        return HihokenshaNo;
    }

    /*
     * setHihokenshaNo
     * @param HihokenshaNo HihokenshaNo
     */
    @JsonProperty("HihokenshaNo")
    public void setHihokenshaNo(RString HihokenshaNo) {
        this.HihokenshaNo = HihokenshaNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgKyotakuKeikaku_Row> getDgKyotakuKeikaku() {
        return this.getPnlKyotakuKeikaku().getDgKyotakuKeikaku();
    }

    @JsonIgnore
    public void  setDgKyotakuKeikaku(DataGrid<dgKyotakuKeikaku_Row> dgKyotakuKeikaku) {
        this.getPnlKyotakuKeikaku().setDgKyotakuKeikaku(dgKyotakuKeikaku);
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getPnlButton().getBtnClose();
    }

    @JsonIgnore
    public void  setBtnClose(Button btnClose) {
        this.getPnlButton().setBtnClose(btnClose);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
