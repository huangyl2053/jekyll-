package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1730011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jul 08 11:05:41 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgShikyuGendogaku_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShikyuGendogaku_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString jotai;
    private TextBoxDate tekiyoKaishi;
    private TextBoxDate tekiyoShuryo;
    private TextBoxNum yoShien1;
    private TextBoxNum yoShien2;
    private TextBoxNum nijiYobo;

    public dgShikyuGendogaku_Row() {
        super();
        this.jotai = RString.EMPTY;
        this.tekiyoKaishi = new TextBoxDate();
        this.tekiyoShuryo = new TextBoxDate();
        this.yoShien1 = new TextBoxNum();
        this.yoShien2 = new TextBoxNum();
        this.nijiYobo = new TextBoxNum();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("tekiyoKaishi", tekiyoKaishi);
        this.setOriginalData("tekiyoShuryo", tekiyoShuryo);
        this.setOriginalData("yoShien1", yoShien1);
        this.setOriginalData("yoShien2", yoShien2);
        this.setOriginalData("nijiYobo", nijiYobo);
    }

    public dgShikyuGendogaku_Row(RString jotai, TextBoxDate tekiyoKaishi, TextBoxDate tekiyoShuryo, TextBoxNum yoShien1, TextBoxNum yoShien2, TextBoxNum nijiYobo) {
        super();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("tekiyoKaishi", tekiyoKaishi);
        this.setOriginalData("tekiyoShuryo", tekiyoShuryo);
        this.setOriginalData("yoShien1", yoShien1);
        this.setOriginalData("yoShien2", yoShien2);
        this.setOriginalData("nijiYobo", nijiYobo);
        this.jotai = jotai;
        this.tekiyoKaishi = tekiyoKaishi;
        this.tekiyoShuryo = tekiyoShuryo;
        this.yoShien1 = yoShien1;
        this.yoShien2 = yoShien2;
        this.nijiYobo = nijiYobo;
    }

    public RString getJotai() {
        return jotai;
    }

    public TextBoxDate getTekiyoKaishi() {
        return tekiyoKaishi;
    }

    public TextBoxDate getTekiyoShuryo() {
        return tekiyoShuryo;
    }

    public TextBoxNum getYoShien1() {
        return yoShien1;
    }

    public TextBoxNum getYoShien2() {
        return yoShien2;
    }

    public TextBoxNum getNijiYobo() {
        return nijiYobo;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setTekiyoKaishi(TextBoxDate tekiyoKaishi) {
        this.setOriginalData("tekiyoKaishi", tekiyoKaishi);
        this.tekiyoKaishi = tekiyoKaishi;
    }

    public void setTekiyoShuryo(TextBoxDate tekiyoShuryo) {
        this.setOriginalData("tekiyoShuryo", tekiyoShuryo);
        this.tekiyoShuryo = tekiyoShuryo;
    }

    public void setYoShien1(TextBoxNum yoShien1) {
        this.setOriginalData("yoShien1", yoShien1);
        this.yoShien1 = yoShien1;
    }

    public void setYoShien2(TextBoxNum yoShien2) {
        this.setOriginalData("yoShien2", yoShien2);
        this.yoShien2 = yoShien2;
    }

    public void setNijiYobo(TextBoxNum nijiYobo) {
        this.setOriginalData("nijiYobo", nijiYobo);
        this.nijiYobo = nijiYobo;
    }

    // </editor-fold>
}
