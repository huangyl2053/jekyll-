package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.dgSetaiJoho_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.dgShinseishoTodokede_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tabHihokenshaShokaiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplHihokenshaRirekiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplIryoHokenDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplRofukuNenkinDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplSeikatsuHogoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplSetaiShokaiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplShinseiTodokedeDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplShoKofuKaishuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.iryohokenrireki.IryoHokenRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.ShoKaishuKirokuKanriDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HihokenshaShokaiPanelSelect のクラスファイル
 *
 * @author 自動生成
 */
public class HihokenshaShokaiPanelSelectDiv extends Panel {
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
    @JsonProperty("tabHihokenshaShokai")
    public tabHihokenshaShokaiDiv getTabHihokenshaShokai() {
        return tabHihokenshaShokai;
    }

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
    public void setTplHihokenshaRireki(tplHihokenshaRirekiDiv tplHihokenshaRireki) {
        this.getTabHihokenshaShokai().setTplHihokenshaRireki(tplHihokenshaRireki);
    }

    @JsonIgnore
    public ShikakuTokusoRirekiDiv getShikakuTokusoRireki() {
        return this.getTabHihokenshaShokai().getTplHihokenshaRireki().getShikakuTokusoRireki();
    }

    @JsonIgnore
    public void setShikakuTokusoRireki(ShikakuTokusoRirekiDiv ShikakuTokusoRireki) {
        this.getTabHihokenshaShokai().getTplHihokenshaRireki().setShikakuTokusoRireki(ShikakuTokusoRireki);
    }

    @JsonIgnore
    public tplSetaiShokaiDiv getTplSetaiShokai() {
        return this.getTabHihokenshaShokai().getTplSetaiShokai();
    }

    @JsonIgnore
    public void setTplSetaiShokai(tplSetaiShokaiDiv tplSetaiShokai) {
        this.getTabHihokenshaShokai().setTplSetaiShokai(tplSetaiShokai);
    }

    @JsonIgnore
    public DataGrid<dgSetaiJoho_Row> getDgSetaiJoho() {
        return this.getTabHihokenshaShokai().getTplSetaiShokai().getDgSetaiJoho();
    }

    @JsonIgnore
    public void setDgSetaiJoho(DataGrid<dgSetaiJoho_Row> dgSetaiJoho) {
        this.getTabHihokenshaShokai().getTplSetaiShokai().setDgSetaiJoho(dgSetaiJoho);
    }

    @JsonIgnore
    public tplIryoHokenDiv getTplIryoHoken() {
        return this.getTabHihokenshaShokai().getTplIryoHoken();
    }

    @JsonIgnore
    public void setTplIryoHoken(tplIryoHokenDiv tplIryoHoken) {
        this.getTabHihokenshaShokai().setTplIryoHoken(tplIryoHoken);
    }

    @JsonIgnore
    public IryoHokenRirekiDiv getIryoHokenRireki() {
        return this.getTabHihokenshaShokai().getTplIryoHoken().getIryoHokenRireki();
    }

    @JsonIgnore
    public void setIryoHokenRireki(IryoHokenRirekiDiv IryoHokenRireki) {
        this.getTabHihokenshaShokai().getTplIryoHoken().setIryoHokenRireki(IryoHokenRireki);
    }

    @JsonIgnore
    public tplSeikatsuHogoDiv getTplSeikatsuHogo() {
        return this.getTabHihokenshaShokai().getTplSeikatsuHogo();
    }

    @JsonIgnore
    public void setTplSeikatsuHogo(tplSeikatsuHogoDiv tplSeikatsuHogo) {
        this.getTabHihokenshaShokai().setTplSeikatsuHogo(tplSeikatsuHogo);
    }

    @JsonIgnore
    public Label getLblSeikatsuHogo() {
        return this.getTabHihokenshaShokai().getTplSeikatsuHogo().getLblSeikatsuHogo();
    }

