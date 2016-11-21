/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihanteimanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihantei.FutanWariaiHanteiJoho;
import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihanteimanager.RiyoshaFutanWariaiHanteiManagerResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.riyoshafutanwariaihanteimanager.RiyoshaFutanWariaiHanteiManagerParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.riyoshafutanwariaihanteimanager.RiyoshaFutanWariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.FutanWariaiHanteiResult;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.RiyoshaFutanWariaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.RiyoshaFutanWariaiKonkyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.RiyoshaFutanWariaiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SeikatsuHogoGaitoJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.riyoshafutanwariaihanteimanager.IRiyoshaFutanWariaiHanteiManagerMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.basic.SogoJigyoTaishoshaManager;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3113RiyoshaFutanWariaiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3114RiyoshaFutanWariaiMeisaiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3115RiyoshaFutanWariaiKonkyoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShikibetsuCd;
import jp.co.ndensan.reams.db.dbz.definition.core.honninkubun.HonninKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2512KaigoShotokuNewestEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.JukyushaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.setai.SetaiinFinder;
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
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ビジネス設計_DBCMNK2001_利用者負担割合判定（service）
 *
 * @reamsid_L DBC-5010-040 quxiaodong
 */
public class RiyoshaFutanWariaiHanteiManager {

    private final MapperProvider mapperProvider;
    private final DbT3113RiyoshaFutanWariaiDac 利用者負担割合Dac;
    private final DbT3114RiyoshaFutanWariaiMeisaiDac 利用者負担割合明細Dac;
    private final DbT3115RiyoshaFutanWariaiKonkyoDac 利用者負担割合根拠Dac;
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
    private static final int INDEX_ZERO = 0;
    private static final int LIST_SIZE_ONE = 1;
    private static final int 履歴番号_ONE = 1;
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
        this.利用者負担割合Dac = InstanceProvider.create(DbT3113RiyoshaFutanWariaiDac.class);
        this.利用者負担割合明細Dac = InstanceProvider.create(DbT3114RiyoshaFutanWariaiMeisaiDac.class);
        this.利用者負担割合根拠Dac = InstanceProvider.create(DbT3115RiyoshaFutanWariaiKonkyoDac.class);
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
    @Transaction
    public RiyoshaFutanWariaiHanteiManagerResult futanWariaiHantei(
            HihokenshaNo 被保険者番号,
            FlexibleYear 年度,
            FlexibleDate 基準日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_被保険者番号.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_年度.toString()));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_基準日.toString()));
        RiyoshaFutanWariaiHanteiManagerResult 判定結果 = new RiyoshaFutanWariaiHanteiManagerResult();
        List<RString> 判定基準日list = RiyoshaFutanWariaiHantei.
                createInstance().getHanteiKijunbi(new RString(基準日.toString()));
        判定基準日list.set(判定基準日list.size() - 1, new RString(基準日.toString()));
        List<RString> 対象開始日list = RiyoshaFutanWariaiHantei.
                createInstance().getTaishoKaishibi(new RYear(年度.toString()));
        List<RString> 対象終了日list = RiyoshaFutanWariaiHantei.
                createInstance().getTaishoShuryobi(new RYear(年度.toString()));
        List<RiyoshaFutanWariaiMeisaiTempEntity> 利用者負担割合明細Tempのマージデータ = new ArrayList<>();
        List<RiyoshaFutanWariaiKonkyoTempEntity> 利用者負担割合根拠Tempのマージデータ = new ArrayList<>();
        for (int i = 判定基準日list.size() - 1; 0 <= i; i--) {
            List<SetaiinShikibetsuCd> 世帯員識別コード情報list = SetaiinFinder.createInstance().
                    get世帯員識別コードBy被保番号(被保険者番号, new FlexibleDate(判定基準日list.get(i)));
            世帯員識別コード情報list = remove重複(世帯員識別コード情報list);
            HihokenshaDaicho 被保険者台帳 = get被保険者台帳(
                    世帯員識別コード情報list, new FlexibleDate(判定基準日list.get(i)));
            HanteiTaishoshaTempEntity 判定対象者Temp = new HanteiTaishoshaTempEntity();
            set判定対象者Tempの被保険者情報部分(判定対象者Temp, 被保険者台帳);
            HihokenshaDaicho 世帯員の被保険者台帳 = get世帯員の被保険者台帳(
                    世帯員識別コード情報list, new FlexibleDate(判定基準日list.get(i)));
            if (被保険者台帳 == null && 基準日.equals(new FlexibleDate(判定基準日list.get(i)))) {
                判定結果.set判定区分(FOUR);
                return 判定結果;
            }
            List<SetaiinShikibetsuCd> 世帯員識別コード情報 = get世帯員被保険者該当チェック(
                    世帯員識別コード情報list, 世帯員の被保険者台帳, 被保険者台帳, 基準日,
                    new FlexibleDate(判定基準日list.get(i)));
            set判定対象者Tempの共通項目部分(被保険者番号, 判定対象者Temp, 被保険者台帳, 世帯員識別コード情報);
            IRiyoshaFutanWariaiHanteiManagerMapper mapper = mapperProvider.create(
                    IRiyoshaFutanWariaiHanteiManagerMapper.class);
            RiyoshaFutanWariaiHanteiParameter parameter = new RiyoshaFutanWariaiHanteiParameter(
                    年度, get識別code(世帯員識別コード情報));
            List<DbV2512KaigoShotokuNewestEntity> 介護所得情報 = mapper.get介護所得情報(parameter);
            set世帯員介護所得情報(年度, 介護所得情報, 世帯員識別コード情報, mapper);
            set判定対象者Tempの介護所得情報部分(判定対象者Temp, 介護所得情報);
            JukyushaDaichoManager jukyumanager = new JukyushaDaichoManager();
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
                    && (基準日時点で受給者台帳 == null || 基準日時点で受給者台帳.isEmpty())
                    && (jukyushaDaicholist == null || jukyushaDaicholist.isEmpty())
                    && (sogoJigyoTaishoshalist == null || sogoJigyoTaishoshalist.isEmpty())) {
                判定結果.set判定区分(FIVE);
                return 判定結果;
            }
            set判定対象者Tempの受給者台帳部分(判定対象者Temp, jukyushaDaicholist,
                    sogoJigyoTaishoshalist, 基準日時点で受給者台帳);
            RiyoshaFutanWariaiHanteiManagerParameter para
                    = new RiyoshaFutanWariaiHanteiManagerParameter(
                            被保険者台帳.get識別コード(), new FlexibleDate(対象開始日list.get(0)),
                            new FlexibleDate(対象終了日list.get(0)));
            List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者情報 = mapper.get生活保護受給者entity(para);
            SeikatsuHogoGaitoJohoTempEntity 生活保護該当情報Temp = new SeikatsuHogoGaitoJohoTempEntity();
            if (生活保護受給者情報 != null && !生活保護受給者情報.isEmpty()
                    && 基準日.equals(new FlexibleDate(判定基準日list.get(i)))) {
                判定結果.set生活保護受給者判定(true);
                get生活保護該当情報Temp(生活保護該当情報Temp, 生活保護受給者情報,
                        new FlexibleDate(判定基準日list.get(i)));
            }
            FutanWariaiHanteiJoho entity = new FutanWariaiHanteiJoho(
                    判定対象者Temp, 生活保護該当情報Temp, null, 介護所得情報, new FlexibleDate(判定基準日list.get(i)));
            FutanWariaiHanteiResult 負担割合判定の結果
                    = RiyoshaFutanWariaiHantei.createInstance().futanWariaiHantei(entity);
            int 世帯１号被保険者数 = get世帯１号被保険者数(世帯員識別コード情報list);
            RiyoshaFutanWariaiMeisaiTempEntity 利用者負担割合明細Temp = new RiyoshaFutanWariaiMeisaiTempEntity();
            get利用者負担割合明細Temp(被保険者番号, 被保険者台帳, 負担割合判定の結果, 介護所得情報,
                    get世帯code(世帯員識別コード情報), 世帯１号被保険者数,
                    生活保護該当情報Temp, 判定対象者Temp, 利用者負担割合明細Temp);
            利用者負担割合明細Tempのマージデータ.add(利用者負担割合明細Temp);
            RiyoshaFutanWariaiKonkyoTempEntity 利用者負担割合根拠Temp
                    = new RiyoshaFutanWariaiKonkyoTempEntity();
            get利用者負担割合根拠Temp(年度, 被保険者番号, 被保険者台帳, 利用者負担割合根拠Temp, 介護所得情報);
            利用者負担割合根拠Temp.setEdaNo(i + 1);
            利用者負担割合根拠Tempのマージデータ.add(利用者負担割合根拠Temp);
        }
        set利用者負担割合明細Tempのソート(利用者負担割合明細Tempのマージデータ);
        set利用者負担割合根拠Tempのマージデータ(利用者負担割合根拠Tempのマージデータ);
        RiyoshaFutanWariaiTempEntity マージResult = RiyoshaFutanWariaiHantei.
                createInstance().futanWariaiHanteiMerge(利用者負担割合明細Tempのマージデータ,
                        利用者負担割合根拠Tempのマージデータ, 年度);
        DbT3113RiyoshaFutanWariaiEntity 利用者負担割合entity = new DbT3113RiyoshaFutanWariaiEntity();
        List<RiyoshaFutanWariaiMeisaiTempEntity> 利用者負担割合明細情報 = マージResult.get利用者負担割合明細情報();
        List<RiyoshaFutanWariaiKonkyoTempEntity> 利用者負担割合根拠情報 = マージResult.get利用者負担割合根拠情報();
        RString koseiJiyu = RString.EMPTY;
        if (利用者負担割合明細情報 != null && !利用者負担割合明細情報.isEmpty()) {
            koseiJiyu = 利用者負担割合明細情報.get(0).getKoseiJiyu();
        }
        get利用者負担割合entity(年度, 被保険者番号, 利用者負担割合entity, koseiJiyu);
        判定結果.set利用者負担割合entity(利用者負担割合entity);
        List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 利用者負担割合明細list
                = get利用者負担割合明細list(年度, 被保険者番号, 利用者負担割合明細情報);
        判定結果.set利用者負担割合明細list(利用者負担割合明細list);
        List<DbT3115RiyoshaFutanWariaiKonkyoEntity> 利用者負担割合根拠list
                = get利用者負担割合根拠list(年度, 被保険者番号, 利用者負担割合根拠情報);
        判定結果.set利用者負担割合根拠list(利用者負担割合根拠list);
        int 利用者負担割合の最大履歴番号 = get利用者負担割合の最大履歴番号(被保険者番号, 年度);
        List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 現在の利用者負担割合明細 = 利用者負担割合明細Dac.selectBySomeKey(
                年度, 被保険者番号, 利用者負担割合の最大履歴番号);
        判定結果.set判定区分(get判定区分(現在の利用者負担割合明細, 利用者負担割合明細list));
        return 判定結果;
    }

    private ShikibetsuCode get識別code(List<SetaiinShikibetsuCd> 世帯員識別コード情報) {
        ShikibetsuCode 識別code = ShikibetsuCode.EMPTY;
        if (世帯員識別コード情報 != null && !世帯員識別コード情報.isEmpty() && 世帯員識別コード情報.get(0) != null) {
            識別code = 世帯員識別コード情報.get(0).get世帯員識別コード();
        }
        return 識別code;
    }

    private void set世帯員介護所得情報(FlexibleYear 年度,
            List<DbV2512KaigoShotokuNewestEntity> 介護所得情報, List<SetaiinShikibetsuCd> 世帯員識別コード情報,
            IRiyoshaFutanWariaiHanteiManagerMapper mapper) {
        if (世帯員識別コード情報 != null && LIST_SIZE_ONE < 世帯員識別コード情報.size()) {
            List<DbV2512KaigoShotokuNewestEntity> 世帯員介護所得情報;
            ShikibetsuCode 識別code;
            RiyoshaFutanWariaiHanteiParameter parameter;
            for (int j = 1; j < 世帯員識別コード情報.size(); j++) {
                識別code = get世帯員識別code(世帯員識別コード情報.get(j).get世帯員識別コード());
                parameter = new RiyoshaFutanWariaiHanteiParameter(年度, 識別code);
                世帯員介護所得情報 = mapper.get介護所得情報(parameter);
                add世帯員介護所得情報(介護所得情報, 世帯員介護所得情報);
            }
        }
    }

    private ShikibetsuCode get世帯員識別code(ShikibetsuCode 世帯員識別code) {
        if (世帯員識別code != null) {
            return 世帯員識別code;
        }
        return ShikibetsuCode.EMPTY;
    }

    private void add世帯員介護所得情報(List<DbV2512KaigoShotokuNewestEntity> 介護所得情報, List<DbV2512KaigoShotokuNewestEntity> 世帯員介護所得情報) {
        if (介護所得情報 == null) {
            return;
        }
        if (世帯員介護所得情報 == null || 世帯員介護所得情報.isEmpty()) {
            return;
        }
        介護所得情報.add(世帯員介護所得情報.get(INDEX_ZERO));
    }

    private SetaiCode get世帯code(List<SetaiinShikibetsuCd> 世帯員識別コード情報) {
        SetaiCode 世帯code = SetaiCode.EMPTY;
        if (世帯員識別コード情報 != null && !世帯員識別コード情報.isEmpty() && 世帯員識別コード情報.get(0) != null) {
            世帯code = 世帯員識別コード情報.get(0).get世帯コード();
        }
        return 世帯code;
    }

    private int get利用者負担割合の最大履歴番号(HihokenshaNo 被保険者番号,
            FlexibleYear 年度) {
        DbT3113RiyoshaFutanWariaiEntity entity = 利用者負担割合Dac.selectMax履歴番号(年度, 被保険者番号);
        int 利用者負担割合の最大履歴番号 = 1;
        if (entity != null) {
            利用者負担割合の最大履歴番号 = entity.getRirekiNo();
        }
        return 利用者負担割合の最大履歴番号;
    }

    private RString get判定区分(
            List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 利用者負担割合明細list,
            List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 今回_作成した負担割合明細list) {
        RString 判定区分;
        if (利用者負担割合明細list == null || 利用者負担割合明細list.isEmpty()) {
            if (今回_作成した負担割合明細list == null || 今回_作成した負担割合明細list.isEmpty()) {
                判定区分 = THREE;
            } else {
                判定区分 = ONE;
            }
        } else {
            if (今回_作成した負担割合明細list == null || 今回_作成した負担割合明細list.isEmpty()) {
                判定区分 = ONE;
            } else {
                DbT3114RiyoshaFutanWariaiMeisaiEntity 現在の利用者負担割合明細 = 利用者負担割合明細list.get(INDEX_ZERO);
                DbT3114RiyoshaFutanWariaiMeisaiEntity 今回_作成した負担割合明細 = 今回_作成した負担割合明細list.get(INDEX_ZERO);
                判定区分 = get判定区分2(現在の利用者負担割合明細, 今回_作成した負担割合明細);
            }
        }
        return 判定区分;
    }

    private RString get判定区分2(DbT3114RiyoshaFutanWariaiMeisaiEntity 現在の利用者負担割合明細,
            DbT3114RiyoshaFutanWariaiMeisaiEntity 今回_作成した負担割合明細) {
        RString 判定区分;
        if (現在の利用者負担割合明細 != null && 今回_作成した負担割合明細 != null) {
            if (is負担割合情報の比較(現在の利用者負担割合明細, 今回_作成した負担割合明細)) {
                判定区分 = THREE;
            } else if (is比較変更RString(現在の利用者負担割合明細.getFutanWariaiKubun(),
                    今回_作成した負担割合明細.getFutanWariaiKubun())) {
                判定区分 = ONE;
            } else {
                判定区分 = TWO;
            }
        } else if (現在の利用者負担割合明細 == null && 今回_作成した負担割合明細 == null) {
            判定区分 = THREE;
        } else {
            判定区分 = ONE;
        }
        return 判定区分;
    }

    private boolean is負担割合情報の比較(DbT3114RiyoshaFutanWariaiMeisaiEntity 現在の利用者負担割合明細,
            DbT3114RiyoshaFutanWariaiMeisaiEntity 今回_作成した負担割合明細) {
        return 現在の利用者負担割合明細.getNendo().equals(今回_作成した負担割合明細.getNendo())
                && 現在の利用者負担割合明細.getHihokenshaNo().equals(今回_作成した負担割合明細.getHihokenshaNo())
                && 現在の利用者負担割合明細.getRirekiNo() == 今回_作成した負担割合明細.getRirekiNo()
                && 現在の利用者負担割合明細.getEdaNo() == 今回_作成した負担割合明細.getEdaNo()
                && is比較変更RString(現在の利用者負担割合明細.getShikakuKubun(),
                        今回_作成した負担割合明細.getShikakuKubun())
                && is比較変更RString(現在の利用者負担割合明細.getFutanWariaiKubun(),
                        今回_作成した負担割合明細.getFutanWariaiKubun())
                && is比較変更年月日(現在の利用者負担割合明細.getYukoKaishiYMD(),
                        今回_作成した負担割合明細.getYukoKaishiYMD())
                && is比較変更年月日(現在の利用者負担割合明細.getYukoShuryoYMD(),
                        今回_作成した負担割合明細.getYukoShuryoYMD())
                && is比較変更数字(現在の利用者負担割合明細.getHonninGoukeiShotokuGaku(),
                        今回_作成した負担割合明細.getHonninGoukeiShotokuGaku())
                && 現在の利用者負担割合明細.getSetaiIchigouHihokenshaSu()
                == 今回_作成した負担割合明細.getSetaiIchigouHihokenshaSu()
                && is比較変更数字(現在の利用者負担割合明細.getNenkinShunyuGoukei(),
                        今回_作成した負担割合明細.getNenkinShunyuGoukei())
                && is比較変更数字(現在の利用者負担割合明細.getSonotanoGoukeiShotokuKingakuGoukei(),
                        今回_作成した負担割合明細.getSonotanoGoukeiShotokuKingakuGoukei())
                && is比較変更RString(現在の利用者負担割合明細.getKoseiRiyu(), 今回_作成した負担割合明細.getKoseiRiyu())
                && is比較変更code(現在の利用者負担割合明細.getSetaiCd(), 今回_作成した負担割合明細.getSetaiCd());
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

    private List<DbT3114RiyoshaFutanWariaiMeisaiEntity> get利用者負担割合明細list(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            List<RiyoshaFutanWariaiMeisaiTempEntity> 利用者負担割合明細情報) {
        List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 利用者負担割合明細list = new ArrayList<>();
        int 枝番号 = 1;
        for (RiyoshaFutanWariaiMeisaiTempEntity entity : 利用者負担割合明細情報) {
            DbT3114RiyoshaFutanWariaiMeisaiEntity 利用者負担割合明細entity = new DbT3114RiyoshaFutanWariaiMeisaiEntity();
            利用者負担割合明細entity.setNendo(年度);
            利用者負担割合明細entity.setHihokenshaNo(被保険者番号);
            List<DbT3114RiyoshaFutanWariaiMeisaiEntity> list = 利用者負担割合明細Dac.
                    select履歴番号BY年度と被保険者番号(年度, 被保険者番号);
            if (list != null && !list.isEmpty()) {
                利用者負担割合明細entity.setRirekiNo(list.get(0).getRirekiNo());
            } else {
                利用者負担割合明細entity.setRirekiNo(履歴番号_ONE);
            }
            利用者負担割合明細entity.setEdaNo(枝番号);
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
            枝番号++;
        }
        return 利用者負担割合明細list;
    }

    private List<DbT3115RiyoshaFutanWariaiKonkyoEntity> get利用者負担割合根拠list(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            List<RiyoshaFutanWariaiKonkyoTempEntity> 利用者負担割合根拠情報) {
        List<DbT3115RiyoshaFutanWariaiKonkyoEntity> 利用者負担割合根拠list = new ArrayList<>();
        int 枝番号 = 1;
        for (RiyoshaFutanWariaiKonkyoTempEntity entity : 利用者負担割合根拠情報) {
            DbT3115RiyoshaFutanWariaiKonkyoEntity 利用者負担割合根拠entity = new DbT3115RiyoshaFutanWariaiKonkyoEntity();
            利用者負担割合根拠entity.setNendo(年度);
            利用者負担割合根拠entity.setHihokenshaNo(被保険者番号);
            DbT3115RiyoshaFutanWariaiKonkyoEntity result = 利用者負担割合根拠Dac.select履歴番号(年度, 被保険者番号);
            if (result != null) {
                利用者負担割合根拠entity.setRirekiNo(result.getRirekiNo());
            } else {
                利用者負担割合根拠entity.setRirekiNo(履歴番号_ONE);
            }
            利用者負担割合根拠entity.setEdaNo(枝番号);
            利用者負担割合根拠entity.setSetaiinHihokenshaNo(entity.getSetaiinHihokenshaNo());
            利用者負担割合根拠entity.setSetaiinShotokuRirekiNo(entity.getSetaiinShotokuRirekiNo());
            利用者負担割合根拠list.add(利用者負担割合根拠entity);
            枝番号++;
        }
        return 利用者負担割合根拠list;
    }

    private void get利用者負担割合entity(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            DbT3113RiyoshaFutanWariaiEntity 利用者負担割合entity,
            RString koseiJiyu) {
        利用者負担割合entity.setNendo(年度);
        利用者負担割合entity.setHihokenshaNo(被保険者番号);
        DbT3113RiyoshaFutanWariaiEntity entity = 利用者負担割合Dac.selectMax履歴番号(年度, 被保険者番号);
        if (entity != null) {
            利用者負担割合entity.setRirekiNo(entity.getRirekiNo());
        } else {
            利用者負担割合entity.setRirekiNo(履歴番号_ONE);
        }
        利用者負担割合entity.setHakoFuyoFlag(false);
        利用者負担割合entity.setShokenFlag(false);
        利用者負担割合entity.setHanteiYMD(FlexibleDate.getNowDate());
        利用者負担割合entity.setHanteiKubun(FOUR);
        if (!RString.isNullOrEmpty(koseiJiyu)) {
            利用者負担割合entity.setKoseiJiyu(new Code(koseiJiyu));
        } else {
            利用者負担割合entity.setKoseiJiyu(Code.EMPTY);
        }
        利用者負担割合entity.setHakoKubun(ZERO);
        利用者負担割合entity.setHakoYMD(FlexibleDate.EMPTY);
        利用者負担割合entity.setKofuYMD(FlexibleDate.EMPTY);
        利用者負担割合entity.setLogicalDeletedFlag(false);
    }

    private void set利用者負担割合明細Tempのソート(
            List<RiyoshaFutanWariaiMeisaiTempEntity> 利用者負担割合明細Tempのマージデータ) {
        Collections.sort(利用者負担割合明細Tempのマージデータ, new Comparator<RiyoshaFutanWariaiMeisaiTempEntity>() {
            @Override
            public int compare(RiyoshaFutanWariaiMeisaiTempEntity o1, RiyoshaFutanWariaiMeisaiTempEntity o2) {
                return new RString(o1.getEdaNo()).compareTo(new RString(o2.getEdaNo()));
            }
        });
    }

    private void set利用者負担割合根拠Tempのマージデータ(
            List<RiyoshaFutanWariaiKonkyoTempEntity> 利用者負担割合根拠Tempのマージデータ) {
        Collections.sort(利用者負担割合根拠Tempのマージデータ, new Comparator<RiyoshaFutanWariaiKonkyoTempEntity>() {
            @Override
            public int compare(RiyoshaFutanWariaiKonkyoTempEntity o1, RiyoshaFutanWariaiKonkyoTempEntity o2) {
                return new RString(o1.getEdaNo()).compareTo(new RString(o2.getEdaNo()));
            }
        });
    }

    private void get利用者負担割合根拠Temp(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            HihokenshaDaicho 被保険者台帳,
            RiyoshaFutanWariaiKonkyoTempEntity 利用者負担割合根拠Temp,
            List<DbV2512KaigoShotokuNewestEntity> 介護所得情報) {
        利用者負担割合根拠Temp.setNendo(年度);
        利用者負担割合根拠Temp.setHihokenshaNo(被保険者番号);
        利用者負担割合根拠Temp.setSetaiinHihokenshaNo(被保険者台帳.get被保険者番号());
        if (介護所得情報 != null && !介護所得情報.isEmpty()) {
            利用者負担割合根拠Temp.setSetaiinShotokuRirekiNo(new Decimal(Integer.parseInt(
                    Long.toString(介護所得情報.get(0).getRirekiNo()))));
        }

    }

    private void get利用者負担割合明細Temp(
            HihokenshaNo 被保険者番号,
            HihokenshaDaicho 被保険者台帳,
            FutanWariaiHanteiResult 負担割合判定の結果,
            List<DbV2512KaigoShotokuNewestEntity> 介護所得情報list,
            SetaiCode 世帯コード,
            int 世帯１号被保険者数,
            SeikatsuHogoGaitoJohoTempEntity 生活保護該当情報Temp,
            HanteiTaishoshaTempEntity 判定対象者Temp,
            RiyoshaFutanWariaiMeisaiTempEntity 利用者負担割合明細Temp) {
        利用者負担割合明細Temp.setHihokenshaNo(被保険者番号);
        利用者負担割合明細Temp.setEdaNo(Integer.parseInt(被保険者台帳.get枝番().toString()));
        if (!RString.isNullOrEmpty(被保険者台帳.get被保険者区分コード())) {
            利用者負担割合明細Temp.setShikakuKubun(被保険者台帳.get被保険者区分コード().padZeroToLeft(1));
        }
        利用者負担割合明細Temp.setFutanWariaiKubun(負担割合判定の結果.get負担割合区分());
        利用者負担割合明細Temp.setYukoKaishiYMD(FlexibleDate.EMPTY);
        利用者負担割合明細Temp.setYukoShuryoYMD(FlexibleDate.EMPTY);
        Decimal 年金収入合計 = Decimal.ZERO;
        Decimal その他の合計所得金額 = Decimal.ZERO;
        if (介護所得情報list != null && !介護所得情報list.isEmpty()) {
            for (DbV2512KaigoShotokuNewestEntity 介護所得情報 : 介護所得情報list) {
                if (介護所得情報.getNenkiniShotokuGaku() != null && 介護所得情報.getGokeiShotokuGaku() != null
                        && 介護所得情報.getNenkiniShotokuGaku().compareTo(介護所得情報.getGokeiShotokuGaku()) < 0) {
                    その他の合計所得金額 = その他の合計所得金額.add(介護所得情報.getGokeiShotokuGaku().
                            subtract(介護所得情報.getNenkiniShotokuGaku()));
                }
                年金収入合計 = 年金収入合計.add(介護所得情報.getNenkiniShotokuGaku());
            }
            利用者負担割合明細Temp.setSonotanoGoukeiShotokuKingakuGoukei(その他の合計所得金額);
            利用者負担割合明細Temp.setHonninGoukeiShotokuGaku(介護所得情報list.get(0).getGokeiShotokuGaku());
            利用者負担割合明細Temp.setNenkinShunyuGoukei(年金収入合計);
        }
        利用者負担割合明細Temp.setSetaiIchigouHihokenshaSu(世帯１号被保険者数);
        利用者負担割合明細Temp.setKoseiRiyu(RString.EMPTY);
        利用者負担割合明細Temp.setSetaiCd(世帯コード);
        利用者負担割合明細Temp.setKoseiJiyu(RString.EMPTY);
        利用者負担割合明細Temp.setHanteiKubun(負担割合判定の結果.get判定区分());
        利用者負担割合明細Temp.setNinteiYukoKaishiDate(判定対象者Temp.getNinteiYukoKaishiDate());
        if (生活保護該当情報Temp.getJukyuKaishiYMD() != null && !生活保護該当情報Temp.getJukyuKaishiYMD().isEmpty()) {
            利用者負担割合明細Temp.setJukyuKaishiYMD(new FlexibleDate(生活保護該当情報Temp.getJukyuKaishiYMD()));
        }
    }

    private void get生活保護該当情報Temp(
            SeikatsuHogoGaitoJohoTempEntity 生活保護該当情報Temp,
            List<UrT0508SeikatsuHogoJukyushaEntity> 生活保護受給者情報,
            FlexibleDate 対象開始日) {
        生活保護該当情報Temp.setTaishoTsuki(new RString(対象開始日.getMonthValue()));
        生活保護該当情報Temp.setShikibetsuCode(生活保護受給者情報.get(0).getShikibetsuCode());
        FlexibleDate 受給開始日 = 生活保護受給者情報.get(0).getJukyuKaishiYMD();
        FlexibleDate 受給廃止日 = 生活保護受給者情報.get(0).getJukyuHaishiYMD();
        for (UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者 : 生活保護受給者情報) {
            if ((生活保護受給者.getJukyuKaishiYMD() != null && !生活保護受給者.getJukyuKaishiYMD().isEmpty())
                    && (受給開始日 != null && !受給開始日.isEmpty())
                    && 生活保護受給者.getJukyuKaishiYMD().isBefore(受給開始日)) {
                受給開始日 = 生活保護受給者.getJukyuKaishiYMD();
            }
            if (受給廃止日 != null && !受給廃止日.isEmpty() && 生活保護受給者.getJukyuHaishiYMD() != null
                    && !生活保護受給者.getJukyuHaishiYMD().isEmpty()
                    && 受給廃止日.isBefore(生活保護受給者.getJukyuHaishiYMD())) {
                受給廃止日 = 生活保護受給者.getJukyuHaishiYMD();
            }
        }
        if (受給開始日 != null && !受給開始日.isEmpty()) {
            生活保護該当情報Temp.setJukyuKaishiYMD(new RString(受給開始日.toString()));
        }
        生活保護該当情報Temp.setJukyuHaishiYMD(受給廃止日 == null || 受給廃止日.isEmpty()
                ? RString.EMPTY : new RString(受給廃止日.toString()));
    }

    private void set判定対象者Tempの共通項目部分(
            HihokenshaNo 被保険者番号,
            HanteiTaishoshaTempEntity 判定対象者Temp,
            HihokenshaDaicho 被保険者台帳,
            List<SetaiinShikibetsuCd> 世帯員識別コード情報) {
        判定対象者Temp.setHihokenshaNo(被保険者番号);
        判定対象者Temp.setShikibetsuCode(被保険者台帳.get識別コード());
        if (世帯員識別コード情報 != null && !世帯員識別コード情報.isEmpty()) {
            判定対象者Temp.setSetaiCode(世帯員識別コード情報.get(0).get世帯コード());
        }
        判定対象者Temp.setIdoShubetsu(RString.EMPTY);

    }

    private void set判定対象者Tempの被保険者情報部分(
            HanteiTaishoshaTempEntity 判定対象者Temp,
            HihokenshaDaicho 被保険者台帳) {
        if (被保険者台帳 != null) {
            判定対象者Temp.setIdoJiyuCode(被保険者台帳.get異動事由コード());
            判定対象者Temp.setShikakuShiyutokiDate(被保険者台帳.get資格取得年月日());
            判定対象者Temp.setFirstShikakuShiyutokiDate(被保険者台帳.get第1号資格取得年月日());
            判定対象者Temp.setHihokenshaKubunCode(被保険者台帳.get被保険者区分コード());
        }
    }

    private void set判定対象者Tempの受給者台帳部分(
            HanteiTaishoshaTempEntity 判定対象者Temp,
            List<JukyushaDaicho> jukyushaDaicholist,
            List<SogoJigyoTaishosha> sogoJigyoTaishoshalist,
            List<JukyushaDaicho> 基準日時点で受給者台帳) {
        if (jukyushaDaicholist != null && !jukyushaDaicholist.isEmpty()) {
            get受給者台帳_判定対象者Temp(jukyushaDaicholist.get(0), 判定対象者Temp);
        } else {
            if (sogoJigyoTaishoshalist != null && !sogoJigyoTaishoshalist.isEmpty()) {
                get総合事業対象者_受給者台帳_判定対象者Temp(
                        sogoJigyoTaishoshalist.get(0), 判定対象者Temp);
            } else if (!基準日時点で受給者台帳.isEmpty()) {
                get受給者台帳_判定対象者Temp(基準日時点で受給者台帳.get(0), 判定対象者Temp);
            }
        }
    }

    private void set判定対象者Tempの介護所得情報部分(
            HanteiTaishoshaTempEntity 判定対象者Temp,
            List<DbV2512KaigoShotokuNewestEntity> 介護所得情報) {
        if (介護所得情報 != null && !介護所得情報.isEmpty()) {
            判定対象者Temp.setShotokuNendo(介護所得情報.get(0).getShotokuNendo());
            判定対象者Temp.setRirekiNo(new RString(Long.toString(介護所得情報.get(0).getRirekiNo())));
            判定対象者Temp.setKazeiKubun(介護所得情報.get(0).getKazeiKubun());
            判定対象者Temp.setKazeiKubunGemmenGo(介護所得情報.get(0).getKazeiKubunGemmenGo());
            判定対象者Temp.setGokeiShotokuGaku(介護所得情報.get(0).getGokeiShotokuGaku());
            判定対象者Temp.setNenkiniShunyuGaku(介護所得情報.get(0).getNenkiniShunyuGaku());
            判定対象者Temp.setNenkiniShotokuGaku(介護所得情報.get(0).getNenkiniShotokuGaku());
            判定対象者Temp.setKazeiShotokuGaku(介護所得情報.get(0).getKazeiShotokuGaku());
            判定対象者Temp.setGekihenKanwaKubun(介護所得情報.get(0).getGekihenKanwaKubun());
        }
    }

    private List<JukyushaDaicho> get受給者台帳情報の取得(
            List<JukyushaDaicho> 受給者台帳情報, HihokenshaNo 被保険者番号) {
        List<JukyushaDaicho> result = new ArrayList<>();
        for (JukyushaDaicho 受給者台帳 : 受給者台帳情報) {
            if (!受給者台帳.is論理削除フラグ() && !受給者台帳.get有効無効区分().value().equals(TWO)
                    && 被保険者番号.equals(受給者台帳.get被保険者番号())) {
                result.add(受給者台帳);
            }
        }
        Collections.sort(result, new Comparator<JukyushaDaicho>() {
            @Override
            public int compare(JukyushaDaicho o1, JukyushaDaicho o2) {
                int flag = o1.get履歴番号().compareTo(o2.get履歴番号());
                if (0 == flag) {
                    flag = o1.get枝番().compareTo(o2.get枝番());
                }
                return flag;
            }
        });
        return result;
    }

    private List<SogoJigyoTaishosha> get総合事業対象者情報の取得(
            List<SogoJigyoTaishosha> 総合事業対象者情報,
            HihokenshaNo 被保険者番号) {
        List<SogoJigyoTaishosha> result = new ArrayList<>();
        for (SogoJigyoTaishosha 総合事業対象者 : 総合事業対象者情報) {
            if (被保険者番号.equals(総合事業対象者.get被保険者番号())) {
                result.add(総合事業対象者);
            }
        }
        Collections.sort(result, new Comparator<SogoJigyoTaishosha>() {
            @Override
            public int compare(SogoJigyoTaishosha o1, SogoJigyoTaishosha o2) {
                return new RString(o1.get履歴番号()).compareTo(new RString(o2.get履歴番号()));
            }
        });
        return result;
    }

    private void get受給者台帳_判定対象者Temp(
            JukyushaDaicho 受給者台帳,
            HanteiTaishoshaTempEntity 判定対象者Temp) {
        判定対象者Temp.setTaishoKubun(ONE);
        判定対象者Temp.setCityCode(受給者台帳.get市町村コード().value());
        判定対象者Temp.setRirekiNo(受給者台帳.get履歴番号());
        判定対象者Temp.setEdaNo(受給者台帳.get枝番());
        判定対象者Temp.setJukyuShinseiJiyu(受給者台帳.get受給申請事由().value());
        判定対象者Temp.setNinteiYukoKaishiDate(受給者台帳.get認定有効期間開始年月日());
        判定対象者Temp.setNinteiYukoShuryoDate(受給者台帳.get認定有効期間終了年月日());
        判定対象者Temp.setNinteiDate(受給者台帳.get認定年月日());
    }

    private void get総合事業対象者_受給者台帳_判定対象者Temp(
            SogoJigyoTaishosha 総合事業対象者,
            HanteiTaishoshaTempEntity 判定対象者Temp) {
        判定対象者Temp.setTaishoKubun(TWO);
        判定対象者Temp.setCityCode(RString.EMPTY);
        判定対象者Temp.setRirekiNo(new RString(総合事業対象者.get履歴番号()));
        判定対象者Temp.setEdaNo(RString.EMPTY);
        判定対象者Temp.setJukyuShinseiJiyu(RString.EMPTY);
        判定対象者Temp.setNinteiYukoKaishiDate(総合事業対象者.get適用開始年月日());
        判定対象者Temp.setNinteiYukoShuryoDate(総合事業対象者.get適用終了年月日());
        判定対象者Temp.setNinteiDate(総合事業対象者.get受付年月日());
    }

    private List<JukyushaDaicho> get基準日時点で認定期間中のデータ(
            List<JukyushaDaicho> 受給者台帳,
            FlexibleDate 判定基準日) {
        List<JukyushaDaicho> result = new ArrayList<>();
        for (JukyushaDaicho jukydai : 受給者台帳) {
            if (!定値_履歴番号.equals(jukydai.get履歴番号())
                    && ((jukydai.get認定有効期間開始年月日() != null && !jukydai.get認定有効期間開始年月日().isEmpty()
                    && 判定基準日 != null && !判定基準日.isEmpty()
                    && jukydai.get認定有効期間開始年月日().isBefore(判定基準日))
                    || (判定基準日 != null && !判定基準日.isEmpty()
                    && jukydai.get認定有効期間終了年月日() != null && !jukydai.get認定有効期間終了年月日().isEmpty()
                    && 判定基準日.isBefore(jukydai.get認定有効期間終了年月日())))
                    && !jukydai.get要介護認定状態区分コード().value().equals(ZERO_ONE)
                    && !jukydai.is論理削除フラグ()
                    && jukydai.get有効無効区分().value().equals(ONE)) {
                result.add(jukydai);
            }
        }
        return result;
    }

    private List<SogoJigyoTaishosha> get基準時時点で事業対象者のデータ(
            List<SogoJigyoTaishosha> 総合事業対象者情報,
            FlexibleDate 判定基準日) {
        List<SogoJigyoTaishosha> result = new ArrayList<>();
        for (SogoJigyoTaishosha 総合事業対象者 : 総合事業対象者情報) {
            if (総合事業対象者.get適用開始年月日() != null && !総合事業対象者.get適用開始年月日().isEmpty()
                    && 総合事業対象者.get適用終了年月日() != null && !総合事業対象者.get適用終了年月日().isEmpty()
                    && 判定基準日 != null && !判定基準日.isEmpty()
                    && (総合事業対象者.get適用開始年月日().isBefore(判定基準日)
                    && 判定基準日.isBefore(総合事業対象者.get適用終了年月日()))) {
                result.add(総合事業対象者);
            }
        }
        return result;
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

    private List<JukyushaDaicho> get基準日時点で申請中のデータ(
            FlexibleDate 判定基準日,
            List<JukyushaDaicho> 受給者台帳情報) {
        List<JukyushaDaicho> result = new ArrayList<>();
        for (JukyushaDaicho jukydai : 受給者台帳情報) {
            if (定値_履歴番号.equals(jukydai.get履歴番号())
                    && ((jukydai.get受給申請年月日() != null && !jukydai.get受給申請年月日().isEmpty()
                    && 判定基準日 != null && !判定基準日.isEmpty()
                    && jukydai.get受給申請年月日().isBefore(判定基準日))
                    || (判定基準日 != null && !判定基準日.isEmpty()
                    && jukydai.get受給申請年月日() != null && !jukydai.get受給申請年月日().isEmpty()
                    && 判定基準日.equals(jukydai.get受給申請年月日())))) {
                result.add(jukydai);
            }
        }
        return result;
    }

    private List<SetaiinShikibetsuCd> remove重複(List<SetaiinShikibetsuCd> 世帯員識別コード情報list) {
        if (世帯員識別コード情報list == null) {
            return new ArrayList<>();
        } else if (世帯員識別コード情報list.isEmpty()) {
            return 世帯員識別コード情報list;
        }
        Map<RString, SetaiinShikibetsuCd> 識別コードMap = new HashMap();
        for (SetaiinShikibetsuCd コード : 世帯員識別コード情報list) {
            RString code = コード.get世帯員識別コード().value();
            if (!識別コードMap.containsKey(code)) {
                識別コードMap.put(code, コード);
            }
        }
        List<SetaiinShikibetsuCd> tempList = new ArrayList<>();
        for (RString code : 識別コードMap.keySet()) {
            tempList.add(識別コードMap.get(code));
        }
        return tempList;
    }

    private HihokenshaDaicho get被保険者台帳(
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

    private int get世帯１号被保険者数(
            List<SetaiinShikibetsuCd> 世帯員識別コード情報list) {
        int 世帯１号被保険者数 = 1;
        for (SetaiinShikibetsuCd 世帯員識別コード情報 : 世帯員識別コード情報list) {
            if (!HonninKubun.本人.getCode().equals(世帯員識別コード情報.get本人区分())) {
                世帯１号被保険者数 = 世帯１号被保険者数 + 1;
            }
        }
        return 世帯１号被保険者数;
    }

    private List<SetaiinShikibetsuCd> get世帯員被保険者該当チェック(
            List<SetaiinShikibetsuCd> 世帯員識別コード情報list,
            HihokenshaDaicho 世帯員の被保険者台帳,
            HihokenshaDaicho 被保険者台帳,
            FlexibleDate 基準日,
            FlexibleDate 判定基準日) {
        List<SetaiinShikibetsuCd> 世帯員識別コード情報 = new ArrayList<>();
        for (SetaiinShikibetsuCd 世帯員情報 : 世帯員識別コード情報list) {
            if (!(基準日.equals(判定基準日) && 被保険者台帳 != null && !ONE.equals(
                    被保険者台帳.get被保険者区分コード()) && 世帯員の被保険者台帳 == null)) {
                世帯員識別コード情報.add(世帯員情報);
            }
        }
        return 世帯員識別コード情報;
    }

    private HihokenshaDaicho get世帯員の被保険者台帳(
            List<SetaiinShikibetsuCd> 世帯員識別コード情報list,
            FlexibleDate 判定基準日) {
        HihokenshaDaicho 被保険者台帳 = null;
        for (SetaiinShikibetsuCd 世帯員識別コード情報 : 世帯員識別コード情報list) {
            if (HonninKubun.世帯構成員.getCode().equals(世帯員識別コード情報.get本人区分())) {
                被保険者台帳 = HihokenshaDaichoManager.createInstance().
                        find被保険者台帳(世帯員識別コード情報.get世帯員識別コード(), 判定基準日);
            }
        }
        return 被保険者台帳;
    }
}
