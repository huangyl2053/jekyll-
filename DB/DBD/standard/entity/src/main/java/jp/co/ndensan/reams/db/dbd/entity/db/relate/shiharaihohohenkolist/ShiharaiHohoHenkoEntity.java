package jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.common.TainoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法変更管理リストのEntityです。
 *
 * @reamsid_L DBD-3630-050 xuyue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoEntity {

    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private RString 被保険者氏名カナ;
    private RString 被保険者氏名;
    private Code 世帯番号;
    private Code 行政区ｺｰﾄﾞ;
    private RString 行政区;
    private Code 住所コード;
    private YubinNo 郵便番号;
    private RString 住所;

    private RDate 資格取得日;
    private RDate 資格喪失日;
    private ShikakuSoshitsuJiyu 喪失事由;
    private ShikakuKubun 資格区分;
    private int 住特フラグ;
    private RString 生保;

    private RString 要介護度;
    private RString 認定有効期間;
    private RDate 認定日;
    private RString 認定情報_申請中;
    private RDate 申請日;

    private RString 償還未払い情報_申請中;
    private RDate 償還未払い情報_申請日;
    private RString 申請中件数;
    private Code 整理番号;
    private RYearMonth 提供年月;
    private RString 未通知件数;

    private ShiharaiHenkoTorokuKubun 滞納管理状況;
    private RString 最長滞納期間;
    private Decimal 以前滞納額;
    private TainoKubun 以前滞納区分;
    private ShiharaiHenkoShuryoKubun 終了状況;

    private RDate 適用開始日_1行目;
    private RDate 適用終了日_2行目;
    private RDate 終了受付日_3行目;
    private RDate 予告発行日_4行目;
    private RDate 弁明期限_5行目;
    private RDate 弁明受付日_6行目;
    private RDate 償還発行日_7行目;
    private RDate 償還証期限_8行目;
    private RString 差止中件数_9行目;
    private Decimal 差止中金額_10行目;
    private RDate 差止納付期日_11行目;
    private RString 控除件数_12行目;
    private RDate 控除証期限_13行目;
    private RString 行14;
    private RString 行15;
    private RString 行16;
    private RString 行17;

    private List<ShunoNendoEntity> 収納情報List;
    private RString 収納情報なし;

    private RYear 日付関連_調定年度;
}
