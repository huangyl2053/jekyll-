/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額サービス費決定情報一時TBL
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuKetteiInTempTableEntity implements Serializable {

    private RString 交換情報識別番号;
    private RString 帳票レコード種別ヘッダ;
    private HokenshaNo 証記載保険者番号;
    private RString 保険者名;
    private FlexibleDate 作成年月日;
    private RString 国保連合会名;
    private RString 帳票レコード種別;
    private int no;
    private HihokenshaNo 被保険者番号;
    private AtenaMeisho 被保険者氏名漢字;
    private FlexibleYearMonth サービス提供年月;
    private Decimal 利用者負担額;
    private RString 支給区分コード;
    private FlexibleYearMonth 決定年月;
    private Decimal 高額支給額;
    private RString 支払方法区分コード;
    private RString 支払場所;
    private FlexibleDate 開始年月日;
    private FlexibleDate 終了年月日;
    private RString 開始曜日;
    private RString 終了曜日;
    private RString 開始時間;
    private RString 終了時間;
    private KinyuKikanCode 金融機関コード;
    private RString 金融機関名;
    private KinyuKikanShitenCode 金融機関支店コード;
    private RString 金融機関支店名;
    private RString 口座種目;
    private RString 口座種目名;
    private RString 口座番号;
    private AtenaKanaMeisho 口座名義人カナ;
    private ShikibetsuCode 識別コード;
    private RString 資格喪失事由;
    private FlexibleDate 資格喪失年月日;
    private RString 全国住所コード;
    private YubinNo 郵便番号;
    private AtenaJusho 住所;
    private GyoseikuCode 行政区コード;
    private RString 行政区;
    private AtenaKanaMeisho 氏名カナ;
    private AtenaMeisho 氏名;

}
