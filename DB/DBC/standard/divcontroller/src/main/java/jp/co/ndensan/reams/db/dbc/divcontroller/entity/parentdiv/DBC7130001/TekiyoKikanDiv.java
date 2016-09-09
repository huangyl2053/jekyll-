package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TekiyoKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class TekiyoKikanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTekiyoKaishiNengetsu")
    private TextBoxDateRange txtTekiyoKaishiNengetsu;
    @JsonProperty("txtTekiyoShuryoNengetsu")
    private TextBoxDateRange txtTekiyoShuryoNengetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTekiyoKaishiNengetsu
     * @return txtTekiyoKaishiNengetsu
     */
    @JsonProperty("txtTekiyoKaishiNengetsu")
    public TextBoxDateRange getTxtTekiyoKaishiNengetsu() {
        return txtTekiyoKaishiNengetsu;
    }

    /*
     * settxtTekiyoKaishiNengetsu
     * @param txtTekiyoKaishiNengetsu txtTekiyoKaishiNengetsu
     */
    @JsonProperty("txtTekiyoKaishiNengetsu")
    public void setTxtTekiyoKaishiNengetsu(TextBoxDateRange txtTekiyoKaishiNengetsu) {
        this.txtTekiyoKaishiNengetsu = txtTekiyoKaishiNengetsu;
    }

    /*
     * gettxtTekiyoShuryoNengetsu
     * @return txtTekiyoShuryoNengetsu
     */
    @JsonProperty("txtTekiyoShuryoNengetsu")
    public TextBoxDateRange getTxtTekiyoShuryoNengetsu() {
        return txtTekiyoShuryoNengetsu;
    }

    /*
     * settxtTekiyoShuryoNengetsu
     * @param txtTekiyoShuryoNengetsu txtTekiyoShuryoNengetsu
     */
    @JsonProperty("txtTekiyoShuryoNengetsu")
    public void setTxtTekiyoShuryoNengetsu(TextBoxDateRange txtTekiyoShuryoNengetsu) {
        this.txtTekiyoShuryoNengetsu = txtTekiyoShuryoNengetsu;
    }

    // </editor-fold>
}
