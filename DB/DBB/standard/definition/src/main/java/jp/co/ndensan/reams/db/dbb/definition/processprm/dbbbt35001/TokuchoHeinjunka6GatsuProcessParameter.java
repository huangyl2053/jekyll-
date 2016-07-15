/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.TyouhyouEntity;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴平準化（特徴6月分）用パラメータのクラスです。
 *
 * @reamsid_L DBB-0810-010 yuanzhenxia
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHeinjunka6GatsuProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private YMDHMS 調定日時;
    private TyouhyouEntity 出力帳票一覧;
    private RDate 発行日;
    private RString 文書番号;
    private RString 出力対象;
    private RString 増額平準化方法;
    private RString 減額平準化方法;

    /**
     * コンストラクタです。
     *
     * @param 調定年度　調定年度
     * @param 賦課年度　賦課年度
     * @param 調定日時 調定日時
     * @param 出力帳票一覧　出力帳票一覧
     * @param 発行日　発行日
     * @param 文書番号　文書番号
     * @param 出力対象　出力対象
     * @param 増額平準化方法　増額平準化方法
     * @param 減額平準化方法　減額平準化方法
     */
//    public TokuchoHeinjunka6GatsuProcessParameter(FlexibleYear 調定年度, FlexibleYear 賦課年度, RDateTime 調定日時,
//            TyouhyouEntity 出力帳票一覧, RDate 発行日, RString 文書番号, RString 出力対象, RString 増額平準化方法, RString 減額平準化方法) {
//        this.調定年度 = 調定年度;
//        this.賦課年度 = 賦課年度;
//        this.調定日時 = 調定日時;
//        this.出力帳票一覧 = 出力帳票一覧;
//        this.発行日 = 発行日;
//        this.文書番号 = 文書番号;
//        this.出力対象 = 出力対象;
//        this.増額平準化方法 = 増額平準化方法;
//        this.減額平準化方法 = 減額平準化方法;
//    }
}
