package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IIryohokenRirekiCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryohokenRirekiCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.IRoreiFukushiNenkinShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RoreiFukushiNenkinShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.IShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabInputs のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabInputsDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplShikakuJoho")
    private tplShikakuJohoDiv tplShikakuJoho;
    @JsonProperty("tplIryoHoken")
    private tplIryoHokenDiv tplIryoHoken;
    @JsonProperty("tplRofukuNenkin")
    private tplRofukuNenkinDiv tplRofukuNenkin;
    @JsonProperty("tplShisetsuNyutaisho")
    private tplShisetsuNyutaishoDiv tplShisetsuNyutaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplShikakuJoho
     * @return tplShikakuJoho
     */
    @JsonProperty("tplShikakuJoho")
    public tplShikakuJohoDiv getTplShikakuJoho() {
        return tplShikakuJoho;
    }

    /*
     * settplShikakuJoho
     * @param tplShikakuJoho tplShikakuJoho
     */
    @JsonProperty("tplShikakuJoho")
    public void setTplShikakuJoho(tplShikakuJohoDiv tplShikakuJoho) {
        this.tplShikakuJoho = tplShikakuJoho;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShikakuTokusoRirekiMainDiv getShikakuTokusoRirekiMain() {
        return this.getTplShikakuJoho().getShikakuTokusoRirekiMain();
    }

    @JsonIgnore
    public void  setShikakuTokusoRirekiMain(ShikakuTokusoRirekiMainDiv ShikakuTokusoRirekiMain) {
        this.getTplShikakuJoho().setShikakuTokusoRirekiMain(ShikakuTokusoRirekiMain);
    }

    @JsonIgnore
    public IryoHokenRirekiMainDiv getIryoHokenRirekiMain() {
        return this.getTplIryoHoken().getIryoHokenRirekiMain();
    }

    @JsonIgnore
    public void  setIryoHokenRirekiMain(IryoHokenRirekiMainDiv IryoHokenRirekiMain) {
        this.getTplIryoHoken().setIryoHokenRirekiMain(IryoHokenRirekiMain);
    }

    @JsonIgnore
    public IIryohokenRirekiCommonChildDiv getCcdIryoHokenRireki() {
        return this.getTplIryoHoken().getIryoHokenRirekiMain().getCcdIryoHokenRireki();
    }

    @JsonIgnore
    public RohukuNenkinDiv getRohukuNenkin() {
        return this.getTplRofukuNenkin().getRohukuNenkin();
    }

    @JsonIgnore
    public void  setRohukuNenkin(RohukuNenkinDiv RohukuNenkin) {
        this.getTplRofukuNenkin().setRohukuNenkin(RohukuNenkin);
    }

    @JsonIgnore
    public IRoreiFukushiNenkinShokaiDiv getCcdRohukuNenkin() {
        return this.getTplRofukuNenkin().getRohukuNenkin().getCcdRohukuNenkin();
    }

    @JsonIgnore
    public ShisetsuNyutaishoRirekiDiv getShisetsuNyutaishoRireki() {
        return this.getTplShisetsuNyutaisho().getShisetsuNyutaishoRireki();
    }

    @JsonIgnore
    public void  setShisetsuNyutaishoRireki(ShisetsuNyutaishoRirekiDiv ShisetsuNyutaishoRireki) {
        this.getTplShisetsuNyutaisho().setShisetsuNyutaishoRireki(ShisetsuNyutaishoRireki);
    }

    @JsonIgnore
    public IShisetsuNyutaishoRirekiKanriDiv getCcdShisetsuNyutaishoRirekiKanri() {
        return this.getTplShisetsuNyutaisho().getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri();
    }

    // </editor-fold>
}
