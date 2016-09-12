/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kijunshunyugakutekiyokettei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 基準収入額決定通知書発行のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-4610-030 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SpoolKijunShunyugakuTekiyoKetteiProcessParameter implements IBatchProcessParameter {

    private RString 抽出期間;
    private FlexibleDate 開始日;
    private FlexibleDate 終了日;
    private RString 印書;
    private RString 帳票出力順ID;
    private FlexibleDate 作成日;
    private RString 文書番号;
    private LasdecCode 市町村コード;
    private RString 市町村名;

}
