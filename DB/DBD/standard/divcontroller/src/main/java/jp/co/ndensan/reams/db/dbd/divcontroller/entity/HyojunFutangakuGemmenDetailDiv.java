package jp.co.ndensan.reams.db.dbd.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.HyojunFutangakuGemmenRiyoshaFutanDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HyojunFutangakuGemmenDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class HyojunFutangakuGemmenDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("HyojunFutangakuGemmenRiyoshaFutan")
    private HyojunFutangakuGemmenRiyoshaFutanDiv HyojunFutangakuGemmenRiyoshaFutan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

    @JsonProperty("HyojunFutangakuGemmenRiyoshaFutan")
    public HyojunFutangakuGemmenRiyoshaFutanDiv getHyojunFutangakuGemmenRiyoshaFutan() {
        return HyojunFutangakuGemmenRiyoshaFutan;
    }

    @JsonProperty("HyojunFutangakuGemmenRiyoshaFutan")
    public void setHyojunFutangakuGemmenRiyoshaFutan(HyojunFutangakuGemmenRiyoshaFutanDiv HyojunFutangakuGemmenRiyoshaFutan) {
        this.HyojunFutangakuGemmenRiyoshaFutan=HyojunFutangakuGemmenRiyoshaFutan;
    }

}
