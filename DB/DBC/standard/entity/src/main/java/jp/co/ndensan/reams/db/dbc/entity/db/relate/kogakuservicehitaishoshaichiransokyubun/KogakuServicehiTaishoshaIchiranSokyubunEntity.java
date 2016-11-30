/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehitaishoshaichiransokyubun;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票設計_DBCMN41003_高額介護サービス費対象者一覧表（遡及分）のEntityクラスです。
 *
 * @reamsid_L DBC-5750-040 kanghongsong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServicehiTaishoshaIchiranSokyubunEntity {

    private RDateTime システムの時間;
    private RString 市町村コード;
    private RString 市町村名;
    private RString 並び順1;
    private RString 並び順2;
    private RString 並び順3;
    private RString 並び順4;
    private RString 並び順5;
    private RString 改頁1;
    private RString 改頁2;
    private RString 改頁3;
    private RString 改頁4;
    private RString 改頁5;
    private ShikibetsuCode 識別コード;
    private RString 連番;
    private RString 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 被保険者名;
    private RString 世帯コード;
    private Decimal 利用者負担額;
    private Decimal 支給_予定_金額;
    private RString 備考;
    private RString マスタの状況;
    private RString 郵便番号;
    private RString 町域コード;
    private RString 行政区コード;
    private RString カナ名称;
    private RString 証記載保険者番号;
    private RString 要介護認定状態区分コード;
    private RString 保険者名;
}
