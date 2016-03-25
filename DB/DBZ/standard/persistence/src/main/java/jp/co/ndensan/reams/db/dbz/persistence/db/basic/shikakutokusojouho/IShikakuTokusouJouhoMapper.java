/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic.shikakutokusojouho;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.shikakutokusojouho.ShikakuTokusoJouhoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakutokusojouho.ShikakuTokusouJouhoRelateEntity;

/**
 *
 * 資格履歴情報のMapperクラスです。
 */
public interface IShikakuTokusouJouhoMapper {

    /**
     * 単一の場合。
     *
     * @param params ShikakuTokusoJouhoParameter
     * @return 資格履歴情報の単一
     */
    List<ShikakuTokusouJouhoRelateEntity> getShikakuJoho(ShikakuTokusoJouhoParameter params);

    /**
     * 広域の場合。
     *
     * @param params ShikakuTokusoJouhoParameter
     * @return 資格履歴情報の広域
     */
    List<ShikakuTokusouJouhoRelateEntity> getShikakuTosoJoho(ShikakuTokusoJouhoParameter params);
}
