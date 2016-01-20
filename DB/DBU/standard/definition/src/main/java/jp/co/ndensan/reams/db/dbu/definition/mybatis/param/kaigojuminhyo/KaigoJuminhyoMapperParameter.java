/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatis.param.kaigojuminhyo;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import lombok.Getter;

/**
 * 介護住民票個別事項連携情報を特定するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class KaigoJuminhyoMapperParameter implements IMyBatisParameter {

    private RDateTime taishoKaishiTimestamp;
    private RDateTime taishoShuryoTimestamp;

    /**
     * コンストラクタです。
     *
     * @param taishoKaishiTimestamp 対象開始日時
     * @param taishoShuryoTimestamp 対象終了日時
     */
    private KaigoJuminhyoMapperParameter(
            RDateTime taishoKaishiTimestamp,
            RDateTime taishoShuryoTimestamp) {

        this.taishoKaishiTimestamp = taishoKaishiTimestamp;
        this.taishoShuryoTimestamp = taishoShuryoTimestamp;
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
        return new KaigoJuminhyoMapperParameter(taishoKaishiTimestamp, taishoShuryoTimestamp);
    }
}
