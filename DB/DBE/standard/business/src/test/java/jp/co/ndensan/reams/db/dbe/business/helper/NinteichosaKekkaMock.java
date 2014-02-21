/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaGaikyo;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaGaikyoKihon;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaGaikyoService;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekka;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GenzaiJokyoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ServiceKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiFuriwakeKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaKomoku;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaKomoku.*;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.*;
import static org.mockito.Mockito.spy;

/**
 * NinteichosaKekkaを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaKekkaMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private NinteichosaKekkaMock() {
    }

    /**
     * NinteichosaKekkaを生成して返します。
     *
     * @return NinteichosaKekka
     */
    public static NinteichosaKekka getSpiedNinteichosaKekkaInstance() {
        return spy(new NinteichosaKekka(new ShinseishoKanriNo(new RString("1234567890")), 0,
                getSpiedChosaKekkaGaikyoInstance(), getSpiedChosaKekkaKihonInstance()));
    }

    /**
     * ChosaKekkaGaikyoを生成して返します。
     *
     * @return ChosaKekkaGaikyo
     */
    public static ChosaKekkaGaikyo getSpiedChosaKekkaGaikyoInstance() {
        return spy(new ChosaKekkaGaikyo(getSpiedChosaKekkaGaikyoKihonInstance(), getSpiedChosaKekkaGaikyoServiceInstance()));
    }

    /**
     * ChosaKekkaGaikyoKihonを生成して返します。
     *
     * @return ChosaKekkaGaikyoKihon
     */
    public static ChosaKekkaGaikyoKihon getSpiedChosaKekkaGaikyoKihonInstance() {
        return spy(new ChosaKekkaGaikyoKihon(
                new FlexibleDate("20140101"),
                ChosaIraiKubun.初回,
                new RString("12345678"),
                new RString("認定調査実施場所名称"),
                ChosaKubun.新規調査,
                new RString("概況特記事項"),
                ShinsakaiFuriwakeKubun.希望無し));
    }

    /**
     * ChosaKekkaGaikyoServiceを生成して返します。
     *
     * @return ChosaKekkaGaikyoService
     */
    public static ChosaKekkaGaikyoService getSpiedChosaKekkaGaikyoServiceInstance() {
        return spy(new ChosaKekkaGaikyoService(
                ServiceKubun.介護給付サービス,
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0,
                GenzaiJokyoKubun.指定介護療養型医療施設,
                new RString("市町村特別給付"),
                new RString("介護保険給付以外の在宅サービス")));
    }

    /**
     * ChosaKekkaKihonを生成して返します。
     *
     * @return ChosaKekkaKihon
     */
    public static Map<ChosaKomoku, RString> getSpiedChosaKekkaKihonInstance() {
        Map<ChosaKomoku, RString> map = new HashMap<>();
        map.put(麻痺等の有無_左上肢, NaiAru.ない.getCode());
        map.put(麻痺等の有無_右上肢, NaiAru.ある.getCode());
        map.put(麻痺等の有無_左下肢, NaiAru.ない.getCode());
        map.put(麻痺等の有無_右下肢, NaiAru.ある.getCode());
        map.put(麻痺等の有無_その他, NaiAru.ない.getCode());
        map.put(関節の動く範囲の制限_肩関節, NaiAru.ない.getCode());
        map.put(関節の動く範囲の制限_股関節, NaiAru.ある.getCode());
        map.put(関節の動く範囲の制限_膝関節, NaiAru.ない.getCode());
        map.put(関節の動く範囲の制限_その他, NaiAru.ある.getCode());
        map.put(寝返り, DekiruDekinai3.できる.getCode());
        map.put(起き上がり, DekiruDekinai3.できない.getCode());
        map.put(座位保持, DekiruDekinai6.できる.getCode());
        map.put(両足での立位, DekiruDekinai5.できない.getCode());
        map.put(歩行, DekiruDekinai3.できる.getCode());
        map.put(立ち上がり, DekiruDekinai3.できない.getCode());
        map.put(片足での立位, DekiruDekinai5.できる.getCode());
        map.put(洗身, Kaijo2.自立.getCode());
        map.put(つめ切り, Kaijo.全介助.getCode());
        map.put(視力, Shiryoku.普通.getCode());
        map.put(聴力, Choryoku.判断不能.getCode());
        map.put(移乗, Kaijo3.自立.getCode());
        map.put(移動, Kaijo3.全介助.getCode());
        map.put(嚥下, DekiruDekinai4.できる.getCode());
        map.put(食事摂取, Kaijo3.自立.getCode());
        map.put(排尿, Kaijo3.全介助.getCode());
        map.put(排便, Kaijo3.自立.getCode());
        map.put(口腔清潔, Kaijo.全介助.getCode());
        map.put(洗顔, Kaijo.自立.getCode());
        map.put(整髪, Kaijo.全介助.getCode());
        map.put(上衣の着脱, Kaijo3.自立.getCode());
        map.put(ズボン等の着脱, Kaijo3.全介助.getCode());
        map.put(外出頻度, Gaishutsu.月１回以上.getCode());
        map.put(意思の伝達, DekiruDekinai2.できる.getCode());
        map.put(毎日の日課を理解, DekiruDekinai.できない.getCode());
        map.put(生年月日をいう, DekiruDekinai.できる.getCode());
        map.put(短期記憶, DekiruDekinai.できない.getCode());
        map.put(自分の名前をいう, DekiruDekinai.できる.getCode());
        map.put(今の季節を理解, DekiruDekinai.できない.getCode());
        map.put(場所の理解, DekiruDekinai.できる.getCode());
        map.put(常時の徘徊, NaiAru2.ない.getCode());
        map.put(外出して戻れない, NaiAru2.ある.getCode());
        map.put(被害的, NaiAru2.ない.getCode());
        map.put(作話, NaiAru2.ある.getCode());
        map.put(感情が不安定, NaiAru2.ない.getCode());
        map.put(昼夜逆転, NaiAru2.ある.getCode());
        map.put(同じ話をする, NaiAru2.ない.getCode());
        map.put(大声を出す, NaiAru2.ある.getCode());
        map.put(介護に抵抗, NaiAru2.ない.getCode());
        map.put(落ち着きなし, NaiAru2.ある.getCode());
        map.put(一人で出たがる, NaiAru2.ない.getCode());
        map.put(収集癖, NaiAru2.ある.getCode());
        map.put(物や衣類を壊す, NaiAru2.ない.getCode());
        map.put(ひどい物忘れ, NaiAru2.ある.getCode());
        map.put(独り言_独り笑, NaiAru2.ない.getCode());
        map.put(自分勝手に行動する, NaiAru2.ある.getCode());
        map.put(話がまとまらない, NaiAru2.ない.getCode());
        map.put(薬の内服, Kaijo.自立.getCode());
        map.put(金銭の管理, Kaijo.全介助.getCode());
        map.put(日常の意思決定, DekiruDekinai7.できる.getCode());
        map.put(集団への不適応, NaiAru2.ない.getCode());
        map.put(買い物, Kaijo3.自立.getCode());
        map.put(簡単な調理, Kaijo3.全介助.getCode());
        map.put(点滴の管理, NaiAru.ない.getCode());
        map.put(中心静脈栄養, NaiAru.ある.getCode());
        map.put(透析, NaiAru.ない.getCode());
        map.put(ストーマの処置, NaiAru.ある.getCode());
        map.put(酸素療法, NaiAru.ない.getCode());
        map.put(レスピレーター, NaiAru.ある.getCode());
        map.put(気管切開, NaiAru.ない.getCode());
        map.put(疼痛の看護, NaiAru.ある.getCode());
        map.put(経管栄養, NaiAru.ない.getCode());
        map.put(モニター測定, NaiAru.ある.getCode());
        map.put(じょくそうの処置, NaiAru.ない.getCode());
        map.put(カテーテル, NaiAru.ある.getCode());
        map.put(障害高齢者の日常生活自立度, ShogaiKoreishaJiritsu.Ａ１.getCode());
        map.put(認知症高齢者の日常生活自立度, NinchishoKoreishaJiritsu.Ⅱａ.getCode());
        return map;
    }
}
