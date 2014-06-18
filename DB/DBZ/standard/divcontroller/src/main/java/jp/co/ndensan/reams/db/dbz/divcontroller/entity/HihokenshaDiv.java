package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KariKaigoCommonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KariKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Hihokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KariKihon")
    private KariKihonDiv KariKihon;
    @JsonProperty("KariKaigoCommon")
    private KariKaigoCommonDiv KariKaigoCommon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KariKihon")
    public KariKihonDiv getKariKihon() {
        return KariKihon;
    }

    @JsonProperty("KariKihon")
    public void setKariKihon(KariKihonDiv KariKihon) {
        this.KariKihon=KariKihon;
    }

    @JsonProperty("KariKaigoCommon")
    public KariKaigoCommonDiv getKariKaigoCommon() {
        return KariKaigoCommon;
    }

    @JsonProperty("KariKaigoCommon")
    public void setKariKaigoCommon(KariKaigoCommonDiv KariKaigoCommon) {
        this.KariKaigoCommon=KariKaigoCommon;
    }

}
