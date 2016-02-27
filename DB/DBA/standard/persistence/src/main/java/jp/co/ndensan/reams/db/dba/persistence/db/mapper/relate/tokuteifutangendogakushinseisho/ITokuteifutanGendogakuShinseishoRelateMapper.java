/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.db.dba.definition.mybatis.param.tokuteifutangendogakushinseisho.TokuteifutanMybatisParam;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;

/**
 * 受給資格証明書発行情報を取得のマッパーインタフェースです。
 *
 */
public interface ITokuteifutanGendogakuShinseishoRelateMapper {

    /**
     * 施設情報の取得。
     *
     * @param param 介護保険特定負担限度額申請書の検索のパラメータ
     * @return DbT1004ShisetsuNyutaishoEntity
     */
    DbT1004ShisetsuNyutaishoEntity get施設情報(TokuteifutanMybatisParam param);

    /**
     * 事業者情報の取得。
     *
     * @param param 介護保険特定負担限度額申請書の検索のパラメータ
     * @return DbT7060KaigoJigyoshaEntity
     */
    DbT7060KaigoJigyoshaEntity get事業者情報(TokuteifutanMybatisParam param);

    /**
     * 事業者情報の取得。
     *
     * @param param 介護保険特定負担限度額申請書の検索のパラメータ
     * @return DbT1005KaigoJogaiTokureiTaishoShisetsuEntity
     */
    DbT1005KaigoJogaiTokureiTaishoShisetsuEntity get介護除外住所地特例対象施設情報(TokuteifutanMybatisParam param);
}
