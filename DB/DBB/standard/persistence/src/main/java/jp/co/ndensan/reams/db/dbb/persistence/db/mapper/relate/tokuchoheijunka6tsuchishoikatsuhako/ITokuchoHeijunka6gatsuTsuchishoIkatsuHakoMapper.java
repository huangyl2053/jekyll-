/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
     * 計算後情報テーブルの更新前後区分が「更正前」のデータにより、仮算定額変更情報一時テーブルの計算後情報「更正前」情報を更新する。
     *
     * @param param パラメータ
     */
    void update計算後情報更正前(TokuchoHeijunka6gatsuMyBatisParameter param);

    /**
     * 前年度・特徴期別金額06を更新する。
     *
     * @param param パラメータ
     */
    void update前年度特徴期別金額06(TokuchoHeijunka6gatsuMyBatisParameter param);

}
