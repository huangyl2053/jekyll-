/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.JukyushaKihonJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoMybatisParamater;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.JukyushaTeikyoJohoKohoEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.JukyushaTeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報提供のmapperクラスです。
 *
 * @reamsid_L DBU-4880-090 wangxiaodong
 */
public interface ITokuteiKojinJohoTeikyoMapper {

    /**
     * 版改定のcountを取得します。
     *
     * @param shokaiTeikyoKubun 初回提供区分
     * @return COUNT(版番号)
     */
    int getTokuteiKojinJohoHanKanriCount(RString shokaiTeikyoKubun);

    /**
     * 処理日付を取得します。
     *
     * @param paramater TokuteiKojinJohoTeikyoMybatisParamater
     * @return 処理日付
     */
    DbT7022ShoriDateKanriEntity getKijunYMD(TokuteiKojinJohoTeikyoMybatisParamater paramater);

    /**
     * 受給者基本情報の提供情報(候補)を取得します。
     *
     * @param parameter JukyushaKihonJohoMybatisParameter
     * @return 提供情報(候補)
     */
    List<JukyushaTeikyoJohoKohoEntity> getJukyushaDaichoTeikyoJohoKoho(JukyushaKihonJohoMybatisParameter parameter);

    /**
     * 受給者基本情報の提供情報(候補)を取得します。
     *
     * @param tempTableName 中間DB（提供基本情報nn）
     * @return 提供情報(候補)
     */
    List<JukyushaTeikyoKihonJohoNNTempEntity> getJukyushaTeikyoKihonJohoNNTempData(JukyushaKihonJohoMybatisParameter tempTableName);

    /**
     * 処理日付を取得します。
     *
     * @param paramater TokuteiKojinJohoTeikyoMybatisParamater
     * @return 処理日付
     */
    List<DbT7022ShoriDateKanriEntity> getShoriDateKanriByShoriName(TokuteiKojinJohoTeikyoMybatisParamater paramater);

}
