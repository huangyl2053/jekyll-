/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.euc.dbb213001;

import jp.co.ndensan.reams.db.dbb.entity.csv.TokuchoSofuJohoRenkeiCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosofujohorenkei.TokuchoSofuJohoRenkeiEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 連携用出力ファイルに特徴依頼情報DTAデータの編集クラスです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
public class TokuchoSofuJohoRenkeiCsvEntityEditor {

    private static final RString 市町村コード = new RString("市町村コード");
    private static final RString スペース名 = new RString("スペース");
    private static final RString 媒体通番 = new RString("媒体通番");
    private static final RString 作成年月日 = new RString("作成年月日");
    private static final RString 予備 = new RString("予備");
    private static final RString ファイル格納件数 = new RString("ファイル格納件数");
    private static final RString レコード区分 = new RString("レコード区分");
    private static final RString 特別徴収義務者コード = new RString("特別徴収義務者コード");
    private static final RString 通知内容コード = new RString("通知内容コード");
    private static final RString 媒体コード = new RString("媒体コード");
    private static final RString 特別徴収制度コード = new RString("特別徴収制度コード");
    private static final RString 基礎年金番号 = new RString("基礎年金番号");
    private static final RString 年金コード = new RString("年金コード");
    private static final RString 生年月日 = new RString("生年月日");
    private static final RString 性別 = new RString("性別");
    private static final RString 氏名カナ = new RString("氏名 カナ");
    private static final RString 氏名シフトコード = new RString("氏名 シフトコード");
    private static final RString 氏名漢字 = new RString("氏名 漢字");
    private static final RString 住所郵便番号 = new RString("住所 郵便番号");
    private static final RString 住所カナ = new RString("住所 カナ");
    private static final RString 住所シフトコード = new RString("住所 シフトコード");
    private static final RString 住所漢字 = new RString("住所 漢字");
    private static final RString 各種区分 = new RString("各種区分");
    private static final RString 処理結果名 = new RString("処理結果");
    private static final RString 後期移管コード = new RString("後期移管コード");
    private static final RString 各種年月日 = new RString("各種年月日");
    private static final RString 各種金額欄金額1 = new RString("各種金額欄 金額1");
    private static final RString 各種金額欄金額2 = new RString("各種金額欄 金額2");
    private static final RString 各種金額欄金額3 = new RString("各種金額欄 金額3");
    private static final RString 共済年金証書記号番号 = new RString("共済年金証書記号番号");
    private static final RString レコード件数 = new RString("レコード件数");
    private static final RString 合計金額金額1 = new RString("合計金額 金額1");
    private static final RString 合計金額金額2 = new RString("合計金額 金額2");
    private static final RString 合計金額金額3 = new RString("合計金額 金額3");
    private static final RString スペース = new RString(" ");
    private static final RString ONESTRING = new RString("1");
    private static final RString TWOSTRING = new RString("2");
    private static final RString THREESTRING = new RString("３");
    private static final RString 各種区分01 = new RString("01");
    private static final RString 特別徴収対象者 = new RString("特別徴収対象者");
    private static final RString 各種区分02 = new RString("02");
    private static final RString 特別徴収対象者住所地特例該当 = new RString("特別徴収対象者（住所地特例該当）");
    private static final RString 各種区分03 = new RString("03");
    private static final RString 特別徴収非対象者 = new RString("特別徴収非対象者");
    private static final RString 処理結果 = new RString("00");
    private static final RString 合計金額金額 = new RString("00000000000");
    private final TokuchoSofuJohoRenkeiEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity データ
     */
    public TokuchoSofuJohoRenkeiCsvEntityEditor(TokuchoSofuJohoRenkeiEntity entity) {
        this.entity = entity;
    }

    /**
     * DTAファイルの管理headを取得します。
     *
     * @return DTAレコード
     */
    public static TokuchoSofuJohoRenkeiCsvEntity edit管理Header() {
        return new TokuchoSofuJohoRenkeiCsvEntity(
                市町村コード, スペース名, 媒体通番, 作成年月日, 予備, ファイル格納件数, 予備
        );
    }

