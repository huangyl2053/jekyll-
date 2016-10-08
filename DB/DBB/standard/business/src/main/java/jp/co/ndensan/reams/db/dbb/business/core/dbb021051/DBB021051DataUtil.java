/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.dbb021051;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.dbb021051.DBZ100001AtenaSealEntity;
import jp.co.ndensan.reams.db.dbb.business.report.dbb021051.DBZ100001AtenaSealParameterEntity;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb021051.DBB021051ProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.csv.DBB021051ShoriKekkaKakuninListCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051.AtenaSealJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051.DBB021051ShoriKekkaListTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051.DBB021051TableJohoTempEntity;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AtesakiShubetsu;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）のDBB021051DataUtilのクラスです。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
public class DBB021051DataUtil {

    private static final RString ERROR_市町村コード = new RString("000000");
    private static final int 市町村コード長さ = 6;
    private final RString str都道府県 = new RString("都道府県");
    private final RString str郡 = new RString("郡");
    private final RString str市町村 = new RString("市町村");
    private final RString str方書 = new RString("方書");
    private final RString 宛名シールのタイトル = new RString("宛名シール");
    private final RString 左括号 = new RString("（");
    private final RString 右括号 = new RString("）");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString FOUR = new RString("4");
    private static final RString FIVE = new RString("5");
    private static final RString SIX = new RString("6");
    private static final RString SEVEN = new RString("7");
    private static final RString ERRORKUBUN = new RString("99");
    private static final RString 生活保護受給者情報 = new RString("【生活保護受給者情報】　　");
    private static final RString 生活保護受給者情報2 = new RString("                                              ");
    private static final RString 普通徴収 = new RString("普通徴収");
    private static final RString 特別徴収 = new RString("特別徴収");
    private static final RString 基準年月 = new RString("【基準年月】　");
    private static final RString 資格区分 = new RString("【資格区分】　");
    private static final RString 日本人1号 = new RString("1号(日本人)");
    private static final RString 日本人2号 = new RString("2号(日本人)");
    private static final RString 外国人1号 = new RString("1号(外国人)");
    private static final RString 外国人2号 = new RString("2号(外国人)");
    private static final RString 全て1号 = new RString("1号(全て)");
    private static final RString 全て2号 = new RString("2号(全て)");
    private static final RString 全て = new RString("全て");
    private static final RString 市町村指定 = new RString("【市町村指定】　");
    private static final RString 最優先住所 = new RString("【最優先住所】　");
    private static final RString 現住所 = new RString("現住所");
    private static final RString 送付先または代納人 = new RString("送付先または代納人");
    private static final RString 敬称 = new RString("【敬称】　");
    private static final RString 被保番号表示 = new RString("【被保番号表示】　");
    private static final RString 表示する = new RString("表示する");
    private static final RString 表示しない = new RString("表示しない");
    private static final RString 宛先住所設定 = new RString("【宛先住所設定】");
    private static final RString 出力順 = new RString("【出力順】　");
    private static final RString 出力順2 = new RString("                     ");
    private static final RString 取込対象データなし = new RString("取込対象データなし");
    private RString tmp;
    private boolean 最優先住所がニ;
    private AtenaJusho 住所;
    private AtenaBanchi 番地;
    private Katagaki 方書;
    private RString wk管内管外区分;

