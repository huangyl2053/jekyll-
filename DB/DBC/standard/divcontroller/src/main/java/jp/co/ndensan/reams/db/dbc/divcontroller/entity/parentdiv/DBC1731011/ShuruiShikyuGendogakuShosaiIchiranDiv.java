package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1731011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShuruiShikyuGendogakuShosaiIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShuruiShikyuGendogakuShosaiIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTsuika")
    private Button btnTsuika;
    @JsonProperty("dgShikyuGendogaku")
    private DataGrid<dgShikyuGendogaku_Row> dgShikyuGendogaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTsuika
     * @return btnTsuika
     */
    @JsonProperty("btnTsuika")
    public Button getBtnTsuika() {
        return btnTsuika;
    }

    /*
     * setbtnTsuika
     * @param btnTsuika btnTsuika
     */
    @JsonProperty("btnTsuika")
    public void setBtnTsuika(Button btnTsuika) {
        this.btnTsuika = btnTsuika;
    }

    /*
     * getdgShikyuGendogaku
     * @return dgShikyuGendogaku
     */
    @JsonProperty("dgShikyuGendogaku")
    public DataGrid<dgShikyuGendogaku_Row> getDgShikyuGendogaku() {
        return dgShikyuGendogaku;
    }

    /*
     * setdgShikyuGendogaku
     * @param dgShikyuGendogaku dgShikyuGendogaku
     */
    @JsonProperty("dgShikyuGendogaku")
    public void setDgShikyuGendogaku(DataGrid<dgShikyuGendogaku_Row> dgShikyuGendogaku) {
        this.dgShikyuGendogaku = dgShikyuGendogaku;
    }

    // </editor-fold>
}
