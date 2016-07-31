/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 賦課の情報-資格の情報ペアのクラスです。
 *
 * @reamsid_L DBB-0660-030 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaShikakuPair implements Serializable {

    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private NendobunFukaList 年度分賦課リスト;
    private HihokenshaDaicho 資格の情報;
}
