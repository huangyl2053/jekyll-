package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.KihonChosa1gunDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.KihonChosa2gunDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.KihonChosa3gunDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.KihonChosa4gunDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.KihonChosa5gunDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.KihonChosaJiritsudoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.KihonChosaTokubetsuIryoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplKihonChosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplKihonChosaDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KihonChosa1gun")
    private KihonChosa1gunDiv KihonChosa1gun;
    @JsonProperty("KihonChosa2gun")
    private KihonChosa2gunDiv KihonChosa2gun;
    @JsonProperty("KihonChosa3gun")
    private KihonChosa3gunDiv KihonChosa3gun;
    @JsonProperty("KihonChosa4gun")
    private KihonChosa4gunDiv KihonChosa4gun;
    @JsonProperty("KihonChosa5gun")
    private KihonChosa5gunDiv KihonChosa5gun;
    @JsonProperty("KihonChosaTokubetsuIryo")
    private KihonChosaTokubetsuIryoDiv KihonChosaTokubetsuIryo;
    @JsonProperty("KihonChosaJiritsudo")
    private KihonChosaJiritsudoDiv KihonChosaJiritsudo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KihonChosa1gun")
    public KihonChosa1gunDiv getKihonChosa1gun() {
        return KihonChosa1gun;
    }

    @JsonProperty("KihonChosa1gun")
    public void setKihonChosa1gun(KihonChosa1gunDiv KihonChosa1gun) {
        this.KihonChosa1gun=KihonChosa1gun;
    }

    @JsonProperty("KihonChosa2gun")
    public KihonChosa2gunDiv getKihonChosa2gun() {
        return KihonChosa2gun;
    }

    @JsonProperty("KihonChosa2gun")
    public void setKihonChosa2gun(KihonChosa2gunDiv KihonChosa2gun) {
        this.KihonChosa2gun=KihonChosa2gun;
    }

    @JsonProperty("KihonChosa3gun")
    public KihonChosa3gunDiv getKihonChosa3gun() {
        return KihonChosa3gun;
    }

    @JsonProperty("KihonChosa3gun")
    public void setKihonChosa3gun(KihonChosa3gunDiv KihonChosa3gun) {
        this.KihonChosa3gun=KihonChosa3gun;
    }

    @JsonProperty("KihonChosa4gun")
    public KihonChosa4gunDiv getKihonChosa4gun() {
        return KihonChosa4gun;
    }

    @JsonProperty("KihonChosa4gun")
    public void setKihonChosa4gun(KihonChosa4gunDiv KihonChosa4gun) {
        this.KihonChosa4gun=KihonChosa4gun;
    }

    @JsonProperty("KihonChosa5gun")
    public KihonChosa5gunDiv getKihonChosa5gun() {
        return KihonChosa5gun;
    }

    @JsonProperty("KihonChosa5gun")
    public void setKihonChosa5gun(KihonChosa5gunDiv KihonChosa5gun) {
        this.KihonChosa5gun=KihonChosa5gun;
    }

    @JsonProperty("KihonChosaTokubetsuIryo")
    public KihonChosaTokubetsuIryoDiv getKihonChosaTokubetsuIryo() {
        return KihonChosaTokubetsuIryo;
    }

    @JsonProperty("KihonChosaTokubetsuIryo")
    public void setKihonChosaTokubetsuIryo(KihonChosaTokubetsuIryoDiv KihonChosaTokubetsuIryo) {
        this.KihonChosaTokubetsuIryo=KihonChosaTokubetsuIryo;
    }

    @JsonProperty("KihonChosaJiritsudo")
    public KihonChosaJiritsudoDiv getKihonChosaJiritsudo() {
        return KihonChosaJiritsudo;
    }

    @JsonProperty("KihonChosaJiritsudo")
    public void setKihonChosaJiritsudo(KihonChosaJiritsudoDiv KihonChosaJiritsudo) {
        this.KihonChosaJiritsudo=KihonChosaJiritsudo;
    }

}
