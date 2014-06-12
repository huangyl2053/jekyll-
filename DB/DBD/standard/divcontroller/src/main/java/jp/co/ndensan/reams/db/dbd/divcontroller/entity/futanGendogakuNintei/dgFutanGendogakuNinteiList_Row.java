package jp.co.ndensan.reams.db.dbd.divcontroller.entity.futanGendogakuNintei;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 12 16:56:32 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


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
    private RString riyoshaFutanDankai;

    public dgFutanGendogakuNinteiList_Row() {
        super();
        this.shinseiDate = new TextBoxFlexibleDate();
        this.ketteiDate = new TextBoxFlexibleDate();
        this.ketteiKubun = RString.EMPTY;
        this.tekiyoDate = new TextBoxFlexibleDate();
        this.yukoKigen = new TextBoxFlexibleDate();
        this.shinseiRiyu = RString.EMPTY;
        this.fushoninRiyu = RString.EMPTY;
        this.riyoshaFutanDankai = RString.EMPTY;
    }

    public dgFutanGendogakuNinteiList_Row(TextBoxFlexibleDate shinseiDate, TextBoxFlexibleDate ketteiDate, RString ketteiKubun, TextBoxFlexibleDate tekiyoDate, TextBoxFlexibleDate yukoKigen, RString shinseiRiyu, RString fushoninRiyu, RString riyoshaFutanDankai) {
        super();
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("ketteiDate", ketteiDate);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.setOriginalData("shinseiRiyu", shinseiRiyu);
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
        this.setOriginalData("riyoshaFutanDankai", riyoshaFutanDankai);
        this.shinseiDate = shinseiDate;
        this.ketteiDate = ketteiDate;
        this.ketteiKubun = ketteiKubun;
        this.tekiyoDate = tekiyoDate;
        this.yukoKigen = yukoKigen;
        this.shinseiRiyu = shinseiRiyu;
        this.fushoninRiyu = fushoninRiyu;
        this.riyoshaFutanDankai = riyoshaFutanDankai;
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

    public RString getRiyoshaFutanDankai() {
        return riyoshaFutanDankai;
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

    public void setRiyoshaFutanDankai(RString riyoshaFutanDankai) {
        this.setOriginalData("riyoshaFutanDankai", riyoshaFutanDankai);
        this.riyoshaFutanDankai = riyoshaFutanDankai;
    }

}