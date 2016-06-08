/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoteishitaisyosyadoutei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoteishitaisyosyadoutei.TokuchoTeishiTaisyosyaDouteiMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shoridatekanri.KonkaiShoriNaiyoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shoridatekanri.ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shoridatekanri.ShoriJokyoJohoEntity;

/**
 * ビジネス設計_DBBBZ81002_1_特徴対象者同定（一括）Mapper
 *
 * @reamsid_L DBB-1850-030 sunhui
 */
public interface ITokuchoTeishiTaisyosyaDouteiMapper {

    /**
     * 処理日付管理マスタからデータを取得する。
     *
     * @param param param
     * @return List<ShoriDateKanriEntity>
     */
    List<ShoriDateKanriEntity> select処理日付管理マスタ(TokuchoTeishiTaisyosyaDouteiMybatisParameter param);

    /**
     * 処理日付管理マスタからデータを取得する。
     *
     * @param param param
     * @return List<ShoriJokyoJohoEntity>
     */
    List<ShoriJokyoJohoEntity> select処理状況一覧情報(TokuchoTeishiTaisyosyaDouteiMybatisParameter param);

    /**
     * 処理日付管理マスタからデータを取得する。
     *
     * @param param param
     * @return KonkaiShoriNaiyoJohoEntity
     */
    KonkaiShoriNaiyoJohoEntity select今回処理内容情報(TokuchoTeishiTaisyosyaDouteiMybatisParameter param);
}
