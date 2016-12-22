 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.ninteishinsakaiiinguide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideResult;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5914SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5911ShujiiIryoKikanJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5914SonotaKikanJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteishinsakaiiinguide.INinteiShinsakaiIinGuideMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定審査会委員ガイド情報クラスです。
 * 
 * @reamsid_L DBE-3000-030  lijia
 * 
 */
public class NinteiShinsakaiIinGuideManager {

    private final DbT5911ShujiiIryoKikanJohoDac shujiiIryoKikanJohoDac;
    private final DbT5910NinteichosaItakusakiJohoDac dinteichosaItakusakiJohoDac;
    private final DbT5914SonotaKikanJohoDac sonotaKikanJohoDac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public NinteiShinsakaiIinGuideManager() {
        shujiiIryoKikanJohoDac = InstanceProvider.create(DbT5911ShujiiIryoKikanJohoDac.class);
        dinteichosaItakusakiJohoDac = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
        sonotaKikanJohoDac = InstanceProvider.create(DbT5914SonotaKikanJohoDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7005RojinHokenJukyushaJohoDac}
     */
    NinteiShinsakaiIinGuideManager(
            DbT5911ShujiiIryoKikanJohoDac shujiiIryoKikanJohoDac,
            DbT5910NinteichosaItakusakiJohoDac dinteichosaItakusakiJohoDac,
            DbT5914SonotaKikanJohoDac sonotaKikanJohoDac
    ) {
        this.shujiiIryoKikanJohoDac = shujiiIryoKikanJohoDac;
        this.dinteichosaItakusakiJohoDac = dinteichosaItakusakiJohoDac;
        this.sonotaKikanJohoDac = sonotaKikanJohoDac;
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiShinsakaiIinGuideManager}のインスタンスを返します。
     *
     * @return NinteiShinsakaiIinGuideManager 認定審査会委員ガイド情報クラス
     * {@link InstanceProvider#create}にて生成した{@link NinteiShinsakaiIinGuideManager}のインスタンス
     */
    public static NinteiShinsakaiIinGuideManager createInstance() {
        return InstanceProvider.create(NinteiShinsakaiIinGuideManager.class);
    }

    /**
     * 主治医医療機関情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return SearchResult<DbT5911ShujiiIryoKikanJohoEntity> 主治医医療機関情報
     */
    @Transaction
    public SearchResult<KeyValueDataSource> get主治医医療機関情報(LasdecCode 市町村コード) {
        List<KeyValueDataSource> 医療機関リスト = new ArrayList<>();
        List<DbT5911ShujiiIryoKikanJohoEntity> shujiiIryoKikanJohoEntityList = shujiiIryoKikanJohoDac.shichosonCodeAndJokyoFlag(市町村コード);
        if (shujiiIryoKikanJohoEntityList.isEmpty()) {
            return SearchResult.of(医療機関リスト, 0, false);
        }
        for (DbT5911ShujiiIryoKikanJohoEntity entity : shujiiIryoKikanJohoEntityList) {
            KeyValueDataSource dateSource = new KeyValueDataSource();
            dateSource.setKey(entity.getShujiiIryokikanCode().value());
            dateSource.setValue(entity.getIryoKikanMeisho());
            医療機関リスト.add(dateSource);

        }
        return SearchResult.of(医療機関リスト, 0, false);
    }

    /**
     * 認定調査委託先情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return SearchResult<KoikiZenShichosonJoho> 現市町村情報
     */
    @Transaction
    public SearchResult<KeyValueDataSource> get認定調査委託先情報(LasdecCode 市町村コード) {
        List<KeyValueDataSource> 介護事業者リスト = new ArrayList<>();
        List<DbT5910NinteichosaItakusakiJohoEntity> entityList = dinteichosaItakusakiJohoDac.shichosonCodeAndJokyoFlag(市町村コード);
        if (entityList.isEmpty()) {
            return SearchResult.of(介護事業者リスト, 0, false);
        }
        for (DbT5910NinteichosaItakusakiJohoEntity entity : entityList) {
            KeyValueDataSource dateSource = new KeyValueDataSource();
            dateSource.setKey(entity.getNinteichosaItakusakiCode());
            dateSource.setValue(entity.getJigyoshaMeisho());
            介護事業者リスト.add(dateSource);
        }
        return SearchResult.of(介護事業者リスト, 0, false);
    }

    /**
     * その他機関情報を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return SearchResult<DbT5914SonotaKikanJohoEntity> その他機関情報
     */
    @Transaction
    public SearchResult<KeyValueDataSource> getその他機関情報(ShoKisaiHokenshaNo 証記載保険者番号) {
        List<KeyValueDataSource> その他事業者リスト = new ArrayList<>();
        List<DbT5914SonotaKikanJohoEntity> sonotaKikanJohoEntityList = sonotaKikanJohoDac.shoKisaiHokenshaNoAndHaishiFlag(証記載保険者番号);
        if (sonotaKikanJohoEntityList.isEmpty()) {
            return SearchResult.of(その他事業者リスト, 0, false);
        }
        for (DbT5914SonotaKikanJohoEntity entity : sonotaKikanJohoEntityList) {
            KeyValueDataSource dateSource = new KeyValueDataSource();
            dateSource.setKey(entity.getSonotaKikanCode());
            dateSource.setValue(entity.getKikanMeisho());
            その他事業者リスト.add(dateSource);
        }
        return SearchResult.of(その他事業者リスト, 0, false);
    }

    /**
     * 審査会委員一覧情報を取得します。
     *
     * @param parameter 審査会委員一覧情報のMyBatis用パラメータ
     * @return List<NinteiShinsakaiIinGuideResult> 審査会委員一覧情報
     */
    @Transaction
    public SearchResult<NinteiShinsakaiIinGuideResult> get審査会委員一覧情報(NinteiShinsakaiIinGuideMapperParameter parameter) {
        List<NinteiShinsakaiIinGuideResult> buinessList = new ArrayList<>();
        INinteiShinsakaiIinGuideMapper mapper = mapperProvider.create(INinteiShinsakaiIinGuideMapper.class);
        List<NinteiShinsakaiIinGuideEntity> entityList = mapper.get審査会委員一覧情報(parameter);
        if (entityList.isEmpty()) {
            return SearchResult.of(buinessList, 0, false);
        }
        for (NinteiShinsakaiIinGuideEntity entity : entityList) {
            buinessList.add(new NinteiShinsakaiIinGuideResult(entity));
        }
        return SearchResult.of(buinessList, 0, false);
    }
}
