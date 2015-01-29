package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IChoikiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChoikiSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChoikiSelectDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdChoikiInputSt")
    private ChoikiInputDiv ccdChoikiInputSt;
    @JsonProperty("lblKaraChoiki")
    private Label lblKaraChoiki;
    @JsonProperty("ccdChoikiInputEd")
    private ChoikiInputDiv ccdChoikiInputEd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdChoikiInputSt")
    public IChoikiInputDiv getCcdChoikiInputSt() {
        return ccdChoikiInputSt;
    }

    @JsonProperty("lblKaraChoiki")
    public Label getLblKaraChoiki() {
        return lblKaraChoiki;
    }

    @JsonProperty("lblKaraChoiki")
    public void setLblKaraChoiki(Label lblKaraChoiki) {
        this.lblKaraChoiki=lblKaraChoiki;
    }

    @JsonProperty("ccdChoikiInputEd")
    public IChoikiInputDiv getCcdChoikiInputEd() {
        return ccdChoikiInputEd;
    }

}
