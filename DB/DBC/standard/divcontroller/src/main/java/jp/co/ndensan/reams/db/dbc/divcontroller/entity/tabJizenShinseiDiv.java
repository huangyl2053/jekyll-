package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplJizenShinseiContentsDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplJizenShinseiPayMethodDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplJizenShinseiResultDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabJizenShinsei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabJizenShinseiDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplJizenShinseiContents")
    private tplJizenShinseiContentsDiv tplJizenShinseiContents;
    @JsonProperty("tplJizenShinseiResult")
    private tplJizenShinseiResultDiv tplJizenShinseiResult;
    @JsonProperty("tplJizenShinseiPayMethod")
    private tplJizenShinseiPayMethodDiv tplJizenShinseiPayMethod;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplJizenShinseiContents")
    public tplJizenShinseiContentsDiv getTplJizenShinseiContents() {
        return tplJizenShinseiContents;
    }

    @JsonProperty("tplJizenShinseiContents")
    public void setTplJizenShinseiContents(tplJizenShinseiContentsDiv tplJizenShinseiContents) {
        this.tplJizenShinseiContents=tplJizenShinseiContents;
    }

    @JsonProperty("tplJizenShinseiResult")
    public tplJizenShinseiResultDiv getTplJizenShinseiResult() {
        return tplJizenShinseiResult;
    }

    @JsonProperty("tplJizenShinseiResult")
    public void setTplJizenShinseiResult(tplJizenShinseiResultDiv tplJizenShinseiResult) {
        this.tplJizenShinseiResult=tplJizenShinseiResult;
    }

    @JsonProperty("tplJizenShinseiPayMethod")
    public tplJizenShinseiPayMethodDiv getTplJizenShinseiPayMethod() {
        return tplJizenShinseiPayMethod;
    }

    @JsonProperty("tplJizenShinseiPayMethod")
    public void setTplJizenShinseiPayMethod(tplJizenShinseiPayMethodDiv tplJizenShinseiPayMethod) {
        this.tplJizenShinseiPayMethod=tplJizenShinseiPayMethod;
    }

}
