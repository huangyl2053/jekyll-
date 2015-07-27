package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.Chiku3InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IChiku3InputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Chikiku3Select のクラスファイル 
 * 
 * @author 自動生成
 */
public class Chikiku3SelectDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdChiku3InputSt")
    private Chiku3InputDiv ccdChiku3InputSt;
    @JsonProperty("lblKaraChiku3")
    private Label lblKaraChiku3;
    @JsonProperty("ccdChiku3InputEd")
    private Chiku3InputDiv ccdChiku3InputEd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdChiku3InputSt")
    public IChiku3InputDiv getCcdChiku3InputSt() {
        return ccdChiku3InputSt;
    }

    @JsonProperty("lblKaraChiku3")
    public Label getLblKaraChiku3() {
        return lblKaraChiku3;
    }

    @JsonProperty("lblKaraChiku3")
    public void setLblKaraChiku3(Label lblKaraChiku3) {
        this.lblKaraChiku3=lblKaraChiku3;
    }

    @JsonProperty("ccdChiku3InputEd")
    public IChiku3InputDiv getCcdChiku3InputEd() {
        return ccdChiku3InputEd;
    }

}
