package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuJizenShinseiContentsDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuJizenShinseiResultDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuKaishuJizenShinsei のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuJizenShinseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JutakuKaishuJizenShinseiContents")
    private JutakuKaishuJizenShinseiContentsDiv JutakuKaishuJizenShinseiContents;
    @JsonProperty("JutakuKaishuJizenShinseiResult")
    private JutakuKaishuJizenShinseiResultDiv JutakuKaishuJizenShinseiResult;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JutakuKaishuJizenShinseiContents")
    public JutakuKaishuJizenShinseiContentsDiv getJutakuKaishuJizenShinseiContents() {
        return JutakuKaishuJizenShinseiContents;
    }

    @JsonProperty("JutakuKaishuJizenShinseiContents")
    public void setJutakuKaishuJizenShinseiContents(JutakuKaishuJizenShinseiContentsDiv JutakuKaishuJizenShinseiContents) {
        this.JutakuKaishuJizenShinseiContents=JutakuKaishuJizenShinseiContents;
    }

    @JsonProperty("JutakuKaishuJizenShinseiResult")
    public JutakuKaishuJizenShinseiResultDiv getJutakuKaishuJizenShinseiResult() {
        return JutakuKaishuJizenShinseiResult;
    }

    @JsonProperty("JutakuKaishuJizenShinseiResult")
    public void setJutakuKaishuJizenShinseiResult(JutakuKaishuJizenShinseiResultDiv JutakuKaishuJizenShinseiResult) {
        this.JutakuKaishuJizenShinseiResult=JutakuKaishuJizenShinseiResult;
    }

}
