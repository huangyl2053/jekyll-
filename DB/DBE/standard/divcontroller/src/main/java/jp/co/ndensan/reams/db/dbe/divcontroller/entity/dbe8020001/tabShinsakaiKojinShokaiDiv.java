package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tplIchijiHanteiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tplShinsakaiJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tplShinsakaiKekkaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabShinsakaiKojinShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShinsakaiKojinShokaiDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplIchijiHantei")
    private tplIchijiHanteiDiv tplIchijiHantei;
    @JsonProperty("tplShinsakaiJoho")
    private tplShinsakaiJohoDiv tplShinsakaiJoho;
    @JsonProperty("tplShinsakaiKekka")
    private tplShinsakaiKekkaDiv tplShinsakaiKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplIchijiHantei")
    public tplIchijiHanteiDiv getTplIchijiHantei() {
        return tplIchijiHantei;
    }

    @JsonProperty("tplIchijiHantei")
    public void setTplIchijiHantei(tplIchijiHanteiDiv tplIchijiHantei) {
        this.tplIchijiHantei=tplIchijiHantei;
    }

    @JsonProperty("tplShinsakaiJoho")
    public tplShinsakaiJohoDiv getTplShinsakaiJoho() {
        return tplShinsakaiJoho;
    }

    @JsonProperty("tplShinsakaiJoho")
    public void setTplShinsakaiJoho(tplShinsakaiJohoDiv tplShinsakaiJoho) {
        this.tplShinsakaiJoho=tplShinsakaiJoho;
    }

    @JsonProperty("tplShinsakaiKekka")
    public tplShinsakaiKekkaDiv getTplShinsakaiKekka() {
        return tplShinsakaiKekka;
    }

    @JsonProperty("tplShinsakaiKekka")
    public void setTplShinsakaiKekka(tplShinsakaiKekkaDiv tplShinsakaiKekka) {
        this.tplShinsakaiKekka=tplShinsakaiKekka;
    }

}
