/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.shutokujohochushutsurenkei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112003.SichousonEntity;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得情報抽出・連携（バッチ）のMybatisパラメータです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShutokuJohoChushutsuRenkeiMybatisParameter implements IMyBatisParameter {

    private final FlexibleYear 処理年度;
    private final List<SichousonEntity> 市町村情報List;
    private final RString 出力順ID;
    private final ReportId 帳票ID;
    private final RString 共有ファイル名;
    private final RString 共有ファイルID;
    private final RString 処理区分;
    private final YMDHMS 処理日時;
    private RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 処理年度 FlexibleYear
     * @param 市町村情報List List<SichousonEntity>
     * @param 出力順ID long
     * @param 帳票ID ReportId
     * @param 共有ファイル名 RString
     * @param 共有ファイルID RDateTime
     * @param 処理区分 RString
     * @param 処理日時 YMDHMS
     */
    public ShutokuJohoChushutsuRenkeiMybatisParameter(FlexibleYear 処理年度,
            List<SichousonEntity> 市町村情報List, RString 出力順ID, ReportId 帳票ID,
            RString 共有ファイル名, RString 共有ファイルID, RString 処理区分, YMDHMS 処理日時) {
        this.処理年度 = 処理年度;
        this.市町村情報List = 市町村情報List;
        this.出力順ID = 出力順ID;
        this.帳票ID = 帳票ID;
        this.共有ファイル名 = 共有ファイル名;
        this.共有ファイルID = 共有ファイルID;
        this.処理区分 = 処理区分;
        this.処理日時 = 処理日時;
    }

}
