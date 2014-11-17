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
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
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
    private final IItemList<IGappeiShichoson> 単一市町村情報;
    private final IItemList<IKoikiKoseiShichoson> 広域市町村情報;
    private final ShinKyuHokenshaNoHenkanKubun 新旧保険者番号変換区分;

    /**
     * コンストラクタです。
     *
     * @param 合併情報 合併情報
     * @param 保険者構成区分 保険者構成区分
     * @param 単一市町村情報 単一市町村情報
     * @param 広域市町村情報 広域市町村情報
     * @param 新旧保険者番号変換区分 新旧保険者番号変換区分
     * @throws NullPointerException 引数がNullの時
     */
    public GappeiShichosonJoho(
            IOptional<IGappeiJoho> 合併情報,
            HokenshaKoseiKubun 保険者構成区分,
            IItemList<IGappeiShichoson> 単一市町村情報,
            IItemList<IKoikiKoseiShichoson> 広域市町村情報,
            ShinKyuHokenshaNoHenkanKubun 新旧保険者番号変換区分) throws NullPointerException {
        this.合併情報 = requireNonNull(合併情報, UrSystemErrorMessages.値がnull.getReplacedMessage("合併情報"));
        this.保険者構成区分 = 保険者構成区分;
        this.単一市町村情報 = requireNonNull(単一市町村情報, UrSystemErrorMessages.値がnull.getReplacedMessage("単一市町村情報"));
        this.広域市町村情報 = requireNonNull(広域市町村情報, UrSystemErrorMessages.値がnull.getReplacedMessage("広域市町村情報"));
        this.新旧保険者番号変換区分 = 新旧保険者番号変換区分;
    }

    /**
     * コンストラクタです。
     *
     * @param 合併情報 合併情報
     * @param 保険者構成区分 保険者構成区分
     * @param 単一市町村情報 単一市町村情報
     * @param 広域市町村情報 広域市町村情報
     */
    public GappeiShichosonJoho(
            IOptional<IGappeiJoho> 合併情報,
            HokenshaKoseiKubun 保険者構成区分,
            IItemList<IGappeiShichoson> 単一市町村情報,
            IItemList<IKoikiKoseiShichoson> 広域市町村情報) {
        this(合併情報, 保険者構成区分, 単一市町村情報, 広域市町村情報, ShinKyuHokenshaNoHenkanKubun.UNKNOWN);
    }

    /**
     * 合併情報を返します。
     *
     * @return 合併情報
     */
    public IOptional<IGappeiJoho> get合併情報() {
        return 合併情報;
    }

    /**
     * 保険者構成区分を返します。
     *
     * @return 保険者構成区分
     */
    public HokenshaKoseiKubun get保険者構成区分() {
        return 保険者構成区分;
    }

    /**
     * 単一市町村情報を返します。
     *
     * @return 単一市町村情報
     */
    public IItemList<IGappeiShichoson> get単一市町村情報() {
        return 単一市町村情報;
    }

    /**
     * 広域市町村情報を返します。
     *
     * @return 広域市町村情報
     */
    public IItemList<IKoikiKoseiShichoson> get広域市町村情報() {
        return 広域市町村情報;
    }

    /**
     * 新旧保険者番号変換区分を返します。
     *
     * @return 新旧保険者番号変換区分
     */
    public ShinKyuHokenshaNoHenkanKubun get新旧保険者番号変換区分() {
        return 新旧保険者番号変換区分;
    }
}
