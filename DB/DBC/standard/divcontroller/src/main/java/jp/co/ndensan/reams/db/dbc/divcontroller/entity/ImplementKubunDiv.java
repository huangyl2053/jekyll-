package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
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
 * ImplementKubun のクラスファイル 
 * 
 * @author 自動生成
 */
public class ImplementKubunDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radNijiYobosha")
    private RadioButton radNijiYobosha;
    @JsonProperty("radYoshien1")
    private RadioButton radYoshien1;
    @JsonProperty("radYoshien2")
    private RadioButton radYoshien2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radNijiYobosha")
    public RadioButton getRadNijiYobosha() {
        return radNijiYobosha;
    }

    @JsonProperty("radNijiYobosha")
    public void setRadNijiYobosha(RadioButton radNijiYobosha) {
        this.radNijiYobosha=radNijiYobosha;
    }

    @JsonProperty("radYoshien1")
    public RadioButton getRadYoshien1() {
        return radYoshien1;
    }

    @JsonProperty("radYoshien1")
    public void setRadYoshien1(RadioButton radYoshien1) {
        this.radYoshien1=radYoshien1;
    }

    @JsonProperty("radYoshien2")
    public RadioButton getRadYoshien2() {
        return radYoshien2;
    }

    @JsonProperty("radYoshien2")
    public void setRadYoshien2(RadioButton radYoshien2) {
        this.radYoshien2=radYoshien2;
    }

}
