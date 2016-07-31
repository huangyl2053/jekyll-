package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ServiceRiyohyoBeppyoRiyoNissu のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceRiyohyoBeppyoRiyoNissuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZengetsuRiyoNissu")
    private TextBoxNum txtZengetsuRiyoNissu;
    @JsonProperty("txtTogetsuRiyoNissu")
    private TextBoxNum txtTogetsuRiyoNissu;
    @JsonProperty("txtRuikeiRiyoNissu")
    private TextBoxNum txtRuikeiRiyoNissu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZengetsuRiyoNissu
     * @return txtZengetsuRiyoNissu
     */
    @JsonProperty("txtZengetsuRiyoNissu")
    public TextBoxNum getTxtZengetsuRiyoNissu() {
        return txtZengetsuRiyoNissu;
    }

    /*
     * settxtZengetsuRiyoNissu
     * @param txtZengetsuRiyoNissu txtZengetsuRiyoNissu
     */
    @JsonProperty("txtZengetsuRiyoNissu")
    public void setTxtZengetsuRiyoNissu(TextBoxNum txtZengetsuRiyoNissu) {
        this.txtZengetsuRiyoNissu = txtZengetsuRiyoNissu;
    }

    /*
     * gettxtTogetsuRiyoNissu
     * @return txtTogetsuRiyoNissu
     */
    @JsonProperty("txtTogetsuRiyoNissu")
    public TextBoxNum getTxtTogetsuRiyoNissu() {
        return txtTogetsuRiyoNissu;
    }

    /*
     * settxtTogetsuRiyoNissu
     * @param txtTogetsuRiyoNissu txtTogetsuRiyoNissu
     */
    @JsonProperty("txtTogetsuRiyoNissu")
    public void setTxtTogetsuRiyoNissu(TextBoxNum txtTogetsuRiyoNissu) {
        this.txtTogetsuRiyoNissu = txtTogetsuRiyoNissu;
    }

    /*
     * gettxtRuikeiRiyoNissu
     * @return txtRuikeiRiyoNissu
     */
    @JsonProperty("txtRuikeiRiyoNissu")
    public TextBoxNum getTxtRuikeiRiyoNissu() {
        return txtRuikeiRiyoNissu;
    }

    /*
     * settxtRuikeiRiyoNissu
     * @param txtRuikeiRiyoNissu txtRuikeiRiyoNissu
     */
    @JsonProperty("txtRuikeiRiyoNissu")
    public void setTxtRuikeiRiyoNissu(TextBoxNum txtRuikeiRiyoNissu) {
        this.txtRuikeiRiyoNissu = txtRuikeiRiyoNissu;
    }

    // </editor-fold>
}
