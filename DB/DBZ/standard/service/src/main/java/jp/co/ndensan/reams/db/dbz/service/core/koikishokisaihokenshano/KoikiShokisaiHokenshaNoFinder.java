/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.koikishokisaihokenshano;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeijoho.GappeiCityJyoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.sortjun.GappeiJohoSortOrder;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 広域証記載保険者番号取得です。
 *
 * @reamsid_L DBC-2450-050 zhangrui
 */
public class KoikiShokisaiHokenshaNoFinder {

    private final List<GappeiCityJyoho> 合併市町村情報List;
    private final List<KoikiZenShichosonJoho> 現市町村情報List;

    private static final int INDEX_0 = 0;

    /**
     * コンストラクタです。
     */
    KoikiShokisaiHokenshaNoFinder() {
        GappeiCityJohoBFinder gappeiCityJohoBfinder = GappeiCityJohoBFinder.createInstance();
        SearchResult<GappeiCityJyoho> resultGappei = gappeiCityJohoBfinder.getKouikigappeijoho(RString.EMPTY,
                GappeiJohoSortOrder.国保連データ連携開始日);
        合併市町村情報List = resultGappei.records();
        KoikiShichosonJohoFinder koikiShichosonJohoFinder = KoikiShichosonJohoFinder.createInstance();
        SearchResult<KoikiZenShichosonJoho> resultKoiki = koikiShichosonJohoFinder.getGenShichosonJoho();
        現市町村情報List = resultKoiki.records();
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KoikiShokisaiHokenshaNoFinder}のインスタンスを返します。
     *
     * @return KoikiShokisaiHokenshaNoFinder KoikiShokisaiHokenshaNoFinder
     */
    public static KoikiShokisaiHokenshaNoFinder createInstance() {

        return InstanceProvider.create(KoikiShokisaiHokenshaNoFinder.class);
    }

    /**
     * 指定された市町村コードの基準日時点の証記載保険者番号を取得します。
     *
     * @param 市町村コード LasdecCode
     * @param 基準年月 FlexibleYearMonth
     * @return ShoKisaiHokenshaNo 証記載保険者番号を取得できなかった場合、nullを返す
     */
    @Transaction
    public ShoKisaiHokenshaNo getShokisaiHokenshaNo(LasdecCode 市町村コード, FlexibleYearMonth 基準年月) {
        List<GappeiCityJyoho> removeList = new ArrayList<>();
        if (null != 合併市町村情報List && !合併市町村情報List.isEmpty()) {
            for (GappeiCityJyoho 合併市町村情報 : 合併市町村情報List) {
                if (!市町村コード.equals(合併市町村情報.get市町村コード())) {
                    removeList.add(合併市町村情報);
                }
            }
            合併市町村情報List.removeAll(removeList);
            if (!合併市町村情報List.isEmpty() && 合併市町村情報List.get(INDEX_0).get国保連データ連携開始年月日()
                    .getYearMonth().isBeforeOrEquals(基準年月)) {
                RString 証記載保険者番号 = 合併市町村情報List.get(INDEX_0).get保険者番号().getColumnValue();
                return new ShoKisaiHokenshaNo(証記載保険者番号);
            }
            int lastIndex = 合併市町村情報List.size() - 1;
            if (!合併市町村情報List.isEmpty() && 基準年月.isBefore(合併市町村情報List.get(lastIndex)
                    .get国保連データ連携開始年月日().getYearMonth())) {
                RString 証記載保険者番号 = 合併市町村情報List.get(lastIndex).get保険者番号().getColumnValue();
                return new ShoKisaiHokenshaNo(証記載保険者番号);
            }
        }
        if (null != 現市町村情報List && !現市町村情報List.isEmpty()) {
            for (KoikiZenShichosonJoho 現市町村情報 : 現市町村情報List) {
                if (市町村コード.equals(現市町村情報.get市町村コード())) {
                    return 現市町村情報.get証記載保険者番号();
                }
            }
        }
        return null;
    }

}
