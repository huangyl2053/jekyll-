/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.kyokaisogaitoshabatchparameter;

import jp.co.ndensan.reams.db.dbu.definition.processprm.kyokaisogaitosha.KyokaisoGaitoshaProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 境界層管理マスタリスト_バッチパラメータ作成クラスです。
 *
 * @reamsid_L DBU-1050-020 wanghui
 */
@Getter
@Setter
public class KyokaisoKanriMasterListBatchParameter extends BatchParameterBase {

    private static final String KEY_MODE = "mode";
    private static final String KEY_RANGE = "range";
    private static final String KEY_DATE_FROM = "date_FROM";
    private static final String KEY_DATE_TO = "date_TO";
    private static final String KEY_ISKYUUFUGAKUFLAG = "iskyuufugakuFlag";
    private static final String KEY_ISHHYOJUNFUTFLA = "ishyojunFutanFlag";
    private static final String KEY_ISKYOJUHINADOFLAG = "iskyojuhinadoFutangFlag";
    private static final String KWY_ISSHOKUHIKEIFLAN = "isshokuhiKeiFlag";
    private static final String KEY_ISKOGAKUFLAG = "iskogakuFlag";
    private static final String KEY_ISHOKENFLAG = "ishokenFlag";
    private static final String KEY_ORDER_ID = "order_ID";
    @BatchParameter(key = KEY_MODE, name = "取得モード")
    private RString mode;
    @BatchParameter(key = KEY_RANGE, name = "境界層対象抽出範囲")
    private RString range;
    @BatchParameter(key = KEY_DATE_FROM, name = "日付FROM")
    private FlexibleDate date_FROM;
    @BatchParameter(key = KEY_DATE_TO, name = "日付TO")
    private FlexibleDate date_TO;
    @BatchParameter(key = KEY_ISKYUUFUGAKUFLAG, name = "給付額減額解除該当区分フラグ")
    private RString iskyuufugakuFlag;
    @BatchParameter(key = KEY_ISHHYOJUNFUTFLA, name = "標準負担額減額該当区分フラグ")
    private RString ishyojunFutanFlag;
    @BatchParameter(key = KEY_ISKYOJUHINADOFLAG, name = "特定介護居住費等負担額減額該当区分フラグ")
    private RString iskyojuhinadoFutangFlag;
    @BatchParameter(key = KWY_ISSHOKUHIKEIFLAN, name = "特定介護食費負担額減額該当区分フラグ")
    private RString isshokuhiKeiFlag;
    @BatchParameter(key = KEY_ISKOGAKUFLAG, name = "高額サービス費該当区分フラグ")
    private RString iskogakuFlag;
    @BatchParameter(key = KEY_ISHOKENFLAG, name = "納付減額該当区分フラグ")
    private RString ishokenFlag;
    @BatchParameter(key = KEY_ORDER_ID, name = "出力順ID")
    private RString order_ID;

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public KyokaisoGaitoshaProcessParameter toKyokaisoGaitoshaProcessParameter() {
        return new KyokaisoGaitoshaProcessParameter(
                this.mode,
                this.range,
                this.date_FROM,
                this.date_TO,
                this.iskyuufugakuFlag,
                this.ishyojunFutanFlag,
                this.iskyojuhinadoFutangFlag,
                this.isshokuhiKeiFlag,
                this.iskogakuFlag,
                this.ishokenFlag,
                this.order_ID);
    }
}
