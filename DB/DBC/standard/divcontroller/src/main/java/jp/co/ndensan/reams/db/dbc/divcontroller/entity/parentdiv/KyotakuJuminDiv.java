package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.KyotakuNushiJuminJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyotakuJumin のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuJuminDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyotakuNushiJuminJoho")
    private KyotakuNushiJuminJohoDiv KyotakuNushiJuminJoho;
    @JsonProperty("btnDlgSeteiJoho")
    private ButtonDialog btnDlgSeteiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyotakuNushiJuminJoho")
    public KyotakuNushiJuminJohoDiv getKyotakuNushiJuminJoho() {
        return KyotakuNushiJuminJoho;
    }

    @JsonProperty("KyotakuNushiJuminJoho")
    public void setKyotakuNushiJuminJoho(KyotakuNushiJuminJohoDiv KyotakuNushiJuminJoho) {
        this.KyotakuNushiJuminJoho=KyotakuNushiJuminJoho;
    }

    @JsonProperty("btnDlgSeteiJoho")
    public ButtonDialog getBtnDlgSeteiJoho() {
        return btnDlgSeteiJoho;
    }

    @JsonProperty("btnDlgSeteiJoho")
    public void setBtnDlgSeteiJoho(ButtonDialog btnDlgSeteiJoho) {
        this.btnDlgSeteiJoho=btnDlgSeteiJoho;
    }

}
