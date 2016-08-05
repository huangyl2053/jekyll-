/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.seigoseichekkurisutosakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 整合性チェックリストRelateEntityクラスです。
 *
 * @reamsid_L DBA-5800-030 zhangzhiming
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeigoseiChekkuRisutoEntity {

    private RString 取得事由コード;
    private FlexibleDate 比較適用年月日;
    private FlexibleDate 比較解除年月日;
    private ShikibetsuCode 宛名識別コード;
    private boolean 対象外フラグ;
    private RString 不整合理由コード;
    private RString 登録日時;
    private int 履歴番号;
    private FlexibleDate 異動年月日;
    private FlexibleDate 届出年月日;
    private RString 異動事由コード;
    private FlexibleDate 処理年月日;
    private RString 住民種別コード;
    private RString 住民状態コード;
    private FlexibleDate 生年月日;
    private RString 登録事由コード;
    private FlexibleDate 登録異動年月日;
    private FlexibleDate 登録届出年月日;
    private RString 消除事由コード;
    private FlexibleDate 消除異動年月日;
    private FlexibleDate 消除届出年月日;
    private FlexibleDate 転出予定異動年月日;
    private FlexibleDate 転出確定異動年月日;
    private FlexibleDate 転出確定通知年月日;
    private RString 台帳種別;
    private FlexibleDate 資格異動日;
    private RString 資格異動枝番;
    private RString 資格異動事由コード;
    private HihokenshaNo 被保険者番号;
    private LasdecCode 市町村コード;
    private RString 取得適用事由コード;
    private FlexibleDate 取得適用年月日;
    private FlexibleDate 取得適用届出年月日;
    private RString 喪失解除事由コード;
    private FlexibleDate 喪失解除年月日;
    private FlexibleDate 喪失解除届出年月日;
    private FlexibleDate 第1号取得年月日;
    private RString 被保険者区分コード;
    private RString 資格変更事由コード;
    private FlexibleDate 資格変更年月日;
    private FlexibleDate 資格変更届出年月日;
    private RString 住特適用事由コード;
    private FlexibleDate 住特適用年月日;
    private FlexibleDate 住特適用届出年月日;
    private RString 住特解除事由コード;
    private FlexibleDate 住特解除年月日;
    private FlexibleDate 住特解除届出年月日;
    private ShikibetsuCode 除外識別コード;
    private RString 処理事由コード;
    private boolean 消除通知フラグ;
    private ShikibetsuCode 台帳識別コード;

}
