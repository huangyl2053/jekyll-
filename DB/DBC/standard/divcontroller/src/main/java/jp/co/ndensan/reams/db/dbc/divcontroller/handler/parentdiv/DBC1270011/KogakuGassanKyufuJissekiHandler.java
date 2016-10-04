/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1270011;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanKyufuJisseki;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufusakuseikubun.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1270011.KogakuGassanKyufuJissekiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1270011.dgRireki_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 高額合算給付実績照会のコントローラです。
 *
 * @reamsid_L DBC-3010-010 linghuhang
 */
public class KogakuGassanKyufuJissekiHandler {

    private final KogakuGassanKyufuJissekiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 高額合算給付実績照会Div
     */
    public KogakuGassanKyufuJissekiHandler(KogakuGassanKyufuJissekiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 高額合算給付実績情報 高額合算給付実績情報
     * @param isデータ存在 isデータ存在
     */
    public void onLoad(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード,
            List<KogakuGassanKyufuJisseki> 高額合算給付実績情報, boolean isデータ存在) {
        div.getKogakuGassanKyufuJissekiKihon().initialize(識別コード);
        div.getKogakuGassanKyufuJissekiKaigoKihon().initialize(被保険者番号);
        set一覧(高額合算給付実績情報, isデータ存在);
    }

    /**
     * 選択ボタンを押下する場合、画面詳細を表示する。
     *
     * @param row 選択データ
     */
    public void onclik_selectButton(dgRireki_Row row) {
        div.getTxtKokanShikibetsu().setValue(row.getTxtKokanShikibetsu());
        div.getTxtShikyuShinseishoSeiriNO().setValue(row.getTxtShikyuShinseishoSeiriNo());
        div.getTxtJikofutangakuShomeishoSeiriNO().setValue(row.getTxtJikoFutanSeiriNo());
        div.getTxtSakuseiKBN().setValue(row.getTxtSakuseiKubun());
        div.getTxtHokeshaNO().setValue(row.getTxtHokenshaNo());
        if (!RString.isNullOrEmpty(row.getTxtShinseiYMD())) {
            div.getTxtShinseiYMD().setValue(new RDate(row.getTxtShinseiYMD().toString()));
        }
        if (!RString.isNullOrEmpty(row.getTxtKetteiYMD())) {
            div.getTxtKetteiYMD().setValue(new RDate(row.getTxtKetteiYMD().toString()));
        }
        if (!RString.isNullOrEmpty(row.getTxtShikyugaku())) {
            div.getTxtJikofutangaku().setValue(to金額(row.getTxtShikyugaku()));
            div.getTxtShikyugaku().setValue(to金額(row.getTxtShikyugaku()));
        } else {
            div.getTxtJikofutangaku().setValue(new Decimal(0));
            div.getTxtShikyugaku().setValue(new Decimal(0));
        }
        if (!RString.isNullOrEmpty(row.getTxtShoriYM())) {
            div.getTxtShoriYMD().setValue(new RDate(row.getTxtShoriYM().toString()));
        }
        if (!RString.isNullOrEmpty(row.getTxtUketoriNengetsu())) {
            div.getTxtUketoriYMD().setValue(new RDate(row.getTxtUketoriNengetsu().toString()));
        }
        if (!RString.isNullOrEmpty(row.getTxtSofuNengetsu())) {
            div.getTxtSoufuYMD().setValue(new RDate(row.getTxtSofuNengetsu().toString()));
        }
    }

    private void set一覧(List<KogakuGassanKyufuJisseki> 高額合算給付実績情報, boolean isデータ存在) {
        List<dgRireki_Row> rowList = new ArrayList<>();
        List<dgRireki_Row> 一覧データ = new ArrayList<>();
        if (!div.getChkRirekiHyoji().isAllSelected()) {
            高額合算給付実績情報 = get履歴を抽出チェックオフ(高額合算給付実績情報);
        } else {
            一覧データ = div.getDgRireki().getDataSource();
        }
        for (KogakuGassanKyufuJisseki 高額合算給付実績 : 高額合算給付実績情報) {
            dgRireki_Row row = new dgRireki_Row();
            if (isデータ存在) {
                row.setSelectButtonState(DataGridButtonState.Disabled);
            }
            row.setTxtKokanShikibetsu(get交換情報識別番号(高額合算給付実績.get交換情報識別番号()));
            row.setTxtShikyuShinseishoSeiriNo(高額合算給付実績.get支給申請書整理番号());
            row.setTxtJikoFutanSeiriNo(高額合算給付実績.get自己負担額証明書整理番号());
            row.setTxtSakuseiKubun(get作成区分(高額合算給付実績.get給付実績作成区分コード()));
            row.setTxtHokenshaNo(get証記載保険者番号(高額合算給付実績.get証記載保険者番号()));
            row.setTxtShinseiYMD(get日期転換(高額合算給付実績.get申請年月日()));
            row.setTxtKetteiYMD(get日期転換(高額合算給付実績.get決定年月日()));
            row.setTxtShikyugaku(get金額(高額合算給付実績.get支給額()));
            row.setTxtShoriYM(get日期転換(高額合算給付実績.get処理年月()));
            row.setTxtUketoriNengetsu(get日期転換(高額合算給付実績.get受取年月()));
            row.setTxtSofuNengetsu(get日期転換(高額合算給付実績.get送付年月()));
            row.setTxtHihokenshaNo(高額合算給付実績.get被保険者番号().value());
            row.setTxtSeiriNo(高額合算給付実績.get整理番号());
            if (div.getChkRirekiHyoji().isAllSelected() && is履歴を抽出チェックオン(get交換情報識別番号(高額合算給付実績.get交換情報識別番号()),
                    高額合算給付実績.get被保険者番号().value(), 高額合算給付実績.get支給申請書整理番号(),
                    高額合算給付実績.get整理番号(), 一覧データ)) {
                row.setRowBgColor(DataGridCellBgColor.bgColorLightRed);
            }
            rowList.add(row);
        }
        div.getDgRireki().setDataSource(rowList);
    }

    private List<KogakuGassanKyufuJisseki> get履歴を抽出チェックオフ(List<KogakuGassanKyufuJisseki> 高額合算給付実績情報) {
        List<KogakuGassanKyufuJisseki> チェックオフデータ = new ArrayList<>();
        List<KogakuGassanKyufuJisseki> チェックオフ = new ArrayList<>();
        RString 同支給申請書整理番号 = RString.EMPTY;
        RString 最大整理番号 = RString.EMPTY;
        int 高額合算給付実績件数 = 0;
        for (KogakuGassanKyufuJisseki 高額合算給付実績 : 高額合算給付実績情報) {
            if (高額合算給付実績.get処理年月() == null || 高額合算給付実績.get処理年月().isEmpty()) {
                チェックオフデータ.add(高額合算給付実績);
            }
        }
        if (!チェックオフデータ.isEmpty()) {
            Collections.sort(チェックオフデータ, new KogakuGassanKyufuJissekiHandler.DateComparator());
            for (KogakuGassanKyufuJisseki 高額合算給付実績 : チェックオフデータ) {
                if (高額合算給付実績件数 == 0) {
                    最大整理番号 = 高額合算給付実績.get整理番号();
                    チェックオフ.add(高額合算給付実績);
                }
                if (!RString.isNullOrEmpty(同支給申請書整理番号) && (!同支給申請書整理番号.equals(高額合算給付実績.get支給申請書整理番号())
                        || 最大整理番号.equals(高額合算給付実績.get整理番号()))) {
                    最大整理番号 = 高額合算給付実績.get整理番号();
                    チェックオフ.add(高額合算給付実績);
                }
                同支給申請書整理番号 = 高額合算給付実績.get支給申請書整理番号();
                高額合算給付実績件数 = 高額合算給付実績件数 + 1;
            }
        }
        最大整理番号 = RString.EMPTY;
        同支給申請書整理番号 = RString.EMPTY;
        FlexibleYearMonth 最大処理年月 = FlexibleYearMonth.EMPTY;
        if (チェックオフ.isEmpty()) {
            Collections.sort(高額合算給付実績情報, new KogakuGassanKyufuJissekiHandler.SyoliDateComparator());
            高額合算給付実績件数 = 0;
            for (KogakuGassanKyufuJisseki kyufuJisseki : 高額合算給付実績情報) {
                if (高額合算給付実績件数 == 0) {
                    最大整理番号 = kyufuJisseki.get整理番号();
                    最大処理年月 = kyufuJisseki.get処理年月();
                    チェックオフ.add(kyufuJisseki);
                }
                if (!RString.isNullOrEmpty(同支給申請書整理番号) && 最大処理年月.equals(kyufuJisseki.get処理年月())
                        && (!同支給申請書整理番号.equals(kyufuJisseki.get支給申請書整理番号())
                        || 最大整理番号.equals(kyufuJisseki.get整理番号()))) {
                    最大整理番号 = kyufuJisseki.get整理番号();
                    最大処理年月 = kyufuJisseki.get処理年月();
                    チェックオフ.add(kyufuJisseki);
                }
                同支給申請書整理番号 = kyufuJisseki.get支給申請書整理番号();
                高額合算給付実績件数 = 高額合算給付実績件数 + 1;
            }
        }
        return チェックオフ;
    }

    private boolean is履歴を抽出チェックオン(RString 交換情報識別番号, RString 被保険者番号,
            RString 支給申請書整理番号, RString 整理番号, List<dgRireki_Row> rowList) {
        for (dgRireki_Row row : rowList) {
            if (交換情報識別番号.equals(row.getTxtKokanShikibetsu()) && 被保険者番号.equals(row.getTxtHihokenshaNo())
                    && 支給申請書整理番号.equals(row.getTxtShikyuShinseishoSeiriNo()) && 整理番号.equals(row.getTxtSeiriNo())) {
                return false;
            }
        }
        return true;
    }

    private RString get交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        if (交換情報識別番号 != null && !交換情報識別番号.isEmpty()) {
            return 交換情報識別番号.value();
        }
        return RString.EMPTY;
    }