    @JsonIgnore
    public void setLblSeikatsuHogo(Label lblSeikatsuHogo) {
        this.getTabHihokenshaShokai().getTplSeikatsuHogo().setLblSeikatsuHogo(lblSeikatsuHogo);
    }

    @JsonIgnore
    public tplRofukuNenkinDiv getTplRofukuNenkin() {
        return this.getTabHihokenshaShokai().getTplRofukuNenkin();
    }

    @JsonIgnore
    public void setTplRofukuNenkin(tplRofukuNenkinDiv tplRofukuNenkin) {
        this.getTabHihokenshaShokai().setTplRofukuNenkin(tplRofukuNenkin);
    }

    @JsonIgnore
    public Label getLblRofukuNenkin() {
        return this.getTabHihokenshaShokai().getTplRofukuNenkin().getLblRofukuNenkin();
    }

    @JsonIgnore
    public void setLblRofukuNenkin(Label lblRofukuNenkin) {
        this.getTabHihokenshaShokai().getTplRofukuNenkin().setLblRofukuNenkin(lblRofukuNenkin);
    }

    @JsonIgnore
    public tplShisetsuNyutaishoDiv getTplShisetsuNyutaisho() {
        return this.getTabHihokenshaShokai().getTplShisetsuNyutaisho();
    }

    @JsonIgnore
    public void setTplShisetsuNyutaisho(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho) {
        this.getTabHihokenshaShokai().setTplShisetsuNyutaisho(tplShisetsuNyutaisho);
    }

    @JsonIgnore
    public ShisetsuNyutaishoRirekiKanriDiv getShisetsuNyutaishoRireki() {
        return this.getTabHihokenshaShokai().getTplShisetsuNyutaisho().getShisetsuNyutaishoRireki();
    }

    @JsonIgnore
    public void setShisetsuNyutaishoRireki(ShisetsuNyutaishoRirekiKanriDiv ShisetsuNyutaishoRireki) {
        this.getTabHihokenshaShokai().getTplShisetsuNyutaisho().setShisetsuNyutaishoRireki(ShisetsuNyutaishoRireki);
    }

    @JsonIgnore
    public tplShoKofuKaishuDiv getTplShoKofuKaishu() {
        return this.getTabHihokenshaShokai().getTplShoKofuKaishu();
    }

    @JsonIgnore
    public void setTplShoKofuKaishu(tplShoKofuKaishuDiv tplShoKofuKaishu) {
        this.getTabHihokenshaShokai().setTplShoKofuKaishu(tplShoKofuKaishu);
    }

    @JsonIgnore
    public ShoKaishuKirokuKanriDiv getShoKofuKaishuKiroku() {
        return this.getTabHihokenshaShokai().getTplShoKofuKaishu().getShoKofuKaishuKiroku();
    }

    @JsonIgnore
    public void setShoKofuKaishuKiroku(ShoKaishuKirokuKanriDiv ShoKofuKaishuKiroku) {
        this.getTabHihokenshaShokai().getTplShoKofuKaishu().setShoKofuKaishuKiroku(ShoKofuKaishuKiroku);
    }

    @JsonIgnore
    public tplShinseiTodokedeDiv getTplShinseiTodokede() {
        return this.getTabHihokenshaShokai().getTplShinseiTodokede();
    }

    @JsonIgnore
    public void setTplShinseiTodokede(tplShinseiTodokedeDiv tplShinseiTodokede) {
        this.getTabHihokenshaShokai().setTplShinseiTodokede(tplShinseiTodokede);
    }

    @JsonIgnore
    public DataGrid<dgShinseishoTodokede_Row> getDgShinseishoTodokede() {
        return this.getTabHihokenshaShokai().getTplShinseiTodokede().getDgShinseishoTodokede();
    }

    @JsonIgnore
    public void setDgShinseishoTodokede(DataGrid<dgShinseishoTodokede_Row> dgShinseishoTodokede) {
        this.getTabHihokenshaShokai().getTplShinseiTodokede().setDgShinseishoTodokede(dgShinseishoTodokede);
    }

}
