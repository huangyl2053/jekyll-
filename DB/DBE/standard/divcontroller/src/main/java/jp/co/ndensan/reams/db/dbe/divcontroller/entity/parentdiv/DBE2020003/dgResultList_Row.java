package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Mar 02 16:39:36 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgResultList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgResultList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private RString hokensha;
    private RString hihokenshaNo;
    private RString name;
    private RString kanaName;
    private RString seibetsu;
    private TextBoxFlexibleDate birthDay;
    private TextBoxFlexibleDate ninteiChosaYmd;
    private RString jokyo;
    private TextBoxFlexibleDate ninteiShinseiYmd;
    private RString shinseiKubun;
    private RString taishoshaMemo;
    private RString shinseishoKanriNo;
    private RString ninteiChosaItakusakiCode;
    private RString ninteiChosainCode;
    private RString ninteiChosaJikanWaku;
    private RString yoyakuKaoFlag;

    public dgResultList_Row() {
        super();
        this.hokensha = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.name = RString.EMPTY;
        this.kanaName = RString.EMPTY;
        this.seibetsu = RString.EMPTY;
        this.birthDay = new TextBoxFlexibleDate();
        this.ninteiChosaYmd = new TextBoxFlexibleDate();
        this.jokyo = RString.EMPTY;
        this.ninteiShinseiYmd = new TextBoxFlexibleDate();
        this.shinseiKubun = RString.EMPTY;
        this.taishoshaMemo = RString.EMPTY;
        this.shinseishoKanriNo = RString.EMPTY;
        this.ninteiChosaItakusakiCode = RString.EMPTY;
        this.ninteiChosainCode = RString.EMPTY;
        this.ninteiChosaJikanWaku = RString.EMPTY;
        this.yoyakuKaoFlag = RString.EMPTY;
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("name", name);
        this.setOriginalData("kanaName", kanaName);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("birthDay", birthDay);
        this.setOriginalData("ninteiChosaYmd", ninteiChosaYmd);
        this.setOriginalData("jokyo", jokyo);
        this.setOriginalData("ninteiShinseiYmd", ninteiShinseiYmd);
        this.setOriginalData("shinseiKubun", shinseiKubun);
        this.setOriginalData("taishoshaMemo", taishoshaMemo);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("ninteiChosaItakusakiCode", ninteiChosaItakusakiCode);
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.setOriginalData("ninteiChosaJikanWaku", ninteiChosaJikanWaku);
        this.setOriginalData("yoyakuKaoFlag", yoyakuKaoFlag);
    }

    public dgResultList_Row(RString hokensha, RString hihokenshaNo, RString name, RString kanaName, RString seibetsu, TextBoxFlexibleDate birthDay, TextBoxFlexibleDate ninteiChosaYmd, RString jokyo, TextBoxFlexibleDate ninteiShinseiYmd, RString shinseiKubun, RString taishoshaMemo, RString shinseishoKanriNo, RString ninteiChosaItakusakiCode, RString ninteiChosainCode, RString ninteiChosaJikanWaku, RString yoyakuKaoFlag) {
        super();
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("name", name);
        this.setOriginalData("kanaName", kanaName);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("birthDay", birthDay);
        this.setOriginalData("ninteiChosaYmd", ninteiChosaYmd);
        this.setOriginalData("jokyo", jokyo);
        this.setOriginalData("ninteiShinseiYmd", ninteiShinseiYmd);
        this.setOriginalData("shinseiKubun", shinseiKubun);
        this.setOriginalData("taishoshaMemo", taishoshaMemo);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("ninteiChosaItakusakiCode", ninteiChosaItakusakiCode);
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.setOriginalData("ninteiChosaJikanWaku", ninteiChosaJikanWaku);
        this.setOriginalData("yoyakuKaoFlag", yoyakuKaoFlag);
        this.hokensha = hokensha;
        this.hihokenshaNo = hihokenshaNo;
        this.name = name;
        this.kanaName = kanaName;
        this.seibetsu = seibetsu;
        this.birthDay = birthDay;
        this.ninteiChosaYmd = ninteiChosaYmd;
        this.jokyo = jokyo;
        this.ninteiShinseiYmd = ninteiShinseiYmd;
        this.shinseiKubun = shinseiKubun;
        this.taishoshaMemo = taishoshaMemo;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
        this.ninteiChosainCode = ninteiChosainCode;
        this.ninteiChosaJikanWaku = ninteiChosaJikanWaku;
        this.yoyakuKaoFlag = yoyakuKaoFlag;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getName() {
        return name;
    }

    public RString getKanaName() {
        return kanaName;
    }

    public RString getSeibetsu() {
        return seibetsu;
    }

    public TextBoxFlexibleDate getBirthDay() {
        return birthDay;
    }

    public TextBoxFlexibleDate getNinteiChosaYmd() {
        return ninteiChosaYmd;
    }

    public RString getJokyo() {
        return jokyo;
    }

    public TextBoxFlexibleDate getNinteiShinseiYmd() {
        return ninteiShinseiYmd;
    }

    public RString getShinseiKubun() {
        return shinseiKubun;
    }

    public RString getTaishoshaMemo() {
        return taishoshaMemo;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public RString getNinteiChosaItakusakiCode() {
        return ninteiChosaItakusakiCode;
    }

    public RString getNinteiChosainCode() {
        return ninteiChosainCode;
    }

    public RString getNinteiChosaJikanWaku() {
        return ninteiChosaJikanWaku;
    }

    public RString getYoyakuKaoFlag() {
        return yoyakuKaoFlag;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setName(RString name) {
        this.setOriginalData("name", name);
        this.name = name;
    }

    public void setKanaName(RString kanaName) {
        this.setOriginalData("kanaName", kanaName);
        this.kanaName = kanaName;
    }

    public void setSeibetsu(RString seibetsu) {
        this.setOriginalData("seibetsu", seibetsu);
        this.seibetsu = seibetsu;
    }

    public void setBirthDay(TextBoxFlexibleDate birthDay) {
        this.setOriginalData("birthDay", birthDay);
        this.birthDay = birthDay;
    }

    public void setNinteiChosaYmd(TextBoxFlexibleDate ninteiChosaYmd) {
        this.setOriginalData("ninteiChosaYmd", ninteiChosaYmd);
        this.ninteiChosaYmd = ninteiChosaYmd;
    }

    public void setJokyo(RString jokyo) {
        this.setOriginalData("jokyo", jokyo);
        this.jokyo = jokyo;
    }

    public void setNinteiShinseiYmd(TextBoxFlexibleDate ninteiShinseiYmd) {
        this.setOriginalData("ninteiShinseiYmd", ninteiShinseiYmd);
        this.ninteiShinseiYmd = ninteiShinseiYmd;
    }

    public void setShinseiKubun(RString shinseiKubun) {
        this.setOriginalData("shinseiKubun", shinseiKubun);
        this.shinseiKubun = shinseiKubun;
    }

    public void setTaishoshaMemo(RString taishoshaMemo) {
        this.setOriginalData("taishoshaMemo", taishoshaMemo);
        this.taishoshaMemo = taishoshaMemo;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public void setNinteiChosaItakusakiCode(RString ninteiChosaItakusakiCode) {
        this.setOriginalData("ninteiChosaItakusakiCode", ninteiChosaItakusakiCode);
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
    }

    public void setNinteiChosainCode(RString ninteiChosainCode) {
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.ninteiChosainCode = ninteiChosainCode;
    }

    public void setNinteiChosaJikanWaku(RString ninteiChosaJikanWaku) {
        this.setOriginalData("ninteiChosaJikanWaku", ninteiChosaJikanWaku);
        this.ninteiChosaJikanWaku = ninteiChosaJikanWaku;
    }

    public void setYoyakuKaoFlag(RString yoyakuKaoFlag) {
        this.setOriginalData("yoyakuKaoFlag", yoyakuKaoFlag);
        this.yoyakuKaoFlag = yoyakuKaoFlag;
    }

    // </editor-fold>
}
