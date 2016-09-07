/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchotaishoshaichiransakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshaichiransakusei.TokuchoSeidokanIFSakuseiMyBatisParameter;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;

/**
 * * ビジネス設計_DBBBZ81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-030 liuyang
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
