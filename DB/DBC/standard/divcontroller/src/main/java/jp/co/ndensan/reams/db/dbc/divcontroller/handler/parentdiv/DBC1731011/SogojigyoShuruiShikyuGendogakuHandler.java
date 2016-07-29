/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1731011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.business.core.sogojigyoshurui.SogojigyoShuruiSearchResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1731011.SogojigyoShuruiShikyuGendogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1731011.dgShikyuGendogaku_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.SogoJigyoShuruiShikyuGendoGakuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiManager;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 総合事業種類支給限度額登録のHandlerクラスです。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
public class SogojigyoShuruiShikyuGendogakuHandler {

    private static final RString 要支援1 = new RString("12");
    private static final RString 要支援2 = new RString("13");
    private static final RString 二次予防 = new RString("01");
    private static final RString 登録 = new RString("登録モード");
    private static final RString 修正 = new RString("修正モード");
    private static final RString 符号 = new RString(":");

    private static final int 履歴番号 = 1;

    private final SogojigyoShuruiShikyuGendogakuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SogojigyoShuruiShikyuGendogakuDiv
     */
    public SogojigyoShuruiShikyuGendogakuHandler(SogojigyoShuruiShikyuGendogakuDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時の動作です。
     *
     * @param resultList List<SogojigyoShuruiSearchResult>
     */
    public void initialize(List<SogojigyoShuruiSearchResult> resultList) {

        div.getBtnTsuika().setDisabled(false);
        div.getDgShikyuGendogaku().getDataSource().clear();
        List<dgShikyuGendogaku_Row> dataSource = new ArrayList<>();
        for (SogojigyoShuruiSearchResult result : resultList) {
            dgShikyuGendogaku_Row row = new dgShikyuGendogaku_Row();
            SogoJigyoShuruiShikyuGendoGaku entity;
            if (result.get要支援1() != null) {
                entity = result.get要支援1();
            } else if (result.get要支援2() != null) {
                entity = result.get要支援2();
            } else {
                entity = result.get二次予防();
            }
            row.setDefaultDataName0(entity.getサービス種類コード().value().concat(符号).concat(result.getサービス種類名称()));
            row.getDefaultDataName1().setValue(new RDate(entity.get適用開始年月().getYearValue(),
                    entity.get適用開始年月().getMonthValue(), 1));
            if (entity.get適用終了年月() != null) {
                row.getDefaultDataName2().setValue(new RDate(entity.get適用終了年月().getYearValue(),
                        entity.get適用終了年月().getMonthValue(), 1));
            }
            if (result.get要支援1() != null) {
                row.getDefaultDataName3().setValue(result.get要支援1().get支給限度単位数());
            }
            if (result.get要支援2() != null) {
                row.getDefaultDataName4().setValue(result.get要支援2().get支給限度単位数());
            }
            if (result.get二次予防() != null) {
                row.getDefaultDataName5().setValue(result.get二次予防().get支給限度単位数());
            }
            dataSource.add(row);
        }
        div.getDgShikyuGendogaku().setDataSource(dataSource);
        clear詳細内容();
        set詳細入力不可();
    }

    /**
     * サービス種類DDLのDataSource設定です。
     *
     * @param manager KaigoServiceShuruiManager
     */
    public void setDataSource(KaigoServiceShuruiManager manager) {
        List<KeyValueDataSource> dataSource = manager.getサービス種類DDLのDataSource();
        div.getDdlServiceShurui().setDataSource(dataSource);
        div.getDdlServiceShurui().setSelectedKey(RString.EMPTY);
    }

    /**
     * 画面詳細パネル各項目内容をクリアします。
     */
    private void clear詳細内容() {
        div.getTxtTekiyoKaishiYM().clearValue();
        div.getTxtTekiyoShuryoYM().clearValue();
        div.getDdlServiceShurui().setSelectedKey(RString.EMPTY);
        div.getTxtYoShien1().clearValue();
        div.getTxtYoShien2().clearValue();
        div.getTxtNijiYobo().clearValue();
    }

//    private void setサービス種類DDL空白表示() {
//        div.getDdlServiceShurui().getDataSource().clear();
//        List<KeyValueDataSource> dataSource空白 = new ArrayList<>();
//        dataSource空白.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
//        div.getDdlServiceShurui().setDataSource(dataSource空白);
//        div.getDdlServiceShurui().setSelectedKey(RString.EMPTY);
//    }
    /**
     * 画面詳細パネル各項目入力不可の状態です。
     */
    private void set詳細入力不可() {
        div.getTxtTekiyoKaishiYM().setReadOnly(true);
        div.getTxtTekiyoShuryoYM().setReadOnly(true);
        div.getDdlServiceShurui().setReadOnly(true);
        div.getTxtYoShien1().setReadOnly(true);
        div.getTxtYoShien2().setReadOnly(true);
        div.getTxtNijiYobo().setReadOnly(true);
    }

    /**
     * 「追加する」ボタン押下時の処理です。
     */
    public void set追加状態() {
        setBtn非活性();
        set詳細可入力();
        clear詳細内容();
        div.getTxtTekiyoShuryoYM().setReadOnly(true);
    }

    /**
     * 総合事業種類支給限度額登録一覧DataGridの「修正」「削除」ボタン、「追加する」ボタンは使用不可です。
     */
    private void setBtn非活性() {
        div.getBtnTsuika().setDisabled(true);
        for (dgShikyuGendogaku_Row row : div.getDgShikyuGendogaku().getDataSource()) {
            row.setModifyButtonState(DataGridButtonState.Disabled);
            row.setDeleteButtonState(DataGridButtonState.Disabled);
        }
    }

    /**
     * 画面詳細パネル各項目可入力の状態です。
     */
    private void set詳細可入力() {
        div.getTxtTekiyoKaishiYM().setReadOnly(false);
        div.getTxtTekiyoShuryoYM().setReadOnly(false);
        div.getDdlServiceShurui().setReadOnly(false);
        div.getTxtYoShien1().setReadOnly(false);
        div.getTxtYoShien2().setReadOnly(false);
        div.getTxtNijiYobo().setReadOnly(false);
    }

    /**
     * 総合事業種類支給限度額登録一覧DataGrid．「修正」ボタン押下時の処理です。
     */
    public void set修正状態() {
        setBtn非活性();
        set詳細可入力();
        set選択行内容表示();
        div.getTxtTekiyoKaishiYM().setReadOnly(true);
        div.getTxtTekiyoShuryoYM().setReadOnly(true);
        div.getDdlServiceShurui().setReadOnly(true);
    }

    /**
     * 総合事業種類支給限度額登録一覧DataGrid選択行の内容が詳細パネルに表示します。
     */
    private void set選択行内容表示() {
        dgShikyuGendogaku_Row row = div.getDgShikyuGendogaku().getClickedItem();
        div.getDdlServiceShurui().setSelectedValue(row.getDefaultDataName0());
        div.getTxtTekiyoKaishiYM().setValue(row.getDefaultDataName1().getValue());
        if (!row.getDefaultDataName2().getText().isNullOrEmpty()) {
            div.getTxtTekiyoShuryoYM().setValue(row.getDefaultDataName2().getValue());
        }
        div.getTxtYoShien1().setValue(row.getDefaultDataName3().getValue());
        div.getTxtYoShien2().setValue(row.getDefaultDataName4().getValue());
        div.getTxtNijiYobo().setValue(row.getDefaultDataName5().getValue());
    }

    /**
     * 総合事業種類支給限度額登録一覧DataGrid．「削除」ボタン押下時の処理です。
     */
    public void set削除状態() {
        setBtn非活性();
        set詳細入力不可();
        set選択行内容表示();
    }

    /**
     * 「入力前の状態に戻る」ボタン押下時の状態変化です。
     */
    public void set入力前状態() {
        clear詳細内容();
        set詳細入力不可();
        div.getBtnTsuika().setDisabled(false);
        for (dgShikyuGendogaku_Row row : div.getDgShikyuGendogaku().getDataSource()) {
            row.setModifyButtonState(DataGridButtonState.Enabled);
            row.setDeleteButtonState(DataGridButtonState.Enabled);
        }
    }

    /**
     * DBへの保存処理です。
     *
     * @param 総合事業種類情報 List<SogojigyoShuruiSearchResult>
     * @param 保存モード RString
     * @param manager SogoJigyoShuruiShikyuGendoGakuManager
     */
    public void save(List<SogojigyoShuruiSearchResult> 総合事業種類情報, RString 保存モード,
            SogoJigyoShuruiShikyuGendoGakuManager manager) {

        FlexibleYearMonth 適用開始年月 = new FlexibleYearMonth(div.getTxtTekiyoKaishiYM().getValue().getYearMonth().toDateString());
        ServiceShuruiCode サービス種類コード = new ServiceShuruiCode(div.getDdlServiceShurui().getSelectedKey());
        if (登録.equals(保存モード)) {
            SogojigyoShuruiSearchResult entityFirst = 総合事業種類情報.get(0);
            SogojigyoShuruiSearchResult entityLast = 総合事業種類情報.get(総合事業種類情報.size() - 1);
            SogoJigyoShuruiShikyuGendoGaku 要支援1Entity = new SogoJigyoShuruiShikyuGendoGaku(サービス種類コード, 要支援1,
                    適用開始年月, 履歴番号);
            SogoJigyoShuruiShikyuGendoGaku 要支援2Entity = new SogoJigyoShuruiShikyuGendoGaku(サービス種類コード, 要支援2,
                    適用開始年月, 履歴番号);
            SogoJigyoShuruiShikyuGendoGaku 二次予防Entity = new SogoJigyoShuruiShikyuGendoGaku(サービス種類コード, 二次予防,
                    適用開始年月, 履歴番号);
            if (!適用開始年月.isBeforeOrEquals(entityFirst.get要支援1().get適用開始年月())) {
                要支援1Entity = 要支援1Entity.createBuilderForEdit().set支給限度単位数(div.getTxtYoShien1().getValue()).build();
                要支援2Entity = 要支援2Entity.createBuilderForEdit().set支給限度単位数(div.getTxtYoShien2().getValue()).build();
                二次予防Entity = 二次予防Entity.createBuilderForEdit().set支給限度単位数(div.getTxtNijiYobo().getValue()).build();
                manager.save介護予防_日常生活支援総合事業種類支給限度額(要支援1Entity.added());
                manager.save介護予防_日常生活支援総合事業種類支給限度額(要支援2Entity.added());
                manager.save介護予防_日常生活支援総合事業種類支給限度額(二次予防Entity.added());
                要支援1Entity = entityFirst.get要支援1();
                要支援2Entity = entityFirst.get要支援2();
                二次予防Entity = entityFirst.get二次予防();
                要支援1Entity = 要支援1Entity.createBuilderForEdit().set適用終了年月(適用開始年月.minusMonth(1)).build();
                要支援2Entity = 要支援2Entity.createBuilderForEdit().set適用終了年月(適用開始年月.minusMonth(1)).build();
                二次予防Entity = 二次予防Entity.createBuilderForEdit().set適用終了年月(適用開始年月.minusMonth(1)).build();
                manager.save介護予防_日常生活支援総合事業種類支給限度額(要支援1Entity.modified());
                manager.save介護予防_日常生活支援総合事業種類支給限度額(要支援2Entity.modified());
                manager.save介護予防_日常生活支援総合事業種類支給限度額(二次予防Entity.modified());
            }
            if (適用開始年月.isBefore(entityLast.get要支援1().get適用開始年月())) {
                要支援1Entity = 要支援1Entity.createBuilderForEdit().set支給限度単位数(div.getTxtYoShien1().getValue())
                        .set適用終了年月(entityLast.get要支援1().get適用開始年月().minusMonth(1)).build();
                要支援2Entity = 要支援2Entity.createBuilderForEdit().set支給限度単位数(div.getTxtYoShien2().getValue())
                        .set適用終了年月(entityLast.get要支援1().get適用開始年月().minusMonth(1)).build();
                二次予防Entity = 二次予防Entity.createBuilderForEdit().set支給限度単位数(div.getTxtNijiYobo().getValue())
                        .set適用終了年月(entityLast.get要支援1().get適用開始年月().minusMonth(1)).build();
                manager.save介護予防_日常生活支援総合事業種類支給限度額(要支援1Entity.added());
                manager.save介護予防_日常生活支援総合事業種類支給限度額(要支援2Entity.added());
                manager.save介護予防_日常生活支援総合事業種類支給限度額(二次予防Entity.added());
            }
        } else {
            SogojigyoShuruiSearchResult sogojigyoShuruiSearchResult = null;
            SogoJigyoShuruiShikyuGendoGaku entity;
            for (SogojigyoShuruiSearchResult result : 総合事業種類情報) {
                if (result.get要支援1() != null) {
                    entity = result.get要支援1();
                } else if (result.get要支援2() != null) {
                    entity = result.get要支援2();
                } else {
                    entity = result.get二次予防();
                }
                if (適用開始年月.equals(entity.get適用開始年月())
                        && サービス種類コード.equals(entity.getサービス種類コード())) {
                    sogojigyoShuruiSearchResult = result;
                }
            }
            SogoJigyoShuruiShikyuGendoGaku 要支援1Entity = null;
            SogoJigyoShuruiShikyuGendoGaku 要支援2Entity = null;
            SogoJigyoShuruiShikyuGendoGaku 二次予防Entity = null;
            if (sogojigyoShuruiSearchResult != null) {
                要支援1Entity = sogojigyoShuruiSearchResult.get要支援1();
                要支援2Entity = sogojigyoShuruiSearchResult.get要支援2();
                二次予防Entity = sogojigyoShuruiSearchResult.get二次予防();
            }
            if (修正.equals(保存モード)) {
                modify情報(manager, 要支援1Entity, 要支援2Entity, 二次予防Entity, 適用開始年月, サービス種類コード);
            } else {
                delete情報(manager, 要支援1Entity, 要支援2Entity, 二次予防Entity);
            }
        }
    }

    private void modify情報(SogoJigyoShuruiShikyuGendoGakuManager manager, SogoJigyoShuruiShikyuGendoGaku 要支援1Entity,
            SogoJigyoShuruiShikyuGendoGaku 要支援2Entity, SogoJigyoShuruiShikyuGendoGaku 二次予防Entity,
            FlexibleYearMonth 適用開始年月, ServiceShuruiCode サービス種類コード) {

        if (要支援1Entity == null) {
            要支援1Entity = new SogoJigyoShuruiShikyuGendoGaku(サービス種類コード, 要支援1, 適用開始年月, 履歴番号);
            if (div.getTxtTekiyoShuryoYM().getValue() != null) {
                要支援1Entity = 要支援1Entity.createBuilderForEdit().set支給限度単位数(div.getTxtYoShien1().getValue())
                        .set適用終了年月(new FlexibleYearMonth(div.getTxtTekiyoShuryoYM().getValue().getYearMonth().toDateString()))
                        .build();
            } else {
                要支援1Entity = 要支援1Entity.createBuilderForEdit().set支給限度単位数(div.getTxtYoShien1().getValue()).build();
            }
            要支援1Entity = 要支援1Entity.added();
        } else {
            if (div.getTxtTekiyoShuryoYM().getValue() != null) {
                要支援1Entity = 要支援1Entity.createBuilderForEdit().set支給限度単位数(div.getTxtYoShien1().getValue())
                        .set適用終了年月(new FlexibleYearMonth(div.getTxtTekiyoShuryoYM().getValue().getYearMonth().toDateString()))
                        .build();
            } else {
                要支援1Entity = 要支援1Entity.createBuilderForEdit().set支給限度単位数(div.getTxtYoShien1().getValue()).build();
            }
            要支援1Entity = 要支援1Entity.modified();
        }
        if (要支援2Entity == null) {
            要支援2Entity = new SogoJigyoShuruiShikyuGendoGaku(サービス種類コード, 要支援2, 適用開始年月, 履歴番号);
            if (div.getTxtTekiyoShuryoYM().getValue() != null) {
                要支援2Entity = 要支援2Entity.createBuilderForEdit().set支給限度単位数(div.getTxtYoShien2().getValue())
                        .set適用終了年月(new FlexibleYearMonth(div.getTxtTekiyoShuryoYM().getValue().getYearMonth().toDateString()))
                        .build();
            } else {
                要支援2Entity = 要支援2Entity.createBuilderForEdit().set支給限度単位数(div.getTxtYoShien2().getValue()).build();
            }
            要支援2Entity = 要支援2Entity.added();
        } else {
            if (div.getTxtTekiyoShuryoYM().getValue() != null) {
                要支援2Entity = 要支援2Entity.createBuilderForEdit().set支給限度単位数(div.getTxtYoShien2().getValue())
                        .set適用終了年月(new FlexibleYearMonth(div.getTxtTekiyoShuryoYM().getValue().getYearMonth().toDateString()))
                        .build();
            } else {
                要支援2Entity = 要支援2Entity.createBuilderForEdit().set支給限度単位数(div.getTxtYoShien2().getValue()).build();
            }
            要支援2Entity = 要支援2Entity.modified();
        }
        if (二次予防Entity == null) {
            二次予防Entity = new SogoJigyoShuruiShikyuGendoGaku(サービス種類コード, 二次予防, 適用開始年月, 履歴番号);
            if (div.getTxtTekiyoShuryoYM().getValue() != null) {
                二次予防Entity = 二次予防Entity.createBuilderForEdit().set支給限度単位数(div.getTxtNijiYobo().getValue())
                        .set適用終了年月(new FlexibleYearMonth(div.getTxtTekiyoShuryoYM().getValue().getYearMonth().toDateString()))
                        .build();
            } else {
                二次予防Entity = 二次予防Entity.createBuilderForEdit().set支給限度単位数(div.getTxtNijiYobo().getValue()).build();
            }
            二次予防Entity = 二次予防Entity.added();
        } else {
            if (div.getTxtTekiyoShuryoYM().getValue() != null) {
                二次予防Entity = 二次予防Entity.createBuilderForEdit().set支給限度単位数(div.getTxtNijiYobo().getValue())
                        .set適用終了年月(new FlexibleYearMonth(div.getTxtTekiyoShuryoYM().getValue().getYearMonth().toDateString()))
                        .build();
            } else {
                二次予防Entity = 二次予防Entity.createBuilderForEdit().set支給限度単位数(div.getTxtNijiYobo().getValue()).build();
            }
            二次予防Entity = 二次予防Entity.modified();
        }
        manager.save介護予防_日常生活支援総合事業種類支給限度額(要支援1Entity);
        manager.save介護予防_日常生活支援総合事業種類支給限度額(要支援2Entity);
        manager.save介護予防_日常生活支援総合事業種類支給限度額(二次予防Entity);
    }

    private void delete情報(SogoJigyoShuruiShikyuGendoGakuManager manager, SogoJigyoShuruiShikyuGendoGaku 要支援1Entity,
            SogoJigyoShuruiShikyuGendoGaku 要支援2Entity, SogoJigyoShuruiShikyuGendoGaku 二次予防Entity
    ) {
        if (要支援1Entity != null) {
            manager.save介護予防_日常生活支援総合事業種類支給限度額(要支援1Entity.deleted());
        }
        if (要支援2Entity != null) {
            manager.save介護予防_日常生活支援総合事業種類支給限度額(要支援2Entity.deleted());
        }
        if (二次予防Entity != null) {
            manager.save介護予防_日常生活支援総合事業種類支給限度額(二次予防Entity.deleted());
        }
    }

}
