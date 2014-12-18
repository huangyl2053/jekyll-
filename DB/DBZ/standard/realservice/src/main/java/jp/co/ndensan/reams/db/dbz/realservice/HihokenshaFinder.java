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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.search.IJuminKihonDaichoSearchKey;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.search.JuminKihonDaichoSearchKeyBuilder;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.shikibetsutaisho.IJukiKojinFinder;
import jp.co.ndensan.reams.ur.urz.realservice.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 介護保険の被保険者を検索するためのクラスです。
 *
 * @author N3327 三浦 凌
 */
@Deprecated
public class HihokenshaFinder {

    private final _HihokenshaDaichoManager hihokenshaDaicho;
    private final IJukiKojinFinder profileSearcher;

    /**
     * 新しいHihokenshaFinderのインスタンスを生成します。
     */
    public HihokenshaFinder() {
        this.hihokenshaDaicho = new _HihokenshaDaichoManager();
        this.profileSearcher = ShikibetsuTaishoService.getJukiKojinFinder();
    }

    /**
     * テスト用のコンストラクタです。 {@link _HihokenshaDaichoManager HihokenshaDaichoManager}と
     * {@link IKojinFinder IKojinFinder}を指定して、インスタンスを生成します。
     *
     * @param hihokenshaDaicho
     * {@link _HihokenshaDaichoManager HihokenshaDaichoManager}
     * @param profileSearcher {@link IKojinFinder IKojinFinder}
     */
    HihokenshaFinder(_HihokenshaDaichoManager hihokenshaDaicho, IJukiKojinFinder profileSearcher) {
        this.hihokenshaDaicho = hihokenshaDaicho;
        this.profileSearcher = profileSearcher;
    }

    /**
     * {@link LasdecCode 市町村コード}と{@link ShikibetsuCode 識別コード}から、
     * 直近の資格情報を保持した{@link Hihokensha Hihokensha}を返します。<br />
     * 該当するHihokenshaがいないときは、nullを返します。
     *
     * @param 市町村コード {@link LasdecCode 市町村コード}
     * @param 識別コード {@link ShikibetsuCode 識別コード}
     * @return {@link Hihokensha Hihokensha}。もしくは、null。
     */
    public Hihokensha get被保険者(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        IHihokenshaShikaku shikaku = hihokenshaDaicho.get直近被保険者資格(市町村コード, 識別コード);
        return toHihokensha(shikaku);
    }

    /**
     * {@link LasdecCode 市町村コード}と{@link HihokenshaNo 被保険者番号}から、
     * 直近の資格情報を保持した{@link Hihokensha Hihokensha}を返します。<br />
     * 該当するHihokenshaがいないときは、nullを返します。
     *
     * @param 市町村コード {@link LasdecCode 市町村コード}
     * @param 被保険者番号 {@link HihokenshaNo 被保険者番号}
     * @return {@link Hihokensha Hihokensha}。もしくは、null。
     */
    public Hihokensha get被保険者(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {
        IHihokenshaShikaku shikaku = hihokenshaDaicho.get直近被保険者資格(市町村コード, 被保険者番号);
        return toHihokensha(shikaku);
    }

    /**
     * 引数に応じた{@link Hihokensha Hihokensha}を返します。<br />
     * 該当するHihokenshaがいないときは、nullを返します。
     *
     * @param 市町村コード {@link LasdecCode 市町村コード}
     * @param 識別コード {@link ShikibetsuCode 識別コード}
     * @param 処理日時 {@link YMDHMS 処理日時}
     * @return {@link Hihokensha Hihokensha}。もしくは、null。
     */
    public Hihokensha get被保険者(LasdecCode 市町村コード, ShikibetsuCode 識別コード, YMDHMS 処理日時) {
        IHihokenshaShikaku shikaku = hihokenshaDaicho.get被保険者資格(市町村コード, 識別コード, 処理日時);
        return toHihokensha(shikaku);
    }

    /**
     * 指定の地方公共団体が管理する{@link HihokenshaList Hihokenshaのリスト}を返します。<br />
     * 該当する被保険者がいないときは、{@link Collections#EMPTY_LIST Collections.EMPTY_LIST}を返します。
     *
     * @param 市町村コード {@link LasdecCode 市町村コード}
     * @return
     * {@link HihokenshaList HihokenshaList}。もしくは、{@link Collections#EMPTY_LIST Collections.EMPTY_LIST}。
     */
    public HihokenshaList get被保険者List(LasdecCode 市町村コード) {
        List<IHihokenshaShikaku> shikakuList = hihokenshaDaicho.get被保険者資格ListOf(市町村コード);
        List<Hihokensha> hihokenshaList = toListOfHihokensha(shikakuList);
        return new HihokenshaList(hihokenshaList);
    }

    /**
     * 検索条件を指定して、該当する{@link HihokenshaList Hihokenshaのリスト}を返します。<br />
     * 該当する被保険者がいないときは、{@link Collections#EMPTY_LIST Collections.EMPTY_LIST}を返します。
     *
     * @param 検索条件 {@link ISearchCondition 検索条件}
     * @return
     * {@link HihokenshaList HihokenshaList}。もしくは、{@link Collections#EMPTY_LIST Collections.EMPTY_LIST}。
     */
    public HihokenshaList get被保険者List(ISearchCondition 検索条件) {
        List<IHihokenshaShikaku> shikakuList = hihokenshaDaicho.get被保険者資格ListOf(検索条件);
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
        IJuminKihonDaichoSearchKey searchKey = new JuminKihonDaichoSearchKeyBuilder(GyomuCode.DB介護保険).set識別コード(shikaku.get識別コード()).build();
        IKojin profile = profileSearcher.find住基個人(searchKey);
        return isNull(profile) ? null : _createHihokensha(profile, shikaku);
    }

    private Hihokensha _createHihokensha(IKojin profile, IHihokenshaShikaku shikaku) {
        return new Hihokensha(profile, shikaku);
    }

    private boolean isNull(Object target) {
        return target == null;
    }
}
