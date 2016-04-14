package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("hihokenshabango")
    private hihokenshabangoDiv hihokenshabango;
    @JsonProperty("ccdKanryoMessage")
    private KanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("shoriMode")
    private RString shoriMode;
    @JsonProperty("gamenMode")
    private RString gamenMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gethihokenshabango
     * @return hihokenshabango
     */
    @JsonProperty("hihokenshabango")
    public hihokenshabangoDiv getHihokenshabango() {
        return hihokenshabango;
    }

    /*
     * sethihokenshabango
     * @param hihokenshabango hihokenshabango
     */
    @JsonProperty("hihokenshabango")
    public void setHihokenshabango(hihokenshabangoDiv hihokenshabango) {
        this.hihokenshabango = hihokenshabango;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * getshoriMode
     * @return shoriMode
     */
    @JsonProperty("shoriMode")
    public RString getShoriMode() {
        return shoriMode;
    }

    /*
     * setshoriMode
     * @param shoriMode shoriMode
     */
    @JsonProperty("shoriMode")
    public void setShoriMode(RString shoriMode) {
        this.shoriMode = shoriMode;
    }

    /*
     * getgamenMode
     * @return gamenMode
     */
    @JsonProperty("gamenMode")
    public RString getGamenMode() {
        return gamenMode;
    }

    /*
     * setgamenMode
     * @param gamenMode gamenMode
     */
    @JsonProperty("gamenMode")
    public void setGamenMode(RString gamenMode) {
        this.gamenMode = gamenMode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnYoshikiyon() {
        return this.getHihokenshabango().getBtnYoshikiyon();
    }

    @JsonIgnore
    public void  setBtnYoshikiyon(Button btnYoshikiyon) {
        this.getHihokenshabango().setBtnYoshikiyon(btnYoshikiyon);
    }

    @JsonIgnore
    public Button getBtnYoshikiyonnoni() {
        return this.getHihokenshabango().getBtnYoshikiyonnoni();
    }

    @JsonIgnore
    public void  setBtnYoshikiyonnoni(Button btnYoshikiyonnoni) {
        this.getHihokenshabango().setBtnYoshikiyonnoni(btnYoshikiyonnoni);
    }

    @JsonIgnore
    public Button getBntYoskiyonosan() {
        return this.getHihokenshabango().getBntYoskiyonosan();
    }

    @JsonIgnore
    public void  setBntYoskiyonosan(Button bntYoskiyonosan) {
        this.getHihokenshabango().setBntYoskiyonosan(bntYoskiyonosan);
    }

    @JsonIgnore
    public YoshikiyonMeisaiDiv getYoshikiyonMeisai() {
        return this.getHihokenshabango().getYoshikiyonMeisai();
    }

    @JsonIgnore
    public void  setYoshikiyonMeisai(YoshikiyonMeisaiDiv YoshikiyonMeisai) {
        this.getHihokenshabango().setYoshikiyonMeisai(YoshikiyonMeisai);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxthokokuYM() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM();
    }

    @JsonIgnore
    public void  setTxthokokuYM(TextBoxFlexibleDate txthokokuYM) {
        this.getHihokenshabango().getYoshikiyonMeisai().setTxthokokuYM(txthokokuYM);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShukeiYM() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTxtShukeiYM();
    }

    @JsonIgnore
    public void  setTxtShukeiYM(TextBoxFlexibleDate txtShukeiYM) {
        this.getHihokenshabango().getYoshikiyonMeisai().setTxtShukeiYM(txtShukeiYM);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshabango() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTxtHihokenshabango();
    }

    @JsonIgnore
    public void  setTxtHihokenshabango(TextBoxCode txtHihokenshabango) {
        this.getHihokenshabango().getYoshikiyonMeisai().setTxtHihokenshabango(txtHihokenshabango);
    }

    @JsonIgnore
    public TextBox getTxthihokenshamei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTxthihokenshamei();
    }

    @JsonIgnore
    public void  setTxthihokenshamei(TextBox txthihokenshamei) {
        this.getHihokenshabango().getYoshikiyonMeisai().setTxthihokenshamei(txthihokenshamei);
    }

    @JsonIgnore
    public DropDownList getDdlShicyoson() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getDdlShicyoson();
    }

    @JsonIgnore
    public void  setDdlShicyoson(DropDownList ddlShicyoson) {
        this.getHihokenshabango().getYoshikiyonMeisai().setDdlShicyoson(ddlShicyoson);
    }

    @JsonIgnore
    public Button getBtnHoukokuNenKT() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getBtnHoukokuNenKT();
    }

    @JsonIgnore
    public void  setBtnHoukokuNenKT(Button btnHoukokuNenKT) {
        this.getHihokenshabango().getYoshikiyonMeisai().setBtnHoukokuNenKT(btnHoukokuNenKT);
    }

    @JsonIgnore
    public tblTokukaikeijokyoDiv getTblTokukaikeijokyo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo();
    }

    @JsonIgnore
    public void  setTblTokukaikeijokyo(tblTokukaikeijokyoDiv tblTokukaikeijokyo) {
        this.getHihokenshabango().getYoshikiyonMeisai().setTblTokukaikeijokyo(tblTokukaikeijokyo);
    }

    @JsonIgnore
    public Label getLblsainyu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsainyu();
    }

    @JsonIgnore
    public Label getLblsaishutsu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsaishutsu();
    }

    @JsonIgnore
    public Label getLblkamoku() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkamoku();
    }

    @JsonIgnore
    public Label getLblsainyukessan() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsainyukessan();
    }

    @JsonIgnore
    public Label getLblsaishutsukamoku() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsaishutsukamoku();
    }

    @JsonIgnore
    public Label getLblsaishutsukessan() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsaishutsukessan();
    }

    @JsonIgnore
    public Label getLblhokenryo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblhokenryo();
    }

    @JsonIgnore
    public Label getLblkaigohokenryo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkaigohokenryo();
    }

    @JsonIgnore
    public TextBoxNum getTxthokenryo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxthokenryo();
    }

    @JsonIgnore
    public Label getLblsaishutsusomu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsaishutsusomu();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaishutsusomu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtsaishutsusomu();
    }

    @JsonIgnore
    public Label getLblfuntan() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblfuntan();
    }

    @JsonIgnore
    public Label getLblfuntannintei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblfuntannintei();
    }

    @JsonIgnore
    public TextBoxNum getTxtnintei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtnintei();
    }

    @JsonIgnore
    public Label getLblsaishutsuhokenkyufu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsaishutsuhokenkyufu();
    }

    @JsonIgnore
    public Label getLblsabisunadoshohi() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsabisunadoshohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtlsabisunadoshohi() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtlsabisunadoshohi();
    }

    @JsonIgnore
    public Label getLblfuntansonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblfuntansonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtfuntansonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtfuntansonota();
    }

    @JsonIgnore
    public Label getLblyobonadoshohi() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblyobonadoshohi();
    }

    @JsonIgnore
    public TextBoxNum getTxtyobonadoshohi() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtyobonadoshohi();
    }

    @JsonIgnore
    public Label getLblshiyooyobitesu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshiyooyobitesu();
    }

    @JsonIgnore
    public Label getLblshiyooy() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshiyooy();
    }

    @JsonIgnore
    public TextBoxNum getTxtshiyoo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtshiyoo();
    }

    @JsonIgnore
    public Label getLblkogakukaigo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkogakukaigo();
    }

    @JsonIgnore
    public TextBoxNum getTxtkogakukaigo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkogakukaigo();
    }

    @JsonIgnore
    public Label getLbltesu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbltesu();
    }

    @JsonIgnore
    public TextBoxNum getTxttesu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxttesu();
    }

    @JsonIgnore
    public Label getLblkogakuiryo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkogakuiryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtlkogakuiryo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtlkogakuiryo();
    }

    @JsonIgnore
    public Label getLblkokko() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkokko();
    }

    @JsonIgnore
    public Label getLblkyufu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkyufu();
    }

    @JsonIgnore
    public TextBoxNum getTxtkyufu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkyufu();
    }

    @JsonIgnore
    public Label getLbltokuteinyusho() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbltokuteinyusho();
    }

    @JsonIgnore
    public TextBoxNum getTxttokuteinyusho() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxttokuteinyusho();
    }

    @JsonIgnore
    public Label getLblchosei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchosei();
    }

    @JsonIgnore
    public TextBoxNum getTxtchosei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtchosei();
    }

    @JsonIgnore
    public Label getLblshinsashiharai() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshinsashiharai();
    }

    @JsonIgnore
    public TextBoxNum getTxtshinsashiharai() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtshinsashiharai();
    }

    @JsonIgnore
    public Label getLblkaigoyobo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkaigoyobo();
    }

    @JsonIgnore
    public TextBoxNum getTxtkaigoyobo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkaigoyobo();
    }

    @JsonIgnore
    public Label getLblshichosontokubetsukyufu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshichosontokubetsukyufu();
    }

    @JsonIgnore
    public TextBoxNum getTxtshichosontokubetsukyufu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtshichosontokubetsukyufu();
    }

    @JsonIgnore
    public Label getLblhokatsu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblhokatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxthokatsu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxthokatsu();
    }

    @JsonIgnore
    public Label getLblkyusonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkyusonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtkyusonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkyusonota();
    }

    @JsonIgnore
    public Label getLblkokkosonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkokkosonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtkokkosonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkokkosonota();
    }

    @JsonIgnore
    public Label getLblchiikishien() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikishien();
    }

    @JsonIgnore
    public Label getLblchiikikaigoyobo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikikaigoyobo();
    }

    @JsonIgnore
    public TextBoxNum getTxtchiikikaigoyobo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtchiikikaigoyobo();
    }

    @JsonIgnore
    public Label getLblshiharaikikin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshiharaikikin();
    }

    @JsonIgnore
    public Label getLblkyufukofukin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkyufukofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtkyufukofukin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkyufukofukin();
    }

    @JsonIgnore
    public Label getLblchiikihokatsujigyo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikihokatsujigyo();
    }

    @JsonIgnore
    public TextBoxNum getTxtchiikihokatsujigyo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtchiikihokatsujigyo();
    }

    @JsonIgnore
    public Label getLblchiikishienkofukin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikishienkofukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtchiikishienkofukin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtchiikishienkofukin();
    }

    @JsonIgnore
    public Label getLblzaisanantei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblzaisanantei();
    }

    @JsonIgnore
    public TextBoxNum getTxtzaisanantei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtzaisanantei();
    }

    @JsonIgnore
    public Label getLbltodofukenshishutsu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbltodofukenshishutsu();
    }

    @JsonIgnore
    public Label getLbltodofukenfutankin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbltodofukenfutankin();
    }

    @JsonIgnore
    public TextBoxNum getTxttodofukenfutankin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxttodofukenfutankin();
    }

    @JsonIgnore
    public Label getLblkokkozaisan() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkokkozaisan();
    }

    @JsonIgnore
    public TextBoxNum getTxtkokkozaisan() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkokkozaisan();
    }

    @JsonIgnore
    public Label getLblzaiseiantei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblzaiseiantei();
    }

    @JsonIgnore
    public TextBoxNum getTxtzaiseiantei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtzaiseiantei();
    }

    @JsonIgnore
    public Label getLblhokenfukushi() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblhokenfukushi();
    }

    @JsonIgnore
    public TextBoxNum getTxthokenfukushi() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxthokenfukushi();
    }

    @JsonIgnore
    public Label getLblchiikishienyobo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikishienyobo();
    }

    @JsonIgnore
    public TextBoxNum getTxtchiikishienyobo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtchiikishienyobo();
    }

    @JsonIgnore
    public Label getLblkikin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtkikin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkikin();
    }

    @JsonIgnore
    public Label getLblchiikishienhokatsu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikishienhokatsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtchiikishienhokatsu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtchiikishienhokatsu();
    }

    @JsonIgnore
    public Label getLblkosai() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkosai();
    }

    @JsonIgnore
    public Label getLblkosaizaisanantei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkosaizaisanantei();
    }

    @JsonIgnore
    public TextBoxNum getTxtv() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtv();
    }

    @JsonIgnore
    public Label getLbltiikisonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbltiikisonota();
    }

    @JsonIgnore
    public TextBoxNum getTxttodofukensonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxttodofukensonota();
    }

    @JsonIgnore
    public Label getLblkosaikosaisonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkosaikosaisonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtkosaikosaisonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkosaikosaisonota();
    }

    @JsonIgnore
    public Label getLblsogo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsogo();
    }

    @JsonIgnore
    public TextBoxNum getTxtzaisanshunyu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtzaisanshunyu();
    }

    @JsonIgnore
    public Label getLblyobihi() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblyobihi();
    }

    @JsonIgnore
    public TextBoxNum getTxtyobihi() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtyobihi();
    }

    @JsonIgnore
    public Label getLblzaisanshunyu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblzaisanshunyu();
    }

    @JsonIgnore
    public TextBoxNum getTxtzaisanshuny() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtzaisanshuny();
    }

    @JsonIgnore
    public Label getLblshoshishutsu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshoshishutsu();
    }

    @JsonIgnore
    public Label getLblkaigosabisukanjo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkaigosabisukanjo();
    }

    @JsonIgnore
    public TextBoxNum getTxtkaigosabisukanjo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkaigosabisukanjo();
    }

    @JsonIgnore
    public Label getLblkifukin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkifukin();
    }

    @JsonIgnore
    public TextBoxNum getTxtkifukin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkifukin();
    }

    @JsonIgnore
    public Label getLbltakaikei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbltakaikei();
    }

    @JsonIgnore
    public TextBoxNum getTxttakaikei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxttakaikei();
    }

    @JsonIgnore
    public Label getLblkurinyukin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkurinyukin();
    }

    @JsonIgnore
    public Label getLblippankaikei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblippankaikei();
    }

    @JsonIgnore
    public TextBoxNum getTxtippankaikei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtippankaikei();
    }

    @JsonIgnore
    public Label getLblshoshishutsusonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshoshishutsusonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtshoshishutsusonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtshoshishutsusonota();
    }

    @JsonIgnore
    public Label getLblsomuhi() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsomuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtsomuhi() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtsomuhi();
    }

    @JsonIgnore
    public Label getLbljumbikikin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbljumbikikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtjumbikikin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtjumbikikin();
    }

    @JsonIgnore
    public Label getLblchiikishienkaigoyobo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikishienkaigoyobo();
    }

    @JsonIgnore
    public TextBoxNum getTxtchiikishienkaigoyobo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtchiikishienkaigoyobo();
    }

    @JsonIgnore
    public Label getLbltiikikaigoyobo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLbltiikikaigoyobo();
    }

    @JsonIgnore
    public TextBoxNum getTxttiikikaigoyobo() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxttiikikaigoyobo();
    }

    @JsonIgnore
    public Label getLblchiikishienni() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblchiikishienni();
    }

    @JsonIgnore
    public TextBoxNum getTxtkurichiikishienhokatsu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkurichiikishienhokatsu();
    }

    @JsonIgnore
    public Label getLblkurinyukinkokkosonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkurinyukinkokkosonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtkurinyukinsonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkurinyukinsonota();
    }

    @JsonIgnore
    public Label getLblkurikoshikin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblkurikoshikin();
    }

    @JsonIgnore
    public TextBoxNum getTxtkurikoshikin() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtkurikoshikin();
    }

    @JsonIgnore
    public Label getLblshichosonsai() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshichosonsai();
    }

    @JsonIgnore
    public Label getLblshichosonzaiseiantei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshichosonzaiseiantei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaizaiseiantei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtsaizaiseiantei();
    }

    @JsonIgnore
    public Label getLblshichosonkokkosonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshichosonkokkosonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaisonota() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtsaisonota();
    }

    @JsonIgnore
    public Label getLblshoshunyu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblshoshunyu();
    }

    @JsonIgnore
    public TextBoxNum getTxtshoshunyu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtshoshunyu();
    }

    @JsonIgnore
    public Label getLblsainyugokei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsainyugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainyugokei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtsainyugokei();
    }

    @JsonIgnore
    public Label getLblsaishutsugoukei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getLblsaishutsugoukei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsaishutsugoukei() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTblTokukaikeijokyo().getTxtsaishutsugoukei();
    }

    @JsonIgnore
    public TextBoxNum getTxtsainyushutsusa() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTxtsainyushutsusa();
    }

    @JsonIgnore
    public void  setTxtsainyushutsusa(TextBoxNum txtsainyushutsusa) {
        this.getHihokenshabango().getYoshikiyonMeisai().setTxtsainyushutsusa(txtsainyushutsusa);
    }

    @JsonIgnore
    public TextBoxNum getTxtuchikikinkurigaku() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTxtuchikikinkurigaku();
    }

    @JsonIgnore
    public void  setTxtuchikikinkurigaku(TextBoxNum txtuchikikinkurigaku) {
        this.getHihokenshabango().getYoshikiyonMeisai().setTxtuchikikinkurigaku(txtuchikikinkurigaku);
    }

    @JsonIgnore
    public tabkaigokyufuhijunhoyuDiv getTabkaigokyufuhijunhoyu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTabkaigokyufuhijunhoyu();
    }

    @JsonIgnore
    public void  setTabkaigokyufuhijunhoyu(tabkaigokyufuhijunhoyuDiv tabkaigokyufuhijunhoyu) {
        this.getHihokenshabango().getYoshikiyonMeisai().setTabkaigokyufuhijunhoyu(tabkaigokyufuhijunhoyu);
    }

    @JsonIgnore
    public Label getLblkaigokyufuhijunhoyu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTabkaigokyufuhijunhoyu().getLblkaigokyufuhijunhoyu();
    }

    @JsonIgnore
    public TextBoxNum getTxtkaigokyufuhijunhoyu() {
        return this.getHihokenshabango().getYoshikiyonMeisai().getTabkaigokyufuhijunhoyu().getTxtkaigokyufuhijunhoyu();
    }

    // </editor-fold>
}
