package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.GemmenGengakuRirekiList;
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
 * GemmenGengakuRirekiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class GemmenGengakuRirekiListDiv extends Panel implements IGemmenGengakuRirekiListDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlFutangendogakuRireki")
    private pnlFutangendogakuRirekiDiv pnlFutangendogakuRireki;
    @JsonProperty("pnlTaGemmenGengakuRireki")
    private pnlTaGemmenGengakuRirekiDiv pnlTaGemmenGengakuRireki;
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
     * getpnlFutangendogakuRireki
     * @return pnlFutangendogakuRireki
     */
    @JsonProperty("pnlFutangendogakuRireki")
    public pnlFutangendogakuRirekiDiv getPnlFutangendogakuRireki() {
        return pnlFutangendogakuRireki;
    }

    /*
     * setpnlFutangendogakuRireki
     * @param pnlFutangendogakuRireki pnlFutangendogakuRireki
     */
    @JsonProperty("pnlFutangendogakuRireki")
    public void setPnlFutangendogakuRireki(pnlFutangendogakuRirekiDiv pnlFutangendogakuRireki) {
        this.pnlFutangendogakuRireki = pnlFutangendogakuRireki;
    }

    /*
     * getpnlTaGemmenGengakuRireki
     * @return pnlTaGemmenGengakuRireki
     */
    @JsonProperty("pnlTaGemmenGengakuRireki")
    public pnlTaGemmenGengakuRirekiDiv getPnlTaGemmenGengakuRireki() {
        return pnlTaGemmenGengakuRireki;
    }

    /*
     * setpnlTaGemmenGengakuRireki
     * @param pnlTaGemmenGengakuRireki pnlTaGemmenGengakuRireki
     */
    @JsonProperty("pnlTaGemmenGengakuRireki")
    public void setPnlTaGemmenGengakuRireki(pnlTaGemmenGengakuRirekiDiv pnlTaGemmenGengakuRireki) {
        this.pnlTaGemmenGengakuRireki = pnlTaGemmenGengakuRireki;
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
    public DataGrid<dgFutanGendogakuList_Row> getDgFutanGendogakuList() {
        return this.getPnlFutangendogakuRireki().getDgFutanGendogakuList();
    }

    @JsonIgnore
    public void  setDgFutanGendogakuList(DataGrid<dgFutanGendogakuList_Row> dgFutanGendogakuList) {
        this.getPnlFutangendogakuRireki().setDgFutanGendogakuList(dgFutanGendogakuList);
    }

    @JsonIgnore
    public DataGrid<dgTaGemmenGengakuList_Row> getDgTaGemmenGengakuList() {
        return this.getPnlTaGemmenGengakuRireki().getDgTaGemmenGengakuList();
    }

    @JsonIgnore
    public void  setDgTaGemmenGengakuList(DataGrid<dgTaGemmenGengakuList_Row> dgTaGemmenGengakuList) {
        this.getPnlTaGemmenGengakuRireki().setDgTaGemmenGengakuList(dgTaGemmenGengakuList);
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
