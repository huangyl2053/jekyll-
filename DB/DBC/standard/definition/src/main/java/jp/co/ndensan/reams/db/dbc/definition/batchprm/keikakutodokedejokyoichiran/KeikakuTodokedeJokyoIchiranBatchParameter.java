/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.definition.batchprm.keikakutodokedejokyoichiran;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 *画面設計_DBC0140011_計画届出情報リストのパラメータクラスです。
 *
 * @reamsid_L DBC-1960-010 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KeikakuTodokedeJokyoIchiranBatchParameter extends BatchParameterBase {
     
    private static final String KEY_受給申請日From = "受給申請日From";
    private static final String KEY_受給申請日To = "受給申請日To";
    private static final String KEY_対象者抽出 = "対象者抽出";
    private static final String KEY_届出状況 = "届出状況";
    private static final String KEY_基準日 = "基準日";
    private static final String KEY_出力順ID = "出力順ID";
   // private static final String KEY_宛名検索条件 = "宛名検索条件";
    
    
    @BatchParameter(key = KEY_受給申請日From, name ="受給申請日From")
    private YMDHMS 受給申請日From;
    @BatchParameter(key = KEY_受給申請日To, name = "受給申請日To")
    private YMDHMS 受給申請日To;
    @BatchParameter(key = KEY_対象者抽出, name = "KEY_対象者抽出")
    private RString 対象者抽出;
    @BatchParameter(key = KEY_届出状況, name = "届出状況")
    private RString 届出状況;
    @BatchParameter(key = KEY_基準日, name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = KEY_出力順ID, name = "出力順ID")
    private RString 出力順ID;
//     @BatchParameter(key =KEY_宛名検索条件, name = "宛名検索条件")
//    private IShikibetsuTaishoPSMSearchKey 宛名検索条件;
      /**
     * toProcessParameter
     *
     * @return KeikakuTodokedeJokyoIchiranProcessParameter
     */
//    public KeikakuTodokedeJokyoIchiranProcessParameter toProcessParameter() {
//        return new KeikakuTodokedeJokyoIchiranProcessParameter(受給申請日From, 受給申請日To, 対象者抽出,届出状況,
//                基準日,出力順ID,宛名検索条件 );
//         }
    
}
