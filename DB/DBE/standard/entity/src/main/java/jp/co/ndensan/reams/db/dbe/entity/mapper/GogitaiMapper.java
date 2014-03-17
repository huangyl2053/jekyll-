/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.Gogitai;
import jp.co.ndensan.reams.db.dbe.business.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.business.GogitaiList;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.entity.relate.GogitaiWariateShinsakaiIinEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 合議体割当委員の情報を元に、合議体クラスを作成するMapperです。
 *
 * @author n8178 城間篤人
 */
public final class GogitaiMapper {

    /**
     * インスタンス化防止のプライベートコンストラクタです。
     */
    private GogitaiMapper() {
    }

    /**
     * 合議体割当委員Entityのリストを元に、合議体Listの情報を作成します。<br/>
     * このメソッドは、引数の合議体割当委員Entitiesがキー項目でソートされている前提のため、
     * ソートされていないListを渡すと予期しない値が返ります。
     *
     * @param 合議体割当委員Entities 合議体割当委員Entities
     * @return 合議体List
     */
    public static GogitaiList to合議体List(List<GogitaiWariateShinsakaiIinEntity> 合議体割当委員Entities) {
        List<Gogitai> 合議体List = new ArrayList<>();
        List<GogitaiWariateShinsakaiIinEntity> 各合議体割当委員Entities = new ArrayList<>();
        GogitaiWariateShinsakaiIinEntity check用割当委員Entity = 合議体割当委員Entities.get(0);

        for (GogitaiWariateShinsakaiIinEntity 割当委員Entity : 合議体割当委員Entities) {
            if (!isキー項目が一致(check用割当委員Entity, 割当委員Entity)) {
                合議体List.add(to合議体(各合議体割当委員Entities));
                各合議体割当委員Entities = new ArrayList<>();
                check用割当委員Entity = 割当委員Entity;
            }
            各合議体割当委員Entities.add(割当委員Entity);
        }

        合議体List.add(to合議体(各合議体割当委員Entities));

        return new GogitaiList(合議体List);
    }

    private static Gogitai to合議体(List<GogitaiWariateShinsakaiIinEntity> 合議体割当委員Entities) {
        GogitaiJoho 合議体情報 = create合議体情報(合議体割当委員Entities.get(0));
        GogitaiWariateIinList 合議体割当委員List = GogitaiWariateIinMapper.to合議体割当委員List(合議体割当委員Entities);

        return new Gogitai(合議体情報, 合議体割当委員List);
    }

    private static GogitaiJoho create合議体情報(GogitaiWariateShinsakaiIinEntity 合議体割当委員Entity) {
        return GogitaiJohoMapper.to合議体情報(合議体割当委員Entity.get合議体情報Entity(),
                ShinsakaiKaisaiBashoJohoMapper.to審査会開催場所(合議体割当委員Entity.get開催場所Entity()));
    }

    private static boolean isキー項目が一致(GogitaiWariateShinsakaiIinEntity check用割当委員Entity, GogitaiWariateShinsakaiIinEntity 割当委員Entity) {
        boolean is合議体番号一致 = get合議体番号(check用割当委員Entity) == get合議体番号(割当委員Entity);
        boolean is開始年月日一致 = get開始年月日(check用割当委員Entity).equals(get開始年月日(割当委員Entity));

        return is合議体番号一致 && is開始年月日一致;
    }

    private static int get合議体番号(GogitaiWariateShinsakaiIinEntity 合議体割当委員Entity) {
        return 合議体割当委員Entity.get合議体情報Entity().getGogitaiNo();
    }

    private static FlexibleDate get開始年月日(GogitaiWariateShinsakaiIinEntity 合議体割当委員Entity) {
        return 合議体割当委員Entity.get合議体情報Entity().getGogitaiYukoKikanKaishiYMD();
    }
}
