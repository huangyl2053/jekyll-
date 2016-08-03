/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk02A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk06A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk09A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk09B;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk99A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyoukflg.GaikyoChosahyouServiceJyoukFlg02A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyoukflg.GaikyoChosahyouServiceJyoukFlg06A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyoukflg.GaikyoChosahyouServiceJyoukFlg09A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyoukflg.GaikyoChosahyouServiceJyoukFlg09B;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyoukflg.GaikyoChosahyouServiceJyoukFlg99A;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku02A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku06A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.IsJutakuKaishu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

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
    private static final int 連番_1 = 1;
    private static final int 連番_2 = 2;
    private static final int 連番_3 = 3;
    private static final int 連番_4 = 4;
    private static final int 連番_5 = 5;
    private static final int 連番_6 = 6;
    private static final int 連番_7 = 7;
    private static final int 連番_8 = 8;
    private static final int 連番_9 = 9;
    private static final int 連番_10 = 10;
    private static final int 連番_11 = 11;
    private static final int 連番_12 = 12;
    private static final int 連番_13 = 13;
    private static final int 連番_14 = 14;
    private static final int 連番_15 = 15;
    private static final int 連番_16 = 16;
    private static final int 連番_17 = 17;
    private static final int 連番_18 = 18;
    private static final int 連番_19 = 19;
    private static final int 連番_20 = 20;
    private static final Code 予防給付サービス = new Code("1");
    private static final Code 介護給付サービス = new Code("2");
    private static final RString 単位 = new RString(":");
    private static final RString 特記事項有 = new RString("※");
