package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0840011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SystemKanri のクラスファイル 
 * 
 * @author 自動生成
 */
public class SystemKanriDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HokenjaJoho")
    private HokenjaJohoDiv HokenjaJoho;
    @JsonProperty("ChohyoJushoDefault")
    private ChohyoJushoDefaultDiv ChohyoJushoDefault;
    @JsonProperty("SearchCondition")
    private SearchConditionDiv SearchCondition;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHokenjaJoho
     * @return HokenjaJoho
     */
    @JsonProperty("HokenjaJoho")
    public HokenjaJohoDiv getHokenjaJoho() {
        return HokenjaJoho;
    }

    /*
     * setHokenjaJoho
     * @param HokenjaJoho HokenjaJoho
     */
    @JsonProperty("HokenjaJoho")
    public void setHokenjaJoho(HokenjaJohoDiv HokenjaJoho) {
        this.HokenjaJoho = HokenjaJoho;
    }

    /*
     * getChohyoJushoDefault
     * @return ChohyoJushoDefault
     */
    @JsonProperty("ChohyoJushoDefault")
    public ChohyoJushoDefaultDiv getChohyoJushoDefault() {
        return ChohyoJushoDefault;
    }

    /*
     * setChohyoJushoDefault
     * @param ChohyoJushoDefault ChohyoJushoDefault
     */
    @JsonProperty("ChohyoJushoDefault")
    public void setChohyoJushoDefault(ChohyoJushoDefaultDiv ChohyoJushoDefault) {
        this.ChohyoJushoDefault = ChohyoJushoDefault;
    }

    /*
     * getSearchCondition
     * @return SearchCondition
     */
    @JsonProperty("SearchCondition")
    public SearchConditionDiv getSearchCondition() {
        return SearchCondition;
    }

    /*
     * setSearchCondition
     * @param SearchCondition SearchCondition
     */
    @JsonProperty("SearchCondition")
    public void setSearchCondition(SearchConditionDiv SearchCondition) {
        this.SearchCondition = SearchCondition;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtHokenjaCode() {
        return this.getHokenjaJoho().getHokenjaJoho1().getTxtHokenjaCode();
    }

    @JsonIgnore
    public void  setTxtHokenjaCode(TextBoxCode txtHokenjaCode) {
        this.getHokenjaJoho().getHokenjaJoho1().setTxtHokenjaCode(txtHokenjaCode);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getHokenjaJoho().getHokenjaJoho1().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getHokenjaJoho().getHokenjaJoho1().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getHokenjaJoho().getHokenjaJoho1().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getHokenjaJoho().getHokenjaJoho1().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public DropDownList getDdlGaikokujinHyoji() {
        return this.getHokenjaJoho().getHokenjaJoho1().getDdlGaikokujinHyoji();
    }

    @JsonIgnore
    public void  setDdlGaikokujinHyoji(DropDownList ddlGaikokujinHyoji) {
        this.getHokenjaJoho().getHokenjaJoho1().setDdlGaikokujinHyoji(ddlGaikokujinHyoji);
    }

    @JsonIgnore
    public TextBox getTxtHokenjaName() {
        return this.getHokenjaJoho().getHokenjaJoho2().getTxtHokenjaName();
    }

    @JsonIgnore
    public void  setTxtHokenjaName(TextBox txtHokenjaName) {
        this.getHokenjaJoho().getHokenjaJoho2().setTxtHokenjaName(txtHokenjaName);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getHokenjaJoho().getHokenjaJoho2().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getHokenjaJoho().getHokenjaJoho2().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public DropDownList getDdlChikuCode() {
        return this.getHokenjaJoho().getHokenjaJoho2().getDdlChikuCode();
    }

    @JsonIgnore
    public void  setDdlChikuCode(DropDownList ddlChikuCode) {
        this.getHokenjaJoho().getHokenjaJoho2().setDdlChikuCode(ddlChikuCode);
    }

    @JsonIgnore
    public DropDownList getDdlGaikokujinBirthdayHyoji() {
        return this.getHokenjaJoho().getHokenjaJoho2().getDdlGaikokujinBirthdayHyoji();
    }

    @JsonIgnore
    public void  setDdlGaikokujinBirthdayHyoji(DropDownList ddlGaikokujinBirthdayHyoji) {
        this.getHokenjaJoho().getHokenjaJoho2().setDdlGaikokujinBirthdayHyoji(ddlGaikokujinBirthdayHyoji);
    }

    @JsonIgnore
    public TextBoxCode getTxtRojinHokenShichosonNo() {
        return this.getHokenjaJoho().getHokenjaJoho2().getTxtRojinHokenShichosonNo();
    }

    @JsonIgnore
    public void  setTxtRojinHokenShichosonNo(TextBoxCode txtRojinHokenShichosonNo) {
        this.getHokenjaJoho().getHokenjaJoho2().setTxtRojinHokenShichosonNo(txtRojinHokenShichosonNo);
    }

    // </editor-fold>
}
