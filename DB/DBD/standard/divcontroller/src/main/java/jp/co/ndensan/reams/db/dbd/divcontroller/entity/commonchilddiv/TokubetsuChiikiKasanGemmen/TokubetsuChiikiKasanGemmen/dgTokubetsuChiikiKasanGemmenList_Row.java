package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.TokubetsuChiikiKasanGemmen.TokubetsuChiikiKasanGemmen;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Sep 20 09:24:39 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgTokubetsuChiikiKasanGemmenList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTokubetsuChiikiKasanGemmenList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private RString kakuninNo;
    private TextBoxFlexibleDate shinseiDate;
    private TextBoxFlexibleDate tekiyoDate;
    private TextBoxFlexibleDate yukoKigen;
    private RString ketteiKubun;
    private TextBoxFlexibleDate ketteiDate;
    private TextBoxNum gengakuRitsu;
    private RString fushoninRiyu;

    public dgTokubetsuChiikiKasanGemmenList_Row() {
        super();
        this.kakuninNo = RString.EMPTY;
        this.shinseiDate = new TextBoxFlexibleDate();
        this.tekiyoDate = new TextBoxFlexibleDate();
        this.yukoKigen = new TextBoxFlexibleDate();
        this.ketteiKubun = RString.EMPTY;
        this.ketteiDate = new TextBoxFlexibleDate();
        this.gengakuRitsu = new TextBoxNum();
        this.fushoninRiyu = RString.EMPTY;
        this.setOriginalData("kakuninNo", kakuninNo);
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("ketteiDate", ketteiDate);
        this.setOriginalData("gengakuRitsu", gengakuRitsu);
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
    }

    public dgTokubetsuChiikiKasanGemmenList_Row(RString kakuninNo, TextBoxFlexibleDate shinseiDate, TextBoxFlexibleDate tekiyoDate, TextBoxFlexibleDate yukoKigen, RString ketteiKubun, TextBoxFlexibleDate ketteiDate, TextBoxNum gengakuRitsu, RString fushoninRiyu) {
        super();
        this.setOriginalData("kakuninNo", kakuninNo);
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("ketteiDate", ketteiDate);
        this.setOriginalData("gengakuRitsu", gengakuRitsu);
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
        this.kakuninNo = kakuninNo;
        this.shinseiDate = shinseiDate;
        this.tekiyoDate = tekiyoDate;
        this.yukoKigen = yukoKigen;
        this.ketteiKubun = ketteiKubun;
        this.ketteiDate = ketteiDate;
        this.gengakuRitsu = gengakuRitsu;
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

    public TextBoxNum getGengakuRitsu() {
        return gengakuRitsu;
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

    public void setGengakuRitsu(TextBoxNum gengakuRitsu) {
        this.setOriginalData("gengakuRitsu", gengakuRitsu);
        this.gengakuRitsu = gengakuRitsu;
    }

    public void setFushoninRiyu(RString fushoninRiyu) {
        this.setOriginalData("fushoninRiyu", fushoninRiyu);
        this.fushoninRiyu = fushoninRiyu;
    }

    // </editor-fold>
}