//    private static final RString 施設名ファイル名 = new RString("C0004.png");
//    private static final RString 住所ファイル名 = new RString("C0005.png");
//    private static final RString 電話ファイル名 = new RString("C0006.png");

    /**
     * 特記リスト１を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査票_特記情報 認定調査票_特記情報
     * @return 特記リスト１
     */
    public List<RString> get特記リスト１(Code 厚労省IF識別コード,
            List<DbT5205NinteichosahyoTokkijikoEntity> 認定調査票_特記情報) {
        List<RString> 認定調査特記事項番号 = new ArrayList<>();
        List<RString> 特記事項有無 = new ArrayList<>();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 認定調査票_特記情報) {
            認定調査特記事項番号.add(entity.getNinteichosaTokkijikoNo());
        }
        if (認定調査特記事項番号.contains(get麻痺調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
            特記事項有無.add(特記事項有);
            特記事項有無.add(特記事項有);
            特記事項有無.add(特記事項有);
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
            特記事項有無.add(RString.EMPTY);
            特記事項有無.add(RString.EMPTY);
            特記事項有無.add(RString.EMPTY);
            特記事項有無.add(RString.EMPTY);
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get拘縮調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
            特記事項有無.add(特記事項有);
            特記事項有無.add(特記事項有);
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
            特記事項有無.add(RString.EMPTY);
            特記事項有無.add(RString.EMPTY);
            特記事項有無.add(RString.EMPTY);
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get寝返調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get起き上調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get座位保持調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get両足での立位調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get歩行調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get立ち上調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get片足での立位調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get洗身調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(getつめ切り調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get視力調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get聴力調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        return 特記事項有無;
    }

    /**
     * 特記リスト２を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査票_特記情報 認定調査票_特記情報
     * @return 特記リスト２
     */
    public List<RString> get特記リスト２(Code 厚労省IF識別コード,
            List<DbT5205NinteichosahyoTokkijikoEntity> 認定調査票_特記情報) {
        List<RString> 認定調査特記事項番号 = new ArrayList<>();
        List<RString> 特記事項有無 = new ArrayList<>();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 認定調査票_特記情報) {
            認定調査特記事項番号.add(entity.getNinteichosaTokkijikoNo());
        }
        if (認定調査特記事項番号.contains(get移乗調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get移動調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(getえん下調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get食事摂取調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get排尿調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get排便調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get口腔清潔調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get洗顔調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get整髪調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get上衣の着脱調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(getズボン等の着脱調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get外出頻度調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        return 特記事項有無;
    }

    /**
     * 特記リスト３を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査票_特記情報 認定調査票_特記情報
     * @return 特記リスト３
     */
    public List<RString> get特記リスト３(Code 厚労省IF識別コード,
            List<DbT5205NinteichosahyoTokkijikoEntity> 認定調査票_特記情報) {
        List<RString> 認定調査特記事項番号 = new ArrayList<>();
        List<RString> 特記事項有無 = new ArrayList<>();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 認定調査票_特記情報) {
            認定調査特記事項番号.add(entity.getNinteichosaTokkijikoNo());
        }
        if (認定調査特記事項番号.contains(get意思の伝達調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get毎日の日課を理解調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get生年月日調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get短期記憶調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get自分の名前調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get今の季節を理解調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get場所の理解調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get徘徊調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get外出して戻調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        return 特記事項有無;
    }

    /**
     * 特記リスト４を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査票_特記情報 認定調査票_特記情報
     * @return 特記リスト４
     */
    public List<RString> get特記リスト４(Code 厚労省IF識別コード,
            List<DbT5205NinteichosahyoTokkijikoEntity> 認定調査票_特記情報) {
        List<RString> 認定調査特記事項番号 = new ArrayList<>();
        List<RString> 特記事項有無 = new ArrayList<>();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 認定調査票_特記情報) {
            認定調査特記事項番号.add(entity.getNinteichosaTokkijikoNo());
        }
        if (認定調査特記事項番号.contains(get被害的調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get作話調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get感情が不安定調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get昼夜逆転調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get同じ話をする調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get大声を出す調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get介護に抵抗調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get落ち着きなし調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get一人で出たがる調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get収集癖調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get物や衣類を壊す調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(getひどい物忘れ調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get独り言独り笑い調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get自分勝手調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get話がまとまらない調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        return 特記事項有無;
    }

    /**
     * 特記リスト５を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査票_特記情報 認定調査票_特記情報
     * @return 特記リスト５
     */
    public List<RString> get特記リスト５(Code 厚労省IF識別コード,
            List<DbT5205NinteichosahyoTokkijikoEntity> 認定調査票_特記情報) {
        List<RString> 認定調査特記事項番号 = new ArrayList<>();
        List<RString> 特記事項有無 = new ArrayList<>();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 認定調査票_特記情報) {
            認定調査特記事項番号.add(entity.getNinteichosaTokkijikoNo());
        }
        if (認定調査特記事項番号.contains(get薬の内服調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get金銭の管理調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get日常の意思決定調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get集団への不適応調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get買い物調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get簡単な調理調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        return 特記事項有無;
    }

    /**
     * 特記リスト６を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査票_特記情報 認定調査票_特記情報
     * @return 特記リスト６
     */
    public List<RString> get特記リスト６(Code 厚労省IF識別コード,
            List<DbT5205NinteichosahyoTokkijikoEntity> 認定調査票_特記情報) {
        List<RString> 認定調査特記事項番号 = new ArrayList<>();
        List<RString> 特記事項有無 = new ArrayList<>();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 認定調査票_特記情報) {
            認定調査特記事項番号.add(entity.getNinteichosaTokkijikoNo());
        }
        if (認定調査特記事項番号.contains(get点滴の管理調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get中心静脈栄養調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get透析調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(getストーマの処置調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get酸素療法調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(getレスピレーター調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        return 特記事項有無;
    }

    /**
     * 特記リスト７を取得します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 認定調査票_特記情報 認定調査票_特記情報
     * @return 特記リスト７
     */
    public List<RString> get特記リスト７(Code 厚労省IF識別コード,
            List<DbT5205NinteichosahyoTokkijikoEntity> 認定調査票_特記情報) {
        List<RString> 認定調査特記事項番号 = new ArrayList<>();
        List<RString> 特記事項有無 = new ArrayList<>();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 認定調査票_特記情報) {
            認定調査特記事項番号.add(entity.getNinteichosaTokkijikoNo());
        }
        if (認定調査特記事項番号.contains(get気管切開の処置調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get疼痛の看護調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(get経管栄養調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(getモニター測定調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(getじょくそうの処置調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        if (認定調査特記事項番号.contains(getカテーテル調査特記事項番号(厚労省IF識別コード))) {
            特記事項有無.add(特記事項有);
        } else {
            特記事項有無.add(RString.EMPTY);
        }
        return 特記事項有無;
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

    /**
     * サービスの状況を設定します。
     *
     * @param entity ItiziHanteiEntity
     * @param 項目 IchijihanteikekkahyoA4Entity
     * @param 予防給付 予防給付
     * @param 介護給付 介護給付
     * @param サービス状況フラグ サービス状況フラグ
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 共通情報 ShinsakaiSiryoKyotsuEntity
     */
    public void setサービスの状況(ItiziHanteiEntity entity, IchijihanteikekkahyoA3Entity 項目,
            List<DbT5207NinteichosahyoServiceJokyoEntity> 予防給付, List<DbT5207NinteichosahyoServiceJokyoEntity> 介護給付,
            DbT5208NinteichosahyoServiceJokyoFlagEntity サービス状況フラグ, Code 厚労省IF識別コード, ShinsakaiSiryoKyotsuEntity 共通情報) {
        RStringBuilder builder;
        if (予防給付サービス.equals(entity.getServiceKubunCode())) {
            項目.setSabisuKubun(new RString("予防給付・総合事業"));
            for (DbT5207NinteichosahyoServiceJokyoEntity dbt5207Entity : 予防給付) {
                switch (dbt5207Entity.getRemban()) {
                    case 連番_1:
                        builder = new RStringBuilder();
                        項目.setSabisuName1(get帳票上の文言(厚労省IF識別コード, new RString(連番_1)));
                        項目.setSabisuKaisu1(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_1)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_1))).toRString());
                        項目.setSabisuName13(get帳票上の文言状況フラグ(厚労省IF識別コード, new RString(連番_1)));
                        項目.setSabisuKaisu13(IsJutakuKaishu.toValue(サービス状況フラグ.getServiceJokyoFlag()).get名称());
                        break;
                    case 連番_2:
                        builder = new RStringBuilder();
                        項目.setSabisuName2(get帳票上の文言(厚労省IF識別コード, new RString(連番_2)));
                        項目.setSabisuKaisu2(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_2)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_2))).toRString());
                        break;
                    case 連番_3:
                        builder = new RStringBuilder();
                        項目.setSabisuName3(get帳票上の文言(厚労省IF識別コード, new RString(連番_3)));
                        項目.setSabisuKaisu3(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_3)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_3))).toRString());
                        break;
                    case 連番_4:
                        builder = new RStringBuilder();
                        項目.setSabisuName4(get帳票上の文言(厚労省IF識別コード, new RString(連番_4)));
                        項目.setSabisuKaisu4(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_4)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_4))).toRString());
                        break;
                    case 連番_5:
                        builder = new RStringBuilder();
                        項目.setSabisuName5(get帳票上の文言(厚労省IF識別コード, new RString(連番_5)));
                        項目.setSabisuKaisu5(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_5)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_5))).toRString());
                        break;
                    case 連番_6:
                        builder = new RStringBuilder();
                        項目.setSabisuName6(get帳票上の文言(厚労省IF識別コード, new RString(連番_6)));
                        項目.setSabisuKaisu6(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_6)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_6))).toRString());
                        break;
                    case 連番_7:
                        builder = new RStringBuilder();
                        項目.setSabisuName7(get帳票上の文言(厚労省IF識別コード, new RString(連番_7)));
                        項目.setSabisuKaisu7(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_7)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_7))).toRString());
                        break;
                    default:
                        予防給付サービスの状況(dbt5207Entity, 項目, 厚労省IF識別コード);
                        break;
                }
            }
