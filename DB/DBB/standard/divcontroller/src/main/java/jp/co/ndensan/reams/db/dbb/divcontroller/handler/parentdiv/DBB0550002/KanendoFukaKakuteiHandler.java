/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0550002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteiidokanendofukakakutei.KanendoIdoFukaKakutei;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550002.KanendoFukaKakuteiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550002.dgKanendoFukaIchiran_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550002.dgShoriNichiji_Row;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendofukakakutei.HonsanteiIdoKanendoFukaKakutei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.fuka.SanteiState;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 本算定異動（過年度）賦課確定（削除込)のハンドラクラスです。
 *
 * @reamsid_L DBB-0680-010 wangkanglei
 */
public class KanendoFukaKakuteiHandler {

    private static final RString 確定処理 = new RString("btnKakutei");
    private static final RString 賦課対象外を削除 = new RString("btnDeleteTaishoGai");
    private static final RString 改行 = new RString("<br>");
    private static final RString スペース = RString.HALF_SPACE;
    private static final RString ゼロ = new RString("0");
    private static final RString 月分_1 = new RString("1月分");
    private static final RString 月分_2 = new RString("2月分");
    private static final RString 月分_3 = new RString("3月分");
    private static final RString 月分_4 = new RString("4月分");
    private static final RString 月分_5 = new RString("5月分");
    private static final RString 月分_6 = new RString("6月分");
    private static final RString 月分_7 = new RString("7月分");
    private static final RString 月分_8 = new RString("8月分");
    private static final RString 月分_9 = new RString("9月分");
    private static final RString 月分_10 = new RString("10月分");
    private static final RString 月分_11 = new RString("11月分");
    private static final RString 月分_12 = new RString("12月分");
    private static final RString 翌年度_4 = new RString("翌年度4月分");
    private static final RString 翌年度_5 = new RString("翌年度5月分");
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_9 = 9;
    private static final int NUM_10 = 10;
    private static final int NUM_11 = 11;
    private static final int NUM_12 = 12;
    private static final int NUM_14 = 14;
    private static final int NUM_15 = 15;

    private final KanendoFukaKakuteiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KanendoFukaKakuteiDiv
     */
    public KanendoFukaKakuteiHandler(KanendoFukaKakuteiDiv div) {
        this.div = div;
    }

    /**
     * setヘッダのメソッドます。
     *
     * @param 異動処理日付 ShoriDateKanri
     */
    public void setヘッダ(ShoriDateKanri 異動処理日付) {
        List<dgShoriNichiji_Row> shoriNichijiList = new ArrayList<>();
        dgShoriNichiji_Row row = new dgShoriNichiji_Row();
        RString 年月日;
        RString 時刻;
        if (異動処理日付.get基準日時() != null) {
            年月日 = 異動処理日付.get基準日時().getRDateTime().getDate().wareki().toDateString();
            時刻 = 異動処理日付.get基準日時().getRDateTime().getTime().toFormattedTimeString(
                    DisplayTimeFormat.HH_mm_ss);
            row.getTxtShoriNichiji().setValue(年月日.concat(スペース).concat(時刻));
            row.getTxtShoriYMD().setValue(異動処理日付.get基準日時().getRDateTime().getDate());
            row.getTxtShoriTime().setValue(異動処理日付.get基準日時().getRDateTime().getTime());
        }
        if (異動処理日付.get対象開始日時() != null) {
            年月日 = 異動処理日付.get対象開始日時().getRDateTime().getDate().wareki().toDateString();
            時刻 = 異動処理日付.get対象開始日時().getRDateTime().getTime().toFormattedTimeString(
                    DisplayTimeFormat.HH_mm_ss);
            row.getTxtChushutsuStNichiji().setValue(年月日.concat(スペース).concat(時刻));
            row.getTxtChushutsuStYMD().setValue(異動処理日付.get対象開始日時().getRDateTime().getDate());
            row.getTxtChushutsuStTime().setValue(異動処理日付.get対象開始日時().getRDateTime().getTime());
        }
        if (異動処理日付.get対象終了日時() != null) {
            年月日 = 異動処理日付.get対象終了日時().getRDateTime().getDate().wareki().toDateString();
            時刻 = 異動処理日付.get対象終了日時().getRDateTime().getTime().toFormattedTimeString(
                    DisplayTimeFormat.HH_mm_ss);
            row.getTxtChushutsuEdNichiji().setValue(年月日.concat(スペース).concat(時刻));
            row.getTxtChushutsuEdYMD().setValue(異動処理日付.get対象終了日時().getRDateTime().getDate());
            row.getTxtChushutsuEdTime().setValue(異動処理日付.get対象終了日時().getRDateTime().getTime());
        }
        shoriNichijiList.add(row);
        div.getDgShoriNichiji().setDataSource(shoriNichijiList);
    }

