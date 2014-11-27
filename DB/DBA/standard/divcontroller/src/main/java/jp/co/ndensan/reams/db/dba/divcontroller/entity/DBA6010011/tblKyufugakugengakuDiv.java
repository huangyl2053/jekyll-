package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011.KaigohokenryoIchiranDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011.KogakuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011.KyojuhiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011.KyufugakugengakuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011.kaiShokuhiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblKyufugakugengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKyufugakugengakuDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celKyufugaku")
    private celKyufugakuAttblKyufugakugengaku celKyufugaku;
    @JsonProperty("cellKaigohoken")
    private cellKaigohokenAttblKyufugakugengaku cellKaigohoken;
    @JsonProperty("celShokuhiKogaku")
    private celShokuhiKogakuAttblKyufugakugengaku celShokuhiKogaku;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public KyufugakugengakuDiv getKyufugakugengaku() {
        return this.celKyufugaku.getKyufugakugengaku();
    }

    @JsonIgnore
    public KyojuhiDiv getKyojuhi() {
        return this.celKyufugaku.getKyojuhi();
    }

    @JsonIgnore
    public KaigohokenryoIchiranDiv getKaigohokenryoIchiran() {
        return this.cellKaigohoken.getKaigohokenryoIchiran();
    }

    @JsonIgnore
    public kaiShokuhiDiv getKaiShokuhi() {
        return this.celShokuhiKogaku.getKaiShokuhi();
    }

    @JsonIgnore
    public KogakuDiv getKogaku() {
        return this.celShokuhiKogaku.getKogaku();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celKyufugaku")
    private celKyufugakuAttblKyufugakugengaku getCelKyufugaku() {
        return celKyufugaku;
    }

    @JsonProperty("celKyufugaku")
    private void setCelKyufugaku(celKyufugakuAttblKyufugakugengaku celKyufugaku) {
        this.celKyufugaku=celKyufugaku;
    }

    @JsonProperty("cellKaigohoken")
    private cellKaigohokenAttblKyufugakugengaku getCellKaigohoken() {
        return cellKaigohoken;
    }

    @JsonProperty("cellKaigohoken")
    private void setCellKaigohoken(cellKaigohokenAttblKyufugakugengaku cellKaigohoken) {
        this.cellKaigohoken=cellKaigohoken;
    }

    @JsonProperty("celShokuhiKogaku")
    private celShokuhiKogakuAttblKyufugakugengaku getCelShokuhiKogaku() {
        return celShokuhiKogaku;
    }

    @JsonProperty("celShokuhiKogaku")
    private void setCelShokuhiKogaku(celShokuhiKogakuAttblKyufugakugengaku celShokuhiKogaku) {
        this.celShokuhiKogaku=celShokuhiKogaku;
    }

}
/**
 * celKyufugaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celKyufugakuAttblKyufugakugengaku extends TableCell {
    @JsonProperty("Kyufugakugengaku")
    private KyufugakugengakuDiv Kyufugakugengaku;
    @JsonProperty("Kyojuhi")
    private KyojuhiDiv Kyojuhi;

    @JsonProperty("Kyufugakugengaku")
    public KyufugakugengakuDiv getKyufugakugengaku() {
        return Kyufugakugengaku;
    }

    @JsonProperty("Kyufugakugengaku")
    public void setKyufugakugengaku(KyufugakugengakuDiv Kyufugakugengaku) {
        this.Kyufugakugengaku=Kyufugakugengaku;
    }

    @JsonProperty("Kyojuhi")
    public KyojuhiDiv getKyojuhi() {
        return Kyojuhi;
    }

    @JsonProperty("Kyojuhi")
    public void setKyojuhi(KyojuhiDiv Kyojuhi) {
        this.Kyojuhi=Kyojuhi;
    }

}
/**
 * cellKaigohoken のクラスファイル 
 * 
 * @author 自動生成
 */
class cellKaigohokenAttblKyufugakugengaku extends TableCell {
    @JsonProperty("KaigohokenryoIchiran")
    private KaigohokenryoIchiranDiv KaigohokenryoIchiran;

    @JsonProperty("KaigohokenryoIchiran")
    public KaigohokenryoIchiranDiv getKaigohokenryoIchiran() {
        return KaigohokenryoIchiran;
    }

    @JsonProperty("KaigohokenryoIchiran")
    public void setKaigohokenryoIchiran(KaigohokenryoIchiranDiv KaigohokenryoIchiran) {
        this.KaigohokenryoIchiran=KaigohokenryoIchiran;
    }

}
/**
 * celShokuhiKogaku のクラスファイル 
 * 
 * @author 自動生成
 */
class celShokuhiKogakuAttblKyufugakugengaku extends TableCell {
    @JsonProperty("kaiShokuhi")
    private kaiShokuhiDiv kaiShokuhi;
    @JsonProperty("Kogaku")
    private KogakuDiv Kogaku;

    @JsonProperty("kaiShokuhi")
    public kaiShokuhiDiv getKaiShokuhi() {
        return kaiShokuhi;
    }

    @JsonProperty("kaiShokuhi")
    public void setKaiShokuhi(kaiShokuhiDiv kaiShokuhi) {
        this.kaiShokuhi=kaiShokuhi;
    }

    @JsonProperty("Kogaku")
    public KogakuDiv getKogaku() {
        return Kogaku;
    }

    @JsonProperty("Kogaku")
    public void setKogaku(KogakuDiv Kogaku) {
        this.Kogaku=Kogaku;
    }

}
