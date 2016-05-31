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
public class NinteichosaIraiHenkoData {

    private RString 保険者番号;
    private RString 被保険者番号;
    private AtenaKanaMeisho 被保険者氏名カナ;
    private AtenaMeisho 氏名;
    private Code 性別;
    private FlexibleDate 生年月日;
    private Code 認定申請区分_申請時_コード;
    private FlexibleDate 認定申請年月日;
    private RString 保険者名;
    private FlexibleDate 変更日;
    private RString 変更前調査事業所;
    private RString 変更前調査員;
    private RString 変更後調査事業所;
    private RString 変更後調査員;
    private RString 変更回数;

}
