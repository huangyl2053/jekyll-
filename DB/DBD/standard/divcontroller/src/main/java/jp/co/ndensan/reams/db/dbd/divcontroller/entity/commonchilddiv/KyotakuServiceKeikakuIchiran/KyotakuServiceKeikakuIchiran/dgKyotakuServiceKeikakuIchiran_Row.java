package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiran;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 24 13:42:39 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKyotakuServiceKeikakuIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKyotakuServiceKeikakuIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private TextBoxFlexibleDate taishoYM;
    private RString keikakuSakuseiKubun;
    private RString jigyoshaNo;
    private RString jigyoshaName;
    private TextBoxFlexibleDate startDate;
    private TextBoxFlexibleDate endDate;
    private RString yukomuko;
    private RString rirekiNo;

    public dgKyotakuServiceKeikakuIchiran_Row() {
        super();
        this.taishoYM = new TextBoxFlexibleDate();
        this.keikakuSakuseiKubun = RString.EMPTY;
        this.jigyoshaNo = RString.EMPTY;
        this.jigyoshaName = RString.EMPTY;
        this.startDate = new TextBoxFlexibleDate();
        this.endDate = new TextBoxFlexibleDate();
        this.yukomuko = RString.EMPTY;
        this.rirekiNo = RString.EMPTY;
        this.setOriginalData("taishoYM", taishoYM);
        this.setOriginalData("keikakuSakuseiKubun", keikakuSakuseiKubun);
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("jigyoshaName", jigyoshaName);
        this.setOriginalData("startDate", startDate);
        this.setOriginalData("endDate", endDate);
        this.setOriginalData("yukomuko", yukomuko);
        this.setOriginalData("rirekiNo", rirekiNo);
    }

    public dgKyotakuServiceKeikakuIchiran_Row(TextBoxFlexibleDate taishoYM, RString keikakuSakuseiKubun, RString jigyoshaNo, RString jigyoshaName, TextBoxFlexibleDate startDate, TextBoxFlexibleDate endDate, RString yukomuko, RString rirekiNo) {
        super();
        this.setOriginalData("taishoYM", taishoYM);
        this.setOriginalData("keikakuSakuseiKubun", keikakuSakuseiKubun);
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("jigyoshaName", jigyoshaName);
        this.setOriginalData("startDate", startDate);
        this.setOriginalData("endDate", endDate);
        this.setOriginalData("yukomuko", yukomuko);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.taishoYM = taishoYM;
        this.keikakuSakuseiKubun = keikakuSakuseiKubun;
        this.jigyoshaNo = jigyoshaNo;
        this.jigyoshaName = jigyoshaName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.yukomuko = yukomuko;
        this.rirekiNo = rirekiNo;
    }

    public TextBoxFlexibleDate getTaishoYM() {
        return taishoYM;
    }

    public RString getKeikakuSakuseiKubun() {
        return keikakuSakuseiKubun;
    }

    public RString getJigyoshaNo() {
        return jigyoshaNo;
    }

    public RString getJigyoshaName() {
        return jigyoshaName;
    }

    public TextBoxFlexibleDate getStartDate() {
        return startDate;
    }

    public TextBoxFlexibleDate getEndDate() {
        return endDate;
    }

    public RString getYukomuko() {
        return yukomuko;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public void setTaishoYM(TextBoxFlexibleDate taishoYM) {
        this.setOriginalData("taishoYM", taishoYM);
        this.taishoYM = taishoYM;
    }

    public void setKeikakuSakuseiKubun(RString keikakuSakuseiKubun) {
        this.setOriginalData("keikakuSakuseiKubun", keikakuSakuseiKubun);
        this.keikakuSakuseiKubun = keikakuSakuseiKubun;
    }

    public void setJigyoshaNo(RString jigyoshaNo) {
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.jigyoshaNo = jigyoshaNo;
    }

    public void setJigyoshaName(RString jigyoshaName) {
        this.setOriginalData("jigyoshaName", jigyoshaName);
        this.jigyoshaName = jigyoshaName;
    }

    public void setStartDate(TextBoxFlexibleDate startDate) {
        this.setOriginalData("startDate", startDate);
        this.startDate = startDate;
    }

    public void setEndDate(TextBoxFlexibleDate endDate) {
        this.setOriginalData("endDate", endDate);
        this.endDate = endDate;
    }

    public void setYukomuko(RString yukomuko) {
        this.setOriginalData("yukomuko", yukomuko);
        this.yukomuko = yukomuko;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    // </editor-fold>
}
