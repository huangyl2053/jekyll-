package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.YokaigoninteiJigyotaishoRirekiList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YokaigoninteiJigyotaishoRirekiList のクラスファイル
 *
 * @reamsid_L DBC-4350-010 wangxingpeng
 */
public class YokaigoninteiJigyotaishoRirekiListDiv extends Panel implements IYokaigoninteiJigyotaishoRirekiListDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlYokaigoNintei")
    private pnlYokaigoNinteiDiv pnlYokaigoNintei;
    @JsonProperty("pnlJigyoTaishosha")
    private pnlJigyoTaishoshaDiv pnlJigyoTaishosha;
    @JsonProperty("pnlBottonArea")
    private pnlBottonAreaDiv pnlBottonArea;
    @JsonProperty("HihokenshaNo")
    private RString HihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpnlYokaigoNintei
     * @return pnlYokaigoNintei
     */
    @JsonProperty("pnlYokaigoNintei")
    public pnlYokaigoNinteiDiv getPnlYokaigoNintei() {
        return pnlYokaigoNintei;
    }

    /*
     * setpnlYokaigoNintei
     * @param pnlYokaigoNintei pnlYokaigoNintei
     */
    @JsonProperty("pnlYokaigoNintei")
    public void setPnlYokaigoNintei(pnlYokaigoNinteiDiv pnlYokaigoNintei) {
        this.pnlYokaigoNintei = pnlYokaigoNintei;
    }

    /*
     * getpnlJigyoTaishosha
     * @return pnlJigyoTaishosha
     */
    @JsonProperty("pnlJigyoTaishosha")
    public pnlJigyoTaishoshaDiv getPnlJigyoTaishosha() {
        return pnlJigyoTaishosha;
    }

    /*
     * setpnlJigyoTaishosha
     * @param pnlJigyoTaishosha pnlJigyoTaishosha
     */
    @JsonProperty("pnlJigyoTaishosha")
    public void setPnlJigyoTaishosha(pnlJigyoTaishoshaDiv pnlJigyoTaishosha) {
        this.pnlJigyoTaishosha = pnlJigyoTaishosha;
    }

    /*
     * getpnlBottonArea
     * @return pnlBottonArea
     */
    @JsonProperty("pnlBottonArea")
    public pnlBottonAreaDiv getPnlBottonArea() {
        return pnlBottonArea;
    }

    /*
     * setpnlBottonArea
     * @param pnlBottonArea pnlBottonArea
     */
    @JsonProperty("pnlBottonArea")
    public void setPnlBottonArea(pnlBottonAreaDiv pnlBottonArea) {
        this.pnlBottonArea = pnlBottonArea;
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
    public DataGrid<dgNinteiRirekiList_Row> getDgNinteiRirekiList() {
        return this.getPnlYokaigoNintei().getDgNinteiRirekiList();
    }

    @JsonIgnore
    public void setDgNinteiRirekiList(DataGrid<dgNinteiRirekiList_Row> dgNinteiRirekiList) {
        this.getPnlYokaigoNintei().setDgNinteiRirekiList(dgNinteiRirekiList);
    }

    @JsonIgnore
    public DataGrid<dgJigyoTaishoshaList_Row> getDgJigyoTaishoshaList() {
        return this.getPnlJigyoTaishosha().getDgJigyoTaishoshaList();
    }

    @JsonIgnore
    public void setDgJigyoTaishoshaList(DataGrid<dgJigyoTaishoshaList_Row> dgJigyoTaishoshaList) {
        this.getPnlJigyoTaishosha().setDgJigyoTaishoshaList(dgJigyoTaishoshaList);
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getPnlBottonArea().getBtnClose();
    }

    @JsonIgnore
    public void setBtnClose(Button btnClose) {
        this.getPnlBottonArea().setBtnClose(btnClose);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
