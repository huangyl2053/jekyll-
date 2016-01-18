/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.kyokaisogaitosha;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyokaisogaitosha.KyokaisoGaitoshaMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 境界層管理マスタリストのバッチ処理クラスのパラメータ
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyokaisoGaitoshaProcessParameter implements IBatchProcessParameter {

    private final RString mode;
    private final RString range;
    private final FlexibleDate date_FROM;
    private final FlexibleDate date_TO;
    private final RString iskyuufugakuFlag;
    private final RString ishyojunFutanFlag;
    private final RString iskyojuhinadoFutangFlag;
    private final RString isshokuhiKeiFlag;
    private final RString iskogakuFlag;
    private final RString ishokenFlag;
    private final RString order_ID;
    private RString psmShikibetsuTaisho;

    /**
     * コンストラクタ。
     *
     * @param mode 取得モード
     * @param range　境界層対象抽出範囲
     * @param date_FROM　日付FROM
     * @param date_TO　日付TO
     * @param iskyuufugakuFlag 給付額減額解除該当区分フラグ
     * @param ishyojunFutanFlag　標準負担額減額該当区分フラグ
     * @param iskyojuhinadoFutangFlag 特定介護居住費等負担額減額該当区分フラグ
     * @param isshokuhiKeiFlag 特定介護食費負担額減額該当区分フラグ
     * @param iskogakuFlag 高額サービス費該当区分フラグ
     * @param ishokenFlag　納付減額該当区分フラグ
     * @param order_ID 出力順ID
     *
     */
    public KyokaisoGaitoshaProcessParameter(RString mode,
            RString range,
            FlexibleDate date_FROM,
            FlexibleDate date_TO,
            RString iskyuufugakuFlag,
            RString ishyojunFutanFlag,
            RString iskyojuhinadoFutangFlag,
            RString isshokuhiKeiFlag,
            RString iskogakuFlag,
            RString ishokenFlag,
            RString order_ID) {
        this.date_TO = date_TO;
        this.date_FROM = date_FROM;
        this.iskyuufugakuFlag = iskyuufugakuFlag;
        this.range = range;
        this.ishyojunFutanFlag = ishyojunFutanFlag;
        this.iskyojuhinadoFutangFlag = iskyojuhinadoFutangFlag;
        this.isshokuhiKeiFlag = isshokuhiKeiFlag;
        this.iskogakuFlag = iskogakuFlag;
        this.mode = mode;
        this.order_ID = order_ID;
        this.ishokenFlag = ishokenFlag;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public KyokaisoGaitoshaMybatisParameter toKyokaisoGaitoshaMybatisParameter() {
        return new KyokaisoGaitoshaMybatisParameter(mode,
                range,
                date_FROM,
                date_TO,
                iskyuufugakuFlag,
                ishyojunFutanFlag,
                iskyojuhinadoFutangFlag,
                isshokuhiKeiFlag,
                iskogakuFlag,
                ishokenFlag,
                order_ID,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                psmShikibetsuTaisho);
    }
}
