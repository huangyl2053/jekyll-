/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihousyosai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dba.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dba.business.shichoson.ShichosonBusiness;
import jp.co.ndensan.reams.db.dba.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihousyosai.HihousyosaiFinderParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.service.KyuShichosonCode;
import jp.co.ndensan.reams.db.dbz.service.kyushichosoncode.KyuShichosonCodeJoho;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保詳細のクラスです。
 */
public class HihousyosaiFinder {

    private final DbT7051KoseiShichosonMasterDac dbT7051Dac;
    private final DbT1001HihokenshaDaichoDac dbT1001Dac;

    /**
     * コンストラクタです。
     */
    public HihousyosaiFinder() {
        dbT7051Dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param dbT7051Dac DbT7051KoseiShichosonMasterDac
     * @param dbT1001dac DbT1001HihokenshaDaichoDac
     */
    HihousyosaiFinder(
            DbT7051KoseiShichosonMasterDac dbT7051Dac,
            DbT1001HihokenshaDaichoDac dbT1001dac
    ) {
        this.dbT7051Dac = dbT7051Dac;
        this.dbT1001Dac = dbT1001dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihousyosaiFinder}のインスタンスを返します。
     *
     * @return HihousyosaiFinder
     */
    public static HihousyosaiFinder createInstance() {
        return InstanceProvider.create(HihousyosaiFinder.class);
    }

    /**
     * 所在保険者リスト情報取得です。
     *
     * @return List<KoseiShichosonMaster> 構成市町村マスタリスト
     */
    @Transaction
    public SearchResult<KoseiShichosonMaster> getKoseiShichosonMasterList() {
        List<KoseiShichosonMaster> businessList = new ArrayList<>();
        List<DbT7051KoseiShichosonMasterEntity> entityList = dbT7051Dac.selectByGappeiKyuShichosonKubun();
        for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
            businessList.add(new KoseiShichosonMaster(entity));
        }

        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 旧保険者リスト情報取得します。
     *
     * @param params 被保詳細パラメータ
     * @return List<Shichoson>
     */
    @Transaction
    public SearchResult<ShichosonBusiness> getGappeiShichosonList(HihousyosaiFinderParameter params) {
        List<ShichosonBusiness> kyuhokenshaList = new ArrayList<>();
        ShichosonBusiness business = new ShichosonBusiness();
        KyuShichosonCodeJoho kyuushichouson = new KyuShichosonCodeJoho();
        //TODO 方法のパラメータ数が一緻しない QA回答まち。
//        KyuShichosonCode.getKyuShichosonCodeJoho(LasdecCode.EMPTY, DonyukeitaiCode.事務広域);
        List<KyuShichosonCode> kyuushichousonList = kyuushichouson.get旧市町村コード情報List();
        if (kyuushichousonList == null) {
            return null;
        }
        if (kyuushichousonList != null) {
            for (KyuShichosonCode hokenshaList : kyuushichousonList) {
                business.set旧市町村コード(hokenshaList.get旧市町村コード());
                business.set旧市町村名称(hokenshaList.get旧市町村名称());
                kyuhokenshaList.add(business);
            }
        }
        return SearchResult.of(kyuhokenshaList, 0, false);
    }

    /**
     * 得喪情報取得です。
     *
     * @param params 被保詳細パラメータ
     * @return 被保険者台帳管理オブジェクト HihokenshaDaicho
     */
    @Transaction
    public HihokenshaDaicho getTokusouJoho(HihousyosaiFinderParameter params) {
        DbT1001HihokenshaDaichoEntity entity = dbT1001Dac.selectByHihokenshaNo(
                params.getHihokenshaNo(),
                params.getIdoYMD(),
                params.getEdaNo());
        if (entity == null) {
            return null;
        }

        return new HihokenshaDaicho(entity);
    }

    /**
     * 被保区分リスト情報取得です。
     *
     * @param code Code
     *
     * @return List<ShikakuKubun> 資格区分リスト
     */
    @Transaction
    public SearchResult<ShikakuKubun> getHihokubunList(RString code) {
        List<ShikakuKubun> list = new ArrayList<>();
        ShikakuKubun enumList = ShikakuKubun.toValue(code);
        list.add(enumList);
        return SearchResult.of(list, 0, false);
    }
}
