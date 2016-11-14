/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jyuryoitakukeiyakukakuninsho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufujuryoininkeiyakutoroku.KaigoKyufuJuryoininKeiyakuTorokuRiyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jyuryoitakukeiyakukakuninsho.JyuryoItakuKeiyakuKakuninShoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 帳票設計_DBCMN31003_介護保険受領委任契約承認（不承認）確認書（利用者向け）Editor
 *
 * @reamsid_L DBC-2130-070 liuxiaoyu
 */
public class JyuryoItakuKeiyakuKakuninShoEditor
        implements IJyuryoItakuKeiyakuKakuninShoEditor {

    private static final RString 被保険者番号 = new RString("被保険者番号");
    private final KaigoKyufuJuryoininKeiyakuTorokuRiyoshaEntity entity;
    private final NinshoshaSource 認証者情報;

    /**
     * コンストラクタです
     *
     * @param entity KogakugassanShikyuKetteitsuchisho
     * @param 認証者情報 NinshoshaSource
     */
    public JyuryoItakuKeiyakuKakuninShoEditor(
            KaigoKyufuJuryoininKeiyakuTorokuRiyoshaEntity entity,
            NinshoshaSource 認証者情報) {
        this.entity = entity;
        this.認証者情報 = 認証者情報;
    }

    @Override
    public JyuryoItakuKeiyakuKakuninShoSource edit(
            JyuryoItakuKeiyakuKakuninShoSource source) {
        editSource(source);
        return source;
    }

    private void editSource(JyuryoItakuKeiyakuKakuninShoSource source) {
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
        source.denshiKoin = 認証者情報.denshiKoin;
        source.hakkoYMD = 認証者情報.hakkoYMD;
        source.ninshoshaYakushokuMei = 認証者情報.ninshoshaYakushokuMei;
        source.ninshoshaYakushokuMei1 = 認証者情報.ninshoshaYakushokuMei1;
        source.ninshoshaYakushokuMei2 = 認証者情報.ninshoshaYakushokuMei2;
        source.ninshoshaShimeiKakenai = 認証者情報.ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = 認証者情報.ninshoshaShimeiKakeru;
        source.koinShoryaku = 認証者情報.koinShoryaku;
        source.koinMojiretsu = 認証者情報.koinMojiretsu;
        source.title = entity.getタイトル();
        source.tsuchibun1 = entity.get文書1();
        source.hihokenshaName = entity.get被保険者氏名();
        source.hihokenshaNo = entity.get被保険者番号().value();
        source.expandedInformation = new ExpandedInformation(new Code("0003"), 被保険者番号,
                source.hihokenshaNo);
        source.shikibetuCode = entity.get識別コード();
        source.uketsukeYMD = entity.get受付日();
        source.shoninKbn = entity.get承認区分();
        source.shoninYMD = entity.get承認年月日();
        source.fushoninRiyu = entity.get不承認理由();
        source.kyufuShurui = entity.get給付の種類();
        if (entity.get事業所名() != null && !entity.get事業所名().isEmpty()) {
            source.jigyoshaName = entity.get事業所名().value();
        }
        if (entity.get代表者氏名() != null && !entity.get代表者氏名().isEmpty()) {
            source.daihyoshaName = entity.get代表者氏名().value();
        }
        if (entity.get事業所郵便番号() != null && !entity.get事業所郵便番号().isEmpty()) {
            source.jigyoshaYubinNo = entity.get事業所郵便番号().value();
        }
        if (entity.get事業所所在地() != null && !entity.get事業所所在地().isEmpty()) {
            source.jigyoshoJusho = entity.get事業所所在地().value();
        }
        if (entity.get事業所電話番号() != null && !entity.get事業所電話番号().isEmpty()) {
            source.jigyoshoTelNo = entity.get事業所電話番号().value();
        }
        source.hiyogakuGokei = entity.get費用額合計();
        source.hokenHiyogaku = entity.get保険対象費用額();
        source.riyoFutangaku = entity.get利用者負担額();
        source.hokenKyufuhigaku = entity.get保険給付額();
        source.tsuchibun2 = entity.get文書2();
        source.pagecnt = entity.getページ();
    }
}
