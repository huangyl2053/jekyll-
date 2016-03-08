/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 調査員の場合で認定調査スケジュール情報戻るのEntity。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaScheduleRelateEntity {

    private RString ninteiChosaItakusakiCode;
    private RString jigyoshaMeisho;
    private RString ninteiChosainCode;
    private RString chosainShimei;
    private FlexibleDate ninteiChosaYoteiYMD;
    private RString ninteiChosaYoteiKaishiTime;
    private RString ninteiChosaYoteiShuryoTime;
    private Code yoyakuJokyo;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private AtenaJusho jusho;
    private RString basho;
    private RString tachiainin1;
    private RString tachiainin2;
    private TelNo renrakusaki1;
    private TelNo renrakusaki2;
    private RString taishoshaMemo;
}
