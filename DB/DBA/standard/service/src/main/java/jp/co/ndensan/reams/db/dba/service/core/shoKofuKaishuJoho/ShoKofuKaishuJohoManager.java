/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.shoKofuKaishuJoho;

import jp.co.ndensan.reams.db.dba.persistence.mapper.shoKofuKaishuJoho.ShoKofuKaishuJohoMapper;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.ShoKofuKaishuJohoModel;
import jp.co.ndensan.reams.db.dba.entity.ShoKofuKaishuJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 証交付回収情報の取得処理です。
 */
public class ShoKofuKaishuJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT7037ShoKofuKaishuDac dac;

    /**
     * コンストラクタ
     */
    ShoKofuKaishuJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT7037ShoKofuKaishuDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param dac dac
     */
    ShoKofuKaishuJohoManager(
            MapperProvider mapperProvider,
            DbT7037ShoKofuKaishuDac dac
    ) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShoKofuKaishuJohoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShoKofuKaishuJohoManager}のインスタンス
     */
    public static ShoKofuKaishuJohoManager createInstance() {
        return InstanceProvider.create(ShoKofuKaishuJohoManager.class);
    }

    /**
     * 証交付回収情報データを返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 論理削除フラグ boolean
     * @return SearchResult<ShoKofuKaishuJohoModel>
     */
    public SearchResult<ShoKofuKaishuJohoModel> getShoKofuKaishuJohoList(HihokenshaNo 被保険者番号, boolean 論理削除フラグ) {
        List<ShoKofuKaishuJohoModel> businessList = new ArrayList<>();
        List<DbT7037ShoKofuKaishuEntity> dbT7037ShoKofuKaishuEntity = dac.select一覧取得(被保険者番号, 論理削除フラグ);
        for (DbT7037ShoKofuKaishuEntity fufukuMoshitateEntity : dbT7037ShoKofuKaishuEntity) {
            businessList.add(new ShoKofuKaishuJohoModel(fufukuMoshitateEntity));
        }

        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 証交付回収の更新処理します。
     *
     * @param kaishuJohoEntity
     * @return count
     */
    @Transaction
    public int updShoKofuKaishuJoho(ShoKofuKaishuJohoEntity kaishuJohoEntity) {
        ShoKofuKaishuJohoMapper mapper = mapperProvider.create(ShoKofuKaishuJohoMapper.class);
        ShoKofuKaishuJohoEntity entity = new ShoKofuKaishuJohoEntity();
        entity.setHihokenshaNo(kaishuJohoEntity.getHihokenshaNo());
        entity.setHakkoShoriTimestamp(kaishuJohoEntity.getHakkoShoriTimestamp());
        entity.setKaishuJiyu(kaishuJohoEntity.getKaishuJiyu());
        entity.setKaishuRiyu(kaishuJohoEntity.getKaishuRiyu());
        entity.setKaishuYMD(kaishuJohoEntity.getKaishuYMD());
        entity.setKofuJiyu(kaishuJohoEntity.getKofuJiyu());
        entity.setKofuRiyu(kaishuJohoEntity.getKofuRiyu());
        entity.setKofuShoShurui(kaishuJohoEntity.getKofuShoShurui());
        entity.setKofuYMD(kaishuJohoEntity.getKofuYMD());
        entity.setYukoKigenYMD(kaishuJohoEntity.getYukoKigenYMD());
        int count = mapper.updShoKofuKaishuJoho(entity);
        return count;
    }

    /**
     * 証交付回収情報を削除します
     *
     * @param kaishuJohoEntity
     * @return count
     */
    @Transaction
    public int delShoKofuKaishuJoho(ShoKofuKaishuJohoEntity kaishuJohoEntity) {
        ShoKofuKaishuJohoMapper mapper = mapperProvider.create(ShoKofuKaishuJohoMapper.class);
        ShoKofuKaishuJohoEntity entity = new ShoKofuKaishuJohoEntity();
        entity.setHihokenshaNo(kaishuJohoEntity.getHihokenshaNo());
        entity.setHakkoShoriTimestamp(kaishuJohoEntity.getHakkoShoriTimestamp());
        entity.setKofuShoShurui(kaishuJohoEntity.getKofuShoShurui());
        int count = mapper.delShoKofuKaishuJoho(entity);
        return count;
    }

    /**
     * 証交付回収の保存処理結果を返します。
     *
     * @param entity
     */
    @Transaction
    public void saveShoKofuKaishuJoho(List<ShoKofuKaishuJohoEntity> entity) {
        for (ShoKofuKaishuJohoEntity johoEntity : entity) {
            if (johoEntity.getStatus() == null || johoEntity.getStatus().isEmpty()) {
                continue;
            }
            if (new RString("更新").equals(johoEntity.getStatus())) {
                updShoKofuKaishuJoho(johoEntity);
            } 
            if (new RString("削除").equals(johoEntity.getStatus())) {
                delShoKofuKaishuJoho(johoEntity);
            }
        }
    }
}
