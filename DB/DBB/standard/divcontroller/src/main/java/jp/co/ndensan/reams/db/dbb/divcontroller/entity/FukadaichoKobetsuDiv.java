package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FukadaichoKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukadaichoKobetsuDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dummyLabelDaicho")
    private Label dummyLabelDaicho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dummyLabelDaicho")
    public Label getDummyLabelDaicho() {
        return dummyLabelDaicho;
    }

    @JsonProperty("dummyLabelDaicho")
    public void setDummyLabelDaicho(Label dummyLabelDaicho) {
        this.dummyLabelDaicho=dummyLabelDaicho;
    }

}
