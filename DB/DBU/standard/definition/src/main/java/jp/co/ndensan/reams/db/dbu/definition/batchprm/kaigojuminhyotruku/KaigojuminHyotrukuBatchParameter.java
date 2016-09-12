/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.kaigojuminhyotruku;

import jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojuminhyotruku.KaigojuminHyotrukuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * バッチ設計_DBUMN81001_住民異動連携情報登録【他社住基用】クラスです。
 *
 * @reamsid_L DBA-1400-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KaigojuminHyotrukuBatchParameter extends BatchParameterBase {

    private static final String SHORITIMESTAMP = "shoriTimestamp";
    @BatchParameter(key = SHORITIMESTAMP, name = "処理日時")
    private RDateTime shoriTimestamp;

    /**
     * コンストラクタです。
     */
    public KaigojuminHyotrukuBatchParameter() {
    }

    /**
     * 介護住民票個別事項連携情報作成【他社住基】のバッチのパラメータを設定します。
     *
     * @return KaigojuminHyotrukuProcessParameter
     */
    public KaigojuminHyotrukuProcessParameter toKaigoJuminhyoProcessParameter() {
        return new KaigojuminHyotrukuProcessParameter(shoriTimestamp);
    }
}
