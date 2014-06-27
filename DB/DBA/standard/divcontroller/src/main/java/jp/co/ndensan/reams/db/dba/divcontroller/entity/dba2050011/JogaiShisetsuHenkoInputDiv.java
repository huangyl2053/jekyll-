package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JogaiShisetsuHenkoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class JogaiShisetsuHenkoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShisetsuHenkoDate")
    private TextBoxFlexibleDate txtShisetsuHenkoDate;
    @JsonProperty("ShisetsuHenkoJogaiShisetsu")
    private ShisetsuJohoDiv ShisetsuHenkoJogaiShisetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShisetsuHenkoDate")
    public TextBoxFlexibleDate getTxtShisetsuHenkoDate() {
        return txtShisetsuHenkoDate;
    }

    @JsonProperty("txtShisetsuHenkoDate")
    public void setTxtShisetsuHenkoDate(TextBoxFlexibleDate txtShisetsuHenkoDate) {
        this.txtShisetsuHenkoDate=txtShisetsuHenkoDate;
    }

    @JsonProperty("ShisetsuHenkoJogaiShisetsu")
    public ShisetsuJohoDiv getShisetsuHenkoJogaiShisetsu() {
        return ShisetsuHenkoJogaiShisetsu;
    }

    @JsonProperty("ShisetsuHenkoJogaiShisetsu")
    public void setShisetsuHenkoJogaiShisetsu(ShisetsuJohoDiv ShisetsuHenkoJogaiShisetsu) {
        this.ShisetsuHenkoJogaiShisetsu=ShisetsuHenkoJogaiShisetsu;
    }

}
