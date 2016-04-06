package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;

/**
 * TokubetsuChoshu のクラスファイル
 *
 * @reamsid_L DBB-1770-040 cuilin
 */
public class TokubetsuChoshuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabTokucho")
    private tabTokuchoDiv tabTokucho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabTokucho
     * @return tabTokucho
     */
    @JsonProperty("tabTokucho")
    public tabTokuchoDiv getTabTokucho() {
        return tabTokucho;
    }

    /*
     * settabTokucho
     * @param tabTokucho tabTokucho
     */
    @JsonProperty("tabTokucho")
    public void setTabTokucho(tabTokuchoDiv tabTokucho) {
        this.tabTokucho = tabTokucho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplKibetsuHasuJohoDiv getTplKibetsuHasuJoho() {
        return this.getTabTokucho().getTplKibetsuHasuJoho();
    }

    @JsonIgnore
    public void setTplKibetsuHasuJoho(tplKibetsuHasuJohoDiv tplKibetsuHasuJoho) {
        this.getTabTokucho().setTplKibetsuHasuJoho(tplKibetsuHasuJoho);
    }

    @JsonIgnore
    public KibetsuJohoHasuDiv getKibetsuJohoHasu() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu();
    }

    @JsonIgnore
    public void setKibetsuJohoHasu(KibetsuJohoHasuDiv KibetsuJohoHasu) {
        this.getTabTokucho().getTplKibetsuHasuJoho().setKibetsuJohoHasu(KibetsuJohoHasu);
    }

    @JsonIgnore
    public DataGrid<dgKibetsuJoho_Row> getDgKibetsuJoho() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho();
    }

    @JsonIgnore
    public void setDgKibetsuJoho(DataGrid<dgKibetsuJoho_Row> dgKibetsuJoho) {
        this.getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().setDgKibetsuJoho(dgKibetsuJoho);
    }

    @JsonIgnore
    public HasuHeijunkaJohoDiv getHasuHeijunkaJoho() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho();
    }

    @JsonIgnore
    public void setHasuHeijunkaJoho(HasuHeijunkaJohoDiv HasuHeijunkaJoho) {
        this.getTabTokucho().getTplKibetsuHasuJoho().setHasuHeijunkaJoho(HasuHeijunkaJoho);
    }

    @JsonIgnore
    public KibetsuHokenryoDiv getKibetsuHokenryo() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getKibetsuHokenryo();
    }

    @JsonIgnore
    public void setKibetsuHokenryo(KibetsuHokenryoDiv KibetsuHokenryo) {
        this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().setKibetsuHokenryo(KibetsuHokenryo);
    }

    @JsonIgnore
    public DropDownList getDdlHasu() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getKibetsuHokenryo().getDdlHasu();
    }

    @JsonIgnore
    public void setDdlHasu(DropDownList ddlHasu) {
        this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getKibetsuHokenryo().setDdlHasu(ddlHasu);
    }

    @JsonIgnore
    public Heijunka6GatsuKeisanHohoDiv getHeijunka6GatsuKeisanHoho() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho();
    }

    @JsonIgnore
    public void setHeijunka6GatsuKeisanHoho(Heijunka6GatsuKeisanHohoDiv Heijunka6GatsuKeisanHoho) {
        this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().setHeijunka6GatsuKeisanHoho(Heijunka6GatsuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdlHeijunkaKeisanHoho() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho().getDdlHeijunkaKeisanHoho();
    }

    @JsonIgnore
    public void setDdlHeijunkaKeisanHoho(DropDownList ddlHeijunkaKeisanHoho) {
        this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho().setDdlHeijunkaKeisanHoho(ddlHeijunkaKeisanHoho);
    }

    @JsonIgnore
    public RadioButton getRadGengakuHeijunKa() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho().getRadGengakuHeijunKa();
    }

    @JsonIgnore
    public void setRadGengakuHeijunKa(RadioButton radGengakuHeijunKa) {
        this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho().setRadGengakuHeijunKa(radGengakuHeijunKa);
    }

    @JsonIgnore
    public RadioButton getRadZogakuHeijunKa() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho().getRadZogakuHeijunKa();
    }

    @JsonIgnore
    public void setRadZogakuHeijunKa(RadioButton radZogakuHeijunKa) {
        this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho().setRadZogakuHeijunKa(radZogakuHeijunKa);
    }

    @JsonIgnore
    public Heijunka8GatsuKeisanHohoDiv getHeijunka8GatsuKeisanHoho() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho();
    }

    @JsonIgnore
    public void setHeijunka8GatsuKeisanHoho(Heijunka8GatsuKeisanHohoDiv Heijunka8GatsuKeisanHoho) {
        this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().setHeijunka8GatsuKeisanHoho(Heijunka8GatsuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdlHeijunka8GatsuKeisanHoho() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().getDdlHeijunka8GatsuKeisanHoho();
    }

    @JsonIgnore
    public void setDdlHeijunka8GatsuKeisanHoho(DropDownList ddlHeijunka8GatsuKeisanHoho) {
        this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().setDdlHeijunka8GatsuKeisanHoho(ddlHeijunka8GatsuKeisanHoho);
    }

    @JsonIgnore
    public RadioButton getRad8GatsuGengakuHeijunKa() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().getRad8GatsuGengakuHeijunKa();
    }

    @JsonIgnore
    public void setRad8GatsuGengakuHeijunKa(RadioButton rad8GatsuGengakuHeijunKa) {
        this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().setRad8GatsuGengakuHeijunKa(rad8GatsuGengakuHeijunKa);
    }

    @JsonIgnore
    public RadioButton getRad8GatsuZogakuHeijunKa() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().getRad8GatsuZogakuHeijunKa();
    }

    @JsonIgnore
    public void setRad8GatsuZogakuHeijunKa(RadioButton rad8GatsuZogakuHeijunKa) {
        this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().setRad8GatsuZogakuHeijunKa(rad8GatsuZogakuHeijunKa);
    }

    @JsonIgnore
    public FuchoKirikaeKeisanHohoDiv getFuchoKirikaeKeisanHoho() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getFuchoKirikaeKeisanHoho();
    }

    @JsonIgnore
    public void setFuchoKirikaeKeisanHoho(FuchoKirikaeKeisanHohoDiv FuchoKirikaeKeisanHoho) {
        this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().setFuchoKirikaeKeisanHoho(FuchoKirikaeKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdlFuchoKirikaeKeisanHoho() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeKeisanHoho();
    }

    @JsonIgnore
    public void setDdlFuchoKirikaeKeisanHoho(DropDownList ddlFuchoKirikaeKeisanHoho) {
        this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getFuchoKirikaeKeisanHoho().setDdlFuchoKirikaeKeisanHoho(ddlFuchoKirikaeKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdlFuchoKirikaeJufukuStKi() {
        return this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getFuchoKirikaeKeisanHoho().getDdlFuchoKirikaeJufukuStKi();
    }

    @JsonIgnore
    public void setDdlFuchoKirikaeJufukuStKi(DropDownList ddlFuchoKirikaeJufukuStKi) {
        this.getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getFuchoKirikaeKeisanHoho().setDdlFuchoKirikaeJufukuStKi(ddlFuchoKirikaeJufukuStKi);
    }

    @JsonIgnore
    public tplTokubetsuChoshuHosokuDiv getTplTokubetsuChoshuHosoku() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku();
    }

    @JsonIgnore
    public void setTplTokubetsuChoshuHosoku(tplTokubetsuChoshuHosokuDiv tplTokubetsuChoshuHosoku) {
        this.getTabTokucho().setTplTokubetsuChoshuHosoku(tplTokubetsuChoshuHosoku);
    }

    @JsonIgnore
    public KaishiTsukiKijunNendoDiv getKaishiTsukiKijunNendo() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo();
    }

    @JsonIgnore
    public void setKaishiTsukiKijunNendo(KaishiTsukiKijunNendoDiv KaishiTsukiKijunNendo) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().setKaishiTsukiKijunNendo(KaishiTsukiKijunNendo);
    }

    @JsonIgnore
    public TokuchoKaishiTsukiDiv getTokuchoKaishiTsuki() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki();
    }

    @JsonIgnore
    public void setTokuchoKaishiTsuki(TokuchoKaishiTsukiDiv TokuchoKaishiTsuki) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().setTokuchoKaishiTsuki(TokuchoKaishiTsuki);
    }

    @JsonIgnore
    public DropDownList getDdl4GatsuHosoku() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().getDdl4GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl4GatsuHosoku(DropDownList ddl4GatsuHosoku) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().setDdl4GatsuHosoku(ddl4GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl6GatsuHosoku() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().getDdl6GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl6GatsuHosoku(DropDownList ddl6GatsuHosoku) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().setDdl6GatsuHosoku(ddl6GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl8GatsuHosoku() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().getDdl8GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl8GatsuHosoku(DropDownList ddl8GatsuHosoku) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().setDdl8GatsuHosoku(ddl8GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl10GatsuHosoku() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().getDdl10GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl10GatsuHosoku(DropDownList ddl10GatsuHosoku) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().setDdl10GatsuHosoku(ddl10GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl12GatsuHosoku() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().getDdl12GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl12GatsuHosoku(DropDownList ddl12GatsuHosoku) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().setDdl12GatsuHosoku(ddl12GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl2GatsuHosoku() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().getDdl2GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl2GatsuHosoku(DropDownList ddl2GatsuHosoku) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().setDdl2GatsuHosoku(ddl2GatsuHosoku);
    }

    @JsonIgnore
    public NengakuKijunNendoDiv getNengakuKijunNendo() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getNengakuKijunNendo();
    }

    @JsonIgnore
    public void setNengakuKijunNendo(NengakuKijunNendoDiv NengakuKijunNendo) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().setNengakuKijunNendo(NengakuKijunNendo);
    }

    @JsonIgnore
    public DropDownList getDdl4GatsuKaishiNengakuKijunNendo() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getNengakuKijunNendo().getDdl4GatsuKaishiNengakuKijunNendo();
    }

    @JsonIgnore
    public void setDdl4GatsuKaishiNengakuKijunNendo(DropDownList ddl4GatsuKaishiNengakuKijunNendo) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getNengakuKijunNendo().setDdl4GatsuKaishiNengakuKijunNendo(ddl4GatsuKaishiNengakuKijunNendo);
    }

    @JsonIgnore
    public DropDownList getDdl6GatsuKaishiNengakuKijunNendo() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getNengakuKijunNendo().getDdl6GatsuKaishiNengakuKijunNendo();
    }

    @JsonIgnore
    public void setDdl6GatsuKaishiNengakuKijunNendo(DropDownList ddl6GatsuKaishiNengakuKijunNendo) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getNengakuKijunNendo().setDdl6GatsuKaishiNengakuKijunNendo(ddl6GatsuKaishiNengakuKijunNendo);
    }

    @JsonIgnore
    public DropDownList getDdl8GatsuKaishiNengakuKijunNendo() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getNengakuKijunNendo().getDdl8GatsuKaishiNengakuKijunNendo();
    }

    @JsonIgnore
    public void setDdl8GatsuKaishiNengakuKijunNendo(DropDownList ddl8GatsuKaishiNengakuKijunNendo) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKaishiTsukiKijunNendo().getNengakuKijunNendo().setDdl8GatsuKaishiNengakuKijunNendo(ddl8GatsuKaishiNengakuKijunNendo);
    }

    @JsonIgnore
    public KeisanHohoDiv getKeisanHoho() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho();
    }

    @JsonIgnore
    public void setKeisanHoho(KeisanHohoDiv KeisanHoho) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().setKeisanHoho(KeisanHoho);
    }

    @JsonIgnore
    public IraiKingakuKeisanHohoDiv getIraiKingakuKeisanHoho() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setIraiKingakuKeisanHoho(IraiKingakuKeisanHohoDiv IraiKingakuKeisanHoho) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().setIraiKingakuKeisanHoho(IraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdl12GatsuKaishiIraiKingakuKeisanHoho() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getIraiKingakuKeisanHoho().getDdl12GatsuKaishiIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setDdl12GatsuKaishiIraiKingakuKeisanHoho(DropDownList ddl12GatsuKaishiIraiKingakuKeisanHoho) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getIraiKingakuKeisanHoho().setDdl12GatsuKaishiIraiKingakuKeisanHoho(ddl12GatsuKaishiIraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdl2GatsuKaishiIraiKingakuKeisanHoho() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getIraiKingakuKeisanHoho().getDdl2GatsuKaishiIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setDdl2GatsuKaishiIraiKingakuKeisanHoho(DropDownList ddl2GatsuKaishiIraiKingakuKeisanHoho) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getIraiKingakuKeisanHoho().setDdl2GatsuKaishiIraiKingakuKeisanHoho(ddl2GatsuKaishiIraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdl4GatsuKaishiIraiKingakuKeisanHoho() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getIraiKingakuKeisanHoho().getDdl4GatsuKaishiIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setDdl4GatsuKaishiIraiKingakuKeisanHoho(DropDownList ddl4GatsuKaishiIraiKingakuKeisanHoho) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getIraiKingakuKeisanHoho().setDdl4GatsuKaishiIraiKingakuKeisanHoho(ddl4GatsuKaishiIraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdl6GatsuKaishiIraiKingakuKeisanHoho() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getIraiKingakuKeisanHoho().getDdl6GatsuKaishiIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setDdl6GatsuKaishiIraiKingakuKeisanHoho(DropDownList ddl6GatsuKaishiIraiKingakuKeisanHoho) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getIraiKingakuKeisanHoho().setDdl6GatsuKaishiIraiKingakuKeisanHoho(ddl6GatsuKaishiIraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdl8GatsuKaishiIraiKingakuKeisanHoho() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getIraiKingakuKeisanHoho().getDdl8GatsuKaishiIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setDdl8GatsuKaishiIraiKingakuKeisanHoho(DropDownList ddl8GatsuKaishiIraiKingakuKeisanHoho) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getIraiKingakuKeisanHoho().setDdl8GatsuKaishiIraiKingakuKeisanHoho(ddl8GatsuKaishiIraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public Space getSpaceTokucho() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getSpaceTokucho();
    }

    @JsonIgnore
    public void setSpaceTokucho(Space spaceTokucho) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().setSpaceTokucho(spaceTokucho);
    }

    @JsonIgnore
    public TokubetsuChoshuShinkishaZenhanDiv getTokubetsuChoshuShinkishaZenhan() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getTokubetsuChoshuShinkishaZenhan();
    }

    @JsonIgnore
    public void setTokubetsuChoshuShinkishaZenhan(TokubetsuChoshuShinkishaZenhanDiv TokubetsuChoshuShinkishaZenhan) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().setTokubetsuChoshuShinkishaZenhan(TokubetsuChoshuShinkishaZenhan);
    }

    @JsonIgnore
    public DropDownList getDdl6GatsuKaishiZenhan() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getTokubetsuChoshuShinkishaZenhan().getDdl6GatsuKaishiZenhan();
    }

    @JsonIgnore
    public void setDdl6GatsuKaishiZenhan(DropDownList ddl6GatsuKaishiZenhan) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getTokubetsuChoshuShinkishaZenhan().setDdl6GatsuKaishiZenhan(ddl6GatsuKaishiZenhan);
    }

    @JsonIgnore
    public DropDownList getDdl8GatsuKaishiZenhan() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getTokubetsuChoshuShinkishaZenhan().getDdl8GatsuKaishiZenhan();
    }

    @JsonIgnore
    public void setDdl8GatsuKaishiZenhan(DropDownList ddl8GatsuKaishiZenhan) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getTokubetsuChoshuShinkishaZenhan().setDdl8GatsuKaishiZenhan(ddl8GatsuKaishiZenhan);
    }

    @JsonIgnore
    public DropDownList getDdl10GatsuKaishiZenhan() {
        return this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getTokubetsuChoshuShinkishaZenhan().getDdl10GatsuKaishiZenhan();
    }

    @JsonIgnore
    public void setDdl10GatsuKaishiZenhan(DropDownList ddl10GatsuKaishiZenhan) {
        this.getTabTokucho().getTplTokubetsuChoshuHosoku().getKeisanHoho().getTokubetsuChoshuShinkishaZenhan().setDdl10GatsuKaishiZenhan(ddl10GatsuKaishiZenhan);
    }

    // </editor-fold>
}
