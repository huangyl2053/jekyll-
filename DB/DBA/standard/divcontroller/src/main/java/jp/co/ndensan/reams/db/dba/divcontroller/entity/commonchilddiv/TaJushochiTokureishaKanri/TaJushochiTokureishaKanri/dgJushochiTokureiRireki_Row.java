package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri.TaJushochiTokureishaKanri;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Mar 28 13:36:33 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgJushochiTokureiRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJushochiTokureiRireki_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private RString jyoTai;
    private TextBoxDate tekiyoYMD;
    private TextBoxDate tekiyoTodokedeYMD;
    private RString tekiyoJiyuCode;
    private TextBoxDate kaijoYMD;
    private TextBoxDate kaijoTodokedeYMD;
    private RString kaijoJiyuCode;
    private TextBoxDate nyushoYMD;
    private TextBoxDate taishoYMD;
    private RString nyushoShisetsuCode;
    private RString sochiHokenshaNo;
    private RString sochiHihokenshaNo;
    private RString shikibetsuCode;
    private RString idoYMD;
    private RString edaNo;
    private RString rirekiNo;
    private RString nyushoShisetsuShurui;
    private RString tekiyoJiyu;
    private RString kaijoJiyu;
    private RString shichosonCode;
    private RString sochiHokensha;
    private RString tatokuRenrakuhyoHakkoYMD;
    private RString shisetsuTaishoTsuchiHakkoYMD;
    private RString shisetsuHenkoTsuchiHakkoYMD;
    private RString nyushoShisetsu;
    private RString idoJiyuCode;

    public dgJushochiTokureiRireki_Row() {
        super();
        this.jyoTai = RString.EMPTY;
        this.tekiyoYMD = new TextBoxDate();
        this.tekiyoTodokedeYMD = new TextBoxDate();
        this.tekiyoJiyuCode = RString.EMPTY;
        this.kaijoYMD = new TextBoxDate();
        this.kaijoTodokedeYMD = new TextBoxDate();
        this.kaijoJiyuCode = RString.EMPTY;
        this.nyushoYMD = new TextBoxDate();
        this.taishoYMD = new TextBoxDate();
        this.nyushoShisetsuCode = RString.EMPTY;
        this.sochiHokenshaNo = RString.EMPTY;
        this.sochiHihokenshaNo = RString.EMPTY;
        this.shikibetsuCode = RString.EMPTY;
        this.idoYMD = RString.EMPTY;
        this.edaNo = RString.EMPTY;
        this.rirekiNo = RString.EMPTY;
        this.nyushoShisetsuShurui = RString.EMPTY;
        this.tekiyoJiyu = RString.EMPTY;
        this.kaijoJiyu = RString.EMPTY;
        this.shichosonCode = RString.EMPTY;
        this.sochiHokensha = RString.EMPTY;
        this.tatokuRenrakuhyoHakkoYMD = RString.EMPTY;
        this.shisetsuTaishoTsuchiHakkoYMD = RString.EMPTY;
        this.shisetsuHenkoTsuchiHakkoYMD = RString.EMPTY;
        this.nyushoShisetsu = RString.EMPTY;
        this.idoJiyuCode = RString.EMPTY;
        this.setOriginalData("jyoTai", jyoTai);
        this.setOriginalData("tekiyoYMD", tekiyoYMD);
        this.setOriginalData("tekiyoTodokedeYMD", tekiyoTodokedeYMD);
        this.setOriginalData("tekiyoJiyuCode", tekiyoJiyuCode);
        this.setOriginalData("kaijoYMD", kaijoYMD);
        this.setOriginalData("kaijoTodokedeYMD", kaijoTodokedeYMD);
        this.setOriginalData("kaijoJiyuCode", kaijoJiyuCode);
        this.setOriginalData("nyushoYMD", nyushoYMD);
        this.setOriginalData("taishoYMD", taishoYMD);
        this.setOriginalData("nyushoShisetsuCode", nyushoShisetsuCode);
        this.setOriginalData("sochiHokenshaNo", sochiHokenshaNo);
        this.setOriginalData("sochiHihokenshaNo", sochiHihokenshaNo);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("idoYMD", idoYMD);
        this.setOriginalData("edaNo", edaNo);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("nyushoShisetsuShurui", nyushoShisetsuShurui);
        this.setOriginalData("tekiyoJiyu", tekiyoJiyu);
        this.setOriginalData("kaijoJiyu", kaijoJiyu);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("sochiHokensha", sochiHokensha);
        this.setOriginalData("tatokuRenrakuhyoHakkoYMD", tatokuRenrakuhyoHakkoYMD);
        this.setOriginalData("shisetsuTaishoTsuchiHakkoYMD", shisetsuTaishoTsuchiHakkoYMD);
        this.setOriginalData("shisetsuHenkoTsuchiHakkoYMD", shisetsuHenkoTsuchiHakkoYMD);
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.setOriginalData("idoJiyuCode", idoJiyuCode);
    }

    public dgJushochiTokureiRireki_Row(RString jyoTai, TextBoxDate tekiyoYMD, TextBoxDate tekiyoTodokedeYMD, RString tekiyoJiyuCode, TextBoxDate kaijoYMD, TextBoxDate kaijoTodokedeYMD, RString kaijoJiyuCode, TextBoxDate nyushoYMD, TextBoxDate taishoYMD, RString nyushoShisetsuCode, RString sochiHokenshaNo, RString sochiHihokenshaNo, RString shikibetsuCode, RString idoYMD, RString edaNo, RString rirekiNo, RString nyushoShisetsuShurui, RString tekiyoJiyu, RString kaijoJiyu, RString shichosonCode, RString sochiHokensha, RString tatokuRenrakuhyoHakkoYMD, RString shisetsuTaishoTsuchiHakkoYMD, RString shisetsuHenkoTsuchiHakkoYMD, RString nyushoShisetsu, RString idoJiyuCode) {
        super();
        this.setOriginalData("jyoTai", jyoTai);
        this.setOriginalData("tekiyoYMD", tekiyoYMD);
        this.setOriginalData("tekiyoTodokedeYMD", tekiyoTodokedeYMD);
        this.setOriginalData("tekiyoJiyuCode", tekiyoJiyuCode);
        this.setOriginalData("kaijoYMD", kaijoYMD);
        this.setOriginalData("kaijoTodokedeYMD", kaijoTodokedeYMD);
        this.setOriginalData("kaijoJiyuCode", kaijoJiyuCode);
        this.setOriginalData("nyushoYMD", nyushoYMD);
        this.setOriginalData("taishoYMD", taishoYMD);
        this.setOriginalData("nyushoShisetsuCode", nyushoShisetsuCode);
        this.setOriginalData("sochiHokenshaNo", sochiHokenshaNo);
        this.setOriginalData("sochiHihokenshaNo", sochiHihokenshaNo);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("idoYMD", idoYMD);
        this.setOriginalData("edaNo", edaNo);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("nyushoShisetsuShurui", nyushoShisetsuShurui);
        this.setOriginalData("tekiyoJiyu", tekiyoJiyu);
        this.setOriginalData("kaijoJiyu", kaijoJiyu);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("sochiHokensha", sochiHokensha);
        this.setOriginalData("tatokuRenrakuhyoHakkoYMD", tatokuRenrakuhyoHakkoYMD);
        this.setOriginalData("shisetsuTaishoTsuchiHakkoYMD", shisetsuTaishoTsuchiHakkoYMD);
        this.setOriginalData("shisetsuHenkoTsuchiHakkoYMD", shisetsuHenkoTsuchiHakkoYMD);
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.setOriginalData("idoJiyuCode", idoJiyuCode);
        this.jyoTai = jyoTai;
        this.tekiyoYMD = tekiyoYMD;
        this.tekiyoTodokedeYMD = tekiyoTodokedeYMD;
        this.tekiyoJiyuCode = tekiyoJiyuCode;
        this.kaijoYMD = kaijoYMD;
        this.kaijoTodokedeYMD = kaijoTodokedeYMD;
        this.kaijoJiyuCode = kaijoJiyuCode;
        this.nyushoYMD = nyushoYMD;
        this.taishoYMD = taishoYMD;
        this.nyushoShisetsuCode = nyushoShisetsuCode;
        this.sochiHokenshaNo = sochiHokenshaNo;
        this.sochiHihokenshaNo = sochiHihokenshaNo;
        this.shikibetsuCode = shikibetsuCode;
        this.idoYMD = idoYMD;
        this.edaNo = edaNo;
        this.rirekiNo = rirekiNo;
        this.nyushoShisetsuShurui = nyushoShisetsuShurui;
        this.tekiyoJiyu = tekiyoJiyu;
        this.kaijoJiyu = kaijoJiyu;
        this.shichosonCode = shichosonCode;
        this.sochiHokensha = sochiHokensha;
        this.tatokuRenrakuhyoHakkoYMD = tatokuRenrakuhyoHakkoYMD;
        this.shisetsuTaishoTsuchiHakkoYMD = shisetsuTaishoTsuchiHakkoYMD;
        this.shisetsuHenkoTsuchiHakkoYMD = shisetsuHenkoTsuchiHakkoYMD;
        this.nyushoShisetsu = nyushoShisetsu;
        this.idoJiyuCode = idoJiyuCode;
    }

    public RString getJyoTai() {
        return jyoTai;
    }

    public TextBoxDate getTekiyoYMD() {
        return tekiyoYMD;
    }

    public TextBoxDate getTekiyoTodokedeYMD() {
        return tekiyoTodokedeYMD;
    }

    public RString getTekiyoJiyuCode() {
        return tekiyoJiyuCode;
    }

    public TextBoxDate getKaijoYMD() {
        return kaijoYMD;
    }

    public TextBoxDate getKaijoTodokedeYMD() {
        return kaijoTodokedeYMD;
    }

    public RString getKaijoJiyuCode() {
        return kaijoJiyuCode;
    }

    public TextBoxDate getNyushoYMD() {
        return nyushoYMD;
    }

    public TextBoxDate getTaishoYMD() {
        return taishoYMD;
    }

    public RString getNyushoShisetsuCode() {
        return nyushoShisetsuCode;
    }

    public RString getSochiHokenshaNo() {
        return sochiHokenshaNo;
    }

    public RString getSochiHihokenshaNo() {
        return sochiHihokenshaNo;
    }

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public RString getIdoYMD() {
        return idoYMD;
    }

    public RString getEdaNo() {
        return edaNo;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public RString getNyushoShisetsuShurui() {
        return nyushoShisetsuShurui;
    }

    public RString getTekiyoJiyu() {
        return tekiyoJiyu;
    }

    public RString getKaijoJiyu() {
        return kaijoJiyu;
    }

    public RString getShichosonCode() {
        return shichosonCode;
    }

    public RString getSochiHokensha() {
        return sochiHokensha;
    }

    public RString getTatokuRenrakuhyoHakkoYMD() {
        return tatokuRenrakuhyoHakkoYMD;
    }

    public RString getShisetsuTaishoTsuchiHakkoYMD() {
        return shisetsuTaishoTsuchiHakkoYMD;
    }

    public RString getShisetsuHenkoTsuchiHakkoYMD() {
        return shisetsuHenkoTsuchiHakkoYMD;
    }

    public RString getNyushoShisetsu() {
        return nyushoShisetsu;
    }

    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    public void setJyoTai(RString jyoTai) {
        this.setOriginalData("jyoTai", jyoTai);
        this.jyoTai = jyoTai;
    }

    public void setTekiyoYMD(TextBoxDate tekiyoYMD) {
        this.setOriginalData("tekiyoYMD", tekiyoYMD);
        this.tekiyoYMD = tekiyoYMD;
    }

    public void setTekiyoTodokedeYMD(TextBoxDate tekiyoTodokedeYMD) {
        this.setOriginalData("tekiyoTodokedeYMD", tekiyoTodokedeYMD);
        this.tekiyoTodokedeYMD = tekiyoTodokedeYMD;
    }

    public void setTekiyoJiyuCode(RString tekiyoJiyuCode) {
        this.setOriginalData("tekiyoJiyuCode", tekiyoJiyuCode);
        this.tekiyoJiyuCode = tekiyoJiyuCode;
    }

    public void setKaijoYMD(TextBoxDate kaijoYMD) {
        this.setOriginalData("kaijoYMD", kaijoYMD);
        this.kaijoYMD = kaijoYMD;
    }

    public void setKaijoTodokedeYMD(TextBoxDate kaijoTodokedeYMD) {
        this.setOriginalData("kaijoTodokedeYMD", kaijoTodokedeYMD);
        this.kaijoTodokedeYMD = kaijoTodokedeYMD;
    }

    public void setKaijoJiyuCode(RString kaijoJiyuCode) {
        this.setOriginalData("kaijoJiyuCode", kaijoJiyuCode);
        this.kaijoJiyuCode = kaijoJiyuCode;
    }

    public void setNyushoYMD(TextBoxDate nyushoYMD) {
        this.setOriginalData("nyushoYMD", nyushoYMD);
        this.nyushoYMD = nyushoYMD;
    }

    public void setTaishoYMD(TextBoxDate taishoYMD) {
        this.setOriginalData("taishoYMD", taishoYMD);
        this.taishoYMD = taishoYMD;
    }

    public void setNyushoShisetsuCode(RString nyushoShisetsuCode) {
        this.setOriginalData("nyushoShisetsuCode", nyushoShisetsuCode);
        this.nyushoShisetsuCode = nyushoShisetsuCode;
    }

    public void setSochiHokenshaNo(RString sochiHokenshaNo) {
        this.setOriginalData("sochiHokenshaNo", sochiHokenshaNo);
        this.sochiHokenshaNo = sochiHokenshaNo;
    }

    public void setSochiHihokenshaNo(RString sochiHihokenshaNo) {
        this.setOriginalData("sochiHihokenshaNo", sochiHihokenshaNo);
        this.sochiHihokenshaNo = sochiHihokenshaNo;
    }

    public void setShikibetsuCode(RString shikibetsuCode) {
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shikibetsuCode = shikibetsuCode;
    }

    public void setIdoYMD(RString idoYMD) {
        this.setOriginalData("idoYMD", idoYMD);
        this.idoYMD = idoYMD;
    }

    public void setEdaNo(RString edaNo) {
        this.setOriginalData("edaNo", edaNo);
        this.edaNo = edaNo;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    public void setNyushoShisetsuShurui(RString nyushoShisetsuShurui) {
        this.setOriginalData("nyushoShisetsuShurui", nyushoShisetsuShurui);
        this.nyushoShisetsuShurui = nyushoShisetsuShurui;
    }

    public void setTekiyoJiyu(RString tekiyoJiyu) {
        this.setOriginalData("tekiyoJiyu", tekiyoJiyu);
        this.tekiyoJiyu = tekiyoJiyu;
    }

    public void setKaijoJiyu(RString kaijoJiyu) {
        this.setOriginalData("kaijoJiyu", kaijoJiyu);
        this.kaijoJiyu = kaijoJiyu;
    }

    public void setShichosonCode(RString shichosonCode) {
        this.setOriginalData("shichosonCode", shichosonCode);
        this.shichosonCode = shichosonCode;
    }

    public void setSochiHokensha(RString sochiHokensha) {
        this.setOriginalData("sochiHokensha", sochiHokensha);
        this.sochiHokensha = sochiHokensha;
    }

    public void setTatokuRenrakuhyoHakkoYMD(RString tatokuRenrakuhyoHakkoYMD) {
        this.setOriginalData("tatokuRenrakuhyoHakkoYMD", tatokuRenrakuhyoHakkoYMD);
        this.tatokuRenrakuhyoHakkoYMD = tatokuRenrakuhyoHakkoYMD;
    }

    public void setShisetsuTaishoTsuchiHakkoYMD(RString shisetsuTaishoTsuchiHakkoYMD) {
        this.setOriginalData("shisetsuTaishoTsuchiHakkoYMD", shisetsuTaishoTsuchiHakkoYMD);
        this.shisetsuTaishoTsuchiHakkoYMD = shisetsuTaishoTsuchiHakkoYMD;
    }

    public void setShisetsuHenkoTsuchiHakkoYMD(RString shisetsuHenkoTsuchiHakkoYMD) {
        this.setOriginalData("shisetsuHenkoTsuchiHakkoYMD", shisetsuHenkoTsuchiHakkoYMD);
        this.shisetsuHenkoTsuchiHakkoYMD = shisetsuHenkoTsuchiHakkoYMD;
    }

    public void setNyushoShisetsu(RString nyushoShisetsu) {
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.nyushoShisetsu = nyushoShisetsu;
    }

    public void setIdoJiyuCode(RString idoJiyuCode) {
        this.setOriginalData("idoJiyuCode", idoJiyuCode);
        this.idoJiyuCode = idoJiyuCode;
    }

    // </editor-fold>
}
