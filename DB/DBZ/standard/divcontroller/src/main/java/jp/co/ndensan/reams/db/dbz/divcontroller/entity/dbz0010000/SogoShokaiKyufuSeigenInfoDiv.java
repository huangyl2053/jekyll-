package jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbz0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbz0010000.SogoShokaiKyufuSeigenGengakuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbz0010000.SogoShokaiKyufuSeigenHenkoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiKyufuSeigenInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiKyufuSeigenInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSeigenTorokuJokyo")
    private TextBox txtSeigenTorokuJokyo;
    @JsonProperty("txtSeigenShuryoJokyo")
    private TextBox txtSeigenShuryoJokyo;
    @JsonProperty("SogoShokaiKyufuSeigenHenko")
    private SogoShokaiKyufuSeigenHenkoDiv SogoShokaiKyufuSeigenHenko;
    @JsonProperty("txtSeigenTainoKojoKetteiYMD")
    private TextBoxDate txtSeigenTainoKojoKetteiYMD;
    @JsonProperty("txtSeigenChoshuShometsuKikan")
    private TextBoxDateRange txtSeigenChoshuShometsuKikan;
    @JsonProperty("txtSeigenNofuzumiKikan")
    private TextBoxDateRange txtSeigenNofuzumiKikan;
    @JsonProperty("SogoShokaiKyufuSeigenGengaku")
    private SogoShokaiKyufuSeigenGengakuDiv SogoShokaiKyufuSeigenGengaku;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSeigenTorokuJokyo")
    public TextBox getTxtSeigenTorokuJokyo() {
        return txtSeigenTorokuJokyo;
    }

    @JsonProperty("txtSeigenTorokuJokyo")
    public void setTxtSeigenTorokuJokyo(TextBox txtSeigenTorokuJokyo) {
        this.txtSeigenTorokuJokyo=txtSeigenTorokuJokyo;
    }

    @JsonProperty("txtSeigenShuryoJokyo")
    public TextBox getTxtSeigenShuryoJokyo() {
        return txtSeigenShuryoJokyo;
    }

    @JsonProperty("txtSeigenShuryoJokyo")
    public void setTxtSeigenShuryoJokyo(TextBox txtSeigenShuryoJokyo) {
        this.txtSeigenShuryoJokyo=txtSeigenShuryoJokyo;
    }

    @JsonProperty("SogoShokaiKyufuSeigenHenko")
    public SogoShokaiKyufuSeigenHenkoDiv getSogoShokaiKyufuSeigenHenko() {
        return SogoShokaiKyufuSeigenHenko;
    }

    @JsonProperty("SogoShokaiKyufuSeigenHenko")
    public void setSogoShokaiKyufuSeigenHenko(SogoShokaiKyufuSeigenHenkoDiv SogoShokaiKyufuSeigenHenko) {
        this.SogoShokaiKyufuSeigenHenko=SogoShokaiKyufuSeigenHenko;
    }

    @JsonProperty("txtSeigenTainoKojoKetteiYMD")
    public TextBoxDate getTxtSeigenTainoKojoKetteiYMD() {
        return txtSeigenTainoKojoKetteiYMD;
    }

    @JsonProperty("txtSeigenTainoKojoKetteiYMD")
    public void setTxtSeigenTainoKojoKetteiYMD(TextBoxDate txtSeigenTainoKojoKetteiYMD) {
        this.txtSeigenTainoKojoKetteiYMD=txtSeigenTainoKojoKetteiYMD;
    }

    @JsonProperty("txtSeigenChoshuShometsuKikan")
    public TextBoxDateRange getTxtSeigenChoshuShometsuKikan() {
        return txtSeigenChoshuShometsuKikan;
    }

    @JsonProperty("txtSeigenChoshuShometsuKikan")
    public void setTxtSeigenChoshuShometsuKikan(TextBoxDateRange txtSeigenChoshuShometsuKikan) {
        this.txtSeigenChoshuShometsuKikan=txtSeigenChoshuShometsuKikan;
    }

    @JsonProperty("txtSeigenNofuzumiKikan")
    public TextBoxDateRange getTxtSeigenNofuzumiKikan() {
        return txtSeigenNofuzumiKikan;
    }

    @JsonProperty("txtSeigenNofuzumiKikan")
    public void setTxtSeigenNofuzumiKikan(TextBoxDateRange txtSeigenNofuzumiKikan) {
        this.txtSeigenNofuzumiKikan=txtSeigenNofuzumiKikan;
    }

    @JsonProperty("SogoShokaiKyufuSeigenGengaku")
    public SogoShokaiKyufuSeigenGengakuDiv getSogoShokaiKyufuSeigenGengaku() {
        return SogoShokaiKyufuSeigenGengaku;
    }

    @JsonProperty("SogoShokaiKyufuSeigenGengaku")
    public void setSogoShokaiKyufuSeigenGengaku(SogoShokaiKyufuSeigenGengakuDiv SogoShokaiKyufuSeigenGengaku) {
        this.SogoShokaiKyufuSeigenGengaku=SogoShokaiKyufuSeigenGengaku;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

}
