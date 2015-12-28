package jp.co.ndensan.reams.db.dbx.service.core.gappeijoho;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri.GappeiJohoKanriConfig;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.KyuShichosonCodeJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7055GappeiJohoDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7056GappeiShichosonDac;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 旧市町村コード情報の取得処理を扱うクラスです。
 */
public class KyuShichosonCodeFinder {

    private final KoseiShichosonJohoFinder koseiShichosonJohoFinder;
    private final DbT7055GappeiJohoDac dbT7055GappeiJohoDac;
    private final DbT7056GappeiShichosonDac dbT7056GappeiShichosonDac;
    private final boolean hasGappei;

    private static final RString 地域番号_二桁目 = new RString("1");

    /**
     * コンストラクタです。
     */
    protected KyuShichosonCodeFinder() {
        this.koseiShichosonJohoFinder = KoseiShichosonJohoFinder.createInstance();
        this.dbT7055GappeiJohoDac = InstanceProvider.create(DbT7055GappeiJohoDac.class);
        this.dbT7056GappeiShichosonDac = InstanceProvider.create(DbT7056GappeiShichosonDac.class);
        this.hasGappei = new GappeiJohoKanriConfig().has合併();
    }

    private KyuShichosonCodeFinder(KoseiShichosonJohoFinder koseiShichosonJohoFinder,
                                   DbT7055GappeiJohoDac dbT7055GappeiJohoDac,
                                   DbT7056GappeiShichosonDac dbT7056GappeiShichosonDac,
                                   boolean has合併) {
        this.koseiShichosonJohoFinder = koseiShichosonJohoFinder;
        this.dbT7055GappeiJohoDac = dbT7055GappeiJohoDac;
        this.dbT7056GappeiShichosonDac = dbT7056GappeiShichosonDac;
        this.hasGappei = has合併;
    }

    /**
     * テスト用のインスタンスを生成します。
     *
     * @param koseiShichosonJohoFinder {@link KoseiShichosonJohoFinder}
     * @param dbT7055GappeiJohoDac {@link DbT7055GappeiJohoDac DbT7055GappeiJohoDac}
     * @param dbT7056GappeiShichosonDac {@link DbT7056GappeiShichosonDac DbT7056GappeiShichosonDac}
     * @param has合併 合併の有無
     * @return {@link KyuShichosonCodeFinder}
     */
    static KyuShichosonCodeFinder createInstanceForTest(KoseiShichosonJohoFinder koseiShichosonJohoFinder,
                                                        DbT7055GappeiJohoDac dbT7055GappeiJohoDac,
                                                        DbT7056GappeiShichosonDac dbT7056GappeiShichosonDac,
                                                        boolean has合併) {
        return new KyuShichosonCodeFinder(koseiShichosonJohoFinder, dbT7055GappeiJohoDac, dbT7056GappeiShichosonDac, has合併);
    }

    /**
     * インスタンスを生成します。
     *
     * @return KyuShichosonCodeFinder
     */
    public static KyuShichosonCodeFinder createInstance() {
        return InstanceProvider.create(KyuShichosonCodeFinder.class);
    }

    /**
     * 旧市町村コード情報を取得します。<br/>
     * 対象となる情報の抽出条件は以下の通りです。<br/>
     * <br/>
     * 【抽出条件】<br/>
     * 市町村コードと導入形態コードより、旧市町村コード情報を対象とします。
     *
     * @param 市町村コード 市町村コード
     * @param 導入形態 導入形態
     * @return KyuShichosonCodeJohoRelateEntityクラス
     */
    public KyuShichosonCodeJohoRelateEntity getKyuShichosonCodeJoho(LasdecCode 市町村コード, DonyuKeitaiCode 導入形態) {
        if (導入形態.is単一()) {
            return get単一市町村KyuShichosonCodeJoho(市町村コード);
        } else if (導入形態.is広域()) {
            return get広域構成市町村KyuShichosonCodeJoho(市町村コード);
        }
        return KyuShichosonCodeJohoRelateEntity.empty();
    }

    private KyuShichosonCodeJohoRelateEntity get単一市町村KyuShichosonCodeJoho(LasdecCode 市町村コード) {
        if (!this.hasGappei) {
            return KyuShichosonCodeJohoRelateEntity.empty();
        }

        DbT7055GappeiJohoEntity dbT7055GappeiJohoEntity = dbT7055GappeiJohoDac.selectTopOneByShichosonCode(市町村コード);
        if (dbT7055GappeiJohoEntity == null) {
            return KyuShichosonCodeJohoRelateEntity.empty();
        }

        List<DbT7056GappeiShichosonEntity> dbT7056GappeiShichosonEntitys = dbT7056GappeiShichosonDac.selectAllOrderbyChikiNoDesc();
        if (地域番号_二桁目.compareTo(dbT7055GappeiJohoEntity.getChiikiNo().substring(1, 2)) < 0) {
            List<DbT7055GappeiJohoEntity> dbT7055GappeiJohoEntitys
                    = dbT7055GappeiJohoDac.selectByLtChiikiNo(dbT7055GappeiJohoEntity.getChiikiNo());
            return new KyuShichosonCodeJohoRelateEntity(
                    removed旧市町村Had合併OverTwoTimes(dbT7056GappeiShichosonEntitys, dbT7055GappeiJohoEntitys),
                    true);
        }
        return new KyuShichosonCodeJohoRelateEntity(dbT7056GappeiShichosonEntitys, true);
    }

