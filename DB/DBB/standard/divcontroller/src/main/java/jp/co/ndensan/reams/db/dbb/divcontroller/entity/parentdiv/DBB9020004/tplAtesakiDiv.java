package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigochohyoseigyokyotsu.KaigoChohyoSeigyoKyotsu.IKaigoChohyoSeigyoKyotsuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigochohyoseigyokyotsu.KaigoChohyoSeigyoKyotsu.KaigoChohyoSeigyoKyotsuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * tplAtesaki のクラスファイル
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class tplAtesakiDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NonyuTsuchishoInfo")
    private NonyuTsuchishoInfoDiv NonyuTsuchishoInfo;
    @JsonProperty("ccdKaigoChohyoSeigyoKyotsu")
    private KaigoChohyoSeigyoKyotsuDiv ccdKaigoChohyoSeigyoKyotsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNonyuTsuchishoInfo
     * @return NonyuTsuchishoInfo
     */
    @JsonProperty("NonyuTsuchishoInfo")
    public NonyuTsuchishoInfoDiv getNonyuTsuchishoInfo() {
        return NonyuTsuchishoInfo;
    }

    /*
     * setNonyuTsuchishoInfo
     * @param NonyuTsuchishoInfo NonyuTsuchishoInfo
     */
    @JsonProperty("NonyuTsuchishoInfo")
    public void setNonyuTsuchishoInfo(NonyuTsuchishoInfoDiv NonyuTsuchishoInfo) {
        this.NonyuTsuchishoInfo = NonyuTsuchishoInfo;
    }

    /*
     * getccdKaigoChohyoSeigyoKyotsu
     * @return ccdKaigoChohyoSeigyoKyotsu
     */
    @JsonProperty("ccdKaigoChohyoSeigyoKyotsu")
    public IKaigoChohyoSeigyoKyotsuDiv getCcdKaigoChohyoSeigyoKyotsu() {
        return ccdKaigoChohyoSeigyoKyotsu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtHakkoBusu() {
        return this.getNonyuTsuchishoInfo().getTxtHakkoBusu();
    }

    @JsonIgnore
    public void setTxtHakkoBusu(TextBox txtHakkoBusu) {
        this.getNonyuTsuchishoInfo().setTxtHakkoBusu(txtHakkoBusu);
    }

    @JsonIgnore
    public RadioButton getRadSokuhoTorikomiKubun() {
        return this.getNonyuTsuchishoInfo().getRadSokuhoTorikomiKubun();
    }

    @JsonIgnore
    public void setRadSokuhoTorikomiKubun(RadioButton radSokuhoTorikomiKubun) {
        this.getNonyuTsuchishoInfo().setRadSokuhoTorikomiKubun(radSokuhoTorikomiKubun);
    }

    @JsonIgnore
    public TanpyoHakkoShokiDiv getTanpyoHakkoShoki() {
        return this.getNonyuTsuchishoInfo().getTanpyoHakkoShoki();
    }

    @JsonIgnore
    public void setTanpyoHakkoShoki(TanpyoHakkoShokiDiv TanpyoHakkoShoki) {
        this.getNonyuTsuchishoInfo().setTanpyoHakkoShoki(TanpyoHakkoShoki);
    }

    @JsonIgnore
    public RadioButton getRadSokujiHakkoHoshiki() {
        return this.getNonyuTsuchishoInfo().getTanpyoHakkoShoki().getRadSokujiHakkoHoshiki();
    }

    @JsonIgnore
    public void setRadSokujiHakkoHoshiki(RadioButton radSokujiHakkoHoshiki) {
        this.getNonyuTsuchishoInfo().getTanpyoHakkoShoki().setRadSokujiHakkoHoshiki(radSokujiHakkoHoshiki);
    }

    @JsonIgnore
    public RadioButton getRadSokujiHakkoKeishiki() {
        return this.getNonyuTsuchishoInfo().getTanpyoHakkoShoki().getRadSokujiHakkoKeishiki();
    }

    @JsonIgnore
    public void setRadSokujiHakkoKeishiki(RadioButton radSokujiHakkoKeishiki) {
        this.getNonyuTsuchishoInfo().getTanpyoHakkoShoki().setRadSokujiHakkoKeishiki(radSokujiHakkoKeishiki);
    }

    // </editor-fold>
}
