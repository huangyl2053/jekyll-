/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.GogitaiDetail;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIin;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.business.GogitaichoKubun;
import jp.co.ndensan.reams.db.dbe.business.ShinsainKubun;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.GogitaiWariateShinsakaiIinEntity;

/**
 * 合議体割当のマッピングを行うクラスです。
 *
 * @author n8178 城間篤人
 */
public final class GogitaiWariateIinMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private GogitaiWariateIinMapper() {
    }

    /**
     * 合議体割当委員EntityのListを受け取り、それを元に合議体割当委員Listを作成して返します。<br/>
     * 引数にnullが渡されたときは、nullを返します。
     *
     * @param 合議体割当委員EntityList 合議体割当委員EntityList
     * @return 合議体割当委員List
     */
    public static GogitaiWariateIinList to合議体割当委員List(List<GogitaiWariateShinsakaiIinEntity> 合議体割当委員EntityList) {
        if (合議体割当委員EntityList == null) {
            return null;
        }

        List<GogitaiWariateIin> 合議体割当委員list = new ArrayList<>();
        for (GogitaiWariateShinsakaiIinEntity 合議体割当委員Entity : 合議体割当委員EntityList) {
            合議体割当委員list.add(to合議体割当委員(合議体割当委員Entity));
        }
        return new GogitaiWariateIinList(合議体割当委員list);
    }

    /**
     * 合議体割当委員Entityの情報を、合議体割当委員クラスにマッピングして返します。<br/>
     * 引数にnullを渡されたときは、nullを返します。
     *
     * @param 合議体割当委員Entity 合議体割当委員Entity
     * @return 合議体割当委員
     */
    public static GogitaiWariateIin to合議体割当委員(GogitaiWariateShinsakaiIinEntity 合議体割当委員Entity) {
        if (合議体割当委員Entity == null) {
            return null;
        }

        return new GogitaiWariateIin(
                create審査会委員(合議体割当委員Entity),
                create審査員区分(合議体割当委員Entity),
                create合議体長区分(合議体割当委員Entity),
                create合議体情報(合議体割当委員Entity));
    }

    private static ShinsakaiIin create審査会委員(GogitaiWariateShinsakaiIinEntity 合議体割当委員Entity) {
        return ShinsakaiIinMapper.to審査会委員(合議体割当委員Entity.get審査会委員Entity());
    }

    private static ShinsainKubun create審査員区分(GogitaiWariateShinsakaiIinEntity 合議体割当委員Entity) {
        return new ShinsainKubun(合議体割当委員Entity.get合議体割当Entity().getShinsainKubunCode(),
                合議体割当委員Entity.get合議体割当Entity().getShinsainKubunCodeMeisho(), 合議体割当委員Entity.get合議体割当Entity().getShinsainKubunCodeRyakusho());
    }

    private static GogitaichoKubun create合議体長区分(GogitaiWariateShinsakaiIinEntity 合議体割当委員Entity) {
        return new GogitaichoKubun(合議体割当委員Entity.get合議体割当Entity().getGogitaichoKubunCode(),
                合議体割当委員Entity.get合議体割当Entity().getGogitaichoKubunCodeMeisho(), 合議体割当委員Entity.get合議体割当Entity().getGogitaichoKubunCodeRyakusho());
    }

    private static GogitaiDetail create合議体情報(GogitaiWariateShinsakaiIinEntity 合議体割当委員Entity) {
        return GogitaiDetailMapper.to合議体情報(合議体割当委員Entity.get合議体情報Entity(),
                ShinsakaiKaisaiBashoMapper.to審査会開催場所(合議体割当委員Entity.get開催場所Entity()));
    }

    /**
     * 合議体の情報を元にマッピングを行い、合議体割当Entityのリストを返します。<br/>
     * 引数にnullが渡された場合は、nullを返します。
     *
     * @param 合議体割当委員List 合議体
     * @return 合議体割当EntityList
     */
    public static List<DbT5107GogitaiWariateIinJohoEntity> to合議体割当委員EntityList(GogitaiWariateIinList 合議体割当委員List) {
        if (合議体割当委員List == null) {
            return null;
        }

        List<DbT5107GogitaiWariateIinJohoEntity> 合議体割当委員情報EntityList = new ArrayList<>();
        for (GogitaiWariateIin 合議体割当委員 : 合議体割当委員List) {
            合議体割当委員情報EntityList.add(to合議体割当委員Entity(合議体割当委員));
        }
        return 合議体割当委員情報EntityList;
    }

    /**
     * 合議体割当の情報を、合議体割当Entityにマッピングします。<br/>
     * 引数にnullが渡されたとき、nullを返します。
     *
     * @param 合議体割当委員 合議体割当委員
     * @return 合議体割当Entity
     */
    public static DbT5107GogitaiWariateIinJohoEntity to合議体割当委員Entity(GogitaiWariateIin 合議体割当委員) {
        if (合議体割当委員 == null) {
            return null;
        }

        DbT5107GogitaiWariateIinJohoEntity entity = new DbT5107GogitaiWariateIinJohoEntity();
        entity.setGogitaiNo(合議体割当委員.get合議体情報().get合議体番号().value());
        entity.setShinsakaiIinCode(合議体割当委員.get委員情報().get委員コード().value());
        entity.setGogitaiYukoKikanKaishiYMD(合議体割当委員.get合議体情報().get有効期間開始年月日().value());
        entity.setGogitaiYukoKikanShuryoYMD(合議体割当委員.get合議体情報().get有効期間終了年月日());
        entity.setGogitaichoKubunCode(合議体割当委員.get合議体長区分().getCode());
        entity.setShinsainKubunCode(合議体割当委員.get認定調査員区分().getCode());
        return entity;
    }
}
