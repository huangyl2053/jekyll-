package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiIryoHokenDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiRofukuNenkinDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiSeikatsuHogoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiSetaiShokaiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiShikakuTokusoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiShinseiTodokedeDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.HihokenshaShokaiShoKofuKaishuDiv;
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
    @JsonProperty("btnShikakuTokuso")
    private Button btnShikakuTokuso;
    @JsonProperty("btnSetaiShokai")
    private Button btnSetaiShokai;
    @JsonProperty("btnIryoHoken")
    private Button btnIryoHoken;
    @JsonProperty("btnSeikatsuHogo")
    private Button btnSeikatsuHogo;
    @JsonProperty("btnRofukuNenkin")
    private Button btnRofukuNenkin;
    @JsonProperty("btnShisetsuNyutaisho")
    private Button btnShisetsuNyutaisho;
    @JsonProperty("btnShoKofu")
    private Button btnShoKofu;
    @JsonProperty("btnShinseiTodokede")
    private Button btnShinseiTodokede;
    @JsonProperty("HihokenshaShokaiShikakuTokuso")
    private HihokenshaShokaiShikakuTokusoDiv HihokenshaShokaiShikakuTokuso;
    @JsonProperty("HihokenshaShokaiSetaiShokai")
    private HihokenshaShokaiSetaiShokaiDiv HihokenshaShokaiSetaiShokai;
    @JsonProperty("HihokenshaShokaiSeikatsuHogo")
    private HihokenshaShokaiSeikatsuHogoDiv HihokenshaShokaiSeikatsuHogo;
    @JsonProperty("HihokenshaShokaiRofukuNenkin")
    private HihokenshaShokaiRofukuNenkinDiv HihokenshaShokaiRofukuNenkin;
    @JsonProperty("HihokenshaShokaiIryoHoken")
    private HihokenshaShokaiIryoHokenDiv HihokenshaShokaiIryoHoken;
    @JsonProperty("HihokenshaShokaiShisetsuNyutaisho")
    private HihokenshaShokaiShisetsuNyutaishoDiv HihokenshaShokaiShisetsuNyutaisho;
    @JsonProperty("HihokenshaShokaiShoKofuKaishu")
    private HihokenshaShokaiShoKofuKaishuDiv HihokenshaShokaiShoKofuKaishu;
    @JsonProperty("HihokenshaShokaiShinseiTodokede")
    private HihokenshaShokaiShinseiTodokedeDiv HihokenshaShokaiShinseiTodokede;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnShikakuTokuso")
    public Button getBtnShikakuTokuso() {
        return btnShikakuTokuso;
    }

    @JsonProperty("btnShikakuTokuso")
    public void setBtnShikakuTokuso(Button btnShikakuTokuso) {
        this.btnShikakuTokuso=btnShikakuTokuso;
    }

    @JsonProperty("btnSetaiShokai")
    public Button getBtnSetaiShokai() {
        return btnSetaiShokai;
    }

    @JsonProperty("btnSetaiShokai")
    public void setBtnSetaiShokai(Button btnSetaiShokai) {
        this.btnSetaiShokai=btnSetaiShokai;
    }

    @JsonProperty("btnIryoHoken")
    public Button getBtnIryoHoken() {
        return btnIryoHoken;
    }

    @JsonProperty("btnIryoHoken")
    public void setBtnIryoHoken(Button btnIryoHoken) {
        this.btnIryoHoken=btnIryoHoken;
    }

    @JsonProperty("btnSeikatsuHogo")
    public Button getBtnSeikatsuHogo() {
        return btnSeikatsuHogo;
    }

    @JsonProperty("btnSeikatsuHogo")
    public void setBtnSeikatsuHogo(Button btnSeikatsuHogo) {
        this.btnSeikatsuHogo=btnSeikatsuHogo;
    }

    @JsonProperty("btnRofukuNenkin")
    public Button getBtnRofukuNenkin() {
        return btnRofukuNenkin;
    }

    @JsonProperty("btnRofukuNenkin")
    public void setBtnRofukuNenkin(Button btnRofukuNenkin) {
        this.btnRofukuNenkin=btnRofukuNenkin;
    }

    @JsonProperty("btnShisetsuNyutaisho")
    public Button getBtnShisetsuNyutaisho() {
        return btnShisetsuNyutaisho;
    }

    @JsonProperty("btnShisetsuNyutaisho")
    public void setBtnShisetsuNyutaisho(Button btnShisetsuNyutaisho) {
        this.btnShisetsuNyutaisho=btnShisetsuNyutaisho;
    }

    @JsonProperty("btnShoKofu")
    public Button getBtnShoKofu() {
        return btnShoKofu;
    }

    @JsonProperty("btnShoKofu")
    public void setBtnShoKofu(Button btnShoKofu) {
        this.btnShoKofu=btnShoKofu;
    }

    @JsonProperty("btnShinseiTodokede")
    public Button getBtnShinseiTodokede() {
        return btnShinseiTodokede;
    }

    @JsonProperty("btnShinseiTodokede")
    public void setBtnShinseiTodokede(Button btnShinseiTodokede) {
        this.btnShinseiTodokede=btnShinseiTodokede;
    }

    @JsonProperty("HihokenshaShokaiShikakuTokuso")
    public HihokenshaShokaiShikakuTokusoDiv getHihokenshaShokaiShikakuTokuso() {
        return HihokenshaShokaiShikakuTokuso;
    }

    @JsonProperty("HihokenshaShokaiShikakuTokuso")
    public void setHihokenshaShokaiShikakuTokuso(HihokenshaShokaiShikakuTokusoDiv HihokenshaShokaiShikakuTokuso) {
        this.HihokenshaShokaiShikakuTokuso=HihokenshaShokaiShikakuTokuso;
    }

    @JsonProperty("HihokenshaShokaiSetaiShokai")
    public HihokenshaShokaiSetaiShokaiDiv getHihokenshaShokaiSetaiShokai() {
        return HihokenshaShokaiSetaiShokai;
    }

    @JsonProperty("HihokenshaShokaiSetaiShokai")
    public void setHihokenshaShokaiSetaiShokai(HihokenshaShokaiSetaiShokaiDiv HihokenshaShokaiSetaiShokai) {
        this.HihokenshaShokaiSetaiShokai=HihokenshaShokaiSetaiShokai;
    }

    @JsonProperty("HihokenshaShokaiSeikatsuHogo")
    public HihokenshaShokaiSeikatsuHogoDiv getHihokenshaShokaiSeikatsuHogo() {
        return HihokenshaShokaiSeikatsuHogo;
    }

    @JsonProperty("HihokenshaShokaiSeikatsuHogo")
    public void setHihokenshaShokaiSeikatsuHogo(HihokenshaShokaiSeikatsuHogoDiv HihokenshaShokaiSeikatsuHogo) {
        this.HihokenshaShokaiSeikatsuHogo=HihokenshaShokaiSeikatsuHogo;
    }

    @JsonProperty("HihokenshaShokaiRofukuNenkin")
    public HihokenshaShokaiRofukuNenkinDiv getHihokenshaShokaiRofukuNenkin() {
        return HihokenshaShokaiRofukuNenkin;
    }

    @JsonProperty("HihokenshaShokaiRofukuNenkin")
    public void setHihokenshaShokaiRofukuNenkin(HihokenshaShokaiRofukuNenkinDiv HihokenshaShokaiRofukuNenkin) {
        this.HihokenshaShokaiRofukuNenkin=HihokenshaShokaiRofukuNenkin;
    }

    @JsonProperty("HihokenshaShokaiIryoHoken")
    public HihokenshaShokaiIryoHokenDiv getHihokenshaShokaiIryoHoken() {
        return HihokenshaShokaiIryoHoken;
    }

    @JsonProperty("HihokenshaShokaiIryoHoken")
    public void setHihokenshaShokaiIryoHoken(HihokenshaShokaiIryoHokenDiv HihokenshaShokaiIryoHoken) {
        this.HihokenshaShokaiIryoHoken=HihokenshaShokaiIryoHoken;
    }

    @JsonProperty("HihokenshaShokaiShisetsuNyutaisho")
    public HihokenshaShokaiShisetsuNyutaishoDiv getHihokenshaShokaiShisetsuNyutaisho() {
        return HihokenshaShokaiShisetsuNyutaisho;
    }

    @JsonProperty("HihokenshaShokaiShisetsuNyutaisho")
    public void setHihokenshaShokaiShisetsuNyutaisho(HihokenshaShokaiShisetsuNyutaishoDiv HihokenshaShokaiShisetsuNyutaisho) {
        this.HihokenshaShokaiShisetsuNyutaisho=HihokenshaShokaiShisetsuNyutaisho;
    }

    @JsonProperty("HihokenshaShokaiShoKofuKaishu")
    public HihokenshaShokaiShoKofuKaishuDiv getHihokenshaShokaiShoKofuKaishu() {
        return HihokenshaShokaiShoKofuKaishu;
    }

    @JsonProperty("HihokenshaShokaiShoKofuKaishu")
    public void setHihokenshaShokaiShoKofuKaishu(HihokenshaShokaiShoKofuKaishuDiv HihokenshaShokaiShoKofuKaishu) {
        this.HihokenshaShokaiShoKofuKaishu=HihokenshaShokaiShoKofuKaishu;
    }

    @JsonProperty("HihokenshaShokaiShinseiTodokede")
    public HihokenshaShokaiShinseiTodokedeDiv getHihokenshaShokaiShinseiTodokede() {
        return HihokenshaShokaiShinseiTodokede;
    }

    @JsonProperty("HihokenshaShokaiShinseiTodokede")
    public void setHihokenshaShokaiShinseiTodokede(HihokenshaShokaiShinseiTodokedeDiv HihokenshaShokaiShinseiTodokede) {
        this.HihokenshaShokaiShinseiTodokede=HihokenshaShokaiShinseiTodokede;
    }

}
