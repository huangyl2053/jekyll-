/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendofuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.processprm.kanendoidofuka.KanendoIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT45001_本算定異動（過年度）パラメータクラスです。
 *
 * @reamsid_L DBB-0910-010 gongliang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class HonSanteiIdoFukaBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_調定年度 = "調定年度";
    private static final String KEY_処理対象 = "処理対象";
    private static final String KEY_抽出開始日時 = "抽出開始日時";
    private static final String KEY_抽出終了日時 = "抽出終了日時";
    private static final String KEY_LIST_出力帳票 = "出力帳票List";

    @BatchParameter(key = KEY_調定年度, name = "調定年度")
    private FlexibleYear 調定年度;
    @BatchParameter(key = KEY_処理対象, name = "処理対象")
    private RString 処理対象;
    @BatchParameter(key = KEY_抽出開始日時, name = "抽出開始日時")
    private RDateTime 抽出開始日時;
    @BatchParameter(key = KEY_抽出終了日時, name = "抽出終了日時")
    private RDateTime 抽出終了日時;
    @BatchParameter(key = KEY_LIST_出力帳票, name = "List<出力帳票List>")
    private List<ChohyoResult> 出力帳票List;

    /**
     * 本算定異動（過年度）のProcessParameterのメソッドです。
     *
     * @param システム日時 YMDHMS
     * @return 本算定異動（過年度）のMybatisParameter
     */
    public KanendoIdoFukaProcessParameter toKanendoIdoFukaProcessParameter(YMDHMS システム日時) {
        RString 出力順ID;
        if (出力帳票List != null && !出力帳票List.isEmpty()) {
            出力順ID = 出力帳票List.get(0).get出力順ID();
        } else {
            出力順ID = RString.EMPTY;
        }
        RString 日付関連_年度サイクル = DbBusinessConfig.get(ConfigNameDBB.日付関連_年度サイクル, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        return new KanendoIdoFukaProcessParameter(日付関連_年度サイクル, 調定年度, 処理対象, 抽出開始日時, 抽出終了日時, 出力順ID, システム日時);
    }

}