    /**
     * DTAファイルのヘッダheadを取得します。
     *
     * @return DTAレコード
     */
    public static TokuchoSofuJohoRenkeiCsvEntity editヘッダHeader() {
        return new TokuchoSofuJohoRenkeiCsvEntity(
                レコード区分, 市町村コード, 特別徴収義務者コード, 通知内容コード, 媒体コード, 特別徴収制度コード, 作成年月日, 予備
        );
    }

    /**
     * DTAファイルのデータheadを取得します。
     *
     * @return DTAレコード
     */
    public static TokuchoSofuJohoRenkeiCsvEntity editデータHeader() {
        return new TokuchoSofuJohoRenkeiCsvEntity(
                レコード区分, 市町村コード, 特別徴収義務者コード, 通知内容コード, 予備, 特別徴収制度コード, 作成年月日, 基礎年金番号, 年金コード,
                予備, 生年月日, 性別, 氏名カナ, 氏名シフトコード, 氏名漢字, 氏名シフトコード, 住所郵便番号, 住所カナ, 住所シフトコード, 住所漢字,
                住所シフトコード, 各種区分, 処理結果名, 後期移管コード, 各種年月日, 各種金額欄金額1, 各種金額欄金額2, 各種金額欄金額3,
                共済年金証書記号番号
        );
    }

    /**
     * DTAファイルのトレイラheadを取得します。
     *
     * @return DTAレコード
     */
    public static TokuchoSofuJohoRenkeiCsvEntity editトレイラHeader() {
        return new TokuchoSofuJohoRenkeiCsvEntity(
                レコード区分, 市町村コード, 特別徴収義務者コード, 通知内容コード, 予備, 特別徴収制度コード, 作成年月日, レコード件数, 合計金額金額1,
                合計金額金額2, 合計金額金額3, 予備
        );
    }

    /**
     * 管理DTAレコードを取得します。
     *
     * @param 通番 通番
     * @param 格納件数 格納件数
     * @return DTAレコード
     */
    // TODO
    public TokuchoSofuJohoRenkeiCsvEntity edit管理(int 通番, int 格納件数) {
        return new TokuchoSofuJohoRenkeiCsvEntity(entity.get市町村コードDT(),
                スペース, new RString(通番), editパターン3(RDate.getNowDate()), RString.EMPTY, new RString(格納件数), RString.EMPTY);
    }

    /**
     * ヘッダDTAレコードを取得します。
     *
     * @return DTAレコード
     */
    // TODO
    public TokuchoSofuJohoRenkeiCsvEntity editヘッダ() {
        return new TokuchoSofuJohoRenkeiCsvEntity(ONESTRING, entity.get市町村コードDT(),
                スペース, entity.get市町村コードDT(), entity.get媒体コードDT(), entity.get特別徴収制度コードDT(),
                editパターン3(RDate.getNowDate()), entity.get通知内容コードDT());
    }

    /**
     * データDTAレコードを取得します。
     *
     * @return DTAレコード
     */
    // TODO
    public TokuchoSofuJohoRenkeiCsvEntity editデータ() {
        return new TokuchoSofuJohoRenkeiCsvEntity(
                TWOSTRING,
                entity.get市町村コードDT(),
                edit特別徴収義務者コード(entity.get特別徴収義務者コードDT()),
                entity.get通知内容コードDT(),
                entity.get予備1DT(),
                entity.get特別徴収制度コードDT(),
                editパターン3(RDate.getNowDate()),
                entity.get基礎年金番号DT(),
                entity.get年金コードDT(),
                entity.get予備2DT(),
                editパターン3(entity.get生年月日DT()),
                entity.get性別DT(),
                entity.getカナ氏名DT(),
                entity.getシフトコード1DT(),
                entity.get漢字氏名DT(),
                entity.getシフトコード2DT(),
                edit郵便番号(entity.get郵便番号DT()),
                entity.getカナ住民DT(),
                entity.getシフトコード3DT(),
                entity.get漢字住所DT(),
                entity.getシフトコード4DT(),
                edit各種区分(entity.get各種区分DT()),
                処理結果,
                entity.get後期移管コードDT(),
                editパターン3(entity.get各種年月日DT()),
                entity.get各種金額欄1DT(),
                entity.get各種金額欄2DT(),
                entity.get各種金額欄3DT(),
                entity.get共済年金証記号番号DT());
    }

