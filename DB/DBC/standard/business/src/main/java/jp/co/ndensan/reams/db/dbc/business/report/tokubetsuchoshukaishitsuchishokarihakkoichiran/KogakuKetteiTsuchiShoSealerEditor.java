/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer.KogakuKetteiTsuchiShoSealerSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoEntity;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）Editorするクラスです。
 *
 * @reamsid_L DBC-2000-060 lijian
 */
public class KogakuKetteiTsuchiShoSealerEditor implements
        IKogakuKetteiTsuchiShoSealerEditor {

    private final KogakuKetteiTsuchiShoEntity 帳票情報;
    private final RString 文書番号;
    private final List<RString> 通知書定型文list;
    private final List<RString> インフォlist;
    private final NinshoshaSource 認証者ソースデータ;
    private final List<RString> titleList;
    private static final RString テスト印刷 = new RString("テスト印刷");
    private static final RString 審査依頼 = new RString("1");
    private static final RString 審査済み = new RString("2");
    private static final RString 口座種別 = new RString("口座種別");
    private static final RString 通帳記号 = new RString("通帳記号");
    private static final RString 通帳番号 = new RString("通帳番号");
    private static final RString 口座番号 = new RString("口座番号");
    private static final RString 窓口払い = new RString("窓口払い");
    private static final RString 口座払いでゆうちょ = new RString("口座払いでゆうちょ");
    private static final RString 支給 = new RString("1");
    private static final RString 不支給 = new RString("2");
    private static final RString 定量_円 = new RString("円");
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;
    private static final int INDEX_TWO = 2;
    private static final int INDEX_THREE = 3;
    private static final int INDEX_FOUR = 4;
    private static final int INDEX_FIVE = 5;
    private static final int INDEX_SIX = 6;
    private static final int INDEX_SEVEN = 7;
    private static final int INDEX_EIGHT = 8;
    private static final int INDEX_NINE = 9;
    private static final int INDEX_TEN = 10;
    private static final int INDEX_ELEVEN = 11;
    private static final int INDEX_TWELVE = 12;
    private static final int INDEX_THIRTEEN = 13;
    private static final int INDEX_FOURTEEN = 14;
    private static final int INDEX_FIFTEEN = 15;
    private static final int INDEX_SIXTEEN = 16;
    private static final int INDEX_SEVENTEEN = 17;
    private static final int INDEX_EIGHTEEN = 18;
    private static final int INDEX_NINETEEN = 19;
    private static final int INDEX_TWENTY = 20;
    private static final int INDEX_TWENTY_ONE = 21;
    private static final int INDEX_TWENTY_TWO = 22;
    private static final int INDEX_TWENTY_THREE = 23;

    /**
     * コンストラクタです。
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoEntity
     * @param 文書番号 RString
     * @param 通知書定型文list List<RString>
     * @param インフォlist List<RString>
     * @param 認証者ソースデータ NinshoshaSource
     * @param titleList List<RString>
     */
    public KogakuKetteiTsuchiShoSealerEditor(
            KogakuKetteiTsuchiShoEntity 帳票情報,
            RString 文書番号,
            List<RString> 通知書定型文list,
            List<RString> インフォlist,
            NinshoshaSource 認証者ソースデータ,
            List<RString> titleList) {

        this.帳票情報 = 帳票情報;
        this.文書番号 = 文書番号;
        this.通知書定型文list = 通知書定型文list;
        this.インフォlist = インフォlist;
        this.認証者ソースデータ = 認証者ソースデータ;
        this.titleList = titleList;
    }

    @Override
    public KogakuKetteiTsuchiShoSealerSource edit(KogakuKetteiTsuchiShoSealerSource source) {

        if (帳票情報.get識別コード() != null) {
            source.shikibetsuCode = 帳票情報.get識別コード().value();
        }

        source.tsuban = new RString(帳票情報.get通番());
        source.bunshoNo = 文書番号;
        setValueFrom帳票情報(source);
        set円(source);
        setインフォ(source);
        set通知文(source);
        setタイトル(source);
        set雛形部品CompNinshosha(source);

        return source;
    }

    private void setValueFrom帳票情報(KogakuKetteiTsuchiShoSealerSource source) {

        if (帳票情報.isテスト出力フラグ()) {
            source.testPrint = テスト印刷;
        } else {
            source.testPrint = RString.EMPTY;
        }
        source.hihokenshaName = 帳票情報.get被保険者氏名();
        source.hihokenshaName2 = 帳票情報.get被保険者氏名();

        if (帳票情報.get被保険者番号() != null) {
            source.hihokenshaNo = 帳票情報.get被保険者番号().value();
        }

        source.ketteiYMD = new RString(帳票情報.get決定年月日().toString());
        source.shiharaiGaku = new RString(帳票情報.get本人支払額().toString());
        source.shiharaiYoteiYMD = new RString(帳票情報.get支払予定日().toString());
        source.taishoYM1 = new RString(帳票情報.get提供年月IDX1().toString());

        source.taishoYM2 = new RString(帳票情報.get提供年月IDX2().toString());
        source.taishoYM3 = new RString(帳票情報.get提供年月IDX3().toString());
        source.taishoYM4 = new RString(帳票情報.get提供年月IDX4().toString());

        if (審査依頼.equals(帳票情報.get審査方法区分())) {
            source.shikyuGaku1 = new RString(帳票情報.get支給額IDX1().toString());
            source.shikyuGaku2 = new RString(帳票情報.get支給額IDX2().toString());
            source.shikyuGaku3 = new RString(帳票情報.get支給額IDX3().toString());
            source.shikyuGaku4 = new RString(帳票情報.get支給額IDX4().toString());
        } else if (審査済み.equals(帳票情報.get審査方法区分())) {
            source.shikyuGaku1 = new RString(帳票情報.get決定額IDX1().toString());
            source.shikyuGaku2 = new RString(帳票情報.get決定額IDX2().toString());
            source.shikyuGaku3 = new RString(帳票情報.get決定額IDX3().toString());
            source.shikyuGaku4 = new RString(帳票情報.get決定額IDX4().toString());
        }

        source.bankName = 帳票情報.get金融機関上段();
        source.branchBankName = 帳票情報.get金融機関下段();

        if (支給.equals(帳票情報.get支給不支給区分()) && 窓口払い.equals(帳票情報.get支払方法())) {
            source.shumokuTitle = 口座種別;
            source.bangoTitle = 口座番号;
        }
        if (支給.equals(帳票情報.get支給不支給区分()) && 口座払いでゆうちょ.equals(帳票情報.get支払方法())) {
            source.shumokuTitle = 通帳記号;
            source.bangoTitle = 通帳番号;
        }
        if (支給.equals(帳票情報.get支給不支給区分()) && !口座払いでゆうちょ.equals(帳票情報.get支払方法())) {
            source.shumokuTitle = 口座種別;
            source.bangoTitle = 口座番号;
        }
        if ((支給.equals(帳票情報.get支給不支給区分()) && 帳票情報.get支給額() != null && 帳票情報.get支給額().compareTo(Decimal.ZERO) < 0)
                || 不支給.equals(帳票情報.get支給不支給区分())) {
            source.shumokuTitle = 口座種別;
            source.bangoTitle = 口座番号;

        }

        if (帳票情報.isゆうちょ銀行フラグ()) {
            source.kouzaShu = 帳票情報.get口座種別();
            source.kouzaNo = 帳票情報.get口座番号();
        } else {
            source.kouzaShu = 帳票情報.get通帳記号();
            source.kouzaNo = 帳票情報.get通帳番号();
        }
        source.kouzaMeigi = 帳票情報.get口座名義人();

    }

    private void set円(KogakuKetteiTsuchiShoSealerSource source) {
        source.yen1 = 定量_円;
        source.yen2 = 定量_円;
        source.yen3 = 定量_円;
        source.yen4 = 定量_円;
    }

    private void setインフォ(KogakuKetteiTsuchiShoSealerSource source) {

        source.info1 = getインフォ(INDEX_ZERO);
        source.info2 = getインフォ(INDEX_ONE);
        source.info3 = getインフォ(INDEX_TWO);
        source.info4 = getインフォ(INDEX_THREE);
        source.info5 = getインフォ(INDEX_FOUR);
        source.info6 = getインフォ(INDEX_FIVE);
        source.info7 = getインフォ(INDEX_SIX);
        source.info8 = getインフォ(INDEX_SEVEN);
        source.info9 = getインフォ(INDEX_EIGHT);
        source.info10 = getインフォ(INDEX_NINE);

    }

    private void set通知文(KogakuKetteiTsuchiShoSealerSource source) {
        source.tsuchibun1 = get通知文(INDEX_ZERO);
        source.tsuchibun2 = get通知文(INDEX_ONE);
        source.tsuchibun3 = get通知文(INDEX_TWO);
        source.tsuchibun4 = get通知文(INDEX_THREE);
        source.tsuchibun5 = get通知文(INDEX_FOUR);
        source.tsuchibun6 = get通知文(INDEX_FIVE);
        source.tsuchibun7 = get通知文(INDEX_SIX);
        source.tsuchibun8 = get通知文(INDEX_SEVEN);
        source.tsuchibun9 = get通知文(INDEX_EIGHT);
        source.tsuchibun10 = get通知文(INDEX_NINE);
        source.tsuchibun11 = get通知文(INDEX_TEN);
        source.tsuchibun12 = get通知文(INDEX_ELEVEN);
        source.tsuchibun13 = get通知文(INDEX_TWELVE);
        source.tsuchibun14 = get通知文(INDEX_THIRTEEN);
        source.tsuchibun15 = get通知文(INDEX_FOURTEEN);
        source.tsuchibun16 = get通知文(INDEX_FIFTEEN);
        source.tsuchibun17 = get通知文(INDEX_SIXTEEN);
        source.tsuchibun18 = get通知文(INDEX_SEVENTEEN);
        source.tsuchibun19 = get通知文(INDEX_EIGHTEEN);
        source.tsuchibun20 = get通知文(INDEX_NINETEEN);
        source.tsuchibun21 = get通知文(INDEX_TWENTY);
        source.tsuchibun22 = get通知文(INDEX_TWENTY_ONE);
        source.tsuchibun23 = get通知文(INDEX_TWENTY_TWO);
        source.tsuchibun24 = get通知文(INDEX_TWENTY_THREE);

    }

    private RString getインフォ(int index) {
        return index < インフォlist.size() ? インフォlist.get(index) : RString.EMPTY;
    }

    private RString get通知文(int index) {
        return index < 通知書定型文list.size() ? 通知書定型文list.get(index) : RString.EMPTY;
    }

    private RString getタイトル(int index) {
        return index < titleList.size() ? titleList.get(index) : RString.EMPTY;
    }

    private void setタイトル(KogakuKetteiTsuchiShoSealerSource source) {
        source.title = getタイトル(0);
        source.title1 = getタイトル(1);
        source.title2 = getタイトル(2);
    }

    private void set雛形部品CompNinshosha(KogakuKetteiTsuchiShoSealerSource source) {
        if (認証者ソースデータ != null) {
            source.denshiKoin = 認証者ソースデータ.denshiKoin;
            source.hakkoYMD = 認証者ソースデータ.hakkoYMD;
            source.ninshoshaYakushokuMei = 認証者ソースデータ.ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = 認証者ソースデータ.ninshoshaYakushokuMei1;
            source.koinMojiretsu = 認証者ソースデータ.koinMojiretsu;
            source.ninshoshaYakushokuMei2 = 認証者ソースデータ.ninshoshaYakushokuMei2;
            source.ninshoshaShimeiKakenai = 認証者ソースデータ.ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = 認証者ソースデータ.ninshoshaShimeiKakeru;
            source.koinShoryaku = 認証者ソースデータ.koinShoryaku;
        }
    }

}
