package jp.co.ndensan.reams.db.dbz.definition.mybatis.param.jukyushikakushomeishohakko;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給資格証明書発行情報の検索キー。
 *
 * @reamsid_L DBA-1090-020 wangkun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class JukyuShikakuShomeishoHakkoParameter {

    private final RString hihokenshaNo;
    private final RString serviceShuruiCd;
    private final RString shinseishoKanriNo;
    private final RString nowDateYearMonth;
    private final RString yukoMukoKubun;
    private final RString psmShikibetsuTaisho;

    private JukyuShikakuShomeishoHakkoParameter(RString hihokenshaNo, RString serviceShuruiCd, RString shinseishoKanriNo, RString yukoMukoKubun,
            RString psmShikibetsuTaisho) {

        this.serviceShuruiCd = serviceShuruiCd;
        this.hihokenshaNo = hihokenshaNo;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.nowDateYearMonth = FlexibleDate.getNowDate().getYearMonth().toDateString();
        this.yukoMukoKubun = yukoMukoKubun;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * 被保険者番号より、受給資格証明書発行情報の検索キーを作成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 有効無効区分_有効 有効無効区分_有効
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @return JukyuShikakuShomeishoHakkoParameter
     */
    public static JukyuShikakuShomeishoHakkoParameter createSelectBy被保険者番号(RString 被保険者番号, RString 有効無効区分_有効,
            RString psmShikibetsuTaisho) {
        return new JukyuShikakuShomeishoHakkoParameter(被保険者番号, null, null, 有効無効区分_有効, psmShikibetsuTaisho);
    }

    /**
     * サービス種類コードより、受給資格証明書発行情報の検索キーを作成します。
     *
     * @param サービス種類コード サービス種類コード
     * @param 有効無効区分_有効 有効無効区分_有効
     * @return JukyuShikakuShomeishoHakkoParameter
     */
    public static JukyuShikakuShomeishoHakkoParameter createSelectByサービス種類コード(RString サービス種類コード,
            RString 有効無効区分_有効) {
        return new JukyuShikakuShomeishoHakkoParameter(null, サービス種類コード, null, 有効無効区分_有効, null);
    }

    /**
     * 申請書管理番号より、受給資格証明書発行情報の検索キーを作成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return JukyuShikakuShomeishoHakkoParameter
     */
    public static JukyuShikakuShomeishoHakkoParameter createSelectBy申請書管理番号(RString 申請書管理番号) {
        return new JukyuShikakuShomeishoHakkoParameter(null, null, 申請書管理番号, null, null);
    }
}
