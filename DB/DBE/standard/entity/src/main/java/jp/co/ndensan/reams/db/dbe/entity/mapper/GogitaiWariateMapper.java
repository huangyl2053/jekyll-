/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.Gogitai;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIin;
import jp.co.ndensan.reams.db.dbe.business.GogitaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.business.GogitaichoKubun;
import jp.co.ndensan.reams.db.dbe.business.ShinsainKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.GogitaiWariateShinsakaiIinEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 合議体割当のマッピングを行うクラスです。
 *
 * @author n8178 城間篤人
 */
public final class GogitaiWariateMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private GogitaiWariateMapper() {
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

        List<GogitaiWariateIin> retList = new ArrayList<>();
        for (GogitaiWariateShinsakaiIinEntity 合議体割当委員Entity : 合議体割当委員EntityList) {
            retList.add(to合議体割当委員(合議体割当委員Entity));
        }
        return new GogitaiWariateIinList(retList);
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

        return new GogitaiWariateIin(ShinsakaiIinMapper.to審査会委員(合議体割当委員Entity.get審査会委員Entity()),
                new ShinsainKubun(合議体割当委員Entity.get合議体割当Entity().getShinsainKubunCode().value(),
                合議体割当委員Entity.get合議体割当Entity().getShinsainKubunName()),
                new GogitaichoKubun(合議体割当委員Entity.get合議体割当Entity().getGogitaichoKubunCode().value(),
                合議体割当委員Entity.get合議体割当Entity().getGogitaichoKubunName()));
    }

    /**
     * 合議体の情報を元にマッピングを行い、合議体割当Entityのリストを返します。<br/>
     * 引数にnullが渡された場合は、nullを返します。
     *
     * @param 合議体 合議体
     * @return 合議体割当EntityList
     */
    public static List<DbT5107GogitaiWariateIinJohoEntity> to合議体割当EntityList(Gogitai 合議体) {
        if (合議体 == null) {
            return null;
        }

        List<DbT5107GogitaiWariateIinJohoEntity> retList = new ArrayList<>();
        for (GogitaiWariateIin 合議体割当委員 : 合議体.get合議体割当審査会委員List()) {
            retList.add(to合議体割当Entity(合議体, 合議体割当委員));
        }
        return retList;
    }

    /**
     * 合議体と合議体割当の情報を、合議体割当Entityにマッピングします。<br/>
     * 引数のどちらかにnullが渡されたとき、nullを返します。
     *
     * @param 合議体 合議体
     * @param 合議体割当委員 合議体割当委員
     * @return 合議体割当Entity
     */
    public static DbT5107GogitaiWariateIinJohoEntity to合議体割当Entity(Gogitai 合議体, GogitaiWariateIin 合議体割当委員) {
        if (合議体 == null || 合議体割当委員 == null) {
            return null;
        }

        DbT5107GogitaiWariateIinJohoEntity entity = new DbT5107GogitaiWariateIinJohoEntity();
        entity.setGogitaiNo(合議体.get合議体番号().value());
        entity.setShinsakaiIinCode(合議体割当委員.get委員情報().get委員コード().value());
        entity.setGogitaiYukoKikanKaishiYMD(合議体.get有効期間().getFrom());
        entity.setGogitaiYukoKikanShuryoYMD(合議体.get有効期間().getTo());
        entity.setGogitaichoKubunCode(new Code(合議体割当委員.get合議体長区分().getCode()));
        entity.setShinsainKubunCode(new Code(合議体割当委員.get認定調査員区分().getCode()));
        return entity;
    }
}
