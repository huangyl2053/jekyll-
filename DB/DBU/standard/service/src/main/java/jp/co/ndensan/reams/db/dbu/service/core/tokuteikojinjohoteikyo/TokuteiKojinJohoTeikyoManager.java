package jp.co.ndensan.reams.db.dbu.service.core.tokuteikojinjohoteikyo;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.business.core.tokuteikojinjohoteikyo.TokuteiKojinHanKanriTokuteiJohoBusiness;
import jp.co.ndensan.reams.db.dbu.business.core.tokuteikojinjohoteikyo.TokuteiKojinJohoKoumokuHanKanriBusiness;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShokaiTeikyoKubun;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoParamater;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7301TokuteiKojinJohoHanKanriEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TokuteiKojinJohoKoumokuHanKanriRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo.ITokuteiKojinJohoTeikyoForServiceMapper;
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
        List<TokuteiKojinHanKanriTokuteiJohoBusiness> 特定個人版管理特定情報リスト = new ArrayList<>();
        ITokuteiKojinJohoTeikyoForServiceMapper mapper = mapperProvider.create(ITokuteiKojinJohoTeikyoForServiceMapper.class);
        RString 版番号 = RString.EMPTY;
        RString 初回提供区分 = ShokaiTeikyoKubun.未提供.getコード();
        if (基準日 == null || 基準日.isEmpty()) {
            基準日 = FlexibleDate.getNowDate();
        }
        List<DbT7301TokuteiKojinJohoHanKanriEntity> entityList;
        if (ShinkiIdoKubun.当初.getコード().equals(異動区分) || ShinkiIdoKubun.版改定.getコード().equals(異動区分)) {
            // TODO
            entityList = mapper.get有効な版番号(TokuteiKojinJohoTeikyoParamater.createParamter版番号取得(
                    特定個人情報名コード, データセット番号, 基準日));
        } else if (ShinkiIdoKubun.再登録.getコード().equals(異動区分) || ShinkiIdoKubun.異動.getコード().equals(異動区分)) {
            entityList = mapper.get初回提供済である直近の版番号(TokuteiKojinJohoTeikyoParamater.createParamter版番号取得(
                    特定個人情報名コード, データセット番号, 基準日));
        } else {
            entityList = mapper.get直近の版番号(TokuteiKojinJohoTeikyoParamater.createParamter版番号取得(
                    特定個人情報名コード, データセット番号, 基準日));
        }
        TokuteiKojinHanKanriTokuteiJohoBusiness 特定個人版管理特定情報 = new TokuteiKojinHanKanriTokuteiJohoBusiness();
        if (entityList == null || entityList.isEmpty()) {
            特定個人版管理特定情報.set版番号(版番号);
            特定個人版管理特定情報.set初回提供区分(初回提供区分);
            特定個人版管理特定情報.set特定個人情報名コード(特定個人情報名コード);
        } else {
            特定個人版管理特定情報.set版番号(entityList.get(0).getHanNo());
            特定個人版管理特定情報.set初回提供区分(entityList.get(0).getShokaiTeikyoKubun());
            特定個人版管理特定情報.set特定個人情報名コード(entityList.get(0).getTokuteiKojinJohoMeiCode());
        }
        特定個人版管理特定情報リスト.add(特定個人版管理特定情報);
        return 特定個人版管理特定情報リスト;
    }

    /**
     * 特定個人情報版管理より情報提供を行う版番号および提供済／未済の情報を取得する。
     *
     * @param 異動区分 異動区分
     * @param 特定個人情報名コードリスト 特定個人情報名コードリスト
     * @param データセット番号 データセット番号
     * @param 基準日 基準日
     *
     * @return 特定個人版管理特定情報リスト
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
     * 特定個人情報項目版管理より情報提供する項目のバージョン、有効／無効の情報を取得する。
     *
     * @param 特定個人情報名コード 特定個人情報名コード
     * @param データセット番号 データセット番号
     * @param 版番号 版番号
     * @param 基準日 基準日
     *
     * @return 特定個人項目版管理情報リスト
     */
    public List<TokuteiKojinJohoKoumokuHanKanriBusiness> get項目バージョン(RString 特定個人情報名コード,
            RString データセット番号, RString 版番号, FlexibleDate 基準日) {
        requireNonNull(特定個人情報名コード, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_特定個人情報名コード.toString()));
        requireNonNull(データセット番号, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_データセット番号.toString()));
        requireNonNull(版番号, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_版番号.toString()));
        List<TokuteiKojinJohoKoumokuHanKanriBusiness> 項目版管理情報リスト = new ArrayList<>();
        ITokuteiKojinJohoTeikyoForServiceMapper mapper = mapperProvider.create(ITokuteiKojinJohoTeikyoForServiceMapper.class);
        if (基準日 == null || 基準日.isEmpty()) {
            基準日 = FlexibleDate.getNowDate();
        }
        List<TokuteiKojinJohoKoumokuHanKanriRelateEntity> entityList = mapper.get特定個人情報項目版管理(
                TokuteiKojinJohoTeikyoParamater.createParamter項目バージョン取得(特定個人情報名コード, データセット番号, 版番号, 基準日));
        for (TokuteiKojinJohoKoumokuHanKanriRelateEntity entity : entityList) {
            TokuteiKojinJohoKoumokuHanKanriBusiness 項目版管理情報 = new TokuteiKojinJohoKoumokuHanKanriBusiness();
            項目版管理情報.set特定個人情報項目コード(entity.get特定個人情報項目コード());
            項目版管理情報.setバージョン情報(entity.getバージョン情報());
            項目版管理情報.set特定個人情報項目区分(entity.get特定個人情報項目区分());
            項目版管理情報.set無効化フラグ(entity.get無効化フラグ());
            項目版管理情報.set提供内容項目番号(entity.get提供内容項目番号());
            項目版管理情報リスト.add(項目版管理情報);
        }
        return 項目版管理情報リスト;
    }
}
