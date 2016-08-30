/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakugassan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyushinseitoroku.ShinseishoJohoResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyushinseitoroku.ShinseishoJohoSearchParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassanshikyushinseitoroku.IKogakuGassanShikyuShinseiTorokuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukaigoservicehikyufutaishoshatoroku.SetaiShotokuKazeiHantei;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.TextSearchType;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算支給申請書登録のビジネスです。
 *
 * @reamsid_L DBC-2040-040 huzongcheng
 */
public class KogakuGassanShikyuShinseiToroku {

    private final MapperProvider mapperProvider;
    private static final RString 識別コード = new RString("識別コード");
    private static final RString 単一市町村モード = new RString("単一市町村モード");
    private static final RString 広域市町村モード = new RString("広域市町村モード");

    /**
     * コンストラクタです。
     */
    KogakuGassanShikyuShinseiToroku() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    KogakuGassanShikyuShinseiToroku(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SetaiShotokuKazeiHantei}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link SetaiShotokuKazeiHantei}のインスタンス
     */
    public static KogakuGassanShikyuShinseiToroku createInstance() {
        return InstanceProvider.create(KogakuGassanShikyuShinseiToroku.class);
    }

    /**
     * 申請書情報検索データ取得します。
     *
     * @param parameter ShinseishoJohoSearchParameter
     * @return ShinseishoJohoResult
     */
    @Transaction
    public ShinseishoJohoResult getShinseishoJoho(ShinseishoJohoSearchParameter parameter) {
        IKogakuGassanShikyuShinseiTorokuMapper mapper = this.mapperProvider.create(IKogakuGassanShikyuShinseiTorokuMapper.class);
        List<HihokenshaNo> 被保険者番号List = 被保険者番号取得(parameter, mapper);
        if (被保険者番号List == null) {
            return null;
        }
        parameter.set被保険者番号リスト(被保険者番号List);
        ShinseishoJohoResult result = new ShinseishoJohoResult();
        return result;
    }

    /**
     * 証記載保険者番号情報取得します。
     *
     * @return Map<RString, List<KoikiZenShichosonJoho>>
     */
    public Map<RString, List<KoikiZenShichosonJoho>> getHokensyaBango() {
        Map<RString, List<KoikiZenShichosonJoho>> map = new HashMap<>();
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 導入形態コード = shichosonSecurityJoho.get導入形態コード().getKey();
        RString モード = RString.EMPTY;
        if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード)
                || DonyuKeitaiCode.事務構成市町村.getCode().equals(導入形態コード)) {
            モード = 単一市町村モード;
        } else if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード)) {
            モード = 広域市町村モード;
        }
        if (モード.equals(単一市町村モード)) {
            List<KoikiZenShichosonJoho> serchList = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records();
            if (serchList != null && !serchList.isEmpty()) {
                map.put(モード, serchList);
            }
        } else if (モード.equals(単一市町村モード)) {
            List<KoikiZenShichosonJoho> serchList = KoikiShichosonJohoFinder.createInstance().getZenShichosonJoho().records();
            if (serchList != null && !serchList.isEmpty()) {
                map.put(モード, serchList);
            }
        }
        return map.isEmpty() ? null : map;
    }

    private List<HihokenshaNo> 被保険者番号取得(
            ShinseishoJohoSearchParameter parameter, IKogakuGassanShikyuShinseiTorokuMapper mapper) {
        ShikibetsuTaishoSearchKeyBuilder builder = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        builder.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set氏名(parameter.get被保険者氏名());
        if (parameter.is被保険者氏名前方一致()) {
            builder.set方書名称検索方法(TextSearchType.前方一致);
        } else {
            builder.set方書名称検索方法(TextSearchType.完全一致);
        }
        IShikibetsuTaishoSearchKey searchKey = builder.build();
        List<IShikibetsuTaisho> 識別対象
                = ShikibetsuTaishoService.getShikibetsuTaishoFinder().get識別対象s(searchKey);
        if (識別対象 == null) {
            return null;
        }
        List<HihokenshaNo> 被保険者番号List = new ArrayList();
        for (IShikibetsuTaisho item : 識別対象) {
            Map<String, Object> pram = new HashMap<>();
            pram.put(識別コード.toString(), item.get識別コード());
            HihokenshaNo 被保険者番号 = mapper.select被保険者番号(pram);
            if (被保険者番号 != null) {
                被保険者番号List.add(被保険者番号);
            }
        }
        return 被保険者番号List.isEmpty() ? null : 被保険者番号List;
    }
}
