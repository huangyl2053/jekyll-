/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaT0714SeikyuHohoEntity;
import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaT0752NokumiEntity;
import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.CharacteristicsPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.TmpHonsanteiTsuchishoTableEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0301YokinShubetsuPatternEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0302KinyuKikanEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0303KinyuKikanShitenEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaT0310KozaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.URZCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 本算定通知書一括発行（バッチ）クラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class HonsanteiTsuchishoIkkatsuHakkoSyori {

    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final RString 定値区分_0 = new RString("0");
    private static final RString タイトル_作成年月日 = new RString("作成年月日");
    private static final RString タイトル_作成日時 = new RString("作成日時");
    private static final RString タイトル_作成時刻 = new RString("作成時刻");
    private static final RString タイトル_賦課年度 = new RString("賦課年度");
    private static final RString タイトル_郵便番号 = new RString("郵便番号");
    private static final RString タイトル_住所 = new RString("住所");
    private static final RString タイトル_町域_管内_管外住所 = new RString("町域（管内）・管外住所");
    private static final RString タイトル_番地 = new RString("番地");
    private static final RString タイトル_行政区コード = new RString("行政区コード");
    private static final RString タイトル_行政区 = new RString("行政区");
    private static final RString タイトル_保険料額 = new RString("保険料額");
    private static final RString タイトル_当期 = new RString("当期");
    private static final RString タイトル_納付人_送付先 = new RString("納付人/送付先");
    private static final RString タイトル_所得段階 = new RString("所得段階");
    private static final RString タイトル_今後納付すべき額 = new RString("今後納付すべき額");
    private static final RString タイトル_次期以降 = new RString("次期以降");
    private static final RString タイトル_生年月日 = new RString("生年月日");
    private static final RString タイトル_性別 = new RString("性別");
    private static final RString タイトル_世帯主名 = new RString("世帯主名");
    private static final RString タイトル_通知書番号 = new RString("通知書番号");
    private static final RString タイトル_世帯コード = new RString("世帯コード");
    private static final RString タイトル_被保険者氏名 = new RString("被保険者氏名");
    private static final RString タイトル_被保険者番号 = new RString("被保険者番号");
    private static final RString タイトル_特別徴収業務者コード = new RString("特別徴収業務者コード");
    private static final RString タイトル_特別徴収業務者 = new RString("特別徴収業務者");
    private static final RString タイトル_特別徴収対象年金コード = new RString("特別徴収対象年金コード");
    private static final RString タイトル_特別徴収対象年金 = new RString("特別徴収対象年金");
    private static final RString タイトル_本徴収額_10月 = new RString("本徴収額（10月）");
    private static final RString タイトル_本徴収額_12月 = new RString("本徴収額（12月）");
    private static final RString タイトル_本徴収額_2月 = new RString("本徴収額（2月）");
    private static final RString タイトル_表示コード名１ = new RString("表示コード名１");
    private static final RString タイトル_表示コード名２ = new RString("表示コード名２");
    private static final RString タイトル_表示コード名３ = new RString("表示コード名３");
    private static final RString タイトル_表示コード１ = new RString("表示コード１");
    private static final RString タイトル_表示コード２ = new RString("表示コード２");
    private static final RString タイトル_表示コード３ = new RString("表示コード３");
    private static final RString タイトル_所得段階_更正前 = new RString("所得段階（更正前）");
    private static final RString タイトル_保険料額_更正前 = new RString("保険料額（更正前）");
    private static final RString タイトル_徴収方法_更正前 = new RString("徴収方法（更正前）");
    private static final RString タイトル_生保開始日 = new RString("生保開始日");
    private static final RString タイトル_生保種別 = new RString("生保種別");
    private static final RString タイトル_氏名 = new RString("氏名");
    private static final RString タイトル_所得段階_更正後 = new RString("所得段階（更正後）");
    private static final RString タイトル_保険料額_更正後 = new RString("保険料額（更正後）");
    private static final RString タイトル_徴収方法_更正後 = new RString("徴収方法（更正後）");
    private static final RString タイトル_口座情報 = new RString("口座情報");
    private static final RString 区分_管内 = new RString("1");
    private static final RString 区分_管外 = new RString("2");
    private static final RString ゆうちょ銀行 = new RString("9900");
    private static final RString 定値_半角ハイフン = new RString("-");
    private static final RString 定値_ほし = new RString("＊");

    /**
     * コンストラクタです。
     */
    public HonsanteiTsuchishoIkkatsuHakkoSyori() {

    }

    /**
     * 通知書発行後異動者登録するメソッドです。
     *
     * @param 帳票作成日時 YMDHMS
     * @param 帳票ID ReportId
     * @param 計算後情報_更正後 DbT2015KeisangoJohoEntity
     * @param 連番 int
     * @return DbT2017TsuchishoHakkogoIdoshaEntity 通知書発行後異動者
     */
    public DbT2017TsuchishoHakkogoIdoshaEntity insert通知書発行後異動者(YMDHMS 帳票作成日時, ReportId 帳票ID,
            DbT2015KeisangoJohoEntity 計算後情報_更正後, int 連番) {

        DbT2017TsuchishoHakkogoIdoshaEntity dbt2017entity = new DbT2017TsuchishoHakkogoIdoshaEntity();
        dbt2017entity.setReportID(帳票ID);
        dbt2017entity.setChohyosakuseiTimestamp(帳票作成日時);
        dbt2017entity.setTsuchishoNo(計算後情報_更正後.getTsuchishoNo());
        dbt2017entity.setFukaNendo(計算後情報_更正後.getFukaNendo());
        dbt2017entity.setShikibetsuCode(計算後情報_更正後.getShikibetsuCode());
        dbt2017entity.setHihokenshaNo(計算後情報_更正後.getHihokenshaNo());
        dbt2017entity.setKeisanTimestamp(get調定日時(計算後情報_更正後.getChoteiNichiji()));
        dbt2017entity.setGaitoRemban(連番);
        dbt2017entity.setIdoAriFlag(false);
        dbt2017entity.setState(EntityDataState.Added);
        return dbt2017entity;
    }

    private YMDHMS get調定日時(YMDHMS 調定日時) {
        if (調定日時 == null) {
            return null;
        }
        return 調定日時;
    }

    /**
     * 特別徴収開始通知書発行一覧表タイトルList取得するメソッドです。
     *
     * @return List<RString> 特別徴収開始通知書発行一覧表タイトルList
     */
    public List<RString> get特別徴収開始通知書発行一覧表タイトルList() {
        List<RString> headerList = new ArrayList<>();
        headerList.add(タイトル_作成年月日);
        headerList.add(タイトル_作成時刻);
        headerList.add(タイトル_賦課年度);
        headerList.add(タイトル_郵便番号);
        headerList.add(タイトル_住所);
        headerList.add(タイトル_町域_管内_管外住所);
        headerList.add(タイトル_番地);
        headerList.add(タイトル_行政区コード);
        headerList.add(タイトル_行政区);
        headerList.add(タイトル_生年月日);
        headerList.add(タイトル_性別);
        headerList.add(タイトル_世帯主名);
        headerList.add(タイトル_通知書番号);
        headerList.add(タイトル_世帯コード);
        headerList.add(タイトル_被保険者氏名);
        headerList.add(タイトル_特別徴収業務者コード);
        headerList.add(タイトル_特別徴収業務者);
        headerList.add(タイトル_特別徴収対象年金コード);
        headerList.add(タイトル_特別徴収対象年金);
        headerList.add(タイトル_本徴収額_10月);
        headerList.add(タイトル_本徴収額_12月);
        headerList.add(タイトル_本徴収額_2月);
        return headerList;
    }

    /**
     * 特別徴収開始通知書発行一覧表bodyList取得するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 帳票作成日時 RDateTime
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @return List<RString> 特別徴収開始通知書発行一覧表bodyList
     */
    public List<RString> get特別徴収開始通知書発行一覧表bodyList(FlexibleYear 調定年度, RDateTime 帳票作成日時,
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {
        List<RString> bodyList = new ArrayList<>();
        bodyList.add(帳票作成日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
        bodyList.add(帳票作成日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        bodyList.add(調定年度.toDateString());
        if (isNull(編集後本算定通知書共通情報.get編集後宛先())) {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get郵便番号());
            bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get編集後住所());
            bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get町域());
            bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get番地());
            bodyList.add(isNull(編集後本算定通知書共通情報.get編集後宛先().get行政区コード())
                    ? RString.EMPTY : 編集後本算定通知書共通情報.get編集後宛先().get行政区コード().getColumnValue());
            bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get行政区名());
        }
        if (isNull(編集後本算定通知書共通情報.get編集後個人())) {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(編集後本算定通知書共通情報.get編集後個人().get生年月日Csv());
            bodyList.add(編集後本算定通知書共通情報.get編集後個人().get性別());
            bodyList.add(isNull(編集後本算定通知書共通情報.get編集後個人().get世帯主名())
                    ? RString.EMPTY : 編集後本算定通知書共通情報.get編集後個人().get世帯主名().getColumnValue());

        }
        bodyList.add(isNull(編集後本算定通知書共通情報.get通知書番号())
                ? RString.EMPTY : 編集後本算定通知書共通情報.get通知書番号().getColumnValue());
        if (isNull(編集後本算定通知書共通情報.get編集後個人())) {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(isNull(編集後本算定通知書共通情報.get編集後個人().get世帯コード())
                    ? RString.EMPTY : 編集後本算定通知書共通情報.get編集後個人().get世帯コード().getColumnValue());
            bodyList.add(isNull(編集後本算定通知書共通情報.get編集後個人().get名称())
                    ? RString.EMPTY : 編集後本算定通知書共通情報.get編集後個人().get名称().getName().getColumnValue());
        }
        if (isNull(編集後本算定通知書共通情報.get更正後())) {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(編集後本算定通知書共通情報.get更正後().get特別徴収義務者コード());
            bodyList.add(編集後本算定通知書共通情報.get更正後().get特別徴収義務者());
            bodyList.add(編集後本算定通知書共通情報.get更正後().get特別徴収対象年金コード());
            bodyList.add(編集後本算定通知書共通情報.get更正後().get特別徴収対象年金());
        }
        set本徴収額(編集後本算定通知書共通情報, bodyList);
        toBodyList(bodyList);
        return bodyList;
    }

    private void set本徴収額(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報, List<RString> bodyList) {

        if (編集後本算定通知書共通情報.get更正後() != null && 編集後本算定通知書共通情報.
                get更正後().get特徴期別金額リスト() != null && !編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト().isEmpty()) {
            RString 本徴収額_10月 = RString.EMPTY;
            RString 本徴収額_12月 = RString.EMPTY;
            RString 本徴収額_2月 = RString.EMPTY;
            List<CharacteristicsPhase> 特徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト();
            if (特徴期別金額リスト == null || 特徴期別金額リスト.isEmpty()) {
                return;
            }
            for (CharacteristicsPhase entity : 特徴期別金額リスト) {
                if (entity == null) {
                    continue;
                }
                if (!RString.isNullOrEmpty(entity.get期()) && Integer.valueOf(entity.get期().toString()) == INT_4) {
                    本徴収額_10月 = isNull(entity.get金額()) ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(entity.get金額(), 0);
                } else if (!RString.isNullOrEmpty(entity.get期()) && Integer.valueOf(entity.get期().toString()) == INT_5) {
                    本徴収額_12月 = isNull(entity.get金額()) ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(entity.get金額(), 0);
                } else if (!RString.isNullOrEmpty(entity.get期()) && Integer.valueOf(entity.get期().toString()) == INT_6) {
                    本徴収額_2月 = isNull(entity.get金額()) ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(entity.get金額(), 0);
                }
            }
            bodyList.add(本徴収額_10月);
            bodyList.add(本徴収額_12月);
            bodyList.add(本徴収額_2月);
        }
    }

    /**
     * 保険料額決定通知書発行一覧表タイトルList取得するメソッドです。
     *
     * @return List<RString> 保険料額決定通知書発行一覧表タイトルList
     */
    public List<RString> get保険料額決定通知書発行一覧表タイトルList() {
        List<RString> headerList = new ArrayList<>();
        headerList.add(タイトル_作成日時);
        headerList.add(タイトル_作成時刻);
        headerList.add(タイトル_通知書番号);
        headerList.add(タイトル_被保険者番号);
        headerList.add(タイトル_世帯コード);
        headerList.add(タイトル_表示コード名１);
        headerList.add(タイトル_表示コード名２);
        headerList.add(タイトル_表示コード名３);
        headerList.add(タイトル_表示コード１);
        headerList.add(タイトル_表示コード２);
        headerList.add(タイトル_表示コード３);
        headerList.add(タイトル_所得段階_更正前);
        headerList.add(タイトル_保険料額_更正前);
        headerList.add(タイトル_徴収方法_更正前);
        headerList.add(タイトル_生保開始日);
        headerList.add(タイトル_生保種別);
        headerList.add(タイトル_氏名);
        headerList.add(タイトル_郵便番号);
        headerList.add(タイトル_住所);
        headerList.add(タイトル_町域_管内_管外住所);
        headerList.add(タイトル_番地);
        headerList.add(タイトル_所得段階_更正後);
        headerList.add(タイトル_保険料額_更正後);
        headerList.add(タイトル_徴収方法_更正後);
        headerList.add(タイトル_口座情報);
        return headerList;
    }

    /**
     * 保険料額決定通知書発行一覧表bodyList取得するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 帳票作成日時 RDateTime
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @return List<RString> 保険料額決定通知書発行一覧表bodyList
     */
    public List<RString> get保険料額決定通知書発行一覧表bodyList(FlexibleYear 調定年度, RDateTime 帳票作成日時,
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {
        List<RString> bodyList = new ArrayList<>();
        bodyList.add(帳票作成日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
        bodyList.add(帳票作成日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        bodyList.add(isNull(編集後本算定通知書共通情報.get通知書番号())
                ? RString.EMPTY : 編集後本算定通知書共通情報.get通知書番号().getColumnValue());
        bodyList.add(isNull(編集後本算定通知書共通情報.get被保険者番号())
                ? RString.EMPTY : 編集後本算定通知書共通情報.get被保険者番号().getColumnValue());
        if (isNull(編集後本算定通知書共通情報.get編集後個人())) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(isNull(編集後本算定通知書共通情報.get編集後個人().get世帯コード())
                    ? RString.EMPTY : 編集後本算定通知書共通情報.get編集後個人().get世帯コード().getColumnValue());
        }
        if (isNull(編集後本算定通知書共通情報.get表示コード())) {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(編集後本算定通知書共通情報.get表示コード().get表示コード名１());
            bodyList.add(編集後本算定通知書共通情報.get表示コード().get表示コード名２());
            bodyList.add(編集後本算定通知書共通情報.get表示コード().get表示コード名３());
            bodyList.add(編集後本算定通知書共通情報.get表示コード().get表示コード１());
            bodyList.add(編集後本算定通知書共通情報.get表示コード().get表示コード２());
            bodyList.add(編集後本算定通知書共通情報.get表示コード().get表示コード３());
        }
        if (isNull(編集後本算定通知書共通情報.get更正前())) {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(編集後本算定通知書共通情報.get更正前().get保険料段階());
            bodyList.add(isNull(編集後本算定通知書共通情報.get更正前().get確定保険料_年額())
                    ? RString.EMPTY : new RString(編集後本算定通知書共通情報.get更正前().get確定保険料_年額().toString()));
            bodyList.add(編集後本算定通知書共通情報.get更正前().get徴収方法());
        }
        if (isNull(編集後本算定通知書共通情報.get更正後())) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(編集後本算定通知書共通情報.get更正後().get生保開始日_西暦());
        }
        if (isNull(編集後本算定通知書共通情報.get更正後())
                || RString.isNullOrEmpty(編集後本算定通知書共通情報.get更正後().get生活保護扶助種類())) {
            bodyList.add(RString.EMPTY);
        } else {
            RString 生活保護扶助名称 = CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系,
                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                    new Code(編集後本算定通知書共通情報.get更正後().get生活保護扶助種類()));
            bodyList.add(生活保護扶助名称);
        }
        if (isNull(編集後本算定通知書共通情報.get編集後宛先())) {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(isNull(編集後本算定通知書共通情報.get編集後宛先().get本人名称())
                    ? RString.EMPTY : 編集後本算定通知書共通情報.get編集後宛先().get本人名称().getName().getColumnValue());
            bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get郵便番号());
            bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get編集後住所());
            if (区分_管内.equals(編集後本算定通知書共通情報.get編集後宛先().get管内管外区分())) {
                bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get町域());
            } else if (区分_管外.equals(編集後本算定通知書共通情報.get編集後宛先().get管内管外区分())) {
                bodyList.add(isNull(編集後本算定通知書共通情報.get編集後個人())
                        ? RString.EMPTY : 編集後本算定通知書共通情報.get編集後個人().get編集後住所());
            }

            bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get番地());
        }
        if (isNull(編集後本算定通知書共通情報.get更正後())) {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(編集後本算定通知書共通情報.get更正後().get保険料段階());
            bodyList.add(isNull(編集後本算定通知書共通情報.get更正後().get確定保険料_年額())
                    ? RString.EMPTY : new RString(編集後本算定通知書共通情報.get更正後().get確定保険料_年額().toString()));
            bodyList.add(編集後本算定通知書共通情報.get更正後().get徴収方法());
        }
        bodyList.add(get口座情報(編集後本算定通知書共通情報));
        toBodyList(bodyList);
        return bodyList;
    }

    private RString get口座情報(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {

        if (編集後本算定通知書共通情報.get編集後口座() == null) {
            return RString.EMPTY;
        }
        RString 金融機関コード = 編集後本算定通知書共通情報.get編集後口座().get金融機関コード();
        RString 通帳記号 = 編集後本算定通知書共通情報.get編集後口座().getEdited通帳記号();
        RString 通帳番号 = 編集後本算定通知書共通情報.get編集後口座().getEdited通帳番号();
        RString 口座名義人漢字 = 編集後本算定通知書共通情報.get編集後口座().get口座名義人漢字();
        RString 支店コード = 編集後本算定通知書共通情報.get編集後口座().get支店コード();
        RString 口座番号 = 編集後本算定通知書共通情報.get編集後口座().get口座番号();
        RString 口座種別 = 編集後本算定通知書共通情報.get編集後口座().get預金種別略称();
        if (ゆうちょ銀行.equals(金融機関コード.substringReturnAsPossible(INT_0, INT_4))) {
            return 金融機関コード.substringReturnAsPossible(INT_0, INT_4).concat(RString.HALF_SPACE)
                    .concat(通帳記号.substringReturnAsPossible(INT_0, INT_5))
                    .concat(定値_半角ハイフン)
                    .concat(通帳番号.substringReturnAsPossible(INT_0, INT_8))
                    .concat(RString.HALF_SPACE)
                    .concat(口座名義人漢字);
        } else {
            return 金融機関コード.substringReturnAsPossible(INT_0, INT_4).concat(定値_半角ハイフン)
                    .concat(支店コード.substringReturnAsPossible(INT_0, INT_3)).concat(RString.HALF_SPACE)
                    .concat(口座種別.substringReturnAsPossible(INT_0, INT_2)).concat(定値_半角ハイフン)
                    .concat(口座番号.substringReturnAsPossible(INT_0, INT_7)).concat(RString.HALF_SPACE)
                    .concat(口座名義人漢字);
        }
    }

    /**
     * 納入通知書発行一覧表タイトルList取得するメソッドです。
     *
     * @return List<RString> 納入通知書発行一覧表タイトルList
     */
    public List<RString> get納入通知書発行一覧表タイトルList() {
        List<RString> headerList = new ArrayList<>();
        headerList.add(タイトル_作成日時);
        headerList.add(タイトル_作成時刻);
        headerList.add(タイトル_賦課年度);
        headerList.add(タイトル_通知書番号);
        headerList.add(タイトル_被保険者番号);
        headerList.add(タイトル_世帯コード);
        headerList.add(タイトル_表示コード名１);
        headerList.add(タイトル_表示コード名２);
        headerList.add(タイトル_表示コード名３);
        headerList.add(タイトル_表示コード１);
        headerList.add(タイトル_表示コード２);
        headerList.add(タイトル_表示コード３);
        headerList.add(タイトル_行政区コード);
        headerList.add(タイトル_行政区);
        headerList.add(タイトル_保険料額);
        headerList.add(タイトル_当期);
        headerList.add(タイトル_納付人_送付先);
        headerList.add(タイトル_生保開始日);
        headerList.add(タイトル_生保種別);
        headerList.add(タイトル_氏名);
        headerList.add(タイトル_郵便番号);
        headerList.add(タイトル_住所);
        headerList.add(タイトル_町域_管内_管外住所);
        headerList.add(タイトル_番地);
        headerList.add(タイトル_所得段階);
        headerList.add(タイトル_今後納付すべき額);
        headerList.add(タイトル_次期以降);
        headerList.add(タイトル_口座情報);
        return headerList;
    }

    /**
     * 納入通知書発行一覧表bodyList取得するメソッドです。
     *
     * @param 賦課年度 FlexibleYear
     * @param 出力期 RString
     * @param 帳票作成日時 RDateTime
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @return List<RString> 納入通知書発行一覧表bodyList
     */
    public List<RString> get納入通知書発行一覧表bodyList(FlexibleYear 賦課年度, RString 出力期, RDateTime 帳票作成日時,
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報) {
        List<RString> bodyList = new ArrayList<>();
        bodyList.add(帳票作成日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
        bodyList.add(帳票作成日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        bodyList.add(賦課年度.toDateString());
        bodyList.add(isNull(編集後本算定通知書共通情報.get通知書番号())
                ? RString.EMPTY : 編集後本算定通知書共通情報.get通知書番号().getColumnValue());
        bodyList.add(isNull(編集後本算定通知書共通情報.get被保険者番号())
                ? RString.EMPTY : 編集後本算定通知書共通情報.get被保険者番号().getColumnValue());
        if (isNull(編集後本算定通知書共通情報.get編集後個人())) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(isNull(編集後本算定通知書共通情報.get編集後個人().get世帯コード())
                    ? RString.EMPTY : 編集後本算定通知書共通情報.get編集後個人().get世帯コード().getColumnValue());
        }
        if (isNull(編集後本算定通知書共通情報.get表示コード())) {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(編集後本算定通知書共通情報.get表示コード().get表示コード名１());
            bodyList.add(編集後本算定通知書共通情報.get表示コード().get表示コード名２());
            bodyList.add(編集後本算定通知書共通情報.get表示コード().get表示コード名３());
            bodyList.add(編集後本算定通知書共通情報.get表示コード().get表示コード１());
            bodyList.add(編集後本算定通知書共通情報.get表示コード().get表示コード２());
            bodyList.add(編集後本算定通知書共通情報.get表示コード().get表示コード３());
        }
        if (isNull(編集後本算定通知書共通情報.get編集後宛先())) {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(isNull(編集後本算定通知書共通情報.get編集後宛先().get行政区コード())
                    ? RString.EMPTY : 編集後本算定通知書共通情報.get編集後宛先().get行政区コード().getColumnValue());
            bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get行政区名());
        }
        if (isNull(編集後本算定通知書共通情報.get更正後())) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(isNull(編集後本算定通知書共通情報.get更正後().get確定保険料_年額())
                    ? RString.EMPTY : new RString(編集後本算定通知書共通情報.get更正後().get確定保険料_年額().toString()));
        }
        set当期(編集後本算定通知書共通情報, 出力期, bodyList);
        set納付人_送付先(編集後本算定通知書共通情報, bodyList);

        if (isNull(編集後本算定通知書共通情報.get更正後())) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(編集後本算定通知書共通情報.get更正後().get生保開始日_西暦());
        }
        if (isNull(編集後本算定通知書共通情報.get更正後())
                || RString.isNullOrEmpty(編集後本算定通知書共通情報.get更正後().get生活保護扶助種類())) {
            bodyList.add(RString.EMPTY);
        } else {
            RString 生活保護扶助名称 = CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系,
                    URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                    new Code(編集後本算定通知書共通情報.get更正後().get生活保護扶助種類()));
            bodyList.add(生活保護扶助名称);
        }

        if (isNull(編集後本算定通知書共通情報.get編集後宛先())) {
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(isNull(編集後本算定通知書共通情報.get編集後宛先().get本人名称())
                    ? RString.EMPTY : 編集後本算定通知書共通情報.get編集後宛先().get本人名称().getName().getColumnValue());
            bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get郵便番号());
            bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get編集後住所());
            bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get町域());
            bodyList.add(編集後本算定通知書共通情報.get編集後宛先().get番地());
        }
        if (isNull(編集後本算定通知書共通情報.get更正後())) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(編集後本算定通知書共通情報.get更正後().get保険料段階());
        }
        bodyList.add(isNull(編集後本算定通知書共通情報.get今後納付すべき額_調定元に())
                ? RString.EMPTY : new RString(編集後本算定通知書共通情報.get今後納付すべき額_調定元に().toString()));
        set次期以降(編集後本算定通知書共通情報, 出力期, bodyList);
        bodyList.add(get口座情報(編集後本算定通知書共通情報));
        toBodyList(bodyList);
        return bodyList;
    }

    private void set納付人_送付先(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報, List<RString> bodyList) {
        if (isNull(編集後本算定通知書共通情報.get編集後宛先())
                || (isNull(編集後本算定通知書共通情報.get編集後宛先().get宛先名称())
                && isNull(編集後本算定通知書共通情報.get編集後宛先().get本人名称()))
                || (!isNull(編集後本算定通知書共通情報.get編集後宛先().get宛先名称())
                && 編集後本算定通知書共通情報.get編集後宛先().get宛先名称().equals(編集後本算定通知書共通情報.get編集後宛先().get本人名称()))) {
            bodyList.add(RString.EMPTY);
        } else {
            bodyList.add(定値_ほし.concat(RString.FULL_SPACE)
                    .concat(編集後本算定通知書共通情報.get編集後宛先().get宛先名称().getName().getColumnValue()));
        }
    }

    private void set当期(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報, RString 出力期, List<RString> bodyList) {

        if (isNull(編集後本算定通知書共通情報.get更正後()) || isNull(編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト())
                || 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト().isEmpty()) {
            bodyList.add(RString.EMPTY);
        } else {
            boolean 区分 = false;
            List<UniversalPhase> 普徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト();
            for (UniversalPhase 普徴期別金額 : 普徴期別金額リスト) {
                if (Integer.parseInt(出力期.toString()) == 普徴期別金額.get期()) {
                    区分 = true;
                    bodyList.add(isNull(普徴期別金額.get金額()) ? RString.EMPTY
                            : DecimalFormatter.toコンマ区切りRString(普徴期別金額.get金額(), 0));
                    break;
                }
            }
            if (!区分) {
                bodyList.add(RString.EMPTY);
            }
        }
    }

    private void set次期以降(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報, RString 出力期, List<RString> bodyList) {

        if (isNull(編集後本算定通知書共通情報.get更正後()) || isNull(編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト())
                || 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト().isEmpty()) {
            bodyList.add(RString.EMPTY);
        } else {
            boolean 区分 = false;
            List<UniversalPhase> 普徴期別金額リスト = 編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト();
            for (UniversalPhase 普徴期別金額 : 普徴期別金額リスト) {
                if (Integer.parseInt(出力期.toString()) == 普徴期別金額.get期() + INT_1) {
                    区分 = true;
                    bodyList.add(isNull(普徴期別金額.get金額()) ? RString.EMPTY
                            : DecimalFormatter.toコンマ区切りRString(普徴期別金額.get金額(), 0));
                    break;
                }
            }
            if (!区分) {
                bodyList.add(RString.EMPTY);
            }
        }
    }

    /**
     * 賦課情報取得するメソッドです。
     *
     * @param entity HonsanteiTsuchishoTempEntity
     * @param 選択通知書 RString
     * @param 出力順グループ名 RString
     * @return TmpHonsanteiTsuchishoTableEntity 賦課情報
     */
    public TmpHonsanteiTsuchishoTableEntity to賦課情報_決定変更判定(HonsanteiTsuchishoTempEntity entity,
            RString 選択通知書, RString 出力順グループ名) {
        TmpHonsanteiTsuchishoTableEntity tempEntity = to賦課情報_決定変更(entity);
        tempEntity.set決定変更区分(選択通知書);
        tempEntity.set出力順グループ指定(出力順グループ名);
        tempEntity.set生活保護区分(entity.get生活保護区分());
        tempEntity.set更正前情報有無区分(entity.get更正前情報有無区分());
        tempEntity.set特徴8月開始者区分(entity.get特徴8月開始者区分());
        tempEntity.set特徴10月開始者区分(entity.get特徴10月開始者区分());
        return tempEntity;

    }

    /**
     * 賦課情報取得するメソッドです。
     *
     * @param entity HonsanteiTsuchishoTempEntity
     * @return TmpHonsanteiTsuchishoTableEntity 賦課情報
     */
    public TmpHonsanteiTsuchishoTableEntity to賦課情報_決定変更(HonsanteiTsuchishoTempEntity entity) {

        TmpHonsanteiTsuchishoTableEntity tmpEntity = new TmpHonsanteiTsuchishoTableEntity();

        set計算後情報_更正後(entity.get計算後情報_更正後(), tmpEntity);

        if (entity.get計算後情報_更正前() != null && entity.get計算後情報_更正前().getTsuchishoNo() != null
                && !entity.get計算後情報_更正前().getTsuchishoNo().isEmpty()) {
            set計算後情報_更正前(entity.get計算後情報_更正前(), tmpEntity);
        }

        if (entity.get対象者_追加含む_情報_更正後() != null && entity.get対象者_追加含む_情報_更正後().getShoriNendo() != null
                && !entity.get対象者_追加含む_情報_更正後().getShoriNendo().isEmpty()) {
            set対象者追加含む情報_更正後(entity.get対象者_追加含む_情報_更正後(), tmpEntity);
        }

        if (entity.get対象者_追加含む_情報_更正前() != null && entity.get対象者_追加含む_情報_更正前().getShoriNendo() != null
                && !entity.get対象者_追加含む_情報_更正前().getShoriNendo().isEmpty()) {
            set対象者追加含む情報_更正前(entity.get対象者_追加含む_情報_更正前(), tmpEntity);
        }

        if (entity.get宛名() != null) {
            set宛名の全項目(entity.get宛名(), tmpEntity);
        }
        if (entity.get宛先() != null && entity.get宛先().getShikibetsuCode() != null) {
            set宛先の全項目(entity.get宛先(), tmpEntity);
        }
        if (entity.get納組() != null && entity.get納組().getSeikyuHoho() != null
                && entity.get納組().getSeikyuHoho().getShikibetsuCode() != null) {
            set納組情報の全項目(entity.get納組(), tmpEntity);
        }
        if (entity.get特定口座() != null && entity.get特定口座().getUaT0310KozaEntity() != null
                && entity.get特定口座().getUaT0310KozaEntity().getKozaId() != 0) {
            set口座情報の全項目(entity.get特定口座(), tmpEntity);
        }

        return tmpEntity;
    }

    /**
     * 賦課情報取得するメソッドです。
     *
     * @param entity HonsanteiTsuchishoTempEntity
     * @return TmpHonsanteiTsuchishoTableEntity 賦課情報
     */
    public TmpHonsanteiTsuchishoTableEntity to賦課情報(HonsanteiTsuchishoTempEntity entity) {

        TmpHonsanteiTsuchishoTableEntity tmpEntity = new TmpHonsanteiTsuchishoTableEntity();

        set計算後情報_更正後(entity.get計算後情報_更正後(), tmpEntity);

        set対象者追加含む情報_更正後(entity.get対象者_追加含む_情報_更正後(), tmpEntity);

        if (entity.get宛名() != null) {
            set宛名の全項目(entity.get宛名(), tmpEntity);
        }
        if (entity.get宛先() != null && entity.get宛先().getShikibetsuCode() != null) {
            set宛先の全項目(entity.get宛先(), tmpEntity);
        }
        if (entity.get納組() != null && entity.get納組().getSeikyuHoho() != null
                && entity.get納組().getSeikyuHoho().getShikibetsuCode() != null) {
            set納組情報の全項目(entity.get納組(), tmpEntity);
        }
        if (entity.get特定口座() != null && entity.get特定口座().getUaT0310KozaEntity() != null
                && entity.get特定口座().getUaT0310KozaEntity().getKozaId() != 0) {
            set口座情報の全項目(entity.get特定口座(), tmpEntity);
        }
        tmpEntity.set更正前情報有無区分(定値区分_0);
        tmpEntity.set生活保護区分(定値区分_0);
        tmpEntity.set決定変更区分(定値区分_0);
        tmpEntity.set特徴8月開始者区分(RString.EMPTY);
        tmpEntity.set特徴10月開始者区分(RString.EMPTY);

        return tmpEntity;
    }

    private void set計算後情報_更正後(DbT2015KeisangoJohoEntity 計算後情報, TmpHonsanteiTsuchishoTableEntity tmpEntity) {
        tmpEntity.setDbT2015KeisangoJoho_choteiNendo(計算後情報.getChoteiNendo());
        tmpEntity.setDbT2015KeisangoJoho_fukaNendo(計算後情報.getFukaNendo());
        tmpEntity.setDbT2015KeisangoJoho_tsuchishoNo(計算後情報.getTsuchishoNo());
        tmpEntity.setDbT2015KeisangoJoho_koseiZengoKubun(計算後情報.getKoseiZengoKubun());
        tmpEntity.setDbT2015KeisangoJoho_sakuseiShoriName(計算後情報.getSakuseiShoriName());
        tmpEntity.setDbT2015KeisangoJoho_fukaRirekiNo(計算後情報.getFukaRirekiNo());
        tmpEntity.setDbT2015KeisangoJoho_hihokenshaNo(計算後情報.getHihokenshaNo());
        tmpEntity.setDbT2015KeisangoJoho_shikibetsuCode(計算後情報.getShikibetsuCode());
        tmpEntity.setDbT2015KeisangoJoho_setaiCode(計算後情報.getSetaiCode());
        tmpEntity.setDbT2015KeisangoJoho_setaiInsu(計算後情報.getSetaiInsu());
        tmpEntity.setDbT2015KeisangoJoho_shikakuShutokuYMD(計算後情報.getShikakuShutokuYMD());
        tmpEntity.setDbT2015KeisangoJoho_shikakuShutokuJiyu(計算後情報.getShikakuShutokuJiyu());
        tmpEntity.setDbT2015KeisangoJoho_shikakuSoshitsuYMD(計算後情報.getShikakuSoshitsuYMD());
        tmpEntity.setDbT2015KeisangoJoho_shikakuSoshitsuJiyu(計算後情報.getShikakuSoshitsuJiyu());
        tmpEntity.setDbT2015KeisangoJoho_seihofujoShurui(計算後情報.getSeihofujoShurui());
        tmpEntity.setDbT2015KeisangoJoho_seihoKaishiYMD(計算後情報.getSeihoKaishiYMD());
        tmpEntity.setDbT2015KeisangoJoho_seihoHaishiYMD(計算後情報.getSeihoHaishiYMD());
        tmpEntity.setDbT2015KeisangoJoho_ronenKaishiYMD(計算後情報.getRonenKaishiYMD());
        tmpEntity.setDbT2015KeisangoJoho_ronenHaishiYMD(計算後情報.getRonenHaishiYMD());
        tmpEntity.setDbT2015KeisangoJoho_fukaYMD(計算後情報.getFukaYMD());
        tmpEntity.setDbT2015KeisangoJoho_kazeiKubun(計算後情報.getKazeiKubun());
        tmpEntity.setDbT2015KeisangoJoho_setaikazeiKubun(計算後情報.getSetaikazeiKubun());
        tmpEntity.setDbT2015KeisangoJoho_gokeiShotokuGaku(計算後情報.getGokeiShotokuGaku());
        tmpEntity.setDbT2015KeisangoJoho_nenkinShunyuGaku(計算後情報.getNenkinShunyuGaku());
        tmpEntity.setDbT2015KeisangoJoho_hokenryoDankai(計算後情報.getHokenryoDankai());
        tmpEntity.setDbT2015KeisangoJoho_hokenryoDankai1(計算後情報.getHokenryoDankai1());
        tmpEntity.setDbT2015KeisangoJoho_nengakuHokenryo1(計算後情報.getNengakuHokenryo1());
        tmpEntity.setDbT2015KeisangoJoho_tsukiwariStartYM1(計算後情報.getTsukiwariStartYM1());
        tmpEntity.setDbT2015KeisangoJoho_tsukiwariEndYM1(計算後情報.getTsukiwariEndYM1());
        tmpEntity.setDbT2015KeisangoJoho_hokenryoDankai2(計算後情報.getHokenryoDankai2());
        tmpEntity.setDbT2015KeisangoJoho_nengakuHokenryo2(計算後情報.getNengakuHokenryo2());
        tmpEntity.setDbT2015KeisangoJoho_tsukiwariStartYM2(計算後情報.getTsukiwariStartYM2());
        tmpEntity.setDbT2015KeisangoJoho_tsukiwariEndYM2(計算後情報.getTsukiwariEndYM2());
        tmpEntity.setDbT2015KeisangoJoho_choteiNichiji(計算後情報.getChoteiNichiji());
        tmpEntity.setDbT2015KeisangoJoho_choteiJiyu1(計算後情報.getChoteiJiyu1());
        tmpEntity.setDbT2015KeisangoJoho_choteiJiyu2(計算後情報.getChoteiJiyu2());
        tmpEntity.setDbT2015KeisangoJoho_choteiJiyu3(計算後情報.getChoteiJiyu3());
        tmpEntity.setDbT2015KeisangoJoho_choteiJiyu4(計算後情報.getChoteiJiyu4());
        tmpEntity.setDbT2015KeisangoJoho_koseiM(計算後情報.getKoseiM());
        tmpEntity.setDbT2015KeisangoJoho_gemmenMaeHokenryo(計算後情報.getGemmenMaeHokenryo());
        tmpEntity.setDbT2015KeisangoJoho_gemmenGaku(計算後情報.getGemmenGaku());
        tmpEntity.setDbT2015KeisangoJoho_kakuteiHokenryo(計算後情報.getKakuteiHokenryo());
        tmpEntity.setDbT2015KeisangoJoho_hokenryoDankaiKarisanntei(計算後情報.getHokenryoDankaiKarisanntei());
        tmpEntity.setDbT2015KeisangoJoho_choshuHohoRirekiNo(計算後情報.getChoshuHohoRirekiNo());
        tmpEntity.setDbT2015KeisangoJoho_idoKijunNichiji(計算後情報.getIdoKijunNichiji());
        tmpEntity.setDbT2015KeisangoJoho_kozaKubun(計算後情報.getKozaKubun());
        tmpEntity.setDbT2015KeisangoJoho_kyokaisoKubun(計算後情報.getKyokaisoKubun());
        tmpEntity.setDbT2015KeisangoJoho_shokkenKubun(計算後情報.getShokkenKubun());
        tmpEntity.setDbT2015KeisangoJoho_fukaShichosonCode(計算後情報.getFukaShichosonCode());
        tmpEntity.setDbT2015KeisangoJoho_tkSaishutsuKampuGaku(計算後情報.getTkSaishutsuKampuGaku());
        tmpEntity.setDbT2015KeisangoJoho_fuSaishutsuKampuGaku(計算後情報.getFuSaishutsuKampuGaku());
        tmpEntity.setDbT2015KeisangoJoho_tkKibetsuGaku01(計算後情報.getTkKibetsuGaku01());
        tmpEntity.setDbT2015KeisangoJoho_tkKibetsuGaku02(計算後情報.getTkKibetsuGaku02());
        tmpEntity.setDbT2015KeisangoJoho_tkKibetsuGaku03(計算後情報.getTkKibetsuGaku03());
        tmpEntity.setDbT2015KeisangoJoho_tkKibetsuGaku04(計算後情報.getTkKibetsuGaku04());
        tmpEntity.setDbT2015KeisangoJoho_tkKibetsuGaku05(計算後情報.getTkKibetsuGaku05());
        tmpEntity.setDbT2015KeisangoJoho_tkKibetsuGaku06(計算後情報.getTkKibetsuGaku06());
        tmpEntity.setDbT2015KeisangoJoho_fuKibetsuGaku01(計算後情報.getFuKibetsuGaku01());
        tmpEntity.setDbT2015KeisangoJoho_fuKibetsuGaku02(計算後情報.getFuKibetsuGaku02());
        tmpEntity.setDbT2015KeisangoJoho_fuKibetsuGaku03(計算後情報.getFuKibetsuGaku03());
        tmpEntity.setDbT2015KeisangoJoho_fuKibetsuGaku04(計算後情報.getFuKibetsuGaku04());
        tmpEntity.setDbT2015KeisangoJoho_fuKibetsuGaku05(計算後情報.getFuKibetsuGaku05());
        tmpEntity.setDbT2015KeisangoJoho_fuKibetsuGaku06(計算後情報.getFuKibetsuGaku06());
        tmpEntity.setDbT2015KeisangoJoho_fuKibetsuGaku07(計算後情報.getFuKibetsuGaku07());
        tmpEntity.setDbT2015KeisangoJoho_fuKibetsuGaku08(計算後情報.getFuKibetsuGaku08());
        tmpEntity.setDbT2015KeisangoJoho_fuKibetsuGaku09(計算後情報.getFuKibetsuGaku09());
        tmpEntity.setDbT2015KeisangoJoho_fuKibetsuGaku10(計算後情報.getFuKibetsuGaku10());
        tmpEntity.setDbT2015KeisangoJoho_fuKibetsuGaku11(計算後情報.getFuKibetsuGaku11());
        tmpEntity.setDbT2015KeisangoJoho_fuKibetsuGaku12(計算後情報.getFuKibetsuGaku12());
        tmpEntity.setDbT2015KeisangoJoho_fuKibetsuGaku13(計算後情報.getFuKibetsuGaku13());
        tmpEntity.setDbT2015KeisangoJoho_fuKibetsuGaku14(計算後情報.getFuKibetsuGaku14());
        tmpEntity.setDbT2015KeisangoJoho_choshuHoho4gatsu(計算後情報.getChoshuHoho4gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHoho5gatsu(計算後情報.getChoshuHoho5gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHoho6gatsu(計算後情報.getChoshuHoho6gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHoho7gatsu(計算後情報.getChoshuHoho7gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHoho8gatsu(計算後情報.getChoshuHoho8gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHoho9gatsu(計算後情報.getChoshuHoho9gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHoho10gatsu(計算後情報.getChoshuHoho10gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHoho11gatsu(計算後情報.getChoshuHoho11gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHoho12gatsu(計算後情報.getChoshuHoho12gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHoho1gatsu(計算後情報.getChoshuHoho1gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHoho2gatsu(計算後情報.getChoshuHoho2gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHoho3gatsu(計算後情報.getChoshuHoho3gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHohoYoku4gatsu(計算後情報.getChoshuHohoYoku4gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHohoYoku5gatsu(計算後情報.getChoshuHohoYoku5gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHohoYoku6gatsu(計算後情報.getChoshuHohoYoku6gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHohoYoku7gatsu(計算後情報.getChoshuHohoYoku7gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHohoYoku8gatsu(計算後情報.getChoshuHohoYoku8gatsu());
        tmpEntity.setDbT2015KeisangoJoho_choshuHohoYoku9gatsu(計算後情報.getChoshuHohoYoku9gatsu());
        tmpEntity.setDbT2015KeisangoJoho_kariNenkinNo(計算後情報.getKariNenkinNo());
        tmpEntity.setDbT2015KeisangoJoho_kariNenkinCode(計算後情報.getKariNenkinCode());
        tmpEntity.setDbT2015KeisangoJoho_kariHosokuM(計算後情報.getKariHosokuM());
        tmpEntity.setDbT2015KeisangoJoho_honNenkinNo(計算後情報.getHonNenkinNo());
        tmpEntity.setDbT2015KeisangoJoho_honNenkinCode(計算後情報.getHonNenkinCode());
        tmpEntity.setDbT2015KeisangoJoho_honHosokuM(計算後情報.getHonHosokuM());
        tmpEntity.setDbT2015KeisangoJoho_yokunendoKariNenkinNo(計算後情報.getYokunendoKariNenkinNo());
        tmpEntity.setDbT2015KeisangoJoho_yokunendoKariNenkinCode(計算後情報.getYokunendoKariNenkinCode());
        tmpEntity.setDbT2015KeisangoJoho_yokunendoKariHosokuM(計算後情報.getYokunendoKariHosokuM());
        tmpEntity.setDbT2015KeisangoJoho_iraiSohuzumiFlag(計算後情報.getIraiSohuzumiFlag());
        tmpEntity.setDbT2015KeisangoJoho_tsuikaIraiSohuzumiFlag(計算後情報.getTsuikaIraiSohuzumiFlag());
        tmpEntity.setDbT2015KeisangoJoho_tokuchoTeishiNichiji(計算後情報.getTokuchoTeishiNichiji());
        tmpEntity.setDbT2015KeisangoJoho_tokuchoTeishiJiyuCode(計算後情報.getTokuchoTeishiJiyuCode());
        tmpEntity.setDbT2015KeisangoJoho_tkShunyuGaku01(計算後情報.getTkShunyuGaku01());
        tmpEntity.setDbT2015KeisangoJoho_tkShunyuGaku02(計算後情報.getTkShunyuGaku02());
        tmpEntity.setDbT2015KeisangoJoho_tkShunyuGaku03(計算後情報.getTkShunyuGaku03());
        tmpEntity.setDbT2015KeisangoJoho_tkShunyuGaku04(計算後情報.getTkShunyuGaku04());
        tmpEntity.setDbT2015KeisangoJoho_tkShunyuGaku05(計算後情報.getTkShunyuGaku05());
        tmpEntity.setDbT2015KeisangoJoho_tkShunyuGaku06(計算後情報.getTkShunyuGaku06());
        tmpEntity.setDbT2015KeisangoJoho_fuShunyuGaku01(計算後情報.getFuShunyuGaku01());
        tmpEntity.setDbT2015KeisangoJoho_fuShunyuGaku02(計算後情報.getFuShunyuGaku02());
        tmpEntity.setDbT2015KeisangoJoho_fuShunyuGaku03(計算後情報.getFuShunyuGaku03());
        tmpEntity.setDbT2015KeisangoJoho_fuShunyuGaku04(計算後情報.getFuShunyuGaku04());
        tmpEntity.setDbT2015KeisangoJoho_fuShunyuGaku05(計算後情報.getFuShunyuGaku05());
        tmpEntity.setDbT2015KeisangoJoho_fuShunyuGaku06(計算後情報.getFuShunyuGaku06());
        tmpEntity.setDbT2015KeisangoJoho_fuShunyuGaku07(計算後情報.getFuShunyuGaku07());
        tmpEntity.setDbT2015KeisangoJoho_fuShunyuGaku08(計算後情報.getFuShunyuGaku08());
        tmpEntity.setDbT2015KeisangoJoho_fuShunyuGaku09(計算後情報.getFuShunyuGaku09());
        tmpEntity.setDbT2015KeisangoJoho_fuShunyuGaku10(計算後情報.getFuShunyuGaku10());
        tmpEntity.setDbT2015KeisangoJoho_fuShunyuGaku11(計算後情報.getFuShunyuGaku11());
        tmpEntity.setDbT2015KeisangoJoho_fuShunyuGaku12(計算後情報.getFuShunyuGaku12());
        tmpEntity.setDbT2015KeisangoJoho_fuShunyuGaku13(計算後情報.getFuShunyuGaku13());
        tmpEntity.setDbT2015KeisangoJoho_fuShunyuGaku14(計算後情報.getFuShunyuGaku14());
    }

    private void set計算後情報_更正前(DbT2015KeisangoJohoEntity 計算後情報, TmpHonsanteiTsuchishoTableEntity tmpEntity) {
        tmpEntity.setChoteiNendo(計算後情報.getChoteiNendo());
        tmpEntity.setFukaNendo(計算後情報.getFukaNendo());
        tmpEntity.setTsuchishoNo(計算後情報.getTsuchishoNo());
        tmpEntity.setKoseiZengoKubun(計算後情報.getKoseiZengoKubun());
        tmpEntity.setSakuseiShoriName(計算後情報.getSakuseiShoriName());
        tmpEntity.setFukaRirekiNo(計算後情報.getFukaRirekiNo());
        tmpEntity.setHihokenshaNo(計算後情報.getHihokenshaNo());
        tmpEntity.setShikibetsuCode(計算後情報.getShikibetsuCode());
        tmpEntity.setSetaiCode(計算後情報.getSetaiCode());
        tmpEntity.setSetaiInsu(計算後情報.getSetaiInsu());
        tmpEntity.setShikakuShutokuYMD(計算後情報.getShikakuShutokuYMD());
        tmpEntity.setShikakuShutokuJiyu(計算後情報.getShikakuShutokuJiyu());
        tmpEntity.setShikakuSoshitsuYMD(計算後情報.getShikakuSoshitsuYMD());
        tmpEntity.setShikakuSoshitsuJiyu(計算後情報.getShikakuSoshitsuJiyu());
        tmpEntity.setSeihofujoShurui(計算後情報.getSeihofujoShurui());
        tmpEntity.setSeihoKaishiYMD(計算後情報.getSeihoKaishiYMD());
        tmpEntity.setSeihoHaishiYMD(計算後情報.getSeihoHaishiYMD());
        tmpEntity.setRonenKaishiYMD(計算後情報.getRonenKaishiYMD());
        tmpEntity.setRonenHaishiYMD(計算後情報.getRonenHaishiYMD());
        tmpEntity.setFukaYMD(計算後情報.getFukaYMD());
        tmpEntity.setKazeiKubun(計算後情報.getKazeiKubun());
        tmpEntity.setSetaikazeiKubun(計算後情報.getSetaikazeiKubun());
        tmpEntity.setGokeiShotokuGaku(計算後情報.getGokeiShotokuGaku());
        tmpEntity.setNenkinShunyuGaku(計算後情報.getNenkinShunyuGaku());
        tmpEntity.setHokenryoDankai(計算後情報.getHokenryoDankai());
        tmpEntity.setHokenryoDankai1(計算後情報.getHokenryoDankai1());
        tmpEntity.setNengakuHokenryo1(計算後情報.getNengakuHokenryo1());
        tmpEntity.setTsukiwariStartYM1(計算後情報.getTsukiwariStartYM1());
        tmpEntity.setTsukiwariEndYM1(計算後情報.getTsukiwariEndYM1());
        tmpEntity.setHokenryoDankai2(計算後情報.getHokenryoDankai2());
        tmpEntity.setNengakuHokenryo2(計算後情報.getNengakuHokenryo2());
        tmpEntity.setTsukiwariStartYM2(計算後情報.getTsukiwariStartYM2());
        tmpEntity.setTsukiwariEndYM2(計算後情報.getTsukiwariEndYM2());
        tmpEntity.setChoteiNichiji(計算後情報.getChoteiNichiji());
        tmpEntity.setChoteiJiyu1(計算後情報.getChoteiJiyu1());
        tmpEntity.setChoteiJiyu2(計算後情報.getChoteiJiyu2());
        tmpEntity.setChoteiJiyu3(計算後情報.getChoteiJiyu3());
        tmpEntity.setChoteiJiyu4(計算後情報.getChoteiJiyu4());
        tmpEntity.setKoseiM(計算後情報.getKoseiM());
        tmpEntity.setGemmenMaeHokenryo(計算後情報.getGemmenMaeHokenryo());
        tmpEntity.setGemmenGaku(計算後情報.getGemmenGaku());
        tmpEntity.setKakuteiHokenryo(計算後情報.getKakuteiHokenryo());
        tmpEntity.setHokenryoDankaiKarisanntei(計算後情報.getHokenryoDankaiKarisanntei());
        tmpEntity.setChoshuHohoRirekiNo(計算後情報.getChoshuHohoRirekiNo());
        tmpEntity.setIdoKijunNichiji(計算後情報.getIdoKijunNichiji());
        tmpEntity.setKozaKubun(計算後情報.getKozaKubun());
        tmpEntity.setKyokaisoKubun(計算後情報.getKyokaisoKubun());
        tmpEntity.setShokkenKubun(計算後情報.getShokkenKubun());
        tmpEntity.setFukaShichosonCode(計算後情報.getFukaShichosonCode());
        tmpEntity.setTkSaishutsuKampuGaku(計算後情報.getTkSaishutsuKampuGaku());
        tmpEntity.setFuSaishutsuKampuGaku(計算後情報.getFuSaishutsuKampuGaku());
        tmpEntity.setTkKibetsuGaku01(計算後情報.getTkKibetsuGaku01());
        tmpEntity.setTkKibetsuGaku02(計算後情報.getTkKibetsuGaku02());
        tmpEntity.setTkKibetsuGaku03(計算後情報.getTkKibetsuGaku03());
        tmpEntity.setTkKibetsuGaku04(計算後情報.getTkKibetsuGaku04());
        tmpEntity.setTkKibetsuGaku05(計算後情報.getTkKibetsuGaku05());
        tmpEntity.setTkKibetsuGaku06(計算後情報.getTkKibetsuGaku06());
        tmpEntity.setFuKibetsuGaku01(計算後情報.getFuKibetsuGaku01());
        tmpEntity.setFuKibetsuGaku02(計算後情報.getFuKibetsuGaku02());
        tmpEntity.setFuKibetsuGaku03(計算後情報.getFuKibetsuGaku03());
        tmpEntity.setFuKibetsuGaku04(計算後情報.getFuKibetsuGaku04());
        tmpEntity.setFuKibetsuGaku05(計算後情報.getFuKibetsuGaku05());
        tmpEntity.setFuKibetsuGaku06(計算後情報.getFuKibetsuGaku06());
        tmpEntity.setFuKibetsuGaku07(計算後情報.getFuKibetsuGaku07());
        tmpEntity.setFuKibetsuGaku08(計算後情報.getFuKibetsuGaku08());
        tmpEntity.setFuKibetsuGaku09(計算後情報.getFuKibetsuGaku09());
        tmpEntity.setFuKibetsuGaku10(計算後情報.getFuKibetsuGaku10());
        tmpEntity.setFuKibetsuGaku11(計算後情報.getFuKibetsuGaku11());
        tmpEntity.setFuKibetsuGaku12(計算後情報.getFuKibetsuGaku12());
        tmpEntity.setFuKibetsuGaku13(計算後情報.getFuKibetsuGaku13());
        tmpEntity.setFuKibetsuGaku14(計算後情報.getFuKibetsuGaku14());
        tmpEntity.setChoshuHoho4gatsu(計算後情報.getChoshuHoho4gatsu());
        tmpEntity.setChoshuHoho5gatsu(計算後情報.getChoshuHoho5gatsu());
        tmpEntity.setChoshuHoho6gatsu(計算後情報.getChoshuHoho6gatsu());
        tmpEntity.setChoshuHoho7gatsu(計算後情報.getChoshuHoho7gatsu());
        tmpEntity.setChoshuHoho8gatsu(計算後情報.getChoshuHoho8gatsu());
        tmpEntity.setChoshuHoho9gatsu(計算後情報.getChoshuHoho9gatsu());
        tmpEntity.setChoshuHoho10gatsu(計算後情報.getChoshuHoho10gatsu());
        tmpEntity.setChoshuHoho11gatsu(計算後情報.getChoshuHoho11gatsu());
        tmpEntity.setChoshuHoho12gatsu(計算後情報.getChoshuHoho12gatsu());
        tmpEntity.setChoshuHoho1gatsu(計算後情報.getChoshuHoho1gatsu());
        tmpEntity.setChoshuHoho2gatsu(計算後情報.getChoshuHoho2gatsu());
        tmpEntity.setChoshuHoho3gatsu(計算後情報.getChoshuHoho3gatsu());
        tmpEntity.setChoshuHohoYoku4gatsu(計算後情報.getChoshuHohoYoku4gatsu());
        tmpEntity.setChoshuHohoYoku5gatsu(計算後情報.getChoshuHohoYoku5gatsu());
        tmpEntity.setChoshuHohoYoku6gatsu(計算後情報.getChoshuHohoYoku6gatsu());
        tmpEntity.setChoshuHohoYoku7gatsu(計算後情報.getChoshuHohoYoku7gatsu());
        tmpEntity.setChoshuHohoYoku8gatsu(計算後情報.getChoshuHohoYoku8gatsu());
        tmpEntity.setChoshuHohoYoku9gatsu(計算後情報.getChoshuHohoYoku9gatsu());
        tmpEntity.setKariNenkinNo(計算後情報.getKariNenkinNo());
        tmpEntity.setKariNenkinCode(計算後情報.getKariNenkinCode());
        tmpEntity.setKariHosokuM(計算後情報.getKariHosokuM());
        tmpEntity.setHonNenkinNo(計算後情報.getHonNenkinNo());
        tmpEntity.setHonNenkinCode(計算後情報.getHonNenkinCode());
        tmpEntity.setHonHosokuM(計算後情報.getHonHosokuM());
        tmpEntity.setYokunendoKariNenkinNo(計算後情報.getYokunendoKariNenkinNo());
        tmpEntity.setYokunendoKariNenkinCode(計算後情報.getYokunendoKariNenkinCode());
        tmpEntity.setYokunendoKariHosokuM(計算後情報.getYokunendoKariHosokuM());
        tmpEntity.setIraiSohuzumiFlag(計算後情報.getIraiSohuzumiFlag());
        tmpEntity.setTsuikaIraiSohuzumiFlag(計算後情報.getTsuikaIraiSohuzumiFlag());
        tmpEntity.setTokuchoTeishiNichiji(計算後情報.getTokuchoTeishiNichiji());
        tmpEntity.setTokuchoTeishiJiyuCode(計算後情報.getTokuchoTeishiJiyuCode());
        tmpEntity.setTkShunyuGaku01(計算後情報.getTkShunyuGaku01());
        tmpEntity.setTkShunyuGaku02(計算後情報.getTkShunyuGaku02());
        tmpEntity.setTkShunyuGaku03(計算後情報.getTkShunyuGaku03());
        tmpEntity.setTkShunyuGaku04(計算後情報.getTkShunyuGaku04());
        tmpEntity.setTkShunyuGaku05(計算後情報.getTkShunyuGaku05());
        tmpEntity.setTkShunyuGaku06(計算後情報.getTkShunyuGaku06());
        tmpEntity.setFuShunyuGaku01(計算後情報.getFuShunyuGaku01());
        tmpEntity.setFuShunyuGaku02(計算後情報.getFuShunyuGaku02());
        tmpEntity.setFuShunyuGaku03(計算後情報.getFuShunyuGaku03());
        tmpEntity.setFuShunyuGaku04(計算後情報.getFuShunyuGaku04());
        tmpEntity.setFuShunyuGaku05(計算後情報.getFuShunyuGaku05());
        tmpEntity.setFuShunyuGaku06(計算後情報.getFuShunyuGaku06());
        tmpEntity.setFuShunyuGaku07(計算後情報.getFuShunyuGaku07());
        tmpEntity.setFuShunyuGaku08(計算後情報.getFuShunyuGaku08());
        tmpEntity.setFuShunyuGaku09(計算後情報.getFuShunyuGaku09());
        tmpEntity.setFuShunyuGaku10(計算後情報.getFuShunyuGaku10());
        tmpEntity.setFuShunyuGaku11(計算後情報.getFuShunyuGaku11());
        tmpEntity.setFuShunyuGaku12(計算後情報.getFuShunyuGaku12());
        tmpEntity.setFuShunyuGaku13(計算後情報.getFuShunyuGaku13());
        tmpEntity.setFuShunyuGaku14(計算後情報.getFuShunyuGaku14());
    }

    private void set対象者追加含む情報_更正後(UeT0511NenkinTokuchoKaifuJohoEntity 対象者_追加含む_情報,
            TmpHonsanteiTsuchishoTableEntity tmpEntity) {
        tmpEntity.setUeT0511after_gyomuCode(対象者_追加含む_情報.getGyomuCode());
        tmpEntity.setUeT0511after_shoriNendo(対象者_追加含む_情報.getShoriNendo());
        tmpEntity.setUeT0511after_tsuchiNaiyoCode(対象者_追加含む_情報.getTsuchiNaiyoCode());
        tmpEntity.setUeT0511after_shoriTaishoYM(対象者_追加含む_情報.getShoriTaishoYM());
        tmpEntity.setUeT0511after_kisoNenkinNo(対象者_追加含む_情報.getKisoNenkinNo());
        tmpEntity.setUeT0511after_nenkinCode(対象者_追加含む_情報.getNenkinCode());
        tmpEntity.setUeT0511after_koseiCityCode(対象者_追加含む_情報.getKoseiCityCode());
        tmpEntity.setUeT0511after_renban(対象者_追加含む_情報.getRenban());
        tmpEntity.setUeT0511after_shoriTimestamp(対象者_追加含む_情報.getShoriTimestamp());
        tmpEntity.setUeT0511after_renkeiShubetsu(対象者_追加含む_情報.getRenkeiShubetsu());
        tmpEntity.setUeT0511after_hosokuTsuki(対象者_追加含む_情報.getHosokuTsuki());
        tmpEntity.setUeT0511after_tenbikiTsuki(対象者_追加含む_情報.getTenbikiTsuki());
        tmpEntity.setUeT0511after_shikibetsuCode(対象者_追加含む_情報.getShikibetsuCode());
        tmpEntity.setUeT0511after_hihokenshaNo(対象者_追加含む_情報.getHihokenshaNo());
        tmpEntity.setUeT0511after_kokuhoSetaiCode(対象者_追加含む_情報.getKokuhoSetaiCode());
        tmpEntity.setUeT0511after_dtCityCode(対象者_追加含む_情報.getDtCityCode());
        tmpEntity.setUeT0511after_dtTokubetsuChoshuGimushaCode(getCode(対象者_追加含む_情報.getDtTokubetsuChoshuGimushaCode()));
        tmpEntity.setUeT0511after_dtTsuchiNaiyoCode(対象者_追加含む_情報.getDtTsuchiNaiyoCode());
        tmpEntity.setUeT0511after_dtBaitaiCode(対象者_追加含む_情報.getDtBaitaiCode());
        tmpEntity.setUeT0511after_dtTokubetsuChoshuSeidoCode(対象者_追加含む_情報.getDtTokubetsuChoshuSeidoCode());
        tmpEntity.setUeT0511after_dtSakuseiYMD(対象者_追加含む_情報.getDtSakuseiYMD());
        tmpEntity.setUeT0511after_dtKisoNenkinNo(対象者_追加含む_情報.getDtKisoNenkinNo());
        tmpEntity.setUeT0511after_dtNenkinCode(対象者_追加含む_情報.getDtNenkinCode());
        tmpEntity.setUeT0511after_dtYobi1(対象者_追加含む_情報.getDtYobi1());
        tmpEntity.setUeT0511after_dtBirthDay(対象者_追加含む_情報.getDtBirthDay());
        tmpEntity.setUeT0511after_dtSeibetsu(対象者_追加含む_情報.getDtSeibetsu());
        tmpEntity.setUeT0511after_dtKanaShimei(対象者_追加含む_情報.getDtKanaShimei());
        tmpEntity.setUeT0511after_dtShiftCode1(対象者_追加含む_情報.getDtShiftCode1());
        tmpEntity.setUeT0511after_dtKanjiShimei(対象者_追加含む_情報.getDtKanjiShimei());
        tmpEntity.setUeT0511after_dtShiftCode2(対象者_追加含む_情報.getDtShiftCode2());
        tmpEntity.setUeT0511after_dtYubinNo(対象者_追加含む_情報.getDtYubinNo());
        tmpEntity.setUeT0511after_dtKanaJusho(対象者_追加含む_情報.getDtKanaJusho());
        tmpEntity.setUeT0511after_dtShiftCode3(対象者_追加含む_情報.getDtShiftCode3());
        tmpEntity.setUeT0511after_dtKanjiJusho(対象者_追加含む_情報.getDtKanjiJusho());
        tmpEntity.setUeT0511after_dtShiftCode4(対象者_追加含む_情報.getDtShiftCode4());
        tmpEntity.setUeT0511after_dtKakushuKubun(対象者_追加含む_情報.getDtKakushuKubun());
        tmpEntity.setUeT0511after_dtShoriKekka(対象者_追加含む_情報.getDtShoriKekka());
        tmpEntity.setUeT0511after_dtKokiIkanCode(対象者_追加含む_情報.getDtKokiIkanCode());
        tmpEntity.setUeT0511after_dtKakushuYMD(対象者_追加含む_情報.getDtKakushuYMD());
        tmpEntity.setUeT0511after_dtKakushuKingaku1(対象者_追加含む_情報.getDtKakushuKingaku1());
        tmpEntity.setUeT0511after_dtKakushuKingaku2(対象者_追加含む_情報.getDtKakushuKingaku2());
        tmpEntity.setUeT0511after_dtKakushuKingaku3(対象者_追加含む_情報.getDtKakushuKingaku3());
        tmpEntity.setUeT0511after_dtYobi2(対象者_追加含む_情報.getDtYobi2());
        tmpEntity.setUeT0511after_dtKyosaiNenkinshoshoKigoNo(対象者_追加含む_情報.getDtKyosaiNenkinshoshoKigoNo());
        tmpEntity.setUeT0511after_dtKakushuKingaku4(対象者_追加含む_情報.getDtKakushuKingaku4());
        tmpEntity.setUeT0511after_dtKakushuKingaku5(対象者_追加含む_情報.getDtKakushuKingaku5());
        tmpEntity.setUeT0511after_dtKakushuKingaku6(対象者_追加含む_情報.getDtKakushuKingaku6());
        tmpEntity.setUeT0511after_dtKakushuKingaku7(対象者_追加含む_情報.getDtKakushuKingaku7());
        tmpEntity.setUeT0511after_dtKakushuKingaku8(対象者_追加含む_情報.getDtKakushuKingaku8());
        tmpEntity.setUeT0511after_dtTeishiYM(対象者_追加含む_情報.getDtTeishiYM());
        tmpEntity.setUeT0511after_dtYobi4Juminzei(対象者_追加含む_情報.getDtYobi4Juminzei());
        tmpEntity.setUeT0511after_dtKojinNo(対象者_追加含む_情報.getDtKojinNo());
    }

    private void set対象者追加含む情報_更正前(UeT0511NenkinTokuchoKaifuJohoEntity 対象者_追加含む_情報,
            TmpHonsanteiTsuchishoTableEntity tmpEntity) {
        tmpEntity.setUeT0511_gyomuCode(対象者_追加含む_情報.getGyomuCode());
        tmpEntity.setUeT0511_shoriNendo(対象者_追加含む_情報.getShoriNendo());
        tmpEntity.setUeT0511_tsuchiNaiyoCode(対象者_追加含む_情報.getTsuchiNaiyoCode());
        tmpEntity.setUeT0511_shoriTaishoYM(対象者_追加含む_情報.getShoriTaishoYM());
        tmpEntity.setUeT0511_kisoNenkinNo(対象者_追加含む_情報.getKisoNenkinNo());
        tmpEntity.setUeT0511_nenkinCode(対象者_追加含む_情報.getNenkinCode());
        tmpEntity.setUeT0511_koseiCityCode(対象者_追加含む_情報.getKoseiCityCode());
        tmpEntity.setUeT0511_renban(対象者_追加含む_情報.getRenban());
        tmpEntity.setUeT0511_shoriTimestamp(対象者_追加含む_情報.getShoriTimestamp());
        tmpEntity.setUeT0511_renkeiShubetsu(対象者_追加含む_情報.getRenkeiShubetsu());
        tmpEntity.setUeT0511_hosokuTsuki(対象者_追加含む_情報.getHosokuTsuki());
        tmpEntity.setUeT0511_tenbikiTsuki(対象者_追加含む_情報.getTenbikiTsuki());
        tmpEntity.setUeT0511_shikibetsuCode(対象者_追加含む_情報.getShikibetsuCode());
        tmpEntity.setUeT0511_hihokenshaNo(対象者_追加含む_情報.getHihokenshaNo());
        tmpEntity.setUeT0511_kokuhoSetaiCode(対象者_追加含む_情報.getKokuhoSetaiCode());
        tmpEntity.setUeT0511_dtCityCode(対象者_追加含む_情報.getDtCityCode());
        tmpEntity.setUeT0511_dtTokubetsuChoshuGimushaCode(getCode(対象者_追加含む_情報.getDtTokubetsuChoshuGimushaCode()));
        tmpEntity.setUeT0511_dtTsuchiNaiyoCode(対象者_追加含む_情報.getDtTsuchiNaiyoCode());
        tmpEntity.setUeT0511_dtBaitaiCode(対象者_追加含む_情報.getDtBaitaiCode());
        tmpEntity.setUeT0511_dtTokubetsuChoshuSeidoCode(対象者_追加含む_情報.getDtTokubetsuChoshuSeidoCode());
        tmpEntity.setUeT0511_dtSakuseiYMD(対象者_追加含む_情報.getDtSakuseiYMD());
        tmpEntity.setUeT0511_dtKisoNenkinNo(対象者_追加含む_情報.getDtKisoNenkinNo());
        tmpEntity.setUeT0511_dtNenkinCode(対象者_追加含む_情報.getDtNenkinCode());
        tmpEntity.setUeT0511_dtYobi1(対象者_追加含む_情報.getDtYobi1());
        tmpEntity.setUeT0511_dtBirthDay(対象者_追加含む_情報.getDtBirthDay());
        tmpEntity.setUeT0511_dtSeibetsu(対象者_追加含む_情報.getDtSeibetsu());
        tmpEntity.setUeT0511_dtKanaShimei(対象者_追加含む_情報.getDtKanaShimei());
        tmpEntity.setUeT0511_dtShiftCode1(対象者_追加含む_情報.getDtShiftCode1());
        tmpEntity.setUeT0511_dtKanjiShimei(対象者_追加含む_情報.getDtKanjiShimei());
        tmpEntity.setUeT0511_dtShiftCode2(対象者_追加含む_情報.getDtShiftCode2());
        tmpEntity.setUeT0511_dtYubinNo(対象者_追加含む_情報.getDtYubinNo());
        tmpEntity.setUeT0511_dtKanaJusho(対象者_追加含む_情報.getDtKanaJusho());
        tmpEntity.setUeT0511_dtShiftCode3(対象者_追加含む_情報.getDtShiftCode3());
        tmpEntity.setUeT0511_dtKanjiJusho(対象者_追加含む_情報.getDtKanjiJusho());
        tmpEntity.setUeT0511_dtShiftCode4(対象者_追加含む_情報.getDtShiftCode4());
        tmpEntity.setUeT0511_dtKakushuKubun(対象者_追加含む_情報.getDtKakushuKubun());
        tmpEntity.setUeT0511_dtShoriKekka(対象者_追加含む_情報.getDtShoriKekka());
        tmpEntity.setUeT0511_dtKokiIkanCode(対象者_追加含む_情報.getDtKokiIkanCode());
        tmpEntity.setUeT0511_dtKakushuYMD(対象者_追加含む_情報.getDtKakushuYMD());
        tmpEntity.setUeT0511_dtKakushuKingaku1(対象者_追加含む_情報.getDtKakushuKingaku1());
        tmpEntity.setUeT0511_dtKakushuKingaku2(対象者_追加含む_情報.getDtKakushuKingaku2());
        tmpEntity.setUeT0511_dtKakushuKingaku3(対象者_追加含む_情報.getDtKakushuKingaku3());
        tmpEntity.setUeT0511_dtYobi2(対象者_追加含む_情報.getDtYobi2());
        tmpEntity.setUeT0511_dtKyosaiNenkinshoshoKigoNo(対象者_追加含む_情報.getDtKyosaiNenkinshoshoKigoNo());
        tmpEntity.setUeT0511_dtKakushuKingaku4(対象者_追加含む_情報.getDtKakushuKingaku4());
        tmpEntity.setUeT0511_dtKakushuKingaku5(対象者_追加含む_情報.getDtKakushuKingaku5());
        tmpEntity.setUeT0511_dtKakushuKingaku6(対象者_追加含む_情報.getDtKakushuKingaku6());
        tmpEntity.setUeT0511_dtKakushuKingaku7(対象者_追加含む_情報.getDtKakushuKingaku7());
        tmpEntity.setUeT0511_dtKakushuKingaku8(対象者_追加含む_情報.getDtKakushuKingaku8());
        tmpEntity.setUeT0511_dtTeishiYM(対象者_追加含む_情報.getDtTeishiYM());
        tmpEntity.setUeT0511_dtYobi4Juminzei(対象者_追加含む_情報.getDtYobi4Juminzei());
        tmpEntity.setUeT0511_dtKojinNo(対象者_追加含む_情報.getDtKojinNo());
    }

    private void set宛名の全項目(UaFt200FindShikibetsuTaishoEntity 宛名, TmpHonsanteiTsuchishoTableEntity tmpEntity) {

        tmpEntity.setShikibetsuTaisho_shikibetsuCode(宛名.getShikibetsuCode());
        tmpEntity.setShikibetsuTaisho_genLasdecCode(宛名.getGenLasdecCode());
        tmpEntity.setShikibetsuTaisho_kyuLasdecCode(宛名.getKyuLasdecCode());
        tmpEntity.setShikibetsuTaisho_kyuLasdecCodeRenban(宛名.getKyuLasdecCodeRenban());
        tmpEntity.setShikibetsuTaisho_gyomuCode(宛名.getGyomuCode());
        tmpEntity.setShikibetsuTaisho_rirekiNo(宛名.getRirekiNo());
        tmpEntity.setShikibetsuTaisho_currentFlag(宛名.getCurrentFlag());
        tmpEntity.setShikibetsuTaisho_juminShubetsuCode(宛名.getJuminShubetsuCode());
        tmpEntity.setShikibetsuTaisho_kojinNo(宛名.getKojinNo());
        tmpEntity.setShikibetsuTaisho_hojinNo(宛名.getHojinNo());
        tmpEntity.setShikibetsuTaisho_shoriYMD(宛名.getShoriYMD());
        tmpEntity.setShikibetsuTaisho_idoJiyuCode(宛名.getIdoJiyuCode());
        tmpEntity.setShikibetsuTaisho_idoYMD(宛名.getIdoYMD());
        tmpEntity.setShikibetsuTaisho_todokedeJiyuCode(宛名.getTodokedeJiyuCode());
        tmpEntity.setShikibetsuTaisho_todokedeYMD(宛名.getTodokedeYMD());
        tmpEntity.setShikibetsuTaisho_idoRiyuCode(宛名.getIdoRiyuCode());
        tmpEntity.setShikibetsuTaisho_meisho(宛名.getMeisho());
        tmpEntity.setShikibetsuTaisho_kanaMeisho(宛名.getKanaMeisho());
        tmpEntity.setShikibetsuTaisho_kannaiKangaiKubun(宛名.getKannaiKangaiKubun());
        tmpEntity.setShikibetsuTaisho_yubinNo(宛名.getYubinNo());
        tmpEntity.setShikibetsuTaisho_choikiCode(宛名.getChoikiCode());
        tmpEntity.setShikibetsuTaisho_zenkokuJushoCode(宛名.getZenkokuJushoCode());
        tmpEntity.setShikibetsuTaisho_jusho(宛名.getJusho());
        tmpEntity.setShikibetsuTaisho_banchiCode1(宛名.getBanchiCode1());
        tmpEntity.setShikibetsuTaisho_banchiCode2(宛名.getBanchiCode2());
        tmpEntity.setShikibetsuTaisho_banchiCode3(宛名.getBanchiCode3());
        tmpEntity.setShikibetsuTaisho_banchiCode4(宛名.getBanchiCode4());
        tmpEntity.setShikibetsuTaisho_banchi(宛名.getBanchi());
        tmpEntity.setShikibetsuTaisho_katagaki(宛名.getKatagaki());
        tmpEntity.setShikibetsuTaisho_katagakiInjiFlag(宛名.getKatagakiInjiFlag());
        tmpEntity.setShikibetsuTaisho_gyoseikuCode(宛名.getGyoseikuCode());
        tmpEntity.setShikibetsuTaisho_gyoseikuName(宛名.getGyoseikuName());
        tmpEntity.setShikibetsuTaisho_chikuCode1(宛名.getChikuCode1());
        tmpEntity.setShikibetsuTaisho_chikuName1(宛名.getChikuName1());
        tmpEntity.setShikibetsuTaisho_chikuCode2(宛名.getChikuCode2());
        tmpEntity.setShikibetsuTaisho_chikuName2(宛名.getChikuName2());
        tmpEntity.setShikibetsuTaisho_chikuCode3(宛名.getChikuCode3());
        tmpEntity.setShikibetsuTaisho_chikuName3(宛名.getChikuName3());
        tmpEntity.setShikibetsuTaisho_shogakkokuCode(宛名.getShogakkokuCode());
        tmpEntity.setShikibetsuTaisho_shogakkokuName(宛名.getShogakkokuName());
        tmpEntity.setShikibetsuTaisho_chugakkokuCode(宛名.getChugakkokuCode());
        tmpEntity.setShikibetsuTaisho_chugakkokuName(宛名.getChugakkokuName());
        tmpEntity.setShikibetsuTaisho_tohyokuCode(宛名.getTohyokuCode());
        tmpEntity.setShikibetsuTaisho_tohyokuName(宛名.getTohyokuName());
        tmpEntity.setShikibetsuTaisho_juminJotaiCode(宛名.getJuminJotaiCode());
        tmpEntity.setShikibetsuTaisho_setaiCode(宛名.getSetaiCode());
        tmpEntity.setShikibetsuTaisho_seinengappiYMD(宛名.getSeinengappiYMD());
        tmpEntity.setShikibetsuTaisho_seinengappiFushoKubun(宛名.getSeinengappiFushoKubun());
        tmpEntity.setShikibetsuTaisho_seibetsuCode(宛名.getSeibetsuCode());
        tmpEntity.setShikibetsuTaisho_tsuzukigaraCode(宛名.getTsuzukigaraCode());
        tmpEntity.setShikibetsuTaisho_tsuzukigara(宛名.getTsuzukigara());
        tmpEntity.setShikibetsuTaisho_kazokuNo(宛名.getKazokuNo());
        tmpEntity.setShikibetsuTaisho_juminhyoHyojijun(宛名.getJuminhyoHyojijun());
        tmpEntity.setShikibetsuTaisho_kikaYMD(宛名.getKikaYMD());
        tmpEntity.setShikibetsuTaisho_kanjiShimei(宛名.getKanjiShimei());
        tmpEntity.setShikibetsuTaisho_kanaShimei(宛名.getKanaShimei());
        tmpEntity.setShikibetsuTaisho_honsekiZenkokuJushoCode(宛名.getHonsekiZenkokuJushoCode());
        tmpEntity.setShikibetsuTaisho_honsekiChoikiCode(宛名.getHonsekiChoikiCode());
        tmpEntity.setShikibetsuTaisho_honsekiJusho(宛名.getHonsekiJusho());
        tmpEntity.setShikibetsuTaisho_honsekiBanchi(宛名.getHonsekiBanchi());
        tmpEntity.setShikibetsuTaisho_hittosha(宛名.getHittosha());
        tmpEntity.setShikibetsuTaisho_gaikokujinShimei(宛名.getGaikokujinShimei());
        tmpEntity.setShikibetsuTaisho_gaikokujinHeikimei(宛名.getGaikokujinHeikimei());
        tmpEntity.setShikibetsuTaisho_gaikokujinKanaShimei(宛名.getGaikokujinKanaShimei());
        tmpEntity.setShikibetsuTaisho_tsushomei(宛名.getTsushomei());
        tmpEntity.setShikibetsuTaisho_shimeiRiyoKubun(宛名.getShimeiRiyoKubun());
        tmpEntity.setShikibetsuTaisho_kanaTsushomei(宛名.getKanaTsushomei());
        tmpEntity.setShikibetsuTaisho_katakanaHyoki(宛名.getKatakanaHyoki());
        tmpEntity.setShikibetsuTaisho_kokusekiChiikiCode(宛名.getKokusekiChiikiCode());
        tmpEntity.setShikibetsuTaisho_zairyuShikakuCode(宛名.getZairyuShikakuCode());
        tmpEntity.setShikibetsuTaisho_zairyuKikanCode(宛名.getZairyuKikanCode());
        tmpEntity.setShikibetsuTaisho_zairyuKikantoManryoYMD(宛名.getZairyuKikantoManryoYMD());
        tmpEntity.setShikibetsuTaisho_zairyuCardtoNo(宛名.getZairyuCardtoNo());
        tmpEntity.setShikibetsuTaisho_zairyuCardtoYukoYMD(宛名.getZairyuCardtoYukoYMD());
        tmpEntity.setShikibetsuTaisho_dai30Jono45niKiteisuruKubun(宛名.getDai30Jono45niKiteisuruKubun());
        tmpEntity.setShikibetsuTaisho_setainushiShikibetsuCode(宛名.getSetainushiShikibetsuCode());
        tmpEntity.setShikibetsuTaisho_setainushiMei(宛名.getSetainushiMei());
        tmpEntity.setShikibetsuTaisho_hojinKeitaiCode(宛名.getHojinKeitaiCode());
        tmpEntity.setShikibetsuTaisho_hojinKeitaiMeisho(宛名.getHojinKeitaiMeisho());
        tmpEntity.setShikibetsuTaisho_hojinKeitaiRyakusho(宛名.getHojinKeitaiRyakusho());
        tmpEntity.setShikibetsuTaisho_hojinMeishoHenshuKubun(宛名.getHojinMeishoHenshuKubun());
        tmpEntity.setShikibetsuTaisho_hojinKeitaiRyakushoKubun(宛名.getHojinKeitaiRyakushoKubun());
        tmpEntity.setShikibetsuTaisho_hojinMeisho(宛名.getHojinMeisho());
        tmpEntity.setShikibetsuTaisho_hojinKanaMeisho(宛名.getHojinKanaMeisho());
        tmpEntity.setShikibetsuTaisho_hojinShitenMeisho(宛名.getHojinShitenMeisho());
        tmpEntity.setShikibetsuTaisho_hojinShitenKanaMeisho(宛名.getHojinShitenKanaMeisho());
        tmpEntity.setShikibetsuTaisho_daihyoshaShikibetsuCode(宛名.getDaihyoshaShikibetsuCode());
        tmpEntity.setShikibetsuTaisho_daihyoshaJuminShubetsu(宛名.getDaihyoshaJuminShubetsu());
        tmpEntity.setShikibetsuTaisho_daihyoshaShimei(宛名.getDaihyoshaShimei());
        tmpEntity.setShikibetsuTaisho_daihyoshaKanaShimei(宛名.getDaihyoshaKanaShimei());
        tmpEntity.setShikibetsuTaisho_daihyoshaNihonjinShimei(宛名.getDaihyoshaNihonjinShimei());
        tmpEntity.setShikibetsuTaisho_daihyoshaNihonjinKanaShimei(宛名.getDaihyoshaNihonjinKanaShimei());
        tmpEntity.setShikibetsuTaisho_daihyoshaGaikokujinShimei(宛名.getDaihyoshaGaikokujinHeikimei());
        tmpEntity.setShikibetsuTaisho_daihyoshaGaikokujinHeikimei(宛名.getDaihyoshaGaikokujinHeikimei());
        tmpEntity.setShikibetsuTaisho_daihyoshaGaikokujinKanaShimei(宛名.getDaihyoshaGaikokujinKanaShimei());
        tmpEntity.setShikibetsuTaisho_daihyoshaTsushomei(宛名.getDaihyoshaTsushomei());
        tmpEntity.setShikibetsuTaisho_daihyoshaShimeiRiyoKubun(宛名.getDaihyoshaShimeiRiyoKubun());
        tmpEntity.setShikibetsuTaisho_daihyoshaKanaTsushomei(宛名.getDaihyoshaKanaTsushomei());
        tmpEntity.setShikibetsuTaisho_daihyoshaKannaiKangaiKubun(宛名.getDaihyoshaKannaiKangaiKubun());
        tmpEntity.setShikibetsuTaisho_daihyoshaYubinNo(宛名.getDaihyoshaYubinNo());
        tmpEntity.setShikibetsuTaisho_daihyoshaChoikiCode(宛名.getDaihyoshaChoikiCode());
        tmpEntity.setShikibetsuTaisho_daihyoshaZenkokuJushoCode(宛名.getDaihyoshaZenkokuJushoCode());
        tmpEntity.setShikibetsuTaisho_daihyoshaJusho(宛名.getDaihyoshaJusho());
        tmpEntity.setShikibetsuTaisho_daihyoshaBanchiCode1(宛名.getDaihyoshaBanchiCode1());
        tmpEntity.setShikibetsuTaisho_daihyoshaBanchiCode2(宛名.getDaihyoshaBanchiCode2());
        tmpEntity.setShikibetsuTaisho_daihyoshaBanchiCode3(宛名.getDaihyoshaBanchiCode3());
        tmpEntity.setShikibetsuTaisho_daihyoshaBanchiCode4(宛名.getDaihyoshaBanchiCode4());
        tmpEntity.setShikibetsuTaisho_daihyoshaBanchi(宛名.getDaihyoshaBanchi());
        tmpEntity.setShikibetsuTaisho_daihyoshaKatagaki(宛名.getDaihyoshaKatagaki());
        tmpEntity.setShikibetsuTaisho_ninkachiendantaiTorokuShikakuKubun(宛名.getNinkachiendantaiTorokuShikakuKubun());
        tmpEntity.setShikibetsuTaisho_ninkachiendantaiNinkaYMD(宛名.getNinkachiendantaiNinkaYMD());
        tmpEntity.setShikibetsuTaisho_kojinHojinKBN(宛名.getKojinHojinKBN());
        tmpEntity.setShikibetsuTaisho_kyoyushaMeisho(宛名.getKyoyushaMeisho());
        tmpEntity.setShikibetsuTaisho_kyoyushaKanaMeisho(宛名.getKyoyushaKanaMeisho());
        tmpEntity.setShikibetsuTaisho_torokuJiyuCode(宛名.getTorokuJiyuCode());
        tmpEntity.setShikibetsuTaisho_torokuIdoYMD(宛名.getTorokuIdoYMD());
        tmpEntity.setShikibetsuTaisho_torokuTodokedeYMD(宛名.getTorokuTodokedeYMD());
        tmpEntity.setShikibetsuTaisho_juteiJiyuCode(宛名.getJuteiJiyuCode());
        tmpEntity.setShikibetsuTaisho_juteiIdoYMD(宛名.getJuteiIdoYMD());
        tmpEntity.setShikibetsuTaisho_juteiTodokedeYMD(宛名.getJuteiTodokedeYMD());
        tmpEntity.setShikibetsuTaisho_shojoJiyuCode(宛名.getShojoJiyuCode());
        tmpEntity.setShikibetsuTaisho_shojoIdoYMD(宛名.getShojoIdoYMD());
        tmpEntity.setShikibetsuTaisho_shojoTodokedeYMD(宛名.getShojoTodokedeYMD());
        tmpEntity.setShikibetsuTaisho_jutonaiYubinNo(宛名.getJutonaiYubinNo());
        tmpEntity.setShikibetsuTaisho_jutonaiChoikiCode(宛名.getJutonaiChoikiCode());
        tmpEntity.setShikibetsuTaisho_jutonaiJusho(宛名.getJutonaiJusho());
        tmpEntity.setShikibetsuTaisho_jutonaiBanchiCode1(宛名.getJutonaiBanchiCode1());
        tmpEntity.setShikibetsuTaisho_jutonaiBanchiCode2(宛名.getJutonaiBanchiCode2());
        tmpEntity.setShikibetsuTaisho_jutonaiBanchiCode3(宛名.getJutonaiBanchiCode3());
        tmpEntity.setShikibetsuTaisho_jutonaiBanchiCode4(宛名.getJutonaiBanchiCode4());
        tmpEntity.setShikibetsuTaisho_jutonaiBanchi(宛名.getJutonaiBanchi());
        tmpEntity.setShikibetsuTaisho_jutonaiKatagaki(宛名.getJutonaiKatagaki());
        tmpEntity.setShikibetsuTaisho_jutonaiKatagakiInjiFlag(宛名.getJutonaiKatagakiInjiFlag());
        tmpEntity.setShikibetsuTaisho_tennyumaeYubinNo(宛名.getTennyumaeYubinNo());
        tmpEntity.setShikibetsuTaisho_tennyumaeZenkokuJushoCode(宛名.getTennyumaeZenkokuJushoCode());
        tmpEntity.setShikibetsuTaisho_tennyumaeJusho(宛名.getTennyumaeJusho());
        tmpEntity.setShikibetsuTaisho_tennyumaeBanchi(宛名.getTennyumaeBanchi());
        set宛名の全項目_部分(宛名, tmpEntity);
    }

    private void set宛名の全項目_部分(UaFt200FindShikibetsuTaishoEntity 宛名, TmpHonsanteiTsuchishoTableEntity tmpEntity) {
        tmpEntity.setShikibetsuTaisho_tennyumaeKatagaki(宛名.getTennyumaeKatagaki());
        tmpEntity.setShikibetsuTaisho_tennyumaeSetainushimei(宛名.getTennyumaeSetainushimei());
        tmpEntity.setShikibetsuTaisho_tennyumaeKyusei(宛名.getTennyumaeKyusei());
        tmpEntity.setShikibetsuTaisho_saishuJutochiYubinNo(宛名.getSaishuJutochiYubinNo());
        tmpEntity.setShikibetsuTaisho_saishuJutochiZenkokuJushoCode(宛名.getSaishuJutochiZenkokuJushoCode());
        tmpEntity.setShikibetsuTaisho_saishuJutochiJusho(宛名.getSaishuJutochiJusho());
        tmpEntity.setShikibetsuTaisho_saishuJutochiBanchi(宛名.getSaishuJutochiBanchi());
        tmpEntity.setShikibetsuTaisho_saishuJutochiKatagaki(宛名.getSaishuJutochiKatagaki());
        tmpEntity.setShikibetsuTaisho_saishuJutochiSetainushimei(宛名.getSaishuJutochiSetainushimei());
        tmpEntity.setShikibetsuTaisho_tenshutsuYoteiIdoYMD(宛名.getTenshutsuYoteiIdoYMD());
        tmpEntity.setShikibetsuTaisho_tenshutsuYoteiYubinNo(宛名.getTenshutsuKakuteiYubinNo());
        tmpEntity.setShikibetsuTaisho_tenshutsuYoteiZenkokuJushoCode(宛名.getTenshutsuYoteiZenkokuJushoCode());
        tmpEntity.setShikibetsuTaisho_tenshutsuYoteiJusho(宛名.getTenshutsuYoteiJusho());
        tmpEntity.setShikibetsuTaisho_tenshutsuYoteiBanchi(宛名.getTenshutsuYoteiBanchi());
        tmpEntity.setShikibetsuTaisho_tenshutsuYoteiKatagaki(宛名.getTenshutsuKakuteiKatagaki());
        tmpEntity.setShikibetsuTaisho_tenshutsuYoteiSetainushimei(宛名.getTenshutsuYoteiSetainushimei());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiIdoYMD(宛名.getTenshutsuKakuteiIdoYMD());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiTsuchiYMD(宛名.getTenshutsuKakuteiTsuchiYMD());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiYubinNo(宛名.getTenshutsuKakuteiYubinNo());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiZenkokuJushoCode(宛名.getTenshutsuKakuteiZenkokuJushoCode());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiJusho(宛名.getTenshutsuKakuteiJusho());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiBanchi(宛名.getTenshutsuKakuteiBanchi());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiKatagaki(宛名.getTenshutsuKakuteiKatagaki());
        tmpEntity.setShikibetsuTaisho_tenshutsuKakuteiSetainushimei(宛名.getTenshutsuKakuteiSetainushimei());
        tmpEntity.setShikibetsuTaisho_juminhyoUtsushiHakkoSeigyoKubun(宛名.getJuminhyoUtsushiHakkoSeigyoKubun());
        tmpEntity.setShikibetsuTaisho_renrakusaki1(宛名.getRenrakusaki1());
        tmpEntity.setShikibetsuTaisho_kensakuRenrakusaki1(宛名.getKensakuRenrakusaki1());
        tmpEntity.setShikibetsuTaisho_renrakusakiKubun1(宛名.getRenrakusakiKubun1());
        tmpEntity.setShikibetsuTaisho_renrakusaki2(宛名.getRenrakusaki2());
        tmpEntity.setShikibetsuTaisho_kensakuRenrakusaki2(宛名.getKensakuRenrakusaki2());
        tmpEntity.setShikibetsuTaisho_renrakusakiKubun2(宛名.getRenrakusakiKubun2());
        tmpEntity.setShikibetsuTaisho_renrakusaki3(宛名.getRenrakusaki3());
        tmpEntity.setShikibetsuTaisho_kensakuRenrakusaki3(宛名.getKensakuRenrakusaki3());
        tmpEntity.setShikibetsuTaisho_renrakusakiKubun3(宛名.getRenrakusakiKubun3());
        tmpEntity.setShikibetsuTaisho_mailAddress(宛名.getMailAddress());
        tmpEntity.setShikibetsuTaisho_biko(宛名.getBiko());
        tmpEntity.setShikibetsuTaisho_kanaName(宛名.getKanaName());
        tmpEntity.setShikibetsuTaisho_gaikokujinKanaName(宛名.getGaikokujinKanaName());
        tmpEntity.setShikibetsuTaisho_kanaTsushoName(宛名.getKanaTsushoName());
        tmpEntity.setShikibetsuTaisho_jutogaiKanriUpdateCount(宛名.getJutogaiKanriUpdateCount());
        tmpEntity.setShikibetsuTaisho_jutogaiKanriTorokuNo(宛名.getJutogaiGaikokujinTorokuNo());
        tmpEntity.setShikibetsuTaisho_jutogaiKojinKihonUpdateCount(宛名.getJutogaiKojinKihonUpdateCount());
        tmpEntity.setShikibetsuTaisho_jutogaiKojinKihonTorokuNo(宛名.getJutogaiKojinKihonTorokuNo());
        tmpEntity.setShikibetsuTaisho_jutogaiNihonjinUpdateCount(宛名.getJutogaiNihonjinUpdateCount());
        tmpEntity.setShikibetsuTaisho_jutogaiNihonjinTorokuNo(宛名.getJutogaiNihonjinTorokuNo());
        tmpEntity.setShikibetsuTaisho_jutogaiGaikokujinUpdateCount(宛名.getJutogaiKojinKihonUpdateCount());
        tmpEntity.setShikibetsuTaisho_jutogaiGaikokujinTorokuNo(宛名.getJutogaiKojinKihonTorokuNo());
        tmpEntity.setShikibetsuTaisho_hojinUpdateCount(宛名.getHojinUpdateCount());
        tmpEntity.setShikibetsuTaisho_hojinTorokuNo(宛名.getHojinTorokuNo());
        tmpEntity.setShikibetsuTaisho_kyoyushaUpdateCount(宛名.getKyoyushaUpdateCount());
        tmpEntity.setShikibetsuTaisho_kyoyushaTorokuNo(宛名.getKyoyushaTorokuNo());
        tmpEntity.setShikibetsuTaisho_shimeiSearchTorokuNo(宛名.getShimeiSearchTorokuNo());
        tmpEntity.setShikibetsuTaisho_yusenShimeiUpdateCount(宛名.getYusenShimeiUpdateCount());
        tmpEntity.setShikibetsuTaisho_yusenShimeiTimestamp(宛名.getYusenShimeiTimestamp());
    }

    private void set宛先の全項目(UaFt250FindAtesakiEntity 宛先, TmpHonsanteiTsuchishoTableEntity tmpEntity) {
        tmpEntity.setAtesaki_shikibetsuCode(宛先.getShikibetsuCode());
        tmpEntity.setAtesaki_atesakiShubetsu(宛先.getAtesakiShubetsu());
        tmpEntity.setAtesaki_gyomubetsuPrimaryKey(宛先.getGyomubetsuPrimaryKey());
        tmpEntity.setAtesaki_gyomuCode(宛先.getGyomuCode());
        tmpEntity.setAtesaki_subGyomuCode(宛先.getSubGyomuCode());
        tmpEntity.setAtesaki_gyomuGroupCode(宛先.getGyomuGroupCode());
        tmpEntity.setAtesaki_gyomuGroupName(宛先.getGyomuGroupName());
        tmpEntity.setAtesaki_subGyomuGroupCode(宛先.getSubGyomuGroupCode());
        tmpEntity.setAtesaki_subGyomuGroupName(宛先.getSubGyomuGroupName());
        tmpEntity.setAtesaki_kamokuCode(宛先.getKamokuCode());
        tmpEntity.setAtesaki_gyomuKoyuKey(宛先.getGyomuKoyuKey());
        tmpEntity.setAtesaki_kannaiKangaiKubun(宛先.getKannaiKangaiKubun());
        tmpEntity.setAtesaki_zenkokuJushoCode(宛先.getZenkokuJushoCode());
        tmpEntity.setAtesaki_choikiCode(宛先.getChoikiCode());
        tmpEntity.setAtesaki_jusho(宛先.getJusho());
        tmpEntity.setAtesaki_yubinNo(宛先.getYubinNo());
        tmpEntity.setAtesaki_banchiCode1(宛先.getBanchiCode1());
        tmpEntity.setAtesaki_banchiCode2(宛先.getBanchiCode2());
        tmpEntity.setAtesaki_banchiCode3(宛先.getBanchiCode3());
        tmpEntity.setAtesaki_banchiCode4(宛先.getBanchiCode4());
        tmpEntity.setAtesaki_banchi(宛先.getBanchi());
        tmpEntity.setAtesaki_katagakiInjiFlag(宛先.getKatagakiInjiFlag());
        tmpEntity.setAtesaki_katagaki(宛先.getKatagaki());
        tmpEntity.setAtesaki_gyoseikuCode(宛先.getGyoseikuCode());
        tmpEntity.setAtesaki_gyoseiku(宛先.getGyoseiku());
        tmpEntity.setAtesaki_chikuCode1(宛先.getChikuCode1());
        tmpEntity.setAtesaki_chiku1(宛先.getChiku1());
        tmpEntity.setAtesaki_chikuCode2(宛先.getChikuCode2());
        tmpEntity.setAtesaki_chiku2(宛先.getChiku2());
        tmpEntity.setAtesaki_chikuCode3(宛先.getChikuCode3());
        tmpEntity.setAtesaki_chiku3(宛先.getChiku3());
        tmpEntity.setAtesaki_juminShubetsuCode(宛先.getJuminShubetsuCode());
        tmpEntity.setAtesaki_juminJotaiCode(宛先.getJuminJotaiCode());
        tmpEntity.setAtesaki_kanjiShimei(宛先.getKanjiShimei());
        tmpEntity.setAtesaki_kanaShimei(宛先.getKanaShimei());
        tmpEntity.setAtesaki_gaikokujinShimei(宛先.getGaikokujinShimei());
        tmpEntity.setAtesaki_gaikokujinHeikimei(宛先.getGaikokujinHeikimei());
        tmpEntity.setAtesaki_gaikokujinKanaShimei(宛先.getGaikokujinKanaShimei());
        tmpEntity.setAtesaki_tsushomei(宛先.getTsushomei());
        tmpEntity.setAtesaki_kanaTsushomei(宛先.getKanaTsushomei());
        tmpEntity.setAtesaki_shimeiRiyoKubun(宛先.getShimeiRiyoKubun());
        tmpEntity.setAtesaki_kyoyushaMeisho(宛先.getKyoyushaMeisho());
        tmpEntity.setAtesaki_kyoyushaKanaMeisho(宛先.getKyoyushaKanaMeisho());
        tmpEntity.setAtesaki_hojinKeitaiCode(宛先.getHojinKeitaiCode());
        tmpEntity.setAtesaki_hojinMeiHenshuKubun(宛先.getHojinMeiHenshuKubun());
        tmpEntity.setAtesaki_hojinKeitaiRyakushoKubun(宛先.getHojinKeitaiRyakushoKubun());
        tmpEntity.setAtesaki_hojinMeisho(宛先.getHojinMeisho());
        tmpEntity.setAtesaki_hojinKanaMeisho(宛先.getHojinKanaMeisho());
        tmpEntity.setAtesaki_hojinShitenMeisho(宛先.getHojinShitenMeisho());
        tmpEntity.setAtesaki_hojinShitenKanaMeisho(宛先.getHojinKanaMeisho());
        tmpEntity.setAtesaki_sofusakiMeisho(宛先.getHojinMeisho());
        tmpEntity.setAtesaki_sofusakiKanaMeisho(宛先.getSofusakiKanaMeisho());
        tmpEntity.setAtesaki_renrakusaki1(宛先.getRenrakusaki1());
        tmpEntity.setAtesaki_renrakusakiKubun1(宛先.getRenrakusakiKubun1());
        tmpEntity.setAtesaki_renrakusaki2(宛先.getRenrakusaki2());
        tmpEntity.setAtesaki_renrakusakiKubun2(宛先.getRenrakusakiKubun2());
        tmpEntity.setAtesaki_renrakusaki3(宛先.getRenrakusaki3());
        tmpEntity.setAtesaki_renrakusakiKubun3(宛先.getRenrakusakiKubun3());
        tmpEntity.setAtesaki_mailAddress(宛先.getMailAddress());
        tmpEntity.setAtesaki_dainoKankeiCode(宛先.getDainoKankeiCode());
        tmpEntity.setAtesaki_biko(宛先.getBiko());
        tmpEntity.setAtesaki_honninJuminShubetsuCode(宛先.getHonninJuminShubetsuCode());
        tmpEntity.setAtesaki_honninJuminJotaiCode(宛先.getHonninJuminJotaiCode());
        tmpEntity.setAtesaki_honninKanjiShimei(宛先.getHonninKanjiShimei());
        tmpEntity.setAtesaki_honninKanaShimei(宛先.getHonninKanaShimei());
        tmpEntity.setAtesaki_honninGaikokujinShimei(宛先.getHonninGaikokujinHeikimei());
        tmpEntity.setAtesaki_honninGaikokujinHeikimei(宛先.getHonninGaikokujinHeikimei());
        tmpEntity.setAtesaki_honninGaikokujinKanaShimei(宛先.getHonninGaikokujinKanaShimei());
        tmpEntity.setAtesaki_honninTsushomei(宛先.getHonninTsushomei());
        tmpEntity.setAtesaki_honninKanaTsushomei(宛先.getHonninKanaTsushomei());
        tmpEntity.setAtesaki_honninShimeiRiyoKubun(宛先.getHonninShimeiRiyoKubun());
        tmpEntity.setAtesaki_honninKyoyushaMeisho(宛先.getHonninKyoyushaMeisho());
        tmpEntity.setAtesaki_honninKyoyushaKanaMeisho(宛先.getHonninKyoyushaKanaMeisho());
        tmpEntity.setAtesaki_honninHojinKeitaiCode(宛先.getHonninHojinKeitaiCode());
        tmpEntity.setAtesaki_honninHojinMeiHenshuKubun(宛先.getHonninHojinMeiHenshuKubun());
        tmpEntity.setAtesaki_honninHojinKeitaiRyakushoKubun(宛先.getHonninHojinKeitaiRyakushoKubun());
        tmpEntity.setAtesaki_honninHojinMeisho(宛先.getHonninHojinMeisho());
        tmpEntity.setAtesaki_honninHojinKanaMeisho(宛先.getHonninHojinKanaMeisho());
        tmpEntity.setAtesaki_honninHojinShitenMeisho(宛先.getHojinShitenMeisho());
        tmpEntity.setAtesaki_honninHojinShitenKanaMeisho(宛先.getHonninHojinKanaMeisho());
        tmpEntity.setAtesaki_honninDaihyoshaShikibetsuCode(宛先.getHonninDaihyoshaShikibetsuCode());
        tmpEntity.setAtesaki_honninDaihyoshaJuminShubetsuCode(宛先.getHonninDaihyoshaJuminShubetsuCode());
        tmpEntity.setAtesaki_honninDaihyoshaShimei(宛先.getHonninDaihyoshaShimei());
        tmpEntity.setAtesaki_honninDaihyoshaKanaShimei(宛先.getHonninDaihyoshaKanaShimei());
        tmpEntity.setAtesaki_honninDaihyoshaNihonjinShimei(宛先.getHonninDaihyoshaNihonjinShimei());
        tmpEntity.setAtesaki_honninDaihyoshaNihonjinKanaShimei(宛先.getHonninDaihyoshaNihonjinKanaShimei());
        tmpEntity.setAtesaki_honninDaihyoshaGaikokujinShimei(宛先.getHonninDaihyoshaGaikokujinShimei());
        tmpEntity.setAtesaki_honninDaihyoshaGaikokujinHeikimei(宛先.getHonninDaihyoshaGaikokujinHeikimei());
        tmpEntity.setAtesaki_honninDaihyoshaGaikokujinKanaShimei(宛先.getHonninDaihyoshaGaikokujinKanaShimei());
        tmpEntity.setAtesaki_honninDaihyoshaTsushomei(宛先.getHonninDaihyoshaTsushomei());
        tmpEntity.setAtesaki_honninDaihyoshaShimeiRiyoKubun(宛先.getHonninDaihyoshaShimeiRiyoKubun());
        tmpEntity.setAtesaki_honninDaihyoshaKanaTsushomei(宛先.getHonninDaihyoshaKanaTsushomei());
        tmpEntity.setAtesaki_setainushiShikibetsuCode(宛先.getSetainushiShikibetsuCode());
        tmpEntity.setAtesaki_setainushiKannaiKangaiKubun(宛先.getSetainushiKannaiKangaiKubun());
        tmpEntity.setAtesaki_setainushiZenkokuJushoCode(宛先.getSetainushiZenkokuJushoCode());
        tmpEntity.setAtesaki_setainushiChoikiCode(宛先.getSetainushiChoikiCode());
        tmpEntity.setAtesaki_setainushiJusho(宛先.getSetainushiJusho());
        tmpEntity.setAtesaki_setainushiYubinNo(宛先.getSetainushiYubinNo());
        tmpEntity.setAtesaki_setainushiBanchiCode1(宛先.getSetainushiBanchiCode1());
        tmpEntity.setAtesaki_setainushiBanchiCode2(宛先.getSetainushiBanchiCode2());
        tmpEntity.setAtesaki_setainushiBanchiCode3(宛先.getSetainushiBanchiCode3());
        tmpEntity.setAtesaki_setainushiBanchiCode4(宛先.getSetainushiBanchiCode4());
        tmpEntity.setAtesaki_setainushiBanchi(宛先.getSetainushiBanchi());
        tmpEntity.setAtesaki_setainushiKatagakiInjiFlag(宛先.getSetainushiKatagakiInjiFlag());
        tmpEntity.setAtesaki_setainushiKatagaki(宛先.getSetainushiKatagaki());
        tmpEntity.setAtesaki_setainushiGyoseikuCode(宛先.getSetainushiGyoseikuCode());
        tmpEntity.setAtesaki_setainushiGyoseikuName(宛先.getSetainushiGyoseikuName());
        tmpEntity.setAtesaki_setainushiChikuCode1(宛先.getSetainushiChikuCode1());
        tmpEntity.setAtesaki_setainushiChiku1(宛先.getSetainushiChiku1());
        tmpEntity.setAtesaki_setainushiChikuCode2(宛先.getSetainushiChikuCode2());
        tmpEntity.setAtesaki_setainushiChiku2(宛先.getSetainushiChiku2());
        tmpEntity.setAtesaki_setainushiChikuCode3(宛先.getSetainushiChikuCode3());
        tmpEntity.setAtesaki_setainushiChiku3(宛先.getSetainushiChiku3());
        tmpEntity.setAtesaki_setainushiJuminShubetsuCode(宛先.getSetainushiJuminJotaiCode());
        tmpEntity.setAtesaki_setainushiJuminJotaiCode(宛先.getSetainushiJuminJotaiCode());
        tmpEntity.setAtesaki_setainushiKanjiShimei(宛先.getSetainushiKanjiShimei());
        tmpEntity.setAtesaki_setainushiKanaShimei(宛先.getSetainushiKanaShimei());
        tmpEntity.setAtesaki_setainushiGaikokujinShimei(宛先.getSetainushiGaikokujinShimei());
        tmpEntity.setAtesaki_setainushiGaikokujinHeikimei(宛先.getSetainushiGaikokujinHeikimei());
        tmpEntity.setAtesaki_setainushiGaikokujinKanaShimei(宛先.getSetainushiGaikokujinKanaShimei());
        tmpEntity.setAtesaki_setainushiTsushomei(宛先.getSetainushiTsushomei());
        tmpEntity.setAtesaki_setainushiKanaTsushomei(宛先.getSetainushiKanaTsushomei());
        tmpEntity.setAtesaki_setainushiShimeiRiyoKubun(宛先.getSetainushiShimeiRiyoKubun());
        tmpEntity.setAtesaki_setainushiRenrakusaki1(宛先.getSetainushiRenrakusaki1());
        tmpEntity.setAtesaki_setainushiRenrakusakiKubun1(宛先.getSetainushiRenrakusakiKubun1());
        tmpEntity.setAtesaki_setainushiRenrakusaki2(宛先.getSetainushiRenrakusaki2());
        tmpEntity.setAtesaki_setainushiRenrakusakiKubun2(宛先.getSetainushiRenrakusakiKubun2());
        tmpEntity.setAtesaki_setainushiRenrakusaki3(宛先.getSetainushiRenrakusaki3());
        tmpEntity.setAtesaki_setainushiRenrakusakiKubun3(宛先.getSetainushiRenrakusakiKubun3());
        tmpEntity.setAtesaki_setainushiMailAddress(宛先.getSetainushiMailAddress());
        tmpEntity.setAtesaki_dainoninShikibetsuCode(宛先.getDainoninShikibetsuCode());
        tmpEntity.setAtesaki_honninSetaiCode(宛先.getHonninSetaiCode());
        tmpEntity.setAtesaki_dainoninSetaiCode(宛先.getDainoninSetaiCode());
    }

    private void set納組情報の全項目(CaFt703FindNokumiEntity 納組, TmpHonsanteiTsuchishoTableEntity tmpEntity) {

        CaT0714SeikyuHohoEntity cat0714Entity = 納組.getSeikyuHoho();
        tmpEntity.setCaT0714shikibetsuCode(cat0714Entity.getShikibetsuCode());
        tmpEntity.setCaT0714gyomubetsuPrimaryKey(cat0714Entity.getGyomubetsuPrimaryKey());
        tmpEntity.setCaT0714gyomuKoyuKey(cat0714Entity.getGyomuKoyuKey());
        tmpEntity.setCaT0714shiharaiHoho(cat0714Entity.getShiharaiHoho());
        tmpEntity.setCaT0714zennoKubun(cat0714Entity.getZennoKubun());
        tmpEntity.setCaT0714creditKeizokuTorokuKey(cat0714Entity.getCreditKeizokuTorokuKey());
        tmpEntity.setCaT0714kaishiYMD(cat0714Entity.getKaishiYMD());
        tmpEntity.setCaT0714shuryoYMD(cat0714Entity.getShuryoYMD());
        tmpEntity.setCaT0714nokumiShurui(cat0714Entity.getNokumiShurui());
        tmpEntity.setCaT0714nokumiCode(cat0714Entity.getNokumiCode());

        CaT0752NokumiEntity cat0725Entity = 納組.getNokumi();
        tmpEntity.setCaT0752meisho(cat0725Entity.getMeisho());
        tmpEntity.setCaT0752kanaMeisho(cat0725Entity.getKanaMeisho());
        tmpEntity.setCaT0752kensakuyoKanaMeisho(cat0725Entity.getKensakuyoKanaMeisho());
        tmpEntity.setCaT0752daihyoshaShikibetsuCode(cat0725Entity.getDaihyoshaShikibetsuCode());
        tmpEntity.setCaT0752daihyoshaShimei(cat0725Entity.getDaihyoshaShimei());
    }

    private void set口座情報の全項目(TokuteiKozaRelateEntity 特定口座, TmpHonsanteiTsuchishoTableEntity tmpEntity) {

        UaT0310KozaEntity uat0310Entity = 特定口座.getUaT0310KozaEntity();
        tmpEntity.setUaT0310Koza_kozaId(uat0310Entity.getKozaId());
        tmpEntity.setUaT0310Koza_shikibetsuCode(uat0310Entity.getShikibetsuCode());
        tmpEntity.setUaT0310Koza_gyomubetsuPrimaryKey(uat0310Entity.getGyomubetsuPrimaryKey());
        tmpEntity.setUaT0310Koza_gyomuKoyuKey(uat0310Entity.getGyomuKoyuKey());
        tmpEntity.setUaT0310Koza_yotoKubun(uat0310Entity.getYotoKubun().getColumnValue());
        tmpEntity.setUaT0310Koza_torokuRenban(uat0310Entity.getTorokuRenban());
        tmpEntity.setUaT0310Koza_kaishiYMD(uat0310Entity.getKaishiYMD());
        tmpEntity.setUaT0310Koza_shuryoYMD(uat0310Entity.getShuryoYMD());
        tmpEntity.setUaT0310Koza_kinyuKikanCode(uat0310Entity.getKinyuKikanCode());
        tmpEntity.setUaT0310Koza_kinyuKikanShitenCode(uat0310Entity.getKinyuKikanShitenCode());
        tmpEntity.setUaT0310Koza_yokinShubetsu(uat0310Entity.getYokinShubetsu());
        tmpEntity.setUaT0310Koza_kozaNo(uat0310Entity.getKozaNo());
        tmpEntity.setUaT0310Koza_tsuchoKigo(uat0310Entity.getTsuchoKigo());
        tmpEntity.setUaT0310Koza_tsuchoNo(uat0310Entity.getTsuchoNo());
        tmpEntity.setUaT0310Koza_kozaMeigininShikibetsuCode(uat0310Entity.getKozaMeigininShikibetsuCode());
        tmpEntity.setUaT0310Koza_kozaMeiginin(uat0310Entity.getKozaMeiginin());
        tmpEntity.setUaT0310Koza_kozaMeigininKanji(uat0310Entity.getKozaMeigininKanji());
        tmpEntity.setUaT0310Koza_kensakuyoMeiginin(uat0310Entity.getKensakuyoMeiginin());
        tmpEntity.setUaT0310Koza_kozaHyojiKubun(uat0310Entity.getKozaHyojiKubun());
        tmpEntity.setUaT0310Koza_nayoseKubun(uat0310Entity.getNayoseKubun());
        tmpEntity.setUaT0310Koza_zumitsuHakkoYohi(uat0310Entity.getZumitsuHakkoYohi());
        tmpEntity.setUaT0310Koza_kozaFurikaeKaishiTsuchiHakkozumi(uat0310Entity.getKozaFurikaeKaishiTsuchiHakkozumi());
        tmpEntity.setUaT0310Koza_kozaTorokuNo(uat0310Entity.getKozaTorokuNo());
        tmpEntity.setUaT0310Koza_kozaTorokuKubunCode(uat0310Entity.getKozaTorokuKubunCode().getColumnValue());
        tmpEntity.setUaT0310Koza_kozaKaishiUketsukeYMD(uat0310Entity.getKozaKaishiUketsukeYMD());
        tmpEntity.setUaT0310Koza_kozaShuryoUketsukeYMD(uat0310Entity.getKozaShuryoUketsukeYMD());
        tmpEntity.setUaT0310Koza_kozaTorokuYMD(uat0310Entity.getKozaTorokuYMD());
        tmpEntity.setUaT0310Koza_temban(uat0310Entity.getTemban());

        UaT0302KinyuKikanEntity uat0302Entity = 特定口座.getKinyuKikanEntity();
        tmpEntity.setUaT0302KinyuKikan_kinyuKikanCode(uat0302Entity.getKinyuKikanCode());
        tmpEntity.setUaT0302KinyuKikan_kaishiYMD(uat0302Entity.getKaishiYMD());
        tmpEntity.setUaT0302KinyuKikan_shuryoYMD(uat0302Entity.getShuryoYMD());
        tmpEntity.setUaT0302KinyuKikan_name(uat0302Entity.getName());
        tmpEntity.setUaT0302KinyuKikan_kanaName(uat0302Entity.getKanaName());
        tmpEntity.setUaT0302KinyuKikan_yokinShubetsuPatternCode(uat0302Entity.getYokinShubetsuPatternCode().getColumnValue());
        tmpEntity.setUaT0302KinyuKikan_hyojijun(uat0302Entity.getHyojijun());

        UaT0301YokinShubetsuPatternEntity uat0301Entity = 特定口座.getYokinShubetsuPatternEntity();
        if (uat0301Entity != null && uat0301Entity.getYokinShubetsuPatternCode() != null) {
            tmpEntity.setUaT0301YokinShubetsuPattern_yokinShubetsuPatternCode(uat0301Entity.getYokinShubetsuPatternCode().getColumnValue());
            tmpEntity.setUaT0301YokinShubetsuPattern_yokinShubetsuCode(uat0301Entity.getYokinShubetsuCode());
            tmpEntity.setUaT0301YokinShubetsuPattern_yokinShubetsuMeisho(uat0301Entity.getYokinShubetsuMeisho());
            tmpEntity.setUaT0301YokinShubetsuPattern_yokinShubetsuRyakusho(uat0301Entity.getYokinShubetsuRyakusho());
        }

        UaT0303KinyuKikanShitenEntity uat0303Entity = 特定口座.getKinyuKikanShitenEntity();
        if (uat0303Entity != null && uat0303Entity.getKinyuKikanCode() != null) {
            tmpEntity.setUaT0303KinyuKikanShiten_kinyuKikanCode(uat0303Entity.getKinyuKikanCode());
            tmpEntity.setUaT0303KinyuKikanShiten_kinyuKikanShitenCode(uat0303Entity.getKinyuKikanShitenCode());
            tmpEntity.setUaT0303KinyuKikanShiten_kaishiYMD(uat0303Entity.getKaishiYMD());
            tmpEntity.setUaT0303KinyuKikanShiten_shuryoYMD(uat0303Entity.getShuryoYMD());
            tmpEntity.setUaT0303KinyuKikanShiten_name(uat0303Entity.getName());
            tmpEntity.setUaT0303KinyuKikanShiten_kanaName(uat0303Entity.getKanaName());
            tmpEntity.setUaT0303KinyuKikanShiten_hyojijun(uat0303Entity.getHyojijun());
        }
    }

    private Code getCode(TokubetsuChoshuGimushaCode code) {
        if (code != null) {
            return code.getColumnValue();
        }
        return null;
    }

    private boolean isNull(Object 項目) {
        return 項目 == null;
    }

    private void toBodyList(List<RString> bodyList) {
        for (int i = INT_0; i < bodyList.size(); i++) {
            if (bodyList.get(i) == null) {
                bodyList.remove(bodyList.get(i));
                bodyList.add(i, RString.EMPTY);
            }
        }
    }
}
