package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 09 15:13:08 JST 2014 
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.KaigoJuminJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.NushiJuminJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JuminPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JuminPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NushiJuminJoho")
    private NushiJuminJohoDiv NushiJuminJoho;
    @JsonProperty("KaigoJuminJoho")
    private KaigoJuminJohoDiv KaigoJuminJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("NushiJuminJoho")
    public NushiJuminJohoDiv getNushiJuminJoho() {
        return NushiJuminJoho;
    }

    @JsonProperty("NushiJuminJoho")
    public void setNushiJuminJoho(NushiJuminJohoDiv NushiJuminJoho) {
        this.NushiJuminJoho=NushiJuminJoho;
    }

    @JsonProperty("KaigoJuminJoho")
    public KaigoJuminJohoDiv getKaigoJuminJoho() {
        return KaigoJuminJoho;
    }

    @JsonProperty("KaigoJuminJoho")
    public void setKaigoJuminJoho(KaigoJuminJohoDiv KaigoJuminJoho) {
        this.KaigoJuminJoho=KaigoJuminJoho;
    }

}
