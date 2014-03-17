/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiYMD;
import jp.co.ndensan.reams.db.dbe.entity.relate.GogitaiWariateShinsakaiIinEntity;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合議体割当情報と、それに割り当てられている審査会委員の情報を取得するDacのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IGogitaiWariateShinsakaiIinDac {

    /**
     * すべての合議体の情報と、それぞれに割り当てられている審査会委員をすべて取得します。
     *
     * @return 合議体割当委員のList
     */
    @Transaction
    List<GogitaiWariateShinsakaiIinEntity> select();

    /**
     * 合議体番号を指定し、合議体の履歴と、それぞれに割り当てられた審査会委員の情報を取得します。
     *
     * @param 合議体番号 合議体番号
     * @return 合議体割当委員のList
     */
    @Transaction
    List<GogitaiWariateShinsakaiIinEntity> select(GogitaiNo 合議体番号);

    /**
     * 合議体有効期間開始年月日を指定し、指定した日付時点で有効な合議体と、それぞれに割り当てられている審査会委員の情報を取得します。
     *
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     * @return 合議体割当委員のList
     */
    @Transaction
    List<GogitaiWariateShinsakaiIinEntity> select(GogitaiYukoKikanKaishiYMD 合議体有効期間開始年月日);

    /**
     * 合議体番号と合議体有効期間開始年月日を指定し、1つの合議体情報と、それに割り当てられた審査会委員の情報を取得します。
     *
     * @param 合議体番号 合議体番号
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     * @return 合議体割当委員のList
     */
    @Transaction
    List<GogitaiWariateShinsakaiIinEntity> select(GogitaiNo 合議体番号, GogitaiYukoKikanKaishiYMD 合議体有効期間開始年月日);
}
