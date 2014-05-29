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
 * RiyoshaFutan のクラスファイル 
 * 
 * @author 自動生成
 */
public class RiyoshaFutanDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radTeiritsuOrTeigaku")
    private RadioButton radTeiritsuOrTeigaku;
    @JsonProperty("txtKyufuritsu")
    private TextBoxNum txtKyufuritsu;
    @JsonProperty("txtRiyoshaFutangaku")
    private TextBoxNum txtRiyoshaFutangaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radTeiritsuOrTeigaku")
    public RadioButton getRadTeiritsuOrTeigaku() {
        return radTeiritsuOrTeigaku;
    }

    @JsonProperty("radTeiritsuOrTeigaku")
    public void setRadTeiritsuOrTeigaku(RadioButton radTeiritsuOrTeigaku) {
        this.radTeiritsuOrTeigaku=radTeiritsuOrTeigaku;
    }

    @JsonProperty("txtKyufuritsu")
    public TextBoxNum getTxtKyufuritsu() {
        return txtKyufuritsu;
    }

    @JsonProperty("txtKyufuritsu")
    public void setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.txtKyufuritsu=txtKyufuritsu;
    }

    @JsonProperty("txtRiyoshaFutangaku")
    public TextBoxNum getTxtRiyoshaFutangaku() {
        return txtRiyoshaFutangaku;
    }

    @JsonProperty("txtRiyoshaFutangaku")
    public void setTxtRiyoshaFutangaku(TextBoxNum txtRiyoshaFutangaku) {
        this.txtRiyoshaFutangaku=txtRiyoshaFutangaku;
    }

}
