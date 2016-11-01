/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.euc.dbb213001;

import jp.co.ndensan.reams.db.dbb.entity.csv.TokuchoSofuJohoRenkeiCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.csv.TokuchoSofuJohoRenkeiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.csv.TokuchoSofuJohoRenkeiHeadEntity;
import jp.co.ndensan.reams.db.dbb.entity.csv.TokuchoSofuJohoRenkeiKanriEntity;
import jp.co.ndensan.reams.db.dbb.entity.csv.TokuchoSofuJohoRenkeiOrtherDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.csv.TokuchoSofuJohoRenkeiTolelaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosofujohorenkei.TokuchoSofuJohoRenkeiEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 連携用出力ファイルに特徴依頼情報DTAデータの編集クラスです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
public class TokuchoSofuJohoRenkeiCsvEntityEditor {

    private static final RString スペース = new RString(" ");
    private static final RString ONESTRING = new RString("1");
    private static final RString TWOSTRING = new RString("2");
    private static final RString THREESTRING = new RString("3");
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
     * 管理DTAレコードを取得します。
     *
     * @param 通番 int
     * @return DTAレコード
     */
    public TokuchoSofuJohoRenkeiKanriEntity edit管理(long 通番) {
        return new TokuchoSofuJohoRenkeiKanriEntity(entity.get構成市町村コード(),
                スペース, new RString(通番), editパターン34(RDate.getNowDate()), RString.EMPTY);
    }

    /**
     * ファイル管理DTAレコードを取得します。
     *
     * @param 格納件数 int
     * @return DTAレコード
     */
    public TokuchoSofuJohoRenkeiCsvEntity editファイル管理(int 格納件数) {
        return new TokuchoSofuJohoRenkeiCsvEntity(new RString(格納件数), RString.EMPTY);
    }

    /**
     * ヘッダDTAレコードを取得します。
     *
     * @return DTAレコード
     */
    public TokuchoSofuJohoRenkeiHeadEntity editヘッダ() {
        RString 特別徴収義務者コード = RString.EMPTY;
        if (entity.get特別徴収義務者コードDT() != null) {
            特別徴収義務者コード = entity.get特別徴収義務者コードDT().value();
        }
        return new TokuchoSofuJohoRenkeiHeadEntity(ONESTRING, entity.get構成市町村コード(),
                特別徴収義務者コード, entity.get通知内容コードDT(), entity.get媒体コードDT(), entity.get特別徴収制度コードDT(),
                editパターン34(entity.get作成年月日DT()), スペース);
    }

    /**
     * データDTAレコードを取得します。
     *
     * @return DTAレコード
     */
    public TokuchoSofuJohoRenkeiDataEntity editデータ() {
        return new TokuchoSofuJohoRenkeiDataEntity(
                TWOSTRING,
                entity.get構成市町村コード(),
                edit特別徴収義務者コード(entity.get特別徴収義務者コードDT()),
                entity.get通知内容コードDT(),
                スペース,
                entity.get特別徴収制度コードDT(),
                editパターン34(entity.get作成年月日DT()),
                entity.get基礎年金番号DT(),
                entity.get年金コードDT(),
                スペース,
                editパターン34(entity.get生年月日DT()),
                entity.get性別DT(),
                RStringUtil.convert全角to半角(entity.getカナ氏名DT()),
                entity.getシフトコード1DT(),
                RStringUtil.convert半角to全角(entity.get漢字氏名DT()),
                entity.getシフトコード2DT(),
                edit郵便番号(entity.get郵便番号DT()),
                RStringUtil.convert全角to半角(entity.getカナ住民DT()),
                entity.getシフトコード3DT(),
                RStringUtil.convert半角to全角(entity.get漢字住所DT()),
                entity.getシフトコード4DT(),
                entity.get各種区分DT(),
                処理結果,
                entity.get後期移管コードDT(),
                editパターン34(entity.get各種年月日DT()),
                entity.get各種金額欄1DT(),
                entity.get各種金額欄2DT(),
                entity.get各種金額欄3DT(),
                RString.EMPTY,
                entity.get共済年金証記号番号DT());
    }

    /**
     * データDTAレコードを取得します。
     *
     * @return DTAレコード
     */
    public TokuchoSofuJohoRenkeiOrtherDataEntity editデータZ99_550_xx_DTAファイルのみ() {
        return new TokuchoSofuJohoRenkeiOrtherDataEntity(
                TWOSTRING,
                entity.get構成市町村コード(),
                edit特別徴収義務者コード(entity.get特別徴収義務者コードDT()),
                entity.get通知内容コードDT(),
                スペース,
                entity.get特別徴収制度コードDT(),
                editパターン34(entity.get作成年月日DT()),
                entity.get基礎年金番号DT(),
                entity.get年金コードDT(),
                スペース,
                editパターン34(entity.get生年月日DT()),
                entity.get性別DT(),
                RStringUtil.convert全角to半角(entity.getカナ氏名DT()),
                entity.getシフトコード1DT(),
                RStringUtil.convert半角to全角(entity.get漢字氏名DT()),
                entity.getシフトコード2DT(),
                edit郵便番号(entity.get郵便番号DT()),
                RStringUtil.convert全角to半角(entity.getカナ住民DT()),
                entity.getシフトコード3DT(),
                RStringUtil.convert半角to全角(entity.get漢字住所DT()),
                entity.getシフトコード4DT(),
                entity.get各種区分DT(),
                処理結果,
                entity.get後期移管コードDT(),
                editパターン34(entity.get各種年月日DT()),
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
    public TokuchoSofuJohoRenkeiTolelaEntity editトレイラ(Decimal 各種金額欄合計1, Decimal 各種金額欄合計2, int 格納件数) {
        return new TokuchoSofuJohoRenkeiTolelaEntity(
                THREESTRING,
                entity.get構成市町村コード(),
                edit特別徴収義務者コード(entity.get特別徴収義務者コードDT()),
                entity.get通知内容コードDT(),
                RString.EMPTY,
                entity.get特別徴収制度コードDT(),
                editパターン34(entity.get作成年月日DT()),
                new RString(格納件数),
                new RString(各種金額欄合計1.toString()),
                new RString(各種金額欄合計2.toString()),
                合計金額金額,
                RString.EMPTY
        );
    }

    private RString editパターン34(RDate date) {
        if (date != null) {
            return date.seireki().separator(Separator.NONE)
                    .fillType(FillType.ZERO).toDateString();
        } else {
            return RString.EMPTY;
        }
    }

    private RString editパターン34(RString date) {
        if (date != null) {
            return new RDate(date.toString()).seireki().separator(Separator.NONE)
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
            return 郵便番号.value();
        }
        return RString.EMPTY;
    }
}
