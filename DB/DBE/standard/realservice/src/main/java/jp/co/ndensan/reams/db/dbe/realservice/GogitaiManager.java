/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.Gogitai;
import jp.co.ndensan.reams.db.dbe.business.GogitaiList;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiYMD;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.GogitaiDetailMapper;
import jp.co.ndensan.reams.db.dbe.entity.mapper.GogitaiMapper;
import jp.co.ndensan.reams.db.dbe.entity.mapper.GogitaiWariateIinMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.GogitaiWariateShinsakaiIinEntity;
import jp.co.ndensan.reams.db.dbe.persistence.relate.GogitaiWariateShinsakaiIinDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.GogitaiAndGogitaiWariateIinDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 合議体の情報を管理するクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiManager {

    private final GogitaiWariateShinsakaiIinDac gogitaiWariateIinDac;
    private final GogitaiAndGogitaiWariateIinDac gogitaiAndWariateIinDac;

    /**
     * デフォルトコンストラクタです。
     */
    public GogitaiManager() {
        gogitaiWariateIinDac = InstanceProvider.create(GogitaiWariateShinsakaiIinDac.class);
        gogitaiAndWariateIinDac = InstanceProvider.create(GogitaiAndGogitaiWariateIinDac.class);
    }

    /**
     * 引数からDacを受け取る、テスト用コンストラクタです。
     *
     * @param wariateIinDac 合議体割当審査会委員Dac
     * @param gogitaiAndWariateIinDac 合議体割当Dac
     */
    public GogitaiManager(GogitaiWariateShinsakaiIinDac wariateIinDac,
            GogitaiAndGogitaiWariateIinDac gogitaiAndWariateIinDac) {
        this.gogitaiWariateIinDac = wariateIinDac;
        this.gogitaiAndWariateIinDac = gogitaiAndWariateIinDac;
    }

    /**
     * 合議体番号を指定して、合議体の履歴のリストを取得します。
     *
     * @param 合議体番号 合議体番号
     * @return 指定した合議体の履歴のリスト
     */
    public GogitaiList get合議体履歴List(GogitaiNo 合議体番号) {
        List<GogitaiWariateShinsakaiIinEntity> 合議体割当委員Entities = gogitaiWariateIinDac.select(合議体番号);
        return GogitaiMapper.to合議体List(合議体割当委員Entities);
    }

    /**
     * 指定した年月日時点で、有効な合議体のリストを取得します。
     *
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     * @return 現時点で有効な合議体のリスト
     */
    public GogitaiList get有効合議体List(GogitaiYukoKikanKaishiYMD 合議体有効期間開始年月日) {
        List<GogitaiWariateShinsakaiIinEntity> 合議体割当委員Entities = gogitaiWariateIinDac.select(合議体有効期間開始年月日);
        return GogitaiMapper.to合議体List(合議体割当委員Entities);
    }

    /**
     * 引数に指定した合議体と、合議体に割り当てられている審査会委員の情報を保存します。
     *
     * @param 合議体 合議体
     * @return 保存に成功したらtrue
     */
    public boolean save(Gogitai 合議体) {
        DbT5103GogitaiJohoEntity 合議体Entity = GogitaiDetailMapper.to合議体情報Entity(合議体.get合議体情報());
        List<DbT5107GogitaiWariateIinJohoEntity> 合議体割当委員Entities =
                GogitaiWariateIinMapper.to合議体割当委員EntityList(合議体.get割当委員List());

        int 更新件数 = gogitaiAndWariateIinDac.insertOrUpdate(合議体Entity, 合議体割当委員Entities);
        return 0 < 更新件数 ? true : false;
    }

    /**
     * 引数に指定した合議体と、合議体に割り当てられている審査会委員の情報を削除します。
     *
     * @param 合議体 合議体
     * @return 削除に成功したらtrue
     */
    public boolean remove(Gogitai 合議体) {
        DbT5103GogitaiJohoEntity 合議体Entity = GogitaiDetailMapper.to合議体情報Entity(合議体.get合議体情報());
        List<DbT5107GogitaiWariateIinJohoEntity> 合議体割当委員Entities =
                GogitaiWariateIinMapper.to合議体割当委員EntityList(合議体.get割当委員List());

        int 更新件数 = gogitaiAndWariateIinDac.delete(合議体Entity, 合議体割当委員Entities);
        return 0 < 更新件数 ? true : false;
    }
}
