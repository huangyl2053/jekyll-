package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Sep 13 17:07:46 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;


/**
 * dgJikoKisambi_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJikoKisambi_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString fukaNendo;
    private RString fuchoTokucho;
    private RString tsuchishoNo;
    private RString ki;
    private RString choteigaku;
    private TextBoxFlexibleDate nokigen;
    private RString shunyugaku;
    private RString minogaku;
    private TextBoxFlexibleDate jikoKisaibi;
    private RString jikoKisaibiJiyu;
    private TextBoxFlexibleDate tokushuJikoKisaibi;
    private DropDownList tokushuJikoKisaibiJiyu;
    private RString hdnFukaNendo;
    private RString minoKannoKubun;
    private RString jikoKubun;
    private RString hdnFuchoTokucho;
    private RString hdnTsuchishoNo;

    public dgJikoKisambi_Row() {
        super();
        this.fukaNendo = RString.EMPTY;
        this.fuchoTokucho = RString.EMPTY;
        this.tsuchishoNo = RString.EMPTY;
        this.ki = RString.EMPTY;
        this.choteigaku = RString.EMPTY;
        this.nokigen = new TextBoxFlexibleDate();
        this.shunyugaku = RString.EMPTY;
        this.minogaku = RString.EMPTY;
        this.jikoKisaibi = new TextBoxFlexibleDate();
        this.jikoKisaibiJiyu = RString.EMPTY;
        this.tokushuJikoKisaibi = new TextBoxFlexibleDate();
        this.tokushuJikoKisaibiJiyu = new DropDownList();
        this.hdnFukaNendo = RString.EMPTY;
        this.minoKannoKubun = RString.EMPTY;
        this.jikoKubun = RString.EMPTY;
        this.hdnFuchoTokucho = RString.EMPTY;
        this.hdnTsuchishoNo = RString.EMPTY;
        this.setOriginalData("fukaNendo", fukaNendo);
        this.setOriginalData("fuchoTokucho", fuchoTokucho);
        this.setOriginalData("tsuchishoNo", tsuchishoNo);
        this.setOriginalData("ki", ki);
        this.setOriginalData("choteigaku", choteigaku);
        this.setOriginalData("nokigen", nokigen);
        this.setOriginalData("shunyugaku", shunyugaku);
        this.setOriginalData("minogaku", minogaku);
        this.setOriginalData("jikoKisaibi", jikoKisaibi);
        this.setOriginalData("jikoKisaibiJiyu", jikoKisaibiJiyu);
        this.setOriginalData("tokushuJikoKisaibi", tokushuJikoKisaibi);
        this.setOriginalData("tokushuJikoKisaibiJiyu", tokushuJikoKisaibiJiyu);
        this.setOriginalData("hdnFukaNendo", hdnFukaNendo);
        this.setOriginalData("minoKannoKubun", minoKannoKubun);
        this.setOriginalData("jikoKubun", jikoKubun);
        this.setOriginalData("hdnFuchoTokucho", hdnFuchoTokucho);
        this.setOriginalData("hdnTsuchishoNo", hdnTsuchishoNo);
    }

    public dgJikoKisambi_Row(RString fukaNendo, RString fuchoTokucho, RString tsuchishoNo, RString ki, RString choteigaku, TextBoxFlexibleDate nokigen, RString shunyugaku, RString minogaku, TextBoxFlexibleDate jikoKisaibi, RString jikoKisaibiJiyu, TextBoxFlexibleDate tokushuJikoKisaibi, DropDownList tokushuJikoKisaibiJiyu, RString hdnFukaNendo, RString minoKannoKubun, RString jikoKubun, RString hdnFuchoTokucho, RString hdnTsuchishoNo) {
        super();
        this.setOriginalData("fukaNendo", fukaNendo);
        this.setOriginalData("fuchoTokucho", fuchoTokucho);
        this.setOriginalData("tsuchishoNo", tsuchishoNo);
        this.setOriginalData("ki", ki);
        this.setOriginalData("choteigaku", choteigaku);
        this.setOriginalData("nokigen", nokigen);
        this.setOriginalData("shunyugaku", shunyugaku);
        this.setOriginalData("minogaku", minogaku);
        this.setOriginalData("jikoKisaibi", jikoKisaibi);
        this.setOriginalData("jikoKisaibiJiyu", jikoKisaibiJiyu);
        this.setOriginalData("tokushuJikoKisaibi", tokushuJikoKisaibi);
        this.setOriginalData("tokushuJikoKisaibiJiyu", tokushuJikoKisaibiJiyu);
        this.setOriginalData("hdnFukaNendo", hdnFukaNendo);
        this.setOriginalData("minoKannoKubun", minoKannoKubun);
        this.setOriginalData("jikoKubun", jikoKubun);
        this.setOriginalData("hdnFuchoTokucho", hdnFuchoTokucho);
        this.setOriginalData("hdnTsuchishoNo", hdnTsuchishoNo);
        this.fukaNendo = fukaNendo;
        this.fuchoTokucho = fuchoTokucho;
        this.tsuchishoNo = tsuchishoNo;
        this.ki = ki;
        this.choteigaku = choteigaku;
        this.nokigen = nokigen;
        this.shunyugaku = shunyugaku;
        this.minogaku = minogaku;
        this.jikoKisaibi = jikoKisaibi;
        this.jikoKisaibiJiyu = jikoKisaibiJiyu;
        this.tokushuJikoKisaibi = tokushuJikoKisaibi;
        this.tokushuJikoKisaibiJiyu = tokushuJikoKisaibiJiyu;
        this.hdnFukaNendo = hdnFukaNendo;
        this.minoKannoKubun = minoKannoKubun;
        this.jikoKubun = jikoKubun;
        this.hdnFuchoTokucho = hdnFuchoTokucho;
        this.hdnTsuchishoNo = hdnTsuchishoNo;
    }

    public dgJikoKisambi_Row(DataGridSetting gridSetting) {
        super();
        this.fukaNendo = RString.EMPTY;
        this.fuchoTokucho = RString.EMPTY;
        this.tsuchishoNo = RString.EMPTY;
        this.ki = RString.EMPTY;
        this.choteigaku = RString.EMPTY;
        this.nokigen = new TextBoxFlexibleDate();
        this.shunyugaku = RString.EMPTY;
        this.minogaku = RString.EMPTY;
        this.jikoKisaibi = new TextBoxFlexibleDate();
        this.jikoKisaibiJiyu = RString.EMPTY;
        this.tokushuJikoKisaibi = new TextBoxFlexibleDate();
        this.tokushuJikoKisaibiJiyu = DropDownList.createInstance(gridSetting.getColumn("tokushuJikoKisaibiJiyu").getCellDetails());
        this.hdnFukaNendo = RString.EMPTY;
        this.minoKannoKubun = RString.EMPTY;
        this.jikoKubun = RString.EMPTY;
        this.hdnFuchoTokucho = RString.EMPTY;
        this.hdnTsuchishoNo = RString.EMPTY;
        this.setOriginalData("fukaNendo", fukaNendo);
        this.setOriginalData("fuchoTokucho", fuchoTokucho);
        this.setOriginalData("tsuchishoNo", tsuchishoNo);
        this.setOriginalData("ki", ki);
        this.setOriginalData("choteigaku", choteigaku);
        this.setOriginalData("nokigen", nokigen);
        this.setOriginalData("shunyugaku", shunyugaku);
        this.setOriginalData("minogaku", minogaku);
        this.setOriginalData("jikoKisaibi", jikoKisaibi);
        this.setOriginalData("jikoKisaibiJiyu", jikoKisaibiJiyu);
        this.setOriginalData("tokushuJikoKisaibi", tokushuJikoKisaibi);
        this.setOriginalData("tokushuJikoKisaibiJiyu", tokushuJikoKisaibiJiyu);
        this.setOriginalData("hdnFukaNendo", hdnFukaNendo);
        this.setOriginalData("minoKannoKubun", minoKannoKubun);
        this.setOriginalData("jikoKubun", jikoKubun);
        this.setOriginalData("hdnFuchoTokucho", hdnFuchoTokucho);
        this.setOriginalData("hdnTsuchishoNo", hdnTsuchishoNo);
    }

    public RString getFukaNendo() {
        return fukaNendo;
    }

    public RString getFuchoTokucho() {
        return fuchoTokucho;
    }

    public RString getTsuchishoNo() {
        return tsuchishoNo;
    }

    public RString getKi() {
        return ki;
    }

    public RString getChoteigaku() {
        return choteigaku;
    }

    public TextBoxFlexibleDate getNokigen() {
        return nokigen;
    }

    public RString getShunyugaku() {
        return shunyugaku;
    }

    public RString getMinogaku() {
        return minogaku;
    }

    public TextBoxFlexibleDate getJikoKisaibi() {
        return jikoKisaibi;
    }

    public RString getJikoKisaibiJiyu() {
        return jikoKisaibiJiyu;
    }

    public TextBoxFlexibleDate getTokushuJikoKisaibi() {
        return tokushuJikoKisaibi;
    }

    public DropDownList getTokushuJikoKisaibiJiyu() {
        return tokushuJikoKisaibiJiyu;
    }

    public RString getHdnFukaNendo() {
        return hdnFukaNendo;
    }

    public RString getMinoKannoKubun() {
        return minoKannoKubun;
    }

    public RString getJikoKubun() {
        return jikoKubun;
    }

    public RString getHdnFuchoTokucho() {
        return hdnFuchoTokucho;
    }

    public RString getHdnTsuchishoNo() {
        return hdnTsuchishoNo;
    }

    public void setFukaNendo(RString fukaNendo) {
        this.setOriginalData("fukaNendo", fukaNendo);
        this.fukaNendo = fukaNendo;
    }

    public void setFuchoTokucho(RString fuchoTokucho) {
        this.setOriginalData("fuchoTokucho", fuchoTokucho);
        this.fuchoTokucho = fuchoTokucho;
    }

    public void setTsuchishoNo(RString tsuchishoNo) {
        this.setOriginalData("tsuchishoNo", tsuchishoNo);
        this.tsuchishoNo = tsuchishoNo;
    }

    public void setKi(RString ki) {
        this.setOriginalData("ki", ki);
        this.ki = ki;
    }

    public void setChoteigaku(RString choteigaku) {
        this.setOriginalData("choteigaku", choteigaku);
        this.choteigaku = choteigaku;
    }

    public void setNokigen(TextBoxFlexibleDate nokigen) {
        this.setOriginalData("nokigen", nokigen);
        this.nokigen = nokigen;
    }

    public void setShunyugaku(RString shunyugaku) {
        this.setOriginalData("shunyugaku", shunyugaku);
        this.shunyugaku = shunyugaku;
    }

    public void setMinogaku(RString minogaku) {
        this.setOriginalData("minogaku", minogaku);
        this.minogaku = minogaku;
    }

    public void setJikoKisaibi(TextBoxFlexibleDate jikoKisaibi) {
        this.setOriginalData("jikoKisaibi", jikoKisaibi);
        this.jikoKisaibi = jikoKisaibi;
    }

    public void setJikoKisaibiJiyu(RString jikoKisaibiJiyu) {
        this.setOriginalData("jikoKisaibiJiyu", jikoKisaibiJiyu);
        this.jikoKisaibiJiyu = jikoKisaibiJiyu;
    }

    public void setTokushuJikoKisaibi(TextBoxFlexibleDate tokushuJikoKisaibi) {
        this.setOriginalData("tokushuJikoKisaibi", tokushuJikoKisaibi);
        this.tokushuJikoKisaibi = tokushuJikoKisaibi;
    }

    public void setTokushuJikoKisaibiJiyu(DropDownList tokushuJikoKisaibiJiyu) {
        this.setOriginalData("tokushuJikoKisaibiJiyu", tokushuJikoKisaibiJiyu);
        this.tokushuJikoKisaibiJiyu = tokushuJikoKisaibiJiyu;
    }

    public void setHdnFukaNendo(RString hdnFukaNendo) {
        this.setOriginalData("hdnFukaNendo", hdnFukaNendo);
        this.hdnFukaNendo = hdnFukaNendo;
    }

    public void setMinoKannoKubun(RString minoKannoKubun) {
        this.setOriginalData("minoKannoKubun", minoKannoKubun);
        this.minoKannoKubun = minoKannoKubun;
    }

    public void setJikoKubun(RString jikoKubun) {
        this.setOriginalData("jikoKubun", jikoKubun);
        this.jikoKubun = jikoKubun;
    }

    public void setHdnFuchoTokucho(RString hdnFuchoTokucho) {
        this.setOriginalData("hdnFuchoTokucho", hdnFuchoTokucho);
        this.hdnFuchoTokucho = hdnFuchoTokucho;
    }

    public void setHdnTsuchishoNo(RString hdnTsuchishoNo) {
        this.setOriginalData("hdnTsuchishoNo", hdnTsuchishoNo);
        this.hdnTsuchishoNo = hdnTsuchishoNo;
    }

    // </editor-fold>
}
