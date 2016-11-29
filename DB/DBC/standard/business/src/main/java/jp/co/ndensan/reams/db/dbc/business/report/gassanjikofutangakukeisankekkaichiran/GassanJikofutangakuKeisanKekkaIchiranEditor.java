/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjikofutangakukeisankekkaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBCMN62006_高額合算自己負担額計算結果一覧表Editorクラスです。
 *
 * @reamsid_L DBC-2060-040 surun
 */
public class GassanJikofutangakuKeisanKekkaIchiranEditor implements IGassanJikofutangakuKeisanKekkaIchiranEditor {

    private final GassanJikofutangakuKeisanKekkaIchiranEntity 高額合算自己負担額計算結果一覧表;
    private final LasdecCode 市町村コード;
    private final RString 市町村名称;
    private final YMDHMS 作成日時;
    private final RString 出力順1;
    private final RString 出力順2;
    private final RString 出力順3;
    private final RString 出力順4;
    private final RString 出力順5;
    private final RString 改頁1;
    private final RString 改頁2;
    private final RString 改頁3;
    private final RString 改頁4;
    private final RString 改頁5;
    private static final RString 住民種別コード_TWO = new RString("2");
    private static final RString 住民種別コード_FOUR = new RString("4");
    private static final RString LINE = new RString("～");
    private static final RString 定数 = new RString("度");

    /**
     * コンストラクタです
     *
     * @param 高額合算自己負担額計算結果一覧表 GassanJikofutangakuKeisanKekkaIchiranEntity
     * @param 市町村コード LasdecCode
     * @param 市町村名称 RString
     * @param 作成日時 YMDHMS
     * @param 出力順1 RString
     * @param 出力順2 RString
     * @param 出力順3 RString
     * @param 出力順4 RString
     * @param 出力順5 RString
     * @param 改頁1 RString
     * @param 改頁2 RString
     * @param 改頁3 RString
     * @param 改頁4 RString
     * @param 改頁5 RString
     */
    public GassanJikofutangakuKeisanKekkaIchiranEditor(GassanJikofutangakuKeisanKekkaIchiranEntity 高額合算自己負担額計算結果一覧表,
            LasdecCode 市町村コード, RString 市町村名称, YMDHMS 作成日時, RString 出力順1, RString 出力順2, RString 出力順3,
            RString 出力順4, RString 出力順5, RString 改頁1, RString 改頁2, RString 改頁3, RString 改頁4, RString 改頁5) {
        this.高額合算自己負担額計算結果一覧表 = 高額合算自己負担額計算結果一覧表;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.作成日時 = 作成日時;
        this.出力順1 = 出力順1;
        this.出力順2 = 出力順2;
        this.出力順3 = 出力順3;
        this.出力順4 = 出力順4;
        this.出力順5 = 出力順5;
        this.改頁1 = 改頁1;
        this.改頁2 = 改頁2;
        this.改頁3 = 改頁3;
        this.改頁4 = 改頁4;
        this.改頁5 = 改頁5;
    }

