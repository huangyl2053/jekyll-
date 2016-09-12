package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6090001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * HomonChosaItakuNyuryoku のクラスファイル
 *
 * @author 自動生成
 */
public class HomonChosaItakuNyuryokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaItakuKensaku")
    private ChosaItakuKensakuDiv ChosaItakuKensaku;
    @JsonProperty("Chosain")
    private ChosainDiv Chosain;
    @JsonProperty("ChosaJissekiJoho")
    private ChosaJissekiJohoDiv ChosaJissekiJoho;
    @JsonProperty("ShinseiJohoMeisai")
    private ShinseiJohoMeisaiDiv ShinseiJohoMeisai;
    @JsonProperty("ShinsakaiMessage")
    private ShinsakaiMessageDiv ShinsakaiMessage;
    @JsonProperty("hdt認定調査委託先コード")
    private RString hdt認定調査委託先コード;
    @JsonProperty("hdt認定調査委託先名称")
    private RString hdt認定調査委託先名称;
    @JsonProperty("hdt証記載保険者番号")
    private RString hdt証記載保険者番号;
    @JsonProperty("hdt申請書管理番号")
    private RString hdt申請書管理番号;
    @JsonProperty("hdt認定調査依頼履歴番号")
    private RString hdt認定調査依頼履歴番号;
    @JsonProperty("hdt市町村コード")
    private RString hdt市町村コード;
    @JsonProperty("hdt状態")
    private RString hdt状態;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChosaItakuKensaku
     * @return ChosaItakuKensaku
     */
    @JsonProperty("ChosaItakuKensaku")
    public ChosaItakuKensakuDiv getChosaItakuKensaku() {
        return ChosaItakuKensaku;
    }

    /*
     * setChosaItakuKensaku
     * @param ChosaItakuKensaku ChosaItakuKensaku
     */
    @JsonProperty("ChosaItakuKensaku")
    public void setChosaItakuKensaku(ChosaItakuKensakuDiv ChosaItakuKensaku) {
        this.ChosaItakuKensaku = ChosaItakuKensaku;
    }

    /*
     * getChosain
     * @return Chosain
     */
    @JsonProperty("Chosain")
    public ChosainDiv getChosain() {
        return Chosain;
    }

    /*
     * setChosain
     * @param Chosain Chosain
     */
    @JsonProperty("Chosain")
    public void setChosain(ChosainDiv Chosain) {
        this.Chosain = Chosain;
    }

    /*
     * getChosaJissekiJoho
     * @return ChosaJissekiJoho
     */
    @JsonProperty("ChosaJissekiJoho")
    public ChosaJissekiJohoDiv getChosaJissekiJoho() {
        return ChosaJissekiJoho;
    }

    /*
     * setChosaJissekiJoho
     * @param ChosaJissekiJoho ChosaJissekiJoho
     */
    @JsonProperty("ChosaJissekiJoho")
    public void setChosaJissekiJoho(ChosaJissekiJohoDiv ChosaJissekiJoho) {
        this.ChosaJissekiJoho = ChosaJissekiJoho;
    }

    /*
     * getShinseiJohoMeisai
     * @return ShinseiJohoMeisai
     */
    @JsonProperty("ShinseiJohoMeisai")
    public ShinseiJohoMeisaiDiv getShinseiJohoMeisai() {
        return ShinseiJohoMeisai;
    }

    /*
     * setShinseiJohoMeisai
     * @param ShinseiJohoMeisai ShinseiJohoMeisai
     */
    @JsonProperty("ShinseiJohoMeisai")
    public void setShinseiJohoMeisai(ShinseiJohoMeisaiDiv ShinseiJohoMeisai) {
        this.ShinseiJohoMeisai = ShinseiJohoMeisai;
    }

    /*
     * getShinsakaiMessage
     * @return ShinsakaiMessage
     */
    @JsonProperty("ShinsakaiMessage")
    public ShinsakaiMessageDiv getShinsakaiMessage() {
        return ShinsakaiMessage;
    }

    /*
     * setShinsakaiMessage
     * @param ShinsakaiMessage ShinsakaiMessage
     */
    @JsonProperty("ShinsakaiMessage")
    public void setShinsakaiMessage(ShinsakaiMessageDiv ShinsakaiMessage) {
        this.ShinsakaiMessage = ShinsakaiMessage;
    }

    /*
     * gethdt認定調査委託先コード
     * @return hdt認定調査委託先コード
     */
    @JsonProperty("hdt認定調査委託先コード")
    public RString getHdt認定調査委託先コード() {
        return hdt認定調査委託先コード;
    }

    /*
     * sethdt認定調査委託先コード
     * @param hdt認定調査委託先コード hdt認定調査委託先コード
     */
    @JsonProperty("hdt認定調査委託先コード")
    public void setHdt認定調査委託先コード(RString hdt認定調査委託先コード) {
        this.hdt認定調査委託先コード = hdt認定調査委託先コード;
    }

    /*
     * gethdt認定調査委託先名称
     * @return hdt認定調査委託先名称
     */
    @JsonProperty("hdt認定調査委託先名称")
    public RString getHdt認定調査委託先名称() {
        return hdt認定調査委託先名称;
    }

    /*
     * sethdt認定調査委託先名称
     * @param hdt認定調査委託先名称 hdt認定調査委託先名称
     */
    @JsonProperty("hdt認定調査委託先名称")
    public void setHdt認定調査委託先名称(RString hdt認定調査委託先名称) {
        this.hdt認定調査委託先名称 = hdt認定調査委託先名称;
    }

    /*
     * gethdt証記載保険者番号
     * @return hdt証記載保険者番号
     */
    @JsonProperty("hdt証記載保険者番号")
    public RString getHdt証記載保険者番号() {
        return hdt証記載保険者番号;
    }

    /*
     * sethdt証記載保険者番号
     * @param hdt証記載保険者番号 hdt証記載保険者番号
     */
    @JsonProperty("hdt証記載保険者番号")
    public void setHdt証記載保険者番号(RString hdt証記載保険者番号) {
        this.hdt証記載保険者番号 = hdt証記載保険者番号;
    }

    /*
     * gethdt申請書管理番号
     * @return hdt申請書管理番号
     */
    @JsonProperty("hdt申請書管理番号")
    public RString getHdt申請書管理番号() {
        return hdt申請書管理番号;
    }

    /*
     * sethdt申請書管理番号
     * @param hdt申請書管理番号 hdt申請書管理番号
     */
    @JsonProperty("hdt申請書管理番号")
    public void setHdt申請書管理番号(RString hdt申請書管理番号) {
        this.hdt申請書管理番号 = hdt申請書管理番号;
    }

    /*
     * gethdt認定調査依頼履歴番号
     * @return hdt認定調査依頼履歴番号
     */
    @JsonProperty("hdt認定調査依頼履歴番号")
    public RString getHdt認定調査依頼履歴番号() {
        return hdt認定調査依頼履歴番号;
    }

    /*
     * sethdt認定調査依頼履歴番号
     * @param hdt認定調査依頼履歴番号 hdt認定調査依頼履歴番号
     */
    @JsonProperty("hdt認定調査依頼履歴番号")
    public void setHdt認定調査依頼履歴番号(RString hdt認定調査依頼履歴番号) {
        this.hdt認定調査依頼履歴番号 = hdt認定調査依頼履歴番号;
    }

    /*
     * gethdt市町村コード
     * @return hdt市町村コード
     */
    @JsonProperty("hdt市町村コード")
    public RString getHdt市町村コード() {
        return hdt市町村コード;
    }

    /*
     * sethdt市町村コード
     * @param hdt市町村コード hdt市町村コード
     */
    @JsonProperty("hdt市町村コード")
    public void setHdt市町村コード(RString hdt市町村コード) {
        this.hdt市町村コード = hdt市町村コード;
    }

    /*
     * gethdt状態
     * @return hdt状態
     */
    @JsonProperty("hdt状態")
    public RString getHdt状態() {
        return hdt状態;
    }

    /*
     * sethdt状態
     * @param hdt状態 hdt状態
     */
    @JsonProperty("hdt状態")
    public void setHdt状態(RString hdt状態) {
        this.hdt状態 = hdt状態;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getChosainShimei() {
        return this.getChosaItakuKensaku().getChosainShimei();
    }

    @JsonIgnore
    public void setChosainShimei(TextBox chosainShimei) {
        this.getChosaItakuKensaku().setChosainShimei(chosainShimei);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaNameMatchType() {
        return this.getChosaItakuKensaku().getDdlHihokenshaNameMatchType();
    }

    @JsonIgnore
    public void setDdlHihokenshaNameMatchType(DropDownList ddlHihokenshaNameMatchType) {
        this.getChosaItakuKensaku().setDdlHihokenshaNameMatchType(ddlHihokenshaNameMatchType);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKensakuNendo() {
        return this.getChosaItakuKensaku().getTxtKensakuNendo();
    }

    @JsonIgnore
    public void setTxtKensakuNendo(TextBoxDateRange txtKensakuNendo) {
        this.getChosaItakuKensaku().setTxtKensakuNendo(txtKensakuNendo);
    }

    @JsonIgnore
    public TextBoxNum getTextBoxNum() {
        return this.getChosaItakuKensaku().getTextBoxNum();
    }

    @JsonIgnore
    public void setTextBoxNum(TextBoxNum TextBoxNum) {
        this.getChosaItakuKensaku().setTextBoxNum(TextBoxNum);
    }

    @JsonIgnore
    public Button getBtnKyufuJissekiSearchClear() {
        return this.getChosaItakuKensaku().getBtnKyufuJissekiSearchClear();
    }

    @JsonIgnore
    public void setBtnKyufuJissekiSearchClear(Button btnKyufuJissekiSearchClear) {
        this.getChosaItakuKensaku().setBtnKyufuJissekiSearchClear(btnKyufuJissekiSearchClear);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getChosaItakuKensaku().getBtnKensaku();
    }

    @JsonIgnore
    public void setBtnKensaku(Button btnKensaku) {
        this.getChosaItakuKensaku().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getChosaItakuKensaku().getCcdHokenshaList();
    }

    @JsonIgnore
    public DataGrid<dgChosain_Row> getDgChosain() {
        return this.getChosain().getDgChosain();
    }

    @JsonIgnore
    public void setDgChosain(DataGrid<dgChosain_Row> dgChosain) {
        this.getChosain().setDgChosain(dgChosain);
    }

    @JsonIgnore
    public TextBoxCode getTxtItakusakiCode() {
        return this.getChosaJissekiJoho().getTxtItakusakiCode();
    }

    @JsonIgnore
    public void setTxtItakusakiCode(TextBoxCode txtItakusakiCode) {
        this.getChosaJissekiJoho().setTxtItakusakiCode(txtItakusakiCode);
    }

    @JsonIgnore
    public TextBox getTxtItakusakiName() {
        return this.getChosaJissekiJoho().getTxtItakusakiName();
    }

    @JsonIgnore
    public void setTxtItakusakiName(TextBox txtItakusakiName) {
        this.getChosaJissekiJoho().setTxtItakusakiName(txtItakusakiName);
    }

    @JsonIgnore
    public TextBoxCode getTxtChousaInCode() {
        return this.getChosaJissekiJoho().getTxtChousaInCode();
    }

    @JsonIgnore
    public void setTxtChousaInCode(TextBoxCode txtChousaInCode) {
        this.getChosaJissekiJoho().setTxtChousaInCode(txtChousaInCode);
    }

    @JsonIgnore
    public TextBox getTxtChousainName() {
        return this.getChosaJissekiJoho().getTxtChousainName();
    }

    @JsonIgnore
    public void setTxtChousainName(TextBox txtChousainName) {
        this.getChosaJissekiJoho().setTxtChousainName(txtChousainName);
    }

    @JsonIgnore
    public DataGrid<dgShinsakaiIin_Row> getDgShinsakaiIin() {
        return this.getChosaJissekiJoho().getDgShinsakaiIin();
    }

    @JsonIgnore
    public void setDgShinsakaiIin(DataGrid<dgShinsakaiIin_Row> dgShinsakaiIin) {
        this.getChosaJissekiJoho().setDgShinsakaiIin(dgShinsakaiIin);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseibi() {
        return this.getShinseiJohoMeisai().getTxtShinseibi();
    }

    @JsonIgnore
    public void setTxtShinseibi(TextBoxFlexibleDate txtShinseibi) {
        this.getShinseiJohoMeisai().setTxtShinseibi(txtShinseibi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiChosaIraiNengappi() {
        return this.getShinseiJohoMeisai().getTxtNinteiChosaIraiNengappi();
    }

    @JsonIgnore
    public void setTxtNinteiChosaIraiNengappi(TextBoxFlexibleDate txtNinteiChosaIraiNengappi) {
        this.getShinseiJohoMeisai().setTxtNinteiChosaIraiNengappi(txtNinteiChosaIraiNengappi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiChosaJisshiNengappi() {
        return this.getShinseiJohoMeisai().getTxtNinteiChosaJisshiNengappi();
    }

    @JsonIgnore
    public void setTxtNinteiChosaJisshiNengappi(TextBoxFlexibleDate txtNinteiChosaJisshiNengappi) {
        this.getShinseiJohoMeisai().setTxtNinteiChosaJisshiNengappi(txtNinteiChosaJisshiNengappi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiJuryoNengappi() {
        return this.getShinseiJohoMeisai().getTxtNinteiJuryoNengappi();
    }

    @JsonIgnore
    public void setTxtNinteiJuryoNengappi(TextBoxFlexibleDate txtNinteiJuryoNengappi) {
        this.getShinseiJohoMeisai().setTxtNinteiJuryoNengappi(txtNinteiJuryoNengappi);
    }

    @JsonIgnore
    public TextBox getTxtHomonShurui() {
        return this.getShinseiJohoMeisai().getTxtHomonShurui();
    }

    @JsonIgnore
    public void setTxtHomonShurui(TextBox txtHomonShurui) {
        this.getShinseiJohoMeisai().setTxtHomonShurui(txtHomonShurui);
    }

    @JsonIgnore
    public TextBox getTxtShiharaiMemo() {
        return this.getShinseiJohoMeisai().getTxtShiharaiMemo();
    }

    @JsonIgnore
    public void setTxtShiharaiMemo(TextBox txtShiharaiMemo) {
        this.getShinseiJohoMeisai().setTxtShiharaiMemo(txtShiharaiMemo);
    }

    @JsonIgnore
    public TextBoxNum getTxtNinteiChosaItakuryo() {
        return this.getShinseiJohoMeisai().getTxtNinteiChosaItakuryo();
    }

    @JsonIgnore
    public void setTxtNinteiChosaItakuryo(TextBoxNum txtNinteiChosaItakuryo) {
        this.getShinseiJohoMeisai().setTxtNinteiChosaItakuryo(txtNinteiChosaItakuryo);
    }

    @JsonIgnore
    public RadioButton getRadGinkoFurikomi() {
        return this.getShinseiJohoMeisai().getRadGinkoFurikomi();
    }

    @JsonIgnore
    public void setRadGinkoFurikomi(RadioButton radGinkoFurikomi) {
        this.getShinseiJohoMeisai().setRadGinkoFurikomi(radGinkoFurikomi);
    }

    @JsonIgnore
    public Button getBtnToroku() {
        return this.getShinseiJohoMeisai().getBtnToroku();
    }

    @JsonIgnore
    public void setBtnToroku(Button btnToroku) {
        this.getShinseiJohoMeisai().setBtnToroku(btnToroku);
    }

    @JsonIgnore
    public Button getBtnNyuryokuToriyameru() {
        return this.getShinseiJohoMeisai().getBtnNyuryokuToriyameru();
    }

    @JsonIgnore
    public void setBtnNyuryokuToriyameru(Button btnNyuryokuToriyameru) {
        this.getShinseiJohoMeisai().setBtnNyuryokuToriyameru(btnNyuryokuToriyameru);
    }

    @JsonIgnore
    public ChosaItakusakiAndChosainInputDiv getCcdChosaItakusakiAndChosainInput() {
        return this.getShinseiJohoMeisai().getCcdChosaItakusakiAndChosainInput();
    }

    // </editor-fold>
}
