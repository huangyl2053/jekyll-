/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe233001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001.ShujiiIkenTokusokujoHakkoMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001.ShujiiIkenTokusokujoMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe233001.ShujiiIkenTokusokujoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe233001.ShujiiIkenTokusokujoRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書督促状発行のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0060-040 zhangzhiming
 */
public interface IDbe233001RelateMapper {

    /**
     * 主治医意見書督促状状パラメータを取得します。
     *
     * @param parameter 検索条件
     * @return ShujiiIkenTokusokujoRelateEntity 検索結果の{@link ShujiiIkenTokusokujoRelateEntity}
     */
    List<ShujiiIkenTokusokujoRelateEntity> select主治医意見書督促状ByKey(ShujiiIkenTokusokujoMybitisParamter parameter);

    /**
     * 主治医意見書督促対象者一覧表パラメータを取得します。
     *
     * @param parameter 検索条件
     * @return ShujiiIkenTokusokujoHakkoRelateEntity 検索結果の{@link ShujiiIkenTokusokujoHakkoRelateEntity}
     */
    List<ShujiiIkenTokusokujoHakkoRelateEntity> select主治医意見書督促対象者一覧表ByKey(ShujiiIkenTokusokujoHakkoMybitisParamter parameter);

    /**
     * 市町村コードを取得します。
     *
     * @param 保険者コード 保険者コード
     * @return DbT7051KoseiShichosonMasterEntity 検索結果の{@link DbT7051KoseiShichosonMasterEntity}
     */
    DbT7051KoseiShichosonMasterEntity select市町村コード(RString 保険者コード);

    /**
     * 宛名機関名等を取得します。
     *
     * @param parameter 検索条件
     * @return 宛名機関 検索結果の{@link DbT5912ShujiiJohoEntity}
     */
    DbT5912ShujiiJohoEntity select宛名機関(ShujiiIkenTokusokujoMybitisParamter parameter);
}
