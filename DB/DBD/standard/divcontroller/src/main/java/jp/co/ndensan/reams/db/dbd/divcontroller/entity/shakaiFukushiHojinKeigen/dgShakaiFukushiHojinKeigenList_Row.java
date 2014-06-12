package jp.co.ndensan.reams.db.dbd.divcontroller.entity.shakaiFukushiHojinKeigen;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 12 16:02:12 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShakaiFukushiHojinKeigenList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShakaiFukushiHojinKeigenList_Row extends DataRow {

    private RString kakuninNo;
    private TextBoxFlexibleDate shinseiDate;
    private TextBoxFlexibleDate tekiyoDate;
    private TextBoxFlexibleDate yukoKigen;
    private RString ketteiKubun;
    private TextBoxFlexibleDate ketteiDate;
    private RString keigenRitsuBunshi;
    private RString keigenRitsuBunbo;
    private RString keigenRitsu;
    private RString keigenRiyu;
    private RString keigenTaishoServiceSeigen;

    public dgShakaiFukushiHojinKeigenList_Row() {
        super();
        this.kakuninNo = RString.EMPTY;
        this.shinseiDate = new TextBoxFlexibleDate();
        this.tekiyoDate = new TextBoxFlexibleDate();
        this.yukoKigen = new TextBoxFlexibleDate();
        this.ketteiKubun = RString.EMPTY;
        this.ketteiDate = new TextBoxFlexibleDate();
        this.keigenRitsuBunshi = RString.EMPTY;
        this.keigenRitsuBunbo = RString.EMPTY;
        this.keigenRitsu = RString.EMPTY;
        this.keigenRiyu = RString.EMPTY;
        this.keigenTaishoServiceSeigen = RString.EMPTY;
    }

    public dgShakaiFukushiHojinKeigenList_Row(RString kakuninNo, TextBoxFlexibleDate shinseiDate, TextBoxFlexibleDate tekiyoDate, TextBoxFlexibleDate yukoKigen, RString ketteiKubun, TextBoxFlexibleDate ketteiDate, RString keigenRitsuBunshi, RString keigenRitsuBunbo, RString keigenRitsu, RString keigenRiyu, RString keigenTaishoServiceSeigen) {
        super();
        this.setOriginalData("kakuninNo", kakuninNo);
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("ketteiDate", ketteiDate);
        this.setOriginalData("keigenRitsuBunshi", keigenRitsuBunshi);
        this.setOriginalData("keigenRitsuBunbo", keigenRitsuBunbo);
        this.setOriginalData("keigenRitsu", keigenRitsu);
        this.setOriginalData("keigenRiyu", keigenRiyu);
        this.setOriginalData("keigenTaishoServiceSeigen", keigenTaishoServiceSeigen);
        this.kakuninNo = kakuninNo;
        this.shinseiDate = shinseiDate;
        this.tekiyoDate = tekiyoDate;
        this.yukoKigen = yukoKigen;
        this.ketteiKubun = ketteiKubun;
        this.ketteiDate = ketteiDate;
        this.keigenRitsuBunshi = keigenRitsuBunshi;
        this.keigenRitsuBunbo = keigenRitsuBunbo;
        this.keigenRitsu = keigenRitsu;
        this.keigenRiyu = keigenRiyu;
        this.keigenTaishoServiceSeigen = keigenTaishoServiceSeigen;
    }

    public RString getKakuninNo() {
        return kakuninNo;
    }

    public TextBoxFlexibleDate getShinseiDate() {
        return shinseiDate;
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

    public RString getKeigenRitsuBunshi() {
        return keigenRitsuBunshi;
    }

    public RString getKeigenRitsuBunbo() {
        return keigenRitsuBunbo;
    }

    public RString getKeigenRitsu() {
        return keigenRitsu;
    }

    public RString getKeigenRiyu() {
        return keigenRiyu;
    }

    public RString getKeigenTaishoServiceSeigen() {
        return keigenTaishoServiceSeigen;
    }

    public void setKakuninNo(RString kakuninNo) {
        this.setOriginalData("kakuninNo", kakuninNo);
        this.kakuninNo = kakuninNo;
    }

    public void setShinseiDate(TextBoxFlexibleDate shinseiDate) {
        this.setOriginalData("shinseiDate", shinseiDate);
        this.shinseiDate = shinseiDate;
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

    public void setKeigenRitsuBunshi(RString keigenRitsuBunshi) {
        this.setOriginalData("keigenRitsuBunshi", keigenRitsuBunshi);
        this.keigenRitsuBunshi = keigenRitsuBunshi;
    }

    public void setKeigenRitsuBunbo(RString keigenRitsuBunbo) {
        this.setOriginalData("keigenRitsuBunbo", keigenRitsuBunbo);
        this.keigenRitsuBunbo = keigenRitsuBunbo;
    }

    public void setKeigenRitsu(RString keigenRitsu) {
        this.setOriginalData("keigenRitsu", keigenRitsu);
        this.keigenRitsu = keigenRitsu;
    }

    public void setKeigenRiyu(RString keigenRiyu) {
        this.setOriginalData("keigenRiyu", keigenRiyu);
        this.keigenRiyu = keigenRiyu;
    }

    public void setKeigenTaishoServiceSeigen(RString keigenTaishoServiceSeigen) {
        this.setOriginalData("keigenTaishoServiceSeigen", keigenTaishoServiceSeigen);
        this.keigenTaishoServiceSeigen = keigenTaishoServiceSeigen;
    }

}