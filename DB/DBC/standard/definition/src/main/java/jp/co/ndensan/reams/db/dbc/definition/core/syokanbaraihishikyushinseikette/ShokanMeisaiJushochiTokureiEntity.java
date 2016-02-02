/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費明細（住特）登録更新処理MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanMeisaiJushochiTokureiEntity {

    private final RString 連番;
    private final ServiceShuruiCode サービス種類コード;
    private final ServiceKomokuCode サービス項目コード;
    private final Decimal 単位;
    private final Decimal 回数日数;
    private final int サービス単位;
    private final ShoKisaiHokenshaNo 施設所在保険者番号;
    private final RString 摘要;
    private final RString 状態;

    /**
     * コンストラクタです。
     *
     *
     * @param 連番
     * @param サービス種類コード
     * @param サービス項目コード
     * @param 単位
     * @param 回数日数
     * @param サービス単位
     * @param 施設所在保険者番号
     * @param 摘要
     * @param 状態
     */
    public ShokanMeisaiJushochiTokureiEntity(RString 連番, ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード,
            Decimal 単位, Decimal 回数日数, int サービス単位, ShoKisaiHokenshaNo 施設所在保険者番号,
            RString 摘要, RString 状態) {
        this.連番 = 連番;
        this.サービス種類コード = サービス種類コード;
        this.サービス項目コード = サービス項目コード;
        this.単位 = 単位;
        this.回数日数 = 回数日数;
        this.サービス単位 = サービス単位;
        this.施設所在保険者番号 = 施設所在保険者番号;
        this.摘要 = 摘要;
        this.状態 = 状態;
    }

    /**
     * コンストラクタです。
     *
     * @param 連番
     * @param サービス種類コード
     * @param サービス項目コード
     * @param 単位
     * @param 回数日数
     * @param サービス単位
     * @param 施設所在保険者番号
     * @param 摘要
     * @param 状態
     * @return
     */
    public static ShokanMeisaiJushochiTokureiEntity createSelectByKeyParam(RString 連番,
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード, Decimal 単位, Decimal 回数日数, int サービス単位,
            ShoKisaiHokenshaNo 施設所在保険者番号, RString 摘要, RString 状態) {
        return new ShokanMeisaiJushochiTokureiEntity(連番, サービス種類コード, サービス項目コード, 単位,
                回数日数, サービス単位, 施設所在保険者番号, 摘要, 状態);
    }
}
