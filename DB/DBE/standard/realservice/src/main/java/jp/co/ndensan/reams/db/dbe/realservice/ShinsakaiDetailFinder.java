/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.GogitaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiDate;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5101ShinsakaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.ShinsakaiDetailMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiJohoDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 審査会の情報を取得するFinderです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiDetailFinder {

    private final ShinsakaiJohoDac 審査会情報Dac;
    private final ShinsakaiKaisaiBashoManager 審査会開催場所Manager;
    private final GogitaiDetailFinder 合議体DetailFinder;

    /**
     * インスタンスを生成します。
     */
    public ShinsakaiDetailFinder() {
        審査会情報Dac = InstanceProvider.create(ShinsakaiJohoDac.class);
        審査会開催場所Manager = new ShinsakaiKaisaiBashoManager();
        合議体DetailFinder = new GogitaiDetailFinder();
    }

    /**
     * テスト用コンストラクタです。引数からテストに必要なDacなどを受け取り、インスタンスを生成します。
     *
     * @param 審査会情報Dac 審査会情報Dac
     * @param 審査会開催場所Manager 審査会開催場所Manager
     * @param 合議体DetailFinder 合議体DetailFinder
     */
    ShinsakaiDetailFinder(ShinsakaiJohoDac 審査会情報Dac, ShinsakaiKaisaiBashoManager 審査会開催場所Manager,
            GogitaiDetailFinder 合議体DetailFinder) {
        this.審査会情報Dac = 審査会情報Dac;
        this.審査会開催場所Manager = 審査会開催場所Manager;
        this.合議体DetailFinder = 合議体DetailFinder;
    }

    /**
     * 審査会開催番号と審査会開催年月日を引数から受け取り、それに対応する審査会情報を取得します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @param 審査会開催年月日 審査会開催年月日
     * @return 審査会情報
     */
    public ShinsakaiDetail get審査会情報(ShinsakaiKaisaiNo 審査会開催番号, ShinsakaiKaisaiDate 審査会開催年月日) {
        DbT5101ShinsakaiJohoEntity entity = 審査会情報Dac.select(審査会開催番号, 審査会開催年月日);
        ShinsakaiKaisaiBasho 開催場所 = get審査会開催場所(entity);
        GogitaiDetail 合議体情報 = get合議体情報(entity);
        return ShinsakaiDetailMapper.to審査会情報(entity, 開催場所, 合議体情報);
    }

    private ShinsakaiKaisaiBasho get審査会開催場所(DbT5101ShinsakaiJohoEntity entity) {
        return 審査会開催場所Manager.get審査会開催場所(new ShinsakaiKaisaiBashoCode(entity.getShinsakaiKaisaiBashoCode()));
    }

    private GogitaiDetail get合議体情報(DbT5101ShinsakaiJohoEntity entity) {
        GogitaiNo 合議体番号 = new GogitaiNo(entity.getGogitaiNo());
        FlexibleDate 審査会開催年月日 = entity.getShinsakaiKaisaiYMD();
        return 合議体DetailFinder.get合議体情報(合議体番号, 審査会開催年月日);
    }

    /**
     * 審査会開催年月日を指定して、その日に開催される審査会の情報を取得します。
     *
     * @param 審査会開催年月日 審査会開催年月日
     * @return 審査会情報List
     */
    public List<ShinsakaiDetail> get開催審査会情報(ShinsakaiKaisaiDate 審査会開催年月日) {
        List<DbT5101ShinsakaiJohoEntity> entityList = 審査会情報Dac.select開催審査会(審査会開催年月日);
        return create審査会情報(entityList);
    }

    private List<ShinsakaiDetail> create審査会情報(List<DbT5101ShinsakaiJohoEntity> entityList) {
        List<ShinsakaiDetail> 審査会情報List = new ArrayList<>();
        for (DbT5101ShinsakaiJohoEntity entity : entityList) {
            ShinsakaiKaisaiBasho 開催場所 = get審査会開催場所(entity);
            GogitaiDetail 合議体情報 = get合議体情報(entity);
            審査会情報List.add(ShinsakaiDetailMapper.to審査会情報(entity, 開催場所, 合議体情報));
        }
        return 審査会情報List;
    }

    /**
     * 基準となる年月日を指定して、その日付を基準に、開催が予定されている審査会情報のリストを検索して返します。
     *
     * @param 基準年月日 基準年月日
     * @return 開催予定の審査会情報List
     */
    public List<ShinsakaiDetail> get開催予定審査会情報(FlexibleDate 基準年月日) {
        List<DbT5101ShinsakaiJohoEntity> entityList = 審査会情報Dac.select開催予定審査会(基準年月日);
        return create審査会情報(entityList);
    }

    /**
     * 審査会の情報をすべて取得します。
     *
     * @return 審査会情報List
     */
    public List<ShinsakaiDetail> get審査会All() {
        List<DbT5101ShinsakaiJohoEntity> entityList = 審査会情報Dac.selectAll();
        return create審査会情報(entityList);
    }
}
