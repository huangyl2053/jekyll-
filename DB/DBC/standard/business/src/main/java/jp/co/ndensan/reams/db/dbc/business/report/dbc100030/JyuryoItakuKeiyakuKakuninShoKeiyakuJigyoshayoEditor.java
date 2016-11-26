/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc100030;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100030.JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc100030.JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBCMN32002_介護保険受領委任契約承認（不承認）確認書（事業者用） BodyEditor
 *
 * @reamsid_L DBC-1910-040 jiangxiaolong
 */
public class JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEditor
        implements IJyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEditor {

    private final JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity entity;

    /**
     * コンストラクタです
     *
     * @param entity KogakugassanShikyuKetteitsuchisho
     */
    public JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEditor(
            JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity entity) {
        this.entity = entity;
    }

    @Override
    public JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource edit(
            JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource source) {
        editSource(source);
        setPageBreakEmpty(source);
        return source;
    }

    private void editSource(JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource source) {
        source.yubinNo = entity.get郵便番号();
        source.gyoseiku1 = entity.get行政区();
        source.jushoText = entity.get住所Text();
        source.jusho4 = entity.get住所1();
        source.jusho5 = entity.get住所2();
        source.jusho6 = entity.get住所3();
        source.katagakiText = entity.get方書Text();
        source.katagaki3 = entity.get方書1();
        source.katagaki4 = entity.get方書2();
        source.katagakiSmall1 = entity.get方書Small1();
        source.katagakiSmall2 = entity.get方書Small2();
        source.dainoKubunMei = entity.get代納人区分();
        source.shimeiText = entity.get氏名Text();
        source.shimei5 = entity.get氏名1();
        source.shimei6 = entity.get氏名2();
        source.shimeiSmall1 = entity.get氏名Small1();
        source.shimeiSmall2 = entity.get氏名Small2();
        source.samabunShimeiText = entity.get氏名samabunText();
        source.samabunShimei1 = entity.get氏名samabun1();
        source.samabunShimei2 = entity.get氏名samabun2();
        source.samabunShimeiSmall1 = entity.get氏名samabunSmall1();
        source.samabunShimeiSmall2 = entity.get氏名samabunSmall2();
        source.meishoFuyo1 = entity.get名称付与1();
        source.meishoFuyo2 = entity.get名称付与2();
        source.samaBun1 = entity.get様文1();
        source.samaBun2 = entity.get様文2();
        source.kakkoLeft1 = entity.get括弧Left1();
        source.kakkoLeft2 = entity.get括弧Left2();
        source.kakkoRight1 = entity.get括弧Right1();
        source.kakkoRight2 = entity.get括弧Right2();
        source.customerBarCode = entity.getカスタマバーコード();
        source.bunshoNo = entity.get文書番号();
        source.denshiKoin = entity.get電子公印();
        source.hakkoYMD = entity.get発行日();
        source.ninshoshaYakushokuMei = entity.get認証者役職名();
        source.ninshoshaYakushokuMei1 = entity.get認証者役職名1();
        source.ninshoshaYakushokuMei2 = entity.get認証者役職名2();
        source.ninshoshaShimeiKakenai = entity.get認証者氏名掛けない();
        source.ninshoshaShimeiKakeru = entity.get認証者氏名掛ける();
        source.koinShoryaku = entity.get公印省略();
        source.koinMojiretsu = entity.get公印文字列();
        source.title = entity.getタイトル();
        source.tsuchibun1 = entity.get通知文1();
        source.hihokenshaName = entity.get被保険者氏名();
        source.hihokenshaNo = entity.get被保険者番号();
        source.uketsukeYMD = entity.get受付日();
        source.shoninKbn = entity.get承認区分();
        source.shoninYMD = entity.get承認年月日();
        source.fushoninRiyu = entity.get不承認理由();
        source.kyufuShurui = entity.get給付の種類();
        source.jigyoshaName = entity.get事業所名();
        source.daihyoshaName = entity.get代表者氏名();
        source.jigyoshaYubinNo = entity.get事業所郵便番号();
        source.jigyoshoJusho = entity.get事業所所在地();
        source.jigyoshoTelNo = entity.get事業所電話番号();
        source.hiyogakuGokei = entity.get費用額合計();
        source.hokenHiyogaku = entity.get保険対象費用額();
        source.riyoFutangaku = entity.get利用者負担額();
        source.hokenKyufuhigaku = entity.get保険給付額();
        source.tsuchibun2 = entity.get通知文2();
        source.pagecnt = entity.getページ();

    }

    private void setPageBreakEmpty(JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoSource source) {
        if (source.kyufuShurui == null) {
            source.kyufuShurui = RString.EMPTY;
        }
        if (source.shoninYMD == null) {
            source.shoninYMD = RString.EMPTY;
        }
        if (source.hihokenshaNo == null) {
            source.hihokenshaNo = RString.EMPTY;
        }
    }

}
