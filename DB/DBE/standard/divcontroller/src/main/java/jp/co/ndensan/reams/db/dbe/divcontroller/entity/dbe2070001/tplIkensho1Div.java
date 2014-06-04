package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplIkensho1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplIkensho1Div extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("imgIkensho1")
    private StaticImage imgIkensho1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("imgIkensho1")
    public StaticImage getImgIkensho1() {
        return imgIkensho1;
    }

    @JsonProperty("imgIkensho1")
    public void setImgIkensho1(StaticImage imgIkensho1) {
        this.imgIkensho1=imgIkensho1;
    }

}
