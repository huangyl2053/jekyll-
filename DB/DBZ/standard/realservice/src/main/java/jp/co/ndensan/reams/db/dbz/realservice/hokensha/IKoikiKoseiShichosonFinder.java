/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hokensha;

import jp.co.ndensan.reams.db.dbz.business.hokensha.IKoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ContainsKyuShichoson;
import jp.co.ndensan.reams.db.dbz.business.hokensha.KoikiKoseiShichosons;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 広域構成市町村に関する情報を取得できます。
 *
 * @author N3327 三浦 凌
 */
public interface IKoikiKoseiShichosonFinder {

    /**
     * 旧市町村を含むか、含まないかを指定して、広域構成市町村を返します。
     *
     * @param contains旧市町村 contains合併旧市町村
     * @return 広域構成市町村(旧市町村を含む)
     */
    KoikiKoseiShichosons load広域構成市町村(ContainsKyuShichoson contains旧市町村);

    /**
     * 指定の市町村コードに該当する{@link IKoikiKoseiShichoson 広域構成市町村情報}を返します。
     *
     * @param 市町村コード 市町村コード
     * @param contains旧市町村 contains合併旧市町村
     * @return 広域構成市町村(旧市町村を含む)
     */
    IOptional<IKoikiKoseiShichoson> find構成市町村(LasdecCode 市町村コード, ContainsKyuShichoson contains旧市町村);
}
