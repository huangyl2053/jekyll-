package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * hihokenshabango のクラスファイル 
 * 
 * @author 自動生成
 */
public class hihokenshabangoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnYoshikiyon")
    private Button btnYoshikiyon;
    @JsonProperty("btnYoshikiyonnoni")
    private Button btnYoshikiyonnoni;
    @JsonProperty("bntYoskiyonosan")
    private Button bntYoskiyonosan;
    @JsonProperty("YoshikiyonMeisai")
    private YoshikiyonMeisaiDiv YoshikiyonMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnYoshikiyon
     * @return btnYoshikiyon
     */
    @JsonProperty("btnYoshikiyon")
    public Button getBtnYoshikiyon() {
        return btnYoshikiyon;
    }

    /*
     * setbtnYoshikiyon
     * @param btnYoshikiyon btnYoshikiyon
     */
    @JsonProperty("btnYoshikiyon")
    public void setBtnYoshikiyon(Button btnYoshikiyon) {
        this.btnYoshikiyon = btnYoshikiyon;
    }

    /*
     * getbtnYoshikiyonnoni
     * @return btnYoshikiyonnoni
     */
    @JsonProperty("btnYoshikiyonnoni")
    public Button getBtnYoshikiyonnoni() {
        return btnYoshikiyonnoni;
    }

    /*
     * setbtnYoshikiyonnoni
     * @param btnYoshikiyonnoni btnYoshikiyonnoni
     */
    @JsonProperty("btnYoshikiyonnoni")
    public void setBtnYoshikiyonnoni(Button btnYoshikiyonnoni) {
        this.btnYoshikiyonnoni = btnYoshikiyonnoni;
    }

    /*
     * getbntYoskiyonosan
     * @return bntYoskiyonosan
     */
    @JsonProperty("bntYoskiyonosan")
    public Button getBntYoskiyonosan() {
        return bntYoskiyonosan;
    }

    /*
     * setbntYoskiyonosan
     * @param bntYoskiyonosan bntYoskiyonosan
     */
    @JsonProperty("bntYoskiyonosan")
    public void setBntYoskiyonosan(Button bntYoskiyonosan) {
        this.bntYoskiyonosan = bntYoskiyonosan;
    }

    /*
     * getYoshikiyonMeisai
     * @return YoshikiyonMeisai
     */
    @JsonProperty("YoshikiyonMeisai")
    public YoshikiyonMeisaiDiv getYoshikiyonMeisai() {
        return YoshikiyonMeisai;
    }

    /*
     * setYoshikiyonMeisai
     * @param YoshikiyonMeisai YoshikiyonMeisai
     */
    @JsonProperty("YoshikiyonMeisai")
    public void setYoshikiyonMeisai(YoshikiyonMeisaiDiv YoshikiyonMeisai) {
        this.YoshikiyonMeisai = YoshikiyonMeisai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxthokokuYM() {
        return this.getYoshikiyonMeisai().getTxthokokuYM();
    }

    @JsonIgnore
    public void  setTxthokokuYM(TextBoxFlexibleDate txthokokuYM) {
        this.getYoshikiyonMeisai().setTxthokokuYM(txthokokuYM);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM() {
        return this.getYoshikiyonMeisai().getTxtShukeiYM();
    }

    @JsonIgnore
    public void  setTxtShukeiYM(TextBoxFlexibleDate txtShukeiYM) {
        this.getYoshikiyonMeisai().setTxtShukeiYM(txtShukeiYM);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshabango() {
        return this.getYoshikiyonMeisai().getTxtHihokenshabango();
    }

    @JsonIgnore
    public void  setTxtHihokenshabango(TextBoxCode txtHihokenshabango) {
        this.getYoshikiyonMeisai().setTxtHihokenshabango(txtHihokenshabango);
    }

    @JsonIgnore
    public TextBox getTxthihokenshamei() {
        return this.getYoshikiyonMeisai().getTxthihokenshamei();
    }

    @JsonIgnore
    public void  setTxthihokenshamei(TextBox txthihokenshamei) {
        this.getYoshikiyonMeisai().setTxthihokenshamei(txthihokenshamei);
    }

    @JsonIgnore
    public DropDownList getDdlShicyoson() {
        return this.getYoshikiyonMeisai().getDdlShicyoson();
    }

    @JsonIgnore
    public void  setDdlShicyoson(DropDownList ddlShicyoson) {
        this.getYoshikiyonMeisai().setDdlShicyoson(ddlShicyoson);
    }

    @JsonIgnore
    public Button getBtnHoukokuNenKT() {
        return this.getYoshikiyonMeisai().getBtnHoukokuNenKT();
    }

    @JsonIgnore
    public void  setBtnHoukokuNenKT(Button btnHoukokuNenKT) {
        this.getYoshikiyonMeisai().setBtnHoukokuNenKT(btnHoukokuNenKT);
    }

    @JsonIgnore
    public tblTokukaikeijokyoDiv getTblTokukaikeijokyo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo();
    }

    @JsonIgnore
    public void  setTblTokukaikeijokyo(tblTokukaikeijokyoDiv tblTokukaikeijokyo) {
        this.getYoshikiyonMeisai().setTblTokukaikeijokyo(tblTokukaikeijokyo);
    }

    @JsonIgnore
    public Label getLblsainyu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsainyu();
    }

    @JsonIgnore
    public Label getLblsaishutsu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsaishutsu();
    }

    @JsonIgnore
    public Label getLblkamoku() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkamoku();
    }

    @JsonIgnore
    public Label getLblsainyukessan() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsainyukessan();
    }

    @JsonIgnore
    public Label getLblsaishutsukamoku() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsaishutsukamoku();
    }

    @JsonIgnore
    public Label getLblsaishutsukessan() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsaishutsukessan();
    }

    @JsonIgnore
    public Label getLblhokenryo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblhokenryo();
    }

    @JsonIgnore
    public Label getLblkaigohokenryo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkaigohokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxthokenryo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxthokenryo();
    }

    @JsonIgnore
    public Label getLblsaishutsusomu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsaishutsusomu();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaishutsusomu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtsaishutsusomu();
    }

    @JsonIgnore
    public Label getLblfuntan() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblfuntan();
    }

    @JsonIgnore
    public Label getLblfuntannintei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblfuntannintei();
    }

    @JsonIgnore
    public TextBoxNum getTxtnintei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtnintei();
    }

    @JsonIgnore
    public Label getLblsaishutsuhokenkyufu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsaishutsuhokenkyufu();
    }

    @JsonIgnore
    public Label getLblsabisunadoshohi() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsabisunadoshohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtlsabisunadoshohi() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtlsabisunadoshohi();
    }

    @JsonIgnore
    public Label getLblfuntansonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblfuntansonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtfuntansonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtfuntansonota();
    }

    @JsonIgnore
    public Label getLblyobonadoshohi() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblyobonadoshohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtyobonadoshohi() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtyobonadoshohi();
    }

    @JsonIgnore
    public Label getLblshiyooyobitesu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshiyooyobitesu();
    }

    @JsonIgnore
    public Label getLblshiyooy() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshiyooy();
    }

    @JsonIgnore
    public TextBoxNum getTxtshiyoo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtshiyoo();
    }

    @JsonIgnore
    public Label getLblkogakukaigo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkogakukaigo();
    }

    @JsonIgnore
    public TextBoxNum getTxtkogakukaigo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkogakukaigo();
    }

    @JsonIgnore
    public Label getLbltesu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbltesu();
    }

    @JsonIgnore
    public TextBoxNum getTxttesu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxttesu();
    }

    @JsonIgnore
    public Label getLblkogakuiryo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkogakuiryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtlkogakuiryo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtlkogakuiryo();
    }

    @JsonIgnore
    public Label getLblkokko() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkokko();
    }

    @JsonIgnore
    public Label getLblkyufu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkyufu();
    }

    @JsonIgnore
    public TextBoxNum getTxtkyufu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkyufu();
    }

    @JsonIgnore
    public Label getLbltokuteinyusho() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbltokuteinyusho();
    }

    @JsonIgnore
    public TextBoxNum getTxttokuteinyusho() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxttokuteinyusho();
    }

    @JsonIgnore
    public Label getLblchosei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchosei();
    }

    @JsonIgnore
    public TextBoxNum getTxtchosei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtchosei();
    }

    @JsonIgnore
    public Label getLblshinsashiharai() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshinsashiharai();
    }

    @JsonIgnore
    public TextBoxNum getTxtshinsashiharai() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtshinsashiharai();
    }

    @JsonIgnore
    public Label getLblkaigoyobo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkaigoyobo();
    }

    @JsonIgnore
    public TextBoxNum getTxtkaigoyobo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkaigoyobo();
    }

    @JsonIgnore
    public Label getLblshichosontokubetsukyufu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshichosontokubetsukyufu();
    }

    @JsonIgnore
    public TextBoxNum getTxtshichosontokubetsukyufu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtshichosontokubetsukyufu();
    }

    @JsonIgnore
    public Label getLblhokatsu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblhokatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxthokatsu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxthokatsu();
    }

    @JsonIgnore
    public Label getLblkyusonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkyusonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtkyusonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkyusonota();
    }

    @JsonIgnore
    public Label getLblkokkosonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkokkosonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtkokkosonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkokkosonota();
    }

    @JsonIgnore
    public Label getLblchiikishien() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikishien();
    }

    @JsonIgnore
    public Label getLblchiikikaigoyobo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikikaigoyobo();
    }

    @JsonIgnore
    public TextBoxNum getTxtchiikikaigoyobo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtchiikikaigoyobo();
    }

    @JsonIgnore
    public Label getLblshiharaikikin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshiharaikikin();
    }

    @JsonIgnore
    public Label getLblkyufukofukin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkyufukofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtkyufukofukin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkyufukofukin();
    }

    @JsonIgnore
    public Label getLblchiikihokatsujigyo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikihokatsujigyo();
    }

    @JsonIgnore
    public TextBoxNum getTxtchiikihokatsujigyo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtchiikihokatsujigyo();
    }

    @JsonIgnore
    public Label getLblchiikishienkofukin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtchiikishienkofukin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtchiikishienkofukin();
    }

    @JsonIgnore
    public Label getLblzaisanantei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblzaisanantei();
    }

    @JsonIgnore
    public TextBoxNum getTxtzaisanantei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtzaisanantei();
    }

    @JsonIgnore
    public Label getLbltodofukenshishutsu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbltodofukenshishutsu();
    }

    @JsonIgnore
    public Label getLbltodofukenfutankin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbltodofukenfutankin();
    }

    @JsonIgnore
    public TextBoxNum getTxttodofukenfutankin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxttodofukenfutankin();
    }

    @JsonIgnore
    public Label getLblkokkozaisan() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkokkozaisan();
    }

    @JsonIgnore
    public TextBoxNum getTxtkokkozaisan() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkokkozaisan();
    }

    @JsonIgnore
    public Label getLblzaiseiantei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblzaiseiantei();
    }

    @JsonIgnore
    public TextBoxNum getTxtzaiseiantei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtzaiseiantei();
    }

    @JsonIgnore
    public Label getLblhokenfukushi() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblhokenfukushi();
    }

    @JsonIgnore
    public TextBoxNum getTxthokenfukushi() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxthokenfukushi();
    }

    @JsonIgnore
    public Label getLblchiikishienyobo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikishienyobo();
    }

    @JsonIgnore
    public TextBoxNum getTxtchiikishienyobo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtchiikishienyobo();
    }

    @JsonIgnore
    public Label getLblkikin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtkikin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkikin();
    }

    @JsonIgnore
    public Label getLblchiikishienhokatsu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikishienhokatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtchiikishienhokatsu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtchiikishienhokatsu();
    }

    @JsonIgnore
    public Label getLblkosai() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkosai();
    }

    @JsonIgnore
    public Label getLblkosaizaisanantei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkosaizaisanantei();
    }

    @JsonIgnore
    public TextBoxNum getTxtv() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtv();
    }

    @JsonIgnore
    public Label getLbltiikisonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbltiikisonota();
    }

    @JsonIgnore
    public TextBoxNum getTxttodofukensonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxttodofukensonota();
    }

    @JsonIgnore
    public Label getLblkosaikosaisonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkosaikosaisonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtkosaikosaisonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkosaikosaisonota();
    }

    @JsonIgnore
    public Label getLblsogo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsogo();
    }

    @JsonIgnore
    public TextBoxNum getTxtzaisanshunyu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtzaisanshunyu();
    }

    @JsonIgnore
    public Label getLblyobihi() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblyobihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtyobihi() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtyobihi();
    }

    @JsonIgnore
    public Label getLblzaisanshunyu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblzaisanshunyu();
    }

    @JsonIgnore
    public TextBoxNum getTxtzaisanshuny() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtzaisanshuny();
    }

    @JsonIgnore
    public Label getLblshoshishutsu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshoshishutsu();
    }

    @JsonIgnore
    public Label getLblkaigosabisukanjo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkaigosabisukanjo();
    }

    @JsonIgnore
    public TextBoxNum getTxtkaigosabisukanjo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkaigosabisukanjo();
    }

    @JsonIgnore
    public Label getLblkifukin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtkifukin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkifukin();
    }

    @JsonIgnore
    public Label getLbltakaikei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbltakaikei();
    }

    @JsonIgnore
    public TextBoxNum getTxttakaikei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxttakaikei();
    }

    @JsonIgnore
    public Label getLblkurinyukin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkurinyukin();
    }

    @JsonIgnore
    public Label getLblippankaikei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblippankaikei();
    }

    @JsonIgnore
    public TextBoxNum getTxtippankaikei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtippankaikei();
    }

    @JsonIgnore
    public Label getLblshoshishutsusonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshoshishutsusonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtshoshishutsusonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtshoshishutsusonota();
    }

    @JsonIgnore
    public Label getLblsomuhi() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsomuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtsomuhi() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtsomuhi();
    }

    @JsonIgnore
    public Label getLbljumbikikin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbljumbikikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtjumbikikin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtjumbikikin();
    }

    @JsonIgnore
    public Label getLblchiikishienkaigoyobo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikishienkaigoyobo();
    }

    @JsonIgnore
    public TextBoxNum getTxtchiikishienkaigoyobo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtchiikishienkaigoyobo();
    }

    @JsonIgnore
    public Label getLbltiikikaigoyobo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbltiikikaigoyobo();
    }

    @JsonIgnore
    public TextBoxNum getTxttiikikaigoyobo() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxttiikikaigoyobo();
    }

    @JsonIgnore
    public Label getLblchiikishienni() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikishienni();
    }

    @JsonIgnore
    public TextBoxNum getTxtkurichiikishienhokatsu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkurichiikishienhokatsu();
    }

    @JsonIgnore
    public Label getLblkurinyukinkokkosonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkurinyukinkokkosonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtkurinyukinsonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkurinyukinsonota();
    }

    @JsonIgnore
    public Label getLblkurikoshikin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkurikoshikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtkurikoshikin() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkurikoshikin();
    }

    @JsonIgnore
    public Label getLblshichosonsai() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshichosonsai();
    }

    @JsonIgnore
    public Label getLblshichosonzaiseiantei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshichosonzaiseiantei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaizaiseiantei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtsaizaiseiantei();
    }

    @JsonIgnore
    public Label getLblshichosonkokkosonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshichosonkokkosonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaisonota() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtsaisonota();
    }

    @JsonIgnore
    public Label getLblshoshunyu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshoshunyu();
    }

    @JsonIgnore
    public TextBoxNum getTxtshoshunyu() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtshoshunyu();
    }

    @JsonIgnore
    public Label getLblsainyugokei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsainyugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainyugokei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtsainyugokei();
    }

    @JsonIgnore
    public Label getLblsaishutsugoukei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsaishutsugoukei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaishutsugoukei() {
        return this.getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtsaishutsugoukei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainyushutsusa() {
        return this.getYoshikiyonMeisai().getTxtsainyushutsusa();
    }

    @JsonIgnore
    public void  setTxtsainyushutsusa(TextBoxNum txtsainyushutsusa) {
        this.getYoshikiyonMeisai().setTxtsainyushutsusa(txtsainyushutsusa);
    }

    @JsonIgnore
    public TextBoxNum getTxtuchikikinkurigaku() {
        return this.getYoshikiyonMeisai().getTxtuchikikinkurigaku();
    }

    @JsonIgnore
    public void  setTxtuchikikinkurigaku(TextBoxNum txtuchikikinkurigaku) {
        this.getYoshikiyonMeisai().setTxtuchikikinkurigaku(txtuchikikinkurigaku);
    }

    @JsonIgnore
    public tabkaigokyufuhijunhoyuDiv getTabkaigokyufuhijunhoyu() {
        return this.getYoshikiyonMeisai().getTabkaigokyufuhijunhoyu();
    }

    @JsonIgnore
    public void  setTabkaigokyufuhijunhoyu(tabkaigokyufuhijunhoyuDiv tabkaigokyufuhijunhoyu) {
        this.getYoshikiyonMeisai().setTabkaigokyufuhijunhoyu(tabkaigokyufuhijunhoyu);
    }

    @JsonIgnore
    public Label getLblkaigokyufuhijunhoyu() {
        return this.getYoshikiyonMeisai().getTabkaigokyufuhijunhoyu().getLblkaigokyufuhijunhoyu();
    }

    @JsonIgnore
    public TextBoxNum getTxtkaigokyufuhijunhoyu() {
        return this.getYoshikiyonMeisai().getTabkaigokyufuhijunhoyu().getTxtkaigokyufuhijunhoyu();
    }

    // </editor-fold>
}
