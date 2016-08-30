package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB5140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * NoufuGakuDataSakusei のクラスファイル
 *
 * @reamsid_L DBB-1890-010 chenhui
 */
public class NoufuGakuDataSakuseiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NoufuGakuDataSakuseiBatchParameter")
    private NoufuGakuDataSakuseiBatchParameterDiv NoufuGakuDataSakuseiBatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNoufuGakuDataSakuseiBatchParameter
     * @return NoufuGakuDataSakuseiBatchParameter
     */
    @JsonProperty("NoufuGakuDataSakuseiBatchParameter")
    public NoufuGakuDataSakuseiBatchParameterDiv getNoufuGakuDataSakuseiBatchParameter() {
        return NoufuGakuDataSakuseiBatchParameter;
    }

    /*
     * setNoufuGakuDataSakuseiBatchParameter
     * @param NoufuGakuDataSakuseiBatchParameter NoufuGakuDataSakuseiBatchParameter
     */
    @JsonProperty("NoufuGakuDataSakuseiBatchParameter")
    public void setNoufuGakuDataSakuseiBatchParameter(NoufuGakuDataSakuseiBatchParameterDiv NoufuGakuDataSakuseiBatchParameter) {
        this.NoufuGakuDataSakuseiBatchParameter = NoufuGakuDataSakuseiBatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShoriNaiyoDiv getShoriNaiyo() {
        return this.getNoufuGakuDataSakuseiBatchParameter().getShoriNaiyo();
    }

    @JsonIgnore
    public void setShoriNaiyo(ShoriNaiyoDiv ShoriNaiyo) {
        this.getNoufuGakuDataSakuseiBatchParameter().setShoriNaiyo(ShoriNaiyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtTaishoNendo() {
        return this.getNoufuGakuDataSakuseiBatchParameter().getShoriNaiyo().getTxtTaishoNendo();
    }

    @JsonIgnore
    public void setTxtTaishoNendo(TextBoxDate txtTaishoNendo) {
        this.getNoufuGakuDataSakuseiBatchParameter().getShoriNaiyo().setTxtTaishoNendo(txtTaishoNendo);
    }

    @JsonIgnore
    public ChushutsuKikanDiv getChushutsuKikan() {
        return this.getNoufuGakuDataSakuseiBatchParameter().getChushutsuKikan();
    }

    @JsonIgnore
    public void setChushutsuKikan(ChushutsuKikanDiv ChushutsuKikan) {
        this.getNoufuGakuDataSakuseiBatchParameter().setChushutsuKikan(ChushutsuKikan);
    }

    @JsonIgnore
    public DataGrid<dgTanitsuShoriJoken_Row> getDgTanitsuShoriJoken() {
        return this.getNoufuGakuDataSakuseiBatchParameter().getChushutsuKikan().getDgTanitsuShoriJoken();
    }

    @JsonIgnore
    public void setDgTanitsuShoriJoken(DataGrid<dgTanitsuShoriJoken_Row> dgTanitsuShoriJoken) {
        this.getNoufuGakuDataSakuseiBatchParameter().getChushutsuKikan().setDgTanitsuShoriJoken(dgTanitsuShoriJoken);
    }

    @JsonIgnore
    public KoikiShoriDiv getKoikiShori() {
        return this.getNoufuGakuDataSakuseiBatchParameter().getKoikiShori();
    }

    @JsonIgnore
    public void setKoikiShori(KoikiShoriDiv KoikiShori) {
        this.getNoufuGakuDataSakuseiBatchParameter().setKoikiShori(KoikiShori);
    }

    @JsonIgnore
    public DataGrid<dgKoikiShoriTaishoSelect_Row> getDgKoikiShoriTaishoSelect() {
        return this.getNoufuGakuDataSakuseiBatchParameter().getKoikiShori().getDgKoikiShoriTaishoSelect();
    }

    @JsonIgnore
    public void setDgKoikiShoriTaishoSelect(DataGrid<dgKoikiShoriTaishoSelect_Row> dgKoikiShoriTaishoSelect) {
        this.getNoufuGakuDataSakuseiBatchParameter().getKoikiShori().setDgKoikiShoriTaishoSelect(dgKoikiShoriTaishoSelect);
    }

    @JsonIgnore
    public ShoriSelectDiv getShoriSelect() {
        return this.getNoufuGakuDataSakuseiBatchParameter().getShoriSelect();
    }

    @JsonIgnore
    public void setShoriSelect(ShoriSelectDiv ShoriSelect) {
        this.getNoufuGakuDataSakuseiBatchParameter().setShoriSelect(ShoriSelect);
    }

    @JsonIgnore
    public CheckBoxList getChkHikazeiNomiSakusei() {
        return this.getNoufuGakuDataSakuseiBatchParameter().getShoriSelect().getChkHikazeiNomiSakusei();
    }

    @JsonIgnore
    public void setChkHikazeiNomiSakusei(CheckBoxList chkHikazeiNomiSakusei) {
        this.getNoufuGakuDataSakuseiBatchParameter().getShoriSelect().setChkHikazeiNomiSakusei(chkHikazeiNomiSakusei);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getNoufuGakuDataSakuseiBatchParameter().getShoriSelect().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
