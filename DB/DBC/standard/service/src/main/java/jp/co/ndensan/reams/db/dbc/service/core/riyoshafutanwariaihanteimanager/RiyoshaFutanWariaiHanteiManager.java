/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihanteimanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihantei.FutanWariaiHanteiRelateEntity;
import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihanteimanager.RiyoshaFutanWariaiHanteiManagerResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.riyoshafutanwariaihanteimanager.RiyoshaFutanWariaiHanteiManagerParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.FutanWariaiHanteiResult;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.RiyoshaFutanWariaiKonkyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.RiyoshaFutanWariaiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SeikatsuHogoGaitoJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.riyoshafutanwariaihanteimanager.IRiyoshaFutanWariaiHanteiManagerMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.basic.SogoJigyoTaishoshaManager;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.RiyoshaFutanWariaiMeisaiMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyoEntity;
import jp.co.ndensan.reams.db.dbd.service.core.futanwariai.RiyoshaFutanWariaiMeisaiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShikibetsuCd;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.definition.core.honninkubun.HonninKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.JukyushaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.setai.SetaiinFinder;
import jp.co.ndensan.reams.db.dbz.service.core.setaiinshotokujoho.SetaiinShotokuJohoFinder;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCMNK2001_利用者負担割合判定（service）
 *
 * @reamsid_L DBC-5010-040 quxiaodong
 */
public class RiyoshaFutanWariaiHanteiManager {

