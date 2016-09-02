package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Aug 31 15:15:21 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * dgKihonInfo_Row のクラスファイル
 *
 * @reamsid_L DBC-2400-010 yuqingzhang
 */
public class dgKihonInfo_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString joutai;
    private TextBoxDate tekiyouKaishiBi;
    private TextBoxDate tekiyouShuuryouBi;
    private TextBoxDate chousaZisshiBi;
    private TextBoxDate ketteiBi;
    private RString rirekiNo;

    public dgKihonInfo_Row() {
        super();
        this.joutai = RString.EMPTY;
        this.tekiyouKaishiBi = new TextBoxDate();
        this.tekiyouShuuryouBi = new TextBoxDate();
        this.chousaZisshiBi = new TextBoxDate();
        this.ketteiBi = new TextBoxDate();
        this.rirekiNo = RString.EMPTY;
        this.setOriginalData("joutai", joutai);
        this.setOriginalData("tekiyouKaishiBi", tekiyouKaishiBi);
        this.setOriginalData("tekiyouShuuryouBi", tekiyouShuuryouBi);
        this.setOriginalData("chousaZisshiBi", chousaZisshiBi);
        this.setOriginalData("ketteiBi", ketteiBi);
        this.setOriginalData("rirekiNo", rirekiNo);
    }

    public dgKihonInfo_Row(RString joutai, TextBoxDate tekiyouKaishiBi, TextBoxDate tekiyouShuuryouBi, TextBoxDate chousaZisshiBi, TextBoxDate ketteiBi, RString rirekiNo) {
        super();
        this.setOriginalData("joutai", joutai);
        this.setOriginalData("tekiyouKaishiBi", tekiyouKaishiBi);
        this.setOriginalData("tekiyouShuuryouBi", tekiyouShuuryouBi);
        this.setOriginalData("chousaZisshiBi", chousaZisshiBi);
        this.setOriginalData("ketteiBi", ketteiBi);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.joutai = joutai;
        this.tekiyouKaishiBi = tekiyouKaishiBi;
        this.tekiyouShuuryouBi = tekiyouShuuryouBi;
        this.chousaZisshiBi = chousaZisshiBi;
        this.ketteiBi = ketteiBi;
        this.rirekiNo = rirekiNo;
    }

    public RString getJoutai() {
        return joutai;
    }

    public TextBoxDate getTekiyouKaishiBi() {
        return tekiyouKaishiBi;
    }

    public TextBoxDate getTekiyouShuuryouBi() {
        return tekiyouShuuryouBi;
    }

    public TextBoxDate getChousaZisshiBi() {
        return chousaZisshiBi;
    }

    public TextBoxDate getKetteiBi() {
        return ketteiBi;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public void setJoutai(RString joutai) {
        this.setOriginalData("joutai", joutai);
        this.joutai = joutai;
    }

    public void setTekiyouKaishiBi(TextBoxDate tekiyouKaishiBi) {
        this.setOriginalData("tekiyouKaishiBi", tekiyouKaishiBi);
        this.tekiyouKaishiBi = tekiyouKaishiBi;
    }

    public void setTekiyouShuuryouBi(TextBoxDate tekiyouShuuryouBi) {
        this.setOriginalData("tekiyouShuuryouBi", tekiyouShuuryouBi);
        this.tekiyouShuuryouBi = tekiyouShuuryouBi;
    }

    public void setChousaZisshiBi(TextBoxDate chousaZisshiBi) {
        this.setOriginalData("chousaZisshiBi", chousaZisshiBi);
        this.chousaZisshiBi = chousaZisshiBi;
    }

    public void setKetteiBi(TextBoxDate ketteiBi) {
        this.setOriginalData("ketteiBi", ketteiBi);
        this.ketteiBi = ketteiBi;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    // </editor-fold>
}
