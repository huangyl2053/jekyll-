/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_受給者台帳異動チェックリストを取得するEntityクラスです。
 *
 * @reamsid_L DBD-1770-020 donghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JyukyushaDaichoIdoCheckListEntity {

    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private Code 厚労省IF識別コード;
    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private FlexibleDate 受給申請年月日;
    private FlexibleDate 認定年月日;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private FlexibleDate 喪失年月日;
    private Code データ区分;
    private Code 有効無効区分;
    private Code 受給申請事由;
    private Code 直近異動事由コード;
    private boolean 旧措置者フラグ;
    private Code 要介護認定状態区分コード;
    private boolean 削除フラグ;
    private int update回数;
    private FlexibleDate 生年月日;
    private AtenaMeisho 名称;
    private AtenaKanaMeisho カナ名称;
    private RString 性別コード;
    private int 年齢;
    private RString 管内管外区分;
    private ChoikiCode 町域コード;
    private ZenkokuJushoCode 全国住所コード;
    private AtenaJusho 住所;
    private GyoseikuCode 行政区コード;
    private RString 行政区名;
    private ShinseishoKanriNo 申請書管理番号;

}
