/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TiyosaKekka;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser07;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局一次判定結果票のEntityの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class IchijihanteikekkahyoKekka {

    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_9 = 9;
    private static final int INT_12 = 12;
    private static final int INT_15 = 15;
    private static final int INT_20 = 20;
    private static final RString 段階悪化 = new RString("▲");
    private static final RString 段階改善 = new RString("▽");

    /**
     * 麻痺今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第１群 第１群
     */
    public void set麻痺今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if (ChosaAnser01.あり.getコード().equals(今回結果コード) && ChosaAnser01.なし.getコード().equals(前回調査結果コード)) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if (ChosaAnser01.あり.getコード().equals(前回調査結果コード) && ChosaAnser01.なし.getコード().equals(今回結果コード)) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 寝返起き上今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第１群 第１群
     */
    public void set寝返起き上今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser02.できない.getコード().equals(今回結果コード) && (ChosaAnser02.つかまらないでできる.getコード().equals(前回調査結果コード)
                || ChosaAnser02.何かにつかまればできる.getコード().equals(前回調査結果コード))) || (ChosaAnser02.何かにつかまればできる.getコード().equals(今回結果コード)
                && ChosaAnser02.つかまらないでできる.getコード().equals(前回調査結果コード))) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser02.できない.getコード().equals(前回調査結果コード) && (ChosaAnser02.つかまらないでできる.getコード().equals(今回結果コード)
                || ChosaAnser02.何かにつかまればできる.getコード().equals(今回結果コード))) || (ChosaAnser02.何かにつかまればできる.getコード().equals(前回調査結果コード)
                && ChosaAnser02.つかまらないでできる.getコード().equals(今回結果コード))) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 座位保持今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第１群 第１群
     */
    public void set座位保持今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser03.できない.getコード().equals(今回結果コード) && (ChosaAnser03.支えが必要.getコード().equals(前回調査結果コード)
                || ChosaAnser03.自分で支えれば可.getコード().equals(前回調査結果コード) || ChosaAnser03.できる.getコード().equals(前回調査結果コード)))
                || (ChosaAnser03.支えが必要.getコード().equals(今回結果コード) && (ChosaAnser03.自分で支えれば可.getコード().equals(前回調査結果コード)
                || ChosaAnser03.できる.getコード().equals(前回調査結果コード))) || (ChosaAnser03.自分で支えれば可.getコード().equals(今回結果コード)
                && ChosaAnser03.できる.getコード().equals(前回調査結果コード))) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser03.できない.getコード().equals(前回調査結果コード) && (ChosaAnser03.支えが必要.getコード().equals(今回結果コード)
                || ChosaAnser03.自分で支えれば可.getコード().equals(今回結果コード) || ChosaAnser03.できる.getコード().equals(今回結果コード)))
                || (ChosaAnser03.支えが必要.getコード().equals(前回調査結果コード) && (ChosaAnser03.自分で支えれば可.getコード().equals(今回結果コード)
                || ChosaAnser03.できる.getコード().equals(今回結果コード))) || (ChosaAnser03.自分で支えれば可.getコード().equals(前回調査結果コード)
                && ChosaAnser03.できる.getコード().equals(今回結果コード))) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 両足での立位今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第１群 第１群
     */
    public void set両足での立位今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser04.できない.getコード().equals(今回結果コード) && (ChosaAnser04.何か支えがあればできる.getコード().equals(前回調査結果コード)
                || ChosaAnser04.支えなしでできる.getコード().equals(前回調査結果コード))) || (ChosaAnser04.何か支えがあればできる.getコード().equals(今回結果コード)
                && ChosaAnser04.支えなしでできる.getコード().equals(前回調査結果コード))) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser04.できない.getコード().equals(前回調査結果コード) && (ChosaAnser04.何か支えがあればできる.getコード().equals(今回結果コード)
                || ChosaAnser04.支えなしでできる.getコード().equals(今回結果コード))) || (ChosaAnser04.何か支えがあればできる.getコード().equals(前回調査結果コード)
                && ChosaAnser04.支えなしでできる.getコード().equals(今回結果コード))) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 洗身今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第１群 第１群
     */
    public void set洗身今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser06.行っていない.getコード().equals(今回結果コード) && (ChosaAnser06.全介助.getコード().equals(前回調査結果コード)
                || ChosaAnser06.一部介助.getコード().equals(前回調査結果コード) || ChosaAnser06.介助されていない.getコード().equals(前回調査結果コード)))
                || (ChosaAnser06.全介助.getコード().equals(今回結果コード) && (ChosaAnser06.一部介助.getコード().equals(前回調査結果コード)
                || ChosaAnser06.介助されていない.getコード().equals(前回調査結果コード))) || (ChosaAnser06.一部介助.getコード().equals(今回結果コード)
                && ChosaAnser06.介助されていない.getコード().equals(前回調査結果コード))) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser06.行っていない.getコード().equals(前回調査結果コード) && (ChosaAnser06.全介助.getコード().equals(今回結果コード)
                || ChosaAnser06.一部介助.getコード().equals(今回結果コード) || ChosaAnser06.介助されていない.getコード().equals(今回結果コード)))
                || (ChosaAnser06.全介助.getコード().equals(前回調査結果コード) && (ChosaAnser06.一部介助.getコード().equals(今回結果コード)
                || ChosaAnser06.介助されていない.getコード().equals(今回結果コード))) || (ChosaAnser06.一部介助.getコード().equals(前回調査結果コード)
                && ChosaAnser06.介助されていない.getコード().equals(今回結果コード))) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * つめ切り今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第１群 第１群
     */
    public void setつめ切り今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser07.全介助.getコード().equals(今回結果コード) && (ChosaAnser07.一部介助.getコード().equals(前回調査結果コード)
                || ChosaAnser07.介助されていない.getコード().equals(前回調査結果コード))) || (ChosaAnser07.一部介助.getコード().equals(今回結果コード)
                && ChosaAnser07.介助されていない.getコード().equals(前回調査結果コード))) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser07.全介助.getコード().equals(前回調査結果コード) && (ChosaAnser07.一部介助.getコード().equals(今回結果コード)
                || ChosaAnser07.介助されていない.getコード().equals(今回結果コード))) || (ChosaAnser07.一部介助.getコード().equals(前回調査結果コード)
                && ChosaAnser07.介助されていない.getコード().equals(今回結果コード))) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 視力今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第１群 第１群
     */
    public void set視力今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser08.見えているのか判断不能.getコード().equals(今回結果コード) && (ChosaAnser08.ほとんど見えない.getコード().equals(前回調査結果コード)
                || ChosaAnser08.目の前に置いた視力確認表の図が見える.getコード().equals(前回調査結果コード) || ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(前回調査結果コード)
                || ChosaAnser08.普通_日常生活に支障がない.getコード().equals(前回調査結果コード))) || is視力今回前回結果比１(今回結果コード, 前回調査結果コード)) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser08.見えているのか判断不能.getコード().equals(前回調査結果コード) && (ChosaAnser08.ほとんど見えない.getコード().equals(今回結果コード)
                || ChosaAnser08.目の前に置いた視力確認表の図が見える.getコード().equals(今回結果コード) || ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(今回結果コード)
                || ChosaAnser08.普通_日常生活に支障がない.getコード().equals(今回結果コード))) || is視力前回今回結果比１(今回結果コード, 前回調査結果コード)) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    private boolean is視力今回前回結果比１(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is今回前回結果 = false;
        if ((ChosaAnser08.ほとんど見えない.getコード().equals(今回結果コード) && (ChosaAnser08.目の前に置いた視力確認表の図が見える.getコード().equals(前回調査結果コード)
                || ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(前回調査結果コード) || ChosaAnser08.普通_日常生活に支障がない.getコード().equals(前回調査結果コード)))
                || (ChosaAnser08.目の前に置いた視力確認表の図が見える.getコード().equals(今回結果コード)
                && (ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(前回調査結果コード) || ChosaAnser08.普通_日常生活に支障がない.getコード().equals(前回調査結果コード)))
                || (ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(今回結果コード) && ChosaAnser08.普通_日常生活に支障がない.getコード().equals(前回調査結果コード))) {
            is今回前回結果 = true;
        }
        return is今回前回結果;
    }

    private boolean is視力前回今回結果比１(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is前回今回結果 = false;
        if ((ChosaAnser08.ほとんど見えない.getコード().equals(前回調査結果コード) && (ChosaAnser08.目の前に置いた視力確認表の図が見える.getコード().equals(今回結果コード)
                || ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(今回結果コード) || ChosaAnser08.普通_日常生活に支障がない.getコード().equals(今回結果コード)))
                || (ChosaAnser08.目の前に置いた視力確認表の図が見える.getコード().equals(前回調査結果コード) && (ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(今回結果コード)
                || ChosaAnser08.普通_日常生活に支障がない.getコード().equals(今回結果コード))) || (ChosaAnser08.約1ｍ離れた視力確認表の図が見える.getコード().equals(前回調査結果コード)
                && ChosaAnser08.普通_日常生活に支障がない.getコード().equals(今回結果コード))) {
            is前回今回結果 = true;
        }
        return is前回今回結果;
    }

    /**
     * 聴力今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第１群 第１群
     */
    public void set聴力今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第１群) {
        if ((ChosaAnser09.聞こえているのか判断不能.getコード().equals(今回結果コード) && (ChosaAnser09.ほとんど聞こえない.getコード().equals(前回調査結果コード)
                || ChosaAnser09.かなり大きな声なら何とか聞き取れる.getコード().equals(前回調査結果コード) || ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(前回調査結果コード)
                || ChosaAnser09.普通.getコード().equals(前回調査結果コード))) || is聴力今回前回結果比１(今回結果コード, 前回調査結果コード)) {
            第１群.set段階改善フラグ(段階悪化);
            第１群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser09.聞こえているのか判断不能.getコード().equals(前回調査結果コード) && (ChosaAnser09.ほとんど聞こえない.getコード().equals(今回結果コード)
                || ChosaAnser09.かなり大きな声なら何とか聞き取れる.getコード().equals(今回結果コード) || ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(今回結果コード)
                || ChosaAnser09.普通.getコード().equals(今回結果コード))) || is聴力前回今回結果比１(今回結果コード, 前回調査結果コード)) {
            第１群.set段階改善フラグ(段階改善);
            第１群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第１群.set段階改善フラグ(RString.EMPTY);
            第１群.set段階改善値(RString.EMPTY);
        }
    }

    private boolean is聴力今回前回結果比１(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is今回前回結果 = false;
        if ((ChosaAnser09.ほとんど聞こえない.getコード().equals(今回結果コード) && (ChosaAnser09.かなり大きな声なら何とか聞き取れる.getコード().equals(前回調査結果コード)
                || ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(前回調査結果コード) || ChosaAnser09.普通.getコード().equals(前回調査結果コード)))
                || (ChosaAnser09.かなり大きな声なら何とか聞き取れる.getコード().equals(今回結果コード) && (ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(前回調査結果コード)
                || ChosaAnser09.普通.getコード().equals(前回調査結果コード))) || (ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(今回結果コード)
                && ChosaAnser09.普通.getコード().equals(前回調査結果コード))) {
            is今回前回結果 = true;
        }
        return is今回前回結果;
    }

    private boolean is聴力前回今回結果比１(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is前回今回結果 = false;
        if ((ChosaAnser09.ほとんど聞こえない.getコード().equals(前回調査結果コード) && (ChosaAnser09.かなり大きな声なら何とか聞き取れる.getコード().equals(今回結果コード)
                || ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(今回結果コード) || ChosaAnser09.普通.getコード().equals(今回結果コード)))
                || (ChosaAnser09.かなり大きな声なら何とか聞き取れる.getコード().equals(前回調査結果コード) && (ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(今回結果コード)
                || ChosaAnser09.普通.getコード().equals(今回結果コード))) || (ChosaAnser09.普通の声がやっと聞き取れる.getコード().equals(前回調査結果コード)
                && ChosaAnser09.普通.getコード().equals(今回結果コード))) {
            is前回今回結果 = true;
        }
        return is前回今回結果;
    }

    /**
     * 移乗今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第２群 第２群
     */
    public void set移乗今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((ChosaAnser10.全介助.getコード().equals(今回結果コード) && (ChosaAnser10.一部介助.getコード().equals(前回調査結果コード)
                || ChosaAnser10.見守り等.getコード().equals(前回調査結果コード) || ChosaAnser10.介助されていない.getコード().equals(前回調査結果コード)))
                || (ChosaAnser10.一部介助.getコード().equals(今回結果コード) && (ChosaAnser10.見守り等.getコード().equals(前回調査結果コード)
                || ChosaAnser10.介助されていない.getコード().equals(前回調査結果コード))) || (ChosaAnser10.見守り等.getコード().equals(今回結果コード)
                && ChosaAnser10.介助されていない.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser10.全介助.getコード().equals(前回調査結果コード) && (ChosaAnser10.一部介助.getコード().equals(今回結果コード)
                || ChosaAnser10.見守り等.getコード().equals(今回結果コード) || ChosaAnser10.介助されていない.getコード().equals(今回結果コード)))
                || (ChosaAnser10.一部介助.getコード().equals(前回調査結果コード) && (ChosaAnser10.見守り等.getコード().equals(今回結果コード)
                || ChosaAnser10.介助されていない.getコード().equals(今回結果コード))) || (ChosaAnser10.見守り等.getコード().equals(前回調査結果コード)
                && ChosaAnser10.介助されていない.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * えん下今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第２群 第２群
     */
    public void setえん下今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((ChosaAnser11.できない.getコード().equals(今回結果コード) && (ChosaAnser11.見守り等.getコード().equals(前回調査結果コード)
                || ChosaAnser11.できる.getコード().equals(前回調査結果コード))) || (ChosaAnser11.見守り等.getコード().equals(今回結果コード)
                && ChosaAnser11.できる.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser11.できない.getコード().equals(前回調査結果コード) && (ChosaAnser11.見守り等.getコード().equals(今回結果コード)
                || ChosaAnser11.できる.getコード().equals(今回結果コード))) || (ChosaAnser11.見守り等.getコード().equals(前回調査結果コード)
                && ChosaAnser11.できる.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 口腔清潔今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第２群 第２群
     */
    public void set口腔清潔今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((ChosaAnser12.全介助.getコード().equals(今回結果コード) && (ChosaAnser12.一部介助.getコード().equals(前回調査結果コード)
                || ChosaAnser12.介助されていない.getコード().equals(前回調査結果コード))) || (ChosaAnser12.一部介助.getコード().equals(今回結果コード)
                && ChosaAnser12.介助されていない.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser12.全介助.getコード().equals(前回調査結果コード) && (ChosaAnser12.一部介助.getコード().equals(今回結果コード)
                || ChosaAnser12.介助されていない.getコード().equals(今回結果コード))) || (ChosaAnser12.一部介助.getコード().equals(前回調査結果コード)
                && ChosaAnser12.介助されていない.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 外出頻度今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第２群 第２群
     */
    public void set外出頻度今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((ChosaAnser13.月1回未満.getコード().equals(今回結果コード) && (ChosaAnser13.月1回以上.getコード().equals(前回調査結果コード)
                || ChosaAnser13.週1回以上.getコード().equals(前回調査結果コード))) || (ChosaAnser13.月1回以上.getコード().equals(今回結果コード)
                && ChosaAnser13.週1回以上.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser13.月1回未満.getコード().equals(前回調査結果コード) && (ChosaAnser13.月1回以上.getコード().equals(今回結果コード)
                || ChosaAnser13.週1回以上.getコード().equals(今回結果コード))) || (ChosaAnser13.月1回以上.getコード().equals(前回調査結果コード)
                && ChosaAnser13.週1回以上.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 意思の伝達今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第３群 第３群
     */
    public void set意思の伝達今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第３群) {
        if ((ChosaAnser14.できない.getコード().equals(今回結果コード) && (ChosaAnser14.ほとんど伝達できない.getコード().equals(前回調査結果コード)
                || ChosaAnser14.ときどき伝達できる.getコード().equals(前回調査結果コード) || ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(前回調査結果コード)))
                || (ChosaAnser14.ほとんど伝達できない.getコード().equals(今回結果コード) && (ChosaAnser14.ときどき伝達できる.getコード().equals(前回調査結果コード)
                || ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(前回調査結果コード))) || (ChosaAnser14.ときどき伝達できる.getコード().equals(今回結果コード)
                && ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(前回調査結果コード))) {
            第３群.set段階改善フラグ(段階悪化);
            第３群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser14.できない.getコード().equals(前回調査結果コード) && (ChosaAnser14.ほとんど伝達できない.getコード().equals(今回結果コード)
                || ChosaAnser14.ときどき伝達できる.getコード().equals(今回結果コード) || ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(今回結果コード)))
                || (ChosaAnser14.ほとんど伝達できない.getコード().equals(前回調査結果コード) && (ChosaAnser14.ときどき伝達できる.getコード().equals(今回結果コード)
                || ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(今回結果コード))) || (ChosaAnser14.ときどき伝達できる.getコード().equals(前回調査結果コード)
                && ChosaAnser14.調査対象者が意思を他者に伝達できる.getコード().equals(今回結果コード))) {
            第３群.set段階改善フラグ(段階改善);
            第３群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第３群.set段階改善フラグ(RString.EMPTY);
            第３群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 毎日の日課を理解今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第３群 第３群
     */
    public void set毎日の日課を理解今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第３群) {
        if (ChosaAnser15.できない.getコード().equals(今回結果コード) && ChosaAnser15.できる.getコード().equals(前回調査結果コード)) {
            第３群.set段階改善フラグ(段階悪化);
            第３群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if (ChosaAnser15.できない.getコード().equals(前回調査結果コード) && ChosaAnser15.できる.getコード().equals(今回結果コード)) {
            第３群.set段階改善フラグ(段階改善);
            第３群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第３群.set段階改善フラグ(RString.EMPTY);
            第３群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 徘徊今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第３群 第３群
     */
    public void set徘徊今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第３群) {
        if ((ChosaAnser16.ある.getコード().equals(今回結果コード) && (ChosaAnser16.ときどきある.getコード().equals(前回調査結果コード)
                || ChosaAnser16.ない.getコード().equals(前回調査結果コード))) || (ChosaAnser16.ときどきある.getコード().equals(今回結果コード)
                && ChosaAnser16.ない.getコード().equals(前回調査結果コード))) {
            第３群.set段階改善フラグ(段階悪化);
            第３群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser16.ある.getコード().equals(前回調査結果コード) && (ChosaAnser16.ときどきある.getコード().equals(今回結果コード)
                || ChosaAnser16.ない.getコード().equals(今回結果コード))) || (ChosaAnser16.ときどきある.getコード().equals(前回調査結果コード)
                && ChosaAnser16.ない.getコード().equals(今回結果コード))) {
            第３群.set段階改善フラグ(段階改善);
            第３群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第３群.set段階改善フラグ(RString.EMPTY);
            第３群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 日常の意思決定今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第３群 第３群
     */
    public void set日常の意思決定今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第３群) {
        if ((ChosaAnser17.できない.getコード().equals(今回結果コード) && (ChosaAnser17.日常的に困難.getコード().equals(前回調査結果コード)
                || ChosaAnser17.特別な場合を除いてできる.getコード().equals(前回調査結果コード) || ChosaAnser17.できる_特別な場合でもできる.getコード().equals(前回調査結果コード)))
                || (ChosaAnser17.日常的に困難.getコード().equals(今回結果コード) && (ChosaAnser17.特別な場合を除いてできる.getコード().equals(前回調査結果コード)
                || ChosaAnser17.できる_特別な場合でもできる.getコード().equals(前回調査結果コード))) || (ChosaAnser17.特別な場合を除いてできる.getコード().equals(今回結果コード)
                && ChosaAnser17.できる_特別な場合でもできる.getコード().equals(前回調査結果コード))) {
            第３群.set段階改善フラグ(段階悪化);
            第３群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((ChosaAnser17.できない.getコード().equals(前回調査結果コード) && (ChosaAnser17.日常的に困難.getコード().equals(今回結果コード)
                || ChosaAnser17.特別な場合を除いてできる.getコード().equals(今回結果コード) || ChosaAnser17.できる_特別な場合でもできる.getコード().equals(今回結果コード)))
                || (ChosaAnser17.日常的に困難.getコード().equals(前回調査結果コード) && (ChosaAnser17.特別な場合を除いてできる.getコード().equals(今回結果コード)
                || ChosaAnser17.できる_特別な場合でもできる.getコード().equals(今回結果コード))) || (ChosaAnser17.特別な場合を除いてできる.getコード().equals(前回調査結果コード)
                && ChosaAnser17.できる_特別な場合でもできる.getコード().equals(今回結果コード))) {
            第３群.set段階改善フラグ(段階改善);
            第３群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第３群.set段階改善フラグ(RString.EMPTY);
            第３群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 日常生活自立度今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第２群 第２群
     */
    public void set日常生活自立度今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if (is日常生活自立度今回前回比１(今回結果コード, 前回調査結果コード) || is日常生活自立度今回前回比２(今回結果コード, 前回調査結果コード)
                || is日常生活自立度今回前回比３(今回結果コード, 前回調査結果コード) || is日常生活自立度今回前回比４(今回結果コード, 前回調査結果コード)) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if (is日常生活自立度前回今回比１(今回結果コード, 前回調査結果コード) || is日常生活自立度前回今回比２(今回結果コード, 前回調査結果コード)
                || is日常生活自立度前回今回比３(今回結果コード, 前回調査結果コード) || is日常生活自立度前回今回比４(今回結果コード, 前回調査結果コード)) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    private boolean is日常生活自立度今回前回比１(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is今回前回結果 = false;
        if (IkenKomoku03.M.getコード().equals(今回結果コード) && (IkenKomoku03.Ⅳ.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅲb.getコード().equals(前回調査結果コード) || IkenKomoku03.Ⅲa.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅱb.getコード().equals(前回調査結果コード) || IkenKomoku03.Ⅱa.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅰ.getコード().equals(前回調査結果コード) || IkenKomoku03.自立.getコード().equals(前回調査結果コード))) {
            is今回前回結果 = true;
        }
        return is今回前回結果;
    }

    private boolean is日常生活自立度今回前回比２(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is今回前回結果 = false;
        if (IkenKomoku03.Ⅳ.getコード().equals(今回結果コード) && (IkenKomoku03.Ⅲb.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅲa.getコード().equals(前回調査結果コード) || IkenKomoku03.Ⅱb.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅱa.getコード().equals(前回調査結果コード) || IkenKomoku03.Ⅰ.getコード().equals(前回調査結果コード)
                || IkenKomoku03.自立.getコード().equals(前回調査結果コード))) {
            is今回前回結果 = true;
        }
        return is今回前回結果;
    }

    private boolean is日常生活自立度今回前回比３(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is今回前回結果 = false;
        if ((IkenKomoku03.Ⅲb.getコード().equals(今回結果コード) && (IkenKomoku03.Ⅲa.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅱb.getコード().equals(前回調査結果コード) || IkenKomoku03.Ⅱa.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅰ.getコード().equals(前回調査結果コード) || IkenKomoku03.自立.getコード().equals(前回調査結果コード)))
                || (IkenKomoku03.Ⅲa.getコード().equals(今回結果コード) && (IkenKomoku03.Ⅱb.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅱa.getコード().equals(前回調査結果コード) || IkenKomoku03.Ⅰ.getコード().equals(前回調査結果コード)
                || IkenKomoku03.自立.getコード().equals(前回調査結果コード)))) {
            is今回前回結果 = true;
        }
        return is今回前回結果;
    }

    private boolean is日常生活自立度今回前回比４(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is今回前回結果 = false;
        if ((IkenKomoku03.Ⅱb.getコード().equals(今回結果コード) && (IkenKomoku03.Ⅱa.getコード().equals(前回調査結果コード)
                || IkenKomoku03.Ⅰ.getコード().equals(前回調査結果コード) || IkenKomoku03.自立.getコード().equals(前回調査結果コード)))
                || (IkenKomoku03.Ⅱa.getコード().equals(今回結果コード) && (IkenKomoku03.Ⅰ.getコード().equals(前回調査結果コード)
                || IkenKomoku03.自立.getコード().equals(前回調査結果コード))) || (IkenKomoku03.Ⅰ.getコード().equals(今回結果コード)
                && IkenKomoku03.自立.getコード().equals(前回調査結果コード))) {
            is今回前回結果 = true;
        }
        return is今回前回結果;
    }

    private boolean is日常生活自立度前回今回比１(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is前回今回結果 = false;
        if ((IkenKomoku03.M.getコード().equals(前回調査結果コード) && (IkenKomoku03.Ⅳ.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅲb.getコード().equals(今回結果コード) || IkenKomoku03.Ⅲa.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅱb.getコード().equals(今回結果コード) || IkenKomoku03.Ⅱa.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅰ.getコード().equals(今回結果コード) || IkenKomoku03.自立.getコード().equals(今回結果コード)))) {
            is前回今回結果 = true;
        }
        return is前回今回結果;

    }

    private boolean is日常生活自立度前回今回比２(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is前回今回結果 = false;
        if ((IkenKomoku03.Ⅳ.getコード().equals(前回調査結果コード) && (IkenKomoku03.Ⅲb.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅲa.getコード().equals(今回結果コード) || IkenKomoku03.Ⅱb.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅱa.getコード().equals(今回結果コード) || IkenKomoku03.Ⅰ.getコード().equals(今回結果コード)
                || IkenKomoku03.自立.getコード().equals(今回結果コード)))) {
            is前回今回結果 = true;
        }
        return is前回今回結果;

    }

    private boolean is日常生活自立度前回今回比３(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is前回今回結果 = false;
        if ((IkenKomoku03.Ⅲb.getコード().equals(前回調査結果コード) && (IkenKomoku03.Ⅲa.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅱb.getコード().equals(今回結果コード) || IkenKomoku03.Ⅱa.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅰ.getコード().equals(今回結果コード) || IkenKomoku03.自立.getコード().equals(今回結果コード)))
                || (IkenKomoku03.Ⅲa.getコード().equals(前回調査結果コード) && (IkenKomoku03.Ⅱb.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅱa.getコード().equals(今回結果コード) || IkenKomoku03.Ⅰ.getコード().equals(今回結果コード)
                || IkenKomoku03.自立.getコード().equals(今回結果コード)))) {
            is前回今回結果 = true;
        }
        return is前回今回結果;

    }

    private boolean is日常生活自立度前回今回比４(RString 今回結果コード, RString 前回調査結果コード) {
        boolean is前回今回結果 = false;
        if ((IkenKomoku03.Ⅱb.getコード().equals(前回調査結果コード) && (IkenKomoku03.Ⅱa.getコード().equals(今回結果コード)
                || IkenKomoku03.Ⅰ.getコード().equals(今回結果コード) || IkenKomoku03.自立.getコード().equals(今回結果コード)))
                || (IkenKomoku03.Ⅱa.getコード().equals(前回調査結果コード) && (IkenKomoku03.Ⅰ.getコード().equals(今回結果コード)
                || IkenKomoku03.自立.getコード().equals(今回結果コード))) || (IkenKomoku03.Ⅰ.getコード().equals(前回調査結果コード)
                && IkenKomoku03.自立.getコード().equals(今回結果コード))) {
            is前回今回結果 = true;
        }
        return is前回今回結果;

    }

    /**
     * 短期記憶意見書今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第２群 第２群
     */
    public void set短期記憶意見書今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((IkenKomoku04.問題あり.getコード().equals(今回結果コード) && IkenKomoku04.問題なし.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((IkenKomoku04.問題あり.getコード().equals(前回調査結果コード) && IkenKomoku04.問題なし.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 認知能力今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第２群 第２群
     */
    public void set認知能力今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((IkenKomoku05.判断できない.getコード().equals(今回結果コード) && (IkenKomoku05.見守りが必要.getコード().equals(前回調査結果コード)
                || IkenKomoku05.いくらか困難.getコード().equals(前回調査結果コード) || IkenKomoku05.自立.getコード().equals(前回調査結果コード)))
                || (IkenKomoku05.見守りが必要.getコード().equals(今回結果コード) && (IkenKomoku05.いくらか困難.getコード().equals(前回調査結果コード)
                || IkenKomoku05.自立.getコード().equals(前回調査結果コード))) || (IkenKomoku05.いくらか困難.getコード().equals(今回結果コード)
                && IkenKomoku05.自立.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((IkenKomoku05.判断できない.getコード().equals(前回調査結果コード) && (IkenKomoku05.見守りが必要.getコード().equals(今回結果コード)
                || IkenKomoku05.いくらか困難.getコード().equals(今回結果コード) || IkenKomoku05.自立.getコード().equals(今回結果コード)))
                || (IkenKomoku05.見守りが必要.getコード().equals(前回調査結果コード) && (IkenKomoku05.いくらか困難.getコード().equals(今回結果コード)
                || IkenKomoku05.自立.getコード().equals(今回結果コード))) || (IkenKomoku05.いくらか困難.getコード().equals(前回調査結果コード)
                && IkenKomoku05.自立.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 伝達能力今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第２群 第２群
     */
    public void set伝達能力今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((IkenKomoku06.伝えられない.getコード().equals(今回結果コード) && (IkenKomoku06.具体的要求に限られる.getコード().equals(前回調査結果コード)
                || IkenKomoku06.いくらか困難.getコード().equals(前回調査結果コード) || IkenKomoku06.伝えられる.getコード().equals(前回調査結果コード)))
                || (IkenKomoku06.具体的要求に限られる.getコード().equals(今回結果コード) && (IkenKomoku06.いくらか困難.getコード().equals(前回調査結果コード)
                || IkenKomoku06.伝えられる.getコード().equals(前回調査結果コード))) || (IkenKomoku06.いくらか困難.getコード().equals(今回結果コード)
                && IkenKomoku06.伝えられる.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((IkenKomoku06.伝えられない.getコード().equals(前回調査結果コード) && (IkenKomoku06.具体的要求に限られる.getコード().equals(今回結果コード)
                || IkenKomoku06.いくらか困難.getコード().equals(今回結果コード) || IkenKomoku06.伝えられる.getコード().equals(今回結果コード)))
                || (IkenKomoku06.具体的要求に限られる.getコード().equals(前回調査結果コード) && (IkenKomoku06.いくらか困難.getコード().equals(今回結果コード)
                || IkenKomoku06.伝えられる.getコード().equals(今回結果コード))) || (IkenKomoku06.いくらか困難.getコード().equals(前回調査結果コード)
                && IkenKomoku06.伝えられる.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 食事行為今回結果前回結果を設定する。
     *
     * @param 今回結果コード 今回結果コード
     * @param 前回調査結果コード 前回調査結果コード
     * @param 第２群 第２群
     */
    public void set食事行為今回結果前回結果比(RString 今回結果コード, RString 前回調査結果コード, TiyosaKekka 第２群) {
        if ((IkenKomoku14.全面介助.getコード().equals(今回結果コード) && IkenKomoku14.自立ないし何とか自分で食べられる.getコード().equals(前回調査結果コード))) {
            第２群.set段階改善フラグ(段階悪化);
            第２群.set段階改善値(new RString(Integer.parseInt(今回結果コード.toString()) - Integer.parseInt(前回調査結果コード.toString())));
        } else if ((IkenKomoku14.全面介助.getコード().equals(前回調査結果コード) && IkenKomoku14.自立ないし何とか自分で食べられる.getコード().equals(今回結果コード))) {
            第２群.set段階改善フラグ(段階改善);
            第２群.set段階改善値(new RString(Integer.parseInt(前回調査結果コード.toString()) - Integer.parseInt(今回結果コード.toString())));
        } else {
            第２群.set段階改善フラグ(RString.EMPTY);
            第２群.set段階改善値(RString.EMPTY);
        }
    }

    /**
     * 第１群リストを取得します。
     *
     * @return 第１群リスト
     */
    public List<TiyosaKekka> get第１群リスト() {
        List<TiyosaKekka> 第１群リスト = new ArrayList<>();
        for (int i = 0; i < INT_20; i++) {
            TiyosaKekka 第１群 = new TiyosaKekka();
            第１群リスト.add(第１群);
        }
        return 第１群リスト;
    }

    /**
     * 第２群リストを取得します。
     *
     * @return 第２群リスト
     */
    public List<TiyosaKekka> get第２群リスト() {
        List<TiyosaKekka> 第２群リスト = new ArrayList<>();
        for (int i = 0; i < INT_12; i++) {
            TiyosaKekka 第１群 = new TiyosaKekka();
            第２群リスト.add(第１群);
        }
        return 第２群リスト;
    }

    /**
     * 第３群リストを取得します。
     *
     * @return 第３群リスト
     */
    public List<TiyosaKekka> get第３群リスト() {
        List<TiyosaKekka> 第２群リスト = new ArrayList<>();
        for (int i = 0; i < INT_9; i++) {
            TiyosaKekka 第１群 = new TiyosaKekka();
            第２群リスト.add(第１群);
        }
        return 第２群リスト;
    }

    /**
     * 第４群リストを取得します。
     *
     * @return 第４群リスト
     */
    public List<TiyosaKekka> get第４群リスト() {
        List<TiyosaKekka> 第２群リスト = new ArrayList<>();
        for (int i = 0; i < INT_15; i++) {
            TiyosaKekka 第１群 = new TiyosaKekka();
            第２群リスト.add(第１群);
        }
        return 第２群リスト;
    }

    /**
     * 第５群リストを取得します。
     *
     * @return 第５群リスト
     */
    public List<TiyosaKekka> get第５群リスト() {
        List<TiyosaKekka> 第２群リスト = new ArrayList<>();
        for (int i = 0; i < INT_6; i++) {
            TiyosaKekka 第１群 = new TiyosaKekka();
            第２群リスト.add(第１群);
        }
        return 第２群リスト;
    }

    /**
     * 主治医意見書リストを取得します。
     *
     * @return 主治医意見書リスト
     */
    public List<TiyosaKekka> get主治医意見書リスト() {
        List<TiyosaKekka> 第２群リスト = new ArrayList<>();
        for (int i = 0; i < INT_5; i++) {
            TiyosaKekka 第１群 = new TiyosaKekka();
            第２群リスト.add(第１群);
        }
        return 第２群リスト;
    }
}
