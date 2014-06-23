package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuJizenShinseiKozaInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuJizenShinseiReasonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuZizenShinseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShinseishaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JutakuKaishuJizenShinseiContents のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuJizenShinseiContentsDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJutakuOwner")
    private TextBox txtJutakuOwner;
    @JsonProperty("txtRelationWithHihokensha")
    private TextBox txtRelationWithHihokensha;
    @JsonProperty("JutakuKaishuZizenShinseiDetail")
    private JutakuKaishuZizenShinseiDetailDiv JutakuKaishuZizenShinseiDetail;
    @JsonProperty("JutakuKaishuJizenShinseiSha")
    private ShinseishaInfoDiv JutakuKaishuJizenShinseiSha;
    @JsonProperty("JutakuKaishuJizenShinseiReason")
    private JutakuKaishuJizenShinseiReasonDiv JutakuKaishuJizenShinseiReason;
    @JsonProperty("JutakuKaishuJizenShinseiKozaInfo")
    private JutakuKaishuJizenShinseiKozaInfoDiv JutakuKaishuJizenShinseiKozaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtJutakuOwner")
    public TextBox getTxtJutakuOwner() {
        return txtJutakuOwner;
    }

    @JsonProperty("txtJutakuOwner")
    public void setTxtJutakuOwner(TextBox txtJutakuOwner) {
        this.txtJutakuOwner=txtJutakuOwner;
    }

    @JsonProperty("txtRelationWithHihokensha")
    public TextBox getTxtRelationWithHihokensha() {
        return txtRelationWithHihokensha;
    }

    @JsonProperty("txtRelationWithHihokensha")
    public void setTxtRelationWithHihokensha(TextBox txtRelationWithHihokensha) {
        this.txtRelationWithHihokensha=txtRelationWithHihokensha;
    }

    @JsonProperty("JutakuKaishuZizenShinseiDetail")
    public JutakuKaishuZizenShinseiDetailDiv getJutakuKaishuZizenShinseiDetail() {
        return JutakuKaishuZizenShinseiDetail;
    }

    @JsonProperty("JutakuKaishuZizenShinseiDetail")
    public void setJutakuKaishuZizenShinseiDetail(JutakuKaishuZizenShinseiDetailDiv JutakuKaishuZizenShinseiDetail) {
        this.JutakuKaishuZizenShinseiDetail=JutakuKaishuZizenShinseiDetail;
    }

    @JsonProperty("JutakuKaishuJizenShinseiSha")
    public ShinseishaInfoDiv getJutakuKaishuJizenShinseiSha() {
        return JutakuKaishuJizenShinseiSha;
    }

    @JsonProperty("JutakuKaishuJizenShinseiSha")
    public void setJutakuKaishuJizenShinseiSha(ShinseishaInfoDiv JutakuKaishuJizenShinseiSha) {
        this.JutakuKaishuJizenShinseiSha=JutakuKaishuJizenShinseiSha;
    }

    @JsonProperty("JutakuKaishuJizenShinseiReason")
    public JutakuKaishuJizenShinseiReasonDiv getJutakuKaishuJizenShinseiReason() {
        return JutakuKaishuJizenShinseiReason;
    }

    @JsonProperty("JutakuKaishuJizenShinseiReason")
    public void setJutakuKaishuJizenShinseiReason(JutakuKaishuJizenShinseiReasonDiv JutakuKaishuJizenShinseiReason) {
        this.JutakuKaishuJizenShinseiReason=JutakuKaishuJizenShinseiReason;
    }

    @JsonProperty("JutakuKaishuJizenShinseiKozaInfo")
    public JutakuKaishuJizenShinseiKozaInfoDiv getJutakuKaishuJizenShinseiKozaInfo() {
        return JutakuKaishuJizenShinseiKozaInfo;
    }

    @JsonProperty("JutakuKaishuJizenShinseiKozaInfo")
    public void setJutakuKaishuJizenShinseiKozaInfo(JutakuKaishuJizenShinseiKozaInfoDiv JutakuKaishuJizenShinseiKozaInfo) {
        this.JutakuKaishuJizenShinseiKozaInfo=JutakuKaishuJizenShinseiKozaInfo;
    }

}
