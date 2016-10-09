/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 1号被保険者および賦課基準日時点の世帯員の取得のパラメタ
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuNendoParameter implements IMyBatisParameter {

    private FlexibleDate 処理年度_0101;
    private FlexibleDate 処理年度_0102;
    private FlexibleDate 処理年度_0401;
    private FlexibleDate 処理年度_plus1_0331;
    private FlexibleDate 処理年度_plus1_0731;
    private FlexibleDate 処理年度_plus1_0401;
    private FlexibleDate 処理年度_minus64_0401;
    private FlexibleDate 処理年度_minus18_0102;
    private FlexibleDate 処理年度_minus39_0401;
    private FlexibleDate 処理年度_0801;
    private FlexibleDate システム日付;
    private RString 出力対象;
}
