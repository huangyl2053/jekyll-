package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KakushuKubun のクラスファイル
 *
 * @reamsid_L DBC-3320-010 chenhui
 */
public class KakushuKubunDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkGendogakuTaishogai")
    private CheckBoxList chkGendogakuTaishogai;
    @JsonProperty("chkGaibuService")
    private CheckBoxList chkGaibuService;
    @JsonProperty("chkTokubetsuChiikiKasn")
    private CheckBoxList chkTokubetsuChiikiKasn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkGendogakuTaishogai
     * @return chkGendogakuTaishogai
     */
    @JsonProperty("chkGendogakuTaishogai")
    public CheckBoxList getChkGendogakuTaishogai() {
        return chkGendogakuTaishogai;
    }

    /*
     * setchkGendogakuTaishogai
     * @param chkGendogakuTaishogai chkGendogakuTaishogai
     */
    @JsonProperty("chkGendogakuTaishogai")
    public void setChkGendogakuTaishogai(CheckBoxList chkGendogakuTaishogai) {
        this.chkGendogakuTaishogai = chkGendogakuTaishogai;
    }

    /*
     * getchkGaibuService
     * @return chkGaibuService
     */
    @JsonProperty("chkGaibuService")
    public CheckBoxList getChkGaibuService() {
        return chkGaibuService;
    }

    /*
     * setchkGaibuService
     * @param chkGaibuService chkGaibuService
     */
    @JsonProperty("chkGaibuService")
    public void setChkGaibuService(CheckBoxList chkGaibuService) {
        this.chkGaibuService = chkGaibuService;
    }

    /*
     * getchkTokubetsuChiikiKasn
     * @return chkTokubetsuChiikiKasn
     */
    @JsonProperty("chkTokubetsuChiikiKasn")
    public CheckBoxList getChkTokubetsuChiikiKasn() {
        return chkTokubetsuChiikiKasn;
    }

    /*
     * setchkTokubetsuChiikiKasn
     * @param chkTokubetsuChiikiKasn chkTokubetsuChiikiKasn
     */
    @JsonProperty("chkTokubetsuChiikiKasn")
    public void setChkTokubetsuChiikiKasn(CheckBoxList chkTokubetsuChiikiKasn) {
        this.chkTokubetsuChiikiKasn = chkTokubetsuChiikiKasn;
    }

    // </editor-fold>
}
