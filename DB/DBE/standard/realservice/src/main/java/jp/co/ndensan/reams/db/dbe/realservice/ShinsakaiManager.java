/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.Shinsakai;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiList;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiDate;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5101ShinsakaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.ShinsakaiDetailMapper;
import jp.co.ndensan.reams.db.dbe.entity.mapper.ShinsakaiMapper;
import jp.co.ndensan.reams.db.dbe.entity.mapper.ShinsakaiWariateIinMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiWariateIinJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.relate.ShinsakaiAndShinskaiWariateIinDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 審査会の情報を管理するクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiManager {

    private ShinsakaiWariateIinJohoDac 割当委員情報Dac;
    private ShinsakaiDetailFinder 審査会情報Finder;
    private ShinsakaiIinManager 委員Manager;
    private ShinsakaiAndShinskaiWariateIinDac 審査会割当委員relateDac;

    /**
     * デフォルトコンストラクタです。インスタンスを生成します。
     */
    public ShinsakaiManager() {
        割当委員情報Dac = InstanceProvider.create(ShinsakaiWariateIinJohoDac.class);
        審査会割当委員relateDac = InstanceProvider.create(ShinsakaiAndShinskaiWariateIinDac.class);
        審査会情報Finder = new ShinsakaiDetailFinder();
        委員Manager = new ShinsakaiIinManager();
    }

    /**
     * テスト用コンストラクタです。引数からDac等を受け取り、インスタンスを生成します。
     *
     * @param 割当委員情報Dac 割当委員情報Dac
     * @param 審査会情報Finder 審査会情報Finder
     * @param 委員Manager 委員Manager
     * @param 審査会割当委員relateDac 審査会割当委員relateDac
     */
    ShinsakaiManager(ShinsakaiWariateIinJohoDac 割当委員情報Dac, ShinsakaiDetailFinder 審査会情報Finder,
            ShinsakaiIinManager 委員Manager, ShinsakaiAndShinskaiWariateIinDac 審査会割当委員relateDac) {
        this.割当委員情報Dac = 割当委員情報Dac;
        this.審査会情報Finder = 審査会情報Finder;
        this.委員Manager = 委員Manager;
        this.審査会割当委員relateDac = 審査会割当委員relateDac;
    }

    /**
     * 開催番号と開催年月日を指定し、審査会を取得します。
     *
     * @param 開催番号 審査会開催番号
     * @param 開催年月日 審査会開催年月日
     * @return 審査会
     */
    public Shinsakai get審査会(ShinsakaiKaisaiNo 開催番号, ShinsakaiKaisaiDate 開催年月日) {
        ShinsakaiDetail 審査会情報 = 審査会情報Finder.get審査会情報(開催番号, 開催年月日);
        return create審査会(審査会情報);
    }

    /**
     * 開催年月日を指定して、その日に開催される審査会の情報を取得します。
     *
     * @param 開催年月日 開催年月日
     * @return 審査会List
     */
    public ShinsakaiList get開催審査会List(ShinsakaiKaisaiDate 開催年月日) {
        List<Shinsakai> 審査会List = new ArrayList<>();

        List<ShinsakaiDetail> 審査会情報List = 審査会情報Finder.get開催審査会情報(開催年月日);
        for (ShinsakaiDetail 審査会情報 : 審査会情報List) {
            審査会List.add(create審査会(審査会情報));
        }
        return new ShinsakaiList(審査会List);
    }

    /**
     * 基準年月日を指定して、その日付を含めて、それ以降に開催される審査会の情報を取得します。
     *
     * @param 基準年月日 基準年月日
     * @return 審査会List
     */
    public ShinsakaiList get開催予定審査会List(FlexibleDate 基準年月日) {
        List<Shinsakai> 審査会List = new ArrayList<>();

        List<ShinsakaiDetail> 審査会情報List = 審査会情報Finder.get開催予定審査会情報(基準年月日);
        for (ShinsakaiDetail 審査会情報 : 審査会情報List) {
            審査会List.add(create審査会(審査会情報));
        }
        return new ShinsakaiList(審査会List);
    }

    /**
     * すべての審査会の情報を取得します。
     *
     * @return 審査会List
     */
    public ShinsakaiList get審査会All() {
        List<Shinsakai> 審査会List = new ArrayList<>();

        List<ShinsakaiDetail> 審査会情報List = 審査会情報Finder.get審査会All();
        for (ShinsakaiDetail 審査会情報 : 審査会情報List) {
            審査会List.add(create審査会(審査会情報));
        }
        return new ShinsakaiList(審査会List);
    }

    private Shinsakai create審査会(ShinsakaiDetail 審査会情報) {
        List<DbT5106ShinsakaiWariateIinJohoEntity> 割当委員EntityList =
                割当委員情報Dac.select(審査会情報.get審査会開催番号(), 審査会情報.get審査会開催年月日());
        ShinsakaiIinList 委員List = 委員Manager.get審査会委員List(get委員コードList(割当委員EntityList));

        return ShinsakaiMapper.to審査会(割当委員EntityList, 委員List, 審査会情報);
    }

    private List<ShinsakaiIinCode> get委員コードList(List<DbT5106ShinsakaiWariateIinJohoEntity> 割当委員EntityList) {
        List<ShinsakaiIinCode> 審査会委員コードList = new ArrayList<>();
        for (DbT5106ShinsakaiWariateIinJohoEntity entity : 割当委員EntityList) {
            審査会委員コードList.add(new ShinsakaiIinCode(entity.getShinsakaiIinCode()));
        }
        return 審査会委員コードList;
    }

    /**
     * 審査会情報と、そこに割り当てられた審査会委員の情報について保存を行います。
     *
     * @param 審査会 審査会
     * @return 保存に成功したらtrue
     */
    public boolean save(Shinsakai 審査会) {
        DbT5101ShinsakaiJohoEntity 審査会情報Entity = ShinsakaiDetailMapper.to審査会情報Entity(審査会.get審査会情報());
        List<DbT5106ShinsakaiWariateIinJohoEntity> 割当委員情報EntityList =
                ShinsakaiWariateIinMapper.to審査会割当委員EntityList(審査会.get割当委員List());
        return 0 < 審査会割当委員relateDac.insertOrUpdate(審査会情報Entity, 割当委員情報EntityList) ? true : false;
    }

    /**
     * 審査会情報と、そこに割り当てられた審査会委員の情報について削除を行います。
     *
     * @param 審査会 審査会
     * @return 削除に成功したらtrue
     */
    public boolean remove(Shinsakai 審査会) {
        DbT5101ShinsakaiJohoEntity 審査会情報Entity = ShinsakaiDetailMapper.to審査会情報Entity(審査会.get審査会情報());
        List<DbT5106ShinsakaiWariateIinJohoEntity> 割当委員情報EntityList =
                ShinsakaiWariateIinMapper.to審査会割当委員EntityList(審査会.get割当委員List());
        return 0 < 審査会割当委員relateDac.delete(審査会情報Entity, 割当委員情報EntityList) ? true : false;
    }
}
