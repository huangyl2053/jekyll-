/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.core.kyokaisogaitoshabatchparameter;

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
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KyokaisoKanriMasterListBatchParameter extends BatchParameterBase {

    public static final String KEY_mode = "mode";
    public static final String KEY_Range = "Range";
    public static final String KEY_Date_FROM = "Date_FROM";
    public static final String KEY_Date_TO = "Date_TO";
    public static final String KEY_iskyuufugakuGengakuKisaiKiajoFlag = "iskyuufugakuGengakuKisaiKiajoFlag";
    public static final String KEY_ishyojunFutanGengakuGaitoFlag = "ishyojunFutanGengakuGaitoFlag";
    public static final String KEY_iskyojuhinadoFutangakugengakuGaitoFlag = "iskyojuhinadoFutangakugengakuGaitoFlag";
    public static final String KEY_isshokuhiKeigengoHutangakuGaitoFlag = "isshokuhiKeigengoHutangakuGaitoFlag";
    public static final String KEY_iskogakuServicehiJogengakuGengakuGaitoFlag = "iskogakuServicehiJogengakuGengakuGaitoFlag ";
    public static final String KEY_ishokenryoNofuGengakuFlag = "ishokenryoNofuGengakuFlag";
    public static final String KEY_order_ID = "order_ID ";

    @BatchParameter(key = KEY_mode, name = "取得モード")
    private RString mode;
    @BatchParameter(key = KEY_Range, name = "境界層対象抽出範囲")
    private RString Range;
    @BatchParameter(key = KEY_Date_FROM, name = "日付FROM")
    private FlexibleDate Date_FROM;
    @BatchParameter(key = KEY_Date_TO, name = "日付TO")
    private FlexibleDate Date_TO;
    @BatchParameter(key = KEY_iskyuufugakuGengakuKisaiKiajoFlag, name = "給付額減額解除該当区分フラグ")
    private RString iskyuufugakuGengakuKisaiKiajoFlag;
    @BatchParameter(key = KEY_ishyojunFutanGengakuGaitoFlag, name = "標準負担額減額該当区分フラグ")
    private RString ishyojunFutanGengakuGaitoFlag;
    @BatchParameter(key = KEY_iskyojuhinadoFutangakugengakuGaitoFlag, name = "特定介護居住費等負担額減額該当区分フラグ")
    private RString iskyojuhinadoFutangakugengakuGaitoFlag;
    @BatchParameter(key = KEY_isshokuhiKeigengoHutangakuGaitoFlag, name = "特定介護食費負担額減額該当区分フラグ")
    private RString isshokuhiKeigengoHutangakuGaitoFlag;
    @BatchParameter(key = KEY_iskogakuServicehiJogengakuGengakuGaitoFlag, name = "高額サービス費該当区分フラグ")
    private RString iskogakuServicehiJogengakuGengakuGaitoFlag;
    @BatchParameter(key = KEY_ishokenryoNofuGengakuFlag, name = "納付減額該当区分フラグ")
    private RString hokenryoNofuGengakuFlag;
    @BatchParameter(key = KEY_order_ID, name = "出力順ID")
    private RString order_ID;

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public KyokaisoGaitoshaProcessParameter toKyokaisoGaitoshaProcessParameter() {
        return new KyokaisoGaitoshaProcessParameter(mode,
                Range,
                Date_FROM,
                Date_TO,
                iskogakuServicehiJogengakuGengakuGaitoFlag,
                ishyojunFutanGengakuGaitoFlag,
                iskyojuhinadoFutangakugengakuGaitoFlag,
                isshokuhiKeigengoHutangakuGaitoFlag,
                iskogakuServicehiJogengakuGengakuGaitoFlag,
                hokenryoNofuGengakuFlag,
                order_ID);
    }

}
