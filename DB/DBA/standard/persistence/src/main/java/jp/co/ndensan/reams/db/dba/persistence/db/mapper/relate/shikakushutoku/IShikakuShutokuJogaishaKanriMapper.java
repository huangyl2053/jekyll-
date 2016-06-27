/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.shikakushutoku;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;

/**
 * 資格取得除外者管理のMapperクラス。
 *
 * @reamsid_L DBA-0440-030 zhangzhiming
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
     * 除外期間重複チェックします。
     *
     * @param shakanrientity DbT1009ShikakuShutokuJogaishaEntity
     * @return int
     */
    int get除外期間重複チェック(DbT1009ShikakuShutokuJogaishaEntity shakanrientity);
}
