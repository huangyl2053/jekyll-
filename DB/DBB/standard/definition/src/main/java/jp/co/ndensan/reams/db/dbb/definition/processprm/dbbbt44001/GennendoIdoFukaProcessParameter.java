/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 本算定異動（現年度）用パラメータのクラスです。
 *
 * @reamsid_L DBB-0930-010 yuanzhenxia
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GennendoIdoFukaProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private RDateTime 調定日時;
    private ChohyoResult 出力帳票一覧;
    private RString 特徴捕捉対象者の依頼金額計算;
    private RString 異動賦課で同時に計算する特徴捕捉分;
    private RString 処理対象;
    private RDateTime 抽出開始日時;
    private RDateTime 抽出終了日時;
}
