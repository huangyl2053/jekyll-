package jp.co.ndensan.reams.db.dbz.definition.mybatis.param.jukyushikakushomeishohakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給資格証明書発行情報の検索キー。
 *
 * @reamsid_L DBA-1090-021 wangkun
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
     * @return JukyuShikakuShomeishoHakkoParameter
     */
    public static JukyuShikakuShomeishoHakkoParameter createSelectBy被保険者番号(RString 被保険者番号, RString 有効無効区分_有効) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.未定義), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        List<JuminJotai> 住民状態 = new ArrayList();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.外国人);
        住民状態.add(JuminJotai.住民);
        住民状態.add(JuminJotai.住登外);
        住民状態.add(JuminJotai.消除者);
        住民状態.add(JuminJotai.転出者);
        key.set住民種別(住民種別);
        key.set住民状態(住民状態);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        return new JukyuShikakuShomeishoHakkoParameter(被保険者番号, null, null, 有効無効区分_有効,
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
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
