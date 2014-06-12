package jp.co.ndensan.reams.db.dbd.divcontroller.entity.riyoshaFutangakuGemmen;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 12 15:59:23 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgRiyoshaFutangakuGemmenList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgRiyoshaFutangakuGemmenList_Row extends DataRow {

    private TextBoxFlexibleDate shinseiDate;
    private TextBoxFlexibleDate tekiyoKaishiDate;
    private TextBoxFlexibleDate yukoKigen;
    private RString ketteiKubun;
    private TextBoxFlexibleDate ketteiDate;
    private RString kyufuRitsu;
    private RString fushoninRiyu;

    public dgRiyoshaFutangakuGemmenList_Row() {
        super();
        this.shinseiDate = new TextBoxFlexibleDate();
        this.tekiyoKaishiDate = new TextBoxFlexibleDate();
        this.yukoKigen = new TextBoxFlexibleDate();
        this.ketteiKubun = RString.EMPTY;
        this.ketteiDate = new TextBoxFlexibleDate();
        this.kyufuRitsu = RString.EMPTY;
        this.fushoninRiyu = RString.EMPTY;
    }

    public dgRiyoshaFutangakuGemmenList_Row(TextBoxFlexibleDate shinseiDate, TextBoxFlexibleDate tekiyoKaishiDate, TextBoxFlexibleDate yukoKigen, RString ketteiKubun, TextBoxFlexibleDate ketteiDate, RString kyufuRitsu, RString fushoninRiyu) {
        super();
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("tekiyoKaishiDate", tekiyoKaishiDate);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("ketteiDate", ketteiDate);
        this.setOriginalData("kyufuRitsu", kyufuRitsu);
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
        this.shinseiDate = shinseiDate;
        this.tekiyoKaishiDate = tekiyoKaishiDate;
        this.yukoKigen = yukoKigen;
        this.ketteiKubun = ketteiKubun;
        this.ketteiDate = ketteiDate;
        this.kyufuRitsu = kyufuRitsu;
        this.fushoninRiyu = fushoninRiyu;
    }

    public TextBoxFlexibleDate getShinseiDate() {
        return shinseiDate;
    }

    public TextBoxFlexibleDate getTekiyoKaishiDate() {
        return tekiyoKaishiDate;
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

    public RString getKyufuRitsu() {
        return kyufuRitsu;
    }

    public RString getFushoninRiyu() {
        return fushoninRiyu;
    }

    public void setShinseiDate(TextBoxFlexibleDate shinseiDate) {
        this.setOriginalData("shinseiDate", shinseiDate);
        this.shinseiDate = shinseiDate;
    }

    public void setTekiyoKaishiDate(TextBoxFlexibleDate tekiyoKaishiDate) {
        this.setOriginalData("tekiyoKaishiDate", tekiyoKaishiDate);
        this.tekiyoKaishiDate = tekiyoKaishiDate;
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

    public void setKyufuRitsu(RString kyufuRitsu) {
        this.setOriginalData("kyufuRitsu", kyufuRitsu);
        this.kyufuRitsu = kyufuRitsu;
    }

    public void setFushoninRiyu(RString fushoninRiyu) {
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
        this.fushoninRiyu = fushoninRiyu;
    }

}