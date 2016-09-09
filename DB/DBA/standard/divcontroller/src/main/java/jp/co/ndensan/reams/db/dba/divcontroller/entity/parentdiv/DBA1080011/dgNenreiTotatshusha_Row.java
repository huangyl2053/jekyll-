package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Sep 09 10:39:12 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgNenreiTotatshusha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgNenreiTotatshusha_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">

    private RString lasdecCode;
    private RString lasdecMei;
    private RString shikibetsuCode;
    private RString rirekiNo;
    private RString shimei;
    private TextBoxFlexibleDate dateOfBirth;
    private RString gender;
    private RString juminJotai;
    private RString jogaiRiyu;
    private TextBoxDate jogaiTekiyoDate;
    private TextBoxDate jogaiKaijyoDate;

    public dgNenreiTotatshusha_Row() {
        super();
        this.lasdecCode = RString.EMPTY;
        this.lasdecMei = RString.EMPTY;
        this.shikibetsuCode = RString.EMPTY;
        this.rirekiNo = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.dateOfBirth = new TextBoxFlexibleDate();
        this.gender = RString.EMPTY;
        this.juminJotai = RString.EMPTY;
        this.jogaiRiyu = RString.EMPTY;
        this.jogaiTekiyoDate = new TextBoxDate();
        this.jogaiKaijyoDate = new TextBoxDate();
        this.setOriginalData("lasdecCode", lasdecCode);
        this.setOriginalData("lasdecMei", lasdecMei);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("dateOfBirth", dateOfBirth);
        this.setOriginalData("gender", gender);
        this.setOriginalData("juminJotai", juminJotai);
        this.setOriginalData("jogaiRiyu", jogaiRiyu);
        this.setOriginalData("jogaiTekiyoDate", jogaiTekiyoDate);
        this.setOriginalData("jogaiKaijyoDate", jogaiKaijyoDate);
    }

    public dgNenreiTotatshusha_Row(RString lasdecCode, RString lasdecMei, RString shikibetsuCode, RString rirekiNo, RString shimei, TextBoxFlexibleDate dateOfBirth, RString gender, RString juminJotai, RString jogaiRiyu, TextBoxDate jogaiTekiyoDate, TextBoxDate jogaiKaijyoDate) {
        super();
        this.setOriginalData("lasdecCode", lasdecCode);
        this.setOriginalData("lasdecMei", lasdecMei);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("dateOfBirth", dateOfBirth);
        this.setOriginalData("gender", gender);
        this.setOriginalData("juminJotai", juminJotai);
        this.setOriginalData("jogaiRiyu", jogaiRiyu);
        this.setOriginalData("jogaiTekiyoDate", jogaiTekiyoDate);
        this.setOriginalData("jogaiKaijyoDate", jogaiKaijyoDate);
        this.lasdecCode = lasdecCode;
        this.lasdecMei = lasdecMei;
        this.shikibetsuCode = shikibetsuCode;
        this.rirekiNo = rirekiNo;
        this.shimei = shimei;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.juminJotai = juminJotai;
        this.jogaiRiyu = jogaiRiyu;
        this.jogaiTekiyoDate = jogaiTekiyoDate;
        this.jogaiKaijyoDate = jogaiKaijyoDate;
    }

    public RString getLasdecCode() {
        return lasdecCode;
    }

    public RString getLasdecMei() {
        return lasdecMei;
    }

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public RString getShimei() {
        return shimei;
    }

    public TextBoxFlexibleDate getDateOfBirth() {
        return dateOfBirth;
    }

    public RString getGender() {
        return gender;
    }

    public RString getJuminJotai() {
        return juminJotai;
    }

    public RString getJogaiRiyu() {
        return jogaiRiyu;
    }

    public TextBoxDate getJogaiTekiyoDate() {
        return jogaiTekiyoDate;
    }

    public TextBoxDate getJogaiKaijyoDate() {
        return jogaiKaijyoDate;
    }

    public void setLasdecCode(RString lasdecCode) {
        this.setOriginalData("lasdecCode", lasdecCode);
        this.lasdecCode = lasdecCode;
    }

    public void setLasdecMei(RString lasdecMei) {
        this.setOriginalData("lasdecMei", lasdecMei);
        this.lasdecMei = lasdecMei;
    }

    public void setShikibetsuCode(RString shikibetsuCode) {
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shikibetsuCode = shikibetsuCode;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setDateOfBirth(TextBoxFlexibleDate dateOfBirth) {
        this.setOriginalData("dateOfBirth", dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(RString gender) {
        this.setOriginalData("gender", gender);
        this.gender = gender;
    }

    public void setJuminJotai(RString juminJotai) {
        this.setOriginalData("juminJotai", juminJotai);
        this.juminJotai = juminJotai;
    }

    public void setJogaiRiyu(RString jogaiRiyu) {
        this.setOriginalData("jogaiRiyu", jogaiRiyu);
        this.jogaiRiyu = jogaiRiyu;
    }

    public void setJogaiTekiyoDate(TextBoxDate jogaiTekiyoDate) {
        this.setOriginalData("jogaiTekiyoDate", jogaiTekiyoDate);
        this.jogaiTekiyoDate = jogaiTekiyoDate;
    }

    public void setJogaiKaijyoDate(TextBoxDate jogaiKaijyoDate) {
        this.setOriginalData("jogaiKaijyoDate", jogaiKaijyoDate);
        this.jogaiKaijyoDate = jogaiKaijyoDate;
    }

    // </editor-fold>
}
