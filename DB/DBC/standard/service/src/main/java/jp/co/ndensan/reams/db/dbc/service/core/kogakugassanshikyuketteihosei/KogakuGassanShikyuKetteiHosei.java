/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakugassanshikyuketteihosei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanShikyuFushikyuKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanKyufuJisseki;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuFushikyuKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuGakuKeisanKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.AuthorityItemResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.HihokenshaDaichoResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.KogakuGassanShikyuKetteiHoseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.KoshinShoriResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei.ShoriModeHanteiResult;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.KaigoGassan_HokenSeido;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufusakuseikubun.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyuketteihosei.KogakuGassanShikyuGakuKeisanKekkaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyuketteihosei.KogakuGassanShikyuGakuKeisanKekkaUpdateParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyuketteihosei.ShoriModeHanteiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3075KogakuGassanKyufuJissekiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3105SogoJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKetteiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassanshikyuketteihosei.IKogakuGassanShikyuKetteiHoseiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonShikibetsuIDniYoruShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ビジネス設計_DBCMN62004_DBCMNN1005_支給決定情報補正（単）(事業分兼)
 *
 * @reamsid_L DBC-2290-030 quxiaodong
 */
public class KogakuGassanShikyuKetteiHosei {

    private final MapperProvider mapperProvider;
    private final DbV1001HihokenshaDaichoAliveDac 被保険者台帳管理dac;
    private final DbT4001JukyushaDaichoDac 受給者台帳dac;
    private final DbT3105SogoJigyoTaishoshaDac 総合事業対象者dac;
    private final DbT3074KogakuGassanShikyuFushikyuKetteiDac 高額合算支給不支給決定dac;
    private final DbT3174JigyoKogakuGassanShikyuFushikyuKetteiDac 事業高額合算支給不支給決定dac;
    private final DbT3075KogakuGassanKyufuJissekiDac 高額合算給付実績dac;
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final KokanShikibetsuNo 定値交換情報識別番号 = new KokanShikibetsuNo("38Q1");
    private static final RString 処理不可 = new RString("処理不可");
    private static final RString 口座修正モード = new RString("口座修正モード");
    private static final RString 削除照会モード = new RString("削除照会モード");
    private static final RString 支給決定情報補正判定MSG1 = new RString("支給決定情報補正判定Msg1");
    private static final RString 支給決定情報補正判定MSG2 = new RString("支給決定情報補正判定Msg2");
    private static final RString 支給決定情報補正判定MSG3 = new RString("支給決定情報補正判定Msg3");
    private static final RString 支給決定情報補正判定MSG4 = new RString("支給決定情報補正判定Msg4");
    private static final RString 支給決定情報補正判定MSG5 = new RString("支給決定情報補正判定Msg5");
    private static final RString 支給決定情報補正判定MSG6 = new RString("支給決定情報補正判定Msg6");
    private static final Code TWELVE = new Code("12");
    private static final Code THIRTEEN = new Code("13");
    private static final Code TWENTY_ONE = new Code("21");
    private static final Code TWENTY_TWO = new Code("22");
    private static final Code TWENTY_THREE = new Code("23");
    private static final Code TWENTY_FOUR = new Code("24");
    private static final Code TWENTY_FIVE = new Code("25");

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KougakuSabisuhiShikyuuShinnseiTouroku}のインスタンス
     */
    public static KogakuGassanShikyuKetteiHosei createInstance() {
        return InstanceProvider.create(KogakuGassanShikyuKetteiHosei.class);
    }

    /**
     * コンストラクタです。
     */
    public KogakuGassanShikyuKetteiHosei() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.被保険者台帳管理dac = InstanceProvider.create(DbV1001HihokenshaDaichoAliveDac.class);
        this.受給者台帳dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.総合事業対象者dac = InstanceProvider.create(DbT3105SogoJigyoTaishoshaDac.class);
        this.高額合算支給不支給決定dac = InstanceProvider.create(DbT3074KogakuGassanShikyuFushikyuKetteiDac.class);
        this.事業高額合算支給不支給決定dac = InstanceProvider.create(DbT3174JigyoKogakuGassanShikyuFushikyuKetteiDac.class);
        this.高額合算給付実績dac = InstanceProvider.create(DbT3075KogakuGassanKyufuJissekiDac.class);
    }

    /**
     * 高額合算支給額計算結果テーブルから取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 FlexibleYear
     * @param 証記載保険者番号 HokenshaNo
     * @param 支給申請書整理番号 RString
     * @param 事業分フラグ boolean
     * @return List<KogakuGassanShikyuKetteiHoseiResult>
     */
    public List<KogakuGassanShikyuKetteiHoseiResult> selectShikyuKetteiHoseiList(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号,
            boolean 事業分フラグ) {
        List<KogakuGassanShikyuKetteiHoseiResult> result = new ArrayList<>();
        if (事業分フラグ) {
            List<DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity> 事業高額合算list
                    = 事業高額合算支給不支給決定dac.getAllByKey(被保険者番号, 対象年度, 証記載保険者番号, 支給申請書整理番号);
            if (事業高額合算list == null || 事業高額合算list.isEmpty()) {
                return result;
            } else {
                for (DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity entity : 事業高額合算list) {
                    KogakuGassanShikyuKetteiHoseiResult 事業高額合算entity = new KogakuGassanShikyuKetteiHoseiResult();
                    事業高額合算entity.set事業高額合算決定entity(new JigyoKogakuGassanShikyuFushikyuKettei(entity));
                    result.add(事業高額合算entity);
                }
            }
            return result;
        }
        List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> 高額合算list
                = 高額合算支給不支給決定dac.getAllByKey(被保険者番号, 対象年度, 証記載保険者番号, 支給申請書整理番号);
        if (高額合算list == null || 高額合算list.isEmpty()) {
            return result;
        } else {
            for (DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity : 高額合算list) {
                KogakuGassanShikyuKetteiHoseiResult 高額合算entity = new KogakuGassanShikyuKetteiHoseiResult();
                高額合算entity.set高額合算決定entity(new KogakuGassanShikyuFushikyuKettei(entity));
                result.add(高額合算entity);
            }
        }
        return result;
    }

    /**
     * 被保険者台帳管理から「資格喪失年月日」、「喪失事由コード」を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return HihokenshaDaichoResult
     */
    public HihokenshaDaichoResult getHihokenshaDaicho(HihokenshaNo 被保険者番号) {
        HihokenshaDaichoResult result = new HihokenshaDaichoResult();
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り.getMessage());
        }
        DbV1001HihokenshaDaichoEntity 被保険者台帳管理entity = 被保険者台帳管理dac.select被保険者台帳情報(被保険者番号);
        if (被保険者台帳管理entity == null) {
            return null;
        }
        if (被保険者台帳管理entity.getShikakuSoshitsuYMD() != null
                && !被保険者台帳管理entity.getShikakuSoshitsuYMD().isEmpty()) {
            result.set資格喪失年月日(new RDate(被保険者台帳管理entity.getShikakuSoshitsuYMD().toString()));
        }
        result.set喪失事由コード(被保険者台帳管理entity.getShikakuSoshitsuJiyuCode());
        return result;
    }

    /**
     * 被保険者番号、基準日を指定し、「要介護状態区分コード」を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 開始対象計算期間 FlexibleDate
     * @param 終了対象計算期間 FlexibleDate
     * @param 事業分フラグ boolean
     * @return RString
     */
    public RString getYokaigoJotaiKubun(
            HihokenshaNo 被保険者番号,
            FlexibleDate 開始対象計算期間,
            FlexibleDate 終了対象計算期間,
            boolean 事業分フラグ) {
        RString 給付の種類 = null;
        if (事業分フラグ) {
            給付の種類 = DbBusinessConfig.get(ConfigNameDBC.支給決定情報補正_給付の種類_事業分,
                    RDate.getNowDate(), SubGyomuCode.DBC介護給付);
            return 給付の種類;
        }
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り.getMessage());
        }
        DbT4001JukyushaDaichoEntity 受給者台帳entity = 受給者台帳dac.get要介護状態区分(
                被保険者番号, 開始対象計算期間, 終了対象計算期間);
        if (受給者台帳entity != null) {
            if (TWENTY_ONE.equals(受給者台帳entity.getYokaigoJotaiKubunCode())
                    || TWENTY_TWO.equals(受給者台帳entity.getYokaigoJotaiKubunCode())
                    || TWENTY_THREE.equals(受給者台帳entity.getYokaigoJotaiKubunCode())
                    || TWENTY_FOUR.equals(受給者台帳entity.getYokaigoJotaiKubunCode())
                    || TWENTY_FIVE.equals(受給者台帳entity.getYokaigoJotaiKubunCode())) {
                給付の種類 = DbBusinessConfig.get(ConfigNameDBC.支給決定情報補正_給付の種類_要介護,
                        RDate.getNowDate(), SubGyomuCode.DBC介護給付);
            } else if (TWELVE.equals(受給者台帳entity.getYokaigoJotaiKubunCode())
                    || THIRTEEN.equals(受給者台帳entity.getYokaigoJotaiKubunCode())) {
                給付の種類 = DbBusinessConfig.get(ConfigNameDBC.支給決定情報補正_給付の種類_要支援,
                        RDate.getNowDate(), SubGyomuCode.DBC介護給付);
            }
            return 給付の種類;
        }
        return 給付の種類;
    }

    /**
     * 処理モード判定を行い。モードとメッセージ内容を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 証記載保険者番号 HokenshaNo
     * @param 支給申請書整理番号 RString
     * @param 対象年度 FlexibleYear
     * @param 受取年月 FlexibleYearMonth
     * @param 支給区分 RString
     * @param 処理区分 RString
     * @return ShoriModeHanteiResult
     */
    public ShoriModeHanteiResult shoriModeHantei(
            HihokenshaNo 被保険者番号,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号,
            FlexibleYear 対象年度,
            FlexibleYearMonth 受取年月,
            RString 支給区分,
            RString 処理区分) {
        ShoriModeHanteiResult result = new ShoriModeHanteiResult();
        List<KogakuGassanShikyuFushikyuKettei> 高額合算決定情報 = getshoriModeHantei_One(
                被保険者番号, 対象年度, 証記載保険者番号, 支給申請書整理番号);
        KogakuGassanKyufuJisseki 給付実績基本情報 = getshoriModeHantei_Two(
                被保険者番号, 証記載保険者番号, 支給申請書整理番号);
        KogakuGassanShikyuGakuKeisanKekka 高額合算支給額情報 = getshoriModeHantei_Three(
                被保険者番号, 対象年度, 証記載保険者番号, 支給申請書整理番号);
        boolean flag1 = ((高額合算決定情報 != null && !高額合算決定情報.isEmpty())
                && ((高額合算決定情報.get(0).get受取年月() != null && !高額合算決定情報.get(0).get受取年月().isEmpty())
                || ((高額合算決定情報.get(0).get受取年月() == null || 高額合算決定情報.get(0).get受取年月().isEmpty())
                && ONE.equals(高額合算決定情報.get(0).get支給区分コード()))));
        boolean flag2 = (受取年月 != null && !受取年月.isEmpty() || ((受取年月 == null || 受取年月.isEmpty())
                && ONE.equals(支給区分)));
        if (給付実績基本情報 == null) {
            get給付実績基本情報のデータが存在しない場合(処理区分, 高額合算支給額情報, 高額合算決定情報, result, flag1, flag2);
            return result;
        }
        boolean 支給額フラグ = get支給額フラグ(高額合算決定情報, 給付実績基本情報);
        if (KyufuSakuseiKubun.新規.getコード().equals(給付実績基本情報.get給付実績作成区分コード())
                || KyufuSakuseiKubun.修正.getコード().equals(給付実績基本情報.get給付実績作成区分コード())) {
            if (高額合算支給額情報 == null) {
                get高額合算支給額情報のデータが存在しない場合(処理区分, 支給額フラグ, 高額合算決定情報, result);
            } else {
                get高額合算支給額情報のデータが存在し場合(処理区分, 給付実績基本情報,
                        高額合算支給額情報, 高額合算決定情報, result);
            }
        } else if (KyufuSakuseiKubun.削除.getコード().equals(給付実績基本情報.get給付実績作成区分コード())) {
            if (!支給額フラグ) {
                get処理区分の場合(処理区分, result);
            } else {
                if (get不支給受取年月フラグ(高額合算決定情報)) {
                    get処理区分の場合(処理区分, result);
                }
            }
        }
        return result;
    }

    /**
     * 画面のデータをＤＢに追加する。 （高額合算支給不支給決定TBL）
     *
     * @param 画面DIV KoshinShoriResult
     * @param 処理モード RString
     * @return boolean
     */
    @Transaction
    public boolean isKoshinShori(
            KoshinShoriResult 画面DIV,
            RString 処理モード) {
        if (画面DIV != null) {
            get更新高額合算支給不支給決定(画面DIV.get高額合算支給不支給決定Entity(), 処理モード);
            get更新高額合算給付実績(処理モード, 画面DIV);
        }
        return true;
    }

    private void get更新高額合算給付実績(RString 処理モード, KoshinShoriResult 画面DIV) {
        if (画面DIV.getUpdate合算給付実績パラメータ() != null) {
            KogakuGassanKyufuJisseki 更新data = getshoriModeHantei_Two(画面DIV.getUpdate合算給付実績パラメータ().
                    get更新後被保険者番号(), 画面DIV.getUpdate合算給付実績パラメータ().
                    get更新後証記載保険者番号(), 画面DIV.getUpdate合算給付実績パラメータ().
                    get更新後支給申請書整理番号());
            if (!処理モード.equals(ONE) && 更新data == null) {
                return;
            }
            if (!処理モード.equals(ONE)) {
                set更新条件(更新data, 画面DIV.getUpdate合算給付実績パラメータ());
            }
            IKogakuGassanShikyuKetteiHoseiMapper mapper = mapperProvider.create(
                    IKogakuGassanShikyuKetteiHoseiMapper.class);
            if (THREE.equals(処理モード)) {
                mapper.logicalDelete高額合算給付実績(画面DIV.getUpdate合算給付実績パラメータ());
            } else if (ONE.equals(処理モード) || TWO.equals(処理モード)) {
                update給付実績データ(更新data, 画面DIV, mapper);
            }
        }
    }

    private void update給付実績データ(KogakuGassanKyufuJisseki 更新data,
            KoshinShoriResult 画面DIV,
            IKogakuGassanShikyuKetteiHoseiMapper mapper) {
        if (更新data == null && ONE.equals(画面DIV.get高額合算支給不支給決定Entity().get支給区分コード())) {
            RString 整理番号 = Saiban.get(SubGyomuCode.DBC介護給付,
                    SaibanHanyokeyName.高額合算給付実績整理番号.get名称(), FlexibleDate.
                    getNowDate().getNendo()).nextString();
            DbT3075KogakuGassanKyufuJissekiEntity 新規data = new DbT3075KogakuGassanKyufuJissekiEntity();
            新規data.setKokanJohoShikibetsuNo(定値交換情報識別番号);
            新規data.setHihokenshaNo(画面DIV.getUpdate合算給付実績パラメータ().get更新後被保険者番号());
            新規data.setShikyuShinseiSeiriNo(画面DIV.getUpdate合算給付実績パラメータ().get更新後支給申請書整理番号());
            新規data.setSeiriNo(整理番号);
            新規data.setJikoFutanSeiriNo(画面DIV.getUpdate合算給付実績パラメータ().get更新後自己負担額証明書整理番号());
            新規data.setHokenSeidoCode(KaigoGassan_HokenSeido.介護.getCode());
            新規data.setKyufuJissekiSakuseiKubunCode(ONE);
            新規data.setShoKisaiHokenshaNo(画面DIV.getUpdate合算給付実績パラメータ().get更新後証記載保険者番号());
            新規data.setShinseiYMD(画面DIV.getUpdate合算給付実績パラメータ().get更新後申請年月日());
            新規data.setKetteiYMD(画面DIV.getUpdate合算給付実績パラメータ().get更新後決定年月日());
            新規data.setJikoFutanSogaku(画面DIV.getUpdate合算給付実績パラメータ().get更新後自己負担総額());
            新規data.setShikyuGaku(画面DIV.getUpdate合算給付実績パラメータ().get更新後支給額());
            新規data.setDataKubun(ZERO);
            新規data.setState(EntityDataState.Added);
            高額合算給付実績dac.save(新規data);
        } else if (更新data != null && (ONE.equals(更新data.get給付実績作成区分コード())
                || TWO.equals(更新data.get給付実績作成区分コード()))
                && 画面DIV.getUpdate合算給付実績パラメータ().isFlag()) {
            if (ZERO.equals(画面DIV.get高額合算支給不支給決定Entity().get支給区分コード())) {
                mapper.physicalDelete高額合算給付実績(画面DIV.getUpdate合算給付実績パラメータ());
            } else {
                mapper.update高額合算給付実績(画面DIV.getUpdate合算給付実績パラメータ());
            }
        } else if (更新data != null && THREE.equals(更新data.get給付実績作成区分コード())
                && ONE.equals(画面DIV.get高額合算支給不支給決定Entity().get支給区分コード())) {
            RString 整理番号 = Saiban.get(SubGyomuCode.DBC介護給付,
                    SaibanHanyokeyName.高額合算給付実績整理番号.get名称(), FlexibleDate.
                    getNowDate().getNendo()).nextString();
            DbT3075KogakuGassanKyufuJissekiEntity 新規data = new DbT3075KogakuGassanKyufuJissekiEntity();
            新規data.setKokanJohoShikibetsuNo(定値交換情報識別番号);
            新規data.setHihokenshaNo(画面DIV.getUpdate合算給付実績パラメータ().get更新後被保険者番号());
            新規data.setShikyuShinseiSeiriNo(画面DIV.getUpdate合算給付実績パラメータ().get更新後支給申請書整理番号());
            新規data.setSeiriNo(整理番号);
            新規data.setJikoFutanSeiriNo(画面DIV.getUpdate合算給付実績パラメータ().get更新後自己負担額証明書整理番号());
            新規data.setHokenSeidoCode(KaigoGassan_HokenSeido.介護.getCode());
            新規data.setKyufuJissekiSakuseiKubunCode(ONE);
            新規data.setShoKisaiHokenshaNo(画面DIV.getUpdate合算給付実績パラメータ().get更新後証記載保険者番号());
            新規data.setShinseiYMD(画面DIV.getUpdate合算給付実績パラメータ().get更新後申請年月日());
            新規data.setKetteiYMD(画面DIV.getUpdate合算給付実績パラメータ().get更新後決定年月日());
            新規data.setJikoFutanSogaku(画面DIV.getUpdate合算給付実績パラメータ().get更新後自己負担総額());
            新規data.setShikyuGaku(画面DIV.getUpdate合算給付実績パラメータ().get更新後支給額());
            新規data.setDataKubun(ZERO);
            新規data.setState(EntityDataState.Added);
            高額合算給付実績dac.save(新規data);
        }
    }

    /**
     * 支給額取得
     *
     * @param 支給申請書整理番号 RString
     * @return Decimal
     */
    public Decimal get支給額(RString 支給申請書整理番号) {
        Decimal 支給額 = Decimal.ZERO;
        List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> 高額合算支給不支給決定データ = 高額合算支給不支給決定dac.
                get高額合算支給不支給決定データ(支給申請書整理番号);
        for (DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity : 高額合算支給不支給決定データ) {
            支給額 = 支給額.add(entity.getShikyugaku());
        }
        return 支給額;
    }

    private void set更新条件(
            KogakuGassanKyufuJisseki 更新data,
            KogakuGassanShikyuGakuKeisanKekkaUpdateParameter 更新para) {
        if (更新para != null) {
            更新para.set更新前交換情報識別番号(更新data.get交換情報識別番号());
            更新para.set更新前被保険者番号(更新data.get被保険者番号());
            更新para.set更新前支給申請書整理番号(更新data.get支給申請書整理番号());
            更新para.set更新前整理番号(更新data.get整理番号());
            更新para.set更新前自己負担額証明書整理番号(更新data.get自己負担額証明書整理番号());
            更新para.set更新前保険制度コード(更新data.get保険制度コード());
            更新para.set更新前給付実績作成区分コード(更新data.get給付実績作成区分コード());
            更新para.set更新前証記載保険者番号(更新data.get証記載保険者番号());
            更新para.set更新前国保_被保険者証記号(更新data.get国保_被保険者証記号());
            更新para.set更新前申請年月日(更新data.get申請年月日());
            更新para.set更新前決定年月日(更新data.get決定年月日());
            更新para.set更新前自己負担総額(更新data.get自己負担総額());
            更新para.set更新前支給額(更新data.get支給額());
            更新para.set更新前処理年月(更新data.get処理年月());
            更新para.set更新前受取年月(更新data.get受取年月());
            更新para.set更新前送付年月(更新data.get送付年月());
            更新para.set更新前データ区分(更新data.getデータ区分());
            更新para.set更新前論理削除(更新data.is論理削除());
        }
    }

    /**
     * 画面のデータをＤＢに追加する。　（事業高額合算支給不支給決定TBL）
     *
     * @param 画面DIV KoshinShoriResult
     * @param 処理モード RString
     * @return boolean
     */
    @Transaction
    public boolean isKoshinShoriJigyo(
            JigyoKogakuGassanShikyuFushikyuKettei 画面DIV,
            RString 処理モード) {
        if (画面DIV != null && (ONE.equals(処理モード) || TWO.equals(処理モード))
                && !EntityDataState.Unchanged.equals(画面DIV.toEntity().getState())) {
            事業高額合算支給不支給決定dac.save(画面DIV.toEntity());
        } else if (画面DIV != null && THREE.equals(処理モード)
                && EntityDataState.Deleted.equals(画面DIV.toEntity().getState())) {
            事業高額合算支給不支給決定dac.save(画面DIV.toEntity());
        }
        return true;
    }

    /**
     * 受給者台帳データ取得です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return JukyushaDaicho
     */
    public List<JukyushaDaicho> get受給者台帳データ(HihokenshaNo 被保険者番号) {
        List<JukyushaDaicho> 受給者台帳list = new ArrayList<>();
        List<DbT4001JukyushaDaichoEntity> 受給者台帳データ = 受給者台帳dac.get受給者台帳データ(被保険者番号);
        if (受給者台帳データ == null || 受給者台帳データ.isEmpty()) {
            return 受給者台帳list;
        }
        for (DbT4001JukyushaDaichoEntity entity : 受給者台帳データ) {
            受給者台帳list.add(new JukyushaDaicho(entity));
        }
        return 受給者台帳list;
    }

    /**
     * 受給者台帳データ取得です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return JukyushaDaicho
     */
    public List<SogoJigyoTaishosha> get総合事業対象者データ(HihokenshaNo 被保険者番号) {
        List<SogoJigyoTaishosha> 総合事業対象者list = new ArrayList<>();
        List<DbT3105SogoJigyoTaishoshaEntity> 受給者台帳データ = 総合事業対象者dac.get総合事業対象者(被保険者番号);
        if (受給者台帳データ == null || 受給者台帳データ.isEmpty()) {
            return 総合事業対象者list;
        }
        for (DbT3105SogoJigyoTaishoshaEntity entity : 受給者台帳データ) {
            総合事業対象者list.add(new SogoJigyoTaishosha(entity));
        }
        return 総合事業対象者list;
    }

    /**
     * 市町村セキュリティ情報を取得し単一市町村と広域市町村の判断をするです。
     *
     * @param reamsLoginId RString
     * @param 保険者構成 RString
     * @return AuthorityItemResult
     */
    public AuthorityItemResult get市町村セキュリティ情報(RString reamsLoginId, RString 保険者構成) {
        AuthorityItemResult result = new AuthorityItemResult();
        if (TWO.equals(保険者構成)) {
            setResult(reamsLoginId, result);
        } else if (ONE.equals(保険者構成)) {
            setResult(reamsLoginId, result);
        }
        return result;
    }

    private void setResult(RString reamsLoginId, AuthorityItemResult result) {
        List<AuthorityItem> 市町村識別list = ShichosonSecurityJoho.getShichosonShikibetsuId(reamsLoginId);
        if (市町村識別list != null && !市町村識別list.isEmpty()) {
            SearchResult<ShichosonShikibetsuIDniYoruShichosonJoho> 市町村情報取得 = KoikiShichosonJohoFinder.
                    createInstance().loginUserShichosonJoho(市町村識別list.get(0).getItemId());
            if (市町村情報取得.records() != null && !市町村情報取得.records().isEmpty()) {
                result.setWk保険者番号(市町村情報取得.records().get(0).get証記載保険者番号());
                result.setWk構成市町村情報(市町村情報取得.records());
            }
        }
    }

    /**
     * 高額決定履歴番取得です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 FlexibleYear
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 RString
     * @return int
     */
    public int get高額決定Max履歴番号(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号) {
        int 履歴番号 = 1;
        DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity = 高額合算支給不支給決定dac.getMax履歴番号のentity(
                被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号);
        if (entity != null) {
            履歴番号 = entity.getRirekiNo() + 1;
        }
        return 履歴番号;
    }

    /**
     * 事業高額決定履歴番取得です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 FlexibleYear
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 RString
     * @return int
     */
    public int get事業高額決定Max履歴番号(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号) {
        int 履歴番号 = 1;
        DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity entity = 事業高額合算支給不支給決定dac.getMax履歴番号のentity(
                被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号);
        if (entity != null) {
            履歴番号 = entity.getRirekiNo() + 1;
        }
        return 履歴番号;
    }

    private void get更新高額合算支給不支給決定(
            KogakuGassanShikyuFushikyuKettei 高額合算Entity,
            RString 処理モード) {
        if (高額合算Entity != null && (ONE.equals(処理モード) || TWO.equals(処理モード))
                && !EntityDataState.Unchanged.equals(高額合算Entity.toEntity().getState())) {
            高額合算支給不支給決定dac.save(高額合算Entity.toEntity());
        } else if (高額合算Entity != null && THREE.equals(処理モード)
                && EntityDataState.Deleted.equals(高額合算Entity.toEntity().getState())) {
            高額合算支給不支給決定dac.save(高額合算Entity.toEntity());
        }
    }

    private void get給付実績基本情報のデータが存在しない場合(
            RString 処理区分,
            KogakuGassanShikyuGakuKeisanKekka 高額合算支給額情報,
            List<KogakuGassanShikyuFushikyuKettei> 高額合算決定情報,
            ShoriModeHanteiResult result,
            boolean flag1,
            boolean flag2) {
        if (ONE.equals(処理区分) && (高額合算決定情報 == null
                || 高額合算決定情報.isEmpty()) && 高額合算支給額情報 != null) {
            result.setWkモード(処理不可);
            result.setWkメッセージ(支給決定情報補正判定MSG1);

        } else if (ONE.equals(処理区分) && (高額合算決定情報 != null && !高額合算決定情報.isEmpty())
                && flag1) {
            result.setWkモード(処理不可);
            result.setWkメッセージ(支給決定情報補正判定MSG1);
        } else if (TWO.equals(処理区分) && flag2) {
            result.setWkモード(口座修正モード);
            result.setWkメッセージ(支給決定情報補正判定MSG2);
        } else if (THREE.equals(処理区分) && flag2) {
            result.setWkモード(削除照会モード);
            result.setWkメッセージ(支給決定情報補正判定MSG3);
        }
    }

    private void get処理区分の場合(RString 処理区分, ShoriModeHanteiResult result) {
        if (ONE.equals(処理区分)) {
            result.setWkモード(処理不可);
            result.setWkメッセージ(支給決定情報補正判定MSG1);
        } else if (TWO.equals(処理区分)) {
            result.setWkモード(口座修正モード);
            result.setWkメッセージ(支給決定情報補正判定MSG2);
        } else if (THREE.equals(処理区分)) {
            result.setWkモード(削除照会モード);
            result.setWkメッセージ(支給決定情報補正判定MSG3);
        }
    }

    private void get高額合算支給額情報のデータが存在し場合(
            RString 処理区分,
            KogakuGassanKyufuJisseki 給付実績基本情報,
            KogakuGassanShikyuGakuKeisanKekka 高額合算支給額情報,
            List<KogakuGassanShikyuFushikyuKettei> 高額合算決定情報,
            ShoriModeHanteiResult result) {
        if (給付実績基本情報.get支給額() != null && 高額合算支給額情報.get按分後支給額() != null
                && !高額合算支給額情報.get按分後支給額().equals(給付実績基本情報.get支給額())) {
            if (!get支給額フラグ(高額合算決定情報, 給付実績基本情報) && ONE.equals(処理区分)) {
                result.setWkモード(処理不可);
                result.setWkメッセージ(支給決定情報補正判定MSG1);
            } else if (!get支給額フラグ(高額合算決定情報, 給付実績基本情報) && TWO.equals(処理区分)) {
                result.setWkモード(口座修正モード);
                result.setWkメッセージ(支給決定情報補正判定MSG2);
            } else if (!get支給額フラグ(高額合算決定情報, 給付実績基本情報) && THREE.equals(処理区分)) {
                result.setWkモード(削除照会モード);
                result.setWkメッセージ(支給決定情報補正判定MSG3);
            }
        }

    }

    private boolean get不支給受取年月フラグ(List<KogakuGassanShikyuFushikyuKettei> 高額合算決定情報) {
        boolean flag = false;
        if ((高額合算決定情報 != null && !高額合算決定情報.isEmpty()) && (高額合算決定情報.get(0).get受取年月() != null
                && !高額合算決定情報.get(0).get受取年月().isEmpty())
                && TWO.equals(高額合算決定情報.get(0).get支給区分コード())) {
            flag = true;
        }
        return flag;
    }

    private void get高額合算支給額情報のデータが存在しない場合(
            RString 処理区分,
            boolean 支給額フラグ,
            List<KogakuGassanShikyuFushikyuKettei> 高額合算決定情報,
            ShoriModeHanteiResult result) {
        if (ONE.equals(処理区分) && (!支給額フラグ || get受取年月フラグ(高額合算決定情報, 支給額フラグ))) {
            result.setWkモード(処理不可);
            result.setWkメッセージ(支給決定情報補正判定MSG4);
        } else if (TWO.equals(処理区分) && (!支給額フラグ || is受取年月フラ(高額合算決定情報))) {
            result.setWkモード(口座修正モード);
            result.setWkメッセージ(支給決定情報補正判定MSG5);
        } else if (THREE.equals(処理区分) && (!支給額フラグ || is受取年月フラ(高額合算決定情報))) {
            result.setWkモード(削除照会モード);
            result.setWkメッセージ(支給決定情報補正判定MSG6);
        }
    }

    private boolean is受取年月フラ(List<KogakuGassanShikyuFushikyuKettei> 高額合算決定情報) {
        boolean flag = true;
        for (KogakuGassanShikyuFushikyuKettei entity : 高額合算決定情報) {
            if (entity.get受取年月() == null || entity.get受取年月().isEmpty()) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private boolean get受取年月フラグ(
            List<KogakuGassanShikyuFushikyuKettei> 高額合算決定情報,
            boolean 支給額フラグ) {
        boolean flag = false;
        if (支給額フラグ && (高額合算決定情報 != null && !高額合算決定情報.isEmpty())
                && (高額合算決定情報.get(0).get受取年月() != null
                && !高額合算決定情報.get(0).get受取年月().isEmpty())) {
            flag = true;
        }
        return flag;
    }

    private boolean get支給額フラグ(
            List<KogakuGassanShikyuFushikyuKettei> 高額合算決定情報,
            KogakuGassanKyufuJisseki 給付実績基本情報) {
        boolean flag = false;
        if (高額合算決定情報 != null && !高額合算決定情報.isEmpty()) {
            Decimal 支給額 = Decimal.ZERO;
            for (KogakuGassanShikyuFushikyuKettei entity : 高額合算決定情報) {
                if (ONE.equals(entity.get支給区分コード())) {
                    支給額 = 支給額.add(entity.get支給額());
                }
            }
            if (支給額.equals(給付実績基本情報.get支給額())) {
                flag = true;
            }
        }
        return flag;
    }

    private List<KogakuGassanShikyuFushikyuKettei> getshoriModeHantei_One(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号) {
        List<KogakuGassanShikyuFushikyuKettei> result = new ArrayList<>();
        List<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> 高額合算list = 高額合算支給不支給決定dac.getAll(
                被保険者番号, 対象年度, 証記載保険者番号, 支給申請書整理番号);
        if (高額合算list == null || 高額合算list.isEmpty()) {
            return result;
        }
        for (DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity : 高額合算list) {
            result.add(new KogakuGassanShikyuFushikyuKettei(entity));
        }
        return result;
    }

    private KogakuGassanKyufuJisseki getshoriModeHantei_Two(
            HihokenshaNo 被保険者番号,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号) {
        IKogakuGassanShikyuKetteiHoseiMapper mapper = mapperProvider.create(IKogakuGassanShikyuKetteiHoseiMapper.class);
        ShoriModeHanteiParameter parameter = new ShoriModeHanteiParameter(
                被保険者番号, 証記載保険者番号, 支給申請書整理番号);
        List<DbT3075KogakuGassanKyufuJissekiEntity> 高額合算給付実績list = mapper.get高額合算給付実績(parameter);
        if (高額合算給付実績list == null || 高額合算給付実績list.isEmpty()) {
            return null;
        }
        if (高額合算給付実績list.size() == 1) {
            return new KogakuGassanKyufuJisseki(高額合算給付実績list.get(0));
        }
        if (高額合算給付実績list.get(0).getShoriYM() == null
                || 高額合算給付実績list.get(0).getShoriYM().isEmpty()) {
            return new KogakuGassanKyufuJisseki(高額合算給付実績list.get(0));
        } else {
            if (高額合算給付実績list.get(高額合算給付実績list.size() - 1).getShoriYM() == null
                    || 高額合算給付実績list.get(高額合算給付実績list.size() - 1).getShoriYM().isEmpty()) {
                return new KogakuGassanKyufuJisseki(高額合算給付実績list.get(高額合算給付実績list.size() - 1));
            } else {
                return new KogakuGassanKyufuJisseki(高額合算給付実績list.get(0));
            }
        }
    }

    private KogakuGassanShikyuGakuKeisanKekka getshoriModeHantei_Three(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号) {
        IKogakuGassanShikyuKetteiHoseiMapper mapper = mapperProvider.create(IKogakuGassanShikyuKetteiHoseiMapper.class);
        KogakuGassanShikyuGakuKeisanKekkaParameter parameter = new KogakuGassanShikyuGakuKeisanKekkaParameter(
                被保険者番号, 対象年度, 証記載保険者番号, 支給申請書整理番号);
        DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity 高額合算支給額計算結果entity
                = mapper.get高額合算支給額計算結果(parameter);
        if (高額合算支給額計算結果entity == null) {
            return null;
        }
        return new KogakuGassanShikyuGakuKeisanKekka(高額合算支給額計算結果entity);
    }

}
