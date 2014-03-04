/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.Gogitai;
import jp.co.ndensan.reams.db.dbe.business.GogitaiList;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.GogitaiMapper;
import jp.co.ndensan.reams.db.dbe.entity.mapper.GogitaiWariateIinMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IGogitaiDac;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IGogitaiWariateDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.IGogitaiWariateShinsakaiIinDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;

/**
 * 合議体の情報を管理するクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiManager {

    private final IGogitaiDac gogitaiDac;
    private final IGogitaiWariateDac gogitaiWariateDac;
    private final IGogitaiWariateShinsakaiIinDac wariateIinDac;
    private final ShinsakaiKaisaiBashoManager kaisaiBashoManager;

    /**
     * デフォルトコンストラクタです。
     */
    public GogitaiManager() {
        gogitaiDac = InstanceCreator.create(IGogitaiDac.class);
        gogitaiWariateDac = InstanceCreator.create(IGogitaiWariateDac.class);
        wariateIinDac = InstanceCreator.create(IGogitaiWariateShinsakaiIinDac.class);
        kaisaiBashoManager = new ShinsakaiKaisaiBashoManager();
    }

    /**
     * 引数からDacを受け取る、テスト用コンストラクタです。
     *
     * @param gogitaiDac 合議体Dac
     * @param gogitaiWariateDac 合議体割当Dac
     * @param wariateIinDac 合議体割当審査会委員Dac
     * @param kaisaiBashoManager 開催場所マネージャ
     */
    public GogitaiManager(IGogitaiDac gogitaiDac, IGogitaiWariateDac gogitaiWariateDac,
            IGogitaiWariateShinsakaiIinDac wariateIinDac, ShinsakaiKaisaiBashoManager kaisaiBashoManager) {
        this.gogitaiDac = gogitaiDac;
        this.gogitaiWariateDac = gogitaiWariateDac;
        this.wariateIinDac = wariateIinDac;
        this.kaisaiBashoManager = kaisaiBashoManager;
    }

    /**
     * 合議体番号を指定して、合議体の履歴のリストを取得します。
     *
     * @param 合議体番号 合議体番号
     * @return 指定した合議体の履歴のリスト
     */
    public GogitaiList get合議体履歴List(GogitaiNo 合議体番号) {
        List<DbT5103GogitaiJohoEntity> 合議体Entities = gogitaiDac.select(合議体番号);
        return create合議体List(合議体Entities);
    }

    /**
     * 指定した年月日時点で、有効な合議体のリストを取得します。
     *
     * @param 基準年月日 基準年月日
     * @return 現時点で有効な合議体のリスト
     */
    public GogitaiList get有効合議体List(FlexibleDate 基準年月日) {
        List<DbT5103GogitaiJohoEntity> 合議体Entities = gogitaiDac.select(基準年月日);
        return create合議体List(合議体Entities);
    }

    private GogitaiList create合議体List(List<DbT5103GogitaiJohoEntity> 合議体Entities) {
        List<GogitaiWariateIinList> 合議体割当委員List = new ArrayList<>();
        List<ShinsakaiKaisaiBasho> 開催場所List = new ArrayList<>();
        for (DbT5103GogitaiJohoEntity 合議体Entity : 合議体Entities) {
            GogitaiWariateIinList list = GogitaiWariateIinMapper.to合議体割当委員List(
                    wariateIinDac.select(new GogitaiNo(合議体Entity.getGogitaiNo()), 合議体Entity.getGogitaiYukoKikanKaishiYMD()));
            合議体割当委員List.add(list);
            開催場所List.add(kaisaiBashoManager.get審査会開催場所(new ShinsakaiKaisaiBashoCode(合議体Entity.getShinsakaiKaisaiBashoCode())));
        }
        return GogitaiMapper.to合議体List(合議体Entities, 開催場所List, 合議体割当委員List);
    }

    /**
     * 引数に指定した合議体の情報を保存します。
     *
     * @param 合議体 合議体
     * @return 保存に成功したらtrue
     */
    public boolean save(Gogitai 合議体) {
        DbT5103GogitaiJohoEntity 合議体Entity = GogitaiMapper.to合議体Entity(合議体);
        List<DbT5107GogitaiWariateIinJohoEntity> 合議体割当Entities = GogitaiWariateIinMapper.to合議体割当EntityList(合議体);

        int 合議体更新件数;
        合議体更新件数 = gogitaiDac.insertOrUpdate(合議体Entity);
        if (合議体更新件数 == 0) {
            return false;
        }

        int 合議体割当更新件数;
        for (DbT5107GogitaiWariateIinJohoEntity 合議体割当Entity : 合議体割当Entities) {
            合議体割当更新件数 = gogitaiWariateDac.insertOrUpdate(合議体割当Entity);
            if (合議体割当更新件数 == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 引数に指定した合議体の情報を削除します。
     *
     * @param 合議体 合議体
     * @return 削除に成功したらtrue
     */
    public boolean remove(Gogitai 合議体) {
        DbT5103GogitaiJohoEntity 合議体Entity = GogitaiMapper.to合議体Entity(合議体);
        List<DbT5107GogitaiWariateIinJohoEntity> 合議体割当Entities = GogitaiWariateIinMapper.to合議体割当EntityList(合議体);

        int 合議体更新件数;
        合議体更新件数 = gogitaiDac.delete(合議体Entity);
        if (合議体更新件数 == 0) {
            return false;
        }

        int 合議体割当更新件数;
        for (DbT5107GogitaiWariateIinJohoEntity 合議体割当Entity : 合議体割当Entities) {
            合議体割当更新件数 = gogitaiWariateDac.delete(合議体割当Entity);
            if (合議体割当更新件数 == 0) {
                return false;
            }
        }
        return true;
    }
}
