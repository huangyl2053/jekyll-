package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.IShoKaishuKirokuKanriDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.ShoKaishuKirokuKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IIryohokenRirekiCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryohokenRirekiCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.IRoreiFukushiNenkinShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RoreiFukushiNenkinShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.ISetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.IShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.ShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.IShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaShokaiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaShokaiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabHihokenshaShokai")
    private tabHihokenshaShokaiDiv tabHihokenshaShokai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabHihokenshaShokai
     * @return tabHihokenshaShokai
     */
    @JsonProperty("tabHihokenshaShokai")
    public tabHihokenshaShokaiDiv getTabHihokenshaShokai() {
        return tabHihokenshaShokai;
    }

    /*
     * settabHihokenshaShokai
     * @param tabHihokenshaShokai tabHihokenshaShokai
     */
    @JsonProperty("tabHihokenshaShokai")
    public void setTabHihokenshaShokai(tabHihokenshaShokaiDiv tabHihokenshaShokai) {
        this.tabHihokenshaShokai = tabHihokenshaShokai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplHihokenshaRirekiDiv getTplHihokenshaRireki() {
        return this.getTabHihokenshaShokai().getTplHihokenshaRireki();
    }

    @JsonIgnore
    public void  setTplHihokenshaRireki(tplHihokenshaRirekiDiv tplHihokenshaRireki) {
        this.getTabHihokenshaShokai().setTplHihokenshaRireki(tplHihokenshaRireki);
    }

    @JsonIgnore
    public IShikakuTokusoRirekiDiv getCcdShisetsuTokusoRireki() {
        return this.getTabHihokenshaShokai().getTplHihokenshaRireki().getCcdShisetsuTokusoRireki();
    }

    @JsonIgnore
    public tplSetaiShokaiDiv getTplSetaiShokai() {
        return this.getTabHihokenshaShokai().getTplSetaiShokai();
    }

    @JsonIgnore
    public void  setTplSetaiShokai(tplSetaiShokaiDiv tplSetaiShokai) {
        this.getTabHihokenshaShokai().setTplSetaiShokai(tplSetaiShokai);
    }

    @JsonIgnore
    public ISetaiShotokuIchiranDiv getCcdSeitaiIchiran() {
        return this.getTabHihokenshaShokai().getTplSetaiShokai().getCcdSeitaiIchiran();
    }

    @JsonIgnore
    public tplIryoHokenDiv getTplIryoHoken() {
        return this.getTabHihokenshaShokai().getTplIryoHoken();
    }

    @JsonIgnore
    public void  setTplIryoHoken(tplIryoHokenDiv tplIryoHoken) {
        this.getTabHihokenshaShokai().setTplIryoHoken(tplIryoHoken);
    }

    @JsonIgnore
    public IIryohokenRirekiCommonChildDiv getCcdIryoHokenRireki() {
        return this.getTabHihokenshaShokai().getTplIryoHoken().getCcdIryoHokenRireki();
    }

    @JsonIgnore
    public tplRofukuNenkinDiv getTplRofukuNenkin() {
        return this.getTabHihokenshaShokai().getTplRofukuNenkin();
    }

    @JsonIgnore
    public void  setTplRofukuNenkin(tplRofukuNenkinDiv tplRofukuNenkin) {
        this.getTabHihokenshaShokai().setTplRofukuNenkin(tplRofukuNenkin);
    }

    @JsonIgnore
    public IRoreiFukushiNenkinShokaiDiv getCcdRoreiFukushiNenkinShokai() {
        return this.getTabHihokenshaShokai().getTplRofukuNenkin().getCcdRoreiFukushiNenkinShokai();
    }

    @JsonIgnore
    public tplShisetsuNyutaishoDiv getTplShisetsuNyutaisho() {
        return this.getTabHihokenshaShokai().getTplShisetsuNyutaisho();
    }

    @JsonIgnore
    public void  setTplShisetsuNyutaisho(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho) {
        this.getTabHihokenshaShokai().setTplShisetsuNyutaisho(tplShisetsuNyutaisho);
    }

    @JsonIgnore
    public IShisetsuNyutaishoRirekiKanriDiv getCcdShisetsuNyutaishoRireki() {
        return this.getTabHihokenshaShokai().getTplShisetsuNyutaisho().getCcdShisetsuNyutaishoRireki();
    }

    @JsonIgnore
    public tplShoKofuKaishuDiv getTplShoKofuKaishu() {
        return this.getTabHihokenshaShokai().getTplShoKofuKaishu();
    }

    @JsonIgnore
    public void  setTplShoKofuKaishu(tplShoKofuKaishuDiv tplShoKofuKaishu) {
        this.getTabHihokenshaShokai().setTplShoKofuKaishu(tplShoKofuKaishu);
    }

    @JsonIgnore
    public IShoKaishuKirokuKanriDiv getCcdShoKaishuJokyoList() {
        return this.getTabHihokenshaShokai().getTplShoKofuKaishu().getCcdShoKaishuJokyoList();
    }

    // </editor-fold>
}
