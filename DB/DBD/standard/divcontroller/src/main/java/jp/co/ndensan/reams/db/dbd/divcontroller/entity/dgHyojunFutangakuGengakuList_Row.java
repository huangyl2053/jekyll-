package jp.co.ndensan.reams.db.dbd.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 16:48:28 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgHyojunFutangakuGengakuList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHyojunFutangakuGengakuList_Row extends DataRow {

    private TextBoxFlexibleDate shinseiDate;
    private TextBoxFlexibleDate tekiyoDate;
    private TextBoxFlexibleDate yukoKigen;
    private RString ketteiKubun;
    private TextBoxFlexibleDate ketteiDate;
    private TextBoxNum futangaku;
    private RString gengakuKubun;
    private RString fushoninRiyu;

    public dgHyojunFutangakuGengakuList_Row() {
        super();
        this.shinseiDate = new TextBoxFlexibleDate();
        this.tekiyoDate = new TextBoxFlexibleDate();
        this.yukoKigen = new TextBoxFlexibleDate();
        this.ketteiKubun = RString.EMPTY;
        this.ketteiDate = new TextBoxFlexibleDate();
        this.futangaku = new TextBoxNum();
        this.gengakuKubun = RString.EMPTY;
        this.fushoninRiyu = RString.EMPTY;
    }

    public dgHyojunFutangakuGengakuList_Row(TextBoxFlexibleDate shinseiDate, TextBoxFlexibleDate tekiyoDate, TextBoxFlexibleDate yukoKigen, RString ketteiKubun, TextBoxFlexibleDate ketteiDate, TextBoxNum futangaku, RString gengakuKubun, RString fushoninRiyu) {
        super();
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("ketteiDate", ketteiDate);
        this.setOriginalData("futangaku", futangaku);
        this.setOriginalData("gengakuKubun", gengakuKubun);
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
        this.shinseiDate = shinseiDate;
        this.tekiyoDate = tekiyoDate;
        this.yukoKigen = yukoKigen;
        this.ketteiKubun = ketteiKubun;
        this.ketteiDate = ketteiDate;
        this.futangaku = futangaku;
        this.gengakuKubun = gengakuKubun;
        this.fushoninRiyu = fushoninRiyu;
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

    public TextBoxNum getFutangaku() {
        return futangaku;
    }

    public RString getGengakuKubun() {
        return gengakuKubun;
    }

    public RString getFushoninRiyu() {
        return fushoninRiyu;
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

    public void setFutangaku(TextBoxNum futangaku) {
        this.setOriginalData("futangaku", futangaku);
        this.futangaku = futangaku;
    }

    public void setGengakuKubun(RString gengakuKubun) {
        this.setOriginalData("gengakuKubun", gengakuKubun);
        this.gengakuKubun = gengakuKubun;
    }

    public void setFushoninRiyu(RString fushoninRiyu) {
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
        this.fushoninRiyu = fushoninRiyu;
    }

}