    private final MapperProvider mapperProvider;
    private static final RString 定値_被保険者番号 = new RString("被保険者番号");
    private static final RString 定値_年度 = new RString("年度");
    private static final RString 定値_基準日 = new RString("基準日");
    private static final RString 定値_履歴番号 = new RString("0000");
    private static final RString ZERO_ONE = new RString("01");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString FOUR = new RString("4");
    private static final RString FIVE = new RString("5");
    private static final int NUM_ONE = 2;
    private static final int NUM_TWO = 2;
    private static final int NUM_THREE = 3;
    private static final int NUM_EIGHT = 8;
    private static final int NUM_TWELVE = 12;

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link RiyoshaFutanWariaiHanteiManager}のインスタンス
     */
    public static RiyoshaFutanWariaiHanteiManager createInstance() {
        return InstanceProvider.create(RiyoshaFutanWariaiHanteiManager.class);
    }

    /**
     * コンストラクタです。
     */
    RiyoshaFutanWariaiHanteiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 負担割合判定を行うです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 年度 FlexibleYear
     * @param 基準日 FlexibleDate
     * @return RiyoshaFutanWariaiHanteiManagerResult
     */
    public RiyoshaFutanWariaiHanteiManagerResult futanWariaiHantei(
            HihokenshaNo 被保険者番号,
            FlexibleYear 年度,
            FlexibleDate 基準日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_被保険者番号.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_年度.toString()));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_基準日.toString()));
        RiyoshaFutanWariaiHanteiManagerResult 判定結果 = new RiyoshaFutanWariaiHanteiManagerResult();
        if (is判定を行うフラグ(基準日)) {
            List<RiyoshaFutanWariaiMeisaiTempEntity> 利用者負担割合明細Tempのマージデータ = new ArrayList<>();
            List<RiyoshaFutanWariaiKonkyoTempEntity> 利用者負担割合割合Tempのマージデータ = new ArrayList<>();
            List<RString> 判定基準日list = RiyoshaFutanWariaiHantei.
                    createInstance().getHanteiKijunbi(new RString(基準日.toString()));
            判定基準日list.set(判定基準日list.size() - 1, new RString(基準日.toString()));
            List<RString> 対象開始日list = RiyoshaFutanWariaiHantei.
                    createInstance().getTaishoKaishibi(new RYear(年度.toString()));
            List<RString> 対象終了日list = RiyoshaFutanWariaiHantei.
                    createInstance().getTaishoShuryobi(new RYear(年度.toString()));
            for (int i = 判定基準日list.size() - 1; i >= 0; i--) {
                List<SetaiinShikibetsuCd> 世帯員識別コード情報list = SetaiinFinder.createInstance().
                        get世帯員識別コードBy被保番号(被保険者番号, new FlexibleDate(判定基準日list.get(i)));
                HihokenshaDaicho 被保険者台帳 = get被保険者台帳の取得(
                        世帯員識別コード情報list, new FlexibleDate(判定基準日list.get(i)));
                if (被保険者台帳 == null && 基準日.equals(new FlexibleDate(判定基準日list.get(i)))) {
                    判定結果.set判定区分(FOUR);
                    return 判定結果;
                }
                List<SetaiinShotoku> 介護所得情報 = get介護所得情報の取得(世帯員識別コード情報list, 年度);
                JukyushaDaichoManager jukyumanager = new JukyushaDaichoManager();
                //TODO QA1177
                List<JukyushaDaicho> 受給者台帳情報 = jukyumanager.get受給者台帳被保険者番号(被保険者番号);
                List<JukyushaDaicho> 受給者台帳 = get受給者台帳情報の取得(受給者台帳情報, 被保険者番号);
                SogoJigyoTaishoshaManager sogomanager = new SogoJigyoTaishoshaManager();
                List<SogoJigyoTaishosha> 総合事業対象者情報 = sogomanager.get総合事業対象者情報(被保険者番号);
                List<SogoJigyoTaishosha> 総合事業対象者 = get総合事業対象者情報の取得(総合事業対象者情報, 被保険者番号);
                List<JukyushaDaicho> jukyushaDaicholist
                        = get基準日時点で認定期間中のデータ(受給者台帳, new FlexibleDate(判定基準日list.get(i)));
                List<SogoJigyoTaishosha> sogoJigyoTaishoshalist = get基準時時点で事業対象者のデータ(
                        総合事業対象者, new FlexibleDate(判定基準日list.get(i)));
                List<JukyushaDaicho> 基準日時点で受給者台帳 = get受給者台帳と総合事業対象者該当チェック(
                        jukyushaDaicholist, sogoJigyoTaishoshalist, 受給者台帳, new FlexibleDate(判定基準日list.get(i)));
                if (基準日.equals(new FlexibleDate(判定基準日list.get(i)))
                        && (基準日時点で受給者台帳 == null || 基準日時点で受給者台帳.isEmpty())) {
                    判定結果.set判定区分(FIVE);
                    return 判定結果;
                }
                IRiyoshaFutanWariaiHanteiManagerMapper mapper = mapperProvider.create(
                        IRiyoshaFutanWariaiHanteiManagerMapper.class);
                ShikibetsuCode 識別コード = 被保険者台帳.get識別コード();
                RiyoshaFutanWariaiHanteiManagerParameter parameter
                        = new RiyoshaFutanWariaiHanteiManagerParameter(
                                識別コード, get対象開始日(new FlexibleDate(判定基準日list.get(i)), 対象開始日list),
                                get対象終了日(new FlexibleDate(判定基準日list.get(i)), 対象終了日list));
                UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者entity = mapper.get生活保護受給者entity(parameter);
                SeikatsuHogoGaitoJohoTempEntity 生活保護該当情報Temp = new SeikatsuHogoGaitoJohoTempEntity();
                if (生活保護受給者entity != null && 基準日.equals(new FlexibleDate(判定基準日list.get(i)))) {
                    判定結果.set生活保護受給者判定(true);
                    get生活保護該当情報Temp(生活保護該当情報Temp, 生活保護受給者entity,
                            new FlexibleDate(判定基準日list.get(i)));
                }
                HanteiTaishoshaTempEntity 判定対象者Temp = new HanteiTaishoshaTempEntity();
                get判定対象者Temp(
                        被保険者番号, 介護所得情報.get(0).get世帯コード(),
                        被保険者台帳, 受給者台帳.get(0), 介護所得情報.get(0), 総合事業対象者.get(0),
                        判定対象者Temp, jukyushaDaicholist, sogoJigyoTaishoshalist, 基準日時点で受給者台帳.get(0));
                FutanWariaiHanteiRelateEntity entity = new FutanWariaiHanteiRelateEntity(
                        判定対象者Temp, 生活保護該当情報Temp, 介護所得情報, new FlexibleDate(判定基準日list.get(i)));
                FutanWariaiHanteiResult 負担割合判定の結果
                        = RiyoshaFutanWariaiHantei.createInstance().futanWariaiHantei(entity);
                RiyoshaFutanWariaiMeisaiTempEntity 利用者負担割合明細Temp = new RiyoshaFutanWariaiMeisaiTempEntity();
                get利用者負担割合明細Temp(被保険者番号, 被保険者台帳, 負担割合判定の結果, 介護所得情報.get(0),
                        介護所得情報.get(0).get世帯コード(), new FlexibleDate(判定基準日list.get(i)),
                        生活保護該当情報Temp, 判定対象者Temp, 利用者負担割合明細Temp);
                RiyoshaFutanWariaiKonkyoTempEntity 利用者負担割合根拠Temp
                        = new RiyoshaFutanWariaiKonkyoTempEntity();
                get利用者負担割合根拠Temp(年度, 被保険者番号, new FlexibleDate(判定基準日list.get(i)),
                        被保険者台帳, 利用者負担割合根拠Temp);
                利用者負担割合明細Tempのマージデータ.add(利用者負担割合明細Temp);
                利用者負担割合割合Tempのマージデータ.add(利用者負担割合根拠Temp);
            }
            set用者負担割合明細Tempのソート(利用者負担割合明細Tempのマージデータ);
            List<RiyoshaFutanWariaiMeisaiTempEntity> 利用者負担割合明細情報 = RiyoshaFutanWariaiHantei.
                    createInstance().futanWariaiHanteiMerge(利用者負担割合明細Tempのマージデータ, 年度);
            DbT3113RiyoshaFutanWariaiEntity 利用者負担割合entity = new DbT3113RiyoshaFutanWariaiEntity();
            get利用者負担割合entity(年度, 被保険者番号, 利用者負担割合entity, 利用者負担割合明細情報.get(0));
            判定結果.set利用者負担割合entity(利用者負担割合entity);
            List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 利用者負担割合明細list
                    = get利用者負担割合明細list(年度, 被保険者番号, 利用者負担割合明細情報);
            判定結果.set利用者負担割合明細list(利用者負担割合明細list);
            List<DbT3115RiyoshaFutanWariaiKonkyoEntity> 利用者負担割合根拠list
                    = get利用者負担割合根拠list(年度, 被保険者番号, 利用者負担割合割合Tempのマージデータ);
            判定結果.set利用者負担割合根拠list(利用者負担割合根拠list);
            RiyoshaFutanWariaiMeisaiMapperParameter 利用者負担割合明細検索条件
                    = RiyoshaFutanWariaiMeisaiMapperParameter.createSelectByKeyParam(年度, 被保険者番号);
            RiyoshaFutanWariaiMeisai 現在の利用者負担割合明細 = RiyoshaFutanWariaiMeisaiManager.
                    createInstance().get利用者負担割合明細(利用者負担割合明細検索条件);
            //TODO QA1177
            判定結果.set判定区分(get判定区分(現在の利用者負担割合明細, 利用者負担割合明細list.get(0)));
        }
        return 判定結果;
    }

    private RString get判定区分(
            RiyoshaFutanWariaiMeisai 現在の利用者負担割合明細,
            DbT3114RiyoshaFutanWariaiMeisaiEntity 今回_作成した負担割合明細) {
        RString 判定区分 = RString.EMPTY;
        if (現在の利用者負担割合明細 != null && 今回_作成した負担割合明細 != null) {
            if (is負担割合情報の比較(現在の利用者負担割合明細, 今回_作成した負担割合明細)) {
                判定区分 = THREE;
            } else if (現在の利用者負担割合明細.get負担割合区分().equals(今回_作成した負担割合明細.getFutanWariaiKubun())
                    && !is排除負担割合区分の情報の比較(現在の利用者負担割合明細, 今回_作成した負担割合明細)) {
                判定区分 = TWO;
            } else if (現在の利用者負担割合明細.get負担割合区分().equals(今回_作成した負担割合明細.getFutanWariaiKubun())) {
                判定区分 = ONE;
            }
        }
        return 判定区分;
    }

    private boolean is負担割合情報の比較(RiyoshaFutanWariaiMeisai 現在の利用者負担割合明細,
            DbT3114RiyoshaFutanWariaiMeisaiEntity 今回_作成した負担割合明細) {
        return 現在の利用者負担割合明細.get年度().equals(今回_作成した負担割合明細.getNendo())
                && 現在の利用者負担割合明細.get被保険者番号().equals(今回_作成した負担割合明細.getHihokenshaNo())
                && 現在の利用者負担割合明細.get履歴番号() == 今回_作成した負担割合明細.getRirekiNo()
                && 現在の利用者負担割合明細.get枝番号() == 今回_作成した負担割合明細.getEdaNo()
                && is比較変更RString(現在の利用者負担割合明細.get資格区分(), 今回_作成した負担割合明細.getShikakuKubun())
                && is比較変更RString(現在の利用者負担割合明細.get負担割合区分(),
                        今回_作成した負担割合明細.getFutanWariaiKubun())
                && is比較変更年月日(現在の利用者負担割合明細.get有効開始日(), 今回_作成した負担割合明細.getYukoKaishiYMD())
                && is比較変更年月日(現在の利用者負担割合明細.get有効終了日(), 今回_作成した負担割合明細.getYukoShuryoYMD())
                && is比較変更数字(現在の利用者負担割合明細.get本人合計所得金額(),
                        今回_作成した負担割合明細.getHonninGoukeiShotokuGaku())
                && 現在の利用者負担割合明細.get世帯１号被保険者数()
                == 今回_作成した負担割合明細.getSetaiIchigouHihokenshaSu()
                && is比較変更数字(現在の利用者負担割合明細.get年金収入合計(),
                        今回_作成した負担割合明細.getNenkinShunyuGoukei())
                && is比較変更数字(現在の利用者負担割合明細.getその他の合計所得金額合計(),
                        今回_作成した負担割合明細.getSonotanoGoukeiShotokuKingakuGoukei())
                && is比較変更RString(現在の利用者負担割合明細.get更正理由(), 今回_作成した負担割合明細.getKoseiRiyu())
                && is比較変更code(現在の利用者負担割合明細.get世帯コード(), 今回_作成した負担割合明細.getSetaiCd());
    }

    private boolean is排除負担割合区分の情報の比較(RiyoshaFutanWariaiMeisai 現在の利用者負担割合明細,
            DbT3114RiyoshaFutanWariaiMeisaiEntity 今回_作成した負担割合明細) {
        return 現在の利用者負担割合明細.get年度().equals(今回_作成した負担割合明細.getNendo())
                && 現在の利用者負担割合明細.get被保険者番号().equals(今回_作成した負担割合明細.getHihokenshaNo())
                && 現在の利用者負担割合明細.get履歴番号() == 今回_作成した負担割合明細.getRirekiNo()
                && 現在の利用者負担割合明細.get枝番号() == 今回_作成した負担割合明細.getEdaNo()
                && is比較変更RString(現在の利用者負担割合明細.get資格区分(), 今回_作成した負担割合明細.getShikakuKubun())
                && is比較変更年月日(現在の利用者負担割合明細.get有効開始日(), 今回_作成した負担割合明細.getYukoKaishiYMD())
                && is比較変更年月日(現在の利用者負担割合明細.get有効終了日(), 今回_作成した負担割合明細.getYukoShuryoYMD())
                && is比較変更数字(現在の利用者負担割合明細.get本人合計所得金額(),
                        今回_作成した負担割合明細.getHonninGoukeiShotokuGaku())
                && 現在の利用者負担割合明細.get世帯１号被保険者数()
                == 今回_作成した負担割合明細.getSetaiIchigouHihokenshaSu()
                && is比較変更数字(現在の利用者負担割合明細.get年金収入合計(),
                        今回_作成した負担割合明細.getNenkinShunyuGoukei())
                && is比較変更数字(現在の利用者負担割合明細.getその他の合計所得金額合計(),
                        今回_作成した負担割合明細.getSonotanoGoukeiShotokuKingakuGoukei())
                && is比較変更RString(現在の利用者負担割合明細.get更正理由(), 今回_作成した負担割合明細.getKoseiRiyu())
                && is比較変更code(現在の利用者負担割合明細.get世帯コード(), 今回_作成した負担割合明細.getSetaiCd());
    }

    private boolean is比較変更RString(RString s1, RString s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }

    private boolean is比較変更年月日(FlexibleDate s1, FlexibleDate s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }

    private boolean is比較変更数字(Decimal s1, Decimal s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }

    private boolean is比較変更code(SetaiCode s1, SetaiCode s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }

    private List<DbT3115RiyoshaFutanWariaiKonkyoEntity> get利用者負担割合根拠list(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            List<RiyoshaFutanWariaiKonkyoTempEntity> 利用者負担割合根拠情報) {
        List<DbT3115RiyoshaFutanWariaiKonkyoEntity> 利用者負担割合根拠list = new ArrayList<>();
        for (RiyoshaFutanWariaiKonkyoTempEntity entity : 利用者負担割合根拠情報) {
            DbT3115RiyoshaFutanWariaiKonkyoEntity 利用者負担割合根拠entity = new DbT3115RiyoshaFutanWariaiKonkyoEntity();
            利用者負担割合根拠entity.setNendo(年度);
            利用者負担割合根拠entity.setHihokenshaNo(被保険者番号);
            //TODO 履歴番号 枝番号 QA1177
            利用者負担割合根拠entity.setSetaiinHihokenshaNo(entity.getSetaiinHihokenshaNo());
            利用者負担割合根拠entity.setSetaiinShotokuRirekiNo(entity.getSetaiinShotokuRirekiNo());
        }
        return 利用者負担割合根拠list;
    }

    private List<DbT3114RiyoshaFutanWariaiMeisaiEntity> get利用者負担割合明細list(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            List<RiyoshaFutanWariaiMeisaiTempEntity> 利用者負担割合明細情報) {
        List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 利用者負担割合明細list = new ArrayList<>();
        for (RiyoshaFutanWariaiMeisaiTempEntity entity : 利用者負担割合明細情報) {
            DbT3114RiyoshaFutanWariaiMeisaiEntity 利用者負担割合明細entity = new DbT3114RiyoshaFutanWariaiMeisaiEntity();
            利用者負担割合明細entity.setNendo(年度);
            利用者負担割合明細entity.setHihokenshaNo(被保険者番号);
            //TODO 履歴番号 枝番号 QA1177
            利用者負担割合明細entity.setShikakuKubun(entity.getShikakuKubun());
            利用者負担割合明細entity.setFutanWariaiKubun(entity.getFutanWariaiKubun());
            利用者負担割合明細entity.setYukoKaishiYMD(entity.getYukoKaishiYMD());
            利用者負担割合明細entity.setYukoShuryoYMD(entity.getYukoShuryoYMD());
            利用者負担割合明細entity.setHonninGoukeiShotokuGaku(entity.getHonninGoukeiShotokuGaku());
            利用者負担割合明細entity.setSetaiIchigouHihokenshaSu(entity.getSetaiIchigouHihokenshaSu());
            利用者負担割合明細entity.setNenkinShunyuGoukei(entity.getNenkinShunyuGoukei());
            利用者負担割合明細entity.setSonotanoGoukeiShotokuKingakuGoukei(
                    entity.getSonotanoGoukeiShotokuKingakuGoukei());
            利用者負担割合明細entity.setKoseiRiyu(entity.getKoseiRiyu());
            利用者負担割合明細entity.setSetaiCd(entity.getSetaiCd());
            利用者負担割合明細entity.setLogicalDeletedFlag(false);
            利用者負担割合明細list.add(利用者負担割合明細entity);
        }
        return 利用者負担割合明細list;
    }

    private void get利用者負担割合entity(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            DbT3113RiyoshaFutanWariaiEntity 利用者負担割合entity,
            RiyoshaFutanWariaiMeisaiTempEntity 利用者負担割合明細Temp) {
        利用者負担割合entity.setNendo(年度);
        利用者負担割合entity.setHihokenshaNo(被保険者番号);
        //TODO 履歴番号 QA1177
        利用者負担割合entity.setHakoFuyoFlag(false);
        利用者負担割合entity.setShokenFlag(false);
        利用者負担割合entity.setHanteiYMD(FlexibleDate.getNowDate());
        利用者負担割合entity.setHanteiKubun(FOUR);
        利用者負担割合entity.setKoseiJiyu(new Code(利用者負担割合明細Temp.getKoseiJiyu()));
        利用者負担割合entity.setHakoKubun(ZERO);
        利用者負担割合entity.setHakoYMD(FlexibleDate.EMPTY);
        利用者負担割合entity.setKofuYMD(FlexibleDate.EMPTY);
        利用者負担割合entity.setLogicalDeletedFlag(false);
    }

    private void set用者負担割合明細Tempのソート(
            List<RiyoshaFutanWariaiMeisaiTempEntity> 利用者負担割合明細Tempのマージデータ) {
        Collections.sort(利用者負担割合明細Tempのマージデータ, new Comparator<RiyoshaFutanWariaiMeisaiTempEntity>() {
            @Override
            public int compare(RiyoshaFutanWariaiMeisaiTempEntity o1, RiyoshaFutanWariaiMeisaiTempEntity o2) {
                return new RString(o2.getEdaNo()).compareTo(new RString(o1.getEdaNo()));
            }
        });
    }

    private void get利用者負担割合根拠Temp(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            FlexibleDate 判定基準日,
            HihokenshaDaicho 被保険者台帳,
            RiyoshaFutanWariaiKonkyoTempEntity 利用者負担割合根拠Temp) {
        利用者負担割合根拠Temp.setNendo(年度);
        利用者負担割合根拠Temp.setHihokenshaNo(被保険者番号);
        利用者負担割合根拠Temp.setEdaNo(判定基準日.getMonthValue());
        //TODO 世帯員被保険者番号 QA1177
        利用者負担割合根拠Temp.setSetaiinHihokenshaNo(被保険者台帳.get被保険者番号());
        //TODO 世帯員所得履歴番号 QA1177
        // 利用者負担割合根拠Temp.setSetaiinShotokuRirekiNo(被保険者台帳);
    }

    private void get利用者負担割合明細Temp(
            HihokenshaNo 被保険者番号,
            HihokenshaDaicho 被保険者台帳,
            FutanWariaiHanteiResult 負担割合判定の結果,
            SetaiinShotoku 介護所得情報,
            RString 世帯コード,
            FlexibleDate 判定基準日,
            SeikatsuHogoGaitoJohoTempEntity 生活保護該当情報Temp,
            HanteiTaishoshaTempEntity 判定対象者Temp,
            RiyoshaFutanWariaiMeisaiTempEntity 利用者負担割合明細Temp) {
        利用者負担割合明細Temp.setHihokenshaNo(被保険者番号.value());
        利用者負担割合明細Temp.setEdaNo(判定基準日.getMonthValue());
        利用者負担割合明細Temp.setShikakuKubun(被保険者台帳.get被保険者区分コード());
        利用者負担割合明細Temp.setFutanWariaiKubun(負担割合判定の結果.get負担割合区分());
        利用者負担割合明細Temp.setYukoKaishiYMD(FlexibleDate.EMPTY);
        利用者負担割合明細Temp.setYukoShuryoYMD(FlexibleDate.EMPTY);
        利用者負担割合明細Temp.setHonninGoukeiShotokuGaku(介護所得情報.get合計所得金額());
        利用者負担割合明細Temp.setSetaiIchigouHihokenshaSu(NUM_ONE);
        利用者負担割合明細Temp.setNenkinShunyuGoukei(介護所得情報.get年金収入額());
        if (介護所得情報.get年金所得額().compareTo(介護所得情報.get合計所得金額()) < 0) {
            利用者負担割合明細Temp.setSonotanoGoukeiShotokuKingakuGoukei(
                    介護所得情報.get合計所得金額().subtract(介護所得情報.get年金所得額()));
        } else {
            利用者負担割合明細Temp.setSonotanoGoukeiShotokuKingakuGoukei(Decimal.ZERO);
        }
        利用者負担割合明細Temp.setKoseiRiyu(RString.EMPTY);
        利用者負担割合明細Temp.setSetaiCd(new SetaiCode(世帯コード));
        利用者負担割合明細Temp.setKoseiJiyu(RString.EMPTY);
        利用者負担割合明細Temp.setHanteiKubun(負担割合判定の結果.get判定区分());
        利用者負担割合明細Temp.setNinteiYukoKaishiDate(判定対象者Temp.getNinteiYukoKaishiDate());
        利用者負担割合明細Temp.setJukyuKaishiYMD(生活保護該当情報Temp.getJukyuKaishibi());

    }

    private void get判定対象者Temp(
            HihokenshaNo 被保険者番号,
            RString 世帯コード,
            HihokenshaDaicho 被保険者台帳,
            JukyushaDaicho 受給者台帳,
            SetaiinShotoku 介護所得情報,
            SogoJigyoTaishosha 総合事業対象者,
            HanteiTaishoshaTempEntity 判定対象者Temp,
            List<JukyushaDaicho> jukyushaDaicholist,
            List<SogoJigyoTaishosha> sogoJigyoTaishoshalist,
            JukyushaDaicho 基準日時点で受給者台帳) {
        if (jukyushaDaicholist != null) {
            get受給者台帳_判定対象者Temp(被保険者番号, 世帯コード, 被保険者台帳, 受給者台帳, 介護所得情報, 判定対象者Temp);
        } else {
            if (sogoJigyoTaishoshalist != null) {
                get総合事業対象者_受給者台帳_判定対象者Temp(
                        被保険者番号, 世帯コード, 被保険者台帳, 介護所得情報, 総合事業対象者, 判定対象者Temp);
            } else {
                get受給者台帳_判定対象者Temp(被保険者番号, 世帯コード,
                        被保険者台帳, 基準日時点で受給者台帳, 介護所得情報, 判定対象者Temp);
            }
        }

    }

    private List<JukyushaDaicho> get受給者台帳と総合事業対象者該当チェック(
            List<JukyushaDaicho> jukyushaDaicholist,
            List<SogoJigyoTaishosha> sogoJigyoTaishoshalist,
            List<JukyushaDaicho> 受給者台帳,
            FlexibleDate 判定基準日) {
        List<JukyushaDaicho> 基準日時点で受給者台帳 = new ArrayList<>();
        if ((jukyushaDaicholist == null || jukyushaDaicholist.isEmpty())
                && sogoJigyoTaishoshalist == null || sogoJigyoTaishoshalist.isEmpty()) {
            基準日時点で受給者台帳 = get基準日時点で申請中のデータ(判定基準日, 受給者台帳);
        }
        return 基準日時点で受給者台帳;

    }

    private List<JukyushaDaicho> get基準日時点で認定期間中のデータ(
            List<JukyushaDaicho> 受給者台帳,
            FlexibleDate 判定基準日) {
        for (JukyushaDaicho jukydai : 受給者台帳) {
            if (定値_履歴番号.equals(jukydai.get履歴番号())
                    && (jukydai.get認定有効期間終了年月日().isBefore(判定基準日)
                    || 判定基準日.isBefore(jukydai.get認定有効期間開始年月日()))
                    && jukydai.get要介護認定状態区分コード().value().equals(ZERO_ONE)) {
                受給者台帳.remove(jukydai);
            }
        }
        return 受給者台帳;
    }

    private List<SogoJigyoTaishosha> get基準時時点で事業対象者のデータ(
            List<SogoJigyoTaishosha> 総合事業対象者情報,
            FlexibleDate 判定基準日) {
        for (SogoJigyoTaishosha 総合事業対象者 : 総合事業対象者情報) {
            if (総合事業対象者.get適用終了年月日().isBefore(判定基準日)
                    || 判定基準日.isBefore(総合事業対象者.get適用開始年月日())) {
                総合事業対象者情報.remove(総合事業対象者);
            }
        }
        return 総合事業対象者情報;
    }

    private List<JukyushaDaicho> get基準日時点で申請中のデータ(
            FlexibleDate 判定基準日,
            List<JukyushaDaicho> 受給者台帳情報) {
        for (JukyushaDaicho jukydai : 受給者台帳情報) {
            if (!定値_履歴番号.equals(jukydai.get履歴番号())
                    && 判定基準日.isBefore(jukydai.get受給申請年月日())) {
                受給者台帳情報.remove(jukydai);
            }
        }
        return 受給者台帳情報;
    }

    private void get受給者台帳_判定対象者Temp(
            HihokenshaNo 被保険者番号,
            RString 世帯コード,
            HihokenshaDaicho 被保険者台帳,
            JukyushaDaicho 受給者台帳,
            SetaiinShotoku 介護所得情報,
            HanteiTaishoshaTempEntity 判定対象者Temp) {
        判定対象者Temp.setTaishoKubun(ONE);
        判定対象者Temp.setHihokenshaNo(被保険者番号.value());
        判定対象者Temp.setShikibetsuCode(被保険者台帳.get識別コード().value());
        判定対象者Temp.setSetaiCode(世帯コード);
        判定対象者Temp.setIdoShubetsu(RString.EMPTY);
        判定対象者Temp.setIdobi(被保険者台帳.get異動日());
        判定対象者Temp.setIdoJiyuCode(被保険者台帳.get異動事由コード());
        判定対象者Temp.setShikakuShiyutokiDate(被保険者台帳.get資格取得年月日());
        判定対象者Temp.setFirstShikakuShiyutokiDate(被保険者台帳.get第1号資格取得年月日());
        判定対象者Temp.setHihokenshaKubunCode(被保険者台帳.get被保険者区分コード());
        判定対象者Temp.setCityCode(受給者台帳.get市町村コード().value());
        判定対象者Temp.setRirekiNo(受給者台帳.get履歴番号());
        判定対象者Temp.setEdaNo(受給者台帳.get枝番());
        判定対象者Temp.setJukyuShinseiJiyu(受給者台帳.get受給申請事由().value());
        判定対象者Temp.setNinteiYukoKaishiDate(受給者台帳.get認定有効期間開始年月日());
        判定対象者Temp.setNinteiYukoShuryoDate(受給者台帳.get認定有効期間終了年月日());
        判定対象者Temp.setNinteiDate(受給者台帳.get認定年月日());
        //TODO 所得年度 所得履歴番号 QA1177
        判定対象者Temp.setKazeiKubun(介護所得情報.get課税区分_住民税減免前());
        判定対象者Temp.setKazeiKubunGemmenGo(介護所得情報.get課税区分_住民税減免後());
        判定対象者Temp.setGokeiShotokuGaku(介護所得情報.get合計所得金額());
        判定対象者Temp.setNenkiniShunyuGaku(介護所得情報.get年金収入額());
        判定対象者Temp.setNenkiniShotokuGaku(介護所得情報.get年金所得額());
        判定対象者Temp.setKazeiShotokuGaku(介護所得情報.get課税所得額());
        判定対象者Temp.setGekihenKanwaKubun(介護所得情報.get激変緩和措置());
    }

    private void get総合事業対象者_受給者台帳_判定対象者Temp(
            HihokenshaNo 被保険者番号,
            RString 世帯コード,
            HihokenshaDaicho 被保険者台帳,
            SetaiinShotoku 介護所得情報,
            SogoJigyoTaishosha 総合事業対象者,
            HanteiTaishoshaTempEntity 判定対象者Temp) {
        判定対象者Temp.setTaishoKubun(TWO);
        判定対象者Temp.setHihokenshaNo(被保険者番号.value());
        判定対象者Temp.setShikibetsuCode(被保険者台帳.get識別コード().value());
        判定対象者Temp.setSetaiCode(世帯コード);
        判定対象者Temp.setIdoShubetsu(RString.EMPTY);
        判定対象者Temp.setIdobi(被保険者台帳.get異動日());
        判定対象者Temp.setIdoJiyuCode(被保険者台帳.get異動事由コード());
        判定対象者Temp.setShikakuShiyutokiDate(被保険者台帳.get資格取得年月日());
        判定対象者Temp.setFirstShikakuShiyutokiDate(被保険者台帳.get第1号資格取得年月日());
        判定対象者Temp.setHihokenshaKubunCode(被保険者台帳.get被保険者区分コード());
        判定対象者Temp.setCityCode(RString.EMPTY);
        判定対象者Temp.setRirekiNo(new RString(総合事業対象者.get履歴番号()));
        判定対象者Temp.setEdaNo(RString.EMPTY);
        判定対象者Temp.setJukyuShinseiJiyu(RString.EMPTY);
        判定対象者Temp.setNinteiYukoKaishiDate(総合事業対象者.get適用開始年月日());
        判定対象者Temp.setNinteiYukoShuryoDate(総合事業対象者.get適用終了年月日());
        //TODO 総合事業対象者.チェックリスト実施日 QA1177
        判定対象者Temp.setNinteiDate(総合事業対象者.get受付年月日());
        //TODO 所得年度 所得履歴番号 QA1177
        判定対象者Temp.setKazeiKubun(介護所得情報.get課税区分_住民税減免前());
        判定対象者Temp.setKazeiKubunGemmenGo(介護所得情報.get課税区分_住民税減免後());
        判定対象者Temp.setGokeiShotokuGaku(介護所得情報.get合計所得金額());
        判定対象者Temp.setNenkiniShunyuGaku(介護所得情報.get年金収入額());
        判定対象者Temp.setNenkiniShotokuGaku(介護所得情報.get年金所得額());
        判定対象者Temp.setKazeiShotokuGaku(介護所得情報.get課税所得額());
        判定対象者Temp.setGekihenKanwaKubun(介護所得情報.get激変緩和措置());
    }

    private void get生活保護該当情報Temp(
            SeikatsuHogoGaitoJohoTempEntity 生活保護該当情報Temp,
            UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者entity,
            FlexibleDate 判定基準日) {
        //TODO 対象月
        生活保護該当情報Temp.setTaishoGetsu(new RString(判定基準日.getMonthValue()));
        生活保護該当情報Temp.setShikibetsuCode(生活保護受給者entity.getShikibetsuCode().value());
        生活保護該当情報Temp.setJukyuKaishibi(生活保護受給者entity.getJukyuKaishiYMD());
        生活保護該当情報Temp.setJukyuShuryobi(生活保護受給者entity.getJukyuHaishiYMD());

    }

    private FlexibleDate get対象開始日(FlexibleDate 判定基準日, List<RString> 対象開始日list) {
        FlexibleDate 対象開始日 = FlexibleDate.EMPTY;
        for (RString kaishibilist : 対象開始日list) {
            if (判定基準日.getMonthValue() == new FlexibleDate(kaishibilist).getMonthValue()) {
                対象開始日 = new FlexibleDate(kaishibilist);
            }
        }
        return 対象開始日;
    }

    private FlexibleDate get対象終了日(FlexibleDate 判定基準日, List<RString> 対象終了日list) {
        FlexibleDate 対象終了日 = FlexibleDate.EMPTY;
        for (RString shuryobilist : 対象終了日list) {
            if (判定基準日.getMonthValue() == new FlexibleDate(shuryobilist).getMonthValue()) {
                対象終了日 = new FlexibleDate(shuryobilist);
            }
        }
        return 対象終了日;
    }

    private List<SogoJigyoTaishosha> get総合事業対象者情報の取得(
            List<SogoJigyoTaishosha> 総合事業対象者情報,
            HihokenshaNo 被保険者番号) {
        for (SogoJigyoTaishosha 総合事業対象者 : 総合事業対象者情報) {
            if (!被保険者番号.equals(総合事業対象者.get被保険者番号())) {
                総合事業対象者情報.remove(総合事業対象者);
            }
        }
        Collections.sort(総合事業対象者情報, new Comparator<SogoJigyoTaishosha>() {
            @Override
            public int compare(SogoJigyoTaishosha o1, SogoJigyoTaishosha o2) {
                return new RString(o2.get履歴番号()).compareTo(new RString(o1.get履歴番号()));
            }
        });
        return 総合事業対象者情報;
    }

    private List<JukyushaDaicho> get受給者台帳情報の取得(
            List<JukyushaDaicho> 受給者台帳情報, HihokenshaNo 被保険者番号) {
        for (JukyushaDaicho 受給者台帳 : 受給者台帳情報) {
            if (受給者台帳.is論理削除フラグ() && 受給者台帳.get有効無効区分().value().equals(TWO)
                    && !被保険者番号.equals(受給者台帳.get被保険者番号())) {
                受給者台帳情報.remove(受給者台帳);
            }
        }
        Collections.sort(受給者台帳情報, new Comparator<JukyushaDaicho>() {
            @Override
            public int compare(JukyushaDaicho o1, JukyushaDaicho o2) {
                int flag = o2.get履歴番号().compareTo(o1.get履歴番号());
                if (0 == flag) {
                    flag = o2.get枝番().compareTo(o1.get枝番());
                }
                return flag;
            }
        });
        return 受給者台帳情報;
    }

    private List<SetaiinShotoku> get介護所得情報の取得(
            List<SetaiinShikibetsuCd> 世帯員識別コード情報list,
            FlexibleYear 年度) {
        List<SetaiinShotoku> 世帯員所得情報 = new ArrayList<>();
        for (SetaiinShikibetsuCd 世帯員識別コード情報 : 世帯員識別コード情報list) {
            if (HonninKubun.本人.getCode().equals(世帯員識別コード情報.get本人区分())) {
                世帯員所得情報 = SetaiinShotokuJohoFinder.createInstance().
                        get世帯員所得情報(世帯員識別コード情報.get世帯員識別コード(), 年度, null);
            }
        }
        return 世帯員所得情報;
    }

    private HihokenshaDaicho get被保険者台帳の取得(
            List<SetaiinShikibetsuCd> 世帯員識別コード情報list,
            FlexibleDate 判定基準日) {
        HihokenshaDaicho 被保険者台帳 = null;
        for (SetaiinShikibetsuCd 世帯員識別コード情報 : 世帯員識別コード情報list) {
            if (HonninKubun.本人.getCode().equals(世帯員識別コード情報.get本人区分())) {
                被保険者台帳 = HihokenshaDaichoManager.createInstance().
                        find被保険者台帳(世帯員識別コード情報.get世帯員識別コード(), 判定基準日);
            }
        }
        return 被保険者台帳;
    }

    private boolean is判定を行うフラグ(FlexibleDate 基準日) {
        int 基準日サイズ = 0;
        if (基準日.getMonthValue() == 1 || 基準日.getMonthValue() == NUM_TWO || 基準日.getMonthValue() == NUM_THREE) {
            基準日サイズ = 基準日.getMonthValue() + NUM_TWELVE;
        } else {
            基準日サイズ = 基準日.getMonthValue();
        }
        return NUM_EIGHT <= 基準日サイズ;
    }

}
