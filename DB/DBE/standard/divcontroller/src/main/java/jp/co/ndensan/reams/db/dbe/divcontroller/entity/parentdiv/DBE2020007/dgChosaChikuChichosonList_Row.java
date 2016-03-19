package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020007;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Mar 18 10:37:04 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgChosaChikuChichosonList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosaChikuChichosonList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private RString jotai;
    private RString yusenNo;
    private RString cityCode;
    private RString cityName;
    private Boolean jichiku;

    public dgChosaChikuChichosonList_Row() {
        super();
        this.jotai = RString.EMPTY;
        this.yusenNo = RString.EMPTY;
        this.cityCode = RString.EMPTY;
        this.cityName = RString.EMPTY;
        this.jichiku = false;
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("yusenNo", yusenNo);
        this.setOriginalData("cityCode", cityCode);
        this.setOriginalData("cityName", cityName);
        this.setOriginalData("jichiku", jichiku);
    }

    public dgChosaChikuChichosonList_Row(RString jotai, RString yusenNo, RString cityCode, RString cityName, Boolean jichiku) {
        super();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("yusenNo", yusenNo);
        this.setOriginalData("cityCode", cityCode);
        this.setOriginalData("cityName", cityName);
        this.setOriginalData("jichiku", jichiku);
        this.jotai = jotai;
        this.yusenNo = yusenNo;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.jichiku = jichiku;
    }

    public RString getJotai() {
        return jotai;
    }

    public RString getYusenNo() {
        return yusenNo;
    }

    public RString getCityCode() {
        return cityCode;
    }

    public RString getCityName() {
        return cityName;
    }

    public Boolean getJichiku() {
        return jichiku;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setYusenNo(RString yusenNo) {
        this.setOriginalData("yusenNo", yusenNo);
        this.yusenNo = yusenNo;
    }

    public void setCityCode(RString cityCode) {
        this.setOriginalData("cityCode", cityCode);
        this.cityCode = cityCode;
    }

    public void setCityName(RString cityName) {
        this.setOriginalData("cityName", cityName);
        this.cityName = cityName;
    }

    public void setJichiku(Boolean jichiku) {
        this.setOriginalData("jichiku", jichiku);
        this.jichiku = jichiku;
    }

    // </editor-fold>
}
