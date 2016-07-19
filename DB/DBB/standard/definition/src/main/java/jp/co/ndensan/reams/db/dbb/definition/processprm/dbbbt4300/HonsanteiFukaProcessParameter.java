/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt4300;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.TyouhyouEntity;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 本算定賦課計算用パラメータのクラスです。
 *
 * @reamsid_L DBB-0730-010 yuanzhenxia
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteiFukaProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private YMDHMS バッチ起動時処理日時;
    private TyouhyouEntity 出力帳票;
    private FlexibleDate 資格基準日;
}