//            setサービス(項目, 共通情報);
        } else if (介護給付サービス.equals(entity.getServiceKubunCode())) {
            項目.setSabisuKubun(new RString("介護給付"));
            for (DbT5207NinteichosahyoServiceJokyoEntity dbt5207Entity : 介護給付) {
                switch (dbt5207Entity.getRemban()) {
                    case 連番_1:
                        builder = new RStringBuilder();
                        項目.setSabisuName1(get帳票上の文言(厚労省IF識別コード, new RString(連番_1)));
                        項目.setSabisuKaisu1(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_1)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_1))).toRString());
                        項目.setSabisuName13(get帳票上の文言状況フラグ(厚労省IF識別コード, new RString(連番_1)));
                        項目.setSabisuKaisu13(IsJutakuKaishu.toValue(サービス状況フラグ.getServiceJokyoFlag()).get名称());
                        break;
                    case 連番_2:
                        builder = new RStringBuilder();
                        項目.setSabisuName2(get帳票上の文言(厚労省IF識別コード, new RString(連番_2)));
                        項目.setSabisuKaisu2(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_2)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_2))).toRString());
                        break;
                    case 連番_3:
                        builder = new RStringBuilder();
                        項目.setSabisuName3(get帳票上の文言(厚労省IF識別コード, new RString(連番_3)));
                        項目.setSabisuKaisu3(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_3)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_3))).toRString());
                        break;
                    case 連番_4:
                        builder = new RStringBuilder();
                        項目.setSabisuName4(get帳票上の文言(厚労省IF識別コード, new RString(連番_4)));
                        項目.setSabisuKaisu4(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_4)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_4))).toRString());
                        break;
                    case 連番_5:
                        builder = new RStringBuilder();
                        項目.setSabisuName5(get帳票上の文言(厚労省IF識別コード, new RString(連番_5)));
                        項目.setSabisuKaisu5(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_5)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_5))).toRString());
                        break;
                    case 連番_6:
                        builder = new RStringBuilder();
                        項目.setSabisuName6(get帳票上の文言(厚労省IF識別コード, new RString(連番_6)));
                        項目.setSabisuKaisu6(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_6)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_6))).toRString());
                        break;
                    case 連番_7:
                        builder = new RStringBuilder();
                        項目.setSabisuName7(get帳票上の文言(厚労省IF識別コード, new RString(連番_7)));
                        項目.setSabisuKaisu7(builder.append(単位)
                                .append(dbt5207Entity.getServiceJokyo())
                                .append(get単位1(厚労省IF識別コード, new RString(連番_7)))
                                .append(get単位2(厚労省IF識別コード, new RString(連番_7))).toRString());
                        break;

                    default:
                        介護給付サービスの状況(dbt5207Entity, 項目, 厚労省IF識別コード);
                        break;
                }
            }
