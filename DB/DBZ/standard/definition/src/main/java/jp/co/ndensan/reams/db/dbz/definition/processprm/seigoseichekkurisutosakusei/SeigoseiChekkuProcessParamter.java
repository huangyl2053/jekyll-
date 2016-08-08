/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.processprm.seigoseichekkurisutosakusei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;

/**
 * 整合性チェックリストのProcess用パラメータクラスです。
 *
 * @reamsid_L DBA-5800-030 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class SeigoseiChekkuProcessParamter implements IBatchProcessParameter {

    private final FlexibleDate 年齢到達の設定日;

    /**
     * コンストラクタです。
     *
     * @param 年齢到達の設定日 年齢到達の設定日
     */
    public SeigoseiChekkuProcessParamter(FlexibleDate 年齢到達の設定日) {
        this.年齢到達の設定日 = 年齢到達の設定日;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public FlexibleDate toSeigoseiBatchMybitisParamter() {
        return 年齢到達の設定日;
    }
}
