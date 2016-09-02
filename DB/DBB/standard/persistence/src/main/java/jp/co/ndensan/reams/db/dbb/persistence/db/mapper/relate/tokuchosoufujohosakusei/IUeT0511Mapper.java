/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosoufujohosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshaichiransakusei.TokuchoSeidokanIFSakuseiMyBatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;

/**
 * ビジネス設計_DBBBZ84001_3_特徴制度間Ｉ／Ｆ（バッチ）のMapperクラスです。
 *
 * @reamsid_L DBB-1830-050 liuyang
 */
public interface IUeT0511Mapper {

    /**
     * select特徴回付情報のデータのメソドです。
     *
     * @param parameter TokuchoSeidokanIFSakuseiMyBatisParameter
     * @return List<UeT0511NenkinTokuchoKaifuJohoEntity>
     */
    List<UeT0511NenkinTokuchoKaifuJohoEntity> select(TokuchoSeidokanIFSakuseiMyBatisParameter parameter);

    /**
     * select特徴回付情報のデータのメソドです。
     *
     * @param parameter TokuchoSeidokanIFSakuseiMyBatisParameter
     * @return List<UeT0511NenkinTokuchoKaifuJohoEntity>
     */
    List<UeT0511NenkinTokuchoKaifuJohoEntity> selectApr(TokuchoSeidokanIFSakuseiMyBatisParameter parameter);

    /**
     * select特徴回付情報のデータのメソドです。
     *
     * @param parameter TokuchoSeidokanIFSakuseiMyBatisParameter
     * @return List<UeT0511NenkinTokuchoKaifuJohoEntity>
     */
    List<UeT0511NenkinTokuchoKaifuJohoEntity> selectJun(TokuchoSeidokanIFSakuseiMyBatisParameter parameter);

    /**
     * select特徴回付情報のデータのメソドです。
     *
     * @param parameter TokuchoSeidokanIFSakuseiMyBatisParameter
     * @return List<UeT0511NenkinTokuchoKaifuJohoEntity>
     */
    List<UeT0511NenkinTokuchoKaifuJohoEntity> selectAug(TokuchoSeidokanIFSakuseiMyBatisParameter parameter);

    /**
     * select特徴回付情報のデータのメソドです。
     *
     * @param parameter TokuchoSeidokanIFSakuseiMyBatisParameter
     * @return List<UeT0511NenkinTokuchoKaifuJohoEntity>
     */
    List<UeT0511NenkinTokuchoKaifuJohoEntity> selectOct(TokuchoSeidokanIFSakuseiMyBatisParameter parameter);

    /**
     * select特徴回付情報のデータのメソドです。
     *
     * @param parameter TokuchoSeidokanIFSakuseiMyBatisParameter
     * @return List<UeT0511NenkinTokuchoKaifuJohoEntity>
     */
    List<UeT0511NenkinTokuchoKaifuJohoEntity> selectDec(TokuchoSeidokanIFSakuseiMyBatisParameter parameter);

    /**
     * select特徴回付情報のデータのメソドです。
     *
     * @param parameter TokuchoSeidokanIFSakuseiMyBatisParameter
     * @return List<UeT0511NenkinTokuchoKaifuJohoEntity>
     */
    List<UeT0511NenkinTokuchoKaifuJohoEntity> selectFeb(TokuchoSeidokanIFSakuseiMyBatisParameter parameter);

}
