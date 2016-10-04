/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD206010;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事業所向け社会福祉法人軽減対象者一覧発行のバッチパラメタークラスです。
 *
 * @reamsid_L DBD-3810-030 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD206010_JigyoshoMukeShakaFukushiHojinKeigenTaishoshaIchiranHakkoParameter extends BatchParameterBase {

    private static final String KIJUNRI = "kijinhi";
    private static final String SHIKAKUSSIUSSENTAKU = "shikakussiusSentaku";
    private static final String JIGYOSHASENTAKU = "jigyoshaSentaku";
    private static final String JIGYOSHANO = "jigyoshaNo";
    private static final String JIGYOSHANAME = "jigyoshaName";
    private static final String OUTPUTJUNNID = "outputJunnId";
    private static final String SHORIDATETIME = "shoriDateTime";
    @BatchParameter(key = KIJUNRI, name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = SHIKAKUSSIUSSENTAKU, name = "資格喪失者選択")
    private RString 資格喪失者選択;
    @BatchParameter(key = JIGYOSHASENTAKU, name = "事業者選択")
    private RString 事業者選択;
    @BatchParameter(key = JIGYOSHANO, name = "事業者番号")
    private RString 事業者番号;
    @BatchParameter(key = JIGYOSHANAME, name = "事業者名")
    private RString 事業者名;
    @BatchParameter(key = OUTPUTJUNNID, name = "出力順ID")
    private Long 出力順ID;
    @BatchParameter(key = SHORIDATETIME, name = "処理日時")
    private YMDHMS 処理日時;

}
