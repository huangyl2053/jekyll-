package jp.co.ndensan.reams.db.dba.definition.mybatis.param.jukyushikakushomeishohakko;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給資格証明書発行情報の検索キー。
 * 
 * @author wangkun
 */
@lombok.Getter
public final class JukyuShikakuShomeishoHakkoParameter {

    private RString hihokenshaNo;
    private RString serviceShuruiCd;
    private RString shinseishoKanriNo;
    private final RString nowDateYearMonth;

    private JukyuShikakuShomeishoHakkoParameter(RString hihokenshaNo
            , RString serviceShuruiCd, RString shinseishoKanriNo) {
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
     *　被保険者番号より、受給資格証明書発行情報の検索キーを作成します。
     * 
     * @param 被保険者番号 被保険者番号
     * @return JukyuShikakuShomeishoHakkoParameter
     */
    public static JukyuShikakuShomeishoHakkoParameter createSelectBy被保険者番号(RString 被保険者番号) {
        JukyuShikakuShomeishoHakkoParameter parameter = new JukyuShikakuShomeishoHakkoParameter(被保険者番号
                , null, null);
        return parameter;
    }

    /**
     * サービス種類コードより、受給資格証明書発行情報の検索キーを作成します。
     * 
     * @param サービス種類コード サービス種類コード
     * @return JukyuShikakuShomeishoHakkoParameter
     */
    public static JukyuShikakuShomeishoHakkoParameter createSelectByサービス種類コード(RString サービス種類コード) {
        JukyuShikakuShomeishoHakkoParameter parameter = new JukyuShikakuShomeishoHakkoParameter(null
                , サービス種類コード, null);
        return parameter;
    }

    /**
     * 申請書管理番号より、受給資格証明書発行情報の検索キーを作成します。
     * 
     * @param 申請書管理番号 申請書管理番号
     * @return JukyuShikakuShomeishoHakkoParameter
     */
    public static JukyuShikakuShomeishoHakkoParameter createSelectBy申請書管理番号(RString 申請書管理番号) {
        JukyuShikakuShomeishoHakkoParameter parameter = new JukyuShikakuShomeishoHakkoParameter(null
                , null, 申請書管理番号);
        return parameter;
    }
}
