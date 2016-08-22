/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihantei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc180020.DBC180020_IdoRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180020.DBC180020MyBatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.DBC180020ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.FutanWariaiHanteiJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.HanteiTaishoshaDaichoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.SetainJohoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SeikatsuHogoGaitoJohoTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2512KaigoShotokuNewestEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * RiyoshaFutanWariaiHanteiUtilのクラスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class RiyoshaFutanWariaiHanteiUtil {

    private static final RString STR0801 = new RString("0801");
    private static final RString STR0731 = new RString("0731");
    private static final int NUM0 = 0;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private static final int NUM6 = 6;
    private static final int NUM8 = 8;

    /**
     * コンストラクタです。
     */
    public RiyoshaFutanWariaiHanteiUtil() {

    }

    /**
     * getIndexOfKijunMonthのメソッドです。
     *
     * @param 基準日 RString
     * @return Integer
     */
    public Integer getIndexOfKijunMonth(RString 基準日) {
        if (基準日 == null) {
            return null;
        }
        int 基準日の月 = Integer.parseInt(基準日.substring(NUM4, NUM6).toString());
        if (基準日の月 >= NUM8) {
            return 基準日の月 - NUM8;
        }
        return 基準日の月 + NUM4;
    }

    /**
     * is同月のメソッドです。
     *
     * @param 現在の判定基準日 RString
     * @param 認定有効期間開始年月日 RString
     * @return boolean
     */
    public boolean is同月(RString 現在の判定基準日, FlexibleDate 認定有効期間開始年月日) {
        RString 有効期間開始年月日 = getFlexibleDateString(認定有効期間開始年月日);
        if (RString.isNullOrEmpty(現在の判定基準日) || RString.isNullOrEmpty(有効期間開始年月日)) {
            return false;
        }
        RString 判定基準日の月 = 現在の判定基準日.substring(NUM0, NUM6);
        RString 有効開始年月日の月 = 認定有効期間開始年月日.getYearMonth().toDateString();
        FlexibleDate 現在判定基準日 = new FlexibleDate(現在の判定基準日);
        return 判定基準日の月.equals(有効開始年月日の月) && 現在判定基準日.isBefore(認定有効期間開始年月日);
    }

    /**
     * getFlexibleDateStringのメソッドです。
     *
     * @param date FlexibleDate
     * @return RString
     */
    public RString getFlexibleDateString(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return null;
        }
        return new RString(date.toString());
    }

    /**
     * getFlexibleYearStringのメソッドです。
     *
     * @param date FlexibleYear
     * @return RString
     */
    public RString getFlexibleYearString(FlexibleYear date) {
        if (date == null || date.isEmpty()) {
            return null;
        }
        return new RString(date.toString());
    }

    /**
     * getFlexibleYearStringのメソッドです。
     *
     * @param date FlexibleYear
     * @return RString
     */
    public RYear getFlexibleYearRYear(FlexibleYear date) {
        if (date == null || date.isEmpty()) {
            return null;
        }
        return new RYear(date.toString());
    }

    /**
     * toHanteiTaishoshaTempのメソッドです。
     *
     * @param result SogoJigyoJukyushaDaichoEntity
     * @return HanteiTaishoshaTempEntity
     */
    public HanteiTaishoshaTempEntity toHanteiTaishoshaTemp(HanteiTaishoshaDaichoEntity result) {
        if (result == null) {
            return null;
        }
        if (result.get受給者台帳().isEmpty() && !result.get総合事業対象者().isEmpty()) {
            return null;

        }
        if (result.get総合事業対象者().isEmpty() && !result.get受給者台帳().isEmpty()) {
            return null;
        }
        return null;
    }

    /**
     * get対象年度開始日のメソッドです。
     *
     * @param 対象年度 RString
     * @return RString
     */
    public RString get対象年度開始日(RYear 対象年度) {
        if (対象年度 == null) {
            return RString.EMPTY;
        }
        return 対象年度.toDateString().concat(STR0801);
    }

    /**
     * get対象年度終了日のメソッドです。
     *
     * @param 対象年度 RString
     * @return RString
     */
    public RString get対象年度終了日(RYear 対象年度) {
        if (対象年度 == null) {
            return RString.EMPTY;
        }
        RString 対象來年度 = new RString(Integer.parseInt(対象年度.toDateString().toString()) + 1);
        return 対象來年度.concat(STR0731);
    }

    /**
     * set対象年度開始終了日のメソッドです。
     *
     * @param param DBC180020MyBatisParameter
     */
    public void set対象年度開始終了日(DBC180020MyBatisParameter param) {
        RString 対象年度 = param.get対象年度();
        if (RString.isNullOrEmpty(対象年度)) {
            return;
        }
        RString 対象來年度 = 対象年度.substring(0, NUM3).concat(
                new RString(Integer.parseInt(対象年度.substring(NUM3, NUM4).toString() + 1)));
        param.set対象年度終了日(対象來年度.concat(STR0731));
        param.set対象年度開始日(対象年度.concat(STR0801));
    }

    /**
     * DBC180020ProcessParameterを取得します。
     *
     * @param param DBC180020_IdoRiyoshaFutanwariaiHanteiParameter
     * @param 異動 boolean
     * @param index int
     * @return DBC180020ProcessParameter
     */
    public DBC180020ProcessParameter toProcessParameter(DBC180020_IdoRiyoshaFutanwariaiHanteiParameter param,
            boolean 異動, int index) {
        if (異動) {
            return new DBC180020ProcessParameter(
                    getFlexibleYearRYear(param.getTaishoNendo()),
                    異動,
                    param.get対象開始日(),
                    param.get対象終了日(),
                    param.getTaishoGetsu(),
                    index);
        } else {
            return new DBC180020ProcessParameter(
                    getFlexibleYearRYear(param.getTaishoNendo()),
                    異動,
                    param.get対象開始日(),
                    param.get対象終了日(),
                    param.getTaishoGetsu(),
                    0);
        }
    }

    /**
     * DBC180020ProcessParameterを取得します。
     *
     * @param param DBC180020_IdoRiyoshaFutanwariaiHanteiParameter
     * @param index int
     * @return DBC180020ProcessParameter
     */
    public DBC180020ProcessParameter toProcessParameter(DBC180020_IdoRiyoshaFutanwariaiHanteiParameter param,
            int index) {
        return new DBC180020ProcessParameter(
                getFlexibleYearRYear(param.getTaishoNendo()),
                getFlexibleDateString(param.getKijunbi()),
                param.getShoriKubun(),
                param.isTestMode(),
                param.getHanteiKijunbi(),
                param.getTaishoGetsu(),
                param.get対象開始日(),
                param.get対象終了日(),
                param.getChushutuKaisu(),
                index);
    }

    /**
     * DBC180020ProcessParameterを取得します。
     *
     * @param param DBC180020_IdoRiyoshaFutanwariaiHanteiParameter
     * @return DBC180020ProcessParameter
     */
    public DBC180020ProcessParameter toProcessParameter(DBC180020_IdoRiyoshaFutanwariaiHanteiParameter param) {
        return new DBC180020ProcessParameter(
                getFlexibleYearRYear(param.getTaishoNendo()),
                getFlexibleDateString(param.getKijunbi()),
                param.getShoriKubun(),
                param.isTestMode(),
                param.getHanteiKijunbi(),
                param.getTaishoGetsu(),
                param.get対象開始日(),
                param.get対象終了日(),
                param.getChushutuKaisu()
        );
    }

    /**
     * getFutanWariaiHanteiJohoのメソッドです。
     *
     * @param entities List<FutanWariaiHanteiJohoEntity>
     * @return FutanWariaiHanteiJoho
     */
    public FutanWariaiHanteiJoho getFutanWariaiHanteiJoho(List<FutanWariaiHanteiJohoEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        HanteiTaishoshaTempEntity 判定対象者Temp = entities.get(0).get判定対象者();
        List<SeikatsuHogoGaitoJohoTempEntity> 生活保護該当情報リスト = entities.get(0).get生活保護該当情報();
        SeikatsuHogoGaitoJohoTempEntity 生活保護該当情報Temp = 生活保護該当情報リスト == null
                || 生活保護該当情報リスト.isEmpty() ? null : 生活保護該当情報リスト.get(0);
        FlexibleDate 判定基準日 = entities.get(0).get判定基準日();
        List<DbV2512KaigoShotokuNewestEntity> 介護所得情報 = new ArrayList<>();
        for (FutanWariaiHanteiJohoEntity entity : entities) {
            List<SetainJohoRelateEntity> 世帯員情報Entities = entity.get世帯員情報Entity();
            if (世帯員情報Entities == null || 世帯員情報Entities.isEmpty()) {
                continue;
            }
            介護所得情報.add(世帯員情報Entities.get(0).get介護所得情報());
        }
        return new FutanWariaiHanteiJoho(判定対象者Temp, 生活保護該当情報Temp, 介護所得情報, 判定基準日);
    }

    /**
     * getTsukiのメソッドです。
     *
     * @param 基準日 RString
     * @return RString
     */
    public RString getTsuki(RString 基準日) {
        if (RString.isNullOrEmpty(基準日)) {
            return RString.EMPTY;
        }
        return 基準日.substring(NUM4, NUM6);
    }
}
