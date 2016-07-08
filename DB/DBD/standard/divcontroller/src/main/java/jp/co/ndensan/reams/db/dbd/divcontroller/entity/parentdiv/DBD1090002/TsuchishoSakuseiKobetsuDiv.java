package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TsuchishoSakuseiKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class TsuchishoSakuseiKobetsuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgChohyoSentaku")
    private DataGrid<dgChohyoSentaku_Row> dgChohyoSentaku;
    @JsonProperty("NinteiShoKobetsu")
    private NinteiShoKobetsuDiv NinteiShoKobetsu;
    @JsonProperty("HenkoTsuchiKobetsu")
    private HenkoTsuchiKobetsuDiv HenkoTsuchiKobetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgChohyoSentaku
     * @return dgChohyoSentaku
     */
    @JsonProperty("dgChohyoSentaku")
    public DataGrid<dgChohyoSentaku_Row> getDgChohyoSentaku() {
        return dgChohyoSentaku;
    }

    /*
     * setdgChohyoSentaku
     * @param dgChohyoSentaku dgChohyoSentaku
     */
    @JsonProperty("dgChohyoSentaku")
    public void setDgChohyoSentaku(DataGrid<dgChohyoSentaku_Row> dgChohyoSentaku) {
        this.dgChohyoSentaku = dgChohyoSentaku;
    }

    /*
     * getNinteiShoKobetsu
     * @return NinteiShoKobetsu
     */
    @JsonProperty("NinteiShoKobetsu")
    public NinteiShoKobetsuDiv getNinteiShoKobetsu() {
        return NinteiShoKobetsu;
    }

    /*
     * setNinteiShoKobetsu
     * @param NinteiShoKobetsu NinteiShoKobetsu
     */
    @JsonProperty("NinteiShoKobetsu")
    public void setNinteiShoKobetsu(NinteiShoKobetsuDiv NinteiShoKobetsu) {
        this.NinteiShoKobetsu = NinteiShoKobetsu;
    }

    /*
     * getHenkoTsuchiKobetsu
     * @return HenkoTsuchiKobetsu
     */
    @JsonProperty("HenkoTsuchiKobetsu")
    public HenkoTsuchiKobetsuDiv getHenkoTsuchiKobetsu() {
        return HenkoTsuchiKobetsu;
    }

    /*
     * setHenkoTsuchiKobetsu
     * @param HenkoTsuchiKobetsu HenkoTsuchiKobetsu
     */
    @JsonProperty("HenkoTsuchiKobetsu")
    public void setHenkoTsuchiKobetsu(HenkoTsuchiKobetsuDiv HenkoTsuchiKobetsu) {
        this.HenkoTsuchiKobetsu = HenkoTsuchiKobetsu;
    }

    // </editor-fold>
}
