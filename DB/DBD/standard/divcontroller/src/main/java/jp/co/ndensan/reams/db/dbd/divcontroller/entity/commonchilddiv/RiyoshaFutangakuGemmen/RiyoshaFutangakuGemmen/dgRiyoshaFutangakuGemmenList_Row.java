package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.RiyoshaFutangakuGemmen.RiyoshaFutangakuGemmen;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Sep 17 17:10:21 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgRiyoshaFutangakuGemmenList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgRiyoshaFutangakuGemmenList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private TextBoxFlexibleDate shinseiDate;
    private TextBoxFlexibleDate tekiyoDate;
    private TextBoxFlexibleDate yukoKigen;
    private RString ketteiKubun;
    private TextBoxFlexibleDate ketteiDate;
    private TextBoxNum kyufuRitsu;
    private RString fushoninRiyu;

    public dgRiyoshaFutangakuGemmenList_Row() {
        super();
        this.shinseiDate = new TextBoxFlexibleDate();
        this.tekiyoDate = new TextBoxFlexibleDate();
        this.yukoKigen = new TextBoxFlexibleDate();
        this.ketteiKubun = RString.EMPTY;
        this.ketteiDate = new TextBoxFlexibleDate();
        this.kyufuRitsu = new TextBoxNum();
        this.fushoninRiyu = RString.EMPTY;
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("ketteiDate", ketteiDate);
        this.setOriginalData("kyufuRitsu", kyufuRitsu);
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
    }

    public dgRiyoshaFutangakuGemmenList_Row(TextBoxFlexibleDate shinseiDate, TextBoxFlexibleDate tekiyoDate, TextBoxFlexibleDate yukoKigen, RString ketteiKubun, TextBoxFlexibleDate ketteiDate, TextBoxNum kyufuRitsu, RString fushoninRiyu) {
        super();
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("ketteiDate", ketteiDate);
        this.setOriginalData("kyufuRitsu", kyufuRitsu);
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
        this.shinseiDate = shinseiDate;
        this.tekiyoDate = tekiyoDate;
        this.yukoKigen = yukoKigen;
        this.ketteiKubun = ketteiKubun;
        this.ketteiDate = ketteiDate;
        this.kyufuRitsu = kyufuRitsu;
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

    public TextBoxNum getKyufuRitsu() {
        return kyufuRitsu;
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

    public void setKyufuRitsu(TextBoxNum kyufuRitsu) {
        this.setOriginalData("kyufuRitsu", kyufuRitsu);
        this.kyufuRitsu = kyufuRitsu;
    }

    public void setFushoninRiyu(RString fushoninRiyu) {
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
        this.fushoninRiyu = fushoninRiyu;
    }

    // </editor-fold>
}
