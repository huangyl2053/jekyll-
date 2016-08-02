/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.enkitsuchisho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * バッチ設計_DBD522001_延期通知書出力バッチパラメタークラスです．
 *
 * @reamsid_L DBD-5220-001 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class EnkiTsuchishohakenIchiranhyoJyohoMybatisParameter implements IMyBatisParameter {

    private FlexibleDate shorimikomibiFrom;
    private FlexibleDate shorimikomibiTo;
    private FlexibleDate tsuchishohakkonbi;

    /**
     * コンストラクタです。
     *
     * @param 処理見込み日From shorimikomibiFrom
     * @param 処理見込み日To shorimikomibiTo
     * @param 通知書発行日 tsuchishohakkonbi
     */
    public EnkiTsuchishohakenIchiranhyoJyohoMybatisParameter(
            FlexibleDate 処理見込み日From,
            FlexibleDate 処理見込み日To,
            FlexibleDate 通知書発行日) {
        this.shorimikomibiFrom = 処理見込み日From;
        this.shorimikomibiTo = 処理見込み日To;
        this.tsuchishohakkonbi = 通知書発行日;
    }
}
