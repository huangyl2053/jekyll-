/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc170010;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7122SogoJigyoServiceCodeEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 送付済データのエンティティクラスです。
 *
 * @reamsid_L DBC-4740-030 zhaowei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServicecodeIdoRenrakuhyoSofuZumiDataEntity {

    private DbT7122SogoJigyoServiceCodeEntity 支援総合事業サービスコード;
    private RString 異動区分コード;
    private FlexibleDate 新規変更異動年月日;
    private FlexibleDate 終了異動年月日;
}
