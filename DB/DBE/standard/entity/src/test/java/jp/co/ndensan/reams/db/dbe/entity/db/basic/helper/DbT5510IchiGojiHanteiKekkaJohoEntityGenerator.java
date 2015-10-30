/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5510IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 要介護認定1.5次判定結果情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5510IchiGojiHanteiKekkaJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1");
    public static final FlexibleDate DEFAULT_要介護認定1_5次判定年月日 = new FlexibleDate("20150402");
    public static final Code DEFAULT_要介護認定1_5次判定結果コード = new Code("1");
    public static final Code DEFAULT_要介護認定1_5次判定結果コード_認知症加算_ = new Code("1");
    public static final int DEFAULT_要介護認定等基準時間 = 1;
    public static final int DEFAULT_要介護認定等基準時間_食事_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_排泄_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_移動_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_清潔保持_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_間接ケア_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_BPSD関連_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_機能訓練_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_医療関連_ = 1;
    public static final int DEFAULT_要介護認定等基準時間_認知症加算_ = 1;
    public static final int DEFAULT_中間評価項目得点第1群 = 1;
    public static final int DEFAULT_中間評価項目得点第2群 = 1;
    public static final int DEFAULT_中間評価項目得点第3群 = 1;
    public static final int DEFAULT_中間評価項目得点第4群 = 1;
    public static final int DEFAULT_中間評価項目得点第5群 = 1;
    public static final Code DEFAULT_要介護認定1_5次判定警告コード = new Code("1");
    public static final Code DEFAULT_要介護認定状態の安定性コード = new Code("1");
    public static final Decimal DEFAULT_認知症自立度Ⅱ以上の蓋然性 = new Decimal("1");
    public static final Code DEFAULT_認知機能及び状態安定性から推定される給付区分コード = new Code("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5510IchiGojiHanteiKekkaJohoEntityGenerator() {
    }

    public static DbT5510IchiGojiHanteiKekkaJohoEntity createDbT5510IchiGojiHanteiKekkaJohoEntity() {
        DbT5510IchiGojiHanteiKekkaJohoEntity entity = new DbT5510IchiGojiHanteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setIchiGojiHanteiYMD(DEFAULT_要介護認定1_5次判定年月日);
        entity.setIchiGojiHanteiKekkaCode(DEFAULT_要介護認定1_5次判定結果コード);
        entity.setIchiGojiHanteiKekkaNinchishoKasanCode(DEFAULT_要介護認定1_5次判定結果コード_認知症加算_);
        entity.setKijunJikan(DEFAULT_要介護認定等基準時間);
        entity.setKijunJikanShokuji(DEFAULT_要介護認定等基準時間_食事_);
        entity.setKijunJikanHaisetsu(DEFAULT_要介護認定等基準時間_排泄_);
        entity.setKijunJikanIdo(DEFAULT_要介護認定等基準時間_移動_);
        entity.setKijunJikanSeiketsuHoji(DEFAULT_要介護認定等基準時間_清潔保持_);
        entity.setKijunJikanKansetsuCare(DEFAULT_要介護認定等基準時間_間接ケア_);
        entity.setKijunJikanBPSDKanren(DEFAULT_要介護認定等基準時間_BPSD関連_);
        entity.setKijunJikanKinoKunren(DEFAULT_要介護認定等基準時間_機能訓練_);
        entity.setKijunJikanIryoKanren(DEFAULT_要介護認定等基準時間_医療関連_);
        entity.setKijunJikanNinchishoKasan(DEFAULT_要介護認定等基準時間_認知症加算_);
        entity.setChukanHyokaKomoku1gun(DEFAULT_中間評価項目得点第1群);
        entity.setChukanHyokaKomoku2gun(DEFAULT_中間評価項目得点第2群);
        entity.setChukanHyokaKomoku3gun(DEFAULT_中間評価項目得点第3群);
        entity.setChukanHyokaKomoku4gun(DEFAULT_中間評価項目得点第4群);
        entity.setChukanHyokaKomoku5gun(DEFAULT_中間評価項目得点第5群);
        entity.setIchiGojiHnateiKeikokuCode(DEFAULT_要介護認定1_5次判定警告コード);
        entity.setJotaiAnteiseiCode(DEFAULT_要介護認定状態の安定性コード);
        entity.setNinchishoJiritsudoIIijoNoGaizensei(DEFAULT_認知症自立度Ⅱ以上の蓋然性);
        entity.setSuiteiKyufuKubunCode(DEFAULT_認知機能及び状態安定性から推定される給付区分コード);
        return entity;
    }
}
