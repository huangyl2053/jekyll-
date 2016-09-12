/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年度内の被保険者台帳の抽出
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaDaichoEntity {

    private HihokenshaNo 被保険者番号;
    private FlexibleDate 異動日;
    private RString 枝番;
    private RString 異動事由コード;
    private LasdecCode 市町村コード;
    private ShikibetsuCode 識別コード;
    private RString 資格取得事由コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格取得届出年月日;
    private FlexibleDate 第１号資格取得年月日;
    private RString 被保険者区分コード;
    private RString 資格喪失事由コード;
    private FlexibleDate 資格喪失年月日;
    private FlexibleDate 資格喪失届出年月日;
    private RString 住所地特例適用事由コード;
    private FlexibleDate 適用年月日;
    private FlexibleDate 適用届出年月日;
    private RString 住所地特例解除事由コード;
    private FlexibleDate 解除年月日;
    private FlexibleDate 解除届出年月日;
    private boolean 住所地特例フラグ;
    private boolean 広域内住所地特例フラグ;
    private RString 広住特措置元市町村コード;
    private FlexibleDate 賦課基準年月日;
}
