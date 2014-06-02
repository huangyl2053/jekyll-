package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
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
 * tplIkenshoShosaiImageHyoji2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplIkenshoShosaiImageHyoji2Div extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("imgIkensho2")
    private StaticImage imgIkensho2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("imgIkensho2")
    public StaticImage getImgIkensho2() {
        return imgIkensho2;
    }

    @JsonProperty("imgIkensho2")
    public void setImgIkensho2(StaticImage imgIkensho2) {
        this.imgIkensho2=imgIkensho2;
    }

}
