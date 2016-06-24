/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0550002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteiidokanendofukakakutei.KanendoIdoFukaKakutei;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550002.KanendoFukaKakuteiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550002.dgKanendoFukaIchiran_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550002.dgShoriNichiji_Row;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendofukakakutei.HonsanteiIdoKanendoFukaKakutei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

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
            row.getTxtHihokenshaNo().setValue(new RString(Integer.toString(entity.getFukaKakuteiEntity().get履歴番号())));
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
                更正前確定介護保険料 = new RString(entity.getFukaKakuteiEntity().get更正前確定介護保険料().toString());
            }
            if (entity.getFukaKakuteiEntity().get確定介護保険料() != null) {
                row.getTxtKakuteiHokenryoAto().setValue(entity.getFukaKakuteiEntity().get確定介護保険料());
                確定介護保険料 = new RString(entity.getFukaKakuteiEntity().get確定介護保険料().toString());
            }
            row.getTxtKakuteiHokenryo().setValue(更正前確定介護保険料.concat(改行).concat(確定介護保険料));
            RString 更正前算定年額保険料 = RString.EMPTY;
            RString 算定年額保険料 = RString.EMPTY;
            if (entity.getFukaKakuteiEntity().get更正前算定年額保険料２() != null) {
                row.getTxtNengakuHokenryoMae().setValue(entity.getFukaKakuteiEntity().get更正前算定年額保険料２());
                更正前算定年額保険料 = new RString(entity.getFukaKakuteiEntity().get更正前算定年額保険料２().toString());
            } else if (entity.getFukaKakuteiEntity().get更正前算定年額保険料１() != null) {
                row.getTxtNengakuHokenryoMae().setValue(entity.getFukaKakuteiEntity().get更正前算定年額保険料１());
                更正前算定年額保険料 = new RString(entity.getFukaKakuteiEntity().get更正前算定年額保険料１().toString());
            }
            if (entity.getFukaKakuteiEntity().get算定年額保険料２() != null) {
                row.getTxtNengakuHokenryoAto().setValue(entity.getFukaKakuteiEntity().get算定年額保険料２());
                算定年額保険料 = new RString(entity.getFukaKakuteiEntity().get算定年額保険料２().toString());
            } else if (entity.getFukaKakuteiEntity().get算定年額保険料１() != null) {
                row.getTxtNengakuHokenryoAto().setValue(entity.getFukaKakuteiEntity().get算定年額保険料１());
                算定年額保険料 = new RString(entity.getFukaKakuteiEntity().get算定年額保険料１().toString());
            }
            row.getTxtNengakuHokenryo().setValue(更正前算定年額保険料.concat(改行).concat(算定年額保険料));
            RString 更正前減免額 = RString.EMPTY;
            RString 減免額 = RString.EMPTY;
            if (entity.getFukaKakuteiEntity().get更正前減免額() != null) {
                row.getTxtGenmenGakuMae().setValue(entity.getFukaKakuteiEntity().get更正前減免額());
                更正前減免額 = new RString(entity.getFukaKakuteiEntity().get更正前減免額().toString());
            }
            if (entity.getFukaKakuteiEntity().get減免額() != null) {
                row.getTxtGenmenGakuAto().setValue(entity.getFukaKakuteiEntity().get減免額());
                減免額 = new RString(entity.getFukaKakuteiEntity().get減免額().toString());
            }
            row.getTxtGenmenGaku().setValue(更正前減免額.concat(改行).concat(減免額));
            RString 更正前保険料算定段階 = RString.EMPTY;
            RString 保険料算定段階 = RString.EMPTY;
            if (entity.getFukaKakuteiEntity().get更正前保険料算定段階２() != null) {
                row.getTxtShotokuDankaiMae().setValue(entity.getFukaKakuteiEntity().get更正前保険料算定段階２());
                更正前保険料算定段階 = entity.getFukaKakuteiEntity().get更正前保険料算定段階２();
            } else if (entity.getFukaKakuteiEntity().get更正前保険料算定段階１() != null) {
                row.getTxtShotokuDankaiMae().setValue(entity.getFukaKakuteiEntity().get更正前保険料算定段階１());
                更正前保険料算定段階 = entity.getFukaKakuteiEntity().get更正前保険料算定段階１();
            }
            if (entity.getFukaKakuteiEntity().get保険料算定段階２() != null) {
                row.getTxtShotokuDankaiAto().setValue(entity.getFukaKakuteiEntity().get保険料算定段階２());
                保険料算定段階 = entity.getFukaKakuteiEntity().get保険料算定段階２();
            } else if (entity.getFukaKakuteiEntity().get保険料算定段階１() != null) {
                row.getTxtShotokuDankaiAto().setValue(entity.getFukaKakuteiEntity().get保険料算定段階１());
                保険料算定段階 = entity.getFukaKakuteiEntity().get保険料算定段階１();
            }
            row.getTxtShotokuDankai().setValue(更正前保険料算定段階.concat(改行).concat(保険料算定段階));
            if (entity.getFukaKakuteiEntity().get調定額() != null) {
                row.getTxtKanendoGaku().setValue(entity.getFukaKakuteiEntity().get調定額());
            }
            if (entity.getFukaKakuteiEntity().get納期限() != null) {
                row.getTxtKanendoNokiGen().setValue(entity.getFukaKakuteiEntity().get納期限());
            }
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
                fukaKakuteiEntity.set履歴番号(
                        Integer.valueOf(row.getTxtHihokenshaNo().getValue().toString()).intValue());
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
}
