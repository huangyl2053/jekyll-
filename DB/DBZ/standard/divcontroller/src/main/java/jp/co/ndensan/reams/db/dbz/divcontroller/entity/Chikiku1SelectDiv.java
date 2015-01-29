package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.Chiku1InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IChiku1InputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Chikiku1Select のクラスファイル 
 * 
 * @author 自動生成
 */
public class Chikiku1SelectDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdChiku1InputSt")
    private Chiku1InputDiv ccdChiku1InputSt;
    @JsonProperty("lblKaraChiku1")
    private Label lblKaraChiku1;
    @JsonProperty("ccdChiku1InputEd")
    private Chiku1InputDiv ccdChiku1InputEd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdChiku1InputSt")
    public IChiku1InputDiv getCcdChiku1InputSt() {
        return ccdChiku1InputSt;
    }

    @JsonProperty("lblKaraChiku1")
    public Label getLblKaraChiku1() {
        return lblKaraChiku1;
    }

    @JsonProperty("lblKaraChiku1")
    public void setLblKaraChiku1(Label lblKaraChiku1) {
        this.lblKaraChiku1=lblKaraChiku1;
    }

    @JsonProperty("ccdChiku1InputEd")
    public IChiku1InputDiv getCcdChiku1InputEd() {
        return ccdChiku1InputEd;
    }

}
