/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc2210011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3066ShichosonTokubetuKyufuServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc2210011.TokubetsuKyufuJigyoshaSearchEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author liuyl
 */
public interface ITokubetsuKyufuJigyoshaSearchMapper {

    List<DbT3066ShichosonTokubetuKyufuServiceEntity> selectサービス内容();

    List<TokubetsuKyufuJigyoshaSearchEntity> select事業者情報(RString 事業者番号);
}
