package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoGemmenGengakuSub のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoGemmenGengakuSubDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("GemmenGengakuRightPanel")
    private GemmenGengakuRightPanelDiv GemmenGengakuRightPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getGemmenGengakuRightPanel
     * @return GemmenGengakuRightPanel
     */
    @JsonProperty("GemmenGengakuRightPanel")
    public GemmenGengakuRightPanelDiv getGemmenGengakuRightPanel() {
        return GemmenGengakuRightPanel;
    }

    /*
     * setGemmenGengakuRightPanel
     * @param GemmenGengakuRightPanel GemmenGengakuRightPanel
     */
    @JsonProperty("GemmenGengakuRightPanel")
    public void setGemmenGengakuRightPanel(GemmenGengakuRightPanelDiv GemmenGengakuRightPanel) {
        this.GemmenGengakuRightPanel = GemmenGengakuRightPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public JukyushaIdoRenrakuhyoRiyoshaFutanDiv getJukyushaIdoRenrakuhyoRiyoshaFutan() {
        return this.getGemmenGengakuRightPanel().getJukyushaIdoRenrakuhyoRiyoshaFutan();
    }

    @JsonIgnore
    public void  setJukyushaIdoRenrakuhyoRiyoshaFutan(JukyushaIdoRenrakuhyoRiyoshaFutanDiv JukyushaIdoRenrakuhyoRiyoshaFutan) {
        this.getGemmenGengakuRightPanel().setJukyushaIdoRenrakuhyoRiyoshaFutan(JukyushaIdoRenrakuhyoRiyoshaFutan);
    }

    @JsonIgnore
    public JukyushaIdoRenrakuhyoFukushiHojinKeigenDiv getJukyushaIdoRenrakuhyoFukushiHojinKeigen() {
        return this.getGemmenGengakuRightPanel().getJukyushaIdoRenrakuhyoFukushiHojinKeigen();
    }

    @JsonIgnore
    public void  setJukyushaIdoRenrakuhyoFukushiHojinKeigen(JukyushaIdoRenrakuhyoFukushiHojinKeigenDiv JukyushaIdoRenrakuhyoFukushiHojinKeigen) {
        this.getGemmenGengakuRightPanel().setJukyushaIdoRenrakuhyoFukushiHojinKeigen(JukyushaIdoRenrakuhyoFukushiHojinKeigen);
    }

    @JsonIgnore
    public JukyushaIdoRenrakuhyoHyojunFutanDiv getJukyushaIdoRenrakuhyoHyojunFutan() {
        return this.getGemmenGengakuRightPanel().getJukyushaIdoRenrakuhyoHyojunFutan();
    }

    @JsonIgnore
    public void  setJukyushaIdoRenrakuhyoHyojunFutan(JukyushaIdoRenrakuhyoHyojunFutanDiv JukyushaIdoRenrakuhyoHyojunFutan) {
        this.getGemmenGengakuRightPanel().setJukyushaIdoRenrakuhyoHyojunFutan(JukyushaIdoRenrakuhyoHyojunFutan);
    }

    // </editor-fold>
}
