package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu May 08 21:02:36 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSearchResultJigyosha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSearchResultJigyosha_Row extends DataRow {

    private Button select;
    private RString jigyosha;
    private RString jusho;
    private RString service;
    private RString ninteiKaishiDate;
    private RString ninteiShuryoDate;
    private RString keigenTaisho;

    public dgSearchResultJigyosha_Row() {
        super();
    }

    public dgSearchResultJigyosha_Row(Button select, RString jigyosha, RString jusho, RString service, RString ninteiKaishiDate, RString ninteiShuryoDate, RString keigenTaisho) {
        super();
        this.setOriginalData("select", select);
        this.setOriginalData("jigyosha", jigyosha);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("service", service);
        this.setOriginalData("ninteiKaishiDate", ninteiKaishiDate);
        this.setOriginalData("ninteiShuryoDate", ninteiShuryoDate);
        this.setOriginalData("keigenTaisho", keigenTaisho);
        this.select = select;
        this.jigyosha = jigyosha;
        this.jusho = jusho;
        this.service = service;
        this.ninteiKaishiDate = ninteiKaishiDate;
        this.ninteiShuryoDate = ninteiShuryoDate;
        this.keigenTaisho = keigenTaisho;
    }

    public Button getSelect() {
        return select;
    }

    public RString getJigyosha() {
        return jigyosha;
    }

    public RString getJusho() {
        return jusho;
    }

    public RString getService() {
        return service;
    }

    public RString getNinteiKaishiDate() {
        return ninteiKaishiDate;
    }

    public RString getNinteiShuryoDate() {
        return ninteiShuryoDate;
    }

    public RString getKeigenTaisho() {
        return keigenTaisho;
    }

    public void setSelect(Button select) {
        this.setOriginalData("select", select);
        this.select = select;
    }

    public void setJigyosha(RString jigyosha) {
        this.setOriginalData("jigyosha", jigyosha);
        this.jigyosha = jigyosha;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    public void setService(RString service) {
        this.setOriginalData("service", service);
        this.service = service;
    }

    public void setNinteiKaishiDate(RString ninteiKaishiDate) {
        this.setOriginalData("ninteiKaishiDate", ninteiKaishiDate);
        this.ninteiKaishiDate = ninteiKaishiDate;
    }

    public void setNinteiShuryoDate(RString ninteiShuryoDate) {
        this.setOriginalData("ninteiShuryoDate", ninteiShuryoDate);
        this.ninteiShuryoDate = ninteiShuryoDate;
    }

    public void setKeigenTaisho(RString keigenTaisho) {
        this.setOriginalData("keigenTaisho", keigenTaisho);
        this.keigenTaisho = keigenTaisho;
    }

}