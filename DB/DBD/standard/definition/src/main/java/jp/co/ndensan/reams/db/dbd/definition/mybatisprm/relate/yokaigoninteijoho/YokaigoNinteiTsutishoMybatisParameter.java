/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.yokaigoninteijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定通知書発行情報のパラメータ
 *
 * @reamsid_L DBE-1430-010 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class YokaigoNinteiTsutishoMybatisParameter implements IMyBatisParameter {

    private RString 申請書管理番号;
    private ShoKisaiHokenshaNo 保険者番号;
    private RString 被保険者番号;
    private ShikibetsuCode 識別コード;
    private List<RString> 性別コードリスト;
    private FlexibleDate 生年月日;
    private RString 氏名;
    private FlexibleDate 申請開始日;
    private FlexibleDate 申請終了日;
    private FlexibleDate 認定開始日;
    private FlexibleDate 認定終了日;
    private int 最大表示件数;
    private RString 出力順;
    private RString 要介護認定状態区分コード;
    private FlexibleDate 認定年月日;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
}
