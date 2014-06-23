package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2030011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutokuTekiyoTaishoshaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutokuTekiyoTaishoshaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JutokuTekiyoCommonJoho")
    private KaigoAtenaInfoDiv JutokuTekiyoCommonJoho;
    @JsonProperty("JutokuTekiyoDbJoho")
    private KaigoShikakuKihonDiv JutokuTekiyoDbJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JutokuTekiyoCommonJoho")
    public KaigoAtenaInfoDiv getJutokuTekiyoCommonJoho() {
        return JutokuTekiyoCommonJoho;
    }

    @JsonProperty("JutokuTekiyoCommonJoho")
    public void setJutokuTekiyoCommonJoho(KaigoAtenaInfoDiv JutokuTekiyoCommonJoho) {
        this.JutokuTekiyoCommonJoho=JutokuTekiyoCommonJoho;
    }

    @JsonProperty("JutokuTekiyoDbJoho")
    public KaigoShikakuKihonDiv getJutokuTekiyoDbJoho() {
        return JutokuTekiyoDbJoho;
    }

    @JsonProperty("JutokuTekiyoDbJoho")
    public void setJutokuTekiyoDbJoho(KaigoShikakuKihonDiv JutokuTekiyoDbJoho) {
        this.JutokuTekiyoDbJoho=JutokuTekiyoDbJoho;
    }

}
