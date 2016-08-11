/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100201;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 非課税年金対象者情報取込バッチパラメタークラスです．
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HikazeiNennkinTaishouSyaJohoTorikomiBatchParameter extends BatchParameterBase {

    private FlexibleYear 処理年度;
    private RString 処理区分;
    private RString 対象月;
    private RString テスト処理;
    private RString 出力区分;
    private RString 処理状態;
    private List<RString> 構成市町村コードリスト;
    private FlexibleDate 処理年月日;
    private RTime 処理日時;
    private Long 出力順ID1;
    private Long 出力順ID2;
    private Long 出力順ID3;
    private Long 出力順ID4;
}
