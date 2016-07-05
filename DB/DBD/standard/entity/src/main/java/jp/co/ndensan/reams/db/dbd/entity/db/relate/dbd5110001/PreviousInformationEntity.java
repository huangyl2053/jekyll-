/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5110001;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 更新未申請者把握リストの前回の情報を取得するEntityクラスです。
 *
 * @reamsid_L DBD-1420-020 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PreviousInformationEntity {

    private RString 厚労省IF識別コード;
    private FlexibleDate 認定申請年月日;
    private RString 認定申請区分_申請時_コード;
    private RString 認定調査委託先コード;
    private RString 入所施設コード;
    private RString 認定調査委託先情報_事業者名称;
    private FlexibleDate 二次判定年月日;
    private RString 二次判定認定有効期間;
    private FlexibleDate 二次判定認定有効開始年月日;
    private FlexibleDate 二次判定認定有効終了年月日;
    private RString 二次判定要介護状態区分コード;
    private RString 介護事業者_事業者名称;

}
