/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kaigojuminhyo;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import lombok.Getter;

/**
 * 介護住民票個別事項連携情報を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBU-0350-020 lijia
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class KaigoJuminhyoMapperParameter implements IMyBatisParameter {

    private final RDateTime taishoKaishiTimestamp;
    private final RDateTime taishoShuryoTimestamp;
    private final boolean checkKaishiFlag;
    private final boolean checkShuryoFlag;

    /**
     * コンストラクタです。
     *
     * @param taishoKaishiTimestamp 対象開始日時
     * @param taishoShuryoTimestamp 対象終了日時
     * @param checkKaishiFlag 対象開始フラグ
     * @param checkShuryoFlag 対象終了フラグ
     */
    private KaigoJuminhyoMapperParameter(
            RDateTime taishoKaishiTimestamp,
            RDateTime taishoShuryoTimestamp,
            boolean checkKaishiFlag,
            boolean checkShuryoFlag) {

        this.taishoKaishiTimestamp = taishoKaishiTimestamp;
        this.taishoShuryoTimestamp = taishoShuryoTimestamp;
        this.checkKaishiFlag = checkKaishiFlag;
        this.checkShuryoFlag = checkShuryoFlag;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param taishoKaishiTimestamp 対象開始日時
     * @param taishoShuryoTimestamp 対象終了日時
     * @return 対象日時範囲チェックの検索パラメータ
     */
    public static KaigoJuminhyoMapperParameter createParam_common(
            RDateTime taishoKaishiTimestamp,
            RDateTime taishoShuryoTimestamp) {
        boolean checkKaishiFlag = false;
        boolean checkShuryoFlag = false;
        if (taishoKaishiTimestamp == null) {
            checkShuryoFlag = true;
        } else {
            checkKaishiFlag = true;
        }
        return new KaigoJuminhyoMapperParameter(
                taishoKaishiTimestamp, taishoShuryoTimestamp, checkKaishiFlag, checkShuryoFlag);
    }
}
