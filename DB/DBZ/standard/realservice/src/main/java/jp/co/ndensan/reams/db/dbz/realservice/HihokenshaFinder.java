/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.Hihokensha;
import jp.co.ndensan.reams.db.dbz.business.HihokenshaList;
import jp.co.ndensan.reams.db.dbz.business.IHihokenshaShikaku;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.realservice.IKojinFinder;
import jp.co.ndensan.reams.ur.urz.realservice.KojinService;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 介護保険の被保険者を検索するためのクラスです。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaFinder {

    private final HihokenshaDaichoManager hihokenshaDaicho;
    private final IKojinFinder profileSearcher;

    /**
     * 新しいHihokenshaFinderのインスタンスを生成します。
     */
    public HihokenshaFinder() {
        this.hihokenshaDaicho = new HihokenshaDaichoManager();
        this.profileSearcher = KojinService.createKojinFinder();
    }

    /**
     * テスト用のコンストラクタです。 {@link HihokenshaDaichoManager HihokenshaDaichoManager}と
     * {@link IKojinFinder IKojinFinder}を指定して、インスタンスを生成します。
     *
     * @param hihokenshaDaicho
     * {@link HihokenshaDaichoManager HihokenshaDaichoManager}
     * @param profileSearcher {@link IKojinFinder IKojinFinder}
     */
    HihokenshaFinder(HihokenshaDaichoManager hihokenshaDaicho, IKojinFinder profileSearcher) {
        this.hihokenshaDaicho = hihokenshaDaicho;
        this.profileSearcher = profileSearcher;
    }

    /**
     * 直近の資格情報を保持した{@link Hihokensha Hihokensha}を返します。<br />
     * 該当するHihokenshaがいないときは、nullを返します。
     *
     * @param 地方公共団体コード {@link LasdecCode 地方公共団体コード}
     * @param 識別コード {@link ShikibetsuCode 識別コード}
     * @return {@link Hihokensha Hihokensha}。もしくは、null。
     */
    public Hihokensha get被保険者(LasdecCode 地方公共団体コード, ShikibetsuCode 識別コード) {
        IHihokenshaShikaku shikaku = hihokenshaDaicho.get被保険者資格(地方公共団体コード, 識別コード);
        return toHihokensha(shikaku);
    }

    /**
     * 引数に応じた{@link Hihokensha Hihokensha}を返します。<br />
     * 該当するHihokenshaがいないときは、nullを返します。
     *
     * @param 地方公共団体コード {@link LasdecCode 地方公共団体コード}
     * @param 識別コード {@link ShikibetsuCode 識別コード}
     * @param 被保険者台帳登録日時 {@link RDateTime 被保険者台帳登録日時}
     * @return {@link Hihokensha Hihokensha}。もしくは、null。
     */
    public Hihokensha get被保険者(LasdecCode 地方公共団体コード, ShikibetsuCode 識別コード, RDateTime 被保険者台帳登録日時) {
        IHihokenshaShikaku shikaku = hihokenshaDaicho.get被保険者資格(地方公共団体コード, 識別コード, 被保険者台帳登録日時);
        return toHihokensha(shikaku);
    }

    /**
     * 指定の地方公共団体が管理する{@link HihokenshaList Hihokenshaのリスト}を返します。<br />
     * 該当する被保険者がいないときは、{@link Collections#EMPTY_LIST Collections.EMPTY_LIST}を返します。
     *
     * @param 地方公共団体コード {@link LasdecCode 地方公共団体コード}
     * @return
     * {@link HihokenshaList HihokenshaList}。もしくは、{@link Collections#EMPTY_LIST Collections.EMPTY_LIST}。
     */
    public HihokenshaList get被保険者List(LasdecCode 地方公共団体コード) {
        List<IHihokenshaShikaku> shikakuList = hihokenshaDaicho.get被保険者資格ListOf(地方公共団体コード);
        List<Hihokensha> hihokenshaList = toListOfHihokensha(shikakuList);
        return new HihokenshaList(hihokenshaList);
    }

    private List<Hihokensha> toListOfHihokensha(List<IHihokenshaShikaku> shikakuList) {
        return shikakuList.isEmpty() ? Collections.EMPTY_LIST : _toListOfHihokensha(shikakuList);
    }

    private List<Hihokensha> _toListOfHihokensha(List<IHihokenshaShikaku> shikakuList) {
        List<Hihokensha> hihokenshaList = new ArrayList<>();
        for (IHihokenshaShikaku shikaku : shikakuList) {
            Hihokensha hihokensha = toHihokensha(shikaku);
            if (isNull(hihokensha)) {
                continue;
            }
            hihokenshaList.add(hihokensha);
        }
        return hihokenshaList;
    }

    private Hihokensha toHihokensha(IHihokenshaShikaku shikaku) {
        return isNull(shikaku) ? null : _toHihokensha(shikaku);
    }

    private Hihokensha _toHihokensha(IHihokenshaShikaku shikaku) {
        IKojin profile = profileSearcher.get個人(shikaku.get識別コード());
        return isNull(profile) ? null : _createHihokensha(profile, shikaku);
    }

    private Hihokensha _createHihokensha(IKojin profile, IHihokenshaShikaku shikaku) {
        return new Hihokensha(profile, shikaku);
    }

    private boolean isNull(Object target) {
        return target == null;
    }
}
