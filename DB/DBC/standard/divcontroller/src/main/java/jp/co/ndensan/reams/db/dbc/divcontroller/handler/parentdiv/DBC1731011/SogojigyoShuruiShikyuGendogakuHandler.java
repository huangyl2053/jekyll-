/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1731011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoShuruiShikyuGendoGakuBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.sogojigyoshurui.SogojigyoShuruiSearchResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1731011.SogojigyoShuruiShikyuGendogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1731011.dgShikyuGendogaku_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;

/**
 * 総合事業種類支給限度額登録のHandlerクラスです。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
public class SogojigyoShuruiShikyuGendogakuHandler {

    private static final RString 要支援1 = new RString("12");
    private static final RString 要支援2 = new RString("13");
    private static final RString 二次予防 = new RString("01");
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
        List<dgShikyuGendogaku_Row> dataSource = new ArrayList<>();
        for (SogojigyoShuruiSearchResult result : resultList) {
            dgShikyuGendogaku_Row row = new dgShikyuGendogaku_Row();
            row.setDefaultDataName0(result.getサービス種類コード());
            row.getDefaultDataName1().setValue(new RDate(result.get適用開始年月().getYearValue(), result.get適用開始年月().getMonthValue(), 1));
            if (result.get適用終了年月() != null) {
                row.getDefaultDataName2().setValue(new RDate(result.get適用終了年月().getYearValue(), result.get適用終了年月().getMonthValue(), 1));
            }
            row.getDefaultDataName3().setValue(result.get要支援1());
            row.getDefaultDataName4().setValue(result.get要支援2());
            row.getDefaultDataName5().setValue(result.get二次予防());
            dataSource.add(row);
        }
        div.getDgShikyuGendogaku().setDataSource(dataSource);
        clear詳細内容();
        set詳細入力不可();
    }

    /**
     * 画面詳細パネル各項目内容をクリアします。
     */
    private void clear詳細内容() {
        div.getTxtTekiyoKaishiYM().clearValue();
        div.getTxtTekiyoShuryoYM().clearValue();
        div.getTxtYoShien1().clearValue();
        div.getTxtYoShien2().clearValue();
        div.getTxtNijiYobo().clearValue();
    }

    /**
     * 画面詳細パネル各項目入力不可の状態です。
     */
    private void set詳細入力不可() {
        div.getTxtTekiyoKaishiYM().setReadOnly(true);
        div.getTxtTekiyoShuryoYM().setReadOnly(true);
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
    }

    /**
     * 総合事業種類支給限度額登録一覧DataGrid選択行の内容が詳細パネルに表示します。
     */
    private void set選択行内容表示() {
        dgShikyuGendogaku_Row row = div.getDgShikyuGendogaku().getClickedItem();
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
     * 登録モードの保存処理です。
     *
     * @return List<SogoJigyoShuruiShikyuGendoGaku>
     */
    public List<SogoJigyoShuruiShikyuGendoGaku> get総合事業種類情報() {

        List<SogoJigyoShuruiShikyuGendoGaku> resultList = new ArrayList<>();
        //TODO
        SogoJigyoShuruiShikyuGendoGaku result1 = new SogoJigyoShuruiShikyuGendoGaku(new ServiceShuruiCode("82"),
                要支援1, new FlexibleYearMonth(div.getTxtTekiyoKaishiYM().getValue().getYearMonth().toDateString()), 履歴番号);
        SogoJigyoShuruiShikyuGendoGaku result2 = new SogoJigyoShuruiShikyuGendoGaku(new ServiceShuruiCode("82"),
                要支援2, new FlexibleYearMonth(div.getTxtTekiyoKaishiYM().getValue().getYearMonth().toDateString()), 履歴番号);
        SogoJigyoShuruiShikyuGendoGaku result3 = new SogoJigyoShuruiShikyuGendoGaku(new ServiceShuruiCode("82"),
                二次予防, new FlexibleYearMonth(div.getTxtTekiyoKaishiYM().getValue().getYearMonth().toDateString()), 履歴番号);
        resultList.add(builder情報(result1));
        resultList.add(builder情報(result2));
        resultList.add(builder情報(result3));
        return resultList;
    }

    private SogoJigyoShuruiShikyuGendoGaku builder情報(SogoJigyoShuruiShikyuGendoGaku result) {
        SogoJigyoShuruiShikyuGendoGakuBuilder builder = result.createBuilderForEdit();
        if (!div.getTxtTekiyoShuryoYM().getText().isNullOrEmpty()) {
            builder.set適用終了年月(new FlexibleYearMonth(div.getTxtTekiyoShuryoYM().getValue().getYearMonth().toDateString()));
        }
        if (要支援1.equals(result.get要介護状態区分())) {
            builder.set支給限度単位数(div.getTxtYoShien1().getValue());
        }
        if (要支援2.equals(result.get要介護状態区分())) {
            builder.set支給限度単位数(div.getTxtYoShien2().getValue());
        }
        if (二次予防.equals(result.get要介護状態区分())) {
            builder.set支給限度単位数(div.getTxtNijiYobo().getValue());
        }
        return builder.build();
    }

}