//            setサービス(項目, 共通情報);
        } else {
            項目.setSabisuKubun(new RString("なし"));
//            setサービス(項目, null);
        }
    }

    private void 予防給付サービスの状況(DbT5207NinteichosahyoServiceJokyoEntity dbt5207Entity,
            IchijihanteikekkahyoA3Entity 項目,
            Code 厚労省IF識別コード) {
        RStringBuilder builder;
        switch (dbt5207Entity.getRemban()) {
            case 連番_8:
                builder = new RStringBuilder();
                項目.setSabisuName8(get帳票上の文言(厚労省IF識別コード, new RString(連番_8)));
                項目.setSabisuKaisu8(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_8)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_8))).toRString());
                break;
            case 連番_9:
                builder = new RStringBuilder();
                項目.setSabisuName9(get帳票上の文言(厚労省IF識別コード, new RString(連番_9)));
                項目.setSabisuKaisu9(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_9)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_9))).toRString());
                break;
            case 連番_10:
                builder = new RStringBuilder();
                項目.setSabisuName10(get帳票上の文言(厚労省IF識別コード, new RString(連番_10)));
                項目.setSabisuKaisu10(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_10)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_10))).toRString());
                break;
            case 連番_11:
                builder = new RStringBuilder();
                項目.setSabisuName11(get帳票上の文言(厚労省IF識別コード, new RString(連番_11)));
                項目.setSabisuKaisu11(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_11))).toRString());
                break;
            case 連番_12:
                builder = new RStringBuilder();
                項目.setSabisuName12(get帳票上の文言(厚労省IF識別コード, new RString(連番_12)));
                項目.setSabisuKaisu12(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_12)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_12))).toRString());
                break;
            case 連番_14:
                builder = new RStringBuilder();
                項目.setSabisuName14(get帳票上の文言(厚労省IF識別コード, new RString(連番_14)));
                項目.setSabisuKaisu14(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_14)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_14))).toRString());
                break;
            case 連番_15:
                builder = new RStringBuilder();
                項目.setSabisuName15(get帳票上の文言(厚労省IF識別コード, new RString(連番_15)));
                項目.setSabisuKaisu15(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_15)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_15))).toRString());
                break;
            case 連番_16:
                builder = new RStringBuilder();
                項目.setSabisuName16(get帳票上の文言(厚労省IF識別コード, new RString(連番_16)));
                項目.setSabisuKaisu16(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_16)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_16))).toRString());
                break;
            default:
                項目.setSabisuName17(RString.EMPTY);
                項目.setSabisuKaisu17(RString.EMPTY);
                項目.setSabisuName18(RString.EMPTY);
                項目.setSabisuKaisu18(RString.EMPTY);
                項目.setSabisuName19(RString.EMPTY);
                項目.setSabisuKaisu19(RString.EMPTY);
                項目.setSabisuName20(RString.EMPTY);
                項目.setSabisuKaisu20(RString.EMPTY);
                項目.setSabisuName21(RString.EMPTY);
                項目.setSabisuKaisu21(RString.EMPTY);
                break;

        }
    }

    private void 介護給付サービスの状況(DbT5207NinteichosahyoServiceJokyoEntity dbt5207Entity,
            IchijihanteikekkahyoA3Entity 項目,
            Code 厚労省IF識別コード) {
        RStringBuilder builder;
        switch (dbt5207Entity.getRemban()) {
            case 連番_8:
                builder = new RStringBuilder();
                項目.setSabisuName8(get帳票上の文言(厚労省IF識別コード, new RString(連番_8)));
                項目.setSabisuKaisu8(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_8)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_8))).toRString());
                break;
            case 連番_9:
                builder = new RStringBuilder();
                項目.setSabisuName9(get帳票上の文言(厚労省IF識別コード, new RString(連番_9)));
                項目.setSabisuKaisu9(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_9)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_9))).toRString());
                break;
            case 連番_10:
                builder = new RStringBuilder();
                項目.setSabisuName10(get帳票上の文言(厚労省IF識別コード, new RString(連番_10)));
                項目.setSabisuKaisu10(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_10)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_10))).toRString());
                break;
            case 連番_11:
                builder = new RStringBuilder();
                項目.setSabisuName11(get帳票上の文言(厚労省IF識別コード, new RString(連番_11)));
                項目.setSabisuKaisu11(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_11))).toRString());
                break;
            case 連番_12:
                builder = new RStringBuilder();
                項目.setSabisuName12(get帳票上の文言(厚労省IF識別コード, new RString(連番_12)));
                項目.setSabisuKaisu12(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_12)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_12))).toRString());
                break;
            case 連番_13:
                builder = new RStringBuilder();
                項目.setSabisuName14(get帳票上の文言(厚労省IF識別コード, new RString(連番_13)));
                項目.setSabisuKaisu14(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_13)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_13))).toRString());
                break;
            case 連番_14:
                builder = new RStringBuilder();
                項目.setSabisuName15(get帳票上の文言(厚労省IF識別コード, new RString(連番_14)));
                項目.setSabisuKaisu15(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_14)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_14))).toRString());
                break;
            case 連番_15:
                builder = new RStringBuilder();
                項目.setSabisuName16(get帳票上の文言(厚労省IF識別コード, new RString(連番_15)));
                項目.setSabisuKaisu16(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_15)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_15))).toRString());
                break;
            case 連番_16:
                builder = new RStringBuilder();
                項目.setSabisuName17(get帳票上の文言(厚労省IF識別コード, new RString(連番_16)));
                項目.setSabisuKaisu17(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_16)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_16))).toRString());
                break;
            case 連番_17:
                builder = new RStringBuilder();
                項目.setSabisuName18(get帳票上の文言(厚労省IF識別コード, new RString(連番_17)));
                項目.setSabisuKaisu18(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_17)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_17))).toRString());
                break;
            case 連番_18:
                builder = new RStringBuilder();
                項目.setSabisuName19(get帳票上の文言(厚労省IF識別コード, new RString(連番_18)));
                項目.setSabisuKaisu19(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_18)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_18))).toRString());
                break;
            case 連番_19:
                builder = new RStringBuilder();
                項目.setSabisuName20(get帳票上の文言(厚労省IF識別コード, new RString(連番_19)));
                項目.setSabisuKaisu20(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_19)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_19))).toRString());
                break;
            case 連番_20:
                builder = new RStringBuilder();
                項目.setSabisuName21(get帳票上の文言(厚労省IF識別コード, new RString(連番_20)));
                項目.setSabisuKaisu21(builder.append(単位)
                        .append(dbt5207Entity.getServiceJokyo())
                        .append(get単位1(厚労省IF識別コード, new RString(連番_20)))
                        .append(get単位2(厚労省IF識別コード, new RString(連番_20))).toRString());
                break;
            default:
                break;
        }
    }

    private RString get帳票上の文言(Code 厚労省IF識別コード, RString 連番) {
        if (A_99.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk99A.toValue(連番).get名称();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk06A.toValue(連番).get名称();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk02A.toValue(連番).get名称();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk09A.toValue(連番).get名称();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk09B.toValue(連番).get名称();
        }
        return RString.EMPTY;
    }

    private RString get帳票上の文言状況フラグ(Code 厚労省IF識別コード, RString 連番) {
        if (A_99.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyoukFlg99A.toValue(連番).get名称();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyoukFlg06A.toValue(連番).get名称();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyoukFlg02A.toValue(連番).get名称();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyoukFlg09A.toValue(連番).get名称();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyoukFlg09B.toValue(連番).get名称();
        }
        return RString.EMPTY;
    }

    private RString get単位1(Code 厚労省IF識別コード, RString 連番) {
        if (A_99.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk99A.toValue(連番).get単位1();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk06A.toValue(連番).get単位1();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk02A.toValue(連番).get単位1();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk09A.toValue(連番).get単位1();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk09B.toValue(連番).get単位1();
        }
        return RString.EMPTY;
    }

    private RString get単位2(Code 厚労省IF識別コード, RString 連番) {
        if (A_99.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk99A.toValue(連番).get単位2();
        } else if (A_06.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk06A.toValue(連番).get単位2();
        } else if (A_02.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk02A.toValue(連番).get単位2();
        } else if (A_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk09A.toValue(連番).get単位2();
        } else if (B_09.equals(厚労省IF識別コード)) {
            return GaikyoChosahyouServiceJyouk09B.toValue(連番).get単位2();
        }
        return RString.EMPTY;
    }

