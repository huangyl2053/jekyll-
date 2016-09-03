/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd5030001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.TsuchishoHakkoJoho;
import jp.co.ndensan.reams.db.dbd.business.core.dbd5030001.TsuchiShoriBusiness;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4122TsuchishoHakkoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5030001.TsuchiShoriEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4122TsuchishoHakkoJohoDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.tsuchishori.ITsuchiShoriMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 完了処理・通知書発行表示情報を取得する
 *
 * @reamsid_L DBD-2040-010 chenxin
 */
public class TsuchiShoriManager {

    private final MapperProvider mapperProvider;
    private final DbT4122TsuchishoHakkoJohoDac 通知書発行情報dac;

    TsuchiShoriManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.通知書発行情報dac = InstanceProvider.create(DbT4122TsuchishoHakkoJohoDac.class);
    }

    /**
     * TsuchiShoriManagerのインスタンス化
     *
     * @return TsuchiShoriManager
     */
    public static TsuchiShoriManager createInstance() {
        return InstanceProvider.create(TsuchiShoriManager.class);
    }

    /**
     * 初期化情報を取得取得する。
     *
     * @return List<TsuchiShoriBusiness>
     */
    public List<TsuchiShoriBusiness> 初期化情報取得() {
        List<TsuchiShoriBusiness> 初期化情報 = new ArrayList<>();
        ITsuchiShoriMapper mapper = mapperProvider.create(ITsuchiShoriMapper.class);
        List<TsuchiShoriEntity> entities = mapper.初期化データ取得();
        for (TsuchiShoriEntity entity : entities) {
            初期化情報.add(new TsuchiShoriBusiness(entity));
        }
        return 初期化情報;
    }

    /**
     * 通知書発行情報を取得する。
     *
     * @return List<TsuchishoHakkoJoho>
     */
    public List<TsuchishoHakkoJoho> 通知書発行情報() {
        List<TsuchishoHakkoJoho> 通知書発行情報 = new ArrayList<>();
        DbT4122TsuchishoHakkoJohoDac dac = InstanceProvider.create(DbT4122TsuchishoHakkoJohoDac.class);
        for (DbT4122TsuchishoHakkoJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            通知書発行情報.add(new TsuchishoHakkoJoho(entity));
        }
        return 通知書発行情報;
    }

    /**
     * UPDATE処理を行う。
     *
     * @param 画面情報 TsuchishoHakkoJoho
     */
    @Transaction
    public void save(TsuchishoHakkoJoho 画面情報) {
        通知書発行情報dac.save(画面情報.toEntity());
    }

    /**
     * INSERT処理を行う。
     *
     * @param 画面情報 TsuchishoHakkoJoho
     */
    @Transaction
    public void insert(TsuchishoHakkoJoho 画面情報) {
        通知書発行情報dac.save(画面情報.toEntity());
    }
}
