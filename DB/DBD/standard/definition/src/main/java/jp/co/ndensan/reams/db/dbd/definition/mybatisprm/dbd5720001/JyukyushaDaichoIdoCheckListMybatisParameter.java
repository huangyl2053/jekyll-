/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5720001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 受給者台帳異動チェックリスト(バッチ)SQLのパラメータクラス
 *
 * @reamsid_L DBD-1770-020 donghj
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JyukyushaDaichoIdoCheckListMybatisParameter implements IMyBatisParameter {

    private final RDate 今回抽出開始年月日;
    private final RTime 今回抽出開始時分秒;
    private final RDate 今回抽出終了年月日;
    private final RTime 今回抽出終了時分秒;
    private final RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 今回抽出開始年月日 今回抽出開始年月日
     * @param 今回抽出開始時分秒 今回抽出開始時分秒
     * @param 今回抽出終了年月日 今回抽出終了年月日
     * @param 今回抽出終了時分秒 今回抽出終了時分秒
     * @param 出力順 出力順
     */
    public JyukyushaDaichoIdoCheckListMybatisParameter(RDate 今回抽出開始年月日, RTime 今回抽出開始時分秒,
            RDate 今回抽出終了年月日, RTime 今回抽出終了時分秒, RString 出力順) {
        this.今回抽出開始年月日 = 今回抽出開始年月日;
        this.今回抽出開始時分秒 = 今回抽出開始時分秒;
        this.今回抽出終了年月日 = 今回抽出終了年月日;
        this.今回抽出終了時分秒 = 今回抽出終了時分秒;
        this.出力順 = 出力順;

    }

}
