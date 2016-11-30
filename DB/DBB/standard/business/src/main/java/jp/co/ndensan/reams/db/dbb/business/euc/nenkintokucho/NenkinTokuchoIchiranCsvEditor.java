/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.euc.nenkintokucho;

import jp.co.ndensan.reams.db.dbb.entity.csv.NenkinTokuchoIchiranCsvEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.KakushuKubun;
import jp.co.ndensan.reams.ue.uex.definition.core.NenkinCode;
import jp.co.ndensan.reams.ue.uex.definition.core.ShoriKekka;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCode;
import jp.co.ndensan.reams.ue.uex.entity.db.relate.uext00010.TorikomiFileKaifuJohoTempEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;

/**
 * バッチ設計_DBB241001_特徴配信データ取り込みの一覧表CSVデータの編集クラスです。
 *
 * @reamsid_L DBB-4270-020 chenyadong
 */
public class NenkinTokuchoIchiranCsvEditor {

    private static final RString HYPEN = new RString("-");
    private static final int INT_0 = 0;
    private static final int INT_3 = 3;
    private static final RString 男 = new RString("1");
    private static final RString 女 = new RString("2");

    /**
     * CSVレコードを取得します。
     *
     * @param tempEntity TorikomiFileKaifuJohoTempEntity
     * @return NenkinTokuchoIchiranCsvEntity
     */
    public NenkinTokuchoIchiranCsvEntity getCsvEntity(TorikomiFileKaifuJohoTempEntity tempEntity) {
        NenkinTokuchoIchiranCsvEntity entity = new NenkinTokuchoIchiranCsvEntity();
        entity.set市町村コード(tempEntity.getShichosoCode());
        entity.set義務者コード(tempEntity.getTokuchoGimuCode());
        entity.set義務者名称(new TokubetsuChoshuGimushaCode(tempEntity.getTokuchoGimuCode()).getMeisho());
        entity.set通知内容コード(tempEntity.getTsuchiNaiyoCode());
        entity.set通知内容(new TsuchiNaiyoCode(tempEntity.getTsuchiNaiyoCode()).value().get通知内容名称());
        entity.set作成年月日(getDate32(tempEntity.getSakuseiYMD()));
        entity.set基礎年金番号(tempEntity.getKisoNenkinNo());
        entity.set年金コード(tempEntity.getNenkinCode());
        entity.set年金名称(get年金名称(tempEntity.getNenkinCode()));
        entity.set生年月日(getDate32(tempEntity.getSeiNengappi()));
        if (tempEntity.getSeibetsu() != null && !tempEntity.getSeibetsu().equals(男)
                && !tempEntity.getSeibetsu().equals(女)) {
            tempEntity.setSeibetsu(null);
        }
        entity.set性別(Gender.toValue(tempEntity.getSeibetsu()).getCommonName());
        entity.setカナ氏名(tempEntity.getShimeiKana());
        entity.set漢字氏名(tempEntity.getShimeiKanji());
        entity.set郵便番号(get郵便番号(tempEntity.getJushoYubinNo()));
        entity.setカナ住所(tempEntity.getJushoKana());
        entity.set漢字住所(tempEntity.getJushoKanji());
        entity.set各種区分(tempEntity.getKakushuKubun());
        entity.set各種区分名称(get各種区分名称(tempEntity.getTsuchiNaiyoCode(), tempEntity.getKakushuKubun()));
        entity.set処理結果コード(tempEntity.getShoriKeikka());
        entity.set処理結果内容(get処理結果内容(tempEntity.getTsuchiNaiyoCode(), tempEntity.getShoriKeikka()));
        entity.set各種年月日(getDate32(tempEntity.getKakushuYMD()));
        entity.set金額1(new RString(tempEntity.getKakushuKingaku1().toString()));
        entity.set金額2(new RString(tempEntity.getKakushuKingaku2().toString()));
        entity.set金額3(new RString(tempEntity.getKakushuKingaku3().toString()));
        entity.set共済年金証書記号番号(tempEntity.getKyosaiNenkinShoshoKigoBango());
        return entity;
    }

    private RString getDate32(FlexibleDate fdate) {
        if ((fdate != null) && (!fdate.isEmpty())) {
            return fdate.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).width(Width.HALF).toDateString();
        }
        return RString.EMPTY;
    }

    private RString get年金名称(RString 年金コード) {
        if (!RString.isNullOrEmpty(年金コード) && 年金コード.length() >= INT_3) {
            return new NenkinCode(年金コード.substringEmptyOnError(INT_0, INT_3)).getMeisho();
        }
        return RString.EMPTY;
    }

    private RString get郵便番号(RString 郵便番号) {
        if (!RString.isNullOrEmpty(郵便番号)) {
            return 郵便番号.substring(INT_0, INT_3).concat(HYPEN).concat(郵便番号.substring(INT_3));
        }
        return RString.EMPTY;
    }

    private RString get各種区分名称(RString 通知内容コード, RString 各種区分) {
        return KakushuKubun.toValue(通知内容コード, 各種区分).get各種区分名称();
    }

    private RString get処理結果内容(RString 通知内容コード, RString 処理結果コード) {
        return ShoriKekka.toValue(通知内容コード, 処理結果コード).get処理結果名称();
    }
}
