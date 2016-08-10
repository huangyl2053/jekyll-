package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuseigenRirekiList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Aug 03 15:45:32 CST 2016 
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * dgKyufuseigenRirekiList_Row のクラスファイル
 *
 * @reamsid_L DBC-4350-050 liuxiaoyu
 */
public class dgKyufuseigenRirekiList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString kanriKubun;
    private RString torokuKubun;
    private TextBoxFlexibleDate tekiyoKaishiYMD;
    private TextBoxFlexibleDate tekiyoShuryoYMD;
    private RString shuryoKubun;

    public dgKyufuseigenRirekiList_Row() {
        super();
        this.kanriKubun = RString.EMPTY;
        this.torokuKubun = RString.EMPTY;
        this.tekiyoKaishiYMD = new TextBoxFlexibleDate();
        this.tekiyoShuryoYMD = new TextBoxFlexibleDate();
        this.shuryoKubun = RString.EMPTY;
        this.setOriginalData("kanriKubun", kanriKubun);
        this.setOriginalData("torokuKubun", torokuKubun);
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("shuryoKubun", shuryoKubun);
    }

    public dgKyufuseigenRirekiList_Row(RString kanriKubun, RString torokuKubun, TextBoxFlexibleDate tekiyoKaishiYMD, TextBoxFlexibleDate tekiyoShuryoYMD, RString shuryoKubun) {
        super();
        this.setOriginalData("kanriKubun", kanriKubun);
        this.setOriginalData("torokuKubun", torokuKubun);
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("shuryoKubun", shuryoKubun);
        this.kanriKubun = kanriKubun;
        this.torokuKubun = torokuKubun;
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
        this.shuryoKubun = shuryoKubun;
    }

    public RString getKanriKubun() {
        return kanriKubun;
    }

    public RString getTorokuKubun() {
        return torokuKubun;
    }

    public TextBoxFlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    public TextBoxFlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    public RString getShuryoKubun() {
        return shuryoKubun;
    }

    public void setKanriKubun(RString kanriKubun) {
        this.setOriginalData("kanriKubun", kanriKubun);
        this.kanriKubun = kanriKubun;
    }

    public void setTorokuKubun(RString torokuKubun) {
        this.setOriginalData("torokuKubun", torokuKubun);
        this.torokuKubun = torokuKubun;
    }

    public void setTekiyoKaishiYMD(TextBoxFlexibleDate tekiyoKaishiYMD) {
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    public void setTekiyoShuryoYMD(TextBoxFlexibleDate tekiyoShuryoYMD) {
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    public void setShuryoKubun(RString shuryoKubun) {
        this.setOriginalData("shuryoKubun", shuryoKubun);
        this.shuryoKubun = shuryoKubun;
    }

    // </editor-fold>
}
