/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.gemmenGengakuTaishoShaHanteiYoukonSakusei;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenGengakuTaishoShaHanteiYoukonSakusei.GemmenGengakuTaishoShaHanteiYoukonSakuseiMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DBDBTZ0001_減免減額対象者判定用根拠作成_process処理のパラメタークラスです。
 *
 * @reamsid_L DBD-3710-090 liuwei2
 */
@lombok.Getter
@lombok.Setter
public class GemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 所得年度;
    private Decimal number;

    /**
     * コンストラクタです。
     *
     */
    public GemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter() {
        this.number = new Decimal(new RString("800000").toString());
    }

    /**
     * コンストラクタです。
     *
     */
    public GemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter(FlexibleYear 所得年度) {
        this.所得年度 = 所得年度;
        this.number = new Decimal(new RString("800000").toString());
    }

    /**
     * MyBatisのパラメータを生成します。
     *
     * @return MyBatisパラメータ
     */
    public GemmenGengakuTaishoShaHanteiYoukonSakuseiMyBatisParameter GemmenGengakuTaishoShaHanteiYoukonSakuseiMyBatisParameter() {
        return new GemmenGengakuTaishoShaHanteiYoukonSakuseiMyBatisParameter(所得年度);
    }
}
