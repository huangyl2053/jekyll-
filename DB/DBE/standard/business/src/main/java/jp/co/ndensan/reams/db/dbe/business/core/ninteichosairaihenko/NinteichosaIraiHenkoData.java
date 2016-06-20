/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosairaihenko;

import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査依頼先変更者のクラスです。
 *
 * @reamsid_L DBE-1390-120 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteichosaIraiHenkoData {

    private final RString 保険者番号;
    private final RString 被保険者番号;
    private final AtenaKanaMeisho 被保険者氏名カナ;
    private final AtenaMeisho 氏名;
    private final Code 性別;
    private final FlexibleDate 生年月日;
    private final Code 認定申請区分_申請時_コード;
    private final FlexibleDate 認定申請年月日;
    private final RString 保険者名;
    private final FlexibleDate 変更日;
    private final RString 変更前調査事業所;
    private final RString 変更前調査員;
    private final RString 変更後調査事業所;
    private final RString 変更後調査員;
    private final RString 変更回数;

    /**
     * コンストラクタです。
     *
     * @param 保険者番号 保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 被保険者氏名カナ 被保険者氏名カナ
     * @param 氏名 氏名
     * @param 性別 性別
     * @param 生年月日 生年月日
     * @param 認定申請区分_申請時_コード 認定申請区分_申請時_コード
     * @param 認定申請年月日 認定申請年月日
     * @param 保険者名 保険者名
     * @param 変更日 変更日
     * @param 変更前調査事業所 変更前調査事業所
     * @param 変更前調査員 変更前調査員
     * @param 変更後調査事業所 変更後調査事業所
     * @param 変更後調査員 変更後調査員
     * @param 変更回数 変更回数
     */
    public NinteichosaIraiHenkoData(RString 保険者番号,
            RString 被保険者番号,
            AtenaKanaMeisho 被保険者氏名カナ,
            AtenaMeisho 氏名,
            Code 性別,
            FlexibleDate 生年月日,
            Code 認定申請区分_申請時_コード,
            FlexibleDate 認定申請年月日,
            RString 保険者名,
            FlexibleDate 変更日,
            RString 変更前調査事業所,
            RString 変更前調査員,
            RString 変更後調査事業所,
            RString 変更後調査員,
            RString 変更回数) {
        this.保険者番号 = 保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.被保険者氏名カナ = 被保険者氏名カナ;
        this.氏名 = 氏名;
        this.性別 = 性別;
        this.生年月日 = 生年月日;
        this.認定申請区分_申請時_コード = 認定申請区分_申請時_コード;
        this.認定申請年月日 = 認定申請年月日;
        this.保険者名 = 保険者名;
        this.変更日 = 変更日;
        this.変更前調査事業所 = 変更前調査事業所;
        this.変更前調査員 = 変更前調査員;
        this.変更後調査事業所 = 変更後調査事業所;
        this.変更後調査員 = 変更後調査員;
        this.変更回数 = 変更回数;
    }
}
