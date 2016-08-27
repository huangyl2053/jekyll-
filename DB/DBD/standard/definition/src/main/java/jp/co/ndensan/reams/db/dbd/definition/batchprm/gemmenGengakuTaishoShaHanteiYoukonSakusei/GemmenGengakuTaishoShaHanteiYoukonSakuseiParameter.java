/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmenGengakuTaishoShaHanteiYoukonSakusei;

import jp.co.ndensan.reams.db.dbd.definition.processprm.hanteiyoukonsakusei.GemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * DBDBTZ0001_減免減額対象者判定用根拠作成バッチパラメタークラス処理クラスです。
 *
 * @reamsid_L DBD-3710-090 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GemmenGengakuTaishoShaHanteiYoukonSakuseiParameter extends BatchParameterBase {

    @BatchParameter(key = "所得年度", name = "所得年度")
    private FlexibleYear 所得年度;

    /**
     * コンストラクタです。
     *
     * @param 所得年度 FlexibleYear
     */
    public GemmenGengakuTaishoShaHanteiYoukonSakuseiParameter(FlexibleYear 所得年度) {
        this.所得年度 = 所得年度;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public GemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter toGemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter() {
        return new GemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter(所得年度);
    }

    /**
     * processのパラメータを生成します。
     *
     * @param 所得年度 FlexibleYear
     * @return processパラメータ
     */
    public GemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter toGemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter(FlexibleYear 所得年度) {
        return new GemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter(所得年度);
    }
}
