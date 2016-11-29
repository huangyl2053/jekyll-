/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikohijukyusha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 総合事業費公費受給者別一覧表帳票BodyEditor。
 *
 * @reamsid_L DBC-4710-040 chenjie
 */
public class SogojigyohiKohiJukyushaBodyEditor implements ISogojigyohiKohiJukyushaEditor {

    private final SogojigyohiKohiJukyushaEntity 帳票出力対象データ;
    private final boolean 集計Flag;
    private static final int EIGHT = 8;
    private static final Code CODE = new Code("0003");
    private static final RString NAME = new RString("被保険者番号");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ SogojigyohiKohiJukyushaEntity
     * @param 集計Flag boolean
     */
    public SogojigyohiKohiJukyushaBodyEditor(SogojigyohiKohiJukyushaEntity 帳票出力対象データ,
            boolean 集計Flag) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.集計Flag = 集計Flag;
    }

    @Override
    public SogojigyohiKohiJukyushaSource edit(SogojigyohiKohiJukyushaSource source) {
        if (集計Flag) {
            edit集計(source);
        }
        edit明細(source);
        setPageBreakEmpty(source);
        return source;
    }

    private void setPageBreakEmpty(SogojigyohiKohiJukyushaSource source) {
        if (source.kohiFutanshaNo == null) {
            source.kohiFutanshaNo = RString.EMPTY;
        }
        if (source.yubinNo == null) {
            source.yubinNo = RString.EMPTY;
        }
        if (source.choikiCode == null) {
            source.choikiCode = RString.EMPTY;
        }
        if (source.gyoseikuCode == null) {
            source.gyoseikuCode = RString.EMPTY;
        }
        if (source.shimei50onKana == null) {
            source.shimei50onKana = RString.EMPTY;
        }
        if (source.shichosonCode == null) {
            source.shichosonCode = RString.EMPTY;
        }
        if (source.listUpper_10 == null) {
            source.listUpper_10 = RString.EMPTY;
        }
    }

    private void edit明細(SogojigyohiKohiJukyushaSource source) {
        source.listUpper_1 = 帳票出力対象データ.get公費受給者番号();
        source.listUpper_2 = doパターン54(帳票出力対象データ.getサービス提供年月());
        source.listUpper_3 = 帳票出力対象データ.get事業者番号();
        source.listLower_1 = 帳票出力対象データ.get事業者名();
        List<RString> サービス種類名 = spiltItem(帳票出力対象データ.getサービス種類名());
        source.listUpper_4 = サービス種類名.get(0);
        source.listLower_2 = サービス種類名.get(1);
        List<RString> サービス項目名 = spiltItem(帳票出力対象データ.getサービス項目名());
        source.listUpper_5 = サービス項目名.get(0);
        source.listLower_3 = サービス項目名.get(1);
        source.listUpper_6 = decimalFormatter(帳票出力対象データ.get日数回数(), 0);
        source.listUpper_7 = decimalFormatter(帳票出力対象データ.get公費対象単位数(), 0);
        source.listUpper_8 = decimalFormatter(帳票出力対象データ.get公費負担金額(), 0);
        source.listUpper_9 = decimalFormatter(帳票出力対象データ.get公費分本人負担額(), 0);
        source.listUpper_10 = getColumnValue(帳票出力対象データ.get登録被保険者番号());
        source.listLower_4 = 帳票出力対象データ.get宛名名称();
        source.listUpper_11 = getColumnValue(帳票出力対象データ.get証記載保険者番号());
        source.shikibetsuCode = getColumnValue(帳票出力対象データ.get識別コード());
        source.拡張情報 = new ExpandedInformation(CODE, NAME, source.listUpper_10);
        source.yubinNo = 帳票出力対象データ.get郵便番号();
        source.choikiCode = 帳票出力対象データ.get町域コード();
        source.gyoseikuCode = 帳票出力対象データ.get行政区コード();
        source.shimei50onKana = 帳票出力対象データ.get氏名５０音カナ();
        source.shichosonCode = getColumnValue(帳票出力対象データ.get市町村コード());
    }

    private void edit集計(SogojigyohiKohiJukyushaSource source) {
        source.kohiTensuGokei = decimalFormatter(帳票出力対象データ.get公費対象単位数集計(), 0);
        source.kohiFutanGakuGokei = decimalFormatter(帳票出力対象データ.get公費負担金額集計(), 0);
        source.kohiHonninFutanGakuGokei = decimalFormatter(帳票出力対象データ.get公費分本人負担額集計(), 0);
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private List<RString> spiltItem(RString item) {
        List<RString> twoPart = new ArrayList<>();
        RString upPart;
        RString downPart;
        if (null == item) {
            upPart = RString.EMPTY;
            downPart = RString.EMPTY;
        } else if (item.length() <= EIGHT) {
            upPart = item;
            downPart = RString.EMPTY;
        } else {
            upPart = item.substring(0, EIGHT);
            downPart = item.substring(EIGHT);
        }
        twoPart.add(upPart);
        twoPart.add(downPart);
        return twoPart;
    }

    private RString decimalFormatter(RString 額, int count) {
        if (null == 額) {
            return RString.EMPTY;
        }
        if (Decimal.canConvert(額)) {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(額.toString()), count);
        }
        return 額;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
