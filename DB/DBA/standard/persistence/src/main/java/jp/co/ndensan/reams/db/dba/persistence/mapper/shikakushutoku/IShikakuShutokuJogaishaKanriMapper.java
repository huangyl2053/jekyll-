/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.mapper.shikakushutoku;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriParameter;
import jp.co.ndensan.reams.db.dba.entity.db.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriEntity;

/**
 *
 * 資格取得除外者管理のMapperクラス。
 */
public interface IShikakuShutokuJogaishaKanriMapper {

    /**
     * 資格関連異動を取得します。
     *
     * @return ShikakuShutokuJogaishaKanriEntity
     */
    List<ShikakuShutokuJogaishaKanriEntity> get資格取得除外者一覧();

    /**
     * 宛名情報を取得します。
     *
     * @param parameter ShikakuShutokuJogaishaKanriParameter
     * @return ShikakuShutokuJogaishaKanriEntity
     */
    ShikakuShutokuJogaishaKanriEntity get宛名情報(ShikakuShutokuJogaishaKanriParameter parameter);

    /**
     * 宛名情報を取得します。
     *
     * @param shakanrientity ShikakuShutokuJogaishaKanriEntity
     * @return int
     */
    int get除外期間重複チェック(ShikakuShutokuJogaishaKanriEntity shakanrientity);

    /**
     * MAX履歴番号を取得します。
     *
     * @return int
     */
    int get履歴番号();

}
