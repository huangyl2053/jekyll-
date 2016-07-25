/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2502KaigoShotokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * {@link jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic.IDbT2002FukaMapper}のマッパーIFです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 *
 */
public interface IDbV2502KaigoShotokuMapper {

    /**
     * 指定した条件を元に、{@link IDbV2502KaigoShotokuEntity}を複数件取得します。
     *
     * @param shiteiNendo 年度指定。指定した年度のみを対象とする。
     * @param shiteiShoriYMDHMS 処理日時指定。指定した日時以下の処理日時のみを対象にする。
     * @param shikibetsuCodeList 識別コードList。指定した識別コードのみ検索対象とする。
     * @return {@link DbV2002FukaEntity}のList
     */
    List<DbV2502KaigoShotokuEntity> getShotokuJohoList(FlexibleYear shiteiNendo, YMDHMS shiteiShoriYMDHMS, List<ShikibetsuCode> shikibetsuCodeList);
}
