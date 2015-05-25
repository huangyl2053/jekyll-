/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbz.business.koseishichosonmaster.IKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成市町村マスタ情報を取得するクラスです。
 *
 * @author n8223　朴義一
 */
public abstract class KoseiShichosonMasterManagerBase implements IKoseiShichosonMasterManager {

    /**
     * 構成市町村マスタ情報を取得します。
     *
     * @param 市町村識別ID
     * @return 構成市町村マスタ情報
     */
    public abstract Optional<IKoseiShichosonMaster> find構成市町村(RString 市町村識別ID);

}
