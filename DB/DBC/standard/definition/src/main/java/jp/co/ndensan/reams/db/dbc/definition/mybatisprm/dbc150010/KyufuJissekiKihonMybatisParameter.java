/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * 利用状況統計表（明細リスト）作成_給付実績基本データ取得のMyBatisParameterのクラスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KyufuJissekiKihonMybatisParameter implements IMyBatisParameter {

    private FlexibleYearMonth 開始年月;
    private FlexibleYearMonth 終了年月;
    private HihokenshaNo 被保険者番号;
    private JigyoshaNo 事業者番号;
    private boolean has被保険者番号;
    private boolean has事業者番号;
    private boolean isサービス提供年月;
    private boolean is審査年月;

    /**
     * ンストラクタです。
     *
     * @param 開始年月 開始年月
     * @param 終了年月 終了年月
     * @param 被保険者番号 被保険者番号
     * @param 事業者番号 事業者番号
     * @param is被保険者番号 被保険者番号が存在かどうか
     * @param isサービス提供年月 isサービス提供年月
     * @param is審査年月 is審査年月
     * @param is事業者番号 事業者番号が存在かどうか
     */
    public KyufuJissekiKihonMybatisParameter(FlexibleYearMonth 開始年月, FlexibleYearMonth 終了年月, HihokenshaNo 被保険者番号,
            JigyoshaNo 事業者番号, boolean is被保険者番号, boolean is事業者番号, boolean isサービス提供年月, boolean is審査年月) {
        this.開始年月 = 開始年月;
        this.終了年月 = 終了年月;
        this.被保険者番号 = 被保険者番号;
        this.事業者番号 = 事業者番号;
        this.has被保険者番号 = is被保険者番号;
        this.has事業者番号 = is事業者番号;
        this.isサービス提供年月 = isサービス提供年月;
        this.is審査年月 = is審査年月;
    }
}
