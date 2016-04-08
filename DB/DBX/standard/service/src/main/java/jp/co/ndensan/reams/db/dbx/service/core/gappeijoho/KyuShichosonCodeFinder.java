package jp.co.ndensan.reams.db.dbx.service.core.gappeijoho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri.GappeiJohoKanriConfig;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.KyuShichosonJohoEntities;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7055GappeiJohoDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7056GappeiShichosonDac;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 旧市町村コード情報の取得処理を扱うクラスです。
 *
 */
public class KyuShichosonCodeFinder {

//    private final DbT7051KoseiShichosonMasterDac dbT7051KoseiShichosonMasterDac;
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

    /**
     * インスタンスを生成します。
     *
     * @return KyuShichosonCodeFinder
     */
    public static KyuShichosonCodeFinder createInstance() {
        return InstanceProvider.create(KyuShichosonCodeFinder.class);
    }

    /**
     * テスト用のコンストラクタです。
     *
     * @param koseiShichosonJohoFinder 構成市町村情報Finder
     * @param dbT7055GappeiJohoDac 合併情報Dac
     * @param dbT7056GappeiShichosonDac 合併市町村Dac
     * @param hasGappei 合併しているかどうか(業務コンフィグの「合併情報区分」)
     */
    KyuShichosonCodeFinder(KoseiShichosonJohoFinder koseiShichosonJohoFinder,
                           DbT7055GappeiJohoDac dbT7055GappeiJohoDac, DbT7056GappeiShichosonDac dbT7056GappeiShichosonDac, boolean hasGappei) {
        this.koseiShichosonJohoFinder = koseiShichosonJohoFinder;
        this.dbT7055GappeiJohoDac = dbT7055GappeiJohoDac;
        this.dbT7056GappeiShichosonDac = dbT7056GappeiShichosonDac;
        this.hasGappei = hasGappei;
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
     * @return KyuShichosonJohoEntitiesクラス
     */
    public KyuShichosonJohoEntities getKyuShichosonCodeJoho(LasdecCode 市町村コード, DonyuKeitaiCode 導入形態) {
        if (DonyuKeitaiCode.事務単一.equals(導入形態)
            || DonyuKeitaiCode.事務構成市町村.equals(導入形態)
            || DonyuKeitaiCode.認定単一.equals(導入形態)) {
            return get単一市町村KyuShichosonCodeJoho(市町村コード);

        } else if (DonyuKeitaiCode.事務広域.equals(導入形態)
                   || DonyuKeitaiCode.認定広域.equals(導入形態)) {
            return get広域構成市町村KyuShichosonCodeJoho(市町村コード);
        }
        return KyuShichosonJohoEntities.empty();
    }

    private KyuShichosonJohoEntities get単一市町村KyuShichosonCodeJoho(LasdecCode 市町村コード) {
        //　1.1　介護共通の業務コンフィグから、取得した合併情報管理_合併情報区分＝1:合併ありの場合
        if (this.hasGappei) {
            // 1.1.1　最新の地域番号の取得
            DbT7055GappeiJohoEntity dbT7055GappeiJohoEntity = dbT7055GappeiJohoDac.selectTopOneByShichosonCode(市町村コード);
            // 1.1.2　上記SQLで合併情報が取得できない場合
            if (dbT7055GappeiJohoEntity == null) {
                return KyuShichosonJohoEntities.empty();
            }

            // 1.1.3　SQL発行
            List<DbT7056GappeiShichosonEntity> dbT7056GappeiShichosonEntitys = dbT7056GappeiShichosonDac.selectAllOrderbyChikiNoDesc();

            // 1.1.5　上記1.1.1で取得された地域番号の二桁目より、以下の処理を行う
            // 1.1.5.1.1　レコードの地域番号の二桁目＝1の場合、1.1.7の処理を続く
            if (地域番号_二桁目.compareTo(dbT7055GappeiJohoEntity.getChiikiNo().substring(1, 2)) == 0) {
                return new KyuShichosonJohoEntities(dbT7056GappeiShichosonEntitys, true);

                // 1.1.5.1.2　レコードの地域番号の二桁目＞1の場合、1.1.6の処理を続く
            } else if (地域番号_二桁目.compareTo(dbT7055GappeiJohoEntity.getChiikiNo().substring(1, 2)) < 0) {
                // 1.1.6　合併情報Listの取得
                List<DbT7055GappeiJohoEntity> dbT7055GappeiJohoEntitys = dbT7055GappeiJohoDac
                        .selectByLtChiikiNo(dbT7055GappeiJohoEntity.getChiikiNo());
                // 1.1.6.1　上記で取得されたデータを合併情報Listに設定し、この合併情報Listを繰り返し、以下の処理を行う。
                // 1.1.8　返却クラスの合併市町村有無フラグをTRUEで設定する。
                return new KyuShichosonJohoEntities(
                        set単一市町村By合併情報List(dbT7055GappeiJohoEntitys, dbT7056GappeiShichosonEntitys),
                        true);
            }
            return new KyuShichosonJohoEntities(Collections.<DbT7056GappeiShichosonEntity>emptyList(), true);
        }
        // 1.2.1　サイズがゼロのリストを返却クラスに設定する。
        // 1.2.2　返却クラスの合併市町村有無フラグをFALSEで設定する。
        return KyuShichosonJohoEntities.empty();
    }

    private List<DbT7056GappeiShichosonEntity> set単一市町村By合併情報List(List<DbT7055GappeiJohoEntity> dbT7055GappeiJohoEntitys,
                                                                  List<DbT7056GappeiShichosonEntity> dbT7056GappeiShichosonEntitys) {
        List<DbT7056GappeiShichosonEntity> list = new ArrayList<>();
        // 1.1.6.１.1　上記1.1.4で取得された旧市町村コード情報Listを繰り返す。
        for (DbT7055GappeiJohoEntity gappeiJohoEntity : dbT7055GappeiJohoEntitys) {
            for (DbT7056GappeiShichosonEntity gappeiShichosonEntity : dbT7056GappeiShichosonEntitys) {
                if (!gappeiShichosonEntity.getKyuShichosonCode().equals(gappeiJohoEntity.getShichosonCode())) {
//                    entity.getEntitys().add(gappeiShichosonEntity);
                    list.add(gappeiShichosonEntity);
                }
            }
        }
        return list;
    }

    private KyuShichosonJohoEntities get広域構成市町村KyuShichosonCodeJoho(LasdecCode 市町村コード) {
        // 2.1　介護共通の業務コンフィグから、取得した合併情報管理_合併情報区分＝1:合併ありの場合
        if (this.hasGappei) {
            // 2.1.1　最新の地域番号の取得
            DbT7055GappeiJohoEntity dbT7055GappeiJohoEntity = dbT7055GappeiJohoDac.selectTopOneByShichosonCode(市町村コード);
            // 2.1.2　上記SQLで合併情報が取得できない場合
            if (dbT7055GappeiJohoEntity == null) {
                return KyuShichosonJohoEntities.empty();
            }

            // 2.1.3　SQL発行
            List<KoseiShichosonMaster> koseiShichosons
                    = koseiShichosonJohoFinder.get合併旧市町村sBy地域番号(dbT7055GappeiJohoEntity.getChiikiNo());

            // 2.1.5　上記2.1.1で取得された地域番号の二桁目より、以下の処理を行う
            // 2.1.5.1.1　レコードの地域番号の二桁目＝1の場合、2.1.7の処理を続く
            if (地域番号_二桁目.compareTo(dbT7055GappeiJohoEntity.getChiikiNo().substring(1, 2)) == 0) {
                List<DbT7056GappeiShichosonEntity> list = new ArrayList<>();
                for (KoseiShichosonMaster koseiShichoson : koseiShichosons) {
                    DbT7056GappeiShichosonEntity gappeiShichosonEntity = new DbT7056GappeiShichosonEntity();
                    gappeiShichosonEntity.setKyuShichosonCode(koseiShichoson.get市町村コード());
                    gappeiShichosonEntity.setKyuHokenshaNo(new HokenshaNo(koseiShichoson.get運用保険者番号().value()));
                    gappeiShichosonEntity.setKyuShichosonMeisho(koseiShichoson.get市町村名称());
                    list.add(gappeiShichosonEntity);
                }
                return new KyuShichosonJohoEntities(list, true);

                // 2.1.5.1.2　レコードの地域番号の二桁目＞1の場合、2.1.6の処理を続く
            } else if (地域番号_二桁目.compareTo(dbT7055GappeiJohoEntity.getChiikiNo().substring(1, 2)) < 0) {
                // 2.1.6　合併情報Listの取得
                List<DbT7055GappeiJohoEntity> dbT7055GappeiJohoEntitys = dbT7055GappeiJohoDac
                        .selectByLtChiikiNo(dbT7055GappeiJohoEntity.getChiikiNo());
                // 2.1.6.1　上記で取得されたデータを合併情報Listに設定し、この合併情報Listを繰り返し、以下の処理を行う。
                // 2.1.8　返却クラスの合併市町村有無フラグをTRUEで設定する。
                return new KyuShichosonJohoEntities(
                        set広域構成市町村By合併情報List(dbT7055GappeiJohoEntitys, koseiShichosons),
                        true);
            }
            return new KyuShichosonJohoEntities(Collections.<DbT7056GappeiShichosonEntity>emptyList(), true);
        }
        // 2.2.1　サイズがゼロのリストを返却クラスに設定する。
        // 2.2.2　返却クラスの合併市町村有無フラグをFALSEで設定する。
        return KyuShichosonJohoEntities.empty();
    }

    private List<DbT7056GappeiShichosonEntity> set広域構成市町村By合併情報List(
            List<DbT7055GappeiJohoEntity> dbT7055GappeiJohoEntitys,
            List<KoseiShichosonMaster> koseiShichosons) {
        List<DbT7056GappeiShichosonEntity> list = new ArrayList<>();
        // 2.1.6.１.1　上記2.1.4で取得された旧市町村コード情報Listを繰り返す。
        for (DbT7055GappeiJohoEntity gappeiJohoEntity : dbT7055GappeiJohoEntitys) {
            for (KoseiShichosonMaster koseiShichoson : koseiShichosons) {
                if (!koseiShichoson.get市町村コード().equals(gappeiJohoEntity.getShichosonCode())) {
                    DbT7056GappeiShichosonEntity gappeiShichosonEntity = new DbT7056GappeiShichosonEntity();
                    gappeiShichosonEntity.setKyuShichosonCode(koseiShichoson.get市町村コード());
                    gappeiShichosonEntity.setKyuHokenshaNo(new HokenshaNo(koseiShichoson.get運用保険者番号().value()));
                    gappeiShichosonEntity.setKyuShichosonMeisho(koseiShichoson.get市町村名称());
                    list.add(gappeiShichosonEntity);
                }
            }
        }
        return list;
    }
}
