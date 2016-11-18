package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
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
 * GemmenGengakuPanel のクラスファイル
 *
 * @reamsid_L DBC-4350-060 chenhui
 */
public class GemmenGengakuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnGemmenGengakuRireki")
    private ButtonDialog btnGemmenGengakuRireki;
    @JsonProperty("JukyushaIdoRenrakuhyoGemmenGengakuSub")
    private JukyushaIdoRenrakuhyoGemmenGengakuSubDiv JukyushaIdoRenrakuhyoGemmenGengakuSub;
    @JsonProperty("JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi")
    private JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHiDiv JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnGemmenGengakuRireki
     * @return btnGemmenGengakuRireki
     */
    @JsonProperty("btnGemmenGengakuRireki")
    public ButtonDialog getBtnGemmenGengakuRireki() {
        return btnGemmenGengakuRireki;
    }

    /*
     * setbtnGemmenGengakuRireki
     * @param btnGemmenGengakuRireki btnGemmenGengakuRireki
     */
    @JsonProperty("btnGemmenGengakuRireki")
    public void setBtnGemmenGengakuRireki(ButtonDialog btnGemmenGengakuRireki) {
        this.btnGemmenGengakuRireki = btnGemmenGengakuRireki;
    }

    /*
     * getJukyushaIdoRenrakuhyoGemmenGengakuSub
     * @return JukyushaIdoRenrakuhyoGemmenGengakuSub
     */
    @JsonProperty("JukyushaIdoRenrakuhyoGemmenGengakuSub")
    public JukyushaIdoRenrakuhyoGemmenGengakuSubDiv getJukyushaIdoRenrakuhyoGemmenGengakuSub() {
        return JukyushaIdoRenrakuhyoGemmenGengakuSub;
    }

    /*
     * setJukyushaIdoRenrakuhyoGemmenGengakuSub
     * @param JukyushaIdoRenrakuhyoGemmenGengakuSub JukyushaIdoRenrakuhyoGemmenGengakuSub
     */
    @JsonProperty("JukyushaIdoRenrakuhyoGemmenGengakuSub")
    public void setJukyushaIdoRenrakuhyoGemmenGengakuSub(JukyushaIdoRenrakuhyoGemmenGengakuSubDiv JukyushaIdoRenrakuhyoGemmenGengakuSub) {
        this.JukyushaIdoRenrakuhyoGemmenGengakuSub = JukyushaIdoRenrakuhyoGemmenGengakuSub;
    }

    /*
     * getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi
     * @return JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi
     */
    @JsonProperty("JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi")
    public JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHiDiv getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi() {
        return JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi;
    }

    /*
     * setJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi
     * @param JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi
     */
    @JsonProperty("JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi")
    public void setJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi(JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHiDiv JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi) {
        this.JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi = JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public JukyushaIdoRenrakuhyoRiyoshaFutanDiv getJukyushaIdoRenrakuhyoRiyoshaFutan() {
        return this.getJukyushaIdoRenrakuhyoGemmenGengakuSub().getGemmenGengakuRightPanel().getJukyushaIdoRenrakuhyoRiyoshaFutan();
    }

    @JsonIgnore
    public void  setJukyushaIdoRenrakuhyoRiyoshaFutan(JukyushaIdoRenrakuhyoRiyoshaFutanDiv JukyushaIdoRenrakuhyoRiyoshaFutan) {
        this.getJukyushaIdoRenrakuhyoGemmenGengakuSub().getGemmenGengakuRightPanel().setJukyushaIdoRenrakuhyoRiyoshaFutan(JukyushaIdoRenrakuhyoRiyoshaFutan);
    }

    @JsonIgnore
    public JukyushaIdoRenrakuhyoFukushiHojinKeigenDiv getJukyushaIdoRenrakuhyoFukushiHojinKeigen() {
        return this.getJukyushaIdoRenrakuhyoGemmenGengakuSub().getGemmenGengakuRightPanel().getJukyushaIdoRenrakuhyoFukushiHojinKeigen();
    }

    @JsonIgnore
    public void  setJukyushaIdoRenrakuhyoFukushiHojinKeigen(JukyushaIdoRenrakuhyoFukushiHojinKeigenDiv JukyushaIdoRenrakuhyoFukushiHojinKeigen) {
        this.getJukyushaIdoRenrakuhyoGemmenGengakuSub().getGemmenGengakuRightPanel().setJukyushaIdoRenrakuhyoFukushiHojinKeigen(JukyushaIdoRenrakuhyoFukushiHojinKeigen);
    }

    @JsonIgnore
    public JukyushaIdoRenrakuhyoHyojunFutanDiv getJukyushaIdoRenrakuhyoHyojunFutan() {
        return this.getJukyushaIdoRenrakuhyoGemmenGengakuSub().getGemmenGengakuRightPanel().getJukyushaIdoRenrakuhyoHyojunFutan();
    }

    @JsonIgnore
    public void  setJukyushaIdoRenrakuhyoHyojunFutan(JukyushaIdoRenrakuhyoHyojunFutanDiv JukyushaIdoRenrakuhyoHyojunFutan) {
        this.getJukyushaIdoRenrakuhyoGemmenGengakuSub().getGemmenGengakuRightPanel().setJukyushaIdoRenrakuhyoHyojunFutan(JukyushaIdoRenrakuhyoHyojunFutan);
    }

    // </editor-fold>
}
