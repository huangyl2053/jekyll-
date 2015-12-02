package jp.co.ndensan.reams.db.dba.definition.mybatis.param.jukyushikakushomeishohakko;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 
 * 受給資格証明書発行情報をキー。
 */
public final class JukyuShikakuShomeishoHakkoParameter {

    private RString hihokenshaNo;
    private RString serviceShuruiCd;
    private RString nowDateYearMonth;
    private RString shinseishoKanriNo;

    private JukyuShikakuShomeishoHakkoParameter() {
    }

    private JukyuShikakuShomeishoHakkoParameter(RString hihokenshaNo, RString serviceShuruiCd, RString shinseishoKanriNo) {
        if (serviceShuruiCd != null) {
            this.serviceShuruiCd = serviceShuruiCd;
        }
        if (hihokenshaNo != null) {
            this.hihokenshaNo = hihokenshaNo;
        }
        if (shinseishoKanriNo != null) {
            this.shinseishoKanriNo = shinseishoKanriNo;
        }
        this.nowDateYearMonth = FlexibleDate.getNowDate().getYearMonth().toDateString();
    }

    /**
     *
     * @param hihokenshaNo
     * @return
     */
    public static JukyuShikakuShomeishoHakkoParameter createSearchParameter_受給資格証明書発行情報(RString hihokenshaNo) {
        JukyuShikakuShomeishoHakkoParameter parameter = new JukyuShikakuShomeishoHakkoParameter(hihokenshaNo, null, null);
        return parameter;
    }

    /**
     *
     * @param serviceShuruiCd
     * @return
     */
    public static JukyuShikakuShomeishoHakkoParameter createSearchParameter_サービス種類コード(RString serviceShuruiCd) {
        JukyuShikakuShomeishoHakkoParameter parameter = new JukyuShikakuShomeishoHakkoParameter(null, serviceShuruiCd, null);
        return parameter;
    }

    /**
     *
     * @param shinseishoKanriNo
     * @return
     */
    public static JukyuShikakuShomeishoHakkoParameter createSearchParameter_認定申請中データ情報(RString shinseishoKanriNo) {
        JukyuShikakuShomeishoHakkoParameter parameter = new JukyuShikakuShomeishoHakkoParameter(null, null, shinseishoKanriNo);
        return parameter;
    }

}
