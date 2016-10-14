/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.tokubetsukyufujigyoshakannri;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc2210011.TokubetsuKyufuJigyoshaRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;

/**
 * 市町村特別給付・サービス事業者管理のマッパーインタフェースです。
 *
 * @reamsid_L DBC-3430-010 miaojin
 */
public interface ITokubetsuKyufuJigyoshaRelateMapper {

    /**
     * 事業者情報を取得します。
     *
     * @param 事業者番号 市町村特別給付・サービス事業者管理のパラメータクラス
     * @return 事業者情報
     */
    List<TokubetsuKyufuJigyoshaRelateEntity> get事業者情報(JigyoshaNo 事業者番号);
}
