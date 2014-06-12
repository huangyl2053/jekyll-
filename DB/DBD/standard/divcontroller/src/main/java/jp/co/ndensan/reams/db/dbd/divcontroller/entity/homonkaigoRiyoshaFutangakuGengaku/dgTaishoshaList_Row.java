package jp.co.ndensan.reams.db.dbd.divcontroller.entity.homonkaigoRiyoshaFutangakuGengaku;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 12 16:20:13 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgTaishoshaList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTaishoshaList_Row extends DataRow {

    private TextBoxFlexibleDate shinseiDate;
    private TextBoxFlexibleDate tekiyoDate;
    private TextBoxFlexibleDate yukoKigen;
    private RString ketteiKubun;
    private TextBoxFlexibleDate ketteiDate;
    private RString hobetsuKubun;
    private RString kyufuRitsu;
    private RString kohiJukyushaNo;
    private RString shogaishaTechoNo;

    public dgTaishoshaList_Row() {
        super();
        this.shinseiDate = new TextBoxFlexibleDate();
        this.tekiyoDate = new TextBoxFlexibleDate();
        this.yukoKigen = new TextBoxFlexibleDate();
        this.ketteiKubun = RString.EMPTY;
        this.ketteiDate = new TextBoxFlexibleDate();
        this.hobetsuKubun = RString.EMPTY;
        this.kyufuRitsu = RString.EMPTY;
        this.kohiJukyushaNo = RString.EMPTY;
        this.shogaishaTechoNo = RString.EMPTY;
    }

    public dgTaishoshaList_Row(TextBoxFlexibleDate shinseiDate, TextBoxFlexibleDate tekiyoDate, TextBoxFlexibleDate yukoKigen, RString ketteiKubun, TextBoxFlexibleDate ketteiDate, RString hobetsuKubun, RString kyufuRitsu, RString kohiJukyushaNo, RString shogaishaTechoNo) {
        super();
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("ketteiDate", ketteiDate);
        this.setOriginalData("hobetsuKubun", hobetsuKubun);
        this.setOriginalData("kyufuRitsu", kyufuRitsu);
        this.setOriginalData("kohiJukyushaNo", kohiJukyushaNo);
        this.setOriginalData("shogaishaTechoNo", shogaishaTechoNo);
        this.shinseiDate = shinseiDate;
        this.tekiyoDate = tekiyoDate;
        this.yukoKigen = yukoKigen;
        this.ketteiKubun = ketteiKubun;
        this.ketteiDate = ketteiDate;
        this.hobetsuKubun = hobetsuKubun;
        this.kyufuRitsu = kyufuRitsu;
        this.kohiJukyushaNo = kohiJukyushaNo;
        this.shogaishaTechoNo = shogaishaTechoNo;
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

    public RString getHobetsuKubun() {
        return hobetsuKubun;
    }

    public RString getKyufuRitsu() {
        return kyufuRitsu;
    }

    public RString getKohiJukyushaNo() {
        return kohiJukyushaNo;
    }

    public RString getShogaishaTechoNo() {
        return shogaishaTechoNo;
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

    public void setHobetsuKubun(RString hobetsuKubun) {
        this.setOriginalData("hobetsuKubun", hobetsuKubun);
        this.hobetsuKubun = hobetsuKubun;
    }

    public void setKyufuRitsu(RString kyufuRitsu) {
        this.setOriginalData("kyufuRitsu", kyufuRitsu);
        this.kyufuRitsu = kyufuRitsu;
    }

    public void setKohiJukyushaNo(RString kohiJukyushaNo) {
        this.setOriginalData("kohiJukyushaNo", kohiJukyushaNo);
        this.kohiJukyushaNo = kohiJukyushaNo;
    }

    public void setShogaishaTechoNo(RString shogaishaTechoNo) {
        this.setOriginalData("shogaishaTechoNo", shogaishaTechoNo);
        this.shogaishaTechoNo = shogaishaTechoNo;
    }

}