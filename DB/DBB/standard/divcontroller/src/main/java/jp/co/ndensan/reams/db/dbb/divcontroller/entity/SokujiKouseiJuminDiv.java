package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.SokujiKouseiJuminJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.SokujiKouseiKaigoJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SokujiKouseiJumin のクラスファイル 
 * 
 * @author 自動生成
 */
public class SokujiKouseiJuminDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SokujiKouseiJuminJoho")
    private SokujiKouseiJuminJohoDiv SokujiKouseiJuminJoho;
    @JsonProperty("SokujiKouseiKaigoJoho")
    private SokujiKouseiKaigoJohoDiv SokujiKouseiKaigoJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SokujiKouseiJuminJoho")
    public SokujiKouseiJuminJohoDiv getSokujiKouseiJuminJoho() {
        return SokujiKouseiJuminJoho;
    }

    @JsonProperty("SokujiKouseiJuminJoho")
    public void setSokujiKouseiJuminJoho(SokujiKouseiJuminJohoDiv SokujiKouseiJuminJoho) {
        this.SokujiKouseiJuminJoho=SokujiKouseiJuminJoho;
    }

    @JsonProperty("SokujiKouseiKaigoJoho")
    public SokujiKouseiKaigoJohoDiv getSokujiKouseiKaigoJoho() {
        return SokujiKouseiKaigoJoho;
    }

    @JsonProperty("SokujiKouseiKaigoJoho")
    public void setSokujiKouseiKaigoJoho(SokujiKouseiKaigoJohoDiv SokujiKouseiKaigoJoho) {
        this.SokujiKouseiKaigoJoho=SokujiKouseiKaigoJoho;
    }

}
