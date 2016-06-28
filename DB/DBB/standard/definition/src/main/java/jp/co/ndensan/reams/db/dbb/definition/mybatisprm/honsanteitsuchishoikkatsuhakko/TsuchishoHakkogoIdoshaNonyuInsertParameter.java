/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納入通知書発行後異動者登録する用パラメータクラスです。
 *
 * @reamsid_L DBB-0780-060 xicongwang
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TsuchishoHakkogoIdoshaNonyuInsertParameter {

    private final int 出力期;
    private final RString 口座区分;
    private final RString 処理対象;
    private final RString 通知書プリント条件;
    private final RString 出力順;
    private final YMDHMS 帳票作成日時;
    private final ReportId 帳票ID;

    /**
     * コンストラクタです。
     *
     * @param 出力期 int
     * @param 口座区分 RString
     * @param 処理対象 RString
     * @param 通知書プリント条件 RString
     * @param 出力順 RString
     * @param 帳票作成日時 YMDHMS
     * @param 帳票ID ReportId
     */
    private TsuchishoHakkogoIdoshaNonyuInsertParameter(
            int 出力期,
            RString 口座区分,
            RString 処理対象,
            RString 通知書プリント条件,
            RString 出力順,
            YMDHMS 帳票作成日時,
            ReportId 帳票ID) {
        this.出力期 = 出力期;
        this.口座区分 = 口座区分;
        this.処理対象 = 処理対象;
        this.通知書プリント条件 = 通知書プリント条件;
        this.出力順 = 出力順;
        this.帳票作成日時 = 帳票作成日時;
        this.帳票ID = 帳票ID;
    }

    /**
     * パラメータメソッドです。
     *
     * @param 出力期 int
     * @param 口座区分 RString
     * @param 処理対象 RString
     * @param 通知書プリント条件 RString
     * @param 出力順 RString
     * @param 帳票作成日時 YMDHMS
     * @param 帳票ID ReportId
     * @return パラメータ
     */
    public static TsuchishoHakkogoIdoshaNonyuInsertParameter createSelectByKeyParam(
            int 出力期,
            RString 口座区分,
            RString 処理対象,
            RString 通知書プリント条件,
            RString 出力順,
            YMDHMS 帳票作成日時,
            ReportId 帳票ID) {
        return new TsuchishoHakkogoIdoshaNonyuInsertParameter(出力期, 口座区分, 処理対象, 通知書プリント条件, 出力順, 帳票作成日時, 帳票ID);
    }
}
