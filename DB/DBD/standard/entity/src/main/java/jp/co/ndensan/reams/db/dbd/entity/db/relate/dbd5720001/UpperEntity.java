/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
public class UpperEntity {

    private LasdecCode 保険者番号;
    private RString 保険者名称;
    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private AtenaJusho 住所;
    private AtenaKanaMeisho フリガナ;
    private FlexibleDate 生年月日;
    private RString 異動区分;
    private RString 処理種別;
    private FlexibleDate 受給申請日;
    private FlexibleDate 認定日;
    private FlexibleDate 認定有効開始日;
    private FlexibleDate 喪失年月日;
    private RString 異動事由;
    private RString 有効無効;

}
