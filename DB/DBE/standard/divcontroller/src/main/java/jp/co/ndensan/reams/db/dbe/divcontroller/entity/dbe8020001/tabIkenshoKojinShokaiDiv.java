package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tplIkenshoImage1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tplIkenshoImage2Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tplIkenshoKomokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.tplShujiiIraiJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabIkenshoKojinShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabIkenshoKojinShokaiDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplShujiiIraiJoho")
    private tplShujiiIraiJohoDiv tplShujiiIraiJoho;
    @JsonProperty("tplIkenshoKomoku")
    private tplIkenshoKomokuDiv tplIkenshoKomoku;
    @JsonProperty("tplIkenshoImage1")
    private tplIkenshoImage1Div tplIkenshoImage1;
    @JsonProperty("tplIkenshoImage2")
    private tplIkenshoImage2Div tplIkenshoImage2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplShujiiIraiJoho")
    public tplShujiiIraiJohoDiv getTplShujiiIraiJoho() {
        return tplShujiiIraiJoho;
    }

    @JsonProperty("tplShujiiIraiJoho")
    public void setTplShujiiIraiJoho(tplShujiiIraiJohoDiv tplShujiiIraiJoho) {
        this.tplShujiiIraiJoho=tplShujiiIraiJoho;
    }

    @JsonProperty("tplIkenshoKomoku")
    public tplIkenshoKomokuDiv getTplIkenshoKomoku() {
        return tplIkenshoKomoku;
    }

    @JsonProperty("tplIkenshoKomoku")
    public void setTplIkenshoKomoku(tplIkenshoKomokuDiv tplIkenshoKomoku) {
        this.tplIkenshoKomoku=tplIkenshoKomoku;
    }

    @JsonProperty("tplIkenshoImage1")
    public tplIkenshoImage1Div getTplIkenshoImage1() {
        return tplIkenshoImage1;
    }

    @JsonProperty("tplIkenshoImage1")
    public void setTplIkenshoImage1(tplIkenshoImage1Div tplIkenshoImage1) {
        this.tplIkenshoImage1=tplIkenshoImage1;
    }

    @JsonProperty("tplIkenshoImage2")
    public tplIkenshoImage2Div getTplIkenshoImage2() {
        return tplIkenshoImage2;
    }

    @JsonProperty("tplIkenshoImage2")
    public void setTplIkenshoImage2(tplIkenshoImage2Div tplIkenshoImage2) {
        this.tplIkenshoImage2=tplIkenshoImage2;
    }

}
