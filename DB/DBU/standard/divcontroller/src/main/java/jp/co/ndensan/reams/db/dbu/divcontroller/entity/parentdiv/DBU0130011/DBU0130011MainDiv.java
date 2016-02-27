package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0130011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DBU0130011Main のクラスファイル 
 * 
 * @author 自動生成
 */
public class DBU0130011MainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("AtenaAreaPanel")
    private AtenaAreaPanelDiv AtenaAreaPanel;
    @JsonProperty("MeisaiPanel")
    private MeisaiPanelDiv MeisaiPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getAtenaAreaPanel
     * @return AtenaAreaPanel
     */
    @JsonProperty("AtenaAreaPanel")
    public AtenaAreaPanelDiv getAtenaAreaPanel() {
        return AtenaAreaPanel;
    }

    /*
     * setAtenaAreaPanel
     * @param AtenaAreaPanel AtenaAreaPanel
     */
    @JsonProperty("AtenaAreaPanel")
    public void setAtenaAreaPanel(AtenaAreaPanelDiv AtenaAreaPanel) {
        this.AtenaAreaPanel = AtenaAreaPanel;
    }

    /*
     * getMeisaiPanel
     * @return MeisaiPanel
     */
    @JsonProperty("MeisaiPanel")
    public MeisaiPanelDiv getMeisaiPanel() {
        return MeisaiPanel;
    }

    /*
     * setMeisaiPanel
     * @param MeisaiPanel MeisaiPanel
     */
    @JsonProperty("MeisaiPanel")
    public void setMeisaiPanel(MeisaiPanelDiv MeisaiPanel) {
        this.MeisaiPanel = MeisaiPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return this.getAtenaAreaPanel().getCcdKaigoAtenaInfo();
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return this.getAtenaAreaPanel().getCcdKaigoShikakuKihon();
    }

    @JsonIgnore
    public TextBoxCode getTxtRokenJukyushaNo() {
        return this.getMeisaiPanel().getTxtRokenJukyushaNo();
    }

    @JsonIgnore
    public void  setTxtRokenJukyushaNo(TextBoxCode txtRokenJukyushaNo) {
        this.getMeisaiPanel().setTxtRokenJukyushaNo(txtRokenJukyushaNo);
    }

    @JsonIgnore
    public TextBox getTxtRoukenShichosonNo() {
        return this.getMeisaiPanel().getTxtRoukenShichosonNo();
    }

    @JsonIgnore
    public void  setTxtRoukenShichosonNo(TextBox txtRoukenShichosonNo) {
        this.getMeisaiPanel().setTxtRoukenShichosonNo(txtRoukenShichosonNo);
    }

    // </editor-fold>
}
