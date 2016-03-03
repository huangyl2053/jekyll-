/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shujiiiryokikanandshujiiguide;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiGuideParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiRelateEntity;

/**
 * 主治医医療機関＆主治医情報検索のインタフェイスです。
 */
public interface IShujiiIryokikanAndShujiiGuideMapper {

    /**
     * 入力された検索条件によって、主治医医療機関＆主治医情報を取得します。
     *
     * @param parameter 主治医医療機関＆主治医情報検索パラメータ
     * @return ShujiiIryokikanAndShujiiRelateEntity
     */
    List<ShujiiIryokikanAndShujiiRelateEntity> get主治医医療機関_主治医情報(
            ShujiiIryokikanAndShujiiGuideParameter parameter);

    /**
     * 入力された検索条件によって、主治医医療機関＆主治医情報を取得します。
     *
     * @param parameter 主治医医療機関＆主治医情報検索パラメータ
     * @return ShujiiIryokikanAndShujiiRelateEntity
     */
    List<ShujiiIryokikanAndShujiiRelateEntity> get子主治医医療機関_子主治医情報(
            ShujiiIryokikanAndShujiiGuideParameter parameter);
}
