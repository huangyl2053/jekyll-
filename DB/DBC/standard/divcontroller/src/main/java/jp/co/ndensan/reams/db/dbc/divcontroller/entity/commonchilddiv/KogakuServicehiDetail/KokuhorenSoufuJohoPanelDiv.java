package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KokuhorenSoufuJohoPanel のクラスファイル
 *
 * @reamsid_L DBC-4380-010 quxiaodong
 */
public class KokuhorenSoufuJohoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTaisyoUketoriYM")
    private TextBoxDate txtTaisyoUketoriYM;
    @JsonProperty("txtKekkaSoufuYM")
    private TextBoxDate txtKekkaSoufuYM;
    @JsonProperty("txtKetteiSyaUketoriYM")
    private TextBoxDate txtKetteiSyaUketoriYM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTaisyoUketoriYM
     * @return txtTaisyoUketoriYM
     */
    @JsonProperty("txtTaisyoUketoriYM")
    public TextBoxDate getTxtTaisyoUketoriYM() {
        return txtTaisyoUketoriYM;
    }

    /*
     * settxtTaisyoUketoriYM
     * @param txtTaisyoUketoriYM txtTaisyoUketoriYM
     */
    @JsonProperty("txtTaisyoUketoriYM")
    public void setTxtTaisyoUketoriYM(TextBoxDate txtTaisyoUketoriYM) {
        this.txtTaisyoUketoriYM = txtTaisyoUketoriYM;
    }

    /*
     * gettxtKekkaSoufuYM
     * @return txtKekkaSoufuYM
     */
    @JsonProperty("txtKekkaSoufuYM")
    public TextBoxDate getTxtKekkaSoufuYM() {
        return txtKekkaSoufuYM;
    }

    /*
     * settxtKekkaSoufuYM
     * @param txtKekkaSoufuYM txtKekkaSoufuYM
     */
    @JsonProperty("txtKekkaSoufuYM")
    public void setTxtKekkaSoufuYM(TextBoxDate txtKekkaSoufuYM) {
        this.txtKekkaSoufuYM = txtKekkaSoufuYM;
    }

    /*
     * gettxtKetteiSyaUketoriYM
     * @return txtKetteiSyaUketoriYM
     */
    @JsonProperty("txtKetteiSyaUketoriYM")
    public TextBoxDate getTxtKetteiSyaUketoriYM() {
        return txtKetteiSyaUketoriYM;
    }

    /*
     * settxtKetteiSyaUketoriYM
     * @param txtKetteiSyaUketoriYM txtKetteiSyaUketoriYM
     */
    @JsonProperty("txtKetteiSyaUketoriYM")
    public void setTxtKetteiSyaUketoriYM(TextBoxDate txtKetteiSyaUketoriYM) {
        this.txtKetteiSyaUketoriYM = txtKetteiSyaUketoriYM;
    }

    // </editor-fold>
}
