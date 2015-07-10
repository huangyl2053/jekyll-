/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbz.business.koseishichosonmaster.IKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成市町村マスタマネージャーのインターフェースです。
 *
 * @author n8223　朴義一
 */
public interface IKoseiShichosonMasterManager {

    /**
     * 構成市町村マスタ情報を取得します。
     *
     * @param 市町村識別ID 市町村識別ID
     * @return 構成市町村マスタ情報
     */
    Optional<IKoseiShichosonMaster> find構成市町村(RString 市町村識別ID);

    /**
     * 構成市町村マスタ情報を取得します。
     *
     * @return 構成市町村マスタ情報
     */
    IItemList<IKoseiShichosonMaster> findAll構成市町村();

    /**
     * 証記載保険者番号を市町村コードへ読み替える構成市町村マスタ情報を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 構成市町村マスタ情報
     */
    Optional<IKoseiShichosonMaster> find構成市町村by証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号);

    /**
     * 市町村コードを証記載保険者番号へ読み替える構成市町村マスタ情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return 構成市町村マスタ情報
     */
    Optional<IKoseiShichosonMaster> find構成市町村by市町村コード(LasdecCode 市町村コード);

    /**
     * 構成市町村マスタ情報を登録します。
     *
     * @param 構成市町村情報
     * @return 登録件数
     */
    int save構成市町村(IKoseiShichosonMaster 構成市町村情報);

}
