/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.koiki;

import jp.co.ndensan.reams.db.dbz.model.koiki.IKoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 広域構成市町村の情報を取得するクラスです。<br/>
 * （※別チケットで対応）
 *
 * @author N8156 宮本 康
 */
public class KoikiKoseiShichosonFinder implements IKoikiKoseiShichosonFinder {

    public KoikiKoseiShichosonFinder() {
    }

    @Override
    public IItemList<IKoikiKoseiShichoson> find構成市町村(ISearchCondition searchCondition) {
        return null;
    }

    @Override
    public Optional<IKoikiKoseiShichoson> get最古構成市町村(LasdecCode 市町村コード) {
        return null;
    }
}
