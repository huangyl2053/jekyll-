/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Value;

/**
 * 介護事業者指定サービスの識別子です。
 */
@Value
public class KaigoJigyoshaShiteiServiceIdentifier implements Serializable {

    private static final long serialVersionUID = 8977963032754423415L;

    private final KaigoJigyoshaNo 事業者番号;
    private final KaigoServiceShuruiCode サービス種類コード;
    private final FlexibleDate 有効開始日;

    /**
     * コンストラクタです。
     *
     * @param 事業者番号 事業者番号
     * @param サービス種類コード サービス種類コード
     * @param 有効開始日 有効開始日
     */
    public KaigoJigyoshaShiteiServiceIdentifier(KaigoJigyoshaNo 事業者番号,
            KaigoServiceShuruiCode サービス種類コード,
            FlexibleDate 有効開始日) {
        this.事業者番号 = 事業者番号;
        this.サービス種類コード = サービス種類コード;
        this.有効開始日 = 有効開始日;
    }
}
