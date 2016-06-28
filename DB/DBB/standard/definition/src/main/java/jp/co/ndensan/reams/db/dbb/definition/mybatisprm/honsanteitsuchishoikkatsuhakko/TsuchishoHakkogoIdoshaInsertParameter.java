/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 通知書発行後異動者登録する用パラメータクラスです。
 *
 * @reamsid_L DBB-0780-060 xicongwang
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TsuchishoHakkogoIdoshaInsertParameter implements IMyBatisParameter {

    private final RString 区分;
    private final YMDHMS 帳票作成日時;
    private final RString 出力順;
    private final ReportId 帳票ID;

    /**
     * コンストラクタです。
     *
     * @param 区分 RString
     * @param 帳票作成日時 YMDHMS
     * @param 出力順 RString
     * @param 帳票ID ReportId
     */
    private TsuchishoHakkogoIdoshaInsertParameter(
            RString 区分,
            YMDHMS 帳票作成日時,
            RString 出力順,
            ReportId 帳票ID) {
        this.区分 = 区分;
        this.帳票作成日時 = 帳票作成日時;
        this.出力順 = 出力順;
        this.帳票ID = 帳票ID;
    }

    /**
     * コンストラクタです。
     *
     * @param 区分 RString
     * @param 帳票作成日時 YMDHMS
     * @param 出力順 RString
     * @param 帳票ID ReportId
     * @return パラメータ
     */
    public static TsuchishoHakkogoIdoshaInsertParameter createSelectByKeyParam(
            RString 区分,
            YMDHMS 帳票作成日時,
            RString 出力順,
            ReportId 帳票ID) {
        return new TsuchishoHakkogoIdoshaInsertParameter(区分, 帳票作成日時, 出力順, 帳票ID);
    }
}
