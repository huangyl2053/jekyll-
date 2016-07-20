/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1730011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoKubunShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoKubunShikyuGendoGakuBuilder;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1730011.SogoJigyoKubunShikyuGendogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1730011.dgShikyuGendogaku_Row;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;

/**
 * 総合事業区分支給限度額登録のHandlerクラスです。
 *
 * @reamsid_L DBC-3363-010 xuxin
 */
public class SogoJigyoKubunShikyuGendogakuHandler {

    private final SogoJigyoKubunShikyuGendogakuDiv div;

    private static final RString 要支援1 = new RString("12");
    private static final RString 要支援2 = new RString("13");
    private static final RString 二次予防 = new RString("01");
    private static final RString 履歴番号 = new RString("0001");

    /**
     * コンストラクタです。
     *
     * @param div SogoJigyoKubunShikyuGendogakuDiv
     */
    public SogoJigyoKubunShikyuGendogakuHandler(SogoJigyoKubunShikyuGendogakuDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時の動作です。
     *
     * @param businessList List<SogoJigyoKubunShikyuGendoGaku>
     */
    public void initialize(List<SogoJigyoKubunShikyuGendoGaku> businessList) {

        div.getBtnTsuika().setDisabled(false);
        List<dgShikyuGendogaku_Row> dataSource = new ArrayList<>();
        for (SogoJigyoKubunShikyuGendoGaku result : businessList) {
            dgShikyuGendogaku_Row row = new dgShikyuGendogaku_Row();
            row.setJotai(result.get要介護状態区分());
            row.getTekiyoKaishi().setValue(new RDate(result.get適用開始年月().getYearValue(), result.get適用開始年月().getMonthValue(), 1));
            if (result.get適用終了年月() != null) {
                row.getTekiyoShuryo().setValue(new RDate(result.get適用終了年月().getYearValue(), result.get適用終了年月().getMonthValue(), 1));
            }
            if (要支援1.equals(result.get要介護状態区分())) {
                row.getYoShien1().setValue(result.get支給限度単位数());
            }
            if (要支援2.equals(result.get要介護状態区分())) {
                row.getYoShien2().setValue(result.get支給限度単位数());
            }
            if (二次予防.equals(result.get要介護状態区分())) {
                row.getNijiYobo().setValue(result.get支給限度単位数());
            }
            dataSource.add(row);
        }
        div.getDgShikyuGendogaku().setDataSource(dataSource);
        clear詳細内容();
        set詳細入力不可();
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
     * 画面詳細パネル各項目内容をクリアします。
     */
    private void clear詳細内容() {
        div.getTxtTekiyoKaishiYM().clearDomain();
        div.getTxtTekiyoShuryoYM().clearDomain();
        div.getTxtYoShien1().clearValue();
        div.getTxtYoShien2().clearValue();
        div.getTxtNijiYobo().clearValue();
    }

    /**
     * 総合事業区分支給限度額登録一覧DataGridの「修正」「削除」ボタン、「追加する」ボタンは使用不可です。
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
     * 総合事業区分支給限度額登録一覧DataGrid．「修正」ボタン押下時の処理です。
     */
    public void set修正状態() {
        setBtn非活性();
        set詳細可入力();
        set選択行内容表示();
    }

    /**
     * 総合事業区分支給限度額登録一覧DataGrid選択行の内容が詳細パネルに表示します。
     */
    private void set選択行内容表示() {
        dgShikyuGendogaku_Row row = div.getDgShikyuGendogaku().getClickedItem();
        div.getTxtTekiyoKaishiYM().setDomain(row.getTekiyoKaishi().getValue().getYearMonth());
        if (!row.getTekiyoShuryo().getText().isNullOrEmpty()) {
            div.getTxtTekiyoShuryoYM().setDomain(row.getTekiyoShuryo().getValue().getYearMonth());
        }
        if (要支援1.equals(row.getJotai())) {
            div.getTxtYoShien1().setValue(row.getYoShien1().getValue());
        }
        if (要支援2.equals(row.getJotai())) {
            div.getTxtYoShien2().setValue(row.getYoShien2().getValue());
        }
        if (二次予防.equals(row.getJotai())) {
            div.getTxtNijiYobo().setValue(row.getNijiYobo().getValue());
        }
    }

    /**
     * 総合事業区分支給限度額登録一覧DataGrid．「削除」ボタン押下時の処理です。
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
     * @return SogoJigyoKubunShikyuGendoGaku
     */
    public SogoJigyoKubunShikyuGendoGaku get総合事業区分情報() {

        SogoJigyoKubunShikyuGendoGaku result;
        if (!div.getTxtYoShien1().getText().isNullOrEmpty()) {
            result = new SogoJigyoKubunShikyuGendoGaku(要支援1, new FlexibleYearMonth(div.getTxtTekiyoKaishiYM().getDomain().toDateString()), Integer.parseInt(履歴番号.toString()));
        } else if (!div.getTxtYoShien2().getText().isNullOrEmpty()) {
            result = new SogoJigyoKubunShikyuGendoGaku(要支援2, new FlexibleYearMonth(div.getTxtTekiyoKaishiYM().getDomain().toDateString()), Integer.parseInt(履歴番号.toString()));
        } else {
            result = new SogoJigyoKubunShikyuGendoGaku(二次予防, new FlexibleYearMonth(div.getTxtTekiyoKaishiYM().getDomain().toDateString()), Integer.parseInt(履歴番号.toString()));
        }
        SogoJigyoKubunShikyuGendoGakuBuilder builder = result.createBuilderForEdit();
        if (div.getTxtTekiyoShuryoYM().getDomain() != null) {
            builder.set適用終了年月(new FlexibleYearMonth(div.getTxtTekiyoShuryoYM().getDomain().toDateString()));
        }
        if (!div.getTxtYoShien1().getText().isNullOrEmpty()) {
            builder.set支給限度単位数(div.getTxtYoShien1().getValue());
        }
        if (!div.getTxtYoShien2().getText().isNullOrEmpty()) {
            builder.set支給限度単位数(div.getTxtYoShien2().getValue());
        }
        if (!div.getTxtNijiYobo().getText().isNullOrEmpty()) {
            builder.set支給限度単位数(div.getTxtNijiYobo().getValue());
        }
        return builder.build();
    }

    /**
     * 修正モードの保存処理です。
     *
     * @param result SogoJigyoKubunShikyuGendoGaku
     * @return SogoJigyoKubunShikyuGendoGaku
     */
    public SogoJigyoKubunShikyuGendoGaku get総合事業区分情報(SogoJigyoKubunShikyuGendoGaku result) {

        SogoJigyoKubunShikyuGendoGakuBuilder builder = result.createBuilderForEdit();
        builder.set適用開始年月(new FlexibleYearMonth(div.getTxtTekiyoKaishiYM().getDomain().toDateString()));
        if (div.getTxtTekiyoShuryoYM().getDomain() != null) {
            builder.set適用終了年月(new FlexibleYearMonth(div.getTxtTekiyoShuryoYM().getDomain().toDateString()));
        }
        if (!div.getTxtYoShien1().getText().isNullOrEmpty()) {
            builder.set支給限度単位数(div.getTxtYoShien1().getValue());
            builder.set要介護状態区分(要支援1);
        }
        if (!div.getTxtYoShien2().getText().isNullOrEmpty()) {
            builder.set支給限度単位数(div.getTxtYoShien2().getValue());
            builder.set要介護状態区分(要支援2);
        }
        if (!div.getTxtNijiYobo().getText().isNullOrEmpty()) {
            builder.set支給限度単位数(div.getTxtNijiYobo().getValue());
            builder.set要介護状態区分(二次予防);
        }
        return builder.build();
    }

}
