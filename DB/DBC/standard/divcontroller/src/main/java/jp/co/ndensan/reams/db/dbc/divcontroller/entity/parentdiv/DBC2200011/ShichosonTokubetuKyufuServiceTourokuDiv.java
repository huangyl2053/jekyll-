package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2200011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShichosonTokubetuKyufuServiceTouroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShichosonTokubetuKyufuServiceTourokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTsuika")
    private Button btnTsuika;
    @JsonProperty("dgServiceNaiyo")
    private DataGrid<dgServiceNaiyo_Row> dgServiceNaiyo;
    @JsonProperty("KubunShikyuGendogakuShosai")
    private KubunShikyuGendogakuShosaiDiv KubunShikyuGendogakuShosai;

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
     * getdgServiceNaiyo
     * @return dgServiceNaiyo
     */
    @JsonProperty("dgServiceNaiyo")
    public DataGrid<dgServiceNaiyo_Row> getDgServiceNaiyo() {
        return dgServiceNaiyo;
    }

    /*
     * setdgServiceNaiyo
     * @param dgServiceNaiyo dgServiceNaiyo
     */
    @JsonProperty("dgServiceNaiyo")
    public void setDgServiceNaiyo(DataGrid<dgServiceNaiyo_Row> dgServiceNaiyo) {
        this.dgServiceNaiyo = dgServiceNaiyo;
    }

    /*
     * getKubunShikyuGendogakuShosai
     * @return KubunShikyuGendogakuShosai
     */
    @JsonProperty("KubunShikyuGendogakuShosai")
    public KubunShikyuGendogakuShosaiDiv getKubunShikyuGendogakuShosai() {
        return KubunShikyuGendogakuShosai;
    }

    /*
     * setKubunShikyuGendogakuShosai
     * @param KubunShikyuGendogakuShosai KubunShikyuGendogakuShosai
     */
    @JsonProperty("KubunShikyuGendogakuShosai")
    public void setKubunShikyuGendogakuShosai(KubunShikyuGendogakuShosaiDiv KubunShikyuGendogakuShosai) {
        this.KubunShikyuGendogakuShosai = KubunShikyuGendogakuShosai;
    }

    // </editor-fold>
}
