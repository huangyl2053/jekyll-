/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choteibo;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 調定簿作成のMyBatisパラメータ
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class ChoteiboMyBatisParameter implements IMyBatisParameter {

    private final FlexibleYear shoriNendo;
    private final YMDHMS chushutsuStYMD;
    private final YMDHMS chushutsuEdYMD;

    /**
     * コンストラクス
     *
     * @param shoriNendo 処理年度
     * @param chushutsuStYMD 開始調定日時
     * @param chushutsuEdYMD 終了調定日時
     */
    public ChoteiboMyBatisParameter(FlexibleYear shoriNendo, YMDHMS chushutsuStYMD, YMDHMS chushutsuEdYMD) {
        this.shoriNendo = shoriNendo;
        this.chushutsuStYMD = chushutsuStYMD;
        this.chushutsuEdYMD = chushutsuEdYMD;
    }
}
