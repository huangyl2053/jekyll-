package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.GaitoshaSentakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.KensakuShijiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GaitoshaKensakuMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class GaitoshaKensakuMainDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuShiji")
    private KensakuShijiDiv KensakuShiji;
    @JsonProperty("GaitoshaSentaku")
    private GaitoshaSentakuDiv GaitoshaSentaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KensakuShiji")
    public KensakuShijiDiv getKensakuShiji() {
        return KensakuShiji;
    }

    @JsonProperty("KensakuShiji")
    public void setKensakuShiji(KensakuShijiDiv KensakuShiji) {
        this.KensakuShiji=KensakuShiji;
    }

    @JsonProperty("GaitoshaSentaku")
    public GaitoshaSentakuDiv getGaitoshaSentaku() {
        return GaitoshaSentaku;
    }

    @JsonProperty("GaitoshaSentaku")
    public void setGaitoshaSentaku(GaitoshaSentakuDiv GaitoshaSentaku) {
        this.GaitoshaSentaku=GaitoshaSentaku;
    }

}