    /**
     * データDTAレコードを取得します。
     *
     * @return DTAレコード
     */
    // TODO
    public TokuchoSofuJohoRenkeiCsvEntity editデータZ99_550_xx_DTAファイルのみ() {
        return new TokuchoSofuJohoRenkeiCsvEntity(
                TWOSTRING,
                entity.get市町村コードDT(),
                edit特別徴収義務者コード(entity.get特別徴収義務者コードDT()),
                entity.get通知内容コードDT(),
                entity.get予備1DT(),
                entity.get特別徴収制度コードDT(),
                editパターン3(RDate.getNowDate()),
                entity.get基礎年金番号DT(),
                entity.get年金コードDT(),
                entity.get予備2DT(),
                editパターン3(entity.get生年月日DT()),
                entity.get性別DT(),
                entity.getカナ氏名DT(),
                entity.getシフトコード1DT(),
                entity.get漢字氏名DT(),
                entity.getシフトコード2DT(),
                edit郵便番号(entity.get郵便番号DT()),
                entity.getカナ住民DT(),
                entity.getシフトコード3DT(),
                entity.get漢字住所DT(),
                entity.getシフトコード4DT(),
                edit各種区分(entity.get各種区分DT()),
                処理結果,
                entity.get後期移管コードDT(),
                editパターン3(entity.get各種年月日DT()),
                entity.get各種金額欄1DT(),
                entity.get各種金額欄2DT(),
                entity.get各種金額欄3DT(),
                entity.get共済年金証記号番号DT(),
                entity.get介護保険被保険者番号(),
                entity.get個人コード区分(),
                entity.get個人コード(),
                entity.get介護保険住所地特例区分(),
                entity.get捕捉年月日(),
                entity.get待機フラグ(),
                entity.get予備()
        );
    }

    /**
     * トレイラDTAレコードを取得します。
     *
     * @param 各種金額欄合計1 各種金額欄合計1
     * @param 各種金額欄合計2 各種金額欄合計2
     * @param 格納件数 格納件数
     * @return DTAレコード
     */
    // TODO
    public TokuchoSofuJohoRenkeiCsvEntity editトレイラ(int 各種金額欄合計1, int 各種金額欄合計2, int 格納件数) {
        return new TokuchoSofuJohoRenkeiCsvEntity(
                THREESTRING,
                entity.get市町村コードDT(),
                edit特別徴収義務者コード(entity.get特別徴収義務者コードDT()),
                entity.get通知内容コードDT(),
                RString.EMPTY,
                entity.get特別徴収制度コードDT(),
                editパターン3(RDate.getNowDate()),
                new RString(格納件数),
                new RString(各種金額欄合計1),
                new RString(各種金額欄合計2),
                合計金額金額,
                RString.EMPTY
        );
    }

    private RString editパターン3(RDate date) {
        if (date != null) {
            return date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.ZERO).toDateString();
        } else {
            return RString.EMPTY;
        }
    }

    private RString editパターン3(RString date) {
        if (date != null) {
            return new RDate(date.toString()).wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.ZERO).toDateString();
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit特別徴収義務者コード(Code code) {
        if (code != null) {
            return code.value();
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit郵便番号(RString string) {
        if (!RString.isNullOrEmpty(string)) {
            YubinNo 郵便番号 = new YubinNo(string);
            return 郵便番号.getEditedYubinNo();
        }
        return RString.EMPTY;
    }

    private RString edit各種区分(RString string) {
        if (各種区分01.equals(string)) {
            return 特別徴収対象者;
        } else if (各種区分02.equals(string)) {
            return 特別徴収対象者住所地特例該当;
        } else if (各種区分03.equals(string)) {
            return 特別徴収非対象者;
        } else {
            return RString.EMPTY;
        }
    }
}
