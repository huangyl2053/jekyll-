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
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabHihokenshaShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabHihokenshaShokaiDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplHihokenshaRireki")
    private tplHihokenshaRirekiDiv tplHihokenshaRireki;
    @JsonProperty("tplSetaiShokai")
    private tplSetaiShokaiDiv tplSetaiShokai;
    @JsonProperty("tplIryoHoken")
    private tplIryoHokenDiv tplIryoHoken;
    @JsonProperty("tplRofukuNenkin")
    private tplRofukuNenkinDiv tplRofukuNenkin;
    @JsonProperty("tplShisetsuNyutaisho")
    private tplShisetsuNyutaishoDiv tplShisetsuNyutaisho;
    @JsonProperty("tplShoKofuKaishu")
    private tplShoKofuKaishuDiv tplShoKofuKaishu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplHihokenshaRireki
     * @return tplHihokenshaRireki
     */
    @JsonProperty("tplHihokenshaRireki")
    public tplHihokenshaRirekiDiv getTplHihokenshaRireki() {
        return tplHihokenshaRireki;
    }

    /*
     * settplHihokenshaRireki
     * @param tplHihokenshaRireki tplHihokenshaRireki
     */
    @JsonProperty("tplHihokenshaRireki")
    public void setTplHihokenshaRireki(tplHihokenshaRirekiDiv tplHihokenshaRireki) {
        this.tplHihokenshaRireki = tplHihokenshaRireki;
    }

    /*
     * gettplSetaiShokai
     * @return tplSetaiShokai
     */
    @JsonProperty("tplSetaiShokai")
    public tplSetaiShokaiDiv getTplSetaiShokai() {
        return tplSetaiShokai;
    }

    /*
     * settplSetaiShokai
     * @param tplSetaiShokai tplSetaiShokai
     */
    @JsonProperty("tplSetaiShokai")
    public void setTplSetaiShokai(tplSetaiShokaiDiv tplSetaiShokai) {
        this.tplSetaiShokai = tplSetaiShokai;
    }

    /*
     * gettplIryoHoken
     * @return tplIryoHoken
     */
    @JsonProperty("tplIryoHoken")
    public tplIryoHokenDiv getTplIryoHoken() {
        return tplIryoHoken;
    }

    /*
     * settplIryoHoken
     * @param tplIryoHoken tplIryoHoken
     */
    @JsonProperty("tplIryoHoken")
    public void setTplIryoHoken(tplIryoHokenDiv tplIryoHoken) {
        this.tplIryoHoken = tplIryoHoken;
    }

    /*
     * gettplRofukuNenkin
     * @return tplRofukuNenkin
     */
    @JsonProperty("tplRofukuNenkin")
    public tplRofukuNenkinDiv getTplRofukuNenkin() {
        return tplRofukuNenkin;
    }

    /*
     * settplRofukuNenkin
     * @param tplRofukuNenkin tplRofukuNenkin
     */
    @JsonProperty("tplRofukuNenkin")
    public void setTplRofukuNenkin(tplRofukuNenkinDiv tplRofukuNenkin) {
        this.tplRofukuNenkin = tplRofukuNenkin;
    }

    /*
     * gettplShisetsuNyutaisho
     * @return tplShisetsuNyutaisho
     */
    @JsonProperty("tplShisetsuNyutaisho")
    public tplShisetsuNyutaishoDiv getTplShisetsuNyutaisho() {
        return tplShisetsuNyutaisho;
    }

    /*
     * settplShisetsuNyutaisho
     * @param tplShisetsuNyutaisho tplShisetsuNyutaisho
     */
    @JsonProperty("tplShisetsuNyutaisho")
    public void setTplShisetsuNyutaisho(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho) {
        this.tplShisetsuNyutaisho = tplShisetsuNyutaisho;
    }

    /*
     * gettplShoKofuKaishu
     * @return tplShoKofuKaishu
     */
    @JsonProperty("tplShoKofuKaishu")
    public tplShoKofuKaishuDiv getTplShoKofuKaishu() {
        return tplShoKofuKaishu;
    }

    /*
     * settplShoKofuKaishu
     * @param tplShoKofuKaishu tplShoKofuKaishu
     */
    @JsonProperty("tplShoKofuKaishu")
    public void setTplShoKofuKaishu(tplShoKofuKaishuDiv tplShoKofuKaishu) {
        this.tplShoKofuKaishu = tplShoKofuKaishu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IShikakuTokusoRirekiDiv getCcdShisetsuTokusoRireki() {
        return this.getTplHihokenshaRireki().getCcdShisetsuTokusoRireki();
    }

    @JsonIgnore
    public ISetaiShotokuIchiranDiv getCcdSeitaiIchiran() {
        return this.getTplSetaiShokai().getCcdSeitaiIchiran();
    }

    @JsonIgnore
    public IIryohokenRirekiCommonChildDiv getCcdIryoHokenRireki() {
        return this.getTplIryoHoken().getCcdIryoHokenRireki();
    }

    @JsonIgnore
    public IRoreiFukushiNenkinShokaiDiv getCcdRoreiFukushiNenkinShokai() {
        return this.getTplRofukuNenkin().getCcdRoreiFukushiNenkinShokai();
    }

    @JsonIgnore
    public IShisetsuNyutaishoRirekiKanriDiv getCcdShisetsuNyutaishoRireki() {
        return this.getTplShisetsuNyutaisho().getCcdShisetsuNyutaishoRireki();
    }

    @JsonIgnore
    public IShoKaishuKirokuKanriDiv getCcdShoKaishuJokyoList() {
        return this.getTplShoKofuKaishu().getCcdShoKaishuJokyoList();
    }

    // </editor-fold>
}