    /**
     * 処理対象に設定のメソッドます。
     *
     * @param entity KanendoIdoFukaKakutei
     */
    public void set処理対象(KanendoIdoFukaKakutei entity) {
        if (entity.getFukaKakuteiEntity().get更正月() != null) {
            switch (Integer.valueOf(entity.getFukaKakuteiEntity().get更正月().toString())) {
                case NUM_1:
                    div.getTxtShoriTsuki().setValue(月分_1);
                    break;
                case NUM_2:
                    div.getTxtShoriTsuki().setValue(月分_2);
                    break;
                case NUM_3:
                    div.getTxtShoriTsuki().setValue(月分_3);
                    break;
                case NUM_4:
                    div.getTxtShoriTsuki().setValue(月分_4);
                    break;
                case NUM_5:
                    div.getTxtShoriTsuki().setValue(月分_5);
                    break;
                case NUM_6:
                    div.getTxtShoriTsuki().setValue(月分_6);
                    break;
                case NUM_7:
                    div.getTxtShoriTsuki().setValue(月分_7);
                    break;
                case NUM_8:
                    div.getTxtShoriTsuki().setValue(月分_8);
                    break;
                case NUM_9:
                    div.getTxtShoriTsuki().setValue(月分_9);
                    break;
                case NUM_10:
                    div.getTxtShoriTsuki().setValue(月分_10);
                    break;
                case NUM_11:
                    div.getTxtShoriTsuki().setValue(月分_11);
                    break;
                case NUM_12:
                    div.getTxtShoriTsuki().setValue(月分_12);
                    break;
                case NUM_14:
                    div.getTxtShoriTsuki().setValue(翌年度_4);
                    break;
                case NUM_15:
                    div.getTxtShoriTsuki().setValue(翌年度_5);
                    break;
                default:
                    div.getTxtShoriTsuki().setValue(RString.EMPTY);
                    break;
            }
        }
        div.setDeleteDataCount(ゼロ);
    }

