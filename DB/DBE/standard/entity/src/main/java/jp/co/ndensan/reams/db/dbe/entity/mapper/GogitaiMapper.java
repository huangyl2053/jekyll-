/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.Gogitai;
import jp.co.ndensan.reams.db.dbe.business.GogitaiList;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyFlag;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzaiFlag;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiYMD;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 合議体のマッピングを行うクラスです。
 *
 * @author n8178 城間篤人
 */
public final class GogitaiMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private GogitaiMapper() {
    }

    /**
     * 引数で指定した情報を元に、合議体クラスを生成します。<br/>
     * 引数のいずれかがnullであるとき、戻り値はnullが返ります。
     *
     * @param 合議体Entity 合議体Entity
     * @param 開催場所 開催場所Entity
     * @param 合議体割当委員List 合議体割当委員List
     * @return 合議体
     */
    public static Gogitai to合議体(DbT5103GogitaiJohoEntity 合議体Entity, ShinsakaiKaisaiBasho 開催場所,
            GogitaiWariateIinList 合議体割当委員List) {
        if (合議体Entity == null || 開催場所 == null || 合議体割当委員List == null) {
            return null;
        }

        return new Gogitai(new GogitaiNo(合議体Entity.getGogitaiNo()), 合議体Entity.getGogitaiMei(),
                new GogitaiYukoKikanKaishiYMD(合議体Entity.getGogitaiYukoKikanKaishiYMD()), 合議体Entity.getGogitaiYukoKikanShuryoYMD(),
                create開始終了時間(合議体Entity),
                開催場所, 合議体Entity.getShinsakaiYoteiTeiin(), 合議体Entity.getShinsakaiJidoWariateTeiin(),
                合議体Entity.getShinsakaiIinTeiin(), 合議体割当委員List,
                GogitaiSeishinkaIshiSonzaiFlag.toValue(合議体Entity.getGogitaiSeishinkaSonzaiFlag()),
                GogitaiDummyFlag.toValue(合議体Entity.getGogitaiDummyFlag()));
    }

    private static Range<TimeString> create開始終了時間(DbT5103GogitaiJohoEntity 合議体Entity) {
        return new Range(new TimeString(合議体Entity.getGogitaiKaishiYoteiTime()), new TimeString(合議体Entity.getGogitaiShuryoYoteiTime()));
    }

    /**
     * 引数で指定した情報を元に、合議体のリストを生成して返します。<br/>
     * 引数のいずれかがnullであるとき、戻り値はnullが返ります。<br/>
     * <br/>
     * 合議体の一つひとつに対して、開催場所のコードと割り当てられた委員Listが存在するため、
     * このメソッドの引数に渡されるリストは、サイズが一致していることが前提です。<br/>
     * そのため、メソッドの引数にサイズの違うリストが渡された場合は例外が発生します。
     *
     * @param 合議体Entities 合議体Entities
     * @param 開催場所List 開催場所List
     * @param 合議体割当委員Lists 合議体割当委員Lists
     * @return 合議体List
     * @throws IllegalArgumentException 引数に渡されたリストサイズが不一致のとき
     */
    public static GogitaiList to合議体List(List<DbT5103GogitaiJohoEntity> 合議体Entities, List<ShinsakaiKaisaiBasho> 開催場所List,
            List<GogitaiWariateIinList> 合議体割当委員Lists) throws IllegalArgumentException {
        if (合議体Entities == null || 開催場所List == null || 合議体割当委員Lists == null) {
            return null;
        }

        if (!isリストサイズが一致(合議体Entities, 開催場所List, 合議体割当委員Lists)) {
            throw new IllegalArgumentException(Messages.E00009.replace("引数に渡されたリストのサイズ").getMessage());
        }

        List<Gogitai> retList = new ArrayList<>();
        for (int i = 0; i < 合議体Entities.size(); i++) {
            retList.add(to合議体(合議体Entities.get(i), 開催場所List.get(i), 合議体割当委員Lists.get(i)));
        }
        return new GogitaiList(retList);
    }

    private static boolean isリストサイズが一致(List<DbT5103GogitaiJohoEntity> 合議体Entities,
            List<ShinsakaiKaisaiBasho> 開催場所List, List<GogitaiWariateIinList> 合議体割当委員Lists) {
        return 合議体Entities.size() == 開催場所List.size() || 開催場所List.size() == 合議体割当委員Lists.size();
    }

    /**
     * 引数から渡された合議体の情報を元に、合議体Entityを生成して返します。<br/>
     * 引数にnullが渡された場合、nullが返ります。
     *
     * @param 合議体 合議体
     * @return 合議体Entity
     */
    public static DbT5103GogitaiJohoEntity to合議体Entity(Gogitai 合議体) {
        if (合議体 == null) {
            return null;
        }

        DbT5103GogitaiJohoEntity entity = new DbT5103GogitaiJohoEntity();
        entity.setGogitaiNo(合議体.get合議体番号().value());
        entity.setGogitaiMei(合議体.get合議体名称());
        entity.setGogitaiYukoKikanKaishiYMD(合議体.get有効期間開始年月日().value());
        entity.setGogitaiYukoKikanShuryoYMD(合議体.get有効期間終了年月日());
        entity.setGogitaiKaishiYoteiTime(合議体.get開始終了予定時刻().getFrom().value());
        entity.setGogitaiShuryoYoteiTime(合議体.get開始終了予定時刻().getTo().value());
        entity.setShinsakaiKaisaiBashoCode(合議体.get審査会開催場所().get開催場所コード().value());
        entity.setShinsakaiYoteiTeiin(合議体.get審査会予定定員());
        entity.setShinsakaiJidoWariateTeiin(合議体.get審査会自動割当定員());
        entity.setShinsakaiIinTeiin(合議体.get審査会委員定員());
        entity.setGogitaiSeishinkaSonzaiFlag(合議体.has精神科医());
        entity.setGogitaiDummyFlag(合議体.isDummy());
        return entity;
    }
}
