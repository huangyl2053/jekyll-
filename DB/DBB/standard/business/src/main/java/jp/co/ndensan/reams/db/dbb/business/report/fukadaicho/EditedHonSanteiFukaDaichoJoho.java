/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.fukadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 編集後本算定賦課台帳情報
 *
 * @reamsid_L DBB-9100-030 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class EditedHonSanteiFukaDaichoJoho {

    private RString 口座名義人;
    private RString 金融機関名;
    private RString 金融機関番号;
    private RString 口座NO;
    private RString 口座種類;
    private RString 調定事由1;
    private RString 調定事由2;
    private RString 調定事由3;
    private RString 調定事由4;
    private RString 調定年度;
    private RString 代納人住所;
    private RString 代納人名称;
    private RString 代納人名称カナ;
    private RString 代納人連絡先１;
    private RString 代納人連絡先２;
    private RString 代納人郵便NO;
    private RString 賦課年度;
    private RString 変更事由1;
    private RString 変更事由2;
    private RString 変更事由3;
    private RString 変更事由4;
    private HihokenshaNo 被保険者番号;
    private RString 保険者名称;
    private LasdecCode 保険者番号;
    private RString 本人生年月日;
    private RString 本人住所;
    private RString 本人名称;
    private RString 本人名称カナ;
    private RString 本人連絡先１;
    private RString 本人連絡先２;
    private RString 本人性別;
    private RString 本人所得段階変更;
    private RString 本人特徴義務者;
    private RString 本人特徴対象年金;
    private RString 本人郵便番号;
    private RString 表示コード１;
    private RString 表示コード２;
    private RString 表示コード３;
    private RString 表示コード名称１;
    private RString 表示コード名称２;
    private RString 表示コード名称３;
    private RString 受給情報;
    private RString 課税区分;
    private FutsuChoshuKi 普徴期;
    private FutsuChoshuTsuki 普徴月;
    private FutsuChoshuZuiji 普徴随時;
    private HonSanteifukaUchiwakeIchi 本算定賦課内訳１更正前;
    private HonSanteifukaUchiwakeIchi 本算定賦課内訳１更正後;
    private HonSanteifukaUchiwakeIchi 本算定賦課内訳１増減額;
    private HonSanteifukaUchiwakeNi 本算定賦課内訳２更正前年額保険料;
    private HonSanteifukaUchiwakeNi 本算定賦課内訳２更正前所得段階;
    private HonSanteifukaUchiwakeNi 本算定賦課内訳２更正後年額保険料;
    private HonSanteifukaUchiwakeNi 本算定賦課内訳２更正後所得段階;
    private FutsuChoshu 普通徴収更正前;
    private FutsuChoshu 普通徴収更正後;
    private FutsuChoshu 普通徴収増減額;
    private FutsuChoshu 普通徴収収入額;
    private Honnin 本人更正前;
    private Honnin 本人更正後;
    private List<SetaInJoho> 世帯員情報リスト;
    private TokubetsuChoshu 特別徴収更正前;
    private TokubetsuChoshu 特別徴収更正後;
    private TokubetsuChoshu 特別徴収増減額;
    private TokubetsuChoshu 特別徴収収入額;
    private TokubetsuChoshuKi 特徴期;
    private TokubetsuChoshuTsuki 特徴月;
    private RString 印刷日時;
    private RString 世帯コード;
    private RString タイトル;
    private RString 通知書NO;
    private GennenKanen 年度区分;
}
