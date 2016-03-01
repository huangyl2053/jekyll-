package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KataAshi のクラスファイル 
 * 
 * @author 自動生成
 */
public class KataAshiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKataAshi")
    private Button btnKataAshi;
    @JsonProperty("radKataAshi")
    private RadioButton radKataAshi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKataAshi
     * @return btnKataAshi
     */
    @JsonProperty("btnKataAshi")
    public Button getBtnKataAshi() {
        return btnKataAshi;
    }

    /*
     * setbtnKataAshi
     * @param btnKataAshi btnKataAshi
     */
    @JsonProperty("btnKataAshi")
    public void setBtnKataAshi(Button btnKataAshi) {
        this.btnKataAshi = btnKataAshi;
    }

    /*
     * getradKataAshi
     * @return radKataAshi
     */
    @JsonProperty("radKataAshi")
    public RadioButton getRadKataAshi() {
        return radKataAshi;
    }

    /*
     * setradKataAshi
     * @param radKataAshi radKataAshi
     */
    @JsonProperty("radKataAshi")
    public void setRadKataAshi(RadioButton radKataAshi) {
        this.radKataAshi = radKataAshi;
    }

    // </editor-fold>
}
