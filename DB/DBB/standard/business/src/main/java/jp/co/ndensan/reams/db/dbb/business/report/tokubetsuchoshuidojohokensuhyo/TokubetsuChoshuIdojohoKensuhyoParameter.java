/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohokensuhyo;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshuidojohokensuhyo.TokuChoYidoKensuEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBBPR82001_4_特別徴収異動情報件数表Parameter
 *
 * @reamsid_L DBB-1840-090 lihang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuIdojohoKensuhyoParameter {

    private TokuChoYidoKensuEntity 特徴異動件数Entity;
    private YMDHMS 作成日時;
    private FlexibleYear 賦課年度;
    private RString 処理対象月;
    private RString 該当件数の件数の合計;
    private RString 資格喪失の件数の合計;
    private RString 仮徴収額変更の件数の合計;
    private RString 住所地特例の件数の合計;
    private RString 特徴追加依頼の件数の合計;

}