//    private void setサービス(IchijihanteikekkahyoA3Entity 項目, ShinsakaiSiryoKyotsuEntity 共通情報) {
//        if (共通情報 == null) {
//            項目.set施設名テキスト(RString.EMPTY);
//            項目.set施設名イメージ(RString.EMPTY);
//            項目.set住所テキスト(RString.EMPTY);
//            項目.set住所イメージ(RString.EMPTY);
//            項目.set電話番号テキスト(RString.EMPTY);
//            項目.set電話番号イメージ(RString.EMPTY);
//        } else {
//            if (!RString.isNullOrEmpty(共通情報.getRiyoShisetsuShimei())) {
//                項目.set施設名テキスト(共通情報.getRiyoShisetsuShimei());
//            } else {
//                項目.set施設名イメージ(共有ファイルを引き出す(共通情報.getImageSharedFileId(), 施設名ファイル名));
//            }
//            if (!RString.isNullOrEmpty(共通情報.getRiyoShisetsuJusho())) {
//                項目.set住所テキスト(共通情報.getRiyoShisetsuJusho());
//            } else {
//                項目.set住所イメージ(共有ファイルを引き出す(共通情報.getImageSharedFileId(), 住所ファイル名));
//            }
//            if (!RString.isNullOrEmpty(共通情報.getRiyoShisetsuTelNo())) {
//                項目.set電話番号テキスト(共通情報.getRiyoShisetsuTelNo());
//            } else {
//                項目.set電話番号イメージ(共有ファイルを引き出す(共通情報.getImageSharedFileId(), 電話ファイル名));
//            }
//        }
//    }
}
