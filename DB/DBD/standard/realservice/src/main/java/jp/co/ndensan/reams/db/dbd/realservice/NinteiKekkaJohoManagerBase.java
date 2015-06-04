/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.INinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;

/**
 * 要介護認定結果情報のベースクラスです。
 *
 * @author n8223 朴義一
 */
public abstract class NinteiKekkaJohoManagerBase implements INinteiKekkaJohoManager {

    @Override
    public abstract Optional<INinteiKekkaJoho> find要介護認定結果情報(ShinseishoKanriNo 申請書管理番号);

}
