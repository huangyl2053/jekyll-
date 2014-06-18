package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tplGaikyoChosaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tplHomonChosaIraiJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tplKihonChosaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tplTokkiJikoIchiranDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabNinteiChosaKojinShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabNinteiChosaKojinShokaiDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplHomonChosaIraiJoho")
    private tplHomonChosaIraiJohoDiv tplHomonChosaIraiJoho;
    @JsonProperty("tplGaikyoChosa")
    private tplGaikyoChosaDiv tplGaikyoChosa;
    @JsonProperty("tplKihonChosa")
    private tplKihonChosaDiv tplKihonChosa;
    @JsonProperty("tplTokkiJikoIchiran")
    private tplTokkiJikoIchiranDiv tplTokkiJikoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplHomonChosaIraiJoho")
    public tplHomonChosaIraiJohoDiv getTplHomonChosaIraiJoho() {
        return tplHomonChosaIraiJoho;
    }

    @JsonProperty("tplHomonChosaIraiJoho")
    public void setTplHomonChosaIraiJoho(tplHomonChosaIraiJohoDiv tplHomonChosaIraiJoho) {
        this.tplHomonChosaIraiJoho=tplHomonChosaIraiJoho;
    }

    @JsonProperty("tplGaikyoChosa")
    public tplGaikyoChosaDiv getTplGaikyoChosa() {
        return tplGaikyoChosa;
    }

    @JsonProperty("tplGaikyoChosa")
    public void setTplGaikyoChosa(tplGaikyoChosaDiv tplGaikyoChosa) {
        this.tplGaikyoChosa=tplGaikyoChosa;
    }

    @JsonProperty("tplKihonChosa")
    public tplKihonChosaDiv getTplKihonChosa() {
        return tplKihonChosa;
    }

    @JsonProperty("tplKihonChosa")
    public void setTplKihonChosa(tplKihonChosaDiv tplKihonChosa) {
        this.tplKihonChosa=tplKihonChosa;
    }

    @JsonProperty("tplTokkiJikoIchiran")
    public tplTokkiJikoIchiranDiv getTplTokkiJikoIchiran() {
        return tplTokkiJikoIchiran;
    }

    @JsonProperty("tplTokkiJikoIchiran")
    public void setTplTokkiJikoIchiran(tplTokkiJikoIchiranDiv tplTokkiJikoIchiran) {
        this.tplTokkiJikoIchiran=tplTokkiJikoIchiran;
    }

}
