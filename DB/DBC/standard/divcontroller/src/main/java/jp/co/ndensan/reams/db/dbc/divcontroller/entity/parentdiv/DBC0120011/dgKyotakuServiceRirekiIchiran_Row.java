package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Aug 10 10:21:31 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * dgKyotakuServiceRirekiIchiran_Row のクラスファイル
 *
 * @reamsid_L DBC-1930-030 huzongcheng
 */
public class dgKyotakuServiceRirekiIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private TextBoxDate taishoYM;
    private RString sakuseiKubun;
    private TextBoxDate tekiyoKaishiYMD;
    private TextBoxDate tekiyoShuryoYMD;
    private TextBoxDate todokedeYMD;
    private TextBoxDate koshinYMD;
    private RString maxRirekiNo;
    private RString kyotakuJigyo;

    public dgKyotakuServiceRirekiIchiran_Row() {
        super();
        this.taishoYM = new TextBoxDate();
        this.sakuseiKubun = RString.EMPTY;
        this.tekiyoKaishiYMD = new TextBoxDate();
        this.tekiyoShuryoYMD = new TextBoxDate();
        this.todokedeYMD = new TextBoxDate();
        this.koshinYMD = new TextBoxDate();
        this.maxRirekiNo = RString.EMPTY;
        this.kyotakuJigyo = RString.EMPTY;
        this.setOriginalData("taishoYM", taishoYM);
        this.setOriginalData("sakuseiKubun", sakuseiKubun);
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("todokedeYMD", todokedeYMD);
        this.setOriginalData("koshinYMD", koshinYMD);
        this.setOriginalData("maxRirekiNo", maxRirekiNo);
        this.setOriginalData("kyotakuJigyo", kyotakuJigyo);
    }

    public dgKyotakuServiceRirekiIchiran_Row(TextBoxDate taishoYM, RString sakuseiKubun, TextBoxDate tekiyoKaishiYMD, TextBoxDate tekiyoShuryoYMD, TextBoxDate todokedeYMD, TextBoxDate koshinYMD, RString maxRirekiNo, RString kyotakuJigyo) {
        super();
        this.setOriginalData("taishoYM", taishoYM);
        this.setOriginalData("sakuseiKubun", sakuseiKubun);
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("todokedeYMD", todokedeYMD);
        this.setOriginalData("koshinYMD", koshinYMD);
        this.setOriginalData("maxRirekiNo", maxRirekiNo);
        this.setOriginalData("kyotakuJigyo", kyotakuJigyo);
        this.taishoYM = taishoYM;
        this.sakuseiKubun = sakuseiKubun;
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
        this.todokedeYMD = todokedeYMD;
        this.koshinYMD = koshinYMD;
        this.maxRirekiNo = maxRirekiNo;
        this.kyotakuJigyo = kyotakuJigyo;
    }

    public TextBoxDate getTaishoYM() {
        return taishoYM;
    }

    public RString getSakuseiKubun() {
        return sakuseiKubun;
    }

    public TextBoxDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    public TextBoxDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    public TextBoxDate getTodokedeYMD() {
        return todokedeYMD;
    }

    public TextBoxDate getKoshinYMD() {
        return koshinYMD;
    }

    public RString getMaxRirekiNo() {
        return maxRirekiNo;
    }

    public RString getKyotakuJigyo() {
        return kyotakuJigyo;
    }

    public void setTaishoYM(TextBoxDate taishoYM) {
        this.setOriginalData("taishoYM", taishoYM);
        this.taishoYM = taishoYM;
    }

    public void setSakuseiKubun(RString sakuseiKubun) {
        this.setOriginalData("sakuseiKubun", sakuseiKubun);
        this.sakuseiKubun = sakuseiKubun;
    }

    public void setTekiyoKaishiYMD(TextBoxDate tekiyoKaishiYMD) {
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    public void setTekiyoShuryoYMD(TextBoxDate tekiyoShuryoYMD) {
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    public void setTodokedeYMD(TextBoxDate todokedeYMD) {
        this.setOriginalData("todokedeYMD", todokedeYMD);
        this.todokedeYMD = todokedeYMD;
    }

    public void setKoshinYMD(TextBoxDate koshinYMD) {
        this.setOriginalData("koshinYMD", koshinYMD);
        this.koshinYMD = koshinYMD;
    }

    public void setMaxRirekiNo(RString maxRirekiNo) {
        this.setOriginalData("maxRirekiNo", maxRirekiNo);
        this.maxRirekiNo = maxRirekiNo;
    }

    public void setKyotakuJigyo(RString kyotakuJigyo) {
        this.setOriginalData("kyotakuJigyo", kyotakuJigyo);
        this.kyotakuJigyo = kyotakuJigyo;
    }

    // </editor-fold>
}
