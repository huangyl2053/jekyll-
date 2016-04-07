package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplTokubetsuChoshuHosoku のクラスファイル
 *
 * @reamsid_L DBB-1770-040 cuilin
 */
public class tplTokubetsuChoshuHosokuDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaishiTsukiKijunNendo")
    private KaishiTsukiKijunNendoDiv KaishiTsukiKijunNendo;
    @JsonProperty("KeisanHoho")
    private KeisanHohoDiv KeisanHoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaishiTsukiKijunNendo
     * @return KaishiTsukiKijunNendo
     */
    @JsonProperty("KaishiTsukiKijunNendo")
    public KaishiTsukiKijunNendoDiv getKaishiTsukiKijunNendo() {
        return KaishiTsukiKijunNendo;
    }

    /*
     * setKaishiTsukiKijunNendo
     * @param KaishiTsukiKijunNendo KaishiTsukiKijunNendo
     */
    @JsonProperty("KaishiTsukiKijunNendo")
    public void setKaishiTsukiKijunNendo(KaishiTsukiKijunNendoDiv KaishiTsukiKijunNendo) {
        this.KaishiTsukiKijunNendo = KaishiTsukiKijunNendo;
    }

    /*
     * getKeisanHoho
     * @return KeisanHoho
     */
    @JsonProperty("KeisanHoho")
    public KeisanHohoDiv getKeisanHoho() {
        return KeisanHoho;
    }

    /*
     * setKeisanHoho
     * @param KeisanHoho KeisanHoho
     */
    @JsonProperty("KeisanHoho")
    public void setKeisanHoho(KeisanHohoDiv KeisanHoho) {
        this.KeisanHoho = KeisanHoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TokuchoKaishiTsukiDiv getTokuchoKaishiTsuki() {
        return this.getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki();
    }

    @JsonIgnore
    public void setTokuchoKaishiTsuki(TokuchoKaishiTsukiDiv TokuchoKaishiTsuki) {
        this.getKaishiTsukiKijunNendo().setTokuchoKaishiTsuki(TokuchoKaishiTsuki);
    }

    @JsonIgnore
    public DropDownList getDdl4GatsuHosoku() {
        return this.getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().getDdl4GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl4GatsuHosoku(DropDownList ddl4GatsuHosoku) {
        this.getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().setDdl4GatsuHosoku(ddl4GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl6GatsuHosoku() {
        return this.getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().getDdl6GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl6GatsuHosoku(DropDownList ddl6GatsuHosoku) {
        this.getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().setDdl6GatsuHosoku(ddl6GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl8GatsuHosoku() {
        return this.getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().getDdl8GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl8GatsuHosoku(DropDownList ddl8GatsuHosoku) {
        this.getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().setDdl8GatsuHosoku(ddl8GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl10GatsuHosoku() {
        return this.getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().getDdl10GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl10GatsuHosoku(DropDownList ddl10GatsuHosoku) {
        this.getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().setDdl10GatsuHosoku(ddl10GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl12GatsuHosoku() {
        return this.getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().getDdl12GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl12GatsuHosoku(DropDownList ddl12GatsuHosoku) {
        this.getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().setDdl12GatsuHosoku(ddl12GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl2GatsuHosoku() {
        return this.getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().getDdl2GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl2GatsuHosoku(DropDownList ddl2GatsuHosoku) {
        this.getKaishiTsukiKijunNendo().getTokuchoKaishiTsuki().setDdl2GatsuHosoku(ddl2GatsuHosoku);
    }

    @JsonIgnore
    public NengakuKijunNendoDiv getNengakuKijunNendo() {
        return this.getKaishiTsukiKijunNendo().getNengakuKijunNendo();
    }

    @JsonIgnore
    public void setNengakuKijunNendo(NengakuKijunNendoDiv NengakuKijunNendo) {
        this.getKaishiTsukiKijunNendo().setNengakuKijunNendo(NengakuKijunNendo);
    }

    @JsonIgnore
    public DropDownList getDdl4GatsuKaishiNengakuKijunNendo() {
        return this.getKaishiTsukiKijunNendo().getNengakuKijunNendo().getDdl4GatsuKaishiNengakuKijunNendo();
    }

    @JsonIgnore
    public void setDdl4GatsuKaishiNengakuKijunNendo(DropDownList ddl4GatsuKaishiNengakuKijunNendo) {
        this.getKaishiTsukiKijunNendo().getNengakuKijunNendo().setDdl4GatsuKaishiNengakuKijunNendo(ddl4GatsuKaishiNengakuKijunNendo);
    }

    @JsonIgnore
    public DropDownList getDdl6GatsuKaishiNengakuKijunNendo() {
        return this.getKaishiTsukiKijunNendo().getNengakuKijunNendo().getDdl6GatsuKaishiNengakuKijunNendo();
    }

    @JsonIgnore
    public void setDdl6GatsuKaishiNengakuKijunNendo(DropDownList ddl6GatsuKaishiNengakuKijunNendo) {
        this.getKaishiTsukiKijunNendo().getNengakuKijunNendo().setDdl6GatsuKaishiNengakuKijunNendo(ddl6GatsuKaishiNengakuKijunNendo);
    }

    @JsonIgnore
    public DropDownList getDdl8GatsuKaishiNengakuKijunNendo() {
        return this.getKaishiTsukiKijunNendo().getNengakuKijunNendo().getDdl8GatsuKaishiNengakuKijunNendo();
    }

    @JsonIgnore
    public void setDdl8GatsuKaishiNengakuKijunNendo(DropDownList ddl8GatsuKaishiNengakuKijunNendo) {
        this.getKaishiTsukiKijunNendo().getNengakuKijunNendo().setDdl8GatsuKaishiNengakuKijunNendo(ddl8GatsuKaishiNengakuKijunNendo);
    }

    @JsonIgnore
    public IraiKingakuKeisanHohoDiv getIraiKingakuKeisanHoho() {
        return this.getKeisanHoho().getIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setIraiKingakuKeisanHoho(IraiKingakuKeisanHohoDiv IraiKingakuKeisanHoho) {
        this.getKeisanHoho().setIraiKingakuKeisanHoho(IraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdl12GatsuKaishiIraiKingakuKeisanHoho() {
        return this.getKeisanHoho().getIraiKingakuKeisanHoho().getDdl12GatsuKaishiIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setDdl12GatsuKaishiIraiKingakuKeisanHoho(DropDownList ddl12GatsuKaishiIraiKingakuKeisanHoho) {
        this.getKeisanHoho().getIraiKingakuKeisanHoho().setDdl12GatsuKaishiIraiKingakuKeisanHoho(ddl12GatsuKaishiIraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdl2GatsuKaishiIraiKingakuKeisanHoho() {
        return this.getKeisanHoho().getIraiKingakuKeisanHoho().getDdl2GatsuKaishiIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setDdl2GatsuKaishiIraiKingakuKeisanHoho(DropDownList ddl2GatsuKaishiIraiKingakuKeisanHoho) {
        this.getKeisanHoho().getIraiKingakuKeisanHoho().setDdl2GatsuKaishiIraiKingakuKeisanHoho(ddl2GatsuKaishiIraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdl4GatsuKaishiIraiKingakuKeisanHoho() {
        return this.getKeisanHoho().getIraiKingakuKeisanHoho().getDdl4GatsuKaishiIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setDdl4GatsuKaishiIraiKingakuKeisanHoho(DropDownList ddl4GatsuKaishiIraiKingakuKeisanHoho) {
        this.getKeisanHoho().getIraiKingakuKeisanHoho().setDdl4GatsuKaishiIraiKingakuKeisanHoho(ddl4GatsuKaishiIraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdl6GatsuKaishiIraiKingakuKeisanHoho() {
        return this.getKeisanHoho().getIraiKingakuKeisanHoho().getDdl6GatsuKaishiIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setDdl6GatsuKaishiIraiKingakuKeisanHoho(DropDownList ddl6GatsuKaishiIraiKingakuKeisanHoho) {
        this.getKeisanHoho().getIraiKingakuKeisanHoho().setDdl6GatsuKaishiIraiKingakuKeisanHoho(ddl6GatsuKaishiIraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public DropDownList getDdl8GatsuKaishiIraiKingakuKeisanHoho() {
        return this.getKeisanHoho().getIraiKingakuKeisanHoho().getDdl8GatsuKaishiIraiKingakuKeisanHoho();
    }

    @JsonIgnore
    public void setDdl8GatsuKaishiIraiKingakuKeisanHoho(DropDownList ddl8GatsuKaishiIraiKingakuKeisanHoho) {
        this.getKeisanHoho().getIraiKingakuKeisanHoho().setDdl8GatsuKaishiIraiKingakuKeisanHoho(ddl8GatsuKaishiIraiKingakuKeisanHoho);
    }

    @JsonIgnore
    public Space getSpaceTokucho() {
        return this.getKeisanHoho().getSpaceTokucho();
    }

    @JsonIgnore
    public void setSpaceTokucho(Space spaceTokucho) {
        this.getKeisanHoho().setSpaceTokucho(spaceTokucho);
    }

    @JsonIgnore
    public TokubetsuChoshuShinkishaZenhanDiv getTokubetsuChoshuShinkishaZenhan() {
        return this.getKeisanHoho().getTokubetsuChoshuShinkishaZenhan();
    }

    @JsonIgnore
    public void setTokubetsuChoshuShinkishaZenhan(TokubetsuChoshuShinkishaZenhanDiv TokubetsuChoshuShinkishaZenhan) {
        this.getKeisanHoho().setTokubetsuChoshuShinkishaZenhan(TokubetsuChoshuShinkishaZenhan);
    }

    @JsonIgnore
    public DropDownList getDdl6GatsuKaishiZenhan() {
        return this.getKeisanHoho().getTokubetsuChoshuShinkishaZenhan().getDdl6GatsuKaishiZenhan();
    }

    @JsonIgnore
    public void setDdl6GatsuKaishiZenhan(DropDownList ddl6GatsuKaishiZenhan) {
        this.getKeisanHoho().getTokubetsuChoshuShinkishaZenhan().setDdl6GatsuKaishiZenhan(ddl6GatsuKaishiZenhan);
    }

    @JsonIgnore
    public DropDownList getDdl8GatsuKaishiZenhan() {
        return this.getKeisanHoho().getTokubetsuChoshuShinkishaZenhan().getDdl8GatsuKaishiZenhan();
    }

    @JsonIgnore
    public void setDdl8GatsuKaishiZenhan(DropDownList ddl8GatsuKaishiZenhan) {
        this.getKeisanHoho().getTokubetsuChoshuShinkishaZenhan().setDdl8GatsuKaishiZenhan(ddl8GatsuKaishiZenhan);
    }

    @JsonIgnore
    public DropDownList getDdl10GatsuKaishiZenhan() {
        return this.getKeisanHoho().getTokubetsuChoshuShinkishaZenhan().getDdl10GatsuKaishiZenhan();
    }

    @JsonIgnore
    public void setDdl10GatsuKaishiZenhan(DropDownList ddl10GatsuKaishiZenhan) {
        this.getKeisanHoho().getTokubetsuChoshuShinkishaZenhan().setDdl10GatsuKaishiZenhan(ddl10GatsuKaishiZenhan);
    }

    // </editor-fold>
}
