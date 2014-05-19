package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
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
 * JutakuKaishuJizenShinseiDate のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuJizenShinseiDateDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiDate")
    private TextBoxDate txtShinseiDate;
    @JsonProperty("txtUketsukeDate")
    private TextBoxDate txtUketsukeDate;
    @JsonProperty("JutakuKaishuJizenShinseiSha")
    private ShinseishaInfoDiv JutakuKaishuJizenShinseiSha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

    @JsonProperty("txtUketsukeDate")
    public TextBoxDate getTxtUketsukeDate() {
        return txtUketsukeDate;
    }

    @JsonProperty("txtUketsukeDate")
    public void setTxtUketsukeDate(TextBoxDate txtUketsukeDate) {
        this.txtUketsukeDate=txtUketsukeDate;
    }

    @JsonProperty("JutakuKaishuJizenShinseiSha")
    public ShinseishaInfoDiv getJutakuKaishuJizenShinseiSha() {
        return JutakuKaishuJizenShinseiSha;
    }

    @JsonProperty("JutakuKaishuJizenShinseiSha")
    public void setJutakuKaishuJizenShinseiSha(ShinseishaInfoDiv JutakuKaishuJizenShinseiSha) {
        this.JutakuKaishuJizenShinseiSha=JutakuKaishuJizenShinseiSha;
    }

}
