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
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping99A;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局一次判定結果票の編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class IchijihanteikekkahyoItemSetteiThreeA3 {

    private static final Code A_99 = new Code("99A");
    private static final Code A_02 = new Code("02A");
    private static final Code A_06 = new Code("06A");
    private static final Code A_09 = new Code("09A");
    private static final Code B_09 = new Code("09B");

    /**
     * 麻痺_左上肢コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 麻痺_左上肢
     */
    public RString get麻痺_左上肢(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.麻痺等_左上肢.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.麻痺等_左上肢.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.麻痺等_左上肢.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.麻痺等_左上肢.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.麻痺等_左上肢.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 麻痺等_左下肢コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 麻痺等_左下肢
     */
    public RString get麻痺_左下肢(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.麻痺等_左下肢.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.麻痺等_左下肢.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.麻痺等_左下肢.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.麻痺等_左下肢.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.麻痺等_左下肢.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 麻痺等_右上肢コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 麻痺等_右上肢
     */
    public RString get麻痺_右上肢(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.麻痺等_右上肢.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.麻痺等_右上肢.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.麻痺等_右上肢.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.麻痺等_右上肢.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.麻痺等_右上肢.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 麻痺等_右下肢コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 麻痺等_右下肢
     */
    public RString get麻痺_右下肢(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.麻痺等_右下肢.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.麻痺等_右下肢.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.麻痺等_右下肢.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.麻痺等_右下肢.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.麻痺等_右下肢.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 麻痺等_その他コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 麻痺等_その他
     */
    public RString get麻痺_その他(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.麻痺等_その他.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.麻痺等_その他.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.麻痺等_その他.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.麻痺等_その他.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.麻痺等_その他.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 拘縮_肩関節コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 拘縮_肩関節
     */
    public RString get拘縮_肩関節(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.拘縮_肩関節.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.拘縮_肩関節.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.拘縮_肩関節.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.拘縮_肩関節.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.拘縮_肩関節.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 拘縮_股関節コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 拘縮_股関節
     */
    public RString get拘縮_股関節(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.拘縮_股関節.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.拘縮_股関節.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.拘縮_股関節.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.拘縮_股関節.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.拘縮_股関節.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 拘縮_膝関節コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 拘縮_膝関節
     */
    public RString get拘縮_膝関節(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.拘縮_膝関節.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.拘縮_膝関節.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.拘縮_膝関節.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.拘縮_膝関節.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.拘縮_膝関節.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 拘縮_その他コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 拘縮_その他
     */
    public RString get拘縮_その他(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.拘縮_その他.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.拘縮_その他.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.拘縮_その他.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.拘縮_その他.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.拘縮_その他.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 寝返りコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 寝返り
     */
    public RString get寝返り(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.寝返り.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.寝返り.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.寝返り.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.寝返り.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.寝返り.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 起き上がりコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 起き上がり
     */
    public RString get起き上(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.起き上がり.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.起き上がり.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.起き上がり.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.起き上がり.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.起き上がり.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 座位保持コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 座位保持
     */
    public RString get座位保持(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.両足がついた座位保持.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.座位保持.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.座位保持.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.座位保持.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.座位保持.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 両足での立位コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 両足での立位
     */
    public RString get両足での立位(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.両足での立位.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.両足での立位.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.両足での立位.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.両足での立位.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.両足での立位.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 歩行コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 歩行
     */
    public RString get歩行(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.歩行.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.歩行.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.歩行.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.歩行.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.歩行.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 立ち上がりコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 立ち上がり
     */
    public RString get立ち上(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.立ち上がり.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.立ち上がり.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.立ち上がり.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.立ち上がり.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.立ち上がり.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 片足での立位コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 片足での立位
     */
    public RString get片足での立位(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.片足での立位.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.片足での立位.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.片足での立位.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.片足での立位.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.片足での立位.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 洗身コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 洗身
     */
    public RString get洗身(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.洗身.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.洗身.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.洗身.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.洗身.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.洗身.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * つめ切りコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return つめ切り
     */
    public RString getつめ切り(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.つめ切り.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.つめ切り.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.つめ切り.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.つめ切り.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.つめ切り.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 視力コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 視力
     */
    public RString get視力(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.視力.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.視力.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.視力.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.視力.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.視力.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 聴力コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 聴力
     */
    public RString get聴力(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.聴力.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.聴力.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.聴力.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.聴力.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.聴力.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 移乗コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 移乗
     */
    public RString get移乗(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.移乗.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.移乗.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.移乗.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.移乗.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.移乗.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 移動コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 移動
     */
    public RString get移動(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.移動.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.移動.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.移動.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.移動.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * えん下コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return えん下
     */
    public RString getえん下(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.えん下.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.えん下.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.えん下.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.えん下.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.えん下.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 食事摂取コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 食事摂取
     */
    public RString get食事摂取(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.食事摂取.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.食事摂取.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.食事摂取.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.食事摂取.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.食事摂取.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 排尿コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 排尿
     */
    public RString get排尿(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.尿意.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.排尿.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.排尿.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.排尿.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.排尿.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 排便コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 排便
     */
    public RString get排便(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.便意.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.排便.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.排便.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.排便.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.排便.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 口腔清潔コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 口腔清潔
     */
    public RString get口腔清潔(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.口腔清潔.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.口腔清潔.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.口腔清潔.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.口腔清潔.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.口腔清潔.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 洗顔コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 洗顔
     */
    public RString get洗顔(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.洗顔.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.洗顔.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.洗顔.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.洗顔.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.洗顔.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 整髪コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 整髪
     */
    public RString get整髪(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.整髪.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.整髪.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.整髪.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.整髪.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.整髪.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 上衣の着脱コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 上衣の着脱
     */
    public RString get上衣の着脱(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.上衣の着脱.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.上衣の着脱.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.上衣の着脱.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.上衣の着脱.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.上衣の着脱.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * ズボン等の着脱コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return ズボン等の着脱
     */
    public RString getズボン等の着脱(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.ズボン等の着脱.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.ズボン等の着脱.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.ズボン等の着脱.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.ズボン等の着脱.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.ズボン等の着脱.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 外出頻度コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 外出頻度
     */
    public RString get外出頻度(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.外出頻度.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.外出頻度.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.外出頻度.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 意思の伝達コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 意思の伝達
     */
    public RString get意思の伝達(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.意思の伝達.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.意思の伝達.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.意思の伝達.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.意思の伝達.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.意思の伝達.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 毎日の日課を理解コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 毎日の日課を理解
     */
    public RString get毎日の日課を理解(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.毎日の日課を理解.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.毎日の日課を理解.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.毎日の日課を理解.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.毎日の日課を理解.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.毎日の日課を理解.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 生年月日をいうコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 生年月日をいう
     */
    public RString get生年月日(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.生年月日をいう.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.生年月日をいう.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.生年月日をいう.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.生年月日をいう.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.生年月日をいう.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 短期記憶コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 短期記憶
     */
    public RString get短期記憶(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.短期記憶.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.短期記憶.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.短期記憶.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.短期記憶.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.短期記憶.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 自分の名前をいうコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 自分の名前をいう
     */
    public RString get自分の名前(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.自分の名前をいう.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.自分の名前をいう.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.自分の名前をいう.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.自分の名前をいう.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.自分の名前をいう.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 今の季節を理解コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 今の季節を理解
     */
    public RString get今の季節を理解(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.今の季節を理解.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.今の季節を理解.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.今の季節を理解.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.今の季節を理解.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.今の季節を理解.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 場所の理解コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 場所の理解
     */
    public RString get場所の理解(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.場所の理解.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.場所の理解.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.場所の理解.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.場所の理解.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.場所の理解.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 常時の徘徊コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 常時の徘徊
     */
    public RString get徘徊(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.常時の徘徊.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.常時の徘徊.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.常時の徘徊.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.常時の徘徊.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.常時の徘徊.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 外出して戻れないコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 外出して戻れない
     */
    public RString get外出して戻(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.外出して戻れない.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.外出して戻れない.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.外出して戻れない.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.外出して戻れない.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.外出して戻れない.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 被害的コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 被害的
     */
    public RString get被害的(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.被害的.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.被害的.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.被害的.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.被害的.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.被害的.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 作話コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 作話
     */
    public RString get作話(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.作話.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.作話.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.作話.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.作話.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.作話.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 感情が不安定コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 感情が不安定
     */
    public RString get感情が不安定(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.感情が不安定.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.感情が不安定.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.感情が不安定.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.感情が不安定.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.感情が不安定.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 昼夜逆転コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 昼夜逆転
     */
    public RString get昼夜逆転(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.昼夜逆転.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.昼夜逆転.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.昼夜逆転.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.昼夜逆転.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.昼夜逆転.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 同じ話をするコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 同じ話をする
     */
    public RString get同じ話をする(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.同じ話をする.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.同じ話をする.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.同じ話をする.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.同じ話をする.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.同じ話をする.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 大声をだすコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 大声をだす
     */
    public RString get大声を出す(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.大声をだす.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.大声をだす.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.大声をだす.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.大声を出す.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.大声を出す.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 介護に抵抗コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 介護に抵抗
     */
    public RString get介護に抵抗(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.介護に抵抗.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.介護に抵抗.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.介護に抵抗.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.介護に抵抗.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.介護に抵抗.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 落ち着きなしコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 落ち着きなし
     */
    public RString get落ち着きなし(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.落ち着きなし.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.落ち着きなし.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.落ち着きなし.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.落ち着きなし.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.落ち着きなし.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 一人で出たがるコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 一人で出たがる
     */
    public RString get一人で出たがる(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.一人で出たがる.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.一人で出たがる.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.一人で出たがる.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.一人で出たがる.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.一人で出たがる.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 収集癖コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 収集癖
     */
    public RString get収集癖(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.収集癖.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.収集癖.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.収集癖.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.収集癖.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.収集癖.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 物や衣類を壊すコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 物や衣類を壊す
     */
    public RString get物や衣類を壊す(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.物や衣類を壊す.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.物や衣類を壊す.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.物や衣類を壊す.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.物や衣類を壊す.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.物や衣類を壊す.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * ひどい物忘れコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return ひどい物忘れ
     */
    public RString getひどい物忘れ(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.ひどい物忘れ.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.ひどい物忘れ.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.ひどい物忘れ.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.ひどい物忘れ.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.ひどい物忘れ.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 独り言_独り笑いコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 独り言_独り笑い
     */
    public RString get独り言独り笑い(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.独り言_独り笑い.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.独り言_独り笑い.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 自分勝手に行動するコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 自分勝手に行動する
     */
    public RString get自分勝手(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.自分勝手に行動する.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.自分勝手に行動する.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 話がまとまらないコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 話がまとまらない
     */
    public RString get話がまとまらない(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.話がまとまらない.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.話がまとまらない.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 薬の内服コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 薬の内服
     */
    public RString get薬の内服(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.薬の内服.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.薬の内服.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.薬の内服.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.薬の内服.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.薬の内服.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 金銭の管理コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 金銭の管理
     */
    public RString get金銭の管理(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.金銭の管理.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.金銭の管理.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.金銭の管理.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.金銭の管理.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.金銭の管理.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 日常の意思決定コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 日常の意思決定
     */
    public RString get日常の意思決定(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.日常の意思決定.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.日常の意思決定.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 集団への不適応コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 集団への不適応
     */
    public RString get集団への不適応(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.集団への不適応.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.集団への不適応.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 買い物コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 買い物
     */
    public RString get買い物(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.買い物.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.買い物.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 簡単な調理コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 簡単な調理
     */
    public RString get簡単な調理(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_06.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.簡単な調理.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.簡単な調理.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 点滴の管理コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 点滴の管理
     */
    public RString get点滴の管理(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.点滴の管理.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.点滴の管理.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.点滴の管理.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.点滴の管理.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.点滴の管理.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 中心静脈栄養コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 中心静脈栄養
     */
    public RString get中心静脈栄養(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.中心静脈栄養.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.中心静脈栄養.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.中心静脈栄養.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.中心静脈栄養.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.中心静脈栄養.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 透析コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 透析
     */
    public RString get透析(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.透析.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.透析.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.透析.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.透析.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.透析.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * ストーマの処置コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return ストーマの処置
     */
    public RString getストーマの処置(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.ストーマの処置.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.ストーマの処置.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.ストーマの処置.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.ストーマの処置.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.ストーマの処置.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 酸素療法コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 酸素療法
     */
    public RString get酸素療法(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.酸素療法.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.酸素療法.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.酸素療法.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.酸素療法.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.酸素療法.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * レスピレーターコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return レスピレーター
     */
    public RString getレスピレーター(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.レスピレーター.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.レスピレーター.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.レスピレーター.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.レスピレーター.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.レスピレーター.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 気管切開の処置コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 気管切開の処置
     */
    public RString get気管切開の処置(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.気管切開の処置.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.気管切開の処置.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.気管切開の処置.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.気管切開の処置.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.気管切開の処置.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 疼痛の看護コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 疼痛の看護
     */
    public RString get疼痛の看護(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.疼痛の看護.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.疼痛の看護.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.疼痛の看護.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.疼痛の看護.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.疼痛の看護.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 経管栄養コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 経管栄養
     */
    public RString get経管栄養(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.経管栄養.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.経管栄養.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.経管栄養.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.経管栄養.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.経管栄養.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * モニター測定コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return モニター測定
     */
    public RString getモニター測定(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.モニター測定.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.モニター測定.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.モニター測定.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.モニター測定.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.モニター測定.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * じょくそうの処置コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return じょくそうの処置
     */
    public RString getじょくそうの処置(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.じょくそうの処置.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.じょくそうの処置.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.じょくそうの処置.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.じょくそうの処置.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.じょくそうの処置.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * カテーテルコードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return カテーテル
     */
    public RString getカテーテル(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping99A.カテーテル.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping02A.カテーテル.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping06A.カテーテル.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09A.カテーテル.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return NinteichosaKomokuMapping09B.カテーテル.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 日常生活自立度コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 日常生活自立度
     */
    public RString get日常生活自立度(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.認知症高齢者の日常生活自立度.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.認知症高齢者の日常生活自立度.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.認知症高齢者の日常生活自立度.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.認知症高齢者の日常生活自立度.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.認知症高齢者の日常生活自立度.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 短期記憶意見書コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 短期記憶意見書
     */
    public RString get短期記憶意見書(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.短期記憶.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.短期記憶.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.短期記憶.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.短期記憶.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.短期記憶.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 認知能力コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 認知能力
     */
    public RString get認知能力(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.認知能力.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.認知能力.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.認知能力.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.認知能力.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.認知能力.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 伝達能力コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 伝達能力
     */
    public RString get伝達能力(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return RString.EMPTY;
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.伝達能力.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.伝達能力.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.伝達能力.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.伝達能力.getコード();
        }
        return RString.EMPTY;
    }

    /**
     * 食事行為コードを取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 食事行為
     */
    public RString get食事行為(Code 厚労省IF識別コード) {
        if (A_99.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping99A.食事.getコード();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping02A.食事.getコード();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping06A.食事行為.getコード();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09A.食事行為.getコード();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return IkenshoKomokuMapping09B.食事行為.getコード();
        }
        return RString.EMPTY;
    }
}
