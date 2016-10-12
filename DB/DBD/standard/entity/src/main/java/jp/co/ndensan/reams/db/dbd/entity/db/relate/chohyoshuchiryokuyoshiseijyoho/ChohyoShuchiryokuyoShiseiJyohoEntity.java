/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.chohyoshuchiryokuyoshiseijyoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力用申請情報Entityです。
 *
 * @reamsid_L DBD-1480-030 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
public class ChohyoShuchiryokuyoShiseiJyohoEntity {

    private RString 保険者名称;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private AtenaMeisho 被保険者氏名;
    private AtenaKanaMeisho 被保険者氏名カナ;
    private AtenaJusho 住所;
    private FlexibleDate 生年月日;
    private RString 性別;
    private Code 認定申請区分_申請時コード;
    private RString 被保険者区分コード;
    private FlexibleDate 認定申請年月日;
    private Code 前回要介護状態区分コード;
    private FlexibleDate 前回認定有効期間開始;
    private FlexibleDate 前回認定有効期間終了;
    private ShikibetsuCode 識別コード;
    private Code 申請届出代行区分コード;
    private RString 出力CSV状況申請;
    private int index;
    private RString 枝番;
}
