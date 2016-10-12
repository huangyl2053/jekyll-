package jp.co.ndensan.reams.db.dbu.service.core.tokuteikojinjohoteikyo;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.business.core.basic.TokuteiKojinJohoHanKanri;
import jp.co.ndensan.reams.db.dbu.business.core.tokuteikojinjohoteikyo.TokuteiKojinJohoKoumokuHanKanriBusiness;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShokaiTeikyoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TeikyoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TeikyoYohi;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoParamater;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7301TokuteiKojinJohoHanKanriEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7304TokuteiKojinJohoTeikyoKanriEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TokuteiKojinJohoKoumokuHanKanriRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.basic.DbT7304TokuteiKojinJohoTeikyoKanriDac;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo.ITokuteiKojinJohoTeikyoForServiceMapper;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 特定個人情報提供のManagerクラスです。
 *
 * @reamsid_L DBU-4880-110 dingyi
 *
 */
public class TokuteiKojinJohoTeikyoManager {

    private final MapperProvider mapperProvider;
    private final DbT7304TokuteiKojinJohoTeikyoKanriDac 特定個人情報提供管理dac;
    private static final RString 文字列_異動区分 = new RString("異動区分");
    private static final RString 文字列_特定個人情報名コード = new RString("特定個人情報名コード");
    private static final RString 文字列_データセット番号 = new RString("データセット番号");
    private static final RString 文字列_版番号 = new RString("版番号");

