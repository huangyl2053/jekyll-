package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011.ShisetsuNyutaishoKanriTaishoshaDbJohoDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShisetsuNyutaishoKainriTaishoshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuNyutaishoKainriTaishoshaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShisetsuNyutaisyoKanriTaishoshaCommonJoho")
    private AtenaShokaiSimpleDiv ShisetsuNyutaisyoKanriTaishoshaCommonJoho;
    @JsonProperty("ShisetsuNyutaishoKanriTaishoshaDbJoho")
    private ShisetsuNyutaishoKanriTaishoshaDbJohoDiv ShisetsuNyutaishoKanriTaishoshaDbJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShisetsuNyutaisyoKanriTaishoshaCommonJoho")
    public AtenaShokaiSimpleDiv getShisetsuNyutaisyoKanriTaishoshaCommonJoho() {
        return ShisetsuNyutaisyoKanriTaishoshaCommonJoho;
    }

    @JsonProperty("ShisetsuNyutaisyoKanriTaishoshaCommonJoho")
    public void setShisetsuNyutaisyoKanriTaishoshaCommonJoho(AtenaShokaiSimpleDiv ShisetsuNyutaisyoKanriTaishoshaCommonJoho) {
        this.ShisetsuNyutaisyoKanriTaishoshaCommonJoho=ShisetsuNyutaisyoKanriTaishoshaCommonJoho;
    }

    @JsonProperty("ShisetsuNyutaishoKanriTaishoshaDbJoho")
    public ShisetsuNyutaishoKanriTaishoshaDbJohoDiv getShisetsuNyutaishoKanriTaishoshaDbJoho() {
        return ShisetsuNyutaishoKanriTaishoshaDbJoho;
    }

    @JsonProperty("ShisetsuNyutaishoKanriTaishoshaDbJoho")
    public void setShisetsuNyutaishoKanriTaishoshaDbJoho(ShisetsuNyutaishoKanriTaishoshaDbJohoDiv ShisetsuNyutaishoKanriTaishoshaDbJoho) {
        this.ShisetsuNyutaishoKanriTaishoshaDbJoho=ShisetsuNyutaishoKanriTaishoshaDbJoho;
    }

}
