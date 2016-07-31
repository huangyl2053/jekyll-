/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujissekikoshinkekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.chohyoshutsuryokutaishodate.ChohyoShutsuryokuTaishoDateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinkekkaichiran.KyufujissekiKoshinkekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBC200054_給付実績更新結果情報一覧表 Editor
 *
 * @reamsid_L DBC-2470-030 sunhui
 */
public class KyufujissekiKoshinkekkaIchiranEditor implements IKyufujissekiKoshinkekkaIchiranEditor {

    private final FlexibleYearMonth 処理年月;
    private final List<ChohyoShutsuryokuTaishoDateEntity> entityList;
    private final Association association;
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final List<RString> 改頁項目List;
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final RString SAKUSEI = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param 処理年月 FlexibleYearMonth
     * @param entityList List<ChohyoShutsuryokuTaishoDateEntity>
     * @param association Association
     * @param 並び順の１件目 RString
     * @param 並び順の２件目 RString
     * @param 並び順の３件目 RString
     * @param 並び順の４件目 RString
     * @param 並び順の５件目 RString
     * @param 改頁項目List List<RString>
     */
    public KyufujissekiKoshinkekkaIchiranEditor(
            FlexibleYearMonth 処理年月,
            List<ChohyoShutsuryokuTaishoDateEntity> entityList,
            Association association,
            RString 並び順の１件目,
            RString 並び順の２件目,
            RString 並び順の３件目,
            RString 並び順の４件目,
            RString 並び順の５件目,
            List<RString> 改頁項目List) {
        this.処理年月 = 処理年月;
        this.entityList = entityList;
        this.association = association;
        this.並び順の１件目 = 並び順の１件目;
        this.並び順の２件目 = 並び順の２件目;
        this.並び順の３件目 = 並び順の３件目;
        this.並び順の４件目 = 並び順の４件目;
        this.並び順の５件目 = 並び順の５件目;
        this.改頁項目List = 改頁項目List;
    }

    /**
     * 帳票設計_DBC200054_給付実績更新結果情報一覧表の項目編集です
     *
     * @param source KyufujissekiKoshinkekkaIchiranSource
     * @return KyufujissekiKoshinkekkaIchiranSource
     */
    @Override
    public KyufujissekiKoshinkekkaIchiranSource edit(KyufujissekiKoshinkekkaIchiranSource source) {
        RString 帳票作成年月日 = YMDHMS.now().getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 帳票作成時 = YMDHMS.now().getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = 帳票作成年月日.concat(RString.HALF_SPACE).concat(帳票作成時)
                .concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.shoriYM = 処理年月.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        if (entityList != null) {
            source.hokenshaNo = entityList.get(0).get保険者番号();
            source.hokenshaName = entityList.get(0).get保険者名();
            source.shutsuryokujun1 = 並び順の１件目;
            source.shutsuryokujun2 = 並び順の２件目;
            source.shutsuryokujun3 = 並び順の３件目;
            source.shutsuryokujun4 = 並び順の４件目;
            source.shutsuryokujun5 = 並び順の５件目;
            set出力順And改ページ(source);
            int i = 1;
            source.listUpper_1 = new RString(i);
            source.listUpper_2 = entityList.get(0).get入力識別番号();
            source.listUpper_3 = entityList.get(0).get入力識別名称_上段();
            source.listUpper_4 = entityList.get(0).get作成区分コード();
            source.listUpper_5 = entityList.get(0).get被保険者番号();
            source.listUpper_6 = entityList.get(0).get宛名カナ名称();
            source.listUpper_7 = entityList.get(0).getサービス提供年月().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString();
            source.listUpper_8 = entityList.get(0).get給付実績区分();
            source.listUpper_9 = entityList.get(0).get事業者番号();
            source.listUpper_10 = entityList.get(0).get整理番号();
            if (entityList.get(0).getレコード件数_H1().compareTo("1") == -1) {
                source.listUpper_11 = RString.EMPTY;
            } else {
                source.listUpper_11 = new RString("○");
            }
            if (entityList.get(0).getレコード件数_D1().compareTo("1") >= 1
                    && entityList.get(0).getレコード件数_DD().compareTo("1") >= 1) {
                source.listUpper_12 = new RString("◎");
            } else if (entityList.get(0).getレコード件数_D1().compareTo("1") >= 1
                    && entityList.get(0).getレコード件数_DD().compareTo("1") == 0) {
                source.listUpper_12 = new RString("○");
            } else if (entityList.get(0).getレコード件数_D1().compareTo("1") == 0
                    && entityList.get(0).getレコード件数_DD().compareTo("1") >= 1) {
                source.listUpper_12 = new RString("●");
            } else {
                source.listUpper_12 = RString.EMPTY;
            }
            if (entityList.get(0).getレコード件数_D2().compareTo("1") == -1) {
                source.listUpper_13 = RString.EMPTY;
            } else {
                source.listUpper_13 = new RString("○");
            }
            if (entityList.get(0).getレコード件数_D3().compareTo("1") == -1) {
                source.listUpper_14 = RString.EMPTY;
            } else {
                source.listUpper_14 = new RString("○");
            }
            if (entityList.get(0).getレコード件数_D4().compareTo("1") == -1) {
                source.listUpper_15 = RString.EMPTY;
            } else {
                source.listUpper_15 = new RString("○");
            }
            if (entityList.get(0).getレコード件数_D5().compareTo("1") == -1) {
                source.listUpper_16 = RString.EMPTY;
            } else {
                source.listUpper_16 = new RString("○");
            }
            if (entityList.get(0).getレコード件数_D6().compareTo("1") == -1) {
                source.listUpper_17 = RString.EMPTY;
            } else {
                source.listUpper_17 = new RString("○");
            }
            if (entityList.get(0).getレコード件数_D7().compareTo("1") == -1) {
                source.listUpper_18 = RString.EMPTY;
            } else {
                source.listUpper_18 = new RString("○");
            }
            if (entityList.get(0).getレコード件数_D8().compareTo("1") >= 1) {
                source.listUpper_19 = new RString("○");
            } else if (entityList.get(0).getレコード件数_DE().compareTo("1") >= 1) {
                source.listUpper_19 = new RString("○");
            } else if (entityList.get(0).getレコード件数_D8().compareTo("1") == 0
                    && entityList.get(0).getレコード件数_DE().compareTo("1") == 0) {
                source.listUpper_19 = RString.EMPTY;
            }

            editorAdd(source);
//            source.gokeiKensuTitle = new RString("合計件数");
//            source.gokeiKensu = DecimalFormatter.toコンマ区切りRString(null, 0);
            entityList.add(entityList.get(0));
        }
        return source;
    }

