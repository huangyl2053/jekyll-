/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.koiki;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.koiki.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.model.hokensha.IHokensha;

/**
 * 広域構成市町村です。
 *
 * @author N3327 三浦 凌
 */
public interface IKoikiKoseiShichoson extends IHokensha {

    /**
     *
     * @return
     */
    ShichosonShikibetsuID get市町村識別ID();

    /**
     *
     * @return
     */
    ShichosonCode get市町村コード();
}