    /**
     * toDBB021051TableJohoTempEntityのメソッドです。
     *
     * @param entity KaigoChoshuHohoJohoEntity
     * @param parameter DBB021051ProcessParameter
     * @return DBB021051TableJohoTempEntity
     *
     */
    public DBB021051TableJohoTempEntity toDBB021051TableJohoTempEntity(AtenaSealJohoEntity entity,
            DBB021051ProcessParameter parameter) {
        最優先住所がニ = TWO.equals(parameter.get最優先住所());
        DBB021051TableJohoTempEntity result = new DBB021051TableJohoTempEntity();
        result.set被保険者番号(entity.get被保険者番号());
        UaFt200FindShikibetsuTaishoEntity 宛名PSM = get宛名PSM(entity);
        UaFt250FindAtesakiEntity 宛先PSM = get宛先PSM(entity);
        LasdecCode lasdecCode = 宛名PSM.getGenLasdecCode();
        result.set市町村コード(lasdecCode == null || lasdecCode.isEmpty() ? ERROR_市町村コード : lasdecCode.value());
        if (宛先PSM != null) {
            result.set代納区分名称(AtesakiShubetsu.toValue(宛先PSM.getAtesakiShubetsu()).toRString());
        }
        set宛名情報(宛名PSM, result);
        住所 = null;
        番地 = null;
        方書 = null;
        wk管内管外区分 = RString.EMPTY;
        if (最優先住所がニ) {
            set最優先住所がニの宛先情報(宛先PSM, result, parameter);
        } else {
            set最優先住所がニ以外宛名情報(宛名PSM, result, parameter);
        }
        if (ONE.equals(wk管内管外区分)) {
            result.setバーコード住所(getバーコード住所(parameter, 住所, 番地, 方書));
        } else {
            result.setバーコード住所(getバーコード住所(住所, 番地, 方書));
        }
        return result;
    }

    /**
     * getErrorEntityのメソッドです。
     *
     * @return DBB021051ShoriKekkaListTempEntity
     */
    public DBB021051ShoriKekkaListTempEntity getErrorEntity() {
        DBB021051ShoriKekkaListTempEntity error = new DBB021051ShoriKekkaListTempEntity();
        error.setエラー区分(ERRORKUBUN);
        error.setキー1(RString.EMPTY);
        error.setキー2(RString.EMPTY);
        error.setキー3(RString.EMPTY);
        error.setキー4(RString.EMPTY);
        error.setキー5(RString.EMPTY);
        error.set備考(RString.EMPTY);
        error.set被保険者カナ氏名(RString.EMPTY);
        error.set被保険者氏名(RString.EMPTY);
        error.set被保険者番号(RString.EMPTY);
        error.set証記載保険者番号(RString.EMPTY);
        return error;
    }

    /**
     * 帳票用Entityを作成する。
     *
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @param システム日付 RString
     * @return DBZ100001AtenaSealParameterEntity
     */
    public DBZ100001AtenaSealParameterEntity getChohyoParameterEntity(RString 市町村コード, RString 市町村名,
            RString システム日付) {
        DBZ100001AtenaSealParameterEntity parameterEntity = new DBZ100001AtenaSealParameterEntity();
        parameterEntity.set市町村コード(市町村コード);
        parameterEntity.set市町村名称(市町村名);
        parameterEntity.set作成日(システム日付);
        parameterEntity.setタイトル(宛名シールのタイトル);
        return parameterEntity;
    }

    /**
     * DBZ100001AtenaSealEntityを作成する。
     *
     * @param parameter DBB021051ProcessParameter
     * @param entity DBB021051TableJohoTempEntity
     * @return DBZ100001AtenaSealEntity
     */
    public DBZ100001AtenaSealEntity getDBZ100001AtenaSealEntity(
            DBB021051ProcessParameter parameter, DBB021051TableJohoTempEntity entity) {
        最優先住所がニ = TWO.equals(parameter.get最優先住所());
        DBZ100001AtenaSealEntity atena = new DBZ100001AtenaSealEntity();
        atena.set識別コード(entity.get識別コード());
        atena.set郵便番号(nonullRStr(entity.get郵便番号()));
        atena.set行政区(entity.get行政区());
//        TODO QA Redmine#100667
        atena.set住所TXT(entity.get住所());
        if (judge宛先住所設定(parameter, str方書)) {
            atena.set方書1(nonullRStr(entity.get宛名方書()));
            if (最優先住所がニ) {
                atena.set方書2(nonullRStr(entity.get方書()));
            }
        }
        atena.set代納区分名称(entity.get代納区分名称());
        atena.set氏名1(nonullRStr(entity.get宛名氏名()));
        if (最優先住所がニ) {
            atena.set氏名2(nonullRStr(entity.get氏名()));
        }
        atena.set左括号1(左括号);
        atena.set左括号2(左括号);
        atena.set名称付与1(parameter.get敬称());
        atena.set名称付与2(parameter.get敬称());
        atena.set様分1(parameter.get敬称());
        atena.set様分2(parameter.get敬称());
        atena.set様分氏名1(parameter.get敬称());
        atena.set様分氏名2(parameter.get敬称());
        atena.set右括号1(右括号);
        atena.set右括号2(右括号);
        atena.setバーコード住所(entity.getバーコード住所());
        return atena;
    }

