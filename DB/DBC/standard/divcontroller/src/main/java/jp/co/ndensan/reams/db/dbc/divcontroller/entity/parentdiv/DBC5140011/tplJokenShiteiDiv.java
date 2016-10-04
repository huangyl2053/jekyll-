package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tplJokenShitei のクラスファイル
 *
 * @reamsid_L DBC-3330-010 lihang
 */
public class tplJokenShiteiDiv extends TablePanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cel01")
    private cel01AttplJokenShitei cel01;
    @JsonProperty("cel02")
    private cel02AttplJokenShitei cel02;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public ChushutsuJoken1Div getChushutsuJoken1() {
        return this.cel01.getChushutsuJoken1();
    }

    @JsonIgnore
    public ChikuShiteiDiv getChikuShitei() {
        return this.cel01.getChikuShitei();
    }

    @JsonIgnore
    public ChushutsuJoken2Div getChushutsuJoken2() {
        return this.cel02.getChushutsuJoken2();
    }

    @JsonIgnore
    public ShutsuryokuJokenDiv getShutsuryokuJoken() {
        return this.cel02.getShutsuryokuJoken();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcel01
     * @return cel01
     */
    @JsonProperty("cel01")
    private cel01AttplJokenShitei getCel01() {
        return cel01;
    }

    /*
     * setcel01
     * @param cel01 cel01
     */
    @JsonProperty("cel01")
    private void setCel01(cel01AttplJokenShitei cel01) {
        this.cel01 = cel01;
    }

    /*
     * getcel02
     * @return cel02
     */
    @JsonProperty("cel02")
    private cel02AttplJokenShitei getCel02() {
        return cel02;
    }

    /*
     * setcel02
     * @param cel02 cel02
     */
    @JsonProperty("cel02")
    private void setCel02(cel02AttplJokenShitei cel02) {
        this.cel02 = cel02;
    }

    // </editor-fold>
}

/**
 * cel01 のクラスファイル
 *
 * @author 自動生成
 */
class cel01AttplJokenShitei extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("ChushutsuJoken1")
    private ChushutsuJoken1Div ChushutsuJoken1;
    @JsonProperty("ChikuShitei")
    private ChikuShiteiDiv ChikuShitei;

    /*
     * getChushutsuJoken1
     * @return ChushutsuJoken1
     */
    @JsonProperty("ChushutsuJoken1")
    public ChushutsuJoken1Div getChushutsuJoken1() {
        return ChushutsuJoken1;
    }

    /*
     * setChushutsuJoken1
     * @param ChushutsuJoken1 ChushutsuJoken1
     */
    @JsonProperty("ChushutsuJoken1")
    public void setChushutsuJoken1(ChushutsuJoken1Div ChushutsuJoken1) {
        this.ChushutsuJoken1 = ChushutsuJoken1;
    }

    /*
     * getChikuShitei
     * @return ChikuShitei
     */
    @JsonProperty("ChikuShitei")
    public ChikuShiteiDiv getChikuShitei() {
        return ChikuShitei;
    }

    /*
     * setChikuShitei
     * @param ChikuShitei ChikuShitei
     */
    @JsonProperty("ChikuShitei")
    public void setChikuShitei(ChikuShiteiDiv ChikuShitei) {
        this.ChikuShitei = ChikuShitei;
    }

    // </editor-fold>
}

/**
 * cel02 のクラスファイル
 *
 * @author 自動生成
 */
class cel02AttplJokenShitei extends TableCell {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    @JsonProperty("ChushutsuJoken2")
    private ChushutsuJoken2Div ChushutsuJoken2;
    @JsonProperty("ShutsuryokuJoken")
    private ShutsuryokuJokenDiv ShutsuryokuJoken;

    /*
     * getChushutsuJoken2
     * @return ChushutsuJoken2
     */
    @JsonProperty("ChushutsuJoken2")
    public ChushutsuJoken2Div getChushutsuJoken2() {
        return ChushutsuJoken2;
    }

    /*
     * setChushutsuJoken2
     * @param ChushutsuJoken2 ChushutsuJoken2
     */
    @JsonProperty("ChushutsuJoken2")
    public void setChushutsuJoken2(ChushutsuJoken2Div ChushutsuJoken2) {
        this.ChushutsuJoken2 = ChushutsuJoken2;
    }

    /*
     * getShutsuryokuJoken
     * @return ShutsuryokuJoken
     */
    @JsonProperty("ShutsuryokuJoken")
    public ShutsuryokuJokenDiv getShutsuryokuJoken() {
        return ShutsuryokuJoken;
    }

    /*
     * setShutsuryokuJoken
     * @param ShutsuryokuJoken ShutsuryokuJoken
     */
    @JsonProperty("ShutsuryokuJoken")
    public void setShutsuryokuJoken(ShutsuryokuJokenDiv ShutsuryokuJoken) {
        this.ShutsuryokuJoken = ShutsuryokuJoken;
    }

    // </editor-fold>
}
