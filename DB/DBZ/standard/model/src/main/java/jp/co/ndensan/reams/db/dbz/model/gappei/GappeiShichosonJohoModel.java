/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.gappei;

import java.io.Serializable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbz.model.util.items.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;
import static java.util.Objects.requireNonNull;

/**
 * 合併市町村情報のモデルクラスです。
 *
 * @author N8156 宮本 康
 */
public class GappeiShichosonJohoModel implements Serializable, IGappeiShichosonJoho {

    private final IOptional<IGappeiJoho> 合併情報;
    private final IItemList<IGappeiShichoson> 合併市町村;

    /**
     * コンストラクタです。
     *
     * @param 合併情報 合併情報
     * @param 合併市町村 合併市町村
     * @throws NullPointerException 引数がNullの時
     */
    public GappeiShichosonJohoModel(IOptional<IGappeiJoho> 合併情報, IItemList<IGappeiShichoson> 合併市町村) throws NullPointerException {
        this.合併情報 = requireNonNull(合併情報, UrSystemErrorMessages.値がnull.getReplacedMessage("合併情報"));
        this.合併市町村 = requireNonNull(合併市町村, UrSystemErrorMessages.値がnull.getReplacedMessage("合併市町村"));
    }

    @Override
    public IOptional<IGappeiJoho> get合併情報() {
        return 合併情報;
    }

    @Override
    public IItemList<IGappeiShichoson> get合併市町村() {
        return 合併市町村;
    }
}
