/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kogakuservicehijuryoininkeiyakukakuninsho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費受領委任契約承認（不承認）確認書 のParameterです。
 *
 * @reamsid_L DBC-1980-030 yuqingzhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServiceHiJuryoininKeiyakuKakuninshoParameter {

    private ShikibetsuCode 識別コード;
    private RString 被保険者氏名フリガナ;
    private RString 被保険者氏名;
    private HihokenshaNo 被保険者番号;
    private FlexibleDate 申請日;
    private FlexibleDate 受付日;
    private FlexibleDate 決定日;
    private FlexibleDate 承認開始日;
    private FlexibleDate 承認終了日;
    private RString 事業者番号;
    private RString 決定区分;
    private RString 承認しない理由;
    private RString 利用者負担上限額;
    private FlexibleDate 通知日;
    private RString 文書番号;

}