    private KyufujissekiKoshinkekkaIchiranSource editorAdd(KyufujissekiKoshinkekkaIchiranSource source) {
        if (entityList.get(0).getレコード件数_T1().compareTo("1") == -1) {
            source.listUpper_20 = RString.EMPTY;
        } else {
            source.listUpper_20 = new RString("○");
        }
        if (entityList.get(0).getレコード件数_D9().compareTo("1") == -1) {
            source.listUpper_21 = RString.EMPTY;
        } else {
            source.listUpper_21 = new RString("○");
        }
        if (entityList.get(0).getレコード件数_DA().compareTo("1") == -1) {
            source.listUpper_22 = RString.EMPTY;
        } else {
            source.listUpper_22 = new RString("○");
        }
        if (entityList.get(0).getレコード件数_DC().compareTo("1") == -1) {
            source.listUpper_23 = RString.EMPTY;
        } else {
            source.listUpper_23 = new RString("○");
        }
        if (new RString("1").equals(entityList.get(0).get警告区分コード())) {
            source.listUpper_24 = RString.EMPTY;
        } else {
            source.listUpper_24 = entityList.get(0).get警告区分コード();
        }
        if (new RString(entityList.get(0).get入力識別名称().length()).compareTo("9") == 1) {
            source.listLower_1 = entityList.get(0).get入力識別名称_下段();
        } else {
            source.listLower_1 = RString.EMPTY;
        }
        source.listLower_2 = entityList.get(0).get宛名名称();
        if (!entityList.get(0).get事業者番号().isEmpty() && entityList.get(0).get事業者名称().isEmpty()) {
            source.listLower_3 = new RString("事業者名不明");
        } else {
            source.listLower_3 = entityList.get(0).get事業者名称();
        }
        return source;
    }

    private void set出力順And改ページ(KyufujissekiKoshinkekkaIchiranSource source) {
        source.shutsuryokujun1 = 並び順の１件目;
        source.shutsuryokujun2 = 並び順の２件目;
        source.shutsuryokujun3 = 並び順の３件目;
        source.shutsuryokujun4 = 並び順の４件目;
        source.shutsuryokujun5 = 並び順の５件目;
        if (null != 改頁項目List && !改頁項目List.isEmpty()) {
            if (改頁項目List.size() > NUM_0) {
                source.kaipage1 = 改頁項目List.get(NUM_0);
            }
            if (改頁項目List.size() > NUM_1) {
                source.kaipage2 = 改頁項目List.get(NUM_1);
            }
            if (改頁項目List.size() > NUM_2) {
                source.kaipage3 = 改頁項目List.get(NUM_2);
            }
            if (改頁項目List.size() > NUM_3) {
                source.kaipage4 = 改頁項目List.get(NUM_3);
            }
            if (改頁項目List.size() > NUM_4) {
                source.kaipage5 = 改頁項目List.get(NUM_4);
            }
        }
    }
}
