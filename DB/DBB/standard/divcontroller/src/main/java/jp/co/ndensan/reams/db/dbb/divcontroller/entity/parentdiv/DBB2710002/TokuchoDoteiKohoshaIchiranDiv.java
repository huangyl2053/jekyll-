package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * TokuchoDoteiKohoshaIchiran のクラスファイル <br/>
 *
 * 画面設計_DBBGM81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-010 yangchenbing
 */
public class TokuchoDoteiKohoshaIchiranDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTokuchoDoteiKohoshaIchiran")
    private DataGrid<dgTokuchoDoteiKohoshaIchiran_Row> dgTokuchoDoteiKohoshaIchiran;
    @JsonProperty("NenkinTokuchoKaifuInfo")
    private NenkinTokuchoKaifuInfoDiv NenkinTokuchoKaifuInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTokuchoDoteiKohoshaIchiran
     * @return dgTokuchoDoteiKohoshaIchiran
     */
    @JsonProperty("dgTokuchoDoteiKohoshaIchiran")
    public DataGrid<dgTokuchoDoteiKohoshaIchiran_Row> getDgTokuchoDoteiKohoshaIchiran() {
        return dgTokuchoDoteiKohoshaIchiran;
    }

    /*
     * setdgTokuchoDoteiKohoshaIchiran
     * @param dgTokuchoDoteiKohoshaIchiran dgTokuchoDoteiKohoshaIchiran
     */
    @JsonProperty("dgTokuchoDoteiKohoshaIchiran")
    public void setDgTokuchoDoteiKohoshaIchiran(DataGrid<dgTokuchoDoteiKohoshaIchiran_Row> dgTokuchoDoteiKohoshaIchiran) {
        this.dgTokuchoDoteiKohoshaIchiran = dgTokuchoDoteiKohoshaIchiran;
    }

    /*
     * getNenkinTokuchoKaifuInfo
     * @return NenkinTokuchoKaifuInfo
     */
    @JsonProperty("NenkinTokuchoKaifuInfo")
    public NenkinTokuchoKaifuInfoDiv getNenkinTokuchoKaifuInfo() {
        return NenkinTokuchoKaifuInfo;
    }

    /*
     * setNenkinTokuchoKaifuInfo
     * @param NenkinTokuchoKaifuInfo NenkinTokuchoKaifuInfo
     */
    @JsonProperty("NenkinTokuchoKaifuInfo")
    public void setNenkinTokuchoKaifuInfo(NenkinTokuchoKaifuInfoDiv NenkinTokuchoKaifuInfo) {
        this.NenkinTokuchoKaifuInfo = NenkinTokuchoKaifuInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtKisoNenkinNo() {
        return this.getNenkinTokuchoKaifuInfo().getTxtKisoNenkinNo();
    }

    @JsonIgnore
    public void setTxtKisoNenkinNo(TextBox txtKisoNenkinNo) {
        this.getNenkinTokuchoKaifuInfo().setTxtKisoNenkinNo(txtKisoNenkinNo);
    }

    @JsonIgnore
    public TextBox getTxtNenkinCode() {
        return this.getNenkinTokuchoKaifuInfo().getTxtNenkinCode();
    }

    @JsonIgnore
    public void setTxtNenkinCode(TextBox txtNenkinCode) {
        this.getNenkinTokuchoKaifuInfo().setTxtNenkinCode(txtNenkinCode);
    }

    @JsonIgnore
    public TextBox getTxtTokuchoGimusha() {
        return this.getNenkinTokuchoKaifuInfo().getTxtTokuchoGimusha();
    }

    @JsonIgnore
    public void setTxtTokuchoGimusha(TextBox txtTokuchoGimusha) {
        this.getNenkinTokuchoKaifuInfo().setTxtTokuchoGimusha(txtTokuchoGimusha);
    }

    @JsonIgnore
    public TextBox getTxtShimeiKana() {
        return this.getNenkinTokuchoKaifuInfo().getTxtShimeiKana();
    }

    @JsonIgnore
    public void setTxtShimeiKana(TextBox txtShimeiKana) {
        this.getNenkinTokuchoKaifuInfo().setTxtShimeiKana(txtShimeiKana);
    }

    @JsonIgnore
    public TextBoxDate getTxtUmareYMD() {
        return this.getNenkinTokuchoKaifuInfo().getTxtUmareYMD();
    }

    @JsonIgnore
    public void setTxtUmareYMD(TextBoxDate txtUmareYMD) {
        this.getNenkinTokuchoKaifuInfo().setTxtUmareYMD(txtUmareYMD);
    }

    @JsonIgnore
    public TextBox getTxtShimeiKanji() {
        return this.getNenkinTokuchoKaifuInfo().getTxtShimeiKanji();
    }

    @JsonIgnore
    public void setTxtShimeiKanji(TextBox txtShimeiKanji) {
        this.getNenkinTokuchoKaifuInfo().setTxtShimeiKanji(txtShimeiKanji);
    }

    @JsonIgnore
    public TextBox getTxtSebetsu() {
        return this.getNenkinTokuchoKaifuInfo().getTxtSebetsu();
    }

    @JsonIgnore
    public void setTxtSebetsu(TextBox txtSebetsu) {
        this.getNenkinTokuchoKaifuInfo().setTxtSebetsu(txtSebetsu);
    }

    @JsonIgnore
    public TextBox getTxtJushoKana() {
        return this.getNenkinTokuchoKaifuInfo().getTxtJushoKana();
    }

    @JsonIgnore
    public void setTxtJushoKana(TextBox txtJushoKana) {
        this.getNenkinTokuchoKaifuInfo().setTxtJushoKana(txtJushoKana);
    }

    @JsonIgnore
    public TextBox getTxtJushoKanji() {
        return this.getNenkinTokuchoKaifuInfo().getTxtJushoKanji();
    }

    @JsonIgnore
    public void setTxtJushoKanji(TextBox txtJushoKanji) {
        this.getNenkinTokuchoKaifuInfo().setTxtJushoKanji(txtJushoKanji);
    }

    // </editor-fold>
}
