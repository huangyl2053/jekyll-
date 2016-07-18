package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SakuseiPanel のクラスファイル
 *
 * @reamsid_L DBC-4380-010 quxiaodong
 */
public class SakuseiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KokuhorenKetteiJohoPanel2")
    private KokuhorenKetteiJohoPanel2Div KokuhorenKetteiJohoPanel2;
    @JsonProperty("FurikomiMeisaiJohoPanel")
    private FurikomiMeisaiJohoPanelDiv FurikomiMeisaiJohoPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKokuhorenKetteiJohoPanel2
     * @return KokuhorenKetteiJohoPanel2
     */
    @JsonProperty("KokuhorenKetteiJohoPanel2")
    public KokuhorenKetteiJohoPanel2Div getKokuhorenKetteiJohoPanel2() {
        return KokuhorenKetteiJohoPanel2;
    }

    /*
     * setKokuhorenKetteiJohoPanel2
     * @param KokuhorenKetteiJohoPanel2 KokuhorenKetteiJohoPanel2
     */
    @JsonProperty("KokuhorenKetteiJohoPanel2")
    public void setKokuhorenKetteiJohoPanel2(KokuhorenKetteiJohoPanel2Div KokuhorenKetteiJohoPanel2) {
        this.KokuhorenKetteiJohoPanel2 = KokuhorenKetteiJohoPanel2;
    }

    /*
     * getFurikomiMeisaiJohoPanel
     * @return FurikomiMeisaiJohoPanel
     */
    @JsonProperty("FurikomiMeisaiJohoPanel")
    public FurikomiMeisaiJohoPanelDiv getFurikomiMeisaiJohoPanel() {
        return FurikomiMeisaiJohoPanel;
    }

    /*
     * setFurikomiMeisaiJohoPanel
     * @param FurikomiMeisaiJohoPanel FurikomiMeisaiJohoPanel
     */
    @JsonProperty("FurikomiMeisaiJohoPanel")
    public void setFurikomiMeisaiJohoPanel(FurikomiMeisaiJohoPanelDiv FurikomiMeisaiJohoPanel) {
        this.FurikomiMeisaiJohoPanel = FurikomiMeisaiJohoPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD1() {
        return this.getKokuhorenKetteiJohoPanel2().getTxtSakuseiYMD1();
    }

    @JsonIgnore
    public void  setTxtSakuseiYMD1(TextBoxDate txtSakuseiYMD1) {
        this.getKokuhorenKetteiJohoPanel2().setTxtSakuseiYMD1(txtSakuseiYMD1);
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiYMD2() {
        return this.getFurikomiMeisaiJohoPanel().getTxtSakuseiYMD2();
    }

    @JsonIgnore
    public void  setTxtSakuseiYMD2(TextBoxDate txtSakuseiYMD2) {
        this.getFurikomiMeisaiJohoPanel().setTxtSakuseiYMD2(txtSakuseiYMD2);
    }

    // </editor-fold>
}
