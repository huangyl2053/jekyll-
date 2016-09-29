/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定審査判定依頼一覧表発行Entity。
 *
 * @reamsid_L DBD-1480-040 liuyl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PntNinteiShinsaHanteiListEntity {

    private RString 被保険者番号;
    private AtenaMeisho 被保険者氏名;
    private AtenaKanaMeisho 被保険者氏名カナ;
    private AtenaJusho 住所;
    private FlexibleDate 生年月日;
    private Code 性別;
    private Code 認定申請区分_申請時_コード;
    private RString 被保険者区分コード;
    private FlexibleDate 認定申請年月日;
    private Code 前回要介護状態区分コード;
    private FlexibleDate 前回認定有効期間_開始;
    private FlexibleDate 前回認定有効期間_終了;
}
