package jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbz0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiKyufuSeigenGengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiKyufuSeigenGengakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSeigenGengakuKikan")
    private TextBoxDateRange txtSeigenGengakuKikan;
    @JsonProperty("txtSeigenGengakuKetteiYMD")
    private TextBoxDate txtSeigenGengakuKetteiYMD;
    @JsonProperty("txtSeigenGengakuTekiyoKikan")
    private TextBoxDateRange txtSeigenGengakuTekiyoKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSeigenGengakuKikan")
    public TextBoxDateRange getTxtSeigenGengakuKikan() {
        return txtSeigenGengakuKikan;
    }

    @JsonProperty("txtSeigenGengakuKikan")
    public void setTxtSeigenGengakuKikan(TextBoxDateRange txtSeigenGengakuKikan) {
        this.txtSeigenGengakuKikan=txtSeigenGengakuKikan;
    }

    @JsonProperty("txtSeigenGengakuKetteiYMD")
    public TextBoxDate getTxtSeigenGengakuKetteiYMD() {
        return txtSeigenGengakuKetteiYMD;
    }

    @JsonProperty("txtSeigenGengakuKetteiYMD")
    public void setTxtSeigenGengakuKetteiYMD(TextBoxDate txtSeigenGengakuKetteiYMD) {
        this.txtSeigenGengakuKetteiYMD=txtSeigenGengakuKetteiYMD;
    }

    @JsonProperty("txtSeigenGengakuTekiyoKikan")
    public TextBoxDateRange getTxtSeigenGengakuTekiyoKikan() {
        return txtSeigenGengakuTekiyoKikan;
    }

    @JsonProperty("txtSeigenGengakuTekiyoKikan")
    public void setTxtSeigenGengakuTekiyoKikan(TextBoxDateRange txtSeigenGengakuTekiyoKikan) {
        this.txtSeigenGengakuTekiyoKikan=txtSeigenGengakuTekiyoKikan;
    }

}
