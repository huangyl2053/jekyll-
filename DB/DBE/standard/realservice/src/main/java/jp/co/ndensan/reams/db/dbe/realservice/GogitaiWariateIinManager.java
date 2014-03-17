/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIin;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiYMD;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.GogitaiWariateIinMapper;
import jp.co.ndensan.reams.db.dbe.entity.relate.GogitaiWariateShinsakaiIinEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IGogitaiWariateDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.IGogitaiWariateShinsakaiIinDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 合議体割当委員の情報を管理するクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiWariateIinManager {

    private final IGogitaiWariateShinsakaiIinDac gogitaiWariateIinDac;
    private final IGogitaiWariateDac wariateDac;

    /**
     * デフォルトコンストラクタです。
     */
    public GogitaiWariateIinManager() {
        this.gogitaiWariateIinDac = InstanceProvider.createWithCustomize(IGogitaiWariateShinsakaiIinDac.class);
        this.wariateDac = InstanceProvider.createWithCustomize(IGogitaiWariateDac.class);
    }

    /**
     * 引数からDACを受け取る、テスト用コンストラクタです。
     *
     * @param gogitaiWariateIinDac 合議体割当審査会委員Dac
     * @param wariateDac 合議体割当Dac
     */
    GogitaiWariateIinManager(IGogitaiWariateShinsakaiIinDac gogitaiWariateIinDac, IGogitaiWariateDac wariateDac) {
        this.gogitaiWariateIinDac = gogitaiWariateIinDac;
        this.wariateDac = wariateDac;
    }

    /**
     * 合議体に割り当てられている審査会委員を全件取得します。
     *
     * @return 合議体割当委員List
     */
    public GogitaiWariateIinList get合議体割当委員ListAll() {
        List<GogitaiWariateShinsakaiIinEntity> entities = gogitaiWariateIinDac.select();
        return GogitaiWariateIinMapper.to合議体割当委員List(entities);
    }

    /**
     * 合議体有効期間開始年月日を指定し、現在有効な合議体割当委員を取得します。
     *
     * @param 有効期間開始年月日 合議体有効期間開始年月日
     * @return 現在有効な割当委員のリスト
     */
    public GogitaiWariateIinList get有効割当委員List(GogitaiYukoKikanKaishiYMD 有効期間開始年月日) {
        List<GogitaiWariateShinsakaiIinEntity> entities = gogitaiWariateIinDac.select(有効期間開始年月日);
        return GogitaiWariateIinMapper.to合議体割当委員List(entities);
    }

    /**
     * 合議体番号と有効期間開始年月日を指定し、特定の合議体に割り当てられている審査会委員のリストを取得します。
     *
     * @param 合議体番号 合議体番号
     * @param 有効期間開始年月日 有効期間開始年月日
     * @return 特定の合議体に割り当てられている審査会委員List
     */
    public GogitaiWariateIinList get合議体割当委員List(GogitaiNo 合議体番号, GogitaiYukoKikanKaishiYMD 有効期間開始年月日) {
        List<GogitaiWariateShinsakaiIinEntity> entities = gogitaiWariateIinDac.select(合議体番号, 有効期間開始年月日);
        return GogitaiWariateIinMapper.to合議体割当委員List(entities);
    }

    /**
     * 引数に指定した合議体割当委員の情報を保存します。
     *
     * @param 合議体割当委員 合議体割当委員
     * @return 保存できた場合はtrue
     */
    public boolean save(GogitaiWariateIin 合議体割当委員) {
        DbT5107GogitaiWariateIinJohoEntity entity = GogitaiWariateIinMapper.to合議体割当委員Entity(合議体割当委員);
        return wariateDac.insertOrUpdate(entity) == 1 ? true : false;
    }

    /**
     * 引数に指定した合議体割当委員の情報を削除します。
     *
     * @param 合議体割当委員 合議体割当委員
     * @return 削除できた場合はtrue
     */
    public boolean remove(GogitaiWariateIin 合議体割当委員) {
        DbT5107GogitaiWariateIinJohoEntity entity = GogitaiWariateIinMapper.to合議体割当委員Entity(合議体割当委員);
        return wariateDac.delete(entity) == 1 ? true : false;
    }
}
