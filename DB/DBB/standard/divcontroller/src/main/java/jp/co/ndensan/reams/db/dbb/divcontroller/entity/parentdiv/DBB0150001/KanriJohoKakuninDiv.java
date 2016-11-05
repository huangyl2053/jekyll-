package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KanriJohoKakunin のクラスファイル 
 * 
 * @author 自動生成
 */
public class KanriJohoKakuninDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgHokenryoDankai")
    private DataGrid<dgHokenryoDankai_Row> dgHokenryoDankai;
    @JsonProperty("dgKomokuNaiyo")
    private DataGrid<dgKomokuNaiyo_Row> dgKomokuNaiyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgHokenryoDankai
     * @return dgHokenryoDankai
     */
    @JsonProperty("dgHokenryoDankai")
    public DataGrid<dgHokenryoDankai_Row> getDgHokenryoDankai() {
        return dgHokenryoDankai;
    }

    /*
     * setdgHokenryoDankai
     * @param dgHokenryoDankai dgHokenryoDankai
     */
    @JsonProperty("dgHokenryoDankai")
    public void setDgHokenryoDankai(DataGrid<dgHokenryoDankai_Row> dgHokenryoDankai) {
        this.dgHokenryoDankai = dgHokenryoDankai;
    }

    /*
     * getdgKomokuNaiyo
     * @return dgKomokuNaiyo
     */
    @JsonProperty("dgKomokuNaiyo")
    public DataGrid<dgKomokuNaiyo_Row> getDgKomokuNaiyo() {
        return dgKomokuNaiyo;
    }

    /*
     * setdgKomokuNaiyo
     * @param dgKomokuNaiyo dgKomokuNaiyo
     */
    @JsonProperty("dgKomokuNaiyo")
    public void setDgKomokuNaiyo(DataGrid<dgKomokuNaiyo_Row> dgKomokuNaiyo) {
        this.dgKomokuNaiyo = dgKomokuNaiyo;
    }

    // </editor-fold>
}
