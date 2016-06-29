/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping99A;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員用一次判定結果票の編集クラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IchijihanteikekkahyoItemSetteiThree {

    private static final RString A_99 = new RString("99A");
    private static final RString A_02 = new RString("02A");
    private static final RString A_06 = new RString("06A");
    private static final RString A_09 = new RString("09A");
    private static final RString B_09 = new RString("09B");

    /**
     * 簡単な調理コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get簡単な調理(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.簡単な調理.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.簡単な調理.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 買い物コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get買い物(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.買い物.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.買い物.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 集団への不適応コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get集団への不適応(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.集団への不適応.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.集団への不適応.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 日常の意思決定コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get日常の意思決定(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.日常の意思決定.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.日常の意思決定.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.日常の意思決定.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.日常の意思決定.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 金銭の管理コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get金銭の管理(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.金銭の管理.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.金銭の管理.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.金銭の管理.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.金銭の管理.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.金銭の管理.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 話がまとまらないコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get話がまとまらない(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.話がまとまらない.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.話がまとまらない.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 自分勝手に行動するコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get自分勝手に行動する(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.自分勝手に行動する.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.自分勝手に行動する.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 独り言_独り笑いコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get独り言_独り笑い(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.独り言_独り笑い.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.独り言_独り笑い.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * ひどい物忘れコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int getひどい物忘れ(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.ひどい物忘れ.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.ひどい物忘れ.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.ひどい物忘れ.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.ひどい物忘れ.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.ひどい物忘れ.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 物や衣類を壊すコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get物や衣類を壊す(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.物や衣類を壊す.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.物や衣類を壊す.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.物や衣類を壊す.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.物や衣類を壊す.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.物や衣類を壊す.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 収集癖コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get収集癖(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.収集癖.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.収集癖.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.収集癖.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.収集癖.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.収集癖.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 一人で出たがるコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get一人で出たがる(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.一人で出たがる.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.一人で出たがる.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.一人で出たがる.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.一人で出たがる.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.一人で出たがる.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 落ち着きなしコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get落ち着きなし(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.落ち着きなし.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.落ち着きなし.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.落ち着きなし.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.落ち着きなし.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.落ち着きなし.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 介護に抵抗コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get介護に抵抗(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.介護に抵抗.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.介護に抵抗.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.介護に抵抗.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.介護に抵抗.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.介護に抵抗.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 大声を出すコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get大声を出す(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.大声をだす.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.大声をだす.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.大声をだす.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.大声を出す.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.大声を出す.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 同じ話をするコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get同じ話をする(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.同じ話をする.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.同じ話をする.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.同じ話をする.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.同じ話をする.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.同じ話をする.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 昼夜逆転コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get昼夜逆転(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.昼夜逆転.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.昼夜逆転.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.昼夜逆転.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.昼夜逆転.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.昼夜逆転.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 感情が不安定コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get感情が不安定(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.感情が不安定.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.感情が不安定.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.感情が不安定.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.感情が不安定.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.感情が不安定.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 作話コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get作話(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.作話.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.作話.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.作話.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.作話.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.作話.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 被害的コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get被害的(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.被害的.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.被害的.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.被害的.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.被害的.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.被害的.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 外出して戻れないコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get外出して戻れない(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.外出して戻れない.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.外出して戻れない.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.外出して戻れない.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.外出して戻れない.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.外出して戻れない.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 徘徊コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get徘徊(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.常時の徘徊.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.常時の徘徊.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.常時の徘徊.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.常時の徘徊.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.常時の徘徊.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 場所の理解コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get場所の理解(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.場所の理解.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.場所の理解.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.場所の理解.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.場所の理解.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.場所の理解.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 今の季節を理解コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get今の季節を理解(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.今の季節を理解.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.今の季節を理解.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.今の季節を理解.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.今の季節を理解.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.今の季節を理解.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 自分の名前をいうコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get自分の名前をいう(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.自分の名前をいう.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.自分の名前をいう.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.自分の名前をいう.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.自分の名前をいう.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.自分の名前をいう.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 短期記憶コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get短期記憶(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.短期記憶.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.短期記憶.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.短期記憶.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.短期記憶.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.短期記憶.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 生年月日をいうコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get生年月日をいう(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.生年月日をいう.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.生年月日をいう.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.生年月日をいう.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.生年月日をいう.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.生年月日をいう.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 毎日の日課を理解コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get毎日の日課を理解(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.毎日の日課を理解.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.毎日の日課を理解.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.毎日の日課を理解.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.毎日の日課を理解.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.毎日の日課を理解.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 意思の伝達コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get意思の伝達(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.意思の伝達.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.意思の伝達.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.意思の伝達.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.意思の伝達.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.意思の伝達.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 外出頻度コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get外出頻度(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.外出頻度.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.外出頻度.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.外出頻度.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * ズボン等の着脱コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int getズボン等の着脱(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.ズボン等の着脱.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.ズボン等の着脱.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.ズボン等の着脱.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.ズボン等の着脱.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.ズボン等の着脱.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 上衣の着脱コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get上衣の着脱(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.上衣の着脱.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.上衣の着脱.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.上衣の着脱.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.上衣の着脱.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.上衣の着脱.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 整髪コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get整髪(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.整髪.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.整髪.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.整髪.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.整髪.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.整髪.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 洗顔コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get洗顔(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.洗顔.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.洗顔.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.洗顔.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.洗顔.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.洗顔.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 口腔清潔コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get口腔清潔(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.口腔清潔.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.口腔清潔.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.口腔清潔.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.口腔清潔.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.口腔清潔.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 排便コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get排便(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.排便.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.排便.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.排便.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.排便.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 排尿コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get排尿(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.排尿.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.排尿.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.排尿.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.排尿.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 食事摂取コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get食事摂取(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.食事摂取.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.食事摂取.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.食事摂取.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.食事摂取.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.食事摂取.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * えん下コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int getえん下(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.えん下.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.えん下.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.えん下.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.えん下.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.えん下.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 移動コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get移動(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.移動.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.移動.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.移動.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.移動.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 移乗コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get移乗(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.移乗.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.移乗.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.移乗.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.移乗.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.移乗.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 聴力コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get聴力(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.聴力.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.聴力.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.聴力.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.聴力.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.聴力.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 視力コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get視力(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.視力.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.視力.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.視力.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.視力.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.視力.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * つめ切りコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int getつめ切り(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.つめ切り.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.つめ切り.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.つめ切り.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.つめ切り.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.つめ切り.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 洗身コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get洗身(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.洗身.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.洗身.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.洗身.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.洗身.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.洗身.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 片足での立位コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get片足での立位(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.片足での立位.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.片足での立位.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.片足での立位.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.片足での立位.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.片足での立位.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 立ち上がりコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get立ち上がり(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.立ち上がり.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.立ち上がり.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.立ち上がり.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.立ち上がり.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.立ち上がり.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 歩行コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get歩行(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.歩行.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.歩行.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.歩行.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.歩行.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.歩行.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 両足での立位コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get両足での立位(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.両足での立位.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.両足での立位.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.両足での立位.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.両足での立位.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.両足での立位.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 座位保持コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get座位保持(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.MAX_VALUE;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.座位保持.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.座位保持.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.座位保持.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.座位保持.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 起き上がりコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get起き上がり(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.起き上がり.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.起き上がり.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.起き上がり.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.起き上がり.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.起き上がり.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 寝返りコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get寝返り(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.寝返り.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.寝返り.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.寝返り.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.寝返り.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.寝返り.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 拘縮_その他コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get拘縮_その他(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.拘縮_その他.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.拘縮_その他.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.拘縮_その他.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.拘縮_その他.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.拘縮_その他.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 拘縮_膝関節コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get拘縮_膝関節(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.拘縮_膝関節.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.拘縮_膝関節.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.拘縮_膝関節.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.拘縮_膝関節.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.拘縮_膝関節.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 拘縮_股関節コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get拘縮_股関節(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.拘縮_股関節.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.拘縮_股関節.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.拘縮_股関節.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.拘縮_股関節.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.拘縮_股関節.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 拘縮_肩関節コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get拘縮_肩関節(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.拘縮_肩関節.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.拘縮_肩関節.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.拘縮_肩関節.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.拘縮_肩関節.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.拘縮_肩関節.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 麻痺_左_上肢コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get麻痺_左_上肢(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.麻痺等_左上肢.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.麻痺等_左上肢.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.麻痺等_左上肢.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.麻痺等_左上肢.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.麻痺等_左上肢.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 麻痺_左_下肢コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get麻痺_左_下肢(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.麻痺等_左下肢.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.麻痺等_左上肢.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.麻痺等_左上肢.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.麻痺等_左上肢.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.麻痺等_左上肢.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 麻痺_右_上肢コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get麻痺_右_上肢(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.麻痺等_右上肢.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.麻痺等_右上肢.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.麻痺等_右上肢.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.麻痺等_右上肢.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.麻痺等_右上肢.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 麻痺_右_下肢コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get麻痺_右_下肢(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.麻痺等_右下肢.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.麻痺等_右下肢.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.麻痺等_右下肢.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.麻痺等_右下肢.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.麻痺等_右下肢.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 麻痺_その他コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get麻痺_その他(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.麻痺等_その他.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.麻痺等_その他.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.麻痺等_その他.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.麻痺等_その他.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.麻痺等_その他.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * カテーテルコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int getカテーテル(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.カテーテル.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.カテーテル.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.カテーテル.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.カテーテル.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.カテーテル.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * じょくそうの処置コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int getじょくそうの処置(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.じょくそうの処置.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.じょくそうの処置.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.じょくそうの処置.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.じょくそうの処置.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.じょくそうの処置.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 薬の内服コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get薬の内服(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.薬の内服.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.薬の内服.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.薬の内服.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.薬の内服.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.薬の内服.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * モニター測定コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int getモニター測定(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.モニター測定.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.モニター測定.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.モニター測定.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.モニター測定.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.モニター測定.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 気管切開の処置コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get気管切開の処置(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.気管切開の処置.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.気管切開の処置.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.気管切開の処置.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.気管切開の処置.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.気管切開の処置.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 点滴の管理コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get点滴の管理(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.点滴の管理.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.点滴の管理.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.点滴の管理.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.点滴の管理.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.点滴の管理.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 中心静脈栄養コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get中心静脈栄養(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.中心静脈栄養.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.中心静脈栄養.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.中心静脈栄養.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.中心静脈栄養.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.中心静脈栄養.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 透析コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get透析(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.透析.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.透析.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.透析.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.透析.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.透析.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * ストーマの処置コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int getストーマの処置(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.ストーマの処置.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.ストーマの処置.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.ストーマの処置.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.ストーマの処置.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.ストーマの処置.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 酸素療法コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get酸素療法(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.酸素療法.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.酸素療法.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.酸素療法.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.酸素療法.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.酸素療法.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * レスピレーターコードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int getレスピレーター(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.レスピレーター.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.レスピレーター.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.レスピレーター.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.レスピレーター.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.レスピレーター.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 疼痛の看護コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get疼痛の看護(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.疼痛の看護.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.疼痛の看護.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.疼痛の看護.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.疼痛の看護.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.疼痛の看護.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 経管栄養コードの取得です。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return コード
     */
    public int get経管栄養(RString 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping99A.経管栄養.getコード().toString());
        } else if (A_02.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping02A.経管栄養.getコード().toString());
        } else if (A_06.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping06A.経管栄養.getコード().toString());
        } else if (A_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09A.経管栄養.getコード().toString());
        } else if (B_09.equals(厚労省IF識別コード)) {
            return Integer.valueOf(NinteichosaKomokuMapping09B.経管栄養.getコード().toString());
        }
        return Integer.MAX_VALUE;
    }

}
