package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4220011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Aug 16 19:31:57 CST 2016 
 */

import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * dgShikyuGendogaku_Row のクラスファイル
 *
 * @reamsid_L DBC-3460-010 jianglaisheng
 */
public class dgShikyuGendogaku_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private TextBoxDate tekiyoKaishiYM;
    private TextBoxDate tekiyoShuryoYM;
    private RString tableKubun;
    private TextBoxNum kyotakukaigoFukushiyoguGendogaku;
    private TextBoxNum kyotakukaigoJutakuKaishuGendogaku;
    private TextBoxNum kyotakushienFukushiyoguGendogaku;
    private TextBoxNum kyotakushienJutakuKaishuGendogaku;
    private RString hdnSaishinFlag;

    public dgShikyuGendogaku_Row() {
        super();
        this.tekiyoKaishiYM = new TextBoxDate();
        this.tekiyoShuryoYM = new TextBoxDate();
        this.tableKubun = RString.EMPTY;
        this.kyotakukaigoFukushiyoguGendogaku = new TextBoxNum();
        this.kyotakukaigoJutakuKaishuGendogaku = new TextBoxNum();
        this.kyotakushienFukushiyoguGendogaku = new TextBoxNum();
        this.kyotakushienJutakuKaishuGendogaku = new TextBoxNum();
        this.hdnSaishinFlag = RString.EMPTY;
        this.setOriginalData("tekiyoKaishiYM", tekiyoKaishiYM);
        this.setOriginalData("tekiyoShuryoYM", tekiyoShuryoYM);
        this.setOriginalData("tableKubun", tableKubun);
        this.setOriginalData("kyotakukaigoFukushiyoguGendogaku", kyotakukaigoFukushiyoguGendogaku);
        this.setOriginalData("kyotakukaigoJutakuKaishuGendogaku", kyotakukaigoJutakuKaishuGendogaku);
        this.setOriginalData("kyotakushienFukushiyoguGendogaku", kyotakushienFukushiyoguGendogaku);
        this.setOriginalData("kyotakushienJutakuKaishuGendogaku", kyotakushienJutakuKaishuGendogaku);
        this.setOriginalData("hdnSaishinFlag", hdnSaishinFlag);
    }

    public dgShikyuGendogaku_Row(TextBoxDate tekiyoKaishiYM, TextBoxDate tekiyoShuryoYM, RString tableKubun, TextBoxNum kyotakukaigoFukushiyoguGendogaku, TextBoxNum kyotakukaigoJutakuKaishuGendogaku, TextBoxNum kyotakushienFukushiyoguGendogaku, TextBoxNum kyotakushienJutakuKaishuGendogaku, RString hdnSaishinFlag) {
        super();
        this.setOriginalData("tekiyoKaishiYM", tekiyoKaishiYM);
        this.setOriginalData("tekiyoShuryoYM", tekiyoShuryoYM);
        this.setOriginalData("tableKubun", tableKubun);
        this.setOriginalData("kyotakukaigoFukushiyoguGendogaku", kyotakukaigoFukushiyoguGendogaku);
        this.setOriginalData("kyotakukaigoJutakuKaishuGendogaku", kyotakukaigoJutakuKaishuGendogaku);
        this.setOriginalData("kyotakushienFukushiyoguGendogaku", kyotakushienFukushiyoguGendogaku);
        this.setOriginalData("kyotakushienJutakuKaishuGendogaku", kyotakushienJutakuKaishuGendogaku);
        this.setOriginalData("hdnSaishinFlag", hdnSaishinFlag);
        this.tekiyoKaishiYM = tekiyoKaishiYM;
        this.tekiyoShuryoYM = tekiyoShuryoYM;
        this.tableKubun = tableKubun;
        this.kyotakukaigoFukushiyoguGendogaku = kyotakukaigoFukushiyoguGendogaku;
        this.kyotakukaigoJutakuKaishuGendogaku = kyotakukaigoJutakuKaishuGendogaku;
        this.kyotakushienFukushiyoguGendogaku = kyotakushienFukushiyoguGendogaku;
        this.kyotakushienJutakuKaishuGendogaku = kyotakushienJutakuKaishuGendogaku;
        this.hdnSaishinFlag = hdnSaishinFlag;
    }

    public TextBoxDate getTekiyoKaishiYM() {
        return tekiyoKaishiYM;
    }

    public TextBoxDate getTekiyoShuryoYM() {
        return tekiyoShuryoYM;
    }

    public RString getTableKubun() {
        return tableKubun;
    }

    public TextBoxNum getKyotakukaigoFukushiyoguGendogaku() {
        return kyotakukaigoFukushiyoguGendogaku;
    }

    public TextBoxNum getKyotakukaigoJutakuKaishuGendogaku() {
        return kyotakukaigoJutakuKaishuGendogaku;
    }

    public TextBoxNum getKyotakushienFukushiyoguGendogaku() {
        return kyotakushienFukushiyoguGendogaku;
    }

    public TextBoxNum getKyotakushienJutakuKaishuGendogaku() {
        return kyotakushienJutakuKaishuGendogaku;
    }

    public RString getHdnSaishinFlag() {
        return hdnSaishinFlag;
    }

    public void setTekiyoKaishiYM(TextBoxDate tekiyoKaishiYM) {
        this.setOriginalData("tekiyoKaishiYM", tekiyoKaishiYM);
        this.tekiyoKaishiYM = tekiyoKaishiYM;
    }

    public void setTekiyoShuryoYM(TextBoxDate tekiyoShuryoYM) {
        this.setOriginalData("tekiyoShuryoYM", tekiyoShuryoYM);
        this.tekiyoShuryoYM = tekiyoShuryoYM;
    }

    public void setTableKubun(RString tableKubun) {
        this.setOriginalData("tableKubun", tableKubun);
        this.tableKubun = tableKubun;
    }

    public void setKyotakukaigoFukushiyoguGendogaku(TextBoxNum kyotakukaigoFukushiyoguGendogaku) {
        this.setOriginalData("kyotakukaigoFukushiyoguGendogaku", kyotakukaigoFukushiyoguGendogaku);
        this.kyotakukaigoFukushiyoguGendogaku = kyotakukaigoFukushiyoguGendogaku;
    }

    public void setKyotakukaigoJutakuKaishuGendogaku(TextBoxNum kyotakukaigoJutakuKaishuGendogaku) {
        this.setOriginalData("kyotakukaigoJutakuKaishuGendogaku", kyotakukaigoJutakuKaishuGendogaku);
        this.kyotakukaigoJutakuKaishuGendogaku = kyotakukaigoJutakuKaishuGendogaku;
    }

    public void setKyotakushienFukushiyoguGendogaku(TextBoxNum kyotakushienFukushiyoguGendogaku) {
        this.setOriginalData("kyotakushienFukushiyoguGendogaku", kyotakushienFukushiyoguGendogaku);
        this.kyotakushienFukushiyoguGendogaku = kyotakushienFukushiyoguGendogaku;
    }

    public void setKyotakushienJutakuKaishuGendogaku(TextBoxNum kyotakushienJutakuKaishuGendogaku) {
        this.setOriginalData("kyotakushienJutakuKaishuGendogaku", kyotakushienJutakuKaishuGendogaku);
        this.kyotakushienJutakuKaishuGendogaku = kyotakushienJutakuKaishuGendogaku;
    }

    public void setHdnSaishinFlag(RString hdnSaishinFlag) {
        this.setOriginalData("hdnSaishinFlag", hdnSaishinFlag);
        this.hdnSaishinFlag = hdnSaishinFlag;
    }

    // </editor-fold>
}
