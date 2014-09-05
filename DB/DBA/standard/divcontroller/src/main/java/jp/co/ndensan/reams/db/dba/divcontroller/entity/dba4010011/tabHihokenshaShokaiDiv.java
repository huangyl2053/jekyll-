package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.dgSetaiJoho_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.dgShinseishoTodokede_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplHihokenshaRirekiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplIryoHokenDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplRofukuNenkinDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplSeikatsuHogoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplSetaiShokaiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplShinseiTodokedeDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.tplShoKofuKaishuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.iryohokenrireki.IryoHokenRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki.ShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri.ShoKaishuKirokuKanriDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tabHihokenshaShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabHihokenshaShokaiDiv extends TabContainer {
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
    @JsonProperty("tplSeikatsuHogo")
    private tplSeikatsuHogoDiv tplSeikatsuHogo;
    @JsonProperty("tplRofukuNenkin")
    private tplRofukuNenkinDiv tplRofukuNenkin;
    @JsonProperty("tplShisetsuNyutaisho")
    private tplShisetsuNyutaishoDiv tplShisetsuNyutaisho;
    @JsonProperty("tplShoKofuKaishu")
    private tplShoKofuKaishuDiv tplShoKofuKaishu;
    @JsonProperty("tplShinseiTodokede")
    private tplShinseiTodokedeDiv tplShinseiTodokede;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplHihokenshaRireki")
    public tplHihokenshaRirekiDiv getTplHihokenshaRireki() {
        return tplHihokenshaRireki;
    }

    @JsonProperty("tplHihokenshaRireki")
    public void setTplHihokenshaRireki(tplHihokenshaRirekiDiv tplHihokenshaRireki) {
        this.tplHihokenshaRireki=tplHihokenshaRireki;
    }

    @JsonProperty("tplSetaiShokai")
    public tplSetaiShokaiDiv getTplSetaiShokai() {
        return tplSetaiShokai;
    }

    @JsonProperty("tplSetaiShokai")
    public void setTplSetaiShokai(tplSetaiShokaiDiv tplSetaiShokai) {
        this.tplSetaiShokai=tplSetaiShokai;
    }

    @JsonProperty("tplIryoHoken")
    public tplIryoHokenDiv getTplIryoHoken() {
        return tplIryoHoken;
    }

    @JsonProperty("tplIryoHoken")
    public void setTplIryoHoken(tplIryoHokenDiv tplIryoHoken) {
        this.tplIryoHoken=tplIryoHoken;
    }

    @JsonProperty("tplSeikatsuHogo")
    public tplSeikatsuHogoDiv getTplSeikatsuHogo() {
        return tplSeikatsuHogo;
    }

    @JsonProperty("tplSeikatsuHogo")
    public void setTplSeikatsuHogo(tplSeikatsuHogoDiv tplSeikatsuHogo) {
        this.tplSeikatsuHogo=tplSeikatsuHogo;
    }

    @JsonProperty("tplRofukuNenkin")
    public tplRofukuNenkinDiv getTplRofukuNenkin() {
        return tplRofukuNenkin;
    }

    @JsonProperty("tplRofukuNenkin")
    public void setTplRofukuNenkin(tplRofukuNenkinDiv tplRofukuNenkin) {
        this.tplRofukuNenkin=tplRofukuNenkin;
    }

    @JsonProperty("tplShisetsuNyutaisho")
    public tplShisetsuNyutaishoDiv getTplShisetsuNyutaisho() {
        return tplShisetsuNyutaisho;
    }

    @JsonProperty("tplShisetsuNyutaisho")
    public void setTplShisetsuNyutaisho(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho) {
        this.tplShisetsuNyutaisho=tplShisetsuNyutaisho;
    }

    @JsonProperty("tplShoKofuKaishu")
    public tplShoKofuKaishuDiv getTplShoKofuKaishu() {
        return tplShoKofuKaishu;
    }

    @JsonProperty("tplShoKofuKaishu")
    public void setTplShoKofuKaishu(tplShoKofuKaishuDiv tplShoKofuKaishu) {
        this.tplShoKofuKaishu=tplShoKofuKaishu;
    }

    @JsonProperty("tplShinseiTodokede")
    public tplShinseiTodokedeDiv getTplShinseiTodokede() {
        return tplShinseiTodokede;
    }

    @JsonProperty("tplShinseiTodokede")
    public void setTplShinseiTodokede(tplShinseiTodokedeDiv tplShinseiTodokede) {
        this.tplShinseiTodokede=tplShinseiTodokede;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShikakuTokusoRirekiDiv getShikakuTokusoRireki() {
        return this.getTplHihokenshaRireki().getShikakuTokusoRireki();
    }

    @JsonIgnore
    public void  setShikakuTokusoRireki(ShikakuTokusoRirekiDiv ShikakuTokusoRireki) {
        this.getTplHihokenshaRireki().setShikakuTokusoRireki(ShikakuTokusoRireki);
    }

    @JsonIgnore
    public DataGrid<dgSetaiJoho_Row> getDgSetaiJoho() {
        return this.getTplSetaiShokai().getDgSetaiJoho();
    }

    @JsonIgnore
    public void  setDgSetaiJoho(DataGrid<dgSetaiJoho_Row> dgSetaiJoho) {
        this.getTplSetaiShokai().setDgSetaiJoho(dgSetaiJoho);
    }

    @JsonIgnore
    public IryoHokenRirekiDiv getIryoHokenRireki() {
        return this.getTplIryoHoken().getIryoHokenRireki();
    }

    @JsonIgnore
    public void  setIryoHokenRireki(IryoHokenRirekiDiv IryoHokenRireki) {
        this.getTplIryoHoken().setIryoHokenRireki(IryoHokenRireki);
    }

    @JsonIgnore
    public Label getLblSeikatsuHogo() {
        return this.getTplSeikatsuHogo().getLblSeikatsuHogo();
    }

    @JsonIgnore
    public void  setLblSeikatsuHogo(Label lblSeikatsuHogo) {
        this.getTplSeikatsuHogo().setLblSeikatsuHogo(lblSeikatsuHogo);
    }

    @JsonIgnore
    public Label getLblRofukuNenkin() {
        return this.getTplRofukuNenkin().getLblRofukuNenkin();
    }

    @JsonIgnore
    public void  setLblRofukuNenkin(Label lblRofukuNenkin) {
        this.getTplRofukuNenkin().setLblRofukuNenkin(lblRofukuNenkin);
    }

    @JsonIgnore
    public ShisetsuNyutaishoRirekiKanriDiv getShisetsuNyutaishoRireki() {
        return this.getTplShisetsuNyutaisho().getShisetsuNyutaishoRireki();
    }

    @JsonIgnore
    public void  setShisetsuNyutaishoRireki(ShisetsuNyutaishoRirekiKanriDiv ShisetsuNyutaishoRireki) {
        this.getTplShisetsuNyutaisho().setShisetsuNyutaishoRireki(ShisetsuNyutaishoRireki);
    }

    @JsonIgnore
    public ShoKaishuKirokuKanriDiv getShoKofuKaishuKiroku() {
        return this.getTplShoKofuKaishu().getShoKofuKaishuKiroku();
    }

    @JsonIgnore
    public void  setShoKofuKaishuKiroku(ShoKaishuKirokuKanriDiv ShoKofuKaishuKiroku) {
        this.getTplShoKofuKaishu().setShoKofuKaishuKiroku(ShoKofuKaishuKiroku);
    }

    @JsonIgnore
    public DataGrid<dgShinseishoTodokede_Row> getDgShinseishoTodokede() {
        return this.getTplShinseiTodokede().getDgShinseishoTodokede();
    }

    @JsonIgnore
    public void  setDgShinseishoTodokede(DataGrid<dgShinseishoTodokede_Row> dgShinseishoTodokede) {
        this.getTplShinseiTodokede().setDgShinseishoTodokede(dgShinseishoTodokede);
    }

}
