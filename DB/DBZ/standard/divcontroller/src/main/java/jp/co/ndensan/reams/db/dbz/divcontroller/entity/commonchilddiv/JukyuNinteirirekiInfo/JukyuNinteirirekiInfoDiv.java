package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JukyuNinteirirekiInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyuNinteirirekiInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyuNinteirirekiInfoDiv extends Panel implements IJukyuNinteirirekiInfoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgNinteiRireki")
    private DataGrid<dgNinteiRireki_Row> dgNinteiRireki;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("hdHihokenshaNo")
    private RString hdHihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgNinteiRireki
     * @return dgNinteiRireki
     */
    @JsonProperty("dgNinteiRireki")
    public DataGrid<dgNinteiRireki_Row> getDgNinteiRireki() {
        return dgNinteiRireki;
    }

    /*
     * setdgNinteiRireki
     * @param dgNinteiRireki dgNinteiRireki
     */
    @JsonProperty("dgNinteiRireki")
    public void setDgNinteiRireki(DataGrid<dgNinteiRireki_Row> dgNinteiRireki) {
        this.dgNinteiRireki = dgNinteiRireki;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    /*
     * gethdHihokenshaNo
     * @return hdHihokenshaNo
     */
    @JsonProperty("hdHihokenshaNo")
    public RString getHdHihokenshaNo() {
        return hdHihokenshaNo;
    }

    /*
     * sethdHihokenshaNo
     * @param hdHihokenshaNo hdHihokenshaNo
     */
    @JsonProperty("hdHihokenshaNo")
    public void setHdHihokenshaNo(RString hdHihokenshaNo) {
        this.hdHihokenshaNo = hdHihokenshaNo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
