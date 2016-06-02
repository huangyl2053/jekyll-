package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NijiyoboJigyoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class NijiyoboJigyoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radNijiyoboJigyoKubun")
    private RadioButton radNijiyoboJigyoKubun;
    @JsonProperty("txtNijiyoboJigyoYukoDateRange")
    private TextBoxDateRange txtNijiyoboJigyoYukoDateRange;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradNijiyoboJigyoKubun
     * @return radNijiyoboJigyoKubun
     */
    @JsonProperty("radNijiyoboJigyoKubun")
    public RadioButton getRadNijiyoboJigyoKubun() {
        return radNijiyoboJigyoKubun;
    }

    /*
     * setradNijiyoboJigyoKubun
     * @param radNijiyoboJigyoKubun radNijiyoboJigyoKubun
     */
    @JsonProperty("radNijiyoboJigyoKubun")
    public void setRadNijiyoboJigyoKubun(RadioButton radNijiyoboJigyoKubun) {
        this.radNijiyoboJigyoKubun = radNijiyoboJigyoKubun;
    }

    /*
     * gettxtNijiyoboJigyoYukoDateRange
     * @return txtNijiyoboJigyoYukoDateRange
     */
    @JsonProperty("txtNijiyoboJigyoYukoDateRange")
    public TextBoxDateRange getTxtNijiyoboJigyoYukoDateRange() {
        return txtNijiyoboJigyoYukoDateRange;
    }

    /*
     * settxtNijiyoboJigyoYukoDateRange
     * @param txtNijiyoboJigyoYukoDateRange txtNijiyoboJigyoYukoDateRange
     */
    @JsonProperty("txtNijiyoboJigyoYukoDateRange")
    public void setTxtNijiyoboJigyoYukoDateRange(TextBoxDateRange txtNijiyoboJigyoYukoDateRange) {
        this.txtNijiyoboJigyoYukoDateRange = txtNijiyoboJigyoYukoDateRange;
    }

    // </editor-fold>
}
