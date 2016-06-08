package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaishiTsukiKijunNendo のクラスファイル
 *
 * @reamsid_L DBB-1770-040 cuilin
 */
public class KaishiTsukiKijunNendoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TokuchoKaishiTsuki")
    private TokuchoKaishiTsukiDiv TokuchoKaishiTsuki;
    @JsonProperty("NengakuKijunNendo")
    private NengakuKijunNendoDiv NengakuKijunNendo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTokuchoKaishiTsuki
     * @return TokuchoKaishiTsuki
     */
    @JsonProperty("TokuchoKaishiTsuki")
    public TokuchoKaishiTsukiDiv getTokuchoKaishiTsuki() {
        return TokuchoKaishiTsuki;
    }

    /*
     * setTokuchoKaishiTsuki
     * @param TokuchoKaishiTsuki TokuchoKaishiTsuki
     */
    @JsonProperty("TokuchoKaishiTsuki")
    public void setTokuchoKaishiTsuki(TokuchoKaishiTsukiDiv TokuchoKaishiTsuki) {
        this.TokuchoKaishiTsuki = TokuchoKaishiTsuki;
    }

    /*
     * getNengakuKijunNendo
     * @return NengakuKijunNendo
     */
    @JsonProperty("NengakuKijunNendo")
    public NengakuKijunNendoDiv getNengakuKijunNendo() {
        return NengakuKijunNendo;
    }

    /*
     * setNengakuKijunNendo
     * @param NengakuKijunNendo NengakuKijunNendo
     */
    @JsonProperty("NengakuKijunNendo")
    public void setNengakuKijunNendo(NengakuKijunNendoDiv NengakuKijunNendo) {
        this.NengakuKijunNendo = NengakuKijunNendo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdl4GatsuHosoku() {
        return this.getTokuchoKaishiTsuki().getDdl4GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl4GatsuHosoku(DropDownList ddl4GatsuHosoku) {
        this.getTokuchoKaishiTsuki().setDdl4GatsuHosoku(ddl4GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl6GatsuHosoku() {
        return this.getTokuchoKaishiTsuki().getDdl6GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl6GatsuHosoku(DropDownList ddl6GatsuHosoku) {
        this.getTokuchoKaishiTsuki().setDdl6GatsuHosoku(ddl6GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl8GatsuHosoku() {
        return this.getTokuchoKaishiTsuki().getDdl8GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl8GatsuHosoku(DropDownList ddl8GatsuHosoku) {
        this.getTokuchoKaishiTsuki().setDdl8GatsuHosoku(ddl8GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl10GatsuHosoku() {
        return this.getTokuchoKaishiTsuki().getDdl10GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl10GatsuHosoku(DropDownList ddl10GatsuHosoku) {
        this.getTokuchoKaishiTsuki().setDdl10GatsuHosoku(ddl10GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl12GatsuHosoku() {
        return this.getTokuchoKaishiTsuki().getDdl12GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl12GatsuHosoku(DropDownList ddl12GatsuHosoku) {
        this.getTokuchoKaishiTsuki().setDdl12GatsuHosoku(ddl12GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl2GatsuHosoku() {
        return this.getTokuchoKaishiTsuki().getDdl2GatsuHosoku();
    }

    @JsonIgnore
    public void setDdl2GatsuHosoku(DropDownList ddl2GatsuHosoku) {
        this.getTokuchoKaishiTsuki().setDdl2GatsuHosoku(ddl2GatsuHosoku);
    }

    @JsonIgnore
    public DropDownList getDdl4GatsuKaishiNengakuKijunNendo() {
        return this.getNengakuKijunNendo().getDdl4GatsuKaishiNengakuKijunNendo();
    }

    @JsonIgnore
    public void setDdl4GatsuKaishiNengakuKijunNendo(DropDownList ddl4GatsuKaishiNengakuKijunNendo) {
        this.getNengakuKijunNendo().setDdl4GatsuKaishiNengakuKijunNendo(ddl4GatsuKaishiNengakuKijunNendo);
    }

    @JsonIgnore
    public DropDownList getDdl6GatsuKaishiNengakuKijunNendo() {
        return this.getNengakuKijunNendo().getDdl6GatsuKaishiNengakuKijunNendo();
    }

    @JsonIgnore
    public void setDdl6GatsuKaishiNengakuKijunNendo(DropDownList ddl6GatsuKaishiNengakuKijunNendo) {
        this.getNengakuKijunNendo().setDdl6GatsuKaishiNengakuKijunNendo(ddl6GatsuKaishiNengakuKijunNendo);
    }

    @JsonIgnore
    public DropDownList getDdl8GatsuKaishiNengakuKijunNendo() {
        return this.getNengakuKijunNendo().getDdl8GatsuKaishiNengakuKijunNendo();
    }

    @JsonIgnore
    public void setDdl8GatsuKaishiNengakuKijunNendo(DropDownList ddl8GatsuKaishiNengakuKijunNendo) {
        this.getNengakuKijunNendo().setDdl8GatsuKaishiNengakuKijunNendo(ddl8GatsuKaishiNengakuKijunNendo);
    }

    // </editor-fold>
}
