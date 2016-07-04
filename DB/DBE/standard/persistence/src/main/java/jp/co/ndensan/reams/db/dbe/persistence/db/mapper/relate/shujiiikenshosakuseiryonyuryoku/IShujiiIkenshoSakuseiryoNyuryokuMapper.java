/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshosakuseiryonyuryoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiryonyuryoku.ShujiiIkenshoSakuseiryoNyuryokuParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiryonyuryoku.ShujiiJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiryonyuryoku.ShujiiJohoRelateEntity;

/**
 * 主治医意見書作成料入力のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1960-010 xuyannan
 */
public interface IShujiiIkenshoSakuseiryoNyuryokuMapper {

    /**
     * 主治医情報を取得します。
     *
     * @param parameter ShujiiIkenshoSakuseiryoNyuryokuParameter
     * @return List<ShujiiJohoRelateEntity>
     */
    List<ShujiiJohoRelateEntity> select主治医情報(ShujiiIkenshoSakuseiryoNyuryokuParameter parameter);

    /**
     * 主治医実績一覧を取得します。
     *
     * @param parameter ShujiiIkenshoSakuseiryoNyuryokuParameter
     * @return List<ShujiiJissekiIchiranRelateEntity>
     */
    List<ShujiiJissekiIchiranRelateEntity> select主治医実績一覧(ShujiiIkenshoSakuseiryoNyuryokuParameter parameter);
}
