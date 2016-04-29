package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JigyoshaShisetsuKanri のクラスファイル
 *
 */
public class JigyoshaShisetsuKanriDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JigyoshaShurui")
    private JigyoshaShuruiDiv JigyoshaShurui;
    @JsonProperty("JigyoshaNyuryokuGuide")
    private JigyoshaNyuryokuGuideDiv JigyoshaNyuryokuGuide;
    @JsonProperty("jigyoshaMode")
    private RString jigyoshaMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJigyoshaShurui
     * @return JigyoshaShurui
     */
    @JsonProperty("JigyoshaShurui")
    public JigyoshaShuruiDiv getJigyoshaShurui() {
        return JigyoshaShurui;
    }

    /*
     * setJigyoshaShurui
     * @param JigyoshaShurui JigyoshaShurui
     */
    @JsonProperty("JigyoshaShurui")
    public void setJigyoshaShurui(JigyoshaShuruiDiv JigyoshaShurui) {
        this.JigyoshaShurui = JigyoshaShurui;
    }

    /*
     * getJigyoshaNyuryokuGuide
     * @return JigyoshaNyuryokuGuide
     */
    @JsonProperty("JigyoshaNyuryokuGuide")
    public JigyoshaNyuryokuGuideDiv getJigyoshaNyuryokuGuide() {
        return JigyoshaNyuryokuGuide;
    }

    /*
     * setJigyoshaNyuryokuGuide
     * @param JigyoshaNyuryokuGuide JigyoshaNyuryokuGuide
     */
    @JsonProperty("JigyoshaNyuryokuGuide")
    public void setJigyoshaNyuryokuGuide(JigyoshaNyuryokuGuideDiv JigyoshaNyuryokuGuide) {
        this.JigyoshaNyuryokuGuide = JigyoshaNyuryokuGuide;
    }

    /*
     * getjigyoshaMode
     * @return jigyoshaMode
     */
    @JsonProperty("jigyoshaMode")
    public RString getJigyoshaMode() {
        return jigyoshaMode;
    }

    /*
     * setjigyoshaMode
     * @param jigyoshaMode jigyoshaMode
     */
    @JsonProperty("jigyoshaMode")
    public void setJigyoshaMode(RString jigyoshaMode) {
        this.jigyoshaMode = jigyoshaMode;
    }

    // </editor-fold>
}
