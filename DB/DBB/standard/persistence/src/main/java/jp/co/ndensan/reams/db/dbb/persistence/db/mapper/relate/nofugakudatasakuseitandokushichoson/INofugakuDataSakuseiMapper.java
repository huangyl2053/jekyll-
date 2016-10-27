/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.nofugakudatasakuseitandokushichoson;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.nofugakudatasakuseitandokushichoson.NofugakuDataMybatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.NofugakuJohoReportEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.NofugakuJohoResultEntity;

/**
 * バッチ設計_DBBBT91003_納付額データ作成 のマッパーインタフェースです。
 *
 * @reamsid_L DBB-1890-030 chenaoqi
 */
public interface INofugakuDataSakuseiMapper {

    /**
     * 納付額情報を取得するメソッドです。
     *
     * @param parameter NofugakuDataMybatisParameter
     * @return 納付額情報
     */
    List<NofugakuJohoResultEntity> get納付額情報(NofugakuDataMybatisParameter parameter);

    /**
     * 納付額一覧表情報を取得するメソッドです。
     *
     * @param parameter NofugakuDataMybatisParameter
     * @return 納付額一覧表情報
     */
    List<NofugakuJohoReportEntity> get納付額一覧表情報(NofugakuDataMybatisParameter parameter);

}