    private List<DbT7056GappeiShichosonEntity> removed旧市町村Had合併OverTwoTimes(List<DbT7056GappeiShichosonEntity> dbT7056GappeiShichosonEntitys,
                                                                            List<DbT7055GappeiJohoEntity> dbT7055GappeiJohoEntitys) {
        List<DbT7056GappeiShichosonEntity> list = new ArrayList<>(dbT7056GappeiShichosonEntitys);
        for (DbT7056GappeiShichosonEntity gappeiShichosonEntity : dbT7056GappeiShichosonEntitys) {
            for (DbT7055GappeiJohoEntity gappeiJohoEntity : dbT7055GappeiJohoEntitys) {
                if (Objects.equals(gappeiShichosonEntity.getKyuShichosonCode(), gappeiJohoEntity.getShichosonCode())) {
                    list.remove(gappeiShichosonEntity);
                }
            }
        }
        return list;
    }

    private KyuShichosonCodeJohoRelateEntity get広域構成市町村KyuShichosonCodeJoho(LasdecCode 市町村コード) {
        if (!this.hasGappei) {
            return KyuShichosonCodeJohoRelateEntity.empty();
        }

        DbT7055GappeiJohoEntity dbT7055GappeiJohoEntity = dbT7055GappeiJohoDac.selectTopOneByShichosonCode(市町村コード);
        if (dbT7055GappeiJohoEntity == null) {
            return KyuShichosonCodeJohoRelateEntity.empty();
        }

        List<KoseiShichosonMaster> koseiShichosons = koseiShichosonJohoFinder.get合併旧市町村sBy地域番号(dbT7055GappeiJohoEntity.getChiikiNo());

        if (地域番号_二桁目.compareTo(dbT7055GappeiJohoEntity.getChiikiNo().substring(1, 2)) < 0) {
            List<DbT7055GappeiJohoEntity> dbT7055GappeiJohoEntitys = dbT7055GappeiJohoDac
                    .selectByLtChiikiNo(dbT7055GappeiJohoEntity.getChiikiNo());
            return new KyuShichosonCodeJohoRelateEntity(create合併市町村ListBy(dbT7055GappeiJohoEntitys, koseiShichosons), true);
        }
        List<DbT7056GappeiShichosonEntity> dbT7056GappeiShichosonEntitys = new ArrayList<>();
        for (KoseiShichosonMaster koseiShichoson : koseiShichosons) {
            dbT7056GappeiShichosonEntitys.add(toDbT7056GappeiShichosonEntity(koseiShichoson));
        }
        return new KyuShichosonCodeJohoRelateEntity(dbT7056GappeiShichosonEntitys, true);
    }

    private List<DbT7056GappeiShichosonEntity> create合併市町村ListBy(List<DbT7055GappeiJohoEntity> dbT7055GappeiJohoEntitys,
                                                                 List<KoseiShichosonMaster> koseiShichosons) {
        List<DbT7056GappeiShichosonEntity> dbT7056GappeiShichosonEntitys = new ArrayList<>();
        koseishichoson:
        for (KoseiShichosonMaster koseiShichoson : koseiShichosons) {
            for (DbT7055GappeiJohoEntity gappeiJohoEntity : dbT7055GappeiJohoEntitys) {
                if (Objects.equals(koseiShichoson.get市町村コード(), gappeiJohoEntity.getShichosonCode())) {
                    continue koseishichoson;
                }
            }
            dbT7056GappeiShichosonEntitys.add(toDbT7056GappeiShichosonEntity(koseiShichoson));
        }
        return dbT7056GappeiShichosonEntitys;
    }

    private static DbT7056GappeiShichosonEntity toDbT7056GappeiShichosonEntity(KoseiShichosonMaster koseiShichoson) {
        DbT7056GappeiShichosonEntity gappeiShichosonEntity = new DbT7056GappeiShichosonEntity();
        gappeiShichosonEntity.setKyuShichosonCode(koseiShichoson.get市町村コード());
        gappeiShichosonEntity.setKyuHokenshaNo(new HokenshaNo(koseiShichoson.get運用保険者番号().value()));
        gappeiShichosonEntity.setKyuShichosonMeisho(koseiShichoson.get市町村名称());
        return gappeiShichosonEntity;
    }

}
