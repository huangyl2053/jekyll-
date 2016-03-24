package jp.co.ndensan.reams.db.dbb.service.core.kanri;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.ChikuHyoji1;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.ChikuHyoji2;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.ChikuHyoji3;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ur.urz.business.config.jushoinput.JushoNyuryokuConfigFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 表示コードのクラスです。
 */
public class HyojiCodeResearcher {

    private static final RString 文字列_帳票制御共通情報 = new RString("帳票制御共通情報");
    private static final RString 文字列_帳票分類ID = new RString("帳票分類ID");
    private static final RString 文字列_町域コード = new RString("町域コード");
    private static final RString 文字列_行政区コード = new RString("行政区コード");
    private static final RString 文字列_納組コード = new RString("納組コード");
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
     * 表示コード名称を取得します。
     *
     * @param 帳票分類ID 帳票分類ID
     * @return 表示コード名称
     */
    public SearchResult<RString> get表示コード名称(ReportId 帳票分類ID) {
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_帳票分類ID.toString()));

        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = dbT7065Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類ID);
        return get表示コード名称(dbT7065Entity);
    }

    /**
     * 表示コードを取得します。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 町域コード 町域コード
     * @param 行政区コード 行政区コード
     * @param 地区コード１ 地区コード１
     * @param 地区コード２ 地区コード２
     * @param 地区コード３ 地区コード３
     * @param 納組コード 納組コード
     * @return 表示コード情報
     */
    public HyojiCodes get表示コード(ReportId 帳票分類ID,
            RString 町域コード,
            RString 行政区コード,
            RString 地区コード１,
            RString 地区コード２,
            RString 地区コード３,
            RString 納組コード) {
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_帳票分類ID.toString()));

        return create表示コード情報(
                dbT7065Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類ID),
                町域コード,
                行政区コード,
                地区コード１,
                地区コード２,
                地区コード３,
                納組コード);
    }

    /**
     * 表示コード名称を取得します。
     *
     * @param 帳票制御共通情報 帳票制御共通情報
     * @return 表示コード名称 SearchResult<RString>
     */
    public SearchResult<RString> get表示コード名称(DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通情報) {
        requireNonNull(帳票制御共通情報, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_帳票制御共通情報.toString()));

        List<RString> 表示コード名称 = new ArrayList<>();
        if (RString.isNullOrEmpty(帳票制御共通情報.getChikuHyoji1())
                || ChikuHyoji1.なし.getコード().equals(帳票制御共通情報.getChikuHyoji1())) {
            表示コード名称.add(RString.EMPTY);
        } else if (ChikuHyoji1.住所コード.getコード().equals(帳票制御共通情報.getChikuHyoji1())) {
            表示コード名称.add(文字列_町域コード);
        } else if (ChikuHyoji1.行政区コード.getコード().equals(帳票制御共通情報.getChikuHyoji1())) {
            表示コード名称.add(文字列_行政区コード);
        }
        if (RString.isNullOrEmpty(帳票制御共通情報.getChikuHyoji2())
                || ChikuHyoji2.なし.getコード().equals(帳票制御共通情報.getChikuHyoji2())) {
            表示コード名称.add(RString.EMPTY);
        } else if (ChikuHyoji2.地区の分類1.getコード().equals(帳票制御共通情報.getChikuHyoji2())) {
            表示コード名称.add(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類１));
        } else if (ChikuHyoji2.地区の分類2.getコード().equals(帳票制御共通情報.getChikuHyoji2())) {
            表示コード名称.add(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類２));
        } else if (ChikuHyoji2.地区の分類3.getコード().equals(帳票制御共通情報.getChikuHyoji2())) {
            表示コード名称.add(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類３));
        } else if (ChikuHyoji2.納組コード.getコード().equals(帳票制御共通情報.getChikuHyoji2())) {
            表示コード名称.add(文字列_納組コード);
        }
        if (RString.isNullOrEmpty(帳票制御共通情報.getChikuHyoji3())
                || ChikuHyoji3.なし.getコード().equals(帳票制御共通情報.getChikuHyoji3())) {
            表示コード名称.add(RString.EMPTY);
        } else if (ChikuHyoji3.地区の分類1.getコード().equals(帳票制御共通情報.getChikuHyoji3())) {
            表示コード名称.add(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類１));
        } else if (ChikuHyoji3.地区の分類2.getコード().equals(帳票制御共通情報.getChikuHyoji3())) {
            表示コード名称.add(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類２));
        } else if (ChikuHyoji3.地区の分類3.getコード().equals(帳票制御共通情報.getChikuHyoji3())) {
            表示コード名称.add(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類３));
        } else if (ChikuHyoji3.納組コード.getコード().equals(帳票制御共通情報.getChikuHyoji3())) {
            表示コード名称.add(文字列_納組コード);
        }
        return SearchResult.of(表示コード名称, 0, false);
    }

    /**
     * 表示コード情報を作成します。
     *
     * @param 帳票制御共通情報 帳票制御共通
     * @param 町域コード 町域コード
     * @param 行政区コード 行政区コード
     * @param 地区コード１ 地区コード１
     * @param 地区コード２ 地区コード２
     * @param 地区コード３ 地区コード３
     * @param 納組コード 納組コード
     * @return 表示コード情報
     */
    public HyojiCodes create表示コード情報(
            DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通情報,
            RString 町域コード,
            RString 行政区コード,
            RString 地区コード１,
            RString 地区コード２,
            RString 地区コード３,
            RString 納組コード) {
        requireNonNull(帳票制御共通情報, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_帳票制御共通情報.toString()));

        HyojiCodes hyojiCodes = new HyojiCodes();
        if (RString.isNullOrEmpty(帳票制御共通情報.getChikuHyoji1())
                || ChikuHyoji1.なし.getコード().equals(帳票制御共通情報.getChikuHyoji1())) {
            hyojiCodes.set表示コード１(RString.EMPTY);
            hyojiCodes.set表示コード名１(RString.EMPTY);
        } else if (ChikuHyoji1.住所コード.getコード().equals(帳票制御共通情報.getChikuHyoji1())) {
            hyojiCodes.set表示コード１(町域コード);
            hyojiCodes.set表示コード名１(文字列_町域コード);
        } else if (ChikuHyoji1.行政区コード.getコード().equals(帳票制御共通情報.getChikuHyoji1())) {
            hyojiCodes.set表示コード１(行政区コード);
            hyojiCodes.set表示コード名１(文字列_行政区コード);
        }
        if (RString.isNullOrEmpty(帳票制御共通情報.getChikuHyoji2())
                || ChikuHyoji2.なし.getコード().equals(帳票制御共通情報.getChikuHyoji2())) {
            hyojiCodes.set表示コード２(RString.EMPTY);
            hyojiCodes.set表示コード名２(RString.EMPTY);
        } else if (ChikuHyoji2.地区の分類1.getコード().equals(帳票制御共通情報.getChikuHyoji2())) {
            hyojiCodes.set表示コード２(地区コード１);
            hyojiCodes.set表示コード名２(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類１));
        } else if (ChikuHyoji2.地区の分類2.getコード().equals(帳票制御共通情報.getChikuHyoji2())) {
            hyojiCodes.set表示コード２(地区コード２);
            hyojiCodes.set表示コード名２(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類２));
        } else if (ChikuHyoji2.地区の分類3.getコード().equals(帳票制御共通情報.getChikuHyoji2())) {
            hyojiCodes.set表示コード２(地区コード３);
            hyojiCodes.set表示コード名２(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類３));
        } else if (ChikuHyoji2.納組コード.getコード().equals(帳票制御共通情報.getChikuHyoji2())) {
            hyojiCodes.set表示コード２(納組コード);
            hyojiCodes.set表示コード名２(文字列_納組コード);
        }
        if (RString.isNullOrEmpty(帳票制御共通情報.getChikuHyoji3())
                || ChikuHyoji3.なし.getコード().equals(帳票制御共通情報.getChikuHyoji3())) {
            hyojiCodes.set表示コード３(RString.EMPTY);
            hyojiCodes.set表示コード名３(RString.EMPTY);
        } else if (ChikuHyoji3.地区の分類1.getコード().equals(帳票制御共通情報.getChikuHyoji3())) {
            hyojiCodes.set表示コード３(地区コード１);
            hyojiCodes.set表示コード名３(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類１));
        } else if (ChikuHyoji3.地区の分類2.getコード().equals(帳票制御共通情報.getChikuHyoji3())) {
            hyojiCodes.set表示コード３(地区コード２);
            hyojiCodes.set表示コード名３(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類２));
        } else if (ChikuHyoji3.地区の分類3.getコード().equals(帳票制御共通情報.getChikuHyoji3())) {
            hyojiCodes.set表示コード３(地区コード３);
            hyojiCodes.set表示コード名３(JushoNyuryokuConfigFactory.createInstance().getコード名称(ConfigKeysCodeName.コード名称_地区の分類３));
        } else if (ChikuHyoji3.納組コード.getコード().equals(帳票制御共通情報.getChikuHyoji3())) {
            hyojiCodes.set表示コード３(納組コード);
            hyojiCodes.set表示コード名３(文字列_納組コード);
        }
        return hyojiCodes;
    }
}
