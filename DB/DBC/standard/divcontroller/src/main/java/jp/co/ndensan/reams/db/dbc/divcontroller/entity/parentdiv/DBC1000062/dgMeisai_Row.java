package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sun Sep 18 12:03:32 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.ImageDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * dgMeisai_Row のクラスファイル
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public class dgMeisai_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString shikibetsuCode;
    private RString hihokenshaNo;
    private RString name;
    private RString birthYMD;
    private RString gender;
    private RString age;
    private RString zokugara;
    private TextBoxNum kotekiNenkin;
    private TextBoxNum kyuyo;
    private TextBoxNum otherIncome;
    private ImageDialog memo;
    private Boolean atesakiPrint;
    private RString jyukyuJigyoTaisho;
    private RString juminZei;
    private TextBoxNum gokeiShotoku;
    private TextBoxNum nenkinShunyu;
    private TextBoxNum nenkinShotoku;
    private TextBoxNum kazeiShotokuKojomae;
    private TextBoxNum kazeiShotokuKojogo;
    private Boolean zennenSetainushi;
    private RString shikibetsuTaishoKubun;

    public dgMeisai_Row() {
        super();
        this.shikibetsuCode = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.name = RString.EMPTY;
        this.birthYMD = RString.EMPTY;
        this.gender = RString.EMPTY;
        this.age = RString.EMPTY;
        this.zokugara = RString.EMPTY;
        this.kotekiNenkin = new TextBoxNum();
        this.kyuyo = new TextBoxNum();
        this.otherIncome = new TextBoxNum();
        this.memo = new ImageDialog();
        this.atesakiPrint = false;
        this.jyukyuJigyoTaisho = RString.EMPTY;
        this.juminZei = RString.EMPTY;
        this.gokeiShotoku = new TextBoxNum();
        this.nenkinShunyu = new TextBoxNum();
        this.nenkinShotoku = new TextBoxNum();
        this.kazeiShotokuKojomae = new TextBoxNum();
        this.kazeiShotokuKojogo = new TextBoxNum();
        this.zennenSetainushi = false;
        this.shikibetsuTaishoKubun = RString.EMPTY;
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("name", name);
        this.setOriginalData("birthYMD", birthYMD);
        this.setOriginalData("gender", gender);
        this.setOriginalData("age", age);
        this.setOriginalData("zokugara", zokugara);
        this.setOriginalData("kotekiNenkin", kotekiNenkin);
        this.setOriginalData("kyuyo", kyuyo);
        this.setOriginalData("otherIncome", otherIncome);
        this.setOriginalData("memo", memo);
        this.setOriginalData("atesakiPrint", atesakiPrint);
        this.setOriginalData("jyukyuJigyoTaisho", jyukyuJigyoTaisho);
        this.setOriginalData("juminZei", juminZei);
        this.setOriginalData("gokeiShotoku", gokeiShotoku);
        this.setOriginalData("nenkinShunyu", nenkinShunyu);
        this.setOriginalData("nenkinShotoku", nenkinShotoku);
        this.setOriginalData("kazeiShotokuKojomae", kazeiShotokuKojomae);
        this.setOriginalData("kazeiShotokuKojogo", kazeiShotokuKojogo);
        this.setOriginalData("zennenSetainushi", zennenSetainushi);
        this.setOriginalData("shikibetsuTaishoKubun", shikibetsuTaishoKubun);
    }

    public dgMeisai_Row(RString shikibetsuCode, RString hihokenshaNo, RString name, RString birthYMD, RString gender, RString age, RString zokugara, TextBoxNum kotekiNenkin, TextBoxNum kyuyo, TextBoxNum otherIncome, ImageDialog memo, Boolean atesakiPrint, RString jyukyuJigyoTaisho, RString juminZei, TextBoxNum gokeiShotoku, TextBoxNum nenkinShunyu, TextBoxNum nenkinShotoku, TextBoxNum kazeiShotokuKojomae, TextBoxNum kazeiShotokuKojogo, Boolean zennenSetainushi, RString shikibetsuTaishoKubun) {
        super();
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("name", name);
        this.setOriginalData("birthYMD", birthYMD);
        this.setOriginalData("gender", gender);
        this.setOriginalData("age", age);
        this.setOriginalData("zokugara", zokugara);
        this.setOriginalData("kotekiNenkin", kotekiNenkin);
        this.setOriginalData("kyuyo", kyuyo);
        this.setOriginalData("otherIncome", otherIncome);
        this.setOriginalData("memo", memo);
        this.setOriginalData("atesakiPrint", atesakiPrint);
        this.setOriginalData("jyukyuJigyoTaisho", jyukyuJigyoTaisho);
        this.setOriginalData("juminZei", juminZei);
        this.setOriginalData("gokeiShotoku", gokeiShotoku);
        this.setOriginalData("nenkinShunyu", nenkinShunyu);
        this.setOriginalData("nenkinShotoku", nenkinShotoku);
        this.setOriginalData("kazeiShotokuKojomae", kazeiShotokuKojomae);
        this.setOriginalData("kazeiShotokuKojogo", kazeiShotokuKojogo);
        this.setOriginalData("zennenSetainushi", zennenSetainushi);
        this.setOriginalData("shikibetsuTaishoKubun", shikibetsuTaishoKubun);
        this.shikibetsuCode = shikibetsuCode;
        this.hihokenshaNo = hihokenshaNo;
        this.name = name;
        this.birthYMD = birthYMD;
        this.gender = gender;
        this.age = age;
        this.zokugara = zokugara;
        this.kotekiNenkin = kotekiNenkin;
        this.kyuyo = kyuyo;
        this.otherIncome = otherIncome;
        this.memo = memo;
        this.atesakiPrint = atesakiPrint;
        this.jyukyuJigyoTaisho = jyukyuJigyoTaisho;
        this.juminZei = juminZei;
        this.gokeiShotoku = gokeiShotoku;
        this.nenkinShunyu = nenkinShunyu;
        this.nenkinShotoku = nenkinShotoku;
        this.kazeiShotokuKojomae = kazeiShotokuKojomae;
        this.kazeiShotokuKojogo = kazeiShotokuKojogo;
        this.zennenSetainushi = zennenSetainushi;
        this.shikibetsuTaishoKubun = shikibetsuTaishoKubun;
    }

    public dgMeisai_Row(DataGridSetting gridSetting) {
        super();
        this.shikibetsuCode = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.name = RString.EMPTY;
        this.birthYMD = RString.EMPTY;
        this.gender = RString.EMPTY;
        this.age = RString.EMPTY;
        this.zokugara = RString.EMPTY;
        this.kotekiNenkin = new TextBoxNum();
        this.kyuyo = new TextBoxNum();
        this.otherIncome = new TextBoxNum();
        this.memo = ImageDialog.createInstance(gridSetting.getColumn("memo").getCellDetails());
        this.atesakiPrint = false;
        this.jyukyuJigyoTaisho = RString.EMPTY;
        this.juminZei = RString.EMPTY;
        this.gokeiShotoku = new TextBoxNum();
        this.nenkinShunyu = new TextBoxNum();
        this.nenkinShotoku = new TextBoxNum();
        this.kazeiShotokuKojomae = new TextBoxNum();
        this.kazeiShotokuKojogo = new TextBoxNum();
        this.zennenSetainushi = false;
        this.shikibetsuTaishoKubun = RString.EMPTY;
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("name", name);
        this.setOriginalData("birthYMD", birthYMD);
        this.setOriginalData("gender", gender);
        this.setOriginalData("age", age);
        this.setOriginalData("zokugara", zokugara);
        this.setOriginalData("kotekiNenkin", kotekiNenkin);
        this.setOriginalData("kyuyo", kyuyo);
        this.setOriginalData("otherIncome", otherIncome);
        this.setOriginalData("memo", memo);
        this.setOriginalData("atesakiPrint", atesakiPrint);
        this.setOriginalData("jyukyuJigyoTaisho", jyukyuJigyoTaisho);
        this.setOriginalData("juminZei", juminZei);
        this.setOriginalData("gokeiShotoku", gokeiShotoku);
        this.setOriginalData("nenkinShunyu", nenkinShunyu);
        this.setOriginalData("nenkinShotoku", nenkinShotoku);
        this.setOriginalData("kazeiShotokuKojomae", kazeiShotokuKojomae);
        this.setOriginalData("kazeiShotokuKojogo", kazeiShotokuKojogo);
        this.setOriginalData("zennenSetainushi", zennenSetainushi);
        this.setOriginalData("shikibetsuTaishoKubun", shikibetsuTaishoKubun);
    }

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getName() {
        return name;
    }

    public RString getBirthYMD() {
        return birthYMD;
    }

    public RString getGender() {
        return gender;
    }

    public RString getAge() {
        return age;
    }

    public RString getZokugara() {
        return zokugara;
    }

    public TextBoxNum getKotekiNenkin() {
        return kotekiNenkin;
    }

    public TextBoxNum getKyuyo() {
        return kyuyo;
    }

    public TextBoxNum getOtherIncome() {
        return otherIncome;
    }

    public ImageDialog getMemo() {
        return memo;
    }

    public Boolean getAtesakiPrint() {
        return atesakiPrint;
    }

    public RString getJyukyuJigyoTaisho() {
        return jyukyuJigyoTaisho;
    }

    public RString getJuminZei() {
        return juminZei;
    }

    public TextBoxNum getGokeiShotoku() {
        return gokeiShotoku;
    }

    public TextBoxNum getNenkinShunyu() {
        return nenkinShunyu;
    }

    public TextBoxNum getNenkinShotoku() {
        return nenkinShotoku;
    }

    public TextBoxNum getKazeiShotokuKojomae() {
        return kazeiShotokuKojomae;
    }

    public TextBoxNum getKazeiShotokuKojogo() {
        return kazeiShotokuKojogo;
    }

    public Boolean getZennenSetainushi() {
        return zennenSetainushi;
    }

    public RString getShikibetsuTaishoKubun() {
        return shikibetsuTaishoKubun;
    }

    public void setShikibetsuCode(RString shikibetsuCode) {
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shikibetsuCode = shikibetsuCode;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setName(RString name) {
        this.setOriginalData("name", name);
        this.name = name;
    }

    public void setBirthYMD(RString birthYMD) {
        this.setOriginalData("birthYMD", birthYMD);
        this.birthYMD = birthYMD;
    }

    public void setGender(RString gender) {
        this.setOriginalData("gender", gender);
        this.gender = gender;
    }

    public void setAge(RString age) {
        this.setOriginalData("age", age);
        this.age = age;
    }

    public void setZokugara(RString zokugara) {
        this.setOriginalData("zokugara", zokugara);
        this.zokugara = zokugara;
    }

    public void setKotekiNenkin(TextBoxNum kotekiNenkin) {
        this.setOriginalData("kotekiNenkin", kotekiNenkin);
        this.kotekiNenkin = kotekiNenkin;
    }

    public void setKyuyo(TextBoxNum kyuyo) {
        this.setOriginalData("kyuyo", kyuyo);
        this.kyuyo = kyuyo;
    }

    public void setOtherIncome(TextBoxNum otherIncome) {
        this.setOriginalData("otherIncome", otherIncome);
        this.otherIncome = otherIncome;
    }

    public void setMemo(ImageDialog memo) {
        this.setOriginalData("memo", memo);
        this.memo = memo;
    }

    public void setAtesakiPrint(Boolean atesakiPrint) {
        this.setOriginalData("atesakiPrint", atesakiPrint);
        this.atesakiPrint = atesakiPrint;
    }

    public void setJyukyuJigyoTaisho(RString jyukyuJigyoTaisho) {
        this.setOriginalData("jyukyuJigyoTaisho", jyukyuJigyoTaisho);
        this.jyukyuJigyoTaisho = jyukyuJigyoTaisho;
    }

    public void setJuminZei(RString juminZei) {
        this.setOriginalData("juminZei", juminZei);
        this.juminZei = juminZei;
    }

    public void setGokeiShotoku(TextBoxNum gokeiShotoku) {
        this.setOriginalData("gokeiShotoku", gokeiShotoku);
        this.gokeiShotoku = gokeiShotoku;
    }

    public void setNenkinShunyu(TextBoxNum nenkinShunyu) {
        this.setOriginalData("nenkinShunyu", nenkinShunyu);
        this.nenkinShunyu = nenkinShunyu;
    }

    public void setNenkinShotoku(TextBoxNum nenkinShotoku) {
        this.setOriginalData("nenkinShotoku", nenkinShotoku);
        this.nenkinShotoku = nenkinShotoku;
    }

    public void setKazeiShotokuKojomae(TextBoxNum kazeiShotokuKojomae) {
        this.setOriginalData("kazeiShotokuKojomae", kazeiShotokuKojomae);
        this.kazeiShotokuKojomae = kazeiShotokuKojomae;
    }

    public void setKazeiShotokuKojogo(TextBoxNum kazeiShotokuKojogo) {
        this.setOriginalData("kazeiShotokuKojogo", kazeiShotokuKojogo);
        this.kazeiShotokuKojogo = kazeiShotokuKojogo;
    }

    public void setZennenSetainushi(Boolean zennenSetainushi) {
        this.setOriginalData("zennenSetainushi", zennenSetainushi);
        this.zennenSetainushi = zennenSetainushi;
    }

    public void setShikibetsuTaishoKubun(RString shikibetsuTaishoKubun) {
        this.setOriginalData("shikibetsuTaishoKubun", shikibetsuTaishoKubun);
        this.shikibetsuTaishoKubun = shikibetsuTaishoKubun;
    }

    // </editor-fold>
}