    private RString get作成区分(RString 給付実績作成区分コード) {
        if (!RString.isNullOrEmpty(給付実績作成区分コード)) {
            return KyufuSakuseiKubun.toValue(給付実績作成区分コード).get名称();
        }
        return RString.EMPTY;
    }

    private RString get証記載保険者番号(HokenshaNo 証記載保険者番号) {
        if (証記載保険者番号 != null && !証記載保険者番号.isEmpty()) {
            return 証記載保険者番号.value();
        }
        return RString.EMPTY;
    }

    private RString get日期転換(FlexibleDate 日期) {
        if (日期 != null && !日期.isEmpty()) {
            return 日期.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString get日期転換(FlexibleYearMonth 日期) {
        if (日期 != null && !日期.isEmpty()) {
            return 日期.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString get金額(Decimal 金額) {
        if (金額 != null) {
            return DecimalFormatter.toコンマ区切りRString(金額, 0);
        }
        return new RString("0");
    }

    private Decimal to金額(RString 金額) {
        RStringBuilder builder = new RStringBuilder();
        List<RString> kinnlist = 金額.split(",");
        for (RString kinn : kinnlist) {
            builder.append(kinn);
        }
        return new Decimal(builder.toString());
    }

    private static class DateComparator implements Comparator<KogakuGassanKyufuJisseki>, Serializable {

        @Override
        public int compare(KogakuGassanKyufuJisseki o1, KogakuGassanKyufuJisseki o2) {
            int 高額合算給付実績 = o2.get支給申請書整理番号().compareTo(o1.get支給申請書整理番号());
            if (高額合算給付実績 == 0) {
                return o2.get整理番号().compareTo(o1.get整理番号());
            }
            return 高額合算給付実績;
        }
    }

    private static class SyoliDateComparator implements Comparator<KogakuGassanKyufuJisseki>, Serializable {

        @Override
        public int compare(KogakuGassanKyufuJisseki o1, KogakuGassanKyufuJisseki o2) {
            int 高額合算給付実績 = o2.get支給申請書整理番号().compareTo(o1.get支給申請書整理番号());
            if (高額合算給付実績 == 0) {
                int 処理年月 = o2.get処理年月().compareTo(o1.get処理年月());
                if (処理年月 == 0) {
                    return o2.get整理番号().compareTo(o1.get整理番号());
                }
                return 処理年月;
            }
            return 高額合算給付実績;
        }
    }
}
