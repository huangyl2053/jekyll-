/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.kanri;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.ChikuHyoji1;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.ChikuHyoji2;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.ChikuHyoji3;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 表示コードのクラス。
 */
public class HyojiCodeResearcher {

    private final DbT7065ChohyoSeigyoKyotsuDac dbT7065Dac;

    /**
     * コンストラクタです。
     */
    public HyojiCodeResearcher() {
        this.dbT7065Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param dbT7065Dac DbT7065ChohyoSeigyoKyotsuDac
     */
    HyojiCodeResearcher(DbT7065ChohyoSeigyoKyotsuDac dbT7065Dac) {
        this.dbT7065Dac = dbT7065Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HyojiCodeResearcher}のインスタンスを返します。
     *
     * @return HyojiCodeResearcher
     */
    public static HyojiCodeResearcher createInstance() {
        return InstanceProvider.create(HyojiCodeResearcher.class);
    }

    /**
     * 表示コード名情報を取得する。
     *
     * @param 帳票分類ID
     * @return 表示コード名情報
     */
    public SearchResult<RString> get表示コード名称(ReportId 帳票分類ID) {
        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = dbT7065Dac.selectByHyoujiCode(帳票分類ID);
        SearchResult<RString> 表示コード名情報List = get表示コード名称(dbT7065Entity);
        return 表示コード名情報List;
    }

    /**
     * 表示コード情報を作成する。
     *
     * @param 帳票分類ID
     * @param 町域コード
     * @param 行政区コード
     * @param 地区コード１
     * @param 地区コード２
     * @param 地区コード３
     * @param 納組コード
     * @return 表示コード情報List
     */
    // TODO QA572：HyojiCodesを実装なし 2016/02/10。
//    public SearchResult<HyojiCodes> get表示コード(ReportId 帳票分類ID,
//            RString 町域コード,
//            RString 行政区コード,
//            RString 地区コード１,
//            RString 地区コード２,
//            RString 地区コード３,
//            RString 納組コード) {
//        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = dbT7065Dac.selectByHyoujiCode(帳票分類ID);
//        SearchResult<HyojiCodes> 表示コード情報List = create表示コード情報(dbT7065Entity, 町域コード, 行政区コード, 地区コード１, 地区コード２, 地区コード３, 納組コード);
//        return 表示コード情報List;
//    }
    /**
     * 表示コード情報を作成する。
     *
     * @param 帳票制御共通情報
     * @return 表示コード情報
     */
    public SearchResult<RString> get表示コード名称(DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通情報) {
        requireNonNull(帳票制御共通情報, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御共通情報"));
        RString 地区コード１ = 帳票制御共通情報.getChikuHyoji1();
        RString 地区コード２ = 帳票制御共通情報.getChikuHyoji2();
        RString 地区コード３ = 帳票制御共通情報.getChikuHyoji3();
        List<RString> RStringList = new ArrayList();
        if (new RString("chikuHyoji1").equals(地区コード１)) {
            for (ChikuHyoji1 seibetsu : ChikuHyoji1.values()) {
                if (地区コード１.equals(seibetsu.getコード())) {
                    RStringList.add(seibetsu.get名称());
                }
            }
        }

        if (new RString("chikuHyoji2").equals(地区コード２)) {
            for (ChikuHyoji2 seibetsu : ChikuHyoji2.values()) {
                if (地区コード２.equals(seibetsu.getコード())) {
                    RStringList.add(seibetsu.get名称());
                }
            }
        }

        if (new RString("chikuHyoji3").equals(地区コード３)) {
            for (ChikuHyoji3 seibetsu : ChikuHyoji3.values()) {
                if (地区コード３.equals(seibetsu.getコード())) {
                    RStringList.add(seibetsu.get名称());
                }
            }
        }

        return SearchResult.of(RStringList, 0, false);
    }

    /**
     * 表示コード情報を作成する。
     *
     * @param 帳票制御共通情報
     * @param 町域コード
     * @param 行政区コード
     * @param 地区コード１
     * @param 地区コード２
     * @param 地区コード３
     * @param 納組コード
     * @return 表示コード情報
     */
    // TODO QA572：HyojiCodesを実装なし、帰ってタイプはList<HyojiCodes>ですが？　2016/02/10。
//    public SearchResult<HyojiCodes> create表示コード情報(DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通情報,
//            RString 町域コード,
//            RString 行政区コード,
//            RString 地区コード１,
//            RString 地区コード２,
//            RString 地区コード３,
//            RString 納組コード) {
//        requireNonNull(帳票制御共通情報, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御共通情報"));
//        RString 地区コード_１ = 帳票制御共通情報.getChikuHyoji1();
//        RString 地区コード_２ = 帳票制御共通情報.getChikuHyoji2();
//        RString 地区コード_３ = 帳票制御共通情報.getChikuHyoji3();
//
//        List<HyojiCodes> hyojiCodes = new ArrayList();
//        if (new RString("chikuHyoji1").equals(地区コード_１)) {
//            hyojiCodes.set表示コード１(ChikuHyoji1.なし.getコード());
//            hyojiCodes.set表示コード名１(ChikuHyoji1.なし.get名称());
//            hyojiCodes.set表示コード１(町域コード);
//            hyojiCodes.set表示コード名１(ChikuHyoji1.住所コード.get名称());
//            hyojiCodes.set表示コード１(行政区コード);
//            hyojiCodes.set表示コード名１(ChikuHyoji1.行政区コード.get名称());
//        }
//
//        if (new RString("chikuHyoji2").equals(地区コード_２)) {
//            hyojiCodes.set表示コード２(ChikuHyoji2.なし.getコード());
//            hyojiCodes.set表示コード名２(ChikuHyoji2.なし.get名称());
//            hyojiCodes.set表示コード２(地区コード１);
//            hyojiCodes.set表示コード名２(ChikuHyoji2.地区の分類1.get名称());
//            hyojiCodes.set表示コード２(地区コード２);
//            hyojiCodes.set表示コード名２(ChikuHyoji2.地区の分類2.get名称());
//            hyojiCodes.set表示コード２(地区コード３);
//            hyojiCodes.set表示コード名２(ChikuHyoji2.地区の分類3.get名称());
//            hyojiCodes.set表示コード２(納組コード);
//            hyojiCodes.set表示コード名２(ChikuHyoji2.納組コード.get名称());
//        }
//
//        if (new RString("chikuHyoji3").equals(地区コード_３)) {
//            hyojiCodes.set表示コード３(ChikuHyoji2.なし.getコード());
//            hyojiCodes.set表示コード名３(ChikuHyoji2.なし.get名称());
//            hyojiCodes.set表示コード３(地区コード１);
//            hyojiCodes.set表示コード名３(ChikuHyoji2.地区の分類1.get名称());
//            hyojiCodes.set表示コード３(地区コード２);
//            hyojiCodes.set表示コード名３(ChikuHyoji2.地区の分類2.get名称());
//            hyojiCodes.set表示コード３(地区コード３);
//            hyojiCodes.set表示コード名３(ChikuHyoji2.地区の分類3.get名称());
//            hyojiCodes.set表示コード３(納組コード);
//            hyojiCodes.set表示コード名３(ChikuHyoji2.納組コード.get名称());
//        }
//        return hyojiCodes;
//    }
}