    @Override
    public GassanJikofutangakuKeisanKekkaIchiranSource edit(GassanJikofutangakuKeisanKekkaIchiranSource source) {
        if (市町村コード != null) {
            source.shichosonCd = 市町村コード.getColumnValue();
        }
        if (高額合算自己負担額計算結果一覧表 != null && 高額合算自己負担額計算結果一覧表.get識別コード() != null) {
            source.shikibetuCode = 高額合算自己負担額計算結果一覧表.get識別コード();
        } else {
            source.shikibetuCode = RString.EMPTY;
        }
        source.shichosonName = 市町村名称;
        source.shutsuryokujun1 = 出力順1;
        source.shutsuryokujun2 = 出力順2;
        source.shutsuryokujun3 = 出力順3;
        source.shutsuryokujun4 = 出力順4;
        source.shutsuryokujun5 = 出力順5;
        source.kaipage1 = 改頁1;
        source.kaipage2 = 改頁2;
        source.kaipage3 = 改頁3;
        source.kaipage4 = 改頁4;
        source.kaipage5 = 改頁5;
        if (作成日時 != null && !作成日時.isEmpty()) {
            RString 調定日 = 作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 調定時 = 作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            source.printTimeStamp = 調定日.concat(RString.HALF_SPACE).concat(調定時).concat(RString.HALF_SPACE);
        }
        if (高額合算自己負担額計算結果一覧表 != null) {
            if (高額合算自己負担額計算結果一覧表.get被保険者番号() != null) {
                source.list_1 = get非空文字列(高額合算自己負担額計算結果一覧表.get被保険者番号().getColumnValue());
            }
            source.list_2 = get非空文字列(高額合算自己負担額計算結果一覧表.get被保険者氏名());
            if (高額合算自己負担額計算結果一覧表.get生年月日() != null && (住民種別コード_TWO.
                    equals(高額合算自己負担額計算結果一覧表.get住民種別コード()) || 住民種別コード_FOUR.
                    equals(高額合算自己負担額計算結果一覧表.get住民種別コード()))) {
                source.list_3 = 高額合算自己負担額計算結果一覧表.get生年月日().seireki().toDateString();
            } else if (高額合算自己負担額計算結果一覧表.get生年月日() != null && !住民種別コード_TWO.
                    equals(高額合算自己負担額計算結果一覧表.get住民種別コード()) && !住民種別コード_FOUR.
                    equals(高額合算自己負担額計算結果一覧表.get住民種別コード())) {
                source.list_3 = 高額合算自己負担額計算結果一覧表.get生年月日().wareki().toDateString();
            }
            editTwo(source);
            editThree(source);
            editFour(source);
        }
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), get非空文字列(source.list_1));
        return source;
    }

    private void editTwo(GassanJikofutangakuKeisanKekkaIchiranSource source) {
        if (Seibetsu.男.getコード().equals(高額合算自己負担額計算結果一覧表.get性別())) {
            source.list_4 = Seibetsu.男.get名称();
        } else if (Seibetsu.女.getコード().equals(高額合算自己負担額計算結果一覧表.get性別())) {
            source.list_4 = Seibetsu.女.get名称();
        }
        source.list_5 = get非空文字列(高額合算自己負担額計算結果一覧表.get申請書整理番号());
        if (高額合算自己負担額計算結果一覧表.get申請年月日() != null) {
            source.list_6 = 高額合算自己負担額計算結果一覧表.get申請年月日().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        source.list_6 = source.list_6 == null ? RString.EMPTY : source.list_6;
        if (高額合算自己負担額計算結果一覧表.get申請対象年度() != null) {
            source.list_7 = 高額合算自己負担額計算結果一覧表.get申請対象年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(定数);
        }
        source.list_7 = source.list_7 == null ? RString.EMPTY : source.list_7;
        if (高額合算自己負担額計算結果一覧表.get介護加入期間開始() != null
                && 高額合算自己負担額計算結果一覧表.get介護加入期間終了() != null) {
            RString 介護加入期間開始 = 高額合算自己負担額計算結果一覧表.get介護加入期間開始().wareki().
                    eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            RString 介護加入期間終了 = 高額合算自己負担額計算結果一覧表.get介護加入期間終了().wareki().
                    eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            source.list_8 = 介護加入期間開始.concat(LINE).concat(介護加入期間終了);
        }
    }

    private void editThree(GassanJikofutangakuKeisanKekkaIchiranSource source) {
        if (高額合算自己負担額計算結果一覧表.get自己負担額() != null) {
            source.list_9 = DecimalFormatter.toコンマ区切りRString(高額合算自己負担額計算結果一覧表.get自己負担額(), 0);
        }
        if (高額合算自己負担額計算結果一覧表.get高額支給額() != null) {
            source.list_10 = DecimalFormatter.toコンマ区切りRString(高額合算自己負担額計算結果一覧表.get高額支給額(), 0);
        }
        if (高額合算自己負担額計算結果一覧表.getOneTwo() != null) {
            source.list_11 = DecimalFormatter.toコンマ区切りRString(高額合算自己負担額計算結果一覧表.getOneTwo(), 0);
        }
        if (高額合算自己負担額計算結果一覧表.get自己負担額内数() != null) {
            source.list_12 = DecimalFormatter.toコンマ区切りRString(高額合算自己負担額計算結果一覧表.get自己負担額内数(), 0);
        }
        source.list_13 = 高額合算自己負担額計算結果一覧表.get備考資格期間不正();
        source.list_15 = 高額合算自己負担額計算結果一覧表.get備考高額支給額確認データ();
    }

    private void editFour(GassanJikofutangakuKeisanKekkaIchiranSource source) {
        source.yubinNo = get非空文字列(高額合算自己負担額計算結果一覧表.getYubinNo());
        source.choikiCode = get非空文字列(高額合算自己負担額計算結果一覧表.getChoikiCode());
        source.gyoseikuCode = get非空文字列(高額合算自己負担額計算結果一覧表.getGyoseikuCode());
        source.hokenshaNo = get非空文字列(高額合算自己負担額計算結果一覧表.getHokenshaNo());
        source.shichosonCode = get非空文字列(高額合算自己負担額計算結果一覧表.getShichosonCode());
    }

    private RString get非空文字列(RString 文字列) {
        if (RString.isNullOrEmpty(文字列)) {
            return RString.EMPTY;
        }
        return 文字列;
    }

}
