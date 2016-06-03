package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiran;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 27 22:56:31 JST 2016 
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private TextBoxFlexibleDate taishoYM;
    private RString keikakuSakuseiKubun;
    private RString zan;
    private RString jigyoshaNo;
    private RString jigyoshaName;
    private TextBoxFlexibleDate startDate;
    private TextBoxFlexibleDate endDate;
    private RString yukomuko;

    public dgKyotakuServiceKeikakuIchiran_Row() {
        super();
        this.taishoYM = new TextBoxFlexibleDate();
        this.keikakuSakuseiKubun = RString.EMPTY;
        this.zan = RString.EMPTY;
        this.jigyoshaNo = RString.EMPTY;
        this.jigyoshaName = RString.EMPTY;
        this.startDate = new TextBoxFlexibleDate();
        this.endDate = new TextBoxFlexibleDate();
        this.yukomuko = RString.EMPTY;
        this.setOriginalData("taishoYM", taishoYM);
        this.setOriginalData("keikakuSakuseiKubun", keikakuSakuseiKubun);
        this.setOriginalData("zan", zan);
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("jigyoshaName", jigyoshaName);
        this.setOriginalData("startDate", startDate);
        this.setOriginalData("endDate", endDate);
        this.setOriginalData("yukomuko", yukomuko);
    }

    public dgKyotakuServiceKeikakuIchiran_Row(TextBoxFlexibleDate taishoYM, RString keikakuSakuseiKubun, RString zan, RString jigyoshaNo, RString jigyoshaName, TextBoxFlexibleDate startDate, TextBoxFlexibleDate endDate, RString yukomuko) {
        super();
        this.setOriginalData("taishoYM", taishoYM);
        this.setOriginalData("keikakuSakuseiKubun", keikakuSakuseiKubun);
        this.setOriginalData("zan", zan);
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("jigyoshaName", jigyoshaName);
        this.setOriginalData("startDate", startDate);
        this.setOriginalData("endDate", endDate);
        this.setOriginalData("yukomuko", yukomuko);
        this.taishoYM = taishoYM;
        this.keikakuSakuseiKubun = keikakuSakuseiKubun;
        this.zan = zan;
        this.jigyoshaNo = jigyoshaNo;
        this.jigyoshaName = jigyoshaName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.yukomuko = yukomuko;
    }

    public TextBoxFlexibleDate getTaishoYM() {
        return taishoYM;
    }

    public RString getKeikakuSakuseiKubun() {
        return keikakuSakuseiKubun;
    }

    public RString getZan() {
        return zan;
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

    public void setTaishoYM(TextBoxFlexibleDate taishoYM) {
        this.setOriginalData("taishoYM", taishoYM);
        this.taishoYM = taishoYM;
    }

    public void setKeikakuSakuseiKubun(RString keikakuSakuseiKubun) {
        this.setOriginalData("keikakuSakuseiKubun", keikakuSakuseiKubun);
        this.keikakuSakuseiKubun = keikakuSakuseiKubun;
    }

    public void setZan(RString zan) {
        this.setOriginalData("zan", zan);
        this.zan = zan;
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

    // </editor-fold>
}
