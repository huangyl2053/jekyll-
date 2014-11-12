/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HokenshaKoseiKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShinKyuHokenshaNoHenkanKubun;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiJoho;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichoson;
import jp.co.ndensan.reams.db.dbz.model.koiki.IKoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.model.util.items.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import static java.util.Objects.requireNonNull;

/**
 * 合併市町村情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class GappeiShichosonJoho {

    private final IOptional<IGappeiJoho> 合併情報;
    private final HokenshaKoseiKubun 保険者構成区分;
    private final IItemList<IGappeiShichoson> 合併市町村;
    private final IItemList<IKoikiKoseiShichoson> 構成市町村;
    private final ShinKyuHokenshaNoHenkanKubun 新旧保険者番号変換区分;

    /**
     * コンストラクタです。
     *
     * @param 合併情報 合併情報
     * @param 保険者構成区分 保険者構成区分
     * @param 合併市町村 合併市町村
     * @param 構成市町村 構成市町村
     * @param 新旧保険者番号変換区分 新旧保険者番号変換区分
     * @throws NullPointerException 引数がNullの時
     */
    public GappeiShichosonJoho(
            IOptional<IGappeiJoho> 合併情報,
            HokenshaKoseiKubun 保険者構成区分,
            IItemList<IGappeiShichoson> 合併市町村,
            IItemList<IKoikiKoseiShichoson> 構成市町村,
            ShinKyuHokenshaNoHenkanKubun 新旧保険者番号変換区分) throws NullPointerException {
        this.合併情報 = requireNonNull(合併情報, UrSystemErrorMessages.値がnull.getReplacedMessage("合併情報"));
        this.保険者構成区分 = 保険者構成区分;
        this.合併市町村 = requireNonNull(合併市町村, UrSystemErrorMessages.値がnull.getReplacedMessage("合併市町村"));
        this.構成市町村 = requireNonNull(構成市町村, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村"));
        this.新旧保険者番号変換区分 = 新旧保険者番号変換区分;
    }

    /**
     * コンストラクタです。
     *
     * @param 合併情報 合併情報
     * @param 保険者構成区分 保険者構成区分
     * @param 合併市町村 合併市町村
     * @param 構成市町村 構成市町村
     */
    public GappeiShichosonJoho(
            IOptional<IGappeiJoho> 合併情報,
            HokenshaKoseiKubun 保険者構成区分,
            IItemList<IGappeiShichoson> 合併市町村,
            IItemList<IKoikiKoseiShichoson> 構成市町村) throws NullPointerException {
        this(合併情報, 保険者構成区分, 合併市町村, 構成市町村, ShinKyuHokenshaNoHenkanKubun.UNKNOWN);
    }

    public IOptional<IGappeiJoho> get合併情報() {
        return 合併情報;
    }

    public HokenshaKoseiKubun get保険者構成区分() {
        return 保険者構成区分;
    }

    public IItemList<IGappeiShichoson> get合併市町村() {
        return 合併市町村;
    }

    public IItemList<IKoikiKoseiShichoson> get構成市町村() {
        return 構成市町村;
    }

    public ShinKyuHokenshaNoHenkanKubun get新旧保険者番号変換区分() {
        return 新旧保険者番号変換区分;
    }
}
