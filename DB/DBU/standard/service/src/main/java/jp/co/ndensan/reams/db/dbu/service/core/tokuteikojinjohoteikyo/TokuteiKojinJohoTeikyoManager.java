package jp.co.ndensan.reams.db.dbu.service.core.tokuteikojinjohoteikyo;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.business.core.tokuteikojinjohoteikyo.TokuteiKojinHanKanriTokuteiJohoBusiness;
import jp.co.ndensan.reams.db.dbu.business.core.tokuteikojinjohoteikyo.TokuteiKojinJohoKoumokuHanKanriBusiness;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 特定個人情報提供のManagerクラスです。
 *
 * @reamsid_L DBU-4880-110 dingyi
 *
 */
public class TokuteiKojinJohoTeikyoManager {

    private final MapperProvider mapperProvider;
    private static final RString 文字列_異動区分 = new RString("異動区分");
    private static final RString 文字列_特定個人情報名コード = new RString("特定個人情報名コード");
    private static final RString 文字列_データセット番号 = new RString("データセット番号");
    private static final RString 文字列_版番号 = new RString("版番号");

    /**
     * コンストラクタです。
     */
    public TokuteiKojinJohoTeikyoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    TokuteiKojinJohoTeikyoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokuteiKojinJohoTeikyoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TokuteiKojinJohoTeikyoManager}のインスタンス
     */
    public static TokuteiKojinJohoTeikyoManager createInstance() {
        return InstanceProvider.create(TokuteiKojinJohoTeikyoManager.class);
    }

    /**
     * 特定個人情報版管理より情報提供を行う版番号および提供済／未済の情報を取得する。
     *
     * @param 異動区分 異動区分
     * @param 特定個人情報名コード 特定個人情報名コード
     * @param データセット番号 データセット番号
     * @param 基準日 基準日
     *
     * @return 特定個人版管理特定情報
     */
    public List<TokuteiKojinHanKanriTokuteiJohoBusiness> get版番号(RString 異動区分, RString 特定個人情報名コード,
            RString データセット番号, FlexibleDate 基準日) {
        requireNonNull(異動区分, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_異動区分.toString()));
        requireNonNull(特定個人情報名コード, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_特定個人情報名コード.toString()));
        requireNonNull(データセット番号, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_データセット番号.toString()));
        List<TokuteiKojinHanKanriTokuteiJohoBusiness> 特定個人版管理特定情報 = new ArrayList<>();
//        List<DbT7301TokuteiKojinJohoHanKanriEntity> entityList = new ArrayList<>();
//        ITokuteiKojinJohoTeikyoMapper mapper = mapperProvider.create(ITokuteiKojinJohoTeikyoMapper.class);
//        RString 版番号 = RString.EMPTY;
//        RString 初回提供区分 = ShokaiTeikyoKubun.未提供.getコード();
//        if (基準日 == null) {
//            基準日 = FlexibleDate.getNowDate();
//        }
//        if (ShinkiIdoKubun.当初.getコード().equals(異動区分) || ShinkiIdoKubun.版改定.getコード().equals(異動区分)) {
//            // TODO
//            entityList = mapper.get有効な版番号(null);
//        }
        return 特定個人版管理特定情報;
    }

    /**
     * 特定個人情報版管理より情報提供を行う版番号および提供済／未済の情報を取得する。
     *
     * @param 異動区分 異動区分
     * @param 特定個人情報名コードリスト 特定個人情報名コードリスト
     * @param データセット番号 データセット番号
     * @param 基準日 基準日
     *
     * @return 特定個人版管理特定情報
     */
    public List<TokuteiKojinHanKanriTokuteiJohoBusiness> get版番号(RString 異動区分, List<RString> 特定個人情報名コードリスト,
            RString データセット番号, FlexibleDate 基準日) {
        List<TokuteiKojinHanKanriTokuteiJohoBusiness> 特定個人版管理特定情報 = new ArrayList<>();
        for (RString 特定個人情報名コード : 特定個人情報名コードリスト) {
            特定個人版管理特定情報.addAll(get版番号(異動区分, 特定個人情報名コード, データセット番号, 基準日));
        }
        return 特定個人版管理特定情報;
    }

    /**
     * 特特定個人情報項目版管理より情報提供する項目のバージョン、有効／無効の情報を取得する。
     *
     * @param 特定個人情報名コード 特定個人情報名コード
     * @param データセット番号 データセット番号
     * @param 版番号 版番号
     * @param 基準日 基準日
     *
     * @return 特定個人情報項目版管理
     */
    public List<TokuteiKojinJohoKoumokuHanKanriBusiness> get項目バージョン(RString 特定個人情報名コード,
            RString データセット番号, RString 版番号, FlexibleDate 基準日) {
        requireNonNull(特定個人情報名コード, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_特定個人情報名コード.toString()));
        requireNonNull(データセット番号, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_データセット番号.toString()));
        requireNonNull(版番号, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_版番号.toString()));
        List<TokuteiKojinJohoKoumokuHanKanriBusiness> 項目版管理情報 = new ArrayList<>();

        return 項目版管理情報;
    }

    /**
     * 特定個人情報提供管理に今回提供した特定個人情報の提供状況(提供済／未提供)を挿入または更新する。
     *
     * @param 中間DBのテーブル名 中間DBのテーブル名
     * @param 新規異動区分 新規異動区分
     * @param 特定個人情報名コード 特定個人情報名コード
     * @param データセット番号 データセット番号
     * @param 版番号 版番号
     *
     */
    public void update特定個人情報提供(RString 中間DBのテーブル名, RString 新規異動区分, RString 特定個人情報名コード,
            RString データセット番号, RString 版番号) {
        // TODO

    }

}
