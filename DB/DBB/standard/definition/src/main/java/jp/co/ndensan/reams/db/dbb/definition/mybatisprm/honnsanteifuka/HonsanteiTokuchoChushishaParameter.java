/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honnsanteifuka;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 本算定特徴中止者追加、徴収方法の情報を取得パラメタのクラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteiTokuchoChushishaParameter implements IMyBatisParameter {

    private FlexibleYear 賦課年度;
    private YMDHMS 処理日時;
}
