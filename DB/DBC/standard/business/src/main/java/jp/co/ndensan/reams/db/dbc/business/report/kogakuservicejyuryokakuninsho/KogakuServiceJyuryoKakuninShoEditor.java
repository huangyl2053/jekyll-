/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicejyuryokakuninsho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicejyuryokakuninsho.KogakuServiceJyuryoKakuninShoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicejyuryokakuninsho.KogakuServiceJyuryoKakuninShoSource;

/**
 *
 * 帳票設計_DBC100031_高額サービス費受領委任契約承認（不承認）確認書のEditorrクラスです。
 *
 * @reamsid_L DBC-1980-040 qinzhen
 */
public class KogakuServiceJyuryoKakuninShoEditor implements
        IKogakuServiceJyuryoKakuninShoEditor {

    private final KogakuServiceJyuryoKakuninShoEntity entity;

    /**
     * コンストラクタです
     *
     * @param entity KogakuServiceJyuryoKakuninShoEntity
     *
     */
    public KogakuServiceJyuryoKakuninShoEditor(KogakuServiceJyuryoKakuninShoEntity entity) {
        this.entity = entity;

    }

    @Override
    public KogakuServiceJyuryoKakuninShoSource edit(KogakuServiceJyuryoKakuninShoSource source) {
        source.bunshoNo = entity.get文書番号();
        source.shonin = entity.get承認不承認();
        source.fushoninRiyu = entity.get不承認理由();
        source.riyoFutanJyogengaku = entity.get利用者負担上限額();
        edit送付物宛先(source);
        edit認証者(source);
        edit確認書(source);
        return source;

    }

    private void edit送付物宛先(KogakuServiceJyuryoKakuninShoSource source) {
        source.yubinNo = entity.get郵便番号();
        source.gyoseiku = entity.get行政区();
        source.jushoText = entity.get住所Text();
        source.jusho1 = entity.get住所1();
        source.jusho2 = entity.get住所2();
        source.jusho3 = entity.get住所3();
        source.katagakiText = entity.get方書Text();
        source.katagaki1 = entity.get方書1();
        source.katagaki2 = entity.get方書2();
        source.katagakiSmall1 = entity.get方書Small1();
        source.katagakiSmall2 = entity.get方書Small2();
        source.dainoKubunMei = entity.get代納人区分();
        source.shimeiText = entity.get氏名Text();
        source.shimei1 = entity.get氏名1();
        source.shimei2 = entity.get氏名2();
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
    }

    private void edit認証者(KogakuServiceJyuryoKakuninShoSource source) {
        source.denshiKoin = entity.get電子公印();
        source.hakkoYMD = entity.get発行日();
        source.ninshoshaYakushokuMei = entity.get認証者役職名();
        source.ninshoshaYakushokuMei1 = entity.get認証者役職名1();
        source.ninshoshaYakushokuMei2 = entity.get認証者役職名2();
        source.ninshoshaShimeiKakenai = entity.get認証者氏名掛けない();
        source.ninshoshaShimeiKakeru = entity.get認証者氏名掛ける();
        source.koinShoryaku = entity.get公印省略();
        source.koinMojiretsu = entity.get公印文字列();
    }

    private void edit確認書(KogakuServiceJyuryoKakuninShoSource source) {
        source.tsuchiBun1 = entity.get通知文1();
        source.hihokenshaNameKana = entity.get被保険者氏名フリガナ();
        source.hihokenshaName = entity.get被保険者氏名();
        source.hihokenshaNo = entity.get被保険者番号();
        source.uketsukeYMD = entity.get受付年月日();
        source.shonin = entity.get承認不承認();
        source.shoninYMD = entity.get承認年月日();
        source.fushoninRiyu = entity.get不承認理由();
        source.jigyoshaName = entity.get事業所名();
        source.daihyoshaName = entity.get代表者名();
        source.jigyoshaYubinNo = entity.get事業所郵便番号();
        source.jigyoshaAddress = entity.get事業所所在地();
        source.jigyoshaTelNo = entity.get事業所電話番号();
        source.riyoFutanJyogengaku = entity.get利用者負担上限額();
        source.tsuchiBun2 = entity.get通知文2();
    }
}
