/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiYMD;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 合議体情報のマッピングを行うクラスです。
 *
 * @author n8178 城間篤人
 */
public final class GogitaiJohoMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private GogitaiJohoMapper() {
    }

    /**
     * 引数で指定した情報を元に、合議体クラスを生成します。<br/>
     * 引数のいずれかがnullであるとき、戻り値はnullが返ります。
     *
     * @param 合議体Entity 合議体Entity
     * @param 開催場所 開催場所Entity
     * @return 合議体
     */
    public static GogitaiJoho to合議体情報(DbT5103GogitaiJohoEntity 合議体Entity, ShinsakaiKaisaiBasho 開催場所) {
        if (合議体Entity == null || 開催場所 == null) {
            return null;
        }

        return new GogitaiJoho(new GogitaiNo(合議体Entity.getGogitaiNo()), 合議体Entity.getGogitaiMei(),
                new GogitaiYukoKikanKaishiYMD(合議体Entity.getGogitaiYukoKikanKaishiYMD()), 合議体Entity.getGogitaiYukoKikanShuryoYMD(),
                create開始終了時間(合議体Entity),
                開催場所, 合議体Entity.getShinsakaiYoteiTeiin(), 合議体Entity.getShinsakaiJidoWariateTeiin(),
                合議体Entity.getShinsakaiIinTeiin(),
                GogitaiSeishinkaIshiSonzaiKubun.toValue(合議体Entity.getGogitaiSeishinkaSonzaiFlag()),
                GogitaiDummyKubun.toValue(合議体Entity.getGogitaiDummyFlag()));
    }

    private static Range<TimeString> create開始終了時間(DbT5103GogitaiJohoEntity 合議体Entity) {
        return new Range(new TimeString(合議体Entity.getGogitaiKaishiYoteiTime()), new TimeString(合議体Entity.getGogitaiShuryoYoteiTime()));
    }

    /**
     * 引数から渡された合議体の情報を元に、合議体Entityを生成して返します。<br/>
     * 引数にnullが渡された場合、nullが返ります。
     *
     * @param 合議体情報 合議体
     * @return 合議体Entity
     */
    public static DbT5103GogitaiJohoEntity to合議体情報Entity(GogitaiJoho 合議体情報) {
        if (合議体情報 == null) {
            return null;
        }

        DbT5103GogitaiJohoEntity entity = new DbT5103GogitaiJohoEntity();
        entity.setGogitaiNo(合議体情報.get合議体番号().value());
        entity.setGogitaiMei(合議体情報.get合議体名称());
        entity.setGogitaiYukoKikanKaishiYMD(合議体情報.get有効期間開始年月日().value());
        entity.setGogitaiYukoKikanShuryoYMD(合議体情報.get有効期間終了年月日());
        entity.setGogitaiKaishiYoteiTime(合議体情報.get予定開催時間().getFrom().value());
        entity.setGogitaiShuryoYoteiTime(合議体情報.get予定開催時間().getTo().value());
        entity.setShinsakaiKaisaiBashoCode(合議体情報.get審査会開催場所().get開催場所コード().value());
        entity.setShinsakaiYoteiTeiin(合議体情報.get審査会予定定員());
        entity.setShinsakaiJidoWariateTeiin(合議体情報.get審査会自動割当定員());
        entity.setShinsakaiIinTeiin(合議体情報.get審査会委員定員());
        entity.setGogitaiSeishinkaSonzaiFlag(合議体情報.has精神科医());
        entity.setGogitaiDummyFlag(合議体情報.isDummy());
        return entity;
    }
}
