package jp.co.ndensan.reams.db.dbd.divcontroller.entity.futanGendogakuNintei;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 26 11:58:12 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgFutanGendogakuNinteiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgFutanGendogakuNinteiList_Row extends DataRow {

    private TextBoxFlexibleDate shinseiDate;
    private TextBoxFlexibleDate ketteiDate;
    private RString ketteiKubun;
    private TextBoxFlexibleDate tekiyoDate;
    private TextBoxFlexibleDate yukoKigen;
    private RString shinseiRiyu;
    private RString fushoninRiyu;
    private RString futanDankai;
    private RString kyushochisha;
    private RString kyoshitsuType;
    private RString kyokaiso;
    private RString gekihenKanwa;
    private TextBoxNum shokuhi;
    private TextBoxNum unitKoshitsu;
    private TextBoxNum unitJunKoshitsu;
    private TextBoxNum tashoshitsu;
    private TextBoxNum juraigataKoshitsuTokuyo;
    private TextBoxNum juraigataKoshitsuRoken;

    public dgFutanGendogakuNinteiList_Row() {
        super();
        this.shinseiDate = new TextBoxFlexibleDate();
        this.ketteiDate = new TextBoxFlexibleDate();
        this.ketteiKubun = RString.EMPTY;
        this.tekiyoDate = new TextBoxFlexibleDate();
        this.yukoKigen = new TextBoxFlexibleDate();
        this.shinseiRiyu = RString.EMPTY;
        this.fushoninRiyu = RString.EMPTY;
        this.futanDankai = RString.EMPTY;
        this.kyushochisha = RString.EMPTY;
        this.kyoshitsuType = RString.EMPTY;
        this.kyokaiso = RString.EMPTY;
        this.gekihenKanwa = RString.EMPTY;
        this.shokuhi = new TextBoxNum();
        this.unitKoshitsu = new TextBoxNum();
        this.unitJunKoshitsu = new TextBoxNum();
        this.tashoshitsu = new TextBoxNum();
        this.juraigataKoshitsuTokuyo = new TextBoxNum();
        this.juraigataKoshitsuRoken = new TextBoxNum();
    }

    public dgFutanGendogakuNinteiList_Row(TextBoxFlexibleDate shinseiDate, TextBoxFlexibleDate ketteiDate, RString ketteiKubun, TextBoxFlexibleDate tekiyoDate, TextBoxFlexibleDate yukoKigen, RString shinseiRiyu, RString fushoninRiyu, RString futanDankai, RString kyushochisha, RString kyoshitsuType, RString kyokaiso, RString gekihenKanwa, TextBoxNum shokuhi, TextBoxNum unitKoshitsu, TextBoxNum unitJunKoshitsu, TextBoxNum tashoshitsu, TextBoxNum juraigataKoshitsuTokuyo, TextBoxNum juraigataKoshitsuRoken) {
        super();
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("ketteiDate", ketteiDate);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.setOriginalData("shinseiRiyu", shinseiRiyu);
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
        this.setOriginalData("futanDankai", futanDankai);
        this.setOriginalData("kyushochisha", kyushochisha);
        this.setOriginalData("kyoshitsuType", kyoshitsuType);
        this.setOriginalData("kyokaiso", kyokaiso);
        this.setOriginalData("gekihenKanwa", gekihenKanwa);
        this.setOriginalData("shokuhi", shokuhi);
        this.setOriginalData("unitKoshitsu", unitKoshitsu);
        this.setOriginalData("unitJunKoshitsu", unitJunKoshitsu);
        this.setOriginalData("tashoshitsu", tashoshitsu);
        this.setOriginalData("juraigataKoshitsuTokuyo", juraigataKoshitsuTokuyo);
        this.setOriginalData("juraigataKoshitsuRoken", juraigataKoshitsuRoken);
        this.shinseiDate = shinseiDate;
        this.ketteiDate = ketteiDate;
        this.ketteiKubun = ketteiKubun;
        this.tekiyoDate = tekiyoDate;
        this.yukoKigen = yukoKigen;
        this.shinseiRiyu = shinseiRiyu;
        this.fushoninRiyu = fushoninRiyu;
        this.futanDankai = futanDankai;
        this.kyushochisha = kyushochisha;
        this.kyoshitsuType = kyoshitsuType;
        this.kyokaiso = kyokaiso;
        this.gekihenKanwa = gekihenKanwa;
        this.shokuhi = shokuhi;
        this.unitKoshitsu = unitKoshitsu;
        this.unitJunKoshitsu = unitJunKoshitsu;
        this.tashoshitsu = tashoshitsu;
        this.juraigataKoshitsuTokuyo = juraigataKoshitsuTokuyo;
        this.juraigataKoshitsuRoken = juraigataKoshitsuRoken;
    }

    public TextBoxFlexibleDate getShinseiDate() {
        return shinseiDate;
    }

    public TextBoxFlexibleDate getKetteiDate() {
        return ketteiDate;
    }

    public RString getKetteiKubun() {
        return ketteiKubun;
    }

    public TextBoxFlexibleDate getTekiyoDate() {
        return tekiyoDate;
    }

    public TextBoxFlexibleDate getYukoKigen() {
        return yukoKigen;
    }

    public RString getShinseiRiyu() {
        return shinseiRiyu;
    }

    public RString getFushoninRiyu() {
        return fushoninRiyu;
    }

    public RString getFutanDankai() {
        return futanDankai;
    }

    public RString getKyushochisha() {
        return kyushochisha;
    }

    public RString getKyoshitsuType() {
        return kyoshitsuType;
    }

    public RString getKyokaiso() {
        return kyokaiso;
    }

    public RString getGekihenKanwa() {
        return gekihenKanwa;
    }

    public TextBoxNum getShokuhi() {
        return shokuhi;
    }

    public TextBoxNum getUnitKoshitsu() {
        return unitKoshitsu;
    }

    public TextBoxNum getUnitJunKoshitsu() {
        return unitJunKoshitsu;
    }

    public TextBoxNum getTashoshitsu() {
        return tashoshitsu;
    }

    public TextBoxNum getJuraigataKoshitsuTokuyo() {
        return juraigataKoshitsuTokuyo;
    }

    public TextBoxNum getJuraigataKoshitsuRoken() {
        return juraigataKoshitsuRoken;
    }

    public void setShinseiDate(TextBoxFlexibleDate shinseiDate) {
        this.setOriginalData("shinseiDate", shinseiDate);
        this.shinseiDate = shinseiDate;
    }

    public void setKetteiDate(TextBoxFlexibleDate ketteiDate) {
        this.setOriginalData("ketteiDate", ketteiDate);
        this.ketteiDate = ketteiDate;
    }

    public void setKetteiKubun(RString ketteiKubun) {
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.ketteiKubun = ketteiKubun;
    }

    public void setTekiyoDate(TextBoxFlexibleDate tekiyoDate) {
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.tekiyoDate = tekiyoDate;
    }

    public void setYukoKigen(TextBoxFlexibleDate yukoKigen) {
        this.setOriginalData("yukoKigen", yukoKigen);
        this.yukoKigen = yukoKigen;
    }

    public void setShinseiRiyu(RString shinseiRiyu) {
        this.setOriginalData("shinseiRiyu", shinseiRiyu);
        this.shinseiRiyu = shinseiRiyu;
    }

    public void setFushoninRiyu(RString fushoninRiyu) {
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
        this.fushoninRiyu = fushoninRiyu;
    }

    public void setFutanDankai(RString futanDankai) {
        this.setOriginalData("futanDankai", futanDankai);
        this.futanDankai = futanDankai;
    }

    public void setKyushochisha(RString kyushochisha) {
        this.setOriginalData("kyushochisha", kyushochisha);
        this.kyushochisha = kyushochisha;
    }

    public void setKyoshitsuType(RString kyoshitsuType) {
        this.setOriginalData("kyoshitsuType", kyoshitsuType);
        this.kyoshitsuType = kyoshitsuType;
    }

    public void setKyokaiso(RString kyokaiso) {
        this.setOriginalData("kyokaiso", kyokaiso);
        this.kyokaiso = kyokaiso;
    }

    public void setGekihenKanwa(RString gekihenKanwa) {
        this.setOriginalData("gekihenKanwa", gekihenKanwa);
        this.gekihenKanwa = gekihenKanwa;
    }

    public void setShokuhi(TextBoxNum shokuhi) {
        this.setOriginalData("shokuhi", shokuhi);
        this.shokuhi = shokuhi;
    }

    public void setUnitKoshitsu(TextBoxNum unitKoshitsu) {
        this.setOriginalData("unitKoshitsu", unitKoshitsu);
        this.unitKoshitsu = unitKoshitsu;
    }

    public void setUnitJunKoshitsu(TextBoxNum unitJunKoshitsu) {
        this.setOriginalData("unitJunKoshitsu", unitJunKoshitsu);
        this.unitJunKoshitsu = unitJunKoshitsu;
    }

    public void setTashoshitsu(TextBoxNum tashoshitsu) {
        this.setOriginalData("tashoshitsu", tashoshitsu);
        this.tashoshitsu = tashoshitsu;
    }

    public void setJuraigataKoshitsuTokuyo(TextBoxNum juraigataKoshitsuTokuyo) {
        this.setOriginalData("juraigataKoshitsuTokuyo", juraigataKoshitsuTokuyo);
        this.juraigataKoshitsuTokuyo = juraigataKoshitsuTokuyo;
    }

    public void setJuraigataKoshitsuRoken(TextBoxNum juraigataKoshitsuRoken) {
        this.setOriginalData("juraigataKoshitsuRoken", juraigataKoshitsuRoken);
        this.juraigataKoshitsuRoken = juraigataKoshitsuRoken;
    }

}