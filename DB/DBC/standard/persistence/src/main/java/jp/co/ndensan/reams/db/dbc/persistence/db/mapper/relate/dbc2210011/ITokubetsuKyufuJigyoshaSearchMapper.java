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
import org.apache.ibatis.annotations.Param;

/**
 *
 * 市町村特別給付・サービス事業者のMapperです。
 *
 * @reamsid_L DBC-3430-010 liuwei2
 */
public interface ITokubetsuKyufuJigyoshaSearchMapper {

    /**
     * 事業者情報を検索します。
     *
     * @param 事業者番号 RString
     * @param 事業者番号Length int
     * @param cD RString
     * @return List<TokubetsuKyufuJigyoshaSearchEntity>
     */
    List<TokubetsuKyufuJigyoshaSearchEntity> select事業者情報(@Param("事業者番号") RString 事業者番号,
            @Param("事業者番号Length") int 事業者番号Length, @Param("cD") RString cD);

    /**
     * サービス内容を検索します。
     *
     * @return List<DbT3066ShichosonTokubetuKyufuServiceEntity>
     */
    List<DbT3066ShichosonTokubetuKyufuServiceEntity> selectサービス内容();

    /**
     * 事業者情報件数を検索します。
     *
     * @param 入力された事業者コード RString
     * @return int
     */
    int selectCount(@Param("入力された事業者コード") RString 入力された事業者コード);

}
