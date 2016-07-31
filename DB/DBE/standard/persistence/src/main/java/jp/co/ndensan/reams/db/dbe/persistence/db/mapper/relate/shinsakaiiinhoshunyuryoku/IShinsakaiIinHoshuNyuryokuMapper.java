/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiiinhoshunyuryoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiiinhoshunyuryoku.ShinsakaiIinHoshuNyuryokuMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinhoshunyuryoku.ShinsakaiIinHoshuNyuryokuEntity;

/**
 *
 * 審査会委員報酬入力のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1950-010 zhengsongling
 */
public interface IShinsakaiIinHoshuNyuryokuMapper {

    /**
     * 審査会委員一覧情報取得します。
     *
     * @param param 審査会委員報酬入力を特定するためのMyBatis用パラメータクラスです。
     * @return DbT5594ShinsakaiIinJohoEntity 審査会委員報酬入力結果情報RelateEntityクラスです。
     */
    List<ShinsakaiIinHoshuNyuryokuEntity> getShinsakaiIin(ShinsakaiIinHoshuNyuryokuMapperParameter param);

    /**
     * 審査実績一覧検索情報取得します。
     *
     * @param param 審査会委員報酬入力を特定するためのMyBatis用パラメータクラスです。
     * @return ShinsakaiIinHoshuNyuryokuEntity 審査会委員報酬入力結果情報RelateEntityクラスです。
     */
    List<ShinsakaiIinHoshuNyuryokuEntity> getdgShinsakaiJisseki(ShinsakaiIinHoshuNyuryokuMapperParameter param);

    /**
     * 介護認定審査会委員報酬実績情報．連番取得します。
     *
     * @param param 審査会委員報酬入力を特定するためのMyBatis用パラメータクラスです。
     * @return ShinsakaiIinHoshuNyuryokuEntity 介護認定審査会委員報酬実績情報．連番RelateEntityクラスです。
     */
    int getremban(ShinsakaiIinHoshuNyuryokuMapperParameter param);
}
