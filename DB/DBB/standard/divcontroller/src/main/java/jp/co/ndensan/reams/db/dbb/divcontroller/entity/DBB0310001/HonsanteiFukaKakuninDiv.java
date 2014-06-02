package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HonsanteiFukaKakunin のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonsanteiFukaKakuninDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtFukaNendo")
    private TextBox txtFukaNendo;
    @JsonProperty("HonsanteiShoriKakunin")
    private HonsanteiShoriKakuninDiv HonsanteiShoriKakunin;
    @JsonProperty("HonsanteiKanrijoho")
    private HonsanteiKanrijohoDiv HonsanteiKanrijoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtFukaNendo")
    public TextBox getTxtFukaNendo() {
        return txtFukaNendo;
    }

    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBox txtFukaNendo) {
        this.txtFukaNendo=txtFukaNendo;
    }

    @JsonProperty("HonsanteiShoriKakunin")
    public HonsanteiShoriKakuninDiv getHonsanteiShoriKakunin() {
        return HonsanteiShoriKakunin;
    }

    @JsonProperty("HonsanteiShoriKakunin")
    public void setHonsanteiShoriKakunin(HonsanteiShoriKakuninDiv HonsanteiShoriKakunin) {
        this.HonsanteiShoriKakunin=HonsanteiShoriKakunin;
    }

    @JsonProperty("HonsanteiKanrijoho")
    public HonsanteiKanrijohoDiv getHonsanteiKanrijoho() {
        return HonsanteiKanrijoho;
    }

    @JsonProperty("HonsanteiKanrijoho")
    public void setHonsanteiKanrijoho(HonsanteiKanrijohoDiv HonsanteiKanrijoho) {
        this.HonsanteiKanrijoho=HonsanteiKanrijoho;
    }

}
