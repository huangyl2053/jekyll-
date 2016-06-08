package jp.co.ndensan.reams.db.dbu.service.core.koikishichosonjohokanri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 広域システム管理のManagerクラスです。
 *
 * @reamsid_L DBU-4010-010 duanzhanli
 *
 */
public class KoikiShichosonJohoKanriManager {

    private final DbT7051KoseiShichosonMasterDac 構成市町村マスタDac;

    /**
     * コンストラクタです。
     */
    public KoikiShichosonJohoKanriManager() {
        this.構成市町村マスタDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac DbT7051KoseiShichosonMasterDac
     */
    KoikiShichosonJohoKanriManager(DbT7051KoseiShichosonMasterDac dac) {
        this.構成市町村マスタDac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KoikiShichosonJohoKanriManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KoikiShichosonJohoKanriManager}のインスタンス
     */
    public static KoikiShichosonJohoKanriManager createInstance() {
        return InstanceProvider.create(KoikiShichosonJohoKanriManager.class);
    }

    /**
     * 広域市町村一覧情報の取得。
     *
     * @return SearchResult(KoseiShichosonMaster) 広域市町村一覧情報
     */
    public SearchResult<KoseiShichosonMaster> get広域市町村一覧() {
        List<DbT7051KoseiShichosonMasterEntity> entityList = 構成市町村マスタDac.select広域市町村一覧();
        List<KoseiShichosonMaster> masterList = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
            KoseiShichosonMaster master = new KoseiShichosonMaster(entity);
            masterList.add(master);
        }
        return SearchResult.of(masterList, 0, false);
    }

    /**
     * メンテナンス情報の取得。
     *
     * @param 市町村識別ID 市町村識別ID
     * @return SearchResult(KoseiShichosonMaster) メンテナンス情報
     */
    public SearchResult<KoseiShichosonMaster> getメンテナンス情報(RString 市町村識別ID) {
        DbT7051KoseiShichosonMasterEntity entity = 構成市町村マスタDac.selectByKey(市町村識別ID);
        List<KoseiShichosonMaster> masterList = new ArrayList<>();
        masterList.add(new KoseiShichosonMaster(entity));
        return SearchResult.of(masterList, 0, false);
    }

    /**
     * 編集内容か表示され、編集ができる。
     *
     * @param master KoseiShichosonMaster
     */
    public void save市町村Master(KoseiShichosonMaster master) {
        構成市町村マスタDac.save(master.toEntity());
    }
}
