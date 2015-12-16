/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.sikakukanrenidoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.sikakukanrenido.SikakuKanrenIdo;
import jp.co.ndensan.reams.db.dba.definition.param.sikakukanrenido.SikakuKanrenIdoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.SikakuKanrenIdoEntity;
import jp.co.ndensan.reams.db.dba.persistence.mapper.basic.sikakukanrenido.ISikakuKanrenIdoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeishichoson.GappeiShichoson;
import jp.co.ndensan.reams.db.dba.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.sikakujiyushutoku.SikakuJiyuShutoku;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.gappei.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.service.KyuShichosonCode;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.kyushichosoncode.KyuShichosonCodeJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 資格関連異動一覧クラスです。
 */
public class SikakuKanrenIdoFinder {

    private final MapperProvider mapperProvider;
    private final DbT7051KoseiShichosonMasterDac db7051Dac;
    private final SikakuJiyuShutoku sikaku;

    private static final RString コード種別_0126 = new RString("0126");

    /**
     * コンストラクタ。
     *
     */
    public SikakuKanrenIdoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.db7051Dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        this.sikaku = InstanceProvider.create(SikakuJiyuShutoku.class);

    }

    /**
     * クラスをcreateメソッドです。
     *
     * @return 資格関連異動一覧の取得処理するクラス
     */
    public static SikakuKanrenIdoFinder createInstance() {
        return InstanceProvider.create(SikakuKanrenIdoFinder.class);
    }

    /**
     * 一覧データ取得リストを取得する。
     *
     * @param params ShikakuTokusoInputGuideParameter
     * @return SikakuKanrenIdo 一覧データ取得取得リスト
     */
    public SearchResult<SikakuKanrenIdo> getSikakuKanrenIdo(SikakuKanrenIdoParameter params) {
        if (params.getHihokenshaNo().isEmpty() && params.getshikibetsuCode().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り.getMessage().toString());
        }
        ISikakuKanrenIdoMapper shikakuTokusoMappers = mapperProvider.create(ISikakuKanrenIdoMapper.class);
        List<SikakuKanrenIdoEntity> 一覧データ取得リスト = shikakuTokusoMappers.getSikakuKanrenIdo(params);
        if (一覧データ取得リスト != null && 一覧データ取得リスト.isEmpty()) {
            return SearchResult.of(Collections.<SikakuKanrenIdo>emptyList(), 0, false);
        }
        List<SikakuKanrenIdo> serviceShuruiList = new ArrayList<>();
        for (SikakuKanrenIdoEntity entity : 一覧データ取得リスト) {
            serviceShuruiList.add(new SikakuKanrenIdo(entity));

        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }

    /**
     * 所在保険者リスト情報取得。
     *
     * @param systemDate RDate
     * @return List<DbT7051KoseiShichosonMasterEntity>
     */
    @Transaction
    public SearchResult<KoseiShichosonMaster> selectByKoseiShichosonMasterList(RDate systemDate) {

        List<KoseiShichosonMaster> serviceShuruiList = new ArrayList<>();
        List<DbT7051KoseiShichosonMasterEntity> entityList = db7051Dac.selectByKoseiShichosonMasterList(systemDate);
        if (entityList != null && !entityList.isEmpty()) {
            return SearchResult.of(Collections.<KoseiShichosonMaster>emptyList(), 0, false);
        }
        for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
            serviceShuruiList.add(new KoseiShichosonMaster(entity));
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }

    /**
     * 変更事由リスト情報を取得。
     *
     * @return List<GappeiShichoson>
     */
    //TODD QA未回
//    public List<HenkoJiyu> getHenkoJiyuList() {
//        List<HenkoJiyu> 変更事由List = new ArrayList<>();
////        sikaku.shikakuJiyuShutoku(CodeShubetsu.EMPTY, FlexibleDate.MAX, コード種別_0126, コード種別_0126);
////        List<UzT0007CodeEntity> list = sikaku.shikakuJiyuShutoku(CodeShubetsu.EMPTY,
////                FlexibleDate.getNowDate(),
////                コード種別_0126, コード種別_0126
////        );
//
//        return null;
    /**
     * 市町村セキュリティ取得。 旧市町村コード情報を取得NULL戻るを
     *
     * @return List<GappeiShichoson>
     */
    public SearchResult<GappeiShichoson> getGappeiShichosonList() {
        List<GappeiShichoson> 旧市町村コード情報List = new ArrayList<>();

        ShichosonSecurityJoho 市町村セキュリティ = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        KyuShichosonCodeJoho 旧市町村コード情報 = KyuShichosonCode.
                getKyuShichosonCodeJoho(LasdecCode.EMPTY,
                        DonyukeitaiCode.toValue(市町村セキュリティ.get導入形態コード().getKey()));
        if (旧市町村コード情報 == null) {

            return null;
        } else {
            for (KyuShichosonCode entity : 旧市町村コード情報.get旧市町村コード情報List()) {
                DbT7056GappeiShichosonEntity list = new DbT7056GappeiShichosonEntity();
                list.setKyuShichosonCode(entity.get旧市町村コード());
                list.setKyuHokenshaNo(entity.get旧保険者番号());
                list.setKyuShichosonMeisho(entity.get旧市町村名称());
                旧市町村コード情報List.add(new GappeiShichoson(list));
            }
            return SearchResult.of(旧市町村コード情報List, 0, false);
        }
    }
}
