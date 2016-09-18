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
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku1Input.Chiku1InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku1Input.IChiku1InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku2Input.Chiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku2Input.IChiku2InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku3Input.Chiku3InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.Chiku3Input.IChiku3InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.IChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.GyoseikuInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.IGyoseikuInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvAtena のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvAtenaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DvJokenSelect")
    private DvJokenSelectDiv DvJokenSelect;
    @JsonProperty("DvChiku")
    private DvChikuDiv DvChiku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDvJokenSelect
     * @return DvJokenSelect
     */
    @JsonProperty("DvJokenSelect")
    public DvJokenSelectDiv getDvJokenSelect() {
        return DvJokenSelect;
    }

    /*
     * setDvJokenSelect
     * @param DvJokenSelect DvJokenSelect
     */
    @JsonProperty("DvJokenSelect")
    public void setDvJokenSelect(DvJokenSelectDiv DvJokenSelect) {
        this.DvJokenSelect = DvJokenSelect;
    }

    /*
     * getDvChiku
     * @return DvChiku
     */
    @JsonProperty("DvChiku")
    public DvChikuDiv getDvChiku() {
        return DvChiku;
    }

    /*
     * setDvChiku
     * @param DvChiku DvChiku
     */
    @JsonProperty("DvChiku")
    public void setDvChiku(DvChikuDiv DvChiku) {
        this.DvChiku = DvChiku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadSelectKijun() {
        return this.getDvJokenSelect().getRadSelectKijun();
    }

    @JsonIgnore
    public void  setRadSelectKijun(RadioButton radSelectKijun) {
        this.getDvJokenSelect().setRadSelectKijun(radSelectKijun);
    }

    @JsonIgnore
    public dvKensakuJokenDiv getDvKensakuJoken() {
        return this.getDvJokenSelect().getDvKensakuJoken();
    }

    @JsonIgnore
    public void  setDvKensakuJoken(dvKensakuJokenDiv dvKensakuJoken) {
        this.getDvJokenSelect().setDvKensakuJoken(dvKensakuJoken);
    }

    @JsonIgnore
    public TextBoxNumRange getTxtNenrei() {
        return this.getDvJokenSelect().getDvKensakuJoken().getTxtNenrei();
    }

    @JsonIgnore
    public void  setTxtNenrei(TextBoxNumRange txtNenrei) {
        this.getDvJokenSelect().getDvKensakuJoken().setTxtNenrei(txtNenrei);
    }

    @JsonIgnore
    public TextBoxDate getTxtNenreiKijunbi() {
        return this.getDvJokenSelect().getDvKensakuJoken().getTxtNenreiKijunbi();
    }

    @JsonIgnore
    public void  setTxtNenreiKijunbi(TextBoxDate txtNenreiKijunbi) {
        this.getDvJokenSelect().getDvKensakuJoken().setTxtNenreiKijunbi(txtNenreiKijunbi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtSeinengappi() {
        return this.getDvJokenSelect().getDvKensakuJoken().getTxtSeinengappi();
    }

    @JsonIgnore
    public void  setTxtSeinengappi(TextBoxDateRange txtSeinengappi) {
        this.getDvJokenSelect().getDvKensakuJoken().setTxtSeinengappi(txtSeinengappi);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getDvJokenSelect().getCcdHokenshaList();
    }

    @JsonIgnore
    public DropDownList getDdlChikuSelect() {
        return this.getDvChiku().getDdlChikuSelect();
    }

    @JsonIgnore
    public void  setDdlChikuSelect(DropDownList ddlChikuSelect) {
        this.getDvChiku().setDdlChikuSelect(ddlChikuSelect);
    }

    @JsonIgnore
    public Label getLblStart() {
        return this.getDvChiku().getLblStart();
    }

    @JsonIgnore
    public void  setLblStart(Label lblStart) {
        this.getDvChiku().setLblStart(lblStart);
    }

    @JsonIgnore
    public IChoikiInputDiv getCcdJushoFrom() {
        return this.getDvChiku().getCcdJushoFrom();
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyoseikuFrom() {
        return this.getDvChiku().getCcdGyoseikuFrom();
    }

    @JsonIgnore
    public IChiku1InputDiv getCcdChiku1From() {
        return this.getDvChiku().getCcdChiku1From();
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChiku2From() {
        return this.getDvChiku().getCcdChiku2From();
    }

    @JsonIgnore
    public IChiku3InputDiv getCcdChiku3From() {
        return this.getDvChiku().getCcdChiku3From();
    }

    @JsonIgnore
    public Label getLblEnd() {
        return this.getDvChiku().getLblEnd();
    }

    @JsonIgnore
    public void  setLblEnd(Label lblEnd) {
        this.getDvChiku().setLblEnd(lblEnd);
    }

    @JsonIgnore
    public IChoikiInputDiv getCcdJushoTo() {
        return this.getDvChiku().getCcdJushoTo();
    }

    @JsonIgnore
    public IGyoseikuInputDiv getCcdGyoseikuTo() {
        return this.getDvChiku().getCcdGyoseikuTo();
    }

    @JsonIgnore
    public IChiku1InputDiv getCcdChiku1To() {
        return this.getDvChiku().getCcdChiku1To();
    }

    @JsonIgnore
    public IChiku2InputDiv getCcdChiku2To() {
        return this.getDvChiku().getCcdChiku2To();
    }

    @JsonIgnore
    public IChiku3InputDiv getCcdChiku3To() {
        return this.getDvChiku().getCcdChiku3To();
    }

    // </editor-fold>
}
