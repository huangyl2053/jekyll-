/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.chohyoshuchiryokuyoshiseijyoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
    private RString 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private RString 被保険者氏名;
    private RString 被保険者氏名カナ;
    private RString 住所;
    private FlexibleDate 生年月日;
    private RString 性別;
    private RString 認定申請区分_申請時コード;
    private RString 被保険者区分コード;
    private FlexibleDate 認定申請年月日;
    private RString 前回要介護状態区分コード;
    private FlexibleDate 前回認定有効期間開始;
    private FlexibleDate 前回認定有効期間終了;
    private RString 出力CSV状況申請;
}