    /**
     * get市町村コードのメソッドです。
     *
     * @param 市町村指定 RString
     * @return RString
     */
    public RString get市町村指定に市町村コード(RString 市町村指定) {
        if (RString.isNullOrEmpty(市町村指定) || RString.isNullOrEmpty(市町村指定.trim())) {
            return RString.EMPTY;
        }
        return 市町村指定.substring(0, 市町村コード長さ);
    }

    /**
     * get市町村指定に市町村名称のメソッドです。
     *
     * @param 市町村指定 RString
     * @return RString
     */
    public RString get市町村指定に市町村名称(RString 市町村指定) {
        if (RString.isNullOrEmpty(市町村指定)) {
            return RString.EMPTY;
        }
        return 市町村指定.substring(市町村コード長さ).trim();
    }

    /**
     * intProcessParameterのメソッドです。
     *
     * @param koikiZenShichosonJoho KoikiZenShichosonJoho
     * @param parameter DBB021051ProcessParameter
     */
    public void intProcessParameter(KoikiZenShichosonJoho koikiZenShichosonJoho, DBB021051ProcessParameter parameter) {
        if (parameter == null) {
            return;
        }
        parameter.set市町村指定に市町村コード(get市町村指定に市町村コード(parameter.get市町村指定()));
        parameter.set市町村指定に市町村名称(get市町村指定に市町村名称(parameter.get市町村指定()));
        if (koikiZenShichosonJoho == null) {
            return;
        }
        parameter.set市町村名称(koikiZenShichosonJoho.get市町村名称());
        parameter.set都道府県名称(koikiZenShichosonJoho.get都道府県名称());
        parameter.set郡名称(koikiZenShichosonJoho.get郡名称());
    }

    /**
     * ReportOutputJokenhyoItemを取得します。
     *
     * @param 導入団体コード RString
     * @param 市町村名 RString
     * @param ジョブ番号 RString
     * @param 出力ページ数 int
     * @param 出力順設定リスト List<RString>
     * @param parameter DBB021051ProcessParameter
     * @return ReportOutputJokenhyoItem
     */
    public ReportOutputJokenhyoItem getReportOutputJokenhyoItem(RString 導入団体コード,
            RString 市町村名, RString ジョブ番号, int 出力ページ数, List<RString> 出力順設定リスト,
            DBB021051ProcessParameter parameter) {
        return getReportOutputJokenhyoItem(
                導入団体コード, 市町村名, ジョブ番号, 出力ページ数, getOutputJoukenList(parameter, 出力順設定リスト));
    }

