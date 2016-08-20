package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokeijoho;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokeijoho.TokeiJohoResearcherMybatisParameter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 統計情報照会のマッパーインタフェースです。
 *
 * @reamsid_L DBU-4120-030 sunhaidi
 */
public interface ITokeiJohoResearcherMapper {

    /**
     * 資格人数または被保険者人数を取得します。
     *
     * @param parameter TokeiJohoResearcherMybatisParameter
     * @return 人数
     */
    int get資格人数(TokeiJohoResearcherMybatisParameter parameter);

    /**
     * 適用除外者人数を取得します。
     *
     * @param parameter TokeiJohoResearcherMybatisParameter
     * @return 人数
     */
    int get適用除外者人数(TokeiJohoResearcherMybatisParameter parameter);

    /**
     * 他住所地特例者人数を取得します。
     *
     * @param parameter TokeiJohoResearcherMybatisParameter
     * @return 人数
     */
    int get他住所地特例者人数(TokeiJohoResearcherMybatisParameter parameter);

    /**
     * 特別徴収人数を取得します。
     *
     * @param parameter TokeiJohoResearcherMybatisParameter
     * @return 人数
     */
    int get特別徴収人数(TokeiJohoResearcherMybatisParameter parameter);

    /**
     * 要介護１人数を取得します。
     *
     * @param parameter TokeiJohoResearcherMybatisParameter
     * @return 人数
     */
    int get要介護人数(TokeiJohoResearcherMybatisParameter parameter);

    /**
     * 自立人数を取得します。
     *
     * @param parameter TokeiJohoResearcherMybatisParameter
     * @return 人数
     */
    int get自立人数(TokeiJohoResearcherMybatisParameter parameter);
}
