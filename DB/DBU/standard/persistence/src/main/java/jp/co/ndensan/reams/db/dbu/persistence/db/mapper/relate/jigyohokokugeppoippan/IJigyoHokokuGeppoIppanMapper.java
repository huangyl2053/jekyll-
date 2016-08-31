/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppoippan;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.SyotaiJohoSyoriMybatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan.SyotaiJohoCsvEntity;

/**
 * 事業報告月報_一般状況のMapperクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public interface IJigyoHokokuGeppoIppanMapper {

    /**
     * 事業状況報告世帯情報をtemp事業報告被保険者統計元データテーブルに登録します。
     *
     * @param paramter SyotaiJohoSyoriMybatisParameter
     */
    void exeShotaiDataInsert(SyotaiJohoSyoriMybatisParameter paramter);

    /**
     * 事業状況報告情報を取得します。
     *
     * @return List<SyotaiJohoCsvEntity>
     */
    List<SyotaiJohoCsvEntity> getShotaiJohoKonkyoCSV();

}
