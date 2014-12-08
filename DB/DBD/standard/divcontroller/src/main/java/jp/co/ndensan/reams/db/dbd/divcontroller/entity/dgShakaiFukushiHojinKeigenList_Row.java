package jp.co.ndensan.reams.db.dbd.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 16:50:00 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


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
    private TextBoxNum keigenRitsuBunshi;
    private TextBoxNum keigenRitsuBunbo;
    private RString keigenRitsu;
    private RString keigenJiyu;
    private RString kyotakuServiceOnly;
    private RString kyojuhiShokujiOnly;
    private RString unitPrivateRoomOnly;
    private RString fushoninRiyu;

    public dgShakaiFukushiHojinKeigenList_Row() {
        super();
        this.kakuninNo = RString.EMPTY;
        this.shinseiDate = new TextBoxFlexibleDate();
        this.tekiyoDate = new TextBoxFlexibleDate();
        this.yukoKigen = new TextBoxFlexibleDate();
        this.ketteiKubun = RString.EMPTY;
        this.ketteiDate = new TextBoxFlexibleDate();
        this.keigenRitsuBunshi = new TextBoxNum();
        this.keigenRitsuBunbo = new TextBoxNum();
        this.keigenRitsu = RString.EMPTY;
        this.keigenJiyu = RString.EMPTY;
        this.kyotakuServiceOnly = RString.EMPTY;
        this.kyojuhiShokujiOnly = RString.EMPTY;
        this.unitPrivateRoomOnly = RString.EMPTY;
        this.fushoninRiyu = RString.EMPTY;
    }

    public dgShakaiFukushiHojinKeigenList_Row(RString kakuninNo, TextBoxFlexibleDate shinseiDate, TextBoxFlexibleDate tekiyoDate, TextBoxFlexibleDate yukoKigen, RString ketteiKubun, TextBoxFlexibleDate ketteiDate, TextBoxNum keigenRitsuBunshi, TextBoxNum keigenRitsuBunbo, RString keigenRitsu, RString keigenJiyu, RString kyotakuServiceOnly, RString kyojuhiShokujiOnly, RString unitPrivateRoomOnly, RString fushoninRiyu) {
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
        this.setOriginalData("keigenJiyu", keigenJiyu);
        this.setOriginalData("kyotakuServiceOnly", kyotakuServiceOnly);
        this.setOriginalData("kyojuhiShokujiOnly", kyojuhiShokujiOnly);
        this.setOriginalData("unitPrivateRoomOnly", unitPrivateRoomOnly);
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
        this.kakuninNo = kakuninNo;
        this.shinseiDate = shinseiDate;
        this.tekiyoDate = tekiyoDate;
        this.yukoKigen = yukoKigen;
        this.ketteiKubun = ketteiKubun;
        this.ketteiDate = ketteiDate;
        this.keigenRitsuBunshi = keigenRitsuBunshi;
        this.keigenRitsuBunbo = keigenRitsuBunbo;
        this.keigenRitsu = keigenRitsu;
        this.keigenJiyu = keigenJiyu;
        this.kyotakuServiceOnly = kyotakuServiceOnly;
        this.kyojuhiShokujiOnly = kyojuhiShokujiOnly;
        this.unitPrivateRoomOnly = unitPrivateRoomOnly;
        this.fushoninRiyu = fushoninRiyu;
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

    public TextBoxNum getKeigenRitsuBunshi() {
        return keigenRitsuBunshi;
    }

    public TextBoxNum getKeigenRitsuBunbo() {
        return keigenRitsuBunbo;
    }

    public RString getKeigenRitsu() {
        return keigenRitsu;
    }

    public RString getKeigenJiyu() {
        return keigenJiyu;
    }

    public RString getKyotakuServiceOnly() {
        return kyotakuServiceOnly;
    }

    public RString getKyojuhiShokujiOnly() {
        return kyojuhiShokujiOnly;
    }

    public RString getUnitPrivateRoomOnly() {
        return unitPrivateRoomOnly;
    }

    public RString getFushoninRiyu() {
        return fushoninRiyu;
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

    public void setKeigenRitsuBunshi(TextBoxNum keigenRitsuBunshi) {
        this.setOriginalData("keigenRitsuBunshi", keigenRitsuBunshi);
        this.keigenRitsuBunshi = keigenRitsuBunshi;
    }

    public void setKeigenRitsuBunbo(TextBoxNum keigenRitsuBunbo) {
        this.setOriginalData("keigenRitsuBunbo", keigenRitsuBunbo);
        this.keigenRitsuBunbo = keigenRitsuBunbo;
    }

    public void setKeigenRitsu(RString keigenRitsu) {
        this.setOriginalData("keigenRitsu", keigenRitsu);
        this.keigenRitsu = keigenRitsu;
    }

    public void setKeigenJiyu(RString keigenJiyu) {
        this.setOriginalData("keigenJiyu", keigenJiyu);
        this.keigenJiyu = keigenJiyu;
    }

    public void setKyotakuServiceOnly(RString kyotakuServiceOnly) {
        this.setOriginalData("kyotakuServiceOnly", kyotakuServiceOnly);
        this.kyotakuServiceOnly = kyotakuServiceOnly;
    }

    public void setKyojuhiShokujiOnly(RString kyojuhiShokujiOnly) {
        this.setOriginalData("kyojuhiShokujiOnly", kyojuhiShokujiOnly);
        this.kyojuhiShokujiOnly = kyojuhiShokujiOnly;
    }

    public void setUnitPrivateRoomOnly(RString unitPrivateRoomOnly) {
        this.setOriginalData("unitPrivateRoomOnly", unitPrivateRoomOnly);
        this.unitPrivateRoomOnly = unitPrivateRoomOnly;
    }

    public void setFushoninRiyu(RString fushoninRiyu) {
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
        this.fushoninRiyu = fushoninRiyu;
    }

}