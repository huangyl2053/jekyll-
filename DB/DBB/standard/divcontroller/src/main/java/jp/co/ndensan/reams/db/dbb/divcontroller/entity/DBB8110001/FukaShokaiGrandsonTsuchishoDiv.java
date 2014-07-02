package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8110001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.KobetsuHakkoChoteiJiyuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.KobetsuHakkoChoteiJiyuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.KobetsuHakkoZengoSentakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.KobetsuHakkoZengoSentakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FukaShokaiGrandsonTsuchisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaShokaiGrandsonTsuchishoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBox txtChoteiNendo;
    @JsonProperty("txtFukaNendo")
    private TextBox txtFukaNendo;
    @JsonProperty("txtKoseiM")
    private TextBox txtKoseiM;
    @JsonProperty("txtKoseiYMD")
    private TextBox txtKoseiYMD;
    @JsonProperty("KobetsuHakkoChoteiJiyu")
    private KobetsuHakkoChoteiJiyuDiv KobetsuHakkoChoteiJiyu;
    @JsonProperty("KobetsuHakkoZengoSentaku")
    private KobetsuHakkoZengoSentakuDiv KobetsuHakkoZengoSentaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChoteiNendo")
    public TextBox getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBox txtChoteiNendo) {
        this.txtChoteiNendo=txtChoteiNendo;
    }

    @JsonProperty("txtFukaNendo")
    public TextBox getTxtFukaNendo() {
        return txtFukaNendo;
    }

    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBox txtFukaNendo) {
        this.txtFukaNendo=txtFukaNendo;
    }

    @JsonProperty("txtKoseiM")
    public TextBox getTxtKoseiM() {
        return txtKoseiM;
    }

    @JsonProperty("txtKoseiM")
    public void setTxtKoseiM(TextBox txtKoseiM) {
        this.txtKoseiM=txtKoseiM;
    }

    @JsonProperty("txtKoseiYMD")
    public TextBox getTxtKoseiYMD() {
        return txtKoseiYMD;
    }

    @JsonProperty("txtKoseiYMD")
    public void setTxtKoseiYMD(TextBox txtKoseiYMD) {
        this.txtKoseiYMD=txtKoseiYMD;
    }

    @JsonProperty("KobetsuHakkoChoteiJiyu")
    public KobetsuHakkoChoteiJiyuDiv getKobetsuHakkoChoteiJiyu() {
        return KobetsuHakkoChoteiJiyu;
    }

    @JsonProperty("KobetsuHakkoChoteiJiyu")
    public void setKobetsuHakkoChoteiJiyu(KobetsuHakkoChoteiJiyuDiv KobetsuHakkoChoteiJiyu) {
        this.KobetsuHakkoChoteiJiyu=KobetsuHakkoChoteiJiyu;
    }

    @JsonProperty("KobetsuHakkoZengoSentaku")
    public KobetsuHakkoZengoSentakuDiv getKobetsuHakkoZengoSentaku() {
        return KobetsuHakkoZengoSentaku;
    }

    @JsonProperty("KobetsuHakkoZengoSentaku")
    public void setKobetsuHakkoZengoSentaku(KobetsuHakkoZengoSentakuDiv KobetsuHakkoZengoSentaku) {
        this.KobetsuHakkoZengoSentaku=KobetsuHakkoZengoSentaku;
    }

}
