package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SystemKanriShakaiFukushiTotal のクラスファイル 
 * 
 * @author 自動生成
 */
public class SystemKanriShakaiFukushiTotalDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SystemKanri")
    private SystemKanriDiv SystemKanri;
    @JsonProperty("KoshinKekkaKakunin")
    private KoshinKekkaKakuninDiv KoshinKekkaKakunin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSystemKanri
     * @return SystemKanri
     */
    @JsonProperty("SystemKanri")
    public SystemKanriDiv getSystemKanri() {
        return SystemKanri;
    }

    /*
     * setSystemKanri
     * @param SystemKanri SystemKanri
     */
    @JsonProperty("SystemKanri")
    public void setSystemKanri(SystemKanriDiv SystemKanri) {
        this.SystemKanri = SystemKanri;
    }

    /*
     * getKoshinKekkaKakunin
     * @return KoshinKekkaKakunin
     */
    @JsonProperty("KoshinKekkaKakunin")
    public KoshinKekkaKakuninDiv getKoshinKekkaKakunin() {
        return KoshinKekkaKakunin;
    }

    /*
     * setKoshinKekkaKakunin
     * @param KoshinKekkaKakunin KoshinKekkaKakunin
     */
    @JsonProperty("KoshinKekkaKakunin")
    public void setKoshinKekkaKakunin(KoshinKekkaKakuninDiv KoshinKekkaKakunin) {
        this.KoshinKekkaKakunin = KoshinKekkaKakunin;
    }

    // </editor-fold>
}
