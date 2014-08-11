/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.GogitaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKyukaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5101ShinsakaiJohoEntity;

/**
 * 審査会情報のマッピングを行うクラスです。
 *
 * @author n8178 城間篤人
 */
public final class ShinsakaiDetailMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private ShinsakaiDetailMapper() {
    }

    /**
     * 審査会Entityとその開催場所の情報、割り当てられた合議体情報を受け取り、審査会情報を生成します。
     *
     * @param 審査会Entity 審査会Entity
     * @param 審査会開催場所 審査会開催場所
     * @param 合議体情報 合議体情報
     * @return 審査会情報
     */
    public static ShinsakaiDetail to審査会情報(DbT5101ShinsakaiJohoEntity 審査会Entity,
            ShinsakaiKaisaiBasho 審査会開催場所, GogitaiDetail 合議体情報) {
        if (合議体情報 == null || 審査会Entity == null || 審査会開催場所 == null) {
            return null;
        }

        return new ShinsakaiDetail.Builder(new ShinsakaiKaisaiNo(審査会Entity.getShinsakaiKaisaiNo()),
                審査会Entity.getShinsakaiKaisaiYMD(),
                new TimeString(審査会Entity.getShinsakaiKaishiTime()),
                new TimeString(審査会Entity.getShinsakaiShuryoTime()),
                合議体情報)
                .set審査会開催場所(審査会開催場所)
                .set審査会予定定員(審査会Entity.getShinsakaiYoteiTeiin())
                .set審査会最大定員(審査会Entity.getShinsakaiSaidaiTeiin())
                .set審査会自動割当定員(審査会Entity.getShinsakaiJidoWariateTeiin())
                .set審査会委員定員(審査会Entity.getShinsakaiIinTeiin())
                .set精神科医存在区分(GogitaiSeishinkaIshiSonzaiKubun.toValue(審査会Entity.getGogitaiSeishinkaiSonzaiFlag()))
                .set合議体ダミー区分(GogitaiDummyKubun.toValue(審査会Entity.getGogitaiDummyFlag()))
                .set審査会資料作成年月日(審査会Entity.getShinsakaiShiryoSakuseiYMD())
                .set審査会休会区分(ShinsakaiKyukaiKubun.toValue(審査会Entity.getShinsakaiKyukaiFlag()))
                .set審査会割当済み人数(審査会Entity.getShinsakaiWariateZumiNinzu())
                .set資料作成区分(審査会Entity.getShiryoSakuseiKubun()).build();
    }

    /**
     * 審査会情報を受け取り、その情報をマッピングして審査会情報Entityを生成して返します。
     *
     * @param 審査会情報 審査会情報
     * @return 審査会情報Entity
     */
    public static DbT5101ShinsakaiJohoEntity to審査会情報Entity(ShinsakaiDetail 審査会情報) {
        if (審査会情報 == null) {
            return null;
        }
        DbT5101ShinsakaiJohoEntity entity = new DbT5101ShinsakaiJohoEntity();
        entity.setShinsakaiKaisaiNo(審査会情報.get審査会開催番号().value());
        entity.setShinsakaiKaisaiYMD(審査会情報.get審査会開催年月日());
        entity.setShinsakaiKaishiTime(審査会情報.get審査会開始時間().value());
        entity.setShinsakaiShuryoTime(審査会情報.get審査会終了時間().value());
        entity.setShinsakaiKaisaiBashoCode(審査会情報.get合議体情報().get審査会開催場所().get開催場所コード().value());
        entity.setGogitaiNo(審査会情報.get合議体情報().get合議体番号().value());
        entity.setShinsakaiYoteiTeiin(審査会情報.get審査会予定定員());
        entity.setShinsakaiSaidaiTeiin(審査会情報.get審査会最大定員());
        entity.setShinsakaiJidoWariateTeiin(審査会情報.get審査会自動割当定員());
        entity.setShinsakaiIinTeiin(審査会情報.get審査会委員定員());
        entity.setGogitaiSeishinkaiSonzaiFlag(審査会情報.is精神科医存在());
        entity.setGogitaiDummyFlag(審査会情報.isDummy());
        entity.setShinsakaiShiryoSakuseiYMD(審査会情報.get審査会資料作成年月日());
        entity.setShinsakaiKyukaiFlag(審査会情報.is休会());
        entity.setShinsakaiWariateZumiNinzu(審査会情報.get審査会割当済み人数());
        entity.setShiryoSakuseiKubun(審査会情報.get資料作成区分());
        return entity;
    }
}
