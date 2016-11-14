/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.keikakutodokedejokyoichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 計画届出状況リストのデータを抽出するのエンティティクラスです。
 *
 * @reamsid_L DBC-1960-030 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KeikakuTodokedeJokyoIchiranEntity extends DbTableEntityBase<KeikakuTodokedeJokyoIchiranEntity> implements IDbAccessable {

    private HihokenshaNo 被保険者番号;
    private RString 履歴番号;
    private FlexibleDate 受給申請年月日;
    private Code 受給申請事由;
    private Code 要介護認定状態区分コード;
    private FlexibleDate 認定有効期間開始日;
    private FlexibleDate 認定有効期間終了日;
    private FlexibleDate 認定年月日;
    private ShikibetsuCode 識別コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格喪失年月日;
    private RString 資格喪失事由コード;
    private RString 住所地特例フラグ;
    private ShikibetsuCode 施設フラウ;
    private FlexibleDate 対象年月;
    private FlexibleDate 計画届出日;
    private FlexibleDate 適用開始年月日;
    private FlexibleDate 適用終了年月日;
    private JigyoshaNo 事業者番号;
    private RString 作成区分コード;
    private TelNo 電話番号;
    private FlexibleDate 変更年月日;
    private RString 事業者名称;
    private HihokenshaNo 居宅給付計画届出_被保険者番号;
    LasdecCode 市町村コード;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
}
