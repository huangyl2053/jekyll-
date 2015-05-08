/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.NyushoShisetsu;
import jp.co.ndensan.reams.db.dbz.business.mapper.NyushoShisetsuMapper;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.KaigoHokenNyushoShisetsuBunrui;
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.hojin.IHojin;
import jp.co.ndensan.reams.db.dbx.realservice.IKaigoJigyoshaFinder;
import jp.co.ndensan.reams.uz.uza.message.Messages;
import jp.co.ndensan.reams.ua.uax.realservice.HojinService;
import jp.co.ndensan.reams.ua.uax.realservice.shikibetsutaisho.IHojinFinder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 入所施設を作成するクラスです。<br/>
 * 施設種類から「介護保険施設」「住所地特例対象施設」「適用除外施設」を判別し、<br/>
 * 「介護保険施設」の場合は介護事業者から<br/>
 * 「住所地特例対象施設」「適用除外施設」の場合は除外住所地特例対象施設から<br/>
 * 法人識別コードを取得します。<br/>
 * 取得した法人識別コードを使って法人を取得し、入所施設を作成します。<br/>
 * ShisetsuNyutaishoManagerからのみ使われる想定のためパッケージプライベートにしています。
 *
 * @author N3317 塚田 萌
 */
class NyushoShisetsuBuilder {

    private final IHojinFinder hojinFinder;
    private IKaigoJigyoshaFinder jigyoshaFinder;
    private JogaiJushochitokureiTaishoShisetsuManager jogaiTokureiShisetsuFinder;

    /**
     * デフォルトコンストラクタです。
     */
    NyushoShisetsuBuilder() {
        hojinFinder = HojinService.createHojinFinder();
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac テスト用Dac
     */
    NyushoShisetsuBuilder(IHojinFinder hojinFinder, IKaigoJigyoshaFinder jigyoshaFinder,
            JogaiJushochitokureiTaishoShisetsuManager jogaiTokureiShisetsuFinder) {
        this.hojinFinder = hojinFinder;
        this.jigyoshaFinder = jigyoshaFinder;
        this.jogaiTokureiShisetsuFinder = jogaiTokureiShisetsuFinder;
    }

    /**
     * 施設種類に対応する「介護事業者」または「除外住所地特例対象施設」から法人識別コードを取得します。<br/>
     * 取得した法人識別コード・入所日に対応する法人を取得し、入所施設インスタンスを生成します。
     *
     * @param 施設種類 施設種類
     * @param 施設コード 施設コード
     * @param 入所日 入所日
     * @return 入所施設インスタンス
     */
    NyushoShisetsu build入所施設(ShisetsuType 施設種類, ShisetsuCode 施設コード, FlexibleDate 入所日) {
        requireNonNull(施設種類, Messages.E00003.replace("施設種類", "NyushoShisetsu").getMessage());

        IHojin 法人 = find法人(get法人識別コード(施設種類, 施設コード), 入所日);

        return NyushoShisetsuMapper.toNyushoShisetsu(施設種類, 施設コード, 法人);
    }

    private ShikibetsuCode get法人識別コード(ShisetsuType 施設種類, ShisetsuCode 施設コード) {
        switch (施設種類) {
            case 介護保険施設:
                return find法人識別コードFrom介護事業者(施設コード);
            case 住所地特例対象施設:
            case 適用除外施設:
                return find法人識別コードFrom除外住所地特例対象施設(施設種類, 施設コード);
            default:
                return null;
        }
    }

    private ShikibetsuCode find法人識別コードFrom介護事業者(ShisetsuCode 施設コード) {
        //TODO n3317塚田萌 IKaigoJigyoshaFinderの修正が完了したら引数(KaigoJigyoshaShubetsu.サービス事業者)を削除する。

        //TODO　n8235船山洋介 get識別コード()が無くなったため、コメントアウト。
//        return jigyoshaFinder.get特定の事業者番号の介護事業者(施設コード.value()).get識別コード();
        return null;
    }

    private ShikibetsuCode find法人識別コードFrom除外住所地特例対象施設(ShisetsuType 施設種類, ShisetsuCode 施設コード) {
        return jogaiTokureiShisetsuFinder.get対象施設(施設種類, 施設コード).get識別コード();
    }

    private IHojin find法人(ShikibetsuCode 識別コード, FlexibleDate 基準日) {
        //TODO n3317塚田萌　RDateからFlexibleDateに変更されたら.toRDate()を外す。

        //TODO n8235船山洋介 hojinFinder.get法人()の引数が変わっているため、暫定的に修正。
//        return hojinFinder.get法人(識別コード, RDate.MAX);
        return hojinFinder.get法人(GyomuCode.DB介護保険, 識別コード);
    }
}
