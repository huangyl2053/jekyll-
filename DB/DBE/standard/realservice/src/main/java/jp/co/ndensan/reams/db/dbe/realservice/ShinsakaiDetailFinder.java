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

    private final ShinsakaiJohoDac dac;
    private final ShinsakaiKaisaiBashoManager 開催場所Manager;
    private final GogitaiDetailFinder 合議体DetailFinder;

    /**
     * インスタンスを生成します。
     */
    public ShinsakaiDetailFinder() {
        dac = InstanceProvider.create(ShinsakaiJohoDac.class);
        開催場所Manager = new ShinsakaiKaisaiBashoManager();
        合議体DetailFinder = new GogitaiDetailFinder();
    }

    /**
     * テスト用コンストラクタです。引数からテストに必要なDacなどを受け取り、インスタンスを生成します。
     *
     * @param dac
     * @param 開催場所Manager
     * @param 合議体DetailFinder
     */
    ShinsakaiDetailFinder(ShinsakaiJohoDac dac, ShinsakaiKaisaiBashoManager 開催場所Manager, GogitaiDetailFinder 合議体DetailFinder) {
        this.dac = dac;
        this.開催場所Manager = 開催場所Manager;
        this.合議体DetailFinder = 合議体DetailFinder;
    }

    /**
     * 審査会の開催番号と開催年月日を受け取り、審査会情報を取得します。
     *
     * @param 開催番号 開催番号
     * @param 開催年月日 開催年月日
     * @return 審査会情報
     */
    public ShinsakaiDetail get審査会情報(ShinsakaiKaisaiNo 開催番号, ShinsakaiKaisaiDate 開催年月日) {
        DbT5101ShinsakaiJohoEntity entity = dac.select(開催番号, 開催年月日);
        ShinsakaiKaisaiBasho 開催場所 = get開催場所(entity);
        GogitaiDetail 合議体情報 = get合議体情報(entity);
        return ShinsakaiDetailMapper.to審査会情報(entity, 開催場所, 合議体情報);
    }

    private ShinsakaiKaisaiBasho get開催場所(DbT5101ShinsakaiJohoEntity entity) {
        return 開催場所Manager.get審査会開催場所(new ShinsakaiKaisaiBashoCode(entity.getShinsakaiKaisaiBashoCode()));
    }

    private GogitaiDetail get合議体情報(DbT5101ShinsakaiJohoEntity entity) {
        GogitaiNo 合議体番号 = new GogitaiNo(entity.getGogitaiNo());
        FlexibleDate 審査会開催年月日 = entity.getShinsakaiKaisaiYMD();
        return 合議体DetailFinder.get合議体情報(合議体番号, 審査会開催年月日);
    }

    /**
     * 開催年月日を指定して、その日に開催される審査会の情報を取得します。
     *
     * @param 開催年月日 開催年月日
     * @return 審査会情報List
     */
    public List<ShinsakaiDetail> get開催審査会情報(ShinsakaiKaisaiDate 開催年月日) {
        List<DbT5101ShinsakaiJohoEntity> entityList = dac.select開催審査会(開催年月日);
        return create審査会情報(entityList);
    }

    private List<ShinsakaiDetail> create審査会情報(List<DbT5101ShinsakaiJohoEntity> entityList) {
        List<ShinsakaiDetail> 審査会情報List = new ArrayList<>();
        for (DbT5101ShinsakaiJohoEntity entity : entityList) {
            ShinsakaiKaisaiBasho 開催場所 = get開催場所(entity);
            GogitaiDetail 合議体情報 = get合議体情報(entity);
            審査会情報List.add(ShinsakaiDetailMapper.to審査会情報(entity, 開催場所, 合議体情報));
        }
        return 審査会情報List;
    }

    /**
     * 基準年月日を指定して、開催が予定されている審査会情報のリストを受け取ります。
     *
     * @param 基準年月日 基準年月日
     * @return 開催予定の審査会情報List
     */
    public List<ShinsakaiDetail> get開催予定審査会情報(FlexibleDate 基準年月日) {
        List<DbT5101ShinsakaiJohoEntity> entityList = dac.select開催予定審査会(基準年月日);
        return create審査会情報(entityList);
    }

    /**
     * 審査会の情報をすべて取得します。
     *
     * @return 審査会情報List
     */
    public List<ShinsakaiDetail> get審査会All() {
        List<DbT5101ShinsakaiJohoEntity> entityList = dac.selectAll();
        return create審査会情報(entityList);
    }
}
