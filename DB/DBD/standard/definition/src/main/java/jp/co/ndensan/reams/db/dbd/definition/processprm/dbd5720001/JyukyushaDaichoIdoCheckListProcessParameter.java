/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5720001;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5720001.JyukyushaDaichoIdoCheckListMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者台帳異動チェックリストのProcess用パラメータクラスです。
 *
 * @reamsid_L DBD-1770-020 donghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JyukyushaDaichoIdoCheckListProcessParameter implements IBatchProcessParameter {

    private RDate 今回抽出開始年月日;
    private RTime 今回抽出開始時分秒;
    private RDate 今回抽出終了年月日;
    private RTime 今回抽出終了時分秒;
    private RString 出力対象;
    private Long 出力順ID;

    /**
     *
     * @param 今回抽出開始年月日 今回抽出開始年月日
     * @param 今回抽出開始時分秒 今回抽出開始時分秒
     * @param 今回抽出終了年月日 今回抽出終了年月日
     * @param 今回抽出終了時分秒 今回抽出終了時分秒
     * @param 出力対象 出力対象
     * @param 出力順ID 出力順ID
     */
    public JyukyushaDaichoIdoCheckListProcessParameter(RDate 今回抽出開始年月日, RTime 今回抽出開始時分秒,
            RDate 今回抽出終了年月日, RTime 今回抽出終了時分秒, RString 出力対象, Long 出力順ID) {
        this.今回抽出開始年月日 = 今回抽出開始年月日;
        this.今回抽出開始時分秒 = 今回抽出開始時分秒;
        this.今回抽出終了年月日 = 今回抽出終了年月日;
        this.今回抽出終了時分秒 = 今回抽出終了時分秒;
        this.出力対象 = 出力対象;
        this.出力順ID = 出力順ID;
    }

    /**
     * コンストラクタです。
     *
     * @param shikibetsuTaishoPSMSearchKey IShikibetsuTaishoPSMSearchKey
     * @param 行挿入日時開始 RDateTime
     * @param 行挿入日時終了 RDateTime
     * @param 出力順 RString
     * @return JyukyushaDaichoIdoCheckListMybatisParameter
     */
    public JyukyushaDaichoIdoCheckListMybatisParameter toJyukyushaDaichoIdoCheckListMybatisParameter(
            IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey,
            RDateTime 行挿入日時開始,
            RDateTime 行挿入日時終了,
            RString 出力順) {
        return new JyukyushaDaichoIdoCheckListMybatisParameter(今回抽出開始年月日, 行挿入日時開始, 今回抽出終了年月日,
                行挿入日時終了, 出力対象, 出力順, shikibetsuTaishoPSMSearchKey);
    }

}
