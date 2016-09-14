package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvJokenSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvJokenSelectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSelectKijun")
    private RadioButton radSelectKijun;
    @JsonProperty("dvKensakuJoken")
    private dvKensakuJokenDiv dvKensakuJoken;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradSelectKijun
     * @return radSelectKijun
     */
    @JsonProperty("radSelectKijun")
    public RadioButton getRadSelectKijun() {
        return radSelectKijun;
    }

    /*
     * setradSelectKijun
     * @param radSelectKijun radSelectKijun
     */
    @JsonProperty("radSelectKijun")
    public void setRadSelectKijun(RadioButton radSelectKijun) {
        this.radSelectKijun = radSelectKijun;
    }

    /*
     * getdvKensakuJoken
     * @return dvKensakuJoken
     */
    @JsonProperty("dvKensakuJoken")
    public dvKensakuJokenDiv getDvKensakuJoken() {
        return dvKensakuJoken;
    }

    /*
     * setdvKensakuJoken
     * @param dvKensakuJoken dvKensakuJoken
     */
    @JsonProperty("dvKensakuJoken")
    public void setDvKensakuJoken(dvKensakuJokenDiv dvKensakuJoken) {
        this.dvKensakuJoken = dvKensakuJoken;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNumRange getTxtNenrei() {
        return this.getDvKensakuJoken().getTxtNenrei();
    }

    @JsonIgnore
    public void  setTxtNenrei(TextBoxNumRange txtNenrei) {
        this.getDvKensakuJoken().setTxtNenrei(txtNenrei);
    }

    @JsonIgnore
    public TextBoxDate getTxtNenreiKijunbi() {
        return this.getDvKensakuJoken().getTxtNenreiKijunbi();
    }

    @JsonIgnore
    public void  setTxtNenreiKijunbi(TextBoxDate txtNenreiKijunbi) {
        this.getDvKensakuJoken().setTxtNenreiKijunbi(txtNenreiKijunbi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtSeinengappi() {
        return this.getDvKensakuJoken().getTxtSeinengappi();
    }

    @JsonIgnore
    public void  setTxtSeinengappi(TextBoxDateRange txtSeinengappi) {
        this.getDvKensakuJoken().setTxtSeinengappi(txtSeinengappi);
    }

    // </editor-fold>
}
