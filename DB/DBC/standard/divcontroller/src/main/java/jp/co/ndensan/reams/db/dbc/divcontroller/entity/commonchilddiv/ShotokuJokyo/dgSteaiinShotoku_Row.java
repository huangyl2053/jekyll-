package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShotokuJokyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Aug 30 09:51:06 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.ImageDialog;

/**
 * dgSteaiinShotoku_Row のクラスファイル
 *
 * @reamsid_L DBC-4620-030 zhouchuanlin
 */
public class dgSteaiinShotoku_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString shikibetsuCode;
    private RString hihokenshaNo;
    private RString name;
    private RString birthYMD;
    private RString gender;
    private RString age;
    private RString zokugara;
    private RString shubetsu;
    private RString idoYMD;
    private ImageDialog memo;
    private RString juminZei;
    private RString gokeiShotoku;
    private RString nenkinShunyu;
    private RString nenkinShotoku;
    private RString kazeiShotoku;
    private RString koseiYMD;
    private RString shikibetsuTaishoKubun;

    public dgSteaiinShotoku_Row() {
        super();
        this.shikibetsuCode = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.name = RString.EMPTY;
        this.birthYMD = RString.EMPTY;
        this.gender = RString.EMPTY;
        this.age = RString.EMPTY;
        this.zokugara = RString.EMPTY;
        this.shubetsu = RString.EMPTY;
        this.idoYMD = RString.EMPTY;
        this.memo = new ImageDialog();
        this.juminZei = RString.EMPTY;
        this.gokeiShotoku = RString.EMPTY;
        this.nenkinShunyu = RString.EMPTY;
        this.nenkinShotoku = RString.EMPTY;
        this.kazeiShotoku = RString.EMPTY;
        this.koseiYMD = RString.EMPTY;
        this.shikibetsuTaishoKubun = RString.EMPTY;
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("name", name);
        this.setOriginalData("birthYMD", birthYMD);
        this.setOriginalData("gender", gender);
        this.setOriginalData("age", age);
        this.setOriginalData("zokugara", zokugara);
        this.setOriginalData("shubetsu", shubetsu);
        this.setOriginalData("idoYMD", idoYMD);
        this.setOriginalData("memo", memo);
        this.setOriginalData("juminZei", juminZei);
        this.setOriginalData("gokeiShotoku", gokeiShotoku);
        this.setOriginalData("nenkinShunyu", nenkinShunyu);
        this.setOriginalData("nenkinShotoku", nenkinShotoku);
        this.setOriginalData("kazeiShotoku", kazeiShotoku);
        this.setOriginalData("koseiYMD", koseiYMD);
        this.setOriginalData("shikibetsuTaishoKubun", shikibetsuTaishoKubun);
    }

    public dgSteaiinShotoku_Row(RString shikibetsuCode, RString hihokenshaNo, RString name, RString birthYMD, RString gender, RString age, RString zokugara, RString shubetsu, RString idoYMD, ImageDialog memo, RString juminZei, RString gokeiShotoku, RString nenkinShunyu, RString nenkinShotoku, RString kazeiShotoku, RString koseiYMD, RString shikibetsuTaishoKubun) {
        super();
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("name", name);
        this.setOriginalData("birthYMD", birthYMD);
        this.setOriginalData("gender", gender);
        this.setOriginalData("age", age);
        this.setOriginalData("zokugara", zokugara);
        this.setOriginalData("shubetsu", shubetsu);
        this.setOriginalData("idoYMD", idoYMD);
        this.setOriginalData("memo", memo);
        this.setOriginalData("juminZei", juminZei);
        this.setOriginalData("gokeiShotoku", gokeiShotoku);
        this.setOriginalData("nenkinShunyu", nenkinShunyu);
        this.setOriginalData("nenkinShotoku", nenkinShotoku);
        this.setOriginalData("kazeiShotoku", kazeiShotoku);
        this.setOriginalData("koseiYMD", koseiYMD);
        this.setOriginalData("shikibetsuTaishoKubun", shikibetsuTaishoKubun);
        this.shikibetsuCode = shikibetsuCode;
        this.hihokenshaNo = hihokenshaNo;
        this.name = name;
        this.birthYMD = birthYMD;
        this.gender = gender;
        this.age = age;
        this.zokugara = zokugara;
        this.shubetsu = shubetsu;
        this.idoYMD = idoYMD;
        this.memo = memo;
        this.juminZei = juminZei;
        this.gokeiShotoku = gokeiShotoku;
        this.nenkinShunyu = nenkinShunyu;
        this.nenkinShotoku = nenkinShotoku;
        this.kazeiShotoku = kazeiShotoku;
        this.koseiYMD = koseiYMD;
        this.shikibetsuTaishoKubun = shikibetsuTaishoKubun;
    }

    public dgSteaiinShotoku_Row(DataGridSetting gridSetting) {
        super();
        this.shikibetsuCode = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.name = RString.EMPTY;
        this.birthYMD = RString.EMPTY;
        this.gender = RString.EMPTY;
        this.age = RString.EMPTY;
        this.zokugara = RString.EMPTY;
        this.shubetsu = RString.EMPTY;
        this.idoYMD = RString.EMPTY;
        this.memo = ImageDialog.createInstance(gridSetting.getColumn("memo").getCellDetails());
        this.juminZei = RString.EMPTY;
        this.gokeiShotoku = RString.EMPTY;
        this.nenkinShunyu = RString.EMPTY;
        this.nenkinShotoku = RString.EMPTY;
        this.kazeiShotoku = RString.EMPTY;
        this.koseiYMD = RString.EMPTY;
        this.shikibetsuTaishoKubun = RString.EMPTY;
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("name", name);
        this.setOriginalData("birthYMD", birthYMD);
        this.setOriginalData("gender", gender);
        this.setOriginalData("age", age);
        this.setOriginalData("zokugara", zokugara);
        this.setOriginalData("shubetsu", shubetsu);
        this.setOriginalData("idoYMD", idoYMD);
        this.setOriginalData("memo", memo);
        this.setOriginalData("juminZei", juminZei);
        this.setOriginalData("gokeiShotoku", gokeiShotoku);
        this.setOriginalData("nenkinShunyu", nenkinShunyu);
        this.setOriginalData("nenkinShotoku", nenkinShotoku);
        this.setOriginalData("kazeiShotoku", kazeiShotoku);
        this.setOriginalData("koseiYMD", koseiYMD);
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

    public RString getShubetsu() {
        return shubetsu;
    }

    public RString getIdoYMD() {
        return idoYMD;
    }

    public ImageDialog getMemo() {
        return memo;
    }

    public RString getJuminZei() {
        return juminZei;
    }

    public RString getGokeiShotoku() {
        return gokeiShotoku;
    }

    public RString getNenkinShunyu() {
        return nenkinShunyu;
    }

    public RString getNenkinShotoku() {
        return nenkinShotoku;
    }

    public RString getKazeiShotoku() {
        return kazeiShotoku;
    }

    public RString getKoseiYMD() {
        return koseiYMD;
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

    public void setShubetsu(RString shubetsu) {
        this.setOriginalData("shubetsu", shubetsu);
        this.shubetsu = shubetsu;
    }

    public void setIdoYMD(RString idoYMD) {
        this.setOriginalData("idoYMD", idoYMD);
        this.idoYMD = idoYMD;
    }

    public void setMemo(ImageDialog memo) {
        this.setOriginalData("memo", memo);
        this.memo = memo;
    }

    public void setJuminZei(RString juminZei) {
        this.setOriginalData("juminZei", juminZei);
        this.juminZei = juminZei;
    }

    public void setGokeiShotoku(RString gokeiShotoku) {
        this.setOriginalData("gokeiShotoku", gokeiShotoku);
        this.gokeiShotoku = gokeiShotoku;
    }

    public void setNenkinShunyu(RString nenkinShunyu) {
        this.setOriginalData("nenkinShunyu", nenkinShunyu);
        this.nenkinShunyu = nenkinShunyu;
    }

    public void setNenkinShotoku(RString nenkinShotoku) {
        this.setOriginalData("nenkinShotoku", nenkinShotoku);
        this.nenkinShotoku = nenkinShotoku;
    }

    public void setKazeiShotoku(RString kazeiShotoku) {
        this.setOriginalData("kazeiShotoku", kazeiShotoku);
        this.kazeiShotoku = kazeiShotoku;
    }

    public void setKoseiYMD(RString koseiYMD) {
        this.setOriginalData("koseiYMD", koseiYMD);
        this.koseiYMD = koseiYMD;
    }

    public void setShikibetsuTaishoKubun(RString shikibetsuTaishoKubun) {
        this.setOriginalData("shikibetsuTaishoKubun", shikibetsuTaishoKubun);
        this.shikibetsuTaishoKubun = shikibetsuTaishoKubun;
    }

    // </editor-fold>
}
