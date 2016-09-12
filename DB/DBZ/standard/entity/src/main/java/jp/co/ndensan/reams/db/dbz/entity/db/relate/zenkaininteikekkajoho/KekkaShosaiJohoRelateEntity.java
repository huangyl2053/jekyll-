/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.zenkaininteikekkajoho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 結果詳細情報ダイアログを表示する時に引数のクラスです。
 *
 * @reamsid_L DBE-3000-020 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KekkaShosaiJohoRelateEntity {

    private RString 取下区分コード;
    private FlexibleDate 認定申請年月日;
    private RString 厚労省IF識別コード;
    private RString 二次判定要介護状態区分コード;
    private FlexibleDate 二次判定認定有効開始年月日;
    private FlexibleDate 二次判定認定有効終了年月日;
    private RString 介護認定審査会意見;
    private RString 直近異動事由コード;
    private RString 削除事由コード;
    private RString 認定申請理由;
    private FlexibleDate 喪失年月日;
    private FlexibleDate 取下年月日;
    private FlexibleDate 当初認定有効開始年月日;
    private FlexibleDate 当初認定有効終了年月日;
    private FlexibleDate 受給資格証明書発行年月日１;
    private FlexibleDate 受給資格証明書発行年月日２;
    private RString 認定申請区分_申請時_コード;
    private RString 認定申請区分_法令_コード;
}
