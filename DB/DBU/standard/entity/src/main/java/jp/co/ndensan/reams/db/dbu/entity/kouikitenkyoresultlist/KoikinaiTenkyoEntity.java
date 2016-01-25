/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.kouikitenkyoresultlist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author GC xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikinaiTenkyoEntity {

    private HihokenshaNo 被保険者番号;
    private AtenaKanaMeisho 氏名カナ;
    private AtenaMeisho 氏名;
    private ShikibetsuCode 旧住民コード;
    private RString 前住所;
    private FlexibleDate 転出予定日;
    private FlexibleDate 転出確定日;
    private FlexibleDate 転出確定通知日;
    private FlexibleDate 処理日;
    private ShikibetsuCode 新住民コード;
    private RString 現住所;
    private FlexibleDate 登録異動日;
    private FlexibleDate 登録届出日;
    private RString 異動情報;
    private FlexibleDate 印刷日時;

}
