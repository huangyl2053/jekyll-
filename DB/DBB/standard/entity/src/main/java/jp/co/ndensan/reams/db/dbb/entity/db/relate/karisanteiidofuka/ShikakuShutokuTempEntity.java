/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得TempEntityです
 *
 * @reamsid_L DBB-0850-020 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuShutokuTempEntity {

    private HihokenshaNo 被保険者番号;
    private FlexibleDate 異動日;
    private RString 枝番;
    private RString 異動事由コード;
    private LasdecCode 市町村コード;
    private ShikibetsuCode 識別コード;
    private RString 資格取得事由コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格取得届出年月日;
    private FlexibleDate 第1号資格取得年月日;
    private RString 被保険者区分コード;
    private RString 資格喪失事由コード;
    private FlexibleDate 資格喪失年月日;
    private FlexibleDate 資格喪失届出年月日;
    private RString 資格変更事由コード;
    private FlexibleDate 資格変更年月日;
    private FlexibleDate 資格変更届出年月日;
    private RString 住所地特例適用事由コード;
    private FlexibleDate 適用年月日;
    private FlexibleDate 適用届出年月日;
    private RString 住所地特例解除事由コード;
    private FlexibleDate 解除年月日;
    private FlexibleDate 解除届出年月日;
    private RString 住所地特例フラグ;
    private RString 広域内住所地特例フラグ;
    private LasdecCode 広住特措置元市町村コード;
    private LasdecCode 旧市町村コード;
    private boolean 論理削除フラグ;
    private TsuchishoNo 通知書番号;
    private FlexibleDate 賦課期日;
    private FlexibleYear 所得年度;
}
