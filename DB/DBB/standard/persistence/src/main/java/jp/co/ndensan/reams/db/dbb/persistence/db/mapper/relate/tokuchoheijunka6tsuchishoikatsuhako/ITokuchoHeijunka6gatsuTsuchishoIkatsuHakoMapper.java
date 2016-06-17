/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 特徴平準化（特徴6月分）通知書一括発行(バッチ)のMapperクラスです。
 *
 * @reamsid_L DBB-0820-040 xuyue
 */
public interface ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper {

    /**
     * 基準日時を取得する。
     *
     * @param param パラメータ
     * @return 基準日時
     */
    RString get基準日時(TokuchoHeijunka6gatsuMyBatisParameter param);

    /**
     * 前年度特徴期別金額06を取得します。
     *
     * @param 徴収方法 徴収方法
     * @return 前年度特徴期別金額06
     */
    RString select前年度特徴期別金額06(@Param("徴収方法") RString 徴収方法);

}
