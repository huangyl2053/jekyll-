/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoifupdate;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定IF更新のRelateEntityクラスです。
 *
 * @reamsid_L DBE-3000-310 jinjue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoifUpdateRelateEntity {

    private List<DbT4003YokaigoNinteiInterfaceEntity> 情報Entity;
    private FlexibleDate 認定申請年月日;
    private RString 被保険者番号;
    private Code 厚労省IF識別コード;
    private FlexibleDate 認定調査依頼年月日;
    private FlexibleDate 認定調査実施年月日;
    private FlexibleDate 主治医意見書作成依頼年月日;
    private FlexibleDate 主治医意見書受領年月日;
    private FlexibleDate 介護認定審査会資料作成年月日;
    private FlexibleDate 二次判定年月日;
    private Code 要介護認定一次判定結果コード;
    private FlexibleDate 要介護認定一次判定年月日;
    private Code 要介護認定一次判定結果コード_認知症加算;
    private Code 二次判定要介護状態区分コード;
    private FlexibleDate 二次判定認定有効開始年月日;
    private FlexibleDate 二次判定認定有効終了年月日;
    private Code 二号特定疾病コード;
    private ChosaItakusakiCode 認定調査委託先コード;
    private ChosainCode 認定調査員コード;
    private RString 主治医医療機関コード;
    private RString 主治医コード;
    private RString 介護認定審査会意見;
    private int 合議体番号;
    private Code 認定申請区分_法令_コード;
    private Code 認知症高齢者の日常生活自立度の蓋然性評価コード;
    private Code 認知症高齢者の日常生活自立度コード;
    private Code 障害高齢者の日常生活自立度コード;
    private FlexibleDate 認定審査会予定年月日;
    private Code 認定申請区分_申請時コード;
}