    /**
     * 過年度異動賦課対象一覧に設定のメソッドます。
     *
     * @param 異動賦課対象List List<KanendoIdoFukaKakutei>
     */
    public void set過年度異動賦課対象一覧(List<KanendoIdoFukaKakutei> 異動賦課対象List) {
        List<dgKanendoFukaIchiran_Row> dgKanendoFukaList = new ArrayList<>();
        dgKanendoFukaIchiran_Row row;
        for (KanendoIdoFukaKakutei entity : 異動賦課対象List) {
            row = new dgKanendoFukaIchiran_Row();
            row.getTxtKetsugoKomoku1().setValue(entity.getFukaKakuteiEntity().get通知書番号().value()
                    .concat(改行).concat(entity.getFukaKakuteiEntity().get識別コード().value()));
            row.getTxtTuchishoNo().setValue(entity.getFukaKakuteiEntity().get通知書番号().value());
            if (entity.getFukaKakuteiEntity().get識別コード() != null) {
                row.getTxtShikibetsuCode().setValue(entity.getFukaKakuteiEntity().get識別コード().value());
            }
            RString 更正前調定年度 = RString.EMPTY;
            if (entity.getFukaKakuteiEntity().get更正前調定年度() != null) {
                更正前調定年度 = entity.getFukaKakuteiEntity().get更正前調定年度().wareki().toDateString();
                row.getTxtChoteiNendoMae().setValue(new RDate(entity.getFukaKakuteiEntity().get更正前調定年度().toString()));
            }
            row.getTxtChoteiNendo().setValue(更正前調定年度
                    .concat(改行).concat(entity.getFukaKakuteiEntity().get調定年度().wareki().toDateString()));
            row.getTxtChoteiNendoAto().setValue(new RDate(entity.getFukaKakuteiEntity().get調定年度().toString()));
            row.getTxtFukaNendo().setValue(new RDate(entity.getFukaKakuteiEntity().get賦課年度().toString()));
            RString 更正前確定介護保険料 = RString.EMPTY;
            RString 確定介護保険料 = RString.EMPTY;
            if (entity.getFukaKakuteiEntity().get更正前確定介護保険料() != null) {
                row.getTxtKakuteiHokenryoMae().setValue(entity.getFukaKakuteiEntity().get更正前確定介護保険料());
                更正前確定介護保険料 = DecimalFormatter.toコンマ区切りRString(entity.getFukaKakuteiEntity().get更正前確定介護保険料(), 0);
            }
            if (entity.getFukaKakuteiEntity().get確定介護保険料() != null) {
                row.getTxtKakuteiHokenryoAto().setValue(entity.getFukaKakuteiEntity().get確定介護保険料());
                確定介護保険料 = DecimalFormatter.toコンマ区切りRString(entity.getFukaKakuteiEntity().get確定介護保険料(), 0);
            }
            row.getTxtKakuteiHokenryo().setValue(更正前確定介護保険料.concat(改行).concat(確定介護保険料));
            RString 更正前算定年額保険料 = RString.EMPTY;
            RString 算定年額保険料 = RString.EMPTY;
            if (entity.getFukaKakuteiEntity().get更正前算定年額保険料２() != null
                    && entity.getFukaKakuteiEntity().get更正前算定年額保険料２().compareTo(Decimal.ZERO) == 1) {
                row.getTxtNengakuHokenryoMae().setValue(entity.getFukaKakuteiEntity().get更正前算定年額保険料２());
                更正前算定年額保険料 = DecimalFormatter.toコンマ区切りRString(entity.getFukaKakuteiEntity().get更正前算定年額保険料２(), 0);
            } else if (entity.getFukaKakuteiEntity().get更正前算定年額保険料１() != null
                    && entity.getFukaKakuteiEntity().get更正前算定年額保険料１().compareTo(Decimal.ZERO) == 1) {
                row.getTxtNengakuHokenryoMae().setValue(entity.getFukaKakuteiEntity().get更正前算定年額保険料１());
                更正前算定年額保険料 = DecimalFormatter.toコンマ区切りRString(entity.getFukaKakuteiEntity().get更正前算定年額保険料１(), 0);
            }
            if (entity.getFukaKakuteiEntity().get算定年額保険料２() != null
                    && entity.getFukaKakuteiEntity().get算定年額保険料２().compareTo(Decimal.ZERO) == 1) {
                row.getTxtNengakuHokenryoAto().setValue(entity.getFukaKakuteiEntity().get算定年額保険料２());
                算定年額保険料 = DecimalFormatter.toコンマ区切りRString(entity.getFukaKakuteiEntity().get算定年額保険料２(), 0);
            } else if (entity.getFukaKakuteiEntity().get算定年額保険料１() != null
                    && entity.getFukaKakuteiEntity().get算定年額保険料１().compareTo(Decimal.ZERO) == 1) {
                row.getTxtNengakuHokenryoAto().setValue(entity.getFukaKakuteiEntity().get算定年額保険料１());
                算定年額保険料 = DecimalFormatter.toコンマ区切りRString(entity.getFukaKakuteiEntity().get算定年額保険料１(), 0);
            }
            row.getTxtNengakuHokenryo().setValue(更正前算定年額保険料.concat(改行).concat(算定年額保険料));
            RString 更正前減免額 = RString.EMPTY;
            RString 減免額 = RString.EMPTY;
            if (entity.getFukaKakuteiEntity().get更正前減免額() != null) {
                row.getTxtGenmenGakuMae().setValue(entity.getFukaKakuteiEntity().get更正前減免額());
                更正前減免額 = DecimalFormatter.toコンマ区切りRString(entity.getFukaKakuteiEntity().get更正前減免額(), 0);
            }
            if (entity.getFukaKakuteiEntity().get減免額() != null) {
                row.getTxtGenmenGakuAto().setValue(entity.getFukaKakuteiEntity().get減免額());
                減免額 = DecimalFormatter.toコンマ区切りRString(entity.getFukaKakuteiEntity().get減免額(), 0);
            }
            row.getTxtGenmenGaku().setValue(更正前減免額.concat(改行).concat(減免額));
            RString 更正前保険料算定段階 = RString.EMPTY;
            RString 保険料算定段階 = RString.EMPTY;
            if (!RString.isNullOrEmpty(entity.getFukaKakuteiEntity().get更正前保険料算定段階２())) {
                row.getTxtShotokuDankaiMae().setValue(entity.getFukaKakuteiEntity().get更正前保険料算定段階２());
                更正前保険料算定段階 = entity.getFukaKakuteiEntity().get更正前保険料算定段階２();
            } else if (!RString.isNullOrEmpty(entity.getFukaKakuteiEntity().get更正前保険料算定段階１())) {
                row.getTxtShotokuDankaiMae().setValue(entity.getFukaKakuteiEntity().get更正前保険料算定段階１());
                更正前保険料算定段階 = entity.getFukaKakuteiEntity().get更正前保険料算定段階１();
            }
            if (!RString.isNullOrEmpty(entity.getFukaKakuteiEntity().get保険料算定段階２())) {
                row.getTxtShotokuDankaiAto().setValue(entity.getFukaKakuteiEntity().get保険料算定段階２());
                保険料算定段階 = entity.getFukaKakuteiEntity().get保険料算定段階２();
            } else if (!RString.isNullOrEmpty(entity.getFukaKakuteiEntity().get保険料算定段階１())) {
                row.getTxtShotokuDankaiAto().setValue(entity.getFukaKakuteiEntity().get保険料算定段階１());
                保険料算定段階 = entity.getFukaKakuteiEntity().get保険料算定段階１();
            }
            row.getTxtShotokuDankai().setValue(更正前保険料算定段階.concat(改行).concat(保険料算定段階));
            if (entity.getFukaKakuteiEntity().get調定額() != null) {
                row.getTxtKanendoGaku().setValue(entity.getFukaKakuteiEntity().get調定額());
                row.getTxtKanendoGakuAto().setValue(改行.concat(DecimalFormatter.toコンマ区切りRString(entity.getFukaKakuteiEntity().get調定額(), 0)));
            }
            if (entity.getFukaKakuteiEntity().get納期限() != null) {
                row.getTxtKanendoNokiGen().setValue(entity.getFukaKakuteiEntity().get納期限());
                row.getTxtKanendoNokiGenAto().setValue(改行.concat(entity.getFukaKakuteiEntity().get納期限().wareki()
                        .eraType(EraType.KANJI_RYAKU)
                        .firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.PERIOD)
                        .fillType(FillType.ZERO)
                        .width(Width.HALF).toDateString()));
            }
            set項目(row, entity);
            dgKanendoFukaList.add(row);
        }
        div.getKaNendoIdoFukaIchiran().getDgKanendoFukaIchiran().setDataSource(dgKanendoFukaList);
    }

    /**
     * 確定処理を実行のメソッドます。
     */
    public void setKakutei() {
        HonsanteiIdoKanendoFukaKakutei fukaKakutei = InstanceProvider.create(HonsanteiIdoKanendoFukaKakutei.class);
        RDate 年月日 = div.getDgShoriNichiji().getDataSource().get(0).getTxtShoriYMD().getValue();
        RTime 時刻 = div.getDgShoriNichiji().getDataSource().get(0).getTxtShoriTime().getValue();
        fukaKakutei.confirmFuka(new YMDHMS(年月日, 時刻));
        div.getKaNendoIdoFukaIchiran().getDgKanendoFukaIchiran().getDataSource().removeAll(
                div.getKaNendoIdoFukaIchiran().getDgKanendoFukaIchiran().getDataSource());
        CommonButtonHolder.setDisabledByCommonButtonFieldName(確定処理, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(賦課対象外を削除, true);
    }

    /**
     * チェックボックス制御を実行のメソッドます。
     */
    public void onChange() {
        div.setDeleteDataCount(new RString(String.valueOf(div.getKaNendoIdoFukaIchiran().getDgKanendoFukaIchiran()
                .getSelectedItems().size())));
        if (Integer.valueOf(div.getDeleteDataCount().toString()) > 0) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(確定処理, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(賦課対象外を削除, false);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(確定処理, false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(賦課対象外を削除, true);
        }
    }

    /**
     * 賦課対象外の削除を実行のメソッドます。
     */
    public void deleteTaishoGai() {
        List<KanendoIdoFukaKakutei> fukaKakuteiList = new ArrayList<>();
        KanendoIdoFukaKakutei fukaKakuteiEntity;
        for (dgKanendoFukaIchiran_Row row : div.getKaNendoIdoFukaIchiran().getDgKanendoFukaIchiran().getSelectedItems()) {
            fukaKakuteiEntity = new KanendoIdoFukaKakutei();
            if (row.getTxtHihokenshaNo().getValue() != null) {
                fukaKakuteiEntity.setFukaKakuteiEntity(null);
                fukaKakuteiEntity.set履歴番号(row.getTxtRirekiNoAto().getValue().toInt());
            }
            if (row.getTxtTuchishoNo().getValue() != null) {
                fukaKakuteiEntity.set通知書番号(new TsuchishoNo(row.getTxtTuchishoNo().getValue()));
            }
            if (row.getTxtChoteiNendoAto().getValue() != null) {
                fukaKakuteiEntity.set調定年度(
                        new FlexibleYear(row.getTxtChoteiNendoAto().getValue().getYear().toString()));
            }
            if (row.getTxtFukaNendo().getValue() != null) {
                fukaKakuteiEntity.set賦課年度(
                        new FlexibleYear(row.getTxtFukaNendo().getValue().getYear().toString()));
            }
            fukaKakuteiList.add(fukaKakuteiEntity);
        }
        HonsanteiIdoKanendoFukaKakutei fukaKakutei = InstanceProvider.create(HonsanteiIdoKanendoFukaKakutei.class);
        if (div.getKaNendoIdoFukaIchiran().getDgKanendoFukaIchiran().getTotalRecords() == div.
                getKaNendoIdoFukaIchiran().getDgKanendoFukaIchiran().getSelectedItems().size()) {
            fukaKakutei.deleteFuka(fukaKakuteiList, true);
        } else {
            fukaKakutei.deleteFuka(fukaKakuteiList, false);
        }
        div.getKaNendoIdoFukaIchiran().getDgKanendoFukaIchiran().getDataSource().removeAll(
                div.getKaNendoIdoFukaIchiran().getDgKanendoFukaIchiran().getSelectedItems());
        CommonButtonHolder.setDisabledByCommonButtonFieldName(賦課対象外を削除, true);
        if (div.getKaNendoIdoFukaIchiran().getDgKanendoFukaIchiran().getTotalRecords() > 0) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(確定処理, false);
        }
    }

    private void set項目(dgKanendoFukaIchiran_Row row, KanendoIdoFukaKakutei entity) {
        if (entity.getFukaKakuteiEntity().get更正前通知書番号() != null
                && !entity.getFukaKakuteiEntity().get更正前通知書番号().isEmpty()) {
            row.getTxtTuchishoNoMae().setValue(entity.getFukaKakuteiEntity().get更正前通知書番号().value());
        }
        row.getTxtHihokenshaNo().setValue(entity.getFukaKakuteiEntity().get被保険者番号().value());
        if (entity.getFukaKakuteiEntity().get更正前被保険者番号() != null
                && !entity.getFukaKakuteiEntity().get更正前被保険者番号().isEmpty()) {
            row.getTxtHihokenshaNoMae().setValue(entity.getFukaKakuteiEntity().get更正前被保険者番号().value());
        }
        row.getTxtRirekiNoAto().setValue(new RString(Integer.toString(entity.getFukaKakuteiEntity().get履歴番号())));
        row.getTxtRirekiNoMae().setValue(new RString(Integer.toString(entity.getFukaKakuteiEntity().get更正前履歴番号())));
        if (entity.getFukaKakuteiEntity().get更正前賦課年度() != null
                && !entity.getFukaKakuteiEntity().get更正前賦課年度().isEmpty()) {
            row.getTxtFukaNendoMae().setValue(new RDate(entity.getFukaKakuteiEntity().get更正前賦課年度().toString()));
        }
        row.getTxtFukaYMDAto().setValue(entity.getFukaKakuteiEntity().get賦課期日());
        if (entity.getFukaKakuteiEntity().get更正前賦課期日() != null
                && !entity.getFukaKakuteiEntity().get更正前賦課期日().isEmpty()) {
            row.getTxtFukaYMDMae().setValue(entity.getFukaKakuteiEntity().get更正前賦課期日());
        }
        row.setTxtKoseiMAto(entity.getFukaKakuteiEntity().get更正月());
        if (!RString.isNullOrEmpty(entity.getFukaKakuteiEntity().get更正前更正月())) {
            row.setTxtKoseiMMae(entity.getFukaKakuteiEntity().get更正前更正月());
        }
        if (entity.getFukaKakuteiEntity().get調定日時() != null
                && !entity.getFukaKakuteiEntity().get調定日時().isEmpty()) {
            row.getTxtChoteiNichijiAto().setValue(new RString(entity.getFukaKakuteiEntity().get調定日時().toString()));
        }
        if (entity.getFukaKakuteiEntity().get更正前調定日時() != null
                && !entity.getFukaKakuteiEntity().get更正前調定日時().isEmpty()) {
            row.getTxtChoteiNichijiMae().setValue(new RString(entity.getFukaKakuteiEntity().get更正前調定日時().toString()));
        }
    }

    /**
     * 選択された賦課の更正後賦課照会キーを返します。
     *
     * @param row dgKanendoFukaIchiran_Row
     * @return 賦課照会キー
     */
    public Optional<FukaShokaiKey> get後履歴Key(dgKanendoFukaIchiran_Row row) {
        FlexibleYear 調定年度 = new FlexibleYear(row.getTxtChoteiNendoAto().getValue().getYear().toDateString());
        FlexibleYear 賦課年度 = new FlexibleYear(row.getTxtFukaNendo().getValue().getYear().toDateString());
        TsuchishoNo 通知書番号 = new TsuchishoNo(row.getTxtTuchishoNo().getValue());
        int 履歴番号 = row.getTxtRirekiNoAto().getValue().toInt();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihokenshaNo().getValue());
        FlexibleDate 賦課期日 = row.getTxtFukaYMDAto().getValue();
        RString 更正月 = row.getTxtKoseiMAto();
        YMDHMS 更正日時 = null;
        if (row.getTxtChoteiNichijiAto().getValue() != null
                && !row.getTxtChoteiNichijiAto().getValue().isEmpty()) {
            更正日時 = new YMDHMS(row.getTxtChoteiNichijiAto().getValue());
        }
        FukaShokaiKey 後履歴Key = new FukaShokaiKey(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号,
                被保険者番号,
                賦課期日,
                更正月,
                更正日時,
                SanteiState.本算定,
                Boolean.FALSE,
                Boolean.FALSE,
                AtenaMeisho.EMPTY);
        return Optional.of(後履歴Key);
    }

    /**
     * 選択された賦課の更正前賦課照会キーを返します。
     *
     * @param row dgKanendoFukaIchiran_Row
     * @return 賦課照会キー
     */
    public Optional<FukaShokaiKey> get前履歴Key(dgKanendoFukaIchiran_Row row) {
        FlexibleYear 調定年度 = null;
        if (row.getTxtChoteiNendoMae().getValue() != null) {
            調定年度 = new FlexibleYear(row.getTxtChoteiNendoMae().getValue().getYear().toDateString());
        }
        FlexibleYear 賦課年度 = null;
        if (row.getTxtFukaNendoMae().getValue() != null) {
            賦課年度 = new FlexibleYear(row.getTxtFukaNendoMae().getValue().getYear().toDateString());
        }
        TsuchishoNo 通知書番号 = TsuchishoNo.EMPTY;
        if (!RString.isNullOrEmpty(row.getTxtTuchishoNoMae().getValue())) {
            通知書番号 = new TsuchishoNo(row.getTxtTuchishoNoMae().getValue());
        }
        int 履歴番号 = 0;
        if (!RString.isNullOrEmpty(row.getTxtRirekiNoMae().getValue())) {
            履歴番号 = row.getTxtRirekiNoMae().getValue().toInt();
        }
        HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
        if (!RString.isNullOrEmpty(row.getTxtHihokenshaNoMae().getValue())) {
            被保険者番号 = new HihokenshaNo(row.getTxtHihokenshaNoMae().getValue());
        }
        FlexibleDate 賦課期日 = row.getTxtFukaYMDMae().getValue();
        RString 更正月 = row.getTxtKoseiMMae();
        YMDHMS 更正日時 = null;
        if (row.getTxtChoteiNichijiMae().getValue() != null
                && !row.getTxtChoteiNichijiMae().getValue().isEmpty()) {
            更正日時 = new YMDHMS(row.getTxtChoteiNichijiMae().getValue());
        }
        FukaShokaiKey 前履歴Key = new FukaShokaiKey(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号,
                被保険者番号,
                賦課期日,
                更正月,
                更正日時,
                SanteiState.本算定,
                Boolean.FALSE,
                Boolean.FALSE,
                AtenaMeisho.EMPTY);
        return Optional.of(前履歴Key);
    }
}
