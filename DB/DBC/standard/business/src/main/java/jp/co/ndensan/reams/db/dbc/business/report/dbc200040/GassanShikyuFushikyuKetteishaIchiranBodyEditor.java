/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200040;

import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteiTsuchiIchiran;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200040.GassanShikyuFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 高額合算支給決定者一覧表BodyEditor
 *
 * @reamsid_L DBC-2300-045 jiangxiaolong
 */
public class GassanShikyuFushikyuKetteishaIchiranBodyEditor
        implements IGassanShikyuFushikyuKetteishaIchiranEditor {

    private final KogakugassanShikyuKetteiTsuchiIchiran entity;
    private final boolean 集計Flag;
    private final GassanShikyuFushikyuKetteishaIchiranParameter paramter;
    private final RString 内部帳票文字切れ制御;

    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_2 = new RString("2");
    private static final RString スペース = new RString("　");
    private static final RString 後括弧 = new RString("）");
    private static final RString 前括弧 = new RString("（");
    private static final RString 接続符 = new RString("～");
    private static final RString 支給計 = new RString("支給計");
    private static final RString 不支給計 = new RString("不支給計");
    private static final RString 支給 = new RString("支給");
    private static final RString 不支給 = new RString("不支給");
    private static final RString 窓口払 = new RString("窓口払");
    private static final RString 口座払 = new RString("口座払");
    private static final RString 件 = new RString("件");
    private static final RString アステリスク_15 = new RString("***************");
    private static final RString 対象データは存在しません = new RString("**　対象データは存在しません　**");
    private static final int INT_34 = 34;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ KogakugassanShikyuKetteiTsuchiIchiran
     * @param 集計Flag boolean
     * @param paramter GassanShikyuFushikyuKetteishaIchiranParameter
     * @param 内部帳票文字切れ制御 RString
     */
    public GassanShikyuFushikyuKetteishaIchiranBodyEditor(
            KogakugassanShikyuKetteiTsuchiIchiran 帳票出力対象データ,
            boolean 集計Flag, GassanShikyuFushikyuKetteishaIchiranParameter paramter, RString 内部帳票文字切れ制御) {
        this.entity = 帳票出力対象データ;
        this.集計Flag = 集計Flag;
        this.paramter = paramter;
        this.内部帳票文字切れ制御 = 内部帳票文字切れ制御;
    }

    @Override
    public GassanShikyuFushikyuKetteishaIchiranSource edit(
            GassanShikyuFushikyuKetteishaIchiranSource source) {
        source.listCerter_2 = RString.EMPTY;
        if (null == entity) {
            if (!集計Flag) {
                editEmpty(source);
            }
            return source;
        } else {
            source.add_hokenshaNo = getColumnValue(entity.get証記載保険者番号());
            source.add_shichosonCode = getColumnValue(entity.get市町村コード());
            source.add_kanaMeisho = getColumnValue(entity.get氏名５０音カナ());
            source.add_choikiCode = getColumnValue(entity.get町域コード());
            source.add_gyoseikuCode = getColumnValue(entity.get行政区コード());
            source.add_yubinNo = getColumnValue(entity.get郵便番号());
        }
        if (集計Flag) {
            edit集計(source);
        } else {
            edit明細(source);
        }
        setPageBreakEmpty(source);
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), source.listCerter_2);
        return source;
    }

    private void setPageBreakEmpty(GassanShikyuFushikyuKetteishaIchiranSource source) {
        if (source.listCerter_2 == null) {
            source.listCerter_2 = RString.EMPTY;
        }
        if (source.listUpper_3 == null) {
            source.listUpper_3 = RString.EMPTY;
        }
        if (source.listLower_2 == null) {
            source.listLower_2 = RString.EMPTY;
        }
        if (source.listUpper_2 == null) {
            source.listUpper_2 = RString.EMPTY;
        }
        if (source.add_hokenshaNo == null) {
            source.add_hokenshaNo = RString.EMPTY;
        }
        if (source.add_shichosonCode == null) {
            source.add_shichosonCode = RString.EMPTY;
        }
        if (source.add_kanaMeisho == null) {
            source.add_kanaMeisho = RString.EMPTY;
        }
        if (source.add_choikiCode == null) {
            source.add_choikiCode = RString.EMPTY;
        }
        if (source.add_gyoseikuCode == null) {
            source.add_gyoseikuCode = RString.EMPTY;
        }
        if (source.add_yubinNo == null) {
            source.add_yubinNo = RString.EMPTY;
        }
    }

    private void edit明細(GassanShikyuFushikyuKetteishaIchiranSource source) {

        source.listCerter_1 = new RString(entity.get帳票通番());
        source.listCerter_2 = getColumnValue(entity.get被保険者番号());
        source.shikibetuCode = entity.get識別コード();
        if (区分_1.equals(entity.get支給区分コード())) {
            source.listCerter_3 = 支給;
        } else if (区分_2.equals(entity.get支給区分コード())) {
            source.listCerter_3 = 不支給;
        }
        if (区分_1.equals(entity.get支払方法区分())) {
            source.listCerter_4 = 窓口払;
        } else if (区分_2.equals(entity.get支払方法区分())) {
            source.listCerter_4 = 口座払;
        }
        if (区分_1.equals(内部帳票文字切れ制御)) {

            source.listLower_1 = get住所();

        } else {
            source.listLower_1 = アステリスク_15;
        }
        source.listLower_2 = entity.get対象年度().toDateString();
        source.listLower_3 = new RString(entity.get履歴番号());
        source.listLower_4 = new RString(entity.get決定年月日().toString());
        source.listLower_5 = doカンマ編集(entity.get支給額());
        if (区分_1.equals(entity.get支払方法区分())) {
            if (null != entity.get支払期間開始年月日() && null != entity.get支払期間開始時間()
                    && null != entity.get支払期間終了年月日() && null != entity.get支払期間終了時間()) {
                source.listLower_6 = toRS(entity.get支払期間開始年月日().toString()).concat(前括弧)
                        .concat(entity.get支払期間開始年月日().getDayOfWeek().getShortTerm()).concat(後括弧).concat(
                                entity.get支払期間開始時間().toString()).concat(接続符).concat(entity.get支払期間終了年月日().toString()).concat(前括弧)
                        .concat(entity.get支払期間終了年月日().getDayOfWeek().getShortTerm()).concat(後括弧)
                        .concat(entity.get支払期間終了時間().toString()
                        );
            }
            source.listUpper_5 = entity.get支払場所();
        } else if (区分_2.equals(entity.get支払方法区分())) {
            if (null != entity.get預金種別()) {
                source.listLower_6 = entity.get預金種別().get預金種別名称().concat(スペース).concat(entity.get口座番号()).
                        concat(getColumnValue(entity.get口座名義人カナ()));
            }
            if (entity.get金融機関名称() != null && entity.get支店名称() != null) {
                source.listUpper_5 = entity.get金融機関名称().concat(スペース).concat(entity.get支店名称());
            }
        }
        if (区分_1.equals(内部帳票文字切れ制御) && null != entity.get被保険者氏名()) {
            source.listUpper_1 = entity.get被保険者氏名().substringReturnAsPossible(0, INT_34);
        } else {
            source.listUpper_1 = アステリスク_15;
        }
        source.listUpper_2 = entity.get支給申請整理番号();
        if (null != entity.get申請年月日()) {
            source.listUpper_3 = toRS(entity.get申請年月日().toString());
        }
        source.listUpper_4 = doカンマ編集(entity.get自己負担総額());
    }

    private void edit集計(GassanShikyuFushikyuKetteishaIchiranSource source) {
        if (区分_1.equals(entity.get支給不支給区分())) {
            source.listUpper_2 = 支給計;
            source.listLower_5 = doカンマ編集(paramter.get支給額の合計金額());
        } else {
            source.listUpper_2 = 不支給計;
        }
        source.listUpper_3 = new RString(paramter.get支給の件数()).concat(件);
        source.listUpper_4 = doカンマ編集(paramter.get自己負担総額の合計金額());
    }

    private void editEmpty(GassanShikyuFushikyuKetteishaIchiranSource source) {
        source.listUpper_1 = 対象データは存在しません;
    }

    private RString get住所() {
        if (null != entity.get住所()) {
            return entity.get住所().substringReturnAsPossible(0, INT_34);

        }
        return RString.EMPTY;
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString toRS(String s) {
        return new RString(s);
    }

}
