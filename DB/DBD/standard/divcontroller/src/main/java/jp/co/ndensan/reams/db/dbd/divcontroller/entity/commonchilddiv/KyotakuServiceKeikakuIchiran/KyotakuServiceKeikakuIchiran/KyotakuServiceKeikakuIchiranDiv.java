package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiran;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyotakuServiceKeikakuIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuServiceKeikakuIchiranDiv extends Panel implements IKyotakuServiceKeikakuIchiranDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKyotakuServiceKeikakuIchiranMain")
    private dgKyotakuServiceKeikakuIchiranMainDiv dgKyotakuServiceKeikakuIchiranMain;
    @JsonProperty("DvJohoSelect")
    private DvJohoSelectDiv DvJohoSelect;
    @JsonProperty("DvKeikakuIraiUketsuke")
    private DvKeikakuIraiUketsukeDiv DvKeikakuIraiUketsuke;
    @JsonProperty("DvJikoSakuseiKeikaku")
    private DvJikoSakuseiKeikakuDiv DvJikoSakuseiKeikaku;
    @JsonProperty("DvKyotakuService")
    private DvKyotakuServiceDiv DvKyotakuService;
    @JsonProperty("DvKyotakuMeisai")
    private DvKyotakuMeisaiDiv DvKyotakuMeisai;
    @JsonProperty("DvShuruiGendoKakunin")
    private DvShuruiGendoKakuninDiv DvShuruiGendoKakunin;
    @JsonProperty("hiddenHihokenshaNo")
    private RString hiddenHihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKyotakuServiceKeikakuIchiranMain
     * @return dgKyotakuServiceKeikakuIchiranMain
     */
    @JsonProperty("dgKyotakuServiceKeikakuIchiranMain")
    public dgKyotakuServiceKeikakuIchiranMainDiv getDgKyotakuServiceKeikakuIchiranMain() {
        return dgKyotakuServiceKeikakuIchiranMain;
    }

    /*
     * setdgKyotakuServiceKeikakuIchiranMain
     * @param dgKyotakuServiceKeikakuIchiranMain dgKyotakuServiceKeikakuIchiranMain
     */
    @JsonProperty("dgKyotakuServiceKeikakuIchiranMain")
    public void setDgKyotakuServiceKeikakuIchiranMain(dgKyotakuServiceKeikakuIchiranMainDiv dgKyotakuServiceKeikakuIchiranMain) {
        this.dgKyotakuServiceKeikakuIchiranMain = dgKyotakuServiceKeikakuIchiranMain;
    }

    /*
     * getDvJohoSelect
     * @return DvJohoSelect
     */
    @JsonProperty("DvJohoSelect")
    public DvJohoSelectDiv getDvJohoSelect() {
        return DvJohoSelect;
    }

    /*
     * setDvJohoSelect
     * @param DvJohoSelect DvJohoSelect
     */
    @JsonProperty("DvJohoSelect")
    public void setDvJohoSelect(DvJohoSelectDiv DvJohoSelect) {
        this.DvJohoSelect = DvJohoSelect;
    }

    /*
     * getDvKeikakuIraiUketsuke
     * @return DvKeikakuIraiUketsuke
     */
    @JsonProperty("DvKeikakuIraiUketsuke")
    public DvKeikakuIraiUketsukeDiv getDvKeikakuIraiUketsuke() {
        return DvKeikakuIraiUketsuke;
    }

    /*
     * setDvKeikakuIraiUketsuke
     * @param DvKeikakuIraiUketsuke DvKeikakuIraiUketsuke
     */
    @JsonProperty("DvKeikakuIraiUketsuke")
    public void setDvKeikakuIraiUketsuke(DvKeikakuIraiUketsukeDiv DvKeikakuIraiUketsuke) {
        this.DvKeikakuIraiUketsuke = DvKeikakuIraiUketsuke;
    }

    /*
     * getDvJikoSakuseiKeikaku
     * @return DvJikoSakuseiKeikaku
     */
    @JsonProperty("DvJikoSakuseiKeikaku")
    public DvJikoSakuseiKeikakuDiv getDvJikoSakuseiKeikaku() {
        return DvJikoSakuseiKeikaku;
    }

    /*
     * setDvJikoSakuseiKeikaku
     * @param DvJikoSakuseiKeikaku DvJikoSakuseiKeikaku
     */
    @JsonProperty("DvJikoSakuseiKeikaku")
    public void setDvJikoSakuseiKeikaku(DvJikoSakuseiKeikakuDiv DvJikoSakuseiKeikaku) {
        this.DvJikoSakuseiKeikaku = DvJikoSakuseiKeikaku;
    }

    /*
     * getDvKyotakuService
     * @return DvKyotakuService
     */
    @JsonProperty("DvKyotakuService")
    public DvKyotakuServiceDiv getDvKyotakuService() {
        return DvKyotakuService;
    }

    /*
     * setDvKyotakuService
     * @param DvKyotakuService DvKyotakuService
     */
    @JsonProperty("DvKyotakuService")
    public void setDvKyotakuService(DvKyotakuServiceDiv DvKyotakuService) {
        this.DvKyotakuService = DvKyotakuService;
    }

    /*
     * getDvKyotakuMeisai
     * @return DvKyotakuMeisai
     */
    @JsonProperty("DvKyotakuMeisai")
    public DvKyotakuMeisaiDiv getDvKyotakuMeisai() {
        return DvKyotakuMeisai;
    }

    /*
     * setDvKyotakuMeisai
     * @param DvKyotakuMeisai DvKyotakuMeisai
     */
    @JsonProperty("DvKyotakuMeisai")
    public void setDvKyotakuMeisai(DvKyotakuMeisaiDiv DvKyotakuMeisai) {
        this.DvKyotakuMeisai = DvKyotakuMeisai;
    }

    /*
     * getDvShuruiGendoKakunin
     * @return DvShuruiGendoKakunin
     */
    @JsonProperty("DvShuruiGendoKakunin")
    public DvShuruiGendoKakuninDiv getDvShuruiGendoKakunin() {
        return DvShuruiGendoKakunin;
    }

    /*
     * setDvShuruiGendoKakunin
     * @param DvShuruiGendoKakunin DvShuruiGendoKakunin
     */
    @JsonProperty("DvShuruiGendoKakunin")
    public void setDvShuruiGendoKakunin(DvShuruiGendoKakuninDiv DvShuruiGendoKakunin) {
        this.DvShuruiGendoKakunin = DvShuruiGendoKakunin;
    }

    /*
     * gethiddenHihokenshaNo
     * @return hiddenHihokenshaNo
     */
    @JsonProperty("hiddenHihokenshaNo")
    public RString getHiddenHihokenshaNo() {
        return hiddenHihokenshaNo;
    }

    /*
     * sethiddenHihokenshaNo
     * @param hiddenHihokenshaNo hiddenHihokenshaNo
     */
    @JsonProperty("hiddenHihokenshaNo")
    public void setHiddenHihokenshaNo(RString hiddenHihokenshaNo) {
        this.hiddenHihokenshaNo = hiddenHihokenshaNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgKyotakuServiceKeikakuIchiran_Row> getDgKyotakuServiceKeikakuIchiran() {
        return this.getDgKyotakuServiceKeikakuIchiranMain().getDgKyotakuServiceKeikakuIchiran();
    }

    @JsonIgnore
    public void  setDgKyotakuServiceKeikakuIchiran(DataGrid<dgKyotakuServiceKeikakuIchiran_Row> dgKyotakuServiceKeikakuIchiran) {
        this.getDgKyotakuServiceKeikakuIchiranMain().setDgKyotakuServiceKeikakuIchiran(dgKyotakuServiceKeikakuIchiran);
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getDgKyotakuServiceKeikakuIchiranMain().getBtnClose();
    }

    @JsonIgnore
    public void  setBtnClose(Button btnClose) {
        this.getDgKyotakuServiceKeikakuIchiranMain().setBtnClose(btnClose);
    }

    @JsonIgnore
    public Button getBtnKeikakuIraiUketsuke() {
        return this.getDvJohoSelect().getBtnKeikakuIraiUketsuke();
    }

    @JsonIgnore
    public void  setBtnKeikakuIraiUketsuke(Button btnKeikakuIraiUketsuke) {
        this.getDvJohoSelect().setBtnKeikakuIraiUketsuke(btnKeikakuIraiUketsuke);
    }

    @JsonIgnore
    public Button getBtnJikosakuseiKeikaku() {
        return this.getDvJohoSelect().getBtnJikosakuseiKeikaku();
    }

    @JsonIgnore
    public void  setBtnJikosakuseiKeikaku(Button btnJikosakuseiKeikaku) {
        this.getDvJohoSelect().setBtnJikosakuseiKeikaku(btnJikosakuseiKeikaku);
    }

    @JsonIgnore
    public Button getBtnKyotakuService() {
        return this.getDvJohoSelect().getBtnKyotakuService();
    }

    @JsonIgnore
    public void  setBtnKyotakuService(Button btnKyotakuService) {
        this.getDvJohoSelect().setBtnKyotakuService(btnKyotakuService);
    }

    @JsonIgnore
    public TextBox getTxtYokaigodo() {
        return this.getDvJikoSakuseiKeikaku().getNinteiJoho().getTxtYokaigodo();
    }

    @JsonIgnore
    public void  setTxtYokaigodo(TextBox txtYokaigodo) {
        this.getDvJikoSakuseiKeikaku().getNinteiJoho().setTxtYokaigodo(txtYokaigodo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiYukokikan() {
        return this.getDvJikoSakuseiKeikaku().getNinteiJoho().getTxtNinteiYukokikan();
    }

    @JsonIgnore
    public void  setTxtNinteiYukokikan(TextBoxDateRange txtNinteiYukokikan) {
        this.getDvJikoSakuseiKeikaku().getNinteiJoho().setTxtNinteiYukokikan(txtNinteiYukokikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuGendoGaku() {
        return this.getDvKyotakuService().getTxtShikyuGendoGaku();
    }

    @JsonIgnore
    public void  setTxtShikyuGendoGaku(TextBoxNum txtShikyuGendoGaku) {
        this.getDvKyotakuService().setTxtShikyuGendoGaku(txtShikyuGendoGaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtGendoKanriKikan() {
        return this.getDvKyotakuService().getTxtGendoKanriKikan();
    }

    @JsonIgnore
    public void  setTxtGendoKanriKikan(TextBoxDateRange txtGendoKanriKikan) {
        this.getDvKyotakuService().setTxtGendoKanriKikan(txtGendoKanriKikan);
    }

    @JsonIgnore
    public tankiNyushoRiyoNissuDiv getTankiNyushoRiyoNissu() {
        return this.getDvKyotakuService().getTankiNyushoRiyoNissu();
    }

    @JsonIgnore
    public void  setTankiNyushoRiyoNissu(tankiNyushoRiyoNissuDiv tankiNyushoRiyoNissu) {
        this.getDvKyotakuService().setTankiNyushoRiyoNissu(tankiNyushoRiyoNissu);
    }

    @JsonIgnore
    public TextBoxNum getTxtZengetsuMadeRiyoNissu() {
        return this.getDvKyotakuService().getTankiNyushoRiyoNissu().getTxtZengetsuMadeRiyoNissu();
    }

    @JsonIgnore
    public void  setTxtZengetsuMadeRiyoNissu(TextBoxNum txtZengetsuMadeRiyoNissu) {
        this.getDvKyotakuService().getTankiNyushoRiyoNissu().setTxtZengetsuMadeRiyoNissu(txtZengetsuMadeRiyoNissu);
    }

    @JsonIgnore
    public TextBoxNum getTxtTogetsuKeikakuRiyoNissu() {
        return this.getDvKyotakuService().getTankiNyushoRiyoNissu().getTxtTogetsuKeikakuRiyoNissu();
    }

    @JsonIgnore
    public void  setTxtTogetsuKeikakuRiyoNissu(TextBoxNum txtTogetsuKeikakuRiyoNissu) {
        this.getDvKyotakuService().getTankiNyushoRiyoNissu().setTxtTogetsuKeikakuRiyoNissu(txtTogetsuKeikakuRiyoNissu);
    }

    @JsonIgnore
    public TextBoxNum getTxtRuisekiRiyoNissu() {
        return this.getDvKyotakuService().getTankiNyushoRiyoNissu().getTxtRuisekiRiyoNissu();
    }

    @JsonIgnore
    public void  setTxtRuisekiRiyoNissu(TextBoxNum txtRuisekiRiyoNissu) {
        this.getDvKyotakuService().getTankiNyushoRiyoNissu().setTxtRuisekiRiyoNissu(txtRuisekiRiyoNissu);
    }

    @JsonIgnore
    public Button getBtnShuruiGendoGakuKakunin() {
        return this.getDvKyotakuService().getBtnShuruiGendoGakuKakunin();
    }

    @JsonIgnore
    public void  setBtnShuruiGendoGakuKakunin(Button btnShuruiGendoGakuKakunin) {
        this.getDvKyotakuService().setBtnShuruiGendoGakuKakunin(btnShuruiGendoGakuKakunin);
    }

    @JsonIgnore
    public DataGrid<dgKyotakuService_Row> getDgKyotakuService() {
        return this.getDvKyotakuService().getDgKyotakuService();
    }

    @JsonIgnore
    public void  setDgKyotakuService(DataGrid<dgKyotakuService_Row> dgKyotakuService) {
        this.getDvKyotakuService().setDgKyotakuService(dgKyotakuService);
    }

    @JsonIgnore
    public Button getBtnKyotakuServiceClose() {
        return this.getDvKyotakuService().getBtnKyotakuServiceClose();
    }

    @JsonIgnore
    public void  setBtnKyotakuServiceClose(Button btnKyotakuServiceClose) {
        this.getDvKyotakuService().setBtnKyotakuServiceClose(btnKyotakuServiceClose);
    }

    @JsonIgnore
    public TextBoxCode getTxtKyotakuJigyoshaNo() {
        return this.getDvKyotakuMeisai().getTxtKyotakuJigyoshaNo();
    }

    @JsonIgnore
    public void  setTxtKyotakuJigyoshaNo(TextBoxCode txtKyotakuJigyoshaNo) {
        this.getDvKyotakuMeisai().setTxtKyotakuJigyoshaNo(txtKyotakuJigyoshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKyotakuJigyoshaName() {
        return this.getDvKyotakuMeisai().getTxtKyotakuJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtKyotakuJigyoshaName(TextBox txtKyotakuJigyoshaName) {
        this.getDvKyotakuMeisai().setTxtKyotakuJigyoshaName(txtKyotakuJigyoshaName);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCode1() {
        return this.getDvKyotakuMeisai().getTxtServiceCode1();
    }

    @JsonIgnore
    public void  setTxtServiceCode1(TextBoxCode txtServiceCode1) {
        this.getDvKyotakuMeisai().setTxtServiceCode1(txtServiceCode1);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCode2() {
        return this.getDvKyotakuMeisai().getTxtServiceCode2();
    }

    @JsonIgnore
    public void  setTxtServiceCode2(TextBoxCode txtServiceCode2) {
        this.getDvKyotakuMeisai().setTxtServiceCode2(txtServiceCode2);
    }

    @JsonIgnore
    public TextBox getTxtServiceName() {
        return this.getDvKyotakuMeisai().getTxtServiceName();
    }

    @JsonIgnore
    public void  setTxtServiceName(TextBox txtServiceName) {
        this.getDvKyotakuMeisai().setTxtServiceName(txtServiceName);
    }

    @JsonIgnore
    public TextBoxNum getTxtTani() {
        return this.getDvKyotakuMeisai().getTxtTani();
    }

    @JsonIgnore
    public void  setTxtTani(TextBoxNum txtTani) {
        this.getDvKyotakuMeisai().setTxtTani(txtTani);
    }

    @JsonIgnore
    public TextBoxNum getTxtWaribikiTekiyogoRitsu() {
        return this.getDvKyotakuMeisai().getTxtWaribikiTekiyogoRitsu();
    }

    @JsonIgnore
    public void  setTxtWaribikiTekiyogoRitsu(TextBoxNum txtWaribikiTekiyogoRitsu) {
        this.getDvKyotakuMeisai().setTxtWaribikiTekiyogoRitsu(txtWaribikiTekiyogoRitsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtWaribikiTekiyogoTani() {
        return this.getDvKyotakuMeisai().getTxtWaribikiTekiyogoTani();
    }

    @JsonIgnore
    public void  setTxtWaribikiTekiyogoTani(TextBoxNum txtWaribikiTekiyogoTani) {
        this.getDvKyotakuMeisai().setTxtWaribikiTekiyogoTani(txtWaribikiTekiyogoTani);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaisu() {
        return this.getDvKyotakuMeisai().getTxtKaisu();
    }

    @JsonIgnore
    public void  setTxtKaisu(TextBoxNum txtKaisu) {
        this.getDvKyotakuMeisai().setTxtKaisu(txtKaisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtServiceTani() {
        return this.getDvKyotakuMeisai().getTxtServiceTani();
    }

    @JsonIgnore
    public void  setTxtServiceTani(TextBoxNum txtServiceTani) {
        this.getDvKyotakuMeisai().setTxtServiceTani(txtServiceTani);
    }

    @JsonIgnore
    public HorizontalLine getLinLine3() {
        return this.getDvKyotakuMeisai().getLinLine3();
    }

    @JsonIgnore
    public void  setLinLine3(HorizontalLine linLine3) {
        this.getDvKyotakuMeisai().setLinLine3(linLine3);
    }

    @JsonIgnore
    public TextBoxNum getTxtShuruiGendoChokaTani() {
        return this.getDvKyotakuMeisai().getTxtShuruiGendoChokaTani();
    }

    @JsonIgnore
    public void  setTxtShuruiGendoChokaTani(TextBoxNum txtShuruiGendoChokaTani) {
        this.getDvKyotakuMeisai().setTxtShuruiGendoChokaTani(txtShuruiGendoChokaTani);
    }

    @JsonIgnore
    public TextBoxNum getTxtShuruiGendonaiTani() {
        return this.getDvKyotakuMeisai().getTxtShuruiGendonaiTani();
    }

    @JsonIgnore
    public void  setTxtShuruiGendonaiTani(TextBoxNum txtShuruiGendonaiTani) {
        this.getDvKyotakuMeisai().setTxtShuruiGendonaiTani(txtShuruiGendonaiTani);
    }

    @JsonIgnore
    public TextBoxNum getTxtTaniTanka() {
        return this.getDvKyotakuMeisai().getTxtTaniTanka();
    }

    @JsonIgnore
    public void  setTxtTaniTanka(TextBoxNum txtTaniTanka) {
        this.getDvKyotakuMeisai().setTxtTaniTanka(txtTaniTanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtKubunGendoChokaTani() {
        return this.getDvKyotakuMeisai().getTxtKubunGendoChokaTani();
    }

    @JsonIgnore
    public void  setTxtKubunGendoChokaTani(TextBoxNum txtKubunGendoChokaTani) {
        this.getDvKyotakuMeisai().setTxtKubunGendoChokaTani(txtKubunGendoChokaTani);
    }

    @JsonIgnore
    public TextBoxNum getTxtKubunGendonaiTani() {
        return this.getDvKyotakuMeisai().getTxtKubunGendonaiTani();
    }

    @JsonIgnore
    public void  setTxtKubunGendonaiTani(TextBoxNum txtKubunGendonaiTani) {
        this.getDvKyotakuMeisai().setTxtKubunGendonaiTani(txtKubunGendonaiTani);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuRitsu() {
        return this.getDvKyotakuMeisai().getTxtKyufuRitsu();
    }

    @JsonIgnore
    public void  setTxtKyufuRitsu(TextBoxNum txtKyufuRitsu) {
        this.getDvKyotakuMeisai().setTxtKyufuRitsu(txtKyufuRitsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHiyoSogaku() {
        return this.getDvKyotakuMeisai().getTxtHiyoSogaku();
    }

    @JsonIgnore
    public void  setTxtHiyoSogaku(TextBoxNum txtHiyoSogaku) {
        this.getDvKyotakuMeisai().setTxtHiyoSogaku(txtHiyoSogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenKyufuGaku() {
        return this.getDvKyotakuMeisai().getTxtHokenKyufuGaku();
    }

    @JsonIgnore
    public void  setTxtHokenKyufuGaku(TextBoxNum txtHokenKyufuGaku) {
        this.getDvKyotakuMeisai().setTxtHokenKyufuGaku(txtHokenKyufuGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenTaishoRiyoshaFutanGaku() {
        return this.getDvKyotakuMeisai().getTxtHokenTaishoRiyoshaFutanGaku();
    }

    @JsonIgnore
    public void  setTxtHokenTaishoRiyoshaFutanGaku(TextBoxNum txtHokenTaishoRiyoshaFutanGaku) {
        this.getDvKyotakuMeisai().setTxtHokenTaishoRiyoshaFutanGaku(txtHokenTaishoRiyoshaFutanGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtZengakuRiyoshaFutanngaku() {
        return this.getDvKyotakuMeisai().getTxtZengakuRiyoshaFutanngaku();
    }

    @JsonIgnore
    public void  setTxtZengakuRiyoshaFutanngaku(TextBoxNum txtZengakuRiyoshaFutanngaku) {
        this.getDvKyotakuMeisai().setTxtZengakuRiyoshaFutanngaku(txtZengakuRiyoshaFutanngaku);
    }

    @JsonIgnore
    public Button getBtnKyotakuServiceShosaiClose() {
        return this.getDvKyotakuMeisai().getBtnKyotakuServiceShosaiClose();
    }

    @JsonIgnore
    public void  setBtnKyotakuServiceShosaiClose(Button btnKyotakuServiceShosaiClose) {
        this.getDvKyotakuMeisai().setBtnKyotakuServiceShosaiClose(btnKyotakuServiceShosaiClose);
    }

    @JsonIgnore
    public DataGrid<dgShuruiGendoKakunin_Row> getDgShuruiGendoKakunin() {
        return this.getDvShuruiGendoKakunin().getDgShuruiGendoKakunin();
    }

    @JsonIgnore
    public void  setDgShuruiGendoKakunin(DataGrid<dgShuruiGendoKakunin_Row> dgShuruiGendoKakunin) {
        this.getDvShuruiGendoKakunin().setDgShuruiGendoKakunin(dgShuruiGendoKakunin);
    }

    @JsonIgnore
    public Button getBtnShuruiGendoGakuKakuninClose() {
        return this.getDvShuruiGendoKakunin().getBtnShuruiGendoGakuKakuninClose();
    }

    @JsonIgnore
    public void  setBtnShuruiGendoGakuKakuninClose(Button btnShuruiGendoGakuKakuninClose) {
        this.getDvShuruiGendoKakunin().setBtnShuruiGendoGakuKakuninClose(btnShuruiGendoGakuKakuninClose);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
