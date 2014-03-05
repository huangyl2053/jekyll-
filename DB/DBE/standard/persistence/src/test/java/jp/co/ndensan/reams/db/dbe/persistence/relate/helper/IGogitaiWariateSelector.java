/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate.helper;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合議体割当委員の情報を取得する、テスト用DACのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IGogitaiWariateSelector {

    /**
     * 合議体番号と合議体有効開始年月日を受け取り、合議体に割り当てられた委員のリストを返します。
     *
     * @param 合議体番号 合議体番号
     * @param 合議体有効開始年月日 合議体有効開始年月日
     * @return 合議体割当委員List
     */
    @Transaction
    List<DbT5107GogitaiWariateIinJohoEntity> select(GogitaiNo 合議体番号, FlexibleDate 合議体有効開始年月日);
}