    /**
     * ShoriKekkaKakuninListCSVEntityを取得します。
     *
     * @param entity DBB021051ShoriKekkaListTempEntity
     * @param firstFlag boolean
     * @return ShoriKekkaKakuninListCSVEntity
     */
    public DBB021051ShoriKekkaKakuninListCSVEntity toShoriKekkaKakuninListCSVEntity(
            DBB021051ShoriKekkaListTempEntity entity, boolean firstFlag) {
        DBB021051ShoriKekkaKakuninListCSVEntity result = new DBB021051ShoriKekkaKakuninListCSVEntity();
        if (firstFlag) {
            result.set作成日時(DateConverter.getDate12Time142(RDate.getNowDateTime()));
        }
        result.set処理名(entity.getエラー区分());
        result.set証記載保険者番号(entity.get証記載保険者番号());
        result.set被保険者番号(entity.get被保険者番号());
        result.set被保険者カナ氏名(entity.get被保険者カナ氏名());
        result.set被保険者氏名(entity.get被保険者氏名());
        result.setエラー内容(取込対象データなし);
        result.set備考(entity.get備考());
        return result;
    }

    /**
     * eqNonullRStrのメソッドです。
     *
     * @param r1 RString
     * @param r2 RString
     * @return boolean
     */
    public boolean eqNonullRStr(RString r1, RString r2) {
        return nonullRStr(r1).equals(nonullRStr(r2));
    }

    private ReportOutputJokenhyoItem getReportOutputJokenhyoItem(RString 導入団体コード,
            RString 市町村名, RString ジョブ番号, int 出力ページ数,
            List<RString> outputJoukenList) {
        return new ReportOutputJokenhyoItem(
                ReportIdDBB.DBZ100001.getReportId().value(),
                導入団体コード, 市町村名, ジョブ番号, ReportIdDBB.DBZ100001.getReportName(), new RString(出力ページ数),
                RString.EMPTY, RString.EMPTY, outputJoukenList);
    }

    private List<RString> getOutputJoukenList(DBB021051ProcessParameter parameter, List<RString> 出力順設定リスト) {
        List<RString> jokenList = new ArrayList();
        set抽出対象者リスト(jokenList, parameter);
        set基準年月(jokenList, parameter);
        set資格区分(jokenList, parameter);
        set市町村指定(jokenList, parameter);
        set最優先住所(jokenList, parameter);
        set敬称(jokenList, parameter);
        set被保番号表示(jokenList, parameter);
        set宛先住所設定(jokenList, parameter);
        set出力順(jokenList, 出力順設定リスト);
        return jokenList;
    }

    private void set抽出対象者リスト(List<RString> jokenList, DBB021051ProcessParameter parameter) {
        RString 抽出対象者 = parameter.get抽出対象者();
        tmp = 生活保護受給者情報;
        if (ONE.equals(抽出対象者)) {
            tmp = tmp.concat(普通徴収);
            jokenList.add(tmp);
        }
        if (TWO.equals(抽出対象者)) {
            tmp = tmp.concat(特別徴収);
            jokenList.add(tmp);
        }
        if (THREE.equals(抽出対象者)) {
            tmp = tmp.concat(普通徴収);
            jokenList.add(tmp);
            tmp = 生活保護受給者情報2.concat(特別徴収);
            jokenList.add(tmp);
        }
    }

    private void set基準年月(List<RString> jokenList, DBB021051ProcessParameter parameter) {
        RString dateStr = DateConverter.getDate53(parameter.get基準年月());
        if (RString.isNullOrEmpty(dateStr)) {
            return;
        }
        tmp = 基準年月.concat(dateStr);
        jokenList.add(tmp);
    }

    private void set資格区分(List<RString> jokenList, DBB021051ProcessParameter parameter) {
        tmp = 資格区分;
        RString 資格区分名 = RString.EMPTY;
        if (ONE.equals(parameter.get資格区分())) {
            資格区分名 = 日本人1号;
        }
        if (TWO.equals(parameter.get資格区分())) {
            資格区分名 = 日本人2号;
        }
        if (THREE.equals(parameter.get資格区分())) {
            資格区分名 = 外国人1号;
        }
        if (FOUR.equals(parameter.get資格区分())) {
            資格区分名 = 外国人2号;
        }
        if (FIVE.equals(parameter.get資格区分())) {
            資格区分名 = 全て1号;
        }
        if (SIX.equals(parameter.get資格区分())) {
            資格区分名 = 全て2号;
        }
        if (SEVEN.equals(parameter.get資格区分())) {
            資格区分名 = 全て;
        }
        tmp = tmp.concat(資格区分名);
        jokenList.add(tmp);
    }

