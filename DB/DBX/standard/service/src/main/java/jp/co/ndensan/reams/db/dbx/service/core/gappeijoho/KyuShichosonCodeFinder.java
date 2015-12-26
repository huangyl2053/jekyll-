package jp.co.ndensan.reams.db.dbx.service.core.gappeijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri.GappeiJohoKanriConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.KyuShichosonCodeJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7055GappeiJohoDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7056GappeiShichosonDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 旧市町村コード情報の取得処理を扱うクラスです。
 *
 */
public class KyuShichosonCodeFinder {

    private final DbT7051KoseiShichosonMasterDac dbT7051KoseiShichosonMasterDac;
    private final DbT7055GappeiJohoDac dbT7055GappeiJohoDac;
    private final DbT7056GappeiShichosonDac dbT7056GappeiShichosonDac;
    private final boolean hasGappei;

    private static final RString 地域番号_二桁目 = new RString("1");

    /**
     * コンストラクタです。
     */
    protected KyuShichosonCodeFinder() {
        this.dbT7051KoseiShichosonMasterDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
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
    public KyuShichosonCodeJohoRelateEntity getKyuShichosonCodeJoho(LasdecCode 市町村コード, DonyukeitaiCode 導入形態) {
        KyuShichosonCodeJohoRelateEntity entity = new KyuShichosonCodeJohoRelateEntity();

        if (DonyukeitaiCode.事務単一.equals(導入形態)
                || DonyukeitaiCode.事務構成市町村.equals(導入形態)
                || DonyukeitaiCode.認定単一.equals(導入形態)) {
            entity = get単一市町村KyuShichosonCodeJoho(市町村コード, entity);

        } else if (DonyukeitaiCode.事務広域.equals(導入形態)
                || DonyukeitaiCode.認定広域.equals(導入形態)) {
            entity = get広域構成市町村KyuShichosonCodeJoho(市町村コード, entity);
        }
        return entity;
    }

    private KyuShichosonCodeJohoRelateEntity get単一市町村KyuShichosonCodeJoho(LasdecCode 市町村コード, KyuShichosonCodeJohoRelateEntity entity) {
        //　1.1　介護共通の業務コンフィグから、取得した合併情報管理_合併情報区分＝1:合併ありの場合
        if (this.hasGappei) {
            // 1.1.1　最新の地域番号の取得
            DbT7055GappeiJohoEntity dbT7055GappeiJohoEntity = dbT7055GappeiJohoDac.selectTopOneByShichosonCode(市町村コード);
            // 1.1.2　上記SQLで合併情報が取得できない場合
            if (dbT7055GappeiJohoEntity == null) {
                setGappeiShichoUmuJoho(entity, false);
                return entity;
            }

            // 1.1.3　SQL発行
            List<DbT7056GappeiShichosonEntity> dbT7056GappeiShichosonEntitys = dbT7056GappeiShichosonDac.selectAllOrderbyChikiNoDesc();

            // 1.1.5　上記1.1.1で取得された地域番号の二桁目より、以下の処理を行う
            // 1.1.5.1.1　レコードの地域番号の二桁目＝1の場合、1.1.7の処理を続く
            if (地域番号_二桁目.compareTo(dbT7055GappeiJohoEntity.getChiikiNo().substring(1, 2)) == 0) {
                entity.setEntitys(dbT7056GappeiShichosonEntitys);
                setGappeiShichoUmuJoho(entity, true);
                return entity;

                // 1.1.5.1.2　レコードの地域番号の二桁目＞1の場合、1.1.6の処理を続く
            } else if (地域番号_二桁目.compareTo(dbT7055GappeiJohoEntity.getChiikiNo().substring(1, 2)) < 0) {
                // 1.1.6　合併情報Listの取得
                List<DbT7055GappeiJohoEntity> dbT7055GappeiJohoEntitys = dbT7055GappeiJohoDac
                        .selectByLtChiikiNo(dbT7055GappeiJohoEntity.getChiikiNo());
                // 1.1.6.1　上記で取得されたデータを合併情報Listに設定し、この合併情報Listを繰り返し、以下の処理を行う。
                set単一市町村By合併情報List(dbT7055GappeiJohoEntitys, dbT7056GappeiShichosonEntitys, entity);
            }

            // 1.1.8　返却クラスの合併市町村有無フラグをTRUEで設定する。
            entity.setGappeiShichoUmuFlag(true);

        } else {
            // 1.2.1　サイズがゼロのリストを返却クラスに設定する。
            // 1.2.2　返却クラスの合併市町村有無フラグをFALSEで設定する。
            setGappeiShichoUmuJoho(entity, false);
        }
        return entity;
    }

    private void set単一市町村By合併情報List(List<DbT7055GappeiJohoEntity> dbT7055GappeiJohoEntitys,
            List<DbT7056GappeiShichosonEntity> dbT7056GappeiShichosonEntitys,
            KyuShichosonCodeJohoRelateEntity entity) {
        // 1.1.6.１.1　上記1.1.4で取得された旧市町村コード情報Listを繰り返す。
        for (DbT7055GappeiJohoEntity gappeiJohoEntity : dbT7055GappeiJohoEntitys) {
            for (DbT7056GappeiShichosonEntity gappeiShichosonEntity : dbT7056GappeiShichosonEntitys) {
                if (!gappeiShichosonEntity.getKyuShichosonCode().equals(gappeiJohoEntity.getShichosonCode())) {
                    entity.getEntitys().add(gappeiShichosonEntity);
                }
            }
        }
    }

    private KyuShichosonCodeJohoRelateEntity get広域構成市町村KyuShichosonCodeJoho(LasdecCode 市町村コード, KyuShichosonCodeJohoRelateEntity entity) {
        // 2.1　介護共通の業務コンフィグから、取得した合併情報管理_合併情報区分＝1:合併ありの場合
        if (this.hasGappei) {
            // 2.1.1　最新の地域番号の取得
            DbT7055GappeiJohoEntity dbT7055GappeiJohoEntity = dbT7055GappeiJohoDac.selectTopOneByShichosonCode(市町村コード);
            // 2.1.2　上記SQLで合併情報が取得できない場合
            if (dbT7055GappeiJohoEntity == null) {
                setGappeiShichoUmuJoho(entity, false);
                return entity;
            }

            // 2.1.3　SQL発行
            List<DbT7051KoseiShichosonMasterEntity> dbT7051KoseiShichosonEntitys = dbT7051KoseiShichosonMasterDac
                    .selectByKbnAndChikiNo(dbT7055GappeiJohoEntity.getChiikiNo());

            // 2.1.5　上記2.1.1で取得された地域番号の二桁目より、以下の処理を行う
            // 2.1.5.1.1　レコードの地域番号の二桁目＝1の場合、2.1.7の処理を続く
            if (地域番号_二桁目.compareTo(dbT7055GappeiJohoEntity.getChiikiNo().substring(1, 2)) == 0) {
                for (DbT7051KoseiShichosonMasterEntity koseiShichosonMasterEntity : dbT7051KoseiShichosonEntitys) {
                    DbT7056GappeiShichosonEntity gappeiShichosonEntity = new DbT7056GappeiShichosonEntity();
                    gappeiShichosonEntity.setKyuShichosonCode(koseiShichosonMasterEntity.getShichosonCode());
                    gappeiShichosonEntity.setKyuHokenshaNo(new HokenshaNo(koseiShichosonMasterEntity.getUnyoHokenshaNo().value()));
                    gappeiShichosonEntity.setKyuShichosonMeisho(koseiShichosonMasterEntity.getShichosonMeisho());
                    entity.getEntitys().add(gappeiShichosonEntity);
                }
                setGappeiShichoUmuJoho(entity, true);

                // 2.1.5.1.2　レコードの地域番号の二桁目＞1の場合、2.1.6の処理を続く
            } else if (地域番号_二桁目.compareTo(dbT7055GappeiJohoEntity.getChiikiNo().substring(1, 2)) < 0) {
                // 2.1.6　合併情報Listの取得
                List<DbT7055GappeiJohoEntity> dbT7055GappeiJohoEntitys = dbT7055GappeiJohoDac
                        .selectByLtChiikiNo(dbT7055GappeiJohoEntity.getChiikiNo());
                // 2.1.6.1　上記で取得されたデータを合併情報Listに設定し、この合併情報Listを繰り返し、以下の処理を行う。
                set広域構成市町村By合併情報List(dbT7055GappeiJohoEntitys, dbT7051KoseiShichosonEntitys, entity);
            }

            // 2.1.8　返却クラスの合併市町村有無フラグをTRUEで設定する。
            entity.setGappeiShichoUmuFlag(true);

        } else {
            // 2.2.1　サイズがゼロのリストを返却クラスに設定する。
            // 2.2.2　返却クラスの合併市町村有無フラグをFALSEで設定する。
            setGappeiShichoUmuJoho(entity, false);
        }
        return entity;
    }

    private void set広域構成市町村By合併情報List(
            List<DbT7055GappeiJohoEntity> dbT7055GappeiJohoEntitys,
            List<DbT7051KoseiShichosonMasterEntity> dbT7051KoseiShichosonEntitys,
            KyuShichosonCodeJohoRelateEntity entity) {
        // 2.1.6.１.1　上記2.1.4で取得された旧市町村コード情報Listを繰り返す。
        for (DbT7055GappeiJohoEntity gappeiJohoEntity : dbT7055GappeiJohoEntitys) {
            for (DbT7051KoseiShichosonMasterEntity koseiShichosonMasterEntity : dbT7051KoseiShichosonEntitys) {
                if (!koseiShichosonMasterEntity.getShichosonCode().equals(gappeiJohoEntity.getShichosonCode())) {
                    DbT7056GappeiShichosonEntity gappeiShichosonEntity = new DbT7056GappeiShichosonEntity();
                    gappeiShichosonEntity.setKyuShichosonCode(koseiShichosonMasterEntity.getShichosonCode());
                    gappeiShichosonEntity.setKyuHokenshaNo(new HokenshaNo(koseiShichosonMasterEntity.getUnyoHokenshaNo().value()));
                    gappeiShichosonEntity.setKyuShichosonMeisho(koseiShichosonMasterEntity.getShichosonMeisho());
                    entity.getEntitys().add(gappeiShichosonEntity);
                }
            }
        }
    }

    /**
     * 旧市町村コード情報有無設定ラクタです。
     *
     * @param KyuShichosonCodeJohoRelateEntityクラス
     * @param umuFlag 合併市町村有無フラグ
     */
    private void setGappeiShichoUmuJoho(KyuShichosonCodeJohoRelateEntity entity, boolean umuFlag) {
        if (umuFlag) {
            // 合併市町村有無フラグをTRUEで設定する。
            entity.setGappeiShichoUmuFlag(true);
        } else {
            // サイズがゼロのリストを返却クラスに設定する。
            entity.getEntitys().clear();
            // 合併市町村有無フラグをFALSEで設定する。
            entity.setGappeiShichoUmuFlag(false);
        }
    }
}
