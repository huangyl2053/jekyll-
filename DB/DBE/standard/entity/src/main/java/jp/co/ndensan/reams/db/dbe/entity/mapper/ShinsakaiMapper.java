/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.Shinsakai;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJohoEntity;

/**
 * 審査会の情報についてマッピングを行うクラスです。
 *
 * @author n8178 城間篤人
 */
public final class ShinsakaiMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private ShinsakaiMapper() {
    }

    /**
     * 引数から審査会割当委員EntityList・審査会委員List・審査会情報を受け取り、それらの情報をマッピングして審査会を生成します。<br/>
     * 引数のいずれかにnullが渡されたとき、nullが返却されます。
     *
     * @param 審査会割当委員EntityList 審査会割当委員EntityList
     * @param 審査会委員List 審査会委員List
     * @param 審査会情報 審査会情報
     * @return 審査会
     * @throws IllegalArgumentException 審査会に割り当てられる委員リストの生成に失敗した場合
     */
    public static Shinsakai to審査会(List<DbT5106ShinsakaiWariateIinJohoEntity> 審査会割当委員EntityList,
            ShinsakaiIinList 審査会委員List, ShinsakaiDetail 審査会情報) throws IllegalArgumentException {
        if (審査会委員List == null || 審査会割当委員EntityList == null || 審査会情報 == null) {
            return null;
        }
        ShinsakaiWariateIinList 審査会割当委員List = ShinsakaiWariateIinMapper.to審査会割当委員List(審査会割当委員EntityList, 審査会委員List, 審査会情報);
        return new Shinsakai(審査会情報, 審査会割当委員List);
    }
}
