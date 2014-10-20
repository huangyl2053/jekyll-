/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.gappei;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.koiki.IKoikiKoseiShichoson;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import static java.util.Objects.requireNonNull;

/**
 * 広域合併市町村情報のモデルクラスです。
 *
 * @author N8156 宮本 康
 */
public class KoikiGappeiShichosonJohoModel implements Serializable, IKoikiGappeiShichosonJoho {

    private final IGappeiJoho 合併情報;
    private final List<IKoikiKoseiShichoson> 構成市町村;

    /**
     * コンストラクタです。
     *
     * @param 合併情報 合併情報
     * @param 構成市町村 構成市町村
     * @throws NullPointerException 引数がNullの時
     */
    public KoikiGappeiShichosonJohoModel(IGappeiJoho 合併情報, List<IKoikiKoseiShichoson> 構成市町村) throws NullPointerException {
        this.合併情報 = requireNonNull(合併情報, UrSystemErrorMessages.値がnull.getReplacedMessage("合併情報"));
        this.構成市町村 = requireNonNull(構成市町村, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村"));
    }

    @Override
    public IGappeiJoho get合併情報() {
        return 合併情報;
    }

    @Override
    public List<IKoikiKoseiShichoson> get構成市町村() {
        return 構成市町村;
    }
}
