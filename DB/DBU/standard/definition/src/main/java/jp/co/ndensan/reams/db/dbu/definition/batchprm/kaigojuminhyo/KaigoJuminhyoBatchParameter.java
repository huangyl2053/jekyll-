/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.kaigojuminhyo;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 介護住民票個別事項連携情報作成【他社住基】のバッチのパラメータ
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KaigoJuminhyoBatchParameter extends BatchParameterBase {

    /**
     * 対象開始年月日日時
     */
    private static final String KEY_TAISHOKAISHI_YMDHMS = "taishoKaishiYMDHMS";

    /**
     * 対象終了年月日日時
     */
    private static final String KEY_TAISHOSHURYO_YMDHMS = "taishoShuryoYMDHMS";

    @BatchParameter(key = KEY_TAISHOKAISHI_YMDHMS, name = "対象開始年月日日時")
    private YMDHMS taishoKaishiYMDHMS;
    @BatchParameter(key = KEY_TAISHOSHURYO_YMDHMS, name = "対象終了年月日日時")
    private YMDHMS taishoShuryoYMDHMS;

//    public KaigoJuminhyoMybatisParameter toSampleMybatisParameter() {
//        //return new KaigoJuminhyoMybatisParameter(KaigoJuminhyo.valueOf(KaigoJuminhyo));
//    }
}
