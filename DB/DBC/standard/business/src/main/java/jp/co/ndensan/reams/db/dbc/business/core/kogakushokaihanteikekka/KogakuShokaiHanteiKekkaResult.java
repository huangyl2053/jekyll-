/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakushokaihanteikekka;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * ビジネス設計_DBCMN11004_世帯合算並列表示（画面）のResultEntityです。
 *
 * @reamsid_L DBC-3000-050 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuShokaiHanteiKekkaResult {

    private RString 世帯集約番号;
    private RString 高額給付根拠;
    private FlexibleDate 受付年月日;
    private FlexibleDate 決定年月日;
    private RString 審査方法区分;
    private Decimal 本人支払額;
    private RString 支給区分コード;
    private Decimal 支給金額;
    private RString 不支給理由;
    private boolean 自動償還対象フラグ;
    private List<ShikyuMeisaiResult> 支給明細list;
}