    /**
     * コンストラクタです。
     */
    public TokuteiKojinJohoTeikyoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.特定個人情報提供管理dac = InstanceProvider.create(DbT7304TokuteiKojinJohoTeikyoKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 特定個人情報提供管理dac 特定個人情報提供管理dac
     */
    TokuteiKojinJohoTeikyoManager(MapperProvider mapperProvider, DbT7304TokuteiKojinJohoTeikyoKanriDac 特定個人情報提供管理dac) {
        this.mapperProvider = mapperProvider;
        this.特定個人情報提供管理dac = 特定個人情報提供管理dac;
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
    @Transaction
    public List<TokuteiKojinJohoHanKanri> get版番号(RString 異動区分, RString 特定個人情報名コード,
            RString データセット番号, FlexibleDate 基準日) {
        requireNonNull(異動区分, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_異動区分.toString()));
        requireNonNull(特定個人情報名コード, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_特定個人情報名コード.toString()));
        requireNonNull(データセット番号, UrSystemErrorMessages.値がnull.getReplacedMessage(文字列_データセット番号.toString()));
        List<TokuteiKojinJohoHanKanri> 特定個人版管理特定情報リスト = new ArrayList<>();
        ITokuteiKojinJohoTeikyoForServiceMapper mapper = mapperProvider.create(ITokuteiKojinJohoTeikyoForServiceMapper.class);
        RString 版番号 = RString.EMPTY;
        RString 初回提供区分 = ShokaiTeikyoKubun.未提供.getコード();
        if (基準日 == null || 基準日.isEmpty()) {
            基準日 = FlexibleDate.getNowDate();
        }
        List<DbT7301TokuteiKojinJohoHanKanriEntity> entityList;
        if (ShinkiIdoKubun.当初.getコード().equals(異動区分) || ShinkiIdoKubun.版改定.getコード().equals(異動区分)) {
            entityList = mapper.get有効な版番号(TokuteiKojinJohoTeikyoParamater.createParamter版番号取得(
                    特定個人情報名コード, データセット番号, 基準日));
        } else if (ShinkiIdoKubun.再登録.getコード().equals(異動区分) || ShinkiIdoKubun.異動.getコード().equals(異動区分)) {
            entityList = mapper.get初回提供済である直近の版番号(TokuteiKojinJohoTeikyoParamater.createParamter版番号取得(
                    特定個人情報名コード, データセット番号, 基準日));
        } else {
            entityList = mapper.get直近の版番号(TokuteiKojinJohoTeikyoParamater.createParamter版番号取得(
                    特定個人情報名コード, データセット番号, 基準日));
        }
        if (entityList == null || entityList.isEmpty()) {
            特定個人版管理特定情報リスト.add(new TokuteiKojinJohoHanKanri(特定個人情報名コード, データセット番号, 版番号).
                    createBuilderForEdit().set版番号(版番号).set初回提供区分(初回提供区分).build());
        } else {
            特定個人版管理特定情報リスト.add(new TokuteiKojinJohoHanKanri(entityList.get(0)));
        }

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
    @Transaction
    public List<TokuteiKojinJohoHanKanri> get版番号(RString 異動区分, List<RString> 特定個人情報名コードリスト,
            RString データセット番号, FlexibleDate 基準日) {
        List<TokuteiKojinJohoHanKanri> 特定個人版管理特定情報 = new ArrayList<>();
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
    @Transaction
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
    @Transaction
    public void update特定個人情報提供(RString 中間DBのテーブル名, RString 新規異動区分, RString 特定個人情報名コード,
            RString データセット番号, RString 版番号) {
        RDateTime システム日時 = RDateTime.now();
        ITokuteiKojinJohoTeikyoForServiceMapper mapper = mapperProvider.create(ITokuteiKojinJohoTeikyoForServiceMapper.class);
        List<TeikyoKihonJohoNNTempEntity> 中間DB提供基本情報 = mapper.get中間DB提供基本情報(
                TokuteiKojinJohoTeikyoParamater.createParamter中間DB提供基本情報取得(中間DBのテーブル名));
        for (TeikyoKihonJohoNNTempEntity entity : 中間DB提供基本情報) {
            DbT7304TokuteiKojinJohoTeikyoKanriEntity 提供基本情報 = 特定個人情報提供管理dac.selectByKey(
                    entity.getHihokenshaNo(), entity.getDataSetKey());
            set提供基本情報(entity, システム日時, 新規異動区分, 特定個人情報名コード, データセット番号, 版番号, 提供基本情報);
        }

    }

    /**
     * 特定個人情報提供管理の版番号カウントを取得します。
     *
     * @return 版番号カウント
     */
    @Transaction
    public int get版番号カウント() {
        return 特定個人情報提供管理dac.get版番号カウント(TeikyoKubun.提供済み.getコード());
    }

    private DbT7304TokuteiKojinJohoTeikyoKanriEntity set提供基本情報(TeikyoKihonJohoNNTempEntity entity,
            RDateTime システム日時, RString 新規異動区分, RString 特定個人情報名コード,
            RString データセット番号, RString 版番号, DbT7304TokuteiKojinJohoTeikyoKanriEntity dbT7304Entity) {
        DbT7304TokuteiKojinJohoTeikyoKanriEntity 提供基本情報 = new DbT7304TokuteiKojinJohoTeikyoKanriEntity();
        if (dbT7304Entity != null) {
            提供基本情報 = dbT7304Entity.clone();
            提供基本情報.setState(EntityDataState.Modified);
        } else {
            提供基本情報.setState(EntityDataState.Added);
        }
        提供基本情報.setHihokenshaNo(entity.getHihokenshaNo());
        提供基本情報.setDataSetRecordKey(entity.getDataSetKey());
        提供基本情報.setTeikyoNichiji(システム日時);
        提供基本情報.setShinkiIdoKubun(新規異動区分);
        提供基本情報.setTokuteiKojinJohoMeiCode(特定個人情報名コード);
        提供基本情報.setHanNo(版番号);
        提供基本情報.setDataSetNo(データセット番号);
        提供基本情報.setKokaiYMD(entity.getKokaiYMD());
        提供基本情報.setTateNo(entity.getShikibetsuCode());
        if (TeikyoYohi.提供要.getコード().equals(entity.getTeikyoKubun())) {
            提供基本情報.setTeikyoKubun(TeikyoKubun.提供済み.getコード());
            提供基本情報.setSoshinNaiyo01(entity.getTeikyoNaiyo01());
            提供基本情報.setMisetteiJiyu01(entity.getMisetteiJiyu01());
            提供基本情報.setSoshinNaiyo02(entity.getTeikyoNaiyo02());
            提供基本情報.setMisetteiJiyu02(entity.getMisetteiJiyu02());
            提供基本情報.setSoshinNaiyo03(entity.getTeikyoNaiyo03());
            提供基本情報.setMisetteiJiyu03(entity.getMisetteiJiyu03());
            提供基本情報.setSoshinNaiyo04(entity.getTeikyoNaiyo04());
            提供基本情報.setMisetteiJiyu04(entity.getMisetteiJiyu04());
            提供基本情報.setSoshinNaiyo05(entity.getTeikyoNaiyo05());
            提供基本情報.setMisetteiJiyu05(entity.getMisetteiJiyu05());
            提供基本情報.setSoshinNaiyo06(entity.getTeikyoNaiyo06());
            提供基本情報.setMisetteiJiyu06(entity.getMisetteiJiyu06());
            提供基本情報.setSoshinNaiyo07(entity.getTeikyoNaiyo07());
            提供基本情報.setMisetteiJiyu07(entity.getMisetteiJiyu07());
            提供基本情報.setSoshinNaiyo08(entity.getTeikyoNaiyo08());
            提供基本情報.setMisetteiJiyu08(entity.getMisetteiJiyu08());
            提供基本情報.setSoshinNaiyo09(entity.getTeikyoNaiyo09());
            提供基本情報.setMisetteiJiyu09(entity.getMisetteiJiyu09());
            提供基本情報.setSoshinNaiyo10(entity.getTeikyoNaiyo10());
            提供基本情報.setMisetteiJiyu10(entity.getMisetteiJiyu10());
        } else {
            提供基本情報.setTeikyoKubun(TeikyoKubun.個人番号未設定により未提供.getコード());
            提供基本情報.setSoshinNaiyo01(RString.EMPTY);
            提供基本情報.setMisetteiJiyu01(RString.EMPTY);
            提供基本情報.setSoshinNaiyo02(RString.EMPTY);
            提供基本情報.setMisetteiJiyu02(RString.EMPTY);
            提供基本情報.setSoshinNaiyo03(RString.EMPTY);
            提供基本情報.setMisetteiJiyu03(RString.EMPTY);
            提供基本情報.setSoshinNaiyo04(RString.EMPTY);
            提供基本情報.setMisetteiJiyu04(RString.EMPTY);
            提供基本情報.setSoshinNaiyo05(RString.EMPTY);
            提供基本情報.setMisetteiJiyu05(RString.EMPTY);
            提供基本情報.setSoshinNaiyo06(RString.EMPTY);
            提供基本情報.setMisetteiJiyu06(RString.EMPTY);
            提供基本情報.setSoshinNaiyo07(RString.EMPTY);
            提供基本情報.setMisetteiJiyu07(RString.EMPTY);
            提供基本情報.setSoshinNaiyo08(RString.EMPTY);
            提供基本情報.setMisetteiJiyu08(RString.EMPTY);
            提供基本情報.setSoshinNaiyo09(RString.EMPTY);
            提供基本情報.setMisetteiJiyu09(RString.EMPTY);
            提供基本情報.setSoshinNaiyo10(RString.EMPTY);
            提供基本情報.setMisetteiJiyu10(RString.EMPTY);
        }
        return 提供基本情報;
    }
}
