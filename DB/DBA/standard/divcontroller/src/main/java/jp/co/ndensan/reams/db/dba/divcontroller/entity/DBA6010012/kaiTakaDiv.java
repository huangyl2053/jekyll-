package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012;
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
 * kaiTaka のクラスファイル 
 * 
 * @author 自動生成
 */
public class kaiTakaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RadioButton4")
    private RadioButton RadioButton4;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("RadioButton4")
    public RadioButton getRadioButton4() {
        return RadioButton4;
    }

    @JsonProperty("RadioButton4")
    public void setRadioButton4(RadioButton RadioButton4) {
        this.RadioButton4=RadioButton4;
    }

}