    private void set市町村指定(List<RString> jokenList, DBB021051ProcessParameter parameter) {
        RString str市町村指定 = parameter.get市町村指定();
        if (RString.isNullOrEmpty(str市町村指定)) {
            return;
        }
        jokenList.add(市町村指定.concat(str市町村指定));
    }

    private void set最優先住所(List<RString> jokenList, DBB021051ProcessParameter parameter) {
        if (ONE.equals(parameter.get最優先住所())) {
            jokenList.add(最優先住所.concat(現住所));
        }
        if (TWO.equals(parameter.get最優先住所())) {
            jokenList.add(最優先住所.concat(送付先または代納人));
        }
    }

    private void set敬称(List<RString> jokenList, DBB021051ProcessParameter parameter) {
        RString str敬称 = parameter.get敬称();
        if (RString.isNullOrEmpty(str敬称)) {
            return;
        }
        jokenList.add(敬称.concat(str敬称));
    }

    private void set被保番号表示(List<RString> jokenList, DBB021051ProcessParameter parameter) {
        if (ONE.equals(parameter.get被保番号表示())) {
            tmp = 表示する;
        } else {
            tmp = 表示しない;
        }
        jokenList.add(被保番号表示.concat(tmp));
    }

    private void set宛先住所設定(List<RString> jokenList, DBB021051ProcessParameter parameter) {
        RString str宛先住所設定 = parameter.get宛先住所設定();
        if (RString.isNullOrEmpty(str宛先住所設定)) {
            return;
        }
        jokenList.add(宛先住所設定.concat(str宛先住所設定));
    }

    private void set出力順(List<RString> jokenList, List<RString> 出力順設定リスト) {
        boolean firstFlag = true;
        if (出力順設定リスト == null || 出力順設定リスト.isEmpty()) {
            return;
        }
        for (RString 出力順項目 : 出力順設定リスト) {
            if (firstFlag) {
                jokenList.add(出力順.concat(出力順項目));
            } else {
                jokenList.add(出力順2.concat(出力順項目));
            }
            firstFlag = false;
        }
    }

    private boolean judge宛先住所設定(DBB021051ProcessParameter parameter, RString 判定対象) {
        RString 宛先住所設定 = parameter.get宛先住所設定();
        if (RString.isNullOrEmpty(宛先住所設定)) {
            return false;
        }
        return 宛先住所設定.contains(判定対象);
    }

    private void set宛名情報(UaFt200FindShikibetsuTaishoEntity 宛名PSM, DBB021051TableJohoTempEntity result) {
        if (宛名PSM == null) {
            return;
        }
        result.set識別コード(宛名PSM.getShikibetsuCode());
        result.set氏名カナ(宛名PSM.getKanaMeisho());
        result.set世帯主名称(宛名PSM.getSetainushiMei());
        result.set住所コード(宛名PSM.getZenkokuJushoCode());
        result.set性別(宛名PSM.getSeibetsuCode());
        result.set住民種別コード(宛名PSM.getJuminShubetsuCode());
        result.set住民状態コード(宛名PSM.getJuminJotaiCode());
        result.set現全国地方公共団体コード(nonullRStr(宛名PSM.getGenLasdecCode()));
        result.set生年月日(宛名PSM.getSeinengappiYMD());
        result.set宛名氏名(宛名PSM.getMeisho());
        result.set宛名方書(宛名PSM.getKatagaki());
    }

