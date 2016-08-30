/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufuhikagomositatetouroku;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3059KagoMoshitateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護給付費過誤申立登録（事業分、経過措置分含む）のEntityクラスです。
 *
 * @reamsid_L DBC-2220-030 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoKyufuhiKagoMositateTourokuEntity {

    private RString 事業所番号;
    private RString 被保険者番号;
    private RString 様式番号;
    private RString サービス提供年月;
    private RString 審査年月;
    private RString 給付実績作成区分コード;
    private RString 給付区分;
    private RString 証記載保険者番号;
    private RString 行番号;
    private RString 氏名;
    private RString 事業者名;
    private DbT3059KagoMoshitateEntity dbT3059;
}
