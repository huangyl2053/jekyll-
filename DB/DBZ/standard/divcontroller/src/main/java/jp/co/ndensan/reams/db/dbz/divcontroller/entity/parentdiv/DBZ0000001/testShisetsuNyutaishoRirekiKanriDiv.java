package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0000001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shisetsunyutaishorirekikanri.IShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * testShisetsuNyutaishoRirekiKanri のクラスファイル 
 * 
 * @author 自動生成
 */
public class testShisetsuNyutaishoRirekiKanriDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShisetsuNyutaishRirekiKanri")
    private ShisetsuNyutaishoRirekiKanriDiv ccdShisetsuNyutaishRirekiKanri;
    @JsonProperty("btnInitialize")
    private Button btnInitialize;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdShisetsuNyutaishRirekiKanri")
    public IShisetsuNyutaishoRirekiKanriDiv getCcdShisetsuNyutaishRirekiKanri() {
        return ccdShisetsuNyutaishRirekiKanri;
    }

    @JsonProperty("btnInitialize")
    public Button getBtnInitialize() {
        return btnInitialize;
    }

    @JsonProperty("btnInitialize")
    public void setBtnInitialize(Button btnInitialize) {
        this.btnInitialize=btnInitialize;
    }

}