    private void set最優先住所がニ以外宛名情報(UaFt200FindShikibetsuTaishoEntity 宛名PSM,
            DBB021051TableJohoTempEntity result, DBB021051ProcessParameter parameter) {
        if (宛名PSM != null) {
            result.set氏名(宛名PSM.getMeisho());
            wk管内管外区分 = 宛名PSM.getKannaiKangaiKubun();
            result.setWk管内管外区分(wk管内管外区分);
            result.set郵便番号(宛名PSM.getYubinNo());
            住所 = 宛名PSM.getJusho();
            番地 = 宛名PSM.getBanchi();
            方書 = 宛名PSM.getKatagaki();
            //        TODO QA Redmine#100667
            result.set住所(getWK管内管外区分が1の住所(parameter, wk管内管外区分, 住所));
            result.set番地(番地);
            result.set方書(方書);
            result.set行政区(宛名PSM.getGyoseikuName());
            result.set管内管外区分(宛名PSM.getKannaiKangaiKubun());
            result.set番地コード(get番地コード(宛名PSM));
            result.set行政区コード(宛名PSM.getGyoseikuCode());
            result.set地区コード1(宛名PSM.getChikuCode1());
            result.set地区コード2(宛名PSM.getChikuCode2());
            result.set地区コード3(宛名PSM.getChikuCode3());
            result.set世帯コード(宛名PSM.getSetaiCode());
        }
    }

    private void set最優先住所がニの宛先情報(UaFt250FindAtesakiEntity 宛先PSM, DBB021051TableJohoTempEntity result,
            DBB021051ProcessParameter parameter) {
        if (宛先PSM != null) {
            result.set氏名(宛先PSM.getKanjiShimei());
            wk管内管外区分 = 宛先PSM.getKannaiKangaiKubun();
            result.setWk管内管外区分(wk管内管外区分);
            result.set郵便番号(宛先PSM.getYubinNo());
            住所 = 宛先PSM.getJusho();
            番地 = 宛先PSM.getBanchi();
            方書 = 宛先PSM.getKatagaki();
            //        TODO QA Redmine#100667
            result.set住所(getWK管内管外区分が1の住所(parameter, wk管内管外区分, 住所));
            result.set番地(番地);
            result.set方書(方書);
            result.set行政区(宛先PSM.getGyoseiku());
            result.set管内管外区分(宛先PSM.getKannaiKangaiKubun());
            result.set番地コード(get番地コード(宛先PSM));
            result.set行政区コード(宛先PSM.getGyoseikuCode());
            result.set地区コード1(宛先PSM.getChikuCode1());
            result.set地区コード2(宛先PSM.getChikuCode2());
            result.set地区コード3(宛先PSM.getChikuCode3());
            result.set世帯コード(宛先PSM.getDainoninSetaiCode());
        }
    }

    private RString getWK管内管外区分が1の住所(DBB021051ProcessParameter parameter, RString wk管内管外区分, AtenaJusho 住所) {
        RString str住所 = nonullRStr(住所);
        if (ONE.equals(wk管内管外区分)) {
            str住所 = get市町村都道府県郡判定ある(parameter).concat(str住所);
        }
        return str住所;
    }

    private UaFt200FindShikibetsuTaishoEntity get宛名PSM(AtenaSealJohoEntity entity) {
        List<UaFt200FindShikibetsuTaishoEntity> 宛名識別対象List = entity.get宛名識別対象PSM();
        if (宛名識別対象List == null || 宛名識別対象List.isEmpty()) {
            return null;
        }
        return 宛名識別対象List.get(0);
    }

    private UaFt250FindAtesakiEntity get宛先PSM(AtenaSealJohoEntity entity) {
        List<UaFt250FindAtesakiEntity> 宛先List = entity.get宛先PSM();
        if (宛先List == null || 宛先List.isEmpty()) {
            return null;
        }
        return 宛先List.get(0);
    }

    private RString get市町村都道府県郡(DBB021051ProcessParameter parameter) {
        RString 市町村都道府県郡 = nonullRStr(parameter.get市町村名称());
        市町村都道府県郡 = 市町村都道府県郡.concat(nonullRStr(parameter.get都道府県名称()));
        市町村都道府県郡 = 市町村都道府県郡.concat(nonullRStr(parameter.get郡名称()));
        return 市町村都道府県郡;
    }

