/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiWariateIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.business.mapper.ShinsakaiWariateIinMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiWariateIinJohoDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 審査会割当委員の情報を管理するクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiWariateIinManager {

    private ShinsakaiWariateIinJohoDac 審査会割当委員情報Dac;
    private ShinsakaiDetailFinder 審査会情報Finder;
    private ShinsakaiIinManager 審査会委員Manager;

    /**
     * インスタンスを生成します。
     */
    public ShinsakaiWariateIinManager() {
        審査会割当委員情報Dac = InstanceProvider.create(ShinsakaiWariateIinJohoDac.class);
        審査会情報Finder = new ShinsakaiDetailFinder();
        審査会委員Manager = new ShinsakaiIinManager();
    }

    /**
     * テスト用コンストラクタです。外部からDacなどを受け取り、インスタンスを生成します。
     *
     * @param 審査会割当委員情報Dac 審査会割当委員情報Dac
     * @param 審査会情報Finder 審査会情報Finder
     * @param 審査会委員Manager 審査会委員Manager
     */
    ShinsakaiWariateIinManager(ShinsakaiWariateIinJohoDac 審査会割当委員情報Dac, ShinsakaiDetailFinder 審査会情報Finder,
            ShinsakaiIinManager 審査会委員Manager) {
        this.審査会割当委員情報Dac = 審査会割当委員情報Dac;
        this.審査会情報Finder = 審査会情報Finder;
        this.審査会委員Manager = 審査会委員Manager;
    }

    /**
     * 開催年月日を指定して、その日に開催される審査会に割り当てられている、審査会割当委員のリストを取得します。
     *
     * @param 開催年月日 開催年月日
     * @return 審査会割当委員List
     */
    public ShinsakaiWariateIinList get審査会参加割当委員List(FlexibleDate 開催年月日) {
        List<DbT5106ShinsakaiWariateIinJohoEntity> 審査会割当委員EntityList = 審査会割当委員情報Dac.select(開催年月日);
        List<ShinsakaiWariateIin> 審査会割当委員List = create審査会割当委員List(審査会割当委員EntityList);
        return new ShinsakaiWariateIinList(審査会割当委員List);
    }

    /**
     * 審査会に割り当てられている委員をすべて取得します。
     *
     * @return 審査会割当委員List
     */
    public ShinsakaiWariateIinList get審査会割当委員All() {
        List<DbT5106ShinsakaiWariateIinJohoEntity> 割当委員EntityList = 審査会割当委員情報Dac.selectAll();
        List<ShinsakaiWariateIin> 審査会割当委員List = create審査会割当委員List(割当委員EntityList);
        return new ShinsakaiWariateIinList(審査会割当委員List);
    }

    private List<ShinsakaiWariateIin> create審査会割当委員List(List<DbT5106ShinsakaiWariateIinJohoEntity> 割当委員EntityList) {
        List<ShinsakaiWariateIin> 割当委員List = new ArrayList<>();

        for (DbT5106ShinsakaiWariateIinJohoEntity 割当委員Entity : 割当委員EntityList) {
            ShinsakaiDetail 審査会情報 = get審査会情報(割当委員Entity);
            ShinsakaiIin 審査会委員 = get委員(割当委員Entity);
            割当委員List.add(ShinsakaiWariateIinMapper.to審査会割当委員(割当委員Entity, 審査会委員, 審査会情報));
        }

        return 割当委員List;
    }

    private ShinsakaiDetail get審査会情報(DbT5106ShinsakaiWariateIinJohoEntity 割当委員Entity) {
        ShinsakaiKaisaiNo 開催番号 = new ShinsakaiKaisaiNo(割当委員Entity.getShinsakaiKaisaiNo());
        FlexibleDate 開催年月日 = 割当委員Entity.getShinsakaiKaisaiYMD();
        return 審査会情報Finder.get審査会情報(開催番号, 開催年月日);
    }

    private ShinsakaiIin get委員(DbT5106ShinsakaiWariateIinJohoEntity 割当委員Entity) {
        return 審査会委員Manager.get審査会委員(new ShinsakaiIinCode(割当委員Entity.getShinsakaiIinCode()));
    }

    /**
     * 審査会に割り当てられた委員の情報を受け取り、その情報を保存します。
     *
     * @param 割当委員 審査会割当委員
     * @return 保存に成功したらtrue
     */
    public boolean save(ShinsakaiWariateIin 割当委員) {
        DbT5106ShinsakaiWariateIinJohoEntity entity = ShinsakaiWariateIinMapper.to審査員割当委員Entity(割当委員);
        return 審査会割当委員情報Dac.insertOrUpdate(entity) == 1 ? true : false;
    }

    /**
     * 審査会に割り当てられた委員の情報を受け取り、その情報を削除します。
     *
     * @param 割当委員 審査会割当委員
     * @return 削除に成功したらtrue
     */
    public boolean remove(ShinsakaiWariateIin 割当委員) {
        DbT5106ShinsakaiWariateIinJohoEntity entity = ShinsakaiWariateIinMapper.to審査員割当委員Entity(割当委員);
        return 審査会割当委員情報Dac.delete(entity) == 1 ? true : false;
    }
}
