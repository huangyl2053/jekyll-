package jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 13 17:19:32 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgHomonkaigoRiyoshaFutangakuGengakuList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHomonkaigoRiyoshaFutangakuGengakuList_Row extends DataRow {

    private TextBoxFlexibleDate shinseiDate;
    private RString shinseiRiyu;
    private TextBoxFlexibleDate tekiyoDate;
    private TextBoxFlexibleDate yukoKigen;
    private RString ketteiKubun;
    private TextBoxFlexibleDate ketteiDate;
    private RString fushoninRiyu;
    private RString hobetsuKubun;
    private TextBoxNum kyufuRitsu;
    private RString kohiFutanshaNo;
    private RString kohiJukyushaNo;
    private Boolean hasShogaishaTecho;
    private RString shogaishaTechoTokyu;
    private RString shogaishaTechoNo;

    public dgHomonkaigoRiyoshaFutangakuGengakuList_Row() {
        super();
        this.shinseiDate = new TextBoxFlexibleDate();
        this.shinseiRiyu = RString.EMPTY;
        this.tekiyoDate = new TextBoxFlexibleDate();
        this.yukoKigen = new TextBoxFlexibleDate();
        this.ketteiKubun = RString.EMPTY;
        this.ketteiDate = new TextBoxFlexibleDate();
        this.fushoninRiyu = RString.EMPTY;
        this.hobetsuKubun = RString.EMPTY;
        this.kyufuRitsu = new TextBoxNum();
        this.kohiFutanshaNo = RString.EMPTY;
        this.kohiJukyushaNo = RString.EMPTY;
        this.hasShogaishaTecho = false;
        this.shogaishaTechoTokyu = RString.EMPTY;
        this.shogaishaTechoNo = RString.EMPTY;
    }

    public dgHomonkaigoRiyoshaFutangakuGengakuList_Row(TextBoxFlexibleDate shinseiDate, RString shinseiRiyu, TextBoxFlexibleDate tekiyoDate, TextBoxFlexibleDate yukoKigen, RString ketteiKubun, TextBoxFlexibleDate ketteiDate, RString fushoninRiyu, RString hobetsuKubun, TextBoxNum kyufuRitsu, RString kohiFutanshaNo, RString kohiJukyushaNo, Boolean hasShogaishaTecho, RString shogaishaTechoTokyu, RString shogaishaTechoNo) {
        super();
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("shinseiRiyu", shinseiRiyu);
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("ketteiDate", ketteiDate);
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
        this.setOriginalData("hobetsuKubun", hobetsuKubun);
        this.setOriginalData("kyufuRitsu", kyufuRitsu);
        this.setOriginalData("kohiFutanshaNo", kohiFutanshaNo);
        this.setOriginalData("kohiJukyushaNo", kohiJukyushaNo);
        this.setOriginalData("hasShogaishaTecho", hasShogaishaTecho);
        this.setOriginalData("shogaishaTechoTokyu", shogaishaTechoTokyu);
        this.setOriginalData("shogaishaTechoNo", shogaishaTechoNo);
        this.shinseiDate = shinseiDate;
        this.shinseiRiyu = shinseiRiyu;
        this.tekiyoDate = tekiyoDate;
        this.yukoKigen = yukoKigen;
        this.ketteiKubun = ketteiKubun;
        this.ketteiDate = ketteiDate;
        this.fushoninRiyu = fushoninRiyu;
        this.hobetsuKubun = hobetsuKubun;
        this.kyufuRitsu = kyufuRitsu;
        this.kohiFutanshaNo = kohiFutanshaNo;
        this.kohiJukyushaNo = kohiJukyushaNo;
        this.hasShogaishaTecho = hasShogaishaTecho;
        this.shogaishaTechoTokyu = shogaishaTechoTokyu;
        this.shogaishaTechoNo = shogaishaTechoNo;
    }

    public TextBoxFlexibleDate getShinseiDate() {
        return shinseiDate;
    }

    public RString getShinseiRiyu() {
        return shinseiRiyu;
    }

    public TextBoxFlexibleDate getTekiyoDate() {
        return tekiyoDate;
    }

    public TextBoxFlexibleDate getYukoKigen() {
        return yukoKigen;
    }

    public RString getKetteiKubun() {
        return ketteiKubun;
    }

    public TextBoxFlexibleDate getKetteiDate() {
        return ketteiDate;
    }

    public RString getFushoninRiyu() {
        return fushoninRiyu;
    }

    public RString getHobetsuKubun() {
        return hobetsuKubun;
    }

    public TextBoxNum getKyufuRitsu() {
        return kyufuRitsu;
    }

    public RString getKohiFutanshaNo() {
        return kohiFutanshaNo;
    }

    public RString getKohiJukyushaNo() {
        return kohiJukyushaNo;
    }

    public Boolean getHasShogaishaTecho() {
        return hasShogaishaTecho;
    }

    public RString getShogaishaTechoTokyu() {
        return shogaishaTechoTokyu;
    }

    public RString getShogaishaTechoNo() {
        return shogaishaTechoNo;
    }

    public void setShinseiDate(TextBoxFlexibleDate shinseiDate) {
        this.setOriginalData("shinseiDate", shinseiDate);
        this.shinseiDate = shinseiDate;
    }

    public void setShinseiRiyu(RString shinseiRiyu) {
        this.setOriginalData("shinseiRiyu", shinseiRiyu);
        this.shinseiRiyu = shinseiRiyu;
    }

    public void setTekiyoDate(TextBoxFlexibleDate tekiyoDate) {
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.tekiyoDate = tekiyoDate;
    }

    public void setYukoKigen(TextBoxFlexibleDate yukoKigen) {
        this.setOriginalData("yukoKigen", yukoKigen);
        this.yukoKigen = yukoKigen;
    }

    public void setKetteiKubun(RString ketteiKubun) {
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.ketteiKubun = ketteiKubun;
    }

    public void setKetteiDate(TextBoxFlexibleDate ketteiDate) {
        this.setOriginalData("ketteiDate", ketteiDate);
        this.ketteiDate = ketteiDate;
    }

    public void setFushoninRiyu(RString fushoninRiyu) {
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
        this.fushoninRiyu = fushoninRiyu;
    }

    public void setHobetsuKubun(RString hobetsuKubun) {
        this.setOriginalData("hobetsuKubun", hobetsuKubun);
        this.hobetsuKubun = hobetsuKubun;
    }

    public void setKyufuRitsu(TextBoxNum kyufuRitsu) {
        this.setOriginalData("kyufuRitsu", kyufuRitsu);
        this.kyufuRitsu = kyufuRitsu;
    }

    public void setKohiFutanshaNo(RString kohiFutanshaNo) {
        this.setOriginalData("kohiFutanshaNo", kohiFutanshaNo);
        this.kohiFutanshaNo = kohiFutanshaNo;
    }

    public void setKohiJukyushaNo(RString kohiJukyushaNo) {
        this.setOriginalData("kohiJukyushaNo", kohiJukyushaNo);
        this.kohiJukyushaNo = kohiJukyushaNo;
    }

    public void setHasShogaishaTecho(Boolean hasShogaishaTecho) {
        this.setOriginalData("hasShogaishaTecho", hasShogaishaTecho);
        this.hasShogaishaTecho = hasShogaishaTecho;
    }

    public void setShogaishaTechoTokyu(RString shogaishaTechoTokyu) {
        this.setOriginalData("shogaishaTechoTokyu", shogaishaTechoTokyu);
        this.shogaishaTechoTokyu = shogaishaTechoTokyu;
    }

    public void setShogaishaTechoNo(RString shogaishaTechoNo) {
        this.setOriginalData("shogaishaTechoNo", shogaishaTechoNo);
        this.shogaishaTechoNo = shogaishaTechoNo;
    }

}