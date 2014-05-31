package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabImageJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabImageJohoDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplImage01")
    private tplImage01Div tplImage01;
    @JsonProperty("tplImage02")
    private tplImage02Div tplImage02;
    @JsonProperty("tplImage03")
    private tplImage03Div tplImage03;
    @JsonProperty("tplImage04")
    private tplImage04Div tplImage04;
    @JsonProperty("tplImage05")
    private tplImage05Div tplImage05;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplImage01")
    public tplImage01Div getTplImage01() {
        return tplImage01;
    }

    @JsonProperty("tplImage01")
    public void setTplImage01(tplImage01Div tplImage01) {
        this.tplImage01=tplImage01;
    }

    @JsonProperty("tplImage02")
    public tplImage02Div getTplImage02() {
        return tplImage02;
    }

    @JsonProperty("tplImage02")
    public void setTplImage02(tplImage02Div tplImage02) {
        this.tplImage02=tplImage02;
    }

    @JsonProperty("tplImage03")
    public tplImage03Div getTplImage03() {
        return tplImage03;
    }

    @JsonProperty("tplImage03")
    public void setTplImage03(tplImage03Div tplImage03) {
        this.tplImage03=tplImage03;
    }

    @JsonProperty("tplImage04")
    public tplImage04Div getTplImage04() {
        return tplImage04;
    }

    @JsonProperty("tplImage04")
    public void setTplImage04(tplImage04Div tplImage04) {
        this.tplImage04=tplImage04;
    }

    @JsonProperty("tplImage05")
    public tplImage05Div getTplImage05() {
        return tplImage05;
    }

    @JsonProperty("tplImage05")
    public void setTplImage05(tplImage05Div tplImage05) {
        this.tplImage05=tplImage05;
    }

}
