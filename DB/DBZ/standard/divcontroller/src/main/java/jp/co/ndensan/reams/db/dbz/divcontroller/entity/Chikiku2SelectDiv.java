package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.Chiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IChiku2InputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Chikiku2Select のクラスファイル 
 * 
 * @author 自動生成
 */
public class Chikiku2SelectDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdChiku2InputSt")
    private Chiku2InputDiv ccdChiku2InputSt;
    @JsonProperty("lblKaraChiku2")
    private Label lblKaraChiku2;
    @JsonProperty("ccdChiku2InputEd")
    private Chiku2InputDiv ccdChiku2InputEd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdChiku2InputSt")
    public IChiku2InputDiv getCcdChiku2InputSt() {
        return ccdChiku2InputSt;
    }

    @JsonProperty("lblKaraChiku2")
    public Label getLblKaraChiku2() {
        return lblKaraChiku2;
    }

    @JsonProperty("lblKaraChiku2")
    public void setLblKaraChiku2(Label lblKaraChiku2) {
        this.lblKaraChiku2=lblKaraChiku2;
    }

    @JsonProperty("ccdChiku2InputEd")
    public IChiku2InputDiv getCcdChiku2InputEd() {
        return ccdChiku2InputEd;
    }

}
