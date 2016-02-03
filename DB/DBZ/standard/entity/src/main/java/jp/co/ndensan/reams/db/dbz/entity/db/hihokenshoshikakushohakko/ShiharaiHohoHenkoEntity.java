/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 支払方法変更Entityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoEntity {

    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString 管理区分;
    private RString 履歴番号;
    private RString 登録区分;
    private FlexibleDate 適用開始年月日;
    private FlexibleDate 適用終了年月日;

}
