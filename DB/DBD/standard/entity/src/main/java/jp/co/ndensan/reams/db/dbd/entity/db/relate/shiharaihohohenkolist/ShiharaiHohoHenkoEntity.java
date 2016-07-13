/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @reamsid_L DBD-3630-050 liangbc
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
    private int 申請中件数;
    private Code 整理番号;
    private RYearMonth 提供年月;
    private int 未通知件数;
    private ShiharaiHenkoTorokuKubun 滞納管理状況;
    private int 最長滞納期間;
    private Decimal 以前滞納額;
    private TainoKubun 以前滞納区分;
    private ShiharaiHenkoShuryoKubun 終了状況;
    private RDate _1行目適用開始日;
    private RDate _2行目適用終了日;
    private RDate _3行目終了受付日;
    private RDate _4行目予告発行日;
    private RDate _5行目弁明期限;
    private RDate _6行目弁明受付日;
    private RDate _7行目償還発行日;
    private RDate _8行目償還証期限;
    private int _9行目差止中件数;
    private Decimal _10行目差止中金額;
    private RDate _11行目差止納付期日;
    private int _12行目控除件数;
    private RDate _13行目控除証期限;
    private RString _14行目;
    private RString _15行目;
    private RString _16行目;
    private RString _17行目;
    private List<RString> 年度1のヘッダー;
    private List<Integer> 年度1の期別;
    private List<Decimal> 年度1の保険料金;
    private List<RDate> 年度1の納期限;
    private List<Decimal> 年度1の滞納額;
    private List<TainoKubun> 年度1の滞納区分;
    private List<RDate> 年度1の時効起算日;
    private List<RString> 年度1の時効起算事由;
    private List<RString> 年度2のヘッダー;
    private List<Integer> 年度2の期別;
    private List<Decimal> 年度2の保険料金;
    private List<RDate> 年度2の納期限;
    private List<Decimal> 年度2の滞納額;
    private List<TainoKubun> 年度2の滞納区分;
    private List<RDate> 年度2の時効起算日;
    private List<RString> 年度2の時効起算事由;
    private List<RString> 年度3のヘッダー;
    private List<Integer> 年度3の期別;
    private List<Decimal> 年度3の保険料金;
    private List<RDate> 年度3の納期限;
    private List<Decimal> 年度3の滞納額;
    private List<TainoKubun> 年度3の滞納区分;
    private List<RDate> 年度3の時効起算日;
    private List<RString> 年度3の時効起算事由;
    private Decimal 保険料額合計1;
    private Decimal 滞納額合計1;
    private Decimal 保険料額合計2;
    private Decimal 滞納額合計2;
    private Decimal 保険料額合計3;
    private Decimal 滞納額合計3;
    private int 収納情報なし;
    private RYear 日付関連_調定年度;
}
