package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tplIkenshoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tplKihonJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tplNinteiChosaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tplShinsakaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabKojinJokyoShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabKojinJokyoShokaiDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplKihonJoho")
    private tplKihonJohoDiv tplKihonJoho;
    @JsonProperty("tplNinteiChosa")
    private tplNinteiChosaDiv tplNinteiChosa;
    @JsonProperty("tplIkensho")
    private tplIkenshoDiv tplIkensho;
    @JsonProperty("tplShinsakai")
    private tplShinsakaiDiv tplShinsakai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplKihonJoho")
    public tplKihonJohoDiv getTplKihonJoho() {
        return tplKihonJoho;
    }

    @JsonProperty("tplKihonJoho")
    public void setTplKihonJoho(tplKihonJohoDiv tplKihonJoho) {
        this.tplKihonJoho=tplKihonJoho;
    }

    @JsonProperty("tplNinteiChosa")
    public tplNinteiChosaDiv getTplNinteiChosa() {
        return tplNinteiChosa;
    }

    @JsonProperty("tplNinteiChosa")
    public void setTplNinteiChosa(tplNinteiChosaDiv tplNinteiChosa) {
        this.tplNinteiChosa=tplNinteiChosa;
    }

    @JsonProperty("tplIkensho")
    public tplIkenshoDiv getTplIkensho() {
        return tplIkensho;
    }

    @JsonProperty("tplIkensho")
    public void setTplIkensho(tplIkenshoDiv tplIkensho) {
        this.tplIkensho=tplIkensho;
    }

    @JsonProperty("tplShinsakai")
    public tplShinsakaiDiv getTplShinsakai() {
        return tplShinsakai;
    }

    @JsonProperty("tplShinsakai")
    public void setTplShinsakai(tplShinsakaiDiv tplShinsakai) {
        this.tplShinsakai=tplShinsakai;
    }

}
