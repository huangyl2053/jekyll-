/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.GogitaichoKubun;
import jp.co.ndensan.reams.db.dbe.business.ShinsainKubun;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiWariateIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIinShukketsuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 審査会割当委員の情報についてマッピングを行うクラスです。
 *
 * @author n8178 城間篤人
 */
public final class ShinsakaiWariateIinMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private ShinsakaiWariateIinMapper() {
    }

    /**
     * 審査会割当委員Entityと、それに対応する委員情報、審査会情報を受け取り、審査会割当委員クラスにマッピングします。<br/>
     * 引数にnullが渡された場合、nullが返ります。
     *
     * @param 審査会割当委員Entity 審査会割当委員Entity
     * @param 委員 委員
     * @param 審査会情報 審査会情報
     * @return 審査会割当委員
     */
    public static ShinsakaiWariateIin to審査会割当委員(DbT5106ShinsakaiWariateIinJohoEntity 審査会割当委員Entity,
            ShinsakaiIin 委員, ShinsakaiDetail 審査会情報) throws IllegalArgumentException {
        if (審査会割当委員Entity == null) {
            return null;
        } else if (委員 == null || 審査会情報 == null) {
            throw new IllegalArgumentException();
        }

        return new ShinsakaiWariateIin(審査会情報,
                委員,
                create審査員区分(審査会割当委員Entity),
                create合議体長区分(審査会割当委員Entity),
                create審査時間(審査会割当委員Entity),
                ShinsakaiIinShukketsuKubun.toValue(審査会割当委員Entity.getShinsakaiIinShukketsuKubun()));
    }

    private static ShinsainKubun create審査員区分(DbT5106ShinsakaiWariateIinJohoEntity entity) {
        return new ShinsainKubun(entity.getShinsainKubunCode(),
                entity.getShinsainKubunCodeMeisho(), entity.getShinsainKubunCodeRyakusho());
    }

    private static GogitaichoKubun create合議体長区分(DbT5106ShinsakaiWariateIinJohoEntity entity) {
        return new GogitaichoKubun(entity.getGogitaichoKubunCode(),
                entity.getGogitaichoKubunCodeMeisho(), entity.getGogitaichoKubunCodeRyakusho());
    }

    private static Range<TimeString> create審査時間(DbT5106ShinsakaiWariateIinJohoEntity entity) {
        return new Range(new TimeString(entity.getShinsakaiIinShinsaKaishiTime()),
                new TimeString(entity.getShinsakaiIinshinsaShuryoTime()));
    }

    /**
     * 引数から審査会割当委員EntityList・委員List・審査会情報を受け取り、
     * それらの情報をマッピングして審査会割当委員Listを生成し、返却します。<br/>
     * 引数のいずれかにnullが渡されたとき、nullが返却されます。
     *
     * @param 審査会割当委員EntityList 審査会割当委員EntityList
     * @param 委員List 委員List
     * @param 審査会情報 審査会情報
     * @return 審査会List
     * @throws IllegalArgumentException
     * 審査会割当委員Entityが持つ委員コードと、委員情報の委員コードで、対応しないものが存在したとき
     */
    public static ShinsakaiWariateIinList to審査会割当委員List(List<DbT5106ShinsakaiWariateIinJohoEntity> 審査会割当委員EntityList,
            ShinsakaiIinList 委員List, ShinsakaiDetail 審査会情報) throws IllegalArgumentException {
        if (委員List == null || 審査会割当委員EntityList == null || 審査会情報 == null) {
            return null;
        }

        List<ShinsakaiWariateIin> 審査会員List = new ArrayList<>();
        for (DbT5106ShinsakaiWariateIinJohoEntity 審査会割当委員Entity : 審査会割当委員EntityList) {
            ShinsakaiIin 委員 = find対応委員(審査会割当委員Entity, 委員List);
            審査会員List.add(to審査会割当委員(審査会割当委員Entity, 委員, 審査会情報));
        }
        return new ShinsakaiWariateIinList(審査会員List);
    }

    private static ShinsakaiIin find対応委員(DbT5106ShinsakaiWariateIinJohoEntity 審査会割当委員Entity, ShinsakaiIinList 委員List)
            throws IllegalArgumentException {
        for (ShinsakaiIin 委員 : 委員List) {
            if (is委員コードが一致(審査会割当委員Entity, 委員)) {
                return 委員;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("審査会割当情報に対応した委員").getMessage());
    }

    private static boolean is委員コードが一致(DbT5106ShinsakaiWariateIinJohoEntity 審査会割当委員Entity, ShinsakaiIin 委員) {
        return 委員.get委員コード().value().equals(審査会割当委員Entity.getShinsakaiIinCode());
    }

    /**
     * 審査会割当委員の情報を、審査会割当委員Entityにマッピングします。<br/>
     * 引数にnullが渡されたとき_nullが返却されます。
     *
     * @param 審査会割当委員 審査会割当委員
     * @return 審査会割当委員Entity
     */
    public static DbT5106ShinsakaiWariateIinJohoEntity to審査員割当委員Entity(ShinsakaiWariateIin 審査会割当委員) {
        DbT5106ShinsakaiWariateIinJohoEntity entity = new DbT5106ShinsakaiWariateIinJohoEntity();
        entity.setShinsakaiKaisaiNo(審査会割当委員.get審査会情報().get審査会開催番号().value());
        entity.setShinsakaiKaisaiYMD(審査会割当委員.get審査会情報().get審査会開催年月日().value());
        entity.setShinsakaiIinCode(審査会割当委員.get委員情報().get委員コード().value());
        entity.setShinsainKubunCode(審査会割当委員.get認定審査員区分().getCode());
        entity.setGogitaichoKubunCode(審査会割当委員.get合議体長区分().getCode());
        entity.setShinsakaiIinShinsaKaishiTime(審査会割当委員.get審査時間().getFrom().value());
        entity.setShinsakaiIinshinsaShuryoTime(審査会割当委員.get審査時間().getTo().value());
        entity.setShinsakaiIinShukketsuKubun(審査会割当委員.get出欠区分().get出欠区分コード());
        return entity;
    }

    /**
     * 審査会割当委員のリストを受け取り、その情報を元にマッピングを行い、審査会割当委員EntityListを生成して返します。<br/>
     * 引数にnullが渡されたとき_nullが返却されます。
     *
     * @param 審査会割当委員List 審査会割当委員List
     * @return 審査会割当委員EntityList
     */
    public static List<DbT5106ShinsakaiWariateIinJohoEntity> to審査会割当委員EntityList(ShinsakaiWariateIinList 審査会割当委員List) {
        List<DbT5106ShinsakaiWariateIinJohoEntity> entityList = new ArrayList<>();
        for (ShinsakaiWariateIin 審査会割当委員 : 審査会割当委員List) {
            entityList.add(to審査員割当委員Entity(審査会割当委員));
        }
        return entityList;
    }
}
