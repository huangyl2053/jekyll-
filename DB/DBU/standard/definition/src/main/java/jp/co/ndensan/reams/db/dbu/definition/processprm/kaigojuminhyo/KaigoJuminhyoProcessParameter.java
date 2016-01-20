/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojuminhyo;

import jp.co.ndensan.reams.db.dbu.definition.mybatis.param.kaigojuminhyo.KaigoJuminhyoMapperParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護住民票個別事項連携情報作成【他社住基】のバッチ処理クラスのパラメータです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KaigoJuminhyoProcessParameter implements IBatchProcessParameter {

    private RDateTime taishoKaishiTimestamp;
    private RDateTime taishoShuryoTimestamp;

    /**
     * コンストラクタ
     *
     * @param taishoKaishiTimestamp 対象開始日時
     * @param taishoShuryoTimestamp 対象終了日時
     */
    public KaigoJuminhyoProcessParameter(
            RDateTime taishoKaishiTimestamp,
            RDateTime taishoShuryoTimestamp
    ) {
        this.taishoKaishiTimestamp = taishoKaishiTimestamp;
        this.taishoShuryoTimestamp = taishoShuryoTimestamp;
    }

    /**
     * 介護住民票個別事項連携情報作成【他社住基】のバッチのパラメータを設定します。
     *
     * @return KaigoJuminhyoMapperParameter
     */
    public KaigoJuminhyoMapperParameter toKaigoJuminhyoMapperParameter() {
        return KaigoJuminhyoMapperParameter.createParam_common(taishoKaishiTimestamp, taishoShuryoTimestamp);
    }
}
