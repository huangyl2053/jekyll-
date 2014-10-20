/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.IMinashi2GoshaDaicho;
import jp.co.ndensan.reams.db.dbe.business.Minashi2Gosha;
import jp.co.ndensan.reams.db.dbe.business.Minashi2GoshaList;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.search.IJuminKihonDaichoSearchKey;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.search.JuminKihonDaichoSearchKeyBuilder;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.shikibetsutaisho.IJukiKojinFinder;
import jp.co.ndensan.reams.ur.urz.realservice.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * みなし2号者の情報を取得します。
 *
 * @author n8178 城間篤人
 */
public class Minashi2GoshaFinder {

    private final Minashi2GoshaDaichoFinder minashiDaichoFinder;
    private final IJukiKojinFinder profileSearcher;

    /**
     * デフォルトコンストラクタです。
     */
    public Minashi2GoshaFinder() {
        minashiDaichoFinder = new Minashi2GoshaDaichoFinder();
        profileSearcher = ShikibetsuTaishoService.getJukiKojinFinder();
    }

    /**
     * テスト用コンストラクタです。
     */
    Minashi2GoshaFinder(Minashi2GoshaDaichoFinder minashiDaichoFinder, IJukiKojinFinder profileSearcher) {
        this.minashiDaichoFinder = minashiDaichoFinder;
        this.profileSearcher = profileSearcher;
    }

    /**
     * 検索条件を元に、みなし2号者のListを取得して返します。
     *
     * @param condition 検索条件
     * @return みなし2号者List
     */
    public Minashi2GoshaList getみなし2号者List(ISearchCondition condition) {
        List<IMinashi2GoshaDaicho> minashi2GoshaDaicho = minashiDaichoFinder.getみなし2号者台帳(condition);

        return toMinashi2GoshaList(minashi2GoshaDaicho);
    }

    private Minashi2GoshaList toMinashi2GoshaList(List<IMinashi2GoshaDaicho> minashi2GoshaDaicho) {
        List<Minashi2Gosha> minashi2GoshaList = new ArrayList<>();
        for (IMinashi2GoshaDaicho minashiDaicho : minashi2GoshaDaicho) {
            IKojin kojin = profileSearcher.find住基個人(createSearchKey(minashiDaicho.get識別コード()));
            minashi2GoshaList.add(new Minashi2Gosha(minashiDaicho, kojin));
        }
        return new Minashi2GoshaList(minashi2GoshaList);
    }

    private IJuminKihonDaichoSearchKey createSearchKey(ShikibetsuCode shikibetsuCode) {
        return new JuminKihonDaichoSearchKeyBuilder(GyomuCode.DB介護保険).set識別コード(shikibetsuCode).build();
    }
}