    private RString get市町村都道府県郡判定ある(DBB021051ProcessParameter parameter) {
        RString 市町村都道府県郡 = RString.EMPTY;
        if (judge宛先住所設定(parameter, str市町村)) {
            市町村都道府県郡 = 市町村都道府県郡.concat(nonullRStr(parameter.get市町村名称()));
        }
        if (judge宛先住所設定(parameter, str都道府県)) {
            市町村都道府県郡 = 市町村都道府県郡.concat(nonullRStr(parameter.get都道府県名称()));
        }
        if (judge宛先住所設定(parameter, str郡)) {
            市町村都道府県郡 = 市町村都道府県郡.concat(nonullRStr(parameter.get郡名称()));
        }
        return 市町村都道府県郡;
    }

    private RString getバーコード住所(DBB021051ProcessParameter parameter, AtenaJusho 住所, AtenaBanchi 番地, Katagaki 方書) {
        RString バーコード住所 = get市町村都道府県郡(parameter);
        バーコード住所 = バーコード住所.concat(nonullRStr(住所));
        バーコード住所 = バーコード住所.concat(nonullRStr(番地));
        バーコード住所 = バーコード住所.concat(nonullRStr(方書));
        return バーコード住所;
    }

    private RString getバーコード住所(AtenaJusho 住所, AtenaBanchi 番地, Katagaki 方書) {
        RString バーコード住所 = nonullRStr(住所);
        バーコード住所 = バーコード住所.concat(nonullRStr(番地));
        バーコード住所 = バーコード住所.concat(nonullRStr(方書));
        return バーコード住所;
    }

    private RString get番地コード(UaFt200FindShikibetsuTaishoEntity 宛名PSM) {
        RString 番地コード = nonullRStr(宛名PSM.getBanchiCode1());
        番地コード = 番地コード.concat(nonullRStr(宛名PSM.getBanchiCode2()));
        番地コード = 番地コード.concat(nonullRStr(宛名PSM.getBanchiCode3()));
        return 番地コード;
    }

    private RString get番地コード(UaFt250FindAtesakiEntity 宛先PSM) {
        RString 番地コード = nonullRStr(宛先PSM.getBanchiCode1());
        番地コード = 番地コード.concat(nonullRStr(宛先PSM.getBanchiCode2()));
        番地コード = 番地コード.concat(nonullRStr(宛先PSM.getBanchiCode3()));
        return 番地コード;
    }

    private RString nonullRStr(RString rstring) {
        if (rstring == null) {
            return RString.EMPTY;
        }
        return rstring;
    }

    private RString nonullRStr(AtenaMeisho atenaMeisho) {
        if (atenaMeisho == null) {
            return RString.EMPTY;
        }
        return atenaMeisho.value();
    }

    private RString nonullRStr(AtenaJusho atenaJusho) {
        if (atenaJusho == null) {
            return RString.EMPTY;
        }
        return atenaJusho.value();
    }

    private RString nonullRStr(AtenaBanchi atenaBanchi) {
        if (atenaBanchi == null) {
            return RString.EMPTY;
        }
        return atenaBanchi.value();
    }

    private RString nonullRStr(Katagaki katagaki) {
        if (katagaki == null) {
            return RString.EMPTY;
        }
        return katagaki.value();
    }

    private RString nonullRStr(BanchiCode banchiCode) {
        if (banchiCode == null) {
            return RString.EMPTY;
        }
        return banchiCode.value();
    }

    private RString nonullRStr(LasdecCode lasdecCode) {
        if (lasdecCode == null) {
            return RString.EMPTY;
        }
        return lasdecCode.value();
    }

    private RString nonullRStr(YubinNo yubinNo) {
        if (yubinNo == null) {
            return RString.EMPTY;
        }
        return yubinNo.value();
    }
}
