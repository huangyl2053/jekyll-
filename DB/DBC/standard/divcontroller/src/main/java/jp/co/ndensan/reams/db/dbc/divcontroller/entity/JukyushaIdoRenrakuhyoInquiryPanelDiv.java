package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKihonJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoSub1Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoSub2Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoInquiryPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoInquiryPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoKihonJoho")
    private JukyushaIdoRenrakuhyoKihonJohoDiv JukyushaIdoRenrakuhyoKihonJoho;
    @JsonProperty("JukyushaIdoRenrakuhyoSub1")
    private JukyushaIdoRenrakuhyoSub1Div JukyushaIdoRenrakuhyoSub1;
    @JsonProperty("JukyushaIdoRenrakuhyoSub2")
    private JukyushaIdoRenrakuhyoSub2Div JukyushaIdoRenrakuhyoSub2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoKihonJoho")
    public JukyushaIdoRenrakuhyoKihonJohoDiv getJukyushaIdoRenrakuhyoKihonJoho() {
        return JukyushaIdoRenrakuhyoKihonJoho;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoKihonJoho")
    public void setJukyushaIdoRenrakuhyoKihonJoho(JukyushaIdoRenrakuhyoKihonJohoDiv JukyushaIdoRenrakuhyoKihonJoho) {
        this.JukyushaIdoRenrakuhyoKihonJoho=JukyushaIdoRenrakuhyoKihonJoho;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoSub1")
    public JukyushaIdoRenrakuhyoSub1Div getJukyushaIdoRenrakuhyoSub1() {
        return JukyushaIdoRenrakuhyoSub1;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoSub1")
    public void setJukyushaIdoRenrakuhyoSub1(JukyushaIdoRenrakuhyoSub1Div JukyushaIdoRenrakuhyoSub1) {
        this.JukyushaIdoRenrakuhyoSub1=JukyushaIdoRenrakuhyoSub1;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoSub2")
    public JukyushaIdoRenrakuhyoSub2Div getJukyushaIdoRenrakuhyoSub2() {
        return JukyushaIdoRenrakuhyoSub2;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoSub2")
    public void setJukyushaIdoRenrakuhyoSub2(JukyushaIdoRenrakuhyoSub2Div JukyushaIdoRenrakuhyoSub2) {
        this.JukyushaIdoRenrakuhyoSub2=JukyushaIdoRenrakuhyoSub2;
    }

}
