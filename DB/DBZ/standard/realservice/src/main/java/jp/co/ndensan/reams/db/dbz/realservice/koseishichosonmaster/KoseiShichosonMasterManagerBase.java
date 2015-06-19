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
 * 構成市町村マスタマネージャーのベースクラスです。
 *
 * @author n8223　朴義一
 */
public abstract class KoseiShichosonMasterManagerBase implements IKoseiShichosonMasterManager {

    /**
     * 構成市町村マスタ情報を取得します。
     *
     * @param 市町村識別ID 市町村識別ID
     * @return 構成市町村マスタ情報
     */
    @Override
    public abstract Optional<IKoseiShichosonMaster> find構成市町村(RString 市町村識別ID);

    /**
     * 構成市町村マスタ情報を登録します。
     *
     * @param 構成市町村情報 構成市町村情報
     * @return 登録件数
     */
    @Override
    public abstract int save構成市町村(IKoseiShichosonMaster 構成市町村情報);

}
