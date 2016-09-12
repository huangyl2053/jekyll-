/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku02A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku06A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku99A;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局一次判定結果票のEntityの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class IchijihanteikekkahyoItemSetteiTwoA3 {

    private static final Code A_99 = new Code("99A");
    private static final Code A_02 = new Code("02A");
    private static final Code A_06 = new Code("06A");
    private static final Code A_09 = new Code("09A");
    private static final Code B_09 = new Code("09B");
    private static final RString 特記事項有 = new RString("※");

    /**
     * 麻痺特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 麻痺特記事項有無
     */
    public RString get麻痺特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get麻痺調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 拘縮特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 拘縮特記事項有無
     */
    public RString get拘縮特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get拘縮調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 寝返特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 寝返特記事項有無
     */
    public RString get寝返特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get寝返調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 起き上特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 起き上特記事項有無
     */
    public RString get起き上特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get起き上調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 座位保持特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 座位保持特記事項有無
     */
    public RString get座位保持特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get座位保持調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 両足での立位特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 両足での立位特記事項有無
     */
    public RString get両足での立位特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get両足での立位調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 歩行特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 歩行特記事項有無
     */
    public RString get歩行特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get歩行調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 立ち上特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 立ち上特記事項有無
     */
    public RString get立ち上特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get立ち上調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 片足での立位特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 片足での立位特記事項有無
     */
    public RString get片足での立位特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get片足での立位調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 洗身特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 洗身特記事項有無
     */
    public RString get洗身特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get洗身調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * つめ切り特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return つめ切り特記事項有無
     */
    public RString getつめ切り特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(getつめ切り調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 視力特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 視力特記事項有無
     */
    public RString get視力特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get視力調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 聴力特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 聴力特記事項有無
     */
    public RString get聴力特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get聴力調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 移乗特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 移乗特記事項有無
     */
    public RString get移乗特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get移乗調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 移動特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 移動特記事項有無
     */
    public RString get移動特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get移動調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * えん下特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return えん下特記事項有無
     */
    public RString getえん下特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(getえん下調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 食事摂取特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 食事摂取特記事項有無
     */
    public RString get食事摂取特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get食事摂取調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 排尿特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 排尿特記事項有無
     */
    public RString get排尿特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get排尿調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 排便特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 排便特記事項有無
     */
    public RString get排便特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get排便調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 口腔清潔特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 口腔清潔特記事項有無
     */
    public RString get口腔清潔特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get口腔清潔調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 洗顔特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 洗顔特記事項有無
     */
    public RString get洗顔特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get洗顔調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 整髪特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 整髪特記事項有無
     */
    public RString get整髪特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get整髪調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 上衣の着脱特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 上衣の着脱特記事項有無
     */
    public RString get上衣の着脱特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get上衣の着脱調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * ズボン等の着脱特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return ズボン等の着脱特記事項有無
     */
    public RString getズボン等の着脱特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(getズボン等の着脱調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 外出頻度特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 外出頻度特記事項有無
     */
    public RString get外出頻度特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get外出頻度調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 意思の伝達特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 意思の伝達特記事項有無
     */
    public RString get意思の伝達特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get意思の伝達調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 毎日の日課を理解特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 毎日の日課を理解特記事項有無
     */
    public RString get毎日の日課を理解特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get毎日の日課を理解調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 生年月日特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 生年月日特記事項有無
     */
    public RString get生年月日特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get生年月日調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 短期記憶特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 短期記憶特記事項有無
     */
    public RString get短期記憶特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get短期記憶調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 自分の名前特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 自分の名前特記事項有無
     */
    public RString get自分の名前特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get自分の名前調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 今の季節を理解特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 今の季節を理解特記事項有無
     */
    public RString get今の季節を理解特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get今の季節を理解調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 場所の理解特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 場所の理解特記事項有無
     */
    public RString get場所の理解特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get場所の理解調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 徘徊特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 徘徊特記事項有無
     */
    public RString get徘徊特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get徘徊調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 外出して戻特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 外出して戻特記事項有無
     */
    public RString get外出して戻特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get外出して戻調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 被害的特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 被害的特記事項有無
     */
    public RString get被害的特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get被害的調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 作話特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 作話特記事項有無
     */
    public RString get作話特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get作話調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 感情が不安定特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 感情が不安定特記事項有無
     */
    public RString get感情が不安定特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get感情が不安定調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 昼夜逆転特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 昼夜逆転特記事項有無
     */
    public RString get昼夜逆転特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get昼夜逆転調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 同じ話をする特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 同じ話をする特記事項有無
     */
    public RString get同じ話をする特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get同じ話をする調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 大声を出す特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 大声を出す特記事項有無
     */
    public RString get大声を出す特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get大声を出す調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 介護に抵抗特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 介護に抵抗特記事項有無
     */
    public RString get介護に抵抗特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get介護に抵抗調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 落ち着きなし特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 落ち着きなし特記事項有無
     */
    public RString get落ち着きなし特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get落ち着きなし調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 一人で出たがる特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 一人で出たがる特記事項有無
     */
    public RString get一人で出たがる特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get一人で出たがる調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 収集癖特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 収集癖特記事項有無
     */
    public RString get収集癖特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get収集癖調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 物や衣類を壊す特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 物や衣類を壊す特記事項有無
     */
    public RString get物や衣類を壊す特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get物や衣類を壊す調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * ひどい物忘れ特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return ひどい物忘れ特記事項有無
     */
    public RString getひどい物忘れ特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(getひどい物忘れ調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 独り言独り笑い特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 独り言独り笑い特記事項有無
     */
    public RString get独り言独り笑い特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get独り言独り笑い調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 自分勝手特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 自分勝手特記事項有無
     */
    public RString get自分勝手特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get自分勝手調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 話がまとまらない特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 話がまとまらない特記事項有無
     */
    public RString get話がまとまらない特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get話がまとまらない調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 薬の内服特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 薬の内服特記事項有無
     */
    public RString get薬の内服特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get薬の内服調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 金銭の管理特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 金銭の管理特記事項有無
     */
    public RString get金銭の管理特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get金銭の管理調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 日常の意思決定特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 日常の意思決定特記事項有無
     */
    public RString get日常の意思決定特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get日常の意思決定調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 集団への不適応特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 集団への不適応特記事項有無
     */
    public RString get集団への不適応特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get集団への不適応調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 買い物特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 買い物特記事項有無
     */
    public RString get買い物特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get買い物調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 簡単な調理特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 簡単な調理特記事項有無
     */
    public RString get簡単な調理特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get簡単な調理調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 点滴の管理特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 点滴の管理特記事項有無
     */
    public RString get点滴の管理特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get点滴の管理調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 中心静脈栄養特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 中心静脈栄養特記事項有無
     */
    public RString get中心静脈栄養特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get中心静脈栄養調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 透析特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 透析特記事項有無
     */
    public RString get透析特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get透析調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * ストーマの処置特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return ストーマの処置特記事項有無
     */
    public RString getストーマの処置特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(getストーマの処置調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 酸素療法特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 酸素療法特記事項有無
     */
    public RString get酸素療法特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get酸素療法調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * レスピレーター特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return レスピレーター特記事項有無
     */
    public RString getレスピレーター特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(getレスピレーター調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 気管切開の処置特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 気管切開の処置特記事項有無
     */
    public RString get気管切開の処置特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get気管切開の処置調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 疼痛の看護特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 疼痛の看護特記事項有無
     */
    public RString get疼痛の看護特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get疼痛の看護調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * 経管栄養特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 経管栄養特記事項有無
     */
    public RString get経管栄養特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(get経管栄養調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * モニター測定特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return モニター測定特記事項有無
     */
    public RString getモニター測定特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(getモニター測定調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * じょくそうの処置特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return じょくそうの処置特記事項有無
     */
    public RString getじょくそうの処置特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(getじょくそうの処置調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    /**
     * カテーテル特記事項有無を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return カテーテル特記事項有無
     */
    public RString getカテーテル特記事項有無(Code 厚労省IF識別コード, List<RString> 認定調査特記事項番号) {
        if (認定調査特記事項番号.contains(getカテーテル調査特記事項番号(厚労省IF識別コード))) {
            return 特記事項有;
        }
        return RString.EMPTY;
    }

    private RString get麻痺調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.麻痺等の有無.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.麻痺等の有無.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.麻痺等の有無.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.麻痺等の有無.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.麻痺等の有無.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get拘縮調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.間接の動く範囲の制限の有無.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.間接の動く範囲の制限の有無.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.間接の動く範囲の制限の有無.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.拘縮の有無.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.拘縮の有無.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get寝返調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.寝返り.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.寝返り.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.寝返り.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.寝返り.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.寝返り.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get起き上調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.起き上がり.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.起き上がり.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.起き上がり.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.起き上がり.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.起き上がり.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get座位保持調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.座位保持.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.座位保持.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.座位保持.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.座位保持.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get両足での立位調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.両足での立位保持.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.両足での立位保持.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.両足での立位保持.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.両足での立位保持.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.両足での立位保持.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get歩行調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.歩行.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.歩行.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.歩行.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.歩行.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.歩行.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get立ち上調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.立ち上がり.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.立ち上がり.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.立ち上がり.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.立ち上がり.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.立ち上がり.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get片足での立位調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.片足での立位.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.片足での立位.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.片足での立位.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.片足での立位.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.片足での立位.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get洗身調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.洗身.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.洗身.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.洗身.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.洗身.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.洗身.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString getつめ切り調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.つめ切り.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.つめ切り.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.つめ切り.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.つめ切り.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.つめ切り.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get視力調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.視力.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.視力.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.視力.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.視力.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.視力.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get聴力調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.聴力.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.聴力.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.聴力.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.聴力.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.聴力.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get移乗調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.移乗.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.移乗.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.移乗.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.移乗.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.移乗.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get移動調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.移動.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.移動.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.移動.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.移動.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString getえん下調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.えん下.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.えん下.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.えん下.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.えん下.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.えん下.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get食事摂取調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.食事摂取.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.食事摂取.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.食事摂取.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.食事摂取.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.食事摂取.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get排尿調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.尿意.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.排尿.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.排尿.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.排尿.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.排尿.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get排便調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.便意.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.排便.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.排便.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.排便.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.排便.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get口腔清潔調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.口腔清潔_はみがき等.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.口腔清潔.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.口腔清潔.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.口腔清潔.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.口腔清潔.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get洗顔調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.洗顔.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.洗顔.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.洗顔.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.洗顔.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.洗顔.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get整髪調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.整髪.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.整髪.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.整髪.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.整髪.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.整髪.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get上衣の着脱調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.上衣の着脱.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.上衣の着脱.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.上衣の着脱.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.上衣の着脱.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.上衣の着脱.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString getズボン等の着脱調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.ズボン_パンツ等の着脱.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.ズボン等の着脱.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.ズボン等の着脱.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.ズボン等の着脱.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.ズボン等の着脱.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get外出頻度調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.外出頻度.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.外出頻度.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.外出頻度.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get意思の伝達調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.意思の伝達.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.意思の伝達.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.意思の伝達.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.意思の伝達.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.意思の伝達.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get毎日の日課を理解調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.毎日の日課を理解.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.毎日の日課を理解.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.毎日の日課を理解.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.毎日の日課を理解.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.毎日の日課を理解.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get生年月日調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.生年月日や年齢をいう.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.生年月日や年齢をいう.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.生年月日や年齢をいう.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.生年月日や年齢を言う.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.生年月日や年齢を言う.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get短期記憶調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.短期記憶.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.短期記憶.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.短期記憶.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.短期記憶.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.短期記憶.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get自分の名前調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.自分の名前をいう.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.自分の名前をいう.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.自分の名前をいう.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.自分の名前を言う.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.自分の名前を言う.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get今の季節を理解調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.今の季節を理解.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.今の季節を理解.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.今の季節を理解.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.今の季節を理解する.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.今の季節を理解する.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get場所の理解調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.自分がいる場所の理解.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.自分がいる場所の理解.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.自分がいる場所の理解.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.場所の理解.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.場所の理解.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get徘徊調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.常時の徘徊.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.常時の徘徊.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.常時の徘徊.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.徘徊.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.徘徊.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get外出して戻調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.外出して戻れない.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.外出して戻れない.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.外出して戻れない.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.外出すると戻れない.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.外出すると戻れない.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get被害的調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.被害的.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.被害的.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.被害的.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.被害的.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.被害的.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get作話調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.作話.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.作話.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.作話.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.作話.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.作話.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get感情が不安定調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.感情が不安定.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.感情が不安定.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.感情が不安定.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.感情が不安定.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.感情が不安定.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get昼夜逆転調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.昼夜逆転.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.昼夜逆転.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.昼夜逆転.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.昼夜逆転.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.昼夜逆転.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get同じ話をする調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.同じ話をする.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.同じ話をする.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.同じ話をする.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.同じ話をする.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.同じ話をする.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get大声を出す調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.大声をだす.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.大声をだす.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.大声をだす.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.大声を出す.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.大声を出す.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get介護に抵抗調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.介護に抵抗.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.介護に抵抗.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.介護に抵抗.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.介護に抵抗.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.介護に抵抗.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get落ち着きなし調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.落ち着きなし.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.落ち着きなし.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.落ち着きなし.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.落ち着きなし.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.落ち着きなし.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get一人で出たがる調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.一人で出たがる.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.一人で出たがる.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.一人で出たがる.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.一人で出たがる.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.一人で出たがる.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get収集癖調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.収集癖.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.収集癖.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.収集癖.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.収集癖.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.収集癖.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get物や衣類を壊す調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.物や衣類を壊す.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.物や衣類を壊す.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.物や衣類を壊す.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.物や衣類を壊す.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.物や衣類を壊す.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString getひどい物忘れ調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.ひどい物忘れ.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.ひどい物忘れ.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.ひどい物忘れ.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.ひどい物忘れ.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.ひどい物忘れ.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get独り言独り笑い調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.独り言独り笑い.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.独り言独り笑い.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get自分勝手調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.自分勝手に行動する.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.自分勝手に行動する.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get薬の内服調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.薬の内服.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.薬の内服.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.薬の内服.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.薬の内服.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.薬の内服.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get金銭の管理調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.金銭の管理.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.金銭の管理.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.金銭の管理.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.金銭の管理.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.金銭の管理.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get日常の意思決定調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.日常の意思決定.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.日常の意思決定.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get集団への不適応調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.集団への不適応.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.集団への不適応.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get買い物調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.買い物.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.買い物.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get簡単な調理調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.簡単な調理.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.簡単な調理.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get話がまとまらない調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.話がまとまらない.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.話がまとまらない.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get点滴の管理調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.点滴の管理.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.点滴の管理.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.点滴の管理.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.点滴の管理.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.点滴の管理.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get中心静脈栄養調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.中心静脈栄養.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.中心静脈栄養.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.中心静脈栄養.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.中心静脈栄養.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.中心静脈栄養.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get透析調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.透析.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.透析.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.透析.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.透析.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.透析.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString getストーマの処置調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.ストーマの処置.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.ストーマの処置.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.ストーマの処置.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.ストーマの処置.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.ストーマの処置.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get酸素療法調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.酸素療法.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.酸素療法.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.酸素療法.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.酸素療法.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.酸素療法.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString getレスピレーター調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.レスピレーター.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.レスピレーター.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.レスピレーター.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.レスピレーター.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.レスピレーター.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get気管切開の処置調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.気管切開の処置.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.気管切開の処置.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.気管切開の処置.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.気管切開.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.気管切開.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get疼痛の看護調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.疼痛の看護.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.疼痛の看護.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.疼痛の看護.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.疼痛の看護.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.疼痛の看護.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString get経管栄養調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.経管栄養.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.経管栄養.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.経管栄養.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.経管栄養.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.経管栄養.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString getモニター測定調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.モニター測定.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.モニター測定.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.モニター測定.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.モニター測定.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.モニター測定.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString getじょくそうの処置調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.じょくそうの処置.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.じょくそうの処置.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.じょくそうの処置.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.じょくそうの処置.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.じょくそうの処置.get調査特記事項番序();
        }
        return RString.EMPTY;
    }

    private RString getカテーテル調査特記事項番号(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.カテーテル.get調査特記事項番序();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.カテーテル.get調査特記事項番序();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.カテーテル.get調査特記事項番序();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.カテーテル.get調査特記事項番序();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.カテーテル.get調査特記事項番序();
        }
        return RString.EMPTY;
    }
}